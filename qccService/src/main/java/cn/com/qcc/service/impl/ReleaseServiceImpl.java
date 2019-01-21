package cn.com.qcc.service.impl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
//import cn.com.qcc.mapper.ArticleMapper;
import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.ArticletypeMapper;
import cn.com.qcc.mapper.ConsumeMapper;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mapper.MyorderMapper;
import cn.com.qcc.mapper.ParametypeMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mapper.ReleasetableMapper;
import cn.com.qcc.mapper.ReleasetypeMapper;
import cn.com.qcc.mapper.StoreMapper;
import cn.com.qcc.mapper.StoreconnMapper;
import cn.com.qcc.mapper.TransmitsendMapper;
import cn.com.qcc.mapper.TypedetailMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mymapper.ConsumeCustomerMapper;
import cn.com.qcc.mymapper.ReleaseCustomerMapper;
import cn.com.qcc.mymapper.TribeCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
//import cn.com.qcc.pojo.Article;
import cn.com.qcc.pojo.ArticleExample;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.ArticletypeExample;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import cn.com.qcc.pojo.Myorder;
import cn.com.qcc.pojo.MyorderExample;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.ParametypeExample;
import cn.com.qcc.pojo.Releasetable;
import cn.com.qcc.pojo.ReleasetableExample;
import cn.com.qcc.pojo.Store;
import cn.com.qcc.pojo.StoreExample;
import cn.com.qcc.pojo.Storeconn;
import cn.com.qcc.pojo.StoreconnExample;
import cn.com.qcc.pojo.Transmitsend;
import cn.com.qcc.pojo.Typedetail;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.pojo.VipcountExample;
import cn.com.qcc.queryvo.DetailCustomer;
import cn.com.qcc.queryvo.ReleaseCustomer;
import cn.com.qcc.queryvo.ReleaseVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.ReleaseService;

@Service
public class ReleaseServiceImpl implements ReleaseService {
	//@Autowired
	//ArticleMapper articleMapper;
	@Autowired
	ArticledetailMapper articledetailMapper;
	@Autowired
	ReleasetypeMapper releasetypeMapper;
	@Autowired
	ReleaseCustomerMapper releaseCustomerMapper;
	@Autowired
	ReleasetableMapper releasetableMapper;
	@Autowired
	ArticletypeMapper articletypeMapper;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	ProfileMapper profileMapper;
	@Autowired
	StoreconnMapper storeconnMapper;
	@Autowired
	DetaileaddressMapper detaileaddressMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	ConsumeCustomerMapper consumeCustomerMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	TypedetailMapper typedetailMapper;
	@Autowired
	MyorderMapper myorderMapper;
	@Autowired
	VipcountMapper vipcountMapper;
	@Autowired
	ConsumeMapper consumeMapper;
	@Autowired
	ParametypeMapper parametypeMapper;
	@Autowired
	TransmitsendMapper transmitsendMapper;
	@Autowired
	TribeCustomerMapper tribeCustomerMapper;
	
	

	// 发布规格参数物品
	public ResultMap pushdetail(ReleaseCustomer releaseCustomer) {

		if (releaseCustomer.getTypedetailid() == null) {
			return ResultMap.build(400, "请选择物品发布类型！");
		}
		if (releaseCustomer.getCount() == null) {
			return ResultMap.build(400, "请输入发布数量！");
		}
		if (releaseCustomer.getPicture() == null) {
			return ResultMap.build(400, "请输入价格！");
		}
		if (releaseCustomer.getPicture() == null || "".equals(releaseCustomer.getPicture())) {
			return ResultMap.build(400, "请插入最少一张图片！");
		}
		/*if (releaseCustomer.getCodeid() == null || "".equals(releaseCustomer.getCodeid())) {
			return ResultMap.build(400, "请输入物品规格参数");
		}*/
		if (releaseCustomer.getTitle() == null || "".equals(releaseCustomer.getTitle())) {
			return ResultMap.build(400, "请输入标题!");
		}
		if (releaseCustomer.getDescription() == null || "".equals(releaseCustomer.getDescription())) {
			return ResultMap.build(400, "请输入物品描述！");
		}
		// 先获取物品详情的ID
		Long articledetailid = Articledetailinsert(releaseCustomer);
		Long tribeid = releaseCustomer.getTribeid();
		if (tribeid == null) {
			tribeid = -1L;
		}
		// 添加部落管理
		this.addarticle(tribeid, articledetailid, 6, tribeid);
		// 更新或者插入物品控制表
		updateReleasetable(articledetailid, releaseCustomer);
		return ResultMap.IS_200(articledetailid);
	}

