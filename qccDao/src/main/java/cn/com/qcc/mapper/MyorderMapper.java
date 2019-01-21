package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Myorder;
import cn.com.qcc.pojo.MyorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyorderMapper {
    int countByExample(MyorderExample example);

    int deleteByExample(MyorderExample example);

    int deleteByPrimaryKey(Long ordernum);

    int insert(Myorder record);

    int insertSelective(Myorder record);

    List<Myorder> selectByExample(MyorderExample example);

    Myorder selectByPrimaryKey(Long ordernum);

    int updateByExampleSelective(@Param("record") Myorder record, @Param("example") MyorderExample example);

    int updateByExample(@Param("record") Myorder record, @Param("example") MyorderExample example);

    int updateByPrimaryKeySelective(Myorder record);

    int updateByPrimaryKey(Myorder record);
    
    Long getordernum();
}