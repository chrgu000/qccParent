package cn.com.qcc.service;

import java.util.LinkedList;
import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ApartmentCustomer;
import cn.com.qcc.queryvo.BrandCustomer;
import cn.com.qcc.queryvo.FurnitureCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseOrderCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.HousetagCustomer;
import cn.com.qcc.queryvo.PreparatoryCustomer;
import cn.com.qcc.queryvo.PriceCustomer;
import cn.com.qcc.queryvo.PropertyCustomer;
import cn.com.qcc.queryvo.RentmodalCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageeVo;

public interface HouseService {

	
	/**
	 * 根据条件查询当前房态图的总数
	 * @param telephone : 电话号码
	 * @param code      : 加密后的code
	 **/
	List<HouseCustomer> roompattern(HouseVo houseVo);
	int roompatternCount(HouseVo houseVo);
	
	

	/**
	 * 查询支付方式
	 */
	List<Paymodal> paymodals();

	/**
	 * 查询收租日分组
	 */
	List<RentmodalCustomer> collectrents();

	/**
	 * 查询其他价格
	 */
	List<RentmodalCustomer> otherprices();

	/**
	 * 查询更多总分类
	 */
	List<FurnitureCustomer> furniturelist();

	/**
	 * 查询更多小分类
	 */
	List<FurnitureCustomer> furnituredetaillist(Long furnitureid);

	/**
	 * 催租表查询
	 **/
	List<HouseCustomer> needpaycentlist(HouseCustomer houseCustomer);

	



	/**
	 * 根据楼栋ID 和userid 查询房东下面的房源
	 * @param userid : 当前用户【房东ID】
	 * @param buildingid : 楼栋的ID
	 **/
	List<HouseCustomer> housebybuildingid(HouseCustomer houseCustomer);

	

	

	/** 发布房源信息 出售
	 * @param house_number : 房号
	 * @param userid : 发布人ID
	 * @param housetitle : 标题
	 * @param code : 区域code
	 * @param villagename : 小区名称
	 * @param villageid : 小区ID
	 * @param building : 楼栋名称
	 * @param apartmentname : 户型
	 * @param area : 面积
	 * @param redecorat : 装修类型
	 * @param paystyle : 支付方式
	 * @param livestyle : 出租方式
	 * @param propertyname : 房屋类型
	 * @param houstatus : 1 出租
	 * @param housetag_id : 标签ID 
	 * @param landlord : 房东
	 * @param landlordtel : 房东电话
	 * @param contacts : 联系人
	 * @param contactstel : 联系人电话
	 * @param user_identity : 房主/其他
	 * @param description : 描述
	 * @param filePath : 房源图片
	 * @param brand : 品牌
	 * @param sex :性别
	 * @param floor : 楼层
	 * @param prices : 价格
	 * @param tribeid : 部落ID 
	 */
	ResultMap publishsale(Building building, Price price, House house, Village village, Long userid, HousetagCustomer housetag,
			String propertyname, String apartmentname, String brand);

	
	
	
	/** 发布房源信息 出租
	 * @param house_number : 房号
	 * @param userid : 发布人ID
	 * @param housetitle : 标题
	 * @param code : 区域code
	 * @param villagename : 小区名称
	 * @param villageid : 小区ID
	 * @param building : 楼栋名称
	 * @param apartmentname : 户型
	 * @param area : 面积
	 * @param redecorat : 装修类型
	 * @param paystyle : 支付方式
	 * @param livestyle : 出租方式
	 * @param propertyname : 房屋类型
	 * @param houstatus : 1 出租
	 * @param housetag_id : 标签ID 
	 * @param landlord : 房东
	 * @param landlordtel : 房东电话
	 * @param contacts : 联系人
	 * @param contactstel : 联系人电话
	 * @param user_identity : 房主/其他
	 * @param description : 描述
	 * @param filePath : 房源图片
	 * @param brand : 品牌
	 * @param sex :性别
	 * @param floor : 楼层
	 * @param prices : 价格
	 * @param tribeid : 部落ID 
	 */
	ResultMap publishouse(Building building, Price price, House house, Village village, Long userid, HousetagCustomer housetag,
			String propertyname, String apartmentname, String brand,String preparatory);

	/**
	 * 最新房源查询
	 * @param userid : 用户ID
	 * @param city : 当前城市
	 **/
	public SearchResult findHouseByTime(AddressCustomer addressCustomer ,
			PageQuery pagequry,Long userid,Long likecode);
	public int findHouseByTimeCount(HouseVo houseVo);
	
