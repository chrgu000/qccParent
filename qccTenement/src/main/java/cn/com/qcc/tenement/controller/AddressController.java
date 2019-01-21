package cn.com.qcc.tenement.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.queryvo.AreaCustomer;
import cn.com.qcc.queryvo.MetroCustomer;
import cn.com.qcc.service.AddressService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;

@Controller
public class AddressController {

	@Autowired AddressService addressService;
	@Autowired UserService userService;
	@Autowired VillageService villageService;

	/** 通过城市的code获取城市的信息 / 如果传入了cityname 则code 会以cityname 对应的CODE 为准
	 *  @param cityname : 城市的名称
	 *  @param code     : 根据当前的cdoe 查询下级地址
	 * **/
	@RequestMapping(value = "/area/getareabycode")
	@ResponseBody
	public ResultMap getareabycode(@RequestParam(defaultValue = "0") String code,String cityname) {
		if (!"".equals(cityname) && cityname !=null) {
			code = villageService.getcodebycity(cityname)+"";
		}
		String[] str = code.split(",");
		List<AreaCustomer> arealist = addressService.getnextareabycode(str);
		return ResultMap.IS_200(arealist);
	}
	
	/** 根据区域的ID编辑区域
	 *  @param id : 区域主键
	 *  @param name : 区域名称
	 * **/
	@RequestMapping(value = "/area/edit")
	@ResponseBody
	public ResultMap edit(HttpServletRequest request ,Integer id, String name) throws UnsupportedEncodingException {
		
		Area area = new Area();
		area.setId(id);
		area.setName(name);
		addressService.updatename(area);
		return ResultMap.IS_200();
	}
	
	/**
	 *   添加区域 
	 *   @param submitname : 添加的名称
	 *   @param area.level : 当前区域的级别
	 *   @param area.code  : 当前区域的code
	 * **/
	@RequestMapping(value = "/area/add")
	@ResponseBody
	public ResultMap add(HttpServletRequest request,Area area, String submitname) throws UnsupportedEncodingException {
		ResultMap result = addressService.add(area, submitname);
		return result;
	}
	
	/**根据CODE 查询区域的详情
	 * @param code : 区域CODE
	 * 
	 * **/
	@RequestMapping(value = "/area/areadetail")
	@ResponseBody
	public ResultMap areadetail(Long code) throws UnsupportedEncodingException {
		Area result = addressService.areadetail(code);
		return ResultMap.IS_200(result);
	}

	/**地铁   新增/ 编辑
	 * @param metro.Finalstop  : 地铁站点
	 * @param metro.Name       : 地铁名称
	 * @param metro.metroid    : 地铁ID
	 * @param metrocode       : 地铁所属区域
	 * **/ 
	@ResponseBody
	@RequestMapping(value = "/metro/add")
	public ResultMap metroadd(Metro metro) {
		ResultMap resultMap = addressService.metroadd(metro);
		return resultMap;
	}

	/**
	 * 地铁查询
	 * @param code : 区域code
	 * @param currentpage : 当前页面
	 * @param pagesize    : 每页查询数目
	 * **/ 
	@ResponseBody
	@RequestMapping(value = "/metro/search")
	public ResultMap mertosearch(Long code ,
			@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "7")int pagesize) {
		
		int infocount = addressService.mertrosearchCount(code);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<MetroCustomer> search = addressService.mertrosearch(code ,pagequery );
		Map<String,Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("metrolist", search);
		return ResultMap.IS_200(map);
	}

	/**地铁删除
	 *  @param metro.metroid : 地铁ID
	 * **/ 
	@ResponseBody
	@RequestMapping(value = "/metro/delete")
	public ResultMap metrodelete(Metro metro) {
		ResultMap resultMap = addressService.metrodelete(metro);
		return resultMap;
	}

	/*** 根据站点查询地铁 
	 *  @param finalstop : 地铁站点
	 *  @param code : 地铁所属区域
	 * **/ 
	@ResponseBody
	@RequestMapping(value = "/metro/searchbycodeandfinalstop")
	public ResultMap searchbycodeandfinalstop(Metro metro) {
		ResultMap resultMap = addressService.searchbycodeandfinalstop(metro);
		return resultMap;
	}

	/** 查询地铁的线路
	 * @param name : 地铁线路名称
	 * 
	 * **/ 
	@RequestMapping(value = "/metro/metrobyname")
	@ResponseBody
	public ResultMap metrobyname(Metro metro) {
		ResultMap resultMap = addressService.metrobyname(metro);
		return resultMap;
	}

	/** 地铁详情信息
	 *  @parm name : 地铁线路名称
	 *  @param coe : 地铁区域
	 * **/
	@RequestMapping(value = "/metro/metrodetail")
	@ResponseBody
	public ResultMap metrodetail(Metro metro) {
		ResultMap resultMap = addressService.metrodetail(metro);
		return resultMap;
	}

	/**新增收货地址 
	 * @param deliveryphone : 联系人电话
	 * @param code : 街道CODE
	 * @param deliveryname  : 联系人姓名、
	 * @param deliveryaddress : 详情地址
	 * @param userid : 发布人ID
	 * **/
	@RequestMapping(value = "/address/adddDeli")
	@ResponseBody
	public ResultMap adddDeli(Delivery delivery) {
		delivery.setType(1);
		ResultMap resultMap = addressService.adddDeli(delivery);
		return resultMap;
	}

	/**编辑收货地址 
	 * @param deliveryphone : 联系人电话
	 * @param deliveryid : 详情地址主键
	 * @param code : 街道CODE
	 * @param deliveryname  : 联系人姓名、
	 * @param deliveryaddress : 详情地址
	 * @param userid : 发布人ID
	 * **/
	@RequestMapping(value = "/address/editdelivery")
	@ResponseBody
	public ResultMap editdelivery(Delivery delivery, String sure) {
		if ("默认收货地址".equals(sure)) {
			delivery.setUpdate_time(new Date());
		}
		ResultMap resultMap = addressService.editdelivery(delivery);
		return resultMap;
	}

	/** 编辑收货地址 的查询
	 * @param Deliveryid : 收货地址ID
	 * **/
	@RequestMapping(value = "/address/searchdeliverybyid")
	@ResponseBody
	public ResultMap searchdeliverybyid(Delivery delivery) {
		if (delivery.getDeliveryid() == null) {
			return ResultMap.build(400, "该地址不存在");
		}
		ResultMap resultMap = addressService.searchdeliverybyid(delivery);
		return resultMap;
	}
	
	
	/** 根据城市查询类似的品牌
	 * @param city : 城市名称
	 * @param likename : 输入的品牌名称
	 * @param code : 城市code
	 * **/
	@RequestMapping("/getlikebrand")
	@ResponseBody
	public ResultMap getlikebrand (String likename , String code ,String city) {
		if (city !=null &&!"".equals(city)) {
			// 通过城市获取到code
			 code = villageService.getcodebycity(city)+"";
		}
		
		if (code == null || "".equals(code)) {
			return ResultMap.build(300, "error");
		}
		if (code.startsWith("11") || code.startsWith("12") || code.startsWith("31") || code.startsWith("50")) {
			code = code.substring(0, 2);
		}else {
			code = code.substring(0,4);
		}
		List<Brand> list = addressService.getlikebrand(likename ,code);
		return ResultMap.IS_200(list);
	}

}
