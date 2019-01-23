package cn.com.qcc.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.AppconnMapper;
import cn.com.qcc.mapper.AppversionMapper;
import cn.com.qcc.pojo.Appconn;
import cn.com.qcc.pojo.Appversion;
import cn.com.qcc.service.AppUpdatesService;


@Service
public class AppUpdateServiceImpl implements AppUpdatesService{

	@Autowired
	AppversionMapper versionMapper;
	@Autowired
	AppconnMapper appconnMapper;
	/**上传一个版本号**/
	public ResultMap insertAppVersion(Appversion appversion ,MultipartFile file) {
		
		//校验版本号是否重复
		if (CheckDataUtil.checkisEmpty(appversion.getVersionid())
				|| CheckDataUtil.checkisEmpty(appversion.getDescname())) {
			return ResultMap.build(400,"输入版本描述和版本号");
		}
		
		//校验版本号是否重复
		Appversion check = versionMapper.selectByPrimaryKey(appversion.getVersionid());
		if (CheckDataUtil.checkNotEmpty(check)) {
			return ResultMap.build(400, "重复的版本号！！");
		}
		
		if (file.isEmpty()) {return ResultMap.build(400, "请选择上传文件");}
		String fileNmae = file.getOriginalFilename();
		if (!fileNmae.endsWith(".apk")) {return ResultMap.build(400, "文件格式错误");}
		//设置文件存放的路劲
		String filePath = "/root/apache-tomcat-7.0.79/webapps/upload/app/" ;
		String newName = "qcc_"+appversion.getVersionid()+".apk";
		String realPath = filePath + newName;
		System.out.println(realPath);
		File uploadPaht = new File(realPath);
		try {
			file.transferTo(uploadPaht);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String returUrl = "https://www.zzw777.com/upload/app/" +newName;
		appversion.setUrl(returUrl);
		appversion.setUpdatetime(new Date());
		versionMapper.insertSelective(appversion);
		return ResultMap.build(200, "上传成功");
	}

	// 校验基本信息
	public ResultMap checkUserAppVersion(String phoneAddress, Integer type, String versionid) {
		
		if (CheckDataUtil.checkisEmpty(phoneAddress)
				|| CheckDataUtil.checkisEmpty(versionid)
				|| CheckDataUtil.checkisEmpty(type)) {
			return ResultMap.build(400, "少参数不需要更新");
		}
		
		// 根据type 获取服务器最新版本
		Appversion version = versionMapper.newVersionByType(type);
		if (CheckDataUtil.checkisEmpty(version)) {
			return ResultMap.build(400, "没有APP文件");
		}
		
		if (CheckDataUtil.checkisEqual(version.getVersionid(), versionid)) {
			return ResultMap.build(400, "已经是最新版本");
		}
		
		// 根据手机address判断是否提示更新信息
		Appconn appconn = appconnMapper.selectByPrimaryKey(phoneAddress);
		//如果查到了数据校验信息
		if (CheckDataUtil.checkNotEmpty(appconn)) {
			//如果用户取消的次数超过10次判断最后一次操作的时间距离现在的时间
			if (appconn.getCount() > 10) {
				//再次判断最近一次操作时间
				Long currentTime = new Date().getTime();
				Long oldTime = appconn.getUpdatetime().getTime();
				if (currentTime < oldTime + 1*60*60*1000) {
					return ResultMap.build(400, "距离上次操作不到一天不需要更新");
				}
			}
		}
		return ResultMap.build(200, "提示更新", version);
	}

	@Override
	public List<Appversion> getAllVersion() {
		List<Appversion> version = versionMapper.getall();
		return version;
	}

	@Override
	public ResultMap deleteAppVersion(String versionid) {
		Appversion delete = versionMapper.selectByPrimaryKey(versionid);
		if (CheckDataUtil.checkNotEmpty(delete)) {
			String appName = delete.getUrl().substring(delete.getUrl().lastIndexOf("/"));
			String filePath = "/root/apache-tomcat-7.0.79/webapps/upload/app" ;
			File file = new File(filePath + appName);
			System.out.println(filePath + appName);
			if (file.exists()) 
				file.delete();
			versionMapper.deleteByPrimaryKey(versionid);
		}
		return ResultMap.IS_200();
	}

	//用户取消下载
	public void cancleUpate(String phoneAddress, String versionid) {
		
		// 做取消的操作
		if (CheckDataUtil.checkNotEmpty(phoneAddress)
				&& CheckDataUtil.checkNotEmpty(versionid)) {
			Appconn conn = appconnMapper.selectByPrimaryKey(phoneAddress);
			if (CheckDataUtil.checkisEmpty(conn)) {
				conn = new Appconn();
				conn.setCount(1);
				conn.setUpdatetime(new Date());
				conn.setPhoneAddress(phoneAddress);
				conn.setVersionid(versionid);
				appconnMapper.insertSelective(conn);
			} else {
				
				//判断是不是最新版本
				
				conn.setCount(conn.getCount() + 1);
				conn.setUpdatetime(new Date());
				conn.setVersionid(versionid);
				appconnMapper.updateByPrimaryKeySelective(conn);
			}
		}
	}

	//如果用户点击了同意下载
	public void doUpate(String phoneAddress, String versionid) {
		// TODO Auto-generated method stub
		if (CheckDataUtil.checkNotEmaile(phoneAddress)
				&& CheckDataUtil.checkNotEmpty(versionid)) {
			Appconn conn = appconnMapper.selectByPrimaryKey(phoneAddress);
			if (CheckDataUtil.checkNotEmpty(conn)) {
				conn.setCount(1);
				conn.setUpdatetime(new Date());
				conn.setVersionid(versionid);
				appconnMapper.updateByPrimaryKeySelective(conn);
			} else {
				conn = new Appconn();
				conn.setCount(1);
				conn.setUpdatetime(new Date());
				conn.setVersionid(versionid);
				conn.setPhoneAddress(phoneAddress);
				appconnMapper.insertSelective(conn);
			}
		}
	}

	/** 获取服务器最新版本APP	**/
	public Appversion searchNewAppservice(Integer type) {
		Appversion version = versionMapper.newVersionByType(type);
		return version;
	}

	
	
	

}
