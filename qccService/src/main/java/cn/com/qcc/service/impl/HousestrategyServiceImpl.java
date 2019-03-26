package cn.com.qcc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.VillagetrategyMapper;
import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.pojo.Villagetrategy;
import cn.com.qcc.queryvo.HousestrategyCustomer;
import cn.com.qcc.service.HousestrategyService;

@Service
public class HousestrategyServiceImpl implements HousestrategyService {

	@Autowired
	private VillagetrategyMapper trategyMapper;
	
	@Autowired
	private VillageCustomerMapper villageCustomerMapper;
	
	@Override
	public ResultMap addHousestrategy(Villagetrategy trategy) {
		if (CheckDataUtil.checkisEmpty(trategy.getVillageid())) {
			return ResultMap.build(400,"选择发布的小区");
		}
		
		if (CheckDataUtil.checkisEmpty(trategy.getUserid())) {
			return ResultMap.build(400, "请先登录");
		}
		
		 trategy.setCreate_time(new Date());
		 trategyMapper.insertSelective(trategy);
		 
		 return ResultMap.build(200, "发布成功");
	}

	@Override
	public ResultMap editSearch(Long housestrategyid) {
		// TODO Auto-generated method stub
		
		if(CheckDataUtil.checkisEmpty(housestrategyid)) {
			return ResultMap.build(400, "选择一条攻略");
		}
		HousestrategyCustomer selectByPrimaryKey = villageCustomerMapper.searchOneTrategy(housestrategyid);
		return ResultMap.IS_200(selectByPrimaryKey);
	}

	@Override
	public ResultMap update(Villagetrategy trategy) {
		if (CheckDataUtil.checkisEmpty(trategy.getTrategyid())) {
			return ResultMap.build(400,"选择攻略");
		}
		
		if (CheckDataUtil.checkisEmpty(trategy.getVillageid())) {
			return ResultMap.build(400,"选择发布的小区");
		}
		
		if (CheckDataUtil.checkisEmpty(trategy.getUserid())) {
			return ResultMap.build(400, "请先登录");
		}
		
		trategyMapper.updateByPrimaryKeySelective(trategy);
		
		return ResultMap.build(200, "编辑成功");
	}

}
