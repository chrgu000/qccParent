package cn.com.qcc.queryvo;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.pojo.Articledetail;

/**封装返回挂到部落 的 基本数据**/
public class DetailCustomer extends Articledetail {
	
	
	// 挂到部落--- > 图片  id  户型   articledetailid 类型id  价格  价格类型  
	// 面积
	private String area;
	
	// 户型
	private String apartmentname;
	
	// 价格   
	private String prices;
	
	// 价格单位
	private String pricetype;
	
	
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


	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}
	
	
	
	
	

}
