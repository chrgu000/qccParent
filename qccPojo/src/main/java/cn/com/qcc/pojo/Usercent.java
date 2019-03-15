package cn.com.qcc.pojo;

import java.util.Date;

public class Usercent {
    /** 租客登记主键*/
    private Long usercentid;

    /** 租约编号*/
    private String usercentnum;

    /** */
    private Integer centtimes;

    /** 房子ID*/
    private Long houseid;

    /** 用户ID*/
    private Long userid;

    /** 1-未签约，2-已签约，3-毁约 ，4 -历史租约*/
    private Integer centstate;

    /** 房东userid*/
    private Long landuserid;

    /** 管家用户ID推送账单*/
    private Long manageruserid;

    /** 当前房价押金*/
    private Double yaprices;

    /** 租金*/
    private Double centprices;

    /** 租客来源ID*/
    private Long centfromid;

    /** 1-签约用户，2-添加用户*/
    private Integer userstete;

    /** 合同补充*/
    private String othermore;

    /** 更多家具ID是*/
    private String othermoreid;

    /** 支付方式ID*/
    private String paystyleid;

    /** 交租规则*/
    private Long rentmodalid;

    /** 结束签约时间*/
    private Date end_time;

    /** 开始签约时间*/
    private Date start_time;

    public Long getUsercentid() {
        return usercentid;
    }

    public void setUsercentid(Long usercentid) {
        this.usercentid = usercentid;
    }

    public String getUsercentnum() {
        return usercentnum;
    }

    public void setUsercentnum(String usercentnum) {
        this.usercentnum = usercentnum == null ? null : usercentnum.trim();
    }

    public Integer getCenttimes() {
        return centtimes;
    }

    public void setCenttimes(Integer centtimes) {
        this.centtimes = centtimes;
    }

    public Long getHouseid() {
        return houseid;
    }

    public void setHouseid(Long houseid) {
        this.houseid = houseid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getCentstate() {
        return centstate;
    }

    public void setCentstate(Integer centstate) {
        this.centstate = centstate;
    }

    public Long getLanduserid() {
        return landuserid;
    }

    public void setLanduserid(Long landuserid) {
        this.landuserid = landuserid;
    }

    public Long getManageruserid() {
        return manageruserid;
    }

    public void setManageruserid(Long manageruserid) {
        this.manageruserid = manageruserid;
    }

    public Double getYaprices() {
        return yaprices;
    }

    public void setYaprices(Double yaprices) {
        this.yaprices = yaprices;
    }

    public Double getCentprices() {
        return centprices;
    }

    public void setCentprices(Double centprices) {
        this.centprices = centprices;
    }

    public Long getCentfromid() {
        return centfromid;
    }

    public void setCentfromid(Long centfromid) {
        this.centfromid = centfromid;
    }

    public Integer getUserstete() {
        return userstete;
    }

    public void setUserstete(Integer userstete) {
        this.userstete = userstete;
    }

    public String getOthermore() {
        return othermore;
    }

    public void setOthermore(String othermore) {
        this.othermore = othermore == null ? null : othermore.trim();
    }

    public String getOthermoreid() {
        return othermoreid;
    }

    public void setOthermoreid(String othermoreid) {
        this.othermoreid = othermoreid == null ? null : othermoreid.trim();
    }

    public String getPaystyleid() {
        return paystyleid;
    }

    public void setPaystyleid(String paystyleid) {
        this.paystyleid = paystyleid == null ? null : paystyleid.trim();
    }

    public Long getRentmodalid() {
        return rentmodalid;
    }

    public void setRentmodalid(Long rentmodalid) {
        this.rentmodalid = rentmodalid;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}