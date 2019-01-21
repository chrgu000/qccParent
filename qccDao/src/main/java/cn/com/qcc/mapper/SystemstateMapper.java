package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Systemstate;
import cn.com.qcc.pojo.SystemstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemstateMapper {
    int countByExample(SystemstateExample example);

    int deleteByExample(SystemstateExample example);

    int deleteByPrimaryKey(Integer systemid);

    int insert(Systemstate record);

    int insertSelective(Systemstate record);

    List<Systemstate> selectByExample(SystemstateExample example);

    Systemstate selectByPrimaryKey(Integer systemid);

    int updateByExampleSelective(@Param("record") Systemstate record, @Param("example") SystemstateExample example);

    int updateByExample(@Param("record") Systemstate record, @Param("example") SystemstateExample example);

    int updateByPrimaryKeySelective(Systemstate record);

    int updateByPrimaryKey(Systemstate record);

}