package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.service.VillageService;

public class VillageAddMess implements MessageListener{
	
	@Autowired
	private VillageService villageService;

	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			Long villageid = Long.valueOf(  (String)textMessage.getText() );
			System.out.println("发布小区收到消息：" + villageid);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			// 2同步索引库
			villageService.onevillagetosolr(villageid);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

}
