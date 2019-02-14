package cn.com.qcc.pojo;

import java.util.Date;

public class Bargaindetail {
    /** 砍价id*/
    private Long barginid;

    /** 砍价金额*/
    private Double account;

    /** 砍价时间*/
    private Date updatetime;

    /** 微信用户id*/
    private String unionid;

    /** 用户昵称*/
    private String username;

    /** 头像*/
    private String avatar;

    public Long getBarginid() {
        return barginid;
    }

    public void setBarginid(Long barginid) {
        this.barginid = barginid;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}