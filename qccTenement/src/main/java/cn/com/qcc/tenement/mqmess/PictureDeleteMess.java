package cn.com.qcc.tenement.mqmess;

import java.io.File;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class PictureDeleteMess implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		try {
			
			Thread.sleep(4000);
			String  filePath =   (String)textMessage.getText() ;
			System.out.println("==========删除本地图片收到消息======：" + filePath );
			String[] splitPath = filePath.split("-");
			for (int i=0;i<splitPath.length;i++) {
				File file = new File(splitPath[i]);
				if (file.exists()) {
					file.delete();
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
