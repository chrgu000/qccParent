package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Releasetype;
import cn.com.qcc.pojo.ReleasetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReleasetypeMapper {
    int countByExample(ReleasetypeExample example);

    int deleteByExample(ReleasetypeExample example);

    int deleteByPrimaryKey(Integer releasetypeid);

    int insert(Releasetype record);

    int insertSelective(Releasetype record);

    List<Releasetype> selectByExample(ReleasetypeExample example);

    Releasetype selectByPrimaryKey(Integer releasetypeid);

    int updateByExampleSelective(@Param("record") Releasetype record, @Param("example") ReleasetypeExample example);

    int updateByExample(@Param("record") Releasetype record, @Param("example") ReleasetypeExample example);

    int updateByPrimaryKeySelective(Releasetype record);

    int updateByPrimaryKey(Releasetype record);
}