package cn.com.qcc.pojo;

import java.util.Date;

public class Landmanager {
    /** 房东经济人维护主键*/
    private Long landmanagerid;

    /** 房东主键也就是landlord的userid*/
    private Long userid;

    /** 经济人ID*/
    private Long followuserid;

    /** 权限的集合*/
    private String accessurlid;

    /** 1-申请，2-通过，3-不通过*/
    private Integer landmanagerstate;

    /** 更新关系时间*/
    private Date update_time;

    /** 建立关系时间*/
    private Date create_time;

    public Long getLandmanagerid() {
        return landmanagerid;
    }

    public void setLandmanagerid(Long landmanagerid) {
        this.landmanagerid = landmanagerid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getFollowuserid() {
        return followuserid;
    }

    public void setFollowuserid(Long followuserid) {
        this.followuserid = followuserid;
    }

    public String getAccessurlid() {
        return accessurlid;
    }

    public void setAccessurlid(String accessurlid) {
        this.accessurlid = accessurlid == null ? null : accessurlid.trim();
    }

    public Integer getLandmanagerstate() {
        return landmanagerstate;
    }

    public void setLandmanagerstate(Integer landmanagerstate) {
        this.landmanagerstate = landmanagerstate;
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