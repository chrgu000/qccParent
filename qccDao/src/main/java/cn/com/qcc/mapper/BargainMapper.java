package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.BargainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BargainMapper {
    int countByExample(BargainExample example);

    int deleteByExample(BargainExample example);

    int insert(Bargain record);

    int insertSelective(Bargain record);

    List<Bargain> selectByExample(BargainExample example);

    int updateByExampleSelective(@Param("record") Bargain record, @Param("example") BargainExample example);

    int updateByExample(@Param("record") Bargain record, @Param("example") BargainExample example);
}