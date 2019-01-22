package cn.com.qcc.mymapper;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Furniture;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.queryvo.BrandCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.FurnitureCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseOrderCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.PreparatoryCustomer;
import cn.com.qcc.queryvo.RentmodalCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageeVo;

public interface HouseCustomerMapper {
	
	//查询房态图
	List<HouseCustomer> roompattern(HouseVo houseVo);
	
	//查询房态图count
	int roompatternCount(HouseVo houseVo);
	
	//查询支付方式
	List<Paymodal> paymodals();
	
	//查询收租日分组
	List<RentmodalCustomer> collectrents();
	
	//根据收租日的父节点查询子节点
	List<RentmodalCustomer> collectrentsson(Integer fatherid);
	
	//查询其他价格
	List<RentmodalCustomer> otherprices();
	
	//获取其他价格的子节点
	List<RentmodalCustomer> otherpricesson(@Param("order")String order);
	
	//查询更多的总分类
	List<FurnitureCustomer> furniturelist();
	
	//查询更多的小分类
	List<FurnitureCustomer> furnituredetaillist(Long furnitureid);
	
	//
	List<Furniture> furnituresbyids(@Param("idsList")String[] centconts);
	
	HouseCustomer rentpaymodal(Long rentmodalid);
	
	List<HouseCustomer> needpaycentlist(HouseCustomer houseCustomer);
	
	List<HouseCustomer> grouptimeandbuilding(HouseCustomer houseCustomer);
	
	List<HouseCustomer> grouptimeandbuildingson(HouseCustomer houseCustomer);
	
	List<HouseCustomer> grouptimeandtime(HouseCustomer houseCustomer);
	
	List<BuildingCustomer> getlandareaname(BuildingCustomer buildingCustomer);
	
	
	List<BuildingCustomer> getlandbuildingname(BuildingCustomer buildingCustomer);
	
	
	//根据房东Id 和楼栋ID 查询出对应的房子。
	List<HouseCustomer> housebybuildingid(HouseCustomer houseCustomer);
	
	//查询当前租约的已经交过的押金总和
	Double centpricespay(Long houseid);
	
	//查询当前租约下面除去房租和押金未交的金额总数
	Double centpricesnotpay(HouseCustomer search);
	
	//查询最近一次的房屋租金价格
	HouseCustomer centpricesnow(HouseCustomer search);
	
	//设置租约为历史租约
	void usercentbehistory(Long houseid);
	
	//设置账单为历史账单
	void housepaybehistory(Long houseid);

	Double centpricespayout(HouseCustomer search);
	
	
	/*
	 * 根据条件查询最新房源
	 */
	public List<HouseCustomer> findHouseByTime(HouseVo houseVo);

	/*
	 * 根据条件最新房源的总和
	 */
	public Integer findHouseByTimeCount(HouseVo houseVo);

	public List<HouseCustomer> findHousetarding(HouseVo houseVo);

	public List<HouseCustomer> findHousebycondition(HouseVo houseVo);

	public LinkedList<HouseCustomer> findHouseByIndex(HouseVo houseVo);

	public List<HouseCustomer> findHouseBySize(HouseVo houseVo);

	// 根据用户ID获取当前用户的房子信息
	public List<HouseCustomer> getHouserByUserid(@Param("userid") Integer userid);

	// 按条件查询的总记录
	public int findHousebyconditionCount(HouseVo houseVo);

	// 附近房源的COUNT
	public int findHouseBySizeCount(HouseVo houseVo);

	// 查看房屋详情
	public HouseCustomer findHouseDetails(@Param("houseid") Long houseid);

	// 查询我的出租
	public List<HouseCustomer> findmyrent( @Param("userid") Long userid , @Param("pagequery") PageQuery pagequery);

	// 查询我的出售
	public List<HouseCustomer> findmysall( @Param("userid") Long userid);

	// 根据街道查总数
	Integer findHouseCountByVillage2(VillageeVo villageeVo);

	// 根据街道查
	List<HouseCustomer> findHouseByVillage2(VillageeVo villageeVo);

