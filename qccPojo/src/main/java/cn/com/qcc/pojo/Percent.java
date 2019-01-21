package cn.com.qcc.pojo;

public class Percent {
    /** */
    private Long percentid;

    /** 1-代表房源*/
    private Double percentnum;

    /** 1-房源*/
    private Integer type;
    
    private String typename;
    

    public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Long getPercentid() {
        return percentid;
    }

    public void setPercentid(Long percentid) {
        this.percentid = percentid;
    }

    public Double getPercentnum() {
        return percentnum;
    }

    public void setPercentnum(Double percentnum) {
        this.percentnum = percentnum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}