package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Rongconn;
import cn.com.qcc.pojo.RongconnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RongconnMapper {
    int countByExample(RongconnExample example);

    int deleteByExample(RongconnExample example);

    int deleteByPrimaryKey(Long connid);

    int insert(Rongconn record);

    int insertSelective(Rongconn record);

    List<Rongconn> selectByExample(RongconnExample example);

    Rongconn selectByPrimaryKey(Long connid);

    int updateByExampleSelective(@Param("record") Rongconn record, @Param("example") RongconnExample example);

    int updateByExample(@Param("record") Rongconn record, @Param("example") RongconnExample example);

    int updateByPrimaryKeySelective(Rongconn record);

    int updateByPrimaryKey(Rongconn record);
}