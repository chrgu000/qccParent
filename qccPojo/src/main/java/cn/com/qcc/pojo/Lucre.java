package cn.com.qcc.pojo;

import java.util.Date;

public class Lucre {
    /** 收益主键*/
    private Long lucreid;

    /** 收益描述*/
    private String descname;

    /** 1-正常,2-非正常,3-已添加到总收益*/
    private Integer state;

    /** 收益金额*/
    private Double account;

    /** 收益人ID*/
    private Long userid;

    /** 0-收益 1-佣金*/
    private Integer type;

    /** 收益时间*/
    private Date update_time;

    public Long getLucreid() {
        return lucreid;
    }

    public void setLucreid(Long lucreid) {
        this.lucreid = lucreid;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}