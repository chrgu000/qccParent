package cn.com.qcc.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.PaymodalMapper;
import cn.com.qcc.mymapper.UserRoomCustomerMapper;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.queryvo.HousepayCustomer;
import cn.com.qcc.queryvo.PayexpertCustomer;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserRoomCustomer;
import cn.com.qcc.service.UserRoomService;

@Service
@Transactional
public class UserRoomServiceImpl implements UserRoomService {
	
	@Autowired
	UserRoomCustomerMapper userRoomCustomerMapper;
	@Autowired
	PaymodalMapper paymodalMapper;

	@Override
	public UserRoomCustomer getLandOrManagerMess(Long telephone) {
		// 第一步查询房东的登录信息
		UserRoomCustomer userRoomCustomer = userRoomCustomerMapper.getLandMess(telephone);
		// 如果查到数据 判断房东是否通过审核
		if (CheckDataUtil.checkNotEmpty(userRoomCustomer)) {
			//如果房东通过审核 直接返回数据
			if (userRoomCustomer.getLandstate() == 2) {
				return userRoomCustomer;
			}
		}
			
		// 第二步查询管理的登录信息  [如果上面条件 没有正常返回]  
		userRoomCustomer = userRoomCustomerMapper.getManagerMess(telephone);
		if (CheckDataUtil.checkNotEmpty(userRoomCustomer)) {
			//如果管理通过审核 直接返回数据
			if (userRoomCustomer.getLandstate() == 2) {
				// 如果是管理的话。 是否需要控制其房东分配给与的权限????
				return userRoomCustomer;
			}
		}
		//如果上诉数据都不成立则返回null 代表该用户不可以登录房东后台
		return null;
	}
	
	
	/**查询房源所有的基本租约信息 包括续签的**/
	public ResultMap usercentdetail(String usercentnum) {
		Map<String, Object> map = new HashMap<>();
		
		UserCentCustomer centprices = userRoomCustomerMapper.usercentdetailprices(usercentnum);
		
		// 根据租约编号查询租约详情信息
		UserCentCustomer userCentCustomer = userRoomCustomerMapper.usercentdetail(usercentnum);
		// 第一步根据 租约编号 获取 所有的房源租约列表
		
		List<UserCentCustomer> cents = userRoomCustomerMapper.usercentdetaillist(usercentnum);
		String payname = ""; // 付款方式 QTC153058298916062
		for (UserCentCustomer cent : cents) {
			String[] ids = cent.getPaystyleid().split(",");
			Paymodal pa1 = paymodalMapper.selectByPrimaryKey(Long.valueOf(ids[0]));
			Paymodal pa2 = paymodalMapper.selectByPrimaryKey(Long.valueOf(ids[1]));
			payname = pa1.getTypename() + pa2.getTypename();
			cent.setPaystylename(payname);
			payname = "";
			// 查询费用集合
			List<UserCentCustomer> pays = userRoomCustomerMapper.firstpay(cent.getUsercentid());
			cent.setUsercents(pays);
			String countName = IDUtils.foematInteger(cent.getCenttimes());
			cent.setCountName("第" + countName + "次签约");
		}
		// 设置总押金
		userCentCustomer.setCurrentprices(centprices.getCentprices());
		// 计算租约时间长度
		String datalong = IDUtils.datecompany(userCentCustomer.getEnd_time(), userCentCustomer.getStart_time());
		userCentCustomer.setCountName(datalong);
		map.put("usercent", userCentCustomer);
		map.put("centlist", cents);
		return ResultMap.IS_200(map);
	}
	
	
	
	
	
	/**通过租约编号查询到账单详情**/
	public ResultMap financialbycentnum(String usercentnum) {
		
		// ==== 由于涉及到的业务复杂和提高性能这里只能做三次数据库查询 ===
		// 第一步根据 租约编号 获取 所有的房源租约列表
		List<UserCentCustomer> houseList = userRoomCustomerMapper.getUserCentsByUsercentnum(usercentnum);
		// 获取租约的id 集合 查询所有的分期信息   [由于 租约可能续签 所以会有两期  所有这里分期列表绑定的是租约id ]
		if (CheckDataUtil.checkisEmpty(houseList)) {
			return ResultMap.build(400,"没有对应的账单");
		}
		List<Long> userCentIds = new ArrayList<>();
		for (UserCentCustomer userCent : houseList) {
			userCentIds.add(userCent.getUsercentid());
		}
		List<PayexpertCustomer> expertList = userRoomCustomerMapper.getPayExpertByuserCentIds(userCentIds);
		// 获取到所有的分期id
		List<Long> expertIds = new ArrayList<>();
		for (PayexpertCustomer expert : expertList) {
			expertIds.add(expert.getPayexpertid());
		}
		// 第三步 根据 分期id查询所有账单
		List<HousepayCustomer> payList = userRoomCustomerMapper.getHousePayByCentIds(expertIds);
		// 整合三方数据
		houseList = MeroUserCentAndExpertAddHousePay(houseList , expertList , payList );
		Map<String, Object> hashMap = new HashMap<>();
		List<HousepayCustomer> yacents = new ArrayList<>();
		//最后把押金提取出来
		for (UserCentCustomer house: houseList) {
			yacents.addAll(house.getYanList());
		}
		hashMap.put("financialist", houseList);
		hashMap.put("yacents", yacents);
		return ResultMap.IS_200(hashMap);
	}


