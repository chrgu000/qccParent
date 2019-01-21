package cn.com.qcc.tenement.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Groupaddress;
import cn.com.qcc.pojo.Grouptype;
import cn.com.qcc.pojo.Rong;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.GroupVo;
import cn.com.qcc.queryvo.RongCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.RongService;
import cn.com.qcc.service.UserService;

@Controller
public class RongYunController {


	@Autowired
	RongService rongService;
	@Autowired
	UserService userService;
	
	//查询群组信息
	@RequestMapping("/group/groupdetail")
	@ResponseBody
	public ResultMap searchgroupdetail( GroupVo groupVo ) {
		ResultMap resultMap = rongService.searchgroupdetail(groupVo);
		return resultMap;
	}
	
	
	
	// 查询想要加入的群组这里需要分组查询
	@RequestMapping("/group/searchbyaddressname")
	@ResponseBody
	public ResultMap searchAddgroupbyAddressName(GroupVo groupVo ,
			@RequestParam(defaultValue="1")	Integer currentpage ,@RequestParam(defaultValue="8")Integer pagesize	) {
		
		// 设置群组的过滤距离
		groupVo.setMaxJuli(PayCommonConfig.GROUP_DEFAULT_COLATION_JULI);
		// 用户id非空不然报错
		if (CheckDataUtil.checkisEmpty(groupVo.getUserid())) {
			groupVo.setUserid(1L);
		}
		// 分页参数
		int infoCount = rongService.searchAddgroupbyAddressNameCount(groupVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		groupVo.setPagequery(pagequery);
		// 先查询分组信息
		List<RongCustomer> groupList = rongService.searchAddgroupbyAddressName(groupVo);
		
		// 提取出详情地址id的集合
		if (CheckDataUtil.checkNotEmpty(groupList)) {
			List<Long> detailids = new ArrayList<>();
			for (RongCustomer rong : groupList) {
				detailids.add(rong.getDetailid());
			}
			// 根据详情地址的集合查询数据
			List<RongCustomer> detailList = rongService.searchGroupbyIds(detailids ,groupVo.getUserid());
			// 在遍历一次融合数据
			for (RongCustomer group : groupList) {
				List<RongCustomer> addList = new ArrayList<>();
				for (RongCustomer detail : detailList) {
					// 如果是同一种的数据就要合并数据
					if (group.getDetailid().longValue() == detail.getDetailid().longValue()) {
						addList.add(detail);
					}
				}
				group.setGroupList(addList);
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery",pagequery);
		map.put("groupList",groupList);
		return ResultMap.IS_200(map);
		
	}
	
	// 查询想要加入的群
	@RequestMapping("/group/searchjoingroup")
	@ResponseBody
	public ResultMap searchaddgroup ( GroupVo groupVo ,
		@RequestParam(defaultValue="1")	Integer currentpage ,@RequestParam(defaultValue="8")Integer pagesize) {
		if (CheckDataUtil.checkisEmpty(groupVo.getUserid())) {
			groupVo.setUserid(1L);
		}
		
		//设置查询距离
		groupVo.setMaxJuli(PayCommonConfig.GROUP_DEFAULT_COLATION_JULI);
		
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = rongService.searchjoingroupCount(groupVo);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		groupVo.setPagequery(pagequery);
		List<RongCustomer> searchAdd = rongService.searchjoingroup(groupVo);
		map.put("pagequery", pagequery);
		map.put("groupsearchadd", searchAdd);
		return ResultMap.IS_200(map);
	}
	
	
	// 查询建群的分类
	@RequestMapping("/group/searchType")
	@ResponseBody
	public ResultMap getGroupTypge(@RequestParam(defaultValue="0") Long grouptypeid) {
		List<Grouptype> typeList = rongService.getGroupTypge(grouptypeid);
		return ResultMap.IS_200(typeList);
	}
	
	
	// 通过查询条件查询群组
	@RequestMapping("/group/searchbycondition")
	@ResponseBody
	public ResultMap searchgroupbycondition (@RequestParam(defaultValue="1") Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize , GroupVo groupVo) {
		
		
		return ResultMap.IS_200();
	}
	
	
	// 根据兴趣群的一级分类id查询二级分类
	@RequestMapping("/tribe/AvocationbyTribetypeid")
	@ResponseBody
	public ResultMap searchAvocationbytribetypeid(Integer tribetypeid) {
		if (CheckDataUtil.checkisEmpty(tribetypeid)) {return ResultMap.build(400, "入参必填");}
		List<Tribetype> typeList = rongService.searchAvocationbytribetypeid(tribetypeid);
		return ResultMap.IS_200(typeList);
	}
	
	
	// 根据用户id查询群列表
	@RequestMapping("/group/searchgroupbyuser")
	@ResponseBody
	public ResultMap searchgroupbyuser(Long userid , @RequestParam(defaultValue="1")Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize) {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		if (CheckDataUtil.checkisEmpty(userid)) 
			{ return ResultMap.build(400,"未知用户");}
		int infoCount = rongService.searchgroupbyuserCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<Ronggroup> groupList = rongService.searchgroupbyuser(userid , pagequery);
		map.put("groupList", groupList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	// 申请加入群组
	@RequestMapping("/group/applyjoin")
	@ResponseBody
	public ResultMap applyjoin (Long groupid ,Long userid) {
		ResultMap  resultMap = rongService.applyjoin (groupid , userid);
		return resultMap;
	}
	
	

	// 创建群
	@ResponseBody
	@RequestMapping("/group/create")
	public ResultMap createtribe(Ronggroup rongroup, Groupaddress groupaddress, Tribetype tribetype,String otherids)
			 {
		ResultMap resultmap = rongService.creategroup(rongroup, groupaddress, tribetype , otherids);
		return resultmap;
	}
	
	// 拉入进群
	@RequestMapping("/group/laren")
	@ResponseBody
	public ResultMap laren(Long groupid ,String otherids ,Long userid) {
		ResultMap resultMap = rongService.laren(groupid , otherids , userid); 
		return resultMap;
	}
	
	// 群编辑
	@ResponseBody
	@RequestMapping("/group/edit")
	public ResultMap updategroup (Ronggroup ronggoup){
		ResultMap resultMap = rongService.editgroup(ronggoup);
		return resultMap;
	}

	// 管理同意入群 / 或者不同意入群
	@ResponseBody
	@RequestMapping("/group/join/{state}")
	public ResultMap join(Long userid, Long groupid ,@PathVariable Integer state ) {
		return rongService.joingroup(userid, groupid , state);
	}

	// 退出群组
	@ResponseBody
	@RequestMapping("/group/quit")
	private ResultMap quitgroup(Long userid, Long groupid) {
		return rongService.quit(userid, groupid);
	}

	


	// 群列表
	@ResponseBody
	@RequestMapping("/group/list")
	public ResultMap grouplist(TribeVo tribeVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "4") int pagesize) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();

		Integer infoCount = rongService.getgrouplistcount(tribeVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		tribeVo.setPagequery(pagequery);

		List<Ronggroup> grouplist = rongService.getgrouplist(tribeVo);
		Map<String, Object> map = new HashMap<>();
		map.put("grouplist", grouplist);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	// 我加入的群
	@ResponseBody
	@RequestMapping("/group/mygroup")
	public ResultMap mygroup(Long userid) {
		if (userid == null) {
			userid = 1L;
		}
		List<RongCustomer> mygroup = rongService.mygroup(userid);
		Map<String, Object> map = new HashMap<>();
		map.put("mygroup", mygroup);
		return ResultMap.IS_200(map);
	}

	// 有兴趣的群
	@ResponseBody
	@RequestMapping("/group/enjorygroup")
	public ResultMap enjorygroup(TribeVo tribeVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "4") int pagesize) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();
		if (tribeVo.getUserid() == null) {
			tribeVo.setUserid(1L);
		}
		Integer infoCount = rongService.enjorygroupcount(tribeVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		tribeVo.setPagequery(pagequery);
		List<RongCustomer> enjorygroup = rongService.enjorygroup(tribeVo);
		Map<String, Object> map = new HashMap<>();
		map.put("enjorygroup", enjorygroup);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	// 群详情
	@ResponseBody
	@RequestMapping("/group/detail")
	public ResultMap enjorygroup(Long groupid) {
		RongCustomer rongCustomer = rongService.groupdetail(groupid);
		if (rongCustomer == null) {
			return ResultMap.build(400, "该群组不存在", rongCustomer);
		}
		return ResultMap.IS_200(rongCustomer);
	}

	// 明星群主
	@ResponseBody
	@RequestMapping("/group/hortuser")
	public ResultMap hortuser(TribeVo tribeVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "4") int pagesize) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();
		if (tribeVo.getUserid() == null) {
			tribeVo.setUserid(1L);
		}
		Integer infoCount = rongService.hortusercount(tribeVo.getUserid());
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		tribeVo.setPagequery(pagequery);
		List<UserCustomer> hortuser = rongService.hortuser(tribeVo);

		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("hortuser", hortuser);
		return ResultMap.IS_200(map);
	}

	// 人气qun
	@ResponseBody
	@RequestMapping("/group/hortgroup")
	public ResultMap hortgroup(TribeVo tribeVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "4") int pagesize) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();
		if (tribeVo.getUserid() == null) {
			tribeVo.setUserid(1L);
		}
		Integer infoCount = rongService.hortgroupcount(tribeVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		tribeVo.setPagequery(pagequery);
		List<RongCustomer> hortgroup = rongService.hortgroup(tribeVo);

		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("hortgroup", hortgroup);
		return ResultMap.IS_200(map);
	}

	// 群成员
	@ResponseBody
	@RequestMapping("/group/groupuser")
	public ResultMap groupuser(Long groupid) {
		List<RongCustomer> groupuser = rongService.groupuser(groupid);
		return ResultMap.IS_200(groupuser);
	}

	// 同步用户数据
	@ResponseBody
	@RequestMapping("/group/syncUser/{type}")
	public ResultMap groupsync(Long groupid , Long userid ,@PathVariable Integer type) {
		return rongService.syncUser(groupid , userid , type);
	}

	// 同步信息
	@RequestMapping("/group/syncpcmsg")
	@ResponseBody
	public ResultMap syncpcmsg(Rong rong) {
		ResultMap resultMap = rongService.syncpcmsg(rong);
		return resultMap;
	}

	// 同步群组信息
	@RequestMapping("/group/syncgrmsg")
	@ResponseBody
	public ResultMap syncgrmsg(Long groupid, String content) {
		ResultMap resultMap = rongService.syncgrmsg(groupid, content);
		return resultMap;
	}

	// 相关的群
	@RequestMapping("/group/about")
	@ResponseBody
	public ResultMap aboutgroup(Ronggroup ronggroup) {
		ResultMap resultMap = rongService.aboutgroup(ronggroup);
		return resultMap;
	}

	// 群成员
	@RequestMapping("/group/single")
	@ResponseBody
	public ResultMap single(Ronggroup ronggroup) {
		ResultMap resultMap = rongService.single(ronggroup);
		return resultMap;
	}
	
	
	// 解散群组
	@RequestMapping("/group/delete")
	@ResponseBody
	public ResultMap deletegroup (Long userid ,Long groupid) {
		ResultMap resultMap = rongService.deleteGroup (userid ,groupid);
		return resultMap;
	}
	
	
	// 查询附近的人
	@RequestMapping("/group/nearpersion")
	@ResponseBody
	public ResultMap nearpersion (VillageeVo villageVo , 
			@RequestParam(defaultValue="1")Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize) {
		PageQuery pagequery = new PageQuery();
		int infoCount = rongService.nearpersionCount(villageVo);
		villageVo.setPagequery(pagequery);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		Map<String, Object> map = new HashMap<>();
		List<ArticleDetailCustomer> userList = rongService.nearpersion(villageVo);
		map.put("userList", userList);
		map.put("pagequery",pagequery);
		return ResultMap.IS_200(map);
	}
	
}
