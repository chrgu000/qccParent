package cn.com.qcc.pojo;

public class Systemstate {
    /** */
    private Integer systemid;

    /** 系统参数描述*/
    private String descname;

    /** 参数说明*/
    private String stateabout;

    /** */
    private Integer defaultstate;

    /** 系统参数关键字不能修改*/
    private String typeword;

    public Integer getSystemid() {
        return systemid;
    }

    public void setSystemid(Integer systemid) {
        this.systemid = systemid;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public String getStateabout() {
        return stateabout;
    }

    public void setStateabout(String stateabout) {
        this.stateabout = stateabout == null ? null : stateabout.trim();
    }

    public Integer getDefaultstate() {
        return defaultstate;
    }

    public void setDefaultstate(Integer defaultstate) {
        this.defaultstate = defaultstate;
    }

    public String getTypeword() {
        return typeword;
    }

    public void setTypeword(String typeword) {
        this.typeword = typeword == null ? null : typeword.trim();
    }
}