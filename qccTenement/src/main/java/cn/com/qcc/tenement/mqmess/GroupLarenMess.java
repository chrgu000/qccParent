package cn.com.qcc.tenement.mqmess;

import java.util.Date;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mapper.RongconnMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Rongconn;
import cn.com.qcc.pojo.Userconn;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.UserService;

public class GroupLarenMess implements MessageListener{

	@Autowired
	RongconnMapper rongconnMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	UserService userService;
	
	@Override
	public void onMessage(Message message) {
		
		try {
			TextMessage textMessage = (TextMessage)message;
			String text =   (String)textMessage.getText() ;
			Long userid = Long.valueOf( text.split("-")[0]) ;
			Long groupid = Long.valueOf( text.split("-")[1]) ;
			String otherids = text.split("-")[2] ;
			String [] otherid = otherids.split(",");
			Userconn userconn = new Userconn();
			userconn.setUserid(userid);
			userconn.setState(3);
			Userconn befriend = new Userconn();
			befriend.setUserid(userid);
			befriend.setState(0);
			List<UserCustomer> myfriends = userCustomerMapper.myfriend(userconn);
			// 遍历
			for (int i=0;i<otherid.length;i++) {
				Rongconn follow = new Rongconn();
				follow.setState(1);
				follow.setUserid(Long.valueOf( otherid[i]  ) );
				follow.setUpdate_time(new Date());
				follow.setGroupid(groupid);
				rongconnMapper.insertSelective(follow);
				follow.setConnid(null);
				
				if (CheckDataUtil.checkNotEmpty(myfriends)) {
					for (UserCustomer user : myfriends) {
						// 判断我的好友里面是否有当前用户
						if (!otherid[i].equals(user.getFollowUserId().toString())) {
							// 建立好友关系
							befriend.setFollowuserid(Long.valueOf(otherid[i]) );
							userService.befriend(userconn);
						}
					}
				}else {
					//就是为空直接调用添加好友的方法
					// 建立好友关系
					befriend.setFollowuserid(Long.valueOf(otherid[i]) );
					userService.befriend(userconn);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
