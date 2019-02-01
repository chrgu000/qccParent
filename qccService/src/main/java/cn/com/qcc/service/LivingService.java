package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Living;

public interface LivingService {
	
	
	/**根据typeid查询活动规则**/
	List<Living> searchByTypeId(Long typeid);
	
	/**根据typeid查询活动规则**/
	List<Living> searchAllByTypeId(Long typeid);
	
	/**上移**/
	ResultMap livingUp(Long typeid, Long livingid);
	
	/**新增分类**/
	ResultMap add(Living livng);

	ResultMap livingChange(Living living);

	Living searchOne(Long livingid);

	void delete(Long livingid);

}
