package cn.com.qcc.queryvo;



import cn.com.qcc.pojo.Village;
public class VillageCustomer extends Village {
	
	 /** */
    private String latitude;

    /** 经度*/
    private String longitude;
    
    private String building;
    
    private Long likecode ;
    private Integer juli;
    
    private String desc;
    
    private String asc;
    
    private String houstatus;
    
    private String houstatus2;
    
    private Long smallprices;
    
    private Long bigprices;
    
    private String trading;
    
    private String district;
    
    private Double avgprices;
    
    private Double orderjuli;
    private String name;
    private String julidesc;
    private String juliasc;
    private Long metroid;
    private String metroname;
    private String finalstop;
    private String onepicture;
    private String metroids;
    private Double centprices;
    private String citycode ;
    public Integer getJuli() {
		return juli;
	}

	public void setJuli(Integer juli) {
		this.juli = juli;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getMetroids() {
		return metroids;
	}

	public void setMetroids(String metroids) {
		this.metroids = metroids;
	}

	private Double buyprices;
   

	public Double getCentprices() {
		return centprices;
	}

	public void setCentprices(Double centprices) {
		this.centprices = centprices;
	}

	public Double getBuyprices() {
		return buyprices;
	}

	public void setBuyprices(Double buyprices) {
		this.buyprices = buyprices;
	}

	public String getOnepicture() {
		if (onepicture !=null && !"".equals(onepicture)) {
			onepicture = onepicture.split(",")[0];
		}
		return onepicture;
	}

	public void setOnepicture(String onepicture) {
		if (onepicture !=null && !"".equals(onepicture)) {
			onepicture = onepicture.split(",")[0];
		}
		this.onepicture = onepicture;
	}
	public Long getMetroid() {
		return metroid;
	}

	public void setMetroid(Long metroid) {
		this.metroid = metroid;
	}

	public String getMetroname() {
		return metroname;
	}

	public void setMetroname(String metroname) {
		this.metroname = metroname;
	}

	public String getFinalstop() {
		return finalstop;
	}

	public void setFinalstop(String finalstop) {
		this.finalstop = finalstop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJulidesc() {
		return julidesc;
	}

	public void setJulidesc(String julidesc) {
		this.julidesc = julidesc;
	}

	public String getJuliasc() {
		return juliasc;
	}

	public void setJuliasc(String juliasc) {
		this.juliasc = juliasc;
	}

	public Double getOrderjuli() {
		return orderjuli;
	}

	public void setOrderjuli(Double orderjuli) {
		this.orderjuli = orderjuli;
	}

	
	public Double getAvgprices() {
		return avgprices;
	}

	public void setAvgprices(Double avgprices) {
		this.avgprices = avgprices;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	public Long getSmallprices() {
		return smallprices;
	}

	public void setSmallprices(Long smallprices) {
		this.smallprices = smallprices;
	}

	public Long getBigprices() {
		return bigprices;
	}

	public void setBigprices(Long bigprices) {
		this.bigprices = bigprices;
	}

	public String getHoustatus() {
		return houstatus;
	}

	public void setHoustatus(String houstatus) {
		this.houstatus = houstatus;
	}

	public String getHoustatus2() {
		return houstatus2;
	}

	public void setHoustatus2(String houstatus2) {
		this.houstatus2 = houstatus2;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAsc() {
		return asc;
	}

	public void setAsc(String asc) {
		this.asc = asc;
	}

	

	public Long getLikecode() {
		return likecode;
	}

	public void setLikecode(Long likecode) {
		this.likecode = likecode;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
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
