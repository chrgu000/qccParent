package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Commoninte;
import cn.com.qcc.pojo.CommoninteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommoninteMapper {
    int countByExample(CommoninteExample example);

    int deleteByExample(CommoninteExample example);

    int deleteByPrimaryKey(Long commonid);

    int insert(Commoninte record);

    int insertSelective(Commoninte record);

    List<Commoninte> selectByExample(CommoninteExample example);

    Commoninte selectByPrimaryKey(Long commonid);

    int updateByExampleSelective(@Param("record") Commoninte record, @Param("example") CommoninteExample example);

    int updateByExample(@Param("record") Commoninte record, @Param("example") CommoninteExample example);

    int updateByPrimaryKeySelective(Commoninte record);

    int updateByPrimaryKey(Commoninte record);
}