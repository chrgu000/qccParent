package cn.com.qcc.pojo;

import java.util.Date;

public class Masonry {
    /** */
    private Long masonryid;

    /** 操作用户ID*/
    private Long userid;

    /** 获得事件或者*/
    private String event;

    /** 1-收入，2支出*/
    private Integer type;

    /** 总数量*/
    private Long count;

    /** 操作事件*/
    private Date update_time;

    public Long getMasonryid() {
        return masonryid;
    }

    public void setMasonryid(Long masonryid) {
        this.masonryid = masonryid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}