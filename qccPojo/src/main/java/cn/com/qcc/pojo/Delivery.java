package cn.com.qcc.pojo;

import java.util.Date;

public class Delivery {
    /** 收货地址主键*/
    private Long deliveryid;

    /** 用户主ID*/
    private Long userid;

    /** 收货人电话*/
    private String deliveryphone;

    /** 街道的code*/
    private Long code;

    /** 收货人姓名*/
    private String deliveryname;

    /** 收货详情地址*/
    private String deliveryaddress;

    /** 创建收货地址或者编辑的时间*/
    private Date update_time;

    /** 1---可用，2删除*/
    private Integer type;
    
    private String proname;

	private String cityname;

	private String disname;

	private String tradname;

	private Long discode;

	private Long procode;

	private Long tracode;

	private Long citycode;
	
	

    public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDisname() {
		return disname;
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}

	public String getTradname() {
		return tradname;
	}

	public void setTradname(String tradname) {
		this.tradname = tradname;
	}

	public Long getDiscode() {
		return discode;
	}

	public void setDiscode(Long discode) {
		this.discode = discode;
	}

	public Long getProcode() {
		return procode;
	}

	public void setProcode(Long procode) {
		this.procode = procode;
	}

	public Long getTracode() {
		return tracode;
	}

	public void setTracode(Long tracode) {
		this.tracode = tracode;
	}

	public Long getCitycode() {
		return citycode;
	}

	public void setCitycode(Long citycode) {
		this.citycode = citycode;
	}

	public Long getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(Long deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDeliveryphone() {
        return deliveryphone;
    }

    public void setDeliveryphone(String deliveryphone) {
        this.deliveryphone = deliveryphone == null ? null : deliveryphone.trim();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDeliveryname() {
        return deliveryname;
    }

    public void setDeliveryname(String deliveryname) {
        this.deliveryname = deliveryname == null ? null : deliveryname.trim();
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress == null ? null : deliveryaddress.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}