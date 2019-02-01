package cn.com.qcc.pojo;

public class Living {
    /** 提问的主键ID*/
    private Long livingid;

    /** 创建提问人ID*/
    private Long typeid;

    /** 发起提问关联ID*/
    private String content;

    /** 发起提问时间*/
    private Integer orderasc;

    /** 提问的类型1-8*/
    private Integer state;

    /** 关键字*/
    private String keyword;

    public Long getLivingid() {
        return livingid;
    }

    public void setLivingid(Long livingid) {
        this.livingid = livingid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getOrderasc() {
        return orderasc;
    }

    public void setOrderasc(Integer orderasc) {
        this.orderasc = orderasc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}