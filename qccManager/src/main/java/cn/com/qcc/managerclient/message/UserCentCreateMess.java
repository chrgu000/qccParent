package cn.com.qcc.managerclient.message;

import java.util.Date;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HousepersionMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.HouseRoomCustomerMapper;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.service.solrdao.HouseSolrDao;


/**
 * 房东发布租约后需要做的事情
 * 1- 给租约和房东发送短信
 * 2- 设置房源状态为已经租的状态
 * 3- ??
 * 
 * **/
public class UserCentCreateMess implements MessageListener {
	
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	HouseRoomCustomerMapper houseRoomCustomerMapper;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	HouseSolrDao houseSolrDao;
	@Autowired
	HousepersionMapper housepersionMapper;

	public void onMessage(Message message) {
		
		try {
			TextMessage textMessage = (TextMessage)message;
			Long userCentId = Long.valueOf(  (String)textMessage.getText() );
			System.out.println("============= 房东端发布租约后接受到 租约id============" + userCentId);
			//休眠 5 秒
			Thread.sleep(5000);
			
			UserCentCustomer userCentCustomer =  houseRoomCustomerMapper.searchCentHouseMess(userCentId);
			Long houseid = userCentCustomer.getHouseid();
			// 1-设置房源为已经租的状态
			House update = new House();
			update.setHouseid(houseid);
			update.setHousestatus("2");
			houseMapper.updateByPrimaryKeySelective(update);
			
			// 2-给租户发送短息
			String modelId = WangYiCommon.LAND_CENT_PUSH;
			String phone = userCentCustomer.getTelephone();
			// 小区  +楼栋 +房号
			String content = userCentCustomer.getVillagename() +"-" + userCentCustomer.getBuilding()
			+ "-" + userCentCustomer.getHouse_number() + "(号房)";
			//发送通知类短息
			SendMessage.sendNoticMess(content, phone, modelId);
			
			
			// 3,这里还需要同步索引库
			HouseCustomer houseCustomer = houseCustomerMapper.searchoneHouseToSolr(houseid);
			if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
				houseSolrDao.AddOneHouseToSolr(houseCustomer);
			}
			
			
			// 4 添加到历史租客
			Housepersion housepersion = new Housepersion();
			housepersion.setSex(userCentCustomer.getSex());
			housepersion.setCardtype("身份证");
			housepersion.setCreate_time(new Date());
			housepersion.setCentstate(1);
			housepersion.setIdentity(userCentCustomer.getIdentity());
			housepersion.setTelephone(userCentCustomer.getTelephone());
			housepersion.setRealname(userCentCustomer.getRealname());
			housepersionMapper.insertSelective(housepersion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
