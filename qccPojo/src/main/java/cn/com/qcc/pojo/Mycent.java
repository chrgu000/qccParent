package cn.com.qcc.pojo;

import java.util.Date;

public class Mycent {
    /** 我的合同模块id*/
    private Long mycentid;

    /** 用户ID*/
    private Long userid;

    /** 模板描述*/
    private String descname;

    /** url地址*/
    private String centurl;

    /** 更新时间*/
    private Date update_time;

    public Long getMycentid() {
        return mycentid;
    }

    public void setMycentid(Long mycentid) {
        this.mycentid = mycentid;
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

    public String getCenturl() {
        return centurl;
    }

    public void setCenturl(String centurl) {
        this.centurl = centurl == null ? null : centurl.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}