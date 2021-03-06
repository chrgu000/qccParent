package cn.com.qcc.pojo;

import java.util.Date;

public class Landlord {
    /** 房东的userid*/
    private Long landuserid;

    /** BD 对应账号*/
    private String bdid;

    /** 1-申请房东，2-通过 ,3不通过 */
    private Integer landstate;

    /** 所属区域*/
    private Long code;

    /** utf8*/
    private String address;

    /** 更新时间*/
    private Date update_time;

    /** 品牌名称*/
    private String brandname;

    /** 公司名称*/
    private String corporate;

    /** 营业执照编号*/
    private String businessnum;

    /** 营业执照图片*/
    private String businesspicture;

    /** 联系人*/
    private String linkman;

    /** 联系人电话*/
    private String linkphone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public String getCorporate() {
        return corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate == null ? null : corporate.trim();
    }

    public String getBusinessnum() {
        return businessnum;
    }

    public void setBusinessnum(String businessnum) {
        this.businessnum = businessnum == null ? null : businessnum.trim();
    }

    public String getBusinesspicture() {
        return businesspicture;
    }

    public void setBusinesspicture(String businesspicture) {
        this.businesspicture = businesspicture == null ? null : businesspicture.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }
}