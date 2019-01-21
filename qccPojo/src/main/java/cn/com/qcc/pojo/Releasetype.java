package cn.com.qcc.pojo;

public class Releasetype {
    /** */
    private Integer releasetypeid;

    /** 商品规格参数*/
    private String typename;

    /** 颜色规格*/
    private String colorname;

    public Integer getReleasetypeid() {
        return releasetypeid;
    }

    public void setReleasetypeid(Integer releasetypeid) {
        this.releasetypeid = releasetypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname == null ? null : colorname.trim();
    }
}