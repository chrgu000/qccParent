package cn.com.qcc.tenement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.queryvo.BuyCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.BuyService;
import cn.com.qcc.service.VillageService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class BuyController {

	@Autowired BuyService buyService;
	@Autowired BrowseService browseService;
	@Autowired VillageService villageService;

	/**发布求购信息
	 * @param Detailes : 详情地址
	 * @param userid : 用户ID
	 * @param code : 街道CODE
	 * @param phone : 电话号码
	 * @param picture : 图片
	 * @param head : 标题
	 * @param qiuzuid : 求租的ID 如果有ID 则是编辑处理
	 * **/ 
	@ResponseBody
	@RequestMapping("/buy/addBuy")
	public ResultMap addBuy(Buy buy, Integer userid,Detaileaddress detaileaddress) {
		if (detaileaddress.getDetailes() == null || "".equals(detaileaddress.getDetailes())) {
			return ResultMap.build(400, "请检查你的详情地址！");
		}
		if (userid == null) {
			return ResultMap.build(400, "请登录后在发布求租信息！");
		}
		if (buy.getCode()==null || "".equals(buy.getCode())) {
			return ResultMap.build(400, "请输入求租街道！");
		}
		if (buy.getPhone() == null) {
			return ResultMap.build(400, "请输入电话号码！");
		}
		if ("".equals(buy.getPicture()) || buy.getPicture() ==null) {
			return ResultMap.build(400, "请检查发布的图片！");
		}
		if ("".equals(buy.getHead()) || buy.getHead()==null) {
			return ResultMap.build(400, "请检查发布求购的标题！");
		}
		buy.setUser_id(Long.valueOf(userid));
		buyService.insertorupdatebuy(buy,detaileaddress);
		return ResultMap.IS_200();
	}

	/**
	 * 我的求购
	 * @param userid : 用户ID
	 */
	@RequestMapping(value = "/buy/findBuyByUserid")
	@ResponseBody
	public ResultMap findBuyByUserid(Long userid) {
		List<BuyCustomer> list = buyService.findBuyByUserid(userid);
		Map map = new HashMap();
		map.put("list", list);
		return ResultMap.build(3, "求购...", map);
	}

	/**
	 * 修改的求购的状态
	 * @param buystatus :   0冻结  1上架 2下架
	 * @param buyid : 求购的ID
	 **/
	@RequestMapping("/buy/updateBuyStatus")
	@ResponseBody
	public ResultMap updateBuyStatus(Buy buy) {
		buyService.updateBuyStatus(buy);
		return ResultMap.IS_200();
	}

	@RequestMapping("/info")
	public String d() {
		return "info";
	}
	
	
	@RequestMapping("/to/map")
	public String map() {
		return "map";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@ResponseBody
	@RequestMapping("/test")
	public ResultMap TEST(VillageeVo villageeVo) {
		villageService.test(villageeVo);
		return null;
	}
	
	
	
	
}
