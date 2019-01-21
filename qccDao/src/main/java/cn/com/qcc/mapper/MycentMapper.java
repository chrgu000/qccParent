package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.MycentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MycentMapper {
    int countByExample(MycentExample example);

    int deleteByExample(MycentExample example);

    int deleteByPrimaryKey(Long mycentid);

    int insert(Mycent record);

    int insertSelective(Mycent record);

    List<Mycent> selectByExample(MycentExample example);

    Mycent selectByPrimaryKey(Long mycentid);

    int updateByExampleSelective(@Param("record") Mycent record, @Param("example") MycentExample example);

    int updateByExample(@Param("record") Mycent record, @Param("example") MycentExample example);

    int updateByPrimaryKeySelective(Mycent record);

    int updateByPrimaryKey(Mycent record);
}