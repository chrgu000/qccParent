package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.InteconnMapper;
import cn.com.qcc.mapper.IntegralMapper;
import cn.com.qcc.mapper.MessagesMapper;
import cn.com.qcc.mapper.MessagesreplyMapper;
import cn.com.qcc.pojo.Inteconn;
import cn.com.qcc.pojo.Integral;
import cn.com.qcc.pojo.Messages;
import cn.com.qcc.pojo.Messagesreply;
import cn.com.qcc.pojo.MessagesreplyExample;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MessReply;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.MessagesService;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	MessagesMapper messagesMapper;
	@Autowired
	MessagesreplyMapper messagesreplyMapper;
	@Autowired
	InteconnMapper inteconnMapper;
	@Autowired
	IntegralMapper  integralMapper;

	/**
	 * 添加留言
	 * **/ 
	public void addMessages(Messages messages) {
		if (messages.getHouse_id() !=null) {
			messages.setState(1);
			messages.setCreate_time(new Date());
			messages.setUpdate_time(new Date());
			messagesMapper.insertSelective(messages);
			managebranch( 11, messages.getUser_id());
			
		}
	}
	
	
	
	
	/**
	 *  根据主键查询留言列表
	 * **/ 
	public List<UserCustomer> findMessagesByHouse(HouseVo houseVo) {
		return messagesMapper.findMessagesByHouse(houseVo);
	}
	public int findMessagesByHouseCount(Long house_id,Integer type) {
		return messagesMapper.findMessagesByHouseCount(house_id,type);
	}
	
	

	/**
	 * 查询当前用户下房子的留言情况
	 * **/ 
	public List<UserCustomer> selectComment(Long userid ,PageQuery pagequery) {
		return messagesMapper.selectComment(userid ,pagequery);
	}
	public int selectCommentCount(Long userid) {
		return messagesMapper.selectCommentCount(userid);
	}
	
	
	/**
	 * 消息回复
	 * **/
	public ResultMap messagereply(Messagesreply messagesreply) {
		if (messagesreply.getUserid() == null) {
			return ResultMap.build(404, "登录后在回复");
		}
		if (messagesreply.getMessagesid() == null) {
			return ResultMap.build(400, "要回复的对象不存在");
		}
		if (messagesreply.getFollowUserid() == null) {
			return ResultMap.build(400, "要回复的对象不存在");
		}
		
		messagesreply.setUpdate_time( new Date());
		messagesreply.setState(1);
		messagesreplyMapper.insertSelective(messagesreply);
		return ResultMap.IS_200();
	}

	/**
	 * 根据一级留言查询所有的二级留言
	 * @param messid : 一级留言id
	 * **/
	public List<MessReply> getreply(Integer messid) {
		return messagesMapper.messreply(messid);
	}

	/**
	 * 删除二级留言
	 * **/
	public void deletemess(Long messagesreplyid) {
		messagesreplyMapper.deleteByPrimaryKey(messagesreplyid);
	}

	/**
	 * 获取二级留言 的集合
	 * @param messageid : 一级留言id
	 * **/
	public List<Messagesreply> getmessreply(Long messagesid) {
		MessagesreplyExample example = new MessagesreplyExample();
		MessagesreplyExample.Criteria criteria = example.createCriteria();
		criteria.andMessagesidEqualTo(messagesid);
		return messagesreplyMapper.selectByExample(example);
	}

	/**
	 * 删除一级留言
	 * **/
	public void deletemessall(Long messagesid) {
		messagesMapper.deleteByPrimaryKey(messagesid);
	}

	
	
	
	//处理获得的积分
	public void managebranch(int type, Long userid) {
		String event = "";
		Long count = 0L;
		//统计积分事件
		Integral integral = new Integral();
		integral.setUpdate_time(new Date());
		integral.setUserid(userid);
		integral.setType(1);
		//处理积分事件详情 3--求租
		if (type == 11) {
			event = "留言" ; count = 1L;
		}
		if (type == 3) {
			event = "发布求租"; count = 100L;
		}
		//处理部落签到
		if (type == 10) {
			event = "部落签到";count = 1L;
		}
		//处理提问 8
		if (type == 8 ) {
			event = "发布提问";count = 1L;
		}
		integral.setEvent(event);
		integral.setCount(count);
		integralMapper.insertSelective(integral);
		
		//控制积分总数
		Inteconn inteconn_search = inteconnMapper.selectByPrimaryKey(userid);
		//如果控制表没有数据
		if (inteconn_search == null) {
			Inteconn inteconn = new Inteconn();
			inteconn.setCount(count);
			inteconn.setUpdate_time(new Date());
			inteconn.setUserid(userid);
			inteconn.setGrand(1);
			inteconnMapper.insertSelective(inteconn);
		} else {
			inteconn_search.setUpdate_time(new Date());
			inteconn_search.setCount(inteconn_search.getCount() + count);
			inteconnMapper.updateByPrimaryKeySelective(inteconn_search);
		}
	}
}
