package cn.com.qcc.tenement.mqmess;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mymapper.AddressCustomerMapper;
import cn.com.qcc.mymapper.BrokerCustomerMapper;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.solrdao.QiuzuSolrDao;


/**当求租新增或者编辑时候**/
public class qiuzuAddOrUpdateMessage implements MessageListener{
	
	@Autowired  QiuZuCustomerMapper qiuZuCustomerMapper;
	@Autowired  QiuzuSolrDao qiuzuSolrDao;
	@Autowired  JedisClient jedisClient;
	@Autowired  InteService inteService;
	@Autowired  AddressCustomerMapper addressCustomerMapper;
	@Autowired  BrokerCustomerMapper brokerCustomerMapper ; 
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			System.out.println("求租编辑或者发布收到消息：" + text);
			long qiuzuId = Long.valueOf(text.split("-")[0]);
			String userid = text.split("-")[1];
			//如果用户id校验通过则加金币操作
			if(CheckDataUtil.checkNotEmpty(userid)){
				inteService.managebranch(12L, Long.valueOf(userid) ,qiuzuId);
			}
			QiuzuCustomer qiuzuCustomer = qiuZuCustomerMapper.qiuzuDetail(qiuzuId);
			if (qiuzuCustomer !=null) {
				// 同步索引库
				qiuzuSolrDao.oneQiuzuToSolr(qiuzuCustomer);
				//推送网易云信消息
				SendWangYunXin(qiuzuCustomer);
				// 同步缓存
				SendRedisMess(qiuzuCustomer);
			}
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
	}

	private void SendRedisMess(QiuzuCustomer qiuzuCustomer) {
		try {
			jedisClient.set(RedisUtil.QIUZU_FIRST_KEY+qiuzuCustomer.getQiuzuid(), 
					JsonUtils.objectToJson(qiuzuCustomer));
			jedisClient.expire(RedisUtil.QIUZU_FIRST_KEY+qiuzuCustomer.getQiuzuid(), RedisUtil.QIUZU_OUT_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void SendWangYunXin(QiuzuCustomer qiuzuCustomer) {
		String body = "";//拼接传输的字符串
		String msg  = ""; //顶部推送 ()
		String distinct = "";
		if (qiuzuCustomer.getDistrict() != null && !"".equals(qiuzuCustomer.getDistrict())){
			msg = qiuzuCustomer.getDistrict() + "最新发布";
			distinct = qiuzuCustomer.getDistrict();
		}body = body + msg ;
		
		String title = ""; //求租标题
		if (qiuzuCustomer.getCaption() !=null &&!"".equals(qiuzuCustomer.getCaption())) {
			title = qiuzuCustomer.getCaption().replace("❤", "");
		}body = body + "❤" +title;
		
		String housetype = ""; //出租方式
		if (qiuzuCustomer.getHousetype() !=null &&!"".equals(qiuzuCustomer.getHousetype())) {
			housetype = qiuzuCustomer.getHousetype().replace("❤", "");
		}body  = body + "❤" + housetype;
		String classfin = "";
		if (qiuzuCustomer.getClassification() !=null && !"".equals(qiuzuCustomer.getClassification())) {
			classfin = qiuzuCustomer.getClassification();
		}body = body + "❤" + classfin;
		String user_name = "";//发布人昵称
		if (qiuzuCustomer.getUser_name() !=null &&!"".equals(qiuzuCustomer.getUser_name())) {
			user_name = qiuzuCustomer.getUser_name().replace("❤", "");
		}body = body + "❤" + user_name;
		//发布日期
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String date = format.format(qiuzuCustomer.getCreate_time());
		body = body + "❤" + date;
		String finalstop = "";//站点
		if (qiuzuCustomer.getFinalstop() !=null &&!"".equals(qiuzuCustomer.getFinalstop())) {
			finalstop = qiuzuCustomer.getFinalstop();
		}body = body + "❤" + finalstop;
		String metroname = "";//地铁
		if (qiuzuCustomer.getMetroname() !=null &&!"".equals(qiuzuCustomer.getMetroname())) {
			metroname = qiuzuCustomer.getMetroname();
		}body = body + "❤" + metroname;
		String trading = "";//街道
		if (qiuzuCustomer.getTrading() !=null &&!"".equals(qiuzuCustomer.getTrading())) {
			trading = qiuzuCustomer.getTrading();
		}body = body + "❤" +trading;
		//拼接区域
		body = body +"❤" +distinct;
		String picture = "";//求租图片
		if (qiuzuCustomer.getPicture() !=null &&!"".equals(qiuzuCustomer.getPicture())) {
			picture = qiuzuCustomer.getPicture().split(",")[0];
		}body = body + "❤"+ picture;
		String avatar = "";//用户头像
		if (qiuzuCustomer.getAvatar() !=null &&!"".equals(qiuzuCustomer.getAvatar())) {
			avatar = qiuzuCustomer.getAvatar();
		}body = body +"❤"+avatar;
		//拼接ID
		body = body + "❤"+qiuzuCustomer.getQiuzuid();
		String details  = "";//详情地址
		if (qiuzuCustomer.getDetailes() !=null &&!"".equals(qiuzuCustomer.getDetailes())) {
			details = qiuzuCustomer.getDetailes().replace("❤", "");
		}body = body + "❤" + details;
		//拼接时间戳
		String time = new Date().getTime()+"";
		body = body + "❤" +time;
		
		String sendUserids = "";
		List<UserCustomer> broList = new ArrayList<>();
		// 根据街道的code查询区域的code
		if (CheckDataUtil.checkNotEmpty(qiuzuCustomer.getCode())) {
			String fathercode = addressCustomerMapper.getFatherCodeBycode(qiuzuCustomer.getCode());
			// 查询推送的经纪人 和房东
			broList= brokerCustomerMapper.searchlikebrokerbyCode(fathercode);
			
		}
		
		if (CheckDataUtil.checkNotEmpty(broList)) {
			for (UserCustomer  user:broList) {
				if (!sendUserids.contains(user.getUserid().toString())) {
					sendUserids +=user.getUserid() +",";
				}
			}
		}
		
		
		// 去掉最后一个逗号
		if (CheckDataUtil.checkNotEmpty(sendUserids)) {
			sendUserids = sendUserids.substring(0,sendUserids.length()-1);
			//如果查到了 数据
			if (! sendUserids.contains("10000003")) {
				sendUserids =sendUserids + ",10000003" ;
			}
			sendUserids = "[" + sendUserids + "]";
		} else {
			sendUserids = "[10001765,10000525,10000003]" ; 
		}
		
		System.out.println(sendUserids);
		String systemId = "10088";
		WangYiUtil.piliangqiuzu(body,sendUserids ,systemId);
	}
	
	

}
