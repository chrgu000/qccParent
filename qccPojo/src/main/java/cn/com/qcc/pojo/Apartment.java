package cn.com.qcc.pojo;

import java.util.Date;

public class Apartment {
    /** 户型表id*/
    private Integer apartmentid;

    /** 户型名*/
    private String apartmentname;

    /** 创建时间*/
    private Date create_time;

    /** 更新时间*/
    private Date update_time;

    public Integer getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(Integer apartmentid) {
        this.apartmentid = apartmentid;
    }

    public String getApartmentname() {
        return apartmentname;
    }

    public void setApartmentname(String apartmentname) {
        this.apartmentname = apartmentname == null ? null : apartmentname.trim();
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