package cn.com.qcc.service;

import cn.com.qcc.queryvo.UserRoomCustomer;

public interface UserRoomService {
	
	
	/**获取管理员或者房东的登录信息**/
	UserRoomCustomer getLandOrManagerMess(Long telephone);

}
