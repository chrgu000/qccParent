package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.RonggroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RonggroupMapper {
    int countByExample(RonggroupExample example);

    int deleteByExample(RonggroupExample example);

    int deleteByPrimaryKey(Long groupid);

    int insert(Ronggroup record);

    int insertSelective(Ronggroup record);

    List<Ronggroup> selectByExample(RonggroupExample example);

    Ronggroup selectByPrimaryKey(Long groupid);

    int updateByExampleSelective(@Param("record") Ronggroup record, @Param("example") RonggroupExample example);

    int updateByExample(@Param("record") Ronggroup record, @Param("example") RonggroupExample example);

    int updateByPrimaryKeySelective(Ronggroup record);

    int updateByPrimaryKey(Ronggroup record);
}