package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Masonry;
import cn.com.qcc.pojo.MasonryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasonryMapper {
    int countByExample(MasonryExample example);

    int deleteByExample(MasonryExample example);

    int deleteByPrimaryKey(Long masonryid);

    int insert(Masonry record);

    int insertSelective(Masonry record);

    List<Masonry> selectByExample(MasonryExample example);

    Masonry selectByPrimaryKey(Long masonryid);

    int updateByExampleSelective(@Param("record") Masonry record, @Param("example") MasonryExample example);

    int updateByExample(@Param("record") Masonry record, @Param("example") MasonryExample example);

    int updateByPrimaryKeySelective(Masonry record);

    int updateByPrimaryKey(Masonry record);
}