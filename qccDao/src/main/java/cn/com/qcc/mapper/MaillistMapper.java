package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Maillist;
import cn.com.qcc.pojo.MaillistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaillistMapper {
    int countByExample(MaillistExample example);

    int deleteByExample(MaillistExample example);

    int insert(Maillist record);

    int insertSelective(Maillist record);

    List<Maillist> selectByExample(MaillistExample example);

    int updateByExampleSelective(@Param("record") Maillist record, @Param("example") MaillistExample example);

    int updateByExample(@Param("record") Maillist record, @Param("example") MaillistExample example);
}