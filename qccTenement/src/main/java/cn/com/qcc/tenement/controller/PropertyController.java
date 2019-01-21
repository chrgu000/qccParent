package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Property;
import cn.com.qcc.service.PropertyService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	// 查询需要发布的物业类型http://localhost:8080/property/propertyList1
	@RequestMapping("/property/propertyList1")
	@ResponseBody
	public ResultMap findPropertyName() {
		List<Property> findProperty = propertyService.findPropertyExpertOldHouse(null);
		
		Map map = new HashMap<>();
		map.put("propertyList", findProperty);
		return ResultMap.IS_200(map);
	}


	// 查询需要发布的物业类型http://localhost:8080/property/propertyList1
	@RequestMapping("/property/propertyList")
	@ResponseBody
	public ResultMap findPropertyName1() {
		List<Property> findProperty = propertyService.findProperty(null);
		Map map = new HashMap<>();
		map.put("propertyList", findProperty);
		return ResultMap.IS_200(map);
	}
}
