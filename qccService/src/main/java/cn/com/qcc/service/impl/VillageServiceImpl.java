package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.AreaMapper;
import cn.com.qcc.mapper.BrandMapper;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.RentalMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mapper.VillagetypeMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.mess.util.SolrPageUtil;
import cn.com.qcc.mymapper.AreaCustomerMapper;
import cn.com.qcc.mymapper.VillageCustomerMapper;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.AreaExample;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.BuildingExample;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Rental;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.VillageExample;
import cn.com.qcc.pojo.Villagetype;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ApartmentCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HousetagCustomer;
import cn.com.qcc.queryvo.MetroCustomer;
import cn.com.qcc.queryvo.SearchModal;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.HousertargService;
import cn.com.qcc.service.VillageService;
import cn.com.qcc.service.solrdao.BuilSolrDao;
import cn.com.qcc.service.solrdao.VillageSolrDao;
import weixin.util.XiaoChengXuCodeUtil;

@Service
public class VillageServiceImpl implements VillageService {

	@Autowired VillageCustomerMapper villageCustomerMapper;
	@Autowired VillageMapper villageMapper;
	@Autowired BuildingMapper buildingMapper;
	@Autowired DetaileaddressMapper detaileaddressMapper;
	@Autowired AreaMapper areaMapper;
	@Autowired AreaCustomerMapper areaCustomerMapper;
	@Autowired UserMapper userMapper;
	@Autowired HouseMapper houseMapper;
	@Autowired BrandMapper brandMapper;
	@Autowired SystemstateMapper systemstateMapper;
	@Autowired VillagetypeMapper villagetypeMapper;
	@Autowired RentalMapper rentalMapper;
	@Autowired BrokerMapper brokerMapper;
	@Autowired HousertargService housertargService;
	@Autowired BuilSolrDao builSolrDao;
	@Autowired VillageSolrDao villageSolrDao;
	@Resource  Destination builAdd;
	@Resource  Destination builUpdate;
	@Resource  Destination villageAdd;
	@Resource  Destination builSearch;
	@Autowired JmsTemplate jmsTemplate;
	@Autowired JedisClient jedisClient;

	/**
	 * 地区下面的小区
	 * **/ 
	public List<VillageCustomer> findAllVillage(VillageeVo villageeVo) {
		return villageCustomerMapper.findAllVillage(villageeVo);
	}

	/**
	 * 小区下面的楼栋
	 * **/ 
	public List<VillageCustomer> findBuildingListByVillage(VillageeVo villageeVo) {
		villageeVo = villageeVo != null ? villageeVo : new VillageeVo();
		VillageCustomer villageCustomer = villageeVo.getVillageCustomer() != null ? villageeVo.getVillageCustomer()
				: new VillageCustomer();

		villageeVo.setVillageCustomer(villageCustomer);
		return villageCustomerMapper.findBuildingListByVillage(villageeVo);
	}


	// 发布小区
	public ResultMap saveVillage(Village village, Detaileaddress detaileaddress) {
		if (detaileaddress.getLatitude() == null || "".equals(detaileaddress.getLatitude())) {
			return ResultMap.build(700, "检查定位");
		}
		if (detaileaddress.getDetailes() == null || "".equals(detaileaddress.getDetailes())) {
			return ResultMap.build(700, "输入详情地址");
		}
		if (village.getCode() == null || "".equals(village.getCode())) {
			return ResultMap.build(701, "检查区域");
		}
		if (village.getUserid() == null) {
			return ResultMap.build(404, "操作需要登录");
		}
		if (village.getPicture() == null || "".equals(village.getPicture())) {
			return ResultMap.build(401, "插入图片");
		}
		if (village.getPicture().contains("undefined")) {
			return ResultMap.build(402, "图片格式错误");
		}
		if (village.getVillagename() == null || "".equals(village.getVillagename())) {
			return ResultMap.build(703, "输入小区名称");
		}
		// 判断小区是否存在
		Village village_search = checkvillageExists(village);
		if (village_search != null) {
			return ResultMap.build(702, "小区存在");
		}
		Long detailid = checkeDetailaAddressExists(detaileaddress);
		if (detailid < 0) {
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = detaileaddress.getDetailid();
		}
		// 通过
		Integer searchstate = systemstateMapper.selectByPrimaryKey(7).getDefaultstate();
		village.setState(searchstate);
		village.setDetailid(Long.valueOf(detailid));
		// 设置更新时间
		village.setUpdate_time(new Date());
		village.setXcxpicture("");
		villageMapper.insertSelective(village);
		
		String sendData = village.getVillageid()+"";
		SendMessUtil.sendData(jmsTemplate, villageAdd, sendData);
		
		// 发布成功后发送消息
		return ResultMap.build(200, "更新成功");
	}

	// 检验最小地址是否存在
	private Village checkvillageExists(Village village) {
		VillageExample example = new VillageExample();
		VillageExample.Criteria criteria = example.createCriteria();
		if (village.getVillageid() != null) {
			criteria.andVillageidNotEqualTo(village.getVillageid());
		}
		criteria.andCodeEqualTo(village.getCode());
		criteria.andVillagenameEqualTo(village.getVillagename());
		List<Village> villagelist = villageMapper.selectByExample(example);
		if (!villagelist.isEmpty() && villagelist.size() > 0) {
			return villagelist.get(0);
		}
		return null;
	}

