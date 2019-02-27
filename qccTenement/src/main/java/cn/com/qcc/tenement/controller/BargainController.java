package cn.com.qcc.tenement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Bargaindetail;
import cn.com.qcc.service.BargainService;


/**
 * 全部砍价类型的控制类
 * ***/
@RestController
public class BargainController {
	
	@Autowired
	private BargainService bargainService;
	
	/**
	 * 做砍价处理
	 * **/
	@RequestMapping("/bargin/dobargin/{type}")
	public ResultMap doBargin(Long preparatoryid ,Long userid ,String reservationstel ,
			String reservations,
			@PathVariable Integer  type , Long otherid) {
		return bargainService.doBargin(preparatoryid , userid , type , otherid ,reservationstel , reservations);
	}
	
	
	/**
	 * 查询砍价列表
	 * ***/
	@RequestMapping("/bargin/searchList")
	public ResultMap searchList (Long barginid,String unionid ,String userid) {
		return bargainService.searchList(barginid, unionid ,userid);
	}
	
	/**砍价**/
	@RequestMapping("/bargin/doBargainDetail")
	public ResultMap doBargainDetail (Bargaindetail bargaindetail) {
		
		return bargainService.doBargainDetail(bargaindetail);
	}

}
