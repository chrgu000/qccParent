package cn.com.qcc.tenement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.ExcelExportSXXSSF;
import cn.com.qcc.pojo.Integral;
import cn.com.qcc.pojo.Masonry;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VipCountService;

@Controller
public class VipCountController {

	@Autowired VipCountService vipCountService;
	@Autowired InteService inteService;
	@Autowired HttpServletRequest request;
	@Autowired UserService userService;
	
	
	/**解绑提现账号**/
	@RequestMapping("/deleteweixinaccount")
	@ResponseBody
	public ResultMap deleteweixinaccount (Long userid) {
		if (userid == null) {return ResultMap.build(400, "未知用户");}
		vipCountService.deleteweixinaccount(userid);
		return ResultMap.build(200, "解绑成功");
	}
	
	

	/**更新用户的提现信息**/
	@RequestMapping("/updatecheckvip")
	@ResponseBody
	public ResultMap updatecheckvip (Long  userid ,String password , String unionid,String confpassword ) {
		Vipcount update = new Vipcount();
		if (userid == null) {return ResultMap.build(400, "输入用户信息");}
		update.setUser_id(userid);
		// 如果设置了密码
		if (password !=null && !"".equals(password)) {
			if (!password.equals(confpassword)) {return ResultMap.build(400, "密码不一致");}
			password = IDUtils.getprivatePassword(password);
			update.setPassword(password);
			vipCountService.updateVipSelective(update);
		}
		if (unionid !=null &&!"".equals(unionid)) {
			
			UserCustomer checkuser = userService.getusermessbyunionid(unionid);
			if (checkuser !=null) {
				// 判断授权没有
				if (checkuser.getWeixinaccount() == null || "".equals(checkuser.getWeixinaccount())) {
					if (!"".equals(password)) {
						return ResultMap.build(407, "请前往公众号平台绑定提现账号");
					} else {
						return ResultMap.build(400, "请设置提现密码");
					}
				}else {
					return ResultMap.build(400, "当前微信已经绑定:"+checkuser.getTelephone()+"为提现账号!");
				}
			}else {
				// 需要把unionid 绑定到用户身上
				User userupdate = new User();
				userupdate.setUnionid(unionid);
				userupdate.setUserid(userid);
				// 这里要先校验unionid 是否已经绑定了user
				userService.updateUserSelective(userupdate);
			}
			return ResultMap.IS_200();
		}
		
		return ResultMap.build(400, "输入请求参数");
		
	}

	
	// 充值VIP时候更新VIP的状态
	public void updateVipStatus(String out_trade_no, String total_amount, HttpServletRequest request) {
		Vipcount vipcount = vipCountService.getVipByUserID(Long.valueOf(out_trade_no));
		if (vipcount != null) {
			// 1表示VIP
			vipcount.setIs_vip(1);
			vipCountService.updateVipSelective(vipcount);
		} else {
			Vipcount vip_new = new Vipcount();
			vip_new.setBalance(0.0);
			vip_new.setUser_id(Long.valueOf(out_trade_no));
			vip_new.setCretime_time(new Date());
			// 设置VIP用户
			vip_new.setIs_vip(1);
			vipCountService.insertVipCount(vip_new);
		}
	};

