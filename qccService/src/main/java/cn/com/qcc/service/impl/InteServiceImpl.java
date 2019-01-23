package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.CommoninteMapper;
import cn.com.qcc.mapper.InteconnMapper;
import cn.com.qcc.mapper.IntegralMapper;
import cn.com.qcc.mapper.MasonryMapper;
import cn.com.qcc.mapper.MasonryconnMapper;
import cn.com.qcc.mymapper.ConsumeCustomerMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.Commoninte;
import cn.com.qcc.pojo.Inteconn;
import cn.com.qcc.pojo.Integral;
import cn.com.qcc.pojo.IntegralExample;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Masonry;
import cn.com.qcc.pojo.Masonryconn;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.service.InteService;



@Service
public class InteServiceImpl implements InteService {

	@Autowired
	InteconnMapper inteconnMapper;
	@Autowired
	IntegralMapper integralMapper;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	MasonryMapper masonryMapper;
	@Autowired
	MasonryconnMapper masonryconnMapper;
	@Autowired
	ConsumeCustomerMapper consumeCustomerMapper;
	@Autowired
	CommoninteMapper commoninteMapper;

	/**积分消耗处理
	 * @param commonid : 类型主键
	 * @param userid : 用户id
	 * @param otherid : 物品主键
	 * **/ 
	public ResultMap consumebranch(Long commonid, Long userid , Long otherid ) {
		// 先判断当前类目是否当天扣过积分
		Integer todaylength = consumeCustomerMapper.todaylength(commonid , otherid , userid);
		if (todaylength > 0 ) {
			// 说明今天扣过积分
			return ResultMap.IS_200();
		}
		
		
		// 第一步查询 此金币类型的基本参数 
		Commoninte search = commoninteMapper.selectByPrimaryKey(commonid);
		// 第二步 根基 金币类型查询当天的次数
		Integer currentlength = consumeCustomerMapper.searchcurrntlength(search.getCommonid() ,userid );
		// 第三步 判断是否在金币频率范围内
		if (search.getFrequency() > currentlength) { 
			// 第四步判断金币是否足够
			String event = search.getTypename();
			Long count = search.getTypecount();
			Inteconn inteconn_search = inteconnMapper.selectByPrimaryKey(userid);
			//如果积分不足返回
			if (inteconn_search.getCount() - count < 0) {
				return ResultMap.build(400, "积分不足");
			}
			// 第五步进行积分扣除事件
			Integral integral = new Integral();
			integral.setUpdate_time(new Date());
			integral.setUserid(userid);
			integral.setType(2);
			integral.setOtherid(otherid);
			integral.setCommonid(commonid);
			integral.setCount(count);
			integral.setEvent(event);
			inteconn_search.setUpdate_time(new Date());
			//这里添加积分操作记录
			integralMapper.insertSelective(integral);
			inteconn_search.setCount(inteconn_search.getCount() - count);
			inteconnMapper.updateByPrimaryKeySelective(inteconn_search);
			
		}
		return ResultMap.IS_200();
	}

	/**
	 * 这里是扣除积分之前的查询操作
	 * @param commonid : 类型主键
	 * @param userid : 用户id
	 * **/ 
	public ResultMap consumebranchsearch(Long commid, Long userid) {
		// 先查询你的积分
		Inteconn integral = inteconnMapper.selectByPrimaryKey(userid);
		if (integral == null) {
			integral = new Inteconn();
			integral.setCount(100L);
			integral.setUpdate_time(new Date());
			integral.setUserid(userid);
			integral.setGrand(1);
			inteconnMapper.insertSelective(integral);
		}
		
		Commoninte search = commoninteMapper.selectByPrimaryKey(commid);
		// 这里查询扣除的积分是否小于总积分
		if (integral.getCount() <search.getTypecount()) {
			return ResultMap.build(300, "积分不足无法操作");
		}
		
		return ResultMap.IS_200();
	}
	
	
	//处理获得的洪币
	public void mangermasonryconn(Long type, Long userid) {
		String event = "";
		Long count = 0L;
		// 统计积分事件
		Masonry masonry = new Masonry();
		masonry.setUpdate_time(new Date());
		masonry.setUserid(userid);
		masonry.setType(1);
		Commoninte search = commoninteMapper.selectByPrimaryKey(type);
		event = search.getTypename();
		count = search.getTypecount();
		//if (type == 15) {event = "被查看电话" ;count=15L;}
		masonry.setEvent(event);
		masonry.setCount(count);
		masonryMapper.insertSelective(masonry);
		
		// 控制积分总数
		Masonryconn masonry_search = masonryconnMapper.selectByPrimaryKey(userid);
		// 如果控制表没有数据
		if (masonry_search == null) {
			Masonryconn masconn = new Masonryconn();
			masconn.setCount(count);
			masconn.setUpdate_time(new Date());
			masconn.setUserid(userid);
			masonryconnMapper.insertSelective(masconn);
		} else {
			masonry_search.setUpdate_time(new Date());
			masonry_search.setCount(masonry_search.getCount() + count);
			masonryconnMapper.updateByPrimaryKeySelective(masonry_search);
		}
		
	}

