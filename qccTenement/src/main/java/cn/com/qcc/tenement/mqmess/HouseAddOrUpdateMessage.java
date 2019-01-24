package cn.com.qcc.tenement.mqmess;
import java.util.List;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.solrdao.BuilSolrDao;
import cn.com.qcc.service.solrdao.HouseSolrDao;



/**当房源新增或者编辑时候
 * 1,处理金币
 * 2,同步索引库
 * 3,新增不需要同步缓存编辑需要同步缓存
 * 4,同步楼栋索引库
 * **/
public class HouseAddOrUpdateMessage implements MessageListener{
	
	@Autowired
	private InteService inteService;
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;
	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private VillageCustomerMapper villageCustomerMapper;
	@Autowired
	private BuilSolrDao builSolrDao;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			System.out.println("编辑房源收收到消息：" + text);
			Long houseid = Long.valueOf(text.split("-")[0]);
			String typestate = text.split("-")[1];
			String tribeid = text.split("-")[2];
			Long userid = Long.valueOf(text.split("-")[3]);
			//如果是新增需要处理金币问题
			if (CheckDataUtil.checkisEqual(typestate, "insert")) {
				// 这里做积分加处理
				inteService.managebranch(11L, userid, houseid);
			} else {
				// 清空缓存数据 编辑时候
				jedisClient.del(RedisUtil.HOUSE_FIRST_KEY+ houseid);
			}
			
			
			//如果有部落id不管是更新或者是编辑都需要同步部落
			if (CheckDataUtil.checkNotEmpty(tribeid)) {
				//tribeService.addarticle(Long.valueOf(tribeid), houseid, 1, houseid);
			}
			
			// 同步房源索引库
			Long buildingid = null;
			HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(houseid);
			if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
				buildingid = houseCustomer.getBuildingid();
				houseSolrDao.AddOneHouseToSolr(houseCustomer);
			}
			
			
			//同步楼栋索引库
			if (CheckDataUtil.checkNotEmpty(buildingid)) {
				List<BuildingCustomer> buils = villageCustomerMapper.addbuildngtosolr(buildingid, null);
				builSolrDao.AllBuildingToSolr(buils);
			}
			
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
