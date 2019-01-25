package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.SearchModal;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.queryvo.VillageeVo;

public interface VillageCustomerMapper {

	// 地区下面的小区
	List<VillageCustomer> findAllVillage(VillageeVo villageeVo);

	// 小区下面的楼栋
	List<VillageCustomer> findBuildingListByVillage(VillageeVo villageeVo);

	// 根据城市名称获取到code
	String getcodebycity(String city);

	// 找小区
	List<VillageCustomer> searchCommlist(VillageeVo villageeVo);

	// 找小区
	Integer searchCommlistCount(VillageeVo villageeVo);

	// 根据小区ID查询小区
	VillageCustomer searchCommById(@Param("villageid") Long villageid);

	// 查询小区下面的楼栋
	List<BuildingCustomer> searchBuildingbyVillageid(@Param("villageid") Long villageid ,
			@Param("pagequery")PageQuery pagequery);

	// 楼栋列表
	List<BuildingCustomer> searchbuildlist(VillageeVo villageeVo);

	// 楼栋列表的count
	Integer searchbuildlistCount(VillageeVo villageeVo);

	// 楼栋详情   searchBanById
	BuildingCustomer searchbuildingbyid (@Param("buildingid") Long banid);

	// 楼栋下面的房源
	List<HouseCustomer> searchhouseList(VillageeVo villageeVo);

	List<BuildingCustomer> getbuildinglistbyvid(Long villageid);

	List<UserCustomer> censusbuilding(@Param("code") String code);
	List<UserCustomer> censusvillage(String code);

	// 地图找楼栋
	List<BuildingCustomer> fingbuildsmap(VillageeVo villageeVo);

	// 地图找楼栋
	List<BuildingCustomer> fingbuildsmaps(AddressCustomer addressCustomer);

	// 地图找街道
	List<BuildingCustomer> fingtrandmap(Long code);

	// 地图找小区
	List<BuildingCustomer> fingvillagemap(Long code);

	// 一键维护地铁
	void updateallmetro(Building builgng);

	List<BuildingCustomer> getallbuilngandvillage();

	List<BuildingCustomer> update_villagedetailid(VillageeVo villagevo);
	
	BuildingCustomer getsimplebuilding( @Param("buildingid")Long buildingid);
	
	//查询出所有的code
	List<Village>  getvillagebuidingcode();
	//根据小区的code查询楼栋
	List<Building> searchbuildingonvillagecode(Village vill);
	
	//根据小区code 查询楼栋的编号
	String searchmaxbuildingcode(Long code);
	
	//查询窗口类似的小区
	List<SearchModal> searchlikevillage(@Param("code") String code, @Param("searchname")String searchname);
	//查询窗口类似的楼栋
	List<SearchModal> searchlikebuilding(@Param("code") String code, @Param("searchname")String searchname);
	//类似的品牌
	List<SearchModal> searchlikebrand(String searchname);
	
	/**
	 * 查询公租房图片
	 * **/
	String searchrentpicture(@Param("codeone")String codeone, @Param("codetwo")String codetwo);

	int searchBuildingbyVillageidCount(Long villageid);
	
	
	/**楼栋一键导入索引库**/
	List<BuildingCustomer> addbuildngtosolr(@Param("buildingid")Long buildingid ,@Param("pagequery") PageQuery pagequery);
	/**查询一条楼栋导入索引库**/
	BuildingCustomer oneBuildToSolr(Long buildingid);
	
	/**楼栋导出EXCLE**/
	List<BuildingCustomer> buildingUpload(@Param("code")Long code,@Param("searchwhere") String searchwhere);

	


}
