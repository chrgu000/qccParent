package cn.com.qcc.tenement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.CentFileSend;
import cn.com.qcc.common.ParamUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.HouseOrderCustomer;
import cn.com.qcc.service.HouseService;

/**
 * 此方法专门做微信退款用。
 */
@Controller
public class WeiXinPayRefund {

	@Autowired
	private HouseService houseService;

	/**
	 * 预定房源退款操作
	 * 
	 * @param :
	 *            houseorderid 预定订单Id
	 **/
	@RequestMapping(method = RequestMethod.POST, value = "/houseorderrefund")
	@Transactional
	@ResponseBody
	public ResultMap refund(String houseorderid, HttpServletRequest request, Long userid, String refundmess) {
		if (houseorderid == null || "".equals(houseorderid) || userid == null) {
			return ResultMap.build(400, "检查订单/参数");
		}

		// Houseorder houseorder = houseService.gethouseorderbyid(houseorderid);
		HouseOrderCustomer houseorder = houseService.searchorderpay(Long.valueOf(houseorderid));
		if (houseorder == null) {
			return ResultMap.build(400, "检查订单");
		}
		// 校验当前订单是否可以退
		if (houseorder.getPaystate() == 6) {
			return ResultMap.build(400, "该订单已退款");
		} else if (houseorder.getPaystate() == 2) {
			return ResultMap.build(400, "未支付不可退款");
		} else if (houseorder.getPaystate() == 5) {
			return ResultMap.build(400, "已入住不可退款");
		} else if (houseorder.getPaystate() == 1 || houseorder.getPaystate() == 4) {
			// 如果是用户发起的退款判断当前用户
			if (houseorder.getSenduserid() == userid.longValue() || houseorder.getUserid() == userid.longValue()) {
				if (houseorder.getUserid() == userid) {
					if (houseorder.isFlag() == false) {
						return ResultMap.build(400, "订单退款超时");
					}
				}
				// 退款金额
				String account = houseorder.getPrices() * 100 + "";
				// 退款订单号
				String outTradeNo = houseorder.getWeixinorder();
				// 通过参数请求形成 xml 数据
				String xmlparam = ParamUtil.getRefundParam(account, outTradeNo);
				// 执行证书请求 和 xml 数据执行证书请求
				String xml = CentFileSend.house_refund(xmlparam);
				// 通过调用工具判断解析的xml最终数据
				ResultMap checkmap = ParamUtil.checkxmlpres(xml);
				// 说明微信操作成功
				if (checkmap.getCode() == 200) {
					// 如果退款成功执行相关业务逻辑
					houseService.updatehouseorder(houseorder.getUserid(), Long.valueOf(houseorderid), 6, refundmess);
				}
				return checkmap;
			} else {
				return ResultMap.build(400,"请不要退款别人的订单");
			}
			
		} else {
			return ResultMap.build(400, "错误的订单状态");
		}
	}

	public static void main(String[] args) {
		try {

			/*
			 * String currTime = PayUtils.getCurrTime(); String strTime =
			 * currTime.substring(8, currTime.length()); String strRandom =
			 * PayUtils.buildRandom(4) + ""; String nonceStr = strTime +
			 * strRandom; String outRefundNo = "wx@re@" +
			 * PayUtils.getTimeStamp(); String outTradeNo =
			 * "154234049950627cz100000018"; //String unionId = openid; String
			 * appid = Constant.APP_ID; String mchid = Constant.MCH_ID; String
			 * key = Constant.APP_KEY;// mch_key // String key =
			 * ResourceUtil.getConfigByName("wx.application.mch_key"); if
			 * (!StringUtils.isEmpty(houseorderid)) { Houseorder houseorder =
			 * houseService.gethouseorderbyid(houseorderid); int total_fee =
			 * (int) (houseorder.getPrices() * 100); // 商户侧传给微信的订单号32位
			 * outTradeNo = houseorder.getWeixinorder(); DecimalFormat df = new
			 * DecimalFormat("0.00"); // String fee =
			 * String.valueOf(df.format((float)total_fee/100)); String fee =
			 * String.valueOf(total_fee); SortedMap<String, String>
			 * packageParams = new TreeMap<String, String>();
			 * packageParams.put("appid", appid); packageParams.put("mch_id",
			 * mchid);// 微信支付分配的商户号 packageParams.put("nonce_str", nonceStr);//
			 * 随机字符串，不长于32位 packageParams.put("op_user_id", mchid);// 操作员帐号,
			 * 默认为商户号 // out_refund_no只能含有数字、字母和字符_-|*@
			 * packageParams.put("out_refund_no", outRefundNo);//
			 * 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
			 * packageParams.put("out_trade_no", outTradeNo);// 商户侧传给微信的订单号32位
			 * packageParams.put("refund_fee", fee);
			 * packageParams.put("total_fee", fee);
			 * //packageParams.put("transaction_id", transactionId);//
			 * 微信生成的订单号，在支付通知中有返回 String sign =
			 * PayUtils.createSign(packageParams, key);
			 * 
			 * String refundUrl =
			 * "https://api.mch.weixin.qq.com/secapi/pay/refund"; String
			 * xmlParam = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
			 * + mchid + "</mch_id>" + "<nonce_str>" + nonceStr + "</nonce_str>"
			 * + "<op_user_id>" + mchid + "</op_user_id>" + "<out_refund_no>" +
			 * outRefundNo + "</out_refund_no>" + "<out_trade_no>" + outTradeNo
			 * + "</out_trade_no>" + "<refund_fee>" + fee + "</refund_fee>" +
			 * "<total_fee>" + fee + "</total_fee>" + "<sign>" + sign +
			 * xmlParam); String resultStr = PayUtils.post(refundUrl, xmlParam);
			 * // 解析结果 try { Map map = PayUtils.doXMLParse(resultStr);
			 * map.get("return_code").toString(); if
			 * (returnCode.equals("SUCCESS")) { String resultCode =
			 * map.get("result_code").toString(); if
			 * (resultCode.equals("SUCCESS")) { // 退款成功。设置订单状态为 6 。表示全额退款
			 * .同时设置房子为可以租的状态
			 * houseService.updatehouseorder(houseorder.getUserid(),
			 * houseorder.getHouseid(), 6); return ResultMap.build(200, "退款成功");
			 * } else { return ResultMap.build(400, "退款失败"); } } else { return
			 * ResultMap.build(400, "退款失败"); } } catch (Exception e) {
			 * e.printStackTrace(); return ResultMap.build(400, "退款失败"); } }
			 * return ResultMap.build(200, "退款成功");
			 */

			// new WeiXinPayRefund().refund("1", request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
