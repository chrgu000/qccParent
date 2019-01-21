package cn.com.qcc.tenement.mqmess;


import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.solrdao.HouseSolrDao;



/**当二手房新增或者编辑时候
 * 1，同步索引库
 * **/
public class UpdateHouseStatusMess implements MessageListener{
	
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			System.out.println("编辑房源状态收到的消息：" + text);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			Long houseid = Long.valueOf(text.split("-")[0]);
			//String state =text.split("-")[1];
			//if (CheckDataUtil.checkNotEqual(state, 3)) 
				{
					// 同步索引库
					HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(houseid);
					if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
						houseSolrDao.AddOneHouseToSolr(houseCustomer);
					}
				
			//	} else {
			//		System.out.println("走删除方法");
			//		//删除索引库
			//		houseSolrDao.deletehousebyhouseid(houseid);
				}
			
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
