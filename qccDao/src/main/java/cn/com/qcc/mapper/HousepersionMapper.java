package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.pojo.HousepersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HousepersionMapper {
    int countByExample(HousepersionExample example);

    int deleteByExample(HousepersionExample example);

    int deleteByPrimaryKey(Long housepersionid);

    int insert(Housepersion record);

    int insertSelective(Housepersion record);

    List<Housepersion> selectByExample(HousepersionExample example);

    Housepersion selectByPrimaryKey(Long housepersionid);

    int updateByExampleSelective(@Param("record") Housepersion record, @Param("example") HousepersionExample example);

    int updateByExample(@Param("record") Housepersion record, @Param("example") HousepersionExample example);

    int updateByPrimaryKeySelective(Housepersion record);

    int updateByPrimaryKey(Housepersion record);
}