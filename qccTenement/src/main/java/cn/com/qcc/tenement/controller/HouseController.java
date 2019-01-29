package cn.com.qcc.tenement.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Browse;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.Pararule;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.BuyCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseOrderCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.HousetagCustomer;
import cn.com.qcc.queryvo.PreparatoryCustomer;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.service.ApartmentService;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.BuyService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.HousertargService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.PropertyService;
import cn.com.qcc.service.QiuzuService;
import cn.com.qcc.service.TribeService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;

@Controller
public class HouseController {

	@Autowired HouseService houseService;
	@Autowired PropertyService propertyService;
	@Autowired ApartmentService apartmentService;
	@Autowired BrowseService browseService;
	@Autowired QiuzuService qiuzuService;
	@Autowired BuyService buyService;
	@Autowired TribeService tribeService;
	@Autowired VillageService villageService;
	@Autowired UserService userService;
	@Autowired InteService inteService;
	@Autowired HousertargService housertargService;

	// 房源一键导入索引库
	@RequestMapping("/house/addtosolr")
	@ResponseBody
	public ResultMap allHouseAddTOSolr(int start ,int end) {
		PageQuery pagequery = new PageQuery();
		pagequery.setPagestart(start);
		pagequery.setPageend(end);
		return houseService.searchAllHouseToSolr(pagequery);
		
	}

	// 查询本小区房源或者本楼栋房源
	@RequestMapping("/searchVillageHouseorBuildingHouse")
	@ResponseBody
	public ResultMap searchVillageHouseorBuildingHouse(Long villageid, Long buildingid,
			@RequestParam(defaultValue = "0") Integer currentpage, @RequestParam(defaultValue = "8") int pagesize) {
		if (CheckDataUtil.checkisEmpty(buildingid) && CheckDataUtil.checkisEmpty(villageid)) {
			return ResultMap.build(400, "输入小区或者楼栋");
		}
		
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = houseService.searchVillageHouseorBuildingHouse(buildingid,villageid,pagequery);
		Integer infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		List<HouseCustomer> houseList = result.getHouselist();
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("houseList", houseList);
		return ResultMap.IS_200(map);
	}

