package cn.com.qcc.pojo;

import java.util.Date;

public class Integral {
    /** 积分主键*/
    private Long integralid;

    /** 用户ID*/
    private Long userid;

    /** 类型主键*/
    private Long otherid;

    /** 金币类型主键*/
    private Long commonid;

    /** 获得积分的数目*/
    private Long count;

    /** 积分事件*/
    private String event;

    /** 类型 2-消耗 ， 1-收入*/
    private Integer type;

    /** 更新时间*/
    private Date update_time;

    public Long getIntegralid() {
        return integralid;
    }

    public void setIntegralid(Long integralid) {
        this.integralid = integralid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getOtherid() {
        return otherid;
    }

    public void setOtherid(Long otherid) {
        this.otherid = otherid;
    }

    public Long getCommonid() {
        return commonid;
    }

    public void setCommonid(Long commonid) {
        this.commonid = commonid;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
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