package cn.com.qcc.pojo;

import java.util.Date;

public class Authorize {
    /** 委托ID*/
    private Long authorizeid;

    /** 区域的CODE*/
    private Long code;

    /** 详情地址ID*/
    private Long detailid;

    /** 用户ID*/
    private Long userid;

    /** 委托标题*/
    private String title;

    /** 户型*/
    private String housetype;

    /** 分类*/
    private String classification;

    /** 地址*/
    private String site;

    /** 价格*/
    private Double prices;

    /** 面积*/
    private String area;

    /** 地铁*/
    private Long metroid;

    /** 联系人*/
    private String linkman;

    /** 联系电话*/
    private String linkphone;

    /** 描述*/
    private String describes;

    /** 0-冻结，1-上架，2-下架，3-移除*/
    private Integer state;

    /** 更新时间*/
    private Date update_time;

    /** 创建时间*/
    private Date create_time;

    public Long getAuthorizeid() {
        return authorizeid;
    }

    public void setAuthorizeid(Long authorizeid) {
        this.authorizeid = authorizeid;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Long getMetroid() {
        return metroid;
    }

    public void setMetroid(Long metroid) {
        this.metroid = metroid;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}