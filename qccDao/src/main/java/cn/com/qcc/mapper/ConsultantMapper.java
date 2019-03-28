package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Consultant;
import cn.com.qcc.pojo.ConsultantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantMapper {
    int countByExample(ConsultantExample example);

    int deleteByExample(ConsultantExample example);

    int insert(Consultant record);

    int insertSelective(Consultant record);

    List<Consultant> selectByExample(ConsultantExample example);

    int updateByExampleSelective(@Param("record") Consultant record, @Param("example") ConsultantExample example);

    int updateByExample(@Param("record") Consultant record, @Param("example") ConsultantExample example);
}