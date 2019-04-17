package cn.com.qcc.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import cn.com.qcc.common.Graphics2DUtils;

public class PosterCreateUtil {
	
	public static String downLoad(String filePath) {

		try {
			
			String resourcePath = "d://hello/";
			
			String orgnaFileName =  filePath ; 
			if (filePath.contains("?")) {
				orgnaFileName = filePath.substring(0,filePath.indexOf("?"));
			}
			orgnaFileName = orgnaFileName.substring(orgnaFileName.lastIndexOf("/")+1,orgnaFileName.length());
		
			System.out.println("原始文11件名称:" + orgnaFileName + " 长度" + orgnaFileName.length());
			URL petUnitUrl = new URL(filePath);
			HttpURLConnection conn = (HttpURLConnection) petUnitUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(10 * 1000);
			BufferedInputStream biss = new BufferedInputStream(conn.getInputStream());
			OutputStream outputStream = new FileOutputStream(new File(resourcePath + orgnaFileName));
			int lens;
			byte[] arrs = new byte[1024];
			while ((lens = biss.read(arrs)) != -1) {
				outputStream.write(arrs, 0, lens);
				outputStream.flush();
			}
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}


	public static String createPoster(String posterTitle, Long scene, String moneyReward, String username)
			throws Exception {
		String resourcePath = "d://hello/";
		long nowTime = System.currentTimeMillis();
		String qrcodeName = UUID.randomUUID().toString().replace("-", "");
		String petUrlName = UUID.randomUUID().toString().replace("-", "");
		// URL petUnitUrl = new URL(petNameUrl);
		// HttpURLConnection conn = (HttpURLConnection)
		// petUnitUrl.openConnection();
		// conn.setRequestMethod("GET");
		// conn.setConnectTimeout(5 * 1000);
		// BufferedInputStream biss = new
		// BufferedInputStream(conn.getInputStream());
		// OutputStream outputStream = new FileOutputStream(new
		// File(resourcePath + petUrlName + ".png"));
		// int lens;
		// byte[] arrs = new byte[1024];
		// while ((lens = biss.read(arrs)) != -1) {
		// outputStream.write(arrs, 0, lens);
		// outputStream.flush();
		// }
		// outputStream.close();

		/**
		 * 二维码图片 URL getCodeUrl = new
		 * URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" +
		 * ACCESS_TOKEN); HttpURLConnection httpURLConnection =
		 * (HttpURLConnection) getCodeUrl.openConnection();
		 * httpURLConnection.setRequestMethod("POST");// 提交模式
		 * httpURLConnection.setDoOutput(true);
		 * httpURLConnection.setDoInput(true); PrintWriter printWriter = new
		 * PrintWriter(httpURLConnection.getOutputStream()); JSONObject
		 * paramJson = new JSONObject(); paramJson.accumulate("scene",
		 * scene).accumulate("page", "pages/index/index");
		 * paramJson.put("auto_color", false); JSONObject lineColor = new
		 * JSONObject(); lineColor.put("r", 0); lineColor.put("g", 0);
		 * lineColor.put("b", 0); paramJson.put("line_color", lineColor);
		 * printWriter.write(paramJson.toString()); printWriter.flush();
		 * BufferedInputStream bis = new
		 * BufferedInputStream(httpURLConnection.getInputStream()); OutputStream
		 * ost = new FileOutputStream(new File(resourcePath + qrcodeName +
		 * ".png")); int len; byte[] arr = new byte[1024]; while ((len =
		 * bis.read(arr)) != -1) { ost.write(arr, 0, len); ost.flush(); }
		 * ost.close();
		 * 
		 **/

		// 合成图片
		String title = posterTitle;

		// 宠物图片文件
		// File petImg =
		// FileUtils.toFile(PosterUtils.class.getResource("/image/" + petUrlName
		// + ".png"));
		File petImg = new File("d://hello/pet.png");

		// 二维码图片文件 1
		File qrCodeImg = new File("d://hello/code.png");
		// FileUtils.toFile(PosterUtils.class.getResource("/image/" + qrcodeName
		// + ".png"));
		// 背景地址
		// 为了方便演示放在resources中，可根据实际情况（上传后）将背景模板放入单独的资源文件夹或远程资源服务器
		// URL url =
		// PosterUtils.class.getResource("/image/c5073a05c0d02953c0a357e6f3372b5.png");
		
		
		File fileBg = new File("d://hello/bk.png");
		// 1、背景图片输入流
		FileInputStream fis = new FileInputStream(fileBg);
		// 2、背景图片对象
		Image srcImg = ImageIO.read(fis);
		// 3、创建画布，根据背景图片的宽高
		BufferedImage bufferedImage = new BufferedImage(
				// 宽度
				srcImg.getWidth(null),
				// 高度
				srcImg.getHeight(null),
				// 图片类型
				BufferedImage.TYPE_INT_RGB);
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();

		System.out.println("背景图片：" + " 宽度： " + width + " 高度：" + height);

		// 4、得到2d画笔对象
		Graphics2D g = bufferedImage.createGraphics();
		// 设置对线段的锯齿状边缘处理
		// g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		// 5、设置画布背景
		g.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		// 6、```````````开始作画```````````
		Font rewardFirstFont = new Font("PingFang SC Bold", Font.PLAIN, 24);
		Font rewardLastFont = new Font("PingFang SC Bold", Font.PLAIN, 48);
		int rewardFirstWidth = Graphics2DUtils.getStringWidth(g, rewardFirstFont, "赏金￥");
		int rewardLastWidth = Graphics2DUtils.getStringWidth(g, rewardLastFont, moneyReward);

		System.out.println("rewardFirstWidth : " + rewardFirstWidth + "  rewardLastWidth" + rewardLastWidth);
		// 赏金内容
		// Graphics2DUtils.drawString(g, Color.decode("#ffffff"),
		// rewardFirstFont, title,
		// (width - rewardFirstWidth - rewardLastWidth) / 2, 550);
		// Graphics2DUtils.drawString(g, Color.decode("#ffd434"),
		// rewardLastFont, moneyReward,
		// (width - rewardLastWidth + rewardFirstWidth) / 2, 550);

		// 推荐码
		Font sercodeFont = new Font("黑体", Font.BOLD, 20);
		int sercodeFontX = width - 200;
		int sercodeFontY = height - 300;
		Graphics2DUtils.drawString(g, Color.decode("#333"), sercodeFont, title, sercodeFontX, sercodeFontY);

		/** 用户头像 **/
		int avatarlocationX = width - 320;
		int avatarlocationY = width - 450;
		g.drawImage(ImageIO.read(petImg), avatarlocationX, avatarlocationY, 120, 120, null);

		// 用户昵称
		Font usernameFont = new Font("黑体", Font.BOLD, 20);
		int usernameFontX = width - 320;
		int usernameFontY = height - 500;
		Graphics2DUtils.drawString(g, Color.decode("#333"), usernameFont, username, usernameFontX, usernameFontY);

		/*** 二维码的位置 右下角 **/
		int codelocationX = width - 160;
		int codelocationY = height - 160;
		g.drawImage(ImageIO.read(qrCodeImg), codelocationX, codelocationY, 130, 130, null);
		// ```````````结束作画```````````
		// 7、处理画作
		g.dispose();
		// 8、得到输出流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", os);
		// 9、转成base64编码前端可以直接显示，也可转换成其它形式比如文件
		String encodeStr = Base64.getEncoder().encodeToString(os.toByteArray());
		// 保存为图片文件
		FileUtils.writeByteArrayToFile(new File("d://hello/" + nowTime + ".jpg"), os.toByteArray());
		// 10、关闭输入输出流
		fis.close();
		os.close();
		// qrCodeImg.delete();
		// petImg.delete();
		return encodeStr;

	}


}
