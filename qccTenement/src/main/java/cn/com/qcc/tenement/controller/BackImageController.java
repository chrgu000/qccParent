package cn.com.qcc.tenement.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ReferralCode;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.pojo.Backimage;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.service.BackImageService;
import cn.com.qcc.service.PosterCreateService;
import cn.com.qcc.service.UserService;


@Controller
@RequestMapping("/backimage")
public class BackImageController {
	
	@Autowired
	BackImageService backImageService;
	@Autowired
	UserService userService;
	@Autowired
	PosterCreateService posterCreateService ; 
	@Autowired
	HttpServletRequest request;
	
	// 上传海报背景
	@RequestMapping( "/upload")
	public ResultMap videoUpload(MultipartFile file ,String descname , int type ) {
		try {
			
			if (file.isEmpty()) {
				return ResultMap.build(400, "请选择文件");
			}
			Backimage insertData = backImageService.createBackImage(descname , type);
			String imageName = IDUtils.getFileOrgName(insertData.getBackimageUrl());
			String path = SearchImageContentPath() + imageName;
			file.transferTo(new File(path));
			return ResultMap.build(200, "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMap.build(400, "上传文件失败");
	}
	
	
	/// 查询用户海报  和 海报列表
	@RequestMapping("/searchAll/{type}")
	@ResponseBody
	public ResultMap searchAll (@PathVariable int type , Long userid) {
		String userPostImage ="";
		if (CheckDataUtil.checkNotEmpty(userid)) {
			Profile profile = userService.getprofile(userid);
			if (CheckDataUtil.checkNotEmpty(profile)) {
				userPostImage = profile.getUserPostImage();
				if (userPostImage == null) {
					userPostImage = "";
				}
			}
		}
		List<Backimage> list = backImageService.searchAll(type);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("userPostImage", userPostImage);
		return ResultMap.IS_200(resultMap);
	}
	
	// 创建个人  海报
	@RequestMapping("/createUserPoster")
	@ResponseBody
	public ResultMap createUserPoster (Long userid , String backimageUrl) {
		Profile profile = userService.getprofile(userid);
		if (CheckDataUtil.checkisEmpty(profile)) {
			return ResultMap.build(400, "未知用户");
		}
		String username = profile.getUser_name();
		String avatar = profile.getAvatar();
		String serialCode =  "推荐码:" +ReferralCode.toSerialCode(userid);
		String userPostImage = posterCreateService.createUserPoster(username, avatar, serialCode, backimageUrl);
		if (CheckDataUtil.checkisEmpty(userPostImage)) {
			return ResultMap.build(400, "创建失败");
		}
		profile.setUserPostImage(userPostImage);
		userService.updateprofile(profile);
		return ResultMap.IS_200(userPostImage);
	}
	
	
	/**获取图片路径**/
	public String SearchImageContentPath () {
		String contentPath =  request.getSession().getServletContext().getRealPath("/img");
		contentPath = contentPath.replace("\\", "/");
		return contentPath+"/";
	}

}
