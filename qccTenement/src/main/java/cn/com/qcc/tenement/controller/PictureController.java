package cn.com.qcc.tenement.controller;
import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SimpleUpload;
import cn.com.qcc.common.WaterMarkUtils;
import cn.com.qcc.mess.util.SendMessUtil;
@Controller
public class PictureController {
	
	@Resource  Destination deletepicture;
	@Autowired JmsTemplate jmsTemplate;
	
	private final static String qnweb_path = "http://www.hadoop.zzw777.com/";
	private final static String qview_path = "http://www.video.zzw777.com/";
	//视频的最大大小20M
	private final static int VIDEO_MAX_SIZE =  1024 * 1000 * 20 ;

	@RequestMapping(value = "/uploadPicture-1")
	@ResponseBody
	public ResultMap uploadPicture() throws IllegalStateException, IOException {
		String bucketName = "zhaofang";
		String uploadToken = SimpleUpload.getuploadpictoken(bucketName);
		return ResultMap.build(200, uploadToken, null);
	}
	
	@RequestMapping(value = "/testupload")
	@ResponseBody
	public ResultMap uploadPicture(@RequestParam MultipartFile image) throws IllegalStateException, IOException {
		//byte [] bype = WaterMarkUtils.addWaterMark(image,uplodpath,  waterMarkContent, markContentColor, font);
                
		return ResultMap.build(200, null, null);
	}
	
	@RequestMapping("/videoUpload")
	@ResponseBody
	public ResultMap videoUpload(MultipartFile content) {
		if (content.isEmpty()) 
			return ResultMap.build(400, "选择文件");
		//获取文件大小
		long size = content.getSize();
		// 最大20M
		if (size > VIDEO_MAX_SIZE) 
			return ResultMap.build(400, "视频最大为20M");
		// 获取文件的全部名称
		String originName  = content.getOriginalFilename();
		// 获取文件后缀
		String lastName = originName.substring(originName.lastIndexOf("."), originName.length());
		// 判断文件的后缀如果不是视频类型的直接返回
		if (CheckDataUtil.checkNotVideo(lastName)) 
			return ResultMap.build(400, "非视频类型");
		// 设置上传的key
		String key = IDUtils.genItemId() + lastName;
		// 上传到远程服务器
		SimpleUpload.vedioUpload(content, key);
		// 设置返回的路径
		String returPath  = qview_path + key ;
		return ResultMap.IS_200(returPath);
	}
	
	@ResponseBody
    @RequestMapping(value="/batchpicure", method=RequestMethod.POST)
    public ResultMap uploadImg(@RequestParam MultipartFile [] images) {
		String  returnpath = "" ;
		String sendData = "" ;
		if (images.length == 0 ) {
			return ResultMap.build(400,"选择图片");
		}
		for (int i=0;i<images.length;i++) {
			MultipartFile image = images[i];
			 //获取原始图片
	        if (image.isEmpty()) {
	            return ResultMap.build(400, "选择文件");
	        }
	        // 1, 建立一个新的文件名
	        String key = IDUtils.genItemId()+ ".png";
	        // 2 , 本上传的文件以新文件名的形式保存在本地服务器[加水印]
	        String filePath = WaterMarkUtils.addWaterMark(image, key);
	        sendData += filePath +"-" ;
	        // 3 , 上传到七牛云服务器
	        SimpleUpload.upload(filePath, key);
	       //发出消息通知后台删除本地图片
			String imagepath =  qnweb_path + key;
			returnpath += imagepath + "-";
		}
		
		// 发放删除本地图片的消息
		if (CheckDataUtil.checkNotEmpty(sendData)) {
			SendMessUtil.sendData(jmsTemplate, deletepicture, sendData);
		}
		
		returnpath = returnpath.substring(0, returnpath.length()-1);
		return ResultMap.IS_200(returnpath);
    }
	
	
	@ResponseBody
    @RequestMapping(value="/onepictureupload", method=RequestMethod.POST)
    public ResultMap onepictureupload(@RequestParam MultipartFile images) {
		String  returnpath = "" ;
		 //获取原始图片
	    if (images.isEmpty()) {
	        return ResultMap.build(400, "选择文件");
	    }
	    // 1, 建立一个新的文件名
	    String key = IDUtils.genItemId()+ ".png";
	    // 2,这里不添加水印
	    String filePath = WaterMarkUtils.addWaterMarkNot(images, key);
	    // 3 , 上传到七牛云服务器
	    SimpleUpload.upload(filePath, key);
	    //发放删除本地图片的消息
		if (CheckDataUtil.checkNotEmpty(filePath)) {
			SendMessUtil.sendData(jmsTemplate, deletepicture, filePath);
		}
		String imagepath =  qnweb_path + key;
		returnpath += imagepath + ",";
		returnpath = returnpath.substring(0, returnpath.length()-1);
		return ResultMap.IS_200(returnpath);
    }
	
	

}
