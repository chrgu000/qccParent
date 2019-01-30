package cn.com.qcc.tenement.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
@SuppressWarnings({ "resource", "unchecked", "deprecation" })
@Controller
public class WeiXinPhoneController {
	
	
	@RequestMapping("/getweixphone")
	@ResponseBody
	public  ResultMap getPhoneNumber(String encryptedData, String code, String iv ,String descname) throws UnsupportedEncodingException {
		
		if (encryptedData == null || encryptedData=="" || "undefined".equals(encryptedData)
				|| iv == null || iv=="" || "undefined".equals(iv)) {
			return ResultMap.build(400,"用户拒绝授权");
		}
		
		
		String session_key="";
		try {
			
			if ("qcc".equals(descname)) {
				session_key = get_qcc_weixinuseridbyxiaochengxu(code);
			} else if ("gzfzz".equals(descname) || "gzf".equals(descname)) {
				session_key = get_gzf_weixinuseridbyxiaochengxu(code);
			} else if ("fdzz".equals(descname)) {
				session_key = get_fdzz_weixinuseridbyxiaochengxu(code);
			} else {
				return ResultMap.build(400, "参数错误");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			 return ResultMap.build(402, "连接超时,请重新获取!");
		}
		// iv  ="oNq+wNln2UPx7wX0QZpVxw=="; 
			 // 被加密的数据
            byte[] dataByte = cn.com.qcc.common.Base64.decode(encryptedData);
            // 加密秘钥
            byte[] keyByte =cn.com.qcc.common.Base64.decode(session_key);
            // 偏移量
            byte[] ivByte = cn.com.qcc.common.Base64.decode(iv);
            try {
                // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
                int base = 16;
                if (keyByte.length % base != 0) {
                    int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                    byte[] temp = new byte[groups * base];
                    Arrays.fill(temp, (byte) 0);
                    System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                    keyByte = temp;
                }
               
                // 初始化
                Security.addProvider(new BouncyCastleProvider());
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//NoPadding   PKCS5Padding
                SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
                AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
                parameters.init(new IvParameterSpec(ivByte));
                cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
                byte[] resultByte = cipher.doFinal(dataByte);
                if (null != resultByte && resultByte.length > 0) {
                    String result = new String(resultByte, "UTF-8");
                    Object obj =  JSONObject.parseObject(result);
                    return ResultMap.IS_200(obj);
                }
            } catch (Exception e) {
                return ResultMap.build(402,"连接超时,请重新获取!");
            }
		
		return null;
	}
	
	
	public String get_qcc_weixinuseridbyxiaochengxu(String code) throws IOException {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + 
				PayCommonConfig.qcc_xiaochengxuappid + "&secret=" + 
				PayCommonConfig.qcc_xiaochengxuSecret + "&js_code="
				+ code + "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse res = client.execute(post);
		String sss = "";
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> jsonOb = mapper.readValue(str, Map.class);
			 sss = jsonOb.get("session_key").toString();
			
		}
		return sss;
	}
	
	
	
	public String get_gzf_weixinuseridbyxiaochengxu(String code) throws IOException {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + 
				PayCommonConfig.gzfzz_xiaochengxuappid + "&secret=" + 
				PayCommonConfig.gzfzz_xiaochengxuSecret + "&js_code="
				+ code + "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse res = client.execute(post);
		String sss = "";
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> jsonOb = mapper.readValue(str, Map.class);
			 sss = jsonOb.get("session_key").toString();
			
		}
		return sss;
	}
	
	
	
	public String get_fdzz_weixinuseridbyxiaochengxu(String code) throws IOException {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + 
				PayCommonConfig.fdzz_xiaochengxuappid + "&secret=" + 
				PayCommonConfig.fdzz_xiaochengxuSecret + "&js_code="
				+ code + "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse res = client.execute(post);
		String sss = "";
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> jsonOb = mapper.readValue(str, Map.class);
			 sss = jsonOb.get("session_key").toString();
			
		}
		return sss;
	}
	


}
