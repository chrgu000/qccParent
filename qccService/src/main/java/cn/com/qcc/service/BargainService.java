package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Bargaindetail;

public interface BargainService {

	/**
	 * 作砍价操作
	 * @param opendid : 当前用户的openid
	 * @param userid : 发起人userid
	 * @param type : 操作的type类型
	 * @param otherid : 被砍物品
	 * **/
	ResultMap doBargin(Long preparatoryid, Long userid, Integer type, Long otherid, String reservationstel,
			String reservations);

	
	/**
	 * 查询砍价列表
	 * **/
	ResultMap searchList(Long barginid,String unionid , String userid);


	ResultMap doBargainDetail(Bargaindetail bargaindetail);


}
