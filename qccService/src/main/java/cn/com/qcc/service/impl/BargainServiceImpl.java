package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BargainMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.PreparatoryMapper;
import cn.com.qcc.mapper.PriceMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.BargainExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Preparatory;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.BargainService;

@Service
public class BargainServiceImpl implements BargainService{

	@Autowired
	HouseMapper houseMapper;
	@Autowired
	BargainMapper bargainMapper;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	PreparatoryMapper preparatoryMapper;
	@Autowired
	PriceMapper priceMapper;
	@Autowired
	HouseorderMapper houseorderMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Override
	public ResultMap doBargin(Long preparatoryid, Long userid, Integer type , Long otherid) {
		
		if (CheckDataUtil.checkisEmpty(preparatoryid) 
				|| 	CheckDataUtil.checkisEmpty(userid)
				|| 	CheckDataUtil.checkisEmpty(type)
				|| 	CheckDataUtil.checkisEmpty(otherid)) {
			
			return ResultMap.build(400, "参数错误");
		}
		
		if (type == 1) {
			// 第一步先查询房源的状态 [必须是可租的房子]
			House house = houseMapper.selectByPrimaryKey(otherid);
			if (CheckDataUtil.checkisEmpty(house)
					|| !"1".equals(house.getHousestatus())) {
				return ResultMap.build(400, "该房源已经出租或者下架");
			}
			// 第二步判断房源的预定信息 [获取最新的一条预定信息]
			Houseorder order = houseCustomerMapper.getHouseNotPayOrder(otherid);
			if (CheckDataUtil.checkNotEmpty(order) ) {
				// 只要不是没有支付状态。就需要判断是不是三天后的时间 [因为正常的逻辑走该房源应该是租的状态]
				if (order.getUserid().longValue() != userid.longValue()) {
					if (!"2".equals(order.getPaystate().toString())) {
						Long current = new Date().getTime();
						Long orderTime = order.getOrdertime().getTime() + 1000 * 60 *60 *24 *4;
						if (current.longValue() < orderTime.longValue()) {
							return ResultMap.build(400, "预定中");
						}
					}
				}
			}
			// 第三步判断是否有其他人在砍价
			Bargain bargain = houseCustomerMapper.getNewBargin(otherid,type);
			if (CheckDataUtil.checkNotEmpty(bargain)) {
				Long current = new Date().getTime();
				Long endTime = bargain.getEndtime().getTime();
				if (current.longValue() < endTime.longValue()) {
					if (bargain.getUserid().longValue() == userid.longValue()) {
						return ResultMap.build(400,"你已经发起了砍价");
					}else {
						return ResultMap.build(400, "你来晚了，有人已经发起了砍价");
					}
				}
			}
			
			
			// 第四步计算砍价金额
			Preparatory prepartory = preparatoryMapper.selectByPrimaryKey(preparatoryid);
			Price price = priceMapper.selectByPrimaryKey( house.getPrice_id());
			double cent = 0;
			double totalprice = 0;
			int daycount = 30;
			double orderprice = 0;
			if (CheckDataUtil.checkNotEmpty(prepartory)) {
				cent = prepartory.getLandpercentnum();
				daycount = prepartory.getDaycount();
				orderprice = price.getPriceid() * (
						prepartory.getCentpercentnum() + prepartory.getLandpercentnum()
				);
			}
			
			if (orderprice == 0) {
				orderprice = price.getPrices() * 0.5;
			}
			
			// 没有设置佣金的情况下
			if (cent < 0) {
				totalprice = price.getPrices() * 0.5 * 0.2;
			}else {
				totalprice = price.getPrices() * cent * 0.4;
			}
			// 计算砍价金额
			Bargain inserBargin = new Bargain();
			inserBargin.setType(1);
			inserBargin.setUserid(userid);
			inserBargin.setOtherid(otherid);
			inserBargin.setLessbalance(totalprice);
			inserBargin.setTotalbanalce(totalprice);
			Date start = new Date();
			Date end = IDUtils.getNextDay(start);
			inserBargin.setStarttime(start);
			inserBargin.setEndtime(end);
			bargainMapper.insertSelective(inserBargin);
			
			UserCustomer userCustomer = userCustomerMapper.getUserAndProfileByUserid(userid);
			// 第五步创建预订单
			Houseorder orderIn = new Houseorder();
			// 如果查无数据表示是第一次点进来的需要做插入
			orderIn.setOrdertime(new Date());
			// 表示没有支付
			orderIn.setPaystate(2);
			orderIn.setBuystate(1);
			orderIn.setDaycount(daycount);
			orderIn.setSallstate(1);
			orderIn.setUserid(userid);
			orderIn.setHouseid(otherid);
			orderIn.setReservationstel(userCustomer.getTelephone()+"");
			orderIn.setReservations(userCustomer.getRealname()==null?"": userCustomer.getRealname());
			orderIn.setPrices(orderprice);
			orderIn.setDaycount(prepartory.getDaycount());
			orderIn.setBarginid(inserBargin.getBarginid());
			houseorderMapper.insertSelective(orderIn);
			return ResultMap.build(200, "发起成功");
		} else {
			return ResultMap.build(400, "参数错误");
		}
	}

	

	/***
	 * 查询砍价列表
	 * **/
	public ResultMap searchList(Long userid, Integer type, Long otherid) {
		BargainExample example = new BargainExample();
		BargainExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		criteria.andOtheridEqualTo(otherid);
		List<Bargain> list = bargainMapper.selectByExample(example);
		return ResultMap.IS_200(list);
	}

}
