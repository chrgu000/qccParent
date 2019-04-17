package cn.com.qcc.tenement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.AccountMgr;
import cn.com.qcc.pojo.Villagetrategy;
import cn.com.qcc.queryvo.TrategyCustomer;
import cn.com.qcc.service.TrategyService;

/**
 * 
 * 小区攻略
 * **/

@RestController
@RequestMapping("/trategy")
public class TrategyController {
	
	@Autowired
	private  TrategyService  trategyService;
	
	@RequestMapping("/add")
	public ResultMap addHousestrategy(Villagetrategy trategy) {
		if (CheckDataUtil.checkNotEmpty(trategy.getStrategyvedio())) {
			String vedioUrl = trategy.getStrategyvedio().replace(AccountMgr.qview_path, 
					AccountMgr.qyunview_path);
			trategy.setStrategyvedio(vedioUrl);
		}
		return trategyService.addHousestrategy (trategy) ;
	}
	
	
	@RequestMapping("/editSearch")
	public ResultMap editSearch (Long trategyid) {
		return trategyService.editSearch(trategyid);
	}
	
	@RequestMapping("/update")
	public ResultMap update (Villagetrategy trategy) {
		if (CheckDataUtil.checkNotEmpty(trategy.getStrategyvedio())) {
			String vedioUrl = trategy.getStrategyvedio().replace(AccountMgr.qview_path, 
					AccountMgr.qyunview_path);
			trategy.setStrategyvedio(vedioUrl);
		}
		return trategyService.update (trategy) ;
	}
	
	
	@RequestMapping ("/list")   
	public ResultMap tragegyList (Long userid ,
			@RequestParam(defaultValue="1")int currentpage ,
			@RequestParam(defaultValue="8")int pagesize  ) {
		Map<String, Object> resultMap = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = trategyService.searchListCount(userid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<TrategyCustomer> trategyList = trategyService.searchList (userid , pagequery ) ;
		resultMap.put("trategyList", trategyList);
		resultMap.put("pagequery", pagequery);
		return ResultMap.IS_200(resultMap);
	}
	
	
	@RequestMapping ("/searchbyVillageid")
	public ResultMap searchTrageryByVillageId (Long villageid) {
		
		List<TrategyCustomer> list = trategyService.searchTrageryByVillageId(villageid);
		if (CheckDataUtil.checkisEmpty(list)) {
			list = new ArrayList<>();
		}
		return ResultMap.IS_200(list);
		
	}
	
	
	@RequestMapping("/delete")
	public ResultMap delete (Long userid , Long trategyid) {
		return trategyService.delete(userid ,trategyid);
	} 
	
	

}
