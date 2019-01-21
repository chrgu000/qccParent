package cn.com.qcc.pojo;

import java.util.Date;

public class Branduser {
    /** 品牌的ID*/
    private Long brandid;

    /** 用户的ID*/
    private Long userid;

    /** 1-品牌拥有，2-正常使用，3-停用*/
    private Integer userstate;

    /** 最后一次修改时间*/
    private Date update_time;

    public Long getBrandid() {
        return brandid;
    }

    public void setBrandid(Long brandid) {
        this.brandid = brandid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}