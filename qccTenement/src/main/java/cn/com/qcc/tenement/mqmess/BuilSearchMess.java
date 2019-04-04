package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.service.BrowseService;




/**新增楼栋时候接受的模板消息
 * 这里主要做一件事情。同步索引库
 * **/
public class BuilSearchMess implements MessageListener{
	
	@Autowired
	private BrowseService browseService;
	public void onMessage(Message message) {
		try {
			// 47094-10001765-5 || 其实这里的type 可以写死的。每一种类型都是固定的
			TextMessage textMessage = (TextMessage)message;
			String text =  (String)textMessage.getText() ;
			System.out.println("查询楼栋收到消息：" + text);
			Long buildingid = Long.valueOf(text.split("-")[0] ) ;
			Long userid = Long.valueOf(text.split("-")[0] ) ;
			Integer type = 5;
			
			//处理浏览量
			browseService.addBrowse(buildingid, userid, type);
			
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
