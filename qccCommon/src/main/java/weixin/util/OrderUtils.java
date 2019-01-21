package weixin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单工具类
 * @author liyizhong
 * @since 2017年6月23日16:22:51
 */
public class OrderUtils {
	
	public static String genOrderNo(){
		String orderNo = "bbm";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String nowTime = sdf.format(new Date());
		orderNo+=nowTime;
		return orderNo;
	}

}
