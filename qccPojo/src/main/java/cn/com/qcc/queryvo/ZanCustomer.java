package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Zan;

public class ZanCustomer extends Zan {

	private String onepicture;

	private String user_name;

	private String avatar;

	public String getOnepicture() {

		if (!"".equals(onepicture) && onepicture != null) {
			String[] str = onepicture.split(",");
			return str[0];
		}

		return "-1";
	}

	public void setOnepicture(String onepicture) {
		if (onepicture == null) {
			this.onepicture = "-1";
		}

		this.onepicture = onepicture;
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
