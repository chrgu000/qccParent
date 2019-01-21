package cn.com.qcc.managerclient.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.Maillist;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.queryvo.CentFromCustomer;
import cn.com.qcc.queryvo.MailCustomer;
import cn.com.qcc.queryvo.MailVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.UserService;

@Controller
@RequestMapping("/companion")
public class UserController {
	@Autowired
	UserService userService;

	// 申请成为我们的伙伴
	@RequestMapping("/regiestland")
	@ResponseBody
	public ResultMap regiestland(Landlord landlord, Long telephone) {
		ResultMap resultMap = userService.regiestland(landlord, telephone);
		return resultMap;
	}

	// 通过电话号码和验证码登录伙伴后台
	@RequestMapping("/login")
	@ResponseBody
	public ResultMap loginmanager(Long telephone, String code, HttpServletRequest res) {
		ResultMap resultMap = userService.codeLogin(telephone, code, res);
		return resultMap;
	}

	/*
	 * 发布租约，和登录用户。
	 * 
	 */
	@RequestMapping("/usercent")
	@ResponseBody
	public ResultMap usercent(Usercent usercent,Mycent mycent,HttpServletRequest request,
			String othermore,String payid,String paycentid,String othermoreid1,String othermoreid2,
		String pricestype,String islinecent) {
		ResultMap resultMap = userService.usercent(usercent, mycent, request, othermore,  payid, paycentid, pricestype,othermoreid1,othermoreid2,islinecent);
		return resultMap;
	}
	
	

	/*
	 * 通过租户的电话号码获取租户的真实信息
	 */
	@RequestMapping("/realname")
	@ResponseBody
	public ResultMap getrealnamebyphone(String telephone) {
		ResultMap resultMap = userService.getrealnamebyphone(telephone);
		return resultMap;
	}


	// 移除不敢兴趣的求租
	@RequestMapping("/removenotlike")
	@ResponseBody
	public Map<String, Object> removenotlike(String userid, String msgid, String time) {
		String fromuserid = "10088"; // 10088 代表求租的客服号码
		Map<String, Object> resultmap = userService.removenotlike(userid, msgid, time, fromuserid);
		return resultmap;
	}

	// 移除不敢兴趣的求租
	@RequestMapping("/centfromlist")
	@ResponseBody
	public ResultMap centfromlist(String userid, String msgid, String time) {
		List<CentFromCustomer> centfromlist = userService.centfromlist();
		return ResultMap.IS_200(centfromlist);
	}
	
	//根据租约ID 查询账单列表
	@RequestMapping("/paylistshowbecent")
	@ResponseBody
	public ResultMap paylistshowbecent (Long usercentid) {
		List<UserCentCustomer> list =  userService.paylistshowbecent(usercentid);
		Map<String ,Object> map = new HashMap<>();
		// 去除多余的标题
		Double monery = 0.0;
		Double totalprices = 0.0;
		Double yaprices = 0.0;
		for (int i = 0; i < list.size() - 1; i++) {// 从第一个数开始，到最后一个数-1次循环
			monery += list.get(i).getCentprices();
			totalprices = totalprices +  list.get(i).getCentprices();
			if (list.get(i).getFid() == 6 || list.get(i).getFinanceid() == 6) {
				yaprices = yaprices + list.get(i).getCentprices();
			}
			
			for (int j = list.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long furid1 = list.get(i).getPayexpertid();
				Long furid2 = list.get(j).getPayexpertid();
				Long fruid_end = furid1 - furid2;
				if (fruid_end == 0) { // 表示是同一个其的
					list.get(j).setPayexpertname("");
					list.get(j).setStart_time(null);
					list.get(j).setEnd_time(null);
					list.get(i).setNeedpaytime(null);
					list.get(i).setCurrentprices(null);
				} 
			}
		
		}
		map.put("accountlist", list);
		map.put("totalprices", totalprices);
		map.put("yaprices", yaprices);
		return ResultMap.IS_200(map);
	}
	
