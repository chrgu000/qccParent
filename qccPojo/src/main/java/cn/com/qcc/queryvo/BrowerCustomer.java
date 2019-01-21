package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Browse;

public class BrowerCustomer extends Browse {

	private Integer ycount ;
	
	private String user_name;

	private String avatar;
	
	

	public Integer getYcount() {
		return ycount;
	}

	public void setYcount(Integer ycount) {
		this.ycount = ycount;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
