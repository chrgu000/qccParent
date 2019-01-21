package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Houseorder;

public class HouseOrderCustomer extends Houseorder {
	
	private String house_number;
	
	private String detailes;
	
	private String housetitle;
	
	private Long senduserid ;
	
	private boolean flag ;
	
	private String cycleName;
	
	

	public String getCycleName() {
		return cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public String getHousetitle() {
		return housetitle;
	}

	public void setHousetitle(String housetitle) {
		this.housetitle = housetitle;
	}

	public Long getSenduserid() {
		return senduserid;
	}

	public void setSenduserid(Long senduserid) {
		this.senduserid = senduserid;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

}
