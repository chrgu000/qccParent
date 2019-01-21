package cn.com.qcc.pojo;

import java.util.Date;

public class Landbuilding {
    /** */
    private Long landbuildingid;

    /** 楼栋ID*/
    private Long buildingid;

    /** 财政ID*/
    private Long financeid;

    /** 1-启用，2表示不启用*/
    private Integer state;

    /** 单价*/
    private Double unitprice;

    /** 当前房东id*/
    private Long userid;

    /** */
    private Date update_time;

    public Long getLandbuildingid() {
        return landbuildingid;
    }

    public void setLandbuildingid(Long landbuildingid) {
        this.landbuildingid = landbuildingid;
    }

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
    }

    public Long getFinanceid() {
        return financeid;
    }

    public void setFinanceid(Long financeid) {
        this.financeid = financeid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}