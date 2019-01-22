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
	

}
