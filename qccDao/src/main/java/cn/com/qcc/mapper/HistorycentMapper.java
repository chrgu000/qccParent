package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Historycent;
import cn.com.qcc.pojo.HistorycentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistorycentMapper {
    int countByExample(HistorycentExample example);

    int deleteByExample(HistorycentExample example);

    int deleteByPrimaryKey(Long historycentid);

    int insert(Historycent record);

    int insertSelective(Historycent record);

    List<Historycent> selectByExample(HistorycentExample example);

    Historycent selectByPrimaryKey(Long historycentid);

    int updateByExampleSelective(@Param("record") Historycent record, @Param("example") HistorycentExample example);

    int updateByExample(@Param("record") Historycent record, @Param("example") HistorycentExample example);

    int updateByPrimaryKeySelective(Historycent record);

    int updateByPrimaryKey(Historycent record);
}