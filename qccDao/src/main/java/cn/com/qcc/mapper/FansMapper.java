package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Fans;
import cn.com.qcc.pojo.FansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FansMapper {
    int countByExample(FansExample example);

    int deleteByExample(FansExample example);

    int deleteByPrimaryKey(Long fansId);

    int insert(Fans record);

    int insertSelective(Fans record);

    List<Fans> selectByExample(FansExample example);

    Fans selectByPrimaryKey(Long fansId);

    int updateByExampleSelective(@Param("record") Fans record, @Param("example") FansExample example);

    int updateByExample(@Param("record") Fans record, @Param("example") FansExample example);

    int updateByPrimaryKeySelective(Fans record);

    int updateByPrimaryKey(Fans record);
    
    
   // 查看粉丝的数量
 	int findFollowCountByUserId(@Param("userid") Long userid);

 	// 查看关注的数量
 	int findFansCountByUserIdandstatus(@Param("userid")Long userid);

 	// 更改粉丝的状态
 	void updateFansState(@Param("userid")Long userid,@Param("followUserId") Long followUserId);
}