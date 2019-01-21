package cn.com.qcc.pojo;

import java.util.Date;

public class Appconn {
    /** */
    private String phoneAddress;

    /** */
    private String versionid;

    /** */
    private Integer count;

    /** */
    private Date updatetime;

    public String getPhoneAddress() {
        return phoneAddress;
    }

    public void setPhoneAddress(String phoneAddress) {
        this.phoneAddress = phoneAddress == null ? null : phoneAddress.trim();
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid == null ? null : versionid.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}