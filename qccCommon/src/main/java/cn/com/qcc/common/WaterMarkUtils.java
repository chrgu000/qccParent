package cn.com.qcc.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import org.springframework.web.multipart.MultipartFile;

public class WaterMarkUtils {
	
	private final static String  waterMarkContent = "七彩巢";
	private final static Color  markContentColor = new Color(255,255,255,200);
	private final static Font  font = new Font("微软雅黑", Font.PLAIN, 40); 
	// 下载到本地服务器的地址
	private final static String downloanpath = "d://shuiyin//";
	// 下载到服务器临时文件夹
	private final static String batchloadpath = "/root/cents/batchpicure";
	/**
     * @param key : 图片名称
     * @param srcImgPath : 图片文件
       */
    public static String addWaterMark(MultipartFile srcImgPath, String key) {

        try {
            // 读取原图片信息
            //File srcImgFile = new File(srcImgPath);//得到文件
            InputStream inputstream = srcImgPath.getInputStream();
            Image srcImg = ImageIO.read(inputstream);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            
            if (srcImgWidth > 1000) {
            	if (srcImgWidth > srcImgHeight) {
            		srcImgWidth =  700;
                	srcImgHeight = 500 ;
            	}else {
            		srcImgWidth =  500;
                	srcImgHeight = 700 ;
            	}
            }
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            
            /*GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
            String[] fa=ge.getAvailableFontFamilyNames();
            for (String s:fa) {
            }*/

            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体

            //设置水印的坐标
            int x = srcImgWidth - 150;  
            int y = srcImgHeight - 40;  
           // String content = new String(waterMarkContent.getBytes(), "utf-8");
            g.drawString(waterMarkContent, x, y);  //画出水印
            g.dispose();  
            // 输出图片  
            key = batchloadpath + key;
            FileOutputStream outImgStream = new FileOutputStream(key);  
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();  
            outImgStream.close();  
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    
    /**
     * @param key : 图片名称
     * @param srcImgPath : 图片文件
       */
    public static String addWaterMark(File srcImgPath, String key) {

        try {
            // 读取原图片信息
            //File srcImgFile = new File(srcImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgPath);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            if (srcImgWidth > 1000) {
            	if (srcImgWidth > srcImgHeight) {
            		srcImgWidth =  700;
                	srcImgHeight = 500 ;
            	}else {
            		srcImgWidth =  500;
                	srcImgHeight = 700 ;
            	}
            }
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体

            //设置水印的坐标
            int x = srcImgWidth - 150;  
            int y = srcImgHeight - 40;  
            g.drawString(waterMarkContent, x, y);  //画出水印
            g.dispose();  
            // 输出图片  
            key = downloanpath + key;
            FileOutputStream outImgStream = new FileOutputStream(key);  
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();  
            outImgStream.close();  
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

	public static String addWaterMarkNot(MultipartFile srcImgPath, String key) {
		try {
            // 读取原图片信息
            //File srcImgFile = new File(srcImgPath);//得到文件
            InputStream inputstream = srcImgPath.getInputStream();
            Image srcImg = ImageIO.read(inputstream);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            
            if (srcImgWidth > 1000) {
            	if (srcImgWidth > srcImgHeight) {
            		srcImgWidth =  700;
                	srcImgHeight = 500 ;
            	}else {
            		srcImgWidth =  500;
                	srcImgHeight = 700 ;
            	}
            }
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体

            //设置水印的坐标
            int x = srcImgWidth ;  
            int y = srcImgHeight ;  
           // String content = new String(waterMarkContent.getBytes(), "utf-8");
            g.drawString("", x, y);  //画出水印
            g.dispose();  
            // 输出图片  
            key = batchloadpath + key;
            FileOutputStream outImgStream = new FileOutputStream(key);  
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();  
            outImgStream.close();  
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
	}
}
