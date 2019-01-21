package cn.com.qcc.pojo;

public class Grouptype {
    /** 类型id*/
    private Long grouptypeid;

    /** 类型名称*/
    private String typename;

    /** 上一级id*/
    private Long fatherid;

    /** 小图片*/
    private String typeurl;

    public Long getGrouptypeid() {
        return grouptypeid;
    }

    public void setGrouptypeid(Long grouptypeid) {
        this.grouptypeid = grouptypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public String getTypeurl() {
        return typeurl;
    }

    public void setTypeurl(String typeurl) {
        this.typeurl = typeurl == null ? null : typeurl.trim();
    }
}