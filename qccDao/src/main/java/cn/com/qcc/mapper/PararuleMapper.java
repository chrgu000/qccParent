package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Pararule;
import cn.com.qcc.pojo.PararuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PararuleMapper {
    int countByExample(PararuleExample example);

    int deleteByExample(PararuleExample example);

    int deleteByPrimaryKey(Integer pararuleid);

    int insert(Pararule record);

    int insertSelective(Pararule record);

    List<Pararule> selectByExample(PararuleExample example);

    Pararule selectByPrimaryKey(Integer pararuleid);

    int updateByExampleSelective(@Param("record") Pararule record, @Param("example") PararuleExample example);

    int updateByExample(@Param("record") Pararule record, @Param("example") PararuleExample example);

    int updateByPrimaryKeySelective(Pararule record);

    int updateByPrimaryKey(Pararule record);
}