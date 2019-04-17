package cn.com.qcc.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Branduser;
import cn.com.qcc.pojo.Housepaydetail;
import cn.com.qcc.pojo.Invite;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Maillist;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.Rongconn;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Userconn;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.CentFromCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MailCustomer;
import cn.com.qcc.queryvo.MailVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;

public interface UserService {


	


	/**
	 * 通过用户手机查询user表是否存在该用户
	 * 
	 * @param telephone
	 *            : 用户电话号码
	 * 
	 **/
	public User getUserByphone(Long telephone);

	

	/**
	 * 根据token获取用户信息
	 * 
	 * @param token
	 *            : 用户唯一标识
	 * 
	 **/
	public UserCustomer getUserAccessToken(String token);

	

	/**
	 * 申请成为的我们的房东
	 * 
	 * @param identity
	 *            : 身份证号
	 * @param idpictures
	 *            :身份照片
	 * @param realname
	 *            : 真实姓名
	 * @param update_time
	 *            : 申请时间
	 * @param state
	 *            :1-申请加入，2表示已经加入
	 * @param telephone
	 *            :电话号码
	 **/
	public ResultMap regiestland(Landlord landlord, Long telephone);

	/**
	 * 移除不敢兴趣的求租
	 * 
	 * @param userid
	 *            : 当前用户ID
	 * @param msgid
	 *            :消息ID
	 * @param time
	 *            : 消息时间戳
	 * @param fromuserid
	 *            : 发布人ID
	 **/
	public Map<String, Object> removenotlike(String userid, String msgid, String time, String fromuserid);

	/**
	 * 通过电话查询租户的真实信息判断曾经是否入驻过
	 * 
	 * @param telephone
	 *            : 租户也即时用户的电话号码
	 **/
	public ResultMap getrealnamebyphone(String telephone);

	/**
	 * 查询租客来源列表
	 **/
	public List<CentFromCustomer> centfromlist();

	/**
	 * 根据租约ID查询账单列表
	 **/
	public List<UserCentCustomer> paylistshowbecent(Long usercentid);

	

	

	/**
	 * 同步通讯录好友
	 */
	public ResultMap syncmail(List<Maillist> mails, Long userid);

	/**
	 * 获取当前用户的通讯好友总数
	 */
	public int mailsbyuseridCount(MailVo mailVo);

	public List<MailCustomer> mailsbyuserid(MailVo mailVo);

	/**
	 * 查询我的待办
	 */
	public UserCentCustomer backlog(UserCentVo userCentVo);

	/**
	 * 查询续租的用户信息
	 */
	public UserCentCustomer xuzusearch(String usercentnum);

	/**
	 * 插入profile基本信息
	 */
	public void insertprofile(Profile profile);

	/**
	 * 更新profile表基本信息
	 */
	public void updateprofile(Profile profile);

	/**
	 * 插入user表信息
	 */
	public void insertuser(User user);

	/**
	 * 插入vipuser表信息
	 */
	public void insertuservip(Vipcount vipcount);

	/**
	 * 新用户的注册
	 * 
	 * @param user
	 */
	public ResultMap userReg(User user, Profile profile);

	// 根据验证码登录
	public ResultMap codeLogin(User user);

	// 根据accesToken新注册查询用户的id
	public User findUserid(User user);


	// 根据密码登录
	public User loginByPwd(User user);

	// 修改密码
	public ResultMap updatePwd(long userId, String newPwd, String oldPwd);

	// 修改手机号
	public void updateTel(User user);

	// 根据userid查询用户密码
	public User findPwdByUserid(User user);

	// 根据电话号码查询用户密码
	public ResultMap findPwdByTel(User user);

	// 根据电话登录时改acc和update_time
	public void updateAccesstoken(User user);

	// 根据电话号码查询用户详情
	public User getUserInfoByTel(User user);

	// 通过userid获取user信息
	public User getUserByUserid(long userid);

	// 通过userid获取user信息 包括hosue
	public User getUserByUserid1(User user);

	// 修改用户身份
	public void updateUsertype(User user);

	// 根据用户ID获取房子信息
	public List<HouseCustomer> singleablum(Integer userid ,PageQuery pagequery);
	public Integer singleablumCount(Integer userid);

	// 通过用户ID返回用户和PROFILE信息
	public UserCustomer getUserAndProfile(Long userid);

	// 更改用户名
	public void updateUserName(Long userid, String username);

	// 更新邮箱
	public void updateMail(Long userid, String mail);

	// 生成融云token
	public String addRongToken(Long userid, String user_name, String atavr) throws Exception;

	// 找房东
	List<UserCustomer> findland(UserVo userVo);

	public Integer findlandCount(UserVo userVo);

	public List<UserCustomer> getuserinfo(String[] user_ids);

	// 根据用户token 获得用户信息
	public ResultMap getUserByToken(String token);

	// 修改头像
	public ResultMap updateAvatat(Long userid, String filePath);

	// 申请添加好友
	public ResultMap befriend(Userconn userconn);

	// 移除黑名单
	public ResultMap romoveblack(Userconn userconn);

