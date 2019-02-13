package cn.com.qcc.mapper;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.AccessExample;
import cn.com.qcc.pojo.Role;
import cn.com.qcc.queryvo.UserCustomer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessMapper {
    int countByExample(AccessExample example);

    int deleteByExample(AccessExample example);

    int deleteByPrimaryKey(Long accessid);

    int insert(Access record);

    int insertSelective(Access record);

    List<Access> selectByExample(AccessExample example);

    Access selectByPrimaryKey(Long accessid);

    int updateByExampleSelective(@Param("record") Access record, @Param("example") AccessExample example);

    int updateByExample(@Param("record") Access record, @Param("example") AccessExample example);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);
    
    List<Access> getrole_access(Long roleid);

	List<Access> isinrole(@Param("idsList")String[] str);

	List<Access> isnotrole(@Param("idsList")String[] str);
	
	void deletebyroleid(Role role);
	
	/**查询需要添加的系统账号**/
	int searchAddRoleCount(@Param("searchWhere") String searchWhere);
	List<UserCustomer> searchAddRole(@Param("searchWhere")String searchWhere,
			@Param("pagequery")PageQuery pagequery);
}