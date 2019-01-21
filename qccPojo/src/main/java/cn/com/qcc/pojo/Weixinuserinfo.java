package cn.com.qcc.pojo;

import java.util.Date;

public class Weixinuserinfo {
    /** ID*/
    private String openId;
    
    private String unionid;

    /** （1是关注，0是未关注）*/
    private Integer subscribe;

    /** 昵称*/
    private String nickname;

    /** 省份*/
    private String province;

    /** 国家*/
    private String country;

    /** （1是男性，2是女性，0是未知）*/
    private Integer sex;

    /** 城市*/
    private String city;

    /** 语言*/
    private String language;

    /** 关注时间*/
    private Date subscribeTime;

    /** utf8*/
    private String headImgUrl;

    /** 微信titcker*/
    private String ticket;
    

    public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

	@Override
	public String toString() {
		return "Weixinuserinfo [openId=" + openId + ", unionid=" + unionid + ", subscribe=" + subscribe + ", nickname="
				+ nickname + ", province=" + province + ", country=" + country + ", sex=" + sex + ", city=" + city
				+ ", language=" + language + ", subscribeTime=" + subscribeTime + ", headImgUrl=" + headImgUrl
				+ ", ticket=" + ticket + "]";
	}
    
    
}