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
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.SearchResult;

@Service
public class BuilSolrDao {
	
	@Resource
	private SolrServer builSolrServer;

	public ResultMap AllBuildingToSolr(List<BuildingCustomer> allBuilding) {
		//deleteAll();
		try {
			
		
		for (BuildingCustomer buil : allBuilding) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("buildingid", buil.getBuildingid());
			// 经纬度
			String latlng = (buil.getLatitude() == null ? "12" : buil.getLatitude()) + ","
					+ (buil.getLongitude() == null ? "114" : buil.getLongitude());
			document.addField("latlng", latlng);
			document.addField("trading", buil.getTrading());
			document.addField("count", buil.getCount());
			document.addField("citycode", buil.getCitycode());
			document.addField("likecode", buil.getLikecode());
			document.addField("finalstop", buil.getFinalstop());
			document.addField("metroname", buil.getMetroname());
			document.addField("avatar", buil.getAvatar());
			document.addField("district", buil.getDistrict());
			document.addField("avgprices", buil.getAvgprices());
			document.addField("onepicture", buil.getOnepicture());
			document.addField("brand", buil.getBrand());
			document.addField("redecorat", buil.getRedecorat());
			document.addField("propertyright", buil.getPropertyright());
			document.addField("apartmentname", buil.getApartmentname());
			document.addField("building", buil.getBuilding());
			document.addField("paystyle", buil.getPaystyle());
			document.addField("villageid", buil.getVillageid());
			document.addField("brandid", buil.getBrandid());
			document.addField("metroid", buil.getMetroid());
			document.addField("update_time", buil.getUpdate_time());
			builSolrServer.add(document);
		}
		builSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "服务器异常导入失败!!!!");
		}
		
		return ResultMap.build(200, "导入成功");
	}


	public SearchResult searchBuilindgList(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = builSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<BuildingCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				BuildingCustomer item = new BuildingCustomer();
				item.setBuildingid(Long.valueOf( (String)solrDocument.get("buildingid") )  );
				item.setTrading( (String) solrDocument.get("trading"));
				String count = (String) solrDocument.get("count");
				if (CheckDataUtil.checkisEmpty(count)) {
					item.setCount(0);
				} else {
					item.setCount(Integer.parseInt(count));
				}
				item.setMetroname((String) solrDocument.get("metroname"));
				item.setFinalstop((String) solrDocument.get("finalstop"));
				item.setAvatar((String) solrDocument.get("avatar"));
				item.setDistrict((String) solrDocument.get("district"));
				// 距离
				item.setJuli(IDUtils.doubletoint( (double)solrDocument.get("juli") ,1000 ));
				item.setAvgprices((Double)solrDocument.get("avgprices"));
				item.setOnepicture((String) solrDocument.get("onepicture"));
				item.setBuilding((String) solrDocument.get("building"));
				item.setUpdate_time((Date)solrDocument.get("update_time"));
				itemList.add(item);
			}
			result.setBuildinglist(itemList);
			return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
		}
	}


	public ResultMap deleteBuildingFromSolr(PageQuery pagequery) {
		
		try {
			String query = "buildingid:["+pagequery.getPagestart()+" TO "+pagequery.getPageend()+"]";
			builSolrServer.deleteByQuery(query);
			builSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "清楚失败!!");
		}
		return ResultMap.IS_200();
	}
	
	

}
