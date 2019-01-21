package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.TribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TribeMapper {
    int countByExample(TribeExample example);

    int deleteByExample(TribeExample example);

    int deleteByPrimaryKey(Long tribeid);

    int insert(Tribe record);

    int insertSelective(Tribe record);

    List<Tribe> selectByExample(TribeExample example);

    Tribe selectByPrimaryKey(Long tribeid);

    int updateByExampleSelective(@Param("record") Tribe record, @Param("example") TribeExample example);

    int updateByExample(@Param("record") Tribe record, @Param("example") TribeExample example);

    int updateByPrimaryKeySelective(Tribe record);

    int updateByPrimaryKey(Tribe record);
}