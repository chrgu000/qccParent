package cn.com.qcc.pojo;

import java.util.Date;

public class Housepersion {
    /** 入驻人主键ID*/
    private Long housepersionid;

    /** 租约编号*/
    private String usercentnum;

    /** 1-承租人，2-入驻人*/
    private Integer centstate;

    /** 1-在住。2-搬离*/
    private Integer state;

    /** 入驻人性别*/
    private String sex;

    /** 入驻人姓名*/
    private String realname;

    /** 身份证照片*/
    private String pictures;

    /** 国家*/
    private String country;

    /** 证件类型*/
    private String cardtype;

    /** 入驻时间*/
    private Date create_time;

    /** 证件号码*/
    private String identity;

    /** 住址*/
    private String address;

    /** */
    private Date idcardstart_time;

    /** */
    private Date idcardend_time;

    /** 职业*/
    private String job;

    /** 爱好*/
    private String love;

    /** 生日*/
    private Date birthday;

    /** 星座*/
    private String xingzuo;

    /** 备注*/
    private String beizhu;

    /** 户籍*/
    private String huji;

    /** 学历*/
    private String xueli;

    /** 紧急联系人*/
    private String jinjilanname;

    /** */
    private String guanxi;

    /** 紧急联系人电话*/
    private String jinjitelephone;

    /** 联系电话*/
    private String telephone;

    public Long getHousepersionid() {
        return housepersionid;
    }

    public void setHousepersionid(Long housepersionid) {
        this.housepersionid = housepersionid;
    }

    public String getUsercentnum() {
        return usercentnum;
    }

    public void setUsercentnum(String usercentnum) {
        this.usercentnum = usercentnum == null ? null : usercentnum.trim();
    }

    public Integer getCentstate() {
        return centstate;
    }

    public void setCentstate(Integer centstate) {
        this.centstate = centstate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getIdcardstart_time() {
        return idcardstart_time;
    }

    public void setIdcardstart_time(Date idcardstart_time) {
        this.idcardstart_time = idcardstart_time;
    }

    public Date getIdcardend_time() {
        return idcardend_time;
    }

    public void setIdcardend_time(Date idcardend_time) {
        this.idcardend_time = idcardend_time;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love == null ? null : love.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getXingzuo() {
        return xingzuo;
    }

    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo == null ? null : xingzuo.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public String getHuji() {
        return huji;
    }

    public void setHuji(String huji) {
        this.huji = huji == null ? null : huji.trim();
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli == null ? null : xueli.trim();
    }

    public String getJinjilanname() {
        return jinjilanname;
    }

    public void setJinjilanname(String jinjilanname) {
        this.jinjilanname = jinjilanname == null ? null : jinjilanname.trim();
    }

    public String getGuanxi() {
        return guanxi;
    }

    public void setGuanxi(String guanxi) {
        this.guanxi = guanxi == null ? null : guanxi.trim();
    }

    public String getJinjitelephone() {
        return jinjitelephone;
    }

    public void setJinjitelephone(String jinjitelephone) {
        this.jinjitelephone = jinjitelephone == null ? null : jinjitelephone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
}