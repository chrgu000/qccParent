package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.common.PageQuery;


public class ReleaseVo {
	
	List<ReleaseCustomer> releList;
	
	private PageQuery pagequery;
	
	private Long userid;
	
	private UserCustomer userCustomer;
	
	
	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	public List<ReleaseCustomer> getReleList() {
		return releList;
	}

	public void setReleList(List<ReleaseCustomer> releList) {
		this.releList = releList;
	}
	

}
