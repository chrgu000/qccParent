package cn.com.qcc.tenement.controller;

import com.jpay.ext.kit.HttpKit;
import com.jpay.ext.kit.IpKit;
import com.jpay.ext.kit.PaymentKit;
import com.jpay.ext.kit.StrKit;
import com.jpay.weixin.api.WxPayApi;
import com.jpay.weixin.api.WxPayApiConfig;
import com.jpay.weixin.api.WxPayApiConfigKit;
import com.thoughtworks.xstream.XStream;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Integral;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.service.ConsumeService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.TribeService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VipCountService;
import net.sf.json.JSONObject;
import weixin.util.Configure;
import weixin.util.H5ScencInfo;
import weixin.util.H5ScencInfo.H5;
import weixin.util.HttpRequest;
import weixin.util.MD5Util;
import weixin.util.OrderInfo;
import weixin.util.OrderReturnInfo;
import weixin.util.RandomStringGenerator;
import weixin.util.SignInfo;
import weixin.util.Signature;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.*;

@SuppressWarnings("deprecation")
@Controller
public class WxPayController {

	@Autowired
	ConsumeService consumeService;
	@Autowired
	VipCountService vipCountService;
	@Autowired
	TribeService tribeService;
	@Autowired
	UserService userService;
	@Autowired
	InteService inteService;
	@Autowired
	HouseService houseService;
	

	public static WxPayApiConfig getApiConfig() {
		return WxPayApiConfig.New().setAppId(PayCommonConfig.qcc_gzhappid).
				setMchId(PayCommonConfig.qcc_gzh_mchid).setPaternerKey(PayCommonConfig.qcc_gzh_partnerKey)
				.setPayModel(WxPayApiConfig.PayModel.BUSINESSMODEL);
	}

