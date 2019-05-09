package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.LucreMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.solrdao.HouseSolrDao;

public class HouseTuiKuanMess implements MessageListener{
	
	@Autowired
	private HouseorderMapper houseorderMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private LucreMapper lucreMapper;

	@Override
	public void onMessage(Message message) {
		try {
			// houseid +"-"+userid + "-" +type ;
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			// 由于
			Thread.sleep(500);
			System.out.println("房源退款收到模板消息：" + text);
			// 接收到订单的 id
			Long houseorderid =  Long.valueOf(text );
			
			Houseorder search = houseorderMapper.selectByPrimaryKey(Long.valueOf(houseorderid));
			
			// 1,同步索引库
			HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(search.getHouseid());
			if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
				houseSolrDao.AddOneHouseToSolr(houseCustomer);
			}
			// 3,发送模板消息
			Lucre update = new Lucre();
			update.setLucreid(houseorderid);
			String descName = update.getDescname().replace("临时预估", "订单退款");
			update.setDescname(descName);
			update.setState(2); //非正常
			lucreMapper.updateByPrimaryKeySelective(update);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
		
	}

}
