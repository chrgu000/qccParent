package cn.com.qcc.tenement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jpay.ext.kit.IpKit;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.WeChatAppPayUtils;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.service.HouseService;
import weixin.util.HttpUtil;
import weixin.util.MD5;
import weixin.util.MD5Util;

@Controller
public class WeChatAppPay {

	@Autowired
	HttpServletRequest request;
	@Autowired
	HouseService houseService;
	@Autowired
	JedisClient jedisClient;

	/***
	 * 发起支付
	 */
	@RequestMapping("/apppay")
	@ResponseBody
	public ResultMap gateway(String monetary, String userid, String descname, String app_type) {
		
		String appid = getAppIdByApptype(app_type);

		String out_trade_no = IDUtils.genItemId();
		// 创建订单号
		//String out_trade_no = conId + "cz" + userid;
		// 设置回调URL
		String notify_url = PayCommonConfig.vippayreturn;
		if ("充值".equals(descname)) {
			notify_url = PayCommonConfig.consumepayreturn;
		}
		
		jedisClient.set(RedisUtil.ONLINE_PAY_ORDER + out_trade_no, "cz_" + userid);
		jedisClient.expire(RedisUtil.ONLINE_PAY_ORDER+ out_trade_no, RedisUtil.ONLINE_PAY_ORDER_OUT_TIME);
		
		// 总金额
		String total_free = MD5Util.getMoney(monetary);
		// 获取签名的结果
		Map<String, String> resultMap = getSignParam(total_free, out_trade_no, notify_url , appid);

		if (resultMap == null) {
			return ResultMap.build(400, "签名失败");
		}

		return ResultMap.IS_200(resultMap);
	}

	private String getAppIdByApptype(String app_type) {
		String appid = "";
		if (CheckDataUtil.checkisEqual(app_type, "land")) {
			appid = PayCommonConfig.LAND_APPID;
		}

		if (CheckDataUtil.checkisEqual(app_type, "user")) {
			appid = PayCommonConfig.USER_APPID;
		}
		return appid;
	}

	

	/**
	 * 创建房源订单
	 **/
	@RequestMapping("/app/houseOrder")
	@ResponseBody
	public ResultMap dd(Houseorder houseorder, String total_free ,String app_type) {
		String out_trade_no = IDUtils.genItemId();
		// total_free = 1;
		// 先需要往数据库插入一条记录或者是更新一条记录
		String appid = getAppIdByApptype(app_type);
		houseorder.setPrices(Double.valueOf(total_free) / 100);
		if (houseorder.getDaycount() == 0) {
			houseorder.setDaycount(0);
		}
		ResultMap resultMap = houseService.gethouseorderid(houseorder);
		if (resultMap.getCode() != 200) {
			return resultMap;
		}
		Long houseorderid = (Long) resultMap.getObj();
		//String out_trade_no = conId + "cz" + houseorderid;
		
		jedisClient.set(RedisUtil.ONLINE_PAY_ORDER + out_trade_no, "cz_" + houseorderid);
		jedisClient.expire(RedisUtil.ONLINE_PAY_ORDER+ out_trade_no, RedisUtil.ONLINE_PAY_ORDER_OUT_TIME);
		
		
		String notify_url = PayCommonConfig.houseyudingreturn;
		Map<String, String> map = getSignParam(total_free, out_trade_no, notify_url , appid);
		if (CheckDataUtil.checkisEmpty(map)) {
			return ResultMap.build(400, "签名失败");
		}
		return ResultMap.IS_200(map);
	}

	/** 第一次签名生成的结果 **/
	public Map<String, String> getSignParam(String total_free, String out_trade_no, String notify_url ,
			String appid) {
		// 机器 的IP
		String spbill_create_ip = IpKit.getRealIp(request);
		if (com.jpay.ext.kit.StrKit.isBlank(spbill_create_ip)) {
			spbill_create_ip = "120.24.43.56";
		}
		// 第一次签名
		Map<String, String> paraMap = new HashMap<>();
		// 订单总金额，单位为分
		paraMap.put("total_fee", total_free);
		// 微信开放平台审核通过的应用APPID
		paraMap.put("appid", appid);
		// 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
		paraMap.put("out_trade_no", out_trade_no);
		// 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
		paraMap.put("attach", "test");
		// 商品描述交易字段格式根据不同的应用场景按照以下格式： APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
		paraMap.put("body", "七彩巢充值");
		// 微信支付分配的商户号
		paraMap.put("mch_id", WeChatAppPayUtils.MCH_ID);
		// 商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见
		paraMap.put("detail", "七彩巢充值");
		// 随机字符串，不长于32位。
		paraMap.put("nonce_str", WeChatAppPayUtils.getNonceStr());
		// 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
		paraMap.put("notify_url", notify_url);
		// 用户端实际ip
		paraMap.put("spbill_create_ip", spbill_create_ip);
		// 交易类型，取值如下：JSAPI，NATIVE，APP
		paraMap.put("trade_type", "APP");

		// 将参数字典序列排序
		String stringSignTemp = WeChatAppPayUtils.formatUrlMap(paraMap, false, false);

		stringSignTemp = stringSignTemp + "&key=" + WeChatAppPayUtils.MCH_ID_KEY;

		// 得到签名
		String sign = MD5.MD5Encoding(stringSignTemp).toUpperCase();
		// 拼接xml
		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		for (Map.Entry<String, String> entry : paraMap.entrySet()) {
			xml.append("<" + entry.getKey() + ">");
			xml.append(entry.getValue());
			xml.append("</" + entry.getKey() + ">" + "\n");
		}
		xml.append("<sign>");
		xml.append(sign);
		xml.append("</sign>");
		xml.append("</xml>");

		// 请求接口返回prepay_id等等数据
		String responseBosy = HttpUtil.sentPost(WeChatAppPayUtils.PAYURL, xml.toString(), "UTF-8");
		// 将返回的xml转为map
		Map<String, String> resultMap = WeChatAppPayUtils.readStringXmlOut(responseBosy);

		String prepay_id = resultMap.getOrDefault("prepay_id", "");
		String return_code = resultMap.getOrDefault("return_code", "");
		if (return_code != null && "SUCCESS".equals(return_code) && prepay_id != null && !"".equals(prepay_id)) {
			// 要返回给app端的支付参数
			// APP端调起支付的参数列表
			Map<String, String> paraMapApp = new HashMap<>();
			// 微信开放平台审核通过的应用APPID
			paraMapApp.put("appid", appid);
			// 微信支付分配的商户号
			paraMapApp.put("partnerid", WeChatAppPayUtils.MCH_ID);
			paraMapApp.put("prepayid", prepay_id);
			paraMapApp.put("package", "Sign=WXPay");
			paraMapApp.put("noncestr", WeChatAppPayUtils.getNonceStr());
			String timeStamp = String.valueOf(WeChatAppPayUtils.getSecondTimestamp(new Date()));
			paraMapApp.put("timestamp", timeStamp);

			String stringSignTempApp = WeChatAppPayUtils.formatUrlMap(paraMapApp, false, false);
			stringSignTempApp = stringSignTempApp + "&key=" + WeChatAppPayUtils.MCH_ID_KEY;
			// 得到app支付签名
			String signApp = MD5.MD5Encoding(stringSignTempApp).toUpperCase();
			paraMapApp.put("sign", signApp);
			return paraMapApp;
		} else {
			return null;
		}
	}

	
}
