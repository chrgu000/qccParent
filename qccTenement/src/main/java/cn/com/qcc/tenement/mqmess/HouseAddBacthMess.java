package cn.com.qcc.tenement.mqmess;
import java.util.List;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.solrdao.BuilSolrDao;
import cn.com.qcc.service.solrdao.HouseSolrDao;


/**当房源信息批量新增时候
 * 1 ， 加金币
 * 2，同步房源索引库 
 * 3，还需要同步楼栋的索引库
 * 4 , 生成小程序二维码
 * **/
public class HouseAddBacthMess implements MessageListener{
	
	@Autowired
	private InteService inteService;
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;
	@Autowired
	private VillageCustomerMapper villageCustomerMapper;
	@Autowired
	private BuilSolrDao builSolrDao;
	
	public void onMessage(Message message) {
		try {
			// houseid-houseid-houseid,userid,tribeid
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			String houseids = text.split(",")[0];
			Long userid = Long.valueOf( text.split(",")[1]);
			String tribeid = text.split(",")[2];
			System.out.println("批量发布房源收到消息：" + text);
			// 这里做积分加处理
			inteService.managebranch(11L, userid, Long.valueOf( houseids.split("-")[0]) );
			Long buildingid = null;
			String [] houseid = houseids.split("-");
			for (int i =0;i<houseid.length;i++) {
				if (CheckDataUtil.checkNotEmpty(tribeid)) {
					//tribeService.addarticle(Long.valueOf(tribeid), Long.valueOf(houseid[i]), 1, Long.valueOf(houseid[i]));
				}
				// 同步索引库
				HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(Long.valueOf(houseid[i]));
				if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
					buildingid = houseCustomer.getBuildingid();
					houseSolrDao.AddOneHouseToSolr(houseCustomer);
				}
				
			}
			
		    //  同步楼栋索引库
			if (CheckDataUtil.checkNotEmpty(buildingid)) {
				List<BuildingCustomer> buildingCustomers = villageCustomerMapper.addbuildngtosolr(buildingid, null);
				builSolrDao.AllBuildingToSolr(buildingCustomers);
			}
			
			
			
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
