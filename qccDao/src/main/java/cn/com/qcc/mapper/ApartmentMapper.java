package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Apartment;
import cn.com.qcc.pojo.ApartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApartmentMapper {
    int countByExample(ApartmentExample example);

    int deleteByExample(ApartmentExample example);

    int deleteByPrimaryKey(Integer apartmentid);

    int insert(Apartment record);

    int insertSelective(Apartment record);

    List<Apartment> selectByExample(ApartmentExample example);

    Apartment selectByPrimaryKey(Integer apartmentid);

    int updateByExampleSelective(@Param("record") Apartment record, @Param("example") ApartmentExample example);

    int updateByExample(@Param("record") Apartment record, @Param("example") ApartmentExample example);

    int updateByPrimaryKeySelective(Apartment record);

    int updateByPrimaryKey(Apartment record);
}