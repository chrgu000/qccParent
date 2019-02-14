package cn.com.qcc.pojo;

import java.util.Date;

public class Houseorder {
	
	private Long preparatoryid;
	
    /** */
    private Long houseorderid;

    /** 砍价的ID*/
    private Long barginid;

    /** 用户ID*/
    private Long userid;

    /** 房源ID*/
    private Long houseid;

    /** 预定人*/
    private String reservations;

    /** 预定人电话*/
    private String reservationstel;

    /** 预定留言*/
    private String mesage;

    /** 预定的价格*/
    private Double prices;

    /** 1-已经支付，2-没有支付,3-移除，4-等待房东确认,5-已经入住,6-全额退款*/
    private Integer paystate;

    /** 退款原因*/
    private String refundmess;

    /** 微信订单号*/
    private String weixinorder;

    /** 1-正常，2移除*/
    private Integer buystate;

    /** 1-正常，2移除*/
    private Integer sallstate;

    /** */
    private Integer daycount;

    /** 预定时间*/
    private Date ordertime;

    /** 截止时间*/
    private Date endtime;
    
    
    public Long getPreparatoryid() {
		return preparatoryid;
	}

	public void setPreparatoryid(Long preparatoryid) {
		this.preparatoryid = preparatoryid;
	}

	public Long getHouseorderid() {
        return houseorderid;
    }

    public void setHouseorderid(Long houseorderid) {
        this.houseorderid = houseorderid;
    }

    public Long getBarginid() {
        return barginid;
    }

    public void setBarginid(Long barginid) {
        this.barginid = barginid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getHouseid() {
        return houseid;
    }

    public void setHouseid(Long houseid) {
        this.houseid = houseid;
    }

    public String getReservations() {
        return reservations;
    }

    public void setReservations(String reservations) {
        this.reservations = reservations == null ? null : reservations.trim();
    }

    public String getReservationstel() {
        return reservationstel;
    }

    public void setReservationstel(String reservationstel) {
        this.reservationstel = reservationstel == null ? null : reservationstel.trim();
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage == null ? null : mesage.trim();
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public String getRefundmess() {
        return refundmess;
    }

    public void setRefundmess(String refundmess) {
        this.refundmess = refundmess == null ? null : refundmess.trim();
    }

    public String getWeixinorder() {
        return weixinorder;
    }

    public void setWeixinorder(String weixinorder) {
        this.weixinorder = weixinorder == null ? null : weixinorder.trim();
    }

    public Integer getBuystate() {
        return buystate;
    }

    public void setBuystate(Integer buystate) {
        this.buystate = buystate;
    }

    public Integer getSallstate() {
        return sallstate;
    }

    public void setSallstate(Integer sallstate) {
        this.sallstate = sallstate;
    }

    public Integer getDaycount() {
        return daycount;
    }

    public void setDaycount(Integer daycount) {
        this.daycount = daycount;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

}