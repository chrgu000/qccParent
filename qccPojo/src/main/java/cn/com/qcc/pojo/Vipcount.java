package cn.com.qcc.pojo;

import java.util.Date;

public class Vipcount {
    /** 关联User表的ID一对一*/
    private Long user_id;

    /** 求租的默认次数*/
    private Integer count;

    /** 1表示VIP，0表示普通用户*/
    private Integer is_vip;

    /** */
    private Date cretime_time;

    /** 可用余额*/
    private Double balance;

    /** 房屋租金*/
    private Double houseaccount;

    /** 收益总额*/
    private Double account;

    /** 提现微信账号*/
    private String weixinaccount;

    /** 提现*/
    private String password;

    /** 佣金*/
    private Double commission;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(Integer is_vip) {
        this.is_vip = is_vip;
    }

    public Date getCretime_time() {
        return cretime_time;
    }

    public void setCretime_time(Date cretime_time) {
        this.cretime_time = cretime_time;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getHouseaccount() {
        return houseaccount;
    }

    public void setHouseaccount(Double houseaccount) {
        this.houseaccount = houseaccount;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public String getWeixinaccount() {
        return weixinaccount;
    }

    public void setWeixinaccount(String weixinaccount) {
        this.weixinaccount = weixinaccount == null ? null : weixinaccount.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }
}