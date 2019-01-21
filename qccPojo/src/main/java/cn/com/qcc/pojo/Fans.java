package cn.com.qcc.pojo;

import java.util.Date;

public class Fans {
    /** 粉丝ID*/
    private Long fansId;

    /** 关注人IID*/
    private Long followUserId;

    /** 用户ID*/
    private Long userId;

    /** 1:关注,0:取消关注*/
    private String fanStatus;

    /** 创建时间*/
    private Date create_time;

    /** 修改时间*/
    private Date update_time;

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFanStatus() {
        return fanStatus;
    }

    public void setFanStatus(String fanStatus) {
        this.fanStatus = fanStatus == null ? null : fanStatus.trim();
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
}