package cn.com.qcc.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BuyMapper;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.mymapper.ReleaseCustomerMapper;
import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import cn.com.qcc.pojo.User;
import cn.com.qcc.queryvo.BuyCustomer;
import cn.com.qcc.service.BuyService;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	BuyMapper buyMapper;
	@Autowired
	QiuZuCustomerMapper qiuZuCustomerMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	DetaileaddressMapper detaileaddressMapper;
	@Autowired
	ReleaseCustomerMapper releaseCustomerMapper;
	@Autowired
	SystemstateMapper systemstateMapper;

	/**发布求购信息
	 * @param Detailes : 详情地址
	 * @param userid : 用户ID
	 * @param code : 街道CODE
	 * @param phone : 电话号码
	 * @param picture : 图片
	 * @param head : 标题
	 * @param qiuzuid : 求租的ID 如果有ID 则是编辑处理
	 * **/ 
	public ResultMap addBuy(Buy buy) {
		// 0冻结 1上架 2下架,首次发布信息默认是上架
		Integer searchstate = systemstateMapper.selectByPrimaryKey(6).getDefaultstate();
		buy.setBuystatus(searchstate+"");
		buyMapper.insert(buy);
		return ResultMap.IS_200();
	}

	/**
	 * 我的求购
	 * @param userid : 用户ID
	 */
	public List<BuyCustomer> findBuyByUserid(Long userid) {

		List<BuyCustomer> buylist = qiuZuCustomerMapper.findBuyByUserid(userid);
		for (BuyCustomer delivery :buylist) {
			if (delivery.getCode() !=null && !"".equals(delivery.getCode())) {
				//获得街道和区一级
				Delivery de_tr = releaseCustomerMapper.getTrandname(Long.valueOf(delivery.getCode()));
				delivery.setDiscode(de_tr.getDiscode());
				delivery.setDisname(de_tr.getDisname());
				delivery.setTracode(de_tr.getTracode());
				delivery.setTradname(de_tr.getTradname());	
				//获得区一级和市一级
				Delivery de_qu = releaseCustomerMapper.getquname(de_tr.getTracode());
				delivery.setCitycode(de_qu.getCitycode());
				delivery.setCityname(de_qu.getCityname());
				Delivery de_city = releaseCustomerMapper.getcityname(de_qu.getCitycode());
				delivery.setProcode(de_city.getProcode());
				delivery.setProname(de_city.getProname());
			}
		}

		return buylist;
	}

	/**
	 * 修改的求购的状态
	 * @param buystatus :   0冻结  1上架 2下架
	 * @param buyid : 求购的ID
	 **/
	public void updateBuyStatus(Buy buy) {
		buyMapper.updateByPrimaryKeySelective(buy);
	}

	/**根据求购ID查询一条求购信息
	 * @param buyid : 求购ID
	 * 
	 * **/
	public BuyCustomer findOneById(Long buyid) {
		// TODO Auto-generated method stub
		BuyCustomer delivery= qiuZuCustomerMapper.findOneById(buyid);
		
		if (delivery.getCode() !=null && !"".equals(delivery.getCode())) {
			//获得街道和区一级
			Delivery de_tr = releaseCustomerMapper.getTrandname(Long.valueOf(delivery.getCode()));
			delivery.setDiscode(de_tr.getDiscode());
			delivery.setDisname(de_tr.getDisname());
			delivery.setTracode(de_tr.getTracode());
			delivery.setTradname(de_tr.getTradname());	
			//获得区一级和市一级
			Delivery de_qu = releaseCustomerMapper.getquname(de_tr.getTracode());
			delivery.setCitycode(de_qu.getCitycode());
			delivery.setCityname(de_qu.getCityname());
			Delivery de_city = releaseCustomerMapper.getcityname(de_qu.getCitycode());
			delivery.setProcode(de_city.getProcode());
			delivery.setProname(de_city.getProname());
		}
		return delivery;
	}

	/**
	 *  更新求购的信息
	 * **/
	public void updateBuy(Buy buy) {
		buyMapper.updateByPrimaryKeySelective(buy);
	}

	
	/**发布求购信息
	 * @param Detailes : 详情地址
	 * @param userid : 用户ID
	 * @param code : 街道CODE
	 * @param phone : 电话号码
	 * @param picture : 图片
	 * @param head : 标题
	 * @param qiuzuid : 求租的ID 如果有ID 则是编辑处理
	 * **/ 
	public void insertorupdatebuy(Buy buy, Detaileaddress detaileaddress) {
		if (detaileaddress.getLatitude() == null) {
			User user = userMapper.selectByPrimaryKey(buy.getUser_id());
			detaileaddress.setLatitude(new BigDecimal(user.getLatitude() + ""));
			detaileaddress.setLongitude(new BigDecimal(user.getLongitude() + ""));
		}

		Long detailid = -1L;
		detailid = Long.valueOf(checkeDetailaAddressExists(detaileaddress));
		if (detailid == -1) {
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = Long.valueOf(detaileaddress.getDetailid());
		}

		if (!"".equals(buy.getBuyid()) && buy.getBuyid() != null) {
			buy.setUpdate_time(new Date());
			buy.setDetailid(detailid);
			buyMapper.updateByPrimaryKeySelective(buy);
		} else {
			buy.setBuystatus(1 + "");
			buy.setCreate_time(new Date());
			buy.setUpdate_time(new Date());
			buyMapper.insertSelective(buy);
		}

	}

	// 检查详情地址是否存在
	public Long checkeDetailaAddressExists(Detaileaddress detaileaddress) {
		DetaileaddressExample example = new DetaileaddressExample();
		DetaileaddressExample.Criteria criteria = example.createCriteria();
		if (!"".equals(detaileaddress.getDetailes()) && detaileaddress.getDetailes() != null) {
			criteria.andDetailesEqualTo(detaileaddress.getDetailes());
		}
		if (!"".equals(detaileaddress.getLatitude()) && detaileaddress.getLatitude() != null) {
			criteria.andLatitudeEqualTo(detaileaddress.getLatitude());
		}
		if (!"".equals(detaileaddress.getLongitude()) && detaileaddress.getLongitude() != null) {
			criteria.andLongitudeEqualTo(detaileaddress.getLongitude());
		}
		List<Detaileaddress> selectByExample = detaileaddressMapper.selectByExample(example);
		if (!selectByExample.isEmpty() || selectByExample.size() > 0) {
			Detaileaddress detail_search = selectByExample.get(0);
			return detail_search.getDetailid();
		} else {
			return -1L;
		}

	}

}
