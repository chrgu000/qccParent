package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Metro;

public class MetroCustomer extends Metro{
	
	private String cityname;
	
	private Long villageid;
	

	public Long getVillageid() {
		return villageid;
	}

	public void setVillageid(Long villageid) {
		this.villageid = villageid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	

}
