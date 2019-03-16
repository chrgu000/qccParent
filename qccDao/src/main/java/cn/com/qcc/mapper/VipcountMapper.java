package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.pojo.VipcountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VipcountMapper {
    int countByExample(VipcountExample example);

    int deleteByExample(VipcountExample example);

    int deleteByPrimaryKey(Long user_id);

    int insert(Vipcount record);

    int insertSelective(Vipcount record);

    List<Vipcount> selectByExample(VipcountExample example);

    Vipcount selectByPrimaryKey(Long user_id);

    int updateByExampleSelective(@Param("record") Vipcount record, @Param("example") VipcountExample example);

    int updateByExample(@Param("record") Vipcount record, @Param("example") VipcountExample example);

    int updateByPrimaryKeySelective(Vipcount record);

    int updateByPrimaryKey(Vipcount record);

}