package cn.com.qcc.queryvo;

import java.util.ArrayList;
import java.util.List;

import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.Bargaindetail;

public class BargainCustomer extends Bargain{
	
	private String houseNumber ;
	
	private String apartmentName;
	
	List<Bargaindetail> details = new ArrayList<>();
	

	public List<Bargaindetail> getDetails() {
		return details;
	}

	public void setDetails(List<Bargaindetail> details) {
		this.details = details;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	

}
