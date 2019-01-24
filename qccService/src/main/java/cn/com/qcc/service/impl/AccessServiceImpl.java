package cn.com.qcc.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.common.SimpleUpload;
import cn.com.qcc.common.WaterMarkUtils;
import cn.com.qcc.detailcommon.AccountMgr;
import cn.com.qcc.mapper.AccessMapper;
import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.ArticletypeMapper;
import cn.com.qcc.mapper.BrandMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.CommoninteMapper;
import cn.com.qcc.mapper.HistoryexcleMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.ManageUserMapper;
import cn.com.qcc.mapper.PercentMapper;
import cn.com.qcc.mapper.PercenttypeMapper;
import cn.com.qcc.mapper.PlatformMapper;
import cn.com.qcc.mapper.RoleAccessMapper;
import cn.com.qcc.mapper.RoleMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mapper.UserRoleMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mymapper.SystemConfigMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.AccessExample;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.BuildingExample;
import cn.com.qcc.pojo.Commoninte;
import cn.com.qcc.pojo.Historyexcle;
import cn.com.qcc.pojo.ManageUser;
import cn.com.qcc.pojo.ManageUserExample;
import cn.com.qcc.pojo.Percent;
import cn.com.qcc.pojo.PercentExample;
import cn.com.qcc.pojo.Percenttype;
import cn.com.qcc.pojo.Platform;
import cn.com.qcc.pojo.Role;
import cn.com.qcc.pojo.RoleAccess;
import cn.com.qcc.pojo.RoleExample;
import cn.com.qcc.pojo.Systemstate;
import cn.com.qcc.pojo.UserRole;
import cn.com.qcc.pojo.UserRoleExample;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.service.AccessService;
@Service
public class AccessServiceImpl implements AccessService {
	@Autowired SystemstateMapper systemstateMapper;
	@Autowired AccessMapper accessMapper;
	@Autowired RoleMapper roleMapper;
	@Autowired RoleAccessMapper roleAccessMapper;
	@Autowired UserCustomerMapper userCustomerMapper;
	@Autowired UserRoleMapper userRoleMapper;
	@Autowired ManageUserMapper manageUserMapper;
	@Autowired HistoryexcleMapper historyexcleMapper;
	@Autowired PlatformMapper platformMapper;
	@Autowired CommoninteMapper commoninteMapper;
	@Autowired SystemConfigMapper systemConfigMapper;
	@Autowired PercenttypeMapper percenttypeMapper;
	@Autowired PercentMapper percentMapper;
	@Autowired ArticledetailMapper articledetailMapper;
	@Autowired ArticletypeMapper articletypeMapper;
	@Autowired BrandMapper brandMapper;
	@Autowired BuildingMapper buildingMapper;
	@Autowired LandlordMapper landlordMapper;
	@Autowired HouseMapper houseMapper;
	@Autowired VillageMapper villageMapper;
	@Autowired HttpServletRequest request;
	/**获取所有权限的集合
	 * @param currentpage : 分页参数当前页面
	 * @param pagesize    : 每页查询的数量
	 * @param userVo      : 主要封装分页参数
	 * **/
	public List<Access> getallaccess(UserVo userVo) {
		List<Access> acc = userCustomerMapper.getallaccess(userVo);
		return acc;
	}
	
	/**获取所有权限的集合COUNT
	 * **/
	public int getallaccessCount(UserVo userVo) {
		int acc = userCustomerMapper.getallaccessCount(userVo);
		return acc;
	}
	
