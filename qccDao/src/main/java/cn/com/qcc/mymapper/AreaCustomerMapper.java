package cn.com.qcc.mymapper;

import cn.com.qcc.pojo.Area;

public interface AreaCustomerMapper {
	
	//根据城市名称获取到code
	Long getcodebycity(String city);
	
	Area getmaxareacode(Long code);

}
