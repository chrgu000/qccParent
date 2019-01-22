package cn.com.qcc.tenement.mqmess;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.service.solrdao.BuilSolrDao;

/**
 * 收到楼栋编辑发布的消息
 * **/
public class BuilUpdateMess implements MessageListener {
	
	@Autowired
	BuilSolrDao builSolrDao;
	@Autowired
	VillageCustomerMapper villageCustomerMapper;
	@Autowired
	JedisClient jedisClient;

	@Override
	public void onMessage(Message message) {
					
		try {
			TextMessage textMessage = (TextMessage)message;
			String text = (String) textMessage.getText();
			Long buildingid = Long.valueOf(text);
			BuildingCustomer buildingCustomer  = villageCustomerMapper.oneBuildToSolr(buildingid);
			builSolrDao.oneBuildToSolr(buildingCustomer);
			System.out.println("收到楼栋编辑发布的消息" + buildingid);
			// 清空楼栋缓存
			jedisClient.del(RedisUtil.BUIL_FIRST_KEY + buildingid);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}


}
