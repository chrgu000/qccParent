package cn.com.qcc.pojo;

import java.util.Date;

public class Rongconn {
    /** 群控制表主键*/
    private Long connid;

    /** 群唯一标识*/
    private Long groupid;

    /** 群里面用户的ID*/
    private Long userid;

    /** 1,正常，2停用，3群主*/
    private Integer state;
    
    private Long [] ids;

    /** */
    private Date update_time;
    

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public Long getConnid() {
        return connid;
    }

    public void setConnid(Long connid) {
        this.connid = connid;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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