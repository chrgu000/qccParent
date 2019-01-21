package cn.com.qcc.pojo;

public class Villagetype {
    /** */
    private Long villagetypeid;

    /** 小区类型*/
    private String typename;

    public Long getVillagetypeid() {
        return villagetypeid;
    }

    public void setVillagetypeid(Long villagetypeid) {
        this.villagetypeid = villagetypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}