package cn.com.qcc.pojo;

import java.util.Date;

public class Backimage {
    /** */
    private Long backimageid;

    /** */
    private Integer type;

    /** 背景图片更新时间*/
    private Date createtime;

    /** 这里只保存图片名称*/
    private String backimageUrl;

    /** 图片秒速*/
    private String descname;

    public Long getBackimageid() {
        return backimageid;
    }

    public void setBackimageid(Long backimageid) {
        this.backimageid = backimageid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBackimageUrl() {
        return backimageUrl;
    }

    public void setBackimageUrl(String backimageUrl) {
        this.backimageUrl = backimageUrl == null ? null : backimageUrl.trim();
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }
}