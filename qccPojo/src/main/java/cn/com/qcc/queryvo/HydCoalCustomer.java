package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Hydcoal;

public class HydCoalCustomer extends Hydcoal {
	
	private String houseids;
	
	private Integer state;
	
	private String categoryname ;
	
	
	

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getHouseids() {
		return houseids;
	}

	public void setHouseids(String houseids) {
		this.houseids = houseids;
	}
	
	

}
