package cn.com.qcc.queryvo;

import java.util.Date;

import cn.com.qcc.pojo.Qiuzu;


public class QiuzuCustomer extends Qiuzu {

	private Long userid;
	
	
	private String fourroom;

	private String avatar;
	
	private String city;
	
	private String trading;
	
	private String province;
	
	private String district;
	
	private String user_name;
	
	private Long likecode;
	
	private Integer juli ;
	
	private String  metroname;
	
	private String finalstop;
	
	private Integer bcount;
	
	private Integer tcount;
	
	private String telephone;
	
	private String detailes; 
	
	private String updatetime;
	
	private String proname;

	private String cityname;

	private String disname;

	private String tradname;

	private Long discode;

	private Long procode;

	private Long tracode;

	private Long citycode;
	
	private Date start_date;
	
	private Date end_date;
	
	private Integer error;
	
	private Integer success;
	
	/** */
    private double latitude;

    /** 经度*/
    private double longitude;
    
	
	public Integer getJuli() {
		return juli;
	}

	public void setJuli(Integer juli) {
		this.juli = juli;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public Integer getBcount() {
		return bcount;
	}

	public void setBcount(Integer bcount) {
		this.bcount = bcount;
	}

	public Integer getTcount() {
		return tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	

	public String getMetroname() {
		return metroname;
	}

	public void setMetroname(String metroname) {
		this.metroname = metroname;
	}

	public String getFinalstop() {
		return finalstop;
	}

	public void setFinalstop(String finalstop) {
		this.finalstop = finalstop;
	}

	public Long getLikecode() {
		return likecode;
	}

	public void setLikecode(Long likecode) {
		this.likecode = likecode;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