	/**
	 * 微信H5 支付--------------------好使 注意：必须再web页面中发起支付且域名已添加到开发配置中
	 */
	@ResponseBody
	@RequestMapping(value = "/h5pay", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultMap wapPay(Consume consume, String userid, HttpServletRequest request, HttpServletResponse response) {
		// consumeService.generateWX();
		String ip = IpKit.getRealIp(request);
		if (com.jpay.ext.kit.StrKit.isBlank(ip)) {
			ip = "120.24.43.56";
		}
		String notify_url = PayCommonConfig.vippayreturn;
		if ("充值".equals(consume.getDescname())) {
			notify_url = PayCommonConfig.consumepayreturn;
		}
		String conId = IDUtils.genItemId();
		String total_count = consume.getMonetary() + "";
		String total_monery = MD5Util.getMoney(total_count);
		String out_trade_no = conId + "cz" + userid;
		H5ScencInfo sceneInfo = new H5ScencInfo();
		H5 h5_info = new H5();
		h5_info.setType("Wap");
		// 此域名必须在商户平台--"产品中心"--"开发配置"中添加
		h5_info.setWap_url(PayCommonConfig.mainqccweb);
		h5_info.setWap_name("腾讯充值");
		sceneInfo.setH5_info(h5_info);
		// WxPayApiConfig wxPayApiConfig=getApiConfig();
		Map<String, String> params = WxPayApiConfig.New().setAppId(PayCommonConfig.qcc_gzhappid)
				.setMchId(PayCommonConfig.qcc_gzh_mchid).setBody("七彩巢充值")
				.setSpbillCreateIp(ip).setTotalFee(total_monery).setTradeType(WxPayApi.TradeType.MWEB)
				.setNotifyUrl(notify_url).setPaternerKey(PayCommonConfig.qcc_gzh_partnerKey)// String.valueOf(System.currentTimeMillis())
				.setOutTradeNo(out_trade_no)
				.setSceneInfo(
						"{\"h5_info\": {\"type\":\"IOS\",\"app_name\": \"mtgg\",\"package_name\": \"com.tencent.tmgp.sgame\"}}")
				.setAttach("七彩巢充值").build();
		String xmlResult = WxPayApi.pushOrder(false, params);
		Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
		String return_code = result.get("return_code");
		String return_msg = result.get("return_msg");
		if (!PaymentKit.codeIsOK(return_code)) {
			// log.error("return_code>" + return_code + " return_msg>" +
			// return_msg);
			throw new RuntimeException(return_msg);
		}
		String result_code = result.get("result_code");
		if (!PaymentKit.codeIsOK(result_code)) {
			throw new RuntimeException(return_msg);
		}
		//String prepay_id = result.get("prepay_id");
		String mweb_url = result.get("mweb_url");
		return ResultMap.IS_200(mweb_url);
	}

	/**
	 * 公众号支付
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/gzhpay", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView webPay(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ModelAndView mv = new ModelAndView();
		String total_fee = request.getParameter("total_fee");
		String total_monery = MD5Util.getMoney(total_fee);
		String notify_url = PayCommonConfig.vippayreturn;
		String order_tar_no = request.getParameter("state");
		String[] str = null;
		String out_trade_no = "";
		// 如果是商城消费
		if (order_tar_no.indexOf("sc") != -1) {
			str = order_tar_no.split("sc");
			if ("0000".equals(str[0])) {
				notify_url = PayCommonConfig.consumepayreturn;
			}
			out_trade_no = IDUtils.genItemId() + "sc" + str[1];

		}
		// 如果是商城消费
		if (order_tar_no.indexOf("cz") != -1) {
			str = order_tar_no.split("cz");
			if ("0000".equals(str[0])) {
				notify_url = PayCommonConfig.consumepayreturn;
			}
			out_trade_no = IDUtils.genItemId() + "cz" + str[1];
		}
		// 获取用户的code
		String code = request.getParameter("code");
		// String out_trade_no = IDUtils.genItemId() + "cz" + str[1];
		String openId = null;
		try {
			List<Object> list = accessToken(code);
			openId = list.get(1).toString();
		} catch (IOException e) {
		}
		if (StrKit.isBlank(openId)) {
			return mv;
		}
		if (StrKit.isBlank(total_fee)) {
			return mv;
		}
		String ip = IpKit.getRealIp(request);
		if (StrKit.isBlank(ip)) {
			ip = "127.0.0.1";
		}
		WxPayApiConfigKit.putApiConfig(getApiConfig());
		Map<String, String> params = WxPayApiConfigKit.getWxPayApiConfig().setAttach("七彩巢充值").setBody("七彩巢充值")
				.setOpenId(openId).setSpbillCreateIp(ip).setTotalFee(total_monery)
				.setTradeType(WxPayApi.TradeType.JSAPI).setNotifyUrl(notify_url).setOutTradeNo(out_trade_no).build();
		String xmlResult = WxPayApi.pushOrder(false, params);
		// log.info(xmlResult);
		Map<String, String> resultMap = PaymentKit.xmlToMap(xmlResult);

		String return_code = resultMap.get("return_code");
		//String return_msg = resultMap.get("return_msg");
		if (!PaymentKit.codeIsOK(return_code)) {
			return mv;
		}
		String result_code = resultMap.get("result_code");
		if (!PaymentKit.codeIsOK(result_code)) {
			return mv;
		}
		// 以下字段在return_code 和result_code都为SUCCESS的时候有返回
		String prepay_id = resultMap.get("prepay_id");
		String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
		String nonce_str = String.valueOf(System.currentTimeMillis());
		String packages = "prepay_id=" + prepay_id;
		Map<String, String> packageParams = new HashMap<String, String>();
		packageParams.put("appId", PayCommonConfig.qcc_gzhappid);
		packageParams.put("timeStamp", timeStamp);
		packageParams.put("nonceStr", nonce_str);
		packageParams.put("package", "prepay_id=" + prepay_id);
		packageParams.put("signType", "MD5");
		String packageSign = PaymentKit.createSign(packageParams,
				WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey());
		packageParams.put("paySign", packageSign);
		// 下面可以通过Map传入参数获取json字符串，其形式和上面一样，传到前台可以转为json形式再用，也是一个不错的方式，可以参考IJPay
		/*
		 * Map<String, String> packageParams =
		 * PaymentKit.prepayIdCreateSign(prepay_id); String jsonStr =
		 * JSON.toJSONString(packageParams); mv.addObject("jsonStr",jsonStr);
		 */
		mv.addObject("appid", PayCommonConfig.qcc_gzhappid);
		mv.addObject("timeStamp", timeStamp);
		mv.addObject("nonceStr", nonce_str);
		mv.addObject("packageValue", packages);
		mv.addObject("paySign", packageSign);
		mv.addObject("success", "ok");
		mv.setViewName("pay");
		return mv;
	}

