package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.pojo.TribetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TribetypeMapper {
    int countByExample(TribetypeExample example);

    int deleteByExample(TribetypeExample example);

    int deleteByPrimaryKey(Long tribetypeid);

    int insert(Tribetype record);

    int insertSelective(Tribetype record);

    List<Tribetype> selectByExample(TribetypeExample example);

    Tribetype selectByPrimaryKey(Long tribetypeid);

    int updateByExampleSelective(@Param("record") Tribetype record, @Param("example") TribetypeExample example);

    int updateByExample(@Param("record") Tribetype record, @Param("example") TribetypeExample example);

    int updateByPrimaryKeySelective(Tribetype record);

    int updateByPrimaryKey(Tribetype record);
}