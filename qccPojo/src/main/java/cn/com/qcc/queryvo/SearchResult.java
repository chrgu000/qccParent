package cn.com.qcc.queryvo;

import java.util.List;

public class SearchResult  {

	private int recordCount; 
	private int totalPages;
	private List<BuildingCustomer> buildinglist;
	private List<QiuzuCustomer> qiuzulist;
	private List<HouseCustomer> houselist;
	private List<ArticleDetailCustomer> detaillist;
	
	public List<ArticleDetailCustomer> getDetaillist() {
		return detaillist;
	}
	public void setDetaillist(List<ArticleDetailCustomer> detaillist) {
		this.detaillist = detaillist;
	}
	public List<HouseCustomer> getHouselist() {
		return houselist;
	}
	public void setHouselist(List<HouseCustomer> houselist) {
		this.houselist = houselist;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<BuildingCustomer> getBuildinglist() {
		return buildinglist;
	}
	public void setBuildinglist(List<BuildingCustomer> buildinglist) {
		this.buildinglist = buildinglist;
	}
	public List<QiuzuCustomer> getQiuzulist() {
		return qiuzulist;
	}
	public void setQiuzulist(List<QiuzuCustomer> qiuzulist) {
		this.qiuzulist = qiuzulist;
	}

}
