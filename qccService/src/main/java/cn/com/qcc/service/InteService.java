package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Integral;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Masonry;
import cn.com.qcc.queryvo.UserVo;

public interface InteService {

	/**查看房源扣除积分
	 * @param houseid : 房源ID
	 * @param userid : 用户ID
	 * @param type : 业务类型
	 * **/
	ResultMap searchphonedeletejinbi(Long houseid, Long userid,String type);

	/** 处理获得的积分
	 * @param commonid : 金币主键
	 * @param userid : 用户ID
	 * **/ 
	String managebranch(Long commonid, Long userid ,Long otherid);

	/**
	 *  我的积分消耗事件
	 * **/
	List<Integral> myinteout(UserVo userVo);
	int myinteoutCount(UserVo userVo);

	/**积分消耗处理
	 * @param commonid : 类型主键
	 * @param userid : 用户id
	 * @param otherid : 物品主键
	 * **/ 
	ResultMap consumebranch(Long commonid, Long userid , Long otherid);

	/**
	 * 这里是扣除积分之前的查询操作
	 * @param commonid : 类型主键
	 * @param userid : 用户id
	 * **/ 
	ResultMap consumebranchsearch(Long commonid, Long userid);

	/**
	 * 这里处理充值金币的回调
	 * 
	 * **/ 
	String chongzhirenturn(Integral integral, double monery);
	
	/**
	 * 判断是否通过关注获得积分
	 * @param userid: 用户id
	 * @param event : 时间名称
	 * **/
	boolean isgetjinbibyevent(Long commonid, Long userid);
	
	/**
	 * 我的洪币列表
	 * **/
	List<Masonry> mymasonrylist(UserVo userVo);
	int mymasonrylistCount(UserVo userVo);

	/** 查询积分是否充足
	 * @param commonid : 类型主键
	 * @param userid : 用户id
	 * **/
	boolean searchdelete(Long i, Long userid);
	
	
	//查询剩余积分
	public Long searchless ( Long userid );
	
	/***
	 *  分享成功获取金币
	 *  @param userid : 用户id
	 *  @param otherid : 分享的物品主键
	 * **/
	ResultMap shareaddjinbi(Long userid , Long otherid);
	
	
	/***
	 *  查询 第 n 天团队员工充值后 收益正常到账
	 *  @param daycount : 资金冷却的周期
	 * **/
	List<Lucre> searchNeedAddLurceByTime(int daycount);
	
	/***
	 *  将第n天的数据同步为已经正常收益状态
	 *  @param daycount : 资金冷却的周期
	 * **/
	void updateLurceIsAddByTime(int daycount);


}