	//通过租约编号查询租约基本信息
	@RequestMapping("/usercentdetail")
	@ResponseBody
	public ResultMap usercentdetail (String usercentnum) {
		return  userService.usercentdetail(usercentnum);
	}
	
	@RequestMapping("/financialbycentnum")
	@ResponseBody
	public ResultMap financialbycentnum (String usercentnum) {
		return  userService.financialbycentnum(usercentnum);
	}
	
	//同步通讯录
	@ResponseBody
	@RequestMapping("/syncmail/{userid}")
	public ResultMap syncmail ( @RequestBody List<Maillist> mails ,@PathVariable Long userid) {
		return userService.syncmail (mails ,userid);
	}
	
	@RequestMapping("/mailsbyuserid")
	@ResponseBody
	public ResultMap mailsbyuserid (@RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize,MailVo mailVo) {
		if (mailVo.getUserid() == null) {
			return ResultMap.build(300,"用户ID不存在");
		}
		System.out.println(mailVo.getSearchwhere());
		PageQuery pagequery = new PageQuery();
		int infoCount = userService.mailsbyuseridCount(mailVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		mailVo.setPagequery(pagequery);
		List<MailCustomer> mails =  userService.mailsbyuserid(mailVo);
		Map<String,Object> map = new HashMap<>();
		map.put("mails", mails);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	//查询我的代办
	@RequestMapping("/backlog")
	@ResponseBody
	public ResultMap backlog (UserCentVo userCentVo) {
		if (userCentVo.getUserid() == null) {return ResultMap.build(300,"参数不全");}
		if (userCentVo.getStart() == null) {return ResultMap.build(300, "参数不全");}
		if (userCentVo.getEnd() == null) {return ResultMap.build(300,"参数不全");}
		UserCentCustomer centCustomer = userService.backlog(userCentVo);
		return ResultMap.IS_200(centCustomer);
	}
	
	// 根据当前租约编号查询 续租的租户信息
	@RequestMapping("/xuzusearch")
	@ResponseBody
	public ResultMap xuzusearch (String usercentnum) {
		if (usercentnum == null || "".equals(usercentnum)) {
			return ResultMap.build(300,"租约编号不存在");
		}
		UserCentCustomer userCentCustomer = userService.xuzusearch(usercentnum);
		return ResultMap.IS_200(userCentCustomer);
	}
	
	
	/**
	 * 房东端密码登录
	 */
	@RequestMapping(value = "/loginbyword")
	@ResponseBody
	public ResultMap userLoginByPwd( String password,Long telephone)  {
		if (password == null || "".equals(password)) {return ResultMap.build(400, "输入密码");}
		if (telephone == null) {return ResultMap.build(400, "输入电话");}
		//password = getFromBASE64(password);  //password = Sha1.getSha1(password + "_zf");
		password = IDUtils.getprivatePassword(password);
		// 封装登录信息
		UserCustomer loginuser = userService.getusermessbypassword(telephone);
		// 这里到时候过滤哪些用户不能进...
		if (loginuser == null) {return ResultMap.build(400,"用户名/密码错误");}
		String oraname = loginuser.getPassword();
		if (!password.equals(oraname)) {
			return ResultMap.build(400, "用户名/密码错误");
		}
		loginuser.setPassword("");
		return ResultMap.build(200, "登录成功" , loginuser);
	}
	
	// 修改密码
	@RequestMapping("/changeloginword")
	@ResponseBody
	public ResultMap changepassword (String password,Long telephone ,String code) {
		if (password ==null || "".equals(password)) {return ResultMap.build(400,"输入密码");}
		//password = getFromBASE64(password); password = Sha1.getSha1(password + "_zf");
		password = IDUtils.getprivatePassword(password);
		ResultMap resultMap = userService.changeloginword(password , telephone,code);
		return resultMap;
	}

	

}
