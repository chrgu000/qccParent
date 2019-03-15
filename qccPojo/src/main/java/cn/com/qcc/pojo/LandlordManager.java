package cn.com.qcc.pojo;

import java.util.Date;

public class LandlordManager {
    /** 层级管理userid*/
    private Long manageruserid;

    /** 房东主键也就是landlord的userid*/
    private Long landuserid;

    /** 权限的集合*/
    private String accessurlid;

    /** 1-申请，2-通过，3-不通过*/
    private Integer state;

    /** 更新关系时间*/
    private Date update_time;

    /** 建立关系时间*/
    private Date create_time;

    public Long getManageruserid() {
        return manageruserid;
    }

    public void setManageruserid(Long manageruserid) {
        this.manageruserid = manageruserid;
    }

    public Long getLanduserid() {
        return landuserid;
    }

    public void setLanduserid(Long landuserid) {
        this.landuserid = landuserid;
    }

    public String getAccessurlid() {
        return accessurlid;
    }

    public void setAccessurlid(String accessurlid) {
        this.accessurlid = accessurlid == null ? null : accessurlid.trim();
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