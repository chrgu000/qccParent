package cn.com.qcc.queryvo;

import java.util.Date;
import java.util.List;
import cn.com.qcc.pojo.House;
public class HouseCustomer extends House {
	private String tribename;
	private String tribepicture ;
	private String paystate;
	private String usercentid;
	private String brand;
	private Double totalprices;
	private String usercentnum;
	private String detailaddress; //详情地址
	private String realname; //客户真实姓名
	private Integer payexstate;
	private Long metroid;
	private Long likecode;
	private Date endtime;
	private String houseyear;
	private String buildingyear;
	private String elevator;
	private String propertyright;
	private Integer articletypeid;
	private Long villageuserid;
	
	private String cycleName;
	
	private Integer villagetypeid;
	
	
	private String prices ; //房间对外标价
	
	private String centprices ; // 租金
	
	private String marginprices ; //押金
	
	private String otherpricespay ; //其他金额的汇总
	
	private String otherpricesnotpay ;
	
	private Date needpaytime; //需要缴费时间
	
	private Date currentday;
	
	private Integer needoutday ; //缴费时间倒计时
	
	private Integer centenoutday; //合同到期倒计时
	
	private Date cententtime; //租约到期时间
	
	private String managerstate; //押金是否支付
	
	private String centstate; //租金是否支付
	
	private String otherstate;//其他费用是否支付
	
	private String housecount; //每栋楼的统计
	
	private String trading ; //街道名称
	
	private String building; //楼栋名称
	
	private Integer notcentday ;//空房时间
	
	private String landaddress;
	
	private String fname;
	
	private String rentname;
	
	private boolean falg = true;
	
	private Date paycentend ;
	
	private Double duoshou;
	
	
	private String apartmentname;
	private String address;
	private String pricetype;
	private Integer desc;
	private Integer asc;
	private String user_name;
	private String propertyname;
	private String village;
	private String district;
	private String telephone;
	private String userid;
	private String avatar;
	private String villagename;
	private String longitude;
	private String latitude;
	private Integer house_id;
	private Long villageid;
	private String city ;
	private String smallarea;
	private String bigarea;
	private String smallhouseprice;
	private String bighouseprice;
	private String houseprice;
	private String detailes;
	private String name;
	private String onepicture;
	private Double orderjuli;
	private Integer juli;
	private String metroname;
	private String finalstop;
	private String type ;
	private Long bcount;
	private Long mcount;
	private Long zcount;
	private Integer id;
	private String title;
	private String identity;
	private String code;
	private String content;
	private String detailname;
	private String buildingcode;
	private String searchbrandid;
	
	private String sexName;
	private String sallType;
	
	private String reservations;
	
	private String reservationstel;
	
	private Long houseorderid;
	
	private List<PreparatoryCustomer> preList ;
	
	
	
	
	
	public String getTribename() {
		return tribename;
	}

	public void setTribename(String tribename) {
		this.tribename = tribename;
	}


	public String getTribepicture() {
		return tribepicture;
	}

	public void setTribepicture(String tribepicture) {
		this.tribepicture = tribepicture;
	}

	public Integer getArticletypeid() {
		return articletypeid;
	}

	public void setArticletypeid(Integer articletypeid) {
		this.articletypeid = articletypeid;
	}

	public Integer getJuli() {
		return juli;
	}

	public void setJuli(Integer juli) {
		this.juli = juli;
	}

	public Long getLikecode() {
		return likecode;
	}

	public void setLikecode(Long likecode) {
		this.likecode = likecode;
	}

	public Long getMetroid() {
		return metroid;
	}

