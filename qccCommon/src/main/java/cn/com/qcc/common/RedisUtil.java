package cn.com.qcc.common;

public class RedisUtil {
	
	/**求租相关*/
	public static final String QIUZU_FIRST_KEY = "qiuzudetail:";
	public static final Integer QIUZU_OUT_TIME = 60*60*24*15;
	
	/**房源相关**/
	public static final String  HOUSE_FIRST_KEY= "housedetail:";
	public static final Integer HOUSE_OUT_TIME = 60*60*24*15;
	
	/**楼栋详情**/
	public static final String  BUIL_FIRST_KEY = "buildingdetail:";
	public static final Integer BUIL_TIME_OUT = 60*60*24*15;
	
	/**部落相关**/
	public static final String  TRIBE_FIRST_KEY = "tribedetail:";
	public static final Integer TRIBE_OUT_TIME = 60*60*24*15;
	
	/**物品发布相关**/
	public static final String  ARTICLEDETAIL_FIRST_KEY="articledetail:";
	public static final Integer ARTICLEDETAIL_OUT_TIME = 60*60*24*15;
	
	/**
	 * 导入房源库id自增主键
	 * 过期时间40天. 一般三十天够了 这里多设置一点。也是没得问题
	 * **/
	public static final String  HOUSE_MODEL_KEY = "houseModelId:";
	/***过期时间2年***/
	public static final Integer HOUSE_MODEL_OUT_TIME = 60*60*24*360*2;
	
	/**手机验证码**/
	public static final String PHONE_CODE_SEND = "telephoneCode:";
	/***验证码过期时间  10分钟***/
	public static final Integer PHONE_CODE_SEND_TIME = 60*10;
	
	/**BD_自增主键**/
	public static final String BD_INSERT_ID = "bdInsert:";
	

}
