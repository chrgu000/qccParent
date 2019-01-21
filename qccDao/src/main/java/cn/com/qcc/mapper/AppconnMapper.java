package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Appconn;
import cn.com.qcc.pojo.AppconnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppconnMapper {
    int countByExample(AppconnExample example);

    int deleteByExample(AppconnExample example);

    int deleteByPrimaryKey(String phoneAddress);

    int insert(Appconn record);

    int insertSelective(Appconn record);

    List<Appconn> selectByExample(AppconnExample example);

    Appconn selectByPrimaryKey(String phoneAddress);

    int updateByExampleSelective(@Param("record") Appconn record, @Param("example") AppconnExample example);

    int updateByExample(@Param("record") Appconn record, @Param("example") AppconnExample example);

    int updateByPrimaryKeySelective(Appconn record);

    int updateByPrimaryKey(Appconn record);
}