	// 发布楼栋
	public ResultMap savebuild(Village village, Building building, Detaileaddress detaileaddress,String brand) {
		
		if (CheckDataUtil.checkisEmpty(building.getBrandid()) || building.getBrandid()<0 ) {
			building.setBrandid(null);
		}
		if (CheckDataUtil.checkisEmpty(building.getUserid())) {
			return ResultMap.build(404, "请先登录");
		}
		if (CheckDataUtil.checkisEmpty(building.getBuilding())) {
			return ResultMap.build(704, "输入楼栋名称");
		}
		if (CheckDataUtil.checkisEmpty(village.getVillagename())) {
			return ResultMap.build(703, "输入小区名称");
		}
		if (CheckDataUtil.checkisEmpty(village.getCode())) {
			return ResultMap.build(705, "检查区域");
		}
		if (CheckDataUtil.checkisEmpty(building.getPicture())) {
			return ResultMap.build(401, "插入图片");
		}
		if (CheckDataUtil.checkisEmpty(detaileaddress.getLatitude())) {
			return ResultMap.build(700, "检查定位");
		}
		if (CheckDataUtil.checkisEmpty(detaileaddress.getDetailes())) {
			return ResultMap.build(700, "输入详情地址");
		}
		
		Village village_search = this.checkvillageExists(village);
		if (CheckDataUtil.checkisEmpty(village_search)) {
			return ResultMap.build(706, "小区不存在");
		}
		String buildingcode = villageCustomerMapper.searchmaxbuildingcode(village.getCode());
		if (CheckDataUtil.checkNotEmpty(buildingcode)) {
			building.setBuildingcode(buildingcode);
		}else{
			building.setBuildingcode(village.getCode() + "00001");
		}
		
		building.setIdentity(village.getVillagename() + building.getBuilding());
		// 小区ID设置给楼栋
		building.setVillageid(village_search.getVillageid());
		Long builidng_id = checkbuildingExists(building);

		if (builidng_id > 0) {
			return ResultMap.build(707, "楼栋存在");
		}

		Long lot = checklongandlat(detaileaddress);
		if (lot > 0) {
			return ResultMap.build(700, "检查定位");
		}
		Long detailid = checkeDetailaAddressExists(detaileaddress);
		if (detailid < 0) {
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = detaileaddress.getDetailid();
		}
		Integer searchstate = systemstateMapper.selectByPrimaryKey(8).getDefaultstate();
		building.setState(searchstate);
		building.setUpdate_time(new Date());
		building.setDetailid(Long.valueOf(detailid));
		building.setXcxpicture("");
		buildingMapper.insertSelective(building);
		
		// 添加楼栋成功需要发送模板消息
		String sendData = building.getBuildingid() + "";
		SendMessUtil.sendData(jmsTemplate, builAdd, sendData);
		return ResultMap.build(200, "添加成功");
	}


	private Long checklongandlat(Detaileaddress detaileaddress) {
		DetaileaddressExample example = new DetaileaddressExample();
		DetaileaddressExample.Criteria criteria = example.createCriteria();
		criteria.andLongitudeEqualTo(detaileaddress.getLongitude());
		criteria.andLatitudeEqualTo(detaileaddress.getLatitude());
		List<Detaileaddress> lat = detaileaddressMapper.selectByExample(example);
		if (!lat.isEmpty() && lat.size() > 0) {
			return lat.get(0).getDetailid();
		}
		return -1L;
	}

	@SuppressWarnings("unused")
	private String getNamebyCode(Long code) {
		AreaExample example = new AreaExample();
		AreaExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Area> area = areaMapper.selectByExample(example);
		if (!area.isEmpty() && area.size() > 0) {
			return area.get(0).getName();
		}
		return null;
	}

	private Long checkbuildingExists(Building building) {
		BuildingExample example = new BuildingExample();
		BuildingExample.Criteria criteria = example.createCriteria();
		if (building.getBuildingid() != null) {
			criteria.andBuildingidNotEqualTo(building.getBuildingid());
		}
		criteria.andVillageidEqualTo(building.getVillageid());
		criteria.andBuildingEqualTo(building.getBuilding());
		List<Building> buildinglist = buildingMapper.selectByExample(example);
		if (!buildinglist.isEmpty() && buildinglist.size() > 0) {
			return buildinglist.get(0).getBuildingid();
		}
		return -1L;
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

	// 通过城市获取到code
	public Long getcodebycity(String city) {
		
		if (city != null && !"".equals(city)) {
			city = city.split("（")[0];
		}
		
		Long code = areaCustomerMapper.getcodebycity(city);
		return code;
	}

	/**找小区
	 * **/ 
	public List<VillageCustomer> searchCommlist(VillageeVo villageeVo) {
		AddressCustomer addressCustomer = villageeVo.getAddressCustomer() != null ? villageeVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();
		// 如果取出经纬度时候
		if (addressCustomer.getNearLatude() != null && !"".equals(addressCustomer.getNearLatude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude()));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
		} // 没有经纬度时候取用户的经纬度
		else {
			if (villageeVo.getUserid() != null) {
				User user = userMapper.selectByPrimaryKey(Long.valueOf(villageeVo.getUserid()));
				userCustomer.setLatitude(user.getLatitude());
				userCustomer.setLongitude(user.getLongitude());

			}
		}
		villageeVo.setUserCustomer(userCustomer);
		if (villageeVo.getUserid() == null) {
			villageeVo.setUserid(111L);
		}

		return villageCustomerMapper.searchCommlist(villageeVo);
	}

