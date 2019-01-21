package cn.com.qcc.service.solrdao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.DateUtilForMart;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.SearchResult;
@SuppressWarnings({ "unused", "deprecation" })
@Service
public class QiuzuSolrDao {

	@Resource
	private SolrServer qizuSolrServer;
	@Autowired
	private QiuZuCustomerMapper qiuZuCustomerMapper;

	public SearchResult searchBuilindgList(SolrQuery solrQuery)  {
		
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = qizuSolrServer.query(solrQuery);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound =  Integer.parseInt(solrDocumentList.getNumFound()+""  ) ;
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<BuildingCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				BuildingCustomer item = new BuildingCustomer();
				item.setBuildingid((long) solrDocument.get("buildingid"));
				item.setOnepicture((String) solrDocument.get("onepicture"));
				item.setAvgprices((double)solrDocument.get("avgprices"));
				item.setMetroname((String)solrDocument.get("metroname"));
				item.setLatlng((String)solrDocument.get("latlng"));
				item.setAvatar((String)solrDocument.get("avatar"));
				item.setFinalstop((String)solrDocument.get("finalstop"));
				item.setTrading((String)solrDocument.get("trading"));
				item.setVillagename((String)solrDocument.get("villagename"));
				item.setDistrict((String)solrDocument.get("district"));
				item.setCount((Integer)solrDocument.get("count"));
				item.setMetrocode((String)solrDocument.get("metrocode"));
				item.setLatitude((String) solrDocument.get("latitude"));
				item.setLongitude((String) solrDocument.get("longitude"));
				item.setBuilding((String)solrDocument.get("building"));
				itemList.add(item);
			}
			result.setBuildinglist(itemList);
			// 返回结果
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	
	public SearchResult searchqiuzuList(SolrQuery solrQuery) {
		
		SearchResult result = new SearchResult();
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = qizuSolrServer.query(solrQuery);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			long numFound = solrDocumentList.getNumFound();
			result.setRecordCount(Integer.parseInt(numFound+"" ));
			List<QiuzuCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				QiuzuCustomer item = new QiuzuCustomer();
				item.setQiuzuid( Long.valueOf((String)solrDocument.get("id")) );
				item.setMetroname((String)solrDocument.get("metroname"));
				item.setAvatar((String)solrDocument.get("avatar"));
				item.setJuli( IDUtils.doubletoint( (double)solrDocument.get("juli") ,1000 ));
				item.setFinalstop((String)solrDocument.get("finalstop"));
				item.setTrading((String)solrDocument.get("trading"));
				item.setDistrict((String)solrDocument.get("district"));
				item.setPrice((String)solrDocument.get("detailprice"));
				item.setMetroid((Long)solrDocument.get("metroid"));
				item.setCode((String)solrDocument.get("code"));
				item.setClassification((String)solrDocument.get("classification"));
				//item.setUpdatetime((String)solrDocument.get("create_time"));
				item.setCreate_time((Date)solrDocument.get("create_time"));
				item.setHousetype((String)solrDocument.get("housetype"));
				itemList.add(item);
			}
			result.setQiuzulist(itemList);
			// 返回结果
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
	}

	private BigDecimal BigDecimal(Object object) {
		// TODO Auto-generated method stub
		return null;
	}



	/**求租一键导入索引库**/
	public ResultMap qiuzuaddtosolr(List<QiuzuCustomer> qiuzulist) {
		try {
		for (QiuzuCustomer qiuzuCustomer : qiuzulist) {
				SolrInputDocument document = new SolrInputDocument();
				// 文档主键也就是求租id
				document.addField("id",qiuzuCustomer.getQiuzuid());
				//地铁名称
				document.addField("metroname", qiuzuCustomer.getMetroname());
				//站点名称
				document.addField("finalstop", qiuzuCustomer.getFinalstop());
				//求租的价格字符串的
				document.addField("detailprice", qiuzuCustomer.getPrice());
				//求租的价格字符串的
				document.addField("qiuzustatus", qiuzuCustomer.getQiuzustatus());
				//求租分类
				document.addField("classification", qiuzuCustomer.getClassification());
				//设置的经纬度方便查询距离和排序
				String latlng =( qiuzuCustomer.getLatitude()<=0 ? 22.0:qiuzuCustomer.getLatitude() )+","
						+  (qiuzuCustomer.getLongitude()<=0 ? 114.0:qiuzuCustomer.getLongitude() )	;
				document.addField("latlng", latlng );
				//求租的更新时间
				document.addField("create_time", qiuzuCustomer.getCreate_time());
				//发布的userid
				document.addField("userid", qiuzuCustomer.getUser_id());
				//区域
				document.addField("district", qiuzuCustomer.getDistrict());
				//街道
				document.addField("trading", qiuzuCustomer.getTrading());
				//用户头像
				document.addField("avatar", qiuzuCustomer.getAvatar());
				//求租的区域
				document.addField("code", qiuzuCustomer.getCode());
				//地铁城市的code
				document.addField("citycode", qiuzuCustomer.getCitycode());
				//地铁的主键
				document.addField("metroid", qiuzuCustomer.getMetroid());
				//户型
				document.addField("housetype", qiuzuCustomer.getHousetype());
				qizuSolrServer.add(document);
		}
		qizuSolrServer.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResultMap.IS_200();
	}


	
	/**把一条求租信息导入索引库 或者 同步索引库**/
	public void oneQiuzuToSolr(QiuzuCustomer qiuzuCustomer) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			// 文档主键也就是求租id
			document.addField("id",qiuzuCustomer.getQiuzuid());
			//地铁名称
			document.addField("metroname", qiuzuCustomer.getMetroname());
			//站点名称
			document.addField("finalstop", qiuzuCustomer.getFinalstop());
			//求租的价格字符串的
			document.addField("detailprice", qiuzuCustomer.getPrice());
			//求租的价格字符串的
			document.addField("qiuzustatus", qiuzuCustomer.getQiuzustatus());
			//求租分类
			document.addField("classification", qiuzuCustomer.getClassification());
			//设置的经纬度方便查询距离和排序
			String latlng =( qiuzuCustomer.getLatitude()<=0 ? 22.0:qiuzuCustomer.getLatitude() )+","
					+  (qiuzuCustomer.getLongitude()<=0 ? 114.0:qiuzuCustomer.getLongitude() )	;
			document.addField("latlng", latlng );
			//求租的更新时间
			document.addField("create_time", qiuzuCustomer.getCreate_time());
			//发布的userid
			document.addField("userid", qiuzuCustomer.getUser_id());
			//区域
			document.addField("district", qiuzuCustomer.getDistrict());
			//街道
			document.addField("trading", qiuzuCustomer.getTrading());
			//用户头像
			document.addField("avatar", qiuzuCustomer.getAvatar());
			//求租的区域
			document.addField("code", qiuzuCustomer.getCode());
			//地铁城市的code
			document.addField("citycode", qiuzuCustomer.getCitycode());
			//地铁的主键
			document.addField("metroid", qiuzuCustomer.getMetroid());
			//户型
			document.addField("housetype", qiuzuCustomer.getHousetype());
			qizuSolrServer.add(document);
			qizuSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteQiuzuFromSolr(Long qiuzuid) {
		try {
			qizuSolrServer.deleteByQuery("id:"+qiuzuid);
			qizuSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void deleteQiuzuBypagequery(PageQuery pagequery) {
		try {
			String query = "id:["+pagequery.getPagestart()+" TO "+pagequery.getPageend()+"]";
			qizuSolrServer.deleteByQuery(query);
			qizuSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
