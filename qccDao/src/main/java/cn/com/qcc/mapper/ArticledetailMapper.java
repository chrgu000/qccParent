package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.ArticledetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticledetailMapper {
    int countByExample(ArticledetailExample example);

    int deleteByExample(ArticledetailExample example);

    int deleteByPrimaryKey(Long articledetailid);

    int insert(Articledetail record);

    int insertSelective(Articledetail record);

    List<Articledetail> selectByExample(ArticledetailExample example);

    Articledetail selectByPrimaryKey(Long articledetailid);

    int updateByExampleSelective(@Param("record") Articledetail record, @Param("example") ArticledetailExample example);

    int updateByExample(@Param("record") Articledetail record, @Param("example") ArticledetailExample example);

    int updateByPrimaryKeySelective(Articledetail record);

    int updateByPrimaryKey(Articledetail record);
}