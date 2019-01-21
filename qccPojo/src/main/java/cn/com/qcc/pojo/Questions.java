package cn.com.qcc.pojo;

import java.util.Date;

public class Questions {
    /** 提问的主键ID*/
    private Long questionsid;

    /** 创建提问人ID*/
    private Long userid;

    /** 发起提问关联ID*/
    private Long otherid;

    /** 发起提问时间*/
    private Date update_time;

    /** 提问的类型1-8*/
    private Integer type;

    /** 1,正常，2停用*/
    private Integer state;

    /** 提问的标题*/
    private String title;

    public Long getQuestionsid() {
        return questionsid;
    }

    public void setQuestionsid(Long questionsid) {
        this.questionsid = questionsid;
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

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}