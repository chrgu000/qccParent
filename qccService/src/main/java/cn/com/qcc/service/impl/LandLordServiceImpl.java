package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.LandlordManagerMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mymapper.LandLordCustomerMapper;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.LandlordManager;
import cn.com.qcc.pojo.LandlordManagerExample;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.UserExample;
import cn.com.qcc.queryvo.LandlordCustomer;
import cn.com.qcc.service.LandLordService;
@Service
@Transactional
public class LandLordServiceImpl implements LandLordService{

	@Autowired LandLordCustomerMapper landLordCustomerMapper;
	@Autowired LandlordMapper landlordMapper;
	@Autowired UserMapper userMapper;
	@Autowired LandlordManagerMapper landlordManagerMapper;
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
	
	
	/**校验管理员的状态**/
	public Long checkManagerByPhone(Long telephone) {

		// 1 第一步校验用户是否存在
		UserExample userexample = new UserExample();
		UserExample.Criteria usercriteria = userexample.createCriteria();
		usercriteria.andTelephoneEqualTo(telephone);
		List<User> userList =  userMapper.selectByExample(userexample);
		if (CheckDataUtil.checkisEmpty(userList)) {
			return null ;
		}
		Long userid = userList.get(0).getUserid();
		// 2 校验房东状态
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		// 如果是正常的房东用户返回false
		if (CheckDataUtil.checkNotEmpty(landlord)
				&& CheckDataUtil.checkisEqual(landlord.getLandstate(), 2)) {
			return null ;
		}
		
		// 3-第三步校验是否有管理员绑定信息
		LandlordManagerExample managerExample = new LandlordManagerExample();
		LandlordManagerExample.Criteria criteria = managerExample.createCriteria();
		criteria.andManageruseridEqualTo(userid);
		criteria.andStateEqualTo(2);
		List<LandlordManager> mangagers = landlordManagerMapper.selectByExample(managerExample);
		if (CheckDataUtil.checkNotEmpty(mangagers)) {
			return null ; 
		}
		return userid;
	}
	@Override
	public void landAddManager(Long landlordUserid, Long managerUserid) {
		LandlordManager addManager = new LandlordManager();
		addManager.setCreate_time(new Date());
		addManager.setAccessurlid("");
		addManager.setLanduserid(landlordUserid);
		addManager.setManageruserid(managerUserid);
		addManager.setState(2);//2 正常绑定关系
		addManager.setUpdate_time(new Date());
		landlordManagerMapper.insertSelective(addManager);
	}
	public List<LandlordCustomer> listManager(Long userid) {
		return landLordCustomerMapper.listManager(userid);
	}
	
	
	
	public ResultMap deleteManager(Long landUserid, Long managerUserid) {
		
		if (CheckDataUtil.checkisEmpty(landUserid)
				|| CheckDataUtil.checkisEmpty(managerUserid )) {
			return ResultMap.build(400, "数据不完整");
		}
		try {
			LandlordManagerExample example= new LandlordManagerExample();
			LandlordManagerExample.Criteria criteria = example.createCriteria();
			criteria.andLanduseridEqualTo(landUserid);
			criteria.andManageruseridEqualTo(managerUserid);
			landlordManagerMapper.deleteByExample(example);
			return ResultMap.build(200, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(200, "删除失败");
		}
	}

}