	// 我的积分消费事件
	@RequestMapping("/inte/myinteout")
	@ResponseBody
	public ResultMap myinteout(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userVo.getUserid() == null) {return ResultMap.build(404, "登记空");}
		int infocount = inteService.myinteoutCount(userVo);
		PageQuery pagequery = new PageQuery();
		userVo.setPagequery(pagequery);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<Integral> myintegrals = inteService.myinteout(userVo);
		Map<String, Object> map = new HashMap<>();
		map.put("myintegrals", myintegrals);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	// 我的积分获得详情
	@RequestMapping("/masonry/mymasonrylist")
	@ResponseBody
	public ResultMap mymasonrylist(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userVo.getUserid() == null) {return ResultMap.build(404, "登记空");}
		int infocount = inteService.mymasonrylistCount(userVo);
		PageQuery pagequery = new PageQuery();
		userVo.setPagequery(pagequery);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<Masonry> masonrys = inteService.mymasonrylist(userVo);
		Map<String, Object> map = new HashMap<>();
		map.put("myintegrals", masonrys);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	//查询本系统用户钱包
	// 我的积分获得详情
	@RequestMapping("/back/getalluserburse")
	@ResponseBody
	public ResultMap getalluserburse(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		int infocount = vipCountService.getalluserburseCount(userVo);
		PageQuery pagequery = new PageQuery();
		userVo.setPagequery(pagequery);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VipCountCustomer> masonrys = vipCountService.getalluserburse(userVo);
		Map<String, Object> map = new HashMap<>();
		map.put("userlist", masonrys);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	// 导出钱包
	@RequestMapping("/back/getalluserburseexcle")
	@ResponseBody
	public ResultMap getalluserburseexcle(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) throws Exception {
		int infocount = vipCountService.getalluserburseCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		
		String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/hisexcle/";
		filePath = filePath.replace("/Tenement", "");
		String filePrefix = "searchuser";
		int flushRows = 100;
		
		List<VipCountCustomer> masonrys = vipCountService.getalluserburse(userVo);
		List<String> fieldCodes = getfieldCodes();
		List<String> fieldNames = getfieldNames();
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/", filePrefix, fieldNames,
				fieldCodes, flushRows);
		excelExportSXXSSF.writeDatasByObject(masonrys);
		String webpath = excelExportSXXSSF.exportFile();
		String returnpath = "https://www.zzw777.com/upload/hisexcle"+webpath;
		return ResultMap.IS_200(returnpath);
	}

	

	private List<String> getfieldNames() {
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("电话号码");
		fieldNames.add("用户昵称");
		fieldNames.add("收益");
		fieldNames.add("红币");
		fieldNames.add("金币");
		fieldNames.add("七彩币");
		fieldNames.add("求租次数");
		return fieldNames;
	}

	private List<String> getfieldCodes() {
		List<String> filedCodes = new ArrayList<String>();
		filedCodes.add("telephone");
		filedCodes.add("username");
		filedCodes.add("account");
		filedCodes.add("mascount");
		filedCodes.add("intecount");
		filedCodes.add("balance");
		filedCodes.add("count");
		return filedCodes;
	}
	
	
	// 根据userids 查询 对应的金币明细
	@RequestMapping("/back/searchjbmx")
	@ResponseBody
	public ResultMap searchjbmx(String userids ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userids == null || "".equals(userids)) {return ResultMap.build(400,"选择用户！");}
		String [] userid = userids.split(",");
		int infocount = vipCountService.searchjbmxCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VipCountCustomer> users = vipCountService.searchjbmx(userid, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("commonmx", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	// 根据userids 查询 对应的金币明细
	@RequestMapping("/back/searchsymx")
	@ResponseBody
	public ResultMap searchsymx(String userids ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userids == null || "".equals(userids)) {return ResultMap.build(400,"选择用户！");}
		String [] userid = userids.split(",");
		int infocount = vipCountService.searchsymxCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VipCountCustomer> users = vipCountService.searchsymx(userid, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("commonmx", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	// 根据userids 查询 对应的红币明细
	@RequestMapping("/back/searchhbmx")
	@ResponseBody
	public ResultMap searchhbmx(String userids ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userids == null || "".equals(userids)) {return ResultMap.build(400,"选择用户！");}
		String [] userid = userids.split(",");
		int infocount = vipCountService.searchhbmxCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VipCountCustomer> users = vipCountService.searchhbmx(userid, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("commonmx", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	
	// 根据userids 查询 对应的求租次数明细
	@RequestMapping("/back/searchhymx")
	@ResponseBody
	public ResultMap searchqzmx(String userids ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userids == null || "".equals(userids)) {return ResultMap.build(400,"选择用户！");}
		String [] userid = userids.split(",");
		int infocount = vipCountService.searchhymxCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VipCountCustomer> users = vipCountService.searchhymx(userid, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("commonmx", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	// 根据userids 查询 对应的求租次数明细
	@RequestMapping("/back/searchxfmx")
	@ResponseBody
	public ResultMap searchqcmx(String userids ,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		if (userids == null || "".equals(userids)) {return ResultMap.build(400,"选择用户！");}
		String [] userid = userids.split(",");
		int infocount = vipCountService.searchxfmxCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VipCountCustomer> users = vipCountService.searchxfmx(userid, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("commonmx", users);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	

}
