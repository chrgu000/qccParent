package cn.com.qcc.pojo;

import java.util.Date;

public class Tribecontroller {
    /** */
    private Long controllerid;

    /** 用户主键*/
    private Long userid;

    /** 部落主键*/
    private Long tribeid;

    /** 1,正常，2停用，3群主*/
    private Integer state;

    /** */
    private Date update_time;

    public Long getControllerid() {
        return controllerid;
    }

    public void setControllerid(Long controllerid) {
        this.controllerid = controllerid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getTribeid() {
        return tribeid;
    }

    public void setTribeid(Long tribeid) {
        this.tribeid = tribeid;
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