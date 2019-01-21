package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.queryvo.LandlordCustomer;


public interface LandLordCustomerMapper {
	
	List<LandlordCustomer> landloadsearch(@Param("pagequery")PageQuery pagequery 
			,@Param("landstate") String landstate);
	int landloadsearchCount(@Param("landstate")String landstate);
	
	
	LandlordCustomer landloadsearchdetail(@Param("userid")Long userid);

}
