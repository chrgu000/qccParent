package cn.com.qcc.mapper;

import cn.com.qcc.pojo.RoleAccess;
import cn.com.qcc.pojo.RoleAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAccessMapper {
    int countByExample(RoleAccessExample example);

    int deleteByExample(RoleAccessExample example);

    int insert(RoleAccess record);

    int insertSelective(RoleAccess record);

    List<RoleAccess> selectByExample(RoleAccessExample example);

    int updateByExampleSelective(@Param("record") RoleAccess record, @Param("example") RoleAccessExample example);

    int updateByExample(@Param("record") RoleAccess record, @Param("example") RoleAccessExample example);
}