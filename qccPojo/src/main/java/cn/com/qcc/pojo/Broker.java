package cn.com.qcc.pojo;

import java.util.Date;

public class Broker {
    /** 当前用户ID*/
    private Long userid;

    /** 身份证号码*/
    private String identity;

    /** 身份证照片*/
    private String idpictures;

    /** 真实姓名*/
    private String realname;

    /** 1 - 验证经纪人，2 -通过，3-不通过*/
    private Integer state;

    /** 代理人二维码*/
    private String xcxpicture;

    /** 区域集合*/
    private String codes;

    /** 入驻时间*/
    private Date update_time;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getIdpictures() {
        return idpictures;
    }

    public void setIdpictures(String idpictures) {
        this.idpictures = idpictures == null ? null : idpictures.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getXcxpicture() {
        return xcxpicture;
    }

    public void setXcxpicture(String xcxpicture) {
        this.xcxpicture = xcxpicture == null ? null : xcxpicture.trim();
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes == null ? null : codes.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}