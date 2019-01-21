package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.pojo.PayexpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayexpertMapper {
    int countByExample(PayexpertExample example);

    int deleteByExample(PayexpertExample example);

    int deleteByPrimaryKey(Long payexpertid);

    int insert(Payexpert record);

    int insertSelective(Payexpert record);

    List<Payexpert> selectByExample(PayexpertExample example);

    Payexpert selectByPrimaryKey(Long payexpertid);

    int updateByExampleSelective(@Param("record") Payexpert record, @Param("example") PayexpertExample example);

    int updateByExample(@Param("record") Payexpert record, @Param("example") PayexpertExample example);

    int updateByPrimaryKeySelective(Payexpert record);

    int updateByPrimaryKey(Payexpert record);
}