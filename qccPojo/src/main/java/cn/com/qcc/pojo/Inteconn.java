package cn.com.qcc.pojo;

import java.util.Date;

public class Inteconn {
    /** 用户ID*/
    private Long userid;

    /** 金币总数*/
    private Long count;

    /** */
    private Date update_time;

    /** 保留字段*/
    private Integer grand;

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

    public Integer getGrand() {
        return grand;
    }

    public void setGrand(Integer grand) {
        this.grand = grand;
    }
}