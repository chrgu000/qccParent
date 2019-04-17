package cn.com.qcc.pojo;

import java.util.Date;

public class Bargain {
    /** */
    private Long barginid;

    /** 发起砍价人*/
    private Long userid;

    /** 砍价的类型的主键*/
    private Long otherid;

    /** 砍价的金额*/
    private Double lessbalance;

    /** 规则的id*/
    private Long preparatoryid;

    /** */
    private Double totalbanalce;

    /** 砍价的类型*/
    private Integer type;

    /** 砍价时间*/
    private Date starttime;

    /** */
    private Date endtime;

    /** 判断砍价对应的房租对应的佣金*/
    private Integer daycount;

    public Long getBarginid() {
        return barginid;
    }

    public void setBarginid(Long barginid) {
        this.barginid = barginid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getOtherid() {
        return otherid;
    }

    public void setOtherid(Long otherid) {
        this.otherid = otherid;
    }

    public Double getLessbalance() {
        return lessbalance;
    }

    public void setLessbalance(Double lessbalance) {
        this.lessbalance = lessbalance;
    }

    public Long getPreparatoryid() {
        return preparatoryid;
    }

    public void setPreparatoryid(Long preparatoryid) {
        this.preparatoryid = preparatoryid;
    }

    public Double getTotalbanalce() {
        return totalbanalce;
    }

    public void setTotalbanalce(Double totalbanalce) {
        this.totalbanalce = totalbanalce;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getDaycount() {
        return daycount;
    }

    public void setDaycount(Integer daycount) {
        this.daycount = daycount;
    }
}