package cn.com.qcc.pojo;

import java.util.Date;

public class Zan {
    /** 主键ID*/
    private Long zanId;

    /** user表ID*/
    private Long userid;

    /** */
    private Long followUserId;

    /** qiuzu表ID*/
    private Long otherid;

    /** 1-房源，2-出租，3-出售，4-其他*/
    private Integer type;

    /** 1:点赞;0:取消点赞*/
    private String state;

    /** */
    private String title;

    /** 创建时间*/
    private Date create_time;

    /** 修改时间*/
    private Date update_time;

    public Long getZanId() {
        return zanId;
    }

    public void setZanId(Long zanId) {
        this.zanId = zanId;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }

    public Long getOtherid() {
        return otherid;
    }

    public void setOtherid(Long otherid) {
        this.otherid = otherid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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