	// 二手房
	public List<HouseCustomer> findoldhouse(HouseVo houseVo);

	// 二手房的统计
	public Integer findoldhouseCount(HouseVo houseVo);

	// 根据小区build查询房子
	public List<HouseCustomer> findHouseByNearVillage(HouseVo houseVo);

	// 根据小区build查询房子的统计
	public Integer findHouseByNearVillageCount(HouseVo houseVo);
	
	//查询一条品牌公寓
	public HouseCustomer findonebarnd(HouseVo houseVo);
	
	//查询部落中个人发布的物品
	public List<HouseCustomer> singleablum(@Param("userid") Integer userid ,@Param("pagequery") PageQuery pagequery);
	Integer singleablumCount(@Param("userid")  Integer userid);
	//根据楼栋ID查询最大房间编号
	public String getmaxhouseNum(Long buildingid);
	//
	public List<HouseCustomer> buildinghousecode();
	
	//品牌公寓列表
	public List<BrandCustomer> brandlist(HouseVo houseVo);
	
	//公寓详情
	public BrandCustomer branddetail(Long brandid);
	
	//
	public int brandlistCount(HouseVo houseVo);
	
	// 根据楼栋ID删除房源品牌ID
	void deletebrandidbybuildingid(Long buildingid);
	
	//根据楼栋ID 添加房源品牌ID
	void addbrandidbybuildingid(HouseCustomer houseCustomer);
	
	//查询上架7天没有更新的房源的信息
	String[] search7daysnotupdate();
	
	//查询对应的房源的所属用户
	List<UserCustomer> search7daysnotupdateuser();
	
	//吧对应的房源下架
	void update7dayundercarriage(@Param("idsList")String[] houseids);
	
	// 根据 category 查询房源的标签
	List<Housetag> getTargBycategory(@Param("category") String category);
	
	//查询房源预定信息
	HouseCustomer getHouseYudingMess(@Param("houseid")Long houseid);
	
	//根据类型和 id查询镖旗
	String getTraName(@Param("houseid")long houseid);
	
	//查询最新预定
	String gethouseorderstatue(Houseorder houseorder);
	
	// 查询我的历史预订信息
	int searchhouselistCount(@Param("userid")Long userid);
	
	List<HouseOrderCustomer> searchhouselist(@Param("userid")Long userid,@Param("pagequery") PageQuery pagequery);
	
	//移除房源预定单
	void updatehouseorder(@Param("userid")Long userid,@Param("houseid") Long houseid
			,@Param("paystate")Integer paystate , @Param("refundmess")String refundmess);
	
	// 查询已经提交订单，房东或者经济人需要确认的房源总数
	int searchSureHousePayCount(@Param("userid")Long userid);
	List<HouseOrderCustomer> searchSureHousePay(@Param("userid")Long userid,@Param("pagequery") PageQuery pagequery);
	
	// 查询确认的信息
	HouseOrderCustomer searchorderpay(@Param("houseorderid") Long houseorderid);
	
	/**查询佣金集合**/
	List<PreparatoryCustomer> preparList(@Param("houseid")Long houseid);

	/**设置房子佣金0 清楚房子佣金**/
	void deletepreparhouse(Long houseid);
	
	/**查询房子详情**/
	HouseCustomer findHouseByHouseID(Long houseid);
	
	/**根据housetagid 查询标签类型**/
	List<Housetag> getTargByHouseTargId(@Param("housetagid") String housetagid);
	
	/**我的出租的列表分页**/
	int findmyrentCount( @Param("userid") Long userid);

	List<PreparatoryCustomer> preparListbyhouseids(@Param("houseids") List<Long> houseid);
	
	/**所有的房子导入索引库**/
	List<HouseCustomer> searchAllHouseToSolr(@Param("pagequery")PageQuery pagequery);
	
	/**一个房子导入索引库**/
	HouseCustomer searchoneHouseToSolr(@Param("houseid")Long valueOf);
	
	/**根据楼栋的id查询同步索引库的数据**/
	List<HouseCustomer> searchHouseToSolrByBuildingid(Long buildingid);
	
	

	

}