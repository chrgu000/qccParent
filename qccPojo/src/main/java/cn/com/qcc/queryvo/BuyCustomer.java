package cn.com.qcc.queryvo;

import java.math.BigDecimal;

import cn.com.qcc.pojo.Buy;

public class BuyCustomer  extends Buy{
	private String fourroom;

	private String avatar;
	
	private String city;
	
	private String trading;
	
	private String province;
	
	private String district;
	
	
	private String proname;

	private String cityname;

	private String disname;

	private String tradname;

	private Long discode;

	private Long procode;

	private Long tracode;

	private Long citycode;
	
	private String detailes;
	
	/** */
    private BigDecimal latitude;

    /** 经度*/
    private BigDecimal longitude;
    
    
	
	
	
	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDisname() {
		return disname;
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}

	public String getTradname() {
		return tradname;
	}

	public void setTradname(String tradname) {
		this.tradname = tradname;
	}

	public Long getDiscode() {
		return discode;
	}

	public void setDiscode(Long discode) {
		this.discode = discode;
	}

	public Long getProcode() {
		return procode;
	}

	public void setProcode(Long procode) {
		this.procode = procode;
	}

	public Long getTracode() {
		return tracode;
	}

	public void setTracode(Long tracode) {
		this.tracode = tracode;
	}

	public Long getCitycode() {
		return citycode;
	}

	public void setCitycode(Long citycode) {
		this.citycode = citycode;
	}

	public String getFourroom() {
		return fourroom;
	}

	public void setFourroom(String fourroom) {
		this.fourroom = fourroom;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	private String user_name;
}
