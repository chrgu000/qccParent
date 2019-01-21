package cn.com.qcc.pojo;

public class Paymodal {
    /** */
    private Long paymodalid;

    /** 1-表示付的，2表示压的*/
    private Integer state;

    /** 业务类型名称*/
    private String typename;

    /** */
    private Integer multiple;

    public Long getPaymodalid() {
        return paymodalid;
    }

    public void setPaymodalid(Long paymodalid) {
        this.paymodalid = paymodalid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }
}