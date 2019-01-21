package cn.com.qcc.pojo;

import java.util.Date;

public class Tribenotice {
    /** 通知主键*/
    private Long tribenoticeid;

    /** 通知*/
    private String tribenotice;

    /** 部落ID */
    private Long tribeid;

    /** 通知创建时间*/
    private Date update_time;

    /** 通知状态 1，启用，2停用*/
    private Integer state;

    public Long getTribenoticeid() {
        return tribenoticeid;
    }

    public void setTribenoticeid(Long tribenoticeid) {
        this.tribenoticeid = tribenoticeid;
    }

    public String getTribenotice() {
        return tribenotice;
    }

    public void setTribenotice(String tribenotice) {
        this.tribenotice = tribenotice == null ? null : tribenotice.trim();
    }

    public Long getTribeid() {
        return tribeid;
    }

    public void setTribeid(Long tribeid) {
        this.tribeid = tribeid;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}