	/**
	 * 根据查询条件查询相应房源
	 * @param userid : 当前用户ID
	 * @param villageCustomer   likecode : 区域CODE
	 * @param propertyCustomer  propertyname : 房源类型
	 * @param priceCustomer     smallprices : 最小价格
	 * @param priceCustomer bigprices : 最大价格
	 * @param juli : 距离大小
	 * @param apartmentCustomer apartmentname : 户型
	 * @param apartmentCustomer fourroom : 四室以上
	 * @param housetagCustomer type : 房屋设施
	 * @param houseCustomer paystyle : 支付方式
	 * @param houseCustomer redecorat : 装修类型
	 * @param houseCustomer desc : 1 价格高到低
	 * @param houseCustomer asc : 1 价格低到高
	 * @param orderbyjuli : 距离排序
	 * @param metro code : 地铁code
	 * @param metro name : 地铁名称
	 * @param metro metroid : 地铁ID
	 */
	/*public List<HouseCustomer> findHousebycondition(HouseVo houseVo);*/
	int findHousebyconditionCount(HouseVo houseVo);

	/**
	 *加载首页 
	 * **/ 
	LinkedList<HouseCustomer> findHouseByIndex(HouseVo houseVo);

	/**
	 * 附近房源
	 * @param userid : 用户ID
	 * @param city : 城市名称
	 * @param addressCustomer.nearLongitude : 经度
	 * @param addressCustomer.nearLatude : 纬度
	 */
	SearchResult findHouseBySize(Long likecode ,AddressCustomer addressCustomer 
			, Long userid,PageQuery pagequery);
	int findHouseBySizeCount(HouseVo houseVo);

	/**
	 * 查看房屋详情
	 * @param houseid : 房源ID
	 */
	HouseCustomer findHouseDetails(Long houseid , Integer type ,Long userid);

	/**
	 *  查询我的出租
	 * @param userid : 用户ID
	 */
	List<HouseCustomer> findmyrent( Long userid ,PageQuery pagequery);
	int findmyrentCount(Long userid);

	/**
	 * 查询我的出售
	 * @param userid : 用户ID
	 */
	List<HouseCustomer> findmysall(Long userid);

	
	SearchResult findHouseByVillage2(Long userid , Long buildingid ,PageQuery pagequery);
	Integer findHouseCountByVillage2(VillageeVo villageeVo);

	
	/**
	 * 根据房子id更新房子状态
	 * @param houseid : 房子id
	 * @param housestatus : 更新的状态
	 * **/
	void updateHousestatus(Long houseid, String housestatus);

	/**
	 * 查询房子根据id
	 * **/ 
	HouseCustomer findHouseByHouseID(Long houseid);

	/**
	 * 根据相应的条件查询二手房
	 * @param city : 城市名称
	 * @param villageCustomer likecode : 区域code
	 * @param propertyCustomer propertyname: 房屋类型
	 * @param housetagCustomer houseyear : 楼龄
	 * @param housetagCustomer buildingyear : 楼房的修旧程度
	 * @param housetagCustomer elevator : 电梯
	 * @param housetagCustomer propertyright : 房屋产权
	 * @param houseCustomer turn : 朝向
	 * @param houseCustomer smallarea :最小面积
	 * @param houseCustomer bigarea : 最大面积
	 * @param houseCustomer smallhouseprice :最小价格
	 * @param houseCustomer bighouseprice : 最大价格
	 * @param apartmentCustomer apartmentname : 户型
	 * @param houseCustomer redecorat : 装修类型
	 * @param metro code : 地铁的code
	 * @param metro name : 地铁mingc
	 * @param metro metroid : 地铁ID
	 * @param userid : 用户ID
	 */
	List<HouseCustomer> findoldhouse(HouseVo houseVo);
	Integer findoldhouseCount(HouseVo houseVo);

	/**
	 * 按照小区或者build查找房子
	 * **/ 
	List<HouseCustomer> findHouseByNearVillage(HouseVo houseVo);
	Integer findHouseByNearVillageCount(HouseVo houseVo);

	/**
	 * 查一条品牌公寓
	 * **/ 
	HouseCustomer findonebarnd(HouseVo houseVo);

	/**
	 * 根据查询条件查询附近的
	 * **/ 
	SearchResult getneardetail(AddressCustomer addressCustomer , HouseCustomer houseCustomer ,PageQuery pagequery,
			Long userid ,String orderJuli , String orderTime);
	int getneardetailCount(HouseVo houseVo);

	
	//处理楼栋编号 [内部方法]
	List<HouseCustomer> buildinghousecode();

