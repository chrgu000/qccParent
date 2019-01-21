package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Historymeter;

public class HistorymeterCustomer extends Historymeter{
	
	
	private Integer house_number ;
	
	private String realname;
	
	private Long buildingid;
	
	private String categoryname ;
	
	private Double singleprice;
	
	private Double unitprice;
	
	private String centname;
	
	
	public String getCentname() {
		return centname;
	}

	public void setCentname(String centname) {
		this.centname = centname;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getSingleprice() {
		return singleprice;
	}

	public void setSingleprice(Double singleprice) {
		this.singleprice = singleprice;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getHouse_number() {
		return house_number;
	}

	public void setHouse_number(Integer house_number) {
		this.house_number = house_number;
	}



	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

	

}
