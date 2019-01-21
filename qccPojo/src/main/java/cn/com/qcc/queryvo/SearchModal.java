package cn.com.qcc.queryvo;

public class SearchModal {
	
	private Integer type ; //类型
	
	private String firstname ; // 前面的名称
	
	private String lastname; //后面的名称
	
	private Long detailid ; //详情 的ID

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getDetailid() {
		return detailid;
	}

	public void setDetailid(Long detailid) {
		this.detailid = detailid;
	}

}
