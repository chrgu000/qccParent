package cn.com.qcc.detailcommon;

import java.util.Date;

public class User {
    /** 用户的id*/
    private Long userid;

    /** 电话号码*/
    private Long telephone;

    /** 用户类型  普通用户0 房东1 租客2 默认是0*/
    private String usertype;

    /** 用户密码*/
    private String password;

    /** 登录信息安全码*/
    private String accestoken;

    /** 冻结0 正常1 默认1*/
    private String userstatus;

    /** */
    private Double longitude;

    /** */
    private Double latitude;

    /** */
    private Date create_time;

    /** */
    private Date update_time;

    /** 网易云token*/
    private String acctoken;

    /** 融云的Token*/
    private String token;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccestoken() {
        return accestoken;
    }

    public void setAccestoken(String accestoken) {
        this.accestoken = accestoken == null ? null : accestoken.trim();
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus == null ? null : userstatus.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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

    public String getAcctoken() {
        return acctoken;
    }

    public void setAcctoken(String acctoken) {
        this.acctoken = acctoken == null ? null : acctoken.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}