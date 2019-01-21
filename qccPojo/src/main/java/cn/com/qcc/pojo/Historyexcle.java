package cn.com.qcc.pojo;

import java.util.Date;

public class Historyexcle {
    /** EXCLE主键*/
    private Long historyexclid;

    /** 用户ID*/
    private Long userid;

    /** EXCLE描述*/
    private String descname;

    /** Excle保存地址*/
    private String historyexcleurl;

    /** 更新时间*/
    private Date update_time;

    public Long getHistoryexclid() {
        return historyexclid;
    }

    public void setHistoryexclid(Long historyexclid) {
        this.historyexclid = historyexclid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public String getHistoryexcleurl() {
        return historyexcleurl;
    }

    public void setHistoryexcleurl(String historyexcleurl) {
        this.historyexcleurl = historyexcleurl == null ? null : historyexcleurl.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}