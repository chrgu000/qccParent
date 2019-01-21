package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Grouptype;
import cn.com.qcc.pojo.GrouptypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrouptypeMapper {
    int countByExample(GrouptypeExample example);

    int deleteByExample(GrouptypeExample example);

    int deleteByPrimaryKey(Long grouptypeid);

    int insert(Grouptype record);

    int insertSelective(Grouptype record);

    List<Grouptype> selectByExample(GrouptypeExample example);

    Grouptype selectByPrimaryKey(Long grouptypeid);

    int updateByExampleSelective(@Param("record") Grouptype record, @Param("example") GrouptypeExample example);

    int updateByExample(@Param("record") Grouptype record, @Param("example") GrouptypeExample example);

    int updateByPrimaryKeySelective(Grouptype record);

    int updateByPrimaryKey(Grouptype record);
}