package cn.com.qcc.mymapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.queryvo.AreaCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MetroCustomer;
public interface AddressCustomerMapper {
	// 附近房源
	List<HouseCustomer> findHouseBySize(HouseVo houseVo);

	List<AreaCustomer> getarealist(@Param("idsList")String [] code);
	
	//地铁查询
	List<MetroCustomer> metrosearch(@Param("code")Long code
			,@Param("pagequery")PageQuery pagequery);
	int metrosearchCount(Long code);
	
	//根据条件查询地铁
	List<Metro> searchbycodeandfinalstop(Metro metro);
	
	/** 查询地铁的线路
	 * @param name : 地铁线路名称
	 * **/ 
	List<Metro> metrobyname(Metro metro);
	
	//地铁详情
	List<Metro> metrodetail(Metro metro);
	//获得附近的详情
	List<HouseCustomer> getneardetail(HouseVo houseVo);
	//查询总数
	int getneardetailCount(HouseVo houseVo);

	List<Brand> getlikebrand(@Param ("likename")String likename , @Param ("likecode") String likecode);
	
	
	

	List<HouseCustomer> getpayListBybuilid(Long buildingid);

	List<HouseCustomer> getredecoraListBybuilid(Long buildingid);

	List<HouseCustomer> getproperListBybuilid(Long buildingid);

	List<HouseCustomer> getapartmentnameListBybuilid(Long buildingid);

	List<HouseCustomer> getCountAndpricesBybuilid(Long buildingid);

	String getFatherCodeBycode(String code);

	

	
	
	
}
