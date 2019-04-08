package cn.com.qcc.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import weixin.util.MD5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

//import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.detailcommon.AccountMgr;

@SuppressWarnings("deprecation")
public class HttpSign {

	private final static String qnweb_path = "http://www.hadoop.zzw777.com/";

	@SuppressWarnings({ "static-access", "unchecked" })
	public static boolean checkuserrealmessage(String realname, String idcard) {
		// 接口地址
		String url = "http://api.chinadatapay.com/communication/personal/1882";
		// 请求参数
		Map<String, Object> params = new HashMap<>();
		// 输入数据宝提供的 key
		params.put("key", "4def75055ed4c80ea09c88161b08162e");
		// 输入局被查询手机号码
		params.put("name", realname);
		params.put("idcard", idcard);
		String result = null;
		try {
			result = post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(result);
		Map<String, Object> map = (Map<String, Object>) jsonobj;
		String code = (String) map.get("code");
		String message = (String) map.get("message");
		if ("10000".equals(code) && "成功".equals(message)) {
			Map<String, Object> data = (Map<String, Object>) map.get("data");
			String returnstr = (String) data.get("result");
			if ("1".equals(returnstr)) {
				return true;
			}
		}
		return false;
	}

	public static String post(String url, Map<String, Object> params) throws Exception {
		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		return PostHttpRequest(url, pairs);
	}

	public static String PostHttpRequest(String Url, List<NameValuePair> params) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		// 超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(300000).setConnectTimeout(300000)

				.build();
		String result = null;
		try {
			HttpPost request = new HttpPost(Url);
			request.setConfig(requestConfig);
			request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			HttpResponse respones = client.execute(request);
			if (respones.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(respones.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return result;
	}

	private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
		ArrayList<NameValuePair> pairs = new ArrayList<>();
		if (params == null || params.size() == 0) {
			return pairs;
		}
		for (Map.Entry<String, Object> param : params.entrySet()) {
			Object value = param.getValue();
			if (value instanceof String[]) {
				String[] values = (String[]) value;
				for (String v : values) {
					pairs.add(new BasicNameValuePair(param.getKey(), v));
				}
			} else {
				if (value instanceof Integer) {
					value = Integer.toString((Integer) value);
				} else if (value instanceof Long) {
					value = Long.toString((Long) value);
				}
				pairs.add(new BasicNameValuePair(param.getKey(), (String) value));
			}
		}
		return pairs;
	}

	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(SortedMap<String, String> packageParams, String key) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		String sign = MD5.MD5Encode(sb.toString()).toUpperCase();
		return sign;

	}

	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * 
	 * @param strxml
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map doXMLParse(String strxml) throws Exception {
		if (null == strxml || "".equals(strxml)) {
			return null;
		}
		Map m = new HashMap();
		InputStream in = String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = HttpSign.getChildrenText(children);
			}
			m.put(k, v);
		}
		// 关闭流
		in.close();
		return m;
	}

	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * 获取子结点的xml
	 * 
	 * @param children
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if (!children.isEmpty()) {
			Iterator it = children.iterator();
			while (it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if (!list.isEmpty()) {
					sb.append(HttpSign.getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}

		return sb.toString();
	}

	@SuppressWarnings({ "static-access", "unchecked", "resource" })
	public static ResultMap OCRsign(MultipartFile first, MultipartFile second) {

		try {
			if (first.isEmpty())
				return ResultMap.build(400, "选择文件");
			String returnPath = "";
			String secondPath = "";
			String originName = first.getOriginalFilename();
			String secondName = second.getOriginalFilename();
			File uploadFile = null;
			String key = "";
			if (originName.contains(".jpg") || originName.contains(".png")) {
				// 获取文件后缀
				String lastName = originName.substring(originName.lastIndexOf("."), originName.length());
				// 设置上传的key
				key = IDUtils.genItemId() + lastName;
				// 上传到远程服务器
				SimpleUpload.doUpload(first, key);
				// 设置返回的路径
				returnPath += qnweb_path + key;
				uploadFile = new File(AccountMgr.LOCAL_UPLOAD_PATH + key);
				first.transferTo(uploadFile);
			} else {
				return ResultMap.build(400, "文件格式错误");
			}

			if (secondName.contains(".jpg") || secondName.contains(".png")) {
				// 获取文件后缀
				String lastName = originName.substring(originName.lastIndexOf("."), originName.length());
				// 设置上传的key
				String secondkey = IDUtils.genItemId() + lastName;
				// 上传到远程服务器
				SimpleUpload.doUpload(second, secondkey);
				// 设置返回的路径
				secondPath += qnweb_path + secondkey;
			}

			System.out.println("七牛云上传路径:" + returnPath);

			String POST_URL = "https://file.chinadatapay.com/img/upload?appkey=ecc71e33d7d3fd770e3c29dfeaada770";
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost post = new HttpPost(POST_URL);
			FileBody fileBody = new FileBody(uploadFile);
			MultipartEntity entity = new MultipartEntity();
			entity.addPart("data", fileBody);
			post.setEntity(entity);
			HttpResponse response = httpclient.execute(post);
			HttpEntity r_entity = response.getEntity();
			String result = EntityUtils.toString(r_entity);
			System.out.println("返回结果：" + result);
			// 你需要根据出错的原因判断错误信息，并修改
			httpclient.getConnectionManager().shutdown();
			net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(result);
			Map<String, Object> map = (Map<String, Object>) jsonobj;
			String code = (String) map.get("code");
			String data = (String) map.get("data");
			String message = (String) map.get("message");
			if (!"10000".equals(code)) {
				return ResultMap.build(400, message);
			}
			String url = "http://api.chinadatapay.com/trade/user/1985";
			// 请求参数
			Map<String, Object> params = new HashMap<>();
			// 输入数据宝提供的 key
			params.put("key", "ecc71e33d7d3fd770e3c29dfeaada770");
			// 输入局被查询手机号码
			params.put("imageId", data);
			String ocrResult = HttpSign.post(url, params);
			jsonobj = new net.sf.json.JSONObject().fromObject(ocrResult);
			map = (Map<String, Object>) jsonobj;
			code = (String) map.get("code");

			net.sf.json.JSONObject dataMap = new net.sf.json.JSONObject().fromObject(map.get("data"));
			Map<String, Object> resultMap = (Map<String, Object>) dataMap;
			resultMap.put("firstPath", returnPath);
			resultMap.put("secondPath", secondPath);
			resultMap.put("filePath", AccountMgr.LOCAL_UPLOAD_PATH + key);
			System.out.println(resultMap);
			message = (String) map.get("message");

			// 如果code 10000 和data 非空实名成
			if ("10000".equals(code) && data != null) {
				return ResultMap.build(200, "", resultMap);
			} else {
				return ResultMap.build(400, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "服务器异常");
		}

	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public static ResultMap OCRsign(String orcPath) {
		
		try {
			String url = "http://api.chinadatapay.com/trade/user/1985";
			// 请求参数
			Map<String, Object> params = new HashMap<>();
			// 输入数据宝提供的 key
			params.put("key", "ecc71e33d7d3fd770e3c29dfeaada770");
			// 输入局被查询手机号码
			params.put("imageId", orcPath);
			String ocrResult = HttpSign.post(url, params);
			net.sf.json.JSONObject  jsonobj = new net.sf.json.JSONObject().fromObject(ocrResult);
			Map<String, Object> map = (Map<String, Object>) jsonobj;
			String code = (String) map.get("code");

			net.sf.json.JSONObject dataMap = new net.sf.json.JSONObject().fromObject(map.get("data"));
			Map<String, Object> resultMap = (Map<String, Object>) dataMap;
			System.out.println(resultMap);
			String message = (String) map.get("message");

			// 如果code 10000 和data 非空实名成
			if ("10000".equals(code) ) {
				return ResultMap.build(200, "", resultMap);
			} else {
				return ResultMap.build(400, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "数据宝异常");
		}
		
	}

}
