package cn.com.qcc.service.solrdao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.SearchResult;

@Service
public class TribeSolrDao {

	@Resource
	private SolrServer houseSolrServer;

	/** 一条部落发布详情导入索引库 **/
	public void oneArticleDetailToSolr(ArticleDetailCustomer articelDeail) {
		oneDetailDeleteFromSolr(articelDeail);
		try {
			Thread.sleep(200);
			SolrInputDocument document = new SolrInputDocument();
			// 文档主键也 string
			document.addField("id", IDUtils.genItemId());
			document.addField("houseid", articelDeail.getArticledetailid());
			// 房源发布的标题 string
			document.addField("housetitle", articelDeail.getTitle());
			// 更新时间date
			document.addField("update_time", articelDeail.getUpdate_time());
			// 一张图片 string
			document.addField("onepicture", articelDeail.getOnepicture());
			document.addField("picture", articelDeail.getPicture());
			document.addField("tribetypeid", articelDeail.getTribetypeid());
			// 用户id long
			document.addField("userid", articelDeail.getUserid());
			document.addField("propertyname", articelDeail.getTypename());
			document.addField("username", articelDeail.getUsername());
			document.addField("videourl", articelDeail.getVideourl());
			document.addField("avatar", articelDeail.getAvatar());
			document.addField("prices", articelDeail.getPrices());
			// 经纬度
			String latlng = (articelDeail.getLatitude() == null ? "12" : articelDeail.getLatitude()) + ","
					+ (articelDeail.getLongitude() == null ? "114" : articelDeail.getLongitude());
			document.addField("latlng", latlng);
			document.addField("trading", articelDeail.getTrading());
			document.addField("description", articelDeail.getDescription());
			String tribeids = articelDeail.getTribeids();
			if (CheckDataUtil.checkisEmpty(tribeids)) 
				{ tribeids = "";}
			document.addField("tribeids", tribeids);
			document.addField("tribename", articelDeail.getTribename());
			document.addField("tribepicture", articelDeail.getTribepicture());
			document.addField("articletypeid", articelDeail.getArticletypeid());
			houseSolrServer.add(document);
			houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void oneDetailDeleteFromSolr(ArticleDetailCustomer detailCustomer) {
		StringBuffer query = new StringBuffer();
		query.append("houseid:" + detailCustomer.getArticledetailid() + "");
		query.append(" AND articletypeid:" + detailCustomer.getArticletypeid() + "");
		try {
			houseSolrServer.deleteByQuery(query.toString());
			houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** 不可错过的人气部落 **/
	/*public SearchResult indexHortTribe(SolrQuery query) {
		SearchResult result = new SearchResult();
		try {
		QueryResponse rq = houseSolrServer.query(query);
		GroupResponse groupResponse = rq.getGroupResponse();
		List<GroupCommand> groupCommandList = groupResponse.getValues();
		List<ArticleDetailCustomer> itemList = new ArrayList<>();
		// 判断是否为空
		System.out.println(groupCommandList.size());
		if (groupCommandList != null && groupCommandList.size() > 0) {
			if (CheckDataUtil.checkNotEmpty(groupCommandList.get(0).getMatches() )) 
				{result.setRecordCount(groupCommandList.get(0).getMatches());}
			List<Group> groupList = groupCommandList.get(0).getValues();
			// 遍历返回的每个分组
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			for (Group group : groupList) {
				// 若为普通搜索的结果则只有一条；若为分组详情则只有一组，将一组全部放入
				for (SolrDocument solrDocument : group.getResult()) {
					ArticleDetailCustomer detailCustomer = new ArticleDetailCustomer();
					detailCustomer.setArticledetailid((Long) solrDocument.get("houseid"));
					Object tribeids = solrDocument.get("tribeids");
					String tribeid = "";
					if (CheckDataUtil.checkNotEmpty(tribeids)) 
						{  
							tribeid = tribeids.toString().split(",")[0];
							detailCustomer.setTribeid(Long.valueOf(tribeid));
						}
					
					detailCustomer.setTribename((String) solrDocument.get("tribename"));
					detailCustomer.setTypename((String) solrDocument.get("propertyname"));
					detailCustomer.setUsername((String) solrDocument.get("username"));
					detailCustomer.setAvatar((String) solrDocument.get("avatar"));
					detailCustomer.setTitle((String) solrDocument.get("housetitle"));
					// 距离
					detailCustomer.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
					detailCustomer.setTribepicture((String) solrDocument.get("tribepicture"));
					detailCustomer.setUpdate_time((Date) solrDocument.get("update_time"));
					detailCustomer.setOnepicture((String) solrDocument.get("onepicture"));
					detailCustomer.setArticletypeid( Integer.parseInt( (String)solrDocument.get("articletypeid")) );
					itemList.add(detailCustomer);
					
				}
			}
			
			result.setDetaillist(itemList);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
	}*/

	public ResultMap AllArticleDetailToSolr(List<ArticleDetailCustomer> detailList) {
		
		try {
			
		
		for (ArticleDetailCustomer articelDeail:detailList) {
			SolrInputDocument document = new SolrInputDocument();
			// 文档主键也 string
			document.addField("id", IDUtils.genItemId());
			document.addField("houseid", articelDeail.getArticledetailid());
			// 房源发布的标题 string
			document.addField("housetitle", articelDeail.getTitle());
			// 更新时间date
			document.addField("update_time", articelDeail.getUpdate_time());
			// 一张图片 string
			document.addField("onepicture", articelDeail.getOnepicture());
			document.addField("picture", articelDeail.getPicture());
			document.addField("tribetypeid", articelDeail.getTribetypeid());
			// 用户id long
			document.addField("userid", articelDeail.getUserid());
			document.addField("propertyname", articelDeail.getTypename());
			document.addField("username", articelDeail.getUsername());
			document.addField("avatar", articelDeail.getAvatar());
			document.addField("prices", articelDeail.getPrices());
			document.addField("videourl", articelDeail.getVideourl());
			// 经纬度
			String latlng = (articelDeail.getLatitude() == null ? "12" : articelDeail.getLatitude()) + ","
					+ (articelDeail.getLongitude() == null ? "114" : articelDeail.getLongitude());
			document.addField("latlng", latlng);
			document.addField("trading", articelDeail.getTrading());
			document.addField("description", articelDeail.getDescription());
			String tribeids = articelDeail.getTribeids();
			if (CheckDataUtil.checkisEmpty(tribeids)) {
				tribeids = "";
			}
			document.addField("tribeids", tribeids);
			document.addField("tribename", articelDeail.getTribename());
			document.addField("tribepicture", articelDeail.getTribepicture());
			document.addField("articletypeid", articelDeail.getArticletypeid());
			houseSolrServer.add(document);
		}
		houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		   return ResultMap.build(400,"导入失败articledetail");
		}
		return ResultMap.IS_200();
	}

	public SearchResult detailIntribe(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<ArticleDetailCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				ArticleDetailCustomer detailCustomer = new ArticleDetailCustomer();
				detailCustomer.setArticledetailid((Long) solrDocument.get("houseid"));
				Object tribeids = solrDocument.get("tribeids");
				String tribeid = "";
				if (CheckDataUtil.checkNotEmpty(tribeids)) 
					{  
						tribeid = tribeids.toString().split(",")[0];
						detailCustomer.setTribeid(Long.valueOf(tribeid));
					}
				
				detailCustomer.setTribename((String) solrDocument.get("tribename"));
				detailCustomer.setTypename((String) solrDocument.get("propertyname"));
				detailCustomer.setUsername((String) solrDocument.get("username"));
				detailCustomer.setAvatar((String) solrDocument.get("avatar"));
				detailCustomer.setTitle((String) solrDocument.get("housetitle"));
				// 距离
				detailCustomer.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				detailCustomer.setTribepicture((String) solrDocument.get("tribepicture"));
				detailCustomer.setUpdate_time((Date) solrDocument.get("update_time"));
				detailCustomer.setOnepicture((String) solrDocument.get("onepicture"));
				detailCustomer.setArticletypeid( Integer.parseInt( (String)solrDocument.get("articletypeid")) );
				itemList.add(detailCustomer);
			}
			result.setDetaillist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public SearchResult indexHortTribe(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<ArticleDetailCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				ArticleDetailCustomer detailCustomer = new ArticleDetailCustomer();
				detailCustomer.setArticledetailid((Long) solrDocument.get("houseid"));
				Object tribeids = solrDocument.get("tribeids");
				String tribeid = "";
				if (CheckDataUtil.checkNotEmpty(tribeids)) 
					{  
						tribeid = tribeids.toString().split(",")[0];
						detailCustomer.setTribeid(Long.valueOf(tribeid));
					}
				detailCustomer.setPicture((String) solrDocument.get("picture"));
				detailCustomer.setTribename((String) solrDocument.get("tribename"));
				detailCustomer.setTypename((String) solrDocument.get("propertyname"));
				detailCustomer.setUsername((String) solrDocument.get("username"));
				detailCustomer.setAvatar((String) solrDocument.get("avatar"));
				detailCustomer.setTitle((String) solrDocument.get("housetitle"));
				detailCustomer.setVideourl((String) solrDocument.get("videourl"));
				// 距离
				detailCustomer.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				detailCustomer.setTribepicture((String) solrDocument.get("tribepicture"));
				detailCustomer.setUpdate_time((Date) solrDocument.get("update_time"));
				detailCustomer.setOnepicture((String) solrDocument.get("onepicture"));
				detailCustomer.setArticletypeid( Integer.parseInt( (String)solrDocument.get("articletypeid")) );
				itemList.add(detailCustomer);
			}
			result.setDetaillist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	

}
