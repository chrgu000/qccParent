package cn.com.qcc.queryvo;

import cn.com.qcc.common.PageQuery;

public class MailVo {
	
	private PageQuery pagequery;
	
	private Long userid ;
	
	private String searchwhere;
	
	private String isUserid;
	

	public String getIsUserid() {
		return isUserid;
	}

	public void setIsUserid(String isUserid) {
		this.isUserid = isUserid;
	}

	public String getSearchwhere() {
		return searchwhere;
	}

	public void setSearchwhere(String searchwhere) {
		this.searchwhere = searchwhere;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	

}
