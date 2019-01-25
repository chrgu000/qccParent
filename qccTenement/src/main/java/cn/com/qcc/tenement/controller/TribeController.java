package cn.com.qcc.tenement.controller;

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
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.Browse;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.pojo.Typedetail;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.DetailCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.TribeCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.TribeService;
import cn.com.qcc.service.UserService;

@Controller
public class TribeController {

	@Autowired
	TribeService tribeService;
	@Autowired
	BrowseService browseService;
	@Autowired
	InteService inteService;
	@Autowired
	UserService userService;
	
	
	// 查询我关注的
	@RequestMapping("/tribe/searchmyfocus")
	@ResponseBody
	public ResultMap searchmyfocus (Long userid ,
			@RequestParam(defaultValue="1")Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize,
			@RequestParam(defaultValue="0")Integer articletypeid) {
		Map<String, Object> map = new HashMap<>();
		int infoCount = tribeService.myfocusCount(userid);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<ArticleDetailCustomer> myfocus = tribeService.myfocus(userid , pagequery ,articletypeid);
		map.put("pagequery", pagequery);
		map.put("myfocus", myfocus);
		return ResultMap.IS_200(map);
		
	}
	
	
	//挂到鱼塘
	@RequestMapping("/tribe/detailToTribe/{type}")
	@ResponseBody
	public ResultMap detailToTribe (Long tribeid ,Long detailid , @PathVariable Integer type) {
		ResultMap resultMap = tribeService.detailToTribe(tribeid  , detailid , type);
		return resultMap;
	}
	
	
	// 查询我的发布挂到鱼塘
	@RequestMapping("/tribe/searchToTribe/{type}")
	@ResponseBody
	public ResultMap searchToTribe(Long userid ,@PathVariable Integer type,
			@RequestParam(defaultValue="1") Integer currentpage , @RequestParam(defaultValue="8")Integer pagesize) {
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		List<DetailCustomer> detailList = tribeService.searchToTribe(userid , type , pagequery); 
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("detailList",detailList);
		return ResultMap.IS_200(map);
	}
	
