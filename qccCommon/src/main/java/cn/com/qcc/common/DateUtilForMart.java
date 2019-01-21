package cn.com.qcc.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilForMart {
	
	
	public static String FormmartDate(Date date) {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(date).toString();
	}

}
