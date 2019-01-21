package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Branduser;
import cn.com.qcc.pojo.BranduserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BranduserMapper {
    int countByExample(BranduserExample example);

    int deleteByExample(BranduserExample example);

    int insert(Branduser record);

    int insertSelective(Branduser record);

    List<Branduser> selectByExample(BranduserExample example);

    int updateByExampleSelective(@Param("record") Branduser record, @Param("example") BranduserExample example);

    int updateByExample(@Param("record") Branduser record, @Param("example") BranduserExample example);
    
    void changeusertype(Branduser branduser);
}