	/**  新增或者编辑权限 当权限ID存在时候 为编辑操作
	 *   @param  access.Accessname :权限的名称
	 *   @param  access.Accessurl  :权限的链接
	 *   @param  access.Accessid   :权限对应的ID
	 * **/
	public ResultMap inserorupdateaccess(Access access) {
		if (access.getAccessname() ==null || "".equals(access.getAccessname())) {
			return ResultMap.build(600,"权限名称不能空");
		}
		if (access.getAccessurl() == null || "".equals(access.getAccessurl())) {
			return ResultMap.build(601, "权限链接不能空");
		}
		
		if (access.getAccessid() !=null){
			accessMapper.updateByPrimaryKeySelective(access);
			return ResultMap.build(200, "更新成功");
		}else {
			Access access_name = CheckAccessName(access);
			if (access_name!=null) {
				return ResultMap.build(602, "该权限存在");
			}
			Access access_url = CheckAccessURL(access);
			if (access_url!=null) {
				return ResultMap.build(602, "该权限存在");
			}
			accessMapper.insertSelective(access);
			return ResultMap.build(200,"操作成功");
		}
		
	}
	
	// 校验权限名称是否存在
	private Access CheckAccessName(Access access) {
		AccessExample example = new AccessExample();
		AccessExample.Criteria criteria = example.createCriteria();
		criteria.andAccessnameEqualTo(access.getAccessname());
		List<Access> accesses = accessMapper.selectByExample(example);
		if (!accesses.isEmpty() && accesses.size()>0) {
			return accesses.get(0);
		}
		return null;
	}
	// 校验权限URL是否存在
	private Access CheckAccessURL(Access access) {
		AccessExample example = new AccessExample();
		AccessExample.Criteria criteria = example.createCriteria();
		criteria.andAccessurlEqualTo(access.getAccessurl());
		List<Access> accesses = accessMapper.selectByExample(example);
		if (!accesses.isEmpty() && accesses.size()>0) {
			return accesses.get(0);
		}
		return null;
	}
	
	
	/** 
	 *  查询所有角色。以及当前角色下面对应的权限
	 * **/
	public ResultMap roletoaccess() {
		List<Role> roles = roleMapper.selectByExample(null);
		for (Role role : roles) {
			String Str = "";
			String accid = "";
			List<Access> acc = getaccessnames(role.getRoleid());
			if (!acc.isEmpty() && acc.size()>0) {
				for (Access accs : acc) {
					Str+= accs.getAccessname()+",";
					accid += accs.getAccessid()+",";
				}
			}
			role.setRole_accid(accid);
			role.setRole_access(Str);
		}
		return ResultMap.IS_200(roles);
	}
	
	// 根据角色ID 获取权限集合
	private List<Access> getaccessnames(Long roleid) {
		List<Access> accesses = accessMapper.getrole_access(roleid);
		return accesses;
	}


	/**
	 * 获取所有的 角色对应 的权限 【在角色范围内】
	 * @param role_accid : 角色 对应的权限
	 * **/
	public List<Access> isinrole(String[] str) {
		// TODO Auto-generated method stub
		return accessMapper.isinrole(str);
	}
	
	
	/**
	 * 获取所有的 角色对应 的权限 【不在角色范围内】
	 * @param role_accid : 角色 对应的权限
	 * **/
	public List<Access> isnotrole(String[] str) {
		// TODO Auto-generated method stub
		return accessMapper.isnotrole(str);
	}

	/** 创建或者编辑 / 角色
	 * @param rolename : 角色名称
	 * **/
	public ResultMap inserorupdaterole(Role role) {
		if (role.getRolename() == null || "".equals(role.getRolename())) {
			return ResultMap.build(603,  "角色名称不能空");
		}
		Role CHECK = CheckRole(role);
		if (CHECK!=null) {
			return ResultMap.build(604, "角色存在");
		}
		if (role.getRoleid() !=null) {
			roleMapper.updateByPrimaryKeySelective(role);
			return ResultMap.build(200,  "更新成功");
		}
		roleMapper.insertSelective(role);
		//角色权限控制表需要插入数据
		RoleAccess in = new RoleAccess();
		in.setAccessid(1L);
		in.setRoleid(role.getRoleid());
		roleAccessMapper.insertSelective(in);
		return ResultMap.build(200,  "操作成功");
	}
	
	// 校验角色名称是否存在
	private Role CheckRole(Role role) {
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andRolenameEqualTo(role.getRolename());
		List<Role> ro_le = roleMapper.selectByExample(example);
		if (!ro_le.isEmpty() && ro_le.size()>0) {
			return ro_le.get(0);
		}
		return null;
	}

