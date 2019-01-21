package cn.com.qcc.pojo;

public class Finance {
    /** 财务配置表主键*/
    private Long financeid;

    /** 父级ID*/
    private Long fatherid;

    /** 财务配置名称*/
    private String categoryname;

    public Long getFinanceid() {
        return financeid;
    }

    public void setFinanceid(Long financeid) {
        this.financeid = financeid;
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }
}