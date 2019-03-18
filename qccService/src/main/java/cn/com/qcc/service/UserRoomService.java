package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.UserRoomCustomer;

public interface UserRoomService {
	
	
	/**获取管理员或者房东的登录信息**/
	UserRoomCustomer getLandOrManagerMess(Long telephone);
	
	
	/**
	 * 查询租约详情
	 */
	public ResultMap usercentdetail(String usercentnum);
	
	/**
	 * 根据租约编号查询账单详情
	 */
	public ResultMap financialbycentnum(String usercentnum);

	/**通过用户id查询 待支付的房源账单**/
	ResultMap findhousebile(Long userid);

	/**用户拒绝签约**/
	ResultMap userNotCent(Long userid, Long usercentid);

}
