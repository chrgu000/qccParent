package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.LandloadBroker;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;

public interface BrokerService {
	
	/**
	 * 经纪人入驻
	 * **/
	ResultMap bebroker(Broker broker);
	
	/**
	 * 实名认证
	 * **/
	ResultMap brokeruser(Profile profile);
	
	/**
	 * 找经纪人
	 * **/
	List<UserCustomer> searchbroker(UserCentVo user);
	int searchbrokerCount(UserCentVo userCentVo);
	
	/**通过城市查询code
	 * @param city : 城市的名称
	 * 
	 * **/
	String getcodebycity(String city);
	
	/**
	 * 查询我的房东
	 * **/
	List<UserCustomer> searchmylandload(UserVo userVo);
	int searchmylandloadCount(UserVo userVo);
	
	
	/**
	 * 查询哪些房东申请加我为经济人
	 * ***/
	int searchmylandloadnewcount(UserVo userVo);
	
	
	/**
	 * 查询我的的经济人
	 * **/ 
	List<UserCustomer> searchmybroker(UserVo userVo);
	int searchmybrokerCount(UserVo userVo);
	
	
	// 查询哪些经济人申请我为房东
	int searchmybrokernewcount(UserVo userVo);
	
	/**
	 * 根据条件查询类似经纪人
	 * **/
	List<UserCustomer> searchlikebroker(UserCustomer search);
	
	/**
	 * 根据userid 查询经纪人
	 * **/
	Broker searchbrokeruserbyid(Long userid);
	
	/**
	 * 查询想要添加的房东
	 * **/
	List<UserCustomer> searchlikeaddlandlord(UserCustomer search);
	
	/**房东添加经纪人
	 * @param landuserid : 房东的userid
	 * @param brokeruserid : 经纪人的userid
	 * **/
	ResultMap landaddbroker(Long landuserid, Long brokeruserid);
	
	/**经纪人添加房东
	 * @param landuserid : 房东的userid
	 * @param brokeruserid : 经纪人的userid
	 * **/
	ResultMap brokerandland(Long landuserid, Long brokeruserid);
	
	/**
	 * 房东查询经纪人的申请
	 * @param landuserid : 房东的userid
	 * **/
	List<UserCustomer> landsearchbrokerapply(Long landuserid);
	
	/**经纪人查询房东的申请列表
	 * @param brokeruserid : 经纪人的userid
	 * **/
	List<UserCustomer> brokersearchlandapply(Long brokeruserid);
	
	/**
	 * 根据当前userid 和查询的userid i 校验数据是否存在
	 * **/
	LandloadBroker checklandbroker(Long userid, Long searchuserid);

	/**更新 房东和经纪的状态
	 * @param userid : 当前的用户userid 也就是房东id
	 * @param searchuserid ：更新的经纪人的userid
	 * @param state ：更新的状态码
	 * **/ 
	ResultMap landapprovebroker(Long userid, Long searchuserid, Long state);
	
	/**经济人处理房东 的 申请
	 * @param userid : 当前用户的userid 经纪人的 userid
	 * @param searchuserid : 更新的房东的userid
	 * @param state : 更新的状态码
	 * 
	 * ***/
	ResultMap brokerapproveland(Long searchuserid, Long userid, Long state);

}
