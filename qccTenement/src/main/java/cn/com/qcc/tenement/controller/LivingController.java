package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Living;
import cn.com.qcc.service.LivingService;


/**
 * 系统活动配置规则
 * **/
@Controller
@ResponseBody
public class LivingController {

	@Autowired
	LivingService livingService;
	
	
	/**根据上级id查询下级配置规则**/
	@RequestMapping("/living/searchByTypeId")
	public ResultMap searchByTypeId(@RequestParam(defaultValue="0")Long typeid ){
		List<Living> list = livingService.searchByTypeId(typeid);
		return ResultMap.IS_200(list);
	}
	
	/**根据上级id查询下级配置规则**/
	@RequestMapping("/living/searchAllByTypeId")
	public ResultMap searchAllByTypeId(@RequestParam(defaultValue="0")Long typeid ){
		Map<String, Object> map = new HashMap<>();
		List<Living> list = livingService.searchAllByTypeId(typeid);
		Living father = livingService.searchOne(typeid);
		map.put("list", list);
		map.put("father", father);
		return ResultMap.IS_200(map);
	}
	
	
	/**上移动**/
	@RequestMapping("/living/up")
	public ResultMap livingUp (Long typeid ,Long livingid) {
		return livingService.livingUp(typeid ,livingid );
	}
	
	
	/**新增分类**/
	@RequestMapping("/living/add")
	public ResultMap livingUp (Living livng) {
		return livingService.add(livng );
	}
	
	/**修改状态**/
	@RequestMapping("/living/livingChange")
	public ResultMap livingChange (Living living) {
		return livingService.livingChange(living);
	}
	
	/**查询一条规则获得**/
	@RequestMapping("/living/searchOne")
	public ResultMap searchOne (Long livingid) {
		Living living = livingService.searchOne(livingid);
		return ResultMap.IS_200(living);
	}
	
	@RequestMapping("/living/delete")
	public ResultMap delete(Long livingid) {
		livingService.delete(livingid);
		return ResultMap.IS_200();
	}
	
}
