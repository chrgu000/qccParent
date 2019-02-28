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
			// 休眠 20 秒钟等待图片上传防止上传 一半 时候删除图片导致报错
			Thread.sleep(1000 * 20);
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
			e.printStackTrace();
		}
		
	}

}