	/** 处理获得的积分
	 * @param commonid : 金币主键
	 * @param userid : 用户ID
	 * **/ 
	public String managebranch(Long commonid, Long userid ,Long otherid) {
		// 第一步查询 此金币类型的基本参数 
		Commoninte search = commoninteMapper.selectByPrimaryKey(commonid);
		String resturn = "当天" +search.getTypename()+"获取金币上限"; // 提示获得金币信息
		// 第二步 根基 金币类型查询当天的次数
		Integer currentlength = consumeCustomerMapper.searchcurrntlength(search.getCommonid() ,userid );
		// 第三步 判断是否在金币频率范围内
		if (search.getFrequency() > currentlength) {
			// 第四步 统计积分事件
			String event = search.getTypename();
			Long count = search.getTypecount();
			Integral integral = new Integral();
			integral.setUpdate_time(new Date());
			integral.setUserid(userid);
			integral.setType(1); // 1-获得，2-失去
			integral.setCommonid(commonid);
			integral.setOtherid(otherid);
			integral.setEvent(event);
			integral.setCount(count);
			integralMapper.insertSelective(integral);
			
			// 控制积分总数
			Inteconn inteconn_search = inteconnMapper.selectByPrimaryKey(userid);
			// 如果控制表没有数据
			if (inteconn_search == null) {
				Inteconn inteconn = new Inteconn();
				inteconn.setCount(count);
				inteconn.setUpdate_time(new Date());
				inteconn.setUserid(userid);
				inteconn.setGrand(1);
				inteconnMapper.insertSelective(inteconn);
			} else {
				inteconn_search.setUpdate_time(new Date());
				inteconn_search.setCount(inteconn_search.getCount() + count);
				inteconnMapper.updateByPrimaryKeySelective(inteconn_search);
			}
			
			resturn = search.getTypename() + "+" + search.getTypecount() ;
		}
		
		return resturn;
		
	}

	/**
	 *  我的积分消耗事件
	 * **/
	public List<Integral> myinteout(UserVo userVo) {
		return consumeCustomerMapper.myinteout(userVo);
	}
	public int myinteoutCount(UserVo userVo) {
		return consumeCustomerMapper.myinteoutCount(userVo);
	}


	/**
	 * 这里处理充值金币的回调
	 * **/ 
	public String chongzhirenturn(Integral integral, double monery) {
		// 先插入一条数据
		integralMapper.insertSelective(integral);

		// 在处理积分相加
		// 控制积分总数
		Inteconn inteconn_search = inteconnMapper.selectByPrimaryKey(integral.getUserid());
		// 如果控制表没有数据
		if (inteconn_search == null) {
			Inteconn inteconn = new Inteconn();
			inteconn.setCount(integral.getCount());
			inteconn.setUpdate_time(new Date());
			inteconn.setUserid(integral.getUserid());
			inteconn.setGrand(1);
			inteconnMapper.insertSelective(inteconn);
		} else {
			inteconn_search.setUpdate_time(new Date());
			inteconn_search.setCount(inteconn_search.getCount() + integral.getCount());
			inteconnMapper.updateByPrimaryKeySelective(inteconn_search);
		}
		return "success";
	}

	
	
