package cn.com.qcc.managerclient.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.House;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.solrdao.HouseSolrDao;


/**
 * 退房收到的模板消息
 * 
 * **/
public class RoomOutMess  implements MessageListener{

	@Autowired
	HouseMapper houseMapper;
	@Autowired
	JedisClient jedisClient;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	HouseSolrDao houseSolrDao;
	
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String  data =   (String)textMessage.getText() ;
			Long houseid =   Long.valueOf(data.split("-")[0]  );
			String usercentnum = data.split("-")[1]  ;
			System.out.println("============= 退房收到 模板消息 ============" + data);
			
			// 1,把房子设置 为 可以租的状态
			House update = new House();
			update.setHouseid(houseid);
			update.setHousestatus("1");
			houseMapper.updateByPrimaryKeySelective(update);
			
			// 2,清空数据库缓存
			jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY + houseid, 0);
			
			
			// 3,这里还需要同步索引库
			HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(houseid);
			if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
				houseSolrDao.AddOneHouseToSolr(houseCustomer);
			}
			
			// 4- 发送短信消息
			
			
		} catch (Exception e) {
		}
		
	}

}
