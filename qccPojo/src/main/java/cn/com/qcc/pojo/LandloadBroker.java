package cn.com.qcc.pojo;

import java.util.Date;

public class LandloadBroker {
    /** 房东的userid*/
    private Long landuserid;

    /** 经纪人userid*/
    private Long brokeruserid;

    /** 1-房东申请，2-经纪人申请，3-通过，4-移除*/
    private Integer state;

    /** 关联时间*/
    private Date update_time;

    public Long getLanduserid() {
        return landuserid;
    }

    public void setLanduserid(Long landuserid) {
        this.landuserid = landuserid;
    }

    public Long getBrokeruserid() {
        return brokeruserid;
    }

    public void setBrokeruserid(Long brokeruserid) {
        this.brokeruserid = brokeruserid;
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