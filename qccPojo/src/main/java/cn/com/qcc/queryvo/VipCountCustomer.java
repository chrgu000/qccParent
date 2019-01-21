package cn.com.qcc.queryvo;

import java.util.Date;

import cn.com.qcc.pojo.Vipcount;

public class VipCountCustomer extends Vipcount {
	
	 private Integer intecount;
	 
	 private Integer mascount;
	 
	 private double monthaccount ;
	 
	 private double totalaccount;
	 
	 private double todayaccount;
	 
	 private String username;
	 
	 private String telephone;
	 
	 private String event;
	 
	 private Long userid;
	 
	 private Integer type ;
	 
	 private Date update_time;
	 

	public double getMonthaccount() {
		return monthaccount;
	}

	public void setMonthaccount(double monthaccount) {
		this.monthaccount = monthaccount;
	}

	public double getTotalaccount() {
		return totalaccount;
	}

	public void setTotalaccount(double totalaccount) {
		this.totalaccount = totalaccount;
	}

	public double getTodayaccount() {
		return todayaccount;
	}

	public void setTodayaccount(double todayaccount) {
		this.todayaccount = todayaccount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getIntecount() {
		return intecount;
	}

	public void setIntecount(Integer intecount) {
		this.intecount = intecount;
	}

	public Integer getMascount() {
		return mascount;
	}

	public void setMascount(Integer mascount) {
		this.mascount = mascount;
	}
	 
	
	

}
