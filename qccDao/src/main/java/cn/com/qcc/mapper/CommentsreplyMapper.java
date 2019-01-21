package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Commentsreply;
import cn.com.qcc.pojo.CommentsreplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsreplyMapper {
    int countByExample(CommentsreplyExample example);

    int deleteByExample(CommentsreplyExample example);

    int deleteByPrimaryKey(Long commentsreply_id);

    int insert(Commentsreply record);

    int insertSelective(Commentsreply record);

    List<Commentsreply> selectByExample(CommentsreplyExample example);

    Commentsreply selectByPrimaryKey(Long commentsreply_id);

    int updateByExampleSelective(@Param("record") Commentsreply record, @Param("example") CommentsreplyExample example);

    int updateByExample(@Param("record") Commentsreply record, @Param("example") CommentsreplyExample example);

    int updateByPrimaryKeySelective(Commentsreply record);

    int updateByPrimaryKey(Commentsreply record);
}