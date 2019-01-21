package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;

/**
 * 账单记录
 * **/
public interface ConsumeService {

	// 生成支付宝提交订单
	//public String generateZFB(Consume consume, String returnUrl);

	/**
	 * 修改账单
	 * **/ 
	public void updateConsume(Consume consume);

	/**添加账单
	 * **/ 
	public void addConsume(Consume consume);

	/**
	 * 增加余额
	 * **//* 
	public void increaseBalance(Consume consume);
    */
	
	
	/**
	 * 根据账单ID获取订单详情
	 * **/ 
	public Consume getConsumeById(Long consume_id);


	/**查询消费信息记录
	 * @param userid : 用户ID 
	 * 
	 * **/ 
	public List<Consume> searchexpense(UserVo userVo);
	public int searchexpenseCount(UserVo userVo);
	
	
	/**获取订单号**/
	public Long ordernum ();
	
	/** 查询我的钱包
	 * @param user_id : 用户id
	 * **/ 
	public VipCountCustomer getmyburse(Long userid , int day);

	
	/**
	 * 更新发布内容详情
	 * **/
	public void updateArticle(Articledetail articledetail);

	/** 查询充值记录
	 * @param userid : 用户ID 
	 * @param currentpage : 当前页面
	 * @param pagesize : 每页条数
	 * **/ 
	public List<Consume> searchrecharge(UserVo userVo);
	public int searchrechargeCount(UserVo userVo);

	
	/**
	 * 根据主键查询vipcount
	 * **/
	public Vipcount checkvipcount(Long user_id);

	/**
	 * 编辑vipcount表的求租次数
	 * **/
	public void updatevipcount(Vipcount vipcount , Long intecount);
}