	/**
	 * 最新房源查询
	 * 
	 * @param userid : 用户ID
	 * @param city : 当前城市 // TDDTO city = "深圳";
	 **/
	@RequestMapping(value = "/house/findHouseByTime")
	@ResponseBody
	public ResultMap findHousetarding(HouseVo houseVo, String city,Long userid,
			@RequestParam(defaultValue = "1") Integer currentpage,@RequestParam(defaultValue = "8") int pagesize) {
		
		// 通过城市获取到code
		Long likecode = villageService.getcodebycity(city);
		VillageCustomer villageCustomer = houseVo.getVillageCustomer();
		if (CheckDataUtil.checkNotEmpty(villageCustomer.getLikecode())) {
			likecode = villageCustomer.getLikecode();
		}
		// 校验城市的code是否正确
		if (CheckDataUtil.checkisEmpty(likecode)
				|| CheckDataUtil.checkisEmpty(currentpage)
				|| CheckDataUtil.checkisEmpty(pagesize)) 
		{return ResultMap.build(400,"参数错误");}
		
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = houseService.findHouseByTime(houseVo.getAddressCustomer() ,
				pagequery ,userid ,likecode);
		List<HouseCustomer> houseList = result.getHouselist();
		pagequery.setPageParams(result.getRecordCount(), pagesize, currentpage);
		// 截取地址
		suplitDetails(houseList);
		Map<String, Object> map = new HashMap<>();
		map.put("houseList", houseList);
		map.put("citycode", likecode);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 根据查询条件查询相应房源
	 * 
	 * @param userid : 当前用户ID
	 * @param villageCustomer.likecode : 区域CODE
	 * @param propertyCustomer.propertyname  : 房源类型
	 * @param priceCustomer.smallprices  : 最小价格
	 * @param priceCustomer.bigprices : 最大价格
	 * @param juli : 距离大小
	 * @param apartmentCustomer.apartmentname : 户型
	 * @param apartmentCustomer.fourroom : 四室以上
	 * @param housetagCustomer.type  : 房屋设施
	 * @param houseCustomer.paystyle : 支付方式
	 * @param houseCustomer.redecorat  : 装修类型
	 * @param houseCustomer.desc  : 1 价格高到低
	 * @param houseCustomer.asc : 1 价格低到高
	 * @param orderbyjuli : 距离排序
	 * @param metro.code  : 地铁code
	 * @param metro.name : 地铁名称
	 * @param metro.metroid : 地铁ID
	 */
	@RequestMapping(value = "/house/findHouseByCondition")
	@ResponseBody
	public ResultMap findHousebycondition(String city, HouseVo houseVo,
			@RequestParam(defaultValue = "0") Integer currentpage,@RequestParam(defaultValue = "8") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		// TDDTO city = "深圳";
		Long likecode = villageService.getcodebycity(city);
		map.put("citycode", likecode);
		VillageCustomer villageCustomer = houseVo.getVillageCustomer();
		if (CheckDataUtil.checkNotEmpty(villageCustomer.getLikecode())) {
			likecode = villageCustomer.getLikecode();
		}
		BuildingCustomer buildingCustomer = houseVo.getBuildingCustomer();
		HouseCustomer houseCustomer = houseVo.getHouseCustomer();
		if (CheckDataUtil.checkNotEmpty(buildingCustomer.getBrandid())) {
			houseCustomer.setBrandid(buildingCustomer.getBrandid());
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = houseService.findHousebycondition(
			 houseVo.getOrderbyjuli(),	houseVo.getMetro(),houseVo.getPriceCustomer()
			,houseVo.getUserid()	,likecode ,houseVo.getPropertyCustomer(),houseVo.getApartmentCustomer(),
			houseVo.getAddressCustomer(),houseCustomer , houseVo.getJuli() , houseVo.getHousetagCustomer(),pagequery);
		// 截取地址
		List<HouseCustomer> findHousetarding = result.getHouselist();
		int infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		List<Long> houseidList = suplitDetails(findHousetarding);
		List<PreparatoryCustomer> preList = houseService.preparList(houseidList);
		setPreList(findHousetarding , preList);
		map.put("addressList", findHousetarding);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 根据相应的条件查询二手房
	 * 
	 * @param city  : 城市名称
	 * @param villageCustomer.likecode   : 区域code
	 * @param propertyCustomer.propertyname: 房屋类型
	 * @param housetagCustomer.houseyear  : 楼龄
	 * @param housetagCustomer.buildingyear : 楼房的修旧程度
	 * @param housetagCustomer.elevator : 电梯
	 * @param housetagCustomer.propertyright : 房屋产权
	 * @param houseCustomer.turn  : 朝向
	 * @param houseCustomer.smallarea  :最小面积
	 * @param houseCustomer.bigarea  : 最大面积
	 * @param houseCustomer.smallhouseprice  :最小价格
	 * @param houseCustomer.bighouseprice  : 最大价格
	 * @param apartmentCustomer.apartmentname  : 户型
	 * @param houseCustomer.redecorat : 装修类型
	 * @param metro.code : 地铁的code
	 * @param metro.name  : 地铁mingc
	 * @param metro.metroid   : 地铁ID
	 * @param userid  : 用户ID
	 */
	@RequestMapping(value = "/house/findoldhouse")
	@ResponseBody
	public ResultMap findoldhouse(String city, HouseVo houseVo, @RequestParam(defaultValue = "1") Integer currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		// 通过城市获取到code
		Long likecode = villageService.getcodebycity(city);
		map.put("citycode", likecode);
		VillageCustomer villageCustomer = houseVo.getVillageCustomer();
		if (CheckDataUtil.checkNotEmpty(villageCustomer.getLikecode())) {
			likecode = villageCustomer.getLikecode();
		}
		if (CheckDataUtil.checkisEmpty(likecode)) {return ResultMap.build(400, "参数不对");}
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result  = houseService.findoldhouse(houseVo.getPropertyCustomer(),
				houseVo.getHousetagCustomer(),houseVo.getHouseCustomer(),houseVo.getApartmentCustomer(),
				houseVo.getMetro(),likecode ,houseVo.getAddressCustomer(),pagequery);
		List<HouseCustomer>  findHousetarding = result.getHouselist();
		int infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		// 截取地址
		suplitDetails(findHousetarding);
		map.put("addressList", findHousetarding);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}


	/**
	 * 发布房源信息 出租
	 * 
	 * @param house_number  : 房号
	 * @param userid  : 发布人ID
	 * @param housetitle   : 标题
	 * @param code   : 区域code
	 * @param villagename   : 小区名称
	 * @param villageid  : 小区ID
	 * @param building     : 楼栋名称
	 * @param apartmentname  : 户型
	 * @param area : 面积
	 * @param redecorat  : 装修类型
	 * @param paystyle   : 支付方式
	 * @param livestyle  : 出租方式
	 * @param propertyname   : 房屋类型
	 * @param houstatus : 1 出租
	 * @param housetag_id    : 标签ID
	 * @param landlord   : 房东
	 * @param landlordtel  : 房东电话
	 * @param contacts     : 联系人
	 * @param contactstel       : 联系人电话
	 * @param user_identity  : 房主/其他
	 * @param description  : 描述
	 * @param filePath     : 房源图片
	 * @param brand     : 品牌
	 * @param sex    :性别
	 * @param floor       : 楼层
	 * @param prices    : 价格
	 * @param tribeid : 部落ID
	 */
	@RequestMapping(value = "/house/insertHouse")
	@ResponseBody
	public ResultMap insertHouse(HousetagCustomer housetag, Building building, Price price, String apartmentname,
			House house, String preparatory, String batchhouse, Area area,  Village village, Long userid,
			String propertyname, String filePath, String brand) {

		// 设置房间类型的关联 -别墅 -二手房 - 写字楼等等
		Integer propertyId = propertyService.selectIDbyPropertyName(propertyname);
		if (CheckDataUtil.checkisEmpty(propertyId)) {
			return ResultMap.build(400, "检查发布类型");
		}
		house.setProperty_id(propertyId);
		// 设置图片的地址
		house.setPicture(filePath);
		ResultMap resultMap = null;
		if (CheckDataUtil.checkisEmpty(batchhouse)) {
			resultMap = houseService.publishouse(building, price, house, village, userid, housetag, propertyname,
					apartmentname, brand, preparatory);
		} else {
			resultMap = houseService.batchhouse(building, price, house, village, userid, housetag, propertyname,
					apartmentname, brand, batchhouse, preparatory);
		}

		return resultMap;
	}

	// 批量录入房源
	/*@RequestMapping("/house/batchin")
	@ResponseBody
	public ResultMap batchin(HousetagCustomer housetag, Building building, Price price, String apartmentname,
			House house, String batchhouse, Area area, Long tribeid, Village village, Long userid, String propertyname,
			String filePath, String brand, String preparatory) {
		if (batchhouse == null || "".equals(batchhouse)) {
			return ResultMap.build(400, "数据格式不对");
		}
		if (userid == null) {
			return ResultMap.build(400, "请登录后在发布房源！");
		}
		if (house.getBrandid() == -1) {
			house.setBrandid(null);
		}
		// 设置房间类型的关联 -别墅 -二手房 - 写字楼等等
		Integer propertyId = propertyService.selectIDbyPropertyName(propertyname);
		if (propertyId != null && !"".equals(propertyname)) {
			house.setProperty_id(propertyId);
		}
		// 设置图片的地址
		house.setPicture(filePath);
		ResultMap resultMap = houseService.batchhouse(building, price, house, village, userid, housetag, propertyname,
				apartmentname, brand, batchhouse, preparatory);
		return resultMap;
	}
*/
	/**
	 * 发布房源信息 出售
	 * @param house_number  : 房号
	 * @param userid  : 发布人ID
	 * @param housetitle  : 标题
	 * @param code  : 区域code
	 * @param villagename  : 小区名称
	 * @param villageid : 小区ID
	 * @param building : 楼栋名称
	 * @param apartmentname  : 户型
	 * @param area : 面积
	 * @param redecorat : 装修类型
	 * @param paystyle : 支付方式
	 * @param livestyle  : 出租方式
	 * @param propertyname  : 房屋类型
	 * @param houstatus  : 1 出租
	 * @param housetag_id   : 标签ID
	 * @param landlord   : 房东
	 * @param landlordtel  : 房东电话
	 * @param contacts  : 联系人
	 * @param contactstel   : 联系人电话
	 * @param user_identity  : 房主/其他
	 * @param description    : 描述
	 * @param filePath  : 房源图片
	 * @param brand  : 品牌
	 * @param sex  :性别
	 * @param floor   : 楼层
	 * @param prices  : 价格
	 * @param tribeid  : 部落ID
	 */
	@RequestMapping(value = "/house/insertHouse2", produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResultMap insertHouse2(HousetagCustomer housetag, Building building, Price price, String apartmentname,
			House house, Village village, Long userid, String propertyname, String filePath, String brand) {

		if (userid == null) {
			return ResultMap.build(400, "请登录后在发布房源！");
		}

		// 设置图片的地址
		house.setPicture(filePath);
		// 设置房间类型的关联 -别墅 -二手房 - 写字楼等等
		Integer propertyId = propertyService.selectIDbyPropertyNameSale(propertyname);
		if (CheckDataUtil.checkisEmpty(propertyId)) {
			return ResultMap.build(400,"检查发布类型");
		}
		house.setProperty_id(propertyId);
		return houseService.publishsale(building, price, house, village, userid, housetag, propertyname, apartmentname,
				brand);

	}

	/**
	 * 主页一加载 每一类型的加1
	 */
	@RequestMapping(value = "/house/searchByIndex")
	@ResponseBody
	public ResultMap findHouseByIndex(HouseVo houseVo) {
		LinkedList<HouseCustomer> houseList = houseService.findHouseByIndex(houseVo);
		HouseCustomer ss = new HouseCustomer();
		for (int i = 0; i < houseList.size(); i++) {
			if (i == 1) {
				ss = houseList.get(1);
				houseList.remove(i);
				break;
			}
		}
		houseList.addLast(ss);
		Map<String, Object> map = new HashMap<>();
		HouseCustomer onebarnd = houseService.findonebarnd(houseVo);
		if (onebarnd != null) {
			onebarnd.setPropertyname("品牌公寓");
			houseList.addFirst(onebarnd);
		}
		// 截取地址
		suplitDetails(houseList);
		map.put("indexList", houseList);
		return ResultMap.IS_200(map);
	}

	/**
	 * 附近房源
	 * 
	 * @param userid   : 用户ID
	 * @param city  : 城市名称
	 * @param addressCustomer.nearLongitude  : 经度
	 * @param addressCustomer.nearLatude  : 纬度
	 */
	@RequestMapping(value = "/house/findHouseBySize")
	@ResponseBody
	public ResultMap findHouseBySize(String city, HouseVo houseVo, @RequestParam(defaultValue = "0") Integer currentpage,
			HttpServletRequest request, @RequestParam(defaultValue = "7") int pagesize) {
		// TDDTO city = "深圳";
		Map<String, Object> map = new HashMap<>();
		// 通过城市获取到code
		Long likecode = villageService.getcodebycity(city);
		houseVo = houseVo != null ? houseVo : new HouseVo();
		if (CheckDataUtil.checkisEmpty(likecode)) {return ResultMap.build(400, "参数不全");}
		PageQuery pagequery = new PageQuery();
		pagequery.setPagesize(pagesize);
		pagequery.setCurrentpage(currentpage);
		SearchResult result  = houseService.findHouseBySize(likecode,houseVo.getAddressCustomer()
				,houseVo.getUserid(),pagequery);
		int infoCount =result.getRecordCount();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<HouseCustomer> houseList = result.getHouselist();
		// 截取地址 和查询佣金
		suplitDetails(houseList);
		map.put("pagequery", pagequery);
		map.put("citycode", likecode);
		map.put("nearList", houseList);
		return ResultMap.IS_200(map);
	}

	// 吧对应的佣金设置在房子上面
	private void setPreList(List<HouseCustomer> houseList, List<PreparatoryCustomer> preList) {
		for (HouseCustomer house : houseList) {
			if (house.getBuilding().contains(house.getVillagename())) {
				house.setIdentity(house.getBuilding());
			}else {
				house.setIdentity(house.getVillagename() + house.getBuilding());
			}
			
			List<PreparatoryCustomer> addList = new ArrayList<>();
			for (PreparatoryCustomer pre : preList) {
				// 说明这个佣金在房子上面
				if (pre.getHouseid() == house.getHouseid().longValue()) {
					addList.add(pre);
				}
			}
			house.setPreList(addList);
		}
	}

	// 截取地址
	private List<Long> suplitDetails(List<HouseCustomer> houseList) {

		List<Long> houseids = new ArrayList<>();

		if (!houseList.isEmpty() && houseList.size() > 0) {
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
				if (CheckDataUtil.checkisEmpty(house.getApartmentname())) {
					house.setApartmentname(house.getArea() + "㎡");
				}
				houseids.add(house.getHouseid());
			}
		}
		return houseids;
	}


	/**
	 * 查看房屋详情
	 * 
	 * @param houseid  : 房源ID
	 * @param userid  : 用户ID
	 * @param checktype   : -1 表示微信分享
	 */
	@RequestMapping(value = "/house/Details/{type}")
	@ResponseBody
	public ResultMap findHouseDetails(Long houseid,Long userid, Browse browse, @PathVariable Integer type, String checktype,
			@RequestParam(defaultValue = "1") Integer currentpage, @RequestParam(defaultValue = "8") int pagesize) {
		
		// 如果是正常登录的
		if (CheckDataUtil.checkNotEmpty(userid)) {
			ResultMap checkmap = inteService.consumebranch(2L, userid, houseid);
			if (checkmap.getCode() !=200) {return checkmap;}
		}
		
		// 查看浏览的总数
		HouseCustomer house = houseService.findHouseDetails(houseid ,type ,userid);
		if (CheckDataUtil.checkisEmpty(house)) {return ResultMap.build(400, "参数异常或者房源不存在");}
		// 根据房子的标签查询
		List<Housetag> houseHag = new ArrayList<>();
		if (CheckDataUtil.checkNotEmpty(house.getHousetag_id())) {
			houseHag = housertargService.getTargByHouseTargId(house.getHousetag_id());
		}
				
		// 同小区房源
		PageQuery villagepagequery = new PageQuery();
		villagepagequery.setCurrentpage(currentpage);
		villagepagequery.setPagesize(pagesize);
		SearchResult villresult = houseService.searchVillageHouseorBuildingHouse(null, house.getVillageid(), villagepagequery);
		int villcount = villresult.getRecordCount();
		List<HouseCustomer> villagehouseList = villresult.getHouselist();
		villagepagequery.setPageParams(villcount, pagesize, currentpage);
		suplitDetails(villagehouseList);

		// 本栋楼房源
		PageQuery buildingpagequery = new PageQuery();
		buildingpagequery.setCurrentpage(currentpage);
		buildingpagequery.setPagesize(pagesize);
		SearchResult builresult = houseService.searchVillageHouseorBuildingHouse(house.getBuildingid(), null, buildingpagequery);
		int builcount = builresult.getRecordCount();
		List<HouseCustomer> buildinghouseList = builresult.getHouselist();
		buildingpagequery.setPageParams(builcount, pagesize, currentpage);
		suplitDetails(buildinghouseList);

		Map<String, Object> map = new HashMap<>();
		map.put("count", house.getBcount());
		map.put("house1", house);
		map.put("villagehouseList", villagehouseList);
		map.put("tagList", houseHag);
		map.put("villagepagequery", villagepagequery);
		map.put("buildinghouseList", buildinghouseList);
		map.put("buildingpagequery", buildingpagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 搜索栏下面写死的类别的搜索 和首页查看更多
	 * 
	 * @param propertyCustomer.propertyname : 房屋类型
	 * @param city : 城市名称的
	 * @param userid : 用户ID
	 */
	@RequestMapping(value = "/house/searchByCategory")
	@ResponseBody
	public ResultMap findHouseByCategory(String city, HouseVo houseVo,
			@RequestParam(defaultValue = "1") Integer currentpage, @RequestParam(defaultValue = "7") int pagesize) {

		// TDDTO city = "深圳";
		Long likecode = villageService.getcodebycity(city);
		VillageCustomer villageCutomer = houseVo.getVillageCustomer() ;
		if (CheckDataUtil.checkNotEmpty(villageCutomer.getLikecode())) {
			likecode = villageCutomer.getLikecode();
		}
		
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = propertyService.findHouseByCategory(houseVo.getPropertyCustomer()
				,pagequery , likecode ,houseVo.getAddressCustomer(),houseVo.getUserid());
		// 截取地址
		List<HouseCustomer> houseList = result.getHouselist();
		int infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize,currentpage);
		suplitDetails(houseList);
		Map<String, Object> map = new HashMap<>();
		map.put("houseList", houseList);
		map.put("citycode", likecode);
		map.put("querypage", pagequery);
		return ResultMap.IS_200(map);
	}


	/**
	 * 查询我的出租
	 * 
	 * @param userid   : 用户ID
	 */
	@RequestMapping("/house/myrent")
	@ResponseBody
	public ResultMap findmyrent(Long userid, @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {

		PageQuery pagequery = new PageQuery();
		int infocount = houseService.findmyrentCount(userid);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<HouseCustomer> myrent = houseService.findmyrent(userid, pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("myrent", myrent);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 查询我的出售
	 * 
	 * @param userid
	 *            : 用户ID
	 */
	@RequestMapping("/house/mysall")
	@ResponseBody
	public ResultMap findmysall(Long userid) {
		List<HouseCustomer> mysall = houseService.findmysall(userid);
		Map<String, Object> map = new HashMap<>();
		map.put("mysall", mysall);
		return ResultMap.IS_200(map);
	}

	/**
	 * 我的出租的小区搜索的列表
	 * 
	 * @param userid  : 用户ID
	 * @param request
	 * @param Response
	 * @return
	 */
	@RequestMapping(value = "/house/searchByVillage2")
	@ResponseBody
	public ResultMap findHouseByVillage2(Long userid, Long buildingid,
			@RequestParam(defaultValue = "0") Integer currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		//非空校验
		if (CheckDataUtil.checkisEmpty(userid) || CheckDataUtil.checkisEmpty(buildingid)) {
			return ResultMap.build(400,"数据不全");
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = houseService.findHouseByVillage2(userid,buildingid,pagequery);
		List<HouseCustomer> houseList = result.getHouselist();
		Integer infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		Map<String, Object> map = new HashMap<>();
		map.put("houseList", houseList);
		map.put("pagequery", pagequery);
		return ResultMap.build(1, "房源...", map);
	}

	/**
	 * 修改房屋状态
	 */
	@RequestMapping(value = "/house/updateHousestatus")
	@ResponseBody
	public ResultMap updateHousestatus(Long houseid, String housestatus) {
		houseService.updateHousestatus(houseid, housestatus);
		return ResultMap.IS_200();
	}

	// 编辑的查询
	@RequestMapping(value = "/edit/editsearch/{type}")
	@ResponseBody
	public ResultMap editsearch(Long editid, @PathVariable Integer type) {

		if (type == 1) {
			HouseCustomer house = houseService.findHouseDetails(editid,type,null);
			// 查询规则的数组
			List<PreparatoryCustomer> preList = houseService.preparList(editid);
			if (CheckDataUtil.checkisEmpty(house)) 
				{return ResultMap.build(400, "未知房源");}
			String ids = house.getHousetag_id();
			if (!"".equals(ids) && ids != null) {
				String[] str = ids.split(",");
				for (int i = 0; i < str.length; i++) {
					if ("9".equals(str[i])) {
						house.setSexName("男");
					}
					if ("10".equals(str[i])) {
						house.setSexName("女");
					}
					if ("11".equals(str[i])) {
						house.setSexName("男女不限");
					}
					if ("12".equals(str[i])) {
						house.setSallType("整租");
					}
					if ("13".equals(str[i])) {
						house.setSallType("合租");
					}
					if ("14".equals(str[i])) {
						house.setSallType("床位");
					}
				}
			}
			house.setPreList(preList);
			return ResultMap.IS_200(house);
		}
		if (type == 2) {
			QiuzuCustomer qiuzu = qiuzuService.qiuzuDetail(editid, null, type);
			return ResultMap.IS_200(qiuzu);
		}
		if (type == 3) {
			BuyCustomer buy = buyService.findOneById(editid);
			return ResultMap.IS_200(buy);
		}
		return null;
	}

	/**
	 * 二手房的详情
	 * @param userid  : 用户ID
	 * @param houseid   : 房源ID
	 * @param type  : 业务类型
	 * @param currentpage  : 当前页码
	 * @param pagesize  : 每页显示的条数
	 */
	@RequestMapping(value = "/house/findoldandNearVillage/{type}")
	@ResponseBody
	public ResultMap findHouseByNearVillage(Long houseid, Long userid, @PathVariable Integer type,
			@RequestParam(defaultValue = "0") Integer currentpage, @RequestParam(defaultValue = "7") int pagesize) {

		if (CheckDataUtil.checkNotEmpty(userid)) {
			ResultMap resultMap = inteService.consumebranch(2L, userid, houseid);
			if (resultMap.getCode() != 200) {
				return resultMap;
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		// 查询二手房的详情的操作
		HouseCustomer houseCustomer = houseService.findHouseDetails(houseid , type,userid);

		// 同小区房源
		PageQuery villagepagequery = new PageQuery();
		villagepagequery.setCurrentpage(currentpage);
		villagepagequery.setPagesize(pagesize);
		SearchResult villresult = houseService.searchVillageHouseorBuildingHouse(null, houseCustomer.getVillageid(), villagepagequery);
		int villcount = villresult.getRecordCount();
		List<HouseCustomer> villagehouseList = villresult.getHouselist();
		villagepagequery.setPageParams(villcount, pagesize, currentpage);
		suplitDetails(villagehouseList);

		// 本栋楼房源
		PageQuery buildingpagequery = new PageQuery();
		buildingpagequery.setCurrentpage(currentpage);
		buildingpagequery.setPagesize(pagesize);
		SearchResult builresult = houseService.searchVillageHouseorBuildingHouse(houseCustomer.getBuildingid(), null, buildingpagequery);
		int builcount = builresult.getRecordCount();
		List<HouseCustomer> buildinghouseList = builresult.getHouselist();
		buildingpagequery.setPageParams(builcount, pagesize, currentpage);
		suplitDetails(buildinghouseList);

		map.put("count", houseCustomer.getBcount());
		map.put("oldhouse", houseCustomer);
		map.put("villagepagequery", villagepagequery);
		map.put("villagehouseList", villagehouseList);
		map.put("buildingpagequery", buildingpagequery);
		map.put("buildinghouseList", buildinghouseList);
		return ResultMap.IS_200(map);
	}

	/*private List<HouseCustomer> findHouseByNearVillage(HouseVo houseVo, String currentpage, int pagesize) {
		List<HouseCustomer> findHousetarding = houseService.findHousebycondition(houseVo);
		// 截取地址
		suplitDetails(findHousetarding);
		return findHousetarding;
	}*/

	@RequestMapping("/qunfa")
	@ResponseBody
	public ResultMap qunfa(String content, HttpServletRequest request) {
		if (content == null || "".equals(content)) {
			return ResultMap.build(400, "请输入群发的内容");
		}
		try {
			List<User> users = new ArrayList<>();
			User u1 = new User();
			u1.setTelephone(18316999864L);
			users.add(u1);
			User u2 = new User();
			u2.setTelephone(13714559748L);
			users.add(u2);
			User u3 = new User();
			u3.setTelephone(13824395439L);
			users.add(u3);
			User u4 = new User();
			u4.setTelephone(13714038879L);
			users.add(u4);
			User u5 = new User();
			u5.setTelephone(137140387879L);
			users.add(u5);
			for (User u : users) {
				SendMessage.qunfa(u.getTelephone(), content, request);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "群发异常");
		}
		return ResultMap.IS_200();
	}

	/**
	 * 获得附近的详情
	 * 
	 **/
	@ResponseBody
	@RequestMapping("/house/nearlist")
	public ResultMap getneardetail(HouseVo houseVo, @RequestParam(defaultValue = "0") Integer currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		Map<String, Object> map = new HashMap<>();
		SearchResult result = houseService.getneardetail(houseVo.getAddressCustomer(),houseVo.getHouseCustomer(),
				pagequery,houseVo.getUserid() ,houseVo.getOrderbyjuli() , houseVo.getOrderbytime());
		List<HouseCustomer> nearlist = result.getHouselist();
		int infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		map.put("nearlist", nearlist);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	// 构建房子编号
	@RequestMapping("/buildinghousecode")
	@ResponseBody
	public ResultMap buildinghousecode() {
		houseService.buildinghousecode();
		return null;
	}

	/**
	 * 查看房源扣除积分
	 * 
	 * @param houseid  : 房源ID
	 * @param userid : 用户ID
	 * @param type  : 业务类型
	 **/
	@RequestMapping("/searchhousedeletejinbi")
	@ResponseBody
	public ResultMap searchhousedeletejinbi(Long houseid, Long userid, String type) {
		// 先校验基本信息
		if (houseid == null) {
			return ResultMap.build(500, "房源信息不存在");
		}
		if (userid == null) {
			return ResultMap.build(500, "登录信息空");
		}
		ResultMap resultMap = inteService.searchphonedeletejinbi(houseid, userid, type);
		return resultMap;
	}

	/***
	 * 查询房源预定信息
	 **/
	@RequestMapping("/searchhouseyudingmess")
	@ResponseBody
	public ResultMap getHouseYudingMess(Long houseid) {
		if (houseid == null) {
			return ResultMap.build(400, "房源ID不为空");
		}
		HouseCustomer houseCustomer = houseService.getHouseYudingMess(houseid);
		String cycleName =null;
		PreparatoryCustomer preparatory = housertargService.getTraName(houseid);
		if (CheckDataUtil.checkNotEmpty(preparatory)) {
			cycleName = preparatory.getType();
			houseCustomer.setCentpercentnum(preparatory.getCentpercentnum());
			houseCustomer.setLandpercentnum(preparatory.getLandpercentnum());
		}else {
			houseCustomer.setCentpercentnum(0.0);
			houseCustomer.setLandpercentnum(0.0);
		}
		cycleName = cycleName == null ? "不限" : cycleName;
		houseCustomer.setCycleName(cycleName);
		return ResultMap.IS_200(houseCustomer);
	}

	/**
	 * 查询房源订单列表
	 **/
	@RequestMapping("/searchhouselist")
	@ResponseBody
	public ResultMap searchhouselist(Long userid, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		int infoCount = houseService.searchhouselistCount(userid);
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		List<HouseOrderCustomer> orderlist = houseService.searchhouselist(userid, pagequery);
		map.put("pagequery", pagequery);
		map.put("orderlist", orderlist);
		return ResultMap.IS_200(map);
	}

	/**
	 * 查询待确认列表
	 **/
	@RequestMapping("/searchSureHousePay")
	@ResponseBody
	public ResultMap searchSureHousePay(Long userid, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		if (userid == null) {
			return ResultMap.build(400, "此操作需要登录");
		}
		Map<String, Object> map = new HashMap<>();
		int infoCount = houseService.searchSureHousePayCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		List<HouseOrderCustomer> orderList = houseService.searchSureHousePay(userid, pagequery);
		map.put("pagequery", pagequery);
		map.put("orderList", orderList);
		return ResultMap.IS_200(map);
	}

	/** 查询 **/
	@RequestMapping("/houseorderdetail")
	@ResponseBody
	public ResultMap houseorderdetail(Long userid, Long houseid) {
		if (userid == null || houseid == null) {
			return ResultMap.build(400, "参数");
		}
		Houseorder houseorder = houseService.houseorderdetail(userid, houseid);
		return ResultMap.IS_200(houseorder);
	}

	/** 移除房源预定 **/
	@RequestMapping("/removehouseorder")
	@ResponseBody
	public ResultMap removehouseorder(Long userid, Long houseorderid) {
		if (userid == null || houseorderid == null) {
			return ResultMap.build(400, "参数不全");
		}
		return houseService.updatehouseorder(userid, houseorderid, 3, "");
	}

	/** 确认房源预定 **/
	@RequestMapping("/surehouseorder")
	@ResponseBody
	public ResultMap surehouseorder(Long userid, Long houseorderid) {
		if (userid == null || houseorderid == null) {
			return ResultMap.build(400, "参数不全");
		}
		return houseService.updatehouseorder(userid, houseorderid, 4, "");
		// houseService.updatehouseorder(userid, houseid, 4 ,"");
		// return ResultMap.build(200, "操作成");
	}

	/** 根据ID 预订协议 **/
	@RequestMapping("/searchpararulebyid")
	@ResponseBody
	public ResultMap searchpararulebyid(Integer pararuleid) {
		Pararule pararule = housertargService.searchpararulebyid(pararuleid);
		return ResultMap.IS_200(pararule);
	}

	/** 查询预订规则列表 **/
	@RequestMapping("/paraulelist")
	@ResponseBody
	public ResultMap paraulelist() {
		List<Pararule> pararule = housertargService.searchpararuleList();
		return ResultMap.IS_200(pararule);
	}

	/** 编辑预订规则列表 **/
	@RequestMapping("/updatepararule")
	@ResponseBody
	public ResultMap updateparaule(Pararule pararule) {
		try {
			String str = new String(pararule.getPararuledetail().getBytes(), "utf-8");
			pararule.setPararuledetail(str);
			housertargService.updateparaule(pararule);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ResultMap.IS_200();
	}

	/** 根据订单ID查询待确认的信息 **/
	@RequestMapping("/searchorderpay")
	@ResponseBody
	public ResultMap searchorderpay(Long houseorderid) {
		if (houseorderid == null) {
			return ResultMap.build(400, "输入订单ID");
		}
		HouseOrderCustomer houseCustomer = houseService.searchorderpay(houseorderid);
		if (houseCustomer == null) {
			return ResultMap.build(400, "订单不存在");
		}
		boolean flag = IDUtils.threedaysafter(houseCustomer.getOrdertime());
		houseCustomer.setFlag(flag);
		String cycleName =null;
		PreparatoryCustomer preparatory = housertargService.getTraName(houseCustomer.getHouseid());
		if (CheckDataUtil.checkNotEmpty(preparatory)) 
			cycleName = preparatory.getType();
		cycleName = cycleName == null ? "不限" : cycleName;
		houseCustomer.setCycleName(cycleName);
		return ResultMap.IS_200(houseCustomer);
	}

}
