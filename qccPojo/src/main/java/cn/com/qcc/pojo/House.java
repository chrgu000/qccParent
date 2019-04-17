package cn.com.qcc.pojo;

import java.util.Date;

public class House {
    /** 房屋id*/
    private Long houseid;

    /** 房屋标题*/
    private String housetitle;

    /** 楼栋ID*/
    private Long buildingid;

    /** 发布人id对应user表id*/
    private Long user_id;

    /** 发布人相对房屋的身份（房主、经纪人）*/
    private String user_identity;

    /** 户型id*/
    private Integer apartment_id;

    /** 公共设施id*/
    private String housetag_id;

    /** 物业类型id*/
    private Integer property_id;

    /** 品牌名*/
    private Long brandid;

    /** 房东姓名*/
    private String landlord;

    /** 房东手机号*/
    private String landlordtel;

    /** 联系人姓名*/
    private String contacts;

    /** 联系人电话*/
    private String contactstel;

    /** 房间面积*/
    private Double area;

    /** 楼层*/
    private Integer floor;

    /** 房屋价格id*/
    private Long price_id;

    /** 支付方式*/
    private String paystyle;

    /** 楼龄*/
    private String ages;

    /** 房屋朝向类型*/
    private String turn;

    /** 房屋装修类型*/
    private String redecorat;

    /** 附近地铁站*/
    private String underground;

    /** 房屋图片*/
    private String picture;

    /** 房屋描述*/
    private String description;

    /** 房屋的状态  冻结0 未租1 已租2  默认1  3是移除 5待审核 6已预定*/
    private String housestatus;

    /** 1为租的  2为卖的*/
    private String houstatus;

    /** 创建时间*/
    private Date create_time;

    /** 房间号码*/
    private String house_number;

    /** 视频地址*/
    private String videourl;

    /**  1-可以预定  2-不可以预定*/
    private Integer schedule;

    /** */
    private Date update_time;

    /** 房间编号*/
    private String housecode;

    /** 房子二维码图片*/
    private String xcxpicture;

    /** 户型图*/
    private String renderings;

    /** 房源海报图片*/
    private String housePostImage;

    /** 部落id的集合*/
    private String tribeids;

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
        this.housetitle = housetitle == null ? null : housetitle.trim();
    }

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
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
        this.user_identity = user_identity == null ? null : user_identity.trim();
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
        this.housetag_id = housetag_id == null ? null : housetag_id.trim();
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Long getBrandid() {
        return brandid;
    }

    public void setBrandid(Long brandid) {
        this.brandid = brandid;
    }

    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord == null ? null : landlord.trim();
    }

    public String getLandlordtel() {
        return landlordtel;
    }

    public void setLandlordtel(String landlordtel) {
        this.landlordtel = landlordtel == null ? null : landlordtel.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactstel() {
        return contactstel;
    }

    public void setContactstel(String contactstel) {
        this.contactstel = contactstel == null ? null : contactstel.trim();
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
        this.paystyle = paystyle == null ? null : paystyle.trim();
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages == null ? null : ages.trim();
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn == null ? null : turn.trim();
    }

    public String getRedecorat() {
        return redecorat;
    }

    public void setRedecorat(String redecorat) {
        this.redecorat = redecorat == null ? null : redecorat.trim();
    }

    public String getUnderground() {
        return underground;
    }

    public void setUnderground(String underground) {
        this.underground = underground == null ? null : underground.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getHousestatus() {
        return housestatus;
    }

    public void setHousestatus(String housestatus) {
        this.housestatus = housestatus == null ? null : housestatus.trim();
    }

    public String getHoustatus() {
        return houstatus;
    }

    public void setHoustatus(String houstatus) {
        this.houstatus = houstatus == null ? null : houstatus.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number == null ? null : house_number.trim();
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getHousecode() {
        return housecode;
    }

    public void setHousecode(String housecode) {
        this.housecode = housecode == null ? null : housecode.trim();
    }

    public String getXcxpicture() {
        return xcxpicture;
    }

    public void setXcxpicture(String xcxpicture) {
        this.xcxpicture = xcxpicture == null ? null : xcxpicture.trim();
    }

    public String getRenderings() {
        return renderings;
    }

    public void setRenderings(String renderings) {
        this.renderings = renderings == null ? null : renderings.trim();
    }

    public String getHousePostImage() {
        return housePostImage;
    }

    public void setHousePostImage(String housePostImage) {
        this.housePostImage = housePostImage == null ? null : housePostImage.trim();
    }

    public String getTribeids() {
        return tribeids;
    }

    public void setTribeids(String tribeids) {
        this.tribeids = tribeids == null ? null : tribeids.trim();
    }
}