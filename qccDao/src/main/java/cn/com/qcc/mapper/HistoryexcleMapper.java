package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Historyexcle;
import cn.com.qcc.pojo.HistoryexcleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryexcleMapper {
    int countByExample(HistoryexcleExample example);

    int deleteByExample(HistoryexcleExample example);

    int deleteByPrimaryKey(Long historyexclid);

    int insert(Historyexcle record);

    int insertSelective(Historyexcle record);

    List<Historyexcle> selectByExample(HistoryexcleExample example);

    Historyexcle selectByPrimaryKey(Long historyexclid);

    int updateByExampleSelective(@Param("record") Historyexcle record, @Param("example") HistoryexcleExample example);

    int updateByExample(@Param("record") Historyexcle record, @Param("example") HistoryexcleExample example);

    int updateByPrimaryKeySelective(Historyexcle record);

    int updateByPrimaryKey(Historyexcle record);
}