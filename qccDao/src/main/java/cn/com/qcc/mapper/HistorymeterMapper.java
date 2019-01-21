package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Historymeter;
import cn.com.qcc.pojo.HistorymeterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistorymeterMapper {
    int countByExample(HistorymeterExample example);

    int deleteByExample(HistorymeterExample example);

    int deleteByPrimaryKey(Long historymeterid);

    int insert(Historymeter record);

    int insertSelective(Historymeter record);

    List<Historymeter> selectByExample(HistorymeterExample example);

    Historymeter selectByPrimaryKey(Long historymeterid);

    int updateByExampleSelective(@Param("record") Historymeter record, @Param("example") HistorymeterExample example);

    int updateByExample(@Param("record") Historymeter record, @Param("example") HistorymeterExample example);

    int updateByPrimaryKeySelective(Historymeter record);

    int updateByPrimaryKey(Historymeter record);
}