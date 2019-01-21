package cn.com.qcc.pojo;

public class Articletype {
    /** 主键*/
    private Long onetypeid;

    /** 类型的名称*/
    private String typename;

    /** 1,表示房源，6.表示找物品，7表示找人,11-增值服务*/
    private Integer articletypeid;

    /** 类目对应的图标*/
    private String typeurl;

    /** 规格参数的id*/
    private String codeids;
    
    private String paramTypeNames;
    
	public String getParamTypeNames() {
		return paramTypeNames;
	}

	public void setParamTypeNames(String paramTypeNames) {
		this.paramTypeNames = paramTypeNames;
	}

	public Long getOnetypeid() {
        return onetypeid;
    }

    public void setOnetypeid(Long onetypeid) {
        this.onetypeid = onetypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(Integer articletypeid) {
        this.articletypeid = articletypeid;
    }

    public String getTypeurl() {
        return typeurl;
    }

    public void setTypeurl(String typeurl) {
        this.typeurl = typeurl == null ? null : typeurl.trim();
    }

    public String getCodeids() {
        return codeids;
    }

    public void setCodeids(String codeids) {
        this.codeids = codeids == null ? null : codeids.trim();
    }
}