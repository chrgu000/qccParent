package cn.com.qcc.tenement.mqmess;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.solrdao.HouseSolrDao;


/**当进入房源详情页面时候需要做的操作
 * 1,缓存是否需要同步 ---> 重置缓存
 * 2,索引库需要同步
 * 3,插入浏览表数据
 * 编辑房源状态收到的消息：3065-3
 * **/
public class HouseSearchMessage implements MessageListener{
	
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private JedisClient jedisClient; 
	@Autowired
	private HouseSolrDao houseSolrDao;
	@Autowired
	private BrowseService browseService;
	
	public void onMessage(Message message) {
		try {
			// houseid +"-"+userid + "-" +type ;
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			// 由于
			Thread.sleep(500);
			System.out.println("查询房源收到消息：" + text);
			Long houseid =  Long.valueOf(text.split("-")[0] );
			Long userid =  Long.valueOf(text.split("-")[1] );
			Integer type = Integer.parseInt(text.split("-")[2]  ) ; 
			
			// 插入浏览量 第一步一定要插入浏览量。不然后面的数据不能同步
			browseService.addBrowse(houseid,userid, type);
			
			// 同步缓存....
			HouseCustomer cache = houseCustomerMapper.findHouseDetails(houseid);
			try {
				jedisClient.set(RedisUtil.HOUSE_FIRST_KEY+houseid, JsonUtils.objectToJson(cache));
				jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY+houseid, RedisUtil.HOUSE_OUT_TIME);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//同步索引
			HouseCustomer houseList = houseCustomerMapper.searchoneHouseToSolr(houseid);
			houseSolrDao.AddOneHouseToSolr(houseList);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
