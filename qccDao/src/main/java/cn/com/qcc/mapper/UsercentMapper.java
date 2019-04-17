package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.pojo.UsercentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsercentMapper {
    int countByExample(UsercentExample example);

    int deleteByExample(UsercentExample example);

    int deleteByPrimaryKey(Long usercentid);

    int insert(Usercent record);

    int insertSelective(Usercent record);

    List<Usercent> selectByExample(UsercentExample example);

    Usercent selectByPrimaryKey(Long usercentid);

    int updateByExampleSelective(@Param("record") Usercent record, @Param("example") UsercentExample example);

    int updateByExample(@Param("record") Usercent record, @Param("example") UsercentExample example);

    int updateByPrimaryKeySelective(Usercent record);

    int updateByPrimaryKey(Usercent record);

}