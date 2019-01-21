package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.HousepayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HousepayMapper {
    int countByExample(HousepayExample example);

    int deleteByExample(HousepayExample example);

    int deleteByPrimaryKey(Long housepayid);

    int insert(Housepay record);

    int insertSelective(Housepay record);

    List<Housepay> selectByExample(HousepayExample example);

    Housepay selectByPrimaryKey(Long housepayid);

    int updateByExampleSelective(@Param("record") Housepay record, @Param("example") HousepayExample example);

    int updateByExample(@Param("record") Housepay record, @Param("example") HousepayExample example);

    int updateByPrimaryKeySelective(Housepay record);

    int updateByPrimaryKey(Housepay record);
}