package cn.com.qcc.mess.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ApartmentCustomer;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HousetagCustomer;
import cn.com.qcc.queryvo.PriceCustomer;
import cn.com.qcc.queryvo.PropertyCustomer;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.VillageCustomer;

public class SolrPageUtil {
	
	public static void setStartAndEnd (PageQuery pagequery , SolrQuery query) {
		
		// 通过当前页面和每页计算
		int currentpage = pagequery.getCurrentpage();
		int pagesize = pagequery.getPagesize();
		if (currentpage<=0){currentpage = 1;}
		int start = (currentpage - 1) * pagesize;
		query.setStart(start);
		query.setRows(pagesize);
	}
	
	/**封装距离的查询条件
	 * @param query : 查询语句
	 * @param juli : 查询范围没有传kong
	 * @param addressCustomer : 距离的经纬度
	 * **/
	public static void juliquery( SolrQuery query ,String juli,AddressCustomer addressCustomer) {
		
		String latlng = "22.7143964,114.2705962";
		if (CheckDataUtil.checkNotEmpty(addressCustomer)) {
			if (CheckDataUtil.checkNotEmpty(addressCustomer.getNearLatude() )
					&& CheckDataUtil.checkNotEmpty(addressCustomer.getNearLongitude())) {
				latlng = addressCustomer.getNearLatude() +"," + addressCustomer.getNearLongitude();
			}
		}
		
		// 先封装距离
		if (CheckDataUtil.checkNotEmpty(juli)) {
			
			if (juli.contains("公里")) {
				juli = juli.substring(0, juli.length()-2);
			} else {
				Long killmin = Long.valueOf(juli);
				juli = (killmin / 1000.0 ) +"";
			}
			
			
		}else {
			juli = "8000000";
		}
		query.set("fq", "{!geofilt}");//距离过滤函数
		query.set("sfield","latlng");//存储地理位置的字段名称
		query.set("pt",latlng); //经纬度参数格式为  纬度,经度
		query.set("fl", "*,juli:geodist()");
		query.set("d",juli); //搜索半径千米
		
	}

	public static void apartmentQuery(ApartmentCustomer apartmentCustomer, SolrQuery query) {
		
		if (CheckDataUtil.checkNotEmpty(apartmentCustomer)) {
			// 封装户型 1--- 4 
			if (CheckDataUtil.checkNotEmpty(apartmentCustomer.getApartmentname())) {
				query.add("fq", "apartmentname:*"+apartmentCustomer.getApartmentname()+"*");
			}
			//四室以上
			if (CheckDataUtil.checkNotEmpty(apartmentCustomer.getFourroom())) {
				query.add("fq", "(apartmentname:*五室* or apartmentname:*六室* or apartmentname:*七室* "
						+ "or apartmentname:*八室*  or apartmentname:*九室* or apartmentname:*十室*)");
			}
		}
		
	}