	//搜索框根据name查询部落
	@RequestMapping("/tribe/searchLike")
	@ResponseBody
	public ResultMap searchLikeTribe(String searchwhere ,Long userid
			,@RequestParam(defaultValue="1")Integer currentpage ,@RequestParam(defaultValue="8")Integer pagesize) {
		Map<String,Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = tribeService.searchLikeTribeCount(userid , searchwhere);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<TribeCustomer> tribeList = tribeService.searchLikeTribe(userid , searchwhere , pagequery);
		map.put("tribeList", tribeList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
		
	}
	
	
	// 根据tribetypeid 查询部落
	@RequestMapping("/tribe/searchtribybyTypeid")
	@ResponseBody
	public ResultMap searchtribebyTypeid(Long userid ,Long tribetypeid,
			@RequestParam(defaultValue="1")Integer currentpage ,@RequestParam(defaultValue="8")Integer pagesize){
		Map<String,Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		int infoCount = tribeService.searchtribebyTypeidCount(userid , tribetypeid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<TribeCustomer> tribeList = tribeService.searchtribebyTypeid(userid , tribetypeid , pagequery);
		map.put("tribeList", tribeList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	

	// 创建部落
	@ResponseBody
	@RequestMapping("/tribe/create")
	public ResultMap createtribe(Tribe tribe, Detaileaddress detaileaddress, Tribetype tribetype) {
		ResultMap resultMap = tribeService.createtribe(tribe, detaileaddress, tribetype);
		return resultMap;
	}
	

	// 加入部落
	@ResponseBody
	@RequestMapping("/tribe/join")
	public ResultMap jointribe(Long tribeid, Long userid) {
		ResultMap resultMap = tribeService.joinTribe(tribeid, userid);
		return resultMap;
	}

	// 我的部落列表
	@ResponseBody
	@RequestMapping("/tribe/myjointribe")
	public ResultMap tribelist(Long userid, @RequestParam(defaultValue = "0") Integer currentpage,
			@RequestParam(defaultValue = "3") int pagesize) {
		if (CheckDataUtil.checkisEmpty(userid)) {return ResultMap.build(400,"未知用户");}
		// 我加入的部落
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		Integer infocount = tribeService.myjointribeCount(userid);
		pagequery.setPageParams(infocount, pagesize, currentpage);
		List<TribeCustomer> mytribe = tribeService.myjointribe(userid ,pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("myjointribe", mytribe);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}

	// 部落签到
	@ResponseBody
	@RequestMapping("/tribe/usersign")
	public ResultMap usersign(Long tribeid, Long userid) {
		ResultMap resultMap = tribeService.usersign(tribeid, userid);
		//签到以后处理积分 10--代表签到
		if (resultMap.getCode() ==200) {
			inteService.managebranch(13L, userid ,tribeid );
		}
		return resultMap;
	}

	
	// 查询城市的部落
	@RequestMapping(value = "/cities/findCities")
	@ResponseBody
	public ResultMap findCities() {
		List<Tribetype> citys = tribeService.getCityTribe();
		return ResultMap.IS_200(citys);
	}

	// 查询兴趣的部落
	@RequestMapping("/tribe/avocation")
	@ResponseBody
	public ResultMap getTribeAvocation() {
		List<Tribetype> tribeavocation = tribeService.getAvocationTribe();
		Map<String, Object> map = new HashMap<>();
		map.put("avocation", tribeavocation);
		return ResultMap.IS_200(map);
	}

	// 人气榜单
	@RequestMapping("/tribe/popularity")
	@ResponseBody
	public ResultMap getPopularity(Long userid) {
		List<TribeCustomer> popularity = tribeService.getpopularity();
		// 干掉自己加入的部落，然后算出。部落里面的人数
		Map<String, Object> map = new HashMap<>();
		map.put("popularity", popularity);
		return ResultMap.IS_200(map);
	}

	// 明星群主
	@RequestMapping("/tribe/luncida")
	@ResponseBody
	public ResultMap getLuncida() {
		Map<String, Object> map = new HashMap<>();
		List<TribeCustomer> luncida = tribeService.getLuncida();
		map.put("luncida", luncida);
		return ResultMap.IS_200(map);
	}

	// 发布提问 1-8 ... 8表示部落
	@RequestMapping("/tribe/pushquestion/{type}")
	@ResponseBody
	public ResultMap pushquestion(Long tribeid, Long userid, String title, @PathVariable Integer type) {
		ResultMap resultMap = tribeService.pushquestion(tribeid, userid, title, type);
		return resultMap;
	}

	// 部落详情页
	@RequestMapping("/tribe/tribedetail/{type}")
	@ResponseBody
	public ResultMap tribedetail(Long tribeid, @PathVariable Integer type, Long userid ,
			@RequestParam(defaultValue="1")Integer currentpage,
			@RequestParam(defaultValue="3") Integer pagesize) {
		
		// 详情页展示部落
		TribeCustomer tribeCustomer = tribeService.getTribetailbyid(tribeid, type,userid);
		if (CheckDataUtil.checkisEmpty(tribeCustomer)) 
			{return ResultMap.build(400, "未知部落");}
		// 判断是不是部落成员
		boolean checkTribeIn = tribeService.checkTribeIn(userid , tribeid);
		
		// 详情页展示部落
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		int infoCount = tribeService.getTribeuserCount(tribeid);
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		List<TribeCustomer> list = tribeService.getTribeuser(tribeid ,pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("tribe", tribeCustomer);
		map.put("tribeuser", list);
		map.put("checkTribeIn", checkTribeIn);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}


	// 查询发布的分类
	@RequestMapping("/tribe/getTribedetailtype/{type}")
	@ResponseBody
	public ResultMap getTribedetailtype(@PathVariable Integer type) {
		if (type == 11) {return ResultMap.build(400, "");}
		List<Articletype> tribelist = tribeService.getTribeDetailType(type);
		return ResultMap.IS_200(tribelist);
	}

	// 部落发布
	@RequestMapping("/tribe/pushtribedetail/{type}")
	@ResponseBody
	public ResultMap pushtribedetail(@PathVariable Integer type,  Articledetail articledetail,Long tribeid,
		@RequestParam(defaultValue="")String codeids, @RequestParam(defaultValue="1")Integer count ,@RequestParam(defaultValue="0") Double prices,
		Detaileaddress detaileaddress ) {
		if (CheckDataUtil.checkNotEmpty(tribeid)) 
			{ articledetail.setTribeids(tribeid+"");}
		ResultMap resultMap = tribeService.pushtribedetail(type,  articledetail, detaileaddress
				,codeids,	count , prices);
		return resultMap;
	}

	// 根据查询条件查找部落
	@RequestMapping("/tribe/findtribe")
	@ResponseBody
	public ResultMap findtribe(TribeVo tribeVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();
		PageQuery pagequery = new PageQuery();
		tribeVo.setPagequery(pagequery);
		Integer infocount = tribeService.getTribebyconditionCount(tribeVo);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<TribeCustomer> tribelist = tribeService.getTribebycondition(tribeVo);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("tribelist", tribelist);
		return ResultMap.IS_200(map);
	}


	// 找人，找物品，问答详情页
	@RequestMapping("/tribe/thingdetail")
	@ResponseBody
	public ResultMap thingdetail(Long articedetailid ,Long userid) {
		ArticleDetailCustomer thingdetail = tribeService.thingdetail(articedetailid,userid);
		return ResultMap.IS_200(thingdetail);
	}

	// 兴趣部落首页
	@RequestMapping("/tribe/indexhortibe")
	@ResponseBody
	public ResultMap indexhortibe(TribeVo tribeVo, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "4") int pagesize) {
		tribeVo = tribeVo != null ? tribeVo : new TribeVo();
		PageQuery pagequery = new PageQuery();
		tribeVo.setPagequery(pagequery);
		Integer infocount = tribeService.indexhortibCount(tribeVo);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<TribeCustomer> indexhortibe = tribeService.indexhortibe(tribeVo);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("indexhortibe", indexhortibe);
		return ResultMap.IS_200(map);
	}

	// 最近浏览部落
	@RequestMapping("/tribe/nearbrotribe")
	@ResponseBody
	public ResultMap nearbrotribe(Long userid, @RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "4") int pagesize) {
		PageQuery pagequery = new PageQuery();
		if (CheckDataUtil.checkisEmpty(userid)) 
			{return ResultMap.build(400,"未知用户");}
		Integer infocount = tribeService.nearbrotribeCount(userid);
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		List<TribeCustomer> nearbrotribe = tribeService.nearbrotribe(userid,pagequery);
		Map<String, Object> map = new HashMap<>();
		map.put("pagequery", pagequery);
		map.put("nearbrotribe", nearbrotribe);
		return ResultMap.IS_200(map);
	}

	// 兴趣部落首页最近部落
	@RequestMapping("/tribe/indexhorneartribe")
	@ResponseBody
	public ResultMap indexhorneartribe(TribeVo tribeVo) {
		List<TribeCustomer> indexhorneartribe = tribeService.indexhorneartribe(tribeVo);
		Map<String, Object> map = new HashMap<>();
		map.put("indexhorneartribe", indexhorneartribe);
		return ResultMap.IS_200(map);
	}
	
	//签到榜单
	@RequestMapping("/tribe/signdetail")
	@ResponseBody
	public ResultMap tribesign (Long tribeid,@RequestParam(defaultValue="1")Integer currentpage,
		@RequestParam(defaultValue="8")	Integer pagesize) {
		Map<String, Object > map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		int infocount = tribeService.tribesignCount(tribeid);
		pagequery.setPageParams(infocount, pagesize, currentpage);
		List<UserCustomer> signList = tribeService.tribesign(tribeid ,pagequery);
		map.put("pagequery", pagequery);
		map.put("signList", signList);
		return ResultMap.IS_200(map);
	}
	
	//编辑部落找人分类
	@ResponseBody
	@RequestMapping("/tribe/edittriebp")
	public ResultMap edittriebp(HttpServletRequest request,Articletype articletype) {
		ResultMap resultMap = tribeService.edittribep(articletype);
		return resultMap;
	}
	
	//新增部落找人分类
	@RequestMapping("/tribe/intriebp/{type}")
	@ResponseBody
	public ResultMap intribep(HttpServletRequest request ,String typename ,@PathVariable Integer type) {
		
		ResultMap resultMap = tribeService.intribep(typename,type);
		return resultMap;
	}
	
	//部落类别的编辑
	@RequestMapping("/tribe/edittype")
	@ResponseBody
	public ResultMap edittype (Tribetype tribetype) {
		ResultMap resultMap = tribeService.edittype(tribetype);
		return resultMap;
	}
	
	//创建部落类别
	@RequestMapping("/tribe/createtribetype/{type}")
	@ResponseBody
	public ResultMap createtribetype(Tribetype tribetype,@PathVariable Integer type) {
		ResultMap resultMap = tribeService.createtribetype(tribetype,type);
		return resultMap;
	}
	
	//城市部落的查询
	@RequestMapping("/tribe/city")
	@ResponseBody
	public ResultMap tribecity() {
		ResultMap resultMap = tribeService.tribecity();
		return resultMap;
	}
	
	//获得物品分类的下一级
	@ResponseBody
	@RequestMapping("/tribe/getdetailtype")
	public ResultMap getdetailtype (Integer articletypeid) {
		List<Articletype> details = tribeService.getTribeDetailType(articletypeid);
		return ResultMap.IS_200(details);
	}
	
	//更新物品二级分类
	@ResponseBody
	@RequestMapping ("/tribe/updatetypedetail")
	public ResultMap updatetypedetail (Typedetail typedetail) {
		ResultMap resultMap = tribeService.updatetypedetail (typedetail);
		return resultMap;
	}
	
	
	//新增物品二级分类
	@ResponseBody
	@RequestMapping("/tribe/addtypedetail")
	public ResultMap addtypedetail (Typedetail typedetail) {
		ResultMap resultMap = tribeService.addtypedetail(typedetail);
		return resultMap;
	}
	
	
	//新增物品二级分类
	@ResponseBody
	@RequestMapping("/tribe/getallguige")
	public ResultMap getallguige (String typeid) {
		Map<String , Object> map = new HashMap<>();
		String [] str = typeid.split(",");
		List<Parametype> isin  = tribeService.isin(str);
		List<Parametype> isnot = tribeService.isnot(str);
		map.put("isin", isin);
		map.put("isnot", isnot);
		return ResultMap.IS_200(map);
	}
	
	
	//更新物品规格参数
	@ResponseBody
	@RequestMapping("/tribe/updatetyepdetail")
	public ResultMap updatetyepdetail (Typedetail typedetail) {
		if (typedetail.getTypedetailid() == null) {
			return ResultMap.build(3300, "编辑异常");
		}
		if (typedetail.getTypeid() == null || "".endsWith(typedetail.getTypeid())) {
			return ResultMap.build(400, "请选择一个规格参数");
		}
		tribeService.updatetyepdetail(typedetail);
		return ResultMap.IS_200();
	}
	
	//增值服务列表
	@RequestMapping ("/tribe/articlelist") 
	@ResponseBody
	public ResultMap getarticlelist (TribeVo tribeVo ,@RequestParam(defaultValue = "0") String currentpage,
			@RequestParam(defaultValue = "7") int pagesize) {
		Integer infocount = tribeService.getarticlelistCount(tribeVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		Map<String , Object> map = new HashMap<>();
		tribeVo.setPagequery(pagequery);
		List<ArticleDetailCustomer> articlelist = tribeService.getarticlelist(tribeVo);
		map.put("articlelist",articlelist);
		map.put("pagequery",pagequery);
		return ResultMap.IS_200(map);
	}
	
	//增值服务
	@RequestMapping ("/tribe/articledetail/{type}") 
	@ResponseBody
	public ResultMap articledetail (TribeVo tribeVo ,@PathVariable Integer type) {
		if (tribeVo.getUserid() == null) {return ResultMap.build(400, "请登录");}
		if (tribeVo.getArticledetailid() == null) {return ResultMap.build(400, "你访问的物品不存在");}
		//这里是处理浏览量的操作
		Browse browse = new Browse();
		browse.setUserid(tribeVo.getUserid());//浏览人主键
		browse.setOtherid(tribeVo.getArticledetailid());//浏览物品的主键
		browse.setType(type);
		//获取浏览的图片
		ArticleDetailCustomer articleDetailCustomer = tribeService.articledetail(tribeVo);
		if (!"".equals(articleDetailCustomer.getPicture()) && articleDetailCustomer.getPicture() != null) {
			browse.setTitle(articleDetailCustomer.getPicture().split(",")[0]);
		} else {
			browse.setTitle(articleDetailCustomer.getTypename());
		}
		browse.setFollowUserId(articleDetailCustomer.getUserid());//被浏览人主键
		//browseService.addBrowse(browse, type);
		return ResultMap.IS_200(articleDetailCustomer);
	}
	
	//余额支付增值服务
	@RequestMapping ("/tribe/articledetailpay") 
	@ResponseBody
	public ResultMap articledetailpay (Long userid,Long monery,Long articledetailid) {
		ResultMap resultMap = tribeService.articledetailpay(userid,monery,articledetailid);
		return resultMap;
	}
	
	//我的增值服务
	@RequestMapping("/tribe/myarticledetail")
	@ResponseBody
	public ResultMap myarticledetail (TribeVo tribeVo,
			@RequestParam(defaultValue = "0") String currentpage,@RequestParam(defaultValue = "7") int pagesize) {
		Map<String , Object> map = new HashMap<>();
		Integer infocount = tribeService.myarticledetailCount(tribeVo);
		PageQuery pagequery = new PageQuery();
		pagequery.setPageParams(infocount, pagesize, Integer.parseInt(currentpage));
		map.put("pagequery", pagequery);
		tribeVo.setPagequery(pagequery);
		List<ArticleDetailCustomer> myarticledetails = tribeService.myarticledetail(tribeVo);
		map.put("myarticledetails", myarticledetails);
		return ResultMap.IS_200(map);
	}
	
	//移除articledetail 根据主键ID
	@RequestMapping("/tribe/removemyarticledetail")
	@ResponseBody
	public ResultMap removearticledetail(Long articledetailid,Long userid) {
		ResultMap resultMap =tribeService.removearticledetail(articledetailid,userid );
		return resultMap;
	} 
	
	//更新articledetail
	@RequestMapping("/tribe/updatemyarticledetail")
	@ResponseBody
	public ResultMap updatemyarticledetail(Articledetail articledetail ,Detaileaddress detaileaddress) {
		ResultMap resultMap =tribeService.updatemyarticledetail(articledetail ,detaileaddress);
		return resultMap;
	} 
	
	/**
	 * 编辑的查询
	 * **/
	@RequestMapping("/tribe/searcheditdetail")
	@ResponseBody
	public ResultMap searcheditdetail (Long tribeid , Integer type ) {
		//获取浏览的图片
		TribeCustomer tribeCustomer = tribeService.getTribetailbyid(tribeid, type, null);
		if (CheckDataUtil.checkisEmpty(tribeCustomer)) 
			{return ResultMap.build(400, "查无数据");}
		return ResultMap.IS_200(tribeCustomer);
	}
	
	
	/**查询部落里面的物品**/
	@RequestMapping("/tribe/detailIntribe/{type}")
	@ResponseBody
	public ResultMap detailIntribe(Long tribeid ,@RequestParam(defaultValue="1")Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize,@PathVariable Integer type) {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = tribeService.detailIntribe(pagequery , tribeid,type);
		List<ArticleDetailCustomer> detailList = result.getDetaillist();
		int infoCount = result.getRecordCount();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		map.put("detailList", detailList);
		map.put("pagequery", pagequery);
		return ResultMap.IS_200(map);
	}
	
	/**部落页面查询物品的列表**/
	@RequestMapping("/tribe/indexHortTribe")
	@ResponseBody
	public ResultMap indexHortTribe(TribeVo tribeVo ,@RequestParam(defaultValue="1") Integer currentpage , 
		@RequestParam(defaultValue="8")	Integer pagesize) {
		Map<String, Object> map = new HashMap<>();
		PageQuery pagequery = new PageQuery();
		pagequery.setCurrentpage(currentpage);
		pagequery.setPagesize(pagesize);
		SearchResult result = tribeService.indexHortTribe(tribeVo.getAddressCustomer() ,
				pagequery);
		List<ArticleDetailCustomer> indexHorstList = result.getDetaillist();
		int infoCount = result.getRecordCount();
		pagequery.setPageParams(infoCount, pagesize, currentpage);
		map.put("pagequery", pagequery);
		map.put("indexHorstList", indexHorstList);
		return ResultMap.IS_200(map);
	}
	
	
	/**编辑物品规格参数的查询**/
	@RequestMapping("/tribe/articleEditSearch")
	@ResponseBody
	public ResultMap articleEditSearch (Long onetypeid) {
		ResultMap resultMap = tribeService.articleEditSearch(onetypeid);
		return resultMap;
	}
	
	
	/**编辑物品规格参数**/
	@RequestMapping("/tribe/editarticletype")
	@ResponseBody
	public ResultMap editarticletype (Long onetypeid , String typename , String codeids) {
		if (CheckDataUtil.checkNotEmpty(codeids)) 
			{ codeids = codeids.substring(0, codeids.length() -1 ); }
		ResultMap resultMap = tribeService.editarticletype(onetypeid , typename , codeids);
		return resultMap;
	}
}
