package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Tribecontroller;
import cn.com.qcc.pojo.TribecontrollerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TribecontrollerMapper {
    int countByExample(TribecontrollerExample example);

    int deleteByExample(TribecontrollerExample example);

    int deleteByPrimaryKey(Long controllerid);

    int insert(Tribecontroller record);

    int insertSelective(Tribecontroller record);

    List<Tribecontroller> selectByExample(TribecontrollerExample example);

    Tribecontroller selectByPrimaryKey(Long controllerid);

    int updateByExampleSelective(@Param("record") Tribecontroller record, @Param("example") TribecontrollerExample example);

    int updateByExample(@Param("record") Tribecontroller record, @Param("example") TribecontrollerExample example);

    int updateByPrimaryKeySelective(Tribecontroller record);

    int updateByPrimaryKey(Tribecontroller record);
}