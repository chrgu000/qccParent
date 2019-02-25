package cn.com.qcc.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.ApartmentMapper;
import cn.com.qcc.mapper.BargainMapper;
import cn.com.qcc.mapper.BrandMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.HousetagMapper;
import cn.com.qcc.mapper.PreparatoryMapper;
import cn.com.qcc.mapper.PriceMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mapper.TribeMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.mess.util.SolrPageUtil;
import cn.com.qcc.mymapper.AddressCustomerMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.TribeCustomerMapper;
import cn.com.qcc.pojo.Apartment;
import cn.com.qcc.pojo.ApartmentExample;
import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.BuildingExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.HouseExample;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.HouseorderExample;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.HousetagExample;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.Preparatory;
import cn.com.qcc.pojo.PreparatoryExample;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.pojo.PriceExample;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.VillageExample;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ApartmentCustomer;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.BrandCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.FurnitureCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseOrderCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.HousetagCustomer;
import cn.com.qcc.queryvo.PreparatoryCustomer;
import cn.com.qcc.queryvo.PriceCustomer;
import cn.com.qcc.queryvo.PropertyCustomer;
import cn.com.qcc.queryvo.RentmodalCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.solrdao.HouseSolrDao;
import cn.com.qcc.service.solrdao.TribeSolrDao;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired private  HouseSolrDao houseSolrDao;
	@Autowired private  SystemstateMapper systemstateMapper;
	@Autowired private  HouseCustomerMapper houseCustomerMapper;
	@Autowired private  UserMapper userMapper;
	@Autowired private  AddressCustomerMapper addressCustomerMapper;
	@Autowired private  PriceMapper priceMapper;
	@Autowired private  VillageMapper villageMapper;
	@Autowired private  HouseMapper houseMapper;
	@Autowired private  ApartmentMapper apartmentMapper;
	@Autowired private  BuildingMapper buildingMapper;
	@Autowired private  BrandMapper brandMapper;
	@Autowired private  HousetagMapper housetagMapper;
	@Autowired private  HouseorderMapper houseorderMapper;
	@Autowired private  HttpServletRequest request;
	@Autowired private  PreparatoryMapper preparatoryMapper;
	@Resource  Destination houseAddOrUpdate;
	@Resource  Destination houseAddBatch;
	@Resource  Destination updateHouseByBuildingid;
	@Resource  Destination updateHousestates;
	@Resource  Destination houseSaleAddOrUpdate;
	@Resource  Destination houseSearch;
	@Autowired JmsTemplate jmsTemplate;
	@Autowired private JedisClient jedisClient;
	@Autowired TribeSolrDao tribeSolrDao;
	@Autowired TribeCustomerMapper tribeCustomerMapper;
	@Autowired TribeMapper tribeMapper;
	@Autowired BargainMapper bargainMapper;

	/**
	 * 查询房态图
	 * **/
	public List<HouseCustomer> roompattern(HouseVo houseVo) {
		List<HouseCustomer> houseList = houseCustomerMapper.roompattern(houseVo);
		if (houseList.size() == 0) {
			return houseList;
		}

		for (int i = 0; i < houseList.size(); i++) {// 从第一个数开始，到最后一个数-1次循环
			for (int j = houseList.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long buil1 = houseList.get(i).getBuildingid();
				Long buil2 = houseList.get(j).getBuildingid();
				Long buil_end = buil1 - buil2;
				Integer folr1 = houseList.get(i).getFloor();
				Integer folr2 = houseList.get(j).getFloor();
				Integer folr_end = folr1 - folr2;
				if (buil_end == 0 && folr_end == 0) {
					houseList.get(j).setFloor(-1);
				}
				if (buil_end == 0) {
					houseList.get(j).setTrading("");
				}
			}

			if (houseList.get(i).getNeedpaytime() != null) {
				int needoutday = DateUtil.daysBetween(new Date(), houseList.get(i).getNeedpaytime());
				houseList.get(i).setNeedoutday(needoutday);
			}
			if (houseList.get(i).getCententtime() != null) {
				int centenoutday = DateUtil.daysBetween(new Date(), houseList.get(i).getCententtime());
				houseList.get(i).setCentenoutday(centenoutday);
			}
			if ("1".equals(houseList.get(i).getHousestatus())) {
				if (houseList.get(i).getUpdate_time() != null) {
					int notcentday = DateUtil.daysBetween(houseList.get(i).getUpdate_time(), new Date());
					houseList.get(i).setNotcentday(notcentday);
				}
			}
		}
		return houseList;
	}
	public int roompatternCount(HouseVo houseVo) {
		int count = houseCustomerMapper.roompatternCount(houseVo);
		return count;
	}
	
	
	
	/**
	 * 查询支付方式
	 */
	public List<Paymodal> paymodals() {
		return houseCustomerMapper.paymodals();
	}

	
	/**
	 * 查询收租日分组
	 */
	public List<RentmodalCustomer> collectrents() {
		// 获取收租日的分组
		List<RentmodalCustomer> rents = houseCustomerMapper.collectrents();
		// 这里获取收租日的子节点
		for (RentmodalCustomer rent : rents) {
			List<RentmodalCustomer> rentsong = 
					houseCustomerMapper.collectrentsson(Integer.parseInt(rent.getValue()));
			rent.setChildren(rentsong);
		}
		return rents;
	}

	
	/**
	 * 查询其他价格
	 */
	public List<RentmodalCustomer> otherprices() {
		List<RentmodalCustomer> otherprices = houseCustomerMapper.otherprices();
		for (RentmodalCustomer other : otherprices) {
			List<RentmodalCustomer> rentsong = null;
			// 说明这是查询押金的
			String order = "!= 6";
			if ("2".equals(other.getValue())) {
				// 这里封装查询
				order = "= 6";
			}
			rentsong = houseCustomerMapper.otherpricesson(order);
			other.setChildren(rentsong);
		}
		return otherprices;
	}

	/**
	 * 查询更多总分类
	 */
	public List<FurnitureCustomer> furniturelist() {
		return houseCustomerMapper.furniturelist();
	}

	
	/**
	 * 查询更多小分类
	 */
	public List<FurnitureCustomer> furnituredetaillist(Long furnitureid) {
		List<FurnitureCustomer> list = houseCustomerMapper.furnituredetaillist(furnitureid);
		// 去除多余的标题
		for (int i = 0; i < list.size() - 1; i++) {// 从第一个数开始，到最后一个数-1次循环
			for (int j = list.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long furid1 = list.get(i).getFatherid();
				Long furid2 = list.get(j).getFatherid();
				Long fruid_end = furid1 - furid2;
				if (fruid_end == 0) {
					list.get(j).setFname("");
				}
			}
		}
		return list;
	}

	/**
	 * 催租表查询
	 **/
	public List<HouseCustomer> needpaycentlist(HouseCustomer houseCustomer) {
		// 去除多余的标题先查出同天下面的楼栋相同为分组
		List<HouseCustomer> list = houseCustomerMapper.needpaycentlist(houseCustomer);
		List<HouseCustomer> grouplistbuilding = houseCustomerMapper.grouptimeandbuilding(houseCustomer);
		for (HouseCustomer house : grouplistbuilding) {
			List<HouseCustomer> SON = house.getSonlist();
			if (SON == null) {
				SON = new ArrayList<>();
			}
			for (HouseCustomer ho : list) {
				if (house.getNeedpaytime().getTime() == ho.getNeedpaytime().getTime()
						&& house.getBuildingid() == ho.getBuildingid()) {
					if (!SON.contains(ho)) {
						SON.add(ho);
					}

				}
			}
			house.setSonlist(SON);
		}
		// 去除多余的父名称
		for (int i = 0; i < grouplistbuilding.size() - 1; i++) {
			for (int j = grouplistbuilding.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Date d1 = grouplistbuilding.get(i).getNeedpaytime();
				Date d2 = grouplistbuilding.get(j).getNeedpaytime();
				if (d1.getTime() == d2.getTime()) {
					grouplistbuilding.get(j).setFalg(false);
					if (grouplistbuilding.get(i).getBuildingid() == grouplistbuilding.get(j).getBuildingid()) {
						grouplistbuilding.get(j).setSonlist(null);
						grouplistbuilding.get(j).setBuilding("");
					}
				}
			}
		}

		return grouplistbuilding;
	}
	
	

	/**
	 * 根据房东ID 查询出对应的区域分组
	 **/
	public List<BuildingCustomer> getlandareaname(BuildingCustomer buildingCustomer) {

		List<BuildingCustomer> landareaname = houseCustomerMapper.getlandareaname(buildingCustomer);

		return landareaname;
	}

	
	/**
	 * 根据房东ID查询房东房源对应的楼栋
	 */
	public List<BuildingCustomer> getlandbuildingname(BuildingCustomer buildingCustomer) {
		List<BuildingCustomer> buils = houseCustomerMapper.getlandbuildingname(buildingCustomer);
		String strbuil = "";
		for (BuildingCustomer buil : buils) {
			strbuil = buil.getDetailes();
			strbuil = strbuil.substring(strbuil.indexOf("市") + 1, strbuil.length());
			buil.setDetailes(strbuil);
		}
		return buils;
	}

	/**
	 * 根据楼栋ID 和userid 查询房东下面的房源
	 * @param userid : 当前用户【房东ID】
	 * @param buildingid : 楼栋的ID
	 **/
	public List<HouseCustomer> housebybuildingid(HouseCustomer houseCustomer) {
		return houseCustomerMapper.housebybuildingid(houseCustomer);
	}

	/**
	 * 根据房源ID 和userid 发起退房操作
	 * @param houseid : 当前房源ID
	 **/
	public HouseCustomer roomoutsearch(Long houseid) {

		// 第一步，查询当前租约已经交过的所有押金
		Double sumcentprices = houseCustomerMapper.centpricespay(houseid);

		// 第二步 ，查询本月或者之前 是否有没有交 的费用总和
		HouseCustomer search = new HouseCustomer();
		search.setHouseid(houseid);
		search.setCurrentday(new Date());
		Double notpayprices = houseCustomerMapper.centpricesnotpay(search);
		if (notpayprices == null) {
			notpayprices = 0.0D;
		}
		// 这里查询大于本期的已经支付的金额
		Double duoshou = houseCustomerMapper.centpricespayout(search);

		// 第三步，计算最近一次房租的情况
		HouseCustomer houseCustomer = houseCustomerMapper.centpricesnow(search);
		if (houseCustomer == null) {
			houseCustomer = new HouseCustomer();
		}
		houseCustomer.setMarginprices(sumcentprices + "");
		houseCustomer.setOtherpricesnotpay(notpayprices + ""); // 其他费用没有交的
		houseCustomer.setDuoshou(duoshou);
		// 计算超出天数
		Double payprices = 0.0D;

		if (houseCustomer.getCreate_time() != null) {
			int totalday = DateUtil.daysBetween(houseCustomer.getCreate_time(), houseCustomer.getUpdate_time());
			int intday = DateUtil.daysBetween(houseCustomer.getCreate_time(), new Date());
			if (houseCustomer.getPayexstate() != null && houseCustomer.getPayexstate() == 1) {
				payprices = sumcentprices - notpayprices
						- Double.valueOf(houseCustomer.getCentprices()) * intday / totalday;
				;
			}
			if (houseCustomer.getPayexstate() != null && houseCustomer.getPayexstate() == 2) {
				payprices = sumcentprices - notpayprices;
			}
		}
		houseCustomer.setTotalprices(payprices + duoshou);
		return houseCustomer;
	}

	
	
	/**
	 * 进行退房操作
	 * @param houseid  : houseid
	 **/
	public ResultMap roomout(Long houseid) {
		if (houseid == null) {
			return ResultMap.build(300, "选择房子");
		}
		// 第一步当前租约改为历史租约
		houseCustomerMapper.usercentbehistory(houseid);
		// 第二步设置 房子账单为历史账单
		houseCustomerMapper.housepaybehistory(houseid);
		// 设置房子为可以租状态
		House house = new House();
		house.setHouseid(houseid);
		house.setHousestatus("1");
		house.setUpdate_time(new Date());
		house.setCreate_time(new Date());
		houseMapper.updateByPrimaryKeySelective(house);
		return ResultMap.build(200, "操作成功");
	}

	/**
	 * 发布房源信息 出租
	 * 
	 * @param house_number
	 *            : 房号
	 * @param userid
	 *            : 发布人ID
	 * @param housetitle
	 *            : 标题
	 * @param code
	 *            : 区域code
	 * @param villagename
	 *            : 小区名称
	 * @param villageid
	 *            : 小区ID
	 * @param building
	 *            : 楼栋名称
	 * @param apartmentname
	 *            : 户型
	 * @param area
	 *            : 面积
	 * @param redecorat
	 *            : 装修类型
	 * @param paystyle
	 *            : 支付方式
	 * @param livestyle
	 *            : 出租方式
	 * @param propertyname
	 *            : 房屋类型
	 * @param houstatus
	 *            : 1 出租
	 * @param housetag_id
	 *            : 标签ID
	 * @param landlord
	 *            : 房东
	 * @param landlordtel
	 *            : 房东电话
	 * @param contacts
	 *            : 联系人
	 * @param contactstel
	 *            : 联系人电话
	 * @param user_identity
	 *            : 房主/其他
	 * @param description
	 *            : 描述
	 * @param filePath
	 *            : 房源图片
	 * @param brand
	 *            : 品牌
	 * @param sex
	 *            :性别
	 * @param floor
	 *            : 楼层
	 * @param prices
	 *            : 价格
	 * @param tribeid
	 *            : 部落ID
	 */
	public ResultMap publishouse(Building building, Price price, House house, Village village, Long userid,
			HousetagCustomer housetag, String propertyname, String apartmentname, String brand,String preparatory) {
		// 检查小区
		ResultMap check_village = checkvillage(village);
		if (CheckDataUtil.checkNotEqual(check_village.getCode(), 200)) {return check_village;}
		Long villageid = (Long)check_village.getObj();
		// 检查楼栋
		ResultMap check_building = checkBuilding(villageid , building);
		if (CheckDataUtil.checkNotEqual(check_building.getCode(),200)) {return check_building;}
		building = (Building)check_building.getObj();
		house.setBuildingid(building.getBuildingid());
		// 前台参数house的非空校验
		ResultMap result_house = checkhouse(house);
		if (CheckDataUtil.checkisEmpty(userid)) { return ResultMap.build(400,"先登录");}
		if (CheckDataUtil.checkNotEqual(result_house.getCode(), 200L)) { return result_house; }
		// 判断房源是否是房源设置对应的参数
		checkpropertynameData(house , housetag ,propertyname);
		//判断户型是否存在设置参数
		checkapartmentnameData(house,apartmentname);
		//校验价格数据
		ResultMap price_result = checkpriceData(house,price);
		if (CheckDataUtil.checkNotEqual(price_result.getCode(), 200)) {return price_result;}
		//校验品牌数据
		checbrandData(userid ,building.getBuildingid() ,house);
		// 这里是编辑操作
		String sendData = "";
		String tribeid = "undefined";
		if (CheckDataUtil.checkNotEmpty(housetag.getTribeid())) {
			tribeid = housetag.getTribeid();
		}
		String message = "";
		if (CheckDataUtil.checkNotEmpty(house.getHouseid())) {
			house.setUpdate_time(new Date());
			houseMapper.updateByPrimaryKeySelective(house);
			sendData = house.getHouseid()+"-update-"+tribeid+"-"+userid;
			message = "编辑成功";
		} else {
			// 插入之前设置房间号码
			String housenum = IDUtils.appendzero(house.getHouse_number() + "", 4);
			String housecode = building.getBuildingcode() + housenum;
			house.setHousecode(housecode);
			house.setCreate_time(new Date());
			house.setUpdate_time(new Date());
			if (CheckDataUtil.checkisEmpty(house.getPaystyle())) {
				// 前台没有传值给默认值
				house.setPaystyle("");
			}
			// 房屋的状态 冻结0 未租1 已租2 默认1 3是移除 5待审核 4没有卖
			Integer searchstate = systemstateMapper.selectByPrimaryKey(4).getDefaultstate();
			house.setHousestatus(searchstate + "");
			// 1为租的 2为卖的
			house.setHoustatus("1");
			// 设置用户ID
			house.setUser_id(Long.valueOf(userid));
			house.setXcxpicture("");
			houseMapper.insert(house);
			//发送消息
			sendData = house.getHouseid()+"-insert-"+tribeid+"-"+userid;
			message = "发布成功";
		}
		SendMessUtil.sendData(jmsTemplate, houseAddOrUpdate, sendData);
		//设置佣金规则
		preparatoryhouse( preparatory , house.getHouseid() );
		
		return ResultMap.build(200, message);
	}
	private void checbrandData(Long userid, Long buildingid,House house) {
		Brand search_brand = getbranddetail(userid + "", buildingid);
		if (CheckDataUtil.checkNotEmpty(house.getBrandid())) {
			if (house.getBrandid() < 0) {
				house.setBrandid(null);
			}
		}
		// 如果楼栋有品牌，
		if (CheckDataUtil.checkNotEmpty(search_brand)) {
			house.setBrandid(null);
		}
		
	}
	private ResultMap checkpriceData(House house, Price price) {
		if (CheckDataUtil.checkNotEmpty(price)) {
			
			if (CheckDataUtil.checkisEmpty(price.getPricetype()) || 
					CheckDataUtil.checkisEmpty(price.getPrices())){
				return ResultMap.build(400, "error");
			}
			Long is_id_existprice = checkepriceExists(price);
			if (is_id_existprice > 0) {
				house.setPrice_id(is_id_existprice);
			} else {
				price.setCreate_time(new Date());
				price.setUpdate_time(new Date());
				priceMapper.insert(price);
				// 返回插入的主键
				Long priceid = price.getPriceid();
				if (house != null && !"".equals(house)) {
					house.setPrice_id(priceid);
				}
			}
		}
		return ResultMap.IS_200();
		
	}
	private void checkapartmentnameData(House house, String apartmentname) {
		// 户型类别的非空校验
		if (CheckDataUtil.checkNotEmpty(apartmentname)) {
			Integer is_appid_exist = checkeApartmentExists(apartmentname);
			if (is_appid_exist > 0) {
				house.setApartment_id(is_appid_exist);
			} else {
				Apartment apartment = new Apartment();
				apartment.setApartmentname(apartmentname);
				apartment.setCreate_time(new Date());
				apartment.setUpdate_time(new Date());
				// 修改mapper文件可以获得主键
				apartmentMapper.insert(apartment);
				Integer apartmentid = apartment.getApartmentid();
				house.setApartment_id(apartmentid);
			}
		} else {
			// 房子几室几厅如果没有值数据库默认存1
			house.setApartment_id(1);
		}

		
	}
	private void  checkpropertynameData(House house, HousetagCustomer housetag, String propertyname) {
		
		// 如果是房源需要加入房子独立设置的关联
		if (CheckDataUtil.checkisEqual(propertyname, "房源")) {
			// 获取性别的ID
			String housetag_sexId = getHousetagByType(housetag.getSex());
			// 获取整租还是出租还是合租的ID
			String housetag_lifeID = getHousetagByType(housetag.getLivestyle());
			// 其他类型的ID 组合
			String housetagid = housetag.getHousetag_id();
			// 拼接房屋设施设备的最终标签
			String idString = housetag_sexId + "," + housetag_lifeID + "," + housetagid;
			// 设置和house的关联
			house.setHousetag_id(idString);
		}
		if (CheckDataUtil.checkNotEqual(propertyname, "房源")) {
			String housetagid = housetag.getHousetag_id();
			String idString = housetagid;
			house.setHousetag_id(idString);
		}
		
		
	}
	//校验楼栋
	private ResultMap checkBuilding(Long villageid, Building building) {
		// 在校验楼栋是否存在
		if (CheckDataUtil.checkNotEmpty(building)) {
			// 首先对Village最小一级的区域地址进行查询有的话直接和和Address进行关联。
			if (CheckDataUtil.checkisEmpty(building.getBuilding())) {
				return ResultMap.build(400, "输入楼栋");
			}
			building.setVillageid(villageid);
			building = checkebuildingExists(building);
			if (CheckDataUtil.checkNotEmpty(building)) {
				//house.setBuildingid(building.getBuildingid());
				return ResultMap.IS_200(building);
			} else {
				return ResultMap.build(400, "楼栋不存在!");
			}
		} else {
			return ResultMap.build(400, "楼栋地址不全!");
		}
	}
	//校验小区
	private ResultMap checkvillage(Village village) {
		// 先校验小区是否存在
		if (CheckDataUtil.checkNotEmpty(village)) {
			if (CheckDataUtil.checkisEmpty(village.getCode())) {
				return ResultMap.build(400, "请检查你输入的地址");
			}
			if (CheckDataUtil.checkisEmpty(village.getVillagename())) {
				return ResultMap.build(400, "请检查你输入的地址");
			}
			// 首先对building最小一级的区域地址进行查询有的话直接和和village进行关联。
			Long villageid_exist = checkvillageExists(village);
			if (villageid_exist > 0) {
				// 如果他的上级地址有值的话，需要把值设置上去形成关联关系
				return ResultMap.IS_200(villageid_exist);
			} else {
				return ResultMap.build(400, "小区不存在!");
			}
		} else {
			return ResultMap.build(400, "小区地址不全!");
		}
	}
	private Brand getbranddetail(String userid, Long buildingid) {

		// 先判断楼栋是否有品牌
		Building building = buildingMapper.selectByPrimaryKey(buildingid);
		if (building.getBrandid() != null) {
			Brand search = brandMapper.selectByPrimaryKey(building.getBrandid());
			// 说明楼栋有品牌，房源不需要绑定品牌
			if (search != null) {
				return search;
			}
		}

		return null;
	}
	/**
	 * 重复房号201
	 * 400 其他数据不全
	 * 200正常 。如果需要房源根据200判断如果不需要房号根据400判断
	 * 
	 * **/
	private ResultMap checkhouse(House house) {
		if (CheckDataUtil.checkisEmpty(house.getHouse_number())) {
			return ResultMap.build(201, "输入房号");
		}
		if (CheckDataUtil.checkisEqual(house.getBrandid(), -1L)) {
			house.setBrandid(null);
		}
		if (CheckDataUtil.checkisEmpty(house.getSchedule())) {
			house.setSchedule(2);
		}
		if (CheckDataUtil.checkisEmpty(house)) {
			return ResultMap.build(400, "房源数据不能为空");
		}
		if (CheckDataUtil.checkisEmpty(house.getPicture())) {
			return ResultMap.build(400, "未知图片");
		}
		if (CheckDataUtil.checkisEmpty(house.getRedecorat())) {
			return ResultMap.build(400, "选择装修类型");
		}
		if (CheckDataUtil.checkisEmpty(house.getArea())) {
			return ResultMap.build(400, "请输入面积");
		}
		if (CheckDataUtil.checkisEmpty(house.getHousetitle())) {
			house.setHousetitle("");
		}
		if (CheckDataUtil.checkisEmpty(house.getUser_identity())) {
			return ResultMap.build(400, "参数不全");
		}
		if (CheckDataUtil.checkisEmpty(house.getContacts())) {
			house.setContacts("");
		}
		if (CheckDataUtil.checkisEmpty(house.getContactstel())) {
			house.setContactstel("");
		}
		if(CheckDataUtil.checkisEmpty(house.getLandlord())) {
			house.setLandlord("");
		}
		if (CheckDataUtil.checkisEmpty(house.getLandlordtel())){
			house.setLandlordtel("");
		}
		if (CheckDataUtil.checkisEmpty(house.getAges())) {
			house.setAges("");
		}
		if (CheckDataUtil.checkisEmpty(house.getTurn())) {
			house.setTurn("");
		}
		if (CheckDataUtil.checkisEmpty(house.getUnderground())) {
			house.setUnderground("");
		}
		if (CheckDataUtil.checkisEmpty(house.getDescription())) {
			house.setDescription("");
		}
		/*if (CheckDataUtil.checkisEmpty(house.getHousetag_id())) {
			return ResultMap.build(400, "输入标签");
		}*/
		// 这里校验房间号是否重复
		House chekchouse = checkhousenum(house);
		if (CheckDataUtil.checkNotEmpty(chekchouse)) {
			return ResultMap.build(201, "房号重复");
		}
		return ResultMap.IS_200();
	}

	/**
	 * 发布房源信息 出售
	 * 
	 * @param house_number
	 *            : 房号
	 * @param userid
	 *            : 发布人ID
	 * @param housetitle
	 *            : 标题
	 * @param code
	 *            : 区域code
	 * @param villagename
	 *            : 小区名称
	 * @param villageid
	 *            : 小区ID
	 * @param building
	 *            : 楼栋名称
	 * @param apartmentname
	 *            : 户型
	 * @param area
	 *            : 面积
	 * @param redecorat
	 *            : 装修类型
	 * @param paystyle
	 *            : 支付方式
	 * @param livestyle
	 *            : 出租方式
	 * @param propertyname
	 *            : 房屋类型
	 * @param houstatus
	 *            : 1 出租
	 * @param housetag_id
	 *            : 标签ID
	 * @param landlord
	 *            : 房东
	 * @param landlordtel
	 *            : 房东电话
	 * @param contacts
	 *            : 联系人
	 * @param contactstel
	 *            : 联系人电话
	 * @param user_identity
	 *            : 房主/其他
	 * @param description
	 *            : 描述
	 * @param filePath
	 *            : 房源图片
	 * @param brand
	 *            : 品牌
	 * @param sex
	 *            :性别
	 * @param floor
	 *            : 楼层
	 * @param prices
	 *            : 价格
	 * @param tribeid
	 *            : 部落ID
	 */
	public ResultMap publishsale(Building building, Price price, House house, Village village, Long userid,
			HousetagCustomer housetag, String propertyname, String apartmentname, String brand) {
		
		// 检查小区
		ResultMap check_village = checkvillage(village);
		if (CheckDataUtil.checkNotEqual(check_village.getCode(), 200)) {return check_village;}
		Long villageid = (Long)check_village.getObj();
		// 检查楼栋
		ResultMap check_building = checkBuilding(villageid , building);
		if (CheckDataUtil.checkNotEqual(check_building.getCode(),200)) {return check_building;}
		building = (Building)check_building.getObj();
		house.setBuildingid(building.getBuildingid());
		// 前台参数house的非空校验
		ResultMap result_house = checkhouse(house);
		if (CheckDataUtil.checkisEmpty(userid)) { return ResultMap.build(400,"先登录");}
		if (CheckDataUtil.checkNotEqual(result_house.getCode(), 200L)) { return result_house; }
		// 判断房源是否是房源设置对应的参数
		checkpropertynameData(house , housetag ,propertyname);
		//判断户型是否存在设置参数
		checkapartmentnameData(house,apartmentname);
		//校验价格数据
		ResultMap price_result = checkpriceData(house,price);
		if (CheckDataUtil.checkNotEqual(price_result.getCode(), 200)) {return price_result;}
		//校验品牌数据
		checbrandData(userid ,building.getBuildingid() ,house);
		
		if (!"".equals(house.getHouseid()) && house.getHouseid() != null) {
			house.setUpdate_time(new Date());
			houseMapper.updateByPrimaryKeySelective(house);
		} else {
			// 插入之前设置房间号码
			String housenum = IDUtils.appendzero(house.getHouse_number() + "", 4);
			String housecode = building.getBuildingcode() + housenum;
			house.setHousecode(housecode);
			house.setCreate_time(new Date());
			house.setUpdate_time(new Date());
			if (house.getPaystyle() == null || "".equals(house.getPaystyle())) {
				// 前台没有传值给默认值
				house.setPaystyle("");
			}
			// 前台没有传值给默认值
			// house.setPaystyle("押一付一");
			// 房屋的状态 冻结0 未租,1 已租,2 默认1 3是移除 5已经卖 4没有卖
			Integer searchstate = systemstateMapper.selectByPrimaryKey(4).getDefaultstate();
			house.setHousestatus(searchstate + "");
			// 1为租的 2为卖的
			house.setHoustatus("2");
			// 设置用ID
			house.setUser_id(Long.valueOf(userid));
			houseMapper.insert(house);
		}
		String sendData = house.getHouseid().toString();
		SendMessUtil.sendData(jmsTemplate, houseSaleAddOrUpdate, sendData);
		return ResultMap.IS_200();
	}

	//
	private House checkhousenum(House house) {
		HouseExample example = new HouseExample();
		HouseExample.Criteria criteria = example.createCriteria();
		// 如果是更新操作过滤房号
		if (house.getHouseid() != null) {
			criteria.andHouseidNotEqualTo(house.getHouseid());
		}
		criteria.andHouse_numberEqualTo(house.getHouse_number());
		criteria.andBuildingidEqualTo(house.getBuildingid());
		criteria.andHousestatusNotEqualTo("3");
		List<House> houses = houseMapper.selectByExample(example);
		if (houses.size() > 0 && !houses.isEmpty()) {
			return houses.get(0);
		}
		return null;
	}

	/**
	 * 最新房源查询
	 * 
	 * @param userid
	 *            : 用户ID
	 * @param city
	 *            : 当前城市
	 **/
	public SearchResult findHouseByTime(AddressCustomer addressCustomer , PageQuery pagequery 
			, Long userid ,Long likecode) {
		SolrQuery query =  getHouseByTimeQuery(addressCustomer,pagequery,userid , likecode);
		SearchResult result = houseSolrDao.findHouseByTime(query);
		return result;
	}

	private SolrQuery getHouseByTimeQuery(AddressCustomer addressCustomer, PageQuery pagequery
			, Long userid,Long likecode) {
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		SolrPageUtil.juliquery(query, "", addressCustomer);
	    // 还要设置查询房源
		query.add("fq","propertyname:房源");
	    // 查询可以租的
		query.add("fq","housestatus:1");
		//设置区域查询
		SolrPageUtil.likecodequery(likecode, query);	    
		//设置排序
		query.addSort("update_time",ORDER.desc);
	    //设置分页
	    SolrPageUtil.setStartAndEnd(pagequery, query);
		return query;
	}
	public int findHouseByTimeCount(HouseVo houseVo) {
		return houseCustomerMapper.findHouseByTimeCount(houseVo);
	}

	/**
	 * 根据查询条件查询相应房源
	 * 
	 * @param userid
	 *            : 当前用户ID
	 * @param villageCustomer.likecode
	 *            : 区域CODE
	 * @param propertyCustomer.propertyname
	 *            : 房源类型
	 * @param priceCustomer.smallprices
	 *            : 最小价格
	 * @param priceCustomer.bigprices
	 *            : 最大价格
	 * @param juli
	 *            : 距离大小
	 * @param apartmentCustomer.apartmentname
	 *            : 户型
	 * @param apartmentCustomer.fourroom
	 *            : 四室以上
	 * @param housetagCustomer.type
	 *            : 房屋设施
	 * @param houseCustomer.paystyle
	 *            : 支付方式
	 * @param houseCustomer.redecorat
	 *            : 装修类型
	 * @param houseCustomer.desc
	 *            : 1 价格高到低
	 * @param houseCustomer.asc
	 *            : 1 价格低到高
	 * @param orderbyjuli
	 *            : 距离排序
	 * @param metro.code
	 *            : 地铁code
	 * @param metro.name
	 *            : 地铁名称
	 * @param metro.metroid
	 *            : 地铁ID
	 */
	/*public List<HouseCustomer> findHousebycondition(HouseVo houseVo) {
		AddressCustomer addressCustomer = houseVo.getAddressCustomer() != null ? houseVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();
		// 如果取出经纬度时候
		if (addressCustomer.getNearLatude() != null && !"".equals(addressCustomer.getNearLatude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude()));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
		} // 没有经纬度时候取用户的经纬度
		else {
			if (houseVo.getUserid() != null) {
				User user = userMapper.selectByPrimaryKey(houseVo.getUserid());
				if (user !=null) {
					userCustomer.setLatitude(user.getLatitude());
					userCustomer.setLongitude(user.getLongitude());
				}
			}
		}
		houseVo.setUserCustomer(userCustomer);
		if (houseVo.getUserid() == null) {
			houseVo.setUserid(111L);
		}
		List<HouseCustomer> houseList =  houseCustomerMapper.findHousebycondition(houseVo);
		if (houseList.isEmpty() || houseList.size() < 0) {
			houseList = new ArrayList<>();
		}
		return houseList;
	}*/

	// 检验最小地址是否存在
	private Long checkvillageExists(Village village) {
		VillageExample example = new VillageExample();
		VillageExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(village.getCode());
		criteria.andVillagenameEqualTo(village.getVillagename());
		List<Village> villagelist = villageMapper.selectByExample(example);
		if (!villagelist.isEmpty() && villagelist.size() > 0) {
			return villagelist.get(0).getVillageid();
		}
		return -1L;
	}

	// 检验价格是否存在
	private Long checkepriceExists(Price price) {
		
		
			PriceExample example = new PriceExample();
			PriceExample.Criteria criteria = example.createCriteria();
			criteria.andPricetypeEqualTo(price.getPricetype());
			criteria.andPricesEqualTo(price.getPrices());
			List<Price> selectByExample = priceMapper.selectByExample(example);
			if (!selectByExample.isEmpty() || selectByExample.size() > 0) {
				return selectByExample.get(0).getPriceid();
			}
		
		
		return -1L;
	}

	// 检验address的地址是否存在
	private Building checkebuildingExists(Building building) {
		BuildingExample example = new BuildingExample();
		BuildingExample.Criteria criteria = example.createCriteria();
		criteria.andBuildingEqualTo(building.getBuilding());
		criteria.andVillageidEqualTo(building.getVillageid());
		List<Building> selectByExample = buildingMapper.selectByExample(example);
		if (!selectByExample.isEmpty() || selectByExample.size() > 0) {
			return selectByExample.get(0);
		}
		return null;
	}

	// apartment类型判断
	private Integer checkeApartmentExists(String apartmentname) {
		ApartmentExample example = new ApartmentExample();
		ApartmentExample.Criteria criteria = example.createCriteria();
		criteria.andApartmentnameEqualTo(apartmentname);
		List<Apartment> selectByExample = apartmentMapper.selectByExample(example);
		if (!selectByExample.isEmpty() || selectByExample.size() > 0) {
			return selectByExample.get(0).getApartmentid();
		}
		return -1;
	}

	// 加载首页
	public LinkedList<HouseCustomer> findHouseByIndex(HouseVo houseVo) {
		LinkedList<HouseCustomer> findHouseByIndex = houseCustomerMapper.findHouseByIndex(houseVo);
		return findHouseByIndex;
	}

	// 附近房源的查询
	public SearchResult findHouseBySize(Long likecode ,AddressCustomer addressCustomer 
			, Long userid,PageQuery pagequry) {
		SolrQuery query = getHouseBySizeQuery(likecode ,addressCustomer ,userid,pagequry);
		SearchResult result = houseSolrDao.findHouseBySize(query);
		return result;
	}

	private SolrQuery getHouseBySizeQuery(Long likecode, AddressCustomer addressCustomer, Long userid
			,PageQuery pagequery) {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		SolrPageUtil.juliquery(query,"", addressCustomer);
		query.set("fq","likecode:"+likecode+"*");
		// 还要设置查询房源
		query.add("fq","propertyname:房源");
	    // 查询可以租的
		query.add("fq","housestatus:1");
		query.addSort("geodist()",ORDER.asc);//按照从近到远排序
		SolrPageUtil.setStartAndEnd(pagequery, query);
		return query;
	}
	@Override
	public int findHousebyconditionCount(HouseVo houseVo) {
		return houseCustomerMapper.findHousebyconditionCount(houseVo);
	}

	@Override
	public int findHouseBySizeCount(HouseVo houseVo) {

		return houseCustomerMapper.findHouseBySizeCount(houseVo);
	}

	/**
	 * 查看房屋详情
	 * @param houseid : 房源ID
	 */
	public HouseCustomer findHouseDetails(Long houseid ,Integer type ,Long userid) {
		// 先校验数据
		if (CheckDataUtil.checkNotEqual(type, 1)
				|| CheckDataUtil.checkisEmpty(houseid)) 
				{return null;}
		
		HouseCustomer houseCustomer =null  ;
		// 先去缓存中取出对应信息
		try {
			String jsonData = jedisClient.get(RedisUtil.HOUSE_FIRST_KEY+houseid);
			if (CheckDataUtil.checkNotEmpty(jsonData)) {
				houseCustomer = JsonUtils.jsonToPojo(jsonData, HouseCustomer.class);
				jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY+houseid, RedisUtil.HOUSE_OUT_TIME);
				//发送模板消息
				if (CheckDataUtil.checkNotEmpty(userid)) {
					String sendData=houseid +"-"+userid + "-" +type ;
					SendMessUtil.sendData(jmsTemplate, houseSearch, sendData);
				}
				return houseCustomer;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//这里从数据库查询
		 houseCustomer =  houseCustomerMapper.findHouseDetails(houseid);
		if (CheckDataUtil.checkisEmpty(houseCustomer)) {return null;}

		
		// 然后存入缓存
		try {
			jedisClient.set(RedisUtil.HOUSE_FIRST_KEY+houseid,JsonUtils.objectToJson(houseCustomer));
			jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY+houseid, RedisUtil.HOUSE_OUT_TIME);
			//发送模板消息
			if (CheckDataUtil.checkNotEmpty(userid)) {
				String sendData=houseid +"-"+userid + "-" +type ;
				SendMessUtil.sendData(jmsTemplate, houseSearch, sendData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return houseCustomer;
	}

	/**
	 * 查询我的出租
	 * @param userid : 用户ID
	 */
	public List<HouseCustomer> findmyrent(Long userid ,PageQuery pagequery) {
		return houseCustomerMapper.findmyrent(userid ,pagequery);
	}
	public int findmyrentCount(Long userid) {
		return houseCustomerMapper.findmyrentCount(userid);
	}

	/**
	 * 查询我的出售
	 * 
	 * @param userid
	 *            : 用户ID
	 */
	public List<HouseCustomer> findmysall(Long userid) {
		return houseCustomerMapper.findmysall(userid);
	}

	@Override
	public SearchResult findHouseByVillage2(Long userid ,Long buildingid ,PageQuery pagequery) {
		SolrQuery query = getfindHouseByVillage2query(userid ,buildingid ,pagequery);
		SearchResult result = houseSolrDao.findHouseByVillage2(query);
		return result;
	}

	private SolrQuery getfindHouseByVillage2query(Long userid, Long buildingid, PageQuery pagequery) {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		//查询所有出租的
		query.add("fq", "housetype:1");
		query.add("fq", "housestatus:(NOT 3)");
		query.add("fq", "userid:"+userid+"");
		query.add("fq", "buildingid:"+buildingid+"");
		query.addSort("house_number",ORDER.asc);
		SolrPageUtil.setStartAndEnd(pagequery, query);
		return query;
	}
	@Override
	public Integer findHouseCountByVillage2(VillageeVo villageeVo) {
		// TODO Auto-generated method stub
		return houseCustomerMapper.findHouseCountByVillage2(villageeVo);
	}

	/**
	 * 根据房子id更新房子状态
	 * @param houseid : 房子id
	 * @param housestatus : 更新的状态
	 * **/
	public void updateHousestatus(Long houseid, String housestatus) {
		House house = new House();
		house.setHouseid(houseid);
		house.setHousestatus(housestatus);
		house.setUpdate_time(new Date());
		houseMapper.updateByPrimaryKeySelective(house);
		String sendData =  houseid +"-" + housestatus;
		SendMessUtil.sendData(jmsTemplate, updateHousestates, sendData);
	}

	
	
	/**
	 * 查询房子根据id
	 * **/ 
	public HouseCustomer findHouseByHouseID(Long houseid) {
		if (houseid == null) {
			return null;
		}
		return houseCustomerMapper.findHouseByHouseID(houseid);
	}

	/**
	 * 根据相应的条件查询二手房
	 * 
	 * @param city
	 *            : 城市名称
	 * @param villageCustomer.likecode
	 *            : 区域code
	 * @param propertyCustomer.propertyname:
	 *            房屋类型
	 * @param housetagCustomer.houseyear
	 *            : 楼龄
	 * @param housetagCustomer.buildingyear
	 *            : 楼房的修旧程度
	 * @param housetagCustomer.elevator
	 *            : 电梯
	 * @param housetagCustomer.propertyright
	 *            : 房屋产权
	 * @param houseCustomer.turn
	 *            : 朝向
	 * @param houseCustomer.smallarea
	 *            :最小面积
	 * @param houseCustomer.bigarea
	 *            : 最大面积
	 * @param houseCustomer.smallhouseprice
	 *            :最小价格
	 * @param houseCustomer.bighouseprice
	 *            : 最大价格
	 * @param apartmentCustomer.apartmentname
	 *            : 户型
	 * @param houseCustomer.redecorat
	 *            : 装修类型
	 * @param metro.code
	 *            : 地铁的code
	 * @param metro.name
	 *            : 地铁mingc
	 * @param metro.metroid
	 *            : 地铁ID
	 */
	public List<HouseCustomer> findoldhouse(HouseVo houseVo) {
		AddressCustomer addressCustomer = houseVo.getAddressCustomer() != null ? houseVo.getAddressCustomer()
				: new AddressCustomer();
		UserCustomer userCustomer = new UserCustomer();
		// 如果取出经纬度时候
		if (addressCustomer.getNearLatude() != null && !"".equals(addressCustomer.getNearLatude())) {
			userCustomer.setLatitude(Double.valueOf(addressCustomer.getNearLatude()));
			userCustomer.setLongitude(Double.valueOf(addressCustomer.getNearLongitude()));
		} // 没有经纬度时候取用户的经纬度
		else {
			if (houseVo.getUserid() != null) {
				User user = userMapper.selectByPrimaryKey(houseVo.getUserid());
				userCustomer.setLatitude(user.getLatitude());
				userCustomer.setLongitude(user.getLongitude());
			}
		}
		houseVo.setUserCustomer(userCustomer);
		if (houseVo.getUserid() == null) {
			houseVo.setUserid(111L);
		}
		return houseCustomerMapper.findoldhouse(houseVo);
	}
	public Integer findoldhouseCount(HouseVo houseVo) {
		return houseCustomerMapper.findoldhouseCount(houseVo);
	}
	
	
	
	/**
	 * 按照小区或者build查找房子
	 * **/ 
	public List<HouseCustomer> findHouseByNearVillage(HouseVo houseVo) {
		return houseCustomerMapper.findHouseByNearVillage(houseVo);
	}
	public Integer findHouseByNearVillageCount(HouseVo houseVo) {
		return houseCustomerMapper.findHouseByNearVillageCount(houseVo);
	}
	
	

	/**
	 * 查一条品牌公寓
	 * **/
	public HouseCustomer findonebarnd(HouseVo houseVo) {
		return houseCustomerMapper.findonebarnd(houseVo);
	}

	// 截取地址
	/*private void suplitDetails(List<HouseCustomer> houseList) {
		for (HouseCustomer house : houseList) {
			String name = "";
			if (house.getVillagename() == null || house.getBuilding() == null) {
				name = (house.getCity() == null ? "" : house.getCity())
						+ (house.getDistrict() == null ? "" : house.getDistrict())
						+ (house.getTrading() == null ? "" : house.getTrading());
			} else {
				name = (house.getTrading() == null ? "" : house.getTrading())
						+ (house.getVillagename() == null ? "" : house.getVillagename())
						+ (house.getBuilding() == null ? "" : house.getBuilding());
			}

			house.setDetailes(name);
		}

	}*/

	/**
	 * 根据查询条件查询附近的
	 * **/
	public SearchResult getneardetail(AddressCustomer addressCustomer ,HouseCustomer houseCustomer,
			PageQuery pagequery , Long userid , String orderJuli , String orderTime) {
		SolrQuery query = getNearDetailQuery(addressCustomer,houseCustomer , pagequery , userid , orderJuli,orderTime);
		SearchResult result = houseSolrDao.getNearDetail(query);
		return result;

	}
	private SolrQuery getNearDetailQuery(AddressCustomer addressCustomer, HouseCustomer houseCustomer,PageQuery pagequery, Long userid,
			String orderJuli ,String orderTime) {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		SolrPageUtil.juliquery(query, "", addressCustomer);
		query.add("fq", "articletypeid:(1 or 11)");
		query.add("fq", "housestatus:(1 OR 2)");
		SolrPageUtil.houseQuery(houseCustomer, query);
		SolrPageUtil.setStartAndEnd(pagequery, query);
		if (CheckDataUtil.checkNotEmpty(orderTime)) {
			query.addSort("update_time",ORDER.desc);
		}
		if (CheckDataUtil.checkNotEmpty(orderJuli)) {
			query.addSort("geodist()",ORDER.asc);//按照从近到远排序
		}
		///query.addSort("update_time",ORDER.desc);//按照从近到远排序
		return query;
	}
	public int getneardetailCount(HouseVo houseVo) {
		return addressCustomerMapper.getneardetailCount(houseVo);
	}
	
	
	

	//处理楼栋编号 [内部方法]
	public List<HouseCustomer> buildinghousecode() {
		List<HouseCustomer> houses = houseCustomerMapper.buildinghousecode();
		for (HouseCustomer house : houses) {
			String houscode = IDUtils.appendzero(house.getHouse_number() + "", 4);
			if (house.getBuildingcode() != null && !"".equals(house.getBuildingcode())) {
				houscode = house.getBuildingcode() + houscode;
				house.setHousecode(houscode);
				houseMapper.updateByPrimaryKeySelective(house);
			}
		}
		return houses;
	}

	/**
	 * 查询品牌公寓列表
	 * **/ 
	public List<BrandCustomer> brandlist(HouseVo houseVo) {
		List<BrandCustomer> brans = houseCustomerMapper.brandlist(houseVo);
		for (BrandCustomer brand : brans) {
			BrandCustomer search = houseCustomerMapper.branddetail(brand.getBrandid());
			brand.setBuilcount(search.getBuilcount());
			brand.setHousecount(search.getHousecount());
			brand.setPrices(search.getPrices());
			if (search.getHousepicture() == null || "".equals(search.getHousepicture())) {
				brand.setHousepicture(brand.getOnepicture());
			} else {
				brand.setHousepicture(search.getHousepicture());
			}

		}

		return brans;
	}
	public int brandlistCount(HouseVo houseVo) {
		return houseCustomerMapper.brandlistCount(houseVo);
	}

	/*
	 * 根据房子属性type获取对应的主键ID
	 */
	public String getHousetagByType(String type) {
		HousetagExample example = new HousetagExample();
		HousetagExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		List<Housetag> housetags = housetagMapper.selectByExample(example);
		if (!housetags.isEmpty() && housetags.size() > 0) {
			return housetags.get(0).getHousetagid() + "";
		}
		return null;
	}

	/**
	 * 根据楼栋ID编辑房源的品牌为空
	 * **/
	public void deletebrandidbybuildingid(Long buildingid) {
		houseCustomerMapper.deletebrandidbybuildingid(buildingid);
		
		// 发送消息同步房源品牌
		SendMessUtil.sendData(jmsTemplate, updateHouseByBuildingid, buildingid.toString());
	}

	/**
	 * 根据楼栋ID 和品牌ID封装房源品牌
	 * **/
	public void addbrandidbybuildingid(HouseCustomer houseCustomer) {
		houseCustomerMapper.addbrandidbybuildingid(houseCustomer);
		// 发送消息同步房源品牌
		SendMessUtil.sendData(jmsTemplate, updateHouseByBuildingid, houseCustomer.getBuildingid().toString());
	}

	// 查询上架7天没有更新房源信息的IDS
	public String[] search7daysnotupdate() {
		// TODO Auto-generated method stub
		return houseCustomerMapper.search7daysnotupdate();
	}

	/**
	 * 根据房子id集合下架7天没有更新的房源
	 * **/
	public void update7dayundercarriage(String[] houseids) {
		houseCustomerMapper.update7dayundercarriage(houseids);
	}

	/**
	 * 7天自动下架旧房源
	 * ***/
	public List<UserCustomer> search7daysnotupdateuser() {
		return houseCustomerMapper.search7daysnotupdateuser();
	}

	
	
	/**
	 * 预订时候查询基本信息
	 * **/
	public HouseCustomer getHouseYudingMess(Long houseid) {
		return houseCustomerMapper.getHouseYudingMess(houseid);
	}

	
	
	
	/**
	 * 根据预订信息 下预订单
	 * **/ 
	public ResultMap gethouseorderid(Houseorder houseorder) {
		// 第一步先查询房源的状态 [必须是可租的房子]
		House house = houseMapper.selectByPrimaryKey(houseorder.getHouseid());
		if (CheckDataUtil.checkisEmpty(house)
				&& !"1".equals(house.getHousestatus())) {
			return ResultMap.build(400, "该房源已经出租或者下架");
		}
		
		
		
		// 第二步判断房子是否正常砍价中 [没有在或者砍价活动结束]
		Bargain bargain = houseCustomerMapper.getNewBargin(houseorder.getHouseid() , 1);
		if (CheckDataUtil.checkNotEmpty(bargain)) {
			// 判断当前时间和截止时间的差距
			Long current = new Date().getTime()-1000*60*10;
			Long end = bargain.getEndtime().getTime();
			if (bargain.getUserid().longValue() !=houseorder.getUserid()) {
				// 如果当前时间小于砍价时间说明在砍价中
				if (current.longValue() < end.longValue()) {
					return ResultMap.build(400, "该房源正在砍价中");
				}
			}
		}
		
		// 如果有订单ID
		if (CheckDataUtil.checkNotEmpty(houseorder.getHouseorderid())) {
			houseorderMapper.updateByPrimaryKeySelective(houseorder);
			return ResultMap.IS_200(houseorder.getHouseorderid());
		}
		
		
		
		// 第三步 这里判断用户是不是点击的未支付的信息
		HouseorderExample example = new HouseorderExample();
		HouseorderExample.Criteria criteria = example.createCriteria();
		criteria.andHouseidEqualTo(houseorder.getHouseid());
		criteria.andUseridEqualTo(houseorder.getUserid());
		criteria.andPaystateEqualTo(2);
		criteria.andBarginidIsNull();
		List<Houseorder> orders = houseorderMapper.selectByExample(example);
		if (!orders.isEmpty() && orders.size() > 0) {
			// 这里表示用户点击的还是同一个房源需要做修改操作
			Houseorder search = orders.get(0);
			search.setMesage(houseorder.getMesage());
			search.setReservations(houseorder.getReservations());
			search.setReservationstel(houseorder.getReservationstel());
			search.setPrices(houseorder.getPrices());
			Long current = new Date().getTime();
			Long pass = search.getOrdertime().getTime();
			if (current - pass >= 3600000) {
				search.setOrdertime(new Date());
			}
			houseorderMapper.updateByPrimaryKeySelective(search);
			return ResultMap.IS_200(search.getHouseorderid());
		}
		// 如果查无数据表示是第一次点进来的需要做插入
		houseorder.setOrdertime(new Date());
		// 表示没有支付
		houseorder.setPaystate(2);
		houseorder.setBuystate(1);
		houseorder.setSallstate(1);
		houseorderMapper.insertSelective(houseorder);
		return ResultMap.IS_200(houseorder.getHouseorderid());
	}

	/**
	 * 房源预定之后的回调
	 * @param houseorderid : 房子订单号
	 * @param total_amount : 总金额
	 * @param weixinorder : 微信商户订单号
	 * **/
	public String houseyudingsuccess(String houseorderid, String total_amount, String weixinorder) {
		// TODO Auto-generated method stub
		Houseorder search = //new HouseOrderCustomer();
				houseorderMapper.selectByPrimaryKey(Long.valueOf(houseorderid));
		// 设置为支付成功
		search.setPaystate(1);
		// 设置成交金额
		search.setPrices(Double.valueOf(total_amount) / 100);
		// 追踪订单时候
		search.setOrdertime(new Date());
		// 设置商户订单号。退款时候需要用到
		search.setWeixinorder(weixinorder);
		houseorderMapper.updateByPrimaryKeySelective(search);

		// 发送短信给租客提醒预定成功
		SendMessage.sendHouseOrder(search.getReservationstel(), request);
		// 发送短信给房东提醒有人预定
		
		// 发送公众号模板消息
		

		// 设置房子为已经预定状态
		House updatehouse = new House();
		updatehouse.setHousestatus("6");
		updatehouse.setHouseid(search.getHouseid());
		houseMapper.updateByPrimaryKeySelective(updatehouse);
		return "success";
	}

	/**
	 * 查询我的历史预定信息
	 * **/
	public List<HouseOrderCustomer> searchhouselist(Long userid, PageQuery pagequery) {
		return houseCustomerMapper.searchhouselist(userid, pagequery);
	}
	public int searchhouselistCount(Long userid) {
		return houseCustomerMapper.searchhouselistCount(userid);
	}

	public Houseorder houseorderdetail(Long userid, Long houseid,Long houseorderid) {
		
		if (CheckDataUtil.checkisEmpty(houseorderid)) {
			return null;
		}
		
		HouseorderExample example = new HouseorderExample();
		HouseorderExample.Criteria criteria = example.createCriteria();
		//criteria.andUseridEqualTo(userid);
		//criteria.andHouseidEqualTo(houseid);
		criteria.andHouseorderidEqualTo(houseorderid);
		List<Houseorder> ordes = houseorderMapper.selectByExample(example);
		if (!ordes.isEmpty() && ordes.size() > 0) {
			Houseorder houseorder =  ordes.get(0);
			double freemonery = 0 ;
			if (CheckDataUtil.checkNotEmpty(houseorder.getBarginid())) {
				Bargain search = bargainMapper.selectByPrimaryKey(houseorder.getBarginid());
				if (CheckDataUtil.checkNotEmpty(search)
						&& CheckDataUtil.checkNotEmpty(search.getPreparatoryid())) {
					houseorder.setPreparatoryid(search.getPreparatoryid());
					freemonery = search.getTotalbanalce() - search.getLessbalance();
					
				}
			}
			houseorder.setFreemonery(freemonery );
			return houseorder;
		}
		return null;
	}

	/**更新房源预定订单
	 * @param userid : 用户id
	 * @param houseorderid : 订单id
	 * @param refundmess : 退款原因如果不是退款为kon
	 * @param paystate : 订单状态
	 * **/
	public ResultMap updatehouseorder(Long userid, Long houseorderid, int paystate , String refundmess) {
		// TODO Auto-generated method stub
		HouseOrderCustomer houseorder = houseCustomerMapper.searchorderpay(houseorderid);
		if (houseorder == null) {
			return ResultMap.build(400, "没有查出相关订单");
		}
		
		// 移除订单只有发起人可以移除
		if (paystate == 3) {
			// 判断当前订单状态如果是 1-支付 和待确认状态不能移除
			if (houseorder.getPaystate() == 1 || houseorder.getPaystate()==4) {
				return ResultMap.build(400, "当前不可移除");
			}
			// 判断当前人是否是发起人
			if (houseorder.getUserid() != userid.longValue() 
					&& houseorder.getSenduserid() != userid.longValue()) { return  ResultMap.build(400,"你无权移除订单");}
			// 如果是买家移除
			if (houseorder.getUserid() == userid.longValue()) {
				houseorder.setBuystate(2);
			}
			// 如果是卖家移除
			if (houseorder.getSenduserid() == userid.longValue()) {
				houseorder.setSallstate(2);
			}
		}
		// 确认订单 相关发起人 才可以确认订单
		if (paystate == 4 ) {
			// 只有支付过的订单才可以 修改为确认状态
			if (houseorder.getPaystate() != 1) { return ResultMap.build(400,"当前预定未支付");}
			// 这里还要判断哪些人可以确认订单 ... 
		}
		
		// 表示全额退款需要修改房子为可以租的状态
		if (paystate == 6) {
			// 只有支付状态下的订单才可以退款
			if (houseorder.getPaystate() !=1) {return ResultMap.build(400, "当前不可退款");}
			House update = new House();
			update.setHouseid(houseorder.getHouseid());
			update.setHousestatus("1");
			houseMapper.updateByPrimaryKeySelective(update);
		}
		if (paystate != 3) {
			houseorder.setPaystate(paystate);
		}
		houseorder.setRefundmess(refundmess);
		houseorderMapper.updateByPrimaryKeySelective(houseorder);
		return ResultMap.build(200,"操作成功 ");
	}



	/**
	 * 查询待确认房源订单
	 * @param userid : 用户id
	 * **/ 
	public List<HouseOrderCustomer> searchSureHousePay(Long userid, PageQuery pagequery) {
		return houseCustomerMapper.searchSureHousePay(userid, pagequery);
	}
	public int searchSureHousePayCount(Long userid) {
		return houseCustomerMapper.searchSureHousePayCount(userid);
	}
	

	/**
	 * 查询已经下单的详情
	 * @param houseorderid : 订单id
	 * **/ 
	public HouseOrderCustomer searchorderpay(Long houseorderid) {
		return houseCustomerMapper.searchorderpay(houseorderid);
	}
	
	

	/**
	 * 根据订单id 查询预订详情
	 * @param houseorderid : 预订单id
	 * @return
	 */
	public Houseorder gethouseorderbyid(String houseorderid) {
		return houseorderMapper.selectByPrimaryKey(Long.valueOf(houseorderid));
	}

	/**
	 * 批量添加房号
	 * **/ 
	public ResultMap batchhouse(Building building, Price price, House house, Village village, Long userid,
			HousetagCustomer housetag, String propertyname, String apartmentname, String brand, String batchhouse
			,String preparatory) {
		
		// 检查小区
		ResultMap check_village = checkvillage(village);
		if (CheckDataUtil.checkNotEqual(check_village.getCode(), 200)) {return check_village;}
		Long villageid = (Long)check_village.getObj();
		// 检查楼栋
		ResultMap check_building = checkBuilding(villageid , building);
		if (CheckDataUtil.checkNotEqual(check_building.getCode(),200)) {return check_building;}
		building = (Building)check_building.getObj();
		house.setBuildingid(building.getBuildingid());
		// 前台参数house的非空校验
		ResultMap result_house = checkhouse(house);
		if (CheckDataUtil.checkisEqual(result_house.getCode(), 400)){return result_house;}
		// 判断房源是否是房源设置对应的参数
		checkpropertynameData(house , housetag ,propertyname);
		//判断户型是否存在设置参数
		checkapartmentnameData(house,apartmentname);
		//校验价格数据
		ResultMap price_result = checkpriceData(house,price);
		if (CheckDataUtil.checkNotEqual(price_result.getCode(), 200)) {return price_result;}
		//校验品牌数据
		checbrandData(userid ,building.getBuildingid() ,house);

		int  success = 0;
		int  error = 0 ;
		List<House> errorList = new ArrayList<>();
		String sendData = "";
		try {
			String[] bartchs = batchhouse.split(",");
			for (int i = 0; i < bartchs.length; i++) {
				// 插入之前设置房间号码
				Integer floor = Integer.parseInt(bartchs[i].split("-")[0]);
				String housenub = bartchs[i].split("-")[1];
				// 这里校验房间号是否重复
				house.setHouse_number(housenub);
				house.setFloor(floor);
				House chekchouse = checkhousenum(house);
				if (chekchouse == null) {
					success++;
					house.setFloor(floor);
					String housenum = IDUtils.appendzero(house.getHouse_number() + "", 4);
					String housecode = building.getBuildingcode() + housenum;
					house.setHousecode(housecode);
					house.setCreate_time(new Date());
					house.setUpdate_time(new Date());
					if (house.getPaystyle() == null || "".equals(house.getPaystyle())) {
						// 前台没有传值给默认值
						house.setPaystyle("");
					}
					// 房屋的状态 冻结0 未租1 已租2 默认1 3是移除 5待审核 4没有卖
					Integer searchstate = systemstateMapper.selectByPrimaryKey(4).getDefaultstate();
					house.setHousestatus(searchstate + "");
					// 1为租的 2为卖的
					house.setHoustatus("1");
					// 设置用户ID
					house.setUser_id(Long.valueOf(userid));
					house.setXcxpicture("");
					houseMapper.insert(house);
					Long inserhouseid = house.getHouseid();
					sendData = sendData + inserhouseid + "-";
					preparatoryhouse( preparatory ,inserhouseid );
					house.setHouseid(null);
				}else {
					House errorhouse = new House();
					errorhouse.setFloor(house.getFloor());
					errorhouse.setHouse_number(house.getHouse_number());
					errorList.add(errorhouse);
					error++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "参数错误");
		}
		//循环完成以后在加入用户id 和部落id
		String message = "";
		if (success > 0) {
			message +="成功发布:" + success;
			sendData = sendData.substring(0, sendData.length()-1);
			String tribeid = "undefined";
			if (CheckDataUtil.checkNotEmpty(housetag.getTribeid())) {
				tribeid = housetag.getTribeid();
			}
			sendData = sendData +","+userid + "," + tribeid;
			SendMessUtil.sendData(jmsTemplate, houseAddBatch, sendData);
		}
			
		if (error > 0)
			message += " 发布失败:"+error ;
		return ResultMap.build(201, message,errorList);
	}
	
	// 设置房源佣金规则
	public void preparatoryhouse(String preparatory ,long houseid ) {
		 try {
			 
			// 先删除佣金规格
			PreparatoryExample exampledelete = new PreparatoryExample();
			PreparatoryExample.Criteria criteriadelete = exampledelete.createCriteria();
			criteriadelete.andHouseidEqualTo(houseid);
			preparatoryMapper.deleteByExample(exampledelete);
			 
			// 先把所有的房子佣金置空
			//houseCustomerMapper.deletepreparhouse(houseid);
			String [] split = preparatory.split(",");
			for (int i =0;i<split.length;i++) {
				Long housetargid = Long.valueOf(split[i].split("-")[0]);
				Integer daycount = 1800 ;
				Double centpercentnum =Double.valueOf(split[i].split("-")[1]);
				Double landpercentnum =Double.valueOf(split[i].split("-")[2]);
				if (housetargid == 72) {daycount = 90;}
				if (housetargid == 71) {daycount = 30 ;}
				if (housetargid == 70) {daycount = 180;}
				if (housetargid == 73) {daycount = 360;}
				if (housetargid == 74) {daycount = 270;}
				if (centpercentnum  > 0 || landpercentnum > 0) {
					Preparatory insert = new Preparatory();
					insert.setCentpercentnum(centpercentnum);
					insert.setDaycount(daycount);
					insert.setLandpercentnum(landpercentnum);
					insert.setHouseid(houseid);
					insert.setHousetagid(housetargid);
					preparatoryMapper.insertSelective(insert);
				}
			}
		} catch (Exception e) {
			System.out.println("佣金格式设计错误：" + preparatory);
		}
		
	}

	/**查询佣金的集合
	 * @param houseid : 房子ID
	 * **/
	public List<PreparatoryCustomer> preparList(Long houseid) {
		List<PreparatoryCustomer> preList =  houseCustomerMapper.preparList(houseid);
		if (preList.isEmpty() || preList.size() == 0) {
			PreparatoryCustomer pre = new PreparatoryCustomer();
			pre.setType("不限");
			pre.setDaycount(0);
			pre.setLandpercentnum(0.0);
			pre.setCentpercentnum(0.0);
			pre.setPreparatoryid(-1L);
			preList = new ArrayList<>();
			preList.add(pre);
		}
		return preList;
	}
	@Override
	public List<PreparatoryCustomer> preparList(List<Long> houseid) {
		if (houseid.size() == 0 || houseid.isEmpty()) {return new ArrayList<>();}
		return houseCustomerMapper.preparListbyhouseids(houseid);
	}


	/**所有的房子信息导入索引库**/
	public ResultMap searchAllHouseToSolr(PageQuery pagequery) {
		// 这里需要查询其中一个部落
		List<HouseCustomer> houseList = houseCustomerMapper.searchAllHouseToSolr(pagequery);
		for (HouseCustomer house:houseList) {
			if (CheckDataUtil.checkNotEmpty(house.getTribeids())) {
				Long tribeid = Long.valueOf(  house.getTribeids().split(",")[0] );
				Tribe  tribe =tribeMapper.selectByPrimaryKey(tribeid);
				house.setTribepicture(tribe.getPicture());
				house.setTribename(tribe.getName());
			}
		}
		
		// 这里需要查询其中一个部落
		List<ArticleDetailCustomer> detailList = tribeCustomerMapper.searchAllDetailToSolr(pagequery);
		for (ArticleDetailCustomer article : detailList) {
			if (CheckDataUtil.checkNotEmpty(article.getTribeids())) {
				Long tribeid = Long.valueOf(  article.getTribeids().split(",")[0] );
				Tribe  tribe =tribeMapper.selectByPrimaryKey(tribeid);
				article.setTribepicture(tribe.getPicture());
				article.setTribename(tribe.getName());
			}
		}
		
		if (CheckDataUtil.checkisEmpty(houseList) && CheckDataUtil.checkisEmpty(detailList)) 
			{return ResultMap.build(400, "没有更多数据了....");}
		// 先删除对应的数据
		ResultMap resultMap = houseSolrDao.deletehousebypagequery(pagequery);
		if (resultMap.getCode() == 200)
			{	
				
				ResultMap resulthouse = houseSolrDao.AddAllHouseToSolr(houseList);
				ResultMap resultdetail = tribeSolrDao.AllArticleDetailToSolr(detailList);
				if (resultdetail.getCode() !=200) {return resultdetail;}
				if (resulthouse.getCode() !=200) {return resulthouse;}
				return ResultMap.build(200, "导入成功");
			}
		
		return resultMap;
		
	}
	
	
	/**查询本小区房源或者本楼栋房源**/
	public SearchResult searchVillageHouseorBuildingHouse(Long buildingid, Long villageid, PageQuery pagequery) {
		SolrQuery query = getsearchVillageHouseorBuildingHousequery(buildingid,villageid,pagequery);
		return houseSolrDao.searchVillageHouseorBuildingHouse(query);
	}
	private SolrQuery getsearchVillageHouseorBuildingHousequery(Long buildingid, Long villageid, PageQuery pagequery) {
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.add("fq","propertyname:房源");
		//楼栋的查询条件
		if (CheckDataUtil.checkNotEmpty(buildingid)) {
			query.add("fq", "buildingid:"+buildingid+"");
		}
		//小区的查询条件
		if (CheckDataUtil.checkNotEmpty(villageid)) {
			query.add("fq", "villageid:"+villageid+"");
		}
		query.add("fq", "housestatus:1 or housestatus:2");
		// 设置排序根据房号排序
		query.addSort("house_number",ORDER.asc);
		SolrPageUtil.setStartAndEnd(pagequery, query);
		return query;
	}
	@Override
	public SearchResult findHousebycondition(String orderbyjuli,Metro metro, PriceCustomer priceCustomer, Long userid,
			Long likecode, PropertyCustomer propertyCustomer, ApartmentCustomer apartmentCustomer,
			AddressCustomer addressCustomer, HouseCustomer houseCustomer, String juli,
			HousetagCustomer housetagCustomer, PageQuery pagequery) {
		// TODO Auto-generated method stub
		
		SolrQuery query = getFindhouseByConditionQuery(orderbyjuli,metro,priceCustomer,userid ,likecode,propertyCustomer,apartmentCustomer
			,addressCustomer,houseCustomer,juli,housetagCustomer,pagequery);
		
		SearchResult result = houseSolrDao.findHouseBycadition(query);
		return result;
	}
	private SolrQuery getFindhouseByConditionQuery(String orderbyjuli,
			Metro metro, PriceCustomer priceCustomer, Long userid, Long likecode,
			PropertyCustomer propertyCustomer, ApartmentCustomer apartmentCustomer, AddressCustomer addressCustomer,
			HouseCustomer houseCustomer, String juli, HousetagCustomer housetagCustomer, PageQuery pagequery) {
		
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		
		//封装距离 的查询条件
		SolrPageUtil.juliquery(query ,juli ,addressCustomer);
		if (CheckDataUtil.checkNotEmpty(orderbyjuli)) {
			if (CheckDataUtil.checkisEqual(orderbyjuli, "desc")) {
				query.addSort("geodist()",ORDER.desc);//按照从近到远排序
			}
			if (CheckDataUtil.checkisEqual(orderbyjuli, "asc")) {
				query.addSort("geodist()",ORDER.asc);//按照从近到远排序
			}
		}
		//封装户型的查询条件
		SolrPageUtil.apartmentQuery(apartmentCustomer , query);
		// 封装房源的查询条件
		SolrPageUtil.houseQuery(houseCustomer,query);
		//房源类型的封装条件
		SolrPageUtil.propertyquery(propertyCustomer,query);
		//价格的查询条件
		SolrPageUtil.pricesquery(priceCustomer,query);
		//地铁查询条件
		SolrPageUtil.metroquery(metro , query);
		// 小区的查询条件
		if (CheckDataUtil.checkNotEmpty(likecode)) {
			query.add("fq", "likecode:*"+likecode+"*");
		}
		SolrPageUtil.setStartAndEnd(pagequery, query);
		
		query.addSort("update_time",ORDER.desc);//按照从近到远排序
	    return query;
	}

	// 二手房的列表页
	public SearchResult findoldhouse(PropertyCustomer propertyCustomer, HousetagCustomer housetagCustomer,
			HouseCustomer houseCustomer, ApartmentCustomer apartmentCustomer, Metro metro, Long likecode
			,AddressCustomer addressCustomer,PageQuery pagequery) {
		
		SolrQuery query=new SolrQuery();
		query.setQuery("*:*");
		//封装距离 的查询条件
		SolrPageUtil.juliquery(query ,"" ,addressCustomer);
		//房子类型二手房之内的
		SolrPageUtil.propertyquery(propertyCustomer, query);
		//房子的基本查询条件
		SolrPageUtil.houseQuery(houseCustomer, query);
		// 标签的条件
		SolrPageUtil.housetargQuery(housetagCustomer, query);
		// 加入地铁的
		SolrPageUtil.metroquery(metro, query);
		SolrPageUtil.setStartAndEnd(pagequery, query);
		// 加入默认排序
		query.addSort("update_time",ORDER.desc);
		
		return houseSolrDao.findoldhouse(query);
	}
	

	

}
