package cn.com.qcc.mapper;

import cn.com.qcc.pojo.HistorymeterHousepayExample;
import cn.com.qcc.pojo.HistorymeterHousepayKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistorymeterHousepayMapper {
    int countByExample(HistorymeterHousepayExample example);

    int deleteByExample(HistorymeterHousepayExample example);

    int deleteByPrimaryKey(HistorymeterHousepayKey key);

    int insert(HistorymeterHousepayKey record);

    int insertSelective(HistorymeterHousepayKey record);

    List<HistorymeterHousepayKey> selectByExample(HistorymeterHousepayExample example);

    int updateByExampleSelective(@Param("record") HistorymeterHousepayKey record, @Param("example") HistorymeterHousepayExample example);

    int updateByExample(@Param("record") HistorymeterHousepayKey record, @Param("example") HistorymeterHousepayExample example);
}