package cn.com.qcc.pojo;

import java.util.Date;

public class Enshrine {
    /** 收藏表主键*/
    private Long enshrineid;

    /** 被收藏人ID*/
    private Long followUserId;

    /** 用户ID*/
    private Long userid;

    /** 收藏物品主键*/
    private Long otherid;

    /** 标题【图片】*/
    private String title;

    /** 1-房源，2-出租，3-出售，等等*/
    private String type;

    /** 1-已经收藏，2-没有收藏*/
    private Integer statue;

    /** 创建时间*/
    private Date create_time;

    /** */
    private Date update_time;

    public Long getEnshrineid() {
        return enshrineid;
    }

    public void setEnshrineid(Long enshrineid) {
        this.enshrineid = enshrineid;
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getOtherid() {
        return otherid;
    }

    public void setOtherid(Long otherid) {
        this.otherid = otherid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
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