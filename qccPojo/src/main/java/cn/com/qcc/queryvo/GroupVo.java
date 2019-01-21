package cn.com.qcc.queryvo;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Ronggroup;

public class GroupVo {
	
	private Long groupid;
	
	/**当前用户userid**/
	private Long userid ;
	
	/**封装经纬度的信息**/
	private AddressCustomer addressCustomer;
	
	/**区域地址的查询条件**/
	private String addressName;
	
	/**群组的查询条件**/
	private Ronggroup ronggroup;
	
	/**查询框的条件**/
	private String searchwhere;
	
	/**类型的条件**/
	private Long grouptypeid;
	
	/**分页的查询条件**/
	private PageQuery pagequery;
	
	/**群组查询时候过滤的最大距离**/
	private int maxJuli;
	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public int getMaxJuli() {
		return maxJuli;
	}

	public void setMaxJuli(int maxJuli) {
		this.maxJuli = maxJuli;
	}

	public String getSearchwhere() {
		return searchwhere;
	}

	public void setSearchwhere(String searchwhere) {
		this.searchwhere = searchwhere;
	}

	public Long getGrouptypeid() {
		return grouptypeid;
	}

	public void setGrouptypeid(Long grouptypeid) {
		this.grouptypeid = grouptypeid;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	public Ronggroup getRonggroup() {
		return ronggroup;
	}

	public void setRonggroup(Ronggroup ronggroup) {
		this.ronggroup = ronggroup;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public AddressCustomer getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(AddressCustomer addressCustomer) {
		this.addressCustomer = addressCustomer;
	}
	
	
	

}
