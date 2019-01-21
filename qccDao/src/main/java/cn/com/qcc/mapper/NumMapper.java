package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Num;
import cn.com.qcc.pojo.NumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NumMapper {
    int countByExample(NumExample example);

    int deleteByExample(NumExample example);

    int insert(Num record);

    int insertSelective(Num record);

    List<Num> selectByExample(NumExample example);

    int updateByExampleSelective(@Param("record") Num record, @Param("example") NumExample example);

    int updateByExample(@Param("record") Num record, @Param("example") NumExample example);
}