package cn.com.qcc.pojo;

import java.util.Date;

public class Housepaydetail {
    /** 微信订单号*/
    private String ordernum;

    /** 租约编号*/
    private String usercentnum;

    /** 订单总金额*/
    private Double totalprices;

    /** 支付时间*/
    private Date paytime;

    /** 房东的userid*/
    private Long landuserid;

    /** 管理员userid*/
    private Long manageruserid;

    /** 支付的用户id*/
    private Long userid;

    /** 支付的房源id*/
    private Long houseid;

    /** 支付的用户电话*/
    private String payuserphone;

    /** 支付明细*/
    private String detailcontent;

    /** 对应的房号*/
    private String housedetails;

    /** 支付的用户姓名*/
    private String payusername;

    /** 管理员电话*/
    private String managerphone;

    /** 管理员姓名*/
    private String managerusername;

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getUsercentnum() {
        return usercentnum;
    }

    public void setUsercentnum(String usercentnum) {
        this.usercentnum = usercentnum == null ? null : usercentnum.trim();
    }

    public Double getTotalprices() {
        return totalprices;
    }

    public void setTotalprices(Double totalprices) {
        this.totalprices = totalprices;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Long getLanduserid() {
        return landuserid;
    }

    public void setLanduserid(Long landuserid) {
        this.landuserid = landuserid;
    }

    public Long getManageruserid() {
        return manageruserid;
    }

    public void setManageruserid(Long manageruserid) {
        this.manageruserid = manageruserid;
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

    public String getPayuserphone() {
        return payuserphone;
    }

    public void setPayuserphone(String payuserphone) {
        this.payuserphone = payuserphone == null ? null : payuserphone.trim();
    }

    public String getDetailcontent() {
        return detailcontent;
    }

    public void setDetailcontent(String detailcontent) {
        this.detailcontent = detailcontent == null ? null : detailcontent.trim();
    }

    public String getHousedetails() {
        return housedetails;
    }

    public void setHousedetails(String housedetails) {
        this.housedetails = housedetails == null ? null : housedetails.trim();
    }

    public String getPayusername() {
        return payusername;
    }

    public void setPayusername(String payusername) {
        this.payusername = payusername == null ? null : payusername.trim();
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone == null ? null : managerphone.trim();
    }

    public String getManagerusername() {
        return managerusername;
    }

    public void setManagerusername(String managerusername) {
        this.managerusername = managerusername == null ? null : managerusername.trim();
    }
}