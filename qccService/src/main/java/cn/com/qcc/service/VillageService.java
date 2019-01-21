package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Rental;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.Villagetype;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ApartmentCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HousetagCustomer;
import cn.com.qcc.queryvo.SearchModal;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.queryvo.VillageeVo;
 

public interface VillageService {

	
	/**
	 * 地区下面的小区
	 * **/ 
	List<VillageCustomer> findAllVillage(VillageeVo villageeVo);
	
	/**
	 * 小区下面的楼栋
	 * **/ 
	List<VillageCustomer> findBuildingListByVillage(VillageeVo villageeVo);


	/**
	 * 发布小区
	 * **/ 
	ResultMap saveVillage(Village village,Detaileaddress detaileaddress);

	/** 发布楼栋
	 * **/
	ResultMap savebuild(Village village, Building building, Detaileaddress detaileaddress,String brand);
	
	/**
	 * 根据城市名称查询CODE
	 * @param CITY : 城市名称
	 * **/
	Long getcodebycity(String city);

	/**
	 * 找小区
	 * **/ 
	Integer searchCommlistCount(VillageeVo villageeVo);

	/**找小区
	 * **/ 
	List<VillageCustomer> searchCommlist(VillageeVo villageeVo);

	/**
	 * 小区详情
	 * @param villageid : 小区ID
	 * **/ 
	VillageCustomer searchCommById(Long villageid);

	/***查询小区下面的楼栋
	 *  @param villageid : 小区的ID
	 * **/ 
	List<BuildingCustomer> searchBuildingbyVillageid(Long villageid ,PageQuery pagequery);
	int searchBuildingbyVillageidCount(Long villageid);
	/**
	 * 楼栋列表
	 * **/ 
	List<BuildingCustomer> searchBuilindgList(VillageeVo villageeVo);
	int searchBuilindgListCount(VillageeVo villageeVo);

	/**
	 * 楼栋详情
	 * @param :buildingid : 楼栋ID
	 * **/ 
	BuildingCustomer searchbuildingbyid(Long buildingid , Long userid , Integer type);

	/**  楼栋下面房源的详情
	 * **/
	List<HouseCustomer> searchhouseList(VillageeVo villageeVo);

	/**根据code查询小区基本信息
	 * @param code : 区域的code
	 * **/ 
	List<Village> getvillagebycode(Long code);

	/**
	 * 基本的小区详情
	 * @param villageid : 小区ID
	 * **/ 
	Village simplevillagedetail(Long villageid);

	/**根据ID更新小区
	 * 
	 * **/ 
	ResultMap villageupdatebyid(Village village);
	List<BuildingCustomer> test(VillageeVo villageeVo);

	/**获取基本 的builnglist
	 * @param village: 小区id
	 * @param userid : 用户ID
	 * **/ 
	ResultMap getbuildinglistbyvid(Long villageid, Long userid);

	/**
	 * 根据楼栋ID 删除楼栋
	 * @param buildingid : 楼栋ID
	 * **/
	void deletebuidilding(Long buildingid);

	/**查询楼栋的基本信息
	 * @param buildingid : 楼栋ID
	 * **/ 
	Building getsimplebuilding(Long buildingid);

	/**
	 * 更新楼栋
	 * @param building : 楼栋的基本信息
	 * @param detailes : 楼栋的详情地址
	 * **/
	ResultMap updatebuilding(Building building,String detailes);

	/**
	 * 根据区域code 统计楼栋发布
	 * @param code : 区域的code
	 * **/
	List<UserCustomer> censusbuilding(String code);

	/**地图找楼栋
	 * **/ 
	List<BuildingCustomer> fingbuildsmap( VillageeVo villageeVo);

	/**地图找街道
	 * @param city : 城市名
	 * @param code : 区域code
	 * **/ 
	List<BuildingCustomer> fingtrandmap(String city, Long code);

	/**地图找小区
	 * @param code : 区域code
	 * **/ 
	List<BuildingCustomer> fingvillagemap(Long code);
	
	/**
	 * 一键维护地铁 . 设置小区下面的楼栋同一地铁
	 * **/
	ResultMap updateallmetro(Building builgng);
	
	Long checkeDetailaAddressExists(Detaileaddress detaileaddress);
	
	/**
	 * 合并小区和楼栋
	 * **/
	List<BuildingCustomer>  megrobuildingandvillage();

	//没有经纬度的小区更新一下经纬度
	List<BuildingCustomer> megrobvillage_detailid(VillageeVo villageeVo);
	
	/**
	 * 根据经纬度查询附近小区
	 * **/
	List<BuildingCustomer> nearvillage(VillageeVo villageeVo);

	ResultMap buildingtosolr();

	List<BuildingCustomer> fingbuildsmaps(AddressCustomer addressCustomer);

	// 截掉楼里多余的图片 [内部方法]
	ResultMap deletesearch();
	// 截掉房源里图片[内部方法]
	ResultMap deletehousepath();
	// 处理楼栋编号[内部方法]
	ResultMap buildingnum();
	// 处理楼栋不符合的电话号码[内部方法]
	ResultMap buidingphone();
	// 生成楼栋专属二维码[内部方法]
	ResultMap buildingxpx(Integer begin,Integer edn);
	
	/**
	 * 根据code 和searchname 模糊查询小区
	 * @param code : 区域code
	 * @param searchname : 搜索关键字
	 * **/
	List<SearchModal> searchlikevillage(String code, String searchname);
	
	//处理房源小程序二维码[内部方法]
	ResultMap housexpx();

	// 生成小区二维码[内部方法]
	ResultMap villagexpx();
	
	/** 查询小区的类型 有公租房小区和普通小区
	 * ***/
	List<Villagetype> searchvillagetype();
	
	// [内部方法]
	ResultMap buildvillageid();
	
	/**
	 * 查询公租房的申请条件
	 * @param citycode : 城市的code
	 * **/
	Rental searchrentbycode(Long citycode);
	
	/**
	 * 查询公租房图片
	 * @param codeone : 二位数的城市code
	 * @param codetwo : 四位数的城市code
	 * **/
	String searchrentpicture(String codeone, String codetwo);

	/**
	 * 生成经纪人小程序的二维码[内部方法]
	 * **/
	ResultMap brokerxpx();

	ResultMap addbuildngtosolr(Long buildingid ,PageQuery pagequery);
	
	/**楼栋的列表查询***/
	SearchResult searchBuilindgList(Long likecode, String juli,BuildingCustomer buildingCustomer, ApartmentCustomer apartmentCustomer,
			HouseCustomer houseCustomer, HousetagCustomer housetagCustomer, VillageCustomer villageCustomer,
			Metro metro,AddressCustomer addressCustomer,PageQuery pagequery);
	
	/**统计小区发布**/
	List<UserCustomer> censusvillage(String code);

	
	
	


	
}
