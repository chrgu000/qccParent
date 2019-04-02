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
import cn.com.qcc.queryvo.SearchResult;
import cn.com.qcc.queryvo.VillageCustomer;

@Service
public class VillageSolrDao {
	
	@Resource
	private SolrServer villageSolrServer;

	
	/**小区导入索引库**/
	public void addvillagetosolr(List<VillageCustomer> villageList) {
		try {
		for (VillageCustomer village : villageList) {
			SolrInputDocument document = new SolrInputDocument();
			//主键
			document.addField("villageid", village.getVillageid());
			document.addField("finalstop", village.getFinalstop());
			document.addField("villagetypeid", village.getVillagetypeid());
			document.addField("metroname", village.getMetroname());
			document.addField("metroids", village.getMetroids());
			document.addField("keyword", village.getKeyword());
			document.addField("centprices", village.getCentprices());
			document.addField("buyprices", village.getBuyprices());
			document.addField("onepicture", village.getOnepicture());
			document.addField("villagename", village.getVillagename());
			document.addField("trading", village.getTrading());
			document.addField("likecode", village.getLikecode());
			document.addField("citycode", village.getCitycode());
			document.addField("update_time", village.getUpdate_time());
			String latlng = (village.getLatitude() == null ? "12" : village.getLatitude()) + ","
					+ (village.getLongitude() == null ? "114" : village.getLongitude());
			document.addField("latlng", latlng);
			villageSolrServer.add(document);
		}
		villageSolrServer.commit();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	
	
	/**小区导入索引库**/
	public void onevillagetosolr(VillageCustomer village) {
		try {
		
			SolrInputDocument document = new SolrInputDocument();
			//主键
			document.addField("villageid", village.getVillageid());
			document.addField("villagetypeid", village.getVillagetypeid());
			document.addField("finalstop", village.getFinalstop());
			document.addField("metroname", village.getMetroname());
			document.addField("metroids", village.getMetroids());
			document.addField("keyword", village.getKeyword());
			document.addField("centprices", village.getCentprices());
			document.addField("buyprices", village.getBuyprices());
			document.addField("onepicture", village.getOnepicture());
			document.addField("villagename", village.getVillagename());
			document.addField("trading", village.getTrading());
			document.addField("likecode", village.getLikecode());
			document.addField("citycode", village.getCitycode());
			document.addField("update_time", village.getUpdate_time());
			String latlng = (village.getLatitude() == null ? "12" : village.getLatitude()) + ","
					+ (village.getLongitude() == null ? "114" : village.getLongitude());
			document.addField("latlng", latlng);
			villageSolrServer.add(document);
		
		villageSolrServer.commit();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	/**从索引库查询小区列表**/
	public SearchResult searchVillageList(SolrQuery query ,String searchWord ) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = villageSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<VillageCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				VillageCustomer item = new VillageCustomer();
				double avgprices = 0 ;
				if (CheckDataUtil.checkNotEmpty(searchWord)) {
					avgprices = (double)solrDocument.get("centprices");
				} else {
					avgprices = (double)solrDocument.get("buyprices");
				}
				item.setAvgprices(IDUtils.doubletoint(avgprices, 1)*1.0);
				item.setVillageid(Long.valueOf((String) solrDocument.get("villageid")));
				String latlng = (String) solrDocument.get("latlng");
				item.setLatitude(latlng.split(",")[0]);
				item.setLongitude(latlng.split(",")[1] );
				item.setTrading((String) solrDocument.get("trading"));
				item.setMetroname((String) solrDocument.get("metroname"));
				item.setFinalstop((String) solrDocument.get("finalstop"));
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 距离
				item.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				itemList.add(item);
			}
			result.setVillagelist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
