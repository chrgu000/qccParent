package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.service.solrdao.QiuzuSolrDao;

/**
 * 求租被查询时候 需要做两件事件。
 * 一,同步缓存中的浏览量
 * 二,同步browse表数据
 * 
 * **/
public class QiuZuStateChangeMess implements MessageListener {
	
	@Autowired QiuZuCustomerMapper qiuZuCustomerMapper;
	@Autowired JedisClient jedisClient;
	@Autowired QiuzuSolrDao qiuzuSolrDao;
	
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String messStr = (String)textMessage.getText();
			System.out.println("改变求租状态收到消息：" +messStr);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			//获取求租id
			Long qiuzuid = Long.valueOf(messStr.split("-")[0] ) ;
			String qiuzuState = messStr.split("-")[1] ;
			QiuzuCustomer qiuzuCustomer = qiuZuCustomerMapper.qiuzuDetail(qiuzuid);
			if (CheckDataUtil.checkNotEmpty(qiuzuCustomer)) {
				// 这里不等于0 不是移除
				if (CheckDataUtil.checkNotEqual(qiuzuState, 0)) {
					//更新最新的状态
					qiuzuSolrDao.oneQiuzuToSolr(qiuzuCustomer);
				} else {
					//这里是移除
					qiuzuSolrDao.deleteQiuzuFromSolr(qiuzuid);
					
				}
			}
			
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

}
