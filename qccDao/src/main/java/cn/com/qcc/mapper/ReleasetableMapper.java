package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Releasetable;
import cn.com.qcc.pojo.ReleasetableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReleasetableMapper {
    int countByExample(ReleasetableExample example);

    int deleteByExample(ReleasetableExample example);

    int deleteByPrimaryKey(Long releaseid);

    int insert(Releasetable record);

    int insertSelective(Releasetable record);

    List<Releasetable> selectByExample(ReleasetableExample example);

    Releasetable selectByPrimaryKey(Long releaseid);

    int updateByExampleSelective(@Param("record") Releasetable record, @Param("example") ReleasetableExample example);

    int updateByExample(@Param("record") Releasetable record, @Param("example") ReleasetableExample example);

    int updateByPrimaryKeySelective(Releasetable record);

    int updateByPrimaryKey(Releasetable record);
}