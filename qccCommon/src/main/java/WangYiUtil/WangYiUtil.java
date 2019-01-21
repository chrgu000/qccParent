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
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.CheckSumBuilder;
import cn.com.qcc.common.JsonUtils;

@SuppressWarnings({ "deprecation","resource", "static-access","unchecked" })
public class WangYiUtil {

	public static Map<String, Object> getACCIDANDTOKEN(Long userid, String name, String icon)
			throws ParseException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/user/create.action";
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
		String nonce = "123456";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);// 参考
		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid", userid + "")); // 用户唯一标识用userid
		nvps.add(new BasicNameValuePair("name", name)); // 用户昵称
		nvps.add(new BasicNameValuePair("icon", icon)); // 用户头像
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
	@SuppressWarnings("unused")
	public static void piliangqiuzu(String body, String toAccids) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = "https://api.netease.im/nimserver/msg/sendBatchMsg.action";
		HttpPost httpPost = new HttpPost(url);
		String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
		String nonce = "123456";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);// 参考
		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("fromAccid", "10088")); // 用户唯一标识用userid
		nvps.add(new BasicNameValuePair("toAccids", toAccids)); // 用户唯一标识用userid
																// "[10000525,10001696]"
		nvps.add(new BasicNameValuePair("type", "0")); // 用户唯一标识用userid
		nvps.add(new BasicNameValuePair("body", "{'msg':'" + body + "'}")); // 用户唯一标识用userid
																			// "{'msg':'深圳最新上市20+求租--深圳求租--EDIT--18316999864'}"
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 执行请求
		HttpResponse response;
		try {
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 移除网易云不喜欢的求租房源
	public static Map<String, Object> removenotlike(String userid, String msgid, String time, String fromuserid)
			throws ParseException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String url = WangYiCommon.recallurl;
		HttpPost httpPost = new HttpPost(url);
		String appKey = WangYiCommon.APPKEY;
		String appSecret = WangYiCommon.APPSecret;
		String nonce = WangYiCommon.nonce;
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);// 参考
		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("deleteMsgid", msgid)); // 用户唯一标识用userid
		nvps.add(new BasicNameValuePair("from", fromuserid)); // 用户唯一标识用userid
		nvps.add(new BasicNameValuePair("timetag", time)); // 用户昵称
		nvps.add(new BasicNameValuePair("type", "7")); // 用户昵称
		nvps.add(new BasicNameValuePair("to", userid)); // 用户昵称
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
	
	
	
	
	
	 public static String updatetoken(long userid)  throws Exception{
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        // 更新TOKEN
	        String url = "https://api.netease.im/nimserver/user/refreshToken.action"; 
	        HttpPost httpPost = new HttpPost(url);

	        String appKey = "00481cb45c031fe722c155d3f321dac0";
			String appSecret = "f2f1c46cc596";
	        String nonce =  "12345";
	        String curTime = String.valueOf((new Date()).getTime() / 1000L);
	        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码

	        // 设置请求的header
	        httpPost.addHeader("AppKey", appKey);
	        httpPost.addHeader("Nonce", nonce);
	        httpPost.addHeader("CurTime", curTime);
	        httpPost.addHeader("CheckSum", checkSum);
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	        // 设置请求的参数
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        nvps.add(new BasicNameValuePair("accid", userid+""));
	        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
	        // 执行请求
	        HttpResponse response = httpClient.execute(httpPost);
	        String str = EntityUtils.toString(response.getEntity(), "utf-8");
			net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
			Map<String, Object> map = (Map<String, Object>) jsonobj;
			String acctoken = "" ;
			String ssobj = map.get("info").toString();
			if (map.get("code").equals(200)) {
				net.sf.json.JSONObject obj = new net.sf.json.JSONObject().fromObject(ssobj);
				WangYiPoJo wpojo = (WangYiPoJo) jsonobj.toBean(obj, WangYiPoJo.class);
				acctoken = wpojo.getToken();
			}
	        return acctoken;
	        //  {"code":200,"info":{"token":"234b9fbb1607ee376c45fccea05a341f","accid":"10001765"}}
	        // 打印执行结果
	    }
	 
	 
	/**创建群组
	 * @param groupName : 群名称
	 * @param userid : 群主id
	 * @param descName : 群描述、
	 * @param icon : 群图像
	 * **/
	public static String createGroup(String groupName , Long userid,String descName,String icon,String otherids) throws Exception {
		String insertUser = "1";
		if (CheckDataUtil.checkNotEmpty(otherids)) {
			insertUser = otherids;
		}
		DefaultHttpClient httpClient = new DefaultHttpClient();
        // 创建群组
        String url = "https://api.netease.im/nimserver/team/create.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        // 群名称
        nvps.add(new BasicNameValuePair("tname", groupName));
        //群主
        nvps.add(new BasicNameValuePair("owner", userid.toString()));
        //插播字段
        nvps.add(new BasicNameValuePair("members", "["+insertUser+"]"));
        nvps.add(new BasicNameValuePair("msg", "1"));
        // 群描述
        nvps.add(new BasicNameValuePair("intro", descName));
       /* nvps.add(new BasicNameValuePair("type", "true"));*/
        // 谁可以修改群资料，0-管理员,1-所有人
        nvps.add(new BasicNameValuePair("uptinfomode", "0"));
        // 谁可以邀请他人入群，0-管理员,1-所有人
        nvps.add(new BasicNameValuePair("invitemode", "1"));
        // 被邀请人同意方式，0-需要同意(默认),1-不需要同意
        nvps.add(new BasicNameValuePair("beinvitemode", "1"));
        // 管理后台建群时，0不需要被邀请人同意加入群，1需要被邀请人同意才可以加入群
        nvps.add(new BasicNameValuePair("magree", "0"));
        //群头像
        nvps.add(new BasicNameValuePair("icon", icon));
        // 0不用验证，1需要验证,2不允许任何人加入。
        nvps.add(new BasicNameValuePair("joinmode", "0"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		System.out.println(jsonobj);
		String code = map.get("code").toString();
		System.out.println(code);
		String tid = "";
		if (code.equals("200")) {
			tid = map.get("tid").toString();
			if (CheckDataUtil.checkisEqual(insertUser, 1)) {
				levelGroup(Long.valueOf(tid), userid);
			}
		}
		return tid;
		 
	 }
	
	/**
	 * 获取用户群组信息
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * **/
	public static List<TeamPojo> getGrupByUserid (Long userid) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/team/joinTeams.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", userid+""));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		System.out.println(jsonobj);
		String ssobj = map.get("infos").toString();
		List<TeamPojo> team = JsonUtils.jsonToList(ssobj, TeamPojo.class);
		return team;
	}
	
	/**编辑群组
	 * @param tid  : 编辑的用户
	 * @param ownid : 群主id
	 * @param tname : 群名称
	 * @param descName : 群描述
	 * @param icon : 群图像
	 * @param joinmode : 加入群模式
	 * **/
    public static Integer editGroup(Long tid , Long ownid,String tname,String descName,String icon
    		,Integer joinmode ,Integer invitemode,Integer beinvitemode) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/team/update.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("tid", tid.toString()));
        nvps.add(new BasicNameValuePair("tname", tname));
        nvps.add(new BasicNameValuePair("owner", ownid.toString()));
        nvps.add(new BasicNameValuePair("intro", descName));
        // 群建好后，sdk操作时，0不用验证，1需要验证,2不允许任何人加入。
        nvps.add(new BasicNameValuePair("joinmode",joinmode.toString()));
        nvps.add(new BasicNameValuePair("icon", icon));
        nvps.add(new BasicNameValuePair("invitemode", invitemode.toString()));
        String magredCode = "";
        if (beinvitemode == 0) {magredCode = "1";}
        if (beinvitemode == 1) {magredCode = "0";}
        nvps.add(new BasicNameValuePair("beinvitemode", beinvitemode.toString()));
        nvps.add(new BasicNameValuePair("magree", magredCode));
        /*nvps.add(new BasicNameValuePair("advanced","true"));*/
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		System.out.println(jsonobj);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}
	
	
	public static Integer deleteGroup(Long tid , Long userid) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/team/remove.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("tid", tid.toString()));
        nvps.add(new BasicNameValuePair("owner", userid.toString()));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		System.out.println(jsonobj);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}
	
	
	public static Integer levelGroup(Long tid , Long userid) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/team/leave.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("tid", tid.toString()));
        nvps.add(new BasicNameValuePair("accid", userid.toString()));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		System.out.println(jsonobj);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}
	
	/**拉人进群
	 * @throws Exception **/
	public static int larenGroup(Long groupid, Long userid,Integer magree, String otherids) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/team/add.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("tid", groupid.toString()));
        nvps.add(new BasicNameValuePair("owner", userid.toString()));
        String magredCode = "";
        if (magree == 0) {magredCode = "1";}
        if (magree == 1) {magredCode = "0";}
        nvps.add(new BasicNameValuePair("magree",magredCode));
        nvps.add(new BasicNameValuePair("msg", "邀请你加入"));
        nvps.add(new BasicNameValuePair("members",  "["+otherids+"]"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		System.out.println(jsonobj);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}
	
	public static int updateUser(Long accid, String name,String icon, String sign
			,String mobile, String email ,String birth,String gender) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/user/updateUinfo.action"; 
        HttpPost httpPost = new HttpPost(url);
        String appKey = "00481cb45c031fe722c155d3f321dac0";
		String appSecret = "f2f1c46cc596";
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", accid.toString()));
        if (CheckDataUtil.checkNotEmpty(name))
        	nvps.add(new BasicNameValuePair("name", name));
        if (CheckDataUtil.checkNotEmpty(icon)) 
        	nvps.add(new BasicNameValuePair("icon", icon));
        if (CheckDataUtil.checkNotEmpty(sign)) 
            nvps.add(new BasicNameValuePair("sign", sign));
        if (CheckDataUtil.checkNotEmpty(mobile)) 
            nvps.add(new BasicNameValuePair("mobile", mobile));
        if (CheckDataUtil.checkNotEmpty(email)) 
        	nvps.add(new BasicNameValuePair("email",email));
        if (CheckDataUtil.checkNotEmpty(birth)) 
        	nvps.add(new BasicNameValuePair("birth",birth));
        if (CheckDataUtil.checkNotEmpty(gender)) 
        	nvps.add(new BasicNameValuePair("gender",gender));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "utf-8");
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(str);
		System.out.println(jsonobj);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		return Integer.parseInt(map.get("code").toString());
	}
	
	
	
	
	 public static void main (String [] args) {
		
	 }
	 
	 

}
