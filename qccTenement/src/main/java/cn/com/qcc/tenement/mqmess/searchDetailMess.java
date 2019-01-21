package cn.com.qcc.tenement.mqmess;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.TribeCustomerMapper;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.service.BrowseService;



/**当二手房新增或者编辑时候
 * 1，同步索引库
 * **/
public class searchDetailMess implements MessageListener{
	
	@Autowired
	private BrowseService browseService;
	@Autowired
	private TribeCustomerMapper tribeCustomerMapper;
	@Autowired
	private JedisClient jedisClient;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			System.out.println("查询部落物品发布详情页面收到消息：" + text);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			Long articedetailid = Long.valueOf(text.split("-")[0]);
			Long userid = Long.valueOf(text.split("-")[1]);
			Integer type = Integer.parseInt(  text.split("-")[2]  );
			// 添加浏览量
			browseService.addBrowse(articedetailid, userid, type);
			
			// 同步缓存
			ArticleDetailCustomer articleDetailCustomer = tribeCustomerMapper.thingdetail(articedetailid);
			jedisClient.set(RedisUtil.ARTICLEDETAIL_FIRST_KEY+articedetailid, JsonUtils.objectToJson(articleDetailCustomer));
			jedisClient.expire(RedisUtil.ARTICLEDETAIL_FIRST_KEY+articedetailid , RedisUtil.ARTICLEDETAIL_OUT_TIME);
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
