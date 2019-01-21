package cn.com.qcc.pojo;

import java.util.Date;

public class Historymeter {
    /** 历史抄表主键*/
    private Long historymeterid;

    /** 抄表人ID*/
    private Long userid;

    /** 当前房子ID*/
    private Long houseid;

    /** 财务配置的ID*/
    private Integer financeid;

    /** 煤气表开始*/
    private Double beforecount;

    /** 煤气表结束*/
    private Double aftercount;

    /** 1--待生成账单，2-表示已经生成账单 3---表示作废*/
    private Integer state;

    /** 抄表时间*/
    private Date update_time;

    public Long getHistorymeterid() {
        return historymeterid;
    }

    public void setHistorymeterid(Long historymeterid) {
        this.historymeterid = historymeterid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getHouseid() {
        return houseid;
    }

    public void setHouseid(Long houseid) {
        this.houseid = houseid;
    }

    public Integer getFinanceid() {
        return financeid;
    }

    public void setFinanceid(Integer financeid) {
        this.financeid = financeid;
    }

    public Double getBeforecount() {
        return beforecount;
    }

    public void setBeforecount(Double beforecount) {
        this.beforecount = beforecount;
    }

    public Double getAftercount() {
        return aftercount;
    }

    public void setAftercount(Double aftercount) {
        this.aftercount = aftercount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}