package cn.com.qcc.tenement.controller;
import java.util.SortedMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CentFileSend;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ParamUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VipCountService;


/**
 * 这里专门做企业付款
 * **/
@Controller
public class WeiXinEnterprisePayController {
	
	@Autowired
	UserService userService;
	@Autowired
	VipCountService vipCountService;
	
	/**提现操作**/
	@RequestMapping("/prisepaytoweixin")
	@ResponseBody
	public ResultMap doTravelScoreCash(Long userid ,HttpServletRequest request ,
			String descname , Double outaccount ,
			String password) throws Exception {
		// 这里做业务逻辑操作 根据用户ID 取出对应的service 然后设置参数
		if (userid == null) {return ResultMap.build(400, "此操作需要登录");}
		UserCustomer userCustomer = userService.checkcash(userid);
		if (password == null || "".equals(password)) {return ResultMap.build(400, "输入提现密码");}
		if (outaccount == null || outaccount < 1) {return ResultMap.build(400, "提现金额不得少于1元");}
		if (userCustomer == null) {return ResultMap.build(400, "未知用户");}
		// 获取微信的账号
		String openid = userCustomer.getWeixinaccount();
		if (openid == null || "".equals(openid)) {return ResultMap.build(407,"检查提现账号");}
		// 获取真实姓名
		String realname = userCustomer.getRealname();
		if (realname ==null || "".equals(realname)){return ResultMap.build(407, "提现实名姓名");}
		String parntpassword = userCustomer.getPassword();
		if (parntpassword == null || "".equals(parntpassword)) {return ResultMap.build(407,"设置提现密码");}
		// 校验实名信息
		Integer signstate = userCustomer.getSignstate();
		if (signstate != 2) {return ResultMap.build(407, "提现需要实名");}
		// 校验提现密码
		String account = "";
		// 这里是操作完成之后的余额
		Double updatecount = 0.0;
		//提现的描述
		String paydesc = "";
		// 这里是提现七彩币操作
		if ("qcb".equals(descname)) {
			// 提现记录表插入的描述
			paydesc = "七彩币提现";
			// 计算当前余额和提现金额的差值
			updatecount = userCustomer.getBalance() - outaccount;
			if (updatecount < 0) {
				return ResultMap.build(400, "七彩币不足");
			}
			// 这里是提现收益的操作
		} else if ("sy".equals(descname)) {
			paydesc = "收益提现";
			updatecount = userCustomer.getAccount()-outaccount;
			if (updatecount < 0) {
				return ResultMap.build(400, "收益余额不足");
			}
		} else {
			return ResultMap.build(400, "参数错误");
		}
		
		// 这里算是最终提现的金额
		account = ( outaccount * 100 )+"";
		
		
		// 对密码进行加密操作
		password = IDUtils.getprivatePassword(password);
		if (! password.equals(parntpassword)) {return ResultMap.build(400, "提现密码错误");}
		if (account == null || "".equals(account)) {return ResultMap.build(400, "检查提现金额");}
		account = account.substring(0,account.lastIndexOf("."));
		// 商户订单号 也就是提现订单号
		String partner_trade_no = IDUtils.genItemId();
		SortedMap<String, String> packageParams =  
			ParamUtil.getParmSorteMap(openid , realname , account,paydesc,request ,partner_trade_no);
		String  xml = CentFileSend.qiye_fukuan(packageParams);
		ResultMap checkmap = ParamUtil.checkxmlpres(xml);
		if (checkmap.getCode() == 200) {
			// 如果是提现成功在这里做相关逻辑操作
	        if ("qcb".equals(descname)) {
	        	Vipcount update = new Vipcount();
	        	update.setUser_id(userid);
	        	update.setBalance(updatecount);
	        	vipCountService.changevipcount(update);
	        }
	        
	        // 这里给提现记录表插入一条数据
	        vipCountService.insertpartner(partner_trade_no , outaccount , paydesc , userid , 1);
		}
		return checkmap;
		
		
		
		///String openid = "oYQk1xEFu9EjR38rhxDh2v2HOg3w"; // 老板 的OPENID
		//String realname = "王玉林";
		//String account = "100";
		//String desc = "企业付款";
		
	}


	
	
	
	
	
	

}
