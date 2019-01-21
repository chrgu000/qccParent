package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.PaymodalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymodalMapper {
    int countByExample(PaymodalExample example);

    int deleteByExample(PaymodalExample example);

    int deleteByPrimaryKey(Long paymodalid);

    int insert(Paymodal record);

    int insertSelective(Paymodal record);

    List<Paymodal> selectByExample(PaymodalExample example);

    Paymodal selectByPrimaryKey(Long paymodalid);

    int updateByExampleSelective(@Param("record") Paymodal record, @Param("example") PaymodalExample example);

    int updateByExample(@Param("record") Paymodal record, @Param("example") PaymodalExample example);

    int updateByPrimaryKeySelective(Paymodal record);

    int updateByPrimaryKey(Paymodal record);
}