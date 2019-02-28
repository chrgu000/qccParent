package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;

/**校验验证码**/
public interface CheckCodeService {
	
	/**校验验证码的准备性**/
	ResultMap DoCheckPhoneCode(String code , Long telephone);

}
