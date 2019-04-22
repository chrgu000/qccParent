package cn.com.qcc.common;


public class PayCommonConfig {
	
	/**本地临时上传目录的位置**/
	public static final String LOCAL_UPLOAD_PATH = "/root/apache-tomcat-7.0.79/webapps/fileUpload/";
	/**测试环境临时文件保存的路径**/
	//public static final String LOCAL_UPLOAD_PATH = "d://hello/";
	
	/**七彩巢房东端app 对应的 APPID**/ 
	public static final String LAND_APPID = "wx5721254e1aeb368f";
	
	/**七彩巢用户端app 对应的 APPID**/
	public static final String USER_APPID = "wx3bb942ba8c1e7923";
	
	/**七彩巢房东端app 对应的 AppSecret **/
	public static final String LAND_AppSecret = "5508cbdb4ea774bc930a4b0b6e513344";
	
	
	/**支付宝余额充值成功的回调页面**/ 
	public static final String zfb_paysuccess_returnpage = "https://www.zzw777.com/pages/balance.html";	
	
	/**支付宝七彩币充值的回调**/ 
	public static final String zfb_consume_recharge = "https://120.24.43.56/Tenement/consume/recharge";	
		
	/**支付宝会员充值的回调**/
	public static final String zfb_vip_recharge = "https://120.24.43.56/Tenement/vip/recharge";
	
	/** 微信  金币充值回调 **/ 
	public static final String jinbireturn = "https://www.zzw777.com/Tenement/jinbi/return";
	
	/** 微信 增值服务置顶回调 **/ 
	public static final String articletopreturn = "https://www.zzw777.com/Tenement/articletop/return";
	
	/** 微信 会员充值的回调  **/ 
	public static final String vippayreturn = "https://www.zzw777.com/Tenement/vip/return"; 
	
	/**
	 * 七彩币 充值的回调 和商城支付的回调
	 * **/ 
	public static final String consumepayreturn = "https://www.zzw777.com/Tenement/consume/return"; 
	
	/**  七彩巢主域名  ***/ 
	public static final String mainqccweb = "https://www.zzw.777.com"; 
	
	/*** 公租房直租小程序 appid  **/
	public static final String gzfzz_xiaochengxuappid = "wx02d1723d0572048c";
	
	/**  *房东直租小程序  appid   **/
	public static final String fdzz_xiaochengxuappid = "wx839bf86c7dd9d787"; 
	
	/** * 房东直租小程序secret **/
	public static final String fdzz_xiaochengxuSecret = "38306a9a0f91dcdeffd05beba32560a0";
	
	/**
	 * 公租房直租小程序secret
	 * **/
	public static final String gzfzz_xiaochengxuSecret = "a9bda36f5b1f0f8f64a416192a7274eb";
	
	/**
	 * 七彩巢小程序APPID
	 * **/
	public static final String qcc_xiaochengxuappid = "wxb22593f52614a217"; 
	
	/**
	 * 七彩巢小程序secret
	 * **/
	public static final String qcc_xiaochengxuSecret = "b01251595b6d2870e07197c512b57031";
	
	/**
	 * 七彩巢公众号对应的APPID
	 * **/
	public static final String qcc_gzhappid = "wx37a5a7281317047a";
	
	/**
	 * 七彩巢公众号对应的secret
	 * **/
	public static final String qcc_gzhsecret = "0949f5a62f702d5c5862b8478425e157";
	
	/** 七彩巢公众号对应的商户号  mch_id 1490776702 * **/
	public static final String qcc_gzh_mchid = "1490776702";
	
	/*** 七彩巢公众号对应的商户密钥  mch_ partnerKey * **/
	public static final String qcc_gzh_partnerKey = "123456789101112131415139399300Sz";
	
	/**
	 * 七彩巢 支付宝对应的 appid
	 * **/
	public static final String qcc_zfb_appid = "2017110609764510";
	
