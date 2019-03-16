package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;


public interface VipCountService {

	/**  根据用户ID查询VIP表记录 
	 *  @param userid : 用户
	 * **/
	Vipcount getVipByUserID(Long userid);

	/** 有选择的更新VIP表的状态
	 * **/ 
	void updateVipSelective(Vipcount vipcount);

	/**
	 * 插入VIP表余额
	 * **/ 
	void insertVipCount(Vipcount vip_new);

	/**
	 * 会员的充值记录
	 * */ 
	List<Vipcount> searchrecharge(String userid);

	/** 查询余额和可以访问的房间的属于次数
	 * @param userid : 用户ID
	 * **/ 
	List<Vipcount> searchbalance(String userid);

	// 查询可以预览求租的次数
	public int findVipCount(Long userid);

	/** 更新VIP的次数 
	 * @param userid : 用户ID
	 * @param count : 求租次数。 
	 * 
	 * */ 
	void updateVipCount(Vipcount vipcount);
	
	/**查询系统用户钱包
	 * 
	 * **/
	int getalluserburseCount(UserVo userVo);
	List<VipCountCustomer> getalluserburse(UserVo userVo);

	
	/**
	 * 查询金币明细
	 * @param userid : 用户ID的集合
	 * **/
	List<VipCountCustomer> searchjbmx(String[] userid, PageQuery pagequery);
	int searchjbmxCount(String[] userid);
	
	/**
	 * 查询收益明细
	 * @param userid : 用户ID的集合
	 * */
	List<VipCountCustomer> searchsymx(String[] userid, PageQuery pagequery);
	int searchsymxCount(String[] userid);
	
	/**查询红币明细
	 * @param userid [] : 用户对象ID 的集合
	 * @param pagequery : 分页对象
	 * **/
	List<VipCountCustomer> searchhbmx(String[] userid, PageQuery pagequery);
	int searchhbmxCount(String[] userid);
	
	/*** 查询求租次数明细
	 *   @param userid : 用户对象集合
	 *   @param pagequery : 分页参数
	 * */
	List<VipCountCustomer> searchhymx(String[] userid, PageQuery pagequery);
	int searchhymxCount(String[] userid);
	
	/**查询七彩币明细
	 * @param  userid[] : 用户对象集合
	 * @param  pagequery : 分页参数 
	 * 
	 * **/
	List<VipCountCustomer> searchxfmx(String[] userid, PageQuery pagequery);
	int searchxfmxCount(String[] userid);
	
	/**
	 * 修改账户余额
	 * **/
	void changevipcount(Vipcount vipcount);
	
	/**
	 * 提现记录表插入一条记录
	 * @param partner_trade_no : 商户订单
	 * @param outaccount : 提现金额
	 * @param descname : 提现描述
	 * @param userid : 提现人
	 * @param type :提现的类型 1-微信 2-支付宝
	 * 
	 * **/
	void insertpartner(String partner_trade_no, Double outaccount, String descname, Long userid, int type);
	
	/**解绑微信账号**/
	void deleteweixinaccount(Long userid);
	
	/**清空授权**/
	void clearUnionId(Long userid);
}
