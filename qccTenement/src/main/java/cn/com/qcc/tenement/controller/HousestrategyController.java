package cn.com.qcc.tenement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Villagetrategy;
import cn.com.qcc.service.HousestrategyService;

/**
 * 
 * 小区攻略
 * **/

@RestController
@RequestMapping("/trategy")
public class HousestrategyController {
	
	@Autowired
	private  HousestrategyService  housestrategyService;
	
	@RequestMapping("/add")
	public ResultMap addHousestrategy(Villagetrategy trategy) {
		return housestrategyService.addHousestrategy (trategy) ;
	}
	
	
	@RequestMapping("/editSearch")
	public ResultMap editSearch (Long trategyid) {
		return housestrategyService.editSearch(trategyid);
	}
	
	@RequestMapping("/update")
	public ResultMap update (Villagetrategy trategy) {
		return housestrategyService.update (trategy) ;
	}

}
