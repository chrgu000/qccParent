package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Villagetrategy;
import cn.com.qcc.pojo.VillagetrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VillagetrategyMapper {
    int countByExample(VillagetrategyExample example);

    int deleteByExample(VillagetrategyExample example);

    int deleteByPrimaryKey(Long trategyid);

    int insert(Villagetrategy record);

    int insertSelective(Villagetrategy record);

    List<Villagetrategy> selectByExample(VillagetrategyExample example);

    Villagetrategy selectByPrimaryKey(Long trategyid);

    int updateByExampleSelective(@Param("record") Villagetrategy record, @Param("example") VillagetrategyExample example);

    int updateByExample(@Param("record") Villagetrategy record, @Param("example") VillagetrategyExample example);

    int updateByPrimaryKeySelective(Villagetrategy record);

    int updateByPrimaryKey(Villagetrategy record);
}