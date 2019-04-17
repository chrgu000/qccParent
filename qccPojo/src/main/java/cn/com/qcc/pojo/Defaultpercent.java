package cn.com.qcc.pojo;

public class Defaultpercent {
    /** */
    private Integer id;

    /** 描述*/
    private String descname;

    /** */
    private Double centnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public Double getCentnum() {
        return centnum;
    }

    public void setCentnum(Double centnum) {
        this.centnum = centnum;
    }
}