package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.mymapper.HouseRoomCustomerMapper;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.service.HouseRoomService;

@Service
public class HouseRoomServiceImpl implements HouseRoomService{
	
	@Autowired
	HouseRoomCustomerMapper houseRoomCustomerMapper;
	
	


	/**查询房态图**/
	public List<HouseRoomCustomer> roompattern(HouseVo houseVo) {
		// 第一步,查询出基本的房源信息列表
		List<HouseRoomCustomer> houseList = houseRoomCustomerMapper.roompattern(houseVo);
		
		// 第二步,根据租约id查询housepay 支付情况表
		List<String> idList = new ArrayList<>();
		
		for (int i = 0; i < houseList.size(); i++) {// 从第一个数开始，到最后一个数-1次循环
			if (CheckDataUtil.checkNotEmpty( houseList.get(i).getUsercentid() ));
			idList.add( houseList.get(i).getUsercentid().toString() );
			for (int j = houseList.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long buil1 = houseList.get(i).getBuildingid();
				Long buil2 = houseList.get(j).getBuildingid();
				Long buil_end = buil1 - buil2;
				Integer folr1 = houseList.get(i).getFloor();
				Integer folr2 = houseList.get(j).getFloor();
				Integer folr_end = folr1 - folr2;
				if (buil_end == 0 && folr_end == 0) {
					houseList.get(j).setFloor(-1);
				}
				if (buil_end == 0) {
					houseList.get(j).setTrading("");
				}
			}

			
		}
		
		
		List<Housepay> payList = new ArrayList<>();
		if (CheckDataUtil.checkNotEmpty(idList)) 
			payList = 	houseRoomCustomerMapper.getPayModel(idList);
		
		// 第三步,计算各种金额数据给前台
		for (HouseRoomCustomer house : houseList) {
			//其他费用没有支付
			double otherpricesnotpay = 0;
			//其他费用支付
			double otherpricespay = 0 ;
			// 取出没有支付的最小日期
			for (Housepay pay : payList) {
				// 当是 同一条租约时候开始计算数据
				if (house.getUsercentid().longValue()== pay.getUsercentid().longValue()) {
					//如果是 29 租金
					if (pay.getFinanceid().longValue() == 29) {
						// 设置租金状态
						house.setCentstate(pay.getPaystate());
						// 设置租金金额
						house.setCentprices(pay.getCentprices());
					} 
					// 如果是30 计算押金
					else if (pay.getFinanceid().longValue() == 30) {
						house.setManagerstate(pay.getPaystate());
						house.setMarginprices(pay.getCentprices());
					} else {
						// 计算其他费用分两类 支付的和 没有支付
						if (pay.getPaystate().longValue() == 1) {
							//判断时间
							Long current = new Date().getTime();
							Long shouKuan = pay.getCreate_time().getTime();
							// 如果当前时间比 收款时间大 说明其他费用逾期
							if (current > shouKuan) 
								otherpricesnotpay += pay.getCentprices();
						}
							
						//其他费用已经支付本月 1 yue 12 -   2  - 12  2 9 
						if ( pay.getPaystate().longValue() == 2) {
							Long current = new Date().getTime();
							Long yishou = 0L;
							if (CheckDataUtil.checkNotEmpty(pay.getUpdate_time())) {
								yishou = pay.getUpdate_time().getTime();
							}
									
							//计算距离收款日前后15 
							if (current > yishou && current < (yishou + 1296000000 * 2) ) 
								otherpricespay +=pay.getCentprices();
						}
							
					}
				}
			}
			house.setOtherpricespay(otherpricespay);
			house.setOtherpricesnotpay(otherpricesnotpay);
			
			if (house.getNeedpaytime() != null) {
				int needoutday = DateUtil.daysBetween(new Date(), house.getNeedpaytime());
				house.setNeedoutday(needoutday);
			}
			if (house.getCententtime() != null) {
				int centenoutday = DateUtil.daysBetween(new Date(), house.getCententtime());
				house.setCentenoutday(centenoutday);
			}
			if ("1".equals(house.getHousestatus())) {
				if (house.getUpdate_time() != null) {
					int notcentday = DateUtil.daysBetween(house.getUpdate_time(), new Date());
					house.setNotcentday(notcentday);
				}
			}
		}
		return houseList;
	}


	@Override
	public int roompatternCount(HouseVo houseVo) {
		// TODO Auto-generated method stub
		return houseRoomCustomerMapper.roompatternCount(houseVo);
	}

}