	/**
	 * 七彩巢 支付宝对应的 appid 应用私钥
	 * **/
	public static final String qcc_zfb_partnerKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKkZH0Un5FgWh4EK1PyrsfZwK5m7vOPo1kcfBiT4pUsKYfwdZwl9bUvhA3SIBB8QkFYbb0Xgx/EVoQ0SPoylv+FMPvgjDWCghY9HyAnoHZzB+T1XybYIyqktBIx8vBlGelp4sQtmrbe5b0j53tUoejooogUz7JmY6bDiaV7RZNOBAgMBAAECgYBS81zwmsocICkmtz6WGE+7mXj5+CuIDc8XonNsLYFAV36Lo4zJDftQrrf4MUT8TC7R3rFuMP9EF50igWGnsyN1wEugzKLF9rQ7blcxNK9EsFJsNXQmZmvfqkiPBrEX13WRkkB52U2wivwnTaaYKuCkDNJhFlcQqXISebkwRoP6wQJBAN68yhDgpJP0sZe9q6tus+Al5Qwh40jkHcBW8rUAd3bzntkT9nMYs+oTMYXKj5z4aeaAlnkT1QE076HnPdDI6JkCQQDCWbYt23XP81ekqhui2gq4SDhv1hK0CJv8dHLGm/WTgakIEBj1ZrxQQgrnygrxKczGXAZCMPsurV+3PPiPoQspAkAfqW5/368FaS8lhsy0XdQr9LcOdnK8ldC02qc9m4df3VmjOfc6fTR1/ax4fEbV5WoIXhcFtw/8T+4QcbKTzzthAkEArRTyHsLMmAayLe5ksFKYq2d+A3NVssncCSe3s9LfEJ+vZoPXhm0ZFizKw4R23DGKsbjwxfATMo2qqWh+QIN+iQJAP0PLxmNvIxSopJGOTY5u4no2kHPYKgiN8W53m/hxKBsvs/07kbVM5fsYP7ONmHvdrDqLaGrgPplP2nDBrSAUFQ==";
	
	/**
	 * 支付宝公钥，由支付宝生成
	 * **/ 
	public static final	String qcc_zfb_publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	
	/**
	 * 支付宝支付网关
	 * **/ 
	public static final	String qcc_zfb_zfwg = "https://openapi.alipay.com/gateway.do";
	
	/**
	 * 微信开放平台 appid APP支付
	 * **/ 
	public static final	String qcc_kfpt_appid = "wx5721254e1aeb368f";
	
	/**
	 * 微信开放平台 appid APP 支付 secret
	 * **/ 
	public static final String qcc_kfpt_secret = "5508cbdb4ea774bc930a4b0b6e513344";
	
	/**
	 * 微信开放平台 mchid APP支付
	 * **/ 
	public static final	String qcc_kfpt_mchid = "1509961881";
	
	/**
	 * 微信开放平台 mchid APP支付
	 * **/ 
	public static final	String qcc_kfpt_partnerkey = "h23456789101112131415139399300Sz";
	
	/**微信统一下单接口**/
	public static final	String weixin_tongyixiadan = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**F房源预订的回调**/
	public static final String houseyudingreturn ="https://www.zzw777.com/Tenement/houseyuding/return";
	
	/**企业付款链接**/
	public static final String qiye_fukuan = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

	/**不校验用户姓名**/
	public static final String NO_CHECK = "NO_CHECK";
	
	/**校验用户姓名*/
	public static final String FORCE_CHECK = "FORCE_CHECK";
	
	/**测试证书位置**/
	public static final String text_certPath = "D:/gzhcent/apiclient_cert.p12";
	
	/**公众号证书的位置**/
	public static final String gzh_KEY_PATH = "/usr/local/cents/apiclient_cert.p12";
	
	/**微信退款接口**/
	public static final String  refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	
	
	/**金币到账的延迟天数**/
	public static final int lurce_day_count = -10;
	
	
	/**群组的过滤距离 20km **/
	public static final int GROUP_DEFAULT_COLATION_JULI = 20 * 1000;
	
	/**交房租支付成功回调**/
	public static final String housepaySuccess = "https://www.zzw777.com/Tenement/housepay/success";
	
	
	/**七彩巢 小程序支付成功的模板id**/
	public static final String QCC_PAY_SUCCESS_TEMID = "F63LKrBZJaOtsasW9WQNlNKe_MY3IJdapUudCa0FmaM";
	
	/**房源预定成功 通知管理员处理**/
	public static final String HOUSE_YUDING_SUCCESS_NOTIC_MANAGER = "9634415";
	/**房源预定成功 通知租户**/
	public static final String HOUSE_YUDING_SUCCESS_NOTIC_USER = "9714561";
	
	/**七牛云返回的域名**/
	public final static String HADOOP_WEB_RETURN_PAHT = "http://www.hadoop.zzw777.com/";
}
