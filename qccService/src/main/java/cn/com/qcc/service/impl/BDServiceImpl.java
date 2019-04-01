package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BdmanagerMapper;
import cn.com.qcc.mapper.BuildinglandlordMapper;
import cn.com.qcc.mapper.InteconnMapper;
import cn.com.qcc.mapper.LandlordManagerMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mymapper.AreaCustomerMapper;
import cn.com.qcc.mymapper.BdCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.BdmanagerExample;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Buildinglandlord;
import cn.com.qcc.pojo.BuildinglandlordExample;
import cn.com.qcc.pojo.Inteconn;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.LandlordManager;
import cn.com.qcc.pojo.LandlordManagerExample;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.UserExample;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.BdManagerCustomer;
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
	@Autowired
	UserMapper userMapper;
	@Autowired
	BdCustomerMapper bdCustomerMapper;
	@Autowired
	AreaCustomerMapper areaCustomerMapper;
	@Autowired
	LandlordManagerMapper landmanagerMapper;
	@Autowired
	VipcountMapper vipcountMapper;
	@Autowired
	InteconnMapper inteconnMapper;
	
	@SuppressWarnings("static-access")
	@Override
	public ResultMap addOrUpdate(Bdmanager bdmanager ) {
		
		if (CheckDataUtil.checkisEmpty(bdmanager.getCode())) {
			bdmanager.setCode("");
		}
		
		// bd账号
		String bdId = "";
		// 登录安全码
		String securitytoken = UUID.randomUUID().toString();
		bdmanager.setSecuritytoken(securitytoken);
		// 网易云token
		String acctoken = "";
		if (CheckDataUtil.checkisEmpty(bdmanager.getRealname())
				) {
			return ResultMap.build(400, "数据不全");
		}
		
		boolean falg = checkUserId(bdmanager.getBdid() , bdmanager.getUserid());
		if (falg ==false) return ResultMap.build(400,"用户存在");
		
		
		User user = userMapper.selectByPrimaryKey(bdmanager.getUserid());
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
				bdmanager.setIsedit(0);
				bdmanager.setUpate_time(new Date());
				bdmanager.setAcctoken(acctoken);
				
				bdmanagerMapper.insertSelective(bdmanager);
				
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						user.getTelephone().toString(), modelId);
				
				
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
			if (CheckDataUtil.checkNotEqual(search.getUserid(), bdmanager.getUserid())) {
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						user.getTelephone().toString(), modelId);
				// 重置登录安全码
				bdmanager.setSecuritytoken(securitytoken);
			}
			bdmanagerMapper.updateByPrimaryKeySelective(bdmanager);
			return ResultMap.build(200, "编辑成功");
		}
	}

	private boolean  checkUserId(String bdid, Long userid) {
		BdmanagerExample example = new BdmanagerExample();
		BdmanagerExample.Criteria criteria = example.createCriteria();
		if (CheckDataUtil.checkisEmpty(bdid)) {
			bdid = "-1";
		}
		criteria.andBdidNotEqualTo(bdid);
		criteria.andUseridEqualTo(userid);
		List<Bdmanager> list = bdmanagerMapper.selectByExample(example);
		return list.size() == 0;
	}

	@Override
	public ResultMap listBD() {
		List<BdManagerCustomer> list = bdCustomerMapper.listBD();
		return ResultMap.IS_200(list);
	}

	@Override
	public ResultMap findOne(String bdid) {
		Map<String, Object> map = new HashMap<>();
		BdManagerCustomer bdmanager =  bdCustomerMapper.findOne(bdid);
		// 构建地址
		String codeIds  = bdmanager.getCode();
		List<Area> level4 = new ArrayList<>();
		List<Area> checklevel = new ArrayList<>();
		List<Area> level3 = new ArrayList<>();
		List<Area> level2 = new ArrayList<>();
		List<Area> level1 = new ArrayList<>();
		Integer level = bdmanager.getLevel();
		String parentId =bdmanager.getCode();
		
		// 判断当前 是最后一级
		if (level == 4) {
			// 查询选中的区域
			checklevel = areaCustomerMapper.searchAreaByCodeIds(codeIds);
			// 获取选中的上级id
			parentId = checklevel.get(0).getParentId().toString();
			//获取所有的上级区域
			level4 = areaCustomerMapper.getAreaByParentId(parentId);
			for (Area level4area : level4) {
				for (Area check : checklevel) {
					if (check.getCode().longValue() == level4area.getCode().longValue()) {
						// 吧level 设置为-1 表示选中
						level4area.setLevel(-1);
					}
				}
			}
			// 吧level 重置为 3 查询下一级
			level = 3 ;
		}
		if (level == 3 ) {
			checklevel = areaCustomerMapper.searchAreaByCodeIds(parentId.toString());
			parentId = checklevel.get(0).getParentId().toString();
			//获取所有的上级区域
			level3 = areaCustomerMapper.getAreaByParentId(parentId);
			for (Area level4area : level3) {
				for (Area check : checklevel) {
					if (check.getCode().longValue() == level4area.getCode().longValue()) {
						// 吧level 设置为-1 表示选中
						level4area.setLevel(-1);
					}
				}
			}
			// 吧level 重置为 3 查询下一级
			level = 2 ;
		}
		
		if (level == 2) {
			checklevel = areaCustomerMapper.searchAreaByCodeIds(parentId.toString());
			parentId = checklevel.get(0).getParentId().toString();
			//获取所有的上级区域
			level2 = areaCustomerMapper.getAreaByParentId(parentId);
			for (Area level4area : level2) {
				for (Area check : checklevel) {
					if (check.getCode().longValue() == level4area.getCode().longValue()) {
						// 吧level 设置为-1 表示选中
						level4area.setLevel(-1);
					}
				}
			}
			// 吧level 重置为 3 查询下一级
			level = 1 ;
		}
		
		
		if (level == 1) {
			checklevel = areaCustomerMapper.searchAreaByCodeIds(parentId.toString());
			if (CheckDataUtil.checkNotEmpty(checklevel)) {
				parentId = checklevel.get(0).getParentId().toString();
			}
			//获取所有的上级区域
			level1 = areaCustomerMapper.getAreaByParentId(parentId);
			for (Area level4area : level1) {
				for (Area check : checklevel) {
					if (check.getCode().longValue() == level4area.getCode().longValue()) {
						// 吧level 设置为-1 表示选中
						level4area.setLevel(-1);
					}
				}
			}
			// 吧level 重置为 3 查询下一级
			level = 0 ;
		}
		
		
		
		map.put("bdmanager", bdmanager);
		map.put("level4", level4);
		map.put("level3", level3);
		map.put("level2", level2);
		map.put("level1", level1);
		return ResultMap.IS_200(map);
	}

	@Override
	public ResultMap changeState(String  bdid) {
		// 重置token
		String  securitytoken = UUID.randomUUID().toString();
		Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdid);
		if (CheckDataUtil.checkNotEmpty(search)) {
			search.setSecuritytoken(securitytoken);
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
	public BdManagerCustomer searchBDByPhoneOrId(String account) {
		return bdCustomerMapper.searchBDByPhoneOrId(account);
	}

	@Override
	public ResultMap changePassword(Long telephone, String BD_ACCTOKEN, String password) {
		Bdmanager bdmanager = getBdidByToken(BD_ACCTOKEN);
		
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| CheckDataUtil.checkNotEqual(telephone, telephone)
				|| CheckDataUtil.checkisEmpty(password)) {
			return ResultMap.build(400, "操作失败");
		}
		password = IDUtils.getprivatePassword(password);
		bdmanager.setPassword(password);
		
		// 重置登录安全码
		String securitytoken = UUID.randomUUID().toString();
		bdmanager.setSecuritytoken(securitytoken);
		bdmanagerMapper.updateByPrimaryKeySelective(bdmanager);
		return ResultMap.build(200, "修改成功");
	}

	@Override
	public List<UserRoomCustomer> searchUserToLand(String searchWhere) {
		return bdCustomerMapper.searchUserToLand(searchWhere);
	}

	@Override
	public ResultMap addLand(String BD_ACCTOKEN, Landlord landlord , Long userid ,
			String uname , String uphone) {
		
		if (CheckDataUtil.checkisEmpty(userid)) {
			ResultMap resultMap = createUser(uname ,uphone);
			if (resultMap.getCode() !=200) {
				return resultMap;
			} else {
				userid = Long.valueOf( resultMap.getObj().toString() ) ;
			}
		}
		
		if (CheckDataUtil.checkisEmpty(landlord.getAddress())
				|| CheckDataUtil.checkisEmpty(landlord.getCode())) {
			return ResultMap.build(400, "选择区域");
		}
		
		/*UserCustomer user = userCustomerMapper.searchUserSign(userid);
		if (CheckDataUtil.checkisEmpty(user)
				|| user.getSignstate() != 2) {
			return ResultMap.build(400, "未实名用户");
		}*/
		
		// 校验bd是否正常
		Bdmanager bdmanager = getBdidByToken(BD_ACCTOKEN);
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| bdmanager.getState() == 0) {
			return ResultMap.build(400, "异常的BD账号");
		}
		
		//判断是否是管理员
		LandlordManagerExample example = new LandlordManagerExample();
		LandlordManagerExample.Criteria criteria = example.createCriteria();
		criteria.andManageruseridEqualTo(userid);
		criteria.andStateEqualTo(2);
		List<LandlordManager> selectByExample = landmanagerMapper.selectByExample(example);
		if (CheckDataUtil.checkNotEmpty(selectByExample)) {
			return ResultMap.build(400, "该用户是管理管理员不可添加");
		}
		
		// 这里需要通知房东
		User landDetail = userMapper.selectByPrimaryKey(userid);
		String content ="";
		//bdmanager.getRealname() +"," + bdmanager.getTelephone();
		String phone = landDetail.getTelephone().toString();
		String modelId = WangYiCommon.BD_ADD_LAND_NOTIC;
		// 判断是否有房东数据
		Landlord searchlandlord = landlordMapper.selectByPrimaryKey(userid);
		if (CheckDataUtil.checkNotEmpty(searchlandlord)) {
			String oldBdid = searchlandlord.getBdid();
			
			if (CheckDataUtil.checkNotEmpty(oldBdid)) {
				if (CheckDataUtil.checkNotEqual(oldBdid, bdmanager.getBdid())) {
					return ResultMap.build(400, "该房东的BD:" + oldBdid);
				}
			}
			
			landlord.setLanduserid(userid);
			landlord.setLandstate(2);
			landlord.setBdid(bdmanager.getBdid());
			landlord.setUpdate_time(new Date());
			landlordMapper.updateByPrimaryKeySelective(landlord);
		
			return ResultMap.build(200, "编辑成功" , landlord );
		}
		landlord.setLanduserid(userid);
		landlord.setLandstate(2);
		landlord.setBdid(bdmanager.getBdid());
		landlord.setUpdate_time(new Date());
		landlordMapper.insertSelective(landlord);
		SendMessage.sendNoticMess(content, phone, modelId);
		return ResultMap.build(200, "添加成功" , landlord );
	}

	@SuppressWarnings("static-access")
	private ResultMap createUser(String uname, String uphone) {
		
		// 先校验电话号码
		if (CheckDataUtil.checkisEmpty(uname)
				|| CheckDataUtil.checkisEmpty(uphone)) {
			return ResultMap.build(400, "输入电话或者姓名");
		}
		Long telephone = null;
		
		try {
			// 校验电话号码
			uphone = uphone.replace(" ", "");
			if (CheckDataUtil.checkNotEqual(uphone.length(), 11)) {
				return ResultMap.build(400,"电话号码长度不对");
			}
			telephone = Long.valueOf(uphone);
		} catch (Exception e) {
		}
		
		if (CheckDataUtil.checkisEmpty(telephone)) {
			return ResultMap.build(400, "电话号码格式错误");
		}
		
		// 校验电话号码是否注册过
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		List<User> user = userMapper.selectByExample(example);
		if (user.size() > 0 && !user.isEmpty()) {
			return ResultMap.IS_200(user.get(0).getUserid());
		}
		// 说明用户没有注册 -- 走注册流程 ---
		User inUserData = new User();
		UUID uuid = UUID.randomUUID();
		inUserData.setCreate_time(new Date());
		inUserData.setUpdate_time(new Date());
		inUserData.setPassword("4d76087378d5f71bd9f994668e342e92e7894d80");
		inUserData.setUsertype("0");
		inUserData.setAccestoken(String.valueOf(uuid));
		inUserData.setUserstatus("1");
		inUserData.setLatitude(22.0);
		inUserData.setLongitude(114.0);
		inUserData.setTelephone(telephone);
		userMapper.insertSelective(inUserData);
		
		
		Profile profile = new Profile();
		profile.setCreate_time(new Date());
		profile.setSign_time(new Date());
		profile.setCode(4403L);
		profile.setSignstate(1);
		profile.setUser_name(uname);
		profile.setReal_name(uname);
		profile.setUser_id(inUserData.getUserid());
		profile.setAvatar("http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
		profile.setSex("未知");
		profileMapper.insertSelective(profile);
		
		
		// 新用户赠送200次求租次数
		Vipcount vipcount = new Vipcount();
		vipcount.setUser_id(inUserData.getUserid());
		vipcount.setBalance(0.0D);
		vipcount.setHouseaccount(0.0);
		vipcount.setCount(200);
		vipcount.setCretime_time(new Date());
		vipcount.setIs_vip(0);
		vipcount.setAccount(0.0D);
		vipcountMapper.insertSelective(vipcount);
		// 新用户赠送50个金币
		Inteconn inteconn = new Inteconn();
		inteconn.setUserid(inUserData.getUserid());
		inteconn.setCount(50L);
		inteconn.setUpdate_time(new Date());
		inteconn.setGrand(1);
		inteconnMapper.insertSelective(inteconn);
		
		
		try {
			Map<String, Object> returnmap = WangYiUtil.getACCIDANDTOKEN(inUserData.getUserid(), "qcc_" + uname,
					profile.getAvatar());
			if (returnmap.get("code").equals(200)) {
				String ssobj = returnmap.get("info").toString();
				net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(ssobj);
				WangYiPoJo wpojo = (WangYiPoJo) jsonobj.toBean(jsonobj, WangYiPoJo.class);
				String acctoken = wpojo.getToken();
				inUserData.setAcctoken(acctoken);
				userMapper.updateByPrimaryKeySelective(inUserData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ResultMap.IS_200(inUserData.getUserid());
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
		
		List<UserRoomCustomer> landList = bdCustomerMapper.getLandList(search);
		return landList;
	}

	/// 查询想要添加的楼栋
	public List<BuildingCustomer> searchAddBuildingToland(String searchWhere , Long code , Long villageid) {
		return bdCustomerMapper.searchAddBuildingToland(searchWhere , code ,villageid);
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

	@Override
	public ResultMap deleteBuildingland(Long userid, Long buildingid) {
		
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(buildingid)) {
			return ResultMap.build(400, "删除失败");
		}
		
		
		BuildinglandlordExample example = new BuildinglandlordExample();
		BuildinglandlordExample.Criteria criteria = example.createCriteria();
		criteria.andBuildingidEqualTo(buildingid);
		criteria.andLandlordidEqualTo(userid);
		buildinglandlordMapper.deleteByExample(example);
		
		return ResultMap.build(200, "删除成功");
	}

	@Override
	public List<BuildingCustomer> searchBuildingBylandId(Long userid) {
		// TODO Auto-generated method stub
		List<BuildingCustomer> list =  bdCustomerMapper.searchBuildingBylandId(userid);
		if (CheckDataUtil.checkisEmpty(list)) {
			list = new ArrayList<>();
		}
		
		return list ;
	}

    // 编辑的查询
	public UserRoomCustomer bdlandeditsearch(Long userid) {
		return bdCustomerMapper.bdlandeditsearch(userid);
	}

	@Override
	public ResultMap removeland(Long userid) {
		Landlord search = landlordMapper.selectByPrimaryKey(userid);
		search.setBdid("");
		landlordMapper.updateByPrimaryKeySelective(search);
		return ResultMap.IS_200();
	}

	@Override
	public ResultMap editAvatar(String bD_ACCTOKEN, String avatar) {
		// TODO Auto-generated method stub
		Bdmanager bdidByToken = getBdidByToken(bD_ACCTOKEN);
		if (CheckDataUtil.checkisEmpty(bdidByToken)) {
			return ResultMap.build(400, "未知用户");
		}
		bdidByToken.setAvatar(avatar);
		bdmanagerMapper.updateByPrimaryKeySelective(bdidByToken);
		return ResultMap.build(200, "编辑成功") ;
	}

	@Override
	public ResultMap changeEditstate(String bdid) {
		// 重置token
		String  securitytoken = UUID.randomUUID().toString();
		Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdid);
		if (CheckDataUtil.checkNotEmpty(search)) {
			search.setSecuritytoken(securitytoken);
			if (search.getIsedit() == 1) {
				search.setIsedit(0);
			}else {
				search.setIsedit(1);
			}
			bdmanagerMapper.updateByPrimaryKeySelective(search);
		}
		return ResultMap.IS_200();
	}

	@Override
	public int searchAddBDCount(String searchWhere) {
		// TODO Auto-generated method stub
		return bdCustomerMapper.searchAddBDCount(searchWhere);
	}
	@Override
	public List<UserCustomer> searchAddBD(String searchWhere, PageQuery pagequery) {
		// TODO Auto-generated method stub
		return bdCustomerMapper.searchAddBD(searchWhere , pagequery);
	}

	@Override
	public List<Brand> searchEditBrandList(String code, String searchWhere, PageQuery pagequery) {
		// TODO Auto-generated method stub
		return bdCustomerMapper.searchEditBrandList(code ,searchWhere , pagequery);
	}

	@Override
	public int searchEditBrandListCount(String code, String searchWhere) {
		// TODO Auto-generated method stub
		return  bdCustomerMapper.searchEditBrandListCount(code ,searchWhere );
	}

}
