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
		
		//休眠一秒钟等待图片上传完成
		
		
		try {
			Thread.sleep(1000);
			String  filePath =   (String)textMessage.getText() ;
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
