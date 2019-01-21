package cn.com.qcc.pojo;

import java.util.Date;

public class Commentsreply {
    /** 回复表id*/
    private Long commentsreply_id;

    /** 评论id*/
    private Long comments_id;

    /** 回复人的id*/
    private Long user_id;

    /** 回复内容*/
    private String reply;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    public Long getCommentsreply_id() {
        return commentsreply_id;
    }

    public void setCommentsreply_id(Long commentsreply_id) {
        this.commentsreply_id = commentsreply_id;
    }

    public Long getComments_id() {
        return comments_id;
    }

    public void setComments_id(Long comments_id) {
        this.comments_id = comments_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
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