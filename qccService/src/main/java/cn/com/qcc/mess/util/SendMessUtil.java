package cn.com.qcc.mess.util;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SendMessUtil {

	public static void sendData(JmsTemplate jmsTemplate, Destination destination, String sendData) {
		// 如果发送消息失败不能影响正常业务逻辑这里需要捕捉异常
		try {
			// 发送消息
			jmsTemplate.send( destination,new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(sendData);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
