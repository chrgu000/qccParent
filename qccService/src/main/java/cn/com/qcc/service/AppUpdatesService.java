package cn.com.qcc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Appversion;

public interface AppUpdatesService {

	ResultMap insertAppVersion(Appversion appversion ,MultipartFile file);

	ResultMap checkUserAppVersion(String phoneAddress, Integer type, String versionid);

	List<Appversion> getAllVersion();

	ResultMap deleteAppVersion(String versionid);

	void cancleUpate(String phoneAddress, String versionid);

	void doUpate(String phoneAddress, String version);

}
