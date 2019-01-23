package cn.com.qcc.tenement.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.AddressService;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.QiuzuService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;
import cn.com.qcc.service.VipCountService;
import cn.com.qcc.service.ZanService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class QiuZuController {

	@Autowired
	QiuzuService qiuzuService;
	@Autowired
	ZanService zanService;
	@Autowired
	UserService userService;
	@Autowired
	VipCountService vipCountService;
	@Autowired
	BrowseService browseService;
	@Autowired
	AddressService addressService;
	@Autowired
	VillageService villageService;
	@Autowired
	InteService inteService;

	/**
	 * 发布求租信息  
	 **/
	@RequestMapping("/qiuzu/addQiuzu")
	@ResponseBody
	public ResultMap addQiuzu(Qiuzu qiuzu, Integer userid, Detaileaddress detaileaddress) {
		if (CheckDataUtil.checkisEmpty(userid)) { return ResultMap.build(400, "请先登录在发布"); }
		qiuzu.setUser_id(Long.valueOf(userid));
		ResultMap resultMap = qiuzuService.insertorupdateqiuzu(qiuzu, detaileaddress);
		return resultMap;
	}

	

	/**
	 * 发布求的统计
	 **/
	@RequestMapping("/qiuzu/total")
	@ResponseBody
	public ResultMap qizutotal(HttpServletRequest request, Qiuzu qiuzu) {
		List<QiuzuCustomer> list = qiuzuService.qiuzutotal(qiuzu);
		return ResultMap.IS_200(list);
	}

	/**
	 * 求租列表
	 */
	@RequestMapping(value = "/qiuzu/findQiuzuList")
	@ResponseBody
	public ResultMap findQiuzuList(Metro metro, QiuzuCustomer qiuzuCustomer, Long userid,String city,
			@RequestParam(defaultValue = "1") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		//TDDTO    city = "深圳";
		Map map = new HashMap();	
		Long citycode = villageService.getcodebycity(city);
		if (CheckDataUtil.checkisEmpty(qiuzuCustomer.getLikecode())) {
			qiuzuCustomer.setLikecode(citycode);
		}
		if (CheckDataUtil.checkNotEmpty(userid)) {
			int vipcount = vipCountService.findVipCount(userid);
			map.put("vipcount", vipcount);
		}
		
		//设置分页参数
		PageQuery pagequery = new PageQuery();
		pagequery.setPagesize(pagesize);
		pagequery.setCurrentpage(Integer.parseInt(currentpage));
		
		
		/**通过索引库查询求租 列表信息**/
		SearchResult result = qiuzuService.searchQiuzuListBySolr(metro , qiuzuCustomer , pagequery);
		List<QiuzuCustomer> list = result.getQiuzulist();
		int infocount = result.getRecordCount();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		
		map.put("list",list);
		map.put("citycode", citycode);
		map.put("pageModel", pagequery);
		return ResultMap.IS_200(map);
	}

	/**
	 * 求租详情
	 * @param qiuzuid
	 * @param userid
	 * @param request
	 * @param Response
	 */
	@RequestMapping(value = "/qiuzu/qiuzuDetail/{type}")
	@ResponseBody
	public ResultMap qiuzuDetail(Long qiuzuid, Long userid, @PathVariable Integer type) {
		Map map = new HashMap();
		//校验type类型是否为2
		if (CheckDataUtil.checkNotEqual(type, 2)) {return ResultMap.build(400, "type类型不对");}
		// 校验求租的次数是否足够
		ResultMap resultMap = CheckQiuzuCount(userid ,qiuzuid );
		//如果求租次数不够直接返回
		if (resultMap.getCode() !=200) {return resultMap;}
		QiuzuCustomer search = qiuzuService.qiuzuDetail(qiuzuid ,userid ,type);
		Integer bcount= 0;
		if (CheckDataUtil.checkNotEmpty(search)) {
			 bcount= search.getBcount();
		}
		map.put("qiuzcount", bcount);
		map.put("qiuzu", search);
		return ResultMap.IS_200(map);
	}

	/**在查看求租之前校验求租次数是否足够**/
	private ResultMap CheckQiuzuCount(Long userid , Long qiuzuid) {
		// 校验用户的登录id
		if (CheckDataUtil.checkisEmpty(userid)) { return ResultMap.build(404, "请先登录"); }
		//校验房子id为空
		if (CheckDataUtil.checkisEmpty(qiuzuid)) { return ResultMap.build(400, "房子ID不能为空");}
		// 先判断用户是否存在
		UserCustomer userCustomer = userService.getUserAndProfile(userid);
		//如果用户不存在要返回
		if (CheckDataUtil.checkisEmpty(userCustomer)) {return ResultMap.build(400, "未知用户");}
		Vipcount vipcount = vipCountService.getVipByUserID(userid);
		int count = 0;
		if (vipcount != null) {
			count = vipcount.getCount();
			if (count == 0) {
				return ResultMap.build(400, "你的可用次数或金币不够请充值");
			}
			count--;
			vipcount.setCount(count);
			vipCountService.updateVipCount(vipcount);
		}
		if (vipcount == null) {
			Vipcount vipcount_insert = new Vipcount();
			vipcount_insert.setBalance(0.0);
			vipcount_insert.setCretime_time(new Date());
			vipcount_insert.setCount(50);
			vipcount_insert.setIs_vip(0);
			vipcount_insert.setUser_id(userid);
			vipCountService.insertVipCount(vipcount_insert);
		}
		return ResultMap.build(200, "金币足够");
	}



	/**
	 * 我的求租列表
	 */
	@RequestMapping(value = "/qiuzu/findQiuzuByUserid")
	@ResponseBody
	public ResultMap findQiuzuByUserid(Long userid, @RequestParam(defaultValue = "0") Integer currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		if (CheckDataUtil.checkisEmpty(userid) || CheckDataUtil.checkisEmpty(pagesize)
				|| CheckDataUtil.checkisEmpty(currentpage)) 
				{return ResultMap.build(400, "数据异常");}
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = qiuzuService.findQiuzuByUserid(userid , pagequery);
		List<QiuzuCustomer> list = result.getQiuzulist();
		Integer infoCount = result.getRecordCount();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		Map map = new HashMap();
		map.put("list", list);
		map.put("pagequery", pagequery);
		return ResultMap.build(2, "求租的...", map);
	}

	/**
	 * 修改求租的状态 上架 下架 移除
	 ** 
	 */
	@RequestMapping("/qiuzu/updateQiuzuStatus")
	@ResponseBody
	public ResultMap updateqiuzustatues(Qiuzu qiuzu) {
		return qiuzuService.updateqiuzustatues(qiuzu);
	}

	/**
	 * 求租一键导入索引库
	 **/
	@RequestMapping("/qiuzu/qiuzuaddtosolr")
	@ResponseBody
	public ResultMap qiuzuaddtosolr(int start ,int end) {
		PageQuery pagequery = new PageQuery();
		pagequery.setPagestart(start);
		pagequery.setPageend(end);
		ResultMap resultMap = qiuzuService.qiuzuaddtosolr(pagequery);
		return resultMap;
	}

	// 发布电话号码求租统计查询
	@RequestMapping("/qiuzu/sendmess")
	@ResponseBody
	public ResultMap sendmess(HttpServletRequest request, String start, String end, String content, Integer num) throws Exception {
		QiuzuCustomer qiuzuCustomer = new QiuzuCustomer();
		try {
			Date start_date = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			Date end_date = new SimpleDateFormat("yyyy-MM-dd").parse(end);
			qiuzuCustomer.setStart_date(start_date);
			qiuzuCustomer.setEnd_date(end_date);
		} catch (Exception e) {
		}

		List<QiuzuCustomer> qiuzulist = qiuzuService.sendmess(qiuzuCustomer);
		int error = 0;
		int success = 0;
		// 这里做群发处理
		if (content != "" && !"".equals(content)) {
			if (num > 0) {
				for (int i = 0; i < qiuzulist.size() && i < num; i++) {
					Map<String, String> result = SendMessage.qunfa(qiuzulist.get(i).getPhone(), content, request);
					String returnstr = result.get("returnStr");
					if (returnstr.indexOf("提交成功")!=-1) {
						success++;
					}else {
						error++;
					}
				}
				qiuzuCustomer.setError(error);
				qiuzuCustomer.setSuccess(success);
				return ResultMap.IS_200(qiuzuCustomer);
			}
		}
		return ResultMap.IS_200(qiuzulist);
	}

	/**测试方法**/
	@RequestMapping("/testSolr")
	@ResponseBody
	public ResultMap testSolr(Metro metro, QiuzuCustomer qiuzuCustomer, Long userid,String city,
			@RequestParam(defaultValue = "1") String currentpage, @RequestParam(defaultValue = "7") int pagesize) {
		
		Long citycode = villageService.getcodebycity(city);
		if (qiuzuCustomer.getLikecode() == null || "".equals(qiuzuCustomer.getLikecode())) {
			qiuzuCustomer.setLikecode(citycode);
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(Integer.parseInt(currentpage));
		pagequery.setPagesize(pagesize);
		SearchResult result = qiuzuService.testSolr(metro, qiuzuCustomer,pagequery);
		Integer infocount = result.getRecordCount();
		List<QiuzuCustomer> list =result.getQiuzulist();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		Map map = new HashMap();
		if (userid != null) {
			int vipcount = vipCountService.findVipCount(userid);
			map.put("vipcount", vipcount);
		}
		map.put("list",list);
		map.put("citycode", citycode);
		map.put("pageModel", pagequery);
		return ResultMap.IS_200(map);
	}
}
