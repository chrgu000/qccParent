package cn.com.qcc.managerclient.controller;

import java.io.File;
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
import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.service.CentService;


@Controller
@RequestMapping("/companion")
public class CentController {
	
	@Autowired
	CentService centService;
	
	//手动确定收款
	@RequestMapping("/autohousepay")
	@ResponseBody
	public ResultMap autohousepay(String housepayids) {
		 return centService.gathering(housepayids);
	}
	
	//查询历史租客
	@RequestMapping("/historyhouserpersion")
	@ResponseBody
	public ResultMap historyhouserpersion (Long houseid) {
		List<Housepersion> persionlist =  centService.historyhouserpersion(houseid);
		Map<String, Object> map = new HashMap<>();
		map.put("persion", persionlist);
		return ResultMap.IS_200(map);
	}
	
	//根据租约编号查询租客
	@RequestMapping("/gethouserpersionbycentnum")
	@ResponseBody
	public ResultMap gethouserpersionbycentnum (String  usercentnum) {
		//这里是查询租客列表
		List<Housepersion> persionlist =  centService.gethouserpersionbycentnum(usercentnum);
		//这里是查承租人信息
		Housepersion housepersion = centService.getcentuserbyCentnum(usercentnum);
		Map<String, Object> map = new HashMap<>();
		map.put("persion", persionlist);
		map.put("housepersion", housepersion);
		return ResultMap.IS_200(map);
	}
	
	//根据租客ID，查询租客详情
	@RequestMapping("/searchhousepersionbyid")
	@ResponseBody
	public ResultMap searchhousepersionbyid (Long housepersionid) {
		Housepersion persion = centService.searchhousepersionbyid(housepersionid);
		return ResultMap.IS_200(persion);
	}
	
	//添加入驻人
	@RequestMapping("/addhousepersion")
	@ResponseBody
	public ResultMap addhousepersion (Housepersion housepersion,Long userid) {
		return centService.addhousepersion(housepersion, userid);
	}
	
	//删除入驻人 [或者搬离入驻人 ]
	@RequestMapping ("/deletehousepersionbyid") 
	@ResponseBody
	public ResultMap deletehousepersionbyid (Long housepersionid,String type) {
		return centService.deletehousepersionbyid(housepersionid,type);
	}
	
