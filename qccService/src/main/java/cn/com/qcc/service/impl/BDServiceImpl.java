package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WangYiUtil.WangYiCommon;
import WangYiUtil.WangYiPoJo;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BdmanagerMapper;
import cn.com.qcc.mapper.BuildinglandlordMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.BdmanagerExample;
import cn.com.qcc.pojo.Buildinglandlord;
import cn.com.qcc.pojo.BuildinglandlordExample;
import cn.com.qcc.pojo.BuildinglandlordExample.Criteria;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.queryvo.BuildingCustomer;
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
	@Autowired
	BuildinglandlordMapper buildinglandlordMapper;
	
	@SuppressWarnings("static-access")
	@Override
	public ResultMap addOrUpdate(Bdmanager bdmanager) {
		
		// bd账号
		String bdId = "";
		// 登录安全码
		String securitytoken = UUID.randomUUID().toString();
		// 网易云token
		String acctoken = "";
		if (CheckDataUtil.checkisEmpty(bdmanager.getRealname())
				|| CheckDataUtil.checkisEmpty(bdmanager.getTelephone())) {
			return ResultMap.build(400, "数据不全");
		}
		
		boolean falg = checkPhone(bdmanager.getBdid() , bdmanager.getTelephone());
		if (falg ==false) return ResultMap.build(400,"电话号码占用");
		
		
		
		// 新建账号
		if (CheckDataUtil.checkisEmpty(bdmanager.getBdid())) {
			try {
				
				bdId = jedisClient.get(RedisUtil.BD_INSERT_ID);
				if (CheckDataUtil.checkisEmpty(bdId)) {
					bdId = "10001";
					jedisClient.set(RedisUtil.BD_INSERT_ID, bdId);
				}
				jedisClient.incr(RedisUtil.BD_INSERT_ID);
				bdmanager.setBdid("qbd" + bdId);
				String avatar = "http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387";
				bdmanager.setAvatar(avatar);
				//生成网易的token
				Map<String, Object> returnmap = WangYiUtil.getACCIDANDTOKEN(bdmanager.getBdid(), "qcc_" + bdmanager.getBdid(),
						avatar);
				if (returnmap.get("code").equals(200)) {
					String ssobj = returnmap.get("info").toString();
					net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(ssobj);
					WangYiPoJo wpojo = (WangYiPoJo) jsonobj.toBean(jsonobj, WangYiPoJo.class);
					acctoken = wpojo.getToken();
				}
				
				if (CheckDataUtil.checkisEmpty(acctoken)) {
					return ResultMap.build(400, "操作失败");
				}
				
				bdmanager.setState(1);
				bdmanager.setPassword("");
			
				bdmanager.setUpate_time(new Date());
				bdmanager.setAcctoken(acctoken);
				bdmanager.setSecuritytoken(securitytoken);
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
			// 判断电话号码是否变更
			bdId = bdmanager.getBdid();
			Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdmanager.getBdid());
			//如果电话号码不一致
			if (CheckDataUtil.checkNotEqual(search.getTelephone(), bdmanager.getTelephone())) {
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						bdmanager.getTelephone(), modelId);
				// 重置登录安全码
				bdmanager.setSecuritytoken(securitytoken);
			}
			bdmanagerMapper.updateByPrimaryKeySelective(bdmanager);
			return ResultMap.build(200, "编辑成功");
		}
	}

	private boolean  checkPhone(String bdid, String telephone) {
		BdmanagerExample example = new BdmanagerExample();
		BdmanagerExample.Criteria criteria = example.createCriteria();
		if (CheckDataUtil.checkisEmpty(bdid)) {
			bdid = "-1";
		}
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
	public ResultMap changePassword(Long telephone, String BD_ACCTOKEN, String password) {
		Bdmanager bdmanager = getBdidByToken(BD_ACCTOKEN);
		
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
	public ResultMap addLand(String BD_ACCTOKEN, Long userid , String address ,Long code) {
		
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
		Bdmanager bdmanager = getBdidByToken(BD_ACCTOKEN);
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| bdmanager.getState() == 0) {
			return ResultMap.build(400, "异常的BD账号");
		}
		
		// 判断是否有房东数据
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		if (CheckDataUtil.checkNotEmpty(landlord)) {
			if (landlord.getLandstate() == 2) {return ResultMap.build(400, "已经是房东");}
			landlord.setLandstate(2);
			landlord.setBdid(bdmanager.getBdid());
			landlord.setLandaddress(address);
			landlord.setCode(code);
			landlordMapper.updateByPrimaryKeySelective(landlord);
			return ResultMap.build(200, "添加成功");
		}
		
		landlord = new Landlord();
		landlord.setBdid(bdmanager.getBdid());
		landlord.setLandaddress(address);
		landlord.setCode(code);
		landlord.setLanduserid(userid);
		landlord.setUpdate_time(new Date());
		landlordMapper.insertSelective(landlord);
		return ResultMap.build(200, "添加成功");
	}

	@Override
	public Bdmanager getBdidByToken(String BD_ACCTOKEN) {
		if (CheckDataUtil.checkisEmpty(BD_ACCTOKEN)) {
			return null;
		}
		BdmanagerExample example = new BdmanagerExample();
		BdmanagerExample.Criteria criteria = example.createCriteria();
		criteria.andSecuritytokenEqualTo(BD_ACCTOKEN);
		List<Bdmanager> list = bdmanagerMapper.selectByExample(example);
		
		if (CheckDataUtil.checkisEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	// BD 查询我的房东
	public List<UserRoomCustomer> myLand(String BD_ACCTOKEN , Long code ) {
		Bdmanager bdmanager = getBdidByToken(BD_ACCTOKEN);
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| CheckDataUtil.checkisEmpty(bdmanager.getBdid())
				|| CheckDataUtil.checkNotEqual(bdmanager.getState(), 1)) {
			return new ArrayList<>();
		}
		
		UserRoomCustomer search = new UserRoomCustomer();
		search.setBdid(bdmanager.getBdid());
		
		if (CheckDataUtil.checkNotEmpty(code)) {
			search.setCode(code);
		}
		
		List<UserRoomCustomer> landList = bdmanagerMapper.getLandList(search);
		return landList;
	}

	/// 查询想要添加的楼栋
	public List<BuildingCustomer> searchAddBuildingToland(String searchWhere) {
		return bdmanagerMapper.searchAddBuildingToland(searchWhere);
	}

	// 给房东绑定楼栋。
	public ResultMap addBuildingToland(Long userid, Long buildingid) {
		
		
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(buildingid)) {
			return ResultMap.build(400, "数据不全");
		}
		
		// 校验房东
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		if (CheckDataUtil.checkisEmpty(landlord)
				|| landlord.getLandstate() !=2) {
			return ResultMap.build(400, "非房东用户");
		}
		
		// 校验楼栋
		BuildinglandlordExample example = new BuildinglandlordExample();
		BuildinglandlordExample.Criteria criteria = example.createCriteria();
		criteria.andBuildingidEqualTo(buildingid);
		List<Buildinglandlord> list = buildinglandlordMapper.selectByExample(example);
		
		if (CheckDataUtil.checkNotEmpty(list)) {
			return ResultMap.build(400, "该楼栋已经绑定");
		}
		
		Buildinglandlord insert = new Buildinglandlord();
		insert.setBuildingid(buildingid);
		insert.setLandlordid(userid);
		buildinglandlordMapper.insertSelective(insert);
		
		return ResultMap.build(200,"操作成功");
	}

}
