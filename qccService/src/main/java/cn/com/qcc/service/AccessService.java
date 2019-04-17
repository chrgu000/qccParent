package cn.com.qcc.service;
import java.util.List;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.Commoninte;
import cn.com.qcc.pojo.Defaultpercent;
import cn.com.qcc.pojo.Historyexcle;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.Percent;
import cn.com.qcc.pojo.Percenttype;
import cn.com.qcc.pojo.Role;
import cn.com.qcc.pojo.Systemstate;
import cn.com.qcc.pojo.UserRole;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VillageCustomer;
public interface AccessService {
	
	/**获取所有权限的集合
	 * @param currentpage : 分页参数当前页面
	 * @param pagesize    : 每页查询的数量
	 * @param userVo      : 主要封装分页参数
	 * **/
	List<Access> getallaccess(UserVo userVo);
	
	
	/**获取所有权限的集合COUNT
	 * **/
	int getallaccessCount(UserVo userVo);
	
	
	/**  新增或者编辑权限 当权限ID存在时候 为编辑操作
	 *   @param  access.Accessname :权限的名称
	 *   @param  access.Accessurl  :权限的链接
	 *   @param  access.Accessid   :权限对应的ID
	 * **/
	ResultMap inserorupdateaccess(Access access);
	
	/** 
	 *  查询所有角色。以及当前角色下面对应的权限
	 * **/
	ResultMap roletoaccess();
	
	/**
	 * 获取所有的 角色对应 的权限 【在角色范围内】
	 * @param role_accid : 角色 对应的权限
	 * **/
	List<Access> isinrole(String[] role_accid);
	
	/**
	 * 获取所有的 角色对应 的权限 【不在角色范围内】
	 * @param role_accid : 角色 对应的权限
	 * **/
	List<Access> isnotrole(String[] role_accid);
	
	/** 创建或者编辑 / 角色
	 * @param rolename : 角色名称
	 * **/
	ResultMap inserorupdaterole(Role role);
	
	/*** 修改角色对应的权限
	 * @param role_accid : 角色对应权限ID
	 * @param roleid  : 当前角色ID
	 * **/
	ResultMap changge_access(Role role);
	
	/**查询所有的用户角色关系
	 * **/
	List<UserCustomer> getalluser_role(UserVo userVo);
	int getalluser_roleCount(UserVo userVo);
	
	/**
	 * 角色对应权限
	 * **/
	ResultMap rolenotinuser(Role role);
	
	/***
	 *  改变用户对应的角色
	 *  @param userid : 用户id
	 *  @param roleid : 角色ID
	 * **/
	ResultMap changgeuserrole(UserRole userRole);
	
	/** 根据用户的ID ，查询用户对应的权限
	 * @param userid : 用户ID
	 * **/
	List<Access> getaccessbyuserid(UserCustomer user_search);
	
	/** 查询 用户对应 的角色
	 * @param rolename : 角色名称
	 * @param telephonoe : 电话号码
	 * **/
	List<UserCustomer> getallmanager_user(UserVo userVo);
	int getallmanager_userCount(UserVo userVo);
	
	/**
	 * 查询管理对应的用户
	 * @param userid : 当前用户ID
	 * **/
	List<UserCustomer> totaluser(UserVo userVo);
	int totaluserCount(UserVo userVo);
	
	/** 查询所有需要被管理的用户
	 *  @param userid : 用户ID
	 * **/
	List<UserCustomer> alltobemanager(UserVo userVo);
	int alltobemanagercount(UserVo uservo);
	
	/**
	 * 建立用户和管理的关系
	 * @param userid : 用户的ID
	 * @param userids : 被管理 的用户
	 * **/ 
	ResultMap usertobemanager(Long userid, String userids);

	
	
	/**
	 * 查询管理员对应用户下充值记录
	 * @param userids : 管理的IDS
	 * **/
	List<UserCustomer> getmanageruserchongzhi(String[] userids ,PageQuery pagequery);
	int getmanageruserchongzhiCount(String[] userids);
	
	/**
	 *  查询管理员对应用户下消费记录
	 *  @param userids : 管理对应的用户IDS
	 * **/
	List<UserCustomer> getmanageruserxiaofei(String[] ids ,PageQuery pageQuery);
	int getmanageruserxiaofeiCount(String[] ids);
	

