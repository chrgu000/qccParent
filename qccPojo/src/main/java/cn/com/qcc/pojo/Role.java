package cn.com.qcc.pojo;

public class Role {
    /** 角色ID*/
    private Long roleid;

    /** 角色名称*/
    private String rolename;
    
    private String role_access;
    
    private String role_accid;
    
    

    public String getRole_access() {
		return role_access;
	}

	public void setRole_access(String role_access) {
		this.role_access = role_access;
	}

	public String getRole_accid() {
		return role_accid;
	}

	public void setRole_accid(String role_accid) {
		this.role_accid = role_accid;
	}

	public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}