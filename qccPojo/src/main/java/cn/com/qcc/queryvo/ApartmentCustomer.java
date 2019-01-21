package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Apartment;

public class ApartmentCustomer extends Apartment {

	private String fourroom;

	public String getFourroom() {
		if("五室".equals(this.getApartmentname())) {
			
		}
		return fourroom;
	}

	public void setFourroom(String fourroom) {
		this.fourroom = fourroom;
	}
}
