package cn.com.qcc.mapper;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Zan;
import cn.com.qcc.pojo.ZanExample;
import cn.com.qcc.queryvo.ZanCustomer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZanMapper {
    int countByExample(ZanExample example);

    int deleteByExample(ZanExample example);

    int deleteByPrimaryKey(Long zanId);

    int insert(Zan record);

    int insertSelective(Zan record);

    List<Zan> selectByExample(ZanExample example);

    Zan selectByPrimaryKey(Long zanId);

    int updateByExampleSelective(@Param("record") Zan record, @Param("example") ZanExample example);

    int updateByExample(@Param("record") Zan record, @Param("example") ZanExample example);

    int updateByPrimaryKeySelective(Zan record);

    int updateByPrimaryKey(Zan record);
    
    
    // 查询赞详情
 	List<ZanCustomer> findzanfollow(@Param("userid")Long userid ,@Param("pagequery") PageQuery pagequery);
 	int findzanfollowCount(@Param("userid")Long userid);
}