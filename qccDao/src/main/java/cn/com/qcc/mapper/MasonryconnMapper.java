package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Masonryconn;
import cn.com.qcc.pojo.MasonryconnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasonryconnMapper {
    int countByExample(MasonryconnExample example);

    int deleteByExample(MasonryconnExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(Masonryconn record);

    int insertSelective(Masonryconn record);

    List<Masonryconn> selectByExample(MasonryconnExample example);

    Masonryconn selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") Masonryconn record, @Param("example") MasonryconnExample example);

    int updateByExample(@Param("record") Masonryconn record, @Param("example") MasonryconnExample example);

    int updateByPrimaryKeySelective(Masonryconn record);

    int updateByPrimaryKey(Masonryconn record);
}