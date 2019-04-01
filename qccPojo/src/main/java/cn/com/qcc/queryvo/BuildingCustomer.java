package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.pojo.Building;


public class BuildingCustomer extends Building{
	
	private String trading;
	
	private String code;
	
	private String citycode;
	
	private String likecode;
	
	private String detailes;
	
	private String villagename;
	
	private List<BuildingCustomer> buils;
	
	private Integer count;
	
	private Long villageuserid;
	
	private Integer villagetypeid;
	
	/** */
	private String latitude;
	
	private String latlng;

	/** 经度 */
	private String longitude;
	
	private String name;
	
	private String finalstop;
	private String metroname;

	private String latandlog;
	private String avatar;

	private String user_id;

	private String user_name;
	private String orderjuli;

	private Integer juli;
	private String metrocode;
	private String district;
	
	private Double avgprices;

	private String bcount;

	private String smallprices;
	private String bigprices;

	private String onepicture;
	private String brand;
	
	private String propertyright;
	
	private String redecorat;
	
	private String apartmentname;
	
	
	
	private String paystyle;
	
	public String getLikecode() {
		return likecode;
	}

	public void setLikecode(String likecode) {
		this.likecode = likecode;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getPropertyright() {
		return propertyright;
	}

	public void setPropertyright(String propertyright) {
		this.propertyright = propertyright;
	}

	public String getRedecorat() {
		return redecorat;
	}

	public void setRedecorat(String redecorat) {
		this.redecorat = redecorat;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public String getPaystyle() {
		return paystyle;
	}

	public void setPaystyle(String paystyle) {
		this.paystyle = paystyle;
	}

	public Long getVillageuserid() {
		return villageuserid;
	}

	public void setVillageuserid(Long villageuserid) {
		this.villageuserid = villageuserid;
	}

	public Integer getVillagetypeid() {
		return villagetypeid;
	}

	public void setVillagetypeid(Integer villagetypeid) {
		this.villagetypeid = villagetypeid;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLatlng() {
		return latlng;
	}

	public void setLatlng(String latlng) {
		this.latlng = latlng;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFinalstop() {
		return finalstop;
	}

	public void setFinalstop(String finalstop) {
		this.finalstop = finalstop;
	}

	public String getMetroname() {
		return metroname;
	}

	public void setMetroname(String metroname) {
		this.metroname = metroname;
	}

	public String getLatandlog() {
		return latandlog;
	}

	public void setLatandlog(String latandlog) {
		this.latandlog = latandlog;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getOrderjuli() {
		return orderjuli;
	}

	public void setOrderjuli(String orderjuli) {
		this.orderjuli = orderjuli;
	}

	
	public Integer getJuli() {
		return juli;
	}

	public void setJuli(Integer juli) {
		this.juli = juli;
	}

	public String getMetrocode() {
		return metrocode;
	}

	public void setMetrocode(String metrocode) {
		this.metrocode = metrocode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Double getAvgprices() {
		return avgprices;
	}

	public void setAvgprices(Double avgprices) {
		this.avgprices = avgprices;
	}

	public String getBcount() {
		return bcount;
	}

	public void setBcount(String bcount) {
		this.bcount = bcount;
	}

	public String getSmallprices() {
		return smallprices;
	}

	public void setSmallprices(String smallprices) {
		this.smallprices = smallprices;
	}

	public String getBigprices() {
		return bigprices;
	}

	public void setBigprices(String bigprices) {
		this.bigprices = bigprices;
	}

	public String getOnepicture() {
		if (onepicture !=null && !"".equals(onepicture)) {
			onepicture = onepicture.split(",")[0];
		}
		return onepicture;
	}

	public void setOnepicture(String onepicture) {
		if (onepicture !=null && !"".equals(onepicture)) {
			onepicture = onepicture.split(",")[0];
		}
		this.onepicture = onepicture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<BuildingCustomer> getBuils() {
		return buils;
	}

	public void setBuils(List<BuildingCustomer> buils) {
		this.buils = buils;
	}

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
