package cn.com.qcc.mymapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.HousepayCustomer;
import cn.com.qcc.queryvo.UserCentCustomer;

public interface HouseRoomCustomerMapper {
	
	/***根据条件查询房态图**/
	List<HouseRoomCustomer> roompattern(HouseVo houseVo);
	int roompatternCount(HouseVo houseVo);
	
	/**根据id集合查询housepay数据**/
	List<HousepayCustomer> getPayModel(@Param("idsList")List<String> idList);


	
	/**根据租约id查询房源信息**/
	UserCentCustomer searchCentHouseMess(Long userCentId);
	
	/**获取房东的区域范围**/
	List<BuildingCustomer> getlandareaname(BuildingCustomer buildingCustomer);
	List<BuildingCustomer> getlandbuildingname(BuildingCustomer buildingCustomer);
	
	/**根据订单id的集合查询需要支付的金额总和**/
	HouseRoomCustomer getpayMonery(@Param ("idsList")String[] split);
	
	/**修改订单为已支付状态**/
	void updateHousePayIsPay( @Param ("idsList") String[] housePayIds);
	

}
