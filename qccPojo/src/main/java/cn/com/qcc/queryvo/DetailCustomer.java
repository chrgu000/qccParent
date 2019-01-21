package cn.com.qcc.queryvo;

import cn.com.qcc.common.CheckDataUtil;

/**封装返回挂到部落 的 基本数据**/
public class DetailCustomer {
	
	
	// 挂到部落--- > 图片  id  户型   articledetailid 类型id  价格  价格类型  
	
	// 详情id
	private Long detailid;
	
	// 类型id
	private Integer articletypeid ;
	
	// 面积
	private String area;
	
	// 户型
	private String apartmentname;
	
	// 价格   
	private String prices;
	
	// 价格单位
	private String pricetype;
	
	// 如果标题是空  trading ---> title;
	private String title;
	
	// 街道
	private String trading;
	
	// 房源-仓库-二手房
	private Integer property_id;
	
	// 一张图片
	private String onepicture;
	
	// 类型
	private String classification;
	
	
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Integer getArticletypeid() {
		return articletypeid;
	}

	public void setArticletypeid(Integer articletypeid) {
		this.articletypeid = articletypeid;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getOnepicture() {
		return onepicture;
	}

	public void setOnepicture(String onepicture) {
		if (CheckDataUtil.checkNotEmpty(onepicture)) {
			onepicture = onepicture.split(",")[0];
		}else {
			onepicture  = "";
		}
		this.onepicture = onepicture;
	}

	public Long getDetailid() {
		return detailid;
	}

	public void setDetailid(Long detailid) {
		this.detailid = detailid;
	}

	
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		if (CheckDataUtil.checkisEmpty(prices)) {
			prices = getClassification();
		}
		this.prices = prices;
	}

	public String getPricetype() {
		return pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		
		if (CheckDataUtil.checkisEmpty(title)) 
			{ title = trading;}
		
		this.title = title;
	}

	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}
	
	
	
	
	

}
