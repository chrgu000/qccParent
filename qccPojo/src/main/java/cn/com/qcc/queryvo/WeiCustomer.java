package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Weixinuserinfo;

public class WeiCustomer extends Weixinuserinfo{

	private String comments;
	
	private Integer currentcount ; 
	
	private Integer allcount;
	
	private Integer sceneid;
	
	private String url;

	public Integer getSceneid() {
		return sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public Integer getCurrentcount() {
		return currentcount;
	}

	public void setCurrentcount(Integer currentcount) {
		this.currentcount = currentcount;
	}

	public Integer getAllcount() {
		return allcount;
	}

	public void setAllcount(Integer allcount) {
		this.allcount = allcount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
