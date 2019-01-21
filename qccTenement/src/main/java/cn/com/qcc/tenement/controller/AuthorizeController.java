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
import cn.com.qcc.pojo.Authorize;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.queryvo.AuthCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.service.AuthService;

@Controller
public class AuthorizeController {

	@Autowired AuthService authService;
	
	/**发布添加委托
	 * @param code : 区域CODE
	 * @param userid : 用户ID
	 * @param title : 委托标题
	 * @param housetype : 户型
	 * @param classification : 分类
	 * @param site : 地址
	 * @param prices : 价格
	 * @param area : 面积
	 * @param metroid : 地铁ID
	 * @param linkman : 联系人
	 * @param linkphone : 联系电话
	 * @param describes : 描述
	 * @param state : 0-冻结，1-上架，2-下架，3-移除
	 * @param update_time : 创建时间
	 * @param create_time : 更新时间
	 * @param authorizeid : 委托ID 如果有ID 表示编辑
	 * **/
	@RequestMapping("/add/authorize")
	@ResponseBody
	public ResultMap addAuthorize(Authorize authorize,Detaileaddress detaileaddress) {
		ResultMap resultMap = authService.insertorupdateauthorize(authorize,detaileaddress);
		return resultMap;
	}

	/**  查询我的委托
	 *   @param userid : 用户ID
	 * **/
	@RequestMapping("/auth/myauthorize")
	@ResponseBody
	public ResultMap findmyAuthroize(Long userid) {

		List<Authorize> authList = authService.myauthorize(userid);

		return ResultMap.IS_200(authList);
	}

	/** 更新我的委托的状态
	 * * @param state : 0-冻结，1-上架，2-下架，3-移除
	 * * @param authorizeid : 委托ID
	 * **/ 
	@RequestMapping("/auth/changemyauthorize")
	@ResponseBody
	public ResultMap changemyAuthroize(Authorize authorize) {
		authService.changemyAuth(authorize);
		return ResultMap.IS_200();
	}
	
	/** 编辑委托的查询
	* * @param authorizeid : 委托ID
	 * **/
	@RequestMapping("/auth/editsearch")
	@ResponseBody
	public ResultMap editSearch(Long authorizeid ) {
		Authorize authorize = authService.getauthbyid(authorizeid);
		return ResultMap.IS_200(authorize);
	}
	
	/**后台查询所有的委托
	 * @param currentpage : 当前页码
	 * @param pagesize : 每页多少数据
	 * **/
	@RequestMapping("/auth/getallauth")
	@ResponseBody
	public ResultMap getallauth( HouseVo houseVo ,
			@RequestParam(defaultValue = "0") String currentpage, @RequestParam(defaultValue = "8")int pagesize) {
		int infocount = authService.getallauthCount(houseVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		Map<String,Object> map = new HashMap<>();
		List<AuthCustomer> auths = authService.getallauth(houseVo);
		map.put("auths", auths);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
}
