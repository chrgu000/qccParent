package cn.com.qcc.managerclient.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.service.BrokerService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.UserService;


@Controller
@RequestMapping("/companion")
public class BrokerController {
	
	@Autowired
	BrokerService brokerService;
	@Autowired
	UserService userService;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	InteService inteService;
	
	//租客登记时候校验实名认证
	@RequestMapping("/checkusersign")
	@ResponseBody
	public ResultMap checkusersign (Long telephone ,String realname ,String identity
			,String orcPath ) {
		if (telephone == null || "".equals(realname) || "".equals(identity) ||
				realname == null || identity == null || (telephone+"").length() !=11) {
			return ResultMap.build(300,"数据不全");
		}
		
		//先通过电话号码获取用户的基本信息
		UserCustomer userCustomer = userService.getuserdetailbyphone (telephone);
		Profile profile = new Profile();
		profile.setReal_name(realname);
		profile.setIdentity(identity);
		profile.setUser_id(userCustomer.getUserid());
		ResultMap resultMap = brokerService.brokeruser(profile ,orcPath);
		//说明实名成功
		if (resultMap.getCode() == 200) {
			// 这里同步信息
			profile.setReal_name(realname);
			profile.setIdentity(identity);
			profile.setSignstate(2);
			profile.setUser_id(userCustomer.getUserid());
			userService.updateprofile(profile);
		}
		return resultMap;
	}
	
	

	//经纪人入驻
	@ResponseBody
	@RequestMapping("/bebroker")
	public ResultMap bebroker (Broker broker ,String orcPath ) {
		// 先校验数据
		if (broker.getUserid() == null) {return ResultMap.build(300, "未知登录");}
		if (broker.getCodes() == null || "".equals(broker.getCodes())) {
			return ResultMap.build(300, "请选择区域");
		}
		Profile profile = new Profile();
		profile.setUser_id(broker.getUserid());
		//先校验实名认证
		ResultMap resultMap = brokerService.brokeruser(profile ,orcPath);
		//说明实名成功
		if (resultMap.getCode() == 200) {
			ResultMap result = brokerService.bebroker(broker);
			return result;
		}
		return resultMap;
	}
	
	//实名认证
	@ResponseBody
	@RequestMapping("/brokeruser")
	public ResultMap brokeruser (Profile profile,String orcPath) {
		
		
		ResultMap resultMap = brokerService.brokeruser(profile ,orcPath);
		//说明通过实名认证过
		if (resultMap.getCode() == 200) {
			boolean flag = inteService.isgetjinbibyevent( 17L , profile.getUser_id());
			//如果没有获得
			if (flag == false) {
				inteService.managebranch(17L, profile.getUser_id() , profile.getUser_id());
			}
		}
		return resultMap;
	}
	
	
	//实名认证
	@ResponseBody
	@RequestMapping("/brokeruser1")
	public ResultMap brokeruser1 (Profile profile , String orcPath) {
		ResultMap resultMap = brokerService.brokeruser(profile , orcPath);
		//说明通过实名认证过
		if (resultMap.getCode() == 200) {
			boolean flag = inteService.isgetjinbibyevent( 17L , profile.getUser_id());
			//如果没有获得
			if (flag == false) {
				inteService.managebranch(17L, profile.getUser_id() , profile.getUser_id());
			}
		}
		return resultMap;
	}
	
