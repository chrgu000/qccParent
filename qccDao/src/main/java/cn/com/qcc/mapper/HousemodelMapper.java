package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Housemodel;
import cn.com.qcc.pojo.HousemodelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HousemodelMapper {
    int countByExample(HousemodelExample example);

    int deleteByExample(HousemodelExample example);

    int deleteByPrimaryKey(Long houseModelId);

    int insert(Housemodel record);

    int insertSelective(Housemodel record);

    List<Housemodel> selectByExample(HousemodelExample example);

    Housemodel selectByPrimaryKey(Long houseModelId);

    int updateByExampleSelective(@Param("record") Housemodel record, @Param("example") HousemodelExample example);

    int updateByExample(@Param("record") Housemodel record, @Param("example") HousemodelExample example);

    int updateByPrimaryKeySelective(Housemodel record);

    int updateByPrimaryKey(Housemodel record);
}