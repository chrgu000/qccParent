package cn.com.qcc.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.AccountMgr;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.ArticletypeMapper;
import cn.com.qcc.mapper.ConsumeMapper;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.ParametypeMapper;
import cn.com.qcc.mapper.QuestionsMapper;
import cn.com.qcc.mapper.ReleasetableMapper;
import cn.com.qcc.mapper.TribeMapper;
import cn.com.qcc.mapper.TribecontrollerMapper;
import cn.com.qcc.mapper.TribetypeMapper;
import cn.com.qcc.mapper.TypedetailMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.UsersignMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.mess.util.SolrPageUtil;
import cn.com.qcc.mymapper.ConsumeCustomerMapper;
import cn.com.qcc.mymapper.ReleaseCustomerMapper;
import cn.com.qcc.mymapper.TribeCustomerMapper;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.ArticletypeExample;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.ParametypeExample;
import cn.com.qcc.pojo.Questions;
import cn.com.qcc.pojo.Releasetable;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.TribeExample;
import cn.com.qcc.pojo.Tribecontroller;
import cn.com.qcc.pojo.TribecontrollerExample;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.pojo.TribetypeExample;
import cn.com.qcc.pojo.Typedetail;
import cn.com.qcc.pojo.TypedetailExample;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Usersign;
import cn.com.qcc.pojo.UsersignExample;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.pojo.VipcountExample;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.DetailCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.TribeCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.TribeService;
import cn.com.qcc.service.solrdao.TribeSolrDao;



//部落或者群
@Service
@Transactional
public class TribeServiceImpl implements TribeService {

	@Autowired
	TribeMapper tribeMapper;
	@Autowired
	DetaileaddressMapper detaileaddressMapper;
	@Autowired
	TribeCustomerMapper tribeCustomerMapper;
	@Autowired
	UsersignMapper usersignMapper;
	@Autowired
	TribetypeMapper tribetypeMapper;
	@Autowired
	QuestionsMapper questionsMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	TribecontrollerMapper tribecontrollerMapper;
	@Autowired
	ArticletypeMapper articletypeMapper;
	@Autowired
	ArticledetailMapper articledetailMapper;
	@Autowired
	TypedetailMapper typedetailMapper;
	@Autowired
	ReleasetableMapper releasetabkeMapper;
	@Autowired
	VipcountMapper vipcountMapper;
	@Autowired
	ConsumeMapper consumeMapper;
	@Autowired
	ReleaseCustomerMapper releaseCustomerMapper;
	@Autowired
	ConsumeCustomerMapper consumeCustomerMapper;
	@Autowired JmsTemplate jmsTemplate;
	@Resource  Destination tribeDetailAdd;
	@Resource  Destination detailToTribe;
	@Resource  Destination searchDetail;
	@Resource  Destination tribeSearch;
	@Autowired JedisClient jedisClient;
	@Autowired
	private TribeSolrDao tribeSolrDao;
	@Autowired
	private HouseMapper houseMapper;
	@Autowired
	private ParametypeMapper parametypeMapper;
	

	
	

	// 创建部落
	public ResultMap createtribe(Tribe tribe, Detaileaddress detaileaddress, Tribetype tribetype) {

		if (CheckDataUtil.checkisEmpty(tribe.getUserid()))
			{ return ResultMap.build(404, "请登录后在创建部落"); }
		if (CheckDataUtil.checkisEmpty(tribe.getName())) 
			{ return ResultMap.build(400, "请输入部落名称"); }
		if (CheckDataUtil.checkisEmpty(tribe.getPicture())) 
			{ return ResultMap.build(400, "请为你的部落插入图片"); }
		if (CheckDataUtil.checkisEmpty(detaileaddress.getDetailes())
				|| CheckDataUtil.checkisEmpty(detaileaddress.getLatitude())
				|| CheckDataUtil.checkisEmpty(detaileaddress.getLongitude())) 
			{ return ResultMap.build(400, "你输入的地址有误，请检查"); 	}
		if (CheckDataUtil.checkisEmpty(tribe.getDescription())) 
			{tribe.setDescription("");}
		// 判断部落是否存在
		Tribe tribe_search = this.checkTribe(tribe.getName());
		// 如果部落已经存在提示用户
		if (CheckDataUtil.checkNotEmpty(tribe_search)) 
			{ return ResultMap.build(400, "该部落已经存在，请重新输入"); }
		
		// 判断详情地址是否存在
		Long detailid = checkeDetailaAddressExists(detaileaddress);

		// 说明详情地址已经存在
		if (detailid > 0) 
			{ tribe.setDetailid(Long.valueOf(detailid + "")); }
		else 
			{
				detaileaddressMapper.insertSelective(detaileaddress);
				Long detail_insertid = detaileaddress.getDetailid();
				tribe.setDetailid(Long.valueOf(detail_insertid + ""));
		    }

		// 获取部落的ID
		Long tribetypeid = getTribetypeid(tribetype);
		if (tribetypeid < 0) 
			{ return ResultMap.build(400, "请检查你输入的部落！"); }
		tribe.setTribetypeid(tribetypeid);
		// 设置部落成员
		// 设置部落状态 1,正常，2-停用
		tribe.setState(1);
		tribe.setUpdate_time(new Date());
		tribeMapper.insertSelective(tribe);

		// 给控制表也同时插入一条记录
		Tribecontroller tribecontroller = new Tribecontroller();
		// 部落首领的唯一标识
		tribecontroller.setState(3);
		tribecontroller.setUserid(tribe.getUserid());
		tribecontroller.setUpdate_time(new Date());
		tribecontroller.setTribeid(tribe.getTribeid());
		tribecontrollerMapper.insert(tribecontroller);
		
		return ResultMap.build(200, "恭喜你创建部落成功！");
	}

	private Long getTribetypeid(Tribetype tribetype) {
		TribetypeExample example = new TribetypeExample();
		TribetypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypenameEqualTo(tribetype.getTypename());
		List<Tribetype> tribetypes = tribetypeMapper.selectByExample(example);
		if (!tribetypes.isEmpty() && tribetypes.size() == 1) {
			return tribetypes.get(0).getTribetypeid();
		}
		return -1L;
	}

	// 加入部落
	public ResultMap joinTribe(Long tribeid, Long followUserId) {
		// 判断用户是否登录
		if (followUserId == null) {
			return ResultMap.build(404, "请登录后在加入部落");
		}
		Tribe Tribe_check = checkjointribe(tribeid);
		if (Tribe_check == null) {
			return ResultMap.build(400, "你加入的部落不存在");
		}
		Tribecontroller tribecontroller = checktribecontroller(tribeid, followUserId);
		if (tribecontroller != null) {
			if (tribecontroller.getState() == 2) {
				return ResultMap.build(400, "你申请加入 ：[" + Tribe_check.getName() + "]部落，待审核");
			}
			if (tribecontroller.getState() == 1) {
				return ResultMap.build(200, "你已经加入过 ：[" + Tribe_check.getName() + "]部落");
			}
			if (tribecontroller.getState() == 3) {
				return ResultMap.build(200, "你是 ：[" + Tribe_check.getName() + "]部落的首领无须加入!");
			}
		}

		if (tribecontroller == null) {
			// 给控制表也同时插入一条记录
			Tribecontroller tribecontroller_insert = new Tribecontroller();
			// 默认是正常加入部落
			tribecontroller_insert.setState(1);
			tribecontroller_insert.setUserid(followUserId);
			tribecontroller_insert.setUpdate_time(new Date());
			tribecontroller_insert.setTribeid(tribeid);
			tribecontrollerMapper.insert(tribecontroller_insert);
		}
		return ResultMap.build(200, "恭喜你成功加入 ：[" + Tribe_check.getName() + "]部落");
	}

