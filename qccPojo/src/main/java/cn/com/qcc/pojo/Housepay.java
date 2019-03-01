package cn.com.qcc.pojo;

import java.util.Date;

public class Housepay {
    /** 租赁总账单id*/
    private Long housepayid;

    /** 房子主键*/
    private Long houseid;

    /** 财务类型主键*/
    private Long financeid;

    /** 分期ID*/
    private Long payexpertid;

    /** 该比账单状态，1-未支付，2已经支付*/
    private Integer paystate;

    /** 1-当前租约，2-历史租约*/
    private Integer currentstate;

    /** 当前类目金额*/
    private Double centprices;

    /** 账单描述*/
    private String description;

    /** 需要交房租时间*/
    private Date create_time;

    /** 实际交房租时间*/
    private Date update_time;

    public Long getHousepayid() {
        return housepayid;
    }

    public void setHousepayid(Long housepayid) {
        this.housepayid = housepayid;
    }

    public Long getHouseid() {
        return houseid;
    }

    public void setHouseid(Long houseid) {
        this.houseid = houseid;
    }

    public Long getFinanceid() {
        return financeid;
    }

    public void setFinanceid(Long financeid) {
        this.financeid = financeid;
    }

    public Long getPayexpertid() {
        return payexpertid;
    }

    public void setPayexpertid(Long payexpertid) {
        this.payexpertid = payexpertid;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public Integer getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(Integer currentstate) {
        this.currentstate = currentstate;
    }

    public Double getCentprices() {
        return centprices;
    }

    public void setCentprices(Double centprices) {
        this.centprices = centprices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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