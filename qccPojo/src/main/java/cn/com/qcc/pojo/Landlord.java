package cn.com.qcc.pojo;

import java.util.Date;

public class Landlord {
    /** 房东的userid*/
    private Long landuserid;

    /** BD 对应账号*/
    private String bdid;

    /** 身份证号*/
    private String identity;

    /** 身份证照片*/
    private String idpictures;

    /** 房东姓名*/
    private String realname;

    /** 1-申请房东，2-通过 ,3不通过 */
    private Integer landstate;

    /** 所属区域*/
    private Long code;

    /** utf8*/
    private String landaddress;

    /** 更新时间*/
    private Date update_time;

    public Long getLanduserid() {
        return landuserid;
    }

    public void setLanduserid(Long landuserid) {
        this.landuserid = landuserid;
    }

    public String getBdid() {
        return bdid;
    }

    public void setBdid(String bdid) {
        this.bdid = bdid == null ? null : bdid.trim();
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

    public Integer getLandstate() {
        return landstate;
    }

    public void setLandstate(Integer landstate) {
        this.landstate = landstate;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLandaddress() {
        return landaddress;
    }

    public void setLandaddress(String landaddress) {
        this.landaddress = landaddress == null ? null : landaddress.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}