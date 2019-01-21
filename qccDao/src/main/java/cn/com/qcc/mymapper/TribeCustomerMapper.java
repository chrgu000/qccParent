package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.pojo.Typedetail;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.DetailCustomer;
import cn.com.qcc.queryvo.TribeCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;

public interface TribeCustomerMapper {

	List<TribeCustomer> myjointribe( @Param("userid") Long userid ,@Param("pagequery") PageQuery pagequery);
	Integer myjointribeCount(Long userid);

	TribeCustomer myjointribeexist(@Param("tribeid") Long tribeid, @Param("userid") Long userid);

	// 根据条件查询部落发布的详情
	List<TribeCustomer> findtribedetailbycondition(TribeVo tribeVo);

	// 根据条件查询部落发布的详情
	List<TribeCustomer> findtribedetailbyHouse(TribeVo tribeVo);

	// 根据条件查询部落发布的详情COUNT
	Integer findtribedetailCount(TribeVo tribeVo);

	// 获取城市的部落
	List<Tribetype> getCityTribe();

	// 不可错过的人气部落
	List<TribeCustomer> horttribe(TribeVo tribeVo);

	// 主页加载的商品
	List<TribeCustomer> indextribe(TribeVo tribeVo);

	// 主页加载的总数
	Integer indextribeCount(TribeVo tribeVo);

	// 人气榜单
	List<TribeCustomer> getpopularity();

	// 明星群主
	List<TribeCustomer> getLuncida();

	// 详情的查询
	TribeCustomer getTribetailbyid(@Param("tribeid") Integer tribeid, @Param("type") Integer type);

	// 获取部落成员
	List<TribeCustomer> getTribeuser(@Param("tribeid") Long tribeid
			,@Param("pagequery")PageQuery pagequery);
	Integer getTribeuserCount(Long tribeid);

	// 根据条件查询部落
	List<TribeCustomer> getTribebycondition(TribeVo tribeVo);

	Integer getTribebyconditionCount(TribeVo tribeVo);

	// 物品详情
	ArticleDetailCustomer thingdetail( Long articedetailid);

	// 兴趣部落首页
	List<TribeCustomer> indexhortibe(TribeVo tribeVo);

	// 最近浏览过的部落
	List<TribeCustomer> nearbrotribe(@Param("userid")Long userid ,@Param("pagequery")PageQuery pagequery);

	// 兴趣部落首页
	Integer indexhortibCount(TribeVo tribeVo);

	// 最近浏览过的部落
	Integer nearbrotribeCount(Long userid);

	// 兴趣部落首页最近部落
	List<TribeCustomer> indexhorneartribe(TribeVo tribeVo);

	// 部落签到榜单
	List<UserCustomer> tribesign(@Param("tribeid")Long tribeid ,
			@Param("pagequery")PageQuery pagequery);
	int tribesignCount(Long tribeid);
	
	List<Tribetype> tribecity();
	
	//获得分类下一级
	List<Typedetail> getdetailtype1(Integer articletypeid);
	
	List<ArticleDetailCustomer> getarticlelist(TribeVo tribeVo);

	Integer getarticlelistCount(TribeVo tribeVo);

	ArticleDetailCustomer articledetail(TribeVo tribeVo);

	ArticleDetailCustomer getArticledetailandtype(String articledetailid);

	Integer myarticledetailCount(TribeVo tribeVo);

	List<ArticleDetailCustomer> myarticledetail(TribeVo tribeVo);
	
	/**一条部落发布详情导入索引库**/
	ArticleDetailCustomer oneArticleDetailToSolr(Long articledetailid);
	
	/**所有部落发布导入索引库**/
	List<ArticleDetailCustomer> searchAllDetailToSolr(@Param("pagequery")PageQuery pagequery);
	
	/**查询规格参数列表**/
	List<Parametype> parametypeList(@Param("idsList")String[] values);
	List<Parametype> parametypeListNot(@Param("idsList")String[] codeid);
	List<Parametype> parametypeListIS(@Param("idsList")String[] codeid);

	
	
	/**根据分类的id查询部落基本信息**/
	int searchtribebyTypeidCount(@Param("userid")Long userid, @Param("tribetypeid")Long tribetypeid);
	List<TribeCustomer> searchtribebyTypeid( @Param("userid") Long userid, 
			@Param("tribetypeid") Long tribetypeid, @Param("pagequery") PageQuery pagequery);
	
	
	/**查询挂到部落的房源**/
	int houseSearchToTribeCount(Long userid);
	List<DetailCustomer> houseSearchToTribe(@Param("userid")Long userid,
			@Param("pagequery")PageQuery pagequery,@Param("detailid")Long detailid);
	
	/**查询求租挂到部落**/
	int qiuzuSearchToTribeCount(Long userid);
	List<DetailCustomer> qiuzuSearchToTribe(@Param("userid")Long userid,
			@Param("pagequery")PageQuery pagequery,@Param("detailid")Long detailid);
	
	
	/**查询类似的部落**/
	List<TribeCustomer> searchLikeTribe(@Param("userid")Long userid, 
			@Param("searchwhere")String searchwhere, @Param("pagequery")PageQuery pagequery);
	int searchLikeTribeCount(@Param("userid")Long userid, @Param("searchwhere")String searchwhere);
	
	/**物品发布挂到部落**/
	int detailSearchToTribeCount(@Param("userid")Long userid , @Param("type") Integer type);
	List<DetailCustomer> detailSearchToTribe(@Param("userid") Long userid ,
		@Param("type")	Integer type ,@Param("pagequery") PageQuery pagequery ,@Param("detailid")Long detailid);
	
	
	/**查询我关注的**/
	List<ArticleDetailCustomer> myfocus(@Param("userid")Long userid,
			@Param("pagequery") PageQuery pagequery ,@Param("articletypeid")Integer articletypeid);
	int myfocusCount(Long userid);
	
	/**根据部落的ids查询部落信息**/
	List<Tribe> searchtribebyids( @Param("idsList")List<String> tribids);
		
	
	
	
	

	
	
}
