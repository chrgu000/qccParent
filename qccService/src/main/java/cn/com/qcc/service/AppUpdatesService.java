package cn.com.qcc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Appversion;

public interface AppUpdatesService {
	
	/**通过后台发布APP版本**/
	ResultMap insertAppVersion(Appversion appversion ,MultipartFile file);

	/**检查用户当前的APP是否是最新版本**/
	ResultMap checkUserAppVersion(String phoneAddress, Integer type, String versionid);

	/**获取所有APP的版本**/
	List<Appversion> getAllVersion();

	/**删除APP版本**/
	ResultMap deleteAppVersion(String versionid);

	/**用户取消APP更新**/
	void cancleUpate(String phoneAddress, String versionid);

	/**用户做更新**/
	void doUpate(String phoneAddress, String version);

	/** 获取服务器最新版本APP **/
	Appversion searchNewAppservice(Integer type);

}
