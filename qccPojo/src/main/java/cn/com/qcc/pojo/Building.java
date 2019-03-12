package cn.com.qcc.pojo;

import java.util.Date;

public class Building {
    /** 楼栋ID*/
    private Long buildingid;

    /** 楼栋名称*/
    private String building;

    /** 详情地址ID*/
    private Long detailid;

    /** 小区街道ID*/
    private Long villageid;

    /** 发布人ID*/
    private Long userid;

    /** 品牌名*/
    private Long brandid;

    /** 描述*/
    private String describes;

    /** 图片*/
    private String picture;

    /** 视频图片*/
    private String videourl;

    /** 楼栋编号*/
    private String buildingcode;

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

    /** 地铁ID*/
    private Long metroid;

    /** 房东*/
    private String land;

    /** 小程序二维码图片*/
    private String xcxpicture;

    /** */
    private Date update_time;

    /** BD账号的id*/
    private String bdid;

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

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

    public Long getBrandid() {
        return brandid;
    }

    public void setBrandid(Long brandid) {
        this.brandid = brandid;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    public String getBuildingcode() {
        return buildingcode;
    }

    public void setBuildingcode(String buildingcode) {
        this.buildingcode = buildingcode == null ? null : buildingcode.trim();
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

    public Long getMetroid() {
        return metroid;
    }

    public void setMetroid(Long metroid) {
        this.metroid = metroid;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land == null ? null : land.trim();
    }

    public String getXcxpicture() {
        return xcxpicture;
    }

    public void setXcxpicture(String xcxpicture) {
        this.xcxpicture = xcxpicture == null ? null : xcxpicture.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getBdid() {
        return bdid;
    }

    public void setBdid(String bdid) {
        this.bdid = bdid == null ? null : bdid.trim();
    }
}