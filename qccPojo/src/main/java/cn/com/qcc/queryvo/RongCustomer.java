package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.pojo.Ronggroup;

public class RongCustomer extends Ronggroup{
	
	private Integer tcount;
	
	private String detailes;
	
	private String typename;
	
	private String avatar ;
	
	private String user_name;
	
	private Double latitude;
	
	private Double longitude;
	
	private String juli;
	
	private Integer userstate ;
	
	private List<RongCustomer> groupList;
	
	private String fathername;
	
	private String groupname;
	
	
	
	
	
	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Integer getUserstate() {
		return userstate;
	}

	public void setUserstate(Integer userstate) {
		if (userstate == 0 ) 
			userstate = 2;
		this.userstate = userstate;
	}

	public List<RongCustomer> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<RongCustomer> groupList) {
		this.groupList = groupList;
	}

	public String getJuli() {
		return juli;
	}

	public void setJuli(String juli) {
		// 设置距离
		juli = IDUtils.mPRETokm(juli);
		this.juli = juli;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public Integer getTcount() {
		return tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}
	
	

}