	private List<UserCentCustomer> MeroUserCentAndExpertAddHousePay(List<UserCentCustomer> houseList, List<PayexpertCustomer> expertList,
			List<HousepayCustomer> payList) {
		// 第四步开始整合三集合的数据
		for (UserCentCustomer userCent : houseList) {
			// 先整合分期
			List<HousepayCustomer> yanList = new ArrayList<>();
			List<PayexpertCustomer> expretAdd = new ArrayList<>();
			for (PayexpertCustomer expert : expertList) {
				double notPay = 0; // 计算没有交费的金额
				// 在遍历账单
				List<HousepayCustomer> payAdd = new ArrayList<>();
				for (HousepayCustomer pay : payList) {
					if (CheckDataUtil.checkisEqual(pay.getPayexpertid(), expert.getPayexpertid())) {
						payAdd.add(pay);
						// 同一分期的要计算没有交费的金额
						if (pay.getPaystate() == 1) {
							notPay +=pay.getCentprices();
							// 计算账单逾期时间
							int needoutday = DateUtil.daysBetween(new Date(), pay.getNeedpaytime());
							pay.setNeedoutday(needoutday);
						}
						if (pay.getFatherid() == 6 ) {
							System.out.println("添加押金");
							yanList.add(pay);
						}
						
					}
				}
				//遍历完成后加入分期 同时设置没有交费的金额
				expert.setCentprices(notPay);
				expert.setPayList(payAdd);
				// 如果是同一个租约的就添加
				if (CheckDataUtil.checkisEqual(expert.getUsercentid(), userCent.getUsercentid())) {
					expretAdd.add(expert);
				}
				
			}
			// 查询费用集合
			String countName = IDUtils.foematInteger(userCent.getCenttimes());
			userCent.setCountName("第" + countName + "次签约");
			// 计算租约时间长度
			String dayLong = IDUtils.datecompany(userCent.getEnd_time(), userCent.getStart_time());
			userCent.setDayLong(dayLong);
			userCent.setYanList(yanList);
			// 遍历完成之后添加到集合中
			userCent.setExpertList(expretAdd);
		}
		
		return houseList;
	}


	/**通过用户id查询待支付的账单集合**/
	public ResultMap findhousebile(Long userid) {
		
		// ==== 由于涉及到的业务复杂和提高性能这里只能做三次数据库查询 ===
		
		// 第一步根据 用户id 获取 所有的房源租约列表
		List<UserCentCustomer> houseList = userRoomCustomerMapper.getUserCentsByUserId(userid);
		// 获取租约的id 集合 查询所有的分期信息   [由于 租约可能续签 所以会有两期  所有这里分期列表绑定的是租约id ]
		if (CheckDataUtil.checkisEmpty(houseList)) {
			return ResultMap.build(400,"没有对应的账单");
		}
		List<Long> userCentIds = new ArrayList<>();
		for (UserCentCustomer userCent : houseList) {
			userCentIds.add(userCent.getUsercentid());
		}
		// 第二步 应该是查询账单的集合 由于账单 关联的是 租约id  和 分期id
		List<PayexpertCustomer> expertList = userRoomCustomerMapper.getPayExpertByuserCentIds(userCentIds);
		// 获取到所有的分期id
		List<Long> expertIds = new ArrayList<>();
		for (PayexpertCustomer expert : expertList) {
			expertIds.add(expert.getPayexpertid());
		}
		// 第三步 根据 分期id查询所有账单
		List<HousepayCustomer> payList = userRoomCustomerMapper.getHousePayByCentIds(expertIds);
		
		// 第四步 整合数据
		houseList = MeroUserCentAndExpertAddHousePay(houseList , expertList , payList );
		
		return ResultMap.IS_200(houseList);
	}

}
