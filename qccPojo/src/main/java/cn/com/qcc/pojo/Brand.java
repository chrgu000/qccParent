package cn.com.qcc.pojo;

import java.util.Date;

public class Brand {
    /** 品牌公寓主键*/
    private Long brandid;

    /** 用户IDS*/
    private Long userid;

    /** 1-表示申请，2-表示通过*/
    private Integer state;

    /** 品牌所属区域*/
    private String codes;

    /** 品牌描述*/
    private String description;

    /** 品牌名称*/
    private String brand;

    /** 品牌图片*/
    private String onepicture;

    /** 品牌创建时间*/
    private Date update_time;
    
    private String userstate ;
    

    public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes == null ? null : codes.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getOnepicture() {
        return onepicture;
    }

    public void setOnepicture(String onepicture) {
        this.onepicture = onepicture == null ? null : onepicture.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}