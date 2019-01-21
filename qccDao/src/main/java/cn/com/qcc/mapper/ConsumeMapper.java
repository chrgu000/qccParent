package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.ConsumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumeMapper {
    int countByExample(ConsumeExample example);

    int deleteByExample(ConsumeExample example);

    int deleteByPrimaryKey(Long consume_id);

    int insert(Consume record);

    int insertSelective(Consume record);

    List<Consume> selectByExample(ConsumeExample example);

    Consume selectByPrimaryKey(Long consume_id);

    int updateByExampleSelective(@Param("record") Consume record, @Param("example") ConsumeExample example);

    int updateByExample(@Param("record") Consume record, @Param("example") ConsumeExample example);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);
}