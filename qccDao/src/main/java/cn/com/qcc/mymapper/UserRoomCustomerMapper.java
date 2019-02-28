package cn.com.qcc.mymapper;

import cn.com.qcc.queryvo.UserRoomCustomer;

public interface UserRoomCustomerMapper {
	
	/**查询房东的登录信息**/
	UserRoomCustomer getLandMess(Long telephone);

	/**查询管理员的登录信息**/
	UserRoomCustomer getManagerMess(Long telephone);

}
