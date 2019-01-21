package cn.com.qcc.pojo;

import java.util.Date;

public class Messages {
    /** 消息ID*/
    private Long messagesid;

    /** 房屋id*/
    private Long house_id;

    /** 用户id*/
    private Long user_id;

    /** 1-房源，2-出租，3-出售*/
    private Integer type;

    /** 消息状态1-正常，2移除*/
    private Integer state;

    /** 留言内容*/
    private String mes;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    public Long getMessagesid() {
        return messagesid;
    }

    public void setMessagesid(Long messagesid) {
        this.messagesid = messagesid;
    }

    public Long getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Long house_id) {
        this.house_id = house_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes == null ? null : mes.trim();
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