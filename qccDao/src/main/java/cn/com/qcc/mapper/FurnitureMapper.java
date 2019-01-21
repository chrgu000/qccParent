package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Furniture;
import cn.com.qcc.pojo.FurnitureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FurnitureMapper {
    int countByExample(FurnitureExample example);

    int deleteByExample(FurnitureExample example);

    int deleteByPrimaryKey(Long furnitureid);

    int insert(Furniture record);

    int insertSelective(Furniture record);

    List<Furniture> selectByExample(FurnitureExample example);

    Furniture selectByPrimaryKey(Long furnitureid);

    int updateByExampleSelective(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByExample(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByPrimaryKeySelective(Furniture record);

    int updateByPrimaryKey(Furniture record);
}