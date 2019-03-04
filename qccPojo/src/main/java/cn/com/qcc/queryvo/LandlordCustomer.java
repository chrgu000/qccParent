package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Landlord;

public class LandlordCustomer extends Landlord {
	
	private Long userid ;
	
	
	private Long telephone;
	
	private String address;

	
	

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

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
