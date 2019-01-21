package cn.com.qcc.mapper;

import cn.com.qcc.pojo.ManageUser;
import cn.com.qcc.pojo.ManageUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManageUserMapper {
    int countByExample(ManageUserExample example);

    int deleteByExample(ManageUserExample example);

    int insert(ManageUser record);

    int insertSelective(ManageUser record);

    List<ManageUser> selectByExample(ManageUserExample example);

    int updateByExampleSelective(@Param("record") ManageUser record, @Param("example") ManageUserExample example);

    int updateByExample(@Param("record") ManageUser record, @Param("example") ManageUserExample example);
}