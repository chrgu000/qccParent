package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BargainMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.BargainExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.service.BargainService;

@Service
public class BargainServiceImpl implements BargainService{

	@Autowired
	HouseMapper houseMapper;
	@Autowired
	BargainMapper bargainMapper;
	
	@Override
	public ResultMap doBargin(String openid, Long userid, Integer type , Long otherid) {
		// 1. 校验该用户是否已经砍过
		List<Bargain> isbragin = checkBargin(openid , userid , type ,otherid);
		if (CheckDataUtil.checkNotEmpty(isbragin)) 
			return ResultMap.build(400, "你已经砍过一刀,机会留给别人吧");
		// 2.判断余额是否为0
		double balance = 0;
		if (type == 1) {
			House house = houseMapper.selectByPrimaryKey(otherid);
			// 获取可以砍价余额
			balance = house.getArea();
			
		}
		if (balance < 0) 
			return ResultMap.build(400, "你来晚了。被人砍光了");
		
		balance = IDUtils.doBargin(balance);
		
		// 作砍价余额的更新
		
		
		
		return ResultMap.build(200, "恭喜你成功砍了一刀");
	}

	private List<Bargain> checkBargin(String openid, Long userid, Integer type , Long otherid) {
		BargainExample example = new BargainExample();
		BargainExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		criteria.andTypeEqualTo(type);
		criteria.andOtheridEqualTo(otherid);
		List<Bargain> list = bargainMapper.selectByExample(example);
		return list;
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
