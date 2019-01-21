package cn.com.qcc.pojo;

import java.util.Date;

public class Ronggroup {
    /** 唯一主键*/
    private Long groupid;

    /** 创建人ID*/
    private Long userid;

    /** 群类别ID*/
    private Long grouptypeid;

    /** */
    private Long detailid;

    /** 区域的名称*/
    private String addressname;

    /** 群名称*/
    private String name;

    /** 描述*/
    private String description;

    /** 群图片*/
    private String picture;

    /** 验证 0不用验证，1需要验证,2不允许任何人加入*/
    private Integer jointype;

    /** ，0不需要被邀请人同意加入群，1需要被邀请人同意才可以加入*/
    private Integer beinvitemode;

    /** 谁可以修改群资料，0-管理员,1-所有人*/
    private Integer uptinfomode;

    /**  谁可以邀请他人入群，0-管理员,1-所有人*/
    private Integer invitemode;

    /** 1,正常，2停用 3讨论组*/
    private Integer state;

    /** */
    private Date update_time;

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getGrouptypeid() {
        return grouptypeid;
    }

    public void setGrouptypeid(Long grouptypeid) {
        this.grouptypeid = grouptypeid;
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname == null ? null : addressname.trim();
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

    public Integer getJointype() {
        return jointype;
    }

    public void setJointype(Integer jointype) {
        this.jointype = jointype;
    }

    public Integer getBeinvitemode() {
        return beinvitemode;
    }

    public void setBeinvitemode(Integer beinvitemode) {
        this.beinvitemode = beinvitemode;
    }

    public Integer getUptinfomode() {
        return uptinfomode;
    }

    public void setUptinfomode(Integer uptinfomode) {
        this.uptinfomode = uptinfomode;
    }

    public Integer getInvitemode() {
        return invitemode;
    }

    public void setInvitemode(Integer invitemode) {
        this.invitemode = invitemode;
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