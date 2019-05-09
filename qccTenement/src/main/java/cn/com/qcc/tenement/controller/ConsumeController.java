package cn.com.qcc.tenement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;
import cn.com.qcc.service.ConsumeService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VipCountService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class ConsumeController {
	@Autowired
	private ConsumeService consumeService;

	@Autowired
	private VipCountService vipCountService;

	@Autowired
	UserService userService;
	
	@Autowired
	JedisClient jedisClient;

	/**  用户充值到余额或者充值VIP
	 * @param descname : 描述 充值类型
	 * @param userid : 充值的用户ID
	 * 
	 * **/
	@RequestMapping(value = "/consume/belogin/orderZfb")
	@ResponseBody
	public ResultMap generateZFB(Consume consume, String userid) {
		String orderId = IDUtils.genItemId();
		consume.setOrder(orderId);
		consume.setType(0);
		consume.setCreate_time(new Date());
		
		
		jedisClient.set(RedisUtil.ONLINE_PAY_ORDER + orderId, "cz_" + userid);
		jedisClient.expire(RedisUtil.ONLINE_PAY_ORDER + orderId, RedisUtil.ONLINE_PAY_ORDER_OUT_TIME);
		
		String url = PayCommonConfig.zfb_vip_recharge;
		if (consume.getDescname().equals("充值")) {
			url = PayCommonConfig.zfb_consume_recharge;
		}
		String str = generateZFBform(consume, url);
		return ResultMap.IS_200(str);
	}
	
	/**获取支付宝充值订单
	 * @param returnURl : 回调URL
	 * @param consume : 封装充值参数
	 * 
	 * **/
	private String generateZFBform(Consume consume, String returnUrl) {
		// 支付宝网关固定值不需要修改
		String URL = PayCommonConfig.qcc_zfb_zfwg;
		// APPID即创建应用后生成
		String APP_ID = PayCommonConfig.qcc_zfb_appid;
		// 开发者应用私钥，由开发者自己生成
		String APP_PRIVATE_KEY = PayCommonConfig.qcc_zfb_partnerKey;
		// 数据返回格式
		String FORMAT = "json";
		// 请求和签名使用的字符编码格式，支持GBK和UTF-8
		String CHARSET = "utf-8";
		// 支付宝公钥，由支付宝生成
		String ALIPAY_PUBLIC_KEY = PayCommonConfig.qcc_zfb_publicKey;
		// 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
		String SIGN_TYPE = "RSA";
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGN_TYPE); // 获得初始化的AlipayClient
		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的requestalipayRequest
		alipayRequest.setReturnUrl(PayCommonConfig.zfb_paysuccess_returnpage);
		alipayRequest.setNotifyUrl(returnUrl);// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + " \"out_trade_no\":\"" + consume.getOrder() + "\"," + " \"total_amount\":\""
				+ consume.getMonetary() + "\"," + " \"subject\":\"" + consume.getDescname() + "\","
				+ " \"product_code\":\"QUICK_WAP_PAY\"" + " }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}

	/** 支付宝余额充值成功 的回调
	 * 
	 * **/ 
	@RequestMapping(value = "/consume/recharge")
	public void rechargeConsume(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}

		boolean signVerified = false;
		String key = PayCommonConfig.qcc_zfb_publicKey;
		signVerified = AlipaySignature.rsaCheckV1(params, key, "utf-8", "RSA");

		if (signVerified) {
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
			// 这里表示是商城购买
			String descname = "";
			Integer type = 0;
			
			String jsonData = jedisClient.get(RedisUtil.ONLINE_PAY_ORDER + out_trade_no);
			String tarde_type = jsonData.split("_")[0];
			String user_id = jsonData.split("_")[1];
			if (tarde_type.equals("sc")) {
				descname = "商城消费";
				type = 1;
			}
			if (tarde_type.equals("cz")) {
				descname = "充值";
				type = 9;
			}
			
			if ("TRADE_SUCCESS".equals(trade_status)) {
				updateConsumeandVip(descname, total_amount, user_id, type);
				response.getWriter().println("success");
			}
		} else {
			response.getWriter().println("failure");
		}

	}

	public String updateConsumeandVip(String descname, String total_amount, String user_id, Integer type) {
		Consume consume = new Consume();
		Long ordernum = consumeService.ordernum();
		consume.setConsume_id(ordernum);
		consume.setType(type);
		// 记录充值的时间
		consume.setCreate_time(new Date());
		consume.setUpdate_time(new Date());
		consume.setDescname(descname);
		consume.setMonetary(Double.valueOf(total_amount));
		consume.setUser_id(user_id);
		consumeService.addConsume(consume);
		// 9 ----表示充值
		if (type == 9) {
			// 修改VIP表的余额
			Vipcount vipcount = vipCountService.getVipByUserID(Long.valueOf(user_id));
			if (vipcount != null) {
				vipcount.setBalance(vipcount.getBalance() + Double.valueOf(total_amount));
				vipcount.setCretime_time(new Date());
				vipCountService.updateVipSelective(vipcount);
				return "success";
			} else {
				Vipcount vip_new = new Vipcount();
				vip_new.setBalance(Double.valueOf(total_amount));
				vip_new.setUser_id(Long.valueOf(user_id));
				vip_new.setCretime_time(new Date());
				vip_new.setCount(10);
				// 表示普通用户
				vip_new.setIs_vip(0);
				vipCountService.insertVipCount(vip_new);
			}
		}

		return "success";
	};

	/** 查询充值记录
	 * @param userid : 用户ID 
	 * @param currentpage : 当前页面
	 * @param pagesize : 每页条数
	 * **/ 
	@RequestMapping("/consume/belogin/recharge")
	@ResponseBody
	public ResultMap searchrecharge(UserVo userVo ,@RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "100")	int pagesize) {
		if (userVo.getUserid() == null) {
			return ResultMap.build(400, "登录空");
		}
		int infocount = consumeService.searchrechargeCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<Consume> consumeList = consumeService.searchrecharge(userVo);
		Map map = new HashMap<>();
		map.put("consumeList", consumeList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/** 查询余额和可以访问的房间的属于次数
	 * @param userid : 用户ID
	 * **/ 
	@RequestMapping("/consume/belogin/balance")
	@ResponseBody
	public ResultMap searchbalance(String userid) {
		List<Vipcount> vipcountList = vipCountService.searchbalance(userid);
		Map map = new HashMap<>();
		map.put("vipcountList", vipcountList);
		return ResultMap.IS_200(map);
	}

	/**查询消费信息记录
	 * @param userid : 用户ID 
	 * 
	 * **/ 
	@RequestMapping("/consume/belogin/expense")
	@ResponseBody
	public ResultMap searchexpense(UserVo userVo,@RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "100")	int pagesize) {
		if (userVo.getUserid() == null) {return ResultMap.build(400, "登记空");}
		int infocount = consumeService.searchexpenseCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<Consume> consumeList = consumeService.searchexpense(userVo);
		Map map = new HashMap<>();
		map.put("consumeList", consumeList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/** 查询我的钱包
	 * @param user_id : 用户id
	 * **/ 
	@RequestMapping("/consume/myburse")
	@ResponseBody
	public ResultMap myburse(Long user_id) {
		if (user_id == null) {
			return ResultMap.build(400, "未知登录状态");
		}
		int day = PayCommonConfig.lurce_day_count - 1;
		VipCountCustomer vipcount_search = consumeService.getmyburse(user_id ,  day);
		return ResultMap.IS_200(vipcount_search);
	}

	/** 
	 * 会员充值时候对数据库的操作
	 * **/ 
	@RequestMapping(value = "/vip/recharge")
	public void rechargeVip(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}

		boolean signVerified = false;
		String key = PayCommonConfig.qcc_zfb_publicKey;
		signVerified = AlipaySignature.rsaCheckV1(params, key, "utf-8", "RSA");

		if (signVerified) {
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
			if ("TRADE_SUCCESS".equals(trade_status)) {
				String jsonData = jedisClient.get(RedisUtil.ONLINE_PAY_ORDER + out_trade_no);
				String user_id = jsonData.split("_")[1];
				updateVipandConsume( total_amount, user_id);
				response.getWriter().println("success");
			}
		} else {
			response.getWriter().println("failure");
		}

	}

	private String updateVipandConsume( String total_amount, String user_id) {
		Consume consume = new Consume();
		Long ordernum = consumeService.ordernum();
		consume.setConsume_id(ordernum);
		consume.setType(5);
		// 记录充值的时间
		consume.setCreate_time(new Date());
		consume.setUpdate_time(new Date());
		consume.setDescname("会员充值");
		consume.setMonetary(Double.valueOf(total_amount));
		consume.setUser_id(user_id);
		consumeService.addConsume(consume);
		// 给自己的对应加分
		userService.addinvitebalance(Long.valueOf(user_id), Double.valueOf(total_amount));
		// 修改VIP表的余额
		Vipcount vipcount = vipCountService.getVipByUserID(Long.valueOf(user_id));
		if (vipcount != null) {
			if ("260.00".equals(total_amount)) {
				vipcount.setCount(vipcount.getCount() + 100);
			}
			if ("600.00".equals(total_amount)) {
				vipcount.setCount(vipcount.getCount() + 300);
			}
			// 1表示VIP
			vipcount.setIs_vip(1);
			vipCountService.updateVipSelective(vipcount);
			return "success";
		} else {
			Vipcount vip_new = new Vipcount();
			vip_new.setBalance(0.0);
			vip_new.setUser_id(Long.valueOf(user_id));
			vip_new.setCretime_time(new Date());
			if ("260.00".equals(total_amount)) {
				vip_new.setCount(110);
			}
			if ("600.00".equals(total_amount)) {
				vip_new.setCount(310);
			}

			// 表示普通用户
			vip_new.setIs_vip(1);
			vipCountService.insertVipCount(vip_new);

			return "success";
		}
	}
	
	// 测试修改数据
	@ResponseBody
	@RequestMapping("/consume/testupdatebure")
	public ResultMap testupdatebure (Vipcount vipcount ,Long intecount) {
		if (vipcount.getUser_id() ==null) {return ResultMap.build(400,"检查用户ID");}
		if (intecount == null) {return ResultMap.build(400, "输入金币不合法");}
		if (vipcount.getIs_vip() == null) {return ResultMap.build(400, "检查会员");}
		if (vipcount.getIs_vip() > 1 || vipcount.getIs_vip() < 0) {return ResultMap.build(400, "会员传值错误!");}
		Vipcount check = consumeService.checkvipcount(vipcount.getUser_id());
		if (check == null) {return ResultMap.build(400, "未知用户");}
		consumeService.updatevipcount(vipcount ,intecount);
		return ResultMap.build(200, "更新成功");
	}

}
