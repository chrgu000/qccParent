package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Hydcoal;
import cn.com.qcc.pojo.HydcoalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HydcoalMapper {
    int countByExample(HydcoalExample example);

    int deleteByExample(HydcoalExample example);

    int deleteByPrimaryKey(Long hydcoalid);

    int insert(Hydcoal record);

    int insertSelective(Hydcoal record);

    List<Hydcoal> selectByExample(HydcoalExample example);

    Hydcoal selectByPrimaryKey(Long hydcoalid);

    int updateByExampleSelective(@Param("record") Hydcoal record, @Param("example") HydcoalExample example);

    int updateByExample(@Param("record") Hydcoal record, @Param("example") HydcoalExample example);

    int updateByPrimaryKeySelective(Hydcoal record);

    int updateByPrimaryKey(Hydcoal record);
}