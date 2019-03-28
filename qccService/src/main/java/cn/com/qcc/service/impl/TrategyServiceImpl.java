package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.VillagetrategyMapper;
import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.pojo.Villagetrategy;
import cn.com.qcc.queryvo.TrategyCustomer;
import cn.com.qcc.service.TrategyService;

@Service
public class TrategyServiceImpl implements TrategyService {

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
		TrategyCustomer selectByPrimaryKey = villageCustomerMapper.searchOneTrategy(housestrategyid);
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

	@Override
	public List<TrategyCustomer> searchList(Long userid, PageQuery pagequery) {
		return villageCustomerMapper.searchTrageryList(userid , pagequery);
	}

	@Override
	public int searchListCount(Long userid) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.searchListCount(userid);
	}

	@Override
	public List<TrategyCustomer> searchTrageryByVillageId(Long villageid) {
		
		
		return villageCustomerMapper.searchTrageryByVillageId(villageid);
	}

	@Override
	public ResultMap delete(Long userid, Long trategyid) {
		Villagetrategy trategy = trategyMapper.selectByPrimaryKey(trategyid);
		
		if (CheckDataUtil.checkisEmpty(trategy)
				|| CheckDataUtil.checkNotEqual(trategy.getUserid(), userid)) {
			return ResultMap.build(400, "无此攻略");
		}
		
		trategyMapper.deleteByPrimaryKey(trategyid);
		
		return ResultMap.build(200,"删除成功");
	}

}
