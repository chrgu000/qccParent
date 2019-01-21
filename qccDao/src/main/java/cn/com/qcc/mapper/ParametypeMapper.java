package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.ParametypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParametypeMapper {
    int countByExample(ParametypeExample example);

    int deleteByExample(ParametypeExample example);

    int deleteByPrimaryKey(Long codeid);

    int insert(Parametype record);

    int insertSelective(Parametype record);

    List<Parametype> selectByExample(ParametypeExample example);

    Parametype selectByPrimaryKey(Long codeid);

    int updateByExampleSelective(@Param("record") Parametype record, @Param("example") ParametypeExample example);

    int updateByExample(@Param("record") Parametype record, @Param("example") ParametypeExample example);

    int updateByPrimaryKeySelective(Parametype record);

    int updateByPrimaryKey(Parametype record);
}