package cn.com.qcc.queryvo;

import java.util.Date;
import java.util.List;

import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.User;

public class UserCustomer extends User {

	private String sex;   //性别
	private String identity;//证件号码
	private String idpictures; //证件图片
	private Integer signstate; // 经纪人状态
	private Integer landstate; // 鉴定房东
	private Long user_id;      // 用户userid
	private Long fatheruserid; // 层级管理
	private String username;   // 用户昵称
	private String landaccesurlid; // 子账号权限
	private Integer state; //状态
	private Double balance; // 余额
	private String realname; // 真实姓名
	private String ordername;
	private List<MessReply> messagereply;
	// 返回用户的昵称
	private String user_name;
	// 粉丝的状态
	private Integer fanStatus;
	// 关注者的ID
	private Integer followUserId;
	// 个人头像
	private String avatar;
	// 消息的ID
	private Integer messagesid;
	// 消息的留言
	private String mes;
	// 房子的ID
	private Integer house_id; 
	private Long consumeid;
	private Integer encount;
	private Integer bcount;
	private Integer tcount;
	private Long ordernum;
	private String mail;
	private Long orderid;
	private Long roleid;
	private Double vipmonetary;
	private Double outmonetary;
	private Double inmonetary;
	private Integer qcount;
	private Long consume_id;
	private Integer scount;
	private String formtime;
	private Integer fcount;
	private String rolename;
	private List<Access> access;
	private String code;
	private Integer landcount;
	private Integer linkcount;
	private Integer nowlandcount;
	private Integer nowlinkcount;
	private Integer nowlinknout;
	private Integer nowlandnout;
	private Integer linknout;
	private Integer landnout;
	private Integer housecount;
	// 封装房源的参数
	private String housestatus;
	private String pricetype;
	private String contacts;
	private String contactstel;
	private String apartmentname;
	private String building;
	private String villagename;
	private String trading;
	private String prices;
	private String classification;
	private String areas;
	private String searchwhere;
	private Long brandid;
	private String weixinaccount ;
	private Double account;
	private String mysign;
	private Date birthday;
	private double houseaccount;
	
	
	public double getHouseaccount() {
		return houseaccount;
	}

	public void setHouseaccount(double houseaccount) {
		this.houseaccount = houseaccount;
	}

	public String getMysign() {
		return mysign;
	}