	private void updateReleasetable(Long articledetailid, ReleaseCustomer releaseCustomer) {
		Releasetable table = new Releasetable();
	//	table.setCode(releaseCustomer.getCode());
		table.setArticledetailid(articledetailid);
		table.setCount(releaseCustomer.getCount());
		table.setPrices(releaseCustomer.getPrices());
	//	table.setUserid(releaseCustomer.getUserid());
		table.setUpdate_time(new Date());
		table.setCount(releaseCustomer.getCount());
		//table.setCodeid(releaseCustomer.getCodeid());
		// 校验物品控制表是否存在该数据
		Releasetable search = CheckReleasebatle(table);
		if (search == null) {
			releasetableMapper.insertSelective(table);
		} else {
			table.setReleaseid(search.getReleaseid());
			releasetableMapper.updateByPrimaryKeySelective(table);
		}

	}

	private Releasetable CheckReleasebatle(Releasetable table) {
		ReleasetableExample example = new ReleasetableExample();
		ReleasetableExample.Criteria criteria = example.createCriteria();
		//criteria.andCodeidEqualTo(table.getCodeid());
		criteria.andArticledetailidEqualTo(table.getArticledetailid());
		//criteria.andUseridEqualTo(table.getUserid());
		List<Releasetable> list = releasetableMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	private Long Articledetailinsert(ReleaseCustomer releaseCustomer) {

		Long articledetailid = null;

		Articledetail articledetail = new Articledetail();
		// 发布人ID
	//	articledetail.setUserid(releaseCustomer.getUserid());
		// 物品状态，目前没用
		articledetail.setState(1);
		// 大的分类的ID，前台传过来
		//articledetail.setArticletypeid(releaseCustomer.getArticletypeid());
		// 设置物品图片
		articledetail.setPicture(releaseCustomer.getPicture());
		// 设置其中一个的价格
		//articledetail.setPrices(releaseCustomer.getPrices());
		// 设置物品的标题
		articledetail.setTitle(releaseCustomer.getTitle());
		// 设置物品的描述
		articledetail.setDescription(releaseCustomer.getDescription());
		// 大的 分类下小的分类 的ID
		//articledetail.setTypedetailid(releaseCustomer.getTypedetailid());
		// 创建更新时间
		//articledetail.setUpdate_time(new Date());
		// 执行插入
		if (releaseCustomer.getArticledetailid() == null) {
			articledetailMapper.insertSelective(articledetail);
			articledetailid = articledetail.getArticledetailid();
		} else {
			articledetailid = releaseCustomer.getArticledetailid();
			articledetail.setArticledetailid(articledetailid);
			articledetailMapper.updateByPrimaryKey(articledetail);
		}
		Long storeid = null;
		// 检查用户是否有店铺
		//Store store = checkstroe(releaseCustomer.getUserid());
		// 如果不存在店铺
		//if (store == null) {
			storeid = createstore(releaseCustomer);
		//} else {
		//	storeid = store.getStoreid();
		//}

		// 检查店铺控制表中是否存在数据
		Storeconn conn = checkstroeconn(storeid, articledetailid);
		// 如果店铺中没有此商品需要做关联
		if (conn == null) {
			createstoreconn(storeid, articledetailid);
		}

		return articledetailid;
	}

	// 添加店铺控制
	private void createstoreconn(Long storeid, Long articledetailid) {
		Storeconn storeconn = new Storeconn();
		storeconn.setArticledetailid(articledetailid);
		storeconn.setStoreid(storeid);
		storeconn.setState(1);
		storeconnMapper.insert(storeconn);
	}

	// 检查店铺中是否有此商品
	private Storeconn checkstroeconn(Long storeid, Long articledetailid) {
		StoreconnExample example = new StoreconnExample();
		StoreconnExample.Criteria criteria = example.createCriteria();
		criteria.andStoreidEqualTo(storeid);
		criteria.andArticledetailidEqualTo(articledetailid);
		List<Storeconn> stro = storeconnMapper.selectByExample(example);
		if (!stro.isEmpty() && stro.size() > 0) {
			return stro.get(0);
		}
		return null;
	}

	// 默认创建一个店铺
	private Long createstore(ReleaseCustomer releaseCustomer) {

		UserCustomer userCustomer = null;
				//userCustomerMapper.getUserAndProfileByUserid(releaseCustomer.getUserid());

		Detaileaddress detaileaddress = new Detaileaddress();
		detaileaddress.setDetailes(releaseCustomer.getAddressname());
		detaileaddress.setLongitude(new BigDecimal(userCustomer.getLongitude()));
		detaileaddress.setLatitude(new BigDecimal(userCustomer.getLatitude()));
		Long detailid = checkeDetailaAddressExists(detaileaddress);
		if (detailid == -1) {
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = Long.valueOf(detaileaddress.getDetailid());
		}
		Store store = new Store();
		//store.setUserid(releaseCustomer.getUserid());
		store.setName(userCustomer.getUser_name());
		store.setPicture(userCustomer.getAvatar());
		store.setCityname(releaseCustomer.getCityname());
		store.setDetailid(detailid);
		store.setUpdate_time(new Date());
		store.setDescription("该店主很懒，暂时没有添加描述");
		storeMapper.insertSelective(store);
		return store.getStoreid();
	}

	private Store checkstroe(Long userid) {
		StoreExample example = new StoreExample();
		StoreExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Store> stores = storeMapper.selectByExample(example);
		if (!stores.isEmpty() && stores.size() > 0) {
			return stores.get(0);
		}
		return null;
	}

	@Override
	public ResultMap gettypename(String typeid) {
		String[] ids = typeid.split(",");
		List<Parametype> list = releaseCustomerMapper.gettypename(ids);
		return ResultMap.IS_200(list);
	}

	@Override
	public ResultMap getcodename(Long typeid) {
		List<Parametype> list = releaseCustomerMapper.getcodename(typeid);
		return ResultMap.IS_200(list);
	}

	@Override
	public ResultMap batch(ReleaseVo releaseVo) {
		List<ReleaseCustomer> list = releaseVo.getReleList();
		for (ReleaseCustomer rele : list) {
			pushdetail(rele);
		}
		return ResultMap.IS_200();
	}

	// 获得所有物品的总分类
	public List<Articletype> getarticlelist() {
		ArticletypeExample example = new ArticletypeExample();
		ArticletypeExample.Criteria criteria = example.createCriteria();
		// 6代表物品总分类
		//criteria.andTypeEqualTo(6);
		List<Articletype> articletypes = articletypeMapper.selectByExample(example);
		return articletypes;
	}

	@Override
	public List<ReleaseCustomer> getnewrelease(ReleaseVo releaseVo) {
		if (releaseVo.getUserid() != null) {
			cn.com.qcc.pojo.User user = userMapper.selectByPrimaryKey(releaseVo.getUserid());
			//User user = userMapper.selectByPrimaryKey(releaseVo.getUserid());
			UserCustomer userCustomer = new UserCustomer();
			userCustomer.setLatitude(user.getLatitude());
			userCustomer.setLongitude(user.getLongitude());
			releaseVo.setUserCustomer(userCustomer);
		}
		return releaseCustomerMapper.getnewrelease(releaseVo);
	}

	@Override
	public int getnewreleaseCount(ReleaseVo releaseVo) {
		return releaseCustomerMapper.getnewreleaseCount(releaseVo);
	}

	// 物品关联部落
	public void addarticle(Long tribeid, Long articledetailid, Integer type, Long otherid) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria criteria = example.createCriteria();
		// 处理房源的TYPE
		if (type == 1) {
			articledetailid = 1L;
		}
		criteria.andTribeidEqualTo(tribeid);
		criteria.andArticledetailidEqualTo(articledetailid);
		criteria.andOtheridEqualTo(otherid);
		/*List<Article> list = articleMapper.selectByExample(example);
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
		}*/
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
			return Long.valueOf(detail_search.getDetailid());
		} else {
			return -1L;
		}

	}

	// 点击我想要获得物品规格参数
	public ResultMap getypeidbyarticleid(Long articledetailid) {
		String ids = "";
		Map<String, Object> map = new HashMap<>();
		// 通过物品主键获得详情 -- >目前是获得物品的最后一次类目
		Articledetail articledetail = articledetailMapper.selectByPrimaryKey(articledetailid);
		// 在通过物品的类目ID获得标签的字符串
		Typedetail typedetail = typedetailMapper.selectByPrimaryKey(null);
		// 这里可以获得物品的typeids
		String[] typeids = typedetail.getTypeid().split(",");
		// 获得物品的标签和规格参数
		List<Parametype> typename = releaseCustomerMapper.gettypename(typeids);
		ReleasetableExample example = new ReleasetableExample();
		ReleasetableExample.Criteria criteria = example.createCriteria();
		criteria.andArticledetailidEqualTo(articledetailid);
		List<Releasetable> tables = releasetableMapper.selectByExample(example);
		if (!tables.isEmpty() && tables.size() > 0) {
			for (Releasetable t : tables) {
				//ids += t.getCodeid();
			}
		}
		String[] sss = ids.split(",");
		List<Parametype> codename = releaseCustomerMapper.findtypenameandcodename(sss);

		map.put("articledetail", articledetail);
		map.put("typename", typename);
		map.put("codename", codename);
		return ResultMap.IS_200(map);
	}

	// 根据物品的参数集合和物品详情的ID查询物品的价格和库存
	public ResultMap getsimpledetail(Releasetable releasetable) {
		/*// 获取物品的基本参数
		ReleaseCustomer search = releaseCustomerMapper.getsimpledetail(releasetable);
		String[] ids = releasetable.getCodeid().split(",");
		// 获得标签的名字
		List<Parametype> parametypes = releaseCustomerMapper.getnames(ids);
		String str = "你选择的：";
		for (Parametype parm : parametypes) {
			str += parm.getTypename() + "类型;" + parm.getCodename() + ",";
		}
		search.setTypename(str.substring(0, str.length() - 1));*/
		return ResultMap.IS_200(null);
	}

	// 我的收货地址列表
	public List<Delivery> mydelivery(Long userid) {
		List<Delivery> list = releaseCustomerMapper.mydelivery(userid);
		for (Delivery delivery : list) {
			//获得街道和区一级
			Delivery de_tr = releaseCustomerMapper.getTrandname(delivery.getCode());
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
		return list;
	}

	// 创建一个待支付订单
	public ResultMap createorder(Myorder order) {
		if (order.getNumber() == null) {
			return ResultMap.build(700,"购买数量不能为空！");
		}
		Long consumeid = createconsume(order);
		// 未支付状态
		Long ordernum = myorderMapper.getordernum();
		order.setState(1);
		order.setOrdernum(ordernum);
		order.setNumber(order.getNumber());
		order.setConsumeid(consumeid);
		order.setUpdate_time(new Date());
		// 检查当前未支付的订单是否存在
		Myorder orMyorder = checkorder(order);
		if (orMyorder == null) {
			myorderMapper.insertSelective(order);
			consumeid = order.getConsumeid();
		} else {
			orMyorder.setUpdate_time(new Date());
			myorderMapper.updateByPrimaryKeySelective(orMyorder);
			consumeid = orMyorder.getConsumeid();
			ordernum = orMyorder.getOrdernum();
		}
		UserCustomer user = userCustomerMapper.searchbalance(order.getUserid());
		user.setConsumeid(consumeid);
		user.setOrdernum(ordernum);
		return ResultMap.build(201, "创建待支付订单成功！", user);
	}

	// 检查当前未支付的订单是否存在
	private Myorder checkorder(Myorder order) {
		MyorderExample example = new MyorderExample();
		MyorderExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(order.getUserid());
		criteria.andDeliveryidEqualTo(order.getDeliveryid());
		criteria.andReleaseidEqualTo(order.getReleaseid());
		criteria.andTotalpricesEqualTo(order.getTotalprices());
		criteria.andStateEqualTo(1);
		List<Myorder> myorders = myorderMapper.selectByExample(example);
		if (!myorders.isEmpty() && myorders.size() > 0) {
			return myorders.get(0);
		}
		return null;
	}

	// 查询用户于额表
	public Vipcount getuserbalance(Myorder order) {
		VipcountExample example = new VipcountExample();
		VipcountExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(order.getUserid());
		List<Vipcount> VIP = vipcountMapper.selectByExample(example);
		if (VIP.size() > 0 && !VIP.isEmpty()) {
			return VIP.get(0);
		}
		return null;
	}

	// 支付成功后的操作
	public void paysuccess(Myorder order) {

		// 更新订单的状态
		order.setState(2);
		myorderMapper.updateByPrimaryKeySelective(order);

		//
	}

	@Override
	public ResultMap payreturn(Myorder myorder, String payword, Releasetable releasetable) {

		// 首先检验支付密码是否正确
		Vipcount vipcount = getuserbalance(myorder);
		/*if ("".equals(payword) || payword == null) {
			return ResultMap.build(400, "支付密码不能为空！");
		}*/
		/*if (vipcount.getPayword() == null || !payword.equals(vipcount.getPayword())) {
			return ResultMap.build(400, "支付密码错误！");
		}*/
		if (myorder.getOrdernum() == null) {
			return ResultMap.build(400, "支付号不能为空！");
		}
		// 查询商品库存
		Releasetable search = releasetableMapper.selectByPrimaryKey(releasetable.getReleaseid());
		if (search.getCount() <  releasetable.getCount() ) {
			return ResultMap.build(400, "库存不足");
		}
		search.setCount(search.getCount() - releasetable.getCount());
		releasetableMapper.updateByPrimaryKeySelective(search);

		// 如果都过了。说明支付成功.第一步，改变消费表记录
		Consume search_conn = consumeMapper.selectByPrimaryKey(myorder.getConsumeid());
		search_conn.setType(1);
		consumeMapper.updateByPrimaryKeySelective(search_conn);
		// 第二步，更新订单状态
		myorder.setState(2);
		myorderMapper.updateByPrimaryKeySelective(myorder);
		// 同步用户余额表
		vipcount.setBalance(vipcount.getBalance() - myorder.getTotalprices());
		vipcountMapper.updateByPrimaryKeySelective(vipcount);

		return ResultMap.build(200, "支付成功");
	}

	private Long createconsume(Myorder myorder) {
		Long consumeid = consumeCustomerMapper.getordernum();
		Consume consume = new Consume();
		consume.setConsume_id(consumeid);
		consume.setCreate_time(new Date());
		consume.setMonetary(-myorder.getTotalprices());
		consume.setDescname("商城消费");
		consume.setType(1); // 1,消费  2，充值
		consume.setUpdate_time(new Date());
		consume.setUser_id(myorder.getUserid() + "");
		consumeMapper.insert(consume);
		return consume.getConsume_id();
	}

	
	

	@Override
	public UserCustomer getbalanceandphone(Myorder order) {
		// TODO Auto-generated method stub
		return releaseCustomerMapper.getbalanceandphone(order);
	}

	//获得所有的规格参数
	public List<Parametype> allarticle(Integer fatherid) {
		// TODO Auto-generated method stub
		return releaseCustomerMapper.allarticle(fatherid);
	}

	@Override
	public ResultMap addarticle(Parametype parametype) {
		/*if (parametype.getTypeid() == null) {
			return ResultMap.build(400, "不能为空");
		}
		if (parametype.getTypename() == null || "".equals(parametype.getTypename())) {
			return ResultMap.build(400, "不能为空");
		}
		if (parametype.getCodename() == null || "".equals(parametype.getCodename()) ||
				"新增成功".equals(parametype.getCodename())	||	"已存在".equals(parametype.getCodename())	
				||	"不能为空".equals(parametype.getCodename())) {
			return ResultMap.build(400, "不能为空");
		}
		Parametype check = new Parametype();
		check.setCodename(parametype.getCodename());
		check.setTypename(parametype.getTypename());
		Parametype search = Checkarticle(check);
		if (search !=null) {
			return ResultMap.build(400, "已存在");
		}
		Long codeid = parametypeMapper.getmaxcodeid();
		parametype.setCodeid(codeid);
		parametypeMapper.insertSelective(parametype);*/
		return ResultMap.build(200, "新增成功");
	}


	//修改分类名称
	public ResultMap editarticle(Parametype parametype) {
		
		if (CheckDataUtil.checkisEmpty(parametype.getCodeid())
			|| CheckDataUtil.checkisEmpty(parametype.getTypename())) {
			return ResultMap.build(400, "参数错误");
		}
		ParametypeExample check = new ParametypeExample();
		ParametypeExample.Criteria criteria = check.createCriteria();
		criteria.andTypenameEqualTo(parametype.getTypename());
		criteria.andCodeidNotEqualTo(parametype.getCodeid());
		List<Parametype> list = parametypeMapper.selectByExample(check);
		if (CheckDataUtil.checkNotEmpty(list)) {
			return ResultMap.build(400, "分类存在");
		}
		parametypeMapper.updateByPrimaryKeySelective(parametype);
		return ResultMap.build(200, "编辑成功");
	}

	@Override
	public ResultMap getcodenamebytypeid(Parametype parametype) {
		/*// TODO Auto-generated method stub
		List<Parametype> parametypes = parametypeMapper.getcodenamebytypeid(parametype);*/
		return ResultMap.IS_200(null);
	}

	@Override
	public ResultMap editcodenamebycodeid(Parametype parametype) {
		/*if (parametype.getCodename() == null || "".equals(parametype.getCodename())||
				"修改成功".equals(parametype.getCodename())	||	"规格参数错误".equals(parametype.getCodename())	) {
			return ResultMap.build(400, "规格参数错误");
		}
		//判断规格参数是否相同需要根据分类名称和规格的名称判断
		Parametype check = new Parametype();
		check.setCodename(parametype.getCodename());
		check.setTypename(parametype.getTypename());
		Parametype search = Checkarticle(check);
		if (search !=null) {
			return ResultMap.build(400, "规格参数错误");
		}
		parametypeMapper.editcodenamebycodeid(parametype);*/
		return ResultMap.build(200, "修改成功");
	}

	@Override
	public ResultMap addtypename(Parametype parametype) {
		if (parametype.getTypename() ==null || "".equals(parametype.getTypename())) {
			return ResultMap.build(400, "分类名称错误");
		}
		ParametypeExample example = new ParametypeExample();
		ParametypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypenameEqualTo(parametype.getTypename());
		List<Parametype> list = parametypeMapper.selectByExample(example);
		if (CheckDataUtil.checkNotEmpty(list)) {
			return ResultMap.build(400, "分类名称存在");
		}
		parametypeMapper.insert(parametype);
		return ResultMap.build(200, "新增成功");
	}

	/**查询商品的一级分类的参数**/
	public List<ReleaseCustomer> searchFirstTypeName(String[] codeid) {
		return releaseCustomerMapper.searchFirstTypeName(codeid);
	}

	/**查询商品的二级分类的参数**/
	public List<Parametype> searchSecondTypeName(String[] codeid) {
		return releaseCustomerMapper.searchSecondTypeName(codeid);
	}

	// 校验是否可以发送
	public ResultMap checkIsSend(Transmitsend send) {
		boolean flag = false;
		if (CheckDataUtil.checkisEmpty(send.getUserid()) 
				|| CheckDataUtil.checkisEmpty(send.getArticletypeid())
				|| CheckDataUtil.checkisEmpty(send.getOtherid())) {
			return ResultMap.build(400, "参数不全");
		}
		// 先去查询
		Transmitsend check = releaseCustomerMapper.searchTrans(send);
		// 第一次发送
		if (CheckDataUtil.checkisEmpty(check)) {
			send.setUpdate_time(new Date());
			transmitsendMapper.insertSelective(send);
			flag =  true ; 
		} else {
			// 比较时间
			Date cuntTime = new Date();
			Long cunt = cuntTime.getTime();
			Long old = check.getUpdate_time().getTime() + 3600000*4;
			if (cunt > old) {
				check.setUpdate_time(cuntTime);
				// 这里做更新处理
				flag = true ;
				releaseCustomerMapper.updateTrans(check);
			} 
		}
		Integer code = 400;
		Object obj = null;
		List<DetailCustomer> list = null;
		// 如果不是空
		if (flag) {
			code = 200;
			if (CheckDataUtil.checkisEqual(send.getArticletypeid(), 1)) { 
				list = tribeCustomerMapper.houseSearchToTribe(null, null, send.getOtherid());
			}
			if (CheckDataUtil.checkisEqual(send.getArticletypeid(), 2)) {
				list = tribeCustomerMapper.qiuzuSearchToTribe(null, null, send.getOtherid());
			}
			if (CheckDataUtil.checkisEqual(send.getArticletypeid(), 6)
					|| CheckDataUtil.checkisEqual(send.getArticletypeid(), 7)
					|| CheckDataUtil.checkisEqual(send.getArticletypeid(), 8)) {
				list = tribeCustomerMapper.detailSearchToTribe(null, send.getArticletypeid(), null, send.getOtherid());
			}
		}
		
		if (CheckDataUtil.checkNotEmpty(list)) {
			obj = list.get(0);
		}
		
		return ResultMap.build(code, "", obj);
	}

	
}
