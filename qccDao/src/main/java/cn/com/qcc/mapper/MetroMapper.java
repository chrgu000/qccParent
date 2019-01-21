package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.MetroExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MetroMapper {
    int countByExample(MetroExample example);

    int deleteByExample(MetroExample example);

    int deleteByPrimaryKey(Long metroid);

    int insert(Metro record);

    int insertSelective(Metro record);

    List<Metro> selectByExample(MetroExample example);

    Metro selectByPrimaryKey(Long metroid);

    int updateByExampleSelective(@Param("record") Metro record, @Param("example") MetroExample example);

    int updateByExample(@Param("record") Metro record, @Param("example") MetroExample example);

    int updateByPrimaryKeySelective(Metro record);

    int updateByPrimaryKey(Metro record);
}