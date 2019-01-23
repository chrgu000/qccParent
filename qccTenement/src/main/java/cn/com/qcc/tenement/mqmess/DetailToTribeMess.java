package cn.com.qcc.tenement.mqmess;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mapper.TribeMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.TribeCustomerMapper;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.solrdao.HouseSolrDao;
import cn.com.qcc.service.solrdao.TribeSolrDao;


/**新增楼栋时候接受的模板消息
 * 1, 这里主要做一件事情。同步索引库
 * 2, 生成小程序二维码
 * **/
public class DetailToTribeMess implements MessageListener{
	
	@Autowired
	private HouseCustomerMapper houseCustomerMapper;
	@Autowired
	private HouseSolrDao houseSolrDao;
	@Autowired
	private TribeMapper tribeMapper;
	@Autowired
	private TribeCustomerMapper tribeCustomerMapper;
	@Autowired
	private TribeSolrDao tribeSolrDao;
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String text =   (String)textMessage.getText() ;
			System.out.println("挂到鱼塘收到消息：" + text);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			Long detailid = Long.valueOf(  text.split("-")[0]  );
			Integer type = Integer.parseInt(  text.split("-")[1] ) ; 
			
			// 同步索引库  
			// 这里需要同步房源的所有
			if (CheckDataUtil.checkisEqual(type, 1)) 
				{
				 	HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(detailid);
					if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
						// 查询部落的id
						String tribes = houseCustomer.getTribeids();
						if (CheckDataUtil.checkNotEmpty(tribes)) 
							{ 
								Long tribeid = Long.valueOf( tribes.split(",")[0]  ) ;
								Tribe tribe = tribeMapper.selectByPrimaryKey(tribeid);
								houseCustomer.setTribename(tribe.getName());
								houseCustomer.setTribepicture(tribe.getPicture());
							
							}
						houseSolrDao.AddOneHouseToSolr(houseCustomer);
					}
				}
			
			// 这里是同步detail表数据
			if (CheckDataUtil.checkisEqual(type, 6)
					|| CheckDataUtil.checkisEqual(type, 7)
					|| CheckDataUtil.checkisEqual(type, 8)) {
				ArticleDetailCustomer articelDeail = tribeCustomerMapper.oneArticleDetailToSolr(detailid);
				// 查询部落的id
				String tribes = articelDeail.getTribeids();
				if (CheckDataUtil.checkNotEmpty(tribes)) 
					{ 
						Long tribeid = Long.valueOf( tribes.split(",")[0]  ) ;
						Tribe tribe = tribeMapper.selectByPrimaryKey(tribeid);
						articelDeail.setTribename(tribe.getName());
						articelDeail.setTribepicture(tribe.getPicture());
					
					}
				tribeSolrDao.oneArticleDetailToSolr(articelDeail);
			}
			// 这里需要同步索引库
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
