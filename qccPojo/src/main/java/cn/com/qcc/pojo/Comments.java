package cn.com.qcc.pojo;

import java.util.Date;

public class Comments {
    /** 评论表id*/
    private Long commentsid;

    /** 帖子id*/
    private Long postid;

    /** 评论人的id*/
    private Long user_id;

    /** 评论内容*/
    private String comments;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    public Long getCommentsid() {
        return commentsid;
    }

    public void setCommentsid(Long commentsid) {
        this.commentsid = commentsid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
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