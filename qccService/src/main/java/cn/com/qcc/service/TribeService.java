package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.pojo.Typedetail;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.DetailCustomer;
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.TribeCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;

//部落或者群
public interface TribeService {

	// 创建部落
	ResultMap createtribe(Tribe tribe, Detaileaddress detaileaddress, Tribetype tribetype);

	// 判断部落是否已经存在部落类别的名称，name
	Tribe checkTribe(String name);

	// 加入部落
	ResultMap joinTribe(Long tribeid, Long followUserId);

	// 我创建的部落
	List<Tribe> mytribelist(Long userid);

	// 我加入的部落列表
	List<TribeCustomer> myjointribe(Long userid ,PageQuery  pagequery);
	Integer myjointribeCount(Long userid);


	// 我是否加入过该部落
	TribeCustomer myjointribeexist(Long tribeid, Long userid);

	// 部落签到
	ResultMap usersign(Long tribeid, Long followUserId);

	// 检查部落是否存在
	public Tribe checkjointribe(Long tribeid);

	// 根据条件查询部落发布的详情
	List<TribeCustomer> findtribedetailbycondition(TribeVo tribeVo);

	// 根据条件查询部落发布的详情
	Integer findtribedetailCount(TribeVo tribeVo);

	// 获取城市的部落
	List<Tribetype> getCityTribe();

	// 获取兴趣爱好的的部落
	List<Tribetype> getAvocationTribe();

	// 不可错过的人气部落
	SearchResult  indexHortTribe(AddressCustomer addressCustomer , PageQuery pagequery);

	// 主页加载的部落中每一个商品
	List<TribeCustomer> indextribe(TribeVo tribeVo);

	// 主页加载的部落中每一个商品
	Integer indextribeCount(TribeVo tribeVo);

	// 人气榜单
	List<TribeCustomer> getpopularity();

	// 明星群主
	List<TribeCustomer> getLuncida();

	// 发起提问
	ResultMap pushquestion(Long tribeid, Long userid, String title, Integer type);

	// 部落详情的查询
	TribeCustomer getTribetailbyid(Long tribeid, Integer type,Long userid);

	// 先获取用户ID
	Tribe getTribebyId(Long tribeid);

	// 查询发布的类型
	List<Articletype> getTribeDetailType(Integer type);

	// 部落中物品发布
	ResultMap pushtribedetail( Integer type,  Articledetail articledetail, 
			Detaileaddress detaileaddress,String codeids,Integer count ,double prices);

	// 物品关联部落
	/*void addarticle(Long tribeid, Long articledetailid, Integer type, Long otherid);*/

	// 获取部落成员
	List<TribeCustomer> getTribeuser(Long tribeid,PageQuery pagequery);
	int getTribeuserCount(Long tribeid);

	// 根据条件查询部落
	List<TribeCustomer> getTribebycondition(TribeVo tribeVo);

	Integer getTribebyconditionCount(TribeVo tribeVo);

	// 物品详情查找
	ArticleDetailCustomer thingdetail(Long articedetailid , Long userid);

	Articledetail getArticleDetailbyId(Integer otherid);

	// 兴趣部落首页
	List<TribeCustomer> indexhortibe(TribeVo tribeVo);

	

	// 兴趣部落首页
	Integer indexhortibCount(TribeVo tribeVo);

	// 最近浏览过的部落
	Integer nearbrotribeCount(Long userid);
	List<TribeCustomer> nearbrotribe(Long userid ,PageQuery pagequery);

	// 兴趣部落首页最近部落
	List<TribeCustomer> indexhorneartribe(TribeVo tribeVo);

	// 根据条件查询部落发布的详情
	List<TribeCustomer> findtribedetailbyHouse(TribeVo tribeVo);

	// 部落签到榜单
	List<UserCustomer> tribesign(Long tribeid ,PageQuery pagequery);
	int tribesignCount(Long tribeid);
	
	//部落找人编辑
	ResultMap edittribep(Articletype articletype);
	
	//新增部落找人分类
	ResultMap intribep(String typename,Integer type);
	
	//部落类别名称的编辑
	ResultMap edittype(Tribetype tribetype);
	
	//创建部落类别
	ResultMap createtribetype(Tribetype tribetype, Integer type);
	//城市部落的查询
	ResultMap tribecity();
	
	//更新物品二级分类
	ResultMap updatetypedetail(Typedetail typedetail);
	
	//新增物品二级分类
	ResultMap addtypedetail(Typedetail typedetail);

	List<Parametype> gettypenames(String[] types);

	List<Parametype> isin(String[] str);

	List<Parametype> isnot(String[] str);

	void updatetyepdetail(Typedetail typedetail);
	//查询列表
	List<ArticleDetailCustomer> getarticlelist(TribeVo tribeVo);
	
	Integer getarticlelistCount(TribeVo tribeVo);

	ArticleDetailCustomer articledetail(TribeVo tribeVo);
	//增值服务置顶
	ResultMap articledetailpay(Long userid, Long monery, Long articledetailid);
	//获得详情和type
	ArticleDetailCustomer getArticledetailandtype(String articledetailid);
	//我的发布detailCount
	Integer myarticledetailCount(TribeVo tribeVo);
	//我的发布列表
	List<ArticleDetailCustomer> myarticledetail(TribeVo tribeVo);
	//移除发布的物品
	ResultMap removearticledetail(Long articledetailid, Long userid);
	//更新我的增值服务
	ResultMap updatemyarticledetail(Articledetail articledetail ,Detaileaddress detaileaddress);
	
	/**判断是否是部落成员**/
	boolean checkTribeIn(Long userid , Long typeid);
	
	/**查询部落里面的物品**/
	SearchResult detailIntribe(PageQuery pagequery, Long tribeid, Integer type);

	
	/**根据分类的id查询部落信息**/
	List<TribeCustomer> searchtribebyTypeid(Long userid, Long tribetypeid, PageQuery pagequery);
	int searchtribebyTypeidCount(Long userid, Long tribetypeid);

	/**查询挂到鱼塘的列表**/
	List<DetailCustomer> searchToTribe(Long userid, Integer type, PageQuery pagequery);
	
	
	/**查询类似的部落**/
	List<TribeCustomer> searchLikeTribe(Long userid, String searchwhere, PageQuery pagequery);
	int searchLikeTribeCount(Long userid, String searchwhere);
	
	/**
	 * @param tribeid : 部落id
	 * @param detailid : 详情的主键
	 * @param type : type类型
	 * 
	 * **/
	ResultMap detailToTribe(Long tribeid, Long detailid, Integer type);
	
	/**规格参数编辑的查询**/
	ResultMap articleEditSearch(Long onetypeid);
	
	/**编辑物品规格参数**/
	ResultMap editarticletype(Long onetypeid, String typename, String codeids);
	
	/**查询我关注的**/
	List<ArticleDetailCustomer> myfocus(Long userid, PageQuery pagequery ,Integer articletypeid);
	int myfocusCount(Long userid);

	

	

	}
