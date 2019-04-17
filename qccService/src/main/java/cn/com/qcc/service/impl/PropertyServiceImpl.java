package cn.com.qcc.service.impl;

import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.mapper.PropertyMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mess.util.SolrPageUtil;
import cn.com.qcc.pojo.Property;
import cn.com.qcc.pojo.PropertyExample;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.PropertyCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.service.PropertyService;
import cn.com.qcc.service.solrdao.HouseSolrDao;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyMapper propertyMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;

	public Property getHouseByProperty(Property property) {
		return null;
	}

	// 查询租房的物业类型
	public List<Property> findProperty(Property property) {
		PropertyExample example = new PropertyExample();
		List<Property> selectByExample = propertyMapper.selectByExample(example);
		return selectByExample;
	}

	public List<Property> findPropertytype(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	// 根据类型名字查对应ID 商铺-房源-写字楼-二手房-别墅 ------------------只查租的--------
	public Integer selectIDbyPropertyName(String propertyname) {
		PropertyExample example = new PropertyExample();
		PropertyExample.Criteria criteria = example.createCriteria();
		if (propertyname != null && !"".equals(propertyname)) {
			criteria.andPropertynameEqualTo(propertyname);
		}
		List<Property> list = propertyMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0).getPropertyid();
		}
		return null;
	}

	// 根据类型名字查对应ID 商铺-房源-写字楼-二手房-别墅 ------------------只查卖的--------
	public Integer selectIDbyPropertyNameSale(String propertyname) {
		PropertyExample example = new PropertyExample();
		PropertyExample.Criteria criteria = example.createCriteria();
		if (propertyname != null && !"".equals(propertyname)) {
			criteria.andPropertynameEqualTo(propertyname);
			// criteria.andPropertytypeEqualTo("卖");
		}
		List<Property> list = propertyMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0).getPropertyid();
		}
		return null;
	}

	// 根据类型查询总数
	public Integer findHouseBypropertyCount(HouseVo houseVo) {
		return propertyMapper.findHouseBypropertyCount(houseVo);
	}

	// 根据类型查询房子的集合
	public SearchResult findHouseByCategory(PropertyCustomer propertyCustomer, PageQuery pagequery,
			Long likecode,AddressCustomer addressCustomer , Long userid) {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		//设置距离
		SolrPageUtil.juliquery(query, "", addressCustomer);
		//设置房源类型
		SolrPageUtil.propertyquery(propertyCustomer, query);
		//设置区域code类型
		SolrPageUtil.likecodequery(likecode ,query);
		//执行查询
		SearchResult result = houseSolrDao.findHouseByCategory(query);
		return result;
	}

	@Override
	public List<Property> findPropertyExpertOldHouse(Object object) {
		PropertyExample example = new PropertyExample();
		example.createCriteria().andPropertynameNotEqualTo("二手房");
		// criteria.andPropertytypeEqualTo("租");
		List<Property> selectByExample = propertyMapper.selectByExample(example);
		return selectByExample;
	}

}
