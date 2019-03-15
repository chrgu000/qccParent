package cn.com.qcc.mapper;

import cn.com.qcc.pojo.LandlordManager;
import cn.com.qcc.pojo.LandlordManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandlordManagerMapper {
    int countByExample(LandlordManagerExample example);

    int deleteByExample(LandlordManagerExample example);

    int deleteByPrimaryKey(Long manageruserid);

    int insert(LandlordManager record);

    int insertSelective(LandlordManager record);

    List<LandlordManager> selectByExample(LandlordManagerExample example);

    LandlordManager selectByPrimaryKey(Long manageruserid);

    int updateByExampleSelective(@Param("record") LandlordManager record, @Param("example") LandlordManagerExample example);

    int updateByExample(@Param("record") LandlordManager record, @Param("example") LandlordManagerExample example);

    int updateByPrimaryKeySelective(LandlordManager record);

    int updateByPrimaryKey(LandlordManager record);
}