	public void setMysign(String mysign) {
		this.mysign = mysign;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getAccount() {
		return account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	public String getWeixinaccount() {
		return weixinaccount;
	}

	public void setWeixinaccount(String weixinaccount) {
		this.weixinaccount = weixinaccount;
	}

	private Date sign_time;
	
	
	
	public Integer getNowlinknout() {
		return nowlinknout;
	}

	public void setNowlinknout(Integer nowlinknout) {
		this.nowlinknout = nowlinknout;
	}

	public Integer getNowlandnout() {
		return nowlandnout;
	}

	public void setNowlandnout(Integer nowlandnout) {
		this.nowlandnout = nowlandnout;
	}

	public Integer getLinknout() {
		return linknout;
	}

	public void setLinknout(Integer linknout) {
		this.linknout = linknout;
	}

	public Integer getLandnout() {
		return landnout;
	}

	public void setLandnout(Integer landnout) {
		this.landnout = landnout;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdpictures() {
		return idpictures;
	}

	public void setIdpictures(String idpictures) {
		this.idpictures = idpictures;
	}

	public Date getSign_time() {
		return sign_time;
	}

	public void setSign_time(Date sign_time) {
		this.sign_time = sign_time;
	}

	public Integer getSignstate() {
		return signstate;
	}

	public void setSignstate(Integer signstate) {
		this.signstate = signstate;
	}


	public List<MessReply> getMessagereply() {
		return messagereply;
	}

	public void setMessagereply(List<MessReply> messagereply) {
		this.messagereply = messagereply;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getFanStatus() {
		return fanStatus;
	}

	public void setFanStatus(Integer fanStatus) {
		this.fanStatus = fanStatus;
	}

	public Integer getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(Integer followUserId) {
		this.followUserId = followUserId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getMessagesid() {
		return messagesid;
	}

	public void setMessagesid(Integer messagesid) {
		this.messagesid = messagesid;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}

	public Long getConsumeid() {
		return consumeid;
	}

	public void setConsumeid(Long consumeid) {
		this.consumeid = consumeid;
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

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Double getVipmonetary() {
		return vipmonetary;
	}

	public void setVipmonetary(Double vipmonetary) {
		this.vipmonetary = vipmonetary;
	}

	public Double getOutmonetary() {
		return outmonetary;
	}

	public void setOutmonetary(Double outmonetary) {
		this.outmonetary = outmonetary;
	}

	public Double getInmonetary() {
		return inmonetary;
	}

	public void setInmonetary(Double inmonetary) {
		this.inmonetary = inmonetary;
	}

	public Integer getQcount() {
		return qcount;
	}

	public void setQcount(Integer qcount) {
		this.qcount = qcount;
	}

	public Long getConsume_id() {
		return consume_id;
	}

	public void setConsume_id(Long consume_id) {
		this.consume_id = consume_id;
	}

	public Integer getScount() {
		return scount;
	}

	public void setScount(Integer scount) {
		this.scount = scount;
	}

	public String getFormtime() {
		return formtime;
	}

	public void setFormtime(String formtime) {
		this.formtime = formtime;
	}

	public Integer getFcount() {
		return fcount;
	}

	public void setFcount(Integer fcount) {
		this.fcount = fcount;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getLandcount() {
		return landcount;
	}

	public void setLandcount(Integer landcount) {
		this.landcount = landcount;
	}

	public Integer getLinkcount() {
		return linkcount;
	}

	public void setLinkcount(Integer linkcount) {
		this.linkcount = linkcount;
	}

	public Integer getNowlandcount() {
		return nowlandcount;
	}

	public void setNowlandcount(Integer nowlandcount) {
		this.nowlandcount = nowlandcount;
	}

	public Integer getNowlinkcount() {
		return nowlinkcount;
	}

	public void setNowlinkcount(Integer nowlinkcount) {
		this.nowlinkcount = nowlinkcount;
	}

	public Integer getHousecount() {
		return housecount;
	}

	public void setHousecount(Integer housecount) {
		this.housecount = housecount;
	}

	public String getHousestatus() {
		return housestatus;
	}

	public void setHousestatus(String housestatus) {
		this.housestatus = housestatus;
	}

	public String getPricetype() {
		return pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContactstel() {
		return contactstel;
	}

	public void setContactstel(String contactstel) {
		this.contactstel = contactstel;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
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

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getSearchwhere() {
		return searchwhere;
	}

	public void setSearchwhere(String searchwhere) {
		this.searchwhere = searchwhere;
	}

	public Long getBrandid() {
		return brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}

	public Integer getEncount() {
		return encount;
	}

	public void setEncount(Integer encount) {
		this.encount = encount;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	private Long vipcount;

	public Long getVipcount() {
		return vipcount;
	}

	public void setVipcount(Long vipcount) {
		this.vipcount = vipcount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getLandstate() {
		return landstate;
	}

	public void setLandstate(Integer landstate) {
		this.landstate = landstate;
	}


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<Access> getAccess() {
		return access;
	}

	public void setAccess(List<Access> access) {
		this.access = access;
	}

	public String getLandaccesurlid() {
		return landaccesurlid;
	}

	public void setLandaccesurlid(String landaccesurlid) {
		this.landaccesurlid = landaccesurlid;
	}


	public Long getFatheruserid() {
		return fatheruserid;
	}

	public void setFatheruserid(Long fatheruserid) {
		this.fatheruserid = fatheruserid;
	}


}
