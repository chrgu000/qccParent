package cn.com.qcc.queryvo;

import java.util.Date;

import cn.com.qcc.common.PageQuery;


public class HydCoalVo {
	
	private PageQuery pagequery;
	
	private Long buildingid;
	
	private Long userid;
	
	private Date start;
	
	private Date end ;
	
	private Long financeid;
	
	private Long floor;
	
	private Long houseid ;
	
	private String state ;  // not --表示没有抄表 。yes 表示已经抄表
	
	
	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
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

	public Long getFinanceid() {
		return financeid;
	}

	public void setFinanceid(Long financeid) {
		this.financeid = financeid;
	}
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public Long getFloor() {
		return floor;
	}

	public void setFloor(Long floor) {
		this.floor = floor;
	}

	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	

}
