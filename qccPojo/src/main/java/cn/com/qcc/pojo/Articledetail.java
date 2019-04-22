package cn.com.qcc.pojo;

import java.util.Date;

public class Articledetail {
    /** 发布物品详情的id*/
    private Long articledetailid;

    /** 发布人ID*/
    private Long userid;

    /** 1-正常，2-置顶没有支付，3-移除*/
    private Integer state;

    /** 类目id*/
    private Long onetypeid;

    /** */
    private Integer articletypeid;

    /** 图片*/
    private String picture;

    /** */
    private String tribeids;

    /** 详情地址ID*/
    private Long detailid;

    /** 区域code*/
    private Long code;

    /** 标题*/
    private String title;

    /** 描述*/
    private String description;

    /** 置顶天数*/
    private Integer topday;

    /** 置顶金额(单位分)*/
    private Integer topprices;

    /** 创建时间*/
    private Date update_time;

    /** 视频的地址*/
    private String videourl;

    public Long getArticledetailid() {
        return articledetailid;
    }

    public void setArticledetailid(Long articledetailid) {
        this.articledetailid = articledetailid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getOnetypeid() {
        return onetypeid;
    }

    public void setOnetypeid(Long onetypeid) {
        this.onetypeid = onetypeid;
    }

    public Integer getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(Integer articletypeid) {
        this.articletypeid = articletypeid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getTribeids() {
        return tribeids;
    }

    public void setTribeids(String tribeids) {
        this.tribeids = tribeids == null ? null : tribeids.trim();
    }

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getTopday() {
        return topday;
    }

    public void setTopday(Integer topday) {
        this.topday = topday;
    }

    public Integer getTopprices() {
        return topprices;
    }

    public void setTopprices(Integer topprices) {
        this.topprices = topprices;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }
}