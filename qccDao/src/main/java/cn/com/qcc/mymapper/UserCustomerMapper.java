package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Historyexcle;
import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.pojo.Invite;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Userconn;
import cn.com.qcc.queryvo.CentFromCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MailCustomer;
import cn.com.qcc.queryvo.MailVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;

public interface UserCustomerMapper {

	// 根据电话号码查询用户基本信息
	public UserCustomer getUserMessage(@Param("telephone") Long telephone);

	// 查询所有权限的集合
	public List<Access> getallurls(@Param("idsList") String[] urls);

	// 根据用户的toekn获取用户信息
	public UserCustomer getUserByToken(@Param("token") String token);

	// 通过租户的电话号码查询租户的信息
	public UserCustomer getrealnamebyphone(String telephone);

	// 查询租客来源列表
	public List<CentFromCustomer> centfromlist();

	// 查询账单列表
	public List<UserCentCustomer> paylistshowbecent(UserCentCustomer userCentCustomer);

	// 通过userid 查询用户的基本信息
	public UserCustomer getcommonusermess(Long userid);

	// 根据房子的ID查询房东和房源的信息
	public HouseCustomer getlandusermess(Long houseid);

	// 查询续约的最大次数
	public Integer getCentTimes(String usercentnum);


	

	

	


	// 租客登记的列表
	public List<UserCentCustomer> housepersionlist(HouseVo houseVo);

	// 租客登记总数
	public int housepersionlistCount(HouseVo houseVo);

	// 同步通讯录
	public List<MailCustomer> mailsbyuserid(MailVo mailVo);
	public int mailsbyuseridCount(MailVo mailVo);

	// 根据房源ID查询历史租客
	public List<Housepersion> historyhouserpersion(Long houseid);

	// 找经纪人
	public List<UserCustomer> searchbroker(UserCentVo user);

	// 找经纪人的总数
	public int searchbrokerCount(UserCentVo userCentVo);

	// 查询我的待办
	public UserCentCustomer backlog(UserCentVo userCentVo);

	// 根据租户编号查询续租信息
	public UserCentCustomer xuzusearch(String usercentnum);

	// 根据用户ID查询用户和profile表的详情数据
	UserCustomer getUserAndProfileByUserid(Long userid);

	// 根据用户ID查询所有的关注
	List<UserCustomer> findFollowByUserId(@Param("userid")Long userid ,@Param("pagequery") PageQuery pagequery);
	int findFollowByUserIdCount(Long userid);

	// 根据用户ID查询所有的粉丝
	List<UserCustomer> findFansByUserId(@Param("userid") Long userid ,@Param("pagequery")PageQuery pagequery);
	int findFansByUserIdCount(Long userid);
	// 找房东
	List<UserCustomer> findland(UserVo userVo);

	Integer findlandCount(UserVo userVo);

	List<UserCustomer> getuserinfo(@Param("idsList") String[] user_ids);

	void updateToken(User user);

	void updateAvatar(Profile profile);

	// 移除黑名单
	void romoveblack(Userconn userconn);

	// 我的好友
	List<UserCustomer> myfriend(Userconn userconn);

	// 查询想要加好友的对象
	List<UserCustomer> searchadd(UserCustomer userCustomer);

	// 邀请好友入群的查询
	List<UserCustomer> inviting(Ronggroup ronggroup);

	// 群邀请列表
	List<UserCustomer> mygrouplist(Userconn userconn);

	// 查询用户的可用于额
	UserCustomer searchbalance(Long userid);

	List<UserCustomer> getalluser_role(UserVo user);
	public int getalluser_roleCount(UserVo user);

	List<Access> getaccessbyuserid(UserCustomer user_search);
	
	/**
	 * 根据用户的ID,查询用户的角色ID 和角色名称 
	 * @param userid : 用户ID
	 * **/
	UserCustomer getRoleName(User user);
	
	//查询管理对应用户
	List<UserCustomer> getallmanager_user(UserVo userVo);
	public int getallmanager_userCount(UserVo userVo);
	
