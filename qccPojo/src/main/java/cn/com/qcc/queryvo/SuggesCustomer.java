package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Sugges;

public class SuggesCustomer extends Sugges{
	
	/** 用户头像 */
	private String avatar;

	/** 用户名 */
	private String user_name;
	
	private String mescount;
	

	public String getMescount() {
		return mescount;
	}

	public void setMescount(String mescount) {
		this.mescount = mescount;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
