package cn.com.qcc.queryvo;

import java.util.Date;

public class HouseRoomCustomer {
	/**房源id**/
	private Long houseid;
	
	/**楼层**/
	private Integer floor;
	
	/**房子状态**/
	private String housestatus;
	
	/**楼栋id**/
	private Long buildingid ;
	
	/** 房号**/
	private String house_number;
	
	/**闲置时间**/
	private Date update_time;
	
	/**租约编号**/
	private String  usercentnum;
	
	/**租金缴费状态 29 **/
	private int centstate;
	
	/**租金金额**/
	private double  centprices;
	
	/**押金缴费状态 30**/
	private int managerstate;
	
	/**押金金额**/
	private double marginprices;
	
	/**其他费用已经支付**/
	private double otherpricespay;
	
	/**其他费用没有支付**/
	private double otherpricesnotpay;
	
	/**用户电话**/
	private String telephone;
	
	/** 真实姓名或者房号**/
	private String realname;
	
	/**需要支付时间**/
	private Date needpaytime;
	
	/**租约截止日期**/
	private Date cententtime;
	
	/**楼栋对应的房源数目**/
	private int housecount;
	
	/**街道**/
	private String trading;
	
	/**小区**/
	private String villagename ;
	
	/**楼栋**/
	private String building;
	
	/**租约id**/
	private Long usercentid;
	
	/**逾期的天数**/
	private int needoutday;
	
	/**租约过期的天数**/
	private int centenoutday;
	
	/**房源闲置的天数**/
	private int notcentday;
	
	private String payIds;
	
	private Long userid; 
	
	private Long landuserid;
	
	private Long manageruserid;
	
	
	
	public Long getLanduserid() {
		return landuserid;
	}

	public void setLanduserid(Long landuserid) {
		this.landuserid = landuserid;
	}

	public Long getManageruserid() {
		return manageruserid;
	}

	public void setManageruserid(Long manageruserid) {
		this.manageruserid = manageruserid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getPayIds() {
		return payIds;
	}

	public void setPayIds(String payIds) {
		this.payIds = payIds;
	}

	public int getNotcentday() {
		return notcentday;
	}

	public void setNotcentday(int notcentday) {
		this.notcentday = notcentday;
	}

	public int getCentenoutday() {
		return centenoutday;
	}

	public void setCentenoutday(int centenoutday) {
		this.centenoutday = centenoutday;
	}

	public int getNeedoutday() {
		return needoutday;
	}

	public void setNeedoutday(int needoutday) {
		this.needoutday = needoutday;
	}

	public Long getUsercentid() {
		return usercentid;
	}

	public void setUsercentid(Long usercentid) {
		this.usercentid = usercentid;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getHousestatus() {
		return housestatus;
	}

	public void setHousestatus(String housestatus) {
		this.housestatus = housestatus;
	}

	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getUsercentnum() {
		return usercentnum;
	}

	public void setUsercentnum(String usercentnum) {
		this.usercentnum = usercentnum;
	}

	public int getCentstate() {
		return centstate;
	}

	public void setCentstate(int centstate) {
		this.centstate = centstate;
	}

	public double getCentprices() {
		return centprices;
	}

	public void setCentprices(double centprices) {
		this.centprices = centprices;
	}

	public int getManagerstate() {
		return managerstate;
	}

	public void setManagerstate(int managerstate) {
		this.managerstate = managerstate;
	}

	public double getMarginprices() {
		return marginprices;
	}

	public void setMarginprices(double marginprices) {
		this.marginprices = marginprices;
	}

	public double getOtherpricespay() {
		return otherpricespay;
	}

	public void setOtherpricespay(double otherpricespay) {
		this.otherpricespay = otherpricespay;
	}

	public double getOtherpricesnotpay() {
		return otherpricesnotpay;
	}

	public void setOtherpricesnotpay(double otherpricesnotpay) {
		this.otherpricesnotpay = otherpricesnotpay;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getNeedpaytime() {
		return needpaytime;
	}

	public void setNeedpaytime(Date needpaytime) {
		this.needpaytime = needpaytime;
	}

	public Date getCententtime() {
		return cententtime;
	}

	public void setCententtime(Date cententtime) {
		this.cententtime = cententtime;
	}

	public int getHousecount() {
		return housecount;
	}

	public void setHousecount(int housecount) {
		this.housecount = housecount;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
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
	
	
	
	
	
	
	
	
	
	
}