	/*** 修改角色对应的权限
	 * @param role_accid : 角色对应权限ID
	 * @param roleid  : 当前角色ID
	 * **/
	public ResultMap changge_access(Role role) {
		if (role.getRole_accid() == null ||"".equals(role.getRole_accid())) {
			return ResultMap.build(605,  "选择权限");
		}
		String [] ids = role.getRole_accid().split(",");
		//先删掉已经存在的权限
		accessMapper.deletebyroleid(role);
		for (int i = 0;i<ids.length;i++) {
			RoleAccess acc = new RoleAccess();
			acc.setRoleid(role.getRoleid());
			acc.setAccessid(Long.valueOf(ids[i]));
			roleAccessMapper.insertSelective(acc);
		}
		return ResultMap.build(200,  "操作成功");
	}


	/**查询所有的用户角色关系
	 * **/
	public List<UserCustomer> getalluser_role(UserVo user) {
		List<UserCustomer> userlist = userCustomerMapper.getalluser_role(user);
		return userlist;
	}
	/**查询所有的用户角色关系
	 * **/
	public int getalluser_roleCount(UserVo user) {
		int count = userCustomerMapper.getalluser_roleCount(user);
		return count;
	}


	/** 查询 用户对应 的角色
	 * @param rolename : 角色名称
	 * @param telephonoe : 电话号码
	 * **/
	public List<UserCustomer> getallmanager_user(UserVo userVo) {
		List<UserCustomer> userlist = userCustomerMapper.getallmanager_user(userVo);
		return userlist;
	}


	/**
	 * 角色对应权限
	 * **/
	public ResultMap rolenotinuser(Role role) {
		List<Role> roles = roleMapper.rolenotinuser(role);
		return ResultMap.IS_200(roles);
	}

	/***
	 *  改变用户对应的角色
	 *  @param userid : 用户id
	 *  @param roleid : 角色ID
	 * **/
	public ResultMap changgeuserrole(UserRole userRole) {
		if (userRole.getUserid() == null) {
			return null;
		}
		if (userRole.getRoleid() == null ) {
			return null;
		}
		UserRole check = CheckUserRole(userRole);
		if (check == null) {
			userRoleMapper.insertSelective(userRole);
			return ResultMap.IS_200();
		}
		else {
			check.setRoleid(userRole.getRoleid());
			roleMapper.updateuserrolebyuserid(userRole);
			return ResultMap.IS_200();
		}
	}
	
