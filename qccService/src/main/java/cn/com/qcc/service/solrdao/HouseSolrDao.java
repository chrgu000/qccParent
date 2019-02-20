package cn.com.qcc.service.solrdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.SearchResult;

@Service
public class HouseSolrDao {

	@Resource
	private SolrServer houseSolrServer;

	/** 房源一键导入索引库 包括那个增值服务器 **/
	public ResultMap AddAllHouseToSolr(List<HouseCustomer> houseList) {
		try {
			Thread.sleep(1000);
			for (HouseCustomer house : houseList) {
				SolrInputDocument document = new SolrInputDocument();
				// 文档主键也 string
				document.addField("id", IDUtils.genItemId());
				document.addField("username", house.getUser_name());
				document.addField("houseid", house.getHouseid());
				document.addField("villageid", house.getVillageid());
				document.addField("picture", house.getPicture());
				// 房源发布的标题 string
				document.addField("housetitle", house.getHousetitle());
				// 更新时间date
				document.addField("update_time", house.getUpdate_time());
				// 一张图片 string
				document.addField("onepicture", house.getOnepicture());
				// 用户id long
				document.addField("userid", house.getUserid());
				// 价格 string
				String prices = house.getPrices();
				if (CheckDataUtil.checkisEqual(house.getPropertyname(), "二手房")) {
					Double totalprices = Integer.parseInt(prices) * house.getArea();
					document.addField("prices", totalprices);
				} else {
					document.addField("prices", prices);
				}

				// 价格类型 string
				document.addField("pricetype", house.getPricetype());
				// 浏览量 long
				document.addField("bcount", house.getBcount());
				// 总赞
				document.addField("zcount", house.getZcount());
				// 总留言
				document.addField("mcount", house.getMcount());
				// 楼栋id long
				document.addField("buildingid", house.getBuildingid());
				// 品牌id long
				document.addField("brandid", house.getBrandid());
				// 房子是否可以租
				document.addField("schedule", house.getSchedule());
				// 房子的状态
				document.addField("housestatus", house.getHousestatus());
				// 房子的类型是租的还是卖的
				document.addField("housetype", house.getHoustatus());
				// 还要判断是房子还是增值物品 0 房子
				document.addField("articletypeid", house.getArticletypeid());
				// 经纬度
				String latlng = (house.getLatitude() == null ? "12" : house.getLatitude()) + ","
						+ (house.getLongitude() == null ? "114" : house.getLongitude());
				document.addField("latlng", latlng);
				// 户型几室几厅
				document.addField("apartmentname", house.getApartmentname());
				// 站点
				document.addField("finalstop", house.getFinalstop());
				// 地铁名称
				document.addField("metroname", house.getMetroname());
				// 整租合租 long
				document.addField("metroid", house.getMetroid());
				// 装修类型
				document.addField("redecorat", house.getRedecorat());
				// 区域的code
				document.addField("likecode", house.getLikecode());
				// 地铁区域的code
				document.addField("citycode", house.getCode());
				// 面积
				document.addField("area", house.getArea());
				// 房屋的标签
				document.addField("housetagid", house.getHousetag_id());
				// 房屋的标签
				document.addField("propertyname", house.getPropertyname());
				// 房屋的标签
				document.addField("avatar", house.getAvatar());
				document.addField("brand", house.getBrand());
				document.addField("villagename", house.getVillagename());
				document.addField("building", house.getBuilding());
				document.addField("trading", house.getTrading());
				document.addField("description", house.getDescription());
				document.addField("tribeids", house.getTribeids());
				document.addField("propertyid", house.getProperty_id());
				document.addField("tribepicture", house.getTribepicture());
				document.addField("house_number", house.getHouse_number());
				document.addField("paystyle", house.getPaystyle());
				houseSolrServer.add(document);
			}
			houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "housedetail导入失败");
		}
		return ResultMap.IS_200();
	}

	public SearchResult findHouseByTime(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 距离
				item.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 地铁路线
				item.setMetroname((String) solrDocument.get("metroname"));
				// 地铁站点
				item.setFinalstop((String) solrDocument.get("finalstop"));
				// 价格
				item.setPrices(IDUtils.doubletoint((Double) solrDocument.get("prices"), 1) + "");
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 价格单位
				item.setAvatar((String) solrDocument.get("avatar"));
				// 是否可以预定...
				item.setSchedule(Integer.parseInt((String) solrDocument.get("schedule")));
				// 品牌名称
				item.setBrand((String) solrDocument.get("brand"));
				// 品牌名称
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				// 用户id
				item.setUserid((Long) solrDocument.get("userid") + "");
				item.setUser_id((Long) solrDocument.get("userid"));
				item.setBuilding((String) solrDocument.get("building"));
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setArea((Double) solrDocument.get("area"));
				item.setApartmentname((String) solrDocument.get("apartmentname"));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SearchResult getNearDetail(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 距离
				// item.setJuli(IDUtils.doubletoint(
				// (double)solrDocument.get("juli") ,1000 ));
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 价格
				item.setPrices((Double) solrDocument.get("prices") + "");
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 价格单位
				item.setAvatar((String) solrDocument.get("avatar"));
				// 品牌名称
				item.setBrand((String) solrDocument.get("brand"));
				item.setUser_name((String) solrDocument.get("username"));
				// 品牌名称
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				// 用户id
				item.setArticletypeid(Integer.parseInt((String) solrDocument.get("articletypeid")));
				item.setUserid((Long) solrDocument.get("userid") + "");
				item.setUser_id((Long) solrDocument.get("userid"));
				item.setBuilding((String) solrDocument.get("building"));
				// 是否可以预定...
				String schell = (String) solrDocument.get("schedule");
				if (CheckDataUtil.checkNotEmpty(schell)) {
					item.setSchedule(Integer.parseInt(schell));
				}
				
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setArea((Double) solrDocument.get("area"));
				item.setBcount((Long) solrDocument.get("bcount"));
				item.setZcount((Long) solrDocument.get("zcount"));
				item.setMcount((Long) solrDocument.get("mcount"));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 查询本小区房源或者本楼栋房源 **/
	public SearchResult searchVillageHouseorBuildingHouse(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 价格
				item.setPrices((Double) solrDocument.get("prices") + "");
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 用户id
				item.setUserid((Long) solrDocument.get("userid") + "");
				// 面积
				item.setArea((Double) solrDocument.get("area"));
				// 户型
				item.setApartmentname((String) solrDocument.get("apartmentname"));
				// 是否可以预定...
				item.setSchedule(Integer.parseInt((String) solrDocument.get("schedule")));
				// 房子的状态
				item.setHousestatus((String) solrDocument.get("housestatus"));
				// 房间号码
				item.setHouse_number((String) solrDocument.get("house_number"));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SearchResult findHouseByVillage2(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 房子的状态
				item.setHousestatus((String) solrDocument.get("housestatus"));
				// 房间号码
				item.setHouse_number((String) solrDocument.get("house_number"));
				item.setProperty_id(Integer.parseInt((String) solrDocument.get("propertyid")));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 一个房子同步索引库 **/
	public void AddOneHouseToSolr(HouseCustomer house) {
		oneHouseDeleteFromSolr(house);
		try {
			Thread.sleep(1000);
			SolrInputDocument document = new SolrInputDocument();
			// 文档主键也 string
			document.addField("id", IDUtils.genItemId());
			document.addField("paystyle", house.getPaystyle());
			document.addField("houseid", house.getHouseid());
			document.addField("villageid", house.getVillageid());
			// 房源发布的标题 string
			document.addField("housetitle", house.getHousetitle());
			// 更新时间date
			document.addField("update_time", house.getUpdate_time());
			// 一张图片 string
			document.addField("onepicture", house.getOnepicture());
			document.addField("picture", house.getPicture());
			// 用户id long
			document.addField("userid", house.getUserid());
			// 价格 string
			String prices = house.getPrices();
			if (CheckDataUtil.checkisEqual(house.getPropertyname(), "二手房")) {
				Double totalprices = Integer.parseInt(prices) * house.getArea();
				document.addField("prices", totalprices);
			} else {
				document.addField("prices", prices);
			}
			document.addField("propertyid", house.getProperty_id());
			// 价格类型 string
			document.addField("pricetype", house.getPricetype());
			// 浏览量 long
			document.addField("bcount", house.getBcount());
			// 总赞
			document.addField("zcount", house.getZcount());
			// 总留言
			document.addField("mcount", house.getMcount());
			// 楼栋id long
			document.addField("buildingid", house.getBuildingid());
			// 品牌id long
			document.addField("brandid", house.getBrandid());
			// 房子是否可以租
			document.addField("schedule", house.getSchedule());
			// 房子的状态
			document.addField("housestatus", house.getHousestatus());
			// 房子的类型是租的还是卖的
			document.addField("housetype", house.getHoustatus());
			// 还要判断是房子还是增值物品 0 房子
			document.addField("articletypeid", house.getArticletypeid());
			// 经纬度
			String latlng = (house.getLatitude() == null ? "12" : house.getLatitude()) + ","
					+ (house.getLongitude() == null ? "114" : house.getLongitude());
			document.addField("latlng", latlng);
			// 户型几室几厅
			document.addField("apartmentname", house.getApartmentname());
			// 站点
			document.addField("finalstop", house.getFinalstop());
			// 地铁名称
			document.addField("metroname", house.getMetroname());
			// 整租合租 long
			document.addField("metroid", house.getMetroid());
			// 装修类型
			document.addField("redecorat", house.getRedecorat());
			// 区域的code
			document.addField("likecode", house.getLikecode());
			// 地铁区域的code
			document.addField("citycode", house.getCode());
			// 面积
			document.addField("area", house.getArea());
			// 房屋的标签
			document.addField("housetagid", house.getHousetag_id());
			// 房屋的标签
			document.addField("propertyname", house.getPropertyname());
			// 房屋的标签
			document.addField("avatar", house.getAvatar());
			document.addField("brand", house.getBrand());
			document.addField("villagename", house.getVillagename());
			document.addField("building", house.getBuilding());
			document.addField("trading", house.getTrading());
			document.addField("description", house.getDescription());
			document.addField("tribeids", house.getTribeids());
			document.addField("username", house.getUser_name());
			document.addField("tribepicture", house.getTribepicture());
			document.addField("tribename", house.getTribename());
			document.addField("house_number", house.getHouse_number());
			houseSolrServer.add(document);
			houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void oneHouseDeleteFromSolr(HouseCustomer houseCustomer) {
		StringBuffer query = new StringBuffer();
		query.append("houseid:" + houseCustomer.getHouseid() + "");
		query.append(" AND articletypeid:" + houseCustomer.getArticletypeid() + "");
		try {
			houseSolrServer.deleteByQuery(query.toString());
			houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	public SearchResult findHouseBySize(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 距离
				item.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 地铁路线
				item.setMetroname((String) solrDocument.get("metroname"));
				// 地铁站点
				item.setFinalstop((String) solrDocument.get("finalstop"));
				// 价格
				item.setPrices(IDUtils.doubletoint((Double) solrDocument.get("prices"), 1) + "");
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 价格单位
				item.setAvatar((String) solrDocument.get("avatar"));
				// 品牌名称
				item.setBrand((String) solrDocument.get("brand"));
				// 是否可以预定...
				item.setSchedule(Integer.parseInt((String) solrDocument.get("schedule")));
				// 品牌名称
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				// 用户id
				item.setUserid((Long) solrDocument.get("userid") + "");
				item.setUser_id((Long) solrDocument.get("userid"));
				item.setBuilding((String) solrDocument.get("building"));
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setArea((Double) solrDocument.get("area"));
				item.setApartmentname((String) solrDocument.get("apartmentname"));
				String latlng = (String) solrDocument.get("latlng");
				if (CheckDataUtil.checkNotEmpty(latlng)) {
					item.setLatitude(latlng.split(",")[0]);
					item.setLongitude(latlng.split(",")[1]);
				}
				
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SearchResult findHouseBycadition(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 距离
				item.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 地铁路线
				item.setMetroname((String) solrDocument.get("metroname"));
				// 地铁站点
				item.setFinalstop((String) solrDocument.get("finalstop"));
				// 价格
				item.setPrices(IDUtils.doubletoint((Double) solrDocument.get("prices"), 1) + "");
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 价格单位
				item.setAvatar((String) solrDocument.get("avatar"));
				// 是否可以预定...
				item.setSchedule(Integer.parseInt((String) solrDocument.get("schedule")));
				// 品牌名称
				item.setBrand((String) solrDocument.get("brand"));
				// 品牌名称
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				// 用户id
				item.setUserid((Long) solrDocument.get("userid") + "");
				item.setUser_id((Long) solrDocument.get("userid"));
				item.setBuilding((String) solrDocument.get("building"));
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setArea((Double) solrDocument.get("area"));
				item.setApartmentname((String) solrDocument.get("apartmentname"));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SearchResult findHouseByCategory(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 距离
				item.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 地铁路线
				item.setMetroname((String) solrDocument.get("metroname"));
				// 地铁站点
				item.setFinalstop((String) solrDocument.get("finalstop"));
				// 价格
				item.setPrices(IDUtils.doubletoint((Double) solrDocument.get("prices"), 1) + "");
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 价格单位
				item.setAvatar((String) solrDocument.get("avatar"));
				// 品牌名称
				item.setBrand((String) solrDocument.get("brand"));
				// 品牌名称
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				// 用户id
				item.setUserid((Long) solrDocument.get("userid") + "");
				item.setUser_id((Long) solrDocument.get("userid"));
				item.setBuilding((String) solrDocument.get("building"));
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setArea((Double) solrDocument.get("area"));
				item.setApartmentname((String) solrDocument.get("apartmentname"));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SearchResult findoldhouse(SolrQuery query) {
		try {
			// 根据query查询索引库
			QueryResponse queryResponse = houseSolrServer.query(query);
			// 取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			// 取查询结果总记录数
			int numFound = Integer.parseInt(solrDocumentList.getNumFound() + "");
			SearchResult result = new SearchResult();
			result.setRecordCount(numFound);
			List<HouseCustomer> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : solrDocumentList) {
				HouseCustomer item = new HouseCustomer();
				// id 主键
				item.setHouseid((Long) solrDocument.get("houseid"));
				// 距离
				item.setJuli(IDUtils.doubletoint((double) solrDocument.get("juli"), 1000));
				// 一张图片
				item.setOnepicture((String) solrDocument.get("onepicture"));
				// 地铁路线
				item.setMetroname((String) solrDocument.get("metroname"));
				// 地铁站点
				item.setFinalstop((String) solrDocument.get("finalstop"));
				// 价格
				Integer pricesTotal = IDUtils.doubletoint((Double) solrDocument.get("prices"), 1);
				if (pricesTotal > 10000) {
					item.setHouseprice(pricesTotal / 10000.0 + "万");
				} else {
					item.setHouseprice(pricesTotal + "");
				}
				item.setPricetype((String) solrDocument.get("pricetype"));
				// 价格单位
				item.setAvatar((String) solrDocument.get("avatar"));
				// 品牌名称
				item.setTrading((String) solrDocument.get("trading"));
				// 品牌名称
				item.setUpdate_time((Date) solrDocument.get("update_time"));
				// 用户id
				item.setUserid((Long) solrDocument.get("userid") + "");
				item.setUser_id((Long) solrDocument.get("userid"));
				item.setBuilding((String) solrDocument.get("building"));
				item.setVillagename((String) solrDocument.get("villagename"));
				item.setArea((Double) solrDocument.get("area"));
				item.setApartmentname((String) solrDocument.get("apartmentname"));
				itemList.add(item);
			}
			result.setHouselist(itemList);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void queryAll() throws SolrServerException {
		// 创建solrQuery对象
		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
		query.add("fq", "tribeid:[1 TO *]");
		/* 分组 */
		// 是否分组
		query.setParam("group", true);
		// 分组的字段，不可以是多值字段
		query.setParam("group.field", "tribeid");
		// 分组中每个组的上限数量，默认为1
		query.setParam("group.limit", "1");
		// 分布式模式使用分组，并返回分组数量
		query.setParam("group.ngroups", "true");
		// 设置start，开始的组
		query.setStart(0);
		// 设置rows，返回多少组
		query.setRows(10);
		// 执行搜索，返回response对象
		query.addSort("update_time",ORDER.desc);
		QueryResponse rq = houseSolrServer.query(query);
		// 从response中获取想要的结果，因为结构与正常搜索的结构不一致，所以取数据时与普通搜索获取数据不一样
		GroupResponse groupResponse = rq.getGroupResponse();
		List<GroupCommand> groupCommandList = groupResponse.getValues();
//		SolrDocumentList solrDocumentList = new SolrDocumentList();
//		long count = 0;
//		long groupNum = 0;
		SearchResult result = new SearchResult();
		List<ArticleDetailCustomer> itemList = new ArrayList<>();
		// 判断是否为空
		if (groupCommandList != null && groupCommandList.size() > 0) {
			/*// 匹配出的结果总数
			count = groupCommandList.get(0).getMatches();
			// 分组总数
			groupNum = groupCommandList.get(0).getNGroups();*/
			result.setRecordCount(groupCommandList.get(0).getNGroups());
			List<Group> groupList = groupCommandList.get(0).getValues();
			// 遍历返回的每个分组
			for (Group group : groupList) {
				// 若为普通搜索的结果则只有一条；若为分组详情则只有一组，将一组全部放入
				for (SolrDocument solrDocument : group.getResult()) {
					// 将分组中的数放入最后一个参数
					ArticleDetailCustomer detailCustomer = new ArticleDetailCustomer();
					//取出详情的id
					detailCustomer.setArticledetailid((Long) solrDocument.get("houseid") );
					//部落id
					detailCustomer.setTribeids((String )solrDocument.get("tribeids"));
					//部落名称
					detailCustomer.setTribename( (String)solrDocument.get("typename"));
					detailCustomer.setTitle((String) solrDocument.get("housetitle"));
					// 部落图片
					detailCustomer.setTribepicture( (String)solrDocument.get("tribepicture"));
					// 发布时间
					detailCustomer.setUpdate_time((Date) solrDocument.get("update_time"));
					// 物品图片
					detailCustomer.setOnepicture((String) solrDocument.get("onepicture"));
					// 物品类型id
				//	detailCustomer.setArticletypeid( (Long)solrDocument.get("articletypeid"));
					//加入集合中
					itemList.add(detailCustomer);
				}
				
				result.setDetaillist(itemList);
			}
		}
	}

	public ResultMap deletehousebypagequery(PageQuery pagequery) {

			try {
				String query = "houseid:["+pagequery.getPagestart()+" TO "+pagequery.getPageend()+"]";
				houseSolrServer.deleteByQuery(query);
				houseSolrServer.commit();
			} catch (Exception e) {
				
				return ResultMap.build(400, "删除失败");
			}
			return ResultMap.IS_200();
		
	}
	
	public void deletehousebyhouseid(Long houseid) {
		try {
			//String query = "houseid:"+houseid+" articletypeid:1";
			//houseSolrServer.deleteByQuery(query);
			//houseSolrServer.deleteById(id, commitWithinMs)
			houseSolrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
