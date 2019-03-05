package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BdmanagerMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.BdmanagerExample;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserRoomCustomer;
import cn.com.qcc.service.BDService;

@Service
public class BDServiceImpl implements BDService{
	
	@Autowired
	BdmanagerMapper bdmanagerMapper;
	@Autowired 
	JedisClient jedisClient;
	@Autowired
	ProfileMapper profileMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	LandlordMapper landlordMapper;

	@Override
	public ResultMap addOrUpdate(Bdmanager bdmanager) {
		
		String bdId = "";
		String acctoken = UUID.randomUUID().toString();
		if (CheckDataUtil.checkisEmpty(bdmanager.getRealname())
				|| CheckDataUtil.checkisEmpty(bdmanager.getTelephone())) {
			return ResultMap.build(400, "数据不全");
		}
		if (CheckDataUtil.checkisEmpty(bdmanager.getBdid())) {
			bdId = jedisClient.get(RedisUtil.BD_INSERT_ID);
			if (CheckDataUtil.checkisEmpty(bdId)) {
				bdId = "10001";
				jedisClient.set(RedisUtil.BD_INSERT_ID, bdId);
			}
			jedisClient.incr(RedisUtil.BD_INSERT_ID);
			bdmanager.setState(1);
			bdmanager.setPassword("");
			bdmanager.setBdid("qbd" + bdId);
			bdmanager.setUpate_time(new Date());
			bdmanager.setAcctoken(acctoken);
			try {
				
				boolean falg = checkPhone(bdmanager.getBdid() , bdmanager.getTelephone());
				if (falg ==false) return ResultMap.build(400,"电话号码占用");
				bdmanagerMapper.insertSelective(bdmanager);
				
				
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						bdmanager.getTelephone(), modelId);
				
				
				return ResultMap.build(200, "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMap.build(400, "失败,账号重复");
			}
		} else {
			boolean falg = checkPhone(bdmanager.getBdid() , bdmanager.getTelephone());
			if (falg ==false) return ResultMap.build(400,"电话号码占用");
			
			// 判断电话号码是否变更
			bdId = bdmanager.getBdid();
			Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdmanager.getBdid());
			
			//如果电话号码不一致
			if (CheckDataUtil.checkNotEqual(search.getTelephone(), bdmanager.getTelephone())) {
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						bdmanager.getTelephone(), modelId);
				
				
			}
			
			
			bdmanager.setAcctoken(acctoken);
			bdmanagerMapper.updateByPrimaryKeySelective(bdmanager);
			return ResultMap.build(200, "编辑成功");
		}
	}

	private boolean  checkPhone(String bdid, String telephone) {
		BdmanagerExample example = new BdmanagerExample();
		BdmanagerExample.Criteria criteria = example.createCriteria();
		criteria.andBdidNotEqualTo(bdid);
		criteria.andTelephoneEqualTo(telephone);
		List<Bdmanager> list = bdmanagerMapper.selectByExample(example);
		return list.size() == 0;
	}

	@Override
	public ResultMap listBD() {
		List<Bdmanager> list = bdmanagerMapper.selectByExample(null);
		return ResultMap.IS_200(list);
	}

	@Override
	public ResultMap findOne(String bdid) {
		// TODO Auto-generated method stub
		Bdmanager bdmanager =  bdmanagerMapper.selectByPrimaryKey(bdid);
		return ResultMap.IS_200(bdmanager);
	}

	@Override
	public ResultMap changeState(String  bdid) {
		Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdid);
		if (CheckDataUtil.checkNotEmpty(search)) {
			if (search.getState() == 1) {
				search.setState(0);
			}else {
				search.setState(1);
			}
			bdmanagerMapper.updateByPrimaryKeySelective(search);
		}
		return ResultMap.IS_200();
	}

	@Override
	public Bdmanager searchBDByPhoneOrId(String account) {
		// TODO Auto-generated method stub
		return bdmanagerMapper.searchBDByPhoneOrId(account);
	}

	@Override
	public ResultMap changePassword(Long telephone, String bdid, String password) {
		Bdmanager bdmanager = bdmanagerMapper.selectByPrimaryKey(bdid);
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| CheckDataUtil.checkNotEqual(telephone, bdmanager.getTelephone())
				|| CheckDataUtil.checkisEmpty(password)) {
			return ResultMap.build(400, "操作失败");
		}
		password = IDUtils.getprivatePassword(password);
		bdmanager.setPassword(password);
		bdmanagerMapper.updateByPrimaryKeySelective(bdmanager);
		return ResultMap.build(200, "修改成功");
	}

	@Override
	public List<UserRoomCustomer> searchUserToLand(String searchWhere) {
		return bdmanagerMapper.searchUserToLand(searchWhere);
	}

	@Override
	public ResultMap addLand(String bdid, Long userid , String address ,Long code) {
		
		if (CheckDataUtil.checkisEmpty(address)
				|| CheckDataUtil.checkisEmpty(code)) {
			return ResultMap.build(400, "选择区域");
		}
		
		UserCustomer user = userCustomerMapper.searchUserSign(userid);
		if (CheckDataUtil.checkisEmpty(user)
				|| user.getSignstate() != 2) {
			return ResultMap.build(400, "未实名用户");
		}
		
		// 校验bd是否正常
		Bdmanager bdmanager = bdmanagerMapper.selectByPrimaryKey(bdid);
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| bdmanager.getState() == 0) {
			return ResultMap.build(400, "异常的BD账号");
		}
		
		// 判断是否有房东数据
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		if (CheckDataUtil.checkNotEmpty(landlord)) {
			if (landlord.getLandstate() == 2) {return ResultMap.build(400, "已经是房东");}
			landlord.setLandstate(2);
			landlord.setBdid(bdid);
			landlord.setLandaddress(address);
			landlord.setCode(code);
			landlordMapper.updateByPrimaryKeySelective(landlord);
			return ResultMap.build(200, "添加成功");
		}
		
		landlord = new Landlord();
		landlord.setBdid(bdid);
		landlord.setLandaddress(address);
		landlord.setCode(code);
		landlord.setUpdate_time(new Date());
		landlordMapper.insertSelective(landlord);
		return ResultMap.build(200, "添加成功");
	}

	@Override
	public ResultMap getBdidByToken(String bD_ACCTOKEN) {
		if (CheckDataUtil.checkisEmpty(bD_ACCTOKEN)) {
			return ResultMap.build(400,"少参数");
		}
		
		BdmanagerExample example = new BdmanagerExample();
		BdmanagerExample.Criteria criteria = example.createCriteria();
		criteria.andAcctokenEqualTo(bD_ACCTOKEN);
		List<Bdmanager> list = bdmanagerMapper.selectByExample(example);
		
		if (CheckDataUtil.checkisEmpty(list)) {
			return ResultMap.build(400, "");
		}
		return ResultMap.IS_200(list.get(0).getBdid());
	}

}