	// 判断用户是否有这个角色
	private UserRole CheckUserRole(UserRole userRole) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userRole.getUserid());
		List<UserRole> list = userRoleMapper.selectByExample(example);
		if (!list.isEmpty() && list.size()>0) {
			return list.get(0);
		}
		return null;
	}


	/** 根据用户的ID ，查询用户对应的权限
	 * @param userid : 用户ID
	 * **/
	public List<Access> getaccessbyuserid(UserCustomer user_search) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getaccessbyuserid(user_search);
	}

	/**
	 * 查询管理对应的用户
	 * @param userid : 当前用户ID
	 * **/
	public List<UserCustomer> totaluser(UserVo userVo) {
		List<UserCustomer> users = userCustomerMapper.totaluser(userVo);
		return users;
	}
	
	/**
	 * 查询管理对应的用户
	 * @param userid : 当前用户ID
	 * **/
	public int totaluserCount(UserVo userVo) {
		return   userCustomerMapper.totaluserCount(userVo);
		
	}

	/** 查询所有需要被管理的用户
	 *  @param userid : 用户ID
	 * **/
	public List<UserCustomer> alltobemanager(UserVo userRole) {
		// TODO Auto-generated method stub
		return userCustomerMapper.alltobemanager(userRole);
	}


	/**
	 * 建立用户和管理的关系
	 * @param userid : 用户的ID
	 * @param userids : 被管理 的用户
	 * **/ 
	public ResultMap usertobemanager(Long userid, String userids) {
		ManageUser manageUser = new ManageUser();
		manageUser.setUserid(userid);
		String [] ids= userids.split(",");
		for (int i=0;i<ids.length;i++) {
			manageUser.setFollowuserid(Long.valueOf(ids[i]));
			ManageUser manageUser2 = CheckManagerUser(manageUser);
			if (manageUser2 == null) {
				manageUserMapper.insertSelective(manageUser);
			}
		}
		return ResultMap.IS_200();
	}
	
	// 判断管理是否有这个用户
	private ManageUser CheckManagerUser(ManageUser manageUser) {
		ManageUserExample example = new ManageUserExample();
		ManageUserExample.Criteria criteria = example.createCriteria();
		criteria.andFollowuseridEqualTo(manageUser.getFollowuserid());
		criteria.andUseridEqualTo(manageUser.getUserid());
		List<ManageUser> list = manageUserMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() >0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public int alltobemanagercount(UserVo uservo) {
		// TODO Auto-generated method stub
		return  userCustomerMapper.alltobemanagercount(uservo);
	}


	/**
	 * 查询管理员对应用户下充值记录
	 * @param userids : 管理的IDS
	 * **/
	public List<UserCustomer> getmanageruserchongzhi(String[] ids ,PageQuery pageQuery) {
		return userCustomerMapper.getmanageruserchongzhi(ids , pageQuery);
	}
	public int getmanageruserchongzhiCount(String[] ids ) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmanageruserchongzhiCount(ids );
	}


	/**
	 *  查询管理员对应用户下消费记录
	 *  @param userids : 管理对应的用户IDS
	 * **/
	public List<UserCustomer> getmanageruserxiaofei(String[] ids,PageQuery pageQuery) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmanageruserxiaofei(ids , pageQuery);
	}
	public int getmanageruserxiaofeiCount(String[] ids) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmanageruserxiaofeiCount(ids);
	}



	/**查询管理员对应用户下会员充值记录
	 * @param userids : 对应的用户的ids
	 * **/ 
	public List<UserCustomer> getmanageruservip(String[] ids ,PageQuery pageQuery) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmanageruservip(ids ,pageQuery);
	}
	public int getmanageruservipCount(String[] ids ) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmanageruservipCount(ids );
	}


	/**查询管理员对应用户下房源记录
	 * @param userids : 用户ID集合
	 * @param housestatus : 房源状态码
	 * ***/ 
	public List<UserCustomer> gethousefabu(String[] ids ,String []housestatus ,PageQuery pageQuery) {
		// TODO Auto-generated method stub
		return userCustomerMapper.gethousefabu(ids,housestatus ,pageQuery);
	}
	public int gethousefabuCount(String[] ids ,String []housestatus) {
		// TODO Auto-generated method stub
		return userCustomerMapper.gethousefabuCount(ids,housestatus);
	}

	/**
	 * 查询管理员对应用户下求租记录
	 * @param userids : 管理下面的与用户ID
	 * @param housestatus : 房源的状态码
	 * **/
	public List<UserCustomer> gethouseqiuzu(String[] ids, String[] housestatus,PageQuery pageQuery) {
		// TODO Auto-generated method stub
		return userCustomerMapper.gethouseqiuzu(ids,housestatus,pageQuery);
	}
	public int gethouseqiuzuCount(String[] ids, String[] housestatus) {
		// TODO Auto-generated method stub
		return userCustomerMapper.gethouseqiuzuCount(ids,housestatus);
	}


	/**
	 * 导入历史excle
	 * @param userid : 用户ID
	 * @param historyexcleurl : EXCLE 文件路径
	 * **/
	public void excleurladd(Historyexcle historyexcle) {
		historyexcleMapper.insertSelective(historyexcle);
	}


	
	
	/**根据userid查出历史导出记录
	 * @param userid : 当前的用户ID
	 * **/
	public List<Historyexcle> getexclebyuserid(UserVo userVo) {
		
		return userCustomerMapper.getexclebyuserid(userVo);
	}
	public int getexclebyuseridCount(UserVo userVo) {
		
		return userCustomerMapper.getexclebyuseridCount(userVo);
	}


	/**根据id编辑EXCLE
	 * @param historyexclid : excle 主键
	 * @param descname : 描述
	 * **/
	public void updatexclebyid(Historyexcle historyexcle) {
		historyexcle.setUpdate_time(new Date());
		historyexcleMapper.updateByPrimaryKeySelective(historyexcle);
	}
	@Override
	public Historyexcle getExclebyeid(Historyexcle historyexcle) {
		// TODO Auto-generated method stub
		return historyexcleMapper.selectByPrimaryKey(historyexcle.getHistoryexclid());
	}


	/**
	 * 根据excleid删除excle
	 * **/
	public void deleteExclebyID(Historyexcle historyexcle) {
		// TODO Auto-generated method stub
		historyexcleMapper.deleteByPrimaryKey(historyexcle.getHistoryexclid());
	}


	/** 查询房源发布，求租发布等的默认状态。修改默认配置
	 * 
	 * **/
	public ResultMap searchsystemstate() {
		List<Systemstate> searchlist = systemstateMapper.selectByExample(null);
		for (Systemstate search :searchlist) {
			String about = search.getStateabout();
			about = about.replace("one", "1").replace("two", "2").replace("sq","需要审核")
					.replace("three", "3").replace("four", "4").replace("five", "5")
					.replace("tg","直接通过");
			search.setStateabout(about);
		}
		
		return ResultMap.IS_200(searchlist);
	}

	/**   根据系统ID ，查询系统默认配置
	 *    @param systemid  : 系统参数唯一标识
	 * **/
	public ResultMap searchsystemstatebyid(Integer systemid) {
		// TODO Auto-generated method stub
		Systemstate sys =  systemstateMapper.selectByPrimaryKey(systemid);
		String about = sys.getStateabout();
		about = about.replace("one", "1").replace("two", "2").replace("sq","需要审核").replace("three", "3")
				.replace("four","4").replace("five", "5").replace("tg","直接通过");
		sys.setStateabout(about);
		return ResultMap.IS_200(sys);
	}


	/**
	 * 编辑系统默认配置参数
	 * **/
	public ResultMap updatesystemstate(Systemstate systemstate) {
		if (systemstate.getSystemid() == null) {return ResultMap.build(500,"输入的值不合法");}
		if (systemstate.getDefaultstate() == null) {return ResultMap.build(500,"输入的值不合法");}
		if (systemstate.getDescname() == null ) {return ResultMap.build(500,"输入的值不合法");}
		String replea = "XXXXXXXXXXXXXXXXXXXX";
		if (systemstate.getDefaultstate() == 1) {
			replea = "one";
		}
		if (systemstate.getDefaultstate() == 2) {
			replea = "two";
		}
		if (systemstate.getDefaultstate() == 3) {
			replea = "three";
		}
		if (systemstate.getDefaultstate() == 4) {
			replea = "four";
		}
		if (systemstate.getDefaultstate() == 5) {
			replea = "five";
		}
		Systemstate sys =  systemstateMapper.selectByPrimaryKey(systemstate.getSystemid());
		if (!sys.getStateabout().contains(replea)) {
			return ResultMap.build(500,"输入的值不合法");
		}
		systemstateMapper.updateByPrimaryKeySelective(systemstate);
		return ResultMap.build(200, "更新成功");
	}
	@Override
	public int getallmanager_userCount(UserVo userVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getallmanager_userCount(userVo);
	}

	/**  
	 * 查询   平台招募 信息
	 * **/ 
	public ResultMap searchplat() {
		// TODO Auto-generated method stub
		List<Platform>  list = platformMapper.selectByExample(null);
		return ResultMap.IS_200(list);
	}

	/**  
	 * 删除管理对应的用户
	 * @param deleteid : 删除的用户ID
	 * @param userid : 对应的管理ID
	 * **/ 
	public void deletemanageruser(String deleteid, Long userid) {
		userCustomerMapper.deletemanageruser(deleteid , userid);
	}

	/**
	 * 查询系统金币参数配置
	 * **/
	public ResultMap searchcommoninte() {
		List<Commoninte> list = commoninteMapper.selectByExample(null);
		return ResultMap.IS_200(list);
	}

	/**根据金币ID 查询金币配置
	 * @param commonid : 金币ID
	 * **/
	public Commoninte searchbycommonid(Long commonid) {
		return commoninteMapper.selectByPrimaryKey(commonid);
	}

	/**根据金币ID 修改金币配置
	 * **/
	public void commoninteupdate(Commoninte comm) {
		commoninteMapper.updateByPrimaryKeySelective(comm);
	}

	/**
	 * 查询百分比类型
	 * **/
	public List<Percent> searchpercent(Integer type) {
		// TODO Auto-generated method stub
		return systemConfigMapper.searchpercent(type);
	}
	
	

	/**
	 * 查询百分比类型
	 * **/
	public List<Percenttype> searchpercenttype() {
		// TODO Auto-generated method stub
		return percenttypeMapper.selectByExample(null);
	}

	/**
	 * 添加百分比
	 * @param type : 类型
	 * @param percentnum : 百分比
	 * **/
	public void addpercent(int type, double percentnum) {
		// TODO Auto-generated method stub
		Percent in = new Percent();
		in.setType(type);
		in.setPercentnum(percentnum);
		percentMapper.insertSelective(in);
		
	}

	// 校验百分比是否存在
	public Percent checkpercent(int type, double percentnum) {
		PercentExample example = new PercentExample();
		PercentExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		criteria.andPercentnumEqualTo(percentnum);
		List<Percent> percent = percentMapper.selectByExample(example);
		if (!percent.isEmpty() && percent.size() > 0 ) {return percent.get(0);}
		return null;
	}

	/**
	 * 删除百分比
	 * **/
	public void deletepercent(long  deleteid) {
		percentMapper.deleteByPrimaryKey(deleteid);
	}

	//编辑系统图片添加水印[内部方法]
	public ResultMap updatepic(Long start ,Long end) {
		BuildingExample example = new BuildingExample();
		BuildingExample.Criteria criteria = example.createCriteria();
		criteria.andBuildingidBetween(start, end);
		List<Building> details = buildingMapper.selectByExample(example);
		for (Building detail : details) {
		    String returnurl = "";
			if (detail.getPicture()!=null && !"".equals(detail.getPicture())) {
				if (detail.getPicture() !=null && ! "".equals(detail.getPicture())){
					String[]picture = detail.getPicture().split(",");
					for (int i=0;i<picture.length;i++) {
						// 第一步把图片 下载到本地
						String singelname=AccountMgr.return_path +  IDUtils.onepicName(picture[i]);
						String downpath = SimpleUpload.downLoad(singelname);
						// 加水印
						File file = new File(downpath);
						String tarImgPath = IDUtils.onepicName(picture[i]);
						String shuiyinpath = WaterMarkUtils.addWaterMark(file, tarImgPath);
						// 移除七牛云的照片
						SimpleUpload.deleteimage(picture[i]);
						if (shuiyinpath !="") {
							//新的图片名称
							String newName = IDUtils.genItemId()+".png";
							SimpleUpload.upload(shuiyinpath, newName);
							returnurl += AccountMgr.return_path + newName + ",";
						}
						
					}
				}
			}
			//  如果操作成功数据库
			if (returnurl !="") {
				returnurl = returnurl.substring(0,returnurl.length()-1);
				detail.setPicture(returnurl);
				buildingMapper.updateByPrimaryKeySelective(detail);
			}
			
		}
		return ResultMap.IS_200();
	}
	
	// [内部方法]
	public ResultMap buildpicpath() {
		List<Village> details = villageMapper.selectByExample(null);
		for (Village detail : details) {
		    String pictures = detail.getPicture();
		    String newpic = IDUtils.getPicName(pictures);
		   
		    detail.setPicture(newpic);
		    villageMapper.updateByPrimaryKeySelective(detail);
			
		}
		return ResultMap.IS_200(details);
	}



	
	

	
}
