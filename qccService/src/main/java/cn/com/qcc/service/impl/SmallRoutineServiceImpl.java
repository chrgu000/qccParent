package cn.com.qcc.service.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.service.SmallRoutineService;
import weixin.util.WxMssVo;

@Service
public class SmallRoutineServiceImpl implements SmallRoutineService {

	// 用来请求微信的get和post
	

	public String pushOneUser(String openid, String formid ,
			String temid ,WxMssVo uxMssVo , String type
			,RestTemplate restTemplate) {

		String appid = PayCommonConfig.qcc_xiaochengxuappid;
		String Secret =  PayCommonConfig.qcc_xiaochengxuSecret ;
		
		if (CheckDataUtil.checkisEqual(type, "fdzz")) {
			appid = PayCommonConfig.fdzz_xiaochengxuappid;
			Secret = PayCommonConfig.fdzz_xiaochengxuSecret;
		}
		
		if (CheckDataUtil.checkisEqual(type, "gzfzz")) {
			appid = PayCommonConfig.gzfzz_xiaochengxuappid;
			Secret = PayCommonConfig.gzfzz_xiaochengxuSecret;
		}
		
		// 获取access_token
		String access_token = IDUtils.getxiaoAccessToken(appid,Secret);
		
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send" +
				"?access_token=" + access_token;
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, uxMssVo, String.class);
		System.out.print("小程序推送结果={}" + responseEntity.getBody());
		
		return responseEntity.getBody();
	}



}
