package cn.com.qcc.tenement.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.ExcelExportSXXSSF;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.detailcommon.Sha1;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.Commoninte;
import cn.com.qcc.pojo.Defaultpercent;
import cn.com.qcc.pojo.Historyexcle;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.Percent;
import cn.com.qcc.pojo.Percenttype;
import cn.com.qcc.pojo.Role;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.UserRole;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.LandlordCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.service.AccessService;
import cn.com.qcc.service.BDService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.LandLordService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;
import cn.com.qcc.service.solrdao.HouseSolrDao;
import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
@Controller
public class BackController{

	@Autowired UserService userService;
	@Autowired AccessService accessService;
	@Autowired HttpServletRequest request;
	@Autowired InteService inteService;
	@Autowired VillageService villageService;
	@Autowired LandLordService landLordService;
	@Autowired HouseSolrDao houseSolrDao;
	@Autowired BDService bdService;
	@Autowired JedisClient jedisClient;
	
	@RequestMapping("/bd/searchAddBd")
	@ResponseBody
	public ResultMap searchAddBd(@RequestParam(defaultValue="1")int currentpage ,
			@RequestParam(defaultValue="7")int pagesize, String searchWhere) {
		int infoCount = bdService.searchAddBDCount(searchWhere);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<UserCustomer> users = bdService.searchAddBD(searchWhere, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery",pagequery);
		map.put("userList", users);
		return ResultMap.IS_200(map);
	}
	
	
	@RequestMapping("/bd/save")
	@ResponseBody
	public ResultMap addBD(Bdmanager bdmanager ) {
		
		String code = bdmanager.getCode();
		
		if (CheckDataUtil.checkNotEmpty(code)
				&& code.endsWith(",")) {
			code = code.substring(0, code.length() -1);
			bdmanager.setCode(code);
		}
		
		return bdService.addOrUpdate(bdmanager);
	}
	
	@RequestMapping("/bd/changeState")
	@ResponseBody
	public ResultMap changeState(String bdid) {
		return bdService.changeState(bdid);
	}
	
	@RequestMapping("/bd/changeEditstate")
	@ResponseBody
	public ResultMap changeEditstate(String bdid) {
		return bdService.changeEditstate(bdid);
	}
	
	@RequestMapping("/bd/list")
	@ResponseBody
	public ResultMap listBD() {
		return bdService.listBD();
	}
	
	@RequestMapping("/bd/searchOne")
	@ResponseBody
	public ResultMap searchOne (String bdid) {
		return bdService.findOne(bdid);
		
	}
	@RequestMapping ("/back/getLikeVillage") 
	@ResponseBody
	public ResultMap getLikeVillage (String likename) {
		List<VillageCustomer> villageCustomer = accessService.getLikeVillage(likename);
		return ResultMap.IS_200(villageCustomer);
	}
	
	@RequestMapping("/back/userRoleAdd")
	@ResponseBody
	public ResultMap userRoleAdd(String userids ,Long roleid){
		
		if (CheckDataUtil.checkisEmpty(userids) || CheckDataUtil.checkisEmpty(roleid)) 
			return ResultMap.build(400, "少参数");
		return accessService.userRoleAdd(userids,roleid);
	}
	
	/**
	 * 查询需要添加的系统账号
	 * **/
	@RequestMapping("/back/searchAddRole")
	@ResponseBody
	public ResultMap searchAddRole(String searchWhere,
			@RequestParam(defaultValue="8")int pagesize ,
			@RequestParam(defaultValue="1")int currentpage) {
		int infocount = accessService.searchAddRoleCount(searchWhere);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		List<UserCustomer> userList = accessService.searchAddRole(searchWhere ,pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("userList", userList);
		return ResultMap.IS_200(map);
	}
	
	
	@RequestMapping("/deleteSolr")
	public ResultMap del (HouseCustomer houseCustomer) {
		houseSolrDao.oneHouseDeleteFromSolr(houseCustomer);
		return ResultMap.IS_200();
	}
	
	
	@RequestMapping("/userback/login11")
	@ResponseBody
	public ResultMap userbacklogin ( User user) {
		System.out.println(user.getPassword());
		if (CheckDataUtil.checkisEmpty(user)) {
			return ResultMap.build(400, "输入手机号码");
		}
		// Base64解密
		String password = user.getPassword();
		String password1 = getFromBASE64(password);
		// Sha1加密
		password = Sha1.getSha1(password1 + "_zf");
		System.out.println(password);
		User userSearch = userService.loginByPwd(user);
		if (CheckDataUtil.checkisEmpty(userSearch)) {
			return ResultMap.build(400, "该用户不存在");
		}
		if (!userSearch.getPassword().equals(password)) {
			return ResultMap.build(400, "账号或者密码错误");
		}
		
		UserCustomer rolen_user = getRoleName(userSearch);
		
		if (CheckDataUtil.checkisEmpty(rolen_user)) {
			return ResultMap.build(400, "你没有登录后台的权限");
		}
		
		if (!"1".equals(rolen_user.getState().toString())) {
			return ResultMap.build(400, "账号已经被冻结");
		}
		
		UserCustomer user_search = userService.getUserAndProfile(userSearch.getUserid());
		user_search.setRoleid(rolen_user.getRoleid());
		user_search.setRolename(rolen_user.getRolename());
		// 通过用户ID查询权限集合
		List<Access> list = getaccessbyuserid(user_search);
		user_search.setAccess(list);
		request.getSession().setAttribute("userback", user_search);
		return ResultMap.IS_200(user_search);
	}

	/** 用户通过密码登录后台
	 * @param password : 账号密码
	 * @param telephone : 电话号码
	 */
	@RequestMapping(value = "/userback/login")
	public String userLoginByPwd(HttpServletRequest request, HttpServletResponse response, String password, Model model,
			Long telephone) throws Exception {
		
		
		
		// Base64解密
		String password1 = getFromBASE64(password);
		// Sha1加密
		String str1 = Sha1.getSha1(password1 + "_zf");
		System.out.println(telephone);
		System.out.println(str1);
		if (telephone == null) {
			return "redirect:/login";
		}
		User user = new User();
		user.setTelephone(telephone);
		User user1 = userService.loginByPwd(user);
		System.out.println(user1.getPassword());
		if (user1 != null) {
			if (!user1.getPassword().equals(str1)) {
				request.getSession().setAttribute("error", "用户名名和密码不一致");
				return "redirect:/login";
			}
			if (user1.getPassword().equals(str1)) {
				UserCustomer rolen_user = getRoleName(user1);
				if (rolen_user == null) {
					request.getSession().setAttribute("error", "你没有登录后台的权限");
					return "redirect:/login";
				} else {
					if (!"1".equals(rolen_user.getState().toString())) {
						request.getSession().setAttribute("error", "你的账号已经被冻结");
						return "redirect:/login";
					}
					
					UserCustomer user_search = userService.getUserAndProfile(user1.getUserid());
					// 通过用户ID查询权限集合
					List<Access> list = getaccessbyuserid(user_search);
					user_search.setAccess(list);
					user_search.setRoleid(rolen_user.getRoleid());
					user_search.setRolename(rolen_user.getRolename());
					request.getSession().setAttribute("userback", user_search);
					return "redirect:/index";
				}
			}
			

		}
		request.getSession().setAttribute("error", "账号密码不匹配");
		return "redirect:/login";

	}

	/**
	 * 根据用户的ID,查询用户的角色ID 和角色名称 
	 * @param userid : 用户ID
	 * **/
	private UserCustomer getRoleName(User user1) {
		return userService.getRoleName(user1);
	}
	
	/** 根据用户的ID ，查询用户对应的权限
	 * @param userid : 用户ID
	 * **/
	private List<Access> getaccessbyuserid(UserCustomer user_search) {
		// TODO Auto-generated method stub
		return accessService.getaccessbyuserid(user_search);
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		
		Object error = request.getSession().getAttribute("error");
		if (CheckDataUtil.checkNotEmpty(error)) {
			
			model.addAttribute("error", error.toString());
			System.out.println(error);
		}
		
		
		return "login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * 退出  后台 登录
	 * **/
	@RequestMapping(value = "/layout")
	public String layout(HttpServletRequest request) {
		request.getSession().removeAttribute("userback");
		return "redirect:/login";
	}

	/** 将 BASE64 编码的字符串 s 进行解码
	 * **/
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取所有的 角色对应 的权限
	 * @param role_accid : 角色 对应的权限
	 * **/
	@RequestMapping(value = "/back/getallrole_access")
	@ResponseBody
	public ResultMap getallrole_access(String role_accid) {
		Map<String, Object> map = new HashMap<>();
		String[] str = role_accid.split(",");
		List<Access> isin = accessService.isinrole(str);
		List<Access> isnot = accessService.isnotrole(str);
		isin.addAll(isnot);
		Collections.sort(isin);
		map.put("isin", isin);
		return ResultMap.IS_200(map);
	}

	/** 创建或者编辑 / 角色
	 * @param rolename : 角色名称
	 * @param roleid : 角色ID
	 * **/
	@RequestMapping(value = "/back/inserorupdaterole")
	@ResponseBody
	public ResultMap inserorupdaterole(Role role) {
		ResultMap resultMap = accessService.inserorupdaterole(role);
		return resultMap;
	}

	/*** 修改角色对应的权限
	 * @param role_accid : 角色对应权限ID
	 * @param roleid  : 当前角色ID
	 * **/
	@RequestMapping(value = "/back/changge_access")
	@ResponseBody
	public ResultMap changge_access(Role role) {
		ResultMap resultMap = accessService.changge_access(role);
		return resultMap;
	}

	/**
	 * 获取所有用户对应的角色
	 * **/ 
	@RequestMapping(value = "/back/getalluser_role")
	@ResponseBody
	public ResultMap getalluser_role(UserVo userVo, @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		userVo = userVo ==  null ? new UserVo() : userVo;
		Map<String,Object> map = new HashMap<>();
		int infocount = accessService.getalluser_roleCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<UserCustomer> users = accessService.getalluser_role(userVo);
		map.put("user", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/** 查询 用户对应 的角色
	 * @param rolename : 角色名称
	 * @param telephonoe : 电话号码
	 * **/
	@RequestMapping(value = "/back/getallmanager_user")
	@ResponseBody
	public ResultMap getallmanager_user(UserVo userVo , @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		
		userVo = userVo ==  null ? new UserVo() : userVo;
		Long userid = IDUtils.searchuseridbyrequest(request);
		userVo.setUserid(userid);
		
		int infocount = accessService.getallmanager_userCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		
		Map<String,Object> map = new HashMap<>();
		List<UserCustomer> users  = accessService.getallmanager_user(userVo);
		
		map.put("manageruser", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 角色对应权限
	 * **/ 
	@RequestMapping(value = "/back/rolenotinuser")
	@ResponseBody
	public ResultMap rolenotinuser(Role role) {
		ResultMap resultMap = accessService.rolenotinuser(role);
		return resultMap;
	}

	/***
	 *  改变用户对应的角色
	 *  @param userid : 用户id
	 *  @param roleid : 角色ID
	 * **/
	@RequestMapping(value = "/back/changgeuserrole")
	@ResponseBody
	public ResultMap changgeuserrole(UserRole userRole) {
		ResultMap resultMap = accessService.changgeuserrole(userRole);
		return resultMap;
	}

	/**
	 * 查询管理对应的用户
	 * @param userid : 当前用户ID
	 * **/
	@RequestMapping(value = "/back/totaluser")
	@ResponseBody
	public ResultMap totaluser(UserVo userVo , @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		int infocount = accessService.totaluserCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		Map<String, Object> map = new HashMap<>();
		List<UserCustomer> users =  accessService.totaluser(userVo);
		map.put("pagequery", pagequery);
		map.put("totaluser", users);
		return ResultMap.IS_200(map);
	}

	/** 查询所有需要被管理的用户
	 *  @param userid : 用户ID
	 * **/
	@RequestMapping(value = "/back/alltobemanager")
	@ResponseBody
	public ResultMap alltobemanager(UserVo uservo, @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		int infocount = accessService.alltobemanagercount(uservo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		uservo.setPagequery(pagequery);
		Map<String, Object> map = new HashMap<>();
		List<UserCustomer> users = accessService.alltobemanager(uservo);
		map.put("users", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 建立用户和管理的关系
	 * @param userid : 用户的ID
	 * @param userids : 被管理 的用户
	 * **/ 
	@RequestMapping(value = "/back/usertobemanager")
	@ResponseBody
	public ResultMap usertobemanager(Long userid, String userids) {
		if (userid == null) {
			return ResultMap.build(400, "请选择管理");
		}
		if ("".equals(userids) || userids == null) {
			return ResultMap.build(400, "请选择需要管理的用户");
		}
		ResultMap resultMap = accessService.usertobemanager(userid, userids);
		return resultMap;
	}

	/**
	 * 查询管理员对应用户下充值记录
	 * @param userids : 管理的IDS
	 * 
	 * **/ 
	@RequestMapping(value = "/back/getmanageruserchongzhi")
	@ResponseBody
	public ResultMap getmanageruserchongzhi(String userids ,@RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize ) {
		if (userids == null || "".equals(userids)) {
			return ResultMap.build(400, "请先选择需要查看的用户");
		}
		Map<String, Object> map = new HashMap<>();
		String[] ids = userids.split(",");
		int infocount = accessService.getmanageruserchongzhiCount(ids);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<UserCustomer> users = accessService.getmanageruserchongzhi(ids ,pagequery);
		map.put("pagequery", pagequery);
		map.put("chongzi", users);
		return ResultMap.IS_200(map);
	}

	/**
	 *  查询管理员对应用户下消费记录
	 *  @param userids : 管理对应的用户IDS
	 * **/
	@RequestMapping(value = "/back/getmanageruserxiaofei")
	@ResponseBody
	public ResultMap getmanageruserxiaofei(String userids, @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize ) {
		if (userids == null || "".equals(userids)) {
			return ResultMap.build(400, "请先选择需要查看的用户");
		}
		Map<String, Object> map = new HashMap<>();
		String[] ids = userids.split(",");
		int infocount = accessService.getmanageruserxiaofeiCount(ids);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<UserCustomer> users = accessService.getmanageruserxiaofei(ids , pagequery);
		map.put("pagequery", pagequery);
		map.put("xiaofei", users);
		return ResultMap.IS_200(map);
	}

	/**查询管理员对应用户下会员充值记录
	 * @param userids : 对应的用户的ids
	 * **/ 
	@RequestMapping(value = "/back/getmanageruservip")
	@ResponseBody
	public ResultMap getmanageruservip(String userids , @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		if (userids == null || "".equals(userids)) {
			return ResultMap.build(400, "请先选择需要查看的用户");
		}
		Map<String, Object> map = new HashMap<>();
		String[] ids = userids.split(",");
		int infocount = accessService.getmanageruservipCount(ids);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<UserCustomer> users = accessService.getmanageruservip(ids ,pagequery);
		map.put("pagequery", pagequery);
		map.put("huiyuan", users);
		return ResultMap.IS_200(map);
	}
	
	
	/**根据条件导出楼栋EXCLE文件
	 * @throws Exception **/
	@RequestMapping("/back/buildingupload")
	@ResponseBody
	public ResultMap buildingUpload (Long code , Integer type) throws Exception {
		String searchwhere = "";
		if (type == 1) {searchwhere = "landphone";}
		List<BuildingCustomer> builList = villageService.buildingUpload (code , searchwhere);
		// 设置文件导出的路径
		String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/hisexcle/";
		filePath = filePath.replace("/Tenement", "");
		// 导出文件的前缀
		String filePrefix = "building";
		// -1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
		int flushRows = 100;
		List<String> fieldNames = getbuildingNamesbyType();
		List<String> fieldCodes = getbuildingCodesbyType();
		
		// 开始导出，执行一些workbook及sheet等对象的初始创建
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/", filePrefix, fieldNames,
				fieldCodes, flushRows);
		//FormmartDate(users);
		// 执行导出
		excelExportSXXSSF.writeDatasByObject(builList);
		// 输出文件，返回下载文件的http地址
		String webpath = excelExportSXXSSF.exportFile();
		String returnpath = "https://www.zzw777.com/upload/hisexcle"+webpath;
		return ResultMap.IS_200(returnpath);
	}
	private List<String> getbuildingCodesbyType() {
		// 指导导出数据的title
		List<String> codedNames = new ArrayList<String>();
		codedNames.add("buildingid");
		codedNames.add("district");
		codedNames.add("villagename");
		codedNames.add("building");
		codedNames.add("landphone");
		codedNames.add("bnumber");
		codedNames.add("detailes");
		return codedNames;
	}

	private List<String> getbuildingNamesbyType() {
		// 指导导出数据的title
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("楼栋主键");
		fieldNames.add("区域名称");
		fieldNames.add("小区名称");
		fieldNames.add("楼栋名称");
		fieldNames.add("房东电话");
		fieldNames.add("门牌号");
		fieldNames.add("详情地址");
		return fieldNames;
	}

	/**
	 * 根据参数导出 EXCLE 文件
	 * **/
	@RequestMapping(value = "/upload")
	@ResponseBody
	public ResultMap te(HttpServletRequest request,String outtype,
			UserVo userVo,String userids,String housestatus,String qiuzuhousestatus) throws Exception {
		String [] houses_tatus = null;
		if ("9".equals(housestatus)) {
			houses_tatus = new String []{"1","2","3","4","0"};
		}else {
			houses_tatus = housestatus.split(",");
		}
		String [] qiuzuhouses_tatus = null;
		if ("9".equals(qiuzuhousestatus)) {
			qiuzuhouses_tatus = new String []{"0","1","2"};
		}else {
			qiuzuhouses_tatus = qiuzuhousestatus.split(",");
		}
		for (int i=0;i<qiuzuhouses_tatus.length;i++) 
		{
		}
	
		String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/hisexcle/";
		filePath = filePath.replace("/Tenement", "");
	
		// 导出文件存放的路径，并且是虚拟目录指向的路径
		
		// 导出文件的前缀
		String filePrefix = "common";
		if ("基本信息".equals(outtype)) {filePrefix="common";}
		if ("充值记录".equals(outtype)) {filePrefix="inmonery";}
		if ("消费记录".equals(outtype)) {filePrefix="outmonery";}
		if ("会员充值".equals(outtype)) {filePrefix="vipmonery";}
		if ("房源发布".equals(outtype)) {filePrefix="housefabu";}
		if ("求租发布".equals(outtype)) {filePrefix="qiuzufabu";}
		// -1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
		int flushRows = 100;
		//根据前台传过来的TYPE
		List<String> fieldNames = getfieldNamesbyType(outtype);

		// 告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
		List<String> fieldCodes = getfieldCodesbyType(outtype);
		

		// 开始导出，执行一些workbook及sheet等对象的初始创建
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/", filePrefix, fieldNames,
				fieldCodes, flushRows);
		

		// 准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
		List<UserCustomer> users = null;
		if ("基本信息".equals(outtype)) {
			users = accessService.totaluser(userVo);
		}
		if ("充值记录".equals(outtype)) {
			if (userids == null || "".equals(userids)) {
				return ResultMap.build(400, "请先选择需要查看的用户");
			}
			String[] ids = userids.split(",");
			users = accessService.getmanageruserchongzhi(ids,null);
		}
		if ("消费记录".equals(outtype)) {
			if (userids == null || "".equals(userids)) {
				return ResultMap.build(400, "请先选择需要查看的用户");
			}
			String[] ids = userids.split(",");
			users =accessService.getmanageruserxiaofei(ids ,null);
		}
		if ("会员充值".equals(outtype)) {
			if (userids == null || "".equals(userids)) {
				return ResultMap.build(400, "请先选择需要查看的用户");
			}
			String[] ids = userids.split(",");
			users =accessService.getmanageruservip(ids,null);
		}
		if ("房源发布".equals(outtype)) {
			if (userids == null || "".equals(userids)) {
				return ResultMap.build(400, "请先选择需要查看的用户");
			}
			String[] ids = userids.split(",");
			users =accessService.gethousefabu(ids ,houses_tatus,null);
			sethousestate(users);
		}
		if ("求租发布".equals(outtype)) {
			if (userids == null || "".equals(userids)) {
				return ResultMap.build(400, "请先选择需要查看的用户");
			}
			String[] ids = userids.split(",");
			users =accessService.gethouseqiuzu(ids, qiuzuhouses_tatus,null);
			sethouseqiuzustate(users);
		}
		FormmartDate(users);
		// 执行导出
		excelExportSXXSSF.writeDatasByObject(users);
		// 输出文件，返回下载文件的http地址
		String webpath = excelExportSXXSSF.exportFile();

		return ResultMap.IS_200(webpath);

	}

	private void FormmartDate(List<UserCustomer> users) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (UserCustomer user : users) {
			if (user.getUpdate_time() !=null) {
				String formtime = simpleDateFormat.format(user.getUpdate_time());
				user.setFormtime(formtime);
			}
		}
		
	}

	private List<String> getfieldCodesbyType(String outtype) {
		List<String> filedCodes = new ArrayList<String>();
		if ("基本信息".equals(outtype)) {
			filedCodes.add("userid");
			filedCodes.add("user_name");
			filedCodes.add("telephone");
			filedCodes.add("inmonetary");
			filedCodes.add("vipmonetary");
			filedCodes.add("outmonetary");
			filedCodes.add("balance");
			filedCodes.add("fcount");
			filedCodes.add("qcount");
			filedCodes.add("scount");
		}
		if ("充值记录".equals(outtype)) {
			filedCodes.add("consume_id");
			filedCodes.add("user_id");
			filedCodes.add("user_name");
			filedCodes.add("telephone");
			filedCodes.add("inmonetary");
			filedCodes.add("formtime");
		}
		if ("消费记录".equals(outtype)) {
			filedCodes.add("consume_id");
			filedCodes.add("user_id");
			filedCodes.add("user_name");
			filedCodes.add("telephone");
			filedCodes.add("outmonetary");
			filedCodes.add("formtime");
		}
		if ("会员充值".equals(outtype)) {
			filedCodes.add("consume_id");
			filedCodes.add("user_id");
			filedCodes.add("user_name");
			filedCodes.add("telephone");
			filedCodes.add("vipmonetary");
			filedCodes.add("formtime");
		}
		if ("房源发布".equals(outtype)) {
			filedCodes.add("user_name");
			filedCodes.add("telephone");
			filedCodes.add("trading");
			filedCodes.add("villagename");
			filedCodes.add("building");
			filedCodes.add("prices");
			filedCodes.add("apartmentname");
			filedCodes.add("contacts");
			filedCodes.add("contactstel");
			filedCodes.add("formtime");
			filedCodes.add("housestatus");
		}
		if ("求租发布".equals(outtype)) {
			filedCodes.add("user_name");
			filedCodes.add("telephone");
			filedCodes.add("trading");
			filedCodes.add("classification");
			filedCodes.add("areas");
			filedCodes.add("prices");
			filedCodes.add("contacts");
			filedCodes.add("contactstel");
			filedCodes.add("formtime");
			filedCodes.add("housestatus");
		}
		return filedCodes;
	}

	private List<String> getfieldNamesbyType(String outtype) {
		// 指导导出数据的title
		List<String> fieldNames = new ArrayList<String>();
		if ("基本信息".equals(outtype)) {
			fieldNames.add("用户主键");
			fieldNames.add("用户昵称");
			fieldNames.add("电话号码");
			fieldNames.add("累计充值");
			fieldNames.add("会员充值");
			fieldNames.add("累计消费");
			fieldNames.add("可用余额");
			fieldNames.add("房源发布");
			fieldNames.add("求租发布");
			fieldNames.add("意见反馈");
		}
		if ("充值记录".equals(outtype)) {
			fieldNames.add("充值单号");
			fieldNames.add("用户编号");
			fieldNames.add("用户昵称");
			fieldNames.add("手机号码");
			fieldNames.add("充值金额");
			fieldNames.add("充值时间");
		}
		if ("消费记录".equals(outtype)) {
			fieldNames.add("消费单号");
			fieldNames.add("用户编号");
			fieldNames.add("用户昵称");
			fieldNames.add("手机号码");
			fieldNames.add("消费金额");
			fieldNames.add("消费时间");
		}
		if ("会员充值".equals(outtype)) {
			fieldNames.add("会员单号");
			fieldNames.add("用户编号");
			fieldNames.add("用户昵称");
			fieldNames.add("手机号码");
			fieldNames.add("会员金额");
			fieldNames.add("充值时间");
		}
		if ("房源发布".equals(outtype)) {
			fieldNames.add("用户昵称");
			fieldNames.add("手机号码");
			fieldNames.add("街道名称");
			fieldNames.add("小区名称");
			fieldNames.add("楼栋名称");
			fieldNames.add("租金(元/月)");
			fieldNames.add("户型");
			fieldNames.add("联系人");
			fieldNames.add("联系人电话");
			fieldNames.add("更新时间");
			fieldNames.add("出租状态");
		}
		if ("求租发布".equals(outtype)) {
			fieldNames.add("用户昵称");
			fieldNames.add("手机号码");
			fieldNames.add("街道名称");
			fieldNames.add("类型");
			fieldNames.add("面积");
			fieldNames.add("价格");
			fieldNames.add("联系人");
			fieldNames.add("联系人电话");
			fieldNames.add("更新时间");
			fieldNames.add("求租状态");
		}
		return fieldNames;
	}
	
	/**
	 * 查询管理员对应用户下求租记录
	 * @param userids : 管理下面的与用户ID
	 * @param housestatus : 房源的状态码
	 * **/
	@RequestMapping(value = "/back/gethouseqiuzu")
	@ResponseBody
	public ResultMap gethouseqiuzu(String userids,String housestatus ,@RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "7")int pagesize) {
		String [] houses_tatus = null;
		if ("9".equals(housestatus)) {
			houses_tatus = new String []{"1","2","3","4","0"};
		}else {
			houses_tatus = housestatus.split(",");
		}
		if (userids == null || "".equals(userids)) {
			return ResultMap.build(400, "请先选择需要查看的用户");
		}
		String[] ids = userids.split(",");
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = accessService.gethouseqiuzuCount(ids,houses_tatus);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		List<UserCustomer> users = accessService.gethouseqiuzu(ids,houses_tatus,pagequery);
		//设置出租状态
		sethouseqiuzustate(users);
		map.put("qiuzu", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	private void sethouseqiuzustate(List<UserCustomer> users) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (UserCustomer user :users) {
			if (user.getUpdate_time() !=null) {
				String formtime = simpleDateFormat.format(user.getUpdate_time());
				user.setFormtime(formtime);
			}
			if ("0".equals(user.getHousestatus())) {
				user.setHousestatus("冻结");
			}
			else if ("1".equals(user.getHousestatus())) {
				user.setHousestatus("上架");
			}
			else if ("2".equals(user.getHousestatus())) {
				user.setHousestatus("下架");
			}else {
				user.setHousestatus("冻结");
			}
		}
		
	}

	/**查询管理员对应用户下房源记录
	 * @param userids : 用户ID集合
	 * @param housestatus : 房源状态码
	 * ***/ 
	@RequestMapping(value = "/back/gethousefabu")
	@ResponseBody
	public ResultMap gethousefabu(String userids,String housestatus, @RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "7")int pagesize) {
		String [] houses_tatus = null;
		if ("9".equals(housestatus)) {
			houses_tatus = new String []{"1","2","3","4","0"};
		}else {
			houses_tatus = housestatus.split(",");
		}
		if (userids == null || "".equals(userids)) {
			return ResultMap.build(400, "请先选择需要查看的用户");
		}
		String[] ids = userids.split(",");
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = accessService.gethousefabuCount(ids,houses_tatus);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		List<UserCustomer> users = accessService.gethousefabu(ids,houses_tatus,pagequery);
		//设置出租状态
		sethousestate(users);
		map.put("fangyuan", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	private void sethousestate(List<UserCustomer> users) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (UserCustomer user :users) {
			if (user.getUpdate_time() !=null) {
				String formtime = simpleDateFormat.format(user.getUpdate_time());
				user.setFormtime(formtime);
			}
			if ("1".equals(user.getHousestatus())) {
				user.setHousestatus("未租");
			}
			else if ("2".equals(user.getHousestatus())) {
				user.setHousestatus("已租");
			}
			else if ("3".equals(user.getHousestatus())) {
				user.setHousestatus("移除");
			}else {
				user.setHousestatus("冻结");
			}
		}
	}
	
	
	/**
	 * 导入历史excle
	 * @param userid : 用户ID
	 * @param historyexcleurl : EXCLE 文件路径
	 * **/
	@RequestMapping("/back/excleurladd")
	@ResponseBody
	public ResultMap excleurladd (Historyexcle historyexcle) {
		if (historyexcle.getUserid() == null) {
			return null;
		}
		if (historyexcle.getHistoryexcleurl()==null || "".equals(historyexcle.getHistoryexcleurl())) {
			return null;
		}
		historyexcle.setUpdate_time(new Date());
		accessService.excleurladd(historyexcle);
		return ResultMap.IS_200();
	}
	
	
	/**根据userid查出历史导出记录
	 * @param userid : 当前的用户ID
	 * **/
	@RequestMapping("/back/getexclebyuserid")
	@ResponseBody
	public ResultMap getexclebyuserid (UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "7")int pagesize) {
		if (userVo.getUserid() == null) { return ResultMap.build(404, "请先登录"); }
		Map<String,Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = accessService.getexclebyuseridCount(userVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<Historyexcle> historyexcles = accessService.getexclebyuserid(userVo);
		//判断文件是否出自
		CheckFIleExist(historyexcles);
		map.put("pagequery", pagequery);
		map.put("historyexcles", historyexcles);
		return ResultMap.IS_200(map);
	}
	
	private void CheckFIleExist(List<Historyexcle> historyexcles) {
		for (Historyexcle his :historyexcles ) {
			String url = his.getHistoryexcleurl();
			url =url.substring(url.lastIndexOf("/"))		;
			String filepath = "/root/apache-tomcat-7.0.79/webapps/upload/hisexcle"+url;
			File f =new File(filepath);
			if (!f.exists()) {
				his.setDescname(his.getDescname()+"[已被销毁]");
			}
		}
	}

	/**根据id编辑EXCLE
	 * @param historyexclid : excle 主键
	 * @param descname : 描述
	 * **/
	@RequestMapping("/back/updatexclebyid")
	@ResponseBody
	public ResultMap updatexclebyid (Historyexcle historyexcle) {
		if (historyexcle.getHistoryexclid() == null) {
			return ResultMap.build(404, "主键");
		}
		if ("".equals(historyexcle.getDescname()) || historyexcle.getDescname()==null) {
			return  ResultMap.build(404, "秒");
		}
		accessService.updatexclebyid(historyexcle);
		return ResultMap.IS_200();
	}
	
	/**  根据id删除EXCLE
	 * @param historyexcleid : EXCLE ID
	 * **/
	@RequestMapping("/back/deletexclebyid")
	@ResponseBody
	public ResultMap deletexclebyid (Historyexcle historyexcle) {
		if (historyexcle.getHistoryexclid() == null) {
			return ResultMap.build(404, "主键");
		}
		Historyexcle search = accessService.getExclebyeid(historyexcle);
		String filename = search.getHistoryexcleurl().substring(search.getHistoryexcleurl().lastIndexOf("/"));
		String filepath = "/root/apache-tomcat-7.0.79/webapps/upload/hisexcle"+filename;
		File deletefilepath = new File(filepath);
		if (deletefilepath.exists()) {
			deletefilepath.delete();
		}
		accessService.deleteExclebyID(historyexcle);
		return ResultMap.IS_200();
	}
	
	/*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public ResultMap  fileUpload2(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
    	String newName = IDUtils.genItemId();
    	String oleName = file.getOriginalFilename();
    	oleName = oleName.substring(oleName.lastIndexOf("."),oleName.length() );
    	newName = newName + oleName;
    	String filePath = request.getSession().getServletContext().getRealPath("/")+"landlordpicture/"+newName;
		filePath = filePath.replace("/Tenement", "");
        File newFile=new File(filePath);
        file.transferTo(newFile);
        String returnstr = "https//www.zzw777.com/landlordpicture/"+ newName;
        return ResultMap.IS_200(returnstr);
    }
    
    
    @ResponseBody
    @RequestMapping("/back/deletemanageruser")
    public ResultMap deltemanageruser (String userid_deleteid) {
    	if (userid_deleteid == null || userid_deleteid== "") {return ResultMap.build(400,"参数错误");}
    	String deleteid = userid_deleteid.split("_")[1];
    	Long userid = Long.valueOf(userid_deleteid.split("_")[0]);
    	if (deleteid == null || deleteid == "") {return ResultMap.build(400, "请选择删除的用户");}
    	if (userid == null) {return ResultMap.build(400, "请选择管理");}
    	accessService.deletemanageruser(deleteid , userid);
    	return ResultMap.IS_200();
    }
    
    //查看金币是否足够
   @ResponseBody
   @RequestMapping("/search/isflag")
   public ResultMap searchdelete (Long commonid , Long userid) {
	   boolean flag = inteService.searchdelete(commonid, userid) ; 
	   return ResultMap.IS_200(flag);
   }
   
   @ResponseBody
   @RequestMapping("/share/addjinbi")
   public ResultMap shareaddjinbi (Long userid) {
	   
	  ResultMap resultmap =  inteService.shareaddjinbi(userid ,userid);
	  return resultmap;
   }
    
   // 查询金币总配置
   @ResponseBody
   @RequestMapping("/back/searchcommoninte")
   public ResultMap searchcommoninte () {
	  ResultMap resultmap =  accessService.searchcommoninte();
	  return resultmap;
   }
   
   // 根据金币ID查询金币配置
   @ResponseBody
   @RequestMapping("/back/searchbycommonid")
   public ResultMap searchbycommonid (Long commonid) {
	   Commoninte search = accessService.searchbycommonid(commonid);
	   return ResultMap.IS_200(search);
   }
   
   //修改金币配置
   @ResponseBody
   @RequestMapping("/back/commoninteupdate")
   public ResultMap commoninteupdate (Commoninte comm) {
	   
	  
	   accessService.commoninteupdate(comm);
	   return ResultMap.IS_200();
   }
    
   
	/***
	 * 查询佣金100%
	 * */
	@RequestMapping("/back/searpercent")
	@ResponseBody
	public ResultMap searchpercent (Integer type) {
		
		List<Percent> list = accessService.searchpercent (type); 
		
		return ResultMap.IS_200(list);
	}
	
	/**
	 * 查询百分比类型
	 * **/
	@RequestMapping("/back/searchpercenttype")
	@ResponseBody
	public ResultMap searchpercenttype () {
		List<Percenttype> list = accessService.searchpercenttype();
		return ResultMap.IS_200(list);
	}
	
	/**
	 * 添加百分比
	 * **/
	@RequestMapping("/back/addpercent")
	@ResponseBody
	public ResultMap addpercent (int type , double percentnum) {
		if ( type < 0 ) {return ResultMap.build(400, "输入参数类型");}
		if (percentnum < 0 || percentnum >1) {return ResultMap.build(400, "输入正确为 0-100");}
		Percent check = accessService.checkpercent( type ,  percentnum);
		if (check !=null) {return ResultMap.build(400,"勿重复输入");}
		accessService.addpercent( type  , percentnum);
		return ResultMap.build(200, "添加成功");
	}
	
	/**
	 * 删除百分比
	 * **/
	@RequestMapping("/back/deletepercent")
	@ResponseBody                        
	public ResultMap deletepercent (Long percentid) {
		accessService.deletepercent(percentid);
		return ResultMap.IS_200();
	}
	
	
	// 导出用户发布求租excle
	@RequestMapping("/back/exportexclebuildnguser")
	@ResponseBody
	public ResultMap exportexclebuildnguser(String code ) throws Exception {
		
		String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/hisexcle/";
		filePath = filePath.replace("/Tenement", "");
		String filePrefix = "building_user";
		int flushRows = 100;
		List<UserCustomer> buildingCustomers = villageService.censusbuilding(code);
		//var nowlinknout = value.bcount - value.nowlinkcount;
		//var nowlandnout = value.bcount - value.nowlandcount;
		//var linknout = value.tcount - value.linkcount;
		//var landnout = value.tcount - value.landcount;
		
		for (UserCustomer user : buildingCustomers) {
			user.setNowlinknout(user.getBcount() - user.getNowlinkcount());
			user.setNowlandnout(user.getBcount() - user.getNowlandcount());
			user.setLinknout(user.getTcount() - user.getLinkcount());
			user.setLandnout(user.getTcount() - user.getLandcount());
		}
		
		
		List<String> fieldCodes = getbuildinguser_fieldCodes();
		List<String> fieldNames = getbuildinguser_fieldNames();
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/", filePrefix, fieldNames,
				fieldCodes, flushRows);
		excelExportSXXSSF.writeDatasByObject(buildingCustomers);
		String webpath = excelExportSXXSSF.exportFile();
		String returnpath = "https://www.zzw777.com/upload/hisexcle"+webpath;
		return ResultMap.IS_200(returnpath);
	}

	private List<String> getbuildinguser_fieldCodes() {
		List<String> filedCodes = new ArrayList<String>();
		filedCodes.add("userid");
		filedCodes.add("user_name");
		filedCodes.add("telephone");
		filedCodes.add("bcount");
		filedCodes.add("nowlinkcount");
		filedCodes.add("nowlinknout");
		filedCodes.add("nowlandcount");
		filedCodes.add("nowlandnout");
		filedCodes.add("tcount");
		filedCodes.add("linkcount");
		filedCodes.add("linknout");
		filedCodes.add("landcount");
		filedCodes.add("landnout");
		return filedCodes;
	}

	private List<String> getbuildinguser_fieldNames() {
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("用户ID");
		fieldNames.add("用户昵称");
		fieldNames.add("电话号码");
		fieldNames.add("本月总数");
		fieldNames.add("本月有联系电话");
		fieldNames.add("本月无联系电话");
		fieldNames.add("本月有房东电话");
		fieldNames.add("本月无房东电话");
		fieldNames.add("总计");
		fieldNames.add("总计有联系电话");
		fieldNames.add("总计无联系电话");
		fieldNames.add("总计有房东电话");
		fieldNames.add("总计无房东电话");
		return fieldNames;
	}
	
	
	// 更新网易云TOKEN
	@RequestMapping("/updatewangyitoken")
	@ResponseBody
	public ResultMap updatewangyitoken ()  {
		List<User> list = userService.searchalluser();
	//	int inde = 1;
		for (User user : list) {
			try {
				String acctoken = WangYiUtil.updatetoken(user.getUserid());
				if (acctoken !="" && acctoken !=null) {
					user.setAcctoken(acctoken);
				//	inde++;
					userService.updateUserByUserId(user);
				}
			} catch (Exception e) {
			}
			
		}
		return ResultMap.IS_200();
		
	}
	
	/**编辑图片**/
	@RequestMapping("/updatepic111")
	@ResponseBody
	public ResultMap updatepic (Long start , Long end) {
		return accessService.updatepic(start , end);
	}
	
	/**查询所有房东表数据**/
	@ResponseBody
	@RequestMapping("/landloadsearch")
	public ResultMap landloadsearch ( @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "7") int pagesize ,String landstate) {
		PageQuery pagequery = new PageQuery();
		int infoCount = landLordService.landloadsearchCount(landstate);
		pagequery.setPageParams(infoCount, pagesize,Integer.parseInt(currentpage) );
		List<LandlordCustomer> list = landLordService.landloadsearch(pagequery , landstate);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("landlist", list);
		return ResultMap.IS_200(map);
	}
	
	
	/**查询所有房东表数据**/
	@ResponseBody
	@RequestMapping("/landloadsearchdetail")
	public ResultMap landloadsearchdetail (Long userid) {
		LandlordCustomer list = landLordService.landloadsearchdetail(userid);
		return ResultMap.IS_200(list);
	}
	
	/**修改房东状态**/
	@RequestMapping("/checklandstate")
	@ResponseBody
	public ResultMap checklandstate(@RequestParam(name = "updateid")Long userid ,int state) {
		ResultMap retuslt = landLordService.checklandstate(userid,state);
		return retuslt; 
	}
	
	
	
	/**删除角色**/
	@RequestMapping("/back/deleterole")
	@ResponseBody
	public ResultMap deleterole (Long userroleid) {
		return accessService.deleterole(userroleid);
	}
	
	
	
	/**  编辑 房东 的基本信息 **/
	@RequestMapping("/back/updateland")
	@ResponseBody
	public ResultMap updateland (Landlord landlord) {
		return accessService.updateland(landlord);
	}
	
	
	
	/**  删除房东 **/
	@RequestMapping("/back/deletelandlord")
	@ResponseBody
	public ResultMap deletelandlord (Long landuserid) {
		return accessService.deletelandlord(landuserid);
	}
	
	
	
	/**  查询所有房东金币百分比 **/
	@RequestMapping("/back/defaultPercentList")
	@ResponseBody
	public ResultMap defaultPercentList ( ) {
		return accessService.defaultPercentList();
	}
	
	
	/**  查询所有房东金币百分比 **/
	@RequestMapping("/back/onedefaultPercent")
	@ResponseBody
	public ResultMap onedefaultPercent (int id ) {
		return accessService.onedefaultPercent(id);
	}
	
	
	/**  查询所有房东金币百分比 **/
	@RequestMapping("/back/updatefaultPercent")
	@ResponseBody
	public ResultMap updatefaultPercent (Defaultpercent defaultPercent) {
		
		if (defaultPercent.getCentnum() > 1
				|| defaultPercent.getCentnum() < 0) {
			return ResultMap.build(400, "必须在 0 -  1  之间");
		}
		
		 accessService.updatefaultPercent(defaultPercent);
		 return ResultMap.IS_200();
	}
	
	
	
    
}
