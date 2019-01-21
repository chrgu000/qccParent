package cn.com.qcc.mapper;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Messages;
import cn.com.qcc.pojo.MessagesExample;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MessReply;
import cn.com.qcc.queryvo.UserCustomer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessagesMapper {
    int countByExample(MessagesExample example);

    int deleteByExample(MessagesExample example);

    int deleteByPrimaryKey(Long messagesid);

    int insert(Messages record);

    int insertSelective(Messages record);

    List<Messages> selectByExample(MessagesExample example);

    Messages selectByPrimaryKey(Long messagesid);

    int updateByExampleSelective(@Param("record") Messages record, @Param("example") MessagesExample example);

    int updateByExample(@Param("record") Messages record, @Param("example") MessagesExample example);

    int updateByPrimaryKeySelective(Messages record);

    int updateByPrimaryKey(Messages record);
    
    // 根据用户ID查询房子的留言信息
 	List<UserCustomer> selectComment(@Param("userid")Long userid ,@Param("pagequery")PageQuery pagequery);
 	int selectCommentCount(Long userid);
    
 	// 根据房子ID查询留言
 	List<UserCustomer> findMessagesByHouse(HouseVo houseVo);

 	// 根据房子ID查询留言的总数
 	Integer findMessagesByHouseCount(@Param("house_id") Long house_id, @Param("type") Integer type);

 	// 根据房子ID查询留言
 	List<MessReply> messreply(@Param("messid") Integer messid);
 	
 	//删除留言
 	void deletemess(@Param("messagesreplyid")Long messagesreplyid);

	
}