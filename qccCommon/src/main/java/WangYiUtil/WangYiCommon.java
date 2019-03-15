package WangYiUtil;


public class WangYiCommon {
	
	/** * 撤回消息*/
	public static final String RECALURL = "https://api.netease.im/nimserver/msg/recall.action";
	
	/** 创建新用户*/
	public static final String CREATEUSER = "https://api.netease.im/nimserver/user/create.action";

	/**更新用户信息**/
	public static final String UPDATEUSERINFO = "https://api.netease.im/nimserver/user/updateUinfo.action";
	
	/**拉人进群**/
	public static final String TEAMADD = "https://api.netease.im/nimserver/team/add.action";
	
	/**离开群组**/
	public static final String TEAMLEVEL = "https://api.netease.im/nimserver/team/leave.action";
	
	/**解散群组**/
	public static final String TEAMREMOVE = "https://api.netease.im/nimserver/team/remove.action";

	/**批量发送消息**/
	public static final String SENDBATCHMSG = "https://api.netease.im/nimserver/msg/sendBatchMsg.action";

	/**重置TOKEN**/
	public static final String REFRESHTOKEN  = "https://api.netease.im/nimserver/user/refreshToken.action";
	
	/**创建群组**/
	public static final String CREATETEAM = "https://api.netease.im/nimserver/team/create.action";
	
	/**获取用户群组信息**/
	public static final String JOINTEAMS =  "https://api.netease.im/nimserver/team/joinTeams.action";

	/**编辑群组**/
	public static final String UPDATETEAM = "https://api.netease.im/nimserver/team/update.action";

	/**发送短信验证码的URL**/
	public static final String SENDCODEURL = "https://api.netease.im/sms/sendcode.action";
	
	/**发送通知类短信**/
	public static final String SENDTEMPLATE = "https://api.netease.im/sms/sendtemplate.action";
	
	/**文件上传**/
	public static final String FILE_UPLOAD = "https://api.netease.im/nimserver/msg/upload.action";
	
	/***修改手机号码发送验证码 的模板ID*/
	public static final String CODE_PHONE_UPDATE = "9744091";
	
	/***使用手机验证码登录 的模板ID*/
	public static final String CODE_PHONE_LOGIN = "9414704";
	
	/**修改登录密码 的模板ID*/
	public static final String CODE_PHONE_PASSWORDCHANGE = "9604116";
	
	/**注册验证码 的模板ID*/
	public static final String CODE_PHONE_REGISTER = "9764124";
	
	/**用户收益的模板ID**/
	public static final String SHOU_YI_TEMPID ="9654153";
	
	/**房东发布租约的模板ID**/
	public static final String LAND_CENT_PUSH = "9644234";

	/**BD 账号添加成功后通知用户**/
	public static final String BD_ADD_NOTIC = "9664334";
	
	/**BD 添加房东后通知房东**/
	public static final String BD_ADD_LAND_NOTIC = "9764325";
	
	/**通知租户交租成功**/
	public static final  String NOTIC_USER_HOUSEPAY_SUCCESS="9684351";
	
	/**通知房东交租成功**/
	public static final  String NOTIC_LAND_HOUSEPAY_SUCCESS ="9644319";
	
	/**通知管理交租成功**/
	public static final  String NOTIC_MANAGER_HOUSEPAY_SUCCESS ="9764356";
	
	

}
