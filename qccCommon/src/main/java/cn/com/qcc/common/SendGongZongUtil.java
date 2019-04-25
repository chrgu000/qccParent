package cn.com.qcc.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import cn.com.qcc.detailcommon.WX_UserUtil;
import net.sf.json.JSONObject;
import weixin.util.MD5Util;
import weixin.util.MyX509TrustManager;
import weixin.util.TemplateData;

public class SendGongZongUtil {

	public static String SendMess(WxTemplate template, KeyWordUtil keyWordUtil) {
		String ACCESS_TOKEN = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);// 获取AccessToken
		Integer state = WX_UserUtil.subscribeState(template.getTouser() ,ACCESS_TOKEN);
		if (CheckDataUtil.checkNotEqual(state, 1) ) {
			return "FAIL";
		}
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		m.put("first", new TemplateData(keyWordUtil.getTitle(), "#8B8378"));
		m.put("keyword1", new TemplateData(keyWordUtil.getKeyword1(), "#000000"));
		m.put("keyword2", new TemplateData(keyWordUtil.getKeyword2(), "#000000"));
		m.put("keyword3", new TemplateData(keyWordUtil.getKeyword3(), "#000000"));
		m.put("keyword4", new TemplateData(keyWordUtil.getKeyword4(), "#000000"));
		m.put("keyword5", new TemplateData(keyWordUtil.getKeyword5(), "#000000"));
		m.put("remark", new TemplateData(keyWordUtil.getRemark(), "blue"));
		template.setData(m);
		JSONObject jsonobj = httpRequest(
				"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + ACCESS_TOKEN + "", "POST",
				JSONObject.fromObject(template).toString());
		System.out.println(jsonobj);
		
		return "SUCCESS" ;

	}

	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
