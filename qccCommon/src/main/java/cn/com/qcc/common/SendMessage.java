package cn.com.qcc.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import WangYiUtil.WangYiCommon;

/*
功能:		1xinxi.cn HTTP接口 发送短信

说明:		
http://sms.1xinxi.cn/asmx/smsservice.aspx?name=登录名&pwd=接口密码&mobile=手机号码&content=内容&sign=签名&st
ime=发送时间&type=pt&extno=自定义扩展码
 */
@SuppressWarnings({ "unchecked", "deprecation", "resource", "static-access" })
public class SendMessage {

	// 发送验证码的请求路径URL
	// 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
	private static final String APP_KEY = "00481cb45c031fe722c155d3f321dac0";
	// 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
	private static final String APP_SECRET = "f2f1c46cc596";
	// 验证码长度，范围4～10，默认为4
	private static final String CODELEN = "4";
	
	
	/**
	 * 发送验证码相关的模板方法
	 * @param TEMPLATEID : 模板ID主键
	 * @param phone : 电话号码
	 * **/
	public static Map<String, Object> doCodeSendMess(String TEMPLATEID , Long phone) {
		Map<String, Object> resutMap = CodeCheckMess(TEMPLATEID , phone.toString());
		return resutMap;
	}
	
	
	
	
	
	


	/**
	 * @param args
	 * @throws IOException
	 *             注册的验证码
	 */
	public static Map<String, String> passwordrelive(Long phone, HttpServletRequest request) throws IOException {
		int radomInt = new Random().nextInt(9999);
		String code = String.valueOf(radomInt);
		// 发送内容
		String content = "您好，您初次登录账户：" + phone + ",默认密码为：111111。";
		String sign = "七彩巢";

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=wylsz888@163.com");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=0899CED2A4D504A25A49D6712145");

		// 向StringBuffer追加手机号码
		sb.append("&mobile=" + phone);

		// 向StringBuffer追加消息内容转URL标准码
		content = java.net.URLEncoder.encode(content, "UTF-8");
		content = java.net.URLEncoder.encode(content, "UTF-8");
		content = java.net.URLDecoder.decode(content, "UTF-8");
		sb.append("&content=" + java.net.URLDecoder.decode(content, "UTF-8"));

		// 加签名
		sign = java.net.URLEncoder.encode(sign, "UTF-8");
		sign = java.net.URLEncoder.encode(sign, "UTF-8");
		sign = java.net.URLDecoder.decode(sign, "UTF-8");
		sb.append("&sign=" + java.net.URLDecoder.decode(sign, "UTF-8"));

		// 追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");

		// type为固定值pt extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");

		// 创建url对象
		// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		InputStream is = url.openStream();

		// 转换返回值
		String returnStr = SendMessage.convertStreamToString(is);

		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
		// 返回发送结果

