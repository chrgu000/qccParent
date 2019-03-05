package cn.com.qcc.managerclient.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.Historymeter;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Landbuilding;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HistorymeterCustomer;
import cn.com.qcc.queryvo.HistorymeterVo;
import cn.com.qcc.queryvo.HydCoalCustomer;
import cn.com.qcc.queryvo.HydCoalVo;
import cn.com.qcc.queryvo.PayexpertCustomer;
import cn.com.qcc.queryvo.ReckoningCustomer;
import cn.com.qcc.service.HydCoalService;

@Controller
@RequestMapping("/companion")
public class HydCoalController {
	
	@Autowired
	HydCoalService hydCoalService;
	
	//根据传过来的房子ID集合创建水电表单价
	@ResponseBody
	@RequestMapping ("/createhydprices")
	public ResultMap createhydprices ( @RequestBody List<HydCoalCustomer> hydcoal) {
		return hydCoalService.createhydprices(hydcoal  ) ;
		
	}
	
	//根据房子ID查询默认的价格
	@ResponseBody
	@RequestMapping ("/defaultprices")
	public ResultMap defaultprices ( String houseids) {
		List<HydCoalCustomer> hyds =  hydCoalService.defaultprices(houseids) ;
		return ResultMap.IS_200(hyds);
	}
	
	//根据buildingid 和 userid 查询抄表的初始
	@ResponseBody
	@RequestMapping("/beforemeter")
	public ResultMap beforemeter (HydCoalVo hydCoalVo){
		List <HistorymeterCustomer> beforemeter= hydCoalService.beforemeter(hydCoalVo);
		return ResultMap.IS_200(beforemeter);
	}
	
	
	//同步更新抄表
	@ResponseBody
	@RequestMapping("/syncmeter/{userid}")
	public ResultMap syncmeter ( @RequestBody List<Historymeter> historymeter ,@PathVariable Long userid) {
		Integer count =  hydCoalService.syncmeter(historymeter ,userid);
		return ResultMap.IS_200(count);
	}
	
	//查询可以抄表的楼栋
	@SuppressWarnings("unused")
	@RequestMapping("/meterbuilding")
	@ResponseBody
	public ResultMap meterbuilding (Long userid ,HttpServletRequest request) {
		Long user_id =(Long) request.getSession().getAttribute("userid");
		List<BuildingCustomer> meterbuilding = hydCoalService.meterbuilding(userid);
		return ResultMap.IS_200(meterbuilding);
	}
	
	//查询可以抄表的楼栋
	@RequestMapping("/unitname")
	@ResponseBody
	public ResultMap unitname (Landbuilding landbuilding ) {
		List<Finance> meterbuilding = hydCoalService.unitname(landbuilding);
		return ResultMap.IS_200(meterbuilding);
	}
	
	//根据房子ID 和financeID查询历史抄表
	@RequestMapping("/meterdetail")
	@ResponseBody
	public ResultMap meterdetail (HistorymeterVo historymeterVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		historymeterVo = historymeterVo == null ? new HistorymeterVo():historymeterVo;
		PageQuery pagequery = new PageQuery();
		int infoCount = hydCoalService.meterdetailCount(historymeterVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		historymeterVo.setPagequery(pagequery);
		List<HistorymeterCustomer> meterdetail = hydCoalService.meterdetail(historymeterVo);
		map.put("pagequery", pagequery);
		map.put("meterdetail", meterdetail);
		return ResultMap.IS_200(map);
	}
	
	//查询需要发送账单的楼栋
	@RequestMapping("/unitbuilding")
	@ResponseBody
	public ResultMap unitbuilding (Long userid ) {
		List<BuildingCustomer> meterbuilding = hydCoalService.unitbuilding(userid);
		return ResultMap.IS_200(meterbuilding);
	}
	
	
	//根据楼栋ID 。和当前房东ID查询 发送账单的列表
	@RequestMapping("/meterbuils")
	@ResponseBody
	public ResultMap meterbuils (HistorymeterCustomer historymeterCustomer) {
		List<HistorymeterCustomer> meterbuilding = hydCoalService.meterbuils(historymeterCustomer);
		return ResultMap.IS_200(meterbuilding);
	}
	
	//根据楼栋ID 。和当前房东ID查询 发送账单的列表
	@RequestMapping("/payexpbyhouseid")
	@ResponseBody
	public ResultMap payexpbyhouseid (Long houseid) {
		List<PayexpertCustomer> paylist = hydCoalService.payexpbyhouseid(houseid);
		return ResultMap.IS_200(paylist);
	}
	
	//根据主键查询查表详情信息
	@RequestMapping("/hismeterdetail")
	@ResponseBody
	public ResultMap hismeterdetail (Long historymeterid) {
		HistorymeterCustomer detail  = hydCoalService.hismeterdetail(historymeterid);
		return ResultMap.IS_200(detail);
	}
	
	//根据主键查询查表详情信息
	@RequestMapping("/deletemeter")
	@ResponseBody
	public ResultMap deletemeter (Long historymeterid) {
		ResultMap resultMap = hydCoalService.deletemeter(historymeterid);
		return resultMap;
	}
	
	//水电煤气表生成生成账单
	@RequestMapping("/hydbuil")
	@ResponseBody
	public ResultMap hydbuil (Long historymeterid ,Long payexpertid ,Double unitprice) {
		ResultMap resultMap = hydCoalService.hydbuil(historymeterid,payexpertid,unitprice);
		return resultMap;
	}
	
	//根据抄表ID获取账单ID
	@RequestMapping("/searchhousepayid")
	@ResponseBody
	public ResultMap searchhousepayid (Long historymeterid) {
		ResultMap resultMap = hydCoalService.searchhousepayid(historymeterid);
		return resultMap;
	}
	
	//根据抄表ID获取账单ID
	@RequestMapping("/reckoning")
	@ResponseBody
	public ResultMap reckoning (HydCoalVo hydCoalVo,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = hydCoalService.reckoningCount(hydCoalVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		hydCoalVo.setPagequery(pagequery);
		List<ReckoningCustomer> roCustomers = hydCoalService.reckoning(hydCoalVo);
		map.put("pagequery", pagequery);
		map.put("recklist", roCustomers);
		return ResultMap.IS_200(map);
	}
	
	// 查询添加账单 的类目
	@RequestMapping("/addfinancelist")
	@ResponseBody
	public ResultMap addfinancelist () {
		List<Finance> list = hydCoalService.addfinancelist();
		return ResultMap.IS_200(list);
	}
	
	// 查询添加账单 的类目
	@RequestMapping("/addotherbuil")
	@ResponseBody
	public ResultMap addotherbuil (Housepay housepay) {
		ResultMap requestMapping = hydCoalService.addotherbuil(housepay);
		return requestMapping;
	}

}
