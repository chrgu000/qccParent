package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Landmanager;
import cn.com.qcc.pojo.LandmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandmanagerMapper {
    int countByExample(LandmanagerExample example);

    int deleteByExample(LandmanagerExample example);

    int deleteByPrimaryKey(Long landmanagerid);

    int insert(Landmanager record);

    int insertSelective(Landmanager record);

    List<Landmanager> selectByExample(LandmanagerExample example);

    Landmanager selectByPrimaryKey(Long landmanagerid);

    int updateByExampleSelective(@Param("record") Landmanager record, @Param("example") LandmanagerExample example);

    int updateByExample(@Param("record") Landmanager record, @Param("example") LandmanagerExample example);

    int updateByPrimaryKeySelective(Landmanager record);

    int updateByPrimaryKey(Landmanager record);
}