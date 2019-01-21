package cn.com.qcc.common;



import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
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
import java.io.IOException;
import java.io.InputStream;


//import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public class HttpSign {
	
	@SuppressWarnings({ "static-access", "unchecked" })
	public static boolean checkuserrealmessage(String realname,String idcard){
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
		Map<String, Object> map = (Map<String, Object>)jsonobj;
		String code = (String)map.get("code");
		String message = (String)map.get("message");
		if ("10000".equals(code) && "成功".equals(message)) {
			Map<String,Object> data =(Map<String,Object>) map.get("data");
			String returnstr  = (String)data.get("result");
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
        String sign =  MD5.MD5Encode(sb.toString()).toUpperCase();
        return sign;

    }
    
    
    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
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
     * @param children
     * @return String
     */
    @SuppressWarnings("rawtypes")
	public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(HttpSign.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }


}
