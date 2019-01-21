package cn.com.qcc.pojo;

import java.util.Date;

public class Masonryconn {
    /** 当前用户ID*/
    private Long userid;

    /** 剩余总数*/
    private Long count;

    /** 操作时间*/
    private Date update_time;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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