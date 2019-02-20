package cn.com.qcc.pojo;

public class Commoninte {
    /** 金币ID*/
    private Long commonid;

    /** 事件描述*/
    private String typename;

    /** 操作频率*/
    private Integer frequency;

    /** 金币数目*/
    private Long typecount;

    /** 系统描述*/
    private String typeword;

    /** 0-金币 1-砍刀*/
    private Integer type;

    public Long getCommonid() {
        return commonid;
    }

    public void setCommonid(Long commonid) {
        this.commonid = commonid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Long getTypecount() {
        return typecount;
    }

    public void setTypecount(Long typecount) {
        this.typecount = typecount;
    }

    public String getTypeword() {
        return typeword;
    }

    public void setTypeword(String typeword) {
        this.typeword = typeword == null ? null : typeword.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}