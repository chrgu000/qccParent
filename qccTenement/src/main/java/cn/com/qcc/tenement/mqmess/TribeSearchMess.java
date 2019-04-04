package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.service.BrowseService;


/**新增楼栋时候接受的模板消息
 * 1, 这里主要做一件事情。同步索引库
 * 2, 生成小程序二维码
 * **/
public class TribeSearchMess implements MessageListener{
	
	@Autowired
	private BrowseService browseService;
	public void onMessage(Message message) {
		try {//  tribeid +"-" + userid+"-" + type;
			TextMessage textMessage = (TextMessage)message;
			String text =  (String)textMessage.getText() ;
			String tribeid = text.split("-")[0]  ;
			Long userid = Long.valueOf(text.split("-")[1] ) ;
			Integer type =9 ;
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			System.out.println("部落查询收到消息："+text);
			//先处理浏览
			browseService.addBrowse(Long.valueOf(tribeid), userid, type);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
