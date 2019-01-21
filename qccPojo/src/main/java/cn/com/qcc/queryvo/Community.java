package cn.com.qcc.queryvo;

import java.util.Date;

public class Community {
    /** 小区ID*/
    private Long villageid;

    /** */
    private Long userid;

    /** 小区图片*/
    private String picture;

    /** 房屋总数*/
    private String housecount;

    /** 完成的年份*/
    private String comyear;

    /** 物业公司*/
    private String company;

    /** 停车费用*/
    private String carfree;

    /** 物业费用*/
    private String comfree;

    /** 物业电话*/
    private String comphone;

    /** 车位总数*/
    private String carcount;

    /** 楼栋总数*/
    private String comcount;

    /** 开发商电话*/
    private String devephone;

    /** 开发商*/
    private String developer;

    /** 村委电话*/
    private String villagephone;

    /** */
    private Date update_time;

    /** 1-通过，2-不通过*/
    private Integer state;

    /** 描述*/
    private String describes;

    public Long getVillageid() {
        return villageid;
    }

    public void setVillageid(Long villageid) {
        this.villageid = villageid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getHousecount() {
        return housecount;
    }

    public void setHousecount(String housecount) {
        this.housecount = housecount == null ? null : housecount.trim();
    }

    public String getComyear() {
        return comyear;
    }

    public void setComyear(String comyear) {
        this.comyear = comyear == null ? null : comyear.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCarfree() {
        return carfree;
    }

    public void setCarfree(String carfree) {
        this.carfree = carfree == null ? null : carfree.trim();
    }

    public String getComfree() {
        return comfree;
    }

    public void setComfree(String comfree) {
        this.comfree = comfree == null ? null : comfree.trim();
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone == null ? null : comphone.trim();
    }

    public String getCarcount() {
        return carcount;
    }

    public void setCarcount(String carcount) {
        this.carcount = carcount == null ? null : carcount.trim();
    }

    public String getComcount() {
        return comcount;
    }

    public void setComcount(String comcount) {
        this.comcount = comcount == null ? null : comcount.trim();
    }

    public String getDevephone() {
        return devephone;
    }

    public void setDevephone(String devephone) {
        this.devephone = devephone == null ? null : devephone.trim();
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public String getVillagephone() {
        return villagephone;
    }

    public void setVillagephone(String villagephone) {
        this.villagephone = villagephone == null ? null : villagephone.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }
}