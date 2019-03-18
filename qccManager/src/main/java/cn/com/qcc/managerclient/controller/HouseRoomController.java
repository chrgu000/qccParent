package cn.com.qcc.managerclient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.FurnitureCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.RentmodalCustomer;
import cn.com.qcc.service.HouseRoomService;
import cn.com.qcc.service.HouseService;

@Controller
@RequestMapping("/companion")
public class HouseRoomController {

	@Autowired
	HouseService houseService;
	
	@Autowired
	HouseRoomService houseRoomService;
	
	
	@RequestMapping("/deletehousebile")
	@ResponseBody
	public ResultMap deletehousebile (Long userid , String housepayIds) {
		
		return houseRoomService.deletehousebile(userid , housepayIds);
		
	}
	
	
	// 根据查询条件查询房态图
	@RequestMapping("/roompattern")
	@ResponseBody
	public ResultMap roompattern(@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "12") int pagesize, HouseVo houseVo) {
		
		String inUserIds = houseRoomService.getInUserIds(houseVo.getUserid());
		if (CheckDataUtil.checkisEmpty(inUserIds)) {
			return ResultMap.build(400, "你已经被移出管理或者房东");
		}
		houseVo.setInUserIds(inUserIds);
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = houseRoomService.roompatternCount(houseVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		List<HouseRoomCustomer> houselist = houseRoomService.roompattern(houseVo);
		map.put("pagequery", pagequery);
		map.put("houselist", houselist);
		return ResultMap.IS_200(map);
	}
	
	
	
	/*
	 * 房东发布租约
	 */
	@RequestMapping("/usercent")
	@ResponseBody
	public ResultMap usercent(Usercent usercent,Mycent mycent,HttpServletRequest request,
			String othermore,String payid,String paycentid,String othermoreid1,String othermoreid2,
		String pricestype,String islinecent) {
		ResultMap resultMap = houseRoomService.usercent(usercent, mycent, request, othermore,  payid, paycentid, pricestype,othermoreid1,othermoreid2,islinecent);
		return resultMap;
	}
	
	

	

	// 获取支付方式类型计算租金押金倍数
	@RequestMapping("/paymodals")
	@ResponseBody
	public ResultMap paymodals() {
		List<Paymodal> paymodals = houseService.paymodals();
		return ResultMap.IS_200(paymodals);
	}

	// 设置收租日计算收租的日期
	@RequestMapping("/collectrents")
	@ResponseBody
	public ResultMap collectrents() {
		List<RentmodalCustomer> rents = houseService.collectrents();
		return ResultMap.IS_200(rents);
	}

	// 查询其他费用 [租约登记时候]
	@RequestMapping("/otherprices")
	@ResponseBody
	public ResultMap otherprices() {
		List<RentmodalCustomer> otherprices = houseService.otherprices();
		return ResultMap.IS_200(otherprices);
	}

	// 查询附加合同总分类
	@RequestMapping("/furniturelist")
	@ResponseBody
	public ResultMap furniturelist() {
		List<FurnitureCustomer> furniturelist = houseService.furniturelist();
		return ResultMap.IS_200(furniturelist);
	}

	// 查询附加合同总分类
	@RequestMapping("/furnituredetaillist")
	@ResponseBody
	public ResultMap furnituredetaillist(Long furnitureid) {
		List<FurnitureCustomer> furniturelist = houseService.furnituredetaillist(furnitureid);
		return ResultMap.IS_200(furniturelist);
	}
	
	//催租表
	@RequestMapping("/needpaycentlist")
	@ResponseBody
	public ResultMap needpaycentlist(HouseCustomer houseCustomer) {
		List<HouseCustomer> needpaycentlist = houseService.needpaycentlist(houseCustomer);
		return ResultMap.IS_200(needpaycentlist);
	}
	
	//查询出房源对应的区域分组
	@RequestMapping("/getlandareaname")
	@ResponseBody
	public ResultMap getlandareaname(BuildingCustomer buildingCustomer) {
		List<BuildingCustomer> getlandareaname = houseRoomService.getlandareaname(buildingCustomer);
		return ResultMap.IS_200(getlandareaname);
	}
	
	//查询出房东对应的楼栋详情地址
	@RequestMapping("/getlandbuildingname")
	@ResponseBody
	public ResultMap getlandbuildingname(BuildingCustomer buildingCustomer) {
		List<BuildingCustomer> getlandareaname = houseRoomService.getlandbuildingname(buildingCustomer);
		return ResultMap.IS_200(getlandareaname);
	}
	
	//根据房东ID 和楼栋ID查询对应的房源
	@RequestMapping ("/housebybuildingid")
	@ResponseBody
	public ResultMap housebybuildingid (HouseCustomer houseCustomer) {
		List<HouseCustomer> houses = houseService.housebybuildingid(houseCustomer);
		return ResultMap.IS_200(houses);
	}
	
	//房东发起退房操作
	@RequestMapping ("/roomoutsearch")
	@ResponseBody
	public ResultMap roomoutsearch (Long houseid) {
		HouseCustomer houseCustomer  = houseRoomService.roomoutsearch(houseid);
		return ResultMap.IS_200(houseCustomer);
	}
	
	//进行退房
	@RequestMapping ("/roomout")
	@ResponseBody
	public ResultMap roomout (Long houseid) {
		ResultMap resultMap = houseRoomService.roomout(houseid);
		return resultMap;
	}

}
