package cn.com.qcc.tenement.mqmess;

import java.util.List;

import javax.jms.JMSException;
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

/**
 * 根据楼栋id编辑房源信息
 * **/
public class UpdateHouseByBuildingIdMess implements MessageListener{
	
	@Autowired
	HouseCustomerMapper HouseCustomerMapper;
	@Autowired
	HouseSolrDao houseSolrDao;
	@Autowired
	JedisClient jedisClient;

	@Override
	public void onMessage(Message message) {
		
		try {
			TextMessage textMessage = (TextMessage)message;
			String text =  (String) textMessage.getText();
			Long buildingid = Long.valueOf(text);
			System.out.println("根据楼栋id编辑房源信息" + buildingid);
			List<HouseCustomer> houseList = HouseCustomerMapper.searchHouseToSolrByBuildingid(buildingid);
			if (CheckDataUtil.checkNotEmpty(houseList)) {
				for (HouseCustomer houseCustomer : houseList) {
					houseSolrDao.AddOneHouseToSolr(houseCustomer);
					//清空缓存
					jedisClient.del(RedisUtil.HOUSE_FIRST_KEY + houseCustomer.getHouseid());
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		
	}

}
