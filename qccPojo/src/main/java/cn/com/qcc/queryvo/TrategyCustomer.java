package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Villagetrategy;

public class TrategyCustomer extends Villagetrategy{
	
	private String villagename;
	
	private String trading;
	
	private String username ;
	
	private String avatar;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}
	
	

}
