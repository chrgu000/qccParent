package cn.com.qcc.pojo;

import java.util.Date;

public class Housemodel {
	
	private double smallprices = 0 ;
	private double bigprices = 99999999999999999999.0;
	private String orderValue ="DEFAULT";
	private String latitude;
	private String longitude ;
	private String onepicture;
	private Long villageid ;
	
	
	
	
	
	
	
	
    public Long getVillageid() {
		return villageid;
	}

	public void setVillageid(Long villageid) {
		this.villageid = villageid;
	}

	public String getOnepicture() {
		return onepicture;
	}

	public void setOnepicture(String onepicture) {
		this.onepicture = onepicture;
	}

	public double getSmallprices() {
		return smallprices;
	}

	public void setSmallprices(double smallprices) {
		this.smallprices = smallprices;
	}

	public double getBigprices() {
		return bigprices;
	}

	public void setBigprices(double bigprices) {
		this.bigprices = bigprices;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

	/** 房源库主键*/
    private Long houseModelId;

    /** 房子id*/
    private Long houseid;

    /** 用户id*/
    private Long userid;

    /** 房子标题*/
    private String houseTitle;

    /** 导入房源库时间*/
    private Date updateTime;

    /** 图片*/
    private String picture;

    /** 价格*/
    private Double prices;

    /** 户型*/
    private String apartmentName;

    /** 装修类型*/
    private String redecorat;

    /** 城市code*/
    private String citycode;

    /** 标签id*/
    private String housetagid;

    /** 小区名称*/
    private String villageName;

    /** 楼栋名称*/
    private String building;

    /** 描述*/
    private String descname;

    /** 房号*/
    private String houseNumber;

    /** 支付方式*/
    private String paystyle;

    /** 业主电话*/
    private String landPhone;

    /** 业主姓名*/
    private String landName;

    /** 区域*/
    private String district;

    /** 街道*/
    private String trading;

    /** 面积*/
    private Double area;

    /** 详情地址*/
    private String detailes;

    /** 经纬度*/
    private String latlng;

    /** 出租方式*/
    private String centType;

    /** 出租状态*/
    private String centState;

    /** 可入住时间*/
    private Date centTime;

    /** 楼层*/
    private String floor;

    /** 佣金百分比*/
    private Double agencyNumber;

    public Long getHouseModelId() {
        return houseModelId;
    }

    public void setHouseModelId(Long houseModelId) {
        this.houseModelId = houseModelId;
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

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle == null ? null : houseTitle.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName == null ? null : apartmentName.trim();
    }

    public String getRedecorat() {
        return redecorat;
    }

    public void setRedecorat(String redecorat) {
        this.redecorat = redecorat == null ? null : redecorat.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getHousetagid() {
        return housetagid;
    }

    public void setHousetagid(String housetagid) {
        this.housetagid = housetagid == null ? null : housetagid.trim();
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName == null ? null : villageName.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber == null ? null : houseNumber.trim();
    }

    public String getPaystyle() {
        return paystyle;
    }

    public void setPaystyle(String paystyle) {
        this.paystyle = paystyle == null ? null : paystyle.trim();
    }

    public String getLandPhone() {
        return landPhone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone == null ? null : landPhone.trim();
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName == null ? null : landName.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getTrading() {
        return trading;
    }

    public void setTrading(String trading) {
        this.trading = trading == null ? null : trading.trim();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDetailes() {
        return detailes;
    }

    public void setDetailes(String detailes) {
        this.detailes = detailes == null ? null : detailes.trim();
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng == null ? null : latlng.trim();
    }

    public String getCentType() {
        return centType;
    }

    public void setCentType(String centType) {
        this.centType = centType == null ? null : centType.trim();
    }

    public String getCentState() {
        return centState;
    }

    public void setCentState(String centState) {
        this.centState = centState == null ? null : centState.trim();
    }

    public Date getCentTime() {
        return centTime;
    }

    public void setCentTime(Date centTime) {
        this.centTime = centTime;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public Double getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(Double agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
    
    
    
}