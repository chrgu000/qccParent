package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.activemq.camel.component.broker.BrokerConsumer;
import org.apache.ibatis.annotations.Param;

import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;

public interface BrokerCustomerMapper {
	
	// 查询我的房东
	List<UserCustomer> searchmylandload(UserVo userVo);
	int searchmylandloadCount(UserVo userVo);
	
	//查询哪些房东申请加我为经济人
	int searchmylandloadnewcount(UserVo userVo);
	
	//查询我的经济人
	List<UserCustomer> searchmybroker(UserVo userVo);
	int searchmybrokerCount(UserVo userVo);
	
	//查询哪些经济人申请
	int searchmybrokernewcount(UserVo userVo);
	
	//查询想要添加的经纪人
	List<UserCustomer> searchlikebroker(UserCustomer search);
	
	//查询想要添加的 房东
	List<UserCustomer> searchlikeaddlandlord(UserCustomer search);
	
	//更新他们之间的关系
	void updatelandaddbroker( @Param("landuserid")Long landuserid, @Param("brokeruserid") Long brokeruserid
			,@Param("state")Long state);
	
	//房东查询经纪人的申请
	List<UserCustomer> landsearchbrokerapply(Long userid);
	
	//经纪人查询房东的 申请列表
	List<UserCustomer> brokersearchlandapply(Long userid);
	
	// 根据区域查询经纪人和房东
	List<UserCustomer> searchlikebrokerbyCode(@Param("code")String fathercode);

}
