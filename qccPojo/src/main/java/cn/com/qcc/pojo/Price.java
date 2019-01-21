package cn.com.qcc.pojo;

import java.util.Date;

public class Price {
    /** 价格id*/
    private Long priceid;

    /** 价格类型*/
    private String pricetype;

    /** 价格*/
    private Double prices;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    public Long getPriceid() {
        return priceid;
    }

    public void setPriceid(Long priceid) {
        this.priceid = priceid;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
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