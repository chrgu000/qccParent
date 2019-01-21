package cn.com.qcc.tenement.controller;
import java.util.ArrayList;
import java.util.HashMap;
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
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Browse;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Rental;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.Villagetype;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.BrowerCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.SearchModal;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class VillageController {
	
	@Autowired VillageService villageService;
	@Autowired BrowseService browseService;
	@Autowired HouseService houseService;
	@Autowired UserService userService;
	@Autowired InteService inteService;
	
	@RequestMapping("/searchBuildingByVillageid")
	@ResponseBody
	public ResultMap searchBuildingByVillageId(Long villageid
			,@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "8") int pagesize) {
		// 查询小区下面的楼栋
		int infocountbuil = villageService.searchBuildingbyVillageidCount(villageid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocountbuil, pagesize, Integer.parseInt(currentpage));
		List<BuildingCustomer> buildingList = villageService.searchBuildingbyVillageid(villageid ,pagequery);
		hebingjinweidu(buildingList);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("buildingList", buildingList);
		return ResultMap.IS_200(map);
	}
	
	@RequestMapping("/building/searchlike")
	@ResponseBody
	public ResultMap getsearchbyname (String code ,String searchname) {
		List<SearchModal> searchlike = new ArrayList<>();
		if (searchname == null || "".equals(searchname)) {
			return ResultMap.IS_200(searchlike);
		}
		 searchlike = villageService.searchlikevillage(code,searchname);
		
		return ResultMap.IS_200(searchlike);
	}
	
	
	/**
	 * 查询公租房的申请条件
	 * **/
	@RequestMapping("/village/searchrentalcontent")
	@ResponseBody
	public ResultMap searchrentalcontent(String city) {
		// 通过城市获取到code
		if (city == null || "".equals(city)) {
			return ResultMap.build(400, "无数据");
		}
		Long citycode = villageService.getcodebycity(city);
		Rental search = villageService.searchrentbycode(citycode);
		if (search == null) {return ResultMap.build(400, "无数据");}
		return ResultMap.IS_200(search);
	}
	
	/**
	 * 发布界面显示所有小区name
	 * 
	 */
	@RequestMapping(value = "/house/findVillage")
	@ResponseBody
	public List<VillageCustomer> findAllVillage(VillageeVo villageeVo) {
		List<VillageCustomer> villageList = villageService.findAllVillage(villageeVo);
		return villageList;
	}

	/**
	 * 发布界面显示小区building下滑列表
	 */
	@RequestMapping(value = "/house/findBuildingListByVillage")
	@ResponseBody
	public ResultMap findBuildingListByVillage(VillageeVo villageeVo) {
		List<VillageCustomer> villageList = villageService.findBuildingListByVillage(villageeVo);
		Map map = new HashMap();
		map.put("villageList", villageList);
		return ResultMap.IS_200(map);
	}

	// 发布小区
	@RequestMapping("/comm/updateorsavecomm")
	@ResponseBody
	public ResultMap addorupdateCommunity(Village village, Detaileaddress detaileaddress) {
		ResultMap result = villageService.saveVillage(village, detaileaddress);
		return result;
	}

	// 发布栋楼
	@RequestMapping("/comm/updateorsavebuild")
	@ResponseBody
	public ResultMap updateorsavebuild(Village village, Building building, Detaileaddress detaileaddress,String brand) {
		ResultMap result = villageService.savebuild(village, building, detaileaddress,brand);
		return result;
	}

	// 小区的列表
	@RequestMapping("/comm/commlist")
	@ResponseBody
	public ResultMap searchVillageList(String city, VillageeVo villageeVo, Long userid,
			@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		// TDDTO   city = "深圳";
		
		// 通过城市获取到code
		Long citycode = villageService.getcodebycity(city);
		Long likecode = null;
		villageeVo = villageeVo != null ? villageeVo : new VillageeVo();
		VillageCustomer villageCutomer = villageeVo.getVillageCustomer() != null ? villageeVo.getVillageCustomer()
				: new VillageCustomer();
		villageCutomer.setState(1);
		if (villageCutomer.getLikecode() == null || "".equals(villageCutomer.getLikecode())) {
			villageCutomer.setLikecode(citycode);
		} else {
			likecode = villageCutomer.getLikecode();
		}
		if (likecode == null) {
			likecode = citycode;
		}

		villageeVo.setVillageCustomer(villageCutomer);
		int infocount = villageService.searchCommlistCount(villageeVo);
		PageQuery pagequery = new PageQuery();
		villageeVo.setPagequery(pagequery);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<VillageCustomer> commlist = villageService.searchCommlist(villageeVo);

		// 拼接地址
		splitcommon(commlist);
		Map<String, Object> map = new HashMap<>();
		map.put("commlist", commlist);
		map.put("citycode", citycode);
		map.put("likecode", likecode);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	
	private void splitcommon(List<VillageCustomer> commlist) {
		String str = "";
		for (VillageCustomer comm : commlist) {
			str = (comm.getDistrict() == null ? "" : comm.getDistrict())
					+ (comm.getTrading() == null ? "" : comm.getTrading());
			comm.setDistrict(str);
		}
	}

	// 小区详情
	@RequestMapping("/comm/villagedetail/{type}")
	@ResponseBody
	public ResultMap villagedetail(Long communityid, Browse browse, @PathVariable Integer type, String checktype,
			@RequestParam(defaultValue = "0") Integer currentpage, @RequestParam(defaultValue = "8") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		// 小区详情
		VillageCustomer villageDetail = villageService.searchCommById(communityid);
		if (villageDetail == null) { return ResultMap.build(400, "小区不存在");}
		Long searchtype = 4L;
		String rentpicture = "";
		// 如果是公租房小区
		if (villageDetail.getVillagetypeid() !=null ) {
			if (villageDetail.getVillagetypeid() == 2) {
				// 查询公祖房图片
				String searchcode = villageDetail.getCode()+"";
				String codeone = searchcode.substring(0,2);
				String codetwo = searchcode.substring(0,4);
				searchtype = 5l;
				rentpicture = villageService.searchrentpicture(codeone , codetwo );
			}
		}
		
		
		// 这里做扣除积分处理
		if (browse.getUserid() !=null && !("-1".equals(checktype))) {
			if (villageDetail.getUserid() != browse.getUserid()) {
				ResultMap resultMap = inteService.consumebranch(searchtype, browse.getUserid() ,communityid);
				if (resultMap.getCode() !=200) {return resultMap;}
			}
		}
		
		// 这里查剩余积分
		Long  surplus = inteService.searchless(browse.getUserid());
		Long userid = villageDetail.getUserid();
		villageDetail.setLikecode(villageDetail.getCode());
		// 查看浏览的总数
		BrowerCustomer browerCustomer = browseService.countone(type, communityid);
		
		// 查询小区下面的楼栋
		int infocountbuil = villageService.searchBuildingbyVillageidCount(communityid);
		PageQuery builpagequery = new PageQuery();
		builpagequery.setPageParams(infocountbuil, 2000, currentpage);
		List<BuildingCustomer> buildingList = villageService.searchBuildingbyVillageid(villageDetail.getVillageid() ,builpagequery);
		hebingjinweidu(buildingList);
		//已经登录的用户做浏览量
		if (browse.getUserid() !=null) {
			browse.setFollowUserId(villageDetail.getUserid());
			browse.setTitle("小区浏览");
			browse.setOtherid(communityid);
			// 添加次数
			//browseService.addBrowse(browse, type);
		}
		
		
		
		
		
		// 同小区房源
		PageQuery housepagequery = new PageQuery();
		housepagequery.setCurrentpage(currentpage);
		housepagequery.setPagesize(pagesize);
		SearchResult result = houseService.searchVillageHouseorBuildingHouse(null, communityid, housepagequery);
		int infocount = result.getRecordCount();
		List<HouseCustomer> houseList = result.getHouselist();
		housepagequery.setPageParams(infocount, pagesize, currentpage);
		// 截取地址
		suplitDetails(houseList);
		map.put("count", browerCustomer.getBcount());
		map.put("buildingList", buildingList);
		map.put("surplus", surplus);
		map.put("houseList", houseList);
		map.put("nearvillage", houseList);
    	map.put("rentpicture", rentpicture);
    	map.put("housepagequery", housepagequery);
    	map.put("builpagequery", builpagequery);
    	villageDetail.setUserid(userid);
    	map.put("community", villageDetail);
		return ResultMap.IS_200(map);
	}

	/*private List<HouseCustomer> findHouseByNearVillage(VillageCustomer community, String currentpage, int pagesize) {
		VillageeVo villageVo = new VillageeVo();
		community.setLikecode(null);
		community.setCode(null);
		community.setUserid(null);
		villageVo.setVillageCustomer(community);
		List<HouseCustomer> findHousetarding = villageService.searchhouseList(villageVo);
		// 截取地址
		suplitDetails(findHousetarding);
		return findHousetarding;
	}*/

	private void hebingjinweidu(List<BuildingCustomer> buildingList) {
		for (BuildingCustomer building : buildingList) {
			building.setLatitude(building.getLongitude() + "," + building.getLatitude());
		}
	}

	// 截取地址
	private void suplitDetails(List<HouseCustomer> houseList) {
		for (HouseCustomer house : houseList) {
			String str = "";
			if (house.getVillagename() == null || house.getBuilding() == null) {
				str = (house.getCity() == null ? "" : house.getCity())
						+ (house.getDistrict() == null ? "" : house.getDistrict())
						+ (house.getTrading() == null ? "" : house.getTrading());
			} else {
				str = (house.getTrading() == null ? "" : house.getTrading())
						+ (house.getVillagename() == null ? "" : house.getVillagename())
						+ (house.getBuilding() == null ? "" : house.getBuilding());
			}

			house.setDetailes(str);
		}

	}

	// 楼栋的列表
	@RequestMapping("/comm/buildinglist")
	@ResponseBody
	public ResultMap searchBuildingList(String city, VillageeVo villageeVo,
			@RequestParam(defaultValue = "1") Integer currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		
		// 通过城市获取到code
		Long likecode = villageService.getcodebycity(city);
		map.put("citycode", likecode);
		VillageCustomer villageCustomer = villageeVo.getVillageCustomer();
		if (CheckDataUtil.checkNotEmpty(villageCustomer.getLikecode())) {
			likecode = villageCustomer.getLikecode();
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = villageService.searchBuilindgList(likecode,villageeVo.getJuli() ,villageeVo.getBuildingCustomer(),
				villageeVo.getApartmentCustomer() , villageeVo.getHouseCustomer() , villageeVo.getHousetagCustomer()
				,villageCustomer,villageeVo.getMetro(),villageeVo.getAddressCustomer(),pagequery );
		List<BuildingCustomer> builList = result.getBuildinglist();
		int infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, currentpage);
		map.put("buildinglist", builList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	// 楼栋详情列表
	@RequestMapping("/comm/buildingdetail/{type}")
	@ResponseBody
	public ResultMap buildingdetail(Long banid, Long userid, @PathVariable Integer type,String path,
			@RequestParam(defaultValue = "0") Integer currentpage, @RequestParam(defaultValue = "8") int pagesize) {
		
		
		Map<String, Object> map = new HashMap<>();
		BuildingCustomer buildingCustomer = villageService.searchbuildingbyid(banid , userid ,type);
		if (CheckDataUtil.checkisEmpty(buildingCustomer)) {return ResultMap.build(400, "参数异常");}
		// 查询本楼栋房源
		PageQuery buildingpagequery = new PageQuery();
		buildingpagequery.setCurrentpage(currentpage);
		buildingpagequery.setPagesize(pagesize);
		SearchResult builresult = houseService.searchVillageHouseorBuildingHouse(banid, null,buildingpagequery);
		int builcount = builresult.getRecordCount();
		List<HouseCustomer> buildinghouseList = builresult.getHouselist();
		buildingpagequery.setPageParams(builcount, pagesize, currentpage);
		splittarg(buildinghouseList);
		suplitDetails(buildinghouseList);
		
		// 查询本小区房源
		PageQuery villagepagequery = new PageQuery();
		villagepagequery.setCurrentpage(currentpage);
		villagepagequery.setPagesize(pagesize);
		SearchResult villresult = houseService.searchVillageHouseorBuildingHouse(null, buildingCustomer.getVillageid(),buildingpagequery);
		int villinfocount = villresult.getRecordCount();
		List<HouseCustomer> villagehouseList = villresult.getHouselist();
		villagepagequery.setPageParams(villinfocount, pagesize, currentpage);
		// 处理前台的标签问题
		splittarg(villagehouseList);
	    suplitDetails(villagehouseList);
		
	    map.put("villagehouseList", villagehouseList);
	    map.put("villagepagequery", villagepagequery);
		map.put("buildingpagequery", buildingpagequery);
		map.put("count", buildingCustomer.getBcount());
		map.put("buildinghouseList", buildinghouseList);
		map.put("banCustomer", buildingCustomer);
		return ResultMap.IS_200(map);
	}

	private void splittarg(List<HouseCustomer> houselist) {
		for (HouseCustomer house : houselist) {

			if ("房源".equals(house.getPropertyname())) {
				house.setPropertyname(house.getApartmentname());
			}

		}
	}

	// 根据code查询小区基本信息
	@ResponseBody
	@RequestMapping("/tribe/getvillagebycode")
	public ResultMap getvillagebycode(Long code) {
		List<Village> villagelist = villageService.getvillagebycode(code);
		return ResultMap.IS_200(villagelist);
	}

	// 根据code查询小区基本信息
	@ResponseBody
	@RequestMapping("/village/simplevillagedetail")
	public ResultMap simplevillagedetail(Long villageid) {
		Village villagelist = villageService.simplevillagedetail(villageid);
		return ResultMap.IS_200(villagelist);
	}

	@ResponseBody
	@RequestMapping("/village/updatebyid")
	public ResultMap villageupdatebyid(HttpServletRequest request, Village village) {
		ResultMap resultMap = villageService.villageupdatebyid(village);
		return resultMap;
	};

	// 获取基本的buildinglist
	@ResponseBody
	@RequestMapping("/village/getbuildinglistbyvid")
	public ResultMap getbuildinglistbyvid(Long villageid, Long userid) {
		ResultMap resultMap = villageService.getbuildinglistbyvid(villageid, userid);
		return resultMap;
	}

	// 删除楼栋
	@RequestMapping("/village/deletebuidilding")
	@ResponseBody
	public ResultMap deletebuidilding(Long buildingid) {
		villageService.deletebuidilding(buildingid);
		return ResultMap.IS_200();
	}

	// 获取楼栋的详情信息
	@ResponseBody
	@RequestMapping("/village/simplebuildingdetail")
	public ResultMap getbuildingdetail(Long buildingid) {
		Building buildings = villageService.getsimplebuilding(buildingid);
		return ResultMap.IS_200(buildings);
	}

	// 编辑楼栋
	@RequestMapping("/village/updatebuilding")
	@ResponseBody
	public ResultMap updatebuilding(HttpServletRequest request, Building building,String detailes) {
		ResultMap resultMap = villageService.updatebuilding(building ,detailes);
		//说明楼栋编辑成功了
		if (resultMap.getCode() == 200) {
			//这里需要同步房源的品牌
			//如果楼栋编辑成有品牌
			if (building.getBrandid() !=null) {
				//需要把房子品牌置空
				houseService.deletebrandidbybuildingid(building.getBuildingid());
			}
			//如果楼栋编辑成无品牌需要需要把楼栋之前的品牌传给房源
			if (building.getBrandid() == null) {
				//封装更新参数
				HouseCustomer houseCustomer = new HouseCustomer();
				houseCustomer.setBrandid(( Long)resultMap.getObj());
				houseCustomer.setBuildingid(building.getBuildingid());
				houseService.addbrandidbybuildingid(houseCustomer);
			}
			
		}
		return resultMap;
	}

	// 统计楼栋发布
	@RequestMapping("/village/censusbuilding")
	@ResponseBody
	public ResultMap censusbuilding(String code) {
		List<UserCustomer> buildingCustomers = villageService.censusbuilding(code);
		Map<String, Object> map = new HashMap<>();
		map.put("buildings", buildingCustomers);
		return ResultMap.IS_200(map);
	}
	
	// 统计楼栋发布
	@RequestMapping("/village/censusvillage")
	@ResponseBody
	public ResultMap censusvillage(String code) {
		List<UserCustomer> buildingCustomers = villageService.censusvillage(code);
		Map<String, Object> map = new HashMap<>();
		map.put("buildings", buildingCustomers);
		return ResultMap.IS_200(map);
	}

	// 后台地图楼栋分布
	@RequestMapping("/village/fingbuildsmaps")
	@ResponseBody
	public ResultMap fingbuildsmaps(AddressCustomer addressCustomer) {
		Map<String, Object> map = new HashMap<>();
		List<BuildingCustomer> buildingCustomers = villageService.fingbuildsmaps(addressCustomer);
		map.put("buildings", buildingCustomers);
		return ResultMap.IS_200(map);
	};

	// 地图找楼栋
	@RequestMapping("/village/fingbuildsmap")
	@ResponseBody
	public ResultMap fingbuildsmap(VillageeVo villageid, String city) {
		// TDDTO     city = "深圳";
		
		// 通过城市获取到code
		Long citycode = villageService.getcodebycity(city);
		Long likecode = null;
		User user = null;
		BuildingCustomer buildingCustomer = villageid.getBuildingCustomer() == null ? new BuildingCustomer()
				: villageid.getBuildingCustomer();
		if (buildingCustomer.getCode() == null || "".equals(buildingCustomer.getCode())) {
			buildingCustomer.setCode(citycode+"");
		} else {
			
			likecode = Long.valueOf(buildingCustomer.getCode());
		}
		if (likecode == null) {
			likecode = citycode;
		}
		Map<String, Object> map = new HashMap<>();
		if (villageid.getUserid() != null) {
			user = userService.getUserByUserid(villageid.getUserid());
		}

		List<BuildingCustomer> buildingCustomers = villageService.fingbuildsmap(villageid);
		map.put("buildings", buildingCustomers);
		map.put("citycode", citycode);
		map.put("likecode", likecode);
		map.put("user", user);
		return ResultMap.IS_200(map);
	}

	// 地图找街道
	@RequestMapping("/village/fingtrandmap")
	@ResponseBody
	public ResultMap findtrindmap(String city, Long code) {
		// TDDTO    city = "深圳";
		

		Map<String, Object> map = new HashMap<>();
		List<BuildingCustomer> buildingCustomers = villageService.fingtrandmap(city, code);
		map.put("buildings", buildingCustomers);
		return ResultMap.IS_200(map);
	}

	// 地图找小区
	@RequestMapping("/village/fingvillagemap")
	@ResponseBody
	public ResultMap fingvillagemap(Long code) {
		Map<String, Object> map = new HashMap<>();
		List<BuildingCustomer> buildingCustomers = villageService.fingvillagemap(code);
		map.put("buildings", buildingCustomers);
		return ResultMap.IS_200(map);
	}

	// 一键维护地铁/building/updateallmetro
	@RequestMapping("/building/updateallmetro")
	@ResponseBody
	public ResultMap updateallmetro(Building builgng) {
		ResultMap resultMap = villageService.updateallmetro(builgng);
		return resultMap;
	}

	// 合并小区楼栋
	@RequestMapping("/building/megrobuildingandvillage")
	@ResponseBody
	public ResultMap megrobuildingandvillage() {
		List<BuildingCustomer> list = villageService.megrobuildingandvillage();
		return ResultMap.IS_200(list);
	}

	// 没有经纬度的小区更新一下经纬度
	@RequestMapping("/building/megrobvillage_detailid")
	@ResponseBody
	public ResultMap megrobvillage_detailid() {
		List<BuildingCustomer> list = villageService.megrobvillage_detailid(null);
		return ResultMap.IS_200(list);
	}

	// 根据经纬度查询附近的小区
	@RequestMapping("/building/nearvillage")
	@ResponseBody
	public ResultMap nearvillage(VillageeVo villageeVo) {
		VillageCustomer villageCustomer = villageeVo.getVillageCustomer() == null ? new VillageCustomer()
				: villageeVo.getVillageCustomer();
		if (villageCustomer.getLikecode() == null) {
			return ResultMap.build(400, "请检查你的地址！");
		}
		List<BuildingCustomer> list = villageService.nearvillage(villageeVo);
		return ResultMap.IS_200(list);
	}

	// 楼栋列表一键导入索引库
	@RequestMapping("/building/builidingtosolr")
	@ResponseBody
	public ResultMap builidingtosolr() {
		ResultMap resultMap = villageService.buildingtosolr();
		return resultMap;
	}

	// 截掉楼里多余的图片 [内部方法]
	@RequestMapping("/deletebuildingpath")
	@ResponseBody
	public ResultMap deleteMap() {
		ResultMap resultMap = villageService.deletesearch();
		return resultMap;
	}

	// 截掉房源里图片[内部方法]
	@RequestMapping("/deletehousepath")
	@ResponseBody
	public ResultMap deletehousepath() {
		ResultMap resultMap = villageService.deletehousepath();
		return resultMap;
	}

	// 处理楼栋编号[内部方法]
	@RequestMapping("/buildingnum")
	@ResponseBody
	public ResultMap buildingnum() {
		ResultMap resultMap = villageService.buildingnum();
		if (resultMap.getCode() == 200) {
			houseService.buildinghousecode();
		}
		return resultMap;

	}

	// 处理楼栋不符合的电话号码[内部方法]
	@RequestMapping("/buidingphone")
	@ResponseBody
	public ResultMap buidingphone() {
		ResultMap resultMap = villageService.buidingphone();
		return resultMap;

	}
	
	// 生成楼栋专属二维码[内部方法]
	@RequestMapping("/buildingxpx")
	@ResponseBody
	public ResultMap buildingxpx(Integer begin ,Integer end ) {
		ResultMap resultMap = villageService.buildingxpx(begin,end);
		return resultMap;
	}
	
	// 生成房源小程序二维码
	@RequestMapping("/housexpx")
	@ResponseBody
	public ResultMap housexpx( ) {
		ResultMap resultMap = villageService.housexpx();
		return resultMap;
	}
	
	// 生成房源小程序二维码
	@RequestMapping("/villagexpx")
	@ResponseBody
	public ResultMap villagexpx( ) {
		ResultMap resultMap = villageService.villagexpx();
		return resultMap;
	}
	
	// 生成房源小程序二维码
	@RequestMapping("/brokerxpx")
	@ResponseBody
	public ResultMap brokerxpx( ) {
		ResultMap resultMap = villageService.brokerxpx();
		return resultMap;
	}
	
	// [内部方法]
	@RequestMapping("/buildvillageid")
	@ResponseBody
	public ResultMap buildvillageid( ) {
		ResultMap resultMap = villageService.buildvillageid();
		return resultMap;
	}
	
	@RequestMapping("/searchvillagetype")
	@ResponseBody
	public ResultMap searchvillagetype( ) {
		List<Villagetype> villagetype  = villageService.searchvillagetype();
		return ResultMap.IS_200(villagetype);
	}
	
	
	//楼栋一键导入索引库
	@RequestMapping("/addbuildingtosolr")
	@ResponseBody
	public ResultMap addbuildingtosolr(int start , int end){
		System.out.println(start);
		System.out.println(end);
		PageQuery query = new PageQuery();
		query.setPagestart(start);
		query.setPageend(end);
		return villageService.addbuildngtosolr(null , query);
	}
	
	

}
