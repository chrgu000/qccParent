package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Landlord;

public class LandlordCustomer extends Landlord {
	
	private Long userid ;
	
	private String address;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
