package cn.com.qcc.tenement.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.AccountMgr;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.detailcommon.TemplateData;
import cn.com.qcc.detailcommon.WX_TemplateMsgUtil;
import cn.com.qcc.detailcommon.WX_UserUtil;
import cn.com.qcc.service.solrdao.HouseSolrDao;

@Controller
public class TestToken {

	@Autowired
	HouseSolrDao houseSolrDao;
	@Autowired
	JedisClient jedisClient;
	@RequestMapping("/tts")
	@ResponseBody
	public ResultMap testtoke(String openid) throws SolrServerException {

		//senMsg( openid);
		houseSolrDao.queryAll();
		return ResultMap.IS_200();
	}

	static void senMsg(String openId) {
		// 用户是否订阅该公众号标识 (0代表此用户没有关注该公众号 1表示关注了该公众号)
		Integer state = WX_UserUtil.subscribeState(openId);
		if (state == 1) {
			// 绑定了微信并且关注了服务号的用户 , 注册成功-推送注册短信
			Map<String, TemplateData> param = new HashMap<>();
			param.put("first", new TemplateData("尊敬的用户你预定的房号1074房东已经确认,请合理的安排入住时间。", "#696969"));
			param.put("keyword1", new TemplateData("1074A", "#696969"));
			param.put("keyword2", new TemplateData("2017年05月06日", "#696969"));
			param.put("remark", new TemplateData("祝投生活愉快！", "#696969"));
			// 注册的微信-模板Id
			//openId = "o3AMB0c5QVaqTKVp6XOHMC9BYcUE";
			String regTempId = "q3P5tKU7dmHGQWMqerQXpwlDreyZ2ceftcxovZJd6rI";
			// 调用发送微信消息给用户的接口
			WX_TemplateMsgUtil.sendWechatMsgToUser(openId, regTempId, "", "#000000", packJsonmsg(param));
			
		}
		
		
	}

	/**
	 * 封装模板详细信息
	 * 
	 * @return
	 */
	public static JSONObject packJsonmsg(Map<String, TemplateData> param) {
		JSONObject json = new JSONObject();
		for (Map.Entry<String, TemplateData> entry : param.entrySet()) {
			JSONObject keyJson = new JSONObject();
			TemplateData dta = entry.getValue();
			keyJson.put("value", dta.getValue());
			keyJson.put("color", dta.getColor());
			json.put(entry.getKey(), keyJson);
		}
		return json;
	}

	/**
	public static void main(String[] args) {

		try {
			
			//1、创建一个连接工厂对象，需要指定服务的ip及端口。
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://120.24.43.56:8020");
			//2、使用工厂对象创建一个Connection对象。
			Connection connection = connectionFactory.createConnection();
			//3、开启连接，调用Connection对象的start方法。
			connection.start();
			//4、创建一个Session对象。
			//第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
			//第二个参数：应答模式。自动应答或者手动应答。一般自动应答。
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue
			Queue queue = session.createQueue("test-queue");
			//6、使用Session对象创建一个Producer对象。
			MessageProducer producer = session.createProducer(queue);
			//7、创建一个Message对象，可以使用TextMessage。
			/*TextMessage textMessage = new ActiveMQTextMessage();
			textMessage.setText("hello Activemq");
			TextMessage textMessage = session.createTextMessage("hello activemq");
			//8、发送消息
			producer.send(textMessage);
			//9、关闭资源
			producer.close();
			session.close();
			connection.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		**/
	
	
	

	
	

	
	
			
	

}
