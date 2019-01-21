package cn.com.qcc.queryvo;

import java.util.Date;

import cn.com.qcc.common.PageQuery;


public class UserCentVo {
	
	private Long userid ;
	
	private String serachwhere; //封装查看日期还是房源
	
	private String centtime; //封装应收款日，还是实际收款日 create
	
	private Date start ;
	
	private String ordername;
	
	private String code;
	
	private Date end ;
	
	private HousepayCustomer housepayCustomer;
	
	private BuildingCustomer buildingCustomer;
	
	private PageQuery pagequery;
	
	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HousepayCustomer getHousepayCustomer() {
		return housepayCustomer;
	}

	public void setHousepayCustomer(HousepayCustomer housepayCustomer) {
		this.housepayCustomer = housepayCustomer;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	public BuildingCustomer getBuildingCustomer() {
		return buildingCustomer;
	}

	public void setBuildingCustomer(BuildingCustomer buildingCustomer) {
		this.buildingCustomer = buildingCustomer;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getCenttime() {
		return centtime;
	}

	public void setCenttime(String centtime) {
		this.centtime = centtime;
	}

	public String getSerachwhere() {
		return serachwhere;
	}

	public void setSerachwhere(String serachwhere) {
		this.serachwhere = serachwhere;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
}
