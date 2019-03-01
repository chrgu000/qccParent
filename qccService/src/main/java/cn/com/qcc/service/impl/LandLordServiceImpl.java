package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mymapper.LandLordCustomerMapper;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.queryvo.LandlordCustomer;
import cn.com.qcc.service.LandLordService;
@Service
@Transactional
public class LandLordServiceImpl implements LandLordService{

	@Autowired LandLordCustomerMapper landLordCustomerMapper;
	@Autowired LandlordMapper landlordMapper;
	/**根据条件查询入驻的房东**/
	public List<LandlordCustomer> landloadsearch(PageQuery pagequery ,String landlstate) {
		List<LandlordCustomer> list = landLordCustomerMapper.landloadsearch(pagequery ,landlstate);
		return list;
	}
	@Override
	public int landloadsearchCount(String landstate) {
		return landLordCustomerMapper.landloadsearchCount(landstate);
	}
	@Override
	public LandlordCustomer landloadsearchdetail(Long userid) {
		return landLordCustomerMapper.landloadsearchdetail(userid);
	}
	@Override
	public ResultMap checklandstate(Long userid, Integer state) {
		if (userid == null ) {return ResultMap.build(400, "参数错误");}
		if (state < 0 || state > 10) {return ResultMap.build(400, "参数错误");}
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		if (landlord == null) {return ResultMap.build(400, "无房东数据局");}
		landlord.setLandstate(state);
		landlordMapper.updateByPrimaryKeySelective(landlord);
		return ResultMap.build(200, "操作成功");
	}
	

}