	//租客列表
	@RequestMapping ("/housepersionlist")
	@ResponseBody
	public ResultMap housepersionlist (HouseVo houseVo,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		houseVo = houseVo == null ? new HouseVo() :houseVo; //非空校验
		PageQuery pagequery = new PageQuery();
		int infoCount = centService.housepersionlistCount(houseVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		List<UserCentCustomer> list =  centService.housepersionlist(houseVo);
		Map<String, Object> map = new HashMap<>();
		map.put("persionlist", list);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	@RequestMapping("/index")
	public String index () {
		return "index";
	}
	
	//根据账单的ID查询账单的详情
	@ResponseBody
	@RequestMapping("/gethousepaybyid")
	public ResultMap gethousepaybyid (Long housepayid) {
		
		UserCentCustomer housepay =  centService.gethousepaybyid (housepayid);
		if (housepay == null) {
			return ResultMap.build(400, "该账单不存在");
		}
		return ResultMap.IS_200(housepay);
	}
	
	//通过账单ID查询出需要发送短信的用户信息
	@ResponseBody
	@RequestMapping("/messdetail")
	public ResultMap messdetail (Long housepayid) {
		UserCentCustomer housepay =  centService.messdetail (housepayid);
		return ResultMap.IS_200(housepay);
	}
	
	//通过账单ID查询出需要发送短信的用户信息
	@ResponseBody
	@RequestMapping("/sendmess")
	public ResultMap sendmess (Long rentphone,String content,HttpServletRequest request,Long landphone,String state) {
		ResultMap resultMap =  centService.sendmess (rentphone,content,request,landphone,state);
		return resultMap;
	}
	
	//营业报表 根据用户ID查询营业报表
	@RequestMapping("/statement")
	@ResponseBody
	public ResultMap statement (UserCentVo userCentVo ,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		//这里查询对应的应该收款 对应收款 和对应待收
		PageQuery pagequery = new PageQuery();
		UserCentCustomer userCentCustomer = new UserCentCustomer();
		if ("create".equals(userCentVo.getCenttime())) {
			userCentCustomer = centService.totalbil(userCentVo);
		}
		if ("update".equals(userCentVo.getCenttime())) {
			userCentCustomer = centService.totalbilreal(userCentVo);
		}

		if ("searchhouse".equals(userCentVo.getSerachwhere())) {
			int infoCount = centService.bussinessCount(userCentVo);
			pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		}
		if ("searchtime".equals(userCentVo.getSerachwhere())) {
			int infoCount = centService.statementCount(userCentVo);
			pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		}
		userCentVo.setPagequery(pagequery);
		List<UserCentCustomer> cents =  centService.statement (userCentVo);
		Map<String, Object> map = new HashMap<>();
		map.put("centdetail", userCentCustomer);
		map.put("centlist", cents);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	// 账单总列表
	@ResponseBody
	@RequestMapping("/bilelist")
	public ResultMap bilelist (UserCentVo userCentVo,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		Map<String,Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		userCentVo = userCentVo == null ? new UserCentVo():userCentVo;
		int infoCount = centService.bilelistCount(userCentVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userCentVo.setPagequery(pagequery);
		List<UserCentCustomer> bilelist=  centService.bilelist (userCentVo);
		
		//统计整体数据
		HouseCustomer totaldetail  = centService.bilelisttotal(userCentVo);
		map.put("pagequery", pagequery);
		map.put("bilelist", bilelist);
		map.put("totaldetail", totaldetail);
		return ResultMap.IS_200(map);
	}
	
	//根据房东ID查询出小区列表
	@ResponseBody
	@RequestMapping("/villagesbylanduserid")
	public ResultMap villagesbylanduserid (Long userid) {
		List<BuildingCustomer> villages = centService.villagesbylanduserid(userid);
		return ResultMap.IS_200(villages);
	}
	
	//查询总账单的二级联动条件 第一级
	@RequestMapping ("/financebiles")
	@ResponseBody
	public ResultMap financebiles (Long financeid) {
		if (financeid == null) {
			return ResultMap.build(400, "参数不全");
		}
		List<Finance> finances = centService.financebiles(financeid);
		return ResultMap.IS_200(finances);
	}
	
	//查询交易流水号
	@RequestMapping ("/builnum")
	@ResponseBody
	public ResultMap builnum (UserCentVo userCentVo,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize) {
		PageQuery pagequery = new PageQuery();
		Map<String, Object> map = new HashMap<>();
		userCentVo = userCentVo == null ? new UserCentVo():userCentVo;
		int infoCount = centService.builnumCount(userCentVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		userCentVo.setPagequery(pagequery);
		List<UserCentCustomer> builnum = centService.builnum(userCentVo);
		UserCentCustomer builnumdetail = centService.builnumdetail(userCentVo);
		map.put("pagequery", pagequery);
		map.put("builnum", builnum);
		map.put("builnumdetail", builnumdetail);
		return ResultMap.IS_200(map);
	}
	
	//房东查询租户合同
	@RequestMapping ("/landsearchusercent")
	@ResponseBody
	public ResultMap landsearchusercent (HouseVo houseVo,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "8") int pagesize ) {
		if (houseVo.getUserid() == null) {
			return ResultMap.build(200, "登录为空");
		}
		PageQuery pagequery = new PageQuery();
		Map<String, Object> map = new HashMap<>();
		int infoCount =centService.landsearchusercentCount(houseVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		houseVo.setPagequery(pagequery);
		List<UserCentCustomer> cents = centService.landsearchusercent(houseVo);
		map.put("pagequery", pagequery);
		map.put("cents", cents);
		return ResultMap.IS_200(map);
	}
	
	// 我的合同管理
	@RequestMapping("/mycentlist")
	@ResponseBody
	public ResultMap mycentlist (Long userid){
		List<Mycent> cents = centService.mycentlist(userid);
		CheckFIleExist(cents);
		return ResultMap.IS_200(cents);
	};
	
	//租客登记时候获取自己的合同和默认合同
	@RequestMapping("/totalcentlist")
	@ResponseBody
	public ResultMap totalcentlist (Long userid){
		List<Mycent> mycents = centService.mycentlist(userid);
		List<Mycent> defaults = centService.mycentlist(10088L);
		defaults.addAll(mycents);
		CheckFIleExist(defaults);
		return ResultMap.IS_200(defaults);
	};
	
	// 获取默认合同
	@RequestMapping("/defaultmycent")
	@ResponseBody
	public ResultMap defaultmycent () {
		Long userid = 10088L ;///合同合同对应的userid
		List<Mycent> cents = centService.mycentlist(userid);
		CheckFIleExist(cents);
		return ResultMap.IS_200(cents);
	}
	
	// 编辑合同的查询
	@RequestMapping("/editsearchmycent")
	@ResponseBody
	public ResultMap defaultmycent (Mycent mycent) {
		if (mycent.getMycentid() == null) {
			return ResultMap.build(399,"合同信息不完整");
		}
		Mycent search = centService.editsearchmycent(mycent);
		return ResultMap.IS_200(search);
	}
	
	// 编辑合同的查询
	@RequestMapping("/editmycent")
	@ResponseBody
	public ResultMap editmycent (Mycent mycent) {
		if (mycent.getDescname() == null || "".equals(mycent.getDescname())) {
			return ResultMap.build(300,"输入描述");
		}
		if (mycent.getMycentid() == null) {
			return ResultMap.build(300, "合同不存在");
		}
		centService.editmycent(mycent);
		return ResultMap.IS_200();
	}
	
	// 删除合同
	@RequestMapping("/deletemycent")
	@ResponseBody
	public ResultMap deletemycent(Long mycentid ,String centurl) {
		if (mycentid == null) {return ResultMap.build(300,"合同不存在");}
		if (centurl == null || "".equals(centurl)) {return ResultMap.build(300,"合同不存在");}
		//先删除对应的合同文件
		centurl  =centurl.substring(centurl.lastIndexOf("/"));
		String filepath = "/root/apache-tomcat-7.0.79/webapps/upload/mycent/"+centurl;
		File file =new File(filepath);
		if (file.exists()) {
			file.delete();
		}
		centService.deletemycent(mycentid);
		return ResultMap.build(200,"操作成功");
		
	}
	
	
	//校验当前合同是否已经存在
	private void CheckFIleExist(List<Mycent> mycents) {
		for (Mycent his :mycents ) {
			String url = his.getCenturl();
			url =url.substring(url.lastIndexOf("/"));
			String filepath = "/root/apache-tomcat-7.0.79/webapps/upload/mycent/"+url;
			File f =new File(filepath);
			if (!f.exists()) {
				his.setDescname(his.getDescname()+"[已销毁]");
			}
		}
	}

}
