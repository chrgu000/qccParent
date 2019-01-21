package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Releasetable;

public class ReleaseCustomer extends Releasetable{
	
	private String title;
	private String picture;
	private String typename;
	private String colorname;
	private Long articletypeid ;
	private String description;
	private Long typedetailid;
	private String user_name;
	private String avatar;
	private String cityname;
	private String tribename;
	private Long tribeid;
	private Long mescount;
	private Long zancount;
	private String addressname;
	private String shopname;
	private Long fatherid ;
	private Long codeid;
	
	private List<Parametype> paramList;
	
	public Long getCodeid() {
		return codeid;
	}
	public void setCodeid(Long codeid) {
		this.codeid = codeid;
	}
	public List<Parametype> getParamList() {
		return paramList;
	}
	public void setParamList(List<Parametype> paramList) {
		this.paramList = paramList;
	}
	public Long getFatherid() {
		return fatherid;
	}
	public void setFatherid(Long fatherid) {
		this.fatherid = fatherid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getAddressname() {
		return addressname;
	}
	public void setAddressname(String addressname) {
		this.addressname = addressname;
	}
	public Long getMescount() {
		return mescount;
	}
	public void setMescount(Long mescount) {
		this.mescount = mescount;
	}
	public Long getZancount() {
		return zancount;
	}
	public void setZancount(Long zancount) {
		this.zancount = zancount;
	}
	public Long getTribeid() {
		return tribeid;
	}
	public void setTribeid(Long tribeid) {
		this.tribeid = tribeid;
	}
	public String getTribename() {
		return tribename;
	}
	public void setTribename(String tribename) {
		this.tribename = tribename;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Long getTypedetailid() {
		return typedetailid;
	}
	public void setTypedetailid(Long typedetailid) {
		this.typedetailid = typedetailid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getArticletypeid() {
		return articletypeid;
	}
	public void setArticletypeid(Long articletypeid) {
		this.articletypeid = articletypeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getColorname() {
		return colorname;
	}
	public void setColorname(String colorname) {
		this.colorname = colorname;
	}
	
	
	
	

}
