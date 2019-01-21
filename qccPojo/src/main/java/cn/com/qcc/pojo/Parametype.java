package cn.com.qcc.pojo;

public class Parametype {
    /** 物品分类ID*/
    private Long codeid;

    /** 父ID*/
    private Long fatherid;

    /** 上级名称*/
    private String typename;
    
    private Integer type ;
    
    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getCodeid() {
        return codeid;
    }

    public void setCodeid(Long codeid) {
        this.codeid = codeid;
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}