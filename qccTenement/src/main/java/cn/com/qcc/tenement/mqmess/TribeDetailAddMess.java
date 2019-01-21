package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mapper.TribeMapper;
import cn.com.qcc.mymapper.TribeCustomerMapper;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.service.solrdao.TribeSolrDao;


/**新增楼栋时候接受的模板消息
 * 1, 这里主要做一件事情。同步索引库
 * 2, 生成小程序二维码
 * **/
public class TribeDetailAddMess implements MessageListener{
	
	@Autowired
	private TribeSolrDao tribeSolrDao;
	@Autowired
    private TribeCustomerMapper tribeCustomerMapper;
	@Autowired
	private TribeMapper tribeMapper;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			Long articledetailid = Long.valueOf(  (String)textMessage.getText() );
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			//导入索引库
			System.out.println("部落发布物品搜到消息:" + articledetailid);
			ArticleDetailCustomer articelDeail = tribeCustomerMapper.oneArticleDetailToSolr(articledetailid);
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
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	
	

}
