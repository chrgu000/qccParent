package cn.com.qcc.mymapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.queryvo.BdManagerCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserRoomCustomer;

public interface BdCustomerMapper {

	List<UserCustomer> searchAddBD(@Param("searchWhere")String searchWhere,
			@Param("pagequery")PageQuery pagequery);
	int searchAddBDCount( @Param("searchWhere") String searchWhere);
	
	
	 // 根据登录账号查询登录信息
    BdManagerCustomer searchBDByPhoneOrId(String account);
    
    
    // 查询房东列表
 	List<UserRoomCustomer> getLandList(UserRoomCustomer userRoomCustomer);
 	
 	
 // 查询想要添加的房东
   	List<UserRoomCustomer> searchUserToLand( @Param("searchWhere")  String searchWhere);
   	
   	
	
	//查询想要添加的楼栋
	List<BuildingCustomer> searchAddBuildingToland( @Param("searchWhere") String searchWhere ,
			@Param("code") Long code , @Param("villageid")  Long villageid);
	
	/**根据房东id查询楼栋**/
	List<BuildingCustomer> searchBuildingBylandId(Long userid);
	
	/**编辑的查询**/
	UserRoomCustomer bdlandeditsearch(Long userid);

	BdManagerCustomer findOne(String bdid);

	List<BdManagerCustomer> listBD();
	
	/**查询想要编辑的品牌**/
	List<Brand> searchEditBrandList(@Param("code")String code,
			@Param("searchWhere") String searchWhere,@Param("pagequery") PageQuery pagequery);
	int searchEditBrandListCount(@Param("code")String code, 
			@Param("searchWhere") String searchWhere);

}
