package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Partnertrade;
import cn.com.qcc.pojo.PartnertradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartnertradeMapper {
    int countByExample(PartnertradeExample example);

    int deleteByExample(PartnertradeExample example);

    int deleteByPrimaryKey(Long partnertradeno);

    int insert(Partnertrade record);

    int insertSelective(Partnertrade record);

    List<Partnertrade> selectByExample(PartnertradeExample example);

    Partnertrade selectByPrimaryKey(Long partnertradeno);

    int updateByExampleSelective(@Param("record") Partnertrade record, @Param("example") PartnertradeExample example);

    int updateByExample(@Param("record") Partnertrade record, @Param("example") PartnertradeExample example);

    int updateByPrimaryKeySelective(Partnertrade record);

    int updateByPrimaryKey(Partnertrade record);
}