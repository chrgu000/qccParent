package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.service.BrowseService;

/**
 * 求租被查询时候 需要做两件事件。
 * 一,同步缓存中的浏览量
 * 二,同步browse表数据
 * 
 * **/
public class QiuzuSearchMess implements MessageListener {
	
	@Autowired BrowseService browseService;
	@Autowired QiuZuCustomerMapper qiuZuCustomerMapper;
	@Autowired JedisClient jedisClient;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String messStr = (String)textMessage.getText();
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(1000);
			System.out.println("求租查询收到消息：" + messStr);
			//获取求租id
			Long qiuzuid = Long.valueOf(messStr.split("-")[0] ) ;
			Long userid = Long.valueOf(messStr.split("-")[1]) ;
			Integer type = Integer.parseInt(messStr.split("-")[2]) ;
			// 这里是同步浏览量数据库
			browseService.addBrowse(qiuzuid,userid, type);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

}
