package cn.com.qcc.tenement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.service.BargainService;


/**
 * 全部砍价类型的控制类
 * ***/
@Controller
public class BargainController {
	
	@Autowired
	private BargainService bargainService;
	
	/**
	 * 做砍价处理
	 * **/
	@RequestMapping("/bargin/dobargin/{type}")
	public ResultMap doBargin(String openid ,Long userid , @PathVariable Integer  type , Long otherid) {
		return bargainService.doBargin(openid , userid , type , otherid);
	}
	
	
	/**
	 * 查询砍价列表
	 * 
	 * ***/
	@RequestMapping("/bargin/searchList/{type}")
	public ResultMap searchList (Long userid , @PathVariable Integer  type , Long otherid) {
		return bargainService.searchList(userid,type,otherid);
	}

}
