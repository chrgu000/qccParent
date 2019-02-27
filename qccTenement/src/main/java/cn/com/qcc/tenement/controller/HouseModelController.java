package cn.com.qcc.tenement.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Housemodel;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.service.HouseModelService;

/**房源库管理**/
@Controller
@RequestMapping("/houseModel")
public class HouseModelController {
	
	@Autowired
	HouseModelService houseModelService;
	
	/** 添加房源库**/
	@RequestMapping("/oneHouseAdd")
	@ResponseBody
	public ResultMap addToHouseModel(Long houseid ,Long userid){
		// 导入房源库之前查询导入的基本信息
		ResultMap resultMap = houseModelService.selectAddToHouseModel(houseid , userid);
		return resultMap;
	}
	
	
	/***编辑房源库**/
	@RequestMapping("/oneHouseUpdate")
	@ResponseBody
	public ResultMap updateHouseModel(Housemodel houseModel) {
		ResultMap resultMap = houseModelService.updateHouseModel(houseModel);
		return    resultMap;
	}
	
	
	
	/**删除房源库**/
	@RequestMapping("/oneHouseDelete")
	@ResponseBody
	public ResultMap oneHouseDelete(Long houseid  ,Long userid){
		// 导入房源库之前查询导入的基本信息
		ResultMap resultMap = houseModelService.oneHouseDelete(houseid , userid);
		return resultMap;
	}
	
	
	
	/**查询房源库中一个房子**/
	@RequestMapping("/oneHouseSearch")
	@ResponseBody
	public ResultMap oneHouseSearch(Long houseModelId){
		// 导入房源库之前查询导入的基本信息
		if (CheckDataUtil.checkisEmpty(houseModelId)) 
			return ResultMap.build(400, "输入主键");
		ResultMap resultMap = houseModelService.oneHouseSearch(houseModelId);
		return resultMap;
	}
	
	
	
	/**查询房源列表 **/
	@RequestMapping("/houseList")
	@ResponseBody
	public ResultMap houseList(Housemodel model ) {
		if (CheckDataUtil.checkisEmpty(model.getUserid())) 
			return ResultMap.build(400, "请先登录");
		
		/// 这里是根据条件查询的结果
		SearchResult houseResult = houseModelService.houseList(model);
		List<Housemodel> houseList = houseResult.getModelList();
		int totalCount = houseResult.getRecordCount();
		
		
		/// 这里是查询所有地址的
		Housemodel search = new Housemodel();
		search.setUserid(model.getUserid());
		SearchResult result = houseModelService.houseList(search);
		List<Housemodel> modelList = result.getModelList();
		Map<String, List<String>> map = new HashMap<>();
		for (Housemodel entity : modelList) {
			List<String> names = map.get(entity.getDistrict());
			if (names == null) {
				names = new ArrayList<>();
				names.add(entity.getVillageName());
				map.put(entity.getDistrict(), names);
			} else {
				boolean flag =  true ;
				for (String village : names)  {
					if (village.equals(entity.getVillageName())) {
						flag = false; 
					}
				}
				if (flag){
					names.add(entity.getVillageName());
					map.put(entity.getDistrict(), names);
				}
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("address", map);
		resultMap.put("houseList", houseList);
		resultMap.put("totalCount", totalCount);
		return ResultMap.IS_200(resultMap);
	};
}
