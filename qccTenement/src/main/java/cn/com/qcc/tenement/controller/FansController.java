package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Zan;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.queryvo.ZanCustomer;
import cn.com.qcc.service.FansService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.MessagesService;
import cn.com.qcc.service.QiuzuService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;
import cn.com.qcc.service.ZanService;

@Controller
public class FansController {

	@Autowired
	FansService fansService;
	@Autowired
	ZanService zanService;
	@Autowired
	MessagesService messagesService;
	@Autowired
	UserService userService;
	@Autowired
	QiuzuService qiuzuService;
	@Autowired
	HouseService houseService;
	@Autowired
	BrokerMapper brokerMapper;
	@Autowired
	InteService inteService;
	@Autowired
	VillageService villageService;
	
	// 进入赞的详情页面
	@ResponseBody
	@RequestMapping("/zan/myzanlist")
	public ResultMap findzanfollow(Long userid ,@RequestParam(defaultValue="1") Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize) {
		Map<String,Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = zanService.findzanfollowCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<ZanCustomer> zanlist = zanService.findzanfollow(userid , pagequery);
		map.put("pagequery", pagequery);
		map.put("myzanList", zanlist);
		return ResultMap.IS_200(map);
	}

	// 查询我的关注
	@RequestMapping(value = "/fans/searchFollow")
	@ResponseBody
	public ResultMap searchFollow(Long userid ,@RequestParam(defaultValue="1") Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize)  {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = fansService.findFollowByUserIdCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<UserCustomer> followList = fansService.findFollowByUserId(userid , pagequery);
		map.put("pagequery", pagequery);
		map.put("followList", followList);
		return ResultMap.IS_200(map);
	}

	// 查询我的粉丝
	@RequestMapping(value = "/fans/searchFans")
	@ResponseBody
	public ResultMap searchFans(Long userid,@RequestParam(defaultValue="1") Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize) {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = fansService.findFansByUserIdCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<UserCustomer> fansList = fansService.findFansByUserId(userid ,pagequery);
		map.put("pagequery", pagequery);
		map.put("fansList", fansList);
		return ResultMap.IS_200(map);
	}

	// 进入别人的个人中心
	@RequestMapping(value = "/fans/searchByFan")
	@ResponseBody
	public ResultMap searchByFan(Long userid, Long followUserId ,@RequestParam(defaultValue="1")Integer currentpage ,
			@RequestParam(defaultValue="2")Integer pagesize) {
		PageQuery pagequery = new PageQuery();
		int infoCount = messagesService.selectCommentCount(followUserId);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询是否是关注的状态
		String str = fansService.findIsFans(userid, followUserId);
		//查看是否是好友
		String friend_str = userService.findIsFriend(userid, followUserId);
		int zanCount = zanService.findzanfollowCount(followUserId);
		int followCount = fansService.findFollowCountByUserId(Long.valueOf(followUserId));
		int fansCount = fansService.findFansCountByUserIdandFolllowid(Long.valueOf(followUserId));
		List<UserCustomer> messageList = messagesService.selectComment(followUserId , pagequery);
		UserCustomer profile = userService.getUserAndProfile(followUserId);
		//查询经纪范围	
		String jiyin = "";
		Broker broker = brokerMapper.selectByPrimaryKey(followUserId);
		String xpxpic = "";
		if (broker !=null) {
			xpxpic = broker.getXcxpicture();
			String [] code = broker.getCodes().split(",");
			List<Area> areas = userService.getjiyin (code);
			if (!areas.isEmpty() && areas.size() >0) {
				for (Area area :areas) {
					jiyin = jiyin  +area.getName() +"," ;
				}
			}
		}
		if (jiyin != "") {
			jiyin = jiyin.substring(0,jiyin.length()-1);
		}
		
		List<VillageCustomer> villageList = villageService.searchVillageByConsultant(followUserId);
		
		map.put("villageList",villageList );
		map.put("xpxpicture",xpxpic );
		map.put("jiyin", jiyin);
		map.put("profile", profile);
		map.put("fansCount", fansCount);
		map.put("followCount", followCount);
		map.put("zanCount", zanCount);
		map.put("messageList", messageList);
		map.put("message", str);
		map.put("friend", friend_str);
		return ResultMap.IS_200(map);
	}

	// 添加关注
	@RequestMapping(value = "/fans/insertFans")
	@ResponseBody
	public ResultMap insertFans(Long userid, Long followUserId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String returnstr = fansService.insertfans(userid, followUserId);
		//关注送金币
		if ("new".equals(returnstr)) {
			inteService.managebranch(10L, followUserId , userid);
		}
		int followCount = fansService.findFollowCountByUserId(Long.valueOf(followUserId));
		int fansCount = fansService.findFansCountByUserIdandFolllowid(Long.valueOf(followUserId));
		map.put("fansCount", fansCount);
		map.put("followCount", followCount);
		return ResultMap.IS_200(map);
	}

	// 取消关注
	@RequestMapping(value = "/fans/removeFans")
	@ResponseBody
	public ResultMap removeFans(Long userid, Long followUserId) {
		Map<String, Object> map = new HashMap<String, Object>();
		fansService.removeFans(userid, followUserId);
		int followCount = fansService.findFollowCountByUserId(Long.valueOf(followUserId));
		int fansCount = fansService.findFansCountByUserIdandFolllowid(Long.valueOf(followUserId));
		map.put("fansCount", fansCount);
		map.put("followCount", followCount);
		return ResultMap.IS_200(map);
	}

	// 点赞
	@RequestMapping(value = "/zan/addzan/{type}")
	@ResponseBody
	public ResultMap zanhouse(Zan zan, @PathVariable Integer type) {
		zanService.addzan(zan, type);
		return ResultMap.IS_200();
	}

	// 查询是否被赞过
	@ResponseBody
	@RequestMapping("/zan/displayzan/{type}")
	public ResultMap displayzanqiuzu(Zan zan, @PathVariable Integer type) {
		String str = "赞";
		Zan myzan = zanService.findisZan(zan, type);
		if (myzan != null) {
			if ("1".equals(myzan.getState())) {
				str = "已赞";
			}
		}
		return ResultMap.IS_200(str);
	}

	

	@RequestMapping(value = "/fans/cancelfFollow")
	@ResponseBody
	public ResultMap cancelfFollow(Long userid, Long followUserId) {
		@SuppressWarnings("unused")
		String msg = "关注";
		Map<String, Integer> map = new HashMap<String, Integer>();
		ResultMap.IS_200(map);
		try {
			fansService.updateFansState(userid, followUserId);
			int FansCount = fansService.findFansCountByUserIdandFolllowid(Long.valueOf(followUserId));
			int FollowCount = fansService.findFollowCountByUserId(Long.valueOf(followUserId));
			map.put("FansCount", FansCount);
			map.put("FollowCount", FollowCount);
		} catch (Exception e) {
			// TODO: handle exception
			msg = "已关注";
		}
		return ResultMap.IS_200(map);
	}

}
