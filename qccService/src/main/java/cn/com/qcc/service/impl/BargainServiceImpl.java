package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BargainMapper;
import cn.com.qcc.mapper.BargaindetailMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.PreparatoryMapper;
import cn.com.qcc.mapper.PriceMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.Bargaindetail;
import cn.com.qcc.pojo.BargaindetailExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Preparatory;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.queryvo.BargainCustomer;
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
	@Autowired
	BargaindetailMapper bargaindetailMapper;
	@Override
	public ResultMap doBargin(Long preparatoryid, Long userid,
			Integer type , Long otherid,String tel , String name) {
		
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
						return ResultMap.build(200,"你已经发起了砍价",bargain.getBarginid());
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
			int daycount = 0;
			double orderprice = 0;
			if (CheckDataUtil.checkNotEmpty(prepartory)) {
				cent = prepartory.getLandpercentnum();
				daycount = prepartory.getDaycount();
				orderprice = price.getPrices() * (
						prepartory.getCentpercentnum() + prepartory.getLandpercentnum()
				);
			}
			
			if (orderprice == 0) {
				orderprice = price.getPrices() * 0.5;
			}
			
			// 没有设置佣金的情况下
			if (cent <= 0) {
				totalprice = price.getPrices() * 0.05 * 0.2;
			}else {
				totalprice = price.getPrices() * cent * 0.4;
			}
			// 计算砍价金额
			Bargain inserBargin = new Bargain();
			inserBargin.setType(1);
			if (CheckDataUtil.checkNotEmpty(preparatoryid)) {
				inserBargin.setPreparatoryid(preparatoryid);
			}
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
			if (CheckDataUtil.checkisEmpty(tel)) {
				tel = userCustomer.getTelephone().toString();
			}
			if (CheckDataUtil.checkisEmpty(name)) {
				name = userCustomer.getRealname()==null?"":userCustomer.getRealname();
			}
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
			orderIn.setReservationstel(tel);
			orderIn.setReservations(name);
			orderIn.setPrices(orderprice);
			orderIn.setDaycount(daycount);
			orderIn.setBarginid(inserBargin.getBarginid());
			houseorderMapper.insertSelective(orderIn);
			return ResultMap.build(200, "发起成功" ,inserBargin.getBarginid());
		} else {
			return ResultMap.build(400, "参数错误");
		}
	}

	

	/***
	 * 查询砍价列表
	 * **/
	public ResultMap searchList(Long barginid,String unionid) {
		BargainCustomer bargainCustomer = houseCustomerMapper.bargainDetailList(barginid);
		if (CheckDataUtil.checkisEmpty(bargainCustomer)) {
			return ResultMap.build(400, "没有查到相关数据");
		}
		BargaindetailExample example = new BargaindetailExample();
		BargaindetailExample.Criteria criteria = example.createCriteria();
		criteria.andBarginidEqualTo(barginid);
		List<Bargaindetail> details = bargaindetailMapper.selectByExample(example);
		bargainCustomer.setDetails(details);
		
		
		return ResultMap.IS_200(bargainCustomer);
	}



	/**作砍价处理**/
	public ResultMap doBargainDetail(Bargaindetail bargaindetail) {
		if (CheckDataUtil.checkisEmpty(bargaindetail.getBarginid())
				|| CheckDataUtil.checkisEmpty(bargaindetail.getUnionid())
				|| CheckDataUtil.checkisEmpty(bargaindetail.getAvatar())
				|| CheckDataUtil.checkisEmpty(bargaindetail.getUsername()))
				{
			return ResultMap.build(400,"未知的授权用户!!");
				}
		
		Bargain bargin = bargainMapper.selectByPrimaryKey(bargaindetail.getBarginid());
		if (CheckDataUtil.checkisEmpty(bargin)
				|| bargin.getLessbalance().doubleValue() <=0) {
			return ResultMap.build(400, "当前没有可砍的余额");
		}
		
		// 判断用户是否砍过
		List<Bargaindetail> detailList = checkDetail (bargaindetail.getBarginid(),bargaindetail.getUnionid());
		
		for (Bargaindetail detail : detailList) {
			if (CheckDataUtil.checkNotEmpty(detail)) {
				if (detail.getUnionid().equals(bargaindetail.getUnionid())) {
					return ResultMap.build(200, "你已经砍了一刀，机会留给别人吧" );
				}
			}
		}
		
	
		
		// 这里做砍刀处理返回剩余的金额
		double doBargin = IDUtils.doBargin(bargin.getLessbalance() ,5 -detailList.size() );
		
		// 更新砍刀表
		bargaindetail.setAccount(bargin.getLessbalance() -  doBargin);
		bargaindetail.setUpdatetime(new Date());
		bargaindetailMapper.insertSelective(bargaindetail);
		// 更新剩余金额
		System.out.println("剩余金额：" + doBargin + "主键：" + bargin.getBarginid());
		bargin.setLessbalance(doBargin);
		bargainMapper.updateByPrimaryKeySelective(bargin);
		return ResultMap.build(200, "恭喜你成功砍了一刀" , bargin.getLessbalance() -  doBargin);
	}



	private List<Bargaindetail> checkDetail(Long barginid, String unionid) {
		BargaindetailExample example = new BargaindetailExample();
		BargaindetailExample.Criteria criteria = example.createCriteria();
		criteria.andBarginidEqualTo(barginid);
		List<Bargaindetail> list = bargaindetailMapper.selectByExample(example);
		if (CheckDataUtil.checkNotEmpty(list)) {
			return list;
		}
		return new ArrayList<>() ;
	}

}
