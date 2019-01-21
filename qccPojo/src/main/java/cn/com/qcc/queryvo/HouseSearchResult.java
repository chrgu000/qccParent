package cn.com.qcc.queryvo;

import java.sql.Timestamp;
import java.util.List;

import cn.com.qcc.pojo.Apartment;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.Property;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Village;


public class HouseSearchResult {

	private Long houseid;
	private String housetitle; // 房屋标题
	private Long address_id; // 地址id
	private Long user_id; // 发布人id
	private String user_identity;// 发布人相对房屋的身份（房主、经纪人）
	private Integer apartment_id;// 户型id
	private String housetag_id; // 公共设施id
	private Integer property_id; // 物业类型id
	private String brand; // 品牌名
	private String landlord; // 房东姓名
	private Long landlordtel; // 房东电话
	private String contacts; // 联系人姓名
	private Long contactstel; // 联系人电话
	private Double area; // 面积
	private Integer floor; // 楼层
	private Long price_id; // 房屋价格id
	private String paystyle; // 支付方式
	private String ages; // 楼龄
	private String turn; // 房屋朝向类型
	private String redecorat; // 房屋装修类型
	private String underground; // 附近地铁站
	private String picture; // 房屋图片
	private String description; // 房屋描述
	private String housestatus; // 房屋的状态
	private String houstatus; // 房屋是租还是卖
	private Timestamp create_time; // 创建时间
	private Timestamp update_time; // 修改时间

	private List<Housetag> housetagList; // 设施
	private Apartment apartment; // 房屋户型
	private Price price; // 房屋价格
	private Property property; // 物业类型
	private User user;
	private Profile profile;
	private String villageBuilUnit;// 三个字段拼接
	private Village village;
	private Double smallarea; // 小面积
	private Double bigarea; // 大面积
	private String type; // 标签
	private String fourroom; // 四室以上筛选
	private String maxtime;

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public String getHousetitle() {
		return housetitle;
	}

	public void setHousetitle(String housetitle) {
		this.housetitle = housetitle;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_identity() {
		return user_identity;
	}

	public void setUser_identity(String user_identity) {
		this.user_identity = user_identity;
	}

	public Integer getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(Integer apartment_id) {
		this.apartment_id = apartment_id;
	}

	public String getHousetag_id() {
		return housetag_id;
	}

	public void setHousetag_id(String housetag_id) {
		this.housetag_id = housetag_id;
	}

	public Integer getProperty_id() {
		return property_id;
	}

	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLandlord() {
		return landlord;
	}

	public void setLandlord(String landlord) {
		this.landlord = landlord;
	}

	public Long getLandlordtel() {
		return landlordtel;
	}

	public void setLandlordtel(Long landlordtel) {
		this.landlordtel = landlordtel;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Long getContactstel() {
		return contactstel;
	}

	public void setContactstel(Long contactstel) {
		this.contactstel = contactstel;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Long getPrice_id() {
		return price_id;
	}

	public void setPrice_id(Long price_id) {
		this.price_id = price_id;
	}

	public String getPaystyle() {
		return paystyle;
	}

	public void setPaystyle(String paystyle) {
		this.paystyle = paystyle;
	}

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getRedecorat() {
		return redecorat;
	}

	public void setRedecorat(String redecorat) {
		this.redecorat = redecorat;
	}

	public String getUnderground() {
		return underground;
	}

	public void setUnderground(String underground) {
		this.underground = underground;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHousestatus() {
		return housestatus;
	}

	public void setHousestatus(String housestatus) {
		this.housestatus = housestatus;
	}

	public String getHoustatus() {
		return houstatus;
	}

	public void setHoustatus(String houstatus) {
		this.houstatus = houstatus;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public List<Housetag> getHousetagList() {
		return housetagList;
	}

	public void setHousetagList(List<Housetag> housetagList) {
		this.housetagList = housetagList;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getVillageBuilUnit() {
		return villageBuilUnit;
	}

	public void setVillageBuilUnit(String villageBuilUnit) {
		this.villageBuilUnit = villageBuilUnit;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Double getSmallarea() {
		return smallarea;
	}

	public void setSmallarea(Double smallarea) {
		this.smallarea = smallarea;
	}

	public Double getBigarea() {
		return bigarea;
	}

	public void setBigarea(Double bigarea) {
		this.bigarea = bigarea;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFourroom() {
		return fourroom;
	}

	public void setFourroom(String fourroom) {
		this.fourroom = fourroom;
	}

	public String getMaxtime() {
		return maxtime;
	}

	public void setMaxtime(String maxtime) {
		this.maxtime = maxtime;
	}
}
