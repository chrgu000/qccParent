package cn.com.qcc.pojo;

import java.util.Date;

public class Partnertrade {
    /** 提现订单号*/
    private Long partnertradeno;

    /** 提现用户ID*/
    private Long userid;

    /** 提现时间*/
    private Date updatetime;

    /** 提现描述*/
    private String pardescname;

    /** 提现金额*/
    private Double account;

    /** 1-微信提现 2-支付宝提现*/
    private Integer type;

    public Long getPartnertradeno() {
        return partnertradeno;
    }

    public void setPartnertradeno(Long partnertradeno) {
        this.partnertradeno = partnertradeno;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPardescname() {
        return pardescname;
    }

    public void setPardescname(String pardescname) {
        this.pardescname = pardescname == null ? null : pardescname.trim();
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}