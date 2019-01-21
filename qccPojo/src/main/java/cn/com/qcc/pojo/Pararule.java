package cn.com.qcc.pojo;

public class Pararule {
    /** */
    private Integer pararuleid;

    /** 预定描述*/
    private String pararulename;

    /** 规格详情*/
    private String pararuledetail;

    public Integer getPararuleid() {
        return pararuleid;
    }

    public void setPararuleid(Integer pararuleid) {
        this.pararuleid = pararuleid;
    }

    public String getPararulename() {
        return pararulename;
    }

    public void setPararulename(String pararulename) {
        this.pararulename = pararulename == null ? null : pararulename.trim();
    }

    public String getPararuledetail() {
        return pararuledetail;
    }

    public void setPararuledetail(String pararuledetail) {
        this.pararuledetail = pararuledetail == null ? null : pararuledetail.trim();
    }
}