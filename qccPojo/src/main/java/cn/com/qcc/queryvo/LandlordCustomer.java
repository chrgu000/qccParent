package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Landlord;

public class LandlordCustomer extends Landlord {
	
	private Long userid ;
	
	private String bdname;
	
	private Long telephone;
	
	private String realname;
	
	private String identity;
	
	
	
	
	
	
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getBdname() {
		return bdname;
	}

	public void setBdname(String bdname) {
		this.bdname = bdname;
	}

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

	
	
	

}
