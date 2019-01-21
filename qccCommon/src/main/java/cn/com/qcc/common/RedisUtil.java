package cn.com.qcc.common;

public class RedisUtil {
	
	/**求租的key*/
	public static final String QIUZU_FIRST_KEY = "qiuzudetail:";
	/**求租的过期时间 15天**/
	public static final Integer QIUZU_OUT_TIME = 60*60*24*15;
	
	
	public static final String  HOUSE_FIRST_KEY= "housedetail:";
	public static final Integer HOUSE_OUT_TIME = 60*60*24*15;
	
	public static final String  BUIL_FIRST_KEY = "buildingdetail:";
	public static final Integer BUIL_TIME_OUT = 60*60*24*15;
	
	public static final String  TRIBE_FIRST_KEY = "tribedetail:";
	public static final Integer TRIBE_OUT_TIME = 60*60*24*15;
	
	public static final String  ARTICLEDETAIL_FIRST_KEY="articledetail:";
	public static final Integer ARTICLEDETAIL_OUT_TIME = 60*60*24*15;
	

}
