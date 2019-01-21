package cn.com.qcc.pojo;

import java.util.Date;

public class Myorder {
    /** 订单编号*/
    private Long ordernum;

    /** 消费记录主键*/
    private Long consumeid;

    /** 用户ID*/
    private Long userid;

    /** 物品规格参数的唯一标识*/
    private Long releaseid;

    /** 收货地址ID*/
    private Long deliveryid;

    /** */
    private Double totalprices;

    /** 商品的数目*/
    private Integer number;

    /** 1-下单，2-支付，3-发货，4-收货*/
    private Integer state;

    /** 创建时间*/
    private Date update_time;
    
    private String orderstr;
    

    public String getOrderstr() {
		return orderstr;
	}

	public void setOrderstr(String orderstr) {
		this.orderstr = orderstr;
	}

	public Long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    public Long getConsumeid() {
        return consumeid;
    }

    public void setConsumeid(Long consumeid) {
        this.consumeid = consumeid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(Long releaseid) {
        this.releaseid = releaseid;
    }

    public Long getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(Long deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Double getTotalprices() {
        return totalprices;
    }

    public void setTotalprices(Double totalprices) {
        this.totalprices = totalprices;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}