package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Sugges;
import cn.com.qcc.queryvo.SuggesCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.SuggesService;

@Controller
public class SuggesController {
	
	@Autowired
	SuggesService suggesService;
	//添加已经反馈
	@RequestMapping("/sugges/add")
	@ResponseBody
	public ResultMap addsugges(Sugges sugges) {
		ResultMap resultMap = suggesService.andsugges(sugges);
		return resultMap;
	}
	
	// 查询所有的反馈
	@RequestMapping("/sugges/suggeslist")
	@ResponseBody
	public ResultMap suggeslist(@RequestParam(defaultValue = "0") String currentpage,
			VillageeVo villageeVo,	@RequestParam(defaultValue = "8") int pagesize) {
		villageeVo = villageeVo != null ? villageeVo : new VillageeVo();
		Integer infoCount = suggesService.suggescount (villageeVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		villageeVo.setPagequery(pagequery);
		List<SuggesCustomer> sugges = suggesService.suggeslist(villageeVo);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("sugges", sugges);
		return ResultMap.IS_200(map);
	}
	
	//我的反馈
	@ResponseBody
	@RequestMapping("/sugges/mysugges")
	public ResultMap mysugges (Long userid ) {
		ResultMap resultmap = suggesService.getmysugges (userid);
		return resultmap;
	}
	
	//反馈详情页
	@ResponseBody
	@RequestMapping("/sugges/detail")
	public ResultMap suggesdetail (Long suggesid) {
		if (suggesid ==null) {
			return ResultMap.build(400,"该反馈信息主题不存在！");
		}
		SuggesCustomer suggesCustomer = suggesService.getdetail (suggesid);
		return ResultMap.IS_200(suggesCustomer);
	}
	
	//移除反馈
	@ResponseBody
	@RequestMapping("/sugges/delete")
	public ResultMap deletesugges (Sugges sugges) {
		ResultMap resultMap = suggesService.deletesugges(sugges);
		return resultMap;
	}
	
}
