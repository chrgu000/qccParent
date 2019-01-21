package cn.com.qcc.mapper;

import cn.com.qcc.pojo.LandloadBroker;
import cn.com.qcc.pojo.LandloadBrokerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandloadBrokerMapper {
    int countByExample(LandloadBrokerExample example);

    int deleteByExample(LandloadBrokerExample example);

    int insert(LandloadBroker record);

    int insertSelective(LandloadBroker record);

    List<LandloadBroker> selectByExample(LandloadBrokerExample example);

    int updateByExampleSelective(@Param("record") LandloadBroker record, @Param("example") LandloadBrokerExample example);

    int updateByExample(@Param("record") LandloadBroker record, @Param("example") LandloadBrokerExample example);
}