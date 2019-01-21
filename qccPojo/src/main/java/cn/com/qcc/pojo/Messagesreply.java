package cn.com.qcc.pojo;

import java.util.Date;

public class Messagesreply {
    /** 留言回复ID*/
    private Long messagesreplyid;

    /** 留言id*/
    private Long messagesid;

    /** 当前用户ID*/
    private Long userid;

    /** 被回复人ID*/
    private Long followUserid;

    /** 1-正常，2停用*/
    private Integer state;

    /** 回复内容*/
    private String reply;

    /** */
    private Date update_time;

    public Long getMessagesreplyid() {
        return messagesreplyid;
    }

    public void setMessagesreplyid(Long messagesreplyid) {
        this.messagesreplyid = messagesreplyid;
    }

    public Long getMessagesid() {
        return messagesid;
    }

    public void setMessagesid(Long messagesid) {
        this.messagesid = messagesid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getFollowUserid() {
        return followUserid;
    }

    public void setFollowUserid(Long followUserid) {
        this.followUserid = followUserid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}