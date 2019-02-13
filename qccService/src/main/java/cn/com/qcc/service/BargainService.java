package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;

public interface BargainService {

	/**
	 * 作砍价操作
	 * @param opendid : 当前用户的openid
	 * @param userid : 发起人userid
	 * @param type : 操作的type类型
	 * @param otherid : 被砍物品
	 * **/
	ResultMap doBargin(String openid, Long userid, Integer type , Long oterhid);
	
	/**
	 * 查询砍价列表
	 * **/
	ResultMap searchList(Long userid, Integer type, Long otherid);

}
