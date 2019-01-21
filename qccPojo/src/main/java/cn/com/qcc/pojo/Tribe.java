package cn.com.qcc.pojo;

import java.util.Date;

public class Tribe {
    /** 部落主键*/
    private Long tribeid;

    /** 创建人ID*/
    private Long userid;

    /** 部落类别的ID关联*/
    private Long tribetypeid;

    /** 详情地址ID*/
    private Long detailid;

    /** 部落名称*/
    private String name;

    /** 部落描述*/
    private String description;

    /** 图片*/
    private String picture;

    /** 1,正常，2-停用*/
    private Integer state;

    /** 部落创建时间*/
    private Date update_time;

    public Long getTribeid() {
        return tribeid;
    }

    public void setTribeid(Long tribeid) {
        this.tribeid = tribeid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getTribetypeid() {
        return tribetypeid;
    }

    public void setTribetypeid(Long tribetypeid) {
        this.tribetypeid = tribetypeid;
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}