	public static void houseQuery(HouseCustomer houseCustomer, SolrQuery query) {
		
		if (CheckDataUtil.checkNotEmpty(houseCustomer)) {
			// 装修类型
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getRedecorat())) {
				query.add("fq", "redecorat:*"+houseCustomer.getRedecorat()+"*");
			}
			//发布人的条件
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getUserid())) {
				query.add("fq", "userid:"+houseCustomer.getUserid()+"");
			}
			
			// 房源预定
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getSchedule())) {
				query.add("fq", "schedule:"+houseCustomer.getSchedule()+"");
			}
			
			
			//面积
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getSmallarea() )
					&& CheckDataUtil.checkNotEmpty(houseCustomer.getBigarea())) 
			{
				query.add("fq", "area:["+houseCustomer.getSmallarea()+" TO "+houseCustomer.getBigarea()+"]");			
					}
			
			
			//支付方式
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getPaystyle())){
				query.add("fq", "paystyle:*"+houseCustomer.getPaystyle()+"*");
			}
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getDesc())) {
				query.addSort("prices",ORDER.desc);
			}
			if (CheckDataUtil.checkNotEmpty(houseCustomer.getAsc())) {
				query.addSort("prices",ORDER.asc);
			}
			
		}
		
	}

	public static void propertyquery(PropertyCustomer propertyCustomer, SolrQuery query) {
		
		
		if (CheckDataUtil.checkNotEmpty(propertyCustomer)) {
			
			if (CheckDataUtil.checkNotEmpty(propertyCustomer.getPropertyname())) {
				// 如果是选中的品牌公寓
				if (CheckDataUtil.checkisEqual(propertyCustomer.getPropertyname(), "品牌公寓")
						|| CheckDataUtil.checkisEqual(propertyCustomer.getPropertyname(), "isppgy")
						|| CheckDataUtil.checkisEqual(propertyCustomer.getPropertyname(), "notppgy")) {
					// 如果不是品牌公寓
					if (CheckDataUtil.checkisEqual(propertyCustomer.getPropertyname(), "notppgy")) {
						query.add("fq", "brand:\"\"");
					} else {
						query.add("fq", "brand:[\"\" TO *]");
					}
					
					
				} else {
					query.add("fq", "propertyname:"+propertyCustomer.getPropertyname()+"");
				}
			}
			
			
		}
		
		
		
	}

	public static void pricesquery(PriceCustomer priceCustomer, SolrQuery query) {
		
		if (CheckDataUtil.checkNotEmpty(priceCustomer)) {
			
			if (CheckDataUtil.checkNotEmpty(priceCustomer.getBigprices())
					&& CheckDataUtil.checkNotEmpty(priceCustomer.getSmallprices())) {
				query.add("fq", "prices:["+priceCustomer.getSmallprices()+" TO "+priceCustomer.getBigprices()+"]");
			}
			
		}
		
		
		
	}

	public static void metroquery(Metro metro, SolrQuery query) {
		
		
		if (CheckDataUtil.checkNotEmpty(metro)) {
			if (CheckDataUtil.checkNotEmpty(metro.getMetroid())) {
				query.add("fq", "metroid:"+metro.getMetroid()+"");
			}
			if (CheckDataUtil.checkNotEmpty(metro.getFinalstop())) {
				query.add("fq", "finalstop:"+metro.getFinalstop()+"");
			}
			if (CheckDataUtil.checkNotEmpty(metro.getName())) {
				query.add("fq", "metroname:"+metro.getName()+"");
			}
			if (CheckDataUtil.checkNotEmpty(metro.getFinalstop())) {
				query.add("fq", "citycode:*"+metro.getCode()+"*");
			}
			
			
		}
		
		
	}

	public static void qiuzuquery(QiuzuCustomer qiuzuCustomer, SolrQuery query) {
		if (CheckDataUtil.checkNotEmpty(qiuzuCustomer)) {
			
			// 出租方式的查询条件
			if (!"".equals(qiuzuCustomer.getClassification()) && qiuzuCustomer.getClassification() != null) {
				query.add("fq", "classification:*" + qiuzuCustomer.getClassification() + "*");
			}
			// 区域四级联动的查询条件
			if (qiuzuCustomer.getLikecode() != null) {
				query.add("fq",  "code:*" + qiuzuCustomer.getLikecode() + "*");
			}
			
			//设置户型几室几厅
			if (!"".equals(qiuzuCustomer.getHousetype()) && qiuzuCustomer.getHousetype() != null) {
				query.add("fq" , "housetype:"+qiuzuCustomer.getHousetype()+"*");
			}
			// 四室以上
			if (qiuzuCustomer.getFourroom() != null && !"".equals(qiuzuCustomer.getFourroom())) {
				query.add("fq","housetype:(* NOT *一室*)" );
				query.add("fq","housetype:(* NOT *二室*)" );
				query.add("fq","housetype:(* NOT *三室*)" );
				query.add("fq","housetype:(* NOT *四室*)" );
			}
			
		}
	}
	
	//四级联动地址的code
	public static void likecodequery(Long likecode ,SolrQuery query) {
		if (CheckDataUtil.checkNotEmpty(likecode)) {
			query.add("fq", "likecode:*"+likecode+"*");
		}
		
	}

	public static void villageQuery(VillageCustomer villageCustomer, SolrQuery query) {

		if (CheckDataUtil.checkNotEmpty(villageCustomer)) {
			
			if (CheckDataUtil.checkNotEmpty(villageCustomer.getSmallprices() )
					&& CheckDataUtil.checkNotEmpty(villageCustomer.getBigprices())) {
				query.add("fq", "avgprices:["+villageCustomer.getSmallprices()+" TO "+villageCustomer.getBigprices()+"]");
			}
			
			if (CheckDataUtil.checkNotEmpty(villageCustomer.getVillageid())) {
				query.add("fq", "villageid:"+villageCustomer.getVillageid()+"");
			}
			
			// 楼栋价格的排序
			if (CheckDataUtil.checkNotEmpty(villageCustomer.getDesc())) {
				query.addSort("avgprices",ORDER.desc);
			}
			
			if (CheckDataUtil.checkNotEmpty(villageCustomer.getAsc())) {
				query.addSort("avgprices",ORDER.asc);
			}
		}
		
	}

	public static void housetargQuery(HousetagCustomer housetagCustomer, SolrQuery query) {
		if (CheckDataUtil.checkNotEmpty(housetagCustomer)) {
			if (CheckDataUtil.checkNotEmpty(housetagCustomer.getPropertyright())) {
				query.add("fq", "housetagid:*"+housetagCustomer.getPropertyright()+"*");
			}
			
			if (CheckDataUtil.checkNotEmpty(housetagCustomer.getHouseyear())) {
				query.add("fq", "housetagid:*"+housetagCustomer.getHouseyear()+"*");
			}
			if (CheckDataUtil.checkNotEmpty(housetagCustomer.getElevator())) {
				query.add("fq", "housetagid:*"+housetagCustomer.getElevator()+"*");
			}
			if (CheckDataUtil.checkNotEmpty(housetagCustomer.getBuildingyear())) {
				query.add("fq", "housetagid:*"+housetagCustomer.getBuildingyear()+"*");
			}
		}
		
	}

	public static void buildingquery(BuildingCustomer buildingCustomer, SolrQuery query) {
		if (CheckDataUtil.checkNotEmpty(buildingCustomer)) {
			if (CheckDataUtil.checkNotEmpty(buildingCustomer.getBuildingid())) {
				query.add("fq", "buildingid:"+buildingCustomer.getBuildingid()+"");
			}
			if (CheckDataUtil.checkNotEmpty(buildingCustomer.getBrandid())) {
				query.add("fq","brandid:"+buildingCustomer.getBrandid()+"");
			}
		}
		
	}

}