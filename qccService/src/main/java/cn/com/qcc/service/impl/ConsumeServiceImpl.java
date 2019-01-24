package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.ConsumeMapper;
import cn.com.qcc.mapper.InteconnMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mymapper.ConsumeCustomerMapper;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Inteconn;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;
import cn.com.qcc.service.ConsumeService;

@Service
public class ConsumeServiceImpl implements ConsumeService {

	@Autowired ConsumeMapper consumeMapper;
	@Autowired ArticledetailMapper articledetailMapper;
	@Autowired ConsumeCustomerMapper consumeCustomerMapper;
	@Autowired VipcountMapper vipcountMapper;
	@Autowired InteconnMapper inteconnMapper;

	
	/**
	 * 修改订单
	 * **/
	public void updateConsume(Consume consume) {
		consumeMapper.updateByPrimaryKeySelective(consume);
	}
	
	/**添加账单
	 * **/ 
	public void addConsume(Consume consume) {
		consumeMapper.insertSelective(consume);
	}

	/**
	 * 根据账单ID获取订单详情
	 * **/ 
	public Consume getConsumeById(Long consume_id) {
		return consumeMapper.selectByPrimaryKey(consume_id);

	}

	

	/** 查询充值记录
	 * @param userid : 用户ID 
	 * @param currentpage : 当前页面
	 * @param pagesize : 每页条数
	 * **/ 
	public List<Consume> searchrecharge(UserVo userVo) {
		List<Consume> consumeList = consumeCustomerMapper.searchrecharge(userVo);
		return consumeList;
	}
	public int searchrechargeCount(UserVo userVo) {
		return consumeCustomerMapper.searchrechargeCount(userVo);
	}

	
	
	

	/**查询消费信息记录
	 * @param userid : 用户ID 
	 * **/ 
	public List<Consume> searchexpense(UserVo userVo) {
		//ConsumeExample example = new ConsumeExample();
		//ConsumeExample.Criteria criteria = example.createCriteria();
		//criteria.andUser_idEqualTo(userid);
		// 1, 5消费记录
		//criteria.andTypeBetween(1, 6);
		
		List<Consume> consumeList =consumeCustomerMapper.searchexpense(userVo); 
				//consumeMapper.selectByExample(example);
		return consumeList;
	}
	public int searchexpenseCount(UserVo userVo) {
		return consumeCustomerMapper.searchexpenseCount(userVo);
	}

	// 获取账单号
	public Long ordernum() {
		
		return consumeCustomerMapper.getordernum();
	}

	/** 查询我的钱包
	 * @param user_id : 用户id
	 * **/ 
	public VipCountCustomer getmyburse(Long userid , int day ) {
		return consumeCustomerMapper.getmyburse(userid , day );
	}

	/**
	 * 更新发布内容详情
	 * **/
	public void updateArticle(Articledetail articledetail) {
		articledetailMapper.updateByPrimaryKeySelective(articledetail);
	}

	
	

	/**
	 * 根据主键查询vipcount
	 * **/
	public Vipcount checkvipcount(Long user_id) {
		return vipcountMapper.selectByPrimaryKey(user_id);
	}

	/**
	 * 编辑vipcount表的求租次数
	 * **/
	public void updatevipcount(Vipcount vipcount ,Long intecount) {
		vipcountMapper.updateByPrimaryKeySelective(vipcount);
		Inteconn update = new Inteconn();
		update.setUserid(vipcount.getUser_id());
		update.setCount(intecount);
		inteconnMapper.updateByPrimaryKeySelective(update);
	}
}
