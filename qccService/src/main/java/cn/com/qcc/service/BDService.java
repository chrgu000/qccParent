package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.queryvo.BdManagerCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserRoomCustomer;

public interface BDService {
	
	/**添加编辑BD用户**/
	ResultMap addOrUpdate(Bdmanager bdmanager );

	/**查询BD列表**/
	ResultMap listBD();

	/**查询一个BD**/
	ResultMap findOne(String bdid);
	
	
	/**禁用和开启BD**/
	ResultMap changeState(String bdid);

	/**根据电话号码或者id 查询BD**/
	BdManagerCustomer searchBDByPhoneOrId(String account);

	/**BD修改登录密码**/
	ResultMap changePassword(Long telephone, String BD_ACCTOKEN, String password);

	/**查询想要添加的房东**/
	List<UserRoomCustomer> searchUserToLand(String searchWhere);
	
	/**BD添加房东**/
	ResultMap addLand(String BD_ACCTOKEN, Landlord landlord ,Long userid);

	Bdmanager getBdidByToken(String BD_ACCTOKEN);

	/**查询我的房东**/
	List<UserRoomCustomer> myLand(String bD_ACCTOKEN , Long code);

	/**查询想要添加的楼栋**/
	List<BuildingCustomer> searchAddBuildingToland(String searchWhere);

	/**给房东绑定楼栋**/
	ResultMap addBuildingToland(Long userid, Long buildingid);
	
	/**删除房东绑定的楼栋**/
	ResultMap deleteBuildingland(Long userid, Long buildingid);
	
	/**查询房东对应的楼栋**/
	List<BuildingCustomer> searchBuildingBylandId(Long userid);
	
	UserRoomCustomer bdlandeditsearch(Long userid);
	
	/** 移除管理房东 **/
	ResultMap removeland(Long userid);

	ResultMap editAvatar(String bD_ACCTOKEN, String avatar);

	ResultMap changeEditstate(String bdid);
	
	
	/**查询需要添加的系统账号**/
	int searchAddBDCount(String searchWhere);
	List<UserCustomer> searchAddBD(String searchWhere, PageQuery pagequery);
	
	/**查询编辑的品牌列表**/
	List<Brand> searchEditBrandList(String code, String searchWhere ,PageQuery pagequery);
	int searchEditBrandListCount(String code, String searchWhere);

}
