package cn.com.qcc.pojo;

import java.util.Date;

public class Villagetrategy {
    /** 攻略主键*/
    private Long trategyid;

    /** 用户id*/
    private Long userid;

    /** 小区id*/
    private Long villageid;

    /** 攻略描述*/
    private String descname;

    /** 攻略图片*/
    private String strategyimg;

    /** 更新时间*/
    private Date create_time;

    /** 小区攻略视频*/
    private String strategyvedio;

    public Long getTrategyid() {
        return trategyid;
    }

    public void setTrategyid(Long trategyid) {
        this.trategyid = trategyid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getVillageid() {
        return villageid;
    }

    public void setVillageid(Long villageid) {
        this.villageid = villageid;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public String getStrategyimg() {
        return strategyimg;
    }

    public void setStrategyimg(String strategyimg) {
        this.strategyimg = strategyimg == null ? null : strategyimg.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getStrategyvedio() {
        return strategyvedio;
    }

    public void setStrategyvedio(String strategyvedio) {
        this.strategyvedio = strategyvedio == null ? null : strategyvedio.trim();
    }
}