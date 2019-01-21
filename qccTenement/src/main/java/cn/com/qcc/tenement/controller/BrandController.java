package cn.com.qcc.tenement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Branduser;
import cn.com.qcc.queryvo.BrandCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;

@Controller
public class BrandController {
	
	@Autowired UserService userService; 
	@Autowired VillageService villageService; 
	@Autowired HouseService houseService;
	
	
	
	/**
	 * 创建品牌
	 * @param Onepicture : 图片
	 * @param Userid : 用户ID
	 * @param Brand : 品牌名称
	 * @param Description : 描述
	 * @param Codes : 区域
	 * **/
	@RequestMapping("/createbrand")
	@ResponseBody
	public ResultMap createbrand (Brand brand) {
		ResultMap resultMap = userService.createbrand (brand);
		return resultMap;
	}
	
	/**查询我的品牌
	 * @param userid : 用户ID
	 * @param currentpage : 当前页面
	 * @param pagesize : 每页显示的条数
	 * **/
	@RequestMapping("/getmybranduser")
	@ResponseBody
	public ResultMap getmybranduser(UserVo userVo , @RequestParam(defaultValue = "1") String currentpage,
			@RequestParam(defaultValue = "20000") int pagesize) {
		int infocount = userService.getmybranduserCount(userVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		if (CheckDataUtil.checkisEmpty(userVo)) 
			userVo = new UserVo();
		if (CheckDataUtil.checkisEmpty(userVo.getUserid())) 
			return ResultMap.build(400,"缺少必须的参数");
		userVo.setPagequery(pagequery);
		Map<String, Object> map = new HashMap<>();
		List<Brand> brands = userService.getmybranduser(userVo);
		map.put("pagequery", pagequery);
		map.put("searchmybrand", brands);
		return ResultMap.IS_200(map);
	}
	
	/**根据城市查询查询我的品牌
	 * @param city : 城市名称
	 * @param userid : 用户主键
	 * **/
	@RequestMapping("/getmybranduserbycity")
	@ResponseBody
	public ResultMap getmybranduserbycity(HouseVo houseVo,String city) {
		if (houseVo.getUserid() == null ) {
			return null;
		}
		BrandCustomer brandCustomer = houseVo.getBrandCustomer() == null ?
				new BrandCustomer() : houseVo.getBrandCustomer();
		Long likecode = villageService.getcodebycity(city);
		brandCustomer.setCodes(likecode+"");
		houseVo.setBrandCustomer(brandCustomer);
		List<Brand> brands = userService.getmybranduserbycity(houseVo);
		return ResultMap.IS_200(brands);
	}
	
	/**
	 * 品牌列表
	 * **/
	@RequestMapping ("/brandlist")
	@ResponseBody
	public ResultMap brandlist (HouseVo houseVo,String city ,
			@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "20000") int pagesize) {
		houseVo = houseVo == null ? new HouseVo() :houseVo;
		// 通过城市获取到code
		Long likecode = villageService.getcodebycity(city);
		BrandCustomer brandCustomer = houseVo.getBrandCustomer()== null ?new BrandCustomer():houseVo.getBrandCustomer();
		brandCustomer.setCodes(likecode+"");
		houseVo.setBrandCustomer(brandCustomer);
		PageQuery pagequery = new PageQuery();
		int infocount = houseService.brandlistCount(houseVo);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		Map<String, Object>map = new HashMap<>();
		List<BrandCustomer> brandlist = houseService.brandlist(houseVo);
		map.put("brandlist", brandlist);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	/**
	 * 根据品牌ID 查询哪些用户在这个品牌下
	 * @param brandid : 品牌ID
	 * **/
	@RequestMapping("/followbrand")
	@ResponseBody
	public ResultMap followbrand (Long brandid) {
		List<UserCustomer> users = userService.followbrand(brandid);
		return ResultMap.IS_200(users);
	}
	
	/**查询需要添加的用户
	 * @param searchwhere : 输入的查询条件
	 * @param brandid : 品牌ID
	 * **/
	@RequestMapping("/searchaddbranduser")
	@ResponseBody
	public ResultMap searchaddbranduser (UserCustomer userCustomer) {
		List<UserCustomer> users = userService.searchaddbranduser(userCustomer);
		return ResultMap.IS_200(users);
	}
	
	/** 更新 用户在品牌中状态
	 * @param Brandid : 品牌ID
	 * @param Userid  : 用户ID
	 * @param Userstate : 在品牌中状态
	 * **/
	@RequestMapping("/updatebranduser")
	@ResponseBody
	public ResultMap updatebranduser(Branduser branduser) {
		ResultMap resultMap = userService.updatebranduser(branduser);
		return resultMap;
	}
	
	/**删除我的品牌
	 * @param brandid : 品牌ID
	 * **/
	@RequestMapping("/deletemybrand")
	@ResponseBody
	public ResultMap deletemybrand(Long brandid) {
		ResultMap resultMap = userService.deletemybrand(brandid);
		return resultMap;
	}
	
	/**
	 * 编辑品牌
	 * @param Onepicture : 图片
	 * @param brandid : 品牌id
	 * @param Brand : 品牌名称
	 * @param Description : 描述
	 * @param Codes : 区域
	 * **/
	@RequestMapping("/updatemybrand")
	@ResponseBody
	public ResultMap updatemybrand(Brand brand) {
		ResultMap resultMap = userService.updatemybrand(brand);
		return resultMap;
	}
	
	/** 编辑的查询
	 * @param brandid : 品牌ID
	 * **/
	@RequestMapping("/searcheditbrand")
	@ResponseBody
	public ResultMap searcheditbrand(Long brandid) {
		Brand search = userService.searcheditbrand(brandid);
		Map<String,Object> map = new HashMap<>();
		List<Area> areas = new ArrayList<>();
		if ("0".equals(search.getCodes())) {
			Area area = new Area();
			area.setCode(0L);
			area.setName("全国连锁");
			areas.add(area);
		}else {
			String[] code = search.getCodes().split(",");
			areas = userService.getjiyin(code);
		}
		map.put("areas", areas);
		map.put("brandsearch", search);
		return ResultMap.IS_200(map);
	}
	
	
	
}