	@ResponseBody // 增值服务置顶
	@RequestMapping(value = "/articletop/return", method = { RequestMethod.POST, RequestMethod.GET })
	public String articletopreturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String xmlMsg = HttpKit.readData(request);
		String returnstr = "";
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		String result_code = params.get("result_code");
		// 总金额
		String total_amount = params.get("total_fee");
		String out_trade_no = params.get("out_trade_no");
		WxPayApiConfigKit.setThreadLocalWxPayApiConfig(getApiConfig());
		if (PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey())) {
			if (("SUCCESS").equals(result_code)) {
				String[] str = out_trade_no.split("cz");
				String descname = "增值服务置顶";
				Integer type = 1;
				String userid = str[1];
				String articledetailid = str[2];
				// 这里需要需要置顶更新和消费记录
				returnstr = updateConsumeAndArticledetail(descname, total_amount, articledetailid, type, userid);
			}
		}
		return returnstr;
	}

	private String updateConsumeAndArticledetail(String descname, String total_amount, String articledetailid,
			Integer type, String userid) {

		// 账单插入一条记录
		Consume consume = new Consume();
		Long ordernum = consumeService.ordernum();
		consume.setConsume_id(ordernum);
		consume.setType(type);
		// 记录充值的时间
		consume.setCreate_time(new Date());
		consume.setUpdate_time(new Date());

		// 这里是应该根据 articledetailid --》查到对应的消费类目
		ArticleDetailCustomer customer = tribeService.getArticledetailandtype(articledetailid);
		consume.setDescname(customer.getTypename());
		consume.setMonetary((Double.valueOf(total_amount) / 100.0));
		consume.setUser_id(userid);
		// 修改订单状态为充值成功
		consumeService.addConsume(consume);

		// 这里处理置顶操作
		Articledetail articledetail = tribeService.getArticleDetailbyId(Integer.parseInt(articledetailid));
		Integer topday = 0;
		articledetail.setArticledetailid(Long.valueOf(articledetailid));
		// 如果是6元置顶一天
		if ("600".equals(total_amount)) {
			topday = 1;
		}
		// 如果是40块置顶7天
		if ("4000".equals(total_amount)) {
			topday = 7;
		}
		// 如果是168置顶30天
		if ("16800".equals(total_amount)) {
			topday = 30;
		}
		// 如果是0.1元置顶9天 测试用的
		if ("10".equals(total_amount)) {
			topday = 9;
		}
		articledetail.setTopday(topday);
		consumeService.updateArticle(articledetail);
		// 给自己的对应加分
		Double account = Double.valueOf(total_amount) / 100.0;
		userService.addinvitebalance(Long.valueOf(userid), account);
		return "success";
	}

	// 充值
	@RequestMapping(value = "/consume/return", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String pay_notify(HttpServletRequest request) {
		// 支付结果通用通知文档:
		// https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7

		String xmlMsg = HttpKit.readData(request);
		
		
		
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		String result_code = params.get("result_code");
		// String openId = params.get("openid");
		// //交易类型
		// String trade_type = params.get("trade_type");
		// //付款银行
		// String bank_type = params.get("bank_type");
		// // 总金额
		// String total_fee = params.get("total_fee");
		// //现金支付金额
		// String cash_fee = params.get("cash_fee");
		// // 微信支付订单号
		// String transaction_id = params.get("transaction_id");
		// // 商户订单号
		// String out_trade_no = params.get("out_trade_no");
		// // 支付完成时间，格式为yyyyMMddHHmmss
		// String time_end = params.get("time_end");

		///////////////////////////// 以下是附加参数///////////////////////////////////
		// 总金额
		String total_amount = params.get("total_fee");
		String out_trade_no = params.get("out_trade_no");
		//String attach = params.get("attach");
		// String fee_type = params.get("fee_type");
		// String is_subscribe = params.get("is_subscribe");
		// String err_code = params.get("err_code");
		// String err_code_des = params.get("err_code_des");
		// 注意重复通知的情况，同一订单号可能收到多次通知，请注意一定先判断订单状态
		// 避免已经成功、关闭、退款的订单被再次更新
		// Order order = Order.dao.getOrderByTransactionId(transaction_id);
		// if (order==null) {
		WxPayApiConfigKit.setThreadLocalWxPayApiConfig(getApiConfig());
		if (PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey())) {
			if (("SUCCESS").equals(result_code)) {
				// 更新订单信息
				// log.warn("更新订单信息:" + attach);
				String[] str = null;
				String descname = "";
				Integer type = -1;
				if (out_trade_no.indexOf("sc") != -1) {
					str = out_trade_no.split("sc");
					descname = "商城消费";
					type = 1;
				}
				if (out_trade_no.indexOf("cz") != -1) {
					str = out_trade_no.split("cz");
					descname = "充值";
					type = 9;
				}
				// String consume_id = str[0];
				String user_id = str[1];
				updateConsumeandVip(descname, total_amount, user_id, type);
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("return_code", "SUCCESS");
				xml.put("return_msg", "OK");
				return PaymentKit.toXml(xml);
			}
		}
		// }

		return null;
	}

	@RequestMapping(value = "/vip/return", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String vipreturn(HttpServletRequest request) {
		// 支付结果通用通知文档:
		String xmlMsg = HttpKit.readData(request);
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		// String appid = params.get("appid");
		// //商户号
		// String mch_id = params.get("mch_id");
		String result_code = params.get("result_code");
		// String openId = params.get("openid");
		// //交易类型
		// String trade_type = params.get("trade_type");
		// //付款银行
		// String bank_type = params.get("bank_type");
		// // 总金额
		String total_amount = params.get("total_fee");
		// //现金支付金额
		// String cash_fee = params.get("cash_fee");
		// // 微信支付订单号
		// String transaction_id = params.get("transaction_id");
		// // 商户订单号
		String out_trade_no = params.get("out_trade_no");
		// // 支付完成时间，格式为yyyyMMddHHmmss
		// String time_end = params.get("time_end");

		///////////////////////////// 以下是附加参数///////////////////////////////////

		//String attach = params.get("attach");
		// String fee_type = params.get("fee_type");
		// String is_subscribe = params.get("is_subscribe");
		// String err_code = params.get("err_code");
		// String err_code_des = params.get("err_code_des");
		// 注意重复通知的情况，同一订单号可能收到多次通知，请注意一定先判断订单状态
		// 避免已经成功、关闭、退款的订单被再次更新
		// Order order = Order.dao.getOrderByTransactionId(transaction_id);
		// if (order==null) {
		WxPayApiConfigKit.setThreadLocalWxPayApiConfig(getApiConfig());
		if (PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey())) {
			if (("SUCCESS").equals(result_code)) {
				// 更新订单信息
				// log.warn("更新订单信息:" + attach);
				// 发送通知等
				String[] str = out_trade_no.split("cz");
				String consume_id = str[0];
				String user_id = str[1];
				updateVipandConsume(consume_id, total_amount, user_id);
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("return_code", "SUCCESS");
				xml.put("return_msg", "OK");
				return PaymentKit.toXml(xml);
			}
		}
		// }

		return null;
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
		consume.setMonetary((Double.valueOf(total_amount) / 100.0));
		consume.setUser_id(user_id);
		// 修改订单状态为充值成功
		consumeService.addConsume(consume);

		// 修改VIP表的余额
		if (type == 9) {
			Vipcount vipcount = vipCountService.getVipByUserID(Long.valueOf(user_id));
			if (vipcount != null) {
				vipcount.setBalance(vipcount.getBalance() + (Double.valueOf(total_amount) / 100.0));
				vipcount.setCretime_time(new Date());
				vipCountService.updateVipSelective(vipcount);
				return "success";
			} else {
				Vipcount vip_new = new Vipcount();
				vip_new.setBalance((Double.valueOf(total_amount) / 100.0));
				vip_new.setUser_id(Long.valueOf(user_id));
				vip_new.setCretime_time(new Date());
				vip_new.setCount(10);
				// 表示普通用户
				vip_new.setIs_vip(0);
				vipCountService.insertVipCount(vip_new);
				return "success";
			}
		}
		return "success";
	}

	private String updateVipandConsume(String consume_id, String total_amount, String user_id) {
		Consume consume = new Consume();
		Long ordernum = consumeService.ordernum();
		consume.setConsume_id(ordernum);
		consume.setType(1);
		// 记录充值的时间
		consume.setCreate_time(new Date());
		consume.setUpdate_time(new Date());
		consume.setDescname("会员充值");

		consume.setMonetary((Double.valueOf(total_amount) / 100.0));
		consume.setUser_id(user_id);
		consumeService.addConsume(consume);

		// 修改VIP表的余额
		Vipcount vipcount = vipCountService.getVipByUserID(Long.valueOf(user_id));
		// 给自己的对应加分 。单位转换为元要除以100
		Double account = Double.valueOf(total_amount) / 100.0;
		userService.addinvitebalance(Long.valueOf(user_id), account);
		if (vipcount != null) {
			if ("26000".equals(total_amount)) {
				vipcount.setCount(vipcount.getCount() + 100);
			}
			if ("60000".equals(total_amount)) {
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
			if ("26000".equals(total_amount)) {
				vip_new.setCount(110);
			}
			if ("60000".equals(total_amount)) {
				vip_new.setCount(310);
			}

			// 表示普通用户
			vip_new.setIs_vip(1);
			vipCountService.insertVipCount(vip_new);
			return "success";
		}
	}

	/**
	 * 通过微信用户的code换取网页授权access_token @return @throws IOException @throws
	 */
	@SuppressWarnings({ "resource", "unchecked" })
	public List<Object> accessToken(String code) throws IOException {
		List<Object> list = new ArrayList<Object>();
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + 
				PayCommonConfig.qcc_gzhappid	+ "&secret=" +
				PayCommonConfig.qcc_gzhsecret + "&code="
				+ code + "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse res = client.execute(post);
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> jsonOb = mapper.readValue(str, Map.class);
			list.add(jsonOb.get("access_token"));
			list.add(jsonOb.get("openid"));
		}
		return list;
	}

	@SuppressWarnings("unused")
	@RequestMapping("/wexin/test")
	@ResponseBody
	public ResultMap Test(String code) {

		String openId = "";
		try {
			List<Object> list = get_qcc_weixinuseridbyxiaochengxu(code);
			openId = list.get(1).toString();
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMap.build(400, "未知异常");

		}

		return ResultMap.IS_200();
	}

	

	// 根据code获得小程序的openid
	@SuppressWarnings({ "resource", "unchecked" })
	public List<Object> get_qcc_weixinuseridbyxiaochengxu(String code) throws IOException {
		List<Object> list = new ArrayList<Object>();
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + 
				PayCommonConfig.qcc_xiaochengxuappid + "&secret=" + 
				PayCommonConfig.qcc_xiaochengxuSecret + "&js_code="
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
	
	// 根据code获得小程序的openid
		@SuppressWarnings({ "resource", "unchecked" })
		public List<Object> get_fdzz_weixinuseridbyxiaochengxu(String code) throws IOException {
			List<Object> list = new ArrayList<Object>();
			String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + 
					PayCommonConfig.fdzz_xiaochengxuappid + "&secret=" + 
					PayCommonConfig.fdzz_xiaochengxuSecret+ "&js_code="
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
	
	
	
	// 根据code获得小程序的openid
	@SuppressWarnings({ "resource", "unchecked" })
	public List<Object> get_gzfzz_weixinuseridbyxiaochengxu(String code) throws IOException {
		List<Object> list = new ArrayList<Object>();
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + 
				PayCommonConfig.gzfzz_xiaochengxuappid + "&secret=" + 
				PayCommonConfig.gzfzz_xiaochengxuSecret+ "&js_code="
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

	// 小程序第一步获取OPENID
	@RequestMapping("/user/testxiaochengxu")
	@ResponseBody
	public ResultMap getopenid(String opencode ,String type ) {
		String openid = "-1";
		List<Object> list = null;
		try {
			
			if ("gzfzz".equals(type)) {
				list = this.get_gzfzz_weixinuseridbyxiaochengxu(opencode);
			} else if ("fdzz".equals(type)) {
				list = this.get_fdzz_weixinuseridbyxiaochengxu(opencode);
			}  else {
				list =  this.get_qcc_weixinuseridbyxiaochengxu(opencode);
			}
			return ResultMap.IS_200(list);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMap.build(400, "获取OPENID失败", openid);
		}
	}

	@RequestMapping("/user/hongbao")
	@ResponseBody
	public ResultMap hongbao(String openid) {
		OrderInfo order = new OrderInfo();
		order.setNonce_str(IDUtils.genItemId()); // 随机字符串
		order.setMch_billno(IDUtils.genImageName());// 商户订单号
		order.setAppid(Configure.getAppID()); // 小程序ID
		order.setMch_id(Configure.getMch_id());// 商户号
		order.setWxappid(Configure.getAppID());// 公众账号appid
		return null;
	}

	// 小程序 生成统一下单接口
	@RequestMapping("/user/createorder")
	@ResponseBody
	public ResultMap createorder(String openid, int total_free, String descname, String userid, String articledetailid,String type
			,Houseorder houseorder)
			throws IllegalAccessException, UnrecoverableKeyException, KeyManagementException, ClientProtocolException,
			KeyStoreException, NoSuchAlgorithmException, IOException {
		OrderInfo order = new OrderInfo();
		String conId = IDUtils.genItemId();
		//if ("10001765".equals(userid)) {total_free = 1;}
		String out_trade_no = conId + "cz" + userid;
		if ("gzfzz".equals(type)) {
			order.setAppid(PayCommonConfig.gzfzz_xiaochengxuappid);
		}else if ("fdzz".equals(type)) {
			order.setAppid(PayCommonConfig.fdzz_xiaochengxuappid);
		}
		else {
			order.setAppid(PayCommonConfig.qcc_xiaochengxuappid);
		}
		
		order.setMch_id(PayCommonConfig.qcc_gzh_mchid);
		order.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		order.setBody("七彩巢支付");
		order.setSpbill_create_ip("120.24.43.56");
		String notify_url = PayCommonConfig.vippayreturn;
		if ("充值".equals(descname)) {
			notify_url = PayCommonConfig.consumepayreturn;
		}
		if ("增值置顶".equals(descname)) {
			out_trade_no = conId + "cz" + userid + "cz" + articledetailid;
			notify_url = PayCommonConfig.articletopreturn;
		}
		if ("金币充值".equals(descname)) {
			notify_url = PayCommonConfig.jinbireturn;
		} 
		if ("房源预订".equals(descname)) {
			//total_free = 1;
			// 先需要往数据库插入一条记录或者是更新一条记录
			houseorder.setPrices(Long.valueOf(total_free ) / 100);
			if (houseorder.getDaycount() == 0) {houseorder.setDaycount(1800);}
			ResultMap resultMap = houseService.gethouseorderid(houseorder);
			if (resultMap.getCode() !=200) {return resultMap;}
			Long houseorderid =(Long) resultMap.getObj();
			out_trade_no = conId + "cz" + houseorderid;
			notify_url = PayCommonConfig.houseyudingreturn;
			
		
		}
		order.setTotal_fee(total_free);
		order.setOut_trade_no(out_trade_no);
		order.setNotify_url(notify_url);
		order.setTrade_type("JSAPI");
		order.setOpenid(openid);
		order.setSign_type("MD5");
		// 生成签名
		String sign = Signature.getSign(order);
		order.setSign(sign);

		String result = HttpRequest.sendPost(PayCommonConfig.weixin_tongyixiadan, order);
		XStream xStream = new XStream();
		xStream.alias("xml", OrderReturnInfo.class);
		OrderReturnInfo returnInfo = (OrderReturnInfo) xStream.fromXML(result);
		JSONObject json = new JSONObject();
		json.put("prepay_id", returnInfo.getPrepay_id());

		return ResultMap.IS_200(json);
	}

	// 再次生成签名
	@ResponseBody
	@RequestMapping("/user/signafter")
	public ResultMap signafter(String repay_id ,String type) throws IllegalAccessException {
		SignInfo signInfo = new SignInfo();
		if ("gzfzz".equals(type)) {
			signInfo.setAppId(PayCommonConfig.gzfzz_xiaochengxuappid);
		}else if ("fdzz".equals(type)) {
			signInfo.setAppId(PayCommonConfig.fdzz_xiaochengxuappid);
		} 
		else {
			signInfo.setAppId(PayCommonConfig.qcc_xiaochengxuappid);
		}
		
		long time = System.currentTimeMillis() / 1000;
		signInfo.setTimeStamp(String.valueOf(time));
		signInfo.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
		signInfo.setRepay_id("prepay_id=" + repay_id);
		signInfo.setSignType("MD5");
		// 生成签名
		String sign = Signature.getSign(signInfo);
		JSONObject json = new JSONObject();
		json.put("timeStamp", signInfo.getTimeStamp());
		json.put("nonceStr", signInfo.getNonceStr());
		json.put("package", signInfo.getRepay_id());
		json.put("signType", signInfo.getSignType());
		json.put("paySign", sign);
		return ResultMap.IS_200(json);
	}

	

	// 再次生成签名
	/*public ResultMap appsignafter(String repay_id) throws IllegalAccessException {
		SignInfo signInfo = new SignInfo();
		signInfo.setAppId(Configure.getAppID());
		long time = System.currentTimeMillis() / 1000;
		signInfo.setTimeStamp(String.valueOf(time));
		signInfo.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
		signInfo.setRepay_id("prepay_id=" + repay_id);
		signInfo.setSignType("MD5");
		// 生成签名
		String sign = Signature.getSign(signInfo);
		JSONObject json = new JSONObject();
		json.put("partnerId", "1509961881");
		json.put("prepayId", repay_id);
		json.put("package", "Sign=WXPay");
		json.put("nonceStr", signInfo.getNonceStr());
		json.put("timeStamp", signInfo.getTimeStamp());
		json.put("sign", sign);
		return ResultMap.IS_200(json);
	}*/
	

	@ResponseBody // 房源预定充值成功的回调
	@RequestMapping(value = "/houseyuding/return", method = { RequestMethod.POST, RequestMethod.GET })
	public String houseyudingreturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String xmlMsg = HttpKit.readData(request);
		String returnstr = "";
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		String result_code = params.get("result_code");
		// 总金额
		String total_amount = params.get("total_fee");
		String out_trade_no = params.get("out_trade_no");
		WxPayApiConfigKit.setThreadLocalWxPayApiConfig(getApiConfig());
		if (PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey())) {
			if (("SUCCESS").equals(result_code)) {
				String[] str = out_trade_no.split("cz");
				String houseorderid = str[1];
				returnstr = houseService.houseyudingsuccess(houseorderid , total_amount ,out_trade_no );
			}
		}
		return returnstr;
	}		
	
			
			
	@ResponseBody // 金币充值回调
	@RequestMapping(value = "/jinbi/return", method = { RequestMethod.POST, RequestMethod.GET })
	public String jinbireturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String xmlMsg = HttpKit.readData(request);
		String returnstr = "";
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		String result_code = params.get("result_code");
		// 总金额
		String total_amount = params.get("total_fee");
		String out_trade_no = params.get("out_trade_no");
		WxPayApiConfigKit.setThreadLocalWxPayApiConfig(getApiConfig());
		if (PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey())) {
			if (("SUCCESS").equals(result_code)) { 
				String[] str = out_trade_no.split("cz");
				String descname = "金币充值";
				Integer type = 1;
				String userid = str[1];
				// 这里需要需要置顶更新和消费记录
				returnstr = updateConsumeAndIntegral(descname, total_amount, type, userid);
			}
		}
		return returnstr;
	}

	// 更新充值记录表和金币表信息
	private String updateConsumeAndIntegral(String descname, String total_amount, Integer type, String userid) {
		// 账单插入一条记录
		Consume consume = new Consume();
		Long ordernum = consumeService.ordernum();
		consume.setConsume_id(ordernum);
		consume.setType(type);
		// 记录充值的时间
		consume.setCreate_time(new Date());
		consume.setUpdate_time(new Date());
		consume.setDescname(descname);
		consume.setMonetary((Double.valueOf(total_amount) / 100.0));
		consume.setUser_id(userid);
		consumeService.addConsume(consume);

		Integral integral = new Integral();
		Long count = (Long.valueOf(total_amount) / 10);
		integral.setEvent(descname);
		integral.setUpdate_time(new Date());
		integral.setUserid(Long.valueOf(userid));
		integral.setType(1);
		integral.setCount(count);
		String str = inteService.chongzhirenturn(integral, (Double.valueOf(total_amount) / 100.0));
		return str;
	}

}
