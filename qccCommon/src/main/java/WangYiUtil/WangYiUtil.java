package WangYiUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.common.Base64;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.CheckSumBuilder;
import cn.com.qcc.common.JsonUtils;

@SuppressWarnings({ "deprecation", "resource", "static-access", "unchecked" })
public class WangYiUtil {
	
	public static final String APPKEY = "00481cb45c031fe722c155d3f321dac0";
	public static final String APPSECRET = "f2f1c46cc596";
	public static final String NONCE = "12345";

	/** 设置网易云请求的请求头部 **/
	public static  HttpPost SetSendHead(String url) {
		HttpPost httpPost = new HttpPost(url);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(APPSECRET, NONCE, curTime);// 参考
		// 设置请求的header
		httpPost.addHeader("AppKey", APPKEY);
		httpPost.addHeader("Nonce", NONCE);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		return httpPost;
	};
	
	
	/** 设置网易云请求的请求头部 **/
	public static  HttpPost SetSendHeadFile(String url) {
		HttpPost httpPost = new HttpPost(url);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(APPSECRET, NONCE, curTime);// 参考
		// 设置请求的header
		httpPost.addHeader("AppKey", APPKEY);
		httpPost.addHeader("Nonce", NONCE);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "multipart/form-data");
		return httpPost;
	};

	/**创建用户**/
	public static  Map<String, Object> getACCIDANDTOKEN(Long userid, String name, String icon)
			throws ParseException, IOException {
		
		// 设置请求头部信息
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.CREATEUSER);
		
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 用户的userid 对应的云唯一约束
		nvps.add(new BasicNameValuePair("accid", userid + "")); 
		// 用户昵称
		nvps.add(new BasicNameValuePair("name", name)); 
		// 用户头像
		nvps.add(new BasicNameValuePair("icon", icon)); 
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		
		// 打印执行结果
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		
		return map;
	}

	// 批量发送消息
	public static void piliangqiuzu(String body, String toAccids) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.SENDBATCHMSG);
		
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 10088 求租推送的唯一标识
		nvps.add(new BasicNameValuePair("fromAccid", "10088"));
		// 推送的用户的id集合
		nvps.add(new BasicNameValuePair("toAccids", toAccids)); 
		// type推送模式
		nvps.add(new BasicNameValuePair("type", "0")); 
		// 推送的消息体
		nvps.add(new BasicNameValuePair("body", "{'msg':'" + body + "'}")); 
		// "{'msg':'深圳最新上市20+求租--深圳求租--EDIT--18316999864'}"
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 执行请求
		try {
			httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/** 移除网易云不喜欢的求租房源 **/ 
	public static Map<String, Object> removenotlike(String userid, String msgid, String time, String fromuserid)
			throws ParseException, IOException {
		//设置请求头部
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.RECALURL);
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 删除的消息id
		nvps.add(new BasicNameValuePair("deleteMsgid", msgid)); 
		// 发送人id
		nvps.add(new BasicNameValuePair("from", fromuserid));
		// 消息的时间戳
		nvps.add(new BasicNameValuePair("timetag", time)); 
		// type 标识消息类型
		nvps.add(new BasicNameValuePair("type", "7")); 
		// 消息抵达的id
		nvps.add(new BasicNameValuePair("to", userid)); 
		// ignoreTime 1 表示忽略最大撤回时间
		nvps.add(new BasicNameValuePair("ignoreTime", "1"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		// 打印执行结果
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return map;
	}

	/**重置网易云密码此方法仅供测试使用**/
	public static String updatetoken(long userid) throws Exception {
		//设置请求头部信息
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.REFRESHTOKEN);

		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		//用户id
		nvps.add(new BasicNameValuePair("accid", userid + ""));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		String acctoken = "";
		String ssobj = map.get("info").toString();
		if (map.get("code").equals(200)) {
			net.sf.json.JSONObject obj = new net.sf.json.JSONObject().fromObject(ssobj);
			WangYiPoJo wpojo = (WangYiPoJo) jsonobj.toBean(obj, WangYiPoJo.class);
			acctoken = wpojo.getToken();
		}
		return acctoken;
	}

	/**
	 * 创建群组
	 * 
	 * @param groupName
	 *            : 群名称
	 * @param userid
	 *            : 群主id
	 * @param descName
	 *            : 群描述、
	 * @param icon
	 *            : 群图像
	 **/
	public static String createGroup(String groupName, Long userid, String descName, String icon, String otherids)
			throws Exception {
		//设置请求头部信息
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.CREATETEAM);
		
		String insertUser = userid.toString();
		if (CheckDataUtil.checkNotEmpty(otherids)) {
			insertUser = otherids;
		}
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 群名称
		nvps.add(new BasicNameValuePair("tname", groupName));
		// 群主
		nvps.add(new BasicNameValuePair("owner", userid.toString()));
		// 插播字段
		nvps.add(new BasicNameValuePair("members", "[" + insertUser + "]"));
		nvps.add(new BasicNameValuePair("msg", "1"));
		// 群描述
		nvps.add(new BasicNameValuePair("intro", descName));
		/* nvps.add(new BasicNameValuePair("type", "true")); */
		// 谁可以修改群资料，0-管理员,1-所有人
		nvps.add(new BasicNameValuePair("uptinfomode", "0"));
		// 谁可以邀请他人入群，0-管理员,1-所有人
		nvps.add(new BasicNameValuePair("invitemode", "1"));
		// 被邀请人同意方式，0-需要同意(默认),1-不需要同意
		nvps.add(new BasicNameValuePair("beinvitemode", "1"));
		// 管理后台建群时，0不需要被邀请人同意加入群，1需要被邀请人同意才可以加入群
		nvps.add(new BasicNameValuePair("magree", "0"));
		// 群头像
		nvps.add(new BasicNameValuePair("icon", icon));
		// 0不用验证，1需要验证,2不允许任何人加入。
		nvps.add(new BasicNameValuePair("joinmode", "0"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		String code = map.get("code").toString();
		System.out.println(code);
		String tid = "";
		if (code.equals("200")) {
			tid = map.get("tid").toString();
		}
		return tid;

	}

	/**
	 * 获取用户群组信息
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 **/
	public static List<TeamPojo> getGrupByUserid(Long userid) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.JOINTEAMS);
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid", userid + ""));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		String ssobj = map.get("infos").toString();
		List<TeamPojo> team = JsonUtils.jsonToList(ssobj, TeamPojo.class);
		return team;
	}

	/**
	 * 编辑群组
	 * 
	 * @param tid
	 *            : 编辑的用户
	 * @param ownid
	 *            : 群主id
	 * @param tname
	 *            : 群名称
	 * @param descName
	 *            : 群描述
	 * @param icon
	 *            : 群图像
	 * @param joinmode
	 *            : 加入群模式
	 **/
	public static Integer editGroup(Long tid, Long ownid, String tname, String descName, String icon, Integer joinmode,
			Integer invitemode, Integer beinvitemode) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.UPDATETEAM);
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 群组id
		nvps.add(new BasicNameValuePair("tid", tid.toString()));
		// 群组名称
		nvps.add(new BasicNameValuePair("tname", tname));
		// 群主id
		nvps.add(new BasicNameValuePair("owner", ownid.toString()));
		// 群组描述
		nvps.add(new BasicNameValuePair("intro", descName));
		// 群建好后，sdk操作时，0不用验证，1需要验证,2不允许任何人加入。
		nvps.add(new BasicNameValuePair("joinmode", joinmode.toString()));
		nvps.add(new BasicNameValuePair("icon", icon));
		nvps.add(new BasicNameValuePair("invitemode", invitemode.toString()));
		String magredCode = "";
		if (beinvitemode == 0) {
			magredCode = "1";
		}
		if (beinvitemode == 1) {
			magredCode = "0";
		}
		nvps.add(new BasicNameValuePair("beinvitemode", beinvitemode.toString()));
		nvps.add(new BasicNameValuePair("magree", magredCode));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}

	/**删除群组**/
	public static Integer deleteGroup(Long tid, Long userid) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.TEAMREMOVE);
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("tid", tid.toString()));
		nvps.add(new BasicNameValuePair("owner", userid.toString()));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}

	/**离开群组**/
	public static Integer levelGroup(Long tid, Long userid) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.TEAMLEVEL);
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 群id
		nvps.add(new BasicNameValuePair("tid", tid.toString()));
		// 用户id
		nvps.add(new BasicNameValuePair("accid", userid.toString()));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}

	/**
	 * 拉人进群
	 * 
	 * @throws Exception
	 **/
	public static int larenGroup(Long groupid, Long userid, Integer magree, String otherids) throws Exception {
		
		// 设置头部请求信息
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.TEAMADD);
		
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		// 群id
		nvps.add(new BasicNameValuePair("tid", groupid.toString()));
		// 群组id
		nvps.add(new BasicNameValuePair("owner", userid.toString()));
		String magredCode = "";
		if (magree == 0) {
			magredCode = "1";
		}
		if (magree == 1) {
			magredCode = "0";
		}
		nvps.add(new BasicNameValuePair("magree", magredCode));
		nvps.add(new BasicNameValuePair("msg", "邀请你加入"));
		// 成员id的集合
		nvps.add(new BasicNameValuePair("members", "[" + otherids + "]"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}

	/**更新用户信息**/
	public static int updateUser(Long accid, String name, String icon, String sign, String mobile, String email,
			String birth, String gender) throws Exception {
		// 设置请求头部信息
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.UPDATEUSERINFO);
	
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid", accid.toString()));
		// 用户昵称
		if (CheckDataUtil.checkNotEmpty(name))
			nvps.add(new BasicNameValuePair("name", name));
		// 用户头像
		if (CheckDataUtil.checkNotEmpty(icon))
			nvps.add(new BasicNameValuePair("icon", icon));
		// 用户签名
		if (CheckDataUtil.checkNotEmpty(sign))
			nvps.add(new BasicNameValuePair("sign", sign));
		// 电话号码
		if (CheckDataUtil.checkNotEmpty(mobile))
			nvps.add(new BasicNameValuePair("mobile", mobile));
		// 邮箱地址
		if (CheckDataUtil.checkNotEmpty(email))
			nvps.add(new BasicNameValuePair("email", email));
		// 生日
		if (CheckDataUtil.checkNotEmpty(birth))
			nvps.add(new BasicNameValuePair("birth", birth));
		// 性别
		if (CheckDataUtil.checkNotEmpty(gender))
			nvps.add(new BasicNameValuePair("gender", gender));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}
	
	
	/**发送通知短信**/
	public static Map<String, Object> CodeCheckMess(String TEMPLATEID, String PHONE) {
		Map<String, Object> returnmap = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.SENDTEMPLATE);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
		nvps.add(new BasicNameValuePair("mobiles", "["+PHONE+"]"));
		nvps.add(new BasicNameValuePair("params", "['【','】']"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			// 执行请求
			HttpResponse response = httpClient.execute(httpPost);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");
			net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
			returnmap = (Map<String, Object>) jsonobj;
			return returnmap;
		} catch (Exception e) {
			e.printStackTrace();
			return returnmap;
		}
		
		
	}
	
	
	
	/**发送通知短信**/
	public static Map<String, Object> upload(MultipartFile content) {
		Map<String, Object> returnmap = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = SetSendHead(WangYiCommon.FILE_UPLOAD);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		try {
			nvps.add(new BasicNameValuePair("content", Base64.encode(content.getBytes())));
			/**
			 * 0 表示文本消息,
				1 表示图片，
				2 表示语音，
				3 表示视频，
				4 表示地理位置信息，
				6 表示文件，
				100 自定义消息类型（特别注意，对于未对接易盾反垃圾功能的应用，该类型的消息不会提交反垃圾系统检测）
			 * 
			 * */
			
			nvps.add(new BasicNameValuePair("type", "3"));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			// 执行请求
			HttpResponse response = httpClient.execute(httpPost);
			String str = EntityUtils.toString(response.getEntity(), "utf-8");
			net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
			System.out.println(jsonobj);               
			returnmap = (Map<String, Object>) jsonobj;
			return returnmap;
		} catch (Exception e) {
			e.printStackTrace();
			return returnmap;
		}
		
		
	}

	public static void main(String[] args) {
		//
		try {
			larenGroup(1572379244L, 10005740L, 1, "10000525");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