	/**
	 * 找小区
	 * **/ 
	public Integer searchCommlistCount(VillageeVo villageeVo) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.searchCommlistCount(villageeVo);
	}

	/**
	 * 小区详情
	 * @param villageid : 小区ID
	 * **/ 
	public VillageCustomer searchCommById(Long villageid) {

		return villageCustomerMapper.searchCommById(villageid);
	}

	/***查询小区下面的楼栋
	 *  @param villageid : 小区的ID
	 * **/ 
	public List<BuildingCustomer> searchBuildingbyVillageid(Long villageid ,PageQuery pagequery) {

		return villageCustomerMapper.searchBuildingbyVillageid(villageid , pagequery);
	}

	/*public List<BuildingCustomer> test(VillageeVo villageeVo) {
		// 设置查询条件
		SolrQuery solrquery = setbuildingquerysolr(villageeVo);
		//SearchResult result = solrdao.searchBuilindgList(solrquery);
		return result.getBuildinglist();
	}*/

	/**
	 * 楼栋列表
	 * **/
	public List<BuildingCustomer> searchBuilindgList(VillageeVo villageeVo) {
		AddressCustomer addressCustomer = villageeVo.getAddressCustomer() != null ? villageeVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();
		
	
		// 如果取出经纬度时候
		if (addressCustomer.getNearLatude() != null && !"".equals(addressCustomer.getNearLatude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude()));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
		} // 没有经纬度时候取用户的经纬度
		else {
			if (villageeVo.getUserid() != null) {
				User user = userMapper.selectByPrimaryKey(villageeVo.getUserid());
				userCustomer.setLatitude(user.getLatitude());
				userCustomer.setLongitude(user.getLongitude());
			}

		}
		// 先设置距离
		if (villageeVo.getJuli() != null && !"".equals(villageeVo.getJuli())) {
			if ("1公里".equals(villageeVo.getJuli())) {
				villageeVo.setJuli(1000 + "");
			}
			if ("3公里".equals(villageeVo.getJuli())) {
				villageeVo.setJuli(3000 + "");
			}
			if ("5公里".equals(villageeVo.getJuli())) {
				villageeVo.setJuli(5000 + "");
			}
		}
		villageeVo.setUserCustomer(userCustomer);
		
		if (villageeVo.getUserid() == null) {
			villageeVo.setUserid(111L);
		}
		return villageCustomerMapper.searchbuildlist(villageeVo);
	}

	// 设置楼栋的solr查询条件
	private SolrQuery setbuildingquerysolr(VillageeVo villageeVo) {
		// 创建一个查询对象
		SolrQuery solrQuery = new SolrQuery();
		StringBuilder params = new StringBuilder("*:" + "*");
		params.append(" AND fq:{!geofilt}");// 距离过滤函数
		params.append(" AND sort:geodist() asc");// 距离过滤函数
		params.append(" AND sfield:latlng");// 距离过滤函数
		params.append(" AND d:30000");// 距离过滤函数
		params.append(" AND f1:*,score");// 距离过滤函数
		// params.put("pt", "31.26552,121.460815");//当前经纬度
		// params.put("sfield", "latlng");//经纬度的字段
		// params.put("d", "2");//就近2公里的所有酒店
		// params.put("sort", "geodist() asc");//根据距离排序
		// params.put("fl", "*,score");
		// params.put("start", "0");//记录开始位置
		// params.put("rows", "10");//查询的行数
		solrQuery.setStart(0);
		solrQuery.setRows(8);
		solrQuery.setQuery(params.toString());
		return solrQuery;

	}

	/**
	 * 楼栋列表
	 * **/ 
	public int searchBuilindgListCount(VillageeVo villageeVo) {
		return villageCustomerMapper.searchbuildlistCount(villageeVo);
	}

	/**
	 * 楼栋详情
	 * @param :buildingid : 楼栋ID
	 * **/ 
	public BuildingCustomer searchbuildingbyid(Long buildingid , Long userid , Integer type) {
		BuildingCustomer buildingCustomer = null;
		
		// 校验基本数据
		if (CheckDataUtil.checkisEmpty(buildingid) || 
				CheckDataUtil.checkNotEqual(type, 5)) 
			{return buildingCustomer;}
		
		//先从缓存中取出楼栋详情
		try {
			String jsonData = jedisClient.get(RedisUtil.BUIL_FIRST_KEY+buildingid);
			// 如果查到数据了在转
			if (CheckDataUtil.checkNotEmpty(jsonData)) {
				buildingCustomer = JsonUtils.jsonToPojo(jsonData, BuildingCustomer.class);
				
				// 发送消息同步浏览量
				if (CheckDataUtil.checkNotEmpty(userid)) {
					String sendData = buildingid +"-" + userid + "-" + type;
					SendMessUtil.sendData(jmsTemplate, builSearch, sendData);
				}
				return buildingCustomer;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		buildingCustomer = villageCustomerMapper.searchbuildingbyid(buildingid);
		if (CheckDataUtil.checkisEmpty(buildingCustomer)) {return null;}
		
		// 吧楼栋存入缓存
		try {
			jedisClient.set(RedisUtil.BUIL_FIRST_KEY+buildingid, JsonUtils.objectToJson(buildingCustomer));
			jedisClient.expire(RedisUtil.BUIL_FIRST_KEY+buildingid, RedisUtil.BUIL_TIME_OUT);
			
			// 如果用户登录了需要发送消息同步浏览量
			if (CheckDataUtil.checkNotEmpty(userid)) {
				String sendData = buildingid +"-" + userid + "-" + type;
				SendMessUtil.sendData(jmsTemplate, builSearch, sendData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return buildingCustomer;
	}

	/**  楼栋下面房源的详情
	 * **/
	public List<HouseCustomer> searchhouseList(VillageeVo villageeVo) {
		return villageCustomerMapper.searchhouseList(villageeVo);
	}

	/**根据code查询小区基本信息
	 * @param code : 区域的code
	 * **/
	public List<Village> getvillagebycode(Long code) {
		VillageExample example = new VillageExample();
		VillageExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		return villageMapper.selectByExample(example);
	}

	/**
	 * 基本的小区详情
	 * @param villageid : 小区ID
	 * **/
	public Village simplevillagedetail(Long villageid) {

		return villageMapper.selectByPrimaryKey(villageid);
	}

	/**根据ID更新小区
	 * 
	 * **/ 
	public ResultMap villageupdatebyid(Village village) {
		if (village.getVillagename() == null || "".equals(village.getVillagename())) {
			return ResultMap.build(703, "输入小区名称");
		}
		Village village_search = checkvillageExists(village);
		if (village_search != null) {
			return ResultMap.build(702, "小区存在");
		}
		village.setUpdate_time(new Date());
		villageMapper.updateByPrimaryKeySelective(village);
		
		
		// 小区编辑发送模板消息
		String sendData = village.getVillageid()+"";
		SendMessUtil.sendData(jmsTemplate, villageAdd, sendData);
		return ResultMap.build(200, "更新成功");
	}

	/**获取基本 的builnglist
	 * @param village: 小区id
	 * @param userid : 用户ID
	 * **/ 
	public ResultMap getbuildinglistbyvid(Long villageid, Long userid) {
		User user = null;
		if (userid != null) {
			user = userMapper.selectByPrimaryKey(userid);
			user.setPassword("");
		}
		Map<String, Object> map = new HashMap<>();
		List<BuildingCustomer> buildings = villageCustomerMapper.getbuildinglistbyvid(villageid);
		hebinglatandlot(buildings);
		map.put("user", user);
		map.put("buildings", buildings);
		return ResultMap.IS_200(map);
	}
	
	// 合并经纬度
	private void hebinglatandlot(List<BuildingCustomer> buildings) {
		for (BuildingCustomer b : buildings) {
			if (b.getLatitude() != null && !"".equals(b.getLatitude())) {
				b.setLatandlog(b.getLongitude() + "," + b.getLatitude());
			}
		}
	}

	/**
	 * 根据楼栋ID 删除楼栋
	 * @param buildingid : 楼栋ID
	 * **/
	public void deletebuidilding(Long buildingid) {
		Building building = buildingMapper.selectByPrimaryKey(buildingid);

		deletedetail(building.getDetailid());
		buildingMapper.deleteByPrimaryKey(buildingid);

	}

	private void deletedetail(Long detailid) {
		detaileaddressMapper.deleteByPrimaryKey(detailid);
	}

	/**查询楼栋的基本信息
	 * @param buildingid : 楼栋ID
	 * 
	 * **/ 
	public BuildingCustomer getsimplebuilding(Long buildingid) {

		return villageCustomerMapper.getsimplebuilding(buildingid);
	}

	/**
	 * 更新楼栋
	 * @param building : 楼栋的基本信息
	 * @param detailes : 楼栋的详情地址
	 * **/
	public ResultMap updatebuilding(Building building,String detailes) {
		if (building.getBuildingid() == null) {
			return ResultMap.build(708, "选择楼栋");
		}
		Long id = checkbuildingExists(building);
		if (id > 0) {
			return ResultMap.build(707, "楼栋存在");
		}
		Building search = buildingMapper.selectByPrimaryKey(building.getBuildingid());
		buildingMapper.updateByPrimaryKeySelective(building);
		//需要把之前的品牌ID传过去
		// 这里编辑详情地址
		Detaileaddress updateaddress = new Detaileaddress();
		updateaddress.setDetailes(detailes);
		updateaddress.setDetailid(search.getDetailid());
		detaileaddressMapper.updateByPrimaryKeySelective(updateaddress);
		
		// 编辑成功以后需要发送消息同步楼栋的信息
		SendMessUtil.sendData(jmsTemplate, builUpdate, building.getBuildingid().toString());
		
		return ResultMap.build(200, "更新成功",search.getBrandid());
	}

	/**
	 * 根据区域code 统计楼栋发布
	 * @param code : 区域的code
	 * **/
	public List<UserCustomer> censusbuilding(String code) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.censusbuilding(code);
	}

	/**地图找楼栋
	 * **/ 
	public List<BuildingCustomer> fingbuildsmap(VillageeVo villageeVo) {
		Long userid = villageeVo.getUserid() == null ? 10000209 : villageeVo.getUserid();
		User user = userMapper.selectByPrimaryKey(userid);
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setLatitude(user.getLatitude());
		userCustomer.setLongitude(user.getLongitude());
		villageeVo.setUserCustomer(userCustomer);
		List<BuildingCustomer> buildingList = villageCustomerMapper.fingbuildsmap(villageeVo);
		hebingjinweidu(buildingList);
		return buildingList;
	}

	/**地图找街道
	 * @param city : 城市名
	 * @param code : 区域code
	 * **/ 
	public List<BuildingCustomer> fingtrandmap(String city, Long code) {
		if (code == null) {
			code = areaCustomerMapper.getcodebycity(city);
		}
		List<BuildingCustomer> buildingList = villageCustomerMapper.fingtrandmap(code);
		hebingjinweidu(buildingList);
		return buildingList;
	}

	/**地图找小区
	 * @param code : 区域code
	 * **/ 
	public List<BuildingCustomer> fingvillagemap(Long code) {
		// TODO Auto-generated method stub
		List<BuildingCustomer> buildingList = villageCustomerMapper.fingvillagemap(code);
		hebingjinweidu(buildingList);
		return buildingList;

	}

	// 合并经纬度
	private void hebingjinweidu(List<BuildingCustomer> buildingList) {
		for (BuildingCustomer building : buildingList) {
			building.setLatandlog(building.getLongitude() + "," + building.getLatitude());
		}
	}

	/**
	 * 一键维护地铁 . 设置小区下面的楼栋同一地铁
	 * **/
	public ResultMap updateallmetro(Building builgng) {
		if (builgng.getMetroid() == null) {
			return ResultMap.build(709,"选择地铁");
		}
		villageCustomerMapper.updateallmetro(builgng);
		return ResultMap.build(200,"更新成功");
	}

	/**
	 * 合并小区和楼栋
	 * **/
	public List<BuildingCustomer> megrobuildingandvillage() {
		// TODO Auto-generated method stub
		List<BuildingCustomer> list = villageCustomerMapper.getallbuilngandvillage();
		for (BuildingCustomer building : list) {
			building.setIdentity(building.getVillagename() + building.getBuilding());
			buildingMapper.updateByPrimaryKeySelective(building);
		}
		return list;
	}

	@Override
	public List<BuildingCustomer> megrobvillage_detailid(VillageeVo v) {
		Village village = new Village();
		List<BuildingCustomer> list = villageCustomerMapper.update_villagedetailid(null);
		for (BuildingCustomer building : list) {
			village.setDetailid(building.getDetailid());
			village.setVillageid(building.getVillageid());
			villageMapper.updateByPrimaryKeySelective(village);
		}
		return null;
	}

	/**
	 * 根据经纬度查询附近小区
	 * **/
	public List<BuildingCustomer> nearvillage(VillageeVo villageVo) {

		AddressCustomer addressCustomer = villageVo.getAddressCustomer() != null ? villageVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();

		if (addressCustomer.getNearLongitude() != null && !"".equals(addressCustomer.getNearLongitude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude() + ""));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
			villageVo.setUserCustomer(userCustomer);
			villageVo.setUserid(-1L);
			villageVo.setAddressCustomer(addressCustomer);
		} else if (villageVo.getUserid() != null) {
			User user = userMapper.selectByPrimaryKey(villageVo.getUserid());
			userCustomer.setLatitude(user.getLatitude());
			userCustomer.setLongitude(user.getLongitude());
			villageVo.setUserCustomer(userCustomer);
		}
		return villageCustomerMapper.update_villagedetailid(villageVo);

	}

	// 做索引库的目前没做。
	public ResultMap buildingtosolr() {
		try {
			List<BuildingCustomer> buildinglist = villageCustomerMapper.searchbuildlist(null);
			for (BuildingCustomer buildings : buildinglist) {
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", IDUtils.genItemId());
				document.addField("buildingid", buildings.getBuildingid());
				document.addField("metroname", buildings.getMetroname());
				document.addField("onepicture", buildings.getOnepicture());
				document.addField("avgprices", buildings.getAvgprices());
				document.addField("count", buildings.getCount());
				document.addField("villagename", buildings.getVillagename());
				document.addField("building", buildings.getBuilding());
				document.addField("finalstop", buildings.getFinalstop());
				document.addField("district", buildings.getDistrict());
				document.addField("avatar", buildings.getAvatar());
				document.addField("trading", buildings.getTrading());
				if (buildings.getLatitude() == null || "".equals(buildings.getLatitude())) {
					document.addField("latlng", "1,1");
				} else {
					document.addField("latlng", buildings.getLatitude() + "," + buildings.getLongitude());
				}

				document.addField("latitude", buildings.getLatitude());
				document.addField("longitude", buildings.getLongitude());
				// document.addField("metrocode", buildings.getMetrocode());
				//solrServer.add(document);
			}
			//solrServer.commit();
			return ResultMap.build(200, "楼栋列表导入索引库成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "楼栋列表导入索引库发生未知异常 ！");
		}

	}

	@Override
	public List<BuildingCustomer> fingbuildsmaps(AddressCustomer addressCustomer) {
		// TODO Auto-generated method stub
		addressCustomer.setMaxLatude(addressCustomer.getCurrentLatude() + 0.002);
		addressCustomer.setMinLatude(addressCustomer.getCurrentLatude() - 0.002);
		addressCustomer.setMaxLongitude(addressCustomer.getCurrentLongitude() + 0.002);
		addressCustomer.setMinLongitude(addressCustomer.getCurrentLongitude() - 0.002);
		return villageCustomerMapper.fingbuildsmaps(addressCustomer);
	}

	// 截掉楼里多余的图片 [内部方法]
	public ResultMap deletesearch() {
		List<Building> buildings = buildingMapper.selectByExample(null);
		for (Building building : buildings) {
			String[] str = building.getPicture().split(",");// 图片拆数组
			String path = "";
			for (int i = 0; i < str.length; i++) {
				path += str[i].split("[?]")[0] + ",";
			}
			path = path.substring(0, path.length() - 1);
			building.setPicture(path);
			buildingMapper.updateByPrimaryKeySelective(building);
		}
		return null;
	}

	// 截掉房源里图片[内部方法]
	public ResultMap deletehousepath() {
		List<House> houses = houseMapper.selectByExample(null);
		for (House house : houses) {
			if (house.getPicture() == null || "".equals(house.getPicture())) {
				house.setPicture("");
			}
			String[] str = house.getPicture().split(",");// 图片拆数组
			String path = "";
			for (int i = 0; i < str.length; i++) {
				path += str[i].split("[?]")[0] + ",";
			}
			path = path.substring(0, path.length() - 1);
			house.setPicture(path);
			houseMapper.updateByPrimaryKeySelective(house);
		}
		return null;
	}

	// 处理楼栋编号[内部方法]
	public ResultMap buildingnum() {
		// 第一步查出所有小区的CODE
		List<Village> villagecode = villageCustomerMapper.getvillagebuidingcode();
		Integer count= 0;
		for (Village vill : villagecode) {
			String buildingcode ="";
			Long sub = 0L;
			// 根据小区区域编号查询building
			List<Building> buildings = villageCustomerMapper.searchbuildingonvillagecode(vill);
			for (int i=0;i<buildings.size() ;i++) {
				if (i == 0) {
					buildingcode = vill.getCode() + "00001";
					sub = Long.valueOf(buildingcode);
				}
				sub = sub +1;
				count ++;
				buildings.get(i).setBuildingcode(sub+"");
				buildingMapper.updateByPrimaryKeySelective(buildings.get(i));
			}
		}

		return null;
	}

	// 处理楼栋不符合的电话号码[内部方法]
	public ResultMap buidingphone() {
		List<Building> buildings = buildingMapper.selectByExample(null);
		for (Building buil : buildings) {
			int i = buil.getLandphone().length();
			int j = buil.getLinkphone().length();
			if (i != 8 && i != 11) {
				buil.setLandphone("");
			}
			if (j != 8 && j != 11) {
				buil.setLinkphone("");
			}
			buildingMapper.updateByPrimaryKeySelective(buil);
		}
		return null;
	}

	// 生成楼栋专属二维码[内部方法]
	public ResultMap buildingxpx(Integer begin, Integer end) {

		List<Building> buildings = buildingMapper.selectByExample(null);
		for (Building buil : buildings) { // 14990-20000
				String xpx_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(buil.getBuildingid(), "buildingdetail");
				String xpx_gfz = XiaoChengXuCodeUtil.make_gzf_xcxqcode(buil.getBuildingid(), "buildingdetail");
				buil.setXcxpicture(xpx_qcc +"," + xpx_gfz);
				buildingMapper.updateByPrimaryKeySelective(buil);
			
		}
		return null;
	}

	/**
	 * 根据code 和searchname 模糊查询小区
	 * @param code : 区域code
	 * @param searchname : 搜索关键字
	 * **/
	public List<SearchModal> searchlikevillage(String code, String searchname) {
		List<SearchModal> searchvillage = villageCustomerMapper.searchlikevillage(code,searchname);
		List<SearchModal> searchbuilding = villageCustomerMapper.searchlikebuilding(code,searchname);
		List<SearchModal> searchbrand = villageCustomerMapper.searchlikebrand(searchname);
		searchbrand.addAll(searchvillage);
		searchbrand.addAll(searchbuilding);
 		return searchbrand;
	}

	//处理房源小程序二维码[内部方法]
	public ResultMap housexpx() {
		List<House> house = houseMapper.selectByExample(null);
		for (House hos : house) {
			String xpx_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(hos.getHouseid(), "housedetail");
			String xpx_gfz = XiaoChengXuCodeUtil.make_gzf_xcxqcode(hos.getHouseid(), "housedetail");
			hos.setXcxpicture(xpx_qcc + "," + xpx_gfz );
			houseMapper.updateByPrimaryKeySelective(hos);
		}
		return ResultMap.IS_200();
	}

	// 生成小区二维码[内部方法]
	public ResultMap villagexpx() {
		List<Village> villages = villageMapper.selectByExample(null);
		for (Village vill : villages) {
			String xpx_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(vill.getVillageid(), "villagedetail");
			String xpx_gzf = XiaoChengXuCodeUtil.make_gzf_xcxqcode(vill.getVillageid(), "villagedetail");
			vill.setXcxpicture(xpx_qcc + "," + xpx_gzf);
			villageMapper.updateByPrimaryKeySelective(vill);
		}
		return null;
	}

	



	/** 查询小区的类型 有公租房小区和普通小区
	 * ***/
	public List<Villagetype> searchvillagetype() {
		// TODO Auto-generated method stub
		return villagetypeMapper.selectByExample(null);
	}

	// [内部方法]
	public ResultMap buildvillageid() {
		// TODO Auto-generated method stub
		Integer count = 0;
		List<Village> village =  villageMapper.selectByExample(null);
		for (Village vill:village) {
			Long detailid = 1L;
		
			BuildingExample example = new BuildingExample();
			BuildingExample.Criteria criteria = example.createCriteria();
			criteria.andVillageidEqualTo(vill.getVillageid());
			List<Building> build = buildingMapper.selectByExample(example);
			if (!build.isEmpty() && build.size() >0) {
				detailid = build.get(0).getDetailid();
			}else {
				count ++ ;
			}
			
			if (detailid > 2L) {
				//vill.setDetailid(detailid);
				//villageMapper.updateByPrimaryKeySelective(vill);
			}
		}
		return null;
	}

	/**
	 * 查询公租房的申请条件
	 * @param citycode : 城市的code
	 * **/
	public Rental searchrentbycode(Long citycode) {
		// TODO Auto-generated method stub
		return rentalMapper.selectByPrimaryKey(citycode);
	}

	/**
	 * 查询公租房图片
	 * @param codeone : 二位数的城市code
	 * @param codetwo : 四位数的城市code
	 * **/
	public String searchrentpicture(String codeone, String codetwo) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.searchrentpicture(codeone ,codetwo );
	}

	/**
	 * 生成经纪人小程序的二维码[内部方法]
	 * **/
	public ResultMap brokerxpx() {
		List<Broker> brokers = brokerMapper.selectByExample(null);
		for (Broker vill : brokers) {
			String xpx_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(vill.getUserid(), "brokerdetail");
			String xpx_gzf = XiaoChengXuCodeUtil.make_gzf_xcxqcode(vill.getUserid(), "brokerdetail");
			vill.setXcxpicture(xpx_qcc + "," + xpx_gzf);
			brokerMapper.updateByPrimaryKeySelective(vill);
		}
		return null;
	}

	@Override
	public int searchBuildingbyVillageidCount(Long villageid) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.searchBuildingbyVillageidCount( villageid);
	}

	@Override
	public List<BuildingCustomer> test(VillageeVo villageeVo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMap addbuildngtosolr(Long buildingid ,PageQuery pagequery) {
		List<BuildingCustomer> allBuilding = villageCustomerMapper.addbuildngtosolr(buildingid,pagequery);
		if (CheckDataUtil.checkisEmpty(allBuilding)) 
			{return ResultMap.build(400, "没有更新数据了!!");}
		List<HouseCustomer> PropertyrightList = housertargService.getproperListBybuilid(buildingid);
		List<HouseCustomer> apartmentNameList = housertargService.getapartmentnameListBybuilid(buildingid);
		//装修类型
		List<HouseCustomer> redecoratList = housertargService.getredecoraListBybuilid(buildingid);
		// 查询支付方式
		List<HouseCustomer> paystyleList = housertargService.getpayListBybuilid(buildingid);
		List<HouseCustomer> pricesList = housertargService.getCountAndpricesBybuilid(buildingid);
		// 先吧第一个集合拆
		for (BuildingCustomer buil : allBuilding) {
			
			Double argprices = 10.0;
			Integer count = 0;
			for (HouseCustomer house: pricesList) {
				if (buil.getBuildingid().longValue() == house.getBuildingid()) {
					count = house.getFloor();
					argprices = Double.valueOf(house.getPrices() );
				} 
			}
			buil.setAvgprices(argprices);
			buil.setCount(count);
			
			//每次进来定义故意空
			String appendproperty = "" ;
			for (HouseCustomer house:PropertyrightList) {
				if (buil.getBuildingid().longValue() == house.getBuildingid()) {
					appendproperty+=house.getHousetag_id()+",";
				}
			}
			appendproperty = CheckDataUtil.DeleteExist(appendproperty);
			buil.setPropertyright(appendproperty);
			String appendpaystye ="";
			for (HouseCustomer house:paystyleList) {
				if (buil.getBuildingid().longValue() == house.getBuildingid()) {
					appendpaystye+=house.getPaystyle()+",";
				}
			}
			appendpaystye = CheckDataUtil.DeleteExist(appendpaystye);
			buil.setPaystyle(appendpaystye);
			
			String appendredecorat="";
			for (HouseCustomer house : redecoratList) {
				if (buil.getBuildingid().longValue() == house.getBuildingid()) {
					appendredecorat+=house.getRedecorat()+",";
				}
			}
			appendredecorat = CheckDataUtil.DeleteExist(appendredecorat);
			buil.setRedecorat(appendredecorat);
			
			String appendAparmentName="";
			for (HouseCustomer house : apartmentNameList) {
				if (buil.getBuildingid().longValue() == house.getBuildingid()) {
					appendAparmentName+=house.getApartmentname()+",";
				}
			}
		    appendAparmentName = CheckDataUtil.DeleteExist(appendAparmentName);
		    buil.setApartmentname(appendAparmentName);
		}
		// 先清空对应的数据
		ResultMap resultMap = builSolrDao.deleteBuildingFromSolr(pagequery);
		if (resultMap.getCode() == 200){
			return  builSolrDao.AllBuildingToSolr(allBuilding);
		}
		return resultMap;
	}

	@Override
	public SearchResult searchBuilindgList(Long likecode, String juli,BuildingCustomer buildingCustomer, ApartmentCustomer apartmentCustomer,
			HouseCustomer houseCustomer, HousetagCustomer housetagCustomer, VillageCustomer villageCustomer,
			Metro metro,AddressCustomer addressCustomer,PageQuery pagequery) {
		
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		//设置距离的查询半径
		SolrPageUtil.juliquery(query,juli, addressCustomer);
		//设置区域的likecode
		SolrPageUtil.likecodequery(likecode, query);
		//设置房源的查询
		SolrPageUtil.houseQuery(houseCustomer, query);
		//设置户型的
		SolrPageUtil.apartmentQuery(apartmentCustomer, query);
		// 设置小区的查询
		SolrPageUtil.villageQuery(villageCustomer,query);
		//设置标签
		SolrPageUtil.housetargQuery(housetagCustomer ,query);
		//设置地铁的查询
		SolrPageUtil.metroquery(metro, query);
		// 封装楼栋的查询条件
		SolrPageUtil.buildingquery(buildingCustomer,query);
		
		//设置分页参数
		SolrPageUtil.setStartAndEnd(pagequery, query);
		query.addSort("update_time",ORDER.desc);//按照从近到远排序
		return builSolrDao.searchBuilindgList(query);
	}

	@Override
	public List<UserCustomer> censusvillage(String code) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.censusvillage(code);
	}

	@Override
	public List<BuildingCustomer> buildingUpload(Long code, String searchwhere) {
		// TODO Auto-generated method stub
		return villageCustomerMapper.buildingUpload(code , searchwhere);
	}

	@Override
	public ResultMap addvillagetosolr(PageQuery pagequery) {
		//根据条件查询导入的小区
		List<VillageCustomer> villageList = villageCustomerMapper.addvillagetosolr(pagequery);
		if (CheckDataUtil.checkisEmpty(villageList)) 
			return ResultMap.build(400, "没有数据");
		// 查询地铁信息
		List<MetroCustomer> metroList = villageCustomerMapper.addvillagetosolrMetro(null);
		for (VillageCustomer village : villageList) {
			for (MetroCustomer metro : metroList) {
				if (village.getVillageid() - metro.getVillageid() == 0 ) {
					// 判断是否包含了地铁名称
					if (!village.getMetroname().contains(metro.getName())) {
						village.setMetroname(village.getMetroname() +"-" + metro.getName());
					}
					// 判断是否包含了站点名称
					if (!village.getFinalstop().contains(metro.getFinalstop())) {
						village.setFinalstop(village.getFinalstop() +"-" + metro.getFinalstop());
					}
					if (!village.getMetroids().contains(metro.getMetroid()+"")) {
						village.setMetroids(village.getMetroids() +"-" +metro.getMetroid());
					}
					village.setCitycode(metro.getCode()+"");
				}
			}
		}
		System.out.println("================================================");
		villageSolrDao.addvillagetosolr(villageList);
		return ResultMap.IS_200(villageList);
	}

	@Override
	public SearchResult searchCommlist(VillageCustomer villageCustomer, Metro metro, Long likecode,
			PageQuery pagequery,AddressCustomer addressCustomer) {
		String searchWord = villageCustomer.getHoustatus() ;
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		if (CheckDataUtil.checkNotEmpty(metro.getMetroid())) {
			String metroids = "-"+metro.getMetroid() ;
			villageCustomer.setMetroids(metroids);
			metro.setMetroid(null);
		}
		//设置距离的查询半径
		SolrPageUtil.juliquery(query,"", addressCustomer);
		//设置区域的likecode
		SolrPageUtil.likecodequery(likecode, query);
		// 设置小区的查询
		SolrPageUtil.villageQuery_all(villageCustomer,query);
		//设置地铁的查询
		SolrPageUtil.metroquery(metro, query);
		//设置分页参数
		SolrPageUtil.setStartAndEnd(pagequery, query);
		query.addSort("update_time",ORDER.desc);//按照从近到远排序
		return villageSolrDao.searchVillageList(query ,searchWord);
	}

	/**一个房子导入索引库**/
	public ResultMap onevillagetosolr(long villageid) {
		// TODO Auto-generated method stub
		VillageCustomer village = villageCustomerMapper.onevillagetosolr(villageid);
		// 查询地铁信息
		List<MetroCustomer> metroList = villageCustomerMapper.addvillagetosolrMetro(villageid);
		if (CheckDataUtil.checkNotEmpty(metroList)) {
			for (MetroCustomer metro : metroList) {
				if (village.getVillageid() - metro.getVillageid() == 0 ) {
					// 判断是否包含了地铁名称
					if (!village.getMetroname().contains(metro.getName())) {
						village.setMetroname(village.getMetroname() +"-" + metro.getName());
					}
					// 判断是否包含了站点名称
					if (!village.getFinalstop().contains(metro.getFinalstop())) {
						village.setFinalstop(village.getFinalstop() +"-" + metro.getFinalstop());
					}
					if (!village.getMetroids().contains(metro.getMetroid()+"")) {
						village.setMetroids(village.getMetroids() +"-" +metro.getMetroid());
					}
					village.setCitycode(metro.getCode()+"");
				}
			}
		}
		villageSolrDao.onevillagetosolr(village);
		return ResultMap.IS_200();
	}

	

	

}
