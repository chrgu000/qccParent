package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.BrokerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrokerMapper {
    int countByExample(BrokerExample example);

    int deleteByExample(BrokerExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(Broker record);

    int insertSelective(Broker record);

    List<Broker> selectByExample(BrokerExample example);

    Broker selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") Broker record, @Param("example") BrokerExample example);

    int updateByExample(@Param("record") Broker record, @Param("example") BrokerExample example);

    int updateByPrimaryKeySelective(Broker record);

    int updateByPrimaryKey(Broker record);
}