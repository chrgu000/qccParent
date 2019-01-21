package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Brand;

public class BrandCustomer extends Brand{
	
	private Integer housecount;
	
	private Integer builcount;
	
	private Integer prices;
	
	private String avatar;
	
	private String housepicture;
	
	
	public String getHousepicture() {
		return housepicture;
	}

	public void setHousepicture(String housepicture) {
		if ( !"".equals(housepicture) && housepicture !=null) {
			housepicture = housepicture.split(",")[0];
		}
		this.housepicture = housepicture;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getHousecount() {
		return housecount;
	}

	public void setHousecount(Integer housecount) {
		this.housecount = housecount;
	}

	public Integer getBuilcount() {
		return builcount;
	}

	public void setBuilcount(Integer builcount) {
		this.builcount = builcount;
	}

	public Integer getPrices() {
		return prices;
	}

	public void setPrices(Integer prices) {
		this.prices = prices;
	}


	
	

}
