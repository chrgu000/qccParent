package cn.com.qcc.mymapper;

import java.util.List;

import cn.com.qcc.pojo.Backimage;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.HouseCustomer;

public interface BackImageCustoermMapper {
	
	/**根据type类型查询默认的背景图片**/
	Backimage searchDefaultByType(int i);
	
	/**查询所有的海报**/
	List<Backimage> searchAllByType(int i);
	
	/**查询需要建立经纪人的海报图片**/
	List<Broker> searchBrokerCreatePost();
	
	/** 查询需要创建 普通二维码的房源信息**/
	List<House> searchHouseCommonCreate();
	
	/**查询需要创建的楼栋的二维码**/
	List<Building> searchbuilCommonCreate();

	List<Village> searchvillCommonCreate();

	Long searchNextId();

	List<HouseCustomer> searchHouseHaibaoCommonCreate();

	HouseCustomer searchHousePostMess(Long houseid);
	
	
	
}