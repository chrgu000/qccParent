package cn.com.qcc.tenement.controller;
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
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.Systemstate;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.service.AccessService;


/**
 *  权限集合的控制CONTROLLER 主要做后台分配权限
 * **/
@Controller
public class AccessController {

	@Autowired AccessService accessService;
	@Autowired HttpServletRequest request;
	
	@RequestMapping("/hello")
	public String he() {
		return "hello";
	}
	
	
	/**获取所有权限的集合
	 * @param currentpage : 分页参数当前页面
	 * @param pagesize    : 每页查询的数量
	 * @param userVo      : 主要封装分页参数
	 * **/
	@RequestMapping("/back/allaccess")
	@ResponseBody
	public ResultMap getallaccess(UserVo userVo  , @RequestParam(defaultValue = "0") String currentpage,
			HttpServletRequest request,	@RequestParam(defaultValue = "7") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = accessService.getallaccessCount(userVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userVo.setPagequery(pagequery);
		List<Access> acces = accessService.getallaccess(userVo);
		map.put("acces", acces);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	/**  新增或者编辑权限 当权限ID存在时候 为编辑操作
	 *   @param  access.Accessname :权限的名称
	 *   @param  access.Accessurl  :权限的链接
	 *   @param  access.Accessid   :权限对应的ID
	 * **/
	@SuppressWarnings("unused")
	@RequestMapping("/back/inserorupdateaccess")
	@ResponseBody
	public ResultMap inserorupdateaccess(Access access,HttpServletRequest request) {
		String userid = (String)request.getAttribute("checkuserid");
		ResultMap acces = accessService.inserorupdateaccess(access);
		return acces;
	}
	
	/** 
	 *  查询所有角色。以及当前角色下面对应的权限
	 * **/
	@RequestMapping("/back/roletoaccess")
	@ResponseBody
	public ResultMap roletoaccess() {
		ResultMap acces = accessService.roletoaccess();
		return acces;
	}
	
	
	/** 查询房源发布，求租发布等的状态。修改默认配置
	 * 
	 * **/
	@RequestMapping("/back/searchsystemstate")
	@ResponseBody
	public ResultMap searchsystemstate() {
		ResultMap resultMap = accessService.searchsystemstate();
		return resultMap;
	}
	
	
	/**   根据系统ID ，查询系统默认配置
	 *    @param systemid  : 系统参数唯一标识
	 * **/
	@RequestMapping("/back/searchsystemstatebyid")
	@ResponseBody
	public ResultMap searchsystemstatebyid(Integer systemid) {
		ResultMap resultMap = accessService.searchsystemstatebyid(systemid);
		return resultMap;
	}
	
	
	/** 编辑系统参数 
	 *  @param systemstate.systemid     : 唯一标识
	 *  @param systemstate.defaultstate : 需要修改的状态
	 * **/
	@RequestMapping("/back/updatesystemstate")
	@ResponseBody
	public ResultMap updatesystemstate(Systemstate systemstate) {
		ResultMap resultMap = accessService.updatesystemstate(systemstate);
		return resultMap;
	}
	
	/**  
	 * 查询   平台招募 信息
	 * **/ 
	@RequestMapping("/back/searchplat")
	@ResponseBody
	public ResultMap searchplat () {
		ResultMap resultMap = accessService.searchplat();
		return resultMap;
	}
	
	
	@RequestMapping("/buildpicpath")
	@ResponseBody
	public ResultMap builpicpath () {
		return accessService.buildpicpath();
	}
	
	@RequestMapping("/beforesend")
	@ResponseBody
	public ResultMap test () {
		
		//Long userid = IDUtils.getUserIdByToken(request);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResultMap.IS_200();
	}
	

	
	
}
