package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Userconn;
import cn.com.qcc.pojo.UserconnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserconnMapper {
    int countByExample(UserconnExample example);

    int deleteByExample(UserconnExample example);

    int deleteByPrimaryKey(Long userconnid);

    int insert(Userconn record);

    int insertSelective(Userconn record);

    List<Userconn> selectByExample(UserconnExample example);

    Userconn selectByPrimaryKey(Long userconnid);

    int updateByExampleSelective(@Param("record") Userconn record, @Param("example") UserconnExample example);

    int updateByExample(@Param("record") Userconn record, @Param("example") UserconnExample example);

    int updateByPrimaryKeySelective(Userconn record);

    int updateByPrimaryKey(Userconn record);
}