package WangYiUtil;

import java.net.URI;

public class WangYiCommon {
	
	/** * 撤回消息*/
	public static final String recallurl = "https://api.netease.im/nimserver/msg/recall.action";
	
	/** 创建新用户*/
	public static final String createUser = "https://api.netease.im/nimserver/user/create.action";

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
	
	

}
