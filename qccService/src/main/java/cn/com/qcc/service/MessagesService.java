package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Messages;
import cn.com.qcc.pojo.Messagesreply;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MessReply;
import cn.com.qcc.queryvo.UserCustomer;

public interface MessagesService {

	/**
	 * 添加留言
	 * **/ 
	public void addMessages(Messages messages);

	/**
	 *  根据主键查询留言列表
	 *  @param house_id : 留言物品主键
	 *  @param type : 类型
	 * **/ 
	public List<UserCustomer> findMessagesByHouse(HouseVo houseVo);
	public int findMessagesByHouseCount(Long house_id,Integer type);

	/**
	 * 查询当前用户下房子的留言情况
	 * **/ 
	public List<UserCustomer> selectComment(Long userid ,PageQuery pagequry);
	public int selectCommentCount(Long userid);
	
	/**
	 * 消息回复
	 * **/
	public ResultMap messagereply(Messagesreply messagesreply);

	
	/**
	 * 根据一级留言查询所有的二级留言
	 * @param messid : 一级留言id
	 * **/
	public List<MessReply> getreply(Integer messid);
	
	/**
	 * 删除二级留言
	 * **/
	public void deletemess(Long messagesreplyid);
	
	/**
	 * 获取二级留言 的集合
	 * @param messageid : 一级留言id
	 * **/
	public List<Messagesreply> getmessreply(Long messagesid);
	
	/**
	 * 删除一级留言
	 * **/
	public void deletemessall(Long messagesid);

	

}
