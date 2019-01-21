package cn.com.qcc.pojo;

import java.util.Date;

public class Buy {
    /** 求购ID*/
    private Long buyid;

    /** 地址的code*/
    private String code;

    /** 发布人ID*/
    private Long user_id;

    /** 标题*/
    private String head;

    /** 分类*/
    private String classify;

    /** 户型*/
    private String housetype;

    /** 详情地址ID*/
    private Long detailid;

    /** 地址[作废]*/
    private String address;

    /** 地铁*/
    private Long metroid;

    /** 面积*/
    private Double areas;

    /** 价格*/
    private String price;

    /** 联系人*/
    private String linkman;

    /** 联系电话*/
    private Long phone;

    /** 描述信息*/
    private String describes;

    /** 0冻结  1上架 2下架*/
    private String buystatus;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    /** 图片*/
    private String picture;

    public Long getBuyid() {
        return buyid;
    }

    public void setBuyid(Long buyid) {
        this.buyid = buyid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getMetroid() {
        return metroid;
    }

    public void setMetroid(Long metroid) {
        this.metroid = metroid;
    }

    public Double getAreas() {
        return areas;
    }

    public void setAreas(Double areas) {
        this.areas = areas;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getBuystatus() {
        return buystatus;
    }

    public void setBuystatus(String buystatus) {
        this.buystatus = buystatus == null ? null : buystatus.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}