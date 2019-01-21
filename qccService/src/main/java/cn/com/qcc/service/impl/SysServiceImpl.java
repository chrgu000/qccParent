package cn.com.qcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.pojo.Systemstate;
import cn.com.qcc.service.SysService;

@Service
public class SysServiceImpl implements SysService{
	
	@Autowired
	SystemstateMapper systemstateMapper;
	@Override
	public int getsysStatebysystemid(Integer systemid) {
		Systemstate search =  systemstateMapper.selectByPrimaryKey(systemid);
		return search.getDefaultstate();
	}

}
