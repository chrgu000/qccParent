package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.mapper.ConsumeMapper;
import cn.com.qcc.mapper.PartnertradeMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mymapper.ConsumeCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Partnertrade;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.pojo.VipcountExample;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;
import cn.com.qcc.service.VipCountService;

@Service
@Transactional
public class VipCountServiceImpl implements VipCountService {

	@Autowired VipcountMapper vipcountMapper;
	@Autowired ConsumeMapper consumeMapper;
	@Autowired ConsumeCustomerMapper consumeCustomerMapper;
	@Autowired PartnertradeMapper partnertradeMapper;
	@Autowired UserCustomerMapper userCustomerMapper;

	@Override
	public Vipcount getVipByUserID(Long user_id) {
		return vipcountMapper.selectByPrimaryKey(user_id);
	}

    /**
     * 有选择的更新用户钱包信息
     * */ 
	public void updateVipSelective(Vipcount vipcount) {
		vipcountMapper.updateByPrimaryKeySelective(vipcount);
	}

	@Override
	public void insertVipCount(Vipcount vip_new) {
		vipcountMapper.insertSelective(vip_new);
	}

	// 会员的充值记录
	public List<Vipcount> searchrecharge(String userid) {
		VipcountExample example = new VipcountExample();
		VipcountExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(Long.valueOf(userid));
		// 1表示是会员
		// criteria.andIs_vipEqualTo(1);
		List<Vipcount> vipList = vipcountMapper.selectByExample(example);
		return vipList;
	}

	/** 查询余额和可以访问的房间的属于次数
	 * @param userid : 用户ID
	 * **/ 
	public List<Vipcount> searchbalance(String userid) {
		VipcountExample example = new VipcountExample();
		VipcountExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(Long.valueOf(userid));
		List<Vipcount> vipList = vipcountMapper.selectByExample(example);
		return vipList;
	}

	// 查询可以看的次数
	public int findVipCount(Long userid) {
		VipcountExample example = new VipcountExample();
		VipcountExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(userid);
		List<Vipcount> vipList = vipcountMapper.selectByExample(example);
		if (!vipList.isEmpty() && vipList.size() > 0) {
			return vipList.get(0).getCount();
		}
		return 1;
	}

	@Override
	public void updateVipCount(Vipcount vipcount) {
		vipcountMapper.updateByPrimaryKeySelective(vipcount);
	}

	public int getalluserburseCount(UserVo userVo) {
		return consumeCustomerMapper.getalluserburseCount(userVo);
	}

	public List<VipCountCustomer> getalluserburse(UserVo userVo) {
		return consumeCustomerMapper.getalluserburse(userVo);
	}

	public List<VipCountCustomer> searchjbmx(String[] userid, PageQuery pagequery) {
		return consumeCustomerMapper.searchjbmx(userid , pagequery);
	}

	public int searchjbmxCount(String[] userid) {
		return consumeCustomerMapper.searchjbmxCount(userid);
	}
	
	
	public List<VipCountCustomer> searchsymx(String[] userid, PageQuery pagequery) {
		return consumeCustomerMapper.searchsymx(userid , pagequery);
	}

	public int searchsymxCount(String[] userid) {
		return consumeCustomerMapper.searchsymxCount(userid);
	}

	public List<VipCountCustomer> searchhbmx(String[] userid, PageQuery pagequery) {
		return consumeCustomerMapper.searchhbmx(userid , pagequery);
	}

	public int searchhbmxCount(String[] userid) {
		return consumeCustomerMapper.searchhbmxCount(userid);
	}

	public List<VipCountCustomer> searchhymx(String[] userid, PageQuery pagequery) {
		return consumeCustomerMapper.searchhymx(userid , pagequery);
	}

	public int searchhymxCount(String[] userid) {
		return consumeCustomerMapper.searchhymxCount(userid);
	}

	@Override
	public List<VipCountCustomer> searchxfmx(String[] userid, PageQuery pagequery) {
		// TODO Auto-generated method stub
		return consumeCustomerMapper.searchxfmx(userid , pagequery);
	}

	@Override
	public int searchxfmxCount(String[] userid) {
		// TODO Auto-generated method stub
		return consumeCustomerMapper.searchxfmxCount(userid);
	}

	@Override
	public void changevipcount(Vipcount vipcount) {
		// TODO Auto-generated method stub
		vipcountMapper.updateByPrimaryKeySelective(vipcount);
	}

	@Override
	public void insertpartner(String partner_trade_no, Double outaccount, String descname, Long userid, int type) {
		// TODO Auto-generated method stub
		Partnertrade inserpar = new Partnertrade();
		// 提现订单号
		inserpar.setPartnertradeno(Long.valueOf(partner_trade_no));
		//提现金额
		inserpar.setAccount(outaccount);
		// 提现描述
		inserpar.setPardescname(descname);
		inserpar.setUserid(userid);
		inserpar.setType(type);
		inserpar.setUpdatetime(new Date());
		partnertradeMapper.insertSelective(inserpar);
	}

	@Override
	public void deleteweixinaccount(Long userid) {
		userCustomerMapper.deleteunionid(userid);
		userCustomerMapper.delteopenid(userid);
	}


}
