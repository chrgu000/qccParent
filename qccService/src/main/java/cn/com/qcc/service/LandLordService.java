package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.LandlordCustomer;


public interface LandLordService {
	//查询所有房东信息
	List<LandlordCustomer> landloadsearch(PageQuery pagequery , String landstate);
	int landloadsearchCount(String landstate);

	LandlordCustomer landloadsearchdetail(Long userid);
	/**
	 * 修改房东状态
	 * @param userid : 房东的用户ID
	 * @param state : 状态码
	 * **/
	ResultMap checklandstate(Long userid, Integer state);

	

}
