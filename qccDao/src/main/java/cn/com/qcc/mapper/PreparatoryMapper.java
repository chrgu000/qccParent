package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Preparatory;
import cn.com.qcc.pojo.PreparatoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreparatoryMapper {
    int countByExample(PreparatoryExample example);

    int deleteByExample(PreparatoryExample example);

    int deleteByPrimaryKey(Long preparatoryid);

    int insert(Preparatory record);

    int insertSelective(Preparatory record);

    List<Preparatory> selectByExample(PreparatoryExample example);

    Preparatory selectByPrimaryKey(Long preparatoryid);

    int updateByExampleSelective(@Param("record") Preparatory record, @Param("example") PreparatoryExample example);

    int updateByExample(@Param("record") Preparatory record, @Param("example") PreparatoryExample example);

    int updateByPrimaryKeySelective(Preparatory record);

    int updateByPrimaryKey(Preparatory record);
}