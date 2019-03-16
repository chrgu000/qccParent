package cn.com.qcc.tenement.mqmess;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.User;
import cn.com.qcc.queryvo.HouseCustomer;


public class UserPayHouseAccountMess implements MessageListener {
	
	@Autowired
	UserMapper userMapper;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;

	@Override
	public void onMessage(Message message) {
		try {
			
			/**
			 *  house.getHouseid() + "-" + house.getUserid() + "-" + house.getLanduserid()
		+ "-" + house.getManageruserid();
			 * 
			 * **/
			TextMessage textMessage = (TextMessage)message;
			String text = (String)textMessage.getText();
			System.out.println("租客交租收到消息：" + text);
			// 拿到TEXT 需要休眠一会儿。等待数据库提交事务
			Thread.sleep(500);
			// 房子id
			Long houseid = Long.valueOf(text.split("-")[0]);
			
			HouseCustomer details = houseCustomerMapper.findHouseDetails(houseid);
			// 租客id
			Long userid = Long.valueOf(text.split("-")[1]);
			// 房东id
			Long landUserid = Long.valueOf(text.split("-")[2]);
			//管理员id
			Long managerUserid = Long.valueOf(text.split("-")[3]);
			String orderNum = text.split("-")[4];
			String centPrices = text.split("-")[5];
			User cent = userMapper.selectByPrimaryKey(userid);
			User land = userMapper.selectByPrimaryKey(landUserid);
			User manager = userMapper.selectByPrimaryKey(managerUserid);
			
			
			
			String modelIdUser = WangYiCommon.NOTIC_USER_HOUSEPAY_SUCCESS;
			String modelIdLand = WangYiCommon.NOTIC_LAND_HOUSEPAY_SUCCESS;
			String modelIdManager = WangYiCommon.NOTIC_MANAGER_HOUSEPAY_SUCCESS;
			String contentCommon = details.getVillagename() + "-" +
					details.getBuilding() + "-" +
					details.getHouse_number() +"(号房)";
			contentCommon = contentCommon + "," + centPrices + " 元"  + "," +orderNum;
			// 通知租户
			SendMessage.sendNoticMess(contentCommon, cent.getTelephone().toString(), modelIdUser);
			// 通知房东
			SendMessage.sendNoticMess(contentCommon, land.getTelephone().toString(), modelIdLand);
			if (landUserid.longValue() != managerUserid.longValue()) {
				// 通知管理员
				SendMessage.sendNoticMess(contentCommon, manager.getTelephone().toString(), modelIdManager);
			}
		} catch (Exception e) {
			// 这里是发生未知异常
			e.printStackTrace();
		}
		
	}

}
