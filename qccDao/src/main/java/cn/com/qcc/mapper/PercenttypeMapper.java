package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Percenttype;
import cn.com.qcc.pojo.PercenttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PercenttypeMapper {
    int countByExample(PercenttypeExample example);

    int deleteByExample(PercenttypeExample example);

    int insert(Percenttype record);

    int insertSelective(Percenttype record);

    List<Percenttype> selectByExample(PercenttypeExample example);

    int updateByExampleSelective(@Param("record") Percenttype record, @Param("example") PercenttypeExample example);

    int updateByExample(@Param("record") Percenttype record, @Param("example") PercenttypeExample example);
}