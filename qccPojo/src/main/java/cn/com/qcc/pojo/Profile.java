package cn.com.qcc.pojo;

import java.util.Date;


public class Profile {
    /** */
    private Long profileid;

    /** 对应用户表中的id字段*/
    private Long user_id;
    

    /** 微信提现账号的唯一标识*/
    private String unionid;

    /** 用户地址id*/
    private Long address_id;

    /** 用户头像*/
    private String avatar;

    /** 用户名*/
    private String user_name;

    /** 用户真实姓名*/
    private String real_name;

    /** 身份证号*/
    private String identity;

    /** 证件照片 第一正面。第二个反面 */
    private String idpictures;

    /** 家庭住址*/
    private String homeaddress;

    /** 用户签名*/
    private String mysign;

    /** 性别*/
    private String sex;

    /** 邮箱*/
    private String mail;

    /** 注册的区域code*/
    private Long code;

    /** 1-表示没有实名，2-表示已经实名 */
    private Integer signstate;

    /** 创建时间*/
    private Date create_time;

    /** 生日*/
    private Date birthday;

    /** 最后一次实名时间*/
    private Date sign_time;
    
    

   
	public Long getProfileid() {
        return profileid;
    }

    public void setProfileid(Long profileid) {
        this.profileid = profileid;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
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

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public String getMysign() {
        return mysign;
    }

    public void setMysign(String mysign) {
        this.mysign = mysign == null ? null : mysign.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getSignstate() {
        return signstate;
    }

    public void setSignstate(Integer signstate) {
        this.signstate = signstate;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getSign_time() {
        return sign_time;
    }

    public void setSign_time(Date sign_time) {
        this.sign_time = sign_time;
    }
}