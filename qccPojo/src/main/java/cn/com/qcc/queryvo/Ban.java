package cn.com.qcc.queryvo;

import java.util.Date;

public class Ban {
    /** 小区街道ID*/
    private Long villageid;

    /** */
    private Long userid;

    /** 品牌名*/
    private String brand;

    /** 描述*/
    private String describes;

    /** 标题*/
    private String title;

    /** 图片*/
    private String picture;

    /** 1-通过，2-通过*/
    private Integer state;

    /** 联系人电话*/
    private String linkphone;

    /** 联系人*/
    private String linkman;

    /** 房东电话*/
    private String landphone;

    /** 身份*/
    private String identity;

    /** 门牌号*/
    private String bnumber;

    /** 地铁*/
    private String metro;

    /** 房东*/
    private String land;

    /** */
    private Date update_time;

    public Long getVillageid() {
        return villageid;
    }

    public void setVillageid(Long villageid) {
        this.villageid = villageid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLandphone() {
        return landphone;
    }

    public void setLandphone(String landphone) {
        this.landphone = landphone == null ? null : landphone.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getBnumber() {
        return bnumber;
    }

    public void setBnumber(String bnumber) {
        this.bnumber = bnumber == null ? null : bnumber.trim();
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro == null ? null : metro.trim();
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land == null ? null : land.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}