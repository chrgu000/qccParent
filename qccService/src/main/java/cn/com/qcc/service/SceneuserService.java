package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.pojo.Sceneuser;
import cn.com.qcc.queryvo.WeiCustomer;

public interface SceneuserService {

	Integer getMaxScenuserId();

	void insersceneuser(Sceneuser sceneuser);

	List<WeiCustomer> getAllForverCode();

	void editCode(Sceneuser sceneuser);

	List<WeiCustomer> getalluser(Integer sceneid);

}
