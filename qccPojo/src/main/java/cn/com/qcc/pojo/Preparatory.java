package cn.com.qcc.pojo;

public class Preparatory {
    /** 主键*/
    private Long preparatoryid;

    /** 房源ID*/
    private Long houseid;

    /** 选择的标签*/
    private Long housetagid;

    /** 租客付佣金*/
    private Double centpercentnum;

    /** 房东付佣金*/
    private Double landpercentnum;

    /** 一起的天数*/
    private Integer daycount;

    public Long getPreparatoryid() {
        return preparatoryid;
    }

    public void setPreparatoryid(Long preparatoryid) {
        this.preparatoryid = preparatoryid;
    }

    public Long getHouseid() {
        return houseid;
    }

    public void setHouseid(Long houseid) {
        this.houseid = houseid;
    }

    public Long getHousetagid() {
        return housetagid;
    }

    public void setHousetagid(Long housetagid) {
        this.housetagid = housetagid;
    }

    public Double getCentpercentnum() {
        return centpercentnum;
    }

    public void setCentpercentnum(Double centpercentnum) {
        this.centpercentnum = centpercentnum;
    }

    public Double getLandpercentnum() {
        return landpercentnum;
    }

    public void setLandpercentnum(Double landpercentnum) {
        this.landpercentnum = landpercentnum;
    }

    public Integer getDaycount() {
        return daycount;
    }

    public void setDaycount(Integer daycount) {
        this.daycount = daycount;
    }
}