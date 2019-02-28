package cn.com.qcc.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mymapper.UserRoomCustomerMapper;
import cn.com.qcc.queryvo.UserRoomCustomer;
import cn.com.qcc.service.UserRoomService;

@Service
public class UserRoomServiceImpl implements UserRoomService {
	
	@Autowired
	UserRoomCustomerMapper userRoomCustomerMapper;

	@Override
	public UserRoomCustomer getLandOrManagerMess(Long telephone) {
		// 第一步查询房东的登录信息
		UserRoomCustomer userRoomCustomer = userRoomCustomerMapper.getLandMess(telephone);
		// 如果查到数据 判断房东是否通过审核
		if (CheckDataUtil.checkNotEmpty(userRoomCustomer)) {
			//如果房东通过审核 直接返回数据
			if (userRoomCustomer.getLandstate() == 2) {
				return userRoomCustomer;
			}
		}
			
		// 第二步查询管理的登录信息  [如果上面条件 没有正常返回]  
		userRoomCustomer = userRoomCustomerMapper.getManagerMess(telephone);
		if (CheckDataUtil.checkNotEmpty(userRoomCustomer)) {
			//如果管理通过审核 直接返回数据
			if (userRoomCustomer.getLandstate() == 2) {
				// 如果是管理的话。 是否需要控制其房东分配给与的权限????
				return userRoomCustomer;
			}
		}
		//如果上诉数据都不成立则返回null 代表该用户不可以登录房东后台
		return null;
	}

}
