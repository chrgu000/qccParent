package cn.com.qcc.pojo;

public class Metro {
    /** 地铁ID*/
    private Long metroid;

    /** 城市的code*/
    private Long code;

    /** 地铁名称*/
    private String name;

    /** 站点*/
    private String finalstop;

    public Long getMetroid() {
        return metroid;
    }

    public void setMetroid(Long metroid) {
        this.metroid = metroid;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFinalstop() {
        return finalstop;
    }

    public void setFinalstop(String finalstop) {
        this.finalstop = finalstop == null ? null : finalstop.trim();
    }
}