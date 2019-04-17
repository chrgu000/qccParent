package weixin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import net.sf.json.JSONObject;

@SuppressWarnings("deprecation")
public class XiaoChengXuCodeUtil {
	private final static String qcc_appID  = "wxb22593f52614a217";
	private final static String qcc_appScret  = "b01251595b6d2870e07197c512b57031";
	private final static String bathpath = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=";
	
	//楼栋生成的二维码
	public static String make_qcc_xcxqcode(Long detailid,String descname) {
		String accestoken = IDUtils.getxiaoAccessToken(qcc_appID, qcc_appScret);
		String returnpath = "";
		String prefix = "qcc_";
		try {
			returnpath = buildingGetPostUrl( accestoken, prefix + detailid,descname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnpath;
	}
	
	
	
	//楼栋生成的二维码
	public static String make_gzf_xcxqcode(Long detailid,String descname) {
		String accestoken = IDUtils.getxiaoAccessToken(PayCommonConfig.gzfzz_xiaochengxuappid,
				PayCommonConfig.gzfzz_xiaochengxuSecret);
		String returnpath = "";
		String prefix = "gzf_";
		try {
			returnpath = buildingGetPostUrl( accestoken,prefix + detailid,descname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnpath;
	}
	 

	public static String buildingGetPostUrl( String access_token, String detailid,String descname) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("scene",descname + "-" + detailid.split("_")[1]);
		if ("test".equals(descname)) {
			map.put("scene", "hfsfsfssd" + "-" + detailid.split("_")[1]);
		}
		map.put("width", "100");// 图片大小
		JSONObject json = JSONObject.fromObject(map);
		//这里返回路径
		String res = buildinghttpPostWithJSON(bathpath + access_token, json.toString(), detailid,descname);
		return res;
	}

	@SuppressWarnings("resource")
	public static String buildinghttpPostWithJSON(String url, String json, String detailid,String descname) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		StringEntity se = new StringEntity(json);
		se.setContentType("application/json");
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "UTF-8"));
		httpPost.setEntity(se);
		HttpResponse response = httpClient.execute(httpPost);
		String imageUploadName = IDUtils.genImageName() +".png";
		if (response != null) {
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				InputStream instreams = resEntity.getContent();
				File saveFile = new File(PayCommonConfig.LOCAL_UPLOAD_PATH + imageUploadName );
				// 判断这个文件（saveFile）是否存在
				if (!saveFile.getParentFile().exists()) {
					// 如果不存在就创建这个文件夹
					saveFile.getParentFile().mkdirs();
				}
				saveToImgByInputStream(instreams, PayCommonConfig.LOCAL_UPLOAD_PATH, imageUploadName);
			}
		}
		httpPost.abort();
		return imageUploadName;
	}

	/*
	 * @param instreams 二进制流
	 * 
	 * @param imgPath 图片的保存路径
	 * 
	 * @param imgName 图片的名称
	 * 
	 * @return 1：保存正常 0：保存失败
	 */
	public static int saveToImgByInputStream(InputStream instreams, String imgPath, String imgName) {
		int stateInt = 1;
		if (instreams != null) {
			try {
				File file = new File(imgPath + imgName);// 可以是任何图片格式.jpg,.png等
				FileOutputStream fos = new FileOutputStream(file);
				byte[] b = new byte[1024];
				int nRead = 0;
				while ((nRead = instreams.read(b)) != -1) {
					fos.write(b, 0, nRead);
				}
				fos.flush();
				fos.close();
			} catch (Exception e) {
				stateInt = 0;
				e.printStackTrace();
			} finally {
				try {
					instreams.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return stateInt;
	}

}