	/**查看房源扣除积分
	 * @param houseid : 房源ID
	 * @param userid : 用户ID
	 * @param type : 业务类型
	 * **/
	public ResultMap searchphonedeletejinbi(Long houseid, Long userid,String type) {
		//如果是查看房源
		if ("house".equals(type)) {
			HouseCustomer house = houseCustomerMapper.findHouseDetails(houseid);
			if (house == null) {
				return ResultMap.build(500, "房源不存在");
			}
			if (house.getUserid().equals(userid+"")) {return ResultMap.IS_200();}
			Inteconn inteconn = inteconnMapper.selectByPrimaryKey(userid);
			if (inteconn == null) {
				inteconn = new Inteconn();
				inteconn.setCount(100L);
				inteconn.setUpdate_time(new Date());
				inteconn.setUserid(userid);
				inteconn.setGrand(1);
				inteconnMapper.insertSelective(inteconn);
			}
			// 这里设置需要扣除的 金币总数
			Long deletetype = 6L;
			if ("".equals(house.getPrices()) || house.getPrices() == null) {
				deletetype = 6L;
			} else {
				Double price = Double.valueOf(house.getPrices());
				if (price > 1000) {
					deletetype = 6L;
				} else {
					deletetype = 7L;
				}
			}
			
			// 处理积分事件和积分问题
			ResultMap resultMap  =  consumebranch(deletetype, userid,houseid);
			
			//如果积分扣除成功
			if (resultMap.getCode() == 200) {
				//处理加分金币
				//managebranch(15,Long.valueOf(house.getUserid()));
				//处理加分洪币
				mangermasonryconn(8L,Long.valueOf(house.getUserid()));
			}
			return resultMap;
		}
		
		// 如果是查看楼栋......
		if ("building".equals(type)) {
			
		}
		return ResultMap.IS_200();

	}

	

	/**
	 * 判断是否通过关注获得积分
	 * @param userid: 用户id
	 * @param event : 时间名称
	 * **/
	public boolean isgetjinbibyevent(Long commonid, Long userid) {
		IntegralExample example = new IntegralExample();
		IntegralExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andCommonidEqualTo(commonid);
		List<Integral> intes = integralMapper.selectByExample(example);
		if (!intes.isEmpty() && intes.size() > 0) {
			return true ;
		}
		return false;
	}

	/**
	 * 我的洪币列表
	 * **/
	public List<Masonry> mymasonrylist(UserVo userVo) {
		return consumeCustomerMapper.mymasonrylist(userVo);
	}
	public int mymasonrylistCount(UserVo userVo) {
		return consumeCustomerMapper.mymasonrylistCount(userVo);
	}

	/** 查询积分是否充足
	 * @param commonid : 类型主键
	 * @param userid : 用户id
	 * **/
	public boolean searchdelete(Long i, Long userid) {
		Long count = 1L;
		if (userid == null || i == null) {return false ;}
		if (userid !=null) {
			//if (i == 1) {count  = 20L;} // 房源20分
			Commoninte commsearch = commoninteMapper.selectByPrimaryKey(i);
			Inteconn search = inteconnMapper.selectByPrimaryKey(userid);
			if (search == null || commsearch == null) {return  false;}
			count = search.getCount() - commsearch.getTypecount();
		}
		return count > 0;
	}
	
	
	//查询剩余积分
	public Long searchless ( Long userid ) {
		Long count = 100L; 
		if (userid ==null) {return count;}
		Inteconn search = inteconnMapper.selectByPrimaryKey(userid);
		return search.getCount();
	}

	/***
	 *  分享成功获取金币
	 *  @param userid : 用户id
	 *  @param otherid : 分享的物品主键
	 * **/
	public ResultMap shareaddjinbi(Long userid , Long otherid) {
		if (userid == null) {return ResultMap.build(400, "未知用户");}
		managebranch(18L , userid , otherid);
		return ResultMap.build(200, "+20");
	}

	// 查询 冷却了n天的收益
	public List<Lucre> searchNeedAddLurceByTime(int daycount) {
		return consumeCustomerMapper.searchNeedAddLurceByTime(daycount);
	}

	// 将第n天已经收益的更新为已经添加到正常收益状态
	public void updateLurceIsAddByTime(int daycount) {
		consumeCustomerMapper.updateLurceIsAddByTime(daycount);
	}

}
