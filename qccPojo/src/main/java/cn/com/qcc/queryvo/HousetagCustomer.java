package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Housetag;

public class HousetagCustomer  extends Housetag{

	private String houseyear; // 满三年，5年

	private String buildingyear; // 5年以内

	private String elevator; // 电梯

	private String propertyright; // 房屋产权
	
	private String tribeid;

	// 接收性别的参数
	private String sex;
	// 接收是整租还是合租
	private String livestyle;
	// 接收从页面传过来的ID
	private String housetag_id;
	

	public String getTribeid() {
		return tribeid;
	}

	public void setTribeid(String tribeid) {
		this.tribeid = tribeid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLivestyle() {
		return livestyle;
	}

	public void setLivestyle(String livestyle) {
		this.livestyle = livestyle;
	}

	public String getHousetag_id() {
		return housetag_id;
	}

	public void setHousetag_id(String housetag_id) {
		this.housetag_id = housetag_id;
	}

	public String getHouseyear() {
		return houseyear;
	}

	public void setHouseyear(String houseyear) {
		this.houseyear = houseyear;
	}

	public String getBuildingyear() {
		return buildingyear;
	}

	public void setBuildingyear(String buildingyear) {
		this.buildingyear = buildingyear;
	}

	public String getElevator() {
		return elevator;
	}

	public void setElevator(String elevator) {
		this.elevator = elevator;
	}

	public String getPropertyright() {
		return propertyright;
	}

	public void setPropertyright(String propertyright) {
		this.propertyright = propertyright;
	}

}
