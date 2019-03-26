package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Villagetrategy;

public interface HousestrategyService {
	
	/**发布小区攻略**/
	ResultMap addHousestrategy(Villagetrategy trategy);
	
	/**编辑的查询*/
	ResultMap editSearch(Long housestrategyid);

	ResultMap update(Villagetrategy trategy);

}