	/**
	 * 查询品牌公寓列表
	 * **/ 
	List<BrandCustomer> brandlist(HouseVo houseVo);
	int brandlistCount(HouseVo houseVo);
	
	/**
	 * 根据楼栋ID编辑房源的品牌为空
	 * **/
	void deletebrandidbybuildingid(Long buildingid);
	
	/**
	 * 根据楼栋ID 和品牌ID封装房源品牌
	 * **/
	void addbrandidbybuildingid(HouseCustomer houseCustomer);
	
	/**
	 * 根据房子id集合下架7天没有更新的房源
	 * **/
	String[] search7daysnotupdate();
	
	/***
	 * 然后把对应的房源信息下架
	 * **/
	void update7dayundercarriage(String[] houseids);
	
	
	
	/**
	 * 7天自动下架旧房源
	 * ***/
	List<UserCustomer> search7daysnotupdateuser();
	
	
	/**
	 * 预订时候查询基本信息
	 * **/
	HouseCustomer getHouseYudingMess(Long houseid);
	
	
	/**
	 * 根据预订信息 下预订单
	 * **/ 
	ResultMap gethouseorderid(Houseorder houseorder);
	
	
	/**
	 * 房源预定之后的回调
	 * @param houseorderid : 房子订单号
	 * @param total_amount : 总金额
	 * @param weixinorder : 微信商户订单号
	 * **/
	String houseyudingsuccess( String total_amount ,String weixinorder);
	
	/**
	 * 查询我的历史预定信息
	 * **/
	int searchhouselistCount(Long userid);
	List<HouseOrderCustomer> searchhouselist(Long userid, PageQuery pagequery);
	
	//重新发订单
	Houseorder houseorderdetail(Long userid, Long houseid,Long houseorderid);
	
	/**更新房源预定订单
	 * @param userid : 用户id
	 * @param houseorderid : 订单id
	 * @param refundmess : 退款原因如果不是退款为kon
	 * @param paystate : 订单状态
	 * **/
	ResultMap updatehouseorder(Long userid, Long houseorderid, int paystate ,String refundmess);
	
	/**
	 * 查询待确认房源订单
	 * @param userid 
	 * **/ 
	int searchSureHousePayCount(Long userid);
	List<HouseOrderCustomer> searchSureHousePay(Long userid, PageQuery pagequery);
	
	/**
	 * 查询已经下单的详情
	 * @param houseorderid : 订单id
	 * **/ 
	HouseOrderCustomer searchorderpay(Long houseorderid);
	
	

	/**
	 * 根据订单id 查询预订详情
	 * @param houseorderid : 预订单id
	 * @return
	 */
	Houseorder gethouseorderbyid(String houseorderid);
	
	/**
	 * 批量添加房号
	 * **/ 
	ResultMap batchhouse(Building building, Price price, House house, Village village, Long userid,
	HousetagCustomer housetag, String propertyname, 
	String apartmentname, String brand, String batchhouse,String preparatory);
	
	
	
	/**查询佣金的集合
	 * @param houseid : 房子ID
	 * **/
	List<PreparatoryCustomer> preparList(Long houseid);
	List<PreparatoryCustomer> preparList(List<Long> houseid);
	
	/**所有的房子信息导入索引库**/
	ResultMap searchAllHouseToSolr(PageQuery pagequery);
	
	/**查询本小区房源或者本楼栋**/
	SearchResult searchVillageHouseorBuildingHouse(Long buildingid, Long villageid, PageQuery pagequery);
	
	
	SearchResult findHousebycondition(String orderbyjuli,Metro metro, PriceCustomer priceCustomer, Long userid, Long likecode,
			PropertyCustomer propertyCustomer, ApartmentCustomer apartmentCustomer, AddressCustomer addressCustomer,
			HouseCustomer houseCustomer, String juli, HousetagCustomer housetagCustomer, PageQuery pagequery);
	
	SearchResult findoldhouse(PropertyCustomer propertyCustomer, HousetagCustomer housetagCustomer,
			HouseCustomer houseCustomer, ApartmentCustomer apartmentCustomer, Metro metro, Long likecode
			,AddressCustomer addressCustomer,PageQuery pagequery);
	
	
	ResultMap publishsaleBatch(Building building, Price price, House house, String batchhouse, Village village,
			Long userid, HousetagCustomer housetag, String propertyname, String apartmentname, String brand);
	
	SearchResult findHouseBySizeWithMap(Long likecode, AddressCustomer addressCustomer, Long userid,
			PageQuery pagequery);
	
	

	

}
