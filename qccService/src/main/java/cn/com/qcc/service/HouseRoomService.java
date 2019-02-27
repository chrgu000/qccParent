package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;

public interface HouseRoomService {
	
	/**房态图列表**/
	List<HouseRoomCustomer> roompattern(HouseVo houseVo);
	int roompatternCount(HouseVo houseVo);

}
