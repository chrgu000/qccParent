package cn.com.qcc.pojo;

import java.util.Date;

public class Hydcoal {
    /** 房源ID*/
    private Long hydcoalid;

    /** */
    private Long houseid;

    /** 热水单价*/
    private Long financeid;

    /** 水表单价*/
    private Double unitprice;

    /** 最后一次更新时间*/
    private Date update_time;

    public Long getHydcoalid() {
        return hydcoalid;
    }

    public void setHydcoalid(Long hydcoalid) {
        this.hydcoalid = hydcoalid;
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

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}