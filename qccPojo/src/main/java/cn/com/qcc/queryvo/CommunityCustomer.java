package cn.com.qcc.queryvo;

import java.math.BigDecimal;


public class CommunityCustomer extends Community {
	
	private String province;
	
	private String city;
	
	private String villagename;
	
	private String district;
	
	private String trading;
	
	private String building;
	
	  /** 1为租的  2为卖的*/
    private String houstatus;
	
	private Double avgprices ;
	
	private Integer smallprices;
	
	private Integer bigprices;
	
	private String desc;
	
	private String asc;
	
	private String julidesc;
	
	private String juliasc;
	
	private String houstatus2;
	
	private String juli;
	
	
	
    public String getHoustatus() {
		return houstatus;
	}

	public void setHoustatus(String houstatus) {
		this.houstatus = houstatus;
	}

	public Integer getSmallprices() {
		return smallprices;
	}

	public void setSmallprices(Integer smallprices) {
		this.smallprices = smallprices;
	}

	public Integer getBigprices() {
		return bigprices;
	}

	public void setBigprices(Integer bigprices) {
		this.bigprices = bigprices;
	}

	public String getJuli() {
		return juli;
	}

	public void setJuli(String juli) {
		this.juli = juli;
	}


	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/** 经度*/
    private BigDecimal longitude;
	

	public String getHoustatus2() {
		return houstatus2;
	}

	public void setHoustatus2(String houstatus2) {
		this.houstatus2 = houstatus2;
	}

	public String getJulidesc() {
		return julidesc;
	}

	public void setJulidesc(String julidesc) {
		this.julidesc = julidesc;
	}

	public String getJuliasc() {
		return juliasc;
	}

	public void setJuliasc(String juliasc) {
		this.juliasc = juliasc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAsc() {
		return asc;
	}

	public void setAsc(String asc) {
		this.asc = asc;
	}

	
	public Double getAvgprices() {
		return avgprices;
	}

	public void setAvgprices(Double avgprices) {
		this.avgprices = avgprices;
	}



	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}
	
	

}