	//查询所有被管理的用户
	List<UserCustomer> totaluser(UserVo userVo);
	public int totaluserCount(UserVo userVo);

	List<UserCustomer> alltobemanager(UserVo uservo);

	int alltobemanagercount(UserVo uservo);

	List<UserCustomer> getmanageruserchongzhi(@Param("idsList") String[] ids ,@Param("pagequery") PageQuery pageQuery);
	public int getmanageruserchongzhiCount(@Param("idsList")String[] ids);

	List<UserCustomer> getmanageruserxiaofei(@Param("idsList") String[] ids ,@Param("pagequery") PageQuery pageQuery);
	public int getmanageruserxiaofeiCount(@Param("idsList")String[] ids);

	List<UserCustomer> getmanageruservip(@Param("idsList") String[] ids ,@Param("pagequery") PageQuery pageQuery);
	public int getmanageruservipCount(@Param("idsList")String[] ids);

	List<UserCustomer> gethousefabu(@Param("idsList") String[] ids, @Param("order") String[] housestatus,@Param("pagequery") PageQuery pageQuery);
	public int gethousefabuCount(@Param("idsList") String[] ids, @Param("order") String[] housestatus);

	List<UserCustomer> gethouseqiuzu(@Param("idsList") String[] ids, @Param("order") String[] housestatus,@Param("pagequery") PageQuery pageQuery);
	public int gethouseqiuzuCount(@Param("idsList") String[] ids, @Param("order") String[] housestatus);

	void updateweixinmess(Profile profile);

	// 查询网易云类似的
	List<UserCustomer> searchlikeuser(@Param("likename") String likename, @Param("userid") String userid);

	void updateUserName(Profile profile);

	void updateMail(Profile profile);

	List<UserCustomer> myteam(Long userid);

	List<UserCustomer> myteamson(UserCustomer userCustomer);

	// 我的收益列表
	List<Lucre> mylurnce(UserVo userVo);
	public int mylurnceCount(UserVo userVo);

	// 根据userid 查询当前用户是推荐人中的位置级别
	Invite getmaxuserlevel(Long userid);

	List<Area> getjiyin(@Param("idsList") String[] code);

	// 通过用户ID查询当前可以用 的品牌
	List<Brand> getmybranduser(UserVo userVo);
	int getmybranduserCount(UserVo userVo);

	// 查询品牌下的用户
	List<UserCustomer> followbrand(Long brandid);

	// 查询品牌添加的用户
	List<UserCustomer> searchaddbranduser(UserCustomer userCustomer);
	

	//根据token校验用户信息
	public String getuseridbytoken(String token);
	
	//根据城市查询我的品牌
	public List<Brand> getmybranduserbycity(HouseVo houseVo);

	public List<Access> getallaccess(UserVo userVo);

	public int getallaccessCount(UserVo userVo);

	//获取历史导出EXCLE记录
	public List<Historyexcle> getexclebyuserid(UserVo userVo);
	public int getexclebyuseridCount(UserVo userVo);

	/**
	 * 删除管理对应的用户
	 * @param deleteid : 删除的用户ID
	 * @param userid  : 对应的管理ID
	 * **/
	public void deletemanageruser(@Param("deleteid")String deleteid,@Param("userid") Long userid);

	
	/**
	 * 查询用户的提现信息
	 * @param userid  : 对应的管理ID
	 * **/
	public UserCustomer checkcash(Long userid);

	
	/**
	 * 通过微信 的唯一ID 查询用户信息
	 * **/
	public UserCustomer getusermessbyunionid(String unionid);

	
	/**解绑微信账号**/
	public void deleteunionid(Long userid);
	public void delteopenid(Long userid);

	/**查询所有的二级团队**/
	public List<UserCustomer> allteamson(@Param("userid")Long userid,@Param("idsList") List<Integer> sons);
	
	/**查询用户的实名信息**/
	public UserCustomer searchUserSign(Long userid);
	

	

	

	

	

	

	

	

	

	

	

	

	

	

}
