package cn.com.qcc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.mapper.HousemodelMapper;
import cn.com.qcc.mapper.HousetagMapper;
import cn.com.qcc.mess.util.SolrPageUtil;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Housemodel;
import cn.com.qcc.pojo.HousemodelExample;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.HousetagExample;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.service.HouseModelService;
import cn.com.qcc.service.solrdao.HouseModelSolrDao;

@Service
public class HouseModelServiceImpl implements HouseModelService {

	@Autowired
	HouseModelSolrDao houseModelSolrDao;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	BrokerMapper brokerMapper;
	@Autowired 
	JedisClient jedisClient;
	@Autowired
	HousemodelMapper housemodelMapper;
	@Autowired
	private HousetagMapper housetagMapper;
	
	public ResultMap selectAddToHouseModel(Long houseid , Long userid) {
		
		if (CheckDataUtil.checkisEmpty(houseid) || CheckDataUtil.checkisEmpty(userid)) 
			return ResultMap.build(400, "请登录");
		
		// 第一步判断数据库中
		boolean flag = checkHouseModel(houseid ,userid);
		if (flag) 
			return ResultMap.build(400, "已经导入房源库");
		
		// 第二步判断当前用户是否是经纪人
		Broker broker = brokerMapper.selectByPrimaryKey(userid);
		if (CheckDataUtil.checkisEmpty(broker) || CheckDataUtil.checkNotEqual(2, broker.getState()))
			return ResultMap.build(400, "入驻经纪人才可以导入房源库");
		
		// 第三步查询需要导入的数据
		Housemodel houseModel = houseCustomerMapper.searchAddToHouseModel(houseid);
		
		if (CheckDataUtil.checkisEmpty(houseModel)) 
			return ResultMap.build(400,"找不到该房源");
		
		// 设置默认值
		houseModel.setUserid(userid);
		houseModel.setCentTime(new Date());
		houseModel.setUpdateTime(new Date());
		houseModel.setCentState("可租");
		String centType = getCentType(houseModel.getHousetagid());
		String latlng = houseModel.getLatitude() +"," +  houseModel.getLongitude();
		houseModel.setLatlng(latlng);
		houseModel.setCentType(centType);
		housemodelMapper.insertSelective(houseModel);
		
		// 第四步 校验数据完整性
		if (	CheckDataUtil.checkisEmpty(houseModel) || 
				CheckDataUtil.checkisEmpty(houseModel.getVillageName()) 
				|| CheckDataUtil.checkisEmpty(houseModel.getDistrict())) 
			return ResultMap.build(400, "房源数据不全,导入失败");
		
		return houseModelSolrDao.AddToHouseModel(houseModel);
	}
	
	/**
	 * 每年 最大1000亿  导入房源库  超出 这个 数目系统数据混乱
	 * 获取redis自增主键 年月日   2019 +  1000 * 10000 * 10000 
	 * **/ 
	public String getHouseModelId() {
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	    Date date=new Date();
	    String formatDate=sdf.format(date);
	    String houseModelId = jedisClient.get(RedisUtil.HOUSE_MODEL_KEY +formatDate);
	    // 如果没有值设置初始值
	    if (CheckDataUtil.checkisEmpty(houseModelId)){
	    	// 前半部分  +  后面部分
	    	houseModelId = formatDate +  "00000000008" ;
	    	 // 这里设置加1
	    	System.out.println(houseModelId  );
		    jedisClient.set(RedisUtil.HOUSE_MODEL_KEY +formatDate, houseModelId);
	    }
	    jedisClient.incr(RedisUtil.HOUSE_MODEL_KEY +formatDate);
	    // 设置过期时间
	    jedisClient.expire(RedisUtil.HOUSE_MODEL_KEY +formatDate, RedisUtil.HOUSE_MODEL_OUT_TIME);
	   
	    return houseModelId;
	}
	


	private boolean checkHouseModel(Long houseid, Long userid) {
		HousemodelExample example = new HousemodelExample();
		HousemodelExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andHouseidEqualTo(houseid);
		List<Housemodel> list = housemodelMapper.selectByExample(example);
		if (CheckDataUtil.checkNotEmpty(list)) {
			return true ;
		}
		return false ;
	}

	public ResultMap oneHouseDelete(Long houseid, Long userid) {
		HousemodelExample example = new HousemodelExample();
		HousemodelExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andHouseidEqualTo(houseid);
		housemodelMapper.deleteByExample(example);
		return houseModelSolrDao.deleteByQuery(houseid,userid);
	}

	public ResultMap oneHouseSearch(Long houseModelId) {
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		//设置区域查询
		Housemodel model = new Housemodel();
		model.setHouseModelId(houseModelId);
		SolrPageUtil.likeHouseModel(model ,query);	
		Housemodel houseModel = houseModelSolrDao.oneHouseSearch(query);
		return ResultMap.IS_200(houseModel);
	}

	public SearchResult houseList(Housemodel model) {
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		//设置区域查询
		SolrPageUtil.likeHouseModel(model ,query);	
		return houseModelSolrDao.houseList(query);
	}

	public ResultMap updateHouseModel(Housemodel houseModel) {
		if (CheckDataUtil.checkisEmpty(houseModel.getHouseid()) 
				|| CheckDataUtil.checkisEmpty(houseModel.getHouseModelId())
				||  CheckDataUtil.checkisEmpty(houseModel.getUserid())) 
			return ResultMap.build(400,"参数不全");
		housemodelMapper.updateByPrimaryKeySelective(houseModel);
		houseModel = housemodelMapper.selectByPrimaryKey(houseModel.getHouseModelId());
		
		if (CheckDataUtil.checkisEmpty(houseModel)) 
			return ResultMap.build(400, "无该房源信息");
		
		return houseModelSolrDao.AddToHouseModel(houseModel);
		
		
	}

	
	
	
	private String getCentType(String housetagid) {
		List<Long> values = JSON.parseArray( "[" + housetagid +"]", Long.class);
		HousetagExample example = new HousetagExample();
		HousetagExample.Criteria criteria = example.createCriteria();
		criteria.andHousetagidIn(values);
		criteria.andCategoryEqualTo(4);
		List<Housetag> returnList = housetagMapper.selectByExample(example);
		return returnList.get(0).getType();
	}

}