	public void setMetroid(Long metroid) {
		this.metroid = metroid;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public List<PreparatoryCustomer> getPreList() {
		return preList;
	}

	public void setPreList(List<PreparatoryCustomer> preList) {
		this.preList = preList;
	}

	public Long getHouseorderid() {
		return houseorderid;
	}

	public void setHouseorderid(Long houseorderid) {
		this.houseorderid = houseorderid;
	}

	public String getReservations() {
		return reservations;
	}

	public void setReservations(String reservations) {
		this.reservations = reservations;
	}

	public String getReservationstel() {
		return reservationstel;
	}

	public void setReservationstel(String reservationstel) {
		this.reservationstel = reservationstel;
	}

	public String getCycleName() {
		return cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
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

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getSallType() {
		return sallType;
	}

	public void setSallType(String sallType) {
		this.sallType = sallType;
	}

	public String getPaystate() {
		return paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPricetype() {
		return pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}

	public Integer getDesc() {
		return desc;
	}

	public void setDesc(Integer desc) {
		this.desc = desc;
	}

	public Integer getAsc() {
		return asc;
	}

	public void setAsc(Integer asc) {
		this.asc = asc;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPropertyname() {
		return propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Integer getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	
	public Long getVillageid() {
		return villageid;
	}

	public void setVillageid(Long villageid) {
		this.villageid = villageid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSmallarea() {
		return smallarea;
	}

	public void setSmallarea(String smallarea) {
		this.smallarea = smallarea;
	}

	public String getBigarea() {
		return bigarea;
	}

	public void setBigarea(String bigarea) {
		this.bigarea = bigarea;
	}

	public String getSmallhouseprice() {
		return smallhouseprice;
	}

	public void setSmallhouseprice(String smallhouseprice) {
		this.smallhouseprice = smallhouseprice;
	}

	public String getBighouseprice() {
		return bighouseprice;
	}

	public void setBighouseprice(String bighouseprice) {
		this.bighouseprice = bighouseprice;
	}

	public String getHouseprice() {
		return houseprice;
	}

	public void setHouseprice(String houseprice) {
		this.houseprice = houseprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Double getOrderjuli() {
		return orderjuli;
	}

	public void setOrderjuli(Double orderjuli) {
		this.orderjuli = orderjuli;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getBcount() {
		return bcount;
	}

	public void setBcount(Long bcount) {
		this.bcount = bcount;
	}

	public Long getMcount() {
		return mcount;
	}

	public void setMcount(Long mcount) {
		this.mcount = mcount;
	}

	public Long getZcount() {
		return zcount;
	}

	public void setZcount(Long zcount) {
		this.zcount = zcount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDetailname() {
		return detailname;
	}

	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}

	public String getBuildingcode() {
		return buildingcode;
	}

	public void setBuildingcode(String buildingcode) {
		this.buildingcode = buildingcode;
	}

	public String getSearchbrandid() {
		return searchbrandid;
	}

	public void setSearchbrandid(String searchbrandid) {
		this.searchbrandid = searchbrandid;
	}

	public Double getDuoshou() {
		return duoshou;
	}

	public void setDuoshou(Double duoshou) {
		this.duoshou = duoshou;
	}

	public Double getTotalprices() {
		return totalprices;
	}

	public void setTotalprices(Double totalprices) {
		this.totalprices = totalprices;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		if (brand == null) {
			brand = "";
		}
		this.brand = brand;
	}

	public String getUsercentnum() {
		return usercentnum;
	}

	public void setUsercentnum(String usercentnum) {
		this.usercentnum = usercentnum;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCurrentday() {
		return currentday;
	}

	public void setCurrentday(Date currentday) {
		this.currentday = currentday;
	}

	private Date start_time ;
	
	private Date end_time;
	
	
	public Date getPaycentend() {
		return paycentend;
	}

	public void setPaycentend(Date paycentend) {
		this.paycentend = paycentend;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public boolean isFalg() {
		return falg;
	}

	public void setFalg(boolean falg) {
		this.falg = falg;
	}

	private List<HouseCustomer> sonlist;
	
	public String getUsercentid() {
		return usercentid;
	}

	public void setUsercentid(String usercentid) {
		this.usercentid = usercentid;
	}

	public List<HouseCustomer> getSonlist() {
		return sonlist;
	}

	public void setSonlist(List<HouseCustomer> sonlist) {
		this.sonlist = sonlist;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getPayexstate() {
		return payexstate;
	}

	public void setPayexstate(Integer payexstate) {
		this.payexstate = payexstate;
	}

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public String getRentname() {
		return rentname;
	}

	public void setRentname(String rentname) {
		this.rentname = rentname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLandaddress() {
		return landaddress;
	}

	public void setLandaddress(String landaddress) {
		this.landaddress = landaddress;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public Integer getNotcentday() {
		return notcentday;
	}

	public void setNotcentday(Integer notcentday) {
		this.notcentday = notcentday;
	}

	public String getHousecount() {
		return housecount;
	}

	public void setHousecount(String housecount) {
		this.housecount = housecount;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getOtherpricespay() {
		return otherpricespay;
	}

	public void setOtherpricespay(String otherpricespay) {
		this.otherpricespay = otherpricespay;
	}

	public String getOtherpricesnotpay() {
		return otherpricesnotpay;
	}

	public void setOtherpricesnotpay(String otherpricesnotpay) {
		this.otherpricesnotpay = otherpricesnotpay;
	}

	public Integer getNeedoutday() {
		return needoutday;
	}

	public void setNeedoutday(Integer needoutday) {
		this.needoutday = needoutday;
	}

	public Integer getCentenoutday() {
		return centenoutday;
	}

	public void setCentenoutday(Integer centenoutday) {
		this.centenoutday = centenoutday;
	}

	public String getCentstate() {
		return centstate;
	}

	public void setCentstate(String centstate) {
		this.centstate = centstate;
	}

	public String getManagerstate() {
		return managerstate;
	}

	public void setManagerstate(String managerstate) {
		this.managerstate = managerstate;
	}

	public String getOtherstate() {
		return otherstate;
	}

	public void setOtherstate(String otherstate) {
		this.otherstate = otherstate;
	}

	public Date getCententtime() {
		return cententtime;
	}

	public void setCententtime(Date cententtime) {
		this.cententtime = cententtime;
	}

	public Date getNeedpaytime() {
		return needpaytime;
	}

	public void setNeedpaytime(Date needpaytime) {
		this.needpaytime = needpaytime;
	}


	public String getCentprices() {
		return centprices;
	}

	public void setCentprices(String centprices) {
		this.centprices = centprices;
	}

	public String getMarginprices() {
		return marginprices;
	}

	public void setMarginprices(String marginprices) {
		this.marginprices = marginprices;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getHouseyear() {
		return houseyear;
	}

	public void setHouseyear(String houseyear) {
		this.houseyear = houseyear;
	}

	public String getBuildingyear() {
		return buildingyear;
	}

	public void setBuildingyear(String buildingyear) {
		this.buildingyear = buildingyear;
	}

	public String getElevator() {
		return elevator;
	}

	public void setElevator(String elevator) {
		this.elevator = elevator;
	}

	public String getPropertyright() {
		return propertyright;
	}

	public void setPropertyright(String propertyright) {
		this.propertyright = propertyright;
	}
	
	
	
	

}
