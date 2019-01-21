package cn.com.qcc.pojo;

public class ManageUser {
    /** 管理ID*/
    private Long userid;

    /** 被管理人ID*/
    private Long followuserid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getFollowuserid() {
        return followuserid;
    }

    public void setFollowuserid(Long followuserid) {
        this.followuserid = followuserid;
    }
}