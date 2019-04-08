package cn.com.qcc.tenement.mqmess;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.service.solrdao.BuilSolrDao;


/**新增楼栋时候接受的模板消息
 * 1, 这里主要做一件事情。同步索引库
 * 2, 生成小程序二维码
 * **/
public class BuilAddMess implements MessageListener{
	
	@Autowired
	private VillageCustomerMapper villageCustomerMapper;
	@Autowired
	private BuilSolrDao builSolrDao;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			Long buildingid = Long.valueOf(  (String)textMessage.getText() );
			System.out.println("发布楼栋收到消息：" + buildingid);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			// 2同步索引库
			BuildingCustomer buil =  villageCustomerMapper.oneBuildToSolr(buildingid);
			builSolrDao.oneBuildToSolr(buil);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
