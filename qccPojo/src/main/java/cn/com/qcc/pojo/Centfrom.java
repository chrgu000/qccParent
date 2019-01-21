package cn.com.qcc.pojo;

public class Centfrom {
    /** 租客来源渠道ID*/
    private Long centfromid;

    /** */
    private String fatherid;

    /** 上级ID*/
    private String categoryname;

    public Long getCentfromid() {
        return centfromid;
    }

    public void setCentfromid(Long centfromid) {
        this.centfromid = centfromid;
    }

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid == null ? null : fatherid.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }
}