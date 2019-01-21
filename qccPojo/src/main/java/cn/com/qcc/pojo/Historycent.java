package cn.com.qcc.pojo;

import java.util.Date;

public class Historycent {
    /** 历史租约ID*/
    private Long historycentid;

    /** 租约保存路径*/
    private String historycenturl;

    /** 签约用户ID*/
    private Long usercentid;

    /** 租约描述*/
    private String descname;

    /** 同步时间*/
    private Date update_time;

    public Long getHistorycentid() {
        return historycentid;
    }

    public void setHistorycentid(Long historycentid) {
        this.historycentid = historycentid;
    }

    public String getHistorycenturl() {
        return historycenturl;
    }

    public void setHistorycenturl(String historycenturl) {
        this.historycenturl = historycenturl == null ? null : historycenturl.trim();
    }

    public Long getUsercentid() {
        return usercentid;
    }

    public void setUsercentid(Long usercentid) {
        this.usercentid = usercentid;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}