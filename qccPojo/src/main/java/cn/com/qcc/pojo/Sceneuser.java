package cn.com.qcc.pojo;

import java.util.Date;

public class Sceneuser {
    /** */
    private Integer sceneid;

    /** 备注*/
    private String comments;

    /** 场景值*/
    private String scene;

    /** */
    private String url;

    /** */
    private Integer allcount;

    /** */
    private Integer nearcount;

    /** */
    private Date update_time;

    /** */
    private String ticket;

    public Integer getSceneid() {
        return sceneid;
    }

    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene == null ? null : scene.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getAllcount() {
        return allcount;
    }

    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    public Integer getNearcount() {
        return nearcount;
    }

    public void setNearcount(Integer nearcount) {
        this.nearcount = nearcount;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }
}