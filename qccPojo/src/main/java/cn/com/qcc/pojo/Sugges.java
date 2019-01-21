package cn.com.qcc.pojo;

import java.util.Date;

public class Sugges {
    /** 意见反馈主键*/
    private Long suggesid;

    /** 反馈的标题*/
    private String title;

    /** 反馈人ID*/
    private Long userid;

    /** */
    private String picture;

    /** */
    private String telephone;

    /** 反馈的时间*/
    private Date update_time;

    /** 1-正常，2停用*/
    private Integer state;

    public Long getSuggesid() {
        return suggesid;
    }

    public void setSuggesid(Long suggesid) {
        this.suggesid = suggesid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}