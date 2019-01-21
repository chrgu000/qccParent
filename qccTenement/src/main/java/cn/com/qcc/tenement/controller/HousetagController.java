package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.service.HousertargService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class HousetagController {

	@Autowired
	HousertargService housertargService;
	
	
	/**
	 * 根据catrgory 查询房源设备和基本信息之内
	**/
	@RequestMapping("/house/getTagbycategory")
	@ResponseBody
	public ResultMap getTargBycategory(String category ) {
		if (category == null || "".equals(category)) {return ResultMap.build(400, "输入类型");}
		List<Housetag> houseList = housertargService.getTargBycategory(category);
		for (int i = 0; i < houseList.size(); i++) {// 从第一个数开始，到最后一个数-1次循环
			for (int j = houseList.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Integer buil1 = houseList.get(i).getCategory();
				Integer buil2 = houseList.get(j).getCategory();
				Integer buil_end = buil1 - buil2;
				if (buil_end == 0) {
					houseList.get(j).setCategory_name("");
				}
			}
		}
		return ResultMap.IS_200(houseList);
	}
	
	/**
	 * 发布房屋提取公用设施给前台 ==================[此处应该是可以优化成一个方法
	 * ]=========================
	 * @param category_name : 房源基础设置名称
	 * @return
	 */
	@RequestMapping(value = "/house/insertHouseGetTags")
	@ResponseBody
	public ResultMap insertHouseGetTags(String category_name) {
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	@RequestMapping(value = "/house/insertHouseGetTags1")
	@ResponseBody
	public ResultMap insertHouseGetTags1(String category_name) {
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	@RequestMapping(value = "/house/insertHouseGetTags2")
	@ResponseBody
	public ResultMap insertHouseGetTags2(String category_name) {
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	// '标签'
	@RequestMapping(value = "/house/insertHouseGetTags3")
	@ResponseBody
	public ResultMap insertHouseGetTags3(String category_name) {
		category_name = "标签";
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	// '电梯'
	@RequestMapping(value = "/house/insertHouseGetTags4")
	@ResponseBody
	public ResultMap insertHouseGetTags4(String category_name) {
		category_name = "电梯";
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	// category_name = '楼龄'
	@RequestMapping(value = "/house/insertHouseGetTags5")
	@ResponseBody
	public ResultMap insertHouseGetTags5(String category_name) {
		category_name = "楼龄";
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	// category_name = '房屋产权'
	@RequestMapping(value = "/house/insertHouseGetTags6")
	@ResponseBody
	public ResultMap insertHouseGetTags6(String category_name) {
		category_name = "房屋产权";
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	//
	@RequestMapping(value = "/house/insertHouseGetTags7")
	@ResponseBody
	public ResultMap insertHouseGetTags7(String category_name) {
		List<Housetag> housetagList = housertargService.getHousetagByCategory(category_name);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	/**
	 * 查看房屋详情显示标签 性别
	 * 
	 */
	@RequestMapping(value = "/house/DetailsOfHousetags")
	@ResponseBody
	public ResultMap getHousetagsofSex(Integer houseid) {
		@SuppressWarnings("unused")
		String category_name = "性别";
		List<Housetag> housetagList = housertargService.getHousetagsofSex(houseid);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	/**
	 * 查看房屋详情显示标签 独用设施
	 */
	@RequestMapping(value = "/house/DetailsOfHousetags2")
	@ResponseBody
	public ResultMap getHousetagsofalone(Integer houseid) {
		List<Housetag> housetagList = housertargService.getHousetagsofalone(houseid);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}

	/**
	 * 查看房屋详情显示标签 公用设施
	 * 
	 */
	@RequestMapping(value = "/house/DetailsOfHousetags3")
	@ResponseBody
	public ResultMap getHousetags3(Integer houseid) {
		List<Housetag> housetagList = housertargService.getHousetagsofcommon(houseid);
		Map map = new HashMap();
		map.put("housetagList", housetagList);
		return ResultMap.IS_200(map);
	}
}
