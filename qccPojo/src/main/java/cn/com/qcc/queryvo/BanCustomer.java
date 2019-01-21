package cn.com.qcc.queryvo;

import java.math.BigDecimal;

public class BanCustomer  extends Ban{
	
	/** 省*/
    private String province;

    /** 市*/
    private String city;

    /** 区/县*/
    private String district;

    /** 街道*/
    private String trading;
    
    /** 小区名*/
    private String villagename;

    /** 单元号或者楼号*/
    private String building;
    
    /** 用户头像 */
	private String avatar;

	/** 用户名 */
	private String user_name;
	
	/** 详情地址*/
    private String detailes;
    
    /** */
    private BigDecimal latitude;

    /** 经度*/
    private BigDecimal longitude;
    
	private Integer user_id;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
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

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}
    
    

}
