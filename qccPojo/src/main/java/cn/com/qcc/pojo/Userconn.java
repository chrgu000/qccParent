package cn.com.qcc.pojo;

import java.util.Date;

public class Userconn {
    /** */
    private Long userconnid;

    /** */
    private Long userid;
    
    private String link ;

    /** */
    private Long followuserid;

    /** 1申请2拒绝3好友4拉黑*/
    private Integer state;

    /** */
    private Date update_time;
    

    public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getUserconnid() {
        return userconnid;
    }

    public void setUserconnid(Long userconnid) {
        this.userconnid = userconnid;
    }

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