package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Appversion;
import cn.com.qcc.pojo.AppversionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppversionMapper {
    int countByExample(AppversionExample example);

    int deleteByExample(AppversionExample example);

    int deleteByPrimaryKey(String versionid);

    int insert(Appversion record);

    int insertSelective(Appversion record);

    List<Appversion> selectByExample(AppversionExample example);

    Appversion selectByPrimaryKey(String versionid);

    int updateByExampleSelective(@Param("record") Appversion record, @Param("example") AppversionExample example);

    int updateByExample(@Param("record") Appversion record, @Param("example") AppversionExample example);

    int updateByPrimaryKeySelective(Appversion record);

    int updateByPrimaryKey(Appversion record);

	Appversion newVersionByType(Integer type);

	List<Appversion> getall();
}