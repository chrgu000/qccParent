package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.mapper.FansMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Fans;
import cn.com.qcc.pojo.FansExample;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.FansService;

@Service
@Transactional
public class FansServiceImpl implements FansService {

	@Autowired FansMapper fansMapper;
	@Autowired UserCustomerMapper userCustomerMapper;

	// 查看关注的数量
	public int findFollowCountByUserId(Long userid) {
		return fansMapper.findFollowCountByUserId(userid);
	}

	// 查看粉丝的数量
	public int findFansCountByUserIdandFolllowid(Long userid) {
		return fansMapper.findFansCountByUserIdandstatus(userid);
	}

	// 根据用户ID查询关注的集合
	public List<UserCustomer> findFollowByUserId(Long userid ,PageQuery pagequery) {
		return userCustomerMapper.findFollowByUserId(userid ,pagequery);
	}
	
	public int findFollowByUserIdCount(Long userid) {
		return userCustomerMapper.findFollowByUserIdCount(userid);
	}

	// 根据用户ID查询粉丝的集合
	public List<UserCustomer> findFansByUserId(Long userid ,PageQuery pagequery) {
		return userCustomerMapper.findFansByUserId(userid , pagequery);
	}
	
	public int findFansByUserIdCount(Long userid){
		return  userCustomerMapper.findFansByUserIdCount(userid);
	}

	// 查询某个人是否是某个人的粉丝
	public String findIsFans(Long userid, Long followUserId) {
		if (CheckDataUtil.checkNotEmpty(userid) && CheckDataUtil.checkNotEmpty(followUserId) ) 
		{
			FansExample example = new FansExample();
			FansExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(Long.valueOf(userid));
			criteria.andFollowUserIdEqualTo(Long.valueOf(followUserId));
			criteria.andFanStatusEqualTo(1 + "");
			List<Fans> list = fansMapper.selectByExample(example);
			if (!list.isEmpty() && list.size() > 0) {
				return "已关注";
			}
			
		}
		return "关注";
	}

	// 添加关注
	public String insertfans(Long userid, Long followUserId) {
		String str = "";
		FansExample example = new FansExample();
		FansExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(Long.valueOf(userid));
		criteria.andFollowUserIdEqualTo(Long.valueOf(followUserId));
		List<Fans> list = fansMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			Fans fans = list.get(0);
			fans.setFanStatus(1 + "");
			fans.setUpdate_time(new Date());
			fansMapper.updateByPrimaryKeySelective(fans);
			str = "old";
		} else {
			Fans fans = new Fans();
			fans.setCreate_time(new Date());
			fans.setUpdate_time(new Date());
			fans.setUserId(Long.valueOf(userid));
			fans.setFollowUserId(Long.valueOf(followUserId));
			fans.setFanStatus(1 + "");
			fansMapper.insertSelective(fans);
			str = "new";
		}
		return str;
	}

	// 取消关注
	public void removeFans(Long userid, Long followUserId) {
		FansExample example = new FansExample();
		FansExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(Long.valueOf(userid));
		criteria.andFollowUserIdEqualTo(Long.valueOf(followUserId));
		List<Fans> list = fansMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			Fans fans = list.get(0);
			fans.setFanStatus(0 + "");
			fansMapper.updateByPrimaryKeySelective(fans);
		}

	}

	// 更新粉丝状态
	public void updateFansState(Long userid, Long followUserId) {
		fansMapper.updateFansState(userid, followUserId);
	}

}
