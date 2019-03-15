package cn.com.qcc.queryvo;


/**
 * finance.categoryname ,
			housepay.housepayid ,
			housepay.centprices 
 * 
 * **/
public class HousePayJsonModel {
	
	private String categoryname ;
	
	private Long housepayid;
	
	private double  centprices;

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Long getHousepayid() {
		return housepayid;
	}

	public void setHousepayid(Long housepayid) {
		this.housepayid = housepayid;
	}

	public double getCentprices() {
		return centprices;
	}

	public void setCentprices(double centprices) {
		this.centprices = centprices;
	}
	
	
	
	
	

}
