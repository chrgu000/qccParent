package weixin.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class MD5Util {

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public static String MD5(String s) throws Exception {
		if (s.trim() == null) {
			return "null";
		}
		MessageDigest messagedigest = MessageDigest.getInstance("MD5");
		byte[] abyte0 = s.getBytes("utf-8");
		byte[] abyte1 = messagedigest.digest(abyte0);
		return bytes2Hex(abyte1).toUpperCase();
	}

	private static String bytes2Hex(byte[] b) {
		String s = "";
		for (int i = 0; i < b.length; ++i) {
			String s1 = Integer.toHexString(b[i] & 0xFF);
			if (s1.length() == 1) {
				s = s + "0";
			}
			s = s + s1;
		}

		return s;
	}


	/**
	 * URL编码（utf-8）
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 元转换成分
	 * 
	 * @param money
	 * @return
	 */
	public static String getMoney(String amount) {
		if (amount == null) {
			return "";
		}
		// 金额转化为分为单位
		String currency = amount.replaceAll("\\$|\\￥|\\,", ""); // 处理包含, ￥
																// 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if (index == -1) {
			amLong = Long.valueOf(currency + "00");
		} else if (length - index >= 3) {
			amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
		} else if (length - index == 2) {
			amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
		} else {
			amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
		}
		return amLong.toString();
	}
	
	public static String getAccessToken(String appid, String appsecret) {  
	    String result = HttpRequestUtil.getAccessToken(appid,appsecret);  
	    JSONObject jsonObject = JSONObject.fromObject(result);  
	    System.out.println(jsonObject);
	    if (null != jsonObject) {  
	        try {  
	            result = jsonObject.getString("access_token");  
	        } catch (JSONException e) {  
	        	e.printStackTrace();
	        }  
	    }  
	    return result;  
	}  
	
	

}
