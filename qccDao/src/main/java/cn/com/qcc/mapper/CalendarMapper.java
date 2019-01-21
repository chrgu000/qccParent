package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Calendar;
import cn.com.qcc.pojo.CalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CalendarMapper {
    int countByExample(CalendarExample example);

    int deleteByExample(CalendarExample example);

    int deleteByPrimaryKey(String datelist);

    int insert(Calendar record);

    int insertSelective(Calendar record);

    List<Calendar> selectByExample(CalendarExample example);

    int updateByExampleSelective(@Param("record") Calendar record, @Param("example") CalendarExample example);

    int updateByExample(@Param("record") Calendar record, @Param("example") CalendarExample example);
}