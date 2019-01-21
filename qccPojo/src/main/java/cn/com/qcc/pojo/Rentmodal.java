package cn.com.qcc.pojo;

public class Rentmodal {
    /** 收租主键*/
    private Long rentmodalid;

    /** 类别ID*/
    private Integer fatherid;

    /** 类别名称*/
    private String rentname;

    public Long getRentmodalid() {
        return rentmodalid;
    }

    public void setRentmodalid(Long rentmodalid) {
        this.rentmodalid = rentmodalid;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public String getRentname() {
        return rentname;
    }

    public void setRentname(String rentname) {
        this.rentname = rentname == null ? null : rentname.trim();
    }
}