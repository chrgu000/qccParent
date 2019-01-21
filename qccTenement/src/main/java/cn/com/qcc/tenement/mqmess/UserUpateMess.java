package cn.com.qcc.tenement.mqmess;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.queryvo.UserCustomer;


public class UserUpateMess implements MessageListener {
	
	@Autowired
	UserCustomerMapper userCustomerMapper;
	
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			Long userid = Long.valueOf(  (String)textMessage.getText() );
			System.out.println("编辑用户信息收到的消息：" + userid);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			String birth = "";
			UserCustomer userCustomer = userCustomerMapper.getUserAndProfileByUserid(userid);
			if (CheckDataUtil.checkNotEmpty(userCustomer.getBirthday())) {
				birth = DateUtil.DateToStr("yyyy-MM-dd", userCustomer.getBirthday());
			}
			String gender = "0";
			if (CheckDataUtil.checkNotEmpty(userCustomer.getSex())) {
				if ( "男".equals(userCustomer.getSex())  )
					gender = "1";
				if ( "女".equals(userCustomer.getSex())  )
					gender = "2";
				
			}
			WangYiUtil.updateUser(userid, userCustomer.getUser_name(), userCustomer.getAvatar(), 
					userCustomer.getMysign(), userCustomer.getTelephone().toString(), 
					userCustomer.getMail(), birth, gender);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

}
