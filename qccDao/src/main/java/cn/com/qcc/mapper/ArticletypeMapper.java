package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.ArticletypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticletypeMapper {
    int countByExample(ArticletypeExample example);

    int deleteByExample(ArticletypeExample example);

    int deleteByPrimaryKey(Long onetypeid);

    int insert(Articletype record);

    int insertSelective(Articletype record);

    List<Articletype> selectByExample(ArticletypeExample example);

    Articletype selectByPrimaryKey(Long onetypeid);

    int updateByExampleSelective(@Param("record") Articletype record, @Param("example") ArticletypeExample example);

    int updateByExample(@Param("record") Articletype record, @Param("example") ArticletypeExample example);

    int updateByPrimaryKeySelective(Articletype record);

    int updateByPrimaryKey(Articletype record);
}