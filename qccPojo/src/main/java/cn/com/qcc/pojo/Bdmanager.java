package cn.com.qcc.pojo;

import java.util.Date;

public class Bdmanager {
    /** bd账号*/
    private String bdid;

    /** 联系电话*/
    private String telephone;

    /** 真实姓名*/
    private String realname;

    /** 更新时间*/
    private Date upate_time;

    /** 状态 0-不可用 1-可用*/
    private Integer state;

    /** 密码*/
    private String password;

    public String getBdid() {
        return bdid;
    }

    public void setBdid(String bdid) {
        this.bdid = bdid == null ? null : bdid.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Date getUpate_time() {
        return upate_time;
    }

    public void setUpate_time(Date upate_time) {
        this.upate_time = upate_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}