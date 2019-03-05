package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BdmanagerMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.BdmanagerExample;
import cn.com.qcc.service.BDService;

@Service
public class BDServiceImpl implements BDService{
	
	@Autowired
	BdmanagerMapper bdmanagerMapper;
	@Autowired 
	JedisClient jedisClient;

	@Override
	public ResultMap addOrUpdate(Bdmanager bdmanager) {
		
		if (CheckDataUtil.checkisEmpty(bdmanager.getRealname())
				|| CheckDataUtil.checkisEmpty(bdmanager.getTelephone())) {
			return ResultMap.build(400, "数据不全");
		}
		if (CheckDataUtil.checkisEmpty(bdmanager.getBdid())) {
			String bdId = jedisClient.get(RedisUtil.BD_INSERT_ID);
			if (CheckDataUtil.checkisEmpty(bdId)) {
				bdId = "10001";
				jedisClient.set(RedisUtil.BD_INSERT_ID, bdId);
			}
			jedisClient.incr(RedisUtil.BD_INSERT_ID);
			bdmanager.setState(1);
			bdmanager.setPassword("");
			bdmanager.setBdid("qbd" + bdId);
			bdmanager.setUpate_time(new Date());
			try {
				
				boolean falg = checkPhone(bdmanager.getBdid() , bdmanager.getTelephone());
				if (falg ==false) return ResultMap.build(400,"电话号码占用");
				bdmanagerMapper.insertSelective(bdmanager);
				
				
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						bdmanager.getTelephone(), modelId);
				
				
				return ResultMap.build(200, "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMap.build(400, "失败,账号重复");
			}
		} else {
			boolean falg = checkPhone(bdmanager.getBdid() , bdmanager.getTelephone());
			if (falg ==false) return ResultMap.build(400,"电话号码占用");
			
			// 判断电话号码是否变更
			Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdmanager.getBdid());
			
			//如果电话号码不一致
			if (CheckDataUtil.checkNotEqual(search.getTelephone(), bdmanager.getTelephone())) {
				// 如果 添加成功发送手机
				String modelId = WangYiCommon.BD_ADD_NOTIC;
				SendMessage.sendNoticMess(bdmanager.getBdid(),
						bdmanager.getTelephone(), modelId);
			}
			 
			 
			bdmanagerMapper.updateByPrimaryKeySelective(bdmanager);
			return ResultMap.build(200, "编辑成功");
		}
	}

	private boolean  checkPhone(String bdid, String telephone) {
		BdmanagerExample example = new BdmanagerExample();
		BdmanagerExample.Criteria criteria = example.createCriteria();
		criteria.andBdidNotEqualTo(bdid);
		criteria.andTelephoneEqualTo(telephone);
		List<Bdmanager> list = bdmanagerMapper.selectByExample(example);
		return list.size() == 0;
	}

	@Override
	public ResultMap listBD() {
		List<Bdmanager> list = bdmanagerMapper.selectByExample(null);
		return ResultMap.IS_200(list);
	}

	@Override
	public ResultMap findOne(String bdid) {
		// TODO Auto-generated method stub
		Bdmanager bdmanager =  bdmanagerMapper.selectByPrimaryKey(bdid);
		return ResultMap.IS_200(bdmanager);
	}

	@Override
	public ResultMap changeState(String  bdid) {
		Bdmanager search = bdmanagerMapper.selectByPrimaryKey(bdid);
		if (CheckDataUtil.checkNotEmpty(search)) {
			if (search.getState() == 1) {
				search.setState(0);
			}else {
				search.setState(1);
			}
			bdmanagerMapper.updateByPrimaryKeySelective(search);
		}
		return ResultMap.IS_200();
	}

	@Override
	public Bdmanager searchBDByPhoneOrId(String account) {
		// TODO Auto-generated method stub
		return bdmanagerMapper.searchBDByPhoneOrId(account);
	}

}
