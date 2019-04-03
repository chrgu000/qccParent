package cn.com.qcc.tenement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Appversion;
import cn.com.qcc.service.AppUpdatesService;
import cn.com.qcc.service.BrowseService;

/**app自动更新的controller**/
@Controller
public class AppUdateController {
	
	@Autowired
	AppUpdatesService appUpdatesService;
	
	
	
	//上传一个版本号
	@RequestMapping("/app/versionadd")
	@ResponseBody
	public ResultMap insertAppVersion (Appversion appversion ,MultipartFile file) {
		return appUpdatesService.insertAppVersion (appversion ,file);
	}
	
	//校验用户当前APP是否是最新APP
	@RequestMapping("/app/checkUserVersion/{type}")
	@ResponseBody
	public ResultMap checkUserAppVserion(String phoneAddress ,@PathVariable Integer type ,
			String versionid) {
		System.out.println("进入校验版本号的方法：" + phoneAddress +"-" + versionid);
		return appUpdatesService.checkUserAppVersion (phoneAddress , type , versionid);
	}
	
	//查询所有的版本
	@RequestMapping("/app/allversion")
	@ResponseBody
	public ResultMap getAllVersion () {
		List<Appversion> versionList = appUpdatesService.getAllVersion ();
		return ResultMap.IS_200(versionList);
	}
	
	// 删除版本号
	@RequestMapping("/app/delete")
	@ResponseBody
	public ResultMap deleteAppVersion (String versionid) {
		return appUpdatesService.deleteAppVersion (versionid);
	}
	
	
	// 用户取消下载
	@RequestMapping("/app/cancleupdate")
	@ResponseBody
	public ResultMap cancleUpate (String phoneAddress , String versionid) {
		appUpdatesService.cancleUpate(phoneAddress ,versionid );
		return ResultMap.IS_200();
	}
	
	//用户点击了更新下载
	@RequestMapping("/app/doupdate")
	@ResponseBody
	public ResultMap doUpate(String phoneAddress ,String versionid) {
		appUpdatesService.doUpate(phoneAddress , versionid);
		return ResultMap.IS_200();
	}
	
	
	
	// 查询最新版本APP
	@RequestMapping("/app/searchNewAppservice/{type}")
	@ResponseBody
	public ResultMap searchNewAppservice (@PathVariable Integer type) {
		Appversion version = appUpdatesService.searchNewAppservice(type);
		if (CheckDataUtil.checkisEmpty(version)) {
			return ResultMap.build(400, "没有找到对应APP");
		}
		return ResultMap.IS_200(version);
	}

}
