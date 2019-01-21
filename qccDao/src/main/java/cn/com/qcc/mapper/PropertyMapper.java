package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Property;
import cn.com.qcc.pojo.PropertyExample;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyMapper {
    int countByExample(PropertyExample example);

    int deleteByExample(PropertyExample example);

    int deleteByPrimaryKey(Integer propertyid);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer propertyid);

    int updateByExampleSelective(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByExample(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
    
    Integer findHouseBypropertyCount();

	// 根据类型查询count
	Integer findHouseBypropertyCount(HouseVo houseVo);

	// 根据类型查询房子
	List<HouseCustomer> findHouseByCategory(HouseVo houseVo);
}