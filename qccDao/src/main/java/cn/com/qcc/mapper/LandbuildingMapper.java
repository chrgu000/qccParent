package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Landbuilding;
import cn.com.qcc.pojo.LandbuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandbuildingMapper {
    int countByExample(LandbuildingExample example);

    int deleteByExample(LandbuildingExample example);

    int deleteByPrimaryKey(Long landbuildingid);

    int insert(Landbuilding record);

    int insertSelective(Landbuilding record);

    List<Landbuilding> selectByExample(LandbuildingExample example);

    Landbuilding selectByPrimaryKey(Long landbuildingid);

    int updateByExampleSelective(@Param("record") Landbuilding record, @Param("example") LandbuildingExample example);

    int updateByExample(@Param("record") Landbuilding record, @Param("example") LandbuildingExample example);

    int updateByPrimaryKeySelective(Landbuilding record);

    int updateByPrimaryKey(Landbuilding record);
}