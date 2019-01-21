package cn.com.qcc.pojo;

import java.util.Date;

public class Payexpert {
    /** 分期租赁iD*/
    private Long payexpertid;

    /** 1-没有推送账单，2-已经推送账单*/
    private Integer state;

    /** 分期名称*/
    private String payexpertname;

    /** 账单开始日期*/
    private Date start_time;

    /** 账单结束日期*/
    private Date end_time;

    public Long getPayexpertid() {
        return payexpertid;
    }

    public void setPayexpertid(Long payexpertid) {
        this.payexpertid = payexpertid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPayexpertname() {
        return payexpertname;
    }

    public void setPayexpertname(String payexpertname) {
        this.payexpertname = payexpertname == null ? null : payexpertname.trim();
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}