package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Groupaddress;
import cn.com.qcc.pojo.GroupaddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupaddressMapper {
    int countByExample(GroupaddressExample example);

    int deleteByExample(GroupaddressExample example);

    int deleteByPrimaryKey(Long detailid);

    int insert(Groupaddress record);

    int insertSelective(Groupaddress record);

    List<Groupaddress> selectByExample(GroupaddressExample example);

    Groupaddress selectByPrimaryKey(Long detailid);

    int updateByExampleSelective(@Param("record") Groupaddress record, @Param("example") GroupaddressExample example);

    int updateByExample(@Param("record") Groupaddress record, @Param("example") GroupaddressExample example);

    int updateByPrimaryKeySelective(Groupaddress record);

    int updateByPrimaryKey(Groupaddress record);
}