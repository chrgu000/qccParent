package cn.com.qcc.service.impl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.Destination;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mapper.QiuzuMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.mess.util.SolrPageUtil;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.mymapper.ReleaseCustomerMapper;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.User;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.service.QiuzuService;
import cn.com.qcc.service.solrdao.QiuzuSolrDao;

@Service
public class QiuzuServiceImpl implements QiuzuService {

	@Autowired QiuZuCustomerMapper qiuZuCustomerMapper;
	@Autowired QiuzuMapper qiuzuMapper;
	@Autowired JedisClient jedisClient;
	@Autowired UserMapper userMapper;
	@Autowired DetaileaddressMapper detaileaddressMapper;
	@Resource  SolrServer qizuSolrServer;
	@Autowired QiuzuSolrDao solrDao;
	@Autowired ReleaseCustomerMapper releaseCustomerMapper;
	@Autowired SystemstateMapper systemstateMapper;
	@Autowired JmsTemplate jmsTemplate;
	@Resource  Destination qiuzuAddOrUpdate;
	@Resource  Destination qiuzuSearch;
	@Resource  Destination qiuzuChange;

	// 查询所有的求租列表
	/*public List<QiuzuCustomer> findQiuzuList(HouseVo houseVo) {
		 List<QiuzuCustomer> qiuzulist = null;
		 qiuzulist = qiuZuCustomerMapper.findQiuzuList(houseVo);
		 return qiuzulist;
	}*/
	
	// 封装求租的查询条件
	private SolrQuery getqiuzulistQuery(Metro metro, QiuzuCustomer qiuzuCustomer, PageQuery pagequery) {
		if (qiuzuCustomer == null) {qiuzuCustomer = new QiuzuCustomer();}
		if (metro == null) {metro = new Metro();}
		//       latlng = "22.005,114.001";
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		SolrPageUtil.juliquery(query, "", null);
		//query.addSort("geodist()",ORDER.desc);//按照从近到远排序
		SolrPageUtil.metroquery(metro, query);
	    SolrPageUtil.qiuzuquery(qiuzuCustomer,query);
		// 设置排序条件  
		query.addSort("create_time",ORDER.desc);
		//设置分页条件
		SolrPageUtil.setStartAndEnd(pagequery, query);
		return query;
	}  
	

	


	/*public int findQiuzuListCount(HouseVo houseVo) {
		return qiuZuCustomerMapper.findQiuzuListCount(houseVo);
	}*/

