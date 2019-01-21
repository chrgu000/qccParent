package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpay.ext.kit.IpKit;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.MyJsonUtil;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.WeixinPayUtil;
import cn.com.qcc.pojo.Consume;
import weixin.util.RequestHandler;
import weixin.util.Sha1Util;

@Controller
public class WeixinAppPayController {

	private static final String tradeType = "APP";

	@SuppressWarnings({ "rawtypes", "unused" })

	@RequestMapping(value = "/auupppay", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResultMap preparePay(String userid, Consume consume, HttpServletRequest request,
			HttpServletResponse response) {
		String conId = IDUtils.genItemId();
		String out_trade_no = conId + "cz" + "1233222";

		// 获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder //
		// 随机数
		String nonce_str = UUID.randomUUID().toString().replaceAll("-", "");
		// 商品描述
		String body = "七彩充值"; // 商户订单号

		// 订单生成的机器 IP
		String spbill_create_ip = IpKit.getRealIp(request);
		if (com.jpay.ext.kit.StrKit.isBlank(spbill_create_ip)) {
			spbill_create_ip = "127.0.0.1";
		} // String spbill_create_ip = request.getRemoteAddr(); //总金额 // TODO
		Integer total_fee = 100;

		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = PayCommonConfig.vippayreturn;
		if ("充值".equals(consume.getDescname())) {
			notify_url = PayCommonConfig.consumepayreturn;
		}

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", PayCommonConfig.qcc_kfpt_appid);
		packageParams.put("mch_id", PayCommonConfig.qcc_kfpt_mchid);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("total_fee", total_fee + "");
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", tradeType);

		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(PayCommonConfig.qcc_kfpt_appid, PayCommonConfig.qcc_kfpt_secret,
				PayCommonConfig.qcc_kfpt_partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + PayCommonConfig.qcc_kfpt_appid + "</appid>" + "<mch_id>"
				+ PayCommonConfig.qcc_kfpt_mchid + "</mch_id>" + "<nonce_str>" + nonce_str + "</nonce_str>" + "<sign>"
				+ sign + "</sign>" + "<body><![CDATA[" + body + "]]></body>" + "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<total_fee>" + total_fee + "" + "</total_fee>" + "<spbill_create_ip>"
				+ spbill_create_ip + "</spbill_create_ip>" + "<notify_url>" + notify_url + "</notify_url>"
				+ "<trade_type>" + tradeType + "</trade_type>" + "</xml>";

		String createOrderURL = PayCommonConfig.weixin_tongyixiadan;
		String prepay_id = "";
		Map payNo2 = WeixinPayUtil.getPayNo2(createOrderURL, xml);
		try {

			prepay_id = (String) payNo2.get("prepay_id");
			String sign2 = (String) payNo2.get("sign");
			payNo2.remove("sign");
			payNo2.remove("key");
			SortedMap<String, String> packageParams2 = new TreeMap<String, String>();
			Iterator iter = payNo2.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				packageParams2.put((String) entry.getKey(), (String) entry.getValue());
			}
			String checkSign = reqHandler.createSign(packageParams2);
			if (prepay_id.equals("")) {
				request.setAttribute("ErrorMsg", "统一支付接口获取预支付订单出错");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
		String packages = "prepay_id=" + prepay_id;
		finalpackage.put("appid", PayCommonConfig.qcc_kfpt_appid);
		finalpackage.put("partnerid", PayCommonConfig.qcc_kfpt_mchid);
		finalpackage.put("prepayid", (String) payNo2.get("prepay_id"));
		finalpackage.put("package", "Sign=WXPay");
		finalpackage.put("noncestr", (String) payNo2.get("nonce_str"));
		finalpackage.put("timestamp", timestamp);
		String finalsign = reqHandler.createSign(finalpackage);

		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", PayCommonConfig.qcc_kfpt_appid);
		map.put("partnerid", PayCommonConfig.qcc_kfpt_mchid);
		map.put("prepayid", (String) payNo2.get("prepay_id"));
		map.put("package", "Sign=WXPay");
		map.put("noncestr", (String) payNo2.get("nonce_str"));
		// 注：此处有一个坑，APP支付必须拿微信回传给你的值，而公众号支付却可以用自己生成的随机串
		map.put("timeStamp", timestamp);
		map.put("sign", finalsign);
		String json = MyJsonUtil.objectToJson(map);
		return ResultMap.IS_200(json);
	}

}
