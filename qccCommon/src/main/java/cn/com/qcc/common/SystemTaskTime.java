package cn.com.qcc.common;


/** 
 *    注：       秒   分   时  日  月 星期几    年 
 *         * 所有字段 如 5 * * *  *  *   (每到秒为5时候执行)
 *         ? 用在日 星期几 表示不明确的值
 * 		   - 一个范围
 * 		   , 表示这些值时候执行
 * 	       / 表示执行的频率
 * 
 * 		 "0 10,44 14 ? 3 WED"三月的每周三的14：10和14：44触发	
 * 		 "0 10 2 ? * THU" 每周三的2点10触发
 * 		 0 0 0 * * 
 * 
 * **/

public class SystemTaskTime {
	
	/**每天  凌晨 0:10   删除临时文件夹里面的数据  **/
	public static final String delete_uploadpic = "0 10 0 * * ?";
	
	/**  * 每天晚上  凌晨  0:30  执行 , 同步 小区 楼栋 房源的视频  * **/
	public static final String sync_vedio = "0 30 0 * * ?";
	
	/**  每天晚上  凌晨    1:50        执行 , 生成对应的二维码图片  **/
	public static final String build_xpxpicture = "0 10 1 * * ?";
	
	/**同步房源 到索引库  2:10        **/
	public static final String sysc_house = "0 10 2 * * ?";
	
	/**同步房源 到索引库  2:20   **/
	public static final String sysc_building = "0 20 2 * * ?";
	
	/**同步房源 到索引库  2:30   **/
	public static final String sysc_village = "0 30 2 * * ?";
	
	
	/**生成海报二维码 3:00   **/
	public static final String buil_PostImage = "0 0 3 * * ?";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**  * 每天晚上凌晨  6:00  * **/
	public static final String every_day_04 = "0 0 6 * * ?";
	
	
	
	
	
	//每隔5秒钟执行一次  
	public static final String fivesecond = "0/5 * * * * ? ";	
	
	//每隔10分钟执行一次
	public static final String minutes_10  = "10 0/10 * * * ? ";	
	

	
	public static final String MONTH_END_22 = "0 0 22 LAST * ?";

	
	
	
	
	
	
	/**每个 周六  凌晨 5:10   同步求租的浏览量  **/
	public static final String sysc_qiuzu = "0 10 5 ? * SAT";	
	
	/**每个 周六  凌晨 5:30   同步求租的浏览量  **/
	public static final String sysc_buil = "0 30 5 ? * SAT";
	
	/**每个 周六  凌晨 5:30   同步部落的浏览量  **/
	public static final String sysc_tribe = "0 50 5 ? * SAT";



	/**  * 每天晚上凌晨 23:00  点执行 , 吧对应的收益加入到用户的总收益中提供提现操作 * **/
	public static final String addlucre = "0 0 23 * * ?";
	
	/**  23:30  ***/
	public static final String house_undercarriage = "0 30 23 ? * SAT";	
	
	

}
