package cn.com.qcc.pojo;

public class Percenttype {
    /** */
    private Integer type;

    /** */
    private String typename;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}