package cn.com.qcc.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import cn.com.qcc.detailcommon.AccountMgr;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class SimpleUpload {
	static Auth auth = Auth.create(AccountMgr.ACCESS_KEY, AccountMgr.SECRET_KEY);
	// 构造一个带指定Zone对象的配置类
	// zone2华南 zone0华东
	static Configuration cfg = new Configuration(Zone.zone0());
	static UploadManager uploadManager = new UploadManager(cfg);
	static String downloadpath = "d://qiniubeifen//" ;
	static String URL = "http://";
	
	
	/**视频上传*/
	@SuppressWarnings("unused")
	public static String vedioUpload (MultipartFile file , String key) {
		try {
			Response res  = uploadManager.put(file.getBytes(), key, getUpToken(AccountMgr.VIDEO,key));
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取凭证
	 * 
	 * @param bucketName
	 *            空间名称
	 * @return
	 */
	public static String getUpToken(String bucketName, String key) {
		StringMap putPolicy = new StringMap();
		putPolicy.put("insertOnly", 1);
		return auth.uploadToken(bucketName, key, 3600, putPolicy);

	}

	/**
	 * 上传
	 * 
	 * @param filePath : 文件的路径
	 * @param key  : 上传到七牛云后的名称
	 * @param bucketName ： 上传空间
	 */
	@SuppressWarnings("unused")
	public static void upload(String filePath, String key) {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(filePath, key, getUpToken(AccountMgr.qcc_bucketName, key));
			// 打印返回的信息
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException qe) {
				// ignore
			}
		}
	}
	
	
	
	/**
	 * 上传
	 * 
	 * @param filePath : 文件的路径
	 * @param key  : 上传到七牛云后的名称
	 * @param bucketName ： 上传空间
	 */
	@SuppressWarnings("unused")
	public static void viedupload(String filePath, String key) {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(filePath, key, getUpToken(AccountMgr.VIDEO, key));
			// 打印返回的信息
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException qe) {
				// ignore
			}
		}
	}

	/**
	 * 主函数：程序入口，测试功能
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static String uploadPicture(String filePath) throws UnsupportedEncodingException {

		// 上传文件的路径，因为在Mac下，所以路径和windows下不同
		filePath = "d://2.jpg";
		// 要上传的空间
		// String bucketName = "zhaofang";
		UUID uuid1 = UUID.randomUUID();
		// 上传到七牛后保存的文件名
		String key = String.valueOf(uuid1);

		upload(filePath, key);

		// 下载
		String fileName = String.valueOf(uuid1);
		String encodedFileName = URLEncoder.encode(fileName, "utf-8");
		String finalUrl = String.format("%s/%s", URL, encodedFileName);
		return finalUrl;
	}
	
	/**七牛云下载图片
	 * @param url : 图片的完整路径比如： http://www.hadoop.zzw777.com/123456.jpg
	 * @param filepath : 下载的目录
	 * **/
	public static String downLoad(String url) {
		OkHttpClient client = new OkHttpClient();
		String picName = IDUtils.onepicName(url);
		Request req = new Request.Builder().url(url).build();
		okhttp3.Response resp = null;
		try {
			resp = client.newCall(req).execute();
			if (resp.isSuccessful()) {
				ResponseBody body = resp.body();
				InputStream is = body.byteStream();
				byte[] data = readInputStream(is);
				File imgFile = new File(downloadpath+ picName);
				FileOutputStream fops = new FileOutputStream(imgFile);
				fops.write(data);
				fops.close();
				
				return downloadpath + picName;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static byte[] readInputStream(InputStream is) {
		ByteArrayOutputStream writer = new ByteArrayOutputStream();
		byte[] buff = new byte[1024 * 2];
		int len = 0;
		try {
			while ((len = is.read(buff)) != -1) {
				writer.write(buff, 0, len);
			}
			is.close();
		} catch (IOException e) {

		}
		return writer.toByteArray();
	}
	/**
	 *七牛云删除图片
	 *@param url : 图片的完整路径
	 * **/
	public  static void deleteimage(String url) {
		url = IDUtils.onepicName(url);
        BucketManager bucketMgr = new BucketManager(auth, cfg);
        try {
			bucketMgr.delete(AccountMgr.qcc_bucketName, url);
		} catch (QiniuException e) {
		}
	}
	
	 

	public static String getuploadpictoken(String bucketName) {
		return auth.uploadToken(bucketName);
	}

	public static void doUpload(MultipartFile file, String key) {
		try {
			Response res  = uploadManager.put(file.getBytes(), key, getUpToken(AccountMgr.qcc_bucketName,key));
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
