package cn.com.qcc.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.Graphics2DUtils;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.SimpleUpload;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mymapper.BackImageCustoermMapper;
import cn.com.qcc.pojo.House;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.PosterCreateService;
import weixin.util.XiaoChengXuCodeUtil;

@Service
public class PosterCreateServiceImpl implements PosterCreateService {

	@Autowired
	HttpServletRequest request;
	@Autowired
	BackImageCustoermMapper backImageCustoermMapper;
	@Autowired
	HouseMapper houseMapper;

	@Override
	public String createUserPoster(String username, String avatar, String serialCode, String backimageUrl) {

		try {
			// 先上传 到临时文件夹上面
			SimpleUpload.loadFileByFileUrl(avatar);
			// 获取图像名称
			avatar = IDUtils.getFileOrgName(avatar);

			String avatarPath = PayCommonConfig.LOCAL_UPLOAD_PATH + avatar;
			File petImg = new File(avatarPath);

			// 返回的是二维码的名称
			String returnPath = XiaoChengXuCodeUtil.make_qcc_xcxqcode(10001765L, "userdetail");
			String userCodePath = PayCommonConfig.LOCAL_UPLOAD_PATH + returnPath;
			// 二维码图片文件 1
			File qrCodeImg = new File(userCodePath);

			// Backimage defaultBack =
			// backImageCustoermMapper.searchDefaultByType(1);
			backimageUrl = IDUtils.getFileOrgName(backimageUrl);
			String backPath = SearchImageContentPath() + backimageUrl;
			File fileBg = new File(backPath);
			System.out.println(backPath);

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

			// 4、得到2d画笔对象
			Graphics2D g = bufferedImage.createGraphics();
			// 5、设置画布背景
			g.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			// 推荐码
			Font sercodeFont = new Font("黑体", Font.BOLD, 20);
			int sercodeFontX = width - 200;
			int sercodeFontY = height - 300;
			Graphics2DUtils.drawString(g, Color.decode("#333"), sercodeFont, serialCode, sercodeFontX, sercodeFontY);

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
			String imageUploadName = IDUtils.genImageName() + ".png";
			String uploadFilePath = PayCommonConfig.LOCAL_UPLOAD_PATH + imageUploadName;
			FileUtils.writeByteArrayToFile(new File(uploadFilePath), os.toByteArray());

			// 上传到七牛云
			SimpleUpload.upload(uploadFilePath, imageUploadName);
			// 10、关闭输入输出流
			fis.close();
			os.close();

			System.out.println("七牛云路径： " + PayCommonConfig.HADOOP_WEB_RETURN_PAHT + imageUploadName);
			// qrCodeImg.delete();
			// petImg.delete();
			return PayCommonConfig.HADOOP_WEB_RETURN_PAHT + imageUploadName;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/** 获取图片路径 **/
	public String SearchImageContentPath() {
		String contentPath = request.getSession().getServletContext().getRealPath("/img");
		contentPath = contentPath.replace("\\", "/");
		return contentPath + "/";
	}

	/// 创建房源海报二维码
	public String createHousePoster(String prices, String apartmentname, String onePicture, Long houseid,String detailName) {
		try {
			// 先上传 到临时文件夹上面
			SimpleUpload.loadFileByFileUrl(onePicture);
			// 这里就是
			onePicture = IDUtils.getFileOrgName(onePicture);

			// 创建临时二维码
			String returnPath = XiaoChengXuCodeUtil.make_qcc_xcxqcode(houseid,detailName);
			String houseCodePath = PayCommonConfig.LOCAL_UPLOAD_PATH + returnPath;
			// 二维码图片文件 1
			File qrCodeImg = new File(houseCodePath);

			// 获取背景t
			File fileBg = new File(PayCommonConfig.LOCAL_UPLOAD_PATH + onePicture);
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

			// 4、得到2d画笔对象
			Graphics2D g = bufferedImage.createGraphics();
			// 5、设置画布背景
			g.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			// 户型
			Font sercodeFont = new Font("黑体", Font.BOLD, 50);
			int sercodeFontX = 60;
			int sercodeFontY = 100;
			Graphics2DUtils.drawString(g, Color.decode("#8E388E"), sercodeFont, apartmentname, sercodeFontX,
					sercodeFontY);

			// 价格
			Font usernameFont = new Font("黑体", Font.BOLD, 40);
			int usernameFontX = 310;
			int usernameFontY = 100;
			Graphics2DUtils.drawString(g, Color.decode("#CD0000"), usernameFont, prices, usernameFontX, usernameFontY);

			// 提示框
			
			Font tipFont1 = new Font("黑体", Font.BOLD, 20);
			int tipX1 = width -200 ; //width - 370;
			int tipY1 = height - 285 ; //height - 40;
			String tipName1 = "长按可识别二维码";
			Graphics2DUtils.drawString(g, Color.decode("#00FFFF"), tipFont1, tipName1, tipX1, tipY1);
			Font tipFont2 = new Font("黑体", Font.BOLD, 20);
			int tipX2 = width -180 ; //width - 370;
			int tipY2 = height - 260 ; //height - 40;
			String tipName2 = "查看更多房源";
			Graphics2DUtils.drawString(g, Color.decode("#00FFFF"), tipFont2, tipName2, tipX2, tipY2);

			/*** 二维码的位置 右下角 **/
			int codelocationX = width - 200;
			int codelocationY = height - 250;
			g.drawImage(ImageIO.read(qrCodeImg), codelocationX, codelocationY, 170, 170, null);

			// 7、处理画作
			g.dispose();
			// 8、得到输出流
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", os);
			// 9、转成base64编码前端可以直接显示，也可转换成其它形式比如文件
			// 保存为图片文件
			String imageUploadName = IDUtils.genImageName() + ".png";
			String uploadFilePath = PayCommonConfig.LOCAL_UPLOAD_PATH + imageUploadName;
			FileUtils.writeByteArrayToFile(new File(uploadFilePath), os.toByteArray());

			// 上传到七牛云
			SimpleUpload.upload(uploadFilePath, imageUploadName);
			// 10、关闭输入输出流
			fis.close();
			os.close();
			System.out.println("七牛云路径： " + PayCommonConfig.HADOOP_WEB_RETURN_PAHT + imageUploadName);
			
			// 同步房源
			House updateHouse = new House();
			updateHouse.setHousePostImage(PayCommonConfig.HADOOP_WEB_RETURN_PAHT + imageUploadName);
			updateHouse.setHouseid(houseid);
			houseMapper.updateByPrimaryKeySelective(updateHouse);
			return PayCommonConfig.HADOOP_WEB_RETURN_PAHT + imageUploadName;

		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public HouseCustomer searchHousePostMess(Long houseid) {
		// TODO Auto-generated method stub
		return backImageCustoermMapper.searchHousePostMess(houseid);
	}

}
