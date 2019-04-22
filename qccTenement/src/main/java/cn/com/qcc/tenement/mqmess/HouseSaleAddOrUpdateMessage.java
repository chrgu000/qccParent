package cn.com.qcc.tenement.mqmess;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.solrdao.HouseSolrDao;



/**当二手房新增或者编辑时候
 * 1，同步索引库
 * **/
public class HouseSaleAddOrUpdateMessage implements MessageListener{
	
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;
	@Autowired
	private JedisClient jedisClient;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			System.out.println("新增房源或者编辑房源：" + text);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			Long houseid = Long.valueOf(text);
			// 同步索引库
			HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(houseid);
			if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
				if (CheckDataUtil.checkisEqual(houseCustomer.getHousestatus(), 3)) {
					houseSolrDao.oneHouseDeleteFromSolr(houseCustomer);
				}else {
					houseSolrDao.AddOneHouseToSolr(houseCustomer);
					jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY+ houseid, 0);
				}
				
			}
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
