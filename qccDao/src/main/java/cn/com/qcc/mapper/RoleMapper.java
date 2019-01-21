package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Role;
import cn.com.qcc.pojo.RoleExample;
import cn.com.qcc.pojo.UserRole;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long roleid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long roleid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    

	List<Role> rolenotinuser(Role role);

	void updateuserrolebyuserid(UserRole userRole);
}