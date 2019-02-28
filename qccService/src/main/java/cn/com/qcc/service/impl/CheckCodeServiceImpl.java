package cn.com.qcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.service.CheckCodeService;

@Service
public class CheckCodeServiceImpl implements CheckCodeService{
	
	@Autowired
	JedisClient jedisClient;

	/**校验验证码的准备性**/
	public ResultMap DoCheckPhoneCode(String code, Long telephone) {
		// 先从redis取出验证
		String phoneCode = jedisClient.get(RedisUtil.PHONE_CODE_SEND + telephone);
		// 如果两个验证码都是空验证失败
		if (CheckDataUtil.checkisEmpty(code) || CheckDataUtil.checkisEmpty(phoneCode)) 
			return ResultMap.build(400, "验证码失效");
		// 在吧原始验证码进行转码
		code =getBASE64(code);
		// 如果两次验证码不一致
		if (CheckDataUtil.checkNotEqual(code, phoneCode)) 
			return ResultMap.build(400, "验证码错误");
		return ResultMap.build(200, "验证成功");
	}
	
	
	
	// 将 s 进行 BASE64 编码
	@SuppressWarnings("restriction")
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

}
