package cn.com.qcc.tenement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Messages;
import cn.com.qcc.pojo.Messagesreply;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MessReply;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.MessagesService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class MessageController {

	@Autowired
	MessagesService messagesService;

	/**
	 * 添加留言
	 */
	@RequestMapping(value = "/messages/addMessages/{type}")
	@ResponseBody
	public ResultMap addMessages(Long userid, Messages messages, @PathVariable Integer type) {
		if (CheckDataUtil.checkNotEmpty(userid)) {
			messages.setUser_id(userid);
		}
		if (CheckDataUtil.checkisEmpty(messages.getUser_id())) {return ResultMap.build(400,"请先登录");}
		messages.setType(type);
		messagesService.addMessages(messages);
		return ResultMap.IS_200();
	}

	/**
	 * 用户之间回复
	 */
	@RequestMapping(value = "/messages/reply")
	@ResponseBody
	public ResultMap messagereply(Messagesreply messagesreply) {
		// 根据留言ID查询用户
		ResultMap resultMap = messagesService.messagereply(messagesreply);
		return resultMap;
	}

	/**
	 * 房屋详情显示留言列表
	 */
	@RequestMapping(value = "/messages/findMessagesByHouse/{type}")
	@ResponseBody
	public ResultMap findMessagesByHouse(Long house_id, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "5") int pagesize, @PathVariable Integer type) {

		PageQuery pagequery = new PageQuery();
		HouseVo houseVo = new HouseVo();
		if (house_id == null) {return ResultMap.build(400, "选择一个类目");}
		int infocount = messagesService.findMessagesByHouseCount(house_id, type);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		houseVo.setHouse_id(Integer.parseInt("" + house_id));
		houseVo.setMessagesType(type);
		List<UserCustomer> list = messagesService.findMessagesByHouse(houseVo);
		List<Integer> mess = new ArrayList<>();
		if (!list.isEmpty() && list.size() > 0) {
			for (UserCustomer reply : list) {
				Integer messid = reply.getMessagesid();
				mess.add(messid);
				if (!mess.isEmpty() && mess.size() > 0) {
					for (Integer intt : mess) {
						// 获取回复的集合
						List<MessReply> reply_mess = messagesService.getreply(intt);
						if (!reply_mess.isEmpty() && reply_mess.size() > 0) {
							reply.setMessagereply(reply_mess);
						} else {
							List<MessReply> re_null = new ArrayList<>();
							reply.setMessagereply(re_null);
						}
					}

				}
			}
		}
		Map map = new HashMap();
		map.put("list", list);
		map.put("pageModel", pagequery);
		return ResultMap.IS_200(map);
	}

	// 删除二级留言
	@RequestMapping("/messages/deletemess")
	@ResponseBody
	public ResultMap deletemess(Long messagesreplyid) {
		messagesService.deletemess(messagesreplyid);
		return ResultMap.IS_200();
	}

	// 删除一级留言
	@RequestMapping("/messages/deletemessall")
	@ResponseBody
	public ResultMap deletemessall(Long messagesid) {
		//通过一级留言查出二级留言ID
		List<Messagesreply> reply = messagesService.getmessreply(messagesid);
		if (!reply.isEmpty() && reply.size() >0) {
			for (Messagesreply mess : reply) {
				//删除二级留言
				if (mess.getMessagesreplyid() !=null) {
					this.deletemess(mess.getMessagesreplyid());
				}
			}
		}
		//删除一级留言
		messagesService.deletemessall(messagesid);
		return ResultMap.IS_200();
	}

}
