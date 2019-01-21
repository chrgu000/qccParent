package cn.com.qcc.common;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;

/** 封装类型转换之内 **/
public class ParamUtil {

	/**
	 * 七彩巢公众号封装企业付款参数
	 * 
	 * @param openid
	 *            : 微信用户在公众平台的openid
	 * @param realname
	 *            : 收款方的真实姓名
	 * @param amount
	 *            : 金额 分为单位
	 * @param desc
	 *            : 收款的描述
	 **/
	public static SortedMap<String, String> getParmSorteMap(String openid, String realname, String amount, String desc,
			HttpServletRequest request ,String partner_trade_no ) {
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		// 企业付款的链接
		// String company_pay_url = PayCommonConfig.qiye_fukuan;
		// 公众平台 对应的商户号
		String mch_id = PayCommonConfig.qcc_gzh_mchid;
		// 公众平台 公众平台 app_id 商户号绑定的app_id
		String mch_appid = PayCommonConfig.qcc_gzhappid;
		// 随机字符串
		String nonce_str = UUID.randomUUID().toString().replaceAll("-", "");
		
		// 校验用户姓名
		String check_name = PayCommonConfig.FORCE_CHECK;
		// 收款方用户真实姓名
		// String re_user_name = "";
		// 操作金额单位 分
		// String amount = "100";
		// 企业备注
		// String desc = "余额提现";
		// 获取机器IP 地址
		String spbill_create_ip = IDUtils.spbill_create_ip(request);
		packageParams.put("mch_appid", mch_appid); // 商户号
		packageParams.put("mchid", mch_id);// 注意这里没下划线
											// ,我都不想说什么了,微信支付的时候这里是带下划线的,
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("partner_trade_no", partner_trade_no);
		packageParams.put("openid", openid);
		packageParams.put("check_name", check_name);
		packageParams.put("re_user_name", realname);
		packageParams.put("amount", amount);
		packageParams.put("desc", desc);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		String sign = HttpSign.createSign(packageParams, PayCommonConfig.qcc_gzh_partnerKey);
		packageParams.put("sign", sign);
		return packageParams;
	}

	/**
	 * 七彩巢公众号封装退款参数
	 * 
	 * @param account
	 *            : 退款金额
	 * @param outTradeNo
	 *            : 退款订单号也是交易订单号
	 **/
	public static String getRefundParam(String account, String outTradeNo) {

		// 小程序的appid
		String appid = PayCommonConfig.qcc_xiaochengxuappid;
		// 公众平台商户号
		String mch_id = PayCommonConfig.qcc_gzh_mchid;
		// 公众平台商户密钥
		String mck_partnerKey = PayCommonConfig.qcc_gzh_partnerKey;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		String nonceStr = UUID.randomUUID().toString().replaceAll("-", "");
		// 退款单号
		String outRefundNo = IDUtils.genItemId();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);// 微信支付分配的商户号
		packageParams.put("nonce_str", nonceStr);// 随机字符串，不长于32位
		packageParams.put("op_user_id", mch_id);// 操作员帐号, 默认为商户号
		// out_refund_no只能含有数字、字母和字符_-|*@
		packageParams.put("out_refund_no", outRefundNo);// 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
		packageParams.put("out_trade_no", outTradeNo);// 商户侧传给微信的订单号32位
		packageParams.put("refund_fee", account);
		packageParams.put("total_fee", account);

		// 创建签名
		String sign = HttpSign.createSign(packageParams, mck_partnerKey);
		String xmlParam = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>"
				+ nonceStr + "</nonce_str>" + "<op_user_id>" + mch_id + "</op_user_id>" + "<out_refund_no>"
				+ outRefundNo + "</out_refund_no>" + "<out_trade_no>" + outTradeNo + "</out_trade_no>" + "<refund_fee>"
				+ account + "</refund_fee>" + "<total_fee>" + account + "</total_fee>" + "<sign>" + sign + "</sign>"
				+ "</xml>";
		return xmlParam;
	}

	/** 此方法主要来解析XML数据返回的结果 **/
	public static ResultMap checkxmlpres(String xml) {
		try {
			@SuppressWarnings("rawtypes")
			Map map = HttpSign.doXMLParse(xml);
			String returnCode = map.get("return_code").toString();
			// 根据错误码返回错误信息
			String err_code = "操作成功";
			Object obj = map.get("err_code");
			if (obj !=null) {err_code = obj.toString();}
			String error_message ="";
			if ("AMOUNT_LIMIT".equals(err_code)) {error_message = "提现金额1-2000元";}
			if ("NAME_MISMATCH".equals(err_code)) {error_message="实名姓名不匹配";}
			if ("NOTENOUGH".equals(err_code)) {error_message = "平台余额不足";}
			if ("PARAM_ERROR".equals(err_code)) {error_message="提现账号异常";}
			if (returnCode.equals("SUCCESS")) {
				String resultCode = map.get("result_code").toString();
				if (resultCode.equals("SUCCESS")) {
					// 退款成功。设置订单状态为 6 。表示全额退款 .同时设置房子为可以租的状态
					// houseService.updatehouseorder(houseorder.getUserid(),
					// houseorder.getHouseid(), 6);
					return ResultMap.build(200, err_code);
				} else {
					return ResultMap.build(400, error_message);
				}
			} else {
				return ResultMap.build(400, error_message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "异常");
		}

	}
	
	
	
	

}
