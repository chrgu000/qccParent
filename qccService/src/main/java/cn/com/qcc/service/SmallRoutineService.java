package cn.com.qcc.service;


import org.springframework.web.client.RestTemplate;

import weixin.util.WxMssVo;


public interface SmallRoutineService {
	/***
	 * @param openid : 用户openid
	 * @param formid : 表单id
	 * @param temid  : 模板id
	 * @param datalist : 数据集合
	 * @param type : 小程序类型
	 * 
	 * **/
	public String pushOneUser(String openid, 
			String formid ,String temid ,WxMssVo uxMssVo , String type
			,RestTemplate restTemplate) ;

}
