package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.BuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyMapper {
    int countByExample(BuyExample example);

    int deleteByExample(BuyExample example);

    int deleteByPrimaryKey(Long buyid);

    int insert(Buy record);

    int insertSelective(Buy record);

    List<Buy> selectByExample(BuyExample example);

    Buy selectByPrimaryKey(Long buyid);

    int updateByExampleSelective(@Param("record") Buy record, @Param("example") BuyExample example);

    int updateByExample(@Param("record") Buy record, @Param("example") BuyExample example);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);
}