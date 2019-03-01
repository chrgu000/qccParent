package cn.com.qcc.service.impl;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.qcc.service.WeiXinService;
import weixin.util.HttpUtil;
import weixin.util.PayConfigUtil;
import weixin.util.PayToolUtil;
import weixin.util.XMLUtil4jdom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
@SuppressWarnings("unchecked")
@Controller
@Transactional
@RequestMapping("/userService")
public class WeiXinServiceImpl implements WeiXinService {

	@Override
	public String weixinPay(String userId, String rechargeAmount, HttpServletRequest request) throws Exception {

		String out_trade_no = "" + System.currentTimeMillis(); // 订单号
																// （调整为自己的生产逻辑）

		HttpSession session = request.getSession();
		session.setAttribute("out_trade_no", out_trade_no);

		String appid = PayConfigUtil.APP_ID; // appid
		String mch_id = PayConfigUtil.MCH_ID; // 商业号
		String key = PayConfigUtil.API_KEY; // key

		String currTime = PayToolUtil.getCurrTime();
		String strTime = currTime.substring(8, currTime.length());
		String strRandom = PayToolUtil.buildRandom(4) + "";
		String nonce_str = strTime + strRandom;

		// 获取发起电脑 ip
		String spbill_create_ip = PayConfigUtil.CREATE_IP;
		// 回调接口
		String notify_url = PayConfigUtil.NOTIFY_URL;
		String trade_type = "NATIVE";

		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", "红包活动充值"); // （调整为自己的名称）
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("total_fee", rechargeAmount); // 价格的单位为分
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", trade_type);

		String sign = PayToolUtil.createSign("UTF-8", packageParams, key);

		packageParams.put("sign", sign);

		String requestXML = PayToolUtil.getRequestXml(packageParams);
		String resXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL, requestXML);
		Map<String,Object> map = XMLUtil4jdom.doXMLParse(resXml);
		String urlCode = (String) map.get("code_url");
		return urlCode;
	}

}