	//找经纪人
	@RequestMapping("/searchbroker")
	@ResponseBody
	public ResultMap searchbroker(UserCentVo userCentVo ,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize ,String city ) {
		if (userCentVo.getOrdername() !=null && !"".equals(userCentVo.getOrdername())) {
			if ( !"desc".equals(userCentVo.getOrdername()) && !"asc".equals(userCentVo.getOrdername())) {
				return ResultMap.build(300,"参数错误");
			}
		}
		
		// 通过城市获取到code
		String likecode = brokerService.getcodebycity(city);
		if (userCentVo.getCode() == null || "".equals(userCentVo.getCode())) {
			userCentVo.setCode(likecode);
		}
		
		Map<String,Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = brokerService.searchbrokerCount(userCentVo);
		userCentVo.setPagequery(pagequery);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		List<UserCustomer> users = brokerService.searchbroker(userCentVo);
		map.put("brokers", users);
		map.put("citycode", likecode);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	//查询我的房东
	@RequestMapping("/searchmylandload")
	@ResponseBody
	public ResultMap searchmylandload(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		Map<String,Object> map = new HashMap<>();
		if (userVo.getUserid() == null) {return ResultMap.build(404, "登录超时");}
		int infoCount =  brokerService.searchmylandloadCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<UserCustomer> mylandload = brokerService.searchmylandload(userVo);
		//查询最新申请哪些房东需要加我为经济人
		int newcount = brokerService.searchmylandloadnewcount(userVo);
		map.put("mylandload", mylandload);
		map.put("pagequery", pagequery);
		map.put("newcount", newcount);
		return ResultMap.IS_200(map);
	}
	
	
	//查询我的经济人
	@RequestMapping("/searchmybroker")
	@ResponseBody
	public ResultMap searchmybroker(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		Map<String,Object> map = new HashMap<>();
		if (userVo.getUserid() == null) {return ResultMap.build(404, "登录超时");}
		int infoCount =  brokerService.searchmybrokerCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<UserCustomer> mylandload = brokerService.searchmybroker(userVo);
		//查询最新申请哪些房东需要加我为经济人
		int newcount = brokerService.searchmybrokernewcount(userVo);
		map.put("mylandload", mylandload);
		map.put("pagequery", pagequery);
		map.put("newcount", newcount);
		return ResultMap.IS_200(map);
	}
	
	// 根据关键字查询 我想添加的经纪人
	@RequestMapping("/searchlikeaddbroker")
	@ResponseBody
	public ResultMap searchlikeaddbroker(Long userid ,String searchwhere) {
		// 校验当前用户是否属于房东
		Landlord landlord = userService.searchLandUserByUserId(userid);
		if (landlord == null || landlord.getLandstate() !=2 ) {return ResultMap.build(404,"非房东用户");}
		//然后根据输入的关键字添加经纪人
		UserCustomer search = new UserCustomer();
		search.setSearchwhere(searchwhere);
		search.setUserid(userid);
		List<UserCustomer> searchbroker = brokerService.searchlikebroker(search);
		return ResultMap.IS_200(searchbroker);
	}
	
	// 根据关键字查询 我想添加的房东
	@RequestMapping("/searchlikeaddlandlord")
	@ResponseBody
	public ResultMap searchlikeaddlandlord(Long userid ,String searchwhere) {
		// 校验当前用户是否经纪人
		Broker broker = brokerService.searchbrokeruserbyid (userid);
		if (broker == null || broker.getState() !=2 ) {return ResultMap.build(404,"非经纪人用户");}
		//然后根据输入的关键字添加经纪人
		UserCustomer search = new UserCustomer();
		search.setSearchwhere(searchwhere);
		search.setUserid(userid);
		List<UserCustomer> searchbroker = brokerService.searchlikeaddlandlord(search);
		return ResultMap.IS_200(searchbroker);
	}
	
	//房东添加经纪人
	@RequestMapping("/landaddbroker")
	@ResponseBody
	public ResultMap landaddbroker (Long userid ,Long searchuserid) {
		// 校验当前用户是否经纪人
		Broker broker = brokerService.searchbrokeruserbyid (searchuserid);
		if (broker == null || broker.getState() !=2 ) {return ResultMap.build(404,"非经纪人用户");}
		Landlord landlord = userService.searchLandUserByUserId(userid);
		if (landlord == null || landlord.getLandstate() !=2 ) {return ResultMap.build(404,"非房东用户");}
		ResultMap resultMap = brokerService.landaddbroker(userid , searchuserid);
		return resultMap ;
	}
	
	
	//经纪人添加 房东
	@RequestMapping("/brokeraddland")
	@ResponseBody
	public ResultMap brokerandland (Long searchuserid ,Long userid) {
		// 校验当前用户是否经纪人
		Broker broker = brokerService.searchbrokeruserbyid (userid);
		if (broker == null || broker.getState() !=2 ) {return ResultMap.build(404,"非经纪人用户");}
		Landlord landlord = userService.searchLandUserByUserId(searchuserid);
		if (landlord == null || landlord.getLandstate() !=2 ) {return ResultMap.build(404,"非房东用户");}
		ResultMap resultMap = brokerService.brokerandland(searchuserid , userid);
		return resultMap ;
	}
	
	//房东查询经纪人的申请列表
	@RequestMapping("/landsearchbrokerapply")
	@ResponseBody
	public ResultMap landsearchbrokerapply(Long userid) {
		if (userid == null) {return ResultMap.build(404, "用户ID不存在");}
		List<UserCustomer> searchlist = brokerService.landsearchbrokerapply(userid);
		return ResultMap.IS_200(searchlist);
	}
	
	//经纪人查询房东的申请列表
	@RequestMapping("/brokersearchlandapply")
	@ResponseBody
	public ResultMap brokersearchlandapply(Long userid) {
		if (userid == null) {return ResultMap.build(404, "用户ID不存在");}
		List<UserCustomer> searchlist = brokerService.brokersearchlandapply(userid);
		return ResultMap.IS_200(searchlist);
	}
	
	//房东 处理 经济人申请的结果
	@RequestMapping("/landapprovebroker") 
	@ResponseBody
	public ResultMap landapprovebroker(Long userid ,Long searchuserid ,Long state) {
		ResultMap resultMap = brokerService.landapprovebroker (userid,searchuserid,state);
		return resultMap;
	}
	
	
	//经济人处理房东 申请的结果 userid 经济人ID 
	@RequestMapping("/brokerapproveland") 
	@ResponseBody
	public ResultMap brokerapproveland(Long userid ,Long searchuserid ,Long state) {
		ResultMap resultMap = brokerService.brokerapproveland (userid,searchuserid,state);
		return resultMap;
	}
	
	
	

}
