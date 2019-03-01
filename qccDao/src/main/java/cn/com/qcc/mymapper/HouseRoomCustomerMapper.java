package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCentCustomer;

public interface HouseRoomCustomerMapper {
	
	/***根据条件查询房态图**/
	List<HouseRoomCustomer> roompattern(HouseVo houseVo);
	
	/**根据id集合查询housepay数据**/
	List<Housepay> getPayModel(@Param("idsList")List<String> idList);

	int roompatternCount(HouseVo houseVo);
	
	/**根据租约id查询房源信息**/
	UserCentCustomer searchCentHouseMess(Long userCentId);

}
