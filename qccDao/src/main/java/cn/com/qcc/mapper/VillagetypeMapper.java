package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Villagetype;
import cn.com.qcc.pojo.VillagetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VillagetypeMapper {
    int countByExample(VillagetypeExample example);

    int deleteByExample(VillagetypeExample example);

    int deleteByPrimaryKey(Long villagetypeid);

    int insert(Villagetype record);

    int insertSelective(Villagetype record);

    List<Villagetype> selectByExample(VillagetypeExample example);

    Villagetype selectByPrimaryKey(Long villagetypeid);

    int updateByExampleSelective(@Param("record") Villagetype record, @Param("example") VillagetypeExample example);

    int updateByExample(@Param("record") Villagetype record, @Param("example") VillagetypeExample example);

    int updateByPrimaryKeySelective(Villagetype record);

    int updateByPrimaryKey(Villagetype record);
}