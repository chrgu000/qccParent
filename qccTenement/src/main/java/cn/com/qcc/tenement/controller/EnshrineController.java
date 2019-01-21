package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Browse;
import cn.com.qcc.pojo.Enshrine;
import cn.com.qcc.queryvo.BrowerCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.ZanCustomer;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.EnshrineService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.QiuzuService;
import cn.com.qcc.service.TribeService;


@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class EnshrineController {

	@Autowired BrowseService browseService;
	@Autowired EnshrineService enshrineService;
	@Autowired HouseService houseService;
	@Autowired QiuzuService qiuzuService;
	@Autowired TribeService tribeService;

	/**添加收藏
	 * 1-房源，2-出租，3-出售，4-其他 (type)
	 * @param userid : 用户ID
	 * **/ 
	@RequestMapping("/ensh/addensh/{type}")
	@ResponseBody
	public ResultMap addenshrine(Enshrine enshrine, @PathVariable Integer type) {
		if (enshrine.getUserid() == null) {return ResultMap.build(300,"未知登录");}
		enshrineService.addenshrine(enshrine, type);
		return ResultMap.IS_200();
	}

	/** 查询我的收藏
	 * @param userid : 用户ID
	 * **/ 
	@RequestMapping("/ensh/myenshlist")
	@ResponseBody
	public ResultMap myenshList( @RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "20")	int pagesize,HouseVo houseVo) {
		if (houseVo.getUserid() ==null) {return ResultMap.build(400, "未知登录");}
		int infocount = enshrineService.findMyEnshListCount(houseVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		List<ZanCustomer> enshList = enshrineService.findMyEnshList(houseVo);
		Map map = new HashMap<>();
		map.put("enshList", enshList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 判断房子的收藏状态
	 * * 1-房源，2-出租，3-出售，4-其他 (type)
	 * @param userid : 用户ID
	 * @param otherid : 物品主键
	 * **/ 
	@RequestMapping("/ensh/enshexist/{type}")
	@ResponseBody
	public ResultMap enshrinexist(Enshrine enshrine, @PathVariable Integer type) {
		String str = "收藏";
		if (enshrine.getUserid() !=null) {
			Enshrine enshrine2 = enshrineService.enshriexist(enshrine, type);
			if (enshrine2 != null) {
				// 表示已经收藏过
				if (enshrine2.getStatue() == 1) {
					str = "已收藏";
				}
			}
		}
		return ResultMap.IS_200(str);
	}

	/** 查询我的浏览列表
	 * @param userid : 用户ID
	 * **/
	@RequestMapping("/brow/mybrowlist")
	@ResponseBody
	public ResultMap browerList( @RequestParam(defaultValue = "0") String currentpage, 
			@RequestParam(defaultValue = "20")	int pagesize,
		HouseVo houseVo) {
		Map<String, Object> map = new HashMap<>();
		int infocount = browseService.findmyBrowListCount(houseVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		List<BrowerCustomer> broList = browseService.findmyBrowList(houseVo);
		map.put("pagequery", pagequery);
		map.put("broList", broList);
		return ResultMap.IS_200(map);
	}

	// 删除查看也就是更新状态
	@RequestMapping("/brow/delete")
	@ResponseBody
	public ResultMap delete(Browse browse) {
		browseService.updatestate(browse);
		return ResultMap.IS_200();
	}
}
