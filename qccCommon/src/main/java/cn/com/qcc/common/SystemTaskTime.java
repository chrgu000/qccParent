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
	
	/**每个 周六  凌晨 2:10   删除临时文件夹里面的数据  **/
	public static final String delete_uploadpic = "0 10 2 ? * SAT";	
	
	/**
	 * 每天晚上  凌晨  4:30  执行 , 生成对应的二维码图片
	 * **/
	public static final String build_xpxpicture = "0 30 4 * * ?";
	
	/**
	 * 每天晚上凌晨4
	 * **/
	public static final String every_day_04 = "0 0 4 * * ?";
	
	
	/**
	 * 每天晚上凌晨1点执行 , 吧对应的收益加入到用户的总收益中提供提现操作
	 * **/
	public static final String addlucre = "0 0 1 * * ?";
	
	//每隔5秒钟执行一次  
	public static final String fivesecond = "0/5 * * * * ? ";	
	
	//每隔10分钟执行一次
	public static final String minutes_10  = "10 0/10 * * * ? ";	
	
	/**
	 * 如果房源长时间没有更新自动下架 [每个周六凌晨3点10分]
	 * **/
	public static final String house_undercarriage = "0 10 3 ? * SAT";	
	
	public static final String MONTH_END_22 = "0 0 22 LAST * ?";
	

}
