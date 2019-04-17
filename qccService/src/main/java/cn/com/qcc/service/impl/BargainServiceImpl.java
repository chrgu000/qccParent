package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BargainMapper;
import cn.com.qcc.mapper.BargaindetailMapper;
import cn.com.qcc.mapper.CommoninteMapper;
import cn.com.qcc.mapper.DefaultpercentMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.PreparatoryMapper;
import cn.com.qcc.mapper.PriceMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.Bargaindetail;
import cn.com.qcc.pojo.BargaindetailExample;
import cn.com.qcc.pojo.Commoninte;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.HouseorderExample;
import cn.com.qcc.pojo.Preparatory;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.ProfileExample;
import cn.com.qcc.queryvo.BargainCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.BargainService;

@Service
@Transactional
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
	@Autowired
	CommoninteMapper commoninteMapper;
	@Autowired
	ProfileMapper profileMapper;
	@Autowired
	DefaultpercentMapper defaultpercentMapper;
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
			Long barginid = null;
			// 第四步计算砍价金额
			Preparatory prepartory = preparatoryMapper.selectByPrimaryKey(preparatoryid);
			Price price = priceMapper.selectByPrimaryKey( house.getPrice_id());
			
			// 房东付佣金百分比
			double cent = 0;
			// 租客付佣金百分比
			double usercent = 0 ;
			// 这里是砍价的金额
			double totalprice = 0;
			int daycount = 0;
			
			/***   1 , 计算订单的金额   [房东佣金 + 租客佣金的 20 % ]
			 * 订单的金额         [订单金额是：(租客佣金百分比 +房东佣金百分比 ) * 租金  ]
			 * 如果都是 0 则为房租价格的一半 。默认为 房租价格
			 * ***/   
			double orderprice = 0;
			if (CheckDataUtil.checkNotEmpty(prepartory)) {
				cent = prepartory.getLandpercentnum();
				usercent = prepartory.getCentpercentnum();
				daycount = prepartory.getDaycount();
				orderprice = price.getPrices() * ( cent + usercent );
			}
			if (orderprice == 0) {
				orderprice = price.getPrices() * defaultpercentMapper.centNumIsZeroDingjinGet();
			}
			Bargain bargain = houseCustomerMapper.getNewBargin(otherid,type ,daycount);
			if (CheckDataUtil.checkNotEmpty(bargain)) {
				Long current = new Date().getTime();
				Long endTime = bargain.getEndtime().getTime();
				if (current.longValue() < endTime.longValue()) {
					if (bargain.getUserid().longValue() == userid.longValue()) {
						/*return ResultMap.build(200,"你已经发起了砍价",bargain.getBarginid());*/
						barginid = bargain.getBarginid() ;
					}else {
						return ResultMap.build(400, "你来晚了，有人已经发起了砍价");
					}
				}
			}
			
			
			
			
			
			
			// 没有设置佣金的情况下
			if (cent == 0) {
				cent = defaultpercentMapper.centNumIsZeroNetGet() ; 
			}
			// 计算砍价的金额  [租金 * 佣金和 * 20]
			totalprice = price.getPrices() 
					* (cent + usercent) 
					* defaultpercentMapper.canJiaNum();
			// 计算砍价金额
			if (CheckDataUtil.checkisEmpty(barginid)) {
				Bargain inserBargin = new Bargain();
				inserBargin.setType(1);
				if (CheckDataUtil.checkNotEmpty(preparatoryid)) {
					inserBargin.setPreparatoryid(preparatoryid);
				}
				inserBargin.setUserid(userid);
				inserBargin.setDaycount(daycount);
				inserBargin.setOtherid(otherid);
				inserBargin.setLessbalance(totalprice);
				inserBargin.setTotalbanalce(totalprice);
				Date start = new Date();
				Date end = IDUtils.getNextDay(start);
				inserBargin.setStarttime(start);
				inserBargin.setEndtime(end);
				bargainMapper.insertSelective(inserBargin);
				barginid = inserBargin.getBarginid();
				
			}
			
			
			UserCustomer userCustomer = userCustomerMapper.getUserAndProfileByUserid(userid);
			if (CheckDataUtil.checkisEmpty(tel)) {
				tel = userCustomer.getTelephone().toString();
			}
			if (CheckDataUtil.checkisEmpty(name)) {
				name = userCustomer.getRealname()==null?"":userCustomer.getRealname();
			}
			
			
			// 第五步把砍价的id绑定到用户订单
			HouseorderExample example = new HouseorderExample();
			HouseorderExample.Criteria criteria = example.createCriteria();
			criteria.andHouseidEqualTo(otherid);
			criteria.andUseridEqualTo(userid);
			criteria.andPaystateEqualTo(2);
			criteria.andDaycountEqualTo(daycount);
			Long orderId = null;
			List<Houseorder> orders = houseorderMapper.selectByExample(example);
			if (CheckDataUtil.checkNotEmpty(orders)) {
				orderId = orders.get(0).getHouseorderid();
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
			orderIn.setBarginid(barginid);
			if (CheckDataUtil.checkNotEmpty(orderId)) {
				orderIn.setHouseorderid(orderId);
				houseorderMapper.updateByPrimaryKeySelective(orderIn);
			} else {
				houseorderMapper.insertSelective(orderIn);
			}
			return ResultMap.build(200, "发起成功" ,barginid);
		} else {
			return ResultMap.build(400, "参数错误");
		}
	}

	

	/***
	 * 查询砍价列表
	 * **/
	public ResultMap searchList(Long barginid,String unionid , String userid) {
		BargainCustomer bargainCustomer = houseCustomerMapper.bargainDetailList(barginid);
		if (CheckDataUtil.checkisEmpty(bargainCustomer)) {
			return ResultMap.build(400, "没有查到相关数据");
		}
		BargaindetailExample example = new BargaindetailExample();
		BargaindetailExample.Criteria criteria = example.createCriteria();
		criteria.andBarginidEqualTo(barginid);
		List<Bargaindetail> details = bargaindetailMapper.selectByExample(example);
		
		//计算当事人砍了多少钱。
		double totalAccount =0;
		for (Bargaindetail detail : details) {
			if (CheckDataUtil.checkisEqual(detail.getUserid(), userid)) {
				totalAccount += detail.getAccount();
			}
			if (CheckDataUtil.checkisEqual(detail.getUnionid(), unionid)) {
				totalAccount += detail.getAccount();
			}
		}
		bargainCustomer.setAccount(totalAccount);
		bargainCustomer.setDetails(details);
		return ResultMap.IS_200(bargainCustomer);
	}



	/**作砍价处理**/
	public ResultMap doBargainDetail(Bargaindetail bargaindetail) {
		if (CheckDataUtil.checkisEmpty(bargaindetail.getBarginid()))
		{return ResultMap.build(400,"未知的授权用户!!");}
		
		if (CheckDataUtil.checkisEmpty(bargaindetail.getUserid() ) 
				&& CheckDataUtil.checkisEmpty(bargaindetail.getUnionid()) ) {
			return ResultMap.build(400, "未知授权用户");
		}
		
		if (CheckDataUtil.checkNotEmpty(bargaindetail.getUserid())) {
			ProfileExample example = new ProfileExample();
			ProfileExample.Criteria criteria = example.createCriteria();
			criteria.andUser_idEqualTo( Long.valueOf(bargaindetail.getUserid()  ));
			List<Profile> preList = profileMapper.selectByExample(example);
			if (CheckDataUtil.checkisEmpty(preList)) {
				return ResultMap.build(400, "未知用户");
			}
			bargaindetail.setUsername(preList.get(0).getUser_name());
			bargaindetail.setAvatar(preList.get(0).getAvatar());
		}
		
		Bargain bargin = bargainMapper.selectByPrimaryKey(bargaindetail.getBarginid());
		if (CheckDataUtil.checkisEmpty(bargin)
				|| bargin.getLessbalance().doubleValue() <=0) {
			return ResultMap.build(400, "当前没有可砍的余额");
		}
		
		// 判断活动是否过期
		long current = new Date().getTime();
		long end = bargin.getEndtime().getTime();
		if (current > end) 
			return ResultMap.build(400, "过期了!!!!");
		
		// 判断用户是否砍过
		List<Bargaindetail> detailList = checkDetail (bargaindetail.getBarginid(),
				bargaindetail.getUnionid() );
		
		for (Bargaindetail detail : detailList) {
			if (CheckDataUtil.checkNotEmpty(detail)) {
				if (CheckDataUtil.checkNotEmpty(detail.getUnionid())) {
					if (detail.getUnionid().equals(bargaindetail.getUnionid())) {
						return ResultMap.build(200, "你已经砍了一刀，机会留给别人吧" );
					}
				}
				if (CheckDataUtil.checkNotEmpty(detail.getUserid())) {
					if (detail.getUserid().equals(bargaindetail.getUserid())) {
						return ResultMap.build(200, "你已经砍了一刀，机会留给别人吧" );
					}
					if (detail.getUsername().equals(bargaindetail.getUsername())) {
						return ResultMap.build(200, "你已经砍了一刀，机会留给别人吧" );
					}
					if (detail.getAvatar().equals(bargaindetail.getAvatar())) {
						return ResultMap.build(200, "你已经砍了一刀，机会留给别人吧" );
					}
				}
			
			}
		}
		
		
		
	
		Commoninte selectByPrimaryKey = commoninteMapper.selectByPrimaryKey(20L);
		// 拿出系统配置好的房源初始需要砍的刀数
		long totalSize = selectByPrimaryKey.getTypecount();
		// 这里做砍刀处理返回剩余的金额
		double doBargin = IDUtils.doBargin(bargin.getLessbalance() ,totalSize -detailList.size() );
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
