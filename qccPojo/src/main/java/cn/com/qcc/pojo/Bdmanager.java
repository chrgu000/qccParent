package cn.com.qcc.pojo;

import java.util.Date;

public class Bdmanager {
    /** bd账号*/
    private String bdid;

    /** 管理的区域*/
    private String code;

    /** 用户id*/
    private Long userid;

    /** 真实姓名*/
    private String realname;

    /** 更新时间*/
    private Date upate_time;

    /** 是否可以编辑区域 1- 只读 2-编辑*/
    private Integer isedit;

    /** 状态 0-不可用 1-可用*/
    private Integer state;

    /** 密码*/
    private String password;

    /** 网易token*/
    private String acctoken;

    /** 登录安全码*/
    private String securitytoken;

    /** BD头像*/
    private String avatar;

    /** */
    private Integer level;

    public String getBdid() {
        return bdid;
    }

    public void setBdid(String bdid) {
        this.bdid = bdid == null ? null : bdid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public Integer getIsedit() {
        return isedit;
    }

    public void setIsedit(Integer isedit) {
        this.isedit = isedit;
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

    public String getAcctoken() {
        return acctoken;
    }

    public void setAcctoken(String acctoken) {
        this.acctoken = acctoken == null ? null : acctoken.trim();
    }

    public String getSecuritytoken() {
        return securitytoken;
    }

    public void setSecuritytoken(String securitytoken) {
        this.securitytoken = securitytoken == null ? null : securitytoken.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}