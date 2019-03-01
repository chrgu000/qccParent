package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.mapper.SceneuserMapper;
import cn.com.qcc.pojo.Sceneuser;
import cn.com.qcc.queryvo.WeiCustomer;
import cn.com.qcc.service.SceneuserService;
@Service
@Transactional
public class SceneuserServiceImpl implements SceneuserService{

	@Autowired
	SceneuserMapper sceneuserMapper;
	
	@Override
	public Integer getMaxScenuserId() {
		// TODO Auto-generated method stub
		return sceneuserMapper.maxSceneId();
	}

	@Override
	public void insersceneuser(Sceneuser sceneuser) {
		sceneuserMapper.insertSelective(sceneuser);
	}

	@Override
	public List<WeiCustomer> getAllForverCode() {
		return sceneuserMapper.getAllForverCode();
	}

	@Override
	public void editCode(Sceneuser sceneuser) {
		sceneuserMapper.updateByPrimaryKeySelective(sceneuser);
	}

	@Override
	public List<WeiCustomer> getalluser(Integer sceneid) {
		return sceneuserMapper.getalluser(sceneid);
	}

}
