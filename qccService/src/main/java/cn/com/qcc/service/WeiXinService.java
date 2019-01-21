package cn.com.qcc.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author xgchen
 *
 */
public interface WeiXinService {

	String weixinPay(String userId, String productId, HttpServletRequest request) throws Exception;
}
