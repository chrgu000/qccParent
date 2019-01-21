package cn.com.qcc.pojo;

import java.util.Date;

public class Rong {
    /** */
    private Long rid;

    /** */
    private Long userid;

    /** 最后一次消息*/
    private String content;

    /** */
    private Long followUserId;

    /** */
    private Integer statue;

    /** */
    private Integer followstatue;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Integer getFollowstatue() {
        return followstatue;
    }

    public void setFollowstatue(Integer followstatue) {
        this.followstatue = followstatue;
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