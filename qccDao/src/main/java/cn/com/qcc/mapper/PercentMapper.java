package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Percent;
import cn.com.qcc.pojo.PercentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PercentMapper {
    int countByExample(PercentExample example);

    int deleteByExample(PercentExample example);

    int deleteByPrimaryKey(Long percentid);

    int insert(Percent record);

    int insertSelective(Percent record);

    List<Percent> selectByExample(PercentExample example);

    Percent selectByPrimaryKey(Long percentid);

    int updateByExampleSelective(@Param("record") Percent record, @Param("example") PercentExample example);

    int updateByExample(@Param("record") Percent record, @Param("example") PercentExample example);

    int updateByPrimaryKeySelective(Percent record);

    int updateByPrimaryKey(Percent record);
}