package cn.com.qcc.pojo;

import java.util.Date;

public class Property {
    /** 房源物业表id*/
    private Integer propertyid;

    /** 分为租和卖两类*/
    private String propertytype;

    /** 物业名称*/
    private String propertyname;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    public Integer getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype == null ? null : propertytype.trim();
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname == null ? null : propertyname.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}