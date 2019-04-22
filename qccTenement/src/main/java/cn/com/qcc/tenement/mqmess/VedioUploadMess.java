package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.SimpleUpload;


public class VedioUploadMess implements MessageListener  {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String fileName =  (String)textMessage.getText() ;
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(5000 );
			String filePath = PayCommonConfig.LOCAL_UPLOAD_PATH + fileName;
			SimpleUpload.viedupload(filePath, fileName);
		} catch (Exception e) {
			// 这里是发生未知异常
			System.out.println(" 视频 上传异常 ==================");
			e.printStackTrace();
		}
		
	}

}
