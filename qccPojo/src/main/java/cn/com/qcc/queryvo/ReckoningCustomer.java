package cn.com.qcc.queryvo;

import java.util.Date;

public class ReckoningCustomer {

	private String realname; // 真实姓名

	private String telephone; // 电话号码

	private Long houseid; // 房源ID
	private Date date;
	private Long buildingid;
	private String trading;

	private String villagename;

	private String building;

	private Long floor;

	private Double total;

	private Integer house_number; // 房号

	private Long financeid;

	private String shuifei = "";

	private String dianfei = "";

	private String meiqifei = "";

	private String diantifei = "";

	private String weishenfei = "";

	private String youxian = "";

	private String guanlifei = "";

	private String lajifei = "";

	private String lenshuifeifei = "";

	private String reshuifei = "";

	private String huanfangfei = "";

	private String kuandai = "";

	private String yajin = "";

	private String zujin = "";

	private String centprices = "";

	private String reshuichu = "";

	private String reshuimo = "";

	private String lengshuichu = "";

	private String lengshuimo = "";

	private String shuichu = "";

	private String shuimo = "";

	private String dianchu = "";

	private String dianmo = "";

	private String meiqichu = "";

	private String meiqimo = "";
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

	public Long getFloor() {
		return floor;
	}

	public void setFloor(Long floor) {
		this.floor = floor;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getReshuichu() {
		return reshuichu;
	}

	public void setReshuichu(String reshuichu) {
		this.reshuichu = reshuichu;
	}

	public String getReshuimo() {
		return reshuimo;
	}

	public void setReshuimo(String reshuimo) {
		this.reshuimo = reshuimo;
	}

	public String getLengshuichu() {
		return lengshuichu;
	}

	public void setLengshuichu(String lengshuichu) {
		this.lengshuichu = lengshuichu;
	}

	public String getLengshuimo() {
		return lengshuimo;
	}

	public void setLengshuimo(String lengshuimo) {
		this.lengshuimo = lengshuimo;
	}

	public String getShuichu() {
		return shuichu;
	}

	public void setShuichu(String shuichu) {
		this.shuichu = shuichu;
	}

	public String getShuimo() {
		return shuimo;
	}

	public void setShuimo(String shuimo) {
		this.shuimo = shuimo;
	}

	public String getDianchu() {
		return dianchu;
	}

	public void setDianchu(String dianchu) {
		this.dianchu = dianchu;
	}

	public String getDianmo() {
		return dianmo;
	}

	public void setDianmo(String dianmo) {
		this.dianmo = dianmo;
	}

	public String getMeiqichu() {
		return meiqichu;
	}

	public void setMeiqichu(String meiqichu) {
		this.meiqichu = meiqichu;
	}

	public String getMeiqimo() {
		return meiqimo;
	}

	public void setMeiqimo(String meiqimo) {
		this.meiqimo = meiqimo;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public Integer getHouse_number() {
		return house_number;
	}

	public void setHouse_number(Integer house_number) {
		this.house_number = house_number;
	}

	public Long getFinanceid() {
		return financeid;
	}

	public void setFinanceid(Long financeid) {
		this.financeid = financeid;
	}

	public String getShuifei() {
		return shuifei;
	}

	public void setShuifei(String shuifei) {
		if (shuifei == null) {
			shuifei = "";
		}
		this.shuifei = shuifei;
	}

	public String getDianfei() {
		return dianfei;
	}

	public void setDianfei(String dianfei) {
		this.dianfei = dianfei;
	}

	public String getMeiqifei() {
		return meiqifei;
	}

	public void setMeiqifei(String meiqifei) {
		this.meiqifei = meiqifei;
	}

	public String getDiantifei() {
		return diantifei;
	}

	public void setDiantifei(String diantifei) {
		this.diantifei = diantifei;
	}

	public String getWeishenfei() {
		return weishenfei;
	}

	public void setWeishenfei(String weishenfei) {
		this.weishenfei = weishenfei;
	}

	public String getYouxian() {
		return youxian;
	}

	public void setYouxian(String youxian) {
		this.youxian = youxian;
	}

	public String getGuanlifei() {
		return guanlifei;
	}

	public void setGuanlifei(String guanlifei) {
		this.guanlifei = guanlifei;
	}

	public String getLajifei() {
		return lajifei;
	}

	public void setLajifei(String lajifei) {
		this.lajifei = lajifei;
	}

	public String getLenshuifeifei() {
		return lenshuifeifei;
	}

	public void setLenshuifeifei(String lenshuifeifei) {
		this.lenshuifeifei = lenshuifeifei;
	}

	public String getReshuifei() {
		return reshuifei;
	}

	public void setReshuifei(String reshuifei) {
		this.reshuifei = reshuifei;
	}

	public String getHuanfangfei() {
		return huanfangfei;
	}

	public void setHuanfangfei(String huanfangfei) {
		this.huanfangfei = huanfangfei;
	}

	public String getKuandai() {
		return kuandai;
	}

	public void setKuandai(String kuandai) {
		this.kuandai = kuandai;
	}

	public String getYajin() {
		return yajin;
	}

	public void setYajin(String yajin) {
		this.yajin = yajin;
	}

	public String getZujin() {
		return zujin;
	}

	public void setZujin(String zujin) {
		this.zujin = zujin;
	}

	public String getCentprices() {
		return centprices;
	}

	public void setCentprices(String centprices) {
		this.centprices = centprices;
	}

}
