package cn.com.qcc.tenement.mqmess;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.LandlordManagerMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.LandlordManager;
import cn.com.qcc.pojo.LandlordManagerExample;
import cn.com.qcc.pojo.User;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.SmallRoutineService;
import cn.com.qcc.service.solrdao.HouseSolrDao;
import weixin.util.TemplateData;
import weixin.util.WxMssVo;


/**
 * 房源消息预定成功
 * **/
public class HouseyudingSuccessMess  implements MessageListener{

	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	HouseorderMapper houseorderMapper;
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	SmallRoutineService smallRoutineService;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	HouseSolrDao houseSolrDao;
	@Autowired
	UserMapper userMapper;
	@Autowired
	LandlordManagerMapper landlordManagerMapper;
	
	@Override
	public void onMessage(Message message) {
		try {
			// "cz_" + houseorderid +"_" + openid + "_" + formid+"_"+type; 
			TextMessage textMessage = (TextMessage)message;
			String sendData = (String)textMessage.getText();
			String houseorderid = sendData.split("_")[1];
			String openid = sendData.split("_")[2];
			String formid = sendData.split("_")[3];
			String type = sendData.split("_")[4];
			System.out.println("=======房源预定成功收到模板消息========" + sendData);
			
			Houseorder search = houseorderMapper.selectByPrimaryKey(Long.valueOf(houseorderid));
			
			// 1, 修改房源为已经预定状态
			House updatehouse = new House();
			updatehouse.setHousestatus("6");
			updatehouse.setHouseid(search.getHouseid());
			houseMapper.updateByPrimaryKeySelective(updatehouse);
			
			// 2,发送短信
			// 发送短信给租客提醒预定成功
			HouseCustomer details = houseCustomerMapper.findHouseDetails(search.getHouseid());
			User user = userMapper.selectByPrimaryKey(search.getUserid());
			String userPhone = user.getTelephone() + "";
			if (CheckDataUtil.checkNotEqual(userPhone, search.getReservationstel())) {
				userPhone = userPhone + " 或 " + search.getReservationstel() ;
			}
			userPhone = userPhone + " (预定人称呼) "+ search.getReservations();
			String contentCommon = details.getVillagename() + "-" +
					details.getBuilding() + "-" +
					details.getHouse_number() +"(号房)";
			contentCommon  = contentCommon + "," + search.getPrices() + " 元"  + "," +search.getWeixinorder();
			
			String noticManager  = contentCommon +"," + userPhone;
			
			// 通过管理的id去查询房东 的userid
			Long landUserId = getLandUserId(details.getUserid());
			if (CheckDataUtil.checkNotEmpty(landUserId)) {
				User manager = userMapper.selectByPrimaryKey(Long.valueOf(  details.getUserid())  );
				// 通知管理员 或者房东有新的 预定
				String modelIdUser = PayCommonConfig.HOUSE_YUDING_SUCCESS_NOTIC_MANAGER;
				SendMessage.sendNoticMess(noticManager, manager.getTelephone().toString(), modelIdUser);
			}
			
			User manager = userMapper.selectByPrimaryKey(Long.valueOf(  details.getUserid())  );
			// 通知管理员 或者房东有新的 预定
			String modelIdUser = PayCommonConfig.HOUSE_YUDING_SUCCESS_NOTIC_MANAGER;
			SendMessage.sendNoticMess(noticManager, manager.getTelephone().toString(), modelIdUser);
			
			
			// 通知租户预定信息
			String noticUser = contentCommon + "," + manager.getTelephone() ;
			String noticUserID = PayCommonConfig.HOUSE_YUDING_SUCCESS_NOTIC_USER;
			SendMessage.sendNoticMess(noticUser,user.getTelephone().toString(), noticUserID);
			
			
			// 3,同步索引库
			HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(search.getHouseid());
			if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
				houseSolrDao.AddOneHouseToSolr(houseCustomer);
			}
			
			
			// 4 , 发送小程序模板消息
			String temid = PayCommonConfig.QCC_PAY_SUCCESS_TEMID ;
			WxMssVo wxMssVo = new WxMssVo();
			wxMssVo.setTouser(openid);// 用户openid
			wxMssVo.setTemplate_id(temid);// 模版id
			wxMssVo.setForm_id(formid);// formid
			// 添加数据集合
			Map<String, TemplateData> m = new HashMap<>();
			
			TemplateData keyword1 = new TemplateData();
			keyword1.setValue(search.getWeixinorder());
			m.put("keyword1", keyword1);

			TemplateData keyword2 = new TemplateData();
			keyword2.setValue(search.getPrices()+"");
			m.put("keyword2", keyword2);
			wxMssVo.setData(m);

			TemplateData keyword3 = new TemplateData();
			Date current = new Date();
			String date =DateUtil.DateToStr(DateUtil.yyyy_MM_dd_HH_mm, current);
			keyword3.setValue(date);
			m.put("keyword3", keyword3); 
			wxMssVo.setData(m);
			
			smallRoutineService.pushOneUser(openid, formid, temid, wxMssVo , type ,restTemplate);
		} catch (Exception e) {
			
		}
	}
	
	
	private Long  getLandUserId(String userid) {
		LandlordManagerExample example = new LandlordManagerExample();
		LandlordManagerExample.Criteria criteria = example.createCriteria();
		criteria.andManageruseridEqualTo(Long.valueOf(userid));
		criteria.andStateEqualTo(2);
		List<LandlordManager> list = landlordManagerMapper.selectByExample(example);
		if (CheckDataUtil.checkNotEmpty(list)) {
			return list.get(0).getLanduserid();
		}
		return null;
	}


	@Bean
	public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
		return new RestTemplate(factory);
	}

	@Bean
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(180000);// 单位为ms
		factory.setConnectTimeout(5000);// 单位为ms
		return factory;
	}
	
	
	

}