	// 我的好友
	public ResultMap myfriend(Userconn userconn);

	// 查询想要加好友的对象
	public ResultMap searchadd(UserCustomer userCustomer);

	// 查看是否是好友
	public String findIsFriend(Long userid, Long followUserId);

	// 邀请好友入群的查询
	public ResultMap inviting(Ronggroup ronggroup);

	// 邀请好友入群
	public ResultMap invitefriend(Rongconn conn);

	// 拒绝加入群组
	public void juquejoingroup(String userid, String groupid);

	// 检查用户权限
	public boolean CheckUserAccess(HttpServletRequest request, String accessurl);

	public UserCustomer getRoleName(User user1);

	public void updateweixinmess(Profile profile);

	public ResultMap updateUser(UserCustomer userCustomer, 
			String codes, HttpServletRequest request,String mysign);

	public void updateUserByUserId(User user);

	// 查询类似的名称
	public ResultMap searchlikename(String likename, String userid);

	// 插入邀请人和被邀请人关联
	public void addinvite(Invite invite);

	// 用户充值以后给对应的推荐人奖励
	public ResultMap addinvitebalance(Long userid, Double account);

	public List<User> getall();

	// 推荐人的上一级
	public Invite getinvitefather(Long userid);

	// 查询我的团队
	public Map<String, Object> myteam(Long userid);

	// 查询我的团队二级
	public List<UserCustomer> myteamson(UserCustomer userCustomer);

	// 查询我的收益记录
	public List<Lucre> mylurnce(UserVo userVo);
	public int mylurnceCount(UserVo userVo);

	// 查询当前推荐人是不是别的第二级
	public Invite istwolevel(Long userid);

	// 根据userid 查询当前用户是第几级用户
	public Invite getmaxuserlevel(Long userid);

	// returnuserid -- 推荐人 userid -- 新用户
	public Map<String,Object> addconnectionlevel(Long returnuserid, Long userid);

	// 查询范围
	public List<Area> getjiyin(String[] code);
	

	/**
	 * 创建品牌
	 * @param Onepicture : 图片
	 * @param Userid : 用户ID
	 * @param Brand : 品牌名称
	 * @param Description : 描述
	 * @param Codes : 区域
	 * **/
	public ResultMap createbrand(Brand brand);

	/**查询我的品牌
	 * @param userid : 用户ID
	 * @param currentpage : 当前页面
	 * @param pagesize : 每页显示的条数
	 * **/
	public List<Brand> getmybranduser(UserVo userVo);
	public int getmybranduserCount(UserVo userVo);

	/**
	 * 根据品牌ID 查询哪些用户在这个品牌下
	 * @param brandid : 品牌ID
	 * **/
	public List<UserCustomer> followbrand(Long brandid);

	/**查询需要添加的用户
	 * @param searchwhere : 输入的查询条件
	 * @param brandid : 品牌ID
	 * **/
	public List<UserCustomer> searchaddbranduser(UserCustomer userCustomer);

	/**更新用户状态
	 * @param Brandid : 品牌ID
	 * @param Userid  : 用户ID
	 * @param Userstate : 在品牌中状态
	 * **/
	public ResultMap updatebranduser(Branduser branduser);

	/**删除我的品牌
	 * @param brandid : 品牌ID
	 * **/
	public ResultMap deletemybrand(Long brandid);

	/** 编辑的查询
	 * @param brandid : 品牌ID
	 * **/
	public Brand searcheditbrand(Long brandid);

	/**
	 * 编辑品牌
	 * @param Onepicture : 图片
	 * @param brandid : 品牌id
	 * @param Brand : 品牌名称
	 * @param Description : 描述
	 * @param Codes : 区域
	 * **/
	public ResultMap updatemybrand(Brand brand);
	
	//校验token安全信息
	public String checkaccesstoken(String token);
	
	/**根据城市查询查询我的品牌
	 * @param city : 城市名称
	 * @param userid : 用户主键
	 * **/
	public List<Brand> getmybranduserbycity(HouseVo houseVo);
	
	//根据用户电话查询用户详情信息
	public UserCustomer getuserdetailbyphone(Long telephone);
	
	//校验房东是否存在
	public  Landlord searchLandUserByUserId(Long userid);

	public String getaccessurl_name(String url);

	public List<User> searchalluser();
	
	/**
	 * 房东端通过密码登录
	 * **/
	public UserCustomer getusermessbypassword(Long telephone);
	/**
	 * 通过手机号修改密码
	 * **/
	public ResultMap changeloginword(String password, Long telephone);
	
	/**
	 * 查询提现的信息
	 * **/
	public UserCustomer checkcash(Long userid);

	/**通过用户绑定的unionid 获取userid**/
	public UserCustomer getusermessbyunionid(String unionid);
	
	/**有选择的更新用户**/
	public void updateUserSelective(User userupdate);


	/**查询在线交租或者收租记录**/
	public List<Housepaydetail> searchHousePayDetailList(Long userid);



	public Profile getprofile(Long userid ) ;


	

	



	

}
