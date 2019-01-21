package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.pojo.User;
import cn.com.qcc.service.FirstService;

@Service
public class FirstServiceImpl implements FirstService {

	@Autowired
	private UserMapper userMapper;

	public List<User> getAllUser() {
		List<User> users = userMapper.selectByExample(null);
		return users;
	}

}
