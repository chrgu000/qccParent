package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Authorize;

public class AuthCustomer  extends Authorize{

	
	private String fourroom;

	private String trading;
	
	private String telephone;
	
	private String user_name;
	
	private String classify;
	
	
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFourroom() {
		return fourroom;
	}

	public void setFourroom(String fourroom) {
		
		if("五室".equals(this.getHousetype())){
			this.fourroom = "五室";
		}else{
			this.fourroom = fourroom;
		}
	}
}
