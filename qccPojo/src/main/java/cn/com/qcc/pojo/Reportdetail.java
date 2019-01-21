package cn.com.qcc.pojo;

import java.util.Date;

public class Reportdetail {
    /** 举报的详情ID*/
    private Integer reportdetailid;

    /** 举报的类目ID*/
    private String reportids;

    /** 举报人ID*/
    private Long userid;

    /** 举报的物品ID*/
    private Long otherid;

    /** 举报的图片*/
    private String pictures;

    /** 举报描述*/
    private String descname;

    /** 举报处理结果 1-没有处理 ，2-举报通过，3-举报不通过*/
    private Integer state;

    /** 举报时间*/
    private Date create_time;

    public Integer getReportdetailid() {
        return reportdetailid;
    }

    public void setReportdetailid(Integer reportdetailid) {
        this.reportdetailid = reportdetailid;
    }

    public String getReportids() {
        return reportids;
    }

    public void setReportids(String reportids) {
        this.reportids = reportids == null ? null : reportids.trim();
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

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}