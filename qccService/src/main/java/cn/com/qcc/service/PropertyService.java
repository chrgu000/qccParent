package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Property;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.PropertyCustomer;
import cn.com.qcc.queryvo.SearchResult;

public interface PropertyService {
	// 根据propertyname查询Property
	public Property getHouseByProperty(Property property);

	// 查询所有的类别
	public List<Property> findProperty(Property property);

	// 查询租的类别
	public List<Property> findPropertytype(Property property);

	// 根据propertyname查询PropertyID
	public Integer selectIDbyPropertyName(String propertyname);

	public Integer selectIDbyPropertyNameSale(String propertyname);

	// 根据类型查询count
	Integer findHouseBypropertyCount(HouseVo houseVo);

	/**
	 * 搜索栏下面写死的类别的搜索 和首页查看更多
	 * @param likecode 
	 * @param pagequery 
	 * @param propertyCustomer 
	 * @param propertyCustomer.propertyname : 房屋类型
	 * @param city : 城市名称的
	 * @param userid : 用户ID
	 */
	SearchResult  findHouseByCategory(PropertyCustomer propertyCustomer, PageQuery pagequery,
			Long likecode,AddressCustomer addressCustomer , Long userid);

	public List<Property> findPropertyExpertOldHouse(Object object);
}
