package cn.com.qcc.queryvo;

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