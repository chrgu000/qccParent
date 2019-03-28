package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Villagetrategy;
import cn.com.qcc.queryvo.TrategyCustomer;

public interface TrategyService {
	
	/**发布小区攻略**/
	ResultMap addHousestrategy(Villagetrategy trategy);
	
	/**编辑的查询*/
	ResultMap editSearch(Long housestrategyid);

	ResultMap update(Villagetrategy trategy);
	
	/**根据用户id
	 *  查询攻略列表
	 * **/
	List<TrategyCustomer> searchList(Long userid, PageQuery pagequery);
	int searchListCount(Long userid);
	
	List<TrategyCustomer> searchTrageryByVillageId(Long villageid);
	
	/**删除攻略**/
	ResultMap delete(Long userid, Long trategyid);

}
