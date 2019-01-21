package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.pojo.Rentmodal;


public class RentmodalCustomer extends Rentmodal{
	
	private List<RentmodalCustomer> rents;
	
	private List<RentmodalCustomer> finances;
	
	private List<RentmodalCustomer> children;
	
	
	
	public List<RentmodalCustomer> getChildren() {
		return children;
	}

	public void setChildren(List<RentmodalCustomer> children) {
		this.children = children;
	}

	private String fname;
	
	private String categoryname;
	
	private String value;
	
	private String text;
	
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private Integer financeid;
	

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getFinanceid() {
		return financeid;
	}

	public void setFinanceid(Integer financeid) {
		this.financeid = financeid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public List<RentmodalCustomer> getFinances() {
		return finances;
	}

	public void setFinances(List<RentmodalCustomer> finances) {
		this.finances = finances;
	}

	private Integer rentday;

	private Integer rentid;
	
	
	public Integer getRentid() {
		return rentid;
	}

	public void setRentid(Integer rentid) {
		this.rentid = rentid;
	}

	public Integer getRentday() {
		return rentday;
	}

	public void setRentday(Integer rentday) {
		this.rentday = rentday;
	}

	public List<RentmodalCustomer> getRents() {
		return rents;
	}

	public void setRents(List<RentmodalCustomer> rents) {
		this.rents = rents;
	}

	
	

	
	

}
