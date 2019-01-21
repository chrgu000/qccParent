package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Releasetable;

public class ArticleDetailCustomer extends Articledetail{
	
	private Long tribetypeid;
	
	private Long tribeid ;
	
	private String pricetype;
	
	private List<Releasetable> releList;
	
	private String username;
	
	private Integer juli;
	
	private String detailes;
	
	private String telephone;
	
	private String avatar;
	
	private String typename;
	
	private String detailname;
	
	private String onepicture;
	
	private String longitude;
	
	private String latitude;
	
	private String proname;

	private String cityname;

	private String disname;

	private String tradname;

	private Long discode;

	private Long procode;

	private Long tracode;

	private Long citycode;
	
	private Long bcount;
	
	private String tribepicture;
	
	private String tribename;
	
	private String trading;
	
	private double prices;
	
	private String codeids;
	
	private String currentCheck;
	
	private Long count;
	
	private String tabName;
	
	private String fanStatus;
	
	private String houseNub;
	
	
	public String getHouseNub() {
		return houseNub;
	}

	public void setHouseNub(String houseNub) {
		this.houseNub = houseNub;
	}

	public String getFanStatus() {
		return fanStatus;
	}

	public void setFanStatus(String fanStatus) {
		this.fanStatus = fanStatus;
	}

	public String getPricetype() {
		return pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		
		this.tabName = tabName;
	}

	public Long getTribeid() {
		return tribeid;
	}

	public void setTribeid(Long tribeid) {
		this.tribeid = tribeid;
	}

	public String getCurrentCheck() {
		return currentCheck;
	}

	public void setCurrentCheck(String currentCheck) {
		this.currentCheck = currentCheck;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getCodeids() {
		return codeids;
	}

	public void setCodeids(String codeids) {
		this.codeids = codeids;
	}

	public Long getTribetypeid() {
		return tribetypeid;
	}

	public void setTribetypeid(Long tribetypeid) {
		this.tribetypeid = tribetypeid;
	}

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}


	public String getTribepicture() {
		return tribepicture;
	}

	public void setTribepicture(String tribepicture) {
		this.tribepicture = tribepicture;
	}

	public String getTribename() {
		return tribename;
	}

	public void setTribename(String tribename) {
		this.tribename = tribename;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public Long getBcount() {
		return bcount;
	}

	public void setBcount(Long bcount) {
		this.bcount = bcount;
	}

	public String getDetailname() {
		return detailname;
	}

	public void setDetailname(String detailname) {
		if (CheckDataUtil.checkisEmpty(detailname)) 
			detailname = "";
		this.detailname = detailname;
	}

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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Integer getJuli() {
		return juli;
	}

	public void setJuli(Integer juli) {
		this.juli = juli;
	}

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}


	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Releasetable> getReleList() {
		return releList;
	}

	public void setReleList(List<Releasetable> releList) {
		this.releList = releList;
	}

	

}