		Map<String, String> ss = new HashMap<String, String>();
		ss.put("returnStr", returnStr);
		ss.put("code", code);
		// 尝试用session解决
		HttpSession session = request.getSession();
		// session存活时间
		session.setMaxInactiveInterval(300);
		// session.removeAttribute("code");
		session.setAttribute("code", code);
		return ss;
	}

	
	
	
	/**
	 * 验证码短信的发送
	 * @param TEMPLATEID : 模板id
	 * @param PHONE : 电话号码
	 * ***/
	private static Map<String, Object> CodeCheckMess(String TEMPLATEID, String PHONE) {
		Map<String, Object> returnmap  = new HashMap<>();;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(WangYiCommon.SENDCODEURL);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		// 设置请求的的参数，requestBody参数
		int radomInt = new Random().nextInt(9999);
		String code = String.valueOf(radomInt);
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, code, curTime);
		// 设置请求的header
		httpPost.addHeader("AppKey", APP_KEY);
		httpPost.addHeader("Nonce", code);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
		nvps.add(new BasicNameValuePair("mobile", PHONE));
		nvps.add(new BasicNameValuePair("codeLen", CODELEN));
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
	
	
	
	

	/**
	 * 找回密码
	 * 
	 * @param phone
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> getCodeFindPwd(Long phone, HttpServletRequest request) throws IOException {
		int radomInt = new Random().nextInt(9999);
		String code = String.valueOf(radomInt);
		// 发送内容
		String content = "亲爱的七彩巢用户您好,您此次修改密码的验证码为:" + code + ",验证码五分钟内有效。";
		String sign = "七彩巢";

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=wylsz888@163.com");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=0899CED2A4D504A25A49D6712145");

		// 向StringBuffer追加手机号码
		sb.append("&mobile=" + phone);

		// 向StringBuffer追加消息内容转URL标准码
		content = java.net.URLEncoder.encode(content, "UTF-8");
		content = java.net.URLEncoder.encode(content, "UTF-8");
		content = java.net.URLDecoder.decode(content, "UTF-8");
		sb.append("&content=" + java.net.URLDecoder.decode(content, "UTF-8"));

		// 加签名
		sign = java.net.URLEncoder.encode(sign, "UTF-8");
		sign = java.net.URLEncoder.encode(sign, "UTF-8");
		sign = java.net.URLDecoder.decode(sign, "UTF-8");
		sb.append("&sign=" + java.net.URLDecoder.decode(sign, "UTF-8"));

		// 追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");

		// type为固定值pt extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");

		// 创建url对象
		// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		InputStream is = url.openStream();

		// 转换返回值
		String returnStr = SendMessage.convertStreamToString(is);

		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
		// 返回发送结果

		Map<String, String> ss = new HashMap<String, String>();
		ss.put("returnStr", returnStr);
		// ss.put("code", code);
		// 尝试用session解决
		HttpSession session = request.getSession();
		// session存活时间
		session.setMaxInactiveInterval(300);
		// session.removeAttribute("code");
		session.setAttribute("code", code);
		return ss;

	}

	/**
	 * 找回密码
	 * 
	 * @param phone
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws MalformedURLException
	 * @throws ProtocolException
	 * @throws IOException
	 */
	public static Map<String, String> houseundercarriage(Long phone, String content, HttpServletRequest request) {
		int radomInt = new Random().nextInt(9999);
		String code = String.valueOf(radomInt);

		String sign = "七彩巢";

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=wylsz888@163.com");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=0899CED2A4D504A25A49D6712145");

		// 向StringBuffer追加手机号码
		sb.append("&mobile=" + phone);
		Map<String, String> ss = new HashMap<String, String>();
		try {
			// 向StringBuffer追加消息内容转URL标准码
			content = java.net.URLEncoder.encode(content, "UTF-8");
			content = java.net.URLEncoder.encode(content, "UTF-8");
			content = java.net.URLDecoder.decode(content, "UTF-8");
			sb.append("&content=" + java.net.URLDecoder.decode(content, "UTF-8"));

			// 加签名
			sign = java.net.URLEncoder.encode(sign, "UTF-8");
			sign = java.net.URLEncoder.encode(sign, "UTF-8");
			sign = java.net.URLDecoder.decode(sign, "UTF-8");
			sb.append("&sign=" + java.net.URLDecoder.decode(sign, "UTF-8"));
			// 追加发送时间，可为空，为空为及时发送
			sb.append("&stime=");

			// type为固定值pt extno为扩展码，必须为数字 可为空
			sb.append("&type=pt&extno=");

			// 创建url对象
			// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
			URL url = new URL(sb.toString());

			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("POST");

			// 发送
			InputStream is = url.openStream();
			// 转换返回值
			String returnStr = SendMessage.convertStreamToString(is);
			// 返回发送结果

			ss.put("returnStr", returnStr);
			// ss.put("code", code);
			// 尝试用session解决
			HttpSession session = request.getSession();
			// session存活时间
			session.setMaxInactiveInterval(300);
			// session.removeAttribute("code");
			session.setAttribute("code", code);
			return ss;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ss;

		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档

	}

	/**
	 * 找回密码
	 */
	public static Map<String, String> qunfa(Long phone, String content, HttpServletRequest request) throws Exception {
		int radomInt = new Random().nextInt(9999);
		String code = String.valueOf(radomInt);

		String sign = "七彩巢";

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=wylsz888@163.com");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=0899CED2A4D504A25A49D6712145");

		// 向StringBuffer追加手机号码
		sb.append("&mobile=" + phone);

		// 向StringBuffer追加消息内容转URL标准码
		content = java.net.URLEncoder.encode(content, "UTF-8");
		content = java.net.URLEncoder.encode(content, "UTF-8");
		content = java.net.URLDecoder.decode(content, "UTF-8");
		sb.append("&content=" + java.net.URLDecoder.decode(content, "UTF-8"));

		// 加签名
		sign = java.net.URLEncoder.encode(sign, "UTF-8");
		sign = java.net.URLEncoder.encode(sign, "UTF-8");
		sign = java.net.URLDecoder.decode(sign, "UTF-8");
		sb.append("&sign=" + java.net.URLDecoder.decode(sign, "UTF-8"));

		// 追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");

		// type为固定值pt extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");

		// 创建url对象
		// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		InputStream is = url.openStream();

		// 转换返回值
		String returnStr = SendMessage.convertStreamToString(is);

		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
		// 返回发送结果

		Map<String, String> ss = new HashMap<String, String>();
		ss.put("returnStr", returnStr);
		// ss.put("code", code);
		// 尝试用session解决
		HttpSession session = request.getSession();
		// session存活时间
		session.setMaxInactiveInterval(300);
		// session.removeAttribute("code");
		session.setAttribute("code", code);
		return ss;

	}


	/**
	 * 转换返回值类型为UTF-8格式.
	 * 
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {
		StringBuilder sb1 = new StringBuilder();
		byte[] bytes = new byte[4096];
		int size = 0;

		try {
			while ((size = is.read(bytes)) > 0) {
				String str = new String(bytes, 0, size, "UTF-8");
				sb1.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb1.toString();
	}

	/**
	 */
	@SuppressWarnings("unused")
	public static void sendHouseOrder(String phone, HttpServletRequest request) {
		String content = "您好，您预订的房源订金已支付成功等待房东确认。";
	}



	public static void main(String[] args) {

	}










	

}
