package cn.com.qcc.managerclient.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mymapper.HouseRoomCustomerMapper;
import cn.com.qcc.pojo.House;
import cn.com.qcc.queryvo.UserCentCustomer;


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

	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			Long userCentId = Long.valueOf(  (String)textMessage.getText() );
			System.out.println("============= 房东端发布租约后接受到 租约id============" + userCentId);
			//休眠 5 秒
			Thread.sleep(5000);
			
			UserCentCustomer userCentCustomer =  houseRoomCustomerMapper.searchCentHouseMess(userCentId);
			
			// 1-设置房源为已经租的状态
			House update = new House();
			update.setHouseid(userCentCustomer.getHouseid());
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
