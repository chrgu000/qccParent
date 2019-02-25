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
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Housemodel;
import cn.com.qcc.queryvo.SearchResult;

@Service
public class HouseModelSolrDao {
	
	
	@Resource
	private SolrServer contentSolrServer;
	

	public int checkHouseModel(SolrQuery query) {
		
		
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = contentSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			return numFound ;
		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}
		
	}
	
	
	/**导入房源库**/
	public ResultMap AddToHouseModel(Housemodel houseModel) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			// 文档主键也 string
			document.addField("id", houseModel.getHouseModelId());
			document.addField("houseid", houseModel.getHouseid());
			document.addField("centType",houseModel.getCentType());
			document.addField("userid", houseModel.getUserid());
			document.addField("housetitle", houseModel.getHouseTitle());
			document.addField("updateTime", houseModel.getUpdateTime());
			document.addField("onepicture", houseModel.getPicture().split(",")[0]);
			document.addField("picture", houseModel.getPicture());
			document.addField("prices", houseModel.getPrices());
			document.addField("apartmentname", houseModel.getApartmentName());
			document.addField("redecorat", houseModel.getRedecorat());
			document.addField("citycode", houseModel.getCitycode());
			document.addField("area", houseModel.getArea());
			document.addField("housetagid", houseModel.getHousetagid());
			document.addField("villageName", houseModel.getVillageName());
			document.addField("building", houseModel.getBuilding());
			document.addField("descname", houseModel.getDescname());
			document.addField("houseNumber", houseModel.getHouseNumber());
			document.addField("paystyle", houseModel.getPaystyle());
			document.addField("landphone", houseModel.getLandPhone());
			document.addField("landname", houseModel.getLandName());
			document.addField("detailes", houseModel.getDetailes());
			document.addField("trading", houseModel.getTrading());
			document.addField("district", houseModel.getDistrict());
			document.addField("floor", houseModel.getFloor());
			document.addField("centTime", houseModel.getCentTime());
			document.addField("centState",houseModel.getCentState());
			document.addField("agencyNumber",houseModel.getAgencyNumber());
			document.addField("latlng", houseModel.getLatlng());
			contentSolrServer.add(document);
			contentSolrServer.commit();
			return ResultMap.build(200, "导入成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "导入失败");
		}
		
	}


	


	public ResultMap deleteByQuery(Long houseid,Long userid) {
		StringBuffer query = new StringBuffer();
		query.append("houseid:" + houseid + "");
		query.append(" AND userid:" + userid + "");
		try {
			contentSolrServer.deleteByQuery(query.toString());
			contentSolrServer.commit();
			return ResultMap.build(200, "删除成功" );
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "删除失败");
		} 
		
	}
	
	public Housemodel oneHouseSearch(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = contentSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			Housemodel model = new Housemodel();
			// 取出查询结果其实只有一条
			for (SolrDocument solrDocument : solrDocumentList) {
				model.setHouseModelId(Long.valueOf( (String)solrDocument.get("id") )   );
				model.setHouseid((Long) solrDocument.get("houseid"));
				model.setUserid((Long) solrDocument.get("userid") );
				model.setHouseTitle((String) solrDocument.get("housetitle") );
				model.setUpdateTime((Date) solrDocument.get("updateTime") );
				model.setPicture(  (String) solrDocument.get("picture") );
				model.setPrices((Double) solrDocument.get("prices"));
				model.setApartmentName((String )(solrDocument.get("apartmentname")));
				model.setRedecorat((String) solrDocument.get("redecorat") );
				model.setArea((Double) solrDocument.get("area"));
				model.setHousetagid( (String) solrDocument.get("housetagid"));
				model.setVillageName( (String) solrDocument.get("villageName"));
				model.setBuilding( (String) solrDocument.get("building"));
				model.setDescname((String) solrDocument.get("descname"));
				model.setHouseNumber( (String) solrDocument.get("houseNumber") );
				model.setPaystyle( (String)solrDocument.get("paystyle")  );
				model.setLandPhone((String)solrDocument.get("landphone") );
				model.setLandName( (String) solrDocument.get("landName"));
				model.setDetailes((String) solrDocument.get("detailes"));
				model.setTrading( (String) solrDocument.get("trading")) ;
				model.setDistrict( (String) solrDocument.get("district"));
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public SearchResult houseList(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = contentSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<Housemodel> list = new ArrayList<>();
			// 取出查询结果其实只有一条
			for (SolrDocument solrDocument : solrDocumentList) {
				// 取查询结果总记录数
				Housemodel model = new Housemodel();
				model.setHouseModelId(Long.valueOf( (String)solrDocument.get("id") )    );
				model.setHouseid((Long) solrDocument.get("houseid"));
				model.setUserid((Long) solrDocument.get("userid") );
				//model.setHouseTitle((String) solrDocument.get("housetitle") );
				model.setUpdateTime((Date) solrDocument.get("updateTime") );
				//model.setPicture(  (String) solrDocument.get("picture") );
				model.setOnepicture((String) solrDocument.get("onepicture")  );
				model.setPrices((Double) solrDocument.get("prices"));
				model.setApartmentName((String )(solrDocument.get("apartmentname")));
				model.setRedecorat((String) solrDocument.get("redecorat") );
				model.setArea((Double) solrDocument.get("area"));
				model.setCentType((String) solrDocument.get("centType"));
				//model.setHousetagid( (String) solrDocument.get("housetagid"));
				model.setVillageName( (String) solrDocument.get("villageName"));
				model.setBuilding( (String) solrDocument.get("building"));
				//model.setDescname((String) solrDocument.get("descname"));
				model.setHouseNumber( (String) solrDocument.get("houseNumber") );
				model.setPaystyle( (String)solrDocument.get("paystyle")  );
				model.setLandPhone((String)solrDocument.get("landphone") );
				//model.setLandName( (String) solrDocument.get("landName"));
				//model.setDetailes((String) solrDocument.get("detailes"));
				//model.setTrading( (String) solrDocument.get("trading")) ;
				model.setDistrict( (String) solrDocument.get("district"));
				list.add(model);
			}
			result.setModelList(list);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
