package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Backimage;
import cn.com.qcc.pojo.BackimageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackimageMapper {
    int countByExample(BackimageExample example);

    int deleteByExample(BackimageExample example);

    int deleteByPrimaryKey(Long backimageid);

    int insert(Backimage record);

    int insertSelective(Backimage record);

    List<Backimage> selectByExample(BackimageExample example);

    Backimage selectByPrimaryKey(Long backimageid);

    int updateByExampleSelective(@Param("record") Backimage record, @Param("example") BackimageExample example);

    int updateByExample(@Param("record") Backimage record, @Param("example") BackimageExample example);

    int updateByPrimaryKeySelective(Backimage record);

    int updateByPrimaryKey(Backimage record);
}