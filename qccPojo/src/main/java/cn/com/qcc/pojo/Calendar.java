package cn.com.qcc.pojo;

public class Calendar {
    /** */
    private String datelist;

    public String getDatelist() {
        return datelist;
    }

    public void setDatelist(String datelist) {
        this.datelist = datelist == null ? null : datelist.trim();
    }
}