package cn.com.qcc.tenement.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import WangYiUtil.WangYiPoJo;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.detailcommon.Sha1;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Housepaydetail;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.Rongconn;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Userconn;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.CheckCodeService;
import cn.com.qcc.service.FansService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.MessagesService;
import cn.com.qcc.service.QiuzuService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;
import cn.com.qcc.service.ZanService;
import cn.com.qcc.service.impl.UserServiceImpl;
import sun.misc.BASE64Decoder;

@SuppressWarnings({ "rawtypes", "unchecked", "deprecation", "restriction" })
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	ZanService zanService;
	@Autowired
	FansService fansService;
	@Autowired
	MessagesService messagesService;
	@Autowired
	BrowseService browseService;
	@Autowired
	VillageService villageService;
	@Autowired
	QiuzuService qiuzuService;
	@Autowired
	BrokerMapper brokerMapper;
	@Autowired
	InteService inteService;
	@Autowired
	CheckCodeService checkCodeService;
	
	
	/**
	 * 校验用户是否符合提现规格
	 * */
	@RequestMapping("/checkmackpartner")
	@ResponseBody
	public ResultMap checkmackpartner(Long userid ) {
		if (userid == null ) {return ResultMap.build(404, "请先登录");}
		UserCustomer userCustomer = userService.checkcash(userid);
		if (userCustomer == null) {return ResultMap.build(405, "未知用户");};
		
		// 为了账号安全需要置空账号信息
		if (CheckDataUtil.checkNotEmpty(userCustomer.getPassword())) 
			userCustomer.setPassword("111111");
		if (CheckDataUtil.checkNotEmpty(userCustomer.getWeixinaccount())) 
			userCustomer.setWeixinaccount("111111");
		if (CheckDataUtil.checkNotEmpty(userCustomer.getUnionid())) 
			userCustomer.setUnionid("111111");
		// 如果有一个条件不成立
		if (CheckDataUtil.checkisEmpty(userCustomer.getPassword())
				|| CheckDataUtil.checkisEmpty( userCustomer.getWeixinaccount() )
				|| CheckDataUtil.checkisEmpty(userCustomer.getUnionid())
				|| CheckDataUtil.checkNotEqual(userCustomer.getSignstate(), 2)) {
			return ResultMap.build(407,"部分参数不符合提现条件" ,userCustomer);
		}
		return ResultMap.IS_200(userCustomer);
	}
	
	
	

	/**
	 * 用户注册
	 * @param session
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	@RequestMapping(value = "/user/register")
	public @ResponseBody ResultMap userReg(HttpSession session, User user, HttpServletRequest request,
			HttpServletResponse Response) throws NumberFormatException, IOException {
		
		
		// 用来生成accesstoken
		UUID uuid1 = UUID.randomUUID();
		String tel_code = request.getParameter("tel_code");
		tel_code = getFromBASE64(tel_code);
		String password = request.getParameter("password");
		
		// 校验验证码是否正确
		ResultMap resultMap = checkCodeService.DoCheckPhoneCode(tel_code, 
				Long.valueOf(request.getParameter("telephone")));
		if (resultMap.getCode() !=200) 
			return resultMap;
		user.setAccestoken(String.valueOf(uuid1));
		user.setTelephone(Long.valueOf(request.getParameter("telephone")));
		String password1 = getFromBASE64(password);
		String str1 = Sha1.getSha1(password1 + "_zf");
		user.setCreate_time(new Date());
		user.setUpdate_time(new Date());
		user.setPassword(str1);
		user.setUsertype("0");
		user.setUserstatus("1");
		user.setLatitude(22.0);
		user.setLongitude(114.0);
		user.setTelephone(Long.valueOf(request.getParameter("telephone")));
		// uService.userReg(user);

		// 设置用户名
		String tel = request.getParameter("telephone");
		String subtext = tel.substring(7, 11);
		// profile的插入userid tel

		Profile profile = new Profile();
		profile.setCreate_time(new Date());
		profile.setSign_time(new Date());
		profile.setSignstate(1);
		profile.setUser_name("zzw_" + subtext);
		profile.setAvatar("http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
		profile.setMail("163.com");
		profile.setSex("未知");
		

		Map<String, Object> map = new HashMap<String, Object>();
		resultMap = userService.userReg(user, profile);
		if (resultMap.getCode() == 200) {
			map.put("userId", resultMap.getObj());
			map.put("accessToken", uuid1);
			return ResultMap.build(200, "注册成功，即将跳转至主界面", map);
		}
		return resultMap;
	}

	/**
	 * 用户通过短信验证码登录
	 * @param telephone : 电话号码
	 * @param tel_code : 验证码
	 * 
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/user/loginByMessage")
	@ResponseBody
	public ResultMap userLogin(HttpSession session, Long telephone, String unionid, String openname,String tel_code,
	@RequestParam(defaultValue="0")Double latitude , String city ,
	@RequestParam(defaultValue="0")Double longitude ,	
	String openavatar, Long userid, HttpServletResponse response, String obj ,HttpServletRequest request) throws Exception {
		UUID uuid = UUID.randomUUID();
		
		ResultMap resultMap = checkCodeService.DoCheckPhoneCode(tel_code, telephone);
		if (resultMap.getCode() !=200) 
			return resultMap;
		
		
		String acctoken = "";
		User user = new User();
		user.setLatitude(latitude);
		user.setLongitude(longitude);
		user.setAccestoken(String.valueOf(uuid));
		user.setTelephone(telephone);
		resultMap = userService.codeLogin(user);
		user = (User) resultMap.getObj();
		if (resultMap.getCode() != 200) {
			return resultMap;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		//String cookieValue = "";
		if (user == null) {
			// 说明用户没有注册 -- 走注册流程 ---
			user = new User();
			user.setCreate_time(new Date());
			user.setUpdate_time(new Date());
			user.setPassword("4d76087378d5f71bd9f994668e342e92e7894d80");
			user.setUsertype("0");
			//cookieValue = String.valueOf(uuid);
			user.setAccestoken(String.valueOf(uuid));
			user.setTelephone(telephone);
			user.setUserstatus("1");
			user.setLatitude(latitude);
			user.setLongitude(longitude);
			user.setTelephone(telephone);
			String subtext = (telephone + "").substring(7, 11);
			Profile profile = new Profile();
			profile.setCreate_time(new Date());
			profile.setSign_time(new Date());
			Long citycode = villageService.getcodebycity(city);
			profile.setCode(citycode);
			profile.setSignstate(1);
			profile.setUser_name("qcc_" + subtext);
			profile.setAvatar("http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
			profile.setSex("未知");
			resultMap = userService.userReg(user, profile);
			Long userId = (Long) resultMap.getObj();
			String token = userService.addRongToken(userId, "z" + userId,
					"http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
			map.put("token", token);
			map.put("accessToken", uuid);
			map.put("lat", user.getLatitude());
			map.put("userId", userId);
			map.put("log", user.getLongitude());
			SendMessage.passwordrelive(telephone, request);
			// 这里是网易云TOKEN验证
			if (user.getAcctoken() != null && !"".equals(user.getAcctoken())) {
				acctoken = user.getAcctoken();
			} else {
				Map<String, Object> returnmap = WangYiUtil.getACCIDANDTOKEN(userId, "qcc_" + subtext,
						profile.getAvatar());
				if (returnmap.get("code").equals(200)) {
					String ssobj = returnmap.get("info").toString();
					net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(ssobj);
					WangYiPoJo wpojo = (WangYiPoJo) jsonobj.toBean(jsonobj, WangYiPoJo.class);
					acctoken = wpojo.getToken();
					user.setAcctoken(acctoken);
					userService.updateUserByUserId(user);
				}
			}
			map.put("acctoken", acctoken);

			// 这里是插入求租
			if (!"".equals(obj) && obj != null && !"".equals(obj)) {

				net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(obj);
				QiuzuCustomer qiuzuCustomer = (QiuzuCustomer) jsonobj.toBean(jsonobj, QiuzuCustomer.class);
				Detaileaddress detaileaddress = new Detaileaddress();
				detaileaddress.setDetailes(qiuzuCustomer.getDetailes());
				detaileaddress.setLatitude( new BigDecimal(qiuzuCustomer.getLatitude()) );
				detaileaddress.setLongitude( new BigDecimal(qiuzuCustomer.getLongitude()) );
				qiuzuCustomer.setUser_id(userId);
				Qiuzu qiuzu = setqiuzudetail(qiuzuCustomer);
				qiuzuService.insertorupdateqiuzu(qiuzu, detaileaddress);
			}
			map.put("vipcount", 10);

			// 建立推荐人和新用户的关系
			Map<String,Object> searchmap = userService.addconnectionlevel(userid, userId);
			// 如果是推荐人推荐过来的
			if ("new".equals(searchmap.get("mess"))) {
				inteService.managebranch(15L, userid ,userid );
			}
			if ("erjinew".equals(searchmap.get("mess"))) {
				inteService.managebranch(15L, userid ,userid);  //先建立一级用户收益
				// 获取上一级userid
				Long leveluserid = (Long)searchmap.get("userid");
				inteService.managebranch(16L, leveluserid , userid);  //先建立一级用户收益
			}
			return ResultMap.IS_200(map);
		} else {
			// 这里是网易云TOKEN验证
			//cookieValue = user.getAccestoken();
			if (user.getAcctoken() != null && !"".equals(user.getAcctoken())) {
				acctoken = user.getAcctoken();
			} else {
				UserCustomer userCustomer = userService.getUserAndProfile(user.getUserid());
				Map<String, Object> returnmap = WangYiUtil.getACCIDANDTOKEN(userCustomer.getUserid(),
						userCustomer.getUser_name(), userCustomer.getAvatar());
				if (returnmap.get("code").equals(200)) {
					String ssobj = returnmap.get("info").toString();
					net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(ssobj);
					WangYiPoJo wpojo = (WangYiPoJo) jsonobj.toBean(jsonobj, WangYiPoJo.class);
					acctoken = wpojo.getToken();
					user.setAcctoken(acctoken);
					userService.updateUserByUserId(user);
				}
			}
			map.put("acctoken", acctoken);
			// 这里是设置融云TOKEN后续删除。
			if (user.getToken() != null && !"".equals(user.getToken())) {
				map.put("token", user.getToken());
			} else {
				String token = userService.addRongToken(user.getUserid(), "z" + user.getUserid(),
						"http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
				map.put("token", token);
			}
			map.put("userId", user.getUserid());
			// 登录成功后user存入session
			map.put("accessToken", uuid);
			map.put("lat", user.getLatitude());
			map.put("log", user.getLongitude());
			// 这里是插入求租
			if (!"".equals(obj) && obj != null) {
				net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(obj);
				QiuzuCustomer qiuzuCustomer = (QiuzuCustomer) jsonobj.toBean(jsonobj, QiuzuCustomer.class);
				Detaileaddress detaileaddress = new Detaileaddress();
				detaileaddress.setDetailes(qiuzuCustomer.getDetailes());
				detaileaddress.setLatitude( new BigDecimal(qiuzuCustomer.getLatitude())  );
				detaileaddress.setLongitude(new BigDecimal(qiuzuCustomer.getLongitude()) );
				Qiuzu qiuzu = new Qiuzu();
				qiuzu.setCaption(qiuzuCustomer.getCaption());
				qiuzu.setUser_id(user.getUserid());
				qiuzu.setClassification(qiuzuCustomer.getClassification());
				qiuzu.setMetroid(qiuzuCustomer.getMetroid());
				qiuzu.setAreas(qiuzuCustomer.getAreas());
				qiuzu.setPhone(qiuzuCustomer.getPhone());
				qiuzu.setLinkman(qiuzuCustomer.getLinkman());
				qiuzu.setDescribes(qiuzuCustomer.getDescribes());
				qiuzu.setLinkman(qiuzuCustomer.getLinkman());
				qiuzu.setCode(qiuzuCustomer.getCode());
				qiuzu.setPrice(qiuzuCustomer.getPrice());
				qiuzu.setPicture(qiuzuCustomer.getPicture());
				qiuzu.setHousetype(qiuzuCustomer.getHousetype());
				qiuzu.setUpdate_time(new Date());
				qiuzuService.insertorupdateqiuzu(qiuzu, detaileaddress);
			}
			Profile profile = new Profile();
			/*if (unionid !=null && !"".equals(unionid)) {
				profile.setOpenid(unionid);
			}*/
			profile.setUser_id(user.getUserid());
			if (!"".equals(openname) && openname != null) {
				profile.setAvatar(openavatar);
				profile.setUser_name(openname);
				UserCustomer user_search = userService.getUserAndProfile(user.getUserid());
				// 如果用户头像不一致时候需要同步索引库的信息
				if (!openavatar.equals(user_search.getAvatar()) ) {
					// 先删除已经有的数据
					//qiuzuService.delete_qiuzubyuserid(user_search.getUserid());
					// 在同步数据
					//qiuzuService.myqiuzu_addtosolr(user_search.getUserid(), openavatar);
				}
				userService.updateweixinmess(profile);
			}
			return ResultMap.build(200, "登录成功", map);
		}

	}

	private Qiuzu setqiuzudetail(QiuzuCustomer qiuzuCustomer) {
		Qiuzu qiuzu = new Qiuzu();
		qiuzu.setCaption(qiuzuCustomer.getCaption()==null? "":qiuzuCustomer.getCaption());
		qiuzu.setUser_id(qiuzuCustomer.getUser_id());
		qiuzu.setClassification(qiuzuCustomer.getClassification()==null?"":qiuzuCustomer.getClassification());
		if (qiuzuCustomer.getMetroid() !=null) {qiuzu.setMetroid(qiuzuCustomer.getMetroid());}
		qiuzu.setAreas(qiuzuCustomer.getAreas()==null?11.0:qiuzuCustomer.getAreas());
		qiuzu.setDescribes(qiuzuCustomer.getDescribes()==null?"":qiuzuCustomer.getDescribes());
		qiuzu.setLinkman(qiuzuCustomer.getLinkman()==null?"":qiuzuCustomer.getLinkman());
		qiuzu.setCode(qiuzuCustomer.getCode()==null ?"":qiuzuCustomer.getCode());
		qiuzu.setPrice(qiuzuCustomer.getPrice()==null?"":qiuzuCustomer.getPrice());
		qiuzu.setPicture(qiuzuCustomer.getPicture()==null ?"":qiuzuCustomer.getPicture());
		qiuzu.setHousetype(qiuzuCustomer.getHousetype()==null?"":qiuzuCustomer.getHousetype());
		qiuzu.setUpdate_time(new Date());
		return qiuzu;
	}

	/**
	 * 用户通过密码登录
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/user/loginByPwd")
	@ResponseBody
	public ResultMap userLoginByPwd(HttpServletRequest request, HttpServletResponse response, String password,
			Long telephone) throws Exception {
		//UUID uuid = UUID.randomUUID();

		// Base64解密
		String password1 = getFromBASE64(password);
		// Sha1加密
		String str1 = Sha1.getSha1(password1 + "_zf");

		Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setTelephone(telephone);
		User user1 = userService.loginByPwd(user);
		if (user1 != null) {
			if (str1.equals(user1.getPassword())) {

				if (user1.getToken() != null && !"".equals(user1.getToken())) {
					map.put("token", user1.getToken());
				} else {
					String token = userService.addRongToken(user1.getUserid(), "z" + user1.getUserid(),
							"http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
					map.put("token", token);
				}
				map.put("userId", user1.getUserid());
				map.put("accesToken", user1.getAccestoken());
				map.put("lat", user1.getLatitude());
				map.put("log", user1.getLongitude());
				return ResultMap.build(200, "登录成功", map);
			} else {
				return ResultMap.build(400, "用户名或者密码错误");
			}

		} else {
			return ResultMap.build(400, "用户名或者密码错误");
		}

	}

	/**
	 * 通过手机号找回密码
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/user/findPwd")
	public @ResponseBody Map<String, Object> findPwd(HttpSession session, HttpServletRequest request,
			HttpServletResponse Response) {
		String tel_code = request.getParameter("tel_code");
		String password = request.getParameter("password");
		Long telephone = Long.valueOf(request.getParameter("telephone"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		ResultMap resultMap = checkCodeService.DoCheckPhoneCode(tel_code, telephone);
		if (resultMap.getCode() !=200) {
			map.put("code", 400);
			map.put("msg", "失败");
			return map;
			
		}
		
		// 解密
		String password1 = getFromBASE64(password);
		String str1 = Sha1.getSha1(password1 + "_zf");
		
		try {
			User user = new User();
			user.setTelephone(telephone);
			user.setPassword(str1);
			session.removeAttribute("code");
			resultMap = userService.findPwdByTel(user);
			if (resultMap.getCode() == 200) {
				map.put("code", 200);
				map.put("msg", "成功");
			}
		} catch (Exception e) {
			map.put("code", 400);
			map.put("msg", "失败");
		}

		return map;
	}

	/**
	 * 通过tel查看用户
	 * 
	 * @param house
	 * @param model
	 * @param request
	 * @param Response
	 * @return,produces="text/html;charset=utf-8"
	 */
	@RequestMapping(value = "/user/getUserInfoByTel")
	@ResponseBody
	public ResultMap getUserInfoByTel(Model model, HttpServletRequest request, HttpServletResponse Response,
			@RequestParam(value = "telephone", required = false) Long telephone) {
		// Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setTelephone(telephone);
		User user1 = userService.getUserInfoByTel(user);
		return ResultMap.IS_200(user1);
	}

	/**
	 * 通过userid返回用户信息
	 * 
	 */
	@RequestMapping(value = "/user/getUserInfoByUserid")
	@ResponseBody
	public ResultMap getUserInfoByUserid(Model model, HttpServletRequest request, HttpServletResponse Response,
			@RequestParam(value = "userid", required = false) Long userid) {
		User user1 = userService.getUserByUserid(userid);
		Map map = new HashMap<>();
		String codes = "no";
		Broker broker = brokerMapper.selectByPrimaryKey(userid);
		if (broker.getCodes() == null) {
			codes = "";
		}
		codes = broker.getCodes();
		map.put("user1", user1);
		map.put("codes", codes);
		return ResultMap.IS_200(map);
	}

	/**
	 * 用户在个人中心修改密码
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/user/updatePwd")
	public @ResponseBody ResultMap updateUserPwd(@RequestParam(value = "userid", required = false) Long userid,
			@RequestParam(value = "password1", required = false) String password1, // 原密码
			@RequestParam(value = "password2", required = false) String password2, // 新密码
			HttpServletRequest request, HttpServletResponse Response) {
		String pwdOld = getFromBASE64(password1);
		// String
		// str=pwdOld.substring(pwdOld.indexOf("_")+1,pwdOld.length());
		// 原密码Sha1加密
		String str1 = Sha1.getSha1(pwdOld + "_zf");
		// 新密码解密
		String pwdNew = getFromBASE64(password2);
		// String
		// str2=pwdNew.substring(pwdNew.indexOf("_")+1,pwdNew.length());
		// 新密码Sha1加密
		String str3 = Sha1.getSha1(pwdNew + "_zf");
		// 查找用户原密码
		ResultMap resultMap = userService.updatePwd(userid, str3, str1);

		return resultMap;
	}

	/**
	 * 换绑手机号
	 * 
	 * @param userid
	 * @param telephone
	 * @param tel_code
	 * @param request
	 * @param Response
	 * @return
	 */
	@RequestMapping(value = "/user/updateTel")
	public @ResponseBody Map<String, Object> updateTel(HttpSession session,
			@RequestParam(value = "userid", required = false) Long userid,
			@RequestParam(value = "telephone", required = false) Long telephone, // 新手机号
			@RequestParam(value = "tel_code", required = false) String tel_code, // 手机验证码
			HttpServletRequest request, HttpServletResponse Response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// String code2=request.getParameter("code1");
		String msg = "成功";
		try {
			//String code1 = getFromBASE64(tel_code);
			UserService uService = new UserServiceImpl();
			User user = new User();

			session.removeAttribute("code");
			user.setUserid(userid);
			user.setTelephone(telephone);
			uService.updateTel(user);
		} catch (Exception e) {
			// TODO: handle exception
			msg = "失败";
		}
		map.put("msg", msg);

		return map;
	}

	/**
	 * 我的出租,包括house,address和price
	 * 
	 * @param userid
	 * @param request
	 * @param Response
	 * @return
	 */
	/*
	 * @RequestMapping(value="/user/myHouse") public @ResponseBody JsonModel
	 * myHouse(
	 * 
	 * @RequestParam(value = "userid", required = false) Long userid,
	 * HttpServletRequest request,HttpServletResponse Response ) { logger.info(
	 * "myHouse called.."); JsonModel json=new JsonModel();
	 * 
	 * 
	 * user.setUserid(userid); User user1=userBiz.getUserByUserid1(user);
	 * 
	 * 
	 * Map map=new HashMap(); map.put("user1", user1); json.setObj(map); return
	 * json; }
	 */

	// 将 s 进行 BASE64 编码
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
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
	 * 通过userid返回用户信息
	 */
	@RequestMapping(value = "/user/belogin/getUserInfoByUserid")
	@ResponseBody
	public ResultMap getUserInfoByUserid(Long userid) {
		if (userid == null) {
			return ResultMap.build(400, "当前未登录无法获取用户信息");
		}

		Integer broCount = browseService.count(userid, -1);
		Integer zanCount = zanService.findzanfollowCount(userid);
		Integer followCount = fansService.findFollowCountByUserId(Long.valueOf(userid));
		Integer fansCount = fansService.findFansCountByUserIdandFolllowid(Long.valueOf(userid));
		UserCustomer user = userService.getUserAndProfile(userid);
		Map map = new HashMap();
		Broker broker = brokerMapper.selectByPrimaryKey(userid);
		List<Area> areas = new ArrayList<>();
		if (broker == null) {
		} else {
			if (broker.getCodes() == null) {

			} else {
				String[] code = broker.getCodes().split(",");
				areas = userService.getjiyin(code);
			}
		}
		map.put("jiyin", areas);
		map.put("fansCount", fansCount);
		map.put("broCount", broCount);
		map.put("followCount", followCount);
		map.put("zanCount", zanCount);
		map.put("user", user);
		
		return ResultMap.IS_200(map);
	}
	
	/**根据id查询用户留言列表**/
	@RequestMapping("/fans/commentlist")
	@ResponseBody
	public ResultMap searchcommentList(Long userid , @RequestParam(defaultValue="1")Integer currentpage
	,@RequestParam(defaultValue="8") Integer pagesize) {
		if (CheckDataUtil.checkisEmpty(userid))
			{return ResultMap.build(400,"未知用户");}
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = messagesService.selectCommentCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<UserCustomer> messageList = messagesService.selectComment(userid , pagequery);
		map.put("pagequery",pagequery);
		map.put("messageList", messageList);
		return ResultMap.IS_200(map);
	}

	/**
	 * 通过userid返回用户信息
	 */
	@RequestMapping(value = "/fans/searchUser")
	@ResponseBody
	public ResultMap getsearchUserByUserid(Long userid,@RequestParam(defaultValue="1")Integer currentpage
			,@RequestParam(defaultValue="2")Integer pagesize) {
		
		PageQuery pagequery = new PageQuery();
		int infoCount = messagesService.selectCommentCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<UserCustomer> messageList = messagesService.selectComment(userid , pagequery);
		// 赞的数量
		int zanCount = zanService.findzanfollowCount(userid);
		int followCount = fansService.findFollowCountByUserId(Long.valueOf(userid));
		int fansCount = fansService.findFansCountByUserIdandFolllowid(Long.valueOf(userid));
		UserCustomer user = userService.getUserAndProfile(userid);

		Map map = new HashMap();
		map.put("fansCount", fansCount);
		map.put("followCount", followCount);
		map.put("messageList", messageList);
		map.put("zanCount", zanCount);
		map.put("pagequery", pagequery);
		map.put("user", user);
		return ResultMap.IS_200(map);
	}

	// 查看我的相册
	@RequestMapping("/user/belogin/album")
	@ResponseBody
	public ResultMap getmyalbum(Integer userid ,@RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "8")	int pagesize) {
		if (CheckDataUtil.checkisEmpty(userid)) 
			{ return ResultMap.build(400,"未知用户");}
		
		Map<String, Object> map = new HashMap<>();
		Integer infoCount = userService.singleablumCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		List<HouseCustomer> resultList =userService.singleablum(userid ,pagequery);
		map.put("pagequery", pagequery);
		map.put("detailList", resultList);
		return ResultMap.IS_200(map);
	}

	@RequestMapping("/user/updateUsername")
	@ResponseBody
	public ResultMap updateusername(Long userid, String username) {
		userService.updateUserName(userid, username);
		return ResultMap.IS_200();
	}

	@RequestMapping("/user/updateMail")
	@ResponseBody
	public ResultMap updatemail(Long userid, String mail) {
		userService.updateMail(userid, mail);
		return ResultMap.IS_200();
	}

	// 找房东
	@RequestMapping("/user/findland")
	@ResponseBody
	public ResultMap findland(String city, UserVo userVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {

		// 通过城市获取到code
		Long likecode = null;
		Long citycode = villageService.getcodebycity(city);
		userVo = userVo != null ? userVo : new UserVo();
		VillageCustomer villageCutomer = userVo.getVillageCustomer() != null ? userVo.getVillageCustomer()
				: new VillageCustomer();
		if (villageCutomer.getLikecode() == null) {
			villageCutomer.setLikecode(citycode);
		} else {
			likecode = villageCutomer.getLikecode();
		}
		if (likecode == null) {
			likecode = citycode;
		}
		userVo.setVillageCustomer(villageCutomer);

		Integer infoCount = userService.findlandCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<UserCustomer> landlist = userService.findland(userVo);

		Map<String, Object> map = new HashMap<>();
		map.put("landlist", landlist);
		map.put("citycode", citycode);
		map.put("likecode", likecode);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	// 修改头像
	@ResponseBody
	@RequestMapping("/user/updateAvatar")
	public ResultMap updateAvatar(Long userid, String filePath) {
		ResultMap resultMap = userService.updateAvatat(userid, filePath);
		return resultMap;
	}

	// 当一个用户向一个用户申请添加好友
	@RequestMapping("/userconn/befriend")
	@ResponseBody
	public ResultMap befriend(Userconn userconn) {
		ResultMap resultMap = userService.befriend(userconn);
		return resultMap;
	}

	// 改变用户 的状态 /移除黑名单 / 删除好友 / 拉入黑名单
	@ResponseBody
	@RequestMapping("/userconn/romoveblack")
	public ResultMap romoveblack(Userconn userconn) {
		ResultMap resultMap = userService.romoveblack(userconn);
		return resultMap;
	}

	// <!-- / 查询好友 / 黑名单 / 申请列表-->
	@RequestMapping("/userconn/myfriend")
	@ResponseBody
	public ResultMap myfriend(Userconn userconn) {
		ResultMap resultMap = userService.myfriend(userconn);
		return resultMap;
	}

	// 查询想要加的对象
	@RequestMapping("/userconn/searchadd")
	@ResponseBody
	public ResultMap searchadd(UserCustomer userCustomer) {
		ResultMap resultMap = userService.searchadd(userCustomer);
		return resultMap;
	}

	// 邀请好友入群的查询
	@RequestMapping("/userconn/inviting")
	@ResponseBody
	public ResultMap inviting(Ronggroup ronggroup) {
		if (ronggroup.getUserid() == null) {
			return ResultMap.build(404, "未知登录");
		}
		if (ronggroup.getGroupid() == null) {
			return ResultMap.build(404, "群ID不存在");
		}
		ResultMap resultMap = userService.inviting(ronggroup);
		return resultMap;
	}

	@RequestMapping("/userconn/invitefriend")
	@ResponseBody
	public ResultMap invitefriend(Rongconn conn) {
		ResultMap resultMap = userService.invitefriend(conn);
		return resultMap;
	}

	// 根据code获得小程序的openid
	@SuppressWarnings("resource")
	public List<Object> getweixinuseridbyxiaochengxu(String code) throws IOException {
		String APPID = "wx23f972f59704c2cc";
		String SERRECT = "712263fda38ab9633a50ef4c8cef969b";
		List<Object> list = new ArrayList<Object>();
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SERRECT + "&js_code="
				+ code + "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse res = client.execute(post);
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> jsonOb = mapper.readValue(str, Map.class);
			list.add(jsonOb.get("session_key"));
			list.add(jsonOb.get("openid"));
			list.add(jsonOb.get("unionid"));
		}
		return list;
	}

	@RequestMapping("/user/getopenid")
	@ResponseBody
	public ResultMap getopenid(String opencode ,String type) {
		List<Object> list = null;
		try {
			list = this.getweixinuseridbyxiaochengxu(opencode);
			if ("gzfzz".equals(type)) {
				//list = this.get_gzfzz_weixinuseridbyxiaochengxu(opencode);
			}
			return ResultMap.IS_200(list);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMap.build(400, "获取OPENID失败", null);
		}
	}

	@RequestMapping("/user/updateuser")
	@ResponseBody
	public ResultMap updateuser(UserCustomer userCustomer, String codes,
			HttpServletRequest request ,String mysign) {
		ResultMap result = userService.updateUser(userCustomer, codes, request , mysign);
		return result;
	}

	// 查询网易云类似的用户
	@RequestMapping("/user/likename")
	@ResponseBody
	public ResultMap searchlikename(String likename, String userid) {
		ResultMap result = userService.searchlikename(likename, userid);
		return result;
	}

	// 测试充值收益接口
	@RequestMapping("/user/testshouyi")
	@ResponseBody
	public ResultMap testshouyi(Long userid, Double account) {
		return userService.addinvitebalance(userid, account);
	}

	// 重置VIPcount
	@RequestMapping("/resetvip")
	@ResponseBody
	public ResultMap vipcount() {
		//List<User> user = userService.getall();
		return null;
	}

	// 查询我的团队
	@RequestMapping("/user/myteam")
	@ResponseBody
	public ResultMap myteam(Long userid) {
		Map<String, Object> map  = userService.myteam(userid);
		return ResultMap.IS_200(map);
	}

	// 查询我的团队
	@RequestMapping("/user/myteamson")
	@ResponseBody
	public ResultMap myteamson(UserCustomer userCustomer) {
		List<UserCustomer> USERS = userService.myteamson(userCustomer);
		return ResultMap.IS_200(USERS);
	}

	// 查询我的收益记录
	@RequestMapping("/user/mylurnce")
	@ResponseBody
	public ResultMap mylurnce(UserVo userVo 
			,@RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "100")	int pagesize) {
		if (userVo.getUserid() == null) {
			return ResultMap.build(400, "登录空");
		}
		int infocount = userService.mylurnceCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		Map<String,Object> map = new HashMap<>();
		List<Lucre> USERS = userService.mylurnce(userVo);
		map.put("mylurnce", USERS);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	/***
	 * 查询在线交租记录 
	 * **/
	@RequestMapping("/user/searchHousePayDetailList")
	@ResponseBody
	public ResultMap searchHousePayDetailList(Long userid) {
		
		List<Housepaydetail> details = userService.searchHousePayDetailList(userid);
		
		return ResultMap.IS_200(details);
		
	}


}
