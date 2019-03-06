package cn.com.qcc.queryvo;

import java.util.Date;

public class UserRoomCustomer {
	
	/**房东的状态**/
	private Integer landstate;
	
	/**登录密码**/
	private String password;
	
	/**用户主键**/
	private Long userid ;
	
	/**用户连接网易云的token**/
	private String acctoken;
	
	/**登录信息安全**/
	private String accestoken;
	
	/**用户类型 1 房东 2 管理**/
	private int usertype;
	
	private String realname;
	
	private String telephone ;
	
	private String bdid;
	
	private String avatar;
	
	private String cityname;
	
	private Long code ;
	
	private Date updatetime;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getBdid() {
		return bdid;
	}
	public void setBdid(String bdid) {
		this.bdid = bdid;
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
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getAcctoken() {
		return acctoken;
	}

	public void setAcctoken(String acctoken) {
		this.acctoken = acctoken;
	}

	public String getAccestoken() {
		return accestoken;
	}

	public void setAccestoken(String accestoken) {
		this.accestoken = accestoken;
	}

	public Integer getLandstate() {
		return landstate;
	}

	public void setLandstate(Integer landstate) {
		this.landstate = landstate;
	}

	
	

}