	/***求租详情
	 * @param qiuzuid : 求租主键
	 * @param userid : 用户id
	 * @param type : type类型
	 * **/
	public QiuzuCustomer qiuzuDetail(Long qiuzuid , Long userid ,Integer type) {
		QiuzuCustomer qiuzuCustomer = null;
		try {
			// 先从缓存中取出求租详情
			String jsonData = jedisClient.get(RedisUtil.QIUZU_FIRST_KEY+qiuzuid);
			//如果取出了数据直接返回
			if (CheckDataUtil.checkNotEmpty(jsonData)) {
				qiuzuCustomer = JsonUtils.jsonToPojo(jsonData, QiuzuCustomer.class);
				// 在返回之前重置过期时间
				jedisClient.expire(RedisUtil.QIUZU_FIRST_KEY+qiuzuid, RedisUtil.QIUZU_OUT_TIME);
				// 如果是正常查询不是编辑时候需要发送消息
				if (CheckDataUtil.checkNotEmpty(userid)) {
					String sendData=qiuzuid +"-"+userid + "-" +type ;
					SendMessUtil.sendData(jmsTemplate, qiuzuSearch, sendData);
				}
				// 在返回数据
				return qiuzuCustomer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 这里从数据库中查询
		 qiuzuCustomer =  qiuZuCustomerMapper.qiuzuDetail(qiuzuid);
		//如果查到数据需要发送模板 消息主要为了做消息
		if (CheckDataUtil.checkNotEmpty(qiuzuCustomer)) {
			if (CheckDataUtil.checkNotEmpty(qiuzuCustomer.getCode())) {
				//获得街道和区一级
				Delivery de_tr = releaseCustomerMapper.getTrandname(Long.valueOf(qiuzuCustomer.getCode()));
				Delivery de_qu = null;
				if (CheckDataUtil.checkNotEmpty(de_tr)) 
					
					{
						qiuzuCustomer.setDiscode(de_tr.getDiscode());
						qiuzuCustomer.setDisname(de_tr.getDisname());
						qiuzuCustomer.setTracode(de_tr.getTracode());
						qiuzuCustomer.setTradname(de_tr.getTradname());	
						//获得区一级和市一级
						de_qu = releaseCustomerMapper.getquname(de_tr.getTracode());
					}
				
				if (CheckDataUtil.checkNotEmpty(de_qu)) 
					{
						qiuzuCustomer.setCitycode(de_qu.getCitycode());
						qiuzuCustomer.setCityname(de_qu.getCityname());
						Delivery de_city = releaseCustomerMapper.getcityname(de_qu.getCitycode());
						qiuzuCustomer.setProcode(de_city.getProcode());
						qiuzuCustomer.setProname(de_city.getProname());
					}
			}
			// 如果是正常查询不是编辑时候需要发送消息
			if (CheckDataUtil.checkNotEmpty(userid)) {
				String sendData=qiuzuid +"-"+userid + "-" +type ;
				SendMessUtil.sendData(jmsTemplate, qiuzuSearch, sendData);
			}
			
			
			// 如果一切正常则吧查询的数据插入缓存
			try {
				jedisClient.set(RedisUtil.QIUZU_FIRST_KEY+qiuzuid,JsonUtils.objectToJson(qiuzuCustomer));
				// 在返回之前重置过期时间
				jedisClient.expire(RedisUtil.QIUZU_FIRST_KEY+qiuzuid, RedisUtil.QIUZU_OUT_TIME);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return qiuzuCustomer;
	}

	/**
	 * 我的求租列表
	 * **/ 
	public SearchResult findQiuzuByUserid(Long userid ,PageQuery pagequery) {
		SolrQuery query=new SolrQuery();
        query.setQuery("*:*");
        SolrPageUtil.juliquery(query, "", null);
	    query.add("fq","qiuzustatus:(* NOT *0*)" );
	    query.add("fq","userid:"+userid+"" );
	    // 设置排序条件  
	 	query.addSort("create_time",ORDER.desc);
	 	//设置分页条件
	 	SolrPageUtil.setStartAndEnd(pagequery, query);
	 	return  solrDao.searchqiuzuList(query);
	}
	public int findQiuzuByUseridCount(HouseVo houseVo) {
		return qiuZuCustomerMapper.findQiuzuByUseridCount(houseVo);
	}

	
	public ResultMap updateqiuzustatues(Qiuzu qiuzu) {
		
		// 这里先做数据校验
		if (CheckDataUtil.checkisEmpty(qiuzu)) {return ResultMap.build(400,"数据不完整");}
		// 在判断求租是否存在
		if (CheckDataUtil.checkisEmpty(qiuzu.getQiuzuid())) {return ResultMap.build(400,"数据不完整");}
		// 在判断求租是否存在
		if (CheckDataUtil.checkisEmpty(qiuzu.getQiuzustatus())) {return ResultMap.build(400,"数据不完整");}
		Qiuzu search = qiuzuMapper.selectByPrimaryKey(qiuzu.getQiuzuid());
		// 判断修改的是否存在
		if (CheckDataUtil.checkisEmpty(search)) {return ResultMap.build(400, "编辑的求租不存在");}
		search.setQiuzustatus(qiuzu.getQiuzustatus());
		qiuzuMapper.updateByPrimaryKeySelective(search);
		
		// 这里发送消息告诉后台修改变化了
		SendMessUtil.sendData(jmsTemplate , qiuzuChange
				 ,qiuzu.getQiuzuid()+"-"+qiuzu.getQiuzustatus() );
		
		return ResultMap.build(200, "操作成功");
	}


	


	// 更新求租
	public void updateqiuzu(Qiuzu qiuzu) {

		qiuzuMapper.updateByPrimaryKeySelective(qiuzu);

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
	public ResultMap insertorupdateqiuzu(Qiuzu qiuzu, Detaileaddress detaileaddress) {
		
		//详情地址必须要填写
		if (CheckDataUtil.checkisEmpty(detaileaddress.getDetailes()) 
				|| CheckDataUtil.checkisEmpty(detaileaddress.getLatitude())
				|| CheckDataUtil.checkisEmpty(detaileaddress.getLongitude()))
				{return ResultMap.build(400, "未知定位信息!"); }
		
		//区域必填
		if (CheckDataUtil.checkisEmpty(qiuzu.getCode())) 
				{ return ResultMap.build(400, "请输入求租街道！"); }
		if (qiuzu.getCode().length() < 8){return ResultMap.build(400, "选择区域");}
		
		//电话号码必须填写
		if (CheckDataUtil.checkisEmpty(qiuzu.getPhone())) 
				{ return ResultMap.build(400, "请输入电话号码！"); }
		
		//经纬度必须有
		if (CheckDataUtil.checkisEmpty(detaileaddress.getLatitude()))
				{
					User user = userMapper.selectByPrimaryKey(qiuzu.getUser_id());
					if (CheckDataUtil.checkisEmpty(user)) {
						return ResultMap.build(400,"未知用户");
					}
					detaileaddress.setLatitude(new BigDecimal(user.getLatitude() + ""));
					detaileaddress.setLongitude(new BigDecimal(user.getLongitude() + ""));
				}
		
		// 面积不是必填但是如果没有填写给一个默认值
		if (CheckDataUtil.checkisEmpty(qiuzu.getAreas())) { qiuzu.setAreas(null); }
		//求租价格不是必填
		if (CheckDataUtil.checkisEmpty(qiuzu.getPrice())) { qiuzu.setPrice(""); }
		//求租标题可以不写
		if (CheckDataUtil.checkisEmpty(qiuzu.getCaption())) { qiuzu.setCaption(""); }
		// 求租描述
		if (CheckDataUtil.checkisEmpty(qiuzu.getClassification())) {qiuzu.setClassification("");}
		// 户型
		if (CheckDataUtil.checkisEmpty(qiuzu.getHousetype())) {qiuzu.setHousetype("");}
		// 联系人
		if (CheckDataUtil.checkisEmpty(qiuzu.getLinkman())) {qiuzu.setLinkman("");}
		// 描述信息
		if (CheckDataUtil.checkisEmpty(qiuzu.getDescribes())) {qiuzu.setDescribes("");}
		//求租的图片
		if (CheckDataUtil.checkisEmpty(qiuzu.getPicture())) {qiuzu.setPicture("");}
		// 如果地铁不存在
		if (CheckDataUtil.checkisEmpty(qiuzu.getMetroid())) {qiuzu.setMetroid(-1L);}
		
		// 获取详情地址
		Long detailid = -1L;
		detailid = Long.valueOf(checkeDetailaAddressExists(detaileaddress));
		if (detailid == -1) { //这里获得
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = Long.valueOf(detaileaddress.getDetailid());
		}

		// 如果求租id校验失败说明有求租id这里需要做编辑处理
		if (!CheckDataUtil.checkisEmpty(qiuzu.getQiuzuid())) {
			qiuzu.setUpdate_time(new Date());
			qiuzu.setDetailid(detailid);
			qiuzuMapper.updateByPrimaryKeySelective(qiuzu);
			//求租状态改变发送消息
			String sendData = qiuzu.getQiuzuid()+"-undefined"  ;
			SendMessUtil.sendData(jmsTemplate, qiuzuAddOrUpdate, sendData);
			return ResultMap.build(300, "编辑成功!");
		} else {
			// 这里是发布求租的控制
			Qiuzu search = new Qiuzu();
			search.setPhone(qiuzu.getPhone());
			search.setUser_id(qiuzu.getUser_id());
			search.setCode(qiuzu.getCode().substring(0, 4));
			Integer qiucount = qiuZuCustomerMapper.totalcout(search);
			// 说明没有重复记录
			if (qiucount == 0) {
				qiuzu.setDetailid(detailid);
				Integer searchstate = systemstateMapper.selectByPrimaryKey(5).getDefaultstate();
				qiuzu.setQiuzustatus(searchstate + "");
				qiuzu.setCreate_time(new Date());
				qiuzu.setUpdate_time(new Date());
				qiuzuMapper.insertSelective(qiuzu);
				//求租状态改变发送消息
				SendMessUtil.sendData(jmsTemplate, qiuzuAddOrUpdate, qiuzu.getQiuzuid()+"-"+qiuzu.getUser_id());
				return ResultMap.IS_200(qiuzu.getQiuzuid());
			} else {
				return ResultMap.build(300, "请勿重复发布！");
			}
		}
	}
	
	
	
	


	@SuppressWarnings("unused")
	private QiuzuCustomer getoneqiuzutosolr(long  qiuzuId) {

		return qiuZuCustomerMapper.getoneqiuzutosolr(qiuzuId);
	}

	// 求租发布的统计
	public List<QiuzuCustomer> qiuzutotal(Qiuzu code) {
		return qiuZuCustomerMapper.qiuzutotal(code);
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

	// 求租一键导入索引库
	public ResultMap qiuzuaddtosolr(PageQuery pagequery) {
		List<QiuzuCustomer> qiuzulist = qiuZuCustomerMapper.qiuzuaddtosolr(pagequery);
		if (CheckDataUtil.checkisEmpty(qiuzulist))
			{return ResultMap.build(400, "没有更多数据了!!!!");}
		solrDao.deleteQiuzuBypagequery(pagequery);
		return solrDao.qiuzuaddtosolr(qiuzulist);
		

	}



	/**
	 * 给求租用户群发短信
	 * **/
	public List<QiuzuCustomer> sendmess(QiuzuCustomer qiuzuCustomer) {
		List<QiuzuCustomer> qiuzus = qiuZuCustomerMapper.sendmess(qiuzuCustomer);
		return qiuzus;
	}

	/**
	 * 根据求租的主键查询
	 * @param qiuzuid : 求租主键
	 * **/
	public QiuzuCustomer getqiuzutui(Long qiuzuid) {
		Qiuzu qiuzu= new Qiuzu();qiuzu.setQiuzuid(qiuzuid);
		return qiuZuCustomerMapper.getoneqiuzutosolr(qiuzuid);
	}

	@Override
	public SearchResult testSolr(Metro metro ,QiuzuCustomer qiuzuCustomer ,PageQuery pagequery) {
		SolrQuery solrquery = getqiuzulistQuery(metro, qiuzuCustomer, pagequery);
		SearchResult result = solrDao.searchqiuzuList(solrquery);
		return result;
	}

	// 同索引库 查询求租列表
	public SearchResult searchQiuzuListBySolr(Metro metro, QiuzuCustomer qiuzuCustomer, PageQuery pagequery) {
		SolrQuery solrquery = getqiuzulistQuery(metro, qiuzuCustomer, pagequery);
		// 这里还需要添加一个条件 1 正常的
		solrquery.add("fq", "qiuzustatus:1");
		SearchResult result = solrDao.searchqiuzuList(solrquery);
		return result;
	}
}
