package cn.com.qcc.queryvo;

import java.util.Date;
import java.util.List;

import cn.com.qcc.pojo.Usercent;
public class UserCentCustomer extends Usercent {
	private String historycenturl;
	private String house_number;
	private String apartmentname;
	private String dayLong ;
	private Integer floor;
	private String realname;
	private String villagename;
	private Integer needoutday;
	private Integer paystate;
	private Long housepayid;
	private Date update_time;
	private Long buildingid;
	private String identity;
	
	private String description;
	
	private String building;
	private String telephone;
	private Date needpaytime;
	private String categoryname ;
	
	private String payexpertname;
	
	private String paystylename;
	
	private Long payexpertid;
	
	private Long financeid;
	
	private Long fid ;
	
	private String fname;
	
	private Double currentprices;
	
	private String rentname;
	
	private String countName;
	
	private String landphone;
	
	private String avatar;
	
	private Integer otherprices;
	
	private String updateTime;
	
	private Integer hycprices; //水电煤气欠款
	private Integer centoutcount; // 需要退房
	private Integer centpricescount; //房租租金总和
	private Integer daishoucount; //待收款总计
	
	private List<PayexpertCustomer> expertList;
	
	private List<HousepayCustomer> yanList;
	
	public String getDayLong() {
		return dayLong;
	}

	public void setDayLong(String dayLong) {
		this.dayLong = dayLong;
	}

	public List<HousepayCustomer> getYanList() {
		return yanList;
	}

	public void setYanList(List<HousepayCustomer> yanList) {
		this.yanList = yanList;
	}

	public List<PayexpertCustomer> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<PayexpertCustomer> expertList) {
		this.expertList = expertList;
	}

	public Integer getHycprices() {
		return hycprices;
	}

	public void setHycprices(Integer hycprices) {
		this.hycprices = hycprices;
	}

	public Integer getCentoutcount() {
		return centoutcount;
	}

	public void setCentoutcount(Integer centoutcount) {
		this.centoutcount = centoutcount;
	}

	public Integer getCentpricescount() {
		return centpricescount;
	}

	public void setCentpricescount(Integer centpricescount) {
		this.centpricescount = centpricescount;
	}

	public Integer getDaishoucount() {
		return daishoucount;
	}

	public void setDaishoucount(Integer daishoucount) {
		this.daishoucount = daishoucount;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getOtherprices() {
		return otherprices;
	}

	public void setOtherprices(Integer otherprices) {
		this.otherprices = otherprices;
	}

	public String getLandphone() {
		return landphone;
	}

	public void setLandphone(String landphone) {
		this.landphone = landphone;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getPaystate() {
		return paystate;
	}

	public void setPaystate(Integer paystate) {
		this.paystate = paystate;
	}

	public Long getHousepayid() {
		return housepayid;
	}

	public void setHousepayid(Long housepayid) {
		this.housepayid = housepayid;
	}



	public Integer getNeedoutday() {
		return needoutday;
	}

	public void setNeedoutday(Integer needoutday) {
		this.needoutday = needoutday;
	}

	public String getCountName() {
		return countName;
	}

	public void setCountName(String countName) {
		this.countName = countName;
	}

	public String getHistorycenturl() {
		return historycenturl;
	}

	public void setHistorycenturl(String historycenturl) {
		this.historycenturl = historycenturl;
	}

	
	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public String getRentname() {
		return rentname;
	}

	public void setRentname(String rentname) {
		this.rentname = rentname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPaystylename() {
		return paystylename;
	}

	public void setPaystylename(String paystylename) {
		this.paystylename = paystylename;
	}

	private List<UserCentCustomer> usercents;
	
	public List<UserCentCustomer> getUsercents() {
		return usercents;
	}

	public void setUsercents(List<UserCentCustomer> usercents) {
		this.usercents = usercents;
	}

	
	public Double getCurrentprices() {
		return currentprices;
	}

	public void setCurrentprices(Double currentprices) {
		this.currentprices = currentprices;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Long getFinanceid() {
		return financeid;
	}

	public void setFinanceid(Long financeid) {
		this.financeid = financeid;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getPayexpertid() {
		return payexpertid;
	}

	public void setPayexpertid(Long payexpertid) {
		this.payexpertid = payexpertid;
	}

	public Date getNeedpaytime() {
		return needpaytime;
	}

	public void setNeedpaytime(Date needpaytime) {
		this.needpaytime = needpaytime;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getPayexpertname() {
		return payexpertname;
	}

	public void setPayexpertname(String payexpertname) {
		this.payexpertname = payexpertname;
	}


	
	

}
