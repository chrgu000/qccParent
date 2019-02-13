package cn.com.qcc.pojo;

import java.util.Date;

public class Bargain {
    /** 发起砍价人*/
    private Long userid;

    /** 砍价人的openid*/
    private String openid;

    /** 砍价的类型的主键*/
    private Long otherid;

    /** 砍价的金额*/
    private Double monery;

    /** 砍价的类型*/
    private Integer type;

    /** 砍价时间*/
    private Date update_time;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Long getOtherid() {
        return otherid;
    }

    public void setOtherid(Long otherid) {
        this.otherid = otherid;
    }

    public Double getMonery() {
        return monery;
    }

    public void setMonery(Double monery) {
        this.monery = monery;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}