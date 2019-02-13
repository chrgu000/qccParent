package cn.com.qcc.pojo;

public class UserRole {
    /** */
    private Long userid;

    /** */
    private Long roleid;

    /** 角色状态 1-正常 2-停用*/
    private Integer state;
    
    
    private String outtype;
    
    

    public String getOuttype() {
		return outtype;
	}

	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}