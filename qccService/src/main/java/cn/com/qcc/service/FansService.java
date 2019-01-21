package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.queryvo.UserCustomer;


public interface FansService {

	/**查看关注的数量
	 * @param userid : 用户ID
	 * **/ 
	int findFollowCountByUserId(Long userid);

	/**查看粉丝的数量
	 * @param userid : 用户ID
	 * **/ 
	int findFansCountByUserIdandFolllowid(Long userid);

	/** 根据用户ID查询关注的集合
	 * @param userid : 用户ID
	 * **/
	List<UserCustomer> findFollowByUserId(Long userid ,PageQuery pagequery);
	int findFollowByUserIdCount(Long userid);
	/**根据用户ID查询粉丝的集合
	 * @param userid : 用户ID
	 * **/ 
	List<UserCustomer> findFansByUserId(Long userid,PageQuery pagequery);
	int findFansByUserIdCount(Long userid);

	/**查询某个人是否是某个人的粉丝
	 * @param userid : 关注者ID
	 * @param followuserid : 被关注者ID
	 * 
	 * **/ 
	String findIsFans(Long userid, Long followUserId);

	/** 添加关注后就成为了别人的粉丝
	 * @param userid : 关注者ID
	 * @param followuserid : 被关注者ID
	 * **/
	String insertfans(Long userid, Long followUserId);

	/** 取消关注
	 * @param userid : 当前用户ID
	 * @param followuserid : 取消关注的那个人ID
	 * **/ 
	void removeFans(Long userid, Long followUserId);

	/**
	 *  更改粉丝的状态
	 *  @param userid : 当前用户id
	 *  @param followUserId : 粉丝的userid
	 * **/
	void updateFansState(Long userid, Long followUserId);

}