	/**查询管理员对应用户下会员充值记录
	 * @param userids : 对应的用户的ids
	 * **/ 
	List<UserCustomer> getmanageruservip(String[] ids ,PageQuery pageQuery);
	int getmanageruservipCount(String[] ids);
	
	
	/**查询管理员对应用户下房源记录
	 * @param userids : 用户ID集合
	 * @param housestatus : 房源状态码
	 * ***/ 
	List<UserCustomer> gethousefabu(String[] ids ,String[] housestatus ,PageQuery pageQuery);
	int gethousefabuCount(String[] ids, String[] houses_tatus);

	
	/**
	 * 查询管理员对应用户下求租记录
	 * @param userids : 管理下面的与用户ID
	 * @param housestatus : 房源的状态码
	 * **/
	List<UserCustomer> gethouseqiuzu(String[] ids, String[] houses_tatus,PageQuery pageQuery);
	int gethouseqiuzuCount(String[] ids, String[] houses_tatus);

	/**
	 * 导入历史excle
	 * @param userid : 用户ID
	 * @param historyexcleurl : EXCLE 文件路径
	 * **/
	void excleurladd(Historyexcle historyexcle);
	
	
	/**根据userid查出历史导出记录
	 * @param userid : 当前的用户ID
	 * **/
	List<Historyexcle> getexclebyuserid(UserVo userVo);
	int getexclebyuseridCount(UserVo userVo);
	
	
	/**根据id编辑EXCLE
	 * @param historyexclid : excle 主键
	 * @param descname : 描述
	 * **/
	void updatexclebyid(Historyexcle historyexcle);

	/**
	 * 根据EXCLEId 获取Excle 详情
	 * **/
	Historyexcle getExclebyeid(Historyexcle historyexcle);

	/**
	 * 根据excleid删除excle
	 * **/
	void deleteExclebyID(Historyexcle historyexcle);

	
	
	/** 查询房源发布，求租发布等的默认状态。修改默认配置
	 * 
	 * **/
	ResultMap searchsystemstate();
	
	
	/**   根据系统ID ，查询系统默认配置
	 *    @param systemid  : 系统参数唯一标识
	 * **/
	ResultMap searchsystemstatebyid(Integer systemid);

	/**
	 * 编辑系统默认配置参数
	 * **/
	ResultMap updatesystemstate(Systemstate systemstate);
	
	/**  
	 * 查询   平台招募 信息
	 * **/ 
	ResultMap searchplat();

	/**  
	 * 删除管理对应的用户
	 * @param deleteid : 删除的用户ID
	 * @param userid : 对应的管理ID
	 * **/ 
	void deletemanageruser(String deleteid, Long userid);

	/**
	 * 查询系统金币参数配置
	 * **/
	ResultMap searchcommoninte();

	/**根据金币ID 查询金币配置
	 * @param commonid : 金币ID
	 * **/
	Commoninte searchbycommonid(Long commonid);

	/**根据金币ID 修改金币配置
	 * **/
	void commoninteupdate(Commoninte comm);

	/**
	 * 查询系统设定的百分比
	 * **/
	List<Percent> searchpercent(Integer type);

	/**
	 * 查询百分比类型
	 * **/
	List<Percenttype> searchpercenttype();

	/**
	 * 添加百分比
	 * @param type : 类型
	 * @param percentnum : 百分比
	 * **/
	void addpercent(int type, double percentnum);

	/**
	 * 根据条件查询百分比
	 * **/
	Percent checkpercent(int type, double percentnum);

	/**
	 * 删除百分比
	 * **/
	void deletepercent(long deleteid);

	//编辑系统图片添加水印[内部方法]
	ResultMap updatepic(Long start ,Long end);
	
	// [内部方法]
	ResultMap buildpicpath();


	ResultMap deleterole(Long userid);

	
	/**查询需要添加的系统账号**/
	int searchAddRoleCount(String searchWhere);
	List<UserCustomer> searchAddRole(String searchWhere, PageQuery pagequery);

	/**
	 * 添加用户角色
	 * */
	ResultMap userRoleAdd(String userids, Long roleid);

	
	List<VillageCustomer> getLikeVillage(String likename);

	/**后台修改房东基本信息*/
	ResultMap updateland(Landlord landlord);


	ResultMap deletelandlord(Long landuserid);


	ResultMap defaultPercentList();


	ResultMap onedefaultPercent(int id);


	void updatefaultPercent(Defaultpercent defaultPercent);

	
	

	
	

	



	
	

	



	



	

}
