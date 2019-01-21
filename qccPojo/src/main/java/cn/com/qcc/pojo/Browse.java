package cn.com.qcc.pojo;

import java.util.Date;

public class Browse {
    /** 主键*/
    private Long browseid;

    /** 被浏览人ID*/
    private Long followUserId;

    /** 浏览人ID*/
    private Long userid;

    /** 被浏览物品ID*/
    private Long otherid;

    /** 浏览总次数*/
    private Integer bcount;

    /** 1-房源，2-出租，3-出售 ,11-增值服务 ,6-物品，7-找人，8-问答*/
    private Integer type;

    /** */
    private Date b_time;

    /** 1,正常，2停用*/
    private Integer statue;

    /** */
    private String title;

    public Long getBrowseid() {
        return browseid;
    }

    public void setBrowseid(Long browseid) {
        this.browseid = browseid;
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

    public Integer getBcount() {
        return bcount;
    }

    public void setBcount(Integer bcount) {
        this.bcount = bcount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getB_time() {
        return b_time;
    }

    public void setB_time(Date b_time) {
        this.b_time = b_time;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}