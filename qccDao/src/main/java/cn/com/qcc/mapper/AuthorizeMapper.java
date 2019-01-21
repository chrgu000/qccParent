package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Authorize;
import cn.com.qcc.pojo.AuthorizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizeMapper {
    int countByExample(AuthorizeExample example);

    int deleteByExample(AuthorizeExample example);

    int deleteByPrimaryKey(Long authorizeid);

    int insert(Authorize record);

    int insertSelective(Authorize record);

    List<Authorize> selectByExample(AuthorizeExample example);

    Authorize selectByPrimaryKey(Long authorizeid);

    int updateByExampleSelective(@Param("record") Authorize record, @Param("example") AuthorizeExample example);

    int updateByExample(@Param("record") Authorize record, @Param("example") AuthorizeExample example);

    int updateByPrimaryKeySelective(Authorize record);

    int updateByPrimaryKey(Authorize record);
}