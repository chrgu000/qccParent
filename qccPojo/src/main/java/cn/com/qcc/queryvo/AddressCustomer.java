package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Detaileaddress;

public class AddressCustomer extends Detaileaddress {

	// 最小纬度
	private Double minLatude;
	// 最大纬度
	private Double maxLatude;
	// 最小经度
	private Double minLongitude;
	// 最大经度
	private Double maxLongitude;
	// 当前经度
	private Double currentLatude;
	// 当前纬度
	private Double currentLongitude;
	// 附近房源的查询封装
	private String nearLatude;
	// 附近房源的查询封装
	private String nearLongitude;
	public Double getMinLatude() {
		return minLatude;
	}
	public void setMinLatude(Double minLatude) {
		this.minLatude = minLatude;
	}
	public Double getMaxLatude() {
		return maxLatude;
	}
	public void setMaxLatude(Double maxLatude) {
		this.maxLatude = maxLatude;
	}
	public Double getMinLongitude() {
		return minLongitude;
	}
	public void setMinLongitude(Double minLongitude) {
		this.minLongitude = minLongitude;
	}
	public Double getMaxLongitude() {
		return maxLongitude;
	}
	public void setMaxLongitude(Double maxLongitude) {
		this.maxLongitude = maxLongitude;
	}
	public Double getCurrentLatude() {
		return currentLatude;
	}
	public void setCurrentLatude(Double currentLatude) {
		this.currentLatude = currentLatude;
	}
	public Double getCurrentLongitude() {
		return currentLongitude;
	}
	public void setCurrentLongitude(Double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}
	public String getNearLatude() {
		return nearLatude;
	}
	public void setNearLatude(String nearLatude) {
		this.nearLatude = nearLatude;
	}
	public String getNearLongitude() {
		return nearLongitude;
	}
	public void setNearLongitude(String nearLongitude) {
		this.nearLongitude = nearLongitude;
	}
	
	

}