	// 校验部落控制表
	private Tribecontroller checktribecontroller(Long tribeid, Long followUserId) {
		TribecontrollerExample example = new TribecontrollerExample();
		TribecontrollerExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(followUserId);
		criteria.andTribeidEqualTo(tribeid);
		List<Tribecontroller> list = tribecontrollerMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 我创建的部落
	public List<Tribe> mytribelist(Long userid) {
		// 判断用户是否登录
		if (userid == null) {
			return null;
		}
		List<Tribe> list = gettribelistbyuserid(userid);
		return list;
	}

	private List<Tribe> gettribelistbyuserid(Long userid) {
		TribeExample example = new TribeExample();
		TribeExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Tribe> list = tribeMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list;
		}
		return null;
	}

	// 检查加入的部落是否存在或者曾经加入过
	public Tribe checkjointribe(Long tribeid) {
		return tribeMapper.selectByPrimaryKey(tribeid);
	}

	// 判断部落或者群是否存在
	public Tribe checkTribe(String name) {
		TribeExample example = new TribeExample();
		TribeExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<Tribe> list = tribeMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 检查详情地址是否存在
	private Long checkeDetailaAddressExists(Detaileaddress detaileaddress) {
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

	@Override
	public List<TribeCustomer> myjointribe(Long userid ,PageQuery pagequery) {
		return tribeCustomerMapper.myjointribe(userid , pagequery);
	}

	public ResultMap usersign(Long tribeid, Long userid) {
		//校验基本数据
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(tribeid)) {
			return ResultMap.build(400, "未登录");
		}
		// 校验是不是部落成员
		boolean flag = this.checkTribeIn(userid, tribeid);
		if (!flag) 
			{return ResultMap.build(400,"非部落成员");}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = "yyyy-MM-dd HH:mm:ss";
		Date date1 = DateUtil.strToDate(format, sdf.format(date) + " 00:00:01");
		Date date2 = DateUtil.strToDate(format, sdf.format(date) + " 23:59:58");
		// 检查签到表是否有记录
		Usersign usersign = checkusersign(tribeid, userid);
		if (CheckDataUtil.checkisEmpty(usersign)) {
			Usersign usersign_insert = new Usersign();
			usersign_insert.setSingcount(1);
			usersign_insert.setUpdate_time(new Date());
			usersign_insert.setTribeid(tribeid);
			usersign_insert.setUserid(userid);
			usersignMapper.insertSelective(usersign_insert);
			return ResultMap.build(200, "签到成功");
		}else {
			if (date1.before(usersign.getUpdate_time()) && usersign.getUpdate_time().before(date2)) {
				return ResultMap.build(201, "今天已经签到过");
			}
			Integer count = usersign.getSingcount();
			count++;
			usersign.setSingcount(count);
			usersign.setUpdate_time(new Date());
			usersignMapper.updateByPrimaryKeySelective(usersign);
			return ResultMap.build(200, "签到成功");
		}
		
	}

	private Usersign checkusersign(Long tribeid, Long followUserId) {
		UsersignExample example = new UsersignExample();
		UsersignExample.Criteria criteria = example.createCriteria();
		criteria.andTribeidEqualTo(tribeid);
		criteria.andUseridEqualTo(followUserId);
		List<Usersign> usersigns = usersignMapper.selectByExample(example);
		if (!usersigns.isEmpty() && usersigns.size() > 0) {
			return usersigns.get(0);
		}
		return null;
	}

	@Override
	public TribeCustomer myjointribeexist(Long tribeid, Long userid) {
		return tribeCustomerMapper.myjointribeexist(tribeid, userid);
	}

	@Override
	public List<TribeCustomer> findtribedetailbycondition(TribeVo tribeVo) {
		return tribeCustomerMapper.findtribedetailbycondition(tribeVo);
	}

	@Override
	public Integer findtribedetailCount(TribeVo tribeVo) {
		return tribeCustomerMapper.findtribedetailCount(tribeVo);
	}

	@Override
	public List<Tribetype> getCityTribe() {
		return tribeCustomerMapper.getCityTribe();
	}

	@Override
	public List<Tribetype> getAvocationTribe() {
		TribetypeExample example = new TribetypeExample();
		TribetypeExample.Criteria criteria = example.createCriteria();
		// 2兴趣爱好部落
		criteria.andTypecodeEqualTo(2);
		List<Tribetype> tribetypes = tribetypeMapper.selectByExample(example);
		return tribetypes;
	}

	/*@Override
	public List<TribeCustomer> horttribe(TribeVo tribeVo) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();
		AddressCustomer addressCustomer = tribeVo.getAddressCustomer() != null ? tribeVo.getAddressCustomer()
				: new AddressCustomer();
		if (addressCustomer.getNearLatude() != null) {
			addressCustomer.setMinLatude(Double.valueOf(addressCustomer.getNearLatude()) - 0.5);
			addressCustomer.setMaxLatude(Double.valueOf(addressCustomer.getNearLatude()) + 0.5);
		}
		if (addressCustomer.getNearLongitude() != null) {
			addressCustomer.setMinLongitude(Double.valueOf(addressCustomer.getNearLongitude()) - 0.5);
			addressCustomer.setMaxLongitude(Double.valueOf(addressCustomer.getNearLongitude()) + 0.5);
		}
		tribeVo.setAddressCustomer(addressCustomer);
		List<TribeCustomer> list = tribeCustomerMapper.horttribe(tribeVo);
		return list;
	}*/

	@Override
	public List<TribeCustomer> indextribe(TribeVo tribeVo) {
		return tribeCustomerMapper.indextribe(tribeVo);
	}

	@Override
	public Integer indextribeCount(TribeVo tribeVo) {
		return tribeCustomerMapper.indextribeCount(tribeVo);
	}

	// 人气榜单
	public List<TribeCustomer> getpopularity() {
		return tribeCustomerMapper.getpopularity();
	}

	@Override
	public List<TribeCustomer> getLuncida() {
		return tribeCustomerMapper.getLuncida();
	}

	// 部落发起提问
	public ResultMap pushquestion(Long tribeid, Long userid, String title, Integer type) {

		if (userid == null) {
			return ResultMap.build(404, "请登录后在操作");
		}
		if (tribeid == null) {
			return ResultMap.build(400, "请核实下部落是否正确");
		}
		if (title == null || "".equals(title)) {
			return ResultMap.build(400, "请为发出的提问，写一个标题");
		}
		if (type == null) {
			return ResultMap.build(400, "请检查你发布提问的类型");
		}
		// 为发布的问题提供数据
		Questions questions = new Questions();
		// 绑定部落ID表示提问在部落发布
		questions.setOtherid(tribeid);
		// 绑定用户ID
		questions.setUserid(userid);
		questions.setUpdate_time(new Date());
		questions.setTitle(title);
		// 1正常，2停用
		questions.setState(1);
		// 8表示部落提问,可以参照系统基本参数
		questions.setType(8);
		// 插入数据库
		questionsMapper.insert(questions);
		return ResultMap.build(200, "发布提问成功");

	}

	// 部落详情查询
	public TribeCustomer getTribetailbyid(Long tribeid, Integer type,Long userid) {
		TribeCustomer tribeCustomer = null;
		if (CheckDataUtil.checkisEmpty(tribeid)
				|| CheckDataUtil.checkNotEqual(type, 9)) 
			{return tribeCustomer;}
		String sendData =  tribeid +"-" + userid+"-" + type;
		//先从缓存中取出部落详情信息
		try {
			String jsonData = jedisClient.get(RedisUtil.TRIBE_FIRST_KEY+tribeid);
			if (CheckDataUtil.checkNotEmpty(jsonData)) {
				tribeCustomer =  JsonUtils.jsonToPojo(jsonData, TribeCustomer.class);
				if (CheckDataUtil.checkNotEmpty(userid)) {
					// 发送模板消息
					SendMessUtil.sendData(jmsTemplate, tribeSearch, sendData);
				}
				return tribeCustomer;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		tribeCustomer =  tribeCustomerMapper.getTribetailbyid(Integer.parseInt(tribeid + ""), type);
		if (CheckDataUtil.checkisEmpty(tribeCustomer)) {return null;}
		// 吧对应的信息存入缓存
		try {
			jedisClient.set(RedisUtil.TRIBE_FIRST_KEY+tribeid, JsonUtils.objectToJson(tribeCustomer));
			jedisClient.expire(RedisUtil.TRIBE_FIRST_KEY+tribeid, RedisUtil.TRIBE_OUT_TIME);
			if (CheckDataUtil.checkNotEmpty(userid)) {
				// 发送模板消息
				SendMessUtil.sendData(jmsTemplate, tribeSearch, sendData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tribeCustomer;
	}

	
	
	
	@Override
	public Tribe getTribebyId(Long tribeid) {
		// TODO Auto-generated method stub
		return tribeMapper.selectByPrimaryKey(tribeid);
	}

	// 查询发布的 类型
	public List<Articletype> getTribeDetailType(Integer type) {
		ArticletypeExample example = new ArticletypeExample();
		ArticletypeExample.Criteria criteria = example.createCriteria();
		criteria.andArticletypeidEqualTo(type);
		List<Articletype> tribetypes = articletypeMapper.selectByExample(example);
		
		
		
		if (CheckDataUtil.checkNotEmpty(tribetypes)) {
			// 查询所有的规格参数
			ParametypeExample parametypeExample = new ParametypeExample();
			ParametypeExample.Criteria paramccriter = parametypeExample.createCriteria();
			paramccriter.andFatheridEqualTo(0L);
			List<Parametype> paramList = parametypeMapper.selectByExample(parametypeExample);
			for (Articletype detail: tribetypes) {
				String paramTypeNames="";
				if (CheckDataUtil.checkNotEmpty(detail.getCodeids())) {
					for (Parametype param:paramList) {
						if (detail.getCodeids().contains(param.getCodeid()+"")) {
							paramTypeNames += param.getTypename() +",";
						}
					}
				}
				detail.setParamTypeNames(paramTypeNames);
			}
		}
		
		
		return tribetypes;
	}

	//部落发布物品
	public ResultMap pushtribedetail(Integer type,  Articledetail articledetail, 
			Detaileaddress detaileaddress,String codeids,Integer count ,double prices) {
		if (CheckDataUtil.checkisEmpty(articledetail))
			{ return ResultMap.build(400, "检查参数");}
		articledetail.setArticletypeid(type);
		// 发布类型
		if (CheckDataUtil.checkisEmpty(articledetail.getOnetypeid())) 
			{return ResultMap.build(400, "选择发布类型");}
		//区域的地址
		if (CheckDataUtil.checkisEmpty(articledetail.getCode())) 
			{articledetail.setCode(0L);}
		// 视频地址
		if (CheckDataUtil.checkisEmpty(articledetail.getVideourl())) 
			{ articledetail.setVideourl("");}
		// 置顶价格
		if (CheckDataUtil.checkisEmpty(articledetail.getTopprices())) 
			{ articledetail.setTopprices(0);  }
		// 置顶天数
		if (articledetail.getTopday() == null) 
			{ articledetail.setTopday(0); }
		// 用户id
		if (CheckDataUtil.checkisEmpty(articledetail.getUserid())) 
			{ return ResultMap.build(404, "请登录后在发布"); }
		// 输入的标题
		if (CheckDataUtil.checkisEmpty(articledetail.getTitle())) 
			{ return ResultMap.build(400, "请输入标题"); }
		if (type != 7 && type !=6 && type !=8 && type !=11 && type !=10 ) 
			{ return ResultMap.build(400, "type类型不对，请检查你发布的类型!"); }
			// 如果是增值服务
			if (CheckDataUtil.checkisEqual(11, type)) {
				if (CheckDataUtil.checkisEmpty(articledetail.getDescription())) 
					{ return ResultMap.build(400, "请发布描述");} }
			if (CheckDataUtil.checkisEqual(6, type)) 
				    {
						if (CheckDataUtil.checkisEqual(0, prices))
							{ return ResultMap.build(400,"输入价格"); }
						if (CheckDataUtil.checkisEmpty(articledetail.getPicture())) 
							{return ResultMap.build(400, "选择图片");}
				    }
		/*if (CheckDataUtil.checkisEmpty(articledetail.getCode()) || 
				CheckDataUtil.checkisEmpty(detaileaddress.getLatitude())
				|| CheckDataUtil.checkisEmpty(detaileaddress.getLongitude())) 
			{return ResultMap.build(400, "检查地址信息");}*/
		if (CheckDataUtil.checkisEmpty(articledetail.getPicture())) 
				{articledetail.setPicture("");}
		if (CheckDataUtil.checkisEmpty(articledetail.getDescription())) 
				{articledetail.setDescription("");}
		// 判断详情地址是否存在
		Long detailid = checkeDetailaAddressExists(detaileaddress);
		if (detailid < 0 ) 
			{
				detaileaddressMapper.insertSelective(detaileaddress);
				detailid = detaileaddress.getDetailid();
		   }
		
		//详情地址ID
		articledetail.setDetailid(Long.valueOf(detailid));	
		// 未支付状态
		articledetail.setState(2);
		articledetail.setUpdate_time(new Date());
		
		if (CheckDataUtil.checkNotEmpty(articledetail.getVideourl())) {
			String videourl = articledetail.getVideourl().replace(AccountMgr.qview_path,
					AccountMgr.qyunview_path);
			articledetail.setVideourl(videourl);
		}
		
		articledetailMapper.insertSelective(articledetail);
		
		// 返回插入的主键
		Long articledetailid = articledetail.getArticledetailid();

		//如果TYPE为6时候是发布物品需要单独再次做处理
		if (CheckDataUtil.checkisEqual(6, type)) {
			Releasetable release = new Releasetable();
			release.setArticledetailid(articledetailid);
			release.setCodeids(codeids);
			release.setCount(count);
			release.setPrices(prices);
			release.setUpdate_time(new Date());
			releasetabkeMapper.insert(release);
		}
		/*if (articledetail.getTopday() > 0) {
			return ResultMap.build(200, "" ,articledetailid);
		}*/
		
		// 这里添加完成发送消息
		SendMessUtil.sendData(jmsTemplate, tribeDetailAdd, articledetailid+"");
		
		return ResultMap.build(200, "发布成功" ,articledetailid);
	}

	// 物品关联部落
	/*public void addarticle(Long tribeid, Long articledetailid, Integer type,Long otherid) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria criteria = example.createCriteria();
		// 处理房源的TYPE
		if (type == 1) {
			articledetailid = 1L;
		}else {
			otherid = 1L;
		}
		criteria.andTribeidEqualTo(tribeid);
		criteria.andArticledetailidEqualTo(articledetailid);
		criteria.andOtheridEqualTo(otherid);
		List<Article> list = articleMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			Article article_search = list.get(0);
			article_search.setTribeid(tribeid);
			article_search.setUpdate_time(new Date());
			articleMapper.updateByPrimaryKeySelective(article_search);
		} else {
			Article article_new = new Article();
			article_new.setArticledetailid(articledetailid);
			article_new.setOtherid(otherid);
			article_new.setTribeid(tribeid);
			article_new.setUpdate_time(new Date());
			articleMapper.insert(article_new);
		}
	}
*/
	//获取部落成员
	public List<TribeCustomer> getTribeuser(Long tribeid,PageQuery pagequery) {
		return tribeCustomerMapper.getTribeuser(tribeid,pagequery);
	}
	public int getTribeuserCount(Long tribeid) {
		return tribeCustomerMapper.getTribeuserCount(tribeid);
	}

	//部落吃查询条件
	public List<TribeCustomer> getTribebycondition(TribeVo tribeVo) {
		AddressCustomer addressCustomer = tribeVo.getAddressCustomer() != null ? tribeVo.getAddressCustomer()
				: new AddressCustomer();
		//如果传入的经纬度有的话，根据附近查询
		if (addressCustomer.getNearLatude()!=null && !"".equals(addressCustomer.getNearLatude()) 
				&& addressCustomer.getNearLongitude()!=null && !"".equals(addressCustomer.getNearLongitude())) {
			addressCustomer.setMinLatude(Double.valueOf(addressCustomer.getNearLatude()) - 0.1);
			addressCustomer.setMaxLatude(Double.valueOf(addressCustomer.getNearLatude()) + 0.1);
			addressCustomer.setMaxLongitude(Double.valueOf(addressCustomer.getNearLongitude()) + 0.1);
			addressCustomer.setMinLongitude(Double.valueOf(addressCustomer.getNearLongitude()) - 0.1);
			tribeVo.setAddressCustomer(addressCustomer);
		}
		return tribeCustomerMapper.getTribebycondition(tribeVo);
	}

	@Override
	public Integer getTribebyconditionCount(TribeVo tribeVo) {
		
		return tribeCustomerMapper.getTribebyconditionCount(tribeVo);
	}

	@Override
	public ArticleDetailCustomer thingdetail(Long articedetailid,Long userid) {
		ArticleDetailCustomer articleDetailCustomer =  null;
		try {
			String jsonData = jedisClient.get(RedisUtil.ARTICLEDETAIL_FIRST_KEY+articedetailid);
			if (CheckDataUtil.checkNotEmpty(jsonData)) {
				articleDetailCustomer = JsonUtils.jsonToPojo(jsonData, ArticleDetailCustomer.class);
				
				//发送消息
				if (CheckDataUtil.checkNotEqual(articleDetailCustomer.getUserid(), userid)
						&& CheckDataUtil.checkNotEmpty(userid)) {
					String sendData = articedetailid +"-" + userid +"-"+articleDetailCustomer.getArticletypeid();
					SendMessUtil.sendData(jmsTemplate, searchDetail, sendData);
				}
				return articleDetailCustomer;
			}
		} catch (Exception e) {
		   e.printStackTrace();
		}
				
		articleDetailCustomer = tribeCustomerMapper.thingdetail(articedetailid);
		if (CheckDataUtil.checkisEmpty(articleDetailCustomer)) { return articleDetailCustomer;}
		if (CheckDataUtil.checkNotEmpty(articleDetailCustomer.getTribeids())){
			String tribeid = articleDetailCustomer.getTribeids().split(",")[0];
			Tribe tribe =  tribeMapper.selectByPrimaryKey(Long.valueOf(tribeid));
			if (CheckDataUtil.checkNotEmpty(tribe)) {
				articleDetailCustomer.setTribename(tribe.getName());
				articleDetailCustomer.setTribepicture(tribe.getPicture());
			}
		}
		
		// 加入缓存
		try {
			//设置物品规格参数
			setThingReseaseTable(articleDetailCustomer);
			jedisClient.set(RedisUtil.ARTICLEDETAIL_FIRST_KEY+articedetailid, JsonUtils.objectToJson(articleDetailCustomer));
			jedisClient.expire(RedisUtil.ARTICLEDETAIL_FIRST_KEY+articedetailid, RedisUtil.ARTICLEDETAIL_OUT_TIME);
			//发送消息
			if (CheckDataUtil.checkNotEqual(articleDetailCustomer.getUserid(), userid)
					&& CheckDataUtil.checkNotEmpty(userid)) {
				String sendData = articedetailid +"-" + userid +"-"+articleDetailCustomer.getArticletypeid();
				SendMessUtil.sendData(jmsTemplate, searchDetail, sendData);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleDetailCustomer;
	}

	private void setThingReseaseTable(ArticleDetailCustomer articleDetailCustomer) {
		
		if (CheckDataUtil.checkNotEmpty(articleDetailCustomer.getCodeids())) {
			String [] values = articleDetailCustomer.getCodeids().split(",");
			List<Parametype> paramList = tribeCustomerMapper.parametypeList(values);
			String currentCheck = "";
			if (CheckDataUtil.checkNotEmpty(paramList)) {
				for (Parametype param:paramList) {
					currentCheck += param.getTypename()+",";
				}
				currentCheck = currentCheck.substring(0, currentCheck.length()-1);
			}
			articleDetailCustomer.setCurrentCheck(currentCheck);
		}
		
		
		
	}

	@Override
	public Articledetail getArticleDetailbyId(Integer articledetailid) {
		return articledetailMapper.selectByPrimaryKey(Long.valueOf(articledetailid));
	}

	@Override
	public List<TribeCustomer> indexhortibe(TribeVo tribeVo) {
		return tribeCustomerMapper.indexhortibe(tribeVo);
	}

	@Override
	public List<TribeCustomer> nearbrotribe(Long userid ,PageQuery pagequery) {
		return tribeCustomerMapper.nearbrotribe(userid ,pagequery);
	}

	@Override
	public Integer indexhortibCount(TribeVo tribeVo) {
		return tribeCustomerMapper.indexhortibCount(tribeVo);
	}

	@Override
	public Integer nearbrotribeCount(Long userid) {
		return tribeCustomerMapper.nearbrotribeCount(userid);
	}

	@Override
	public List<TribeCustomer> indexhorneartribe(TribeVo tribeVo) {
		
		AddressCustomer addressCustomer = tribeVo.getAddressCustomer() != null ? tribeVo.getAddressCustomer()
				: new AddressCustomer();
		//如果传入的经纬度有的话，根据附近查询
		if (addressCustomer.getNearLatude()!=null && !"".equals(addressCustomer.getNearLatude()) 
				&& addressCustomer.getNearLongitude()!=null && !"".equals(addressCustomer.getNearLongitude())) {
			addressCustomer.setMinLatude(Double.valueOf(addressCustomer.getNearLatude()) - 0.4);
			addressCustomer.setMaxLatude(Double.valueOf(addressCustomer.getNearLatude()) + 0.4);
			addressCustomer.setMaxLongitude(Double.valueOf(addressCustomer.getNearLongitude()) + 0.4);
			addressCustomer.setMinLongitude(Double.valueOf(addressCustomer.getNearLongitude()) - 0.4);
			tribeVo.setAddressCustomer(addressCustomer);
		}
		return tribeCustomerMapper.indexhorneartribe(tribeVo);
	}

	@Override
	public List<TribeCustomer> findtribedetailbyHouse(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return tribeCustomerMapper.findtribedetailbyHouse(tribeVo);
	}

	//签到榜单单
	public List<UserCustomer> tribesign(Long tribeid,PageQuery pagequery) {
		if (CheckDataUtil.checkisEmpty(tribeid)) 
			{return new ArrayList<>();}
		return tribeCustomerMapper.tribesign(tribeid , pagequery);
	}
	public int tribesignCount(Long tribeid) {
		return tribeCustomerMapper.tribesignCount(tribeid);
	}

	@Override
	public ResultMap edittribep(Articletype articletype) {
		if (articletype == null) {
			return ResultMap.build(400, "参数错误!");
		}
		Articletype type_search = checktypename (articletype.getTypename());
		if (type_search !=null) {
			return ResultMap.build(400, "该分类已经存在！");
		}
		 articletypeMapper.updateByPrimaryKeySelective(articletype);
		 return ResultMap.build(200, "恭喜你编辑成功！");
	}

	@Override
	public ResultMap intribep(String typename,Integer type) {
		if ("".equals(typename) || typename == null) {
			return ResultMap.build(400, "分类名称不能为空！");
		}
		Articletype type_search = checktypename (typename);
		if (type_search !=null) {
			return ResultMap.build(400, "该分类已经存在！");
		}
		Articletype type_in = new Articletype();
		type_in.setTypename(typename);
		type_in.setArticletypeid(type);
		type_in.setCodeids("");
		type_in.setTypeurl("");
		articletypeMapper.insertSelective(type_in);
		return ResultMap.build(200, "恭喜添加分类成功！");
	}

	private Articletype checktypename(String typename) {
		ArticletypeExample example = new ArticletypeExample();
		ArticletypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypenameEqualTo(typename);
		List<Articletype> typelist = articletypeMapper.selectByExample(example);
		if (!typelist.isEmpty() && typelist.size() >0) {
			return typelist.get(0);
		}
		return null;
	}

	@Override
	public ResultMap edittype(Tribetype tribetype) {
		if (tribetype.getTypename() == null || "".equals(tribetype.getTypename())) {
			return ResultMap.build(400, "请输入部落类别的名称！");
		}
		Tribetype tribe_type = checkarticletype(tribetype.getTypename());
		if (tribe_type !=null) {
			return ResultMap.build(400, "该部落类别的名称已经存在！");
		}
		tribetypeMapper.updateByPrimaryKeySelective(tribetype);
		return ResultMap.build(200, "恭喜你编辑成功！");
	}

	private Tribetype checkarticletype(String typename) {
		TribetypeExample example = new TribetypeExample();
		TribetypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypenameEqualTo(typename);
		List<Tribetype> list = tribetypeMapper.selectByExample(example);
		if (!list.isEmpty()&& list.size() >0 ) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public ResultMap createtribetype(Tribetype tribetype, Integer type) {
		if (tribetype.getTypename() == null || "".equals(tribetype.getTypename())) {
			return ResultMap.build(400, "部落类别的名称不能为空！");
		}
		if (tribetype.getInitial() == null || "".equals(tribetype.getInitial()) ) {
			return ResultMap.build(400,"请输入标签！");
		}
		Tribetype tribe_type = checkarticletype(tribetype.getTypename());
		if (tribe_type !=null) {
			return ResultMap.build(400, "该部落类别的名称已经存在！");
		}
		Tribetype type_in = new Tribetype();
		type_in.setCreate_time(new Date());
		type_in.setUpdate_time(new Date());
		type_in.setInitial(tribetype.getInitial());
		type_in.setTypecode(type);
		type_in.setTypename(tribetype.getTypename());
		tribetypeMapper.insertSelective(type_in);
		return ResultMap.build(200, "恭喜你创建分类成功！");
	}

	@Override
	public ResultMap tribecity() {
		// TODO Auto-generated method stub
		List<Tribetype> tribetypes =  tribeCustomerMapper.tribecity();
		return ResultMap.IS_200(tribetypes);
	}


	@Override
	public ResultMap updatetypedetail(Typedetail typedetail) {
		if (typedetail.getDetailname()  == null  || "".equals(typedetail.getDetailname())) {
			return ResultMap.build(400, "请输入分类的名称!");
		}
		Typedetail typedetail_search = checktypedetail(typedetail) ;
		if (typedetail_search !=null) {
			//说明该分类存在不容许重复添加
			return ResultMap.build(400, "该分类已经存在！");
		}
		typedetailMapper.updateByPrimaryKeySelective(typedetail);
		return ResultMap.build(200,"更新成功！");
	}

	private Typedetail checktypedetail(Typedetail typedetail) {
		TypedetailExample example = new TypedetailExample();
		TypedetailExample.Criteria criteria = example.createCriteria();
		criteria.andDetailnameEqualTo(typedetail.getDetailname());
		List<Typedetail> list = typedetailMapper.selectByExample(example);
		return list.size() == 0 || list.isEmpty() ? null :list.get(0);
	}


	@Override
	public ResultMap addtypedetail(Typedetail typedetail) {
		if (typedetail.getDetailname() == null || "".equals(typedetail.getDetailname())) {
			return ResultMap.build(400, "请输入分类的名称！");
		}
		Typedetail search = checktypedetail(typedetail);
		if (search !=null) {
			//说明该分类存在不容许重复添加
			return ResultMap.build(400, "该分类已经存在！");
		}
		typedetailMapper.insertSelective(typedetail);
		return ResultMap.build(200, "新建成功！");
	}

	@Override
	public List<Parametype> gettypenames(String[] types) {
		// TODO Auto-generated method stub
		//return releasetabkeMapper.gettypenames(types);
		return null;
	}

	@Override
	public List<Parametype> isin(String[] str) {
		// TODO Auto-generated method stub
		return null;
				//releasetabkeMapper.isin(str);
	}

	@Override
	public List<Parametype> isnot(String[] str) {
		// TODO Auto-generated method stub
		return null;
				//releasetabkeMapper.isnot(str);
	}

	@Override
	public void updatetyepdetail(Typedetail typedetail) {
		typedetailMapper.updateByPrimaryKeySelective(typedetail);
	}

	@Override
	public List<ArticleDetailCustomer> getarticlelist(TribeVo tribeVo) {
		AddressCustomer addressCustomer = tribeVo.getAddressCustomer() != null ? tribeVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();
		//如果取出经纬度时候
		if (addressCustomer.getNearLatude() !=null &&!"".equals(addressCustomer.getNearLatude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude()));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
		}//没有经纬度时候取用户的经纬度
		else {
			if (tribeVo.getUserid() !=null) {
				
				User user = userMapper.selectByPrimaryKey(tribeVo.getUserid());
				userCustomer.setLatitude(user.getLatitude());
				userCustomer.setLongitude(user.getLongitude());
			}
		}
		tribeVo.setUserCustomer(userCustomer);
		return tribeCustomerMapper.getarticlelist(tribeVo);
	}

	@Override
	public Integer getarticlelistCount(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return tribeCustomerMapper.getarticlelistCount(tribeVo);
	}

	@Override
	public ArticleDetailCustomer articledetail(TribeVo tribeVo) {
		AddressCustomer addressCustomer = tribeVo.getAddressCustomer() != null ? tribeVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();
		//如果取出经纬度时候
		if (addressCustomer.getNearLatude() !=null &&!"".equals(addressCustomer.getNearLatude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude()));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
		}//没有经纬度时候取用户的经纬度
		else {
			if (tribeVo.getUserid() !=null) {
				User user = userMapper.selectByPrimaryKey(tribeVo.getUserid());
				userCustomer.setLatitude(user.getLatitude());
				userCustomer.setLongitude(user.getLongitude());
			}
		}
		tribeVo.setUserCustomer(userCustomer);
		// TODO Auto-generated method stub
		ArticleDetailCustomer articleDetailCustomer =  tribeCustomerMapper.articledetail(tribeVo);
		//获得街道和区一级
        Delivery de_tr = releaseCustomerMapper.getTrandname(articleDetailCustomer.getCode());
		articleDetailCustomer.setDiscode(de_tr.getDiscode());
		articleDetailCustomer.setDisname(de_tr.getDisname());
		articleDetailCustomer.setTracode(de_tr.getTracode());
		articleDetailCustomer.setTradname(de_tr.getTradname());
		//获得区一级和市一级
		Delivery de_qu = releaseCustomerMapper.getquname(de_tr.getTracode());
		articleDetailCustomer.setCitycode(de_qu.getCitycode());
		articleDetailCustomer.setCityname(de_qu.getCityname());
		Delivery de_city = releaseCustomerMapper.getcityname(de_qu.getCitycode());
		articleDetailCustomer.setProcode(de_city.getProcode());
		articleDetailCustomer.setProname(de_city.getProname());
		return articleDetailCustomer;
	}

	@Override
	public ResultMap articledetailpay(Long userid, Long monery, Long articledetailid) {
		if (userid == null || monery ==null || articledetailid == null) {
			return ResultMap.build(500, "参数不足");
		}
		//第一步查询用户表余额
		Vipcount vipcount = getVipCountbyUserId(userid);
		if (vipcount == null) {
			InsertVipCount(userid); //插入vip表数据
			return ResultMap.build(400,"余额不足");
			
		}
		Double out = monery/100.0;
		if (vipcount.getBalance() < out) {return ResultMap.build(400,"余额不足");}
		
		//这里处理余额和消费记录。同步置天数
		//1,处理余额
		vipcount.setBalance(vipcount.getBalance() - out);
		vipcountMapper.updateByPrimaryKeySelective(vipcount); //更新钱包余额
		ArticleDetailCustomer articleDetailCustomer = this.getArticledetailandtype(articledetailid+"");
		//2,消费记录表插入记录
		Consume consume  = new Consume();
		Long consumeid = consumeCustomerMapper.getordernum();
		consume.setConsume_id(consumeid);
		consume.setCreate_time(new Date());
		consume.setUpdate_time(new Date());
		consume.setMonetary(out);
		consume.setDescname(articleDetailCustomer.getTypename()+"置顶");
		consume.setUser_id(userid+"");
		consume.setType(1);  // 1,消费 2充值
		consumeMapper.insertSelective(consume);
		
		//这里是处理置顶天数
		Integer topday = 0;
		if (out == 5) {topday = 1;}
		if (out == 40) {topday =7; }
		if (out == 168) {topday =30;}
		Articledetail articledetail = new Articledetail();
		articledetail.setState(1);
		articledetail.setArticledetailid(articledetailid);articledetail.setTopday(topday);
		
		
		articledetailMapper.updateByPrimaryKeySelective(articledetail);
		return ResultMap.build(200, "置顶成功");
	}

	private void InsertVipCount(Long userid) {
		Vipcount vipcount = new Vipcount();
		vipcount.setBalance(0.0);
		vipcount.setCount(100);
		vipcount.setCretime_time(new Date());
		vipcount.setIs_vip(1);
		vipcount.setUser_id(userid);
		vipcountMapper.insertSelective(vipcount);
	}

	private Vipcount getVipCountbyUserId(Long userid) {
		VipcountExample example = new VipcountExample();
		VipcountExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(userid);
		List<Vipcount> vipcounts = vipcountMapper.selectByExample(example);
		if ( !vipcounts.isEmpty() && vipcounts.size()>0) {
			return vipcounts.get(0);
		}
		return null;
	}

	@Override
	public ArticleDetailCustomer getArticledetailandtype(String articledetailid) {
		ArticleDetailCustomer articleDetailCustomer = tribeCustomerMapper.getArticledetailandtype(articledetailid);
		// TODO Auto-generated method stub
		return articleDetailCustomer;	
		}

	@Override
	public Integer myarticledetailCount(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return tribeCustomerMapper.myarticledetailCount(tribeVo);
	}

	@Override
	public List<ArticleDetailCustomer> myarticledetail(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return tribeCustomerMapper.myarticledetail(tribeVo);
	}

	@Override
	public ResultMap removearticledetail(Long articledetailid, Long userid) {
		if (articledetailid == null) {
			return ResultMap.build(400, "请选择一个物品");
		}
		if (userid == null) {
			return ResultMap.build(400, "请登录");
		}
		//移除之前判断一下是否有该物品
		Articledetail articledetail = articledetailMapper.selectByPrimaryKey(articledetailid);
		if (articledetail == null) {return ResultMap.build(400, "该物品不存在");}
		if (!articledetail.getUserid().equals(userid)) {return ResultMap.build(400, "不能移除别的东西");}
		articledetail.setState(3);//移除
		
		articledetailMapper.updateByPrimaryKeySelective(articledetail);
		ArticleDetailCustomer delete = new ArticleDetailCustomer();
		delete.setArticledetailid(articledetailid);
		delete.setArticletypeid(articledetail.getArticletypeid());
		tribeSolrDao.oneDetailDeleteFromSolr(delete);
		return ResultMap.build(200, "移除成功");
	}

	@Override
	public ResultMap updatemyarticledetail(Articledetail articledetail,Detaileaddress detaileaddress) {
		Long detailid = -2L;
		if (articledetail.getArticledetailid() == null) {
			return ResultMap.build(400, "请选择一个物品");
		}
		if (articledetail.getUserid() == null) {
			return ResultMap.build(400, "请登录");
		}
		detailid = checkeDetailaAddressExists(detaileaddress);
		if (detailid < 0) {
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = detaileaddress.getDetailid();
		}
		//移除之前判断一下是否有该物品
		Articledetail search = articledetailMapper.selectByPrimaryKey(articledetail.getArticledetailid());
		if (search == null) {return ResultMap.build(400, "该物品不存在");}
		if (!articledetail.getUserid().equals(search.getUserid())) {return ResultMap.build(400, "不能编辑别物品");}
		articledetail.setDetailid(detailid);//设置详情地址ID
		articledetailMapper.updateByPrimaryKeySelective(articledetail);
		return ResultMap.build(200, "编辑成功");
	}

	@Override
	public Integer myjointribeCount(Long userid) {
		return tribeCustomerMapper.myjointribeCount(userid);
	}

	/**判断是否是部落成员**/
	public boolean checkTribeIn(Long userid , Long tribeid) {
		if (CheckDataUtil.checkisEmpty(userid)) 
			{return false;}
		TribecontrollerExample example = new TribecontrollerExample();
		TribecontrollerExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andTribeidEqualTo(tribeid);
		criteria.andStateNotEqualTo(2);
		return tribecontrollerMapper.selectByExample(example).size() > 0;
	}

	

	/**部落页面查询物品的列表**/
	public SearchResult indexHortTribe(AddressCustomer addressCustomer, PageQuery pagequery) {
		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
		/* 分组 */ // 是否分组
		//query.setParam("group", true);
		// 分组的字段，不可以是多值字段
		//query.setParam("group.field", "tribeid");
		// 分组中每个组的上限数量，默认为1
		//query.setParam("group.limit", "1");
		// 分布式模式使用分组，并返回分组数量
		//query.setParam("group.ngroups", "true");
		SolrPageUtil.juliquery(query, "", addressCustomer);
		//query.add("fq", "tribeids:[1 TO *]");
		query.add("fq", "articletypeid:(6 or 7 or 8 or 1 or 10 )");
		SolrPageUtil.setStartAndEnd(pagequery, query);
		// 执行搜索，返回response对象
		query.addSort("update_time",ORDER.desc);
		return tribeSolrDao.indexHortTribe(query);
	}

	@Override
	public SearchResult detailIntribe(PageQuery pagequery, Long tribeid, Integer type) {
		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
		SolrPageUtil.juliquery(query, null, null);
		query.add("fq","tribeids:*"+tribeid+"*");
		if (CheckDataUtil.checkNotEqual(type, 0)) {
			query.add("fq","articletypeid:"+type+"");
		}
		SolrPageUtil.setStartAndEnd(pagequery, query);
		query.addSort("update_time",ORDER.desc);
		return tribeSolrDao.detailIntribe(query);
	}

	@Override
	public List<TribeCustomer> searchtribebyTypeid(Long userid, Long tribetypeid, PageQuery pagequery) {
		return tribeCustomerMapper.searchtribebyTypeid( userid,  tribetypeid,  pagequery) ;
	}

	@Override
	public int searchtribebyTypeidCount(Long userid, Long tribetypeid) {
		return tribeCustomerMapper.searchtribebyTypeidCount( userid,  tribetypeid);
	}

	@Override
	public List<DetailCustomer> searchToTribe(Long userid, Integer type, PageQuery pagequery) {
		// 查询挂到鱼塘的列表
		// 这里是查询房源
		List<DetailCustomer> detailList = new ArrayList<>();
		int infoCount = 0;
		
		// 房源的
		if (CheckDataUtil.checkisEqual(type, 1)){
			infoCount = tribeCustomerMapper.houseSearchToTribeCount(userid);
			pagequery.setPageParams(infoCount, pagequery.getPagesize(), pagequery.getCurrentpage());
			detailList = tribeCustomerMapper.houseSearchToTribe(userid ,pagequery ,null);
		}
		// 求租
		if (CheckDataUtil.checkisEqual(type, 2)) {
			infoCount = tribeCustomerMapper.qiuzuSearchToTribeCount(userid);
			pagequery.setPageParams(infoCount, pagequery.getPagesize(), pagequery.getCurrentpage());
			detailList = tribeCustomerMapper.qiuzuSearchToTribe(userid ,pagequery,null);
		}
		
		// 6 物品
		if (CheckDataUtil.checkisEqual(type, 6) 
				|| CheckDataUtil.checkisEqual(type, 7)
				|| CheckDataUtil.checkisEqual(type, 8)) {
			infoCount = tribeCustomerMapper.detailSearchToTribeCount(userid ,type);
			pagequery.setPageParams(infoCount, pagequery.getPagesize(), pagequery.getCurrentpage());
			detailList = tribeCustomerMapper.detailSearchToTribe(userid , type,pagequery , null);
		}
		
		return detailList;
	}

	@Override
	public List<TribeCustomer> searchLikeTribe(Long userid, String searchwhere, PageQuery pagequery) {
		return tribeCustomerMapper.searchLikeTribe(userid ,searchwhere,pagequery);
	}

	@Override
	public int searchLikeTribeCount(Long userid, String searchwhere) {
		return  tribeCustomerMapper.searchLikeTribeCount(userid ,searchwhere);
	}

	//吧 发布的房源，物品，之内的挂到部落里面。
	public ResultMap detailToTribe(Long tribeid, Long detailid, Integer type) {
		
		// 非空校验
		if (CheckDataUtil.checkisEmpty(tribeid) 
				|| CheckDataUtil.checkisEmpty(detailid)
				|| CheckDataUtil.checkisEmpty(type)) {
			return ResultMap.build(400, "数据不完整");
		}
		
		// 先校验部落是否存在
		Tribe tribe = tribeMapper.selectByPrimaryKey(tribeid);
		if (CheckDataUtil.checkisEmpty(tribe)) {
			return ResultMap.build(400,"该部落不存在");
		}
		// 发送的模板消息
		String sendData = "";
		// 挂起房源
		if (CheckDataUtil.checkisEqual(type, 1)) {
			House house = houseMapper.selectByPrimaryKey(detailid);
			if (CheckDataUtil.checkisEmpty(house)) 
				{ return ResultMap.build(400,"该房源不存在");}
			if (CheckDataUtil.checkNotEmpty(house.getTribeids())
					&& house.getTribeids().contains(tribeid+"")) 
				{ return ResultMap.build(400, "该部落已经同步过");}
			// 这里做同步
			if (CheckDataUtil.checkisEmpty( house.getTribeids() )) {
				house.setTribeids(tribeid+"");
			} else {
				house.setTribeids(house.getTribeids() +"," + tribeid);
			}
			houseMapper.updateByPrimaryKey(house);
			sendData = detailid +"-" + type ;
		}
		
		
		// 挂起物品
		if (CheckDataUtil.checkisEqual(type, 6)
				|| CheckDataUtil.checkisEqual(type, 7)
				|| CheckDataUtil.checkisEqual(type, 8)) {
			// 先判断物品存在不
			Articledetail articledetail =  articledetailMapper.selectByPrimaryKey(detailid);
			if (CheckDataUtil.checkisEmpty(articledetail)) 
				{ return ResultMap.build(400,"物品不存在");}
			if (CheckDataUtil.checkNotEmpty(articledetail.getTribeids())
					&& articledetail.getTribeids().contains(tribeid+"")) 
				{ return ResultMap.build(400, "该部落已经同步过");}
			// 这里做同步
			if (CheckDataUtil.checkisEmpty(articledetail.getTribeids())){
				articledetail.setTribeids( tribeid+"");
			}else {
				articledetail.setTribeids(articledetail.getTribeids() +"," + tribeid);
			}
			articledetailMapper.updateByPrimaryKey(articledetail);
			sendData = detailid +"-" + type ;
		}
		
		// 发送模板消息
		if (CheckDataUtil.checkisEmpty(sendData)) {
			return ResultMap.build(400, "参错误");
		}
		SendMessUtil.sendData(jmsTemplate, detailToTribe, sendData);
		return ResultMap.build(200,"挂起成功");
	}

	@Override
	public ResultMap articleEditSearch(Long onetypeid) {
		Map<String, Object> map = new HashMap<>();
		Articletype articletype= articletypeMapper.selectByPrimaryKey(onetypeid);
		String [] codeid = null;
		if (CheckDataUtil.checkNotEmpty( articletype.getCodeids() )) {
			 codeid = articletype.getCodeids().split(",");
		}else {
			codeid = new String[]{"-1"};
		}
		
		List<Parametype> isin = tribeCustomerMapper.parametypeListIS(codeid);
		List<Parametype> isnotin =  tribeCustomerMapper.parametypeListNot(codeid);
		isin.addAll(isnotin);
		map.put("paramList",isin);
	
		map.put("articletype", articletype);
		
		return ResultMap.IS_200(map);
	}

	@Override
	public ResultMap editarticletype(Long onetypeid, String typename, String codeids) {
		if (CheckDataUtil.checkisEmpty(onetypeid) || CheckDataUtil.checkisEmpty(typename)) 
		{ return ResultMap.build(400, "参数错误");}
		Articletype type = articletypeMapper.selectByPrimaryKey(onetypeid);
		if (CheckDataUtil.checkisEmpty(type)) {return ResultMap.build(400,"错误");}
		ArticletypeExample example = new ArticletypeExample();
		ArticletypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypenameEqualTo(typename);
		criteria.andOnetypeidNotEqualTo(onetypeid);
		List<Articletype> list = articletypeMapper.selectByExample(example);
		
		if (CheckDataUtil.checkNotEmpty(list))  {
			return ResultMap.build(400, "类型存在");
		}
		type.setCodeids(codeids);
		type.setTypename(typename);
		articletypeMapper.updateByPrimaryKeySelective(type);
		return ResultMap.IS_200(type.getArticletypeid());
	}

	// 查询我关注的
	public List<ArticleDetailCustomer> myfocus(Long userid, PageQuery pagequery,Integer articletypeid) {
		List<ArticleDetailCustomer> list =  tribeCustomerMapper.myfocus(userid ,pagequery ,articletypeid);
		
		List<String> tribids = new ArrayList<>();
		
		// 遍历数组取出所有的部落信息
		if (CheckDataUtil.checkNotEmpty(list)) {
			for (ArticleDetailCustomer detail : list) {
				if (CheckDataUtil.checkNotEmpty(detail.getTribeids())) {
					tribids.add(detail.getTribeids().split(",")[0]);
				}
				String tabName = "";
				// 如果是房源的时候需要在detailName后面加上房号
				if (CheckDataUtil.checkisEqual(detail.getArticletypeid(), 1)) {
					tabName = detail.getTypename();
					detail.setTitle(detail.getTitle() + "  " + detail.getHouseNub() + "号房");
				}
				if (CheckDataUtil.checkisEqual(detail.getArticletypeid(), 2)) {
					tabName = "【求租】";
				}
				if (CheckDataUtil.checkisEqual(detail.getArticletypeid(), 6)) {
					tabName = "【物品】";
				}
				if (CheckDataUtil.checkisEqual(detail.getArticletypeid(), 7)) {
					tabName = "【找人】";
				}
				if (CheckDataUtil.checkisEqual(detail.getArticletypeid(), 8)) {
					tabName = "【问答】";
				}
				if (CheckDataUtil.checkisEqual(detail.getArticletypeid(), 9)) {
					tabName = "【视频】";
				}
				detail.setTabName(tabName);
			}
		}
		
		// 如果拿到了tribeids
		if (CheckDataUtil.checkNotEmpty(tribids)) {
			List<Tribe> tribeList = tribeCustomerMapper.searchtribebyids(tribids);
			for (ArticleDetailCustomer detail : list) {
				//如果外面不为空在遍历内层
				if (CheckDataUtil.checkNotEmpty(detail.getTribeids())) {
					for (Tribe tribe : tribeList) {
						if (detail.getTribeids().startsWith(tribe.getTribeid().toString())) {
							detail.setTribeid(tribe.getTribeid());
							detail.setTribename(tribe.getName());
						}
					}
				}
				
			}
		}
		
		
		
		return list ;
	}
	public int myfocusCount(Long userid) {
		// TODO Auto-generated method stub
		return tribeCustomerMapper.myfocusCount(userid);
	}

	@Override
	public List<DetailCustomer> mydetails(Long userid, Integer type, PageQuery pagequery) {
		int infoCount = tribeCustomerMapper.detailSearchToTribeCount(userid ,type);
		pagequery.setPageParams(infoCount, pagequery.getPagesize(), pagequery.getCurrentpage());
		List<DetailCustomer> detailList = tribeCustomerMapper.mydetails(userid ,
				type,pagequery , null);
		return detailList;
	}

	@Override
	public DetailCustomer detailEditSearch(Long articledetailid) {
		// TODO Auto-generated method stub
		return tribeCustomerMapper.detailEditSearch(articledetailid);
	}



	
	
	
	

}
