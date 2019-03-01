package cn.com.qcc.queryvo;

import java.util.Date;

import cn.com.qcc.pojo.Housepay;

public class HousepayCustomer  extends Housepay{
	
	private String financeids;
	
	private int fatherid;
	
	private String categoryname;
	//逾期时间
	private int  needoutday;
	// 需要支付的时间
	private Date needpaytime ;
	//租约id
	private Long usercentid;
	
	public Long getUsercentid() {
		return usercentid;
	}

	public void setUsercentid(Long usercentid) {
		this.usercentid = usercentid;
	}

	public Date getNeedpaytime() {
		return needpaytime;
	}

	public void setNeedpaytime(Date needpaytime) {
		this.needpaytime = needpaytime;
	}

	public int getNeedoutday() {
		return needoutday;
	}

	public void setNeedoutday(int needoutday) {
		this.needoutday = needoutday;
	}

	public int getFatherid() {
		return fatherid;
	}

	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getFinanceids() {
		return financeids;
	}

	public void setFinanceids(String financeids) {
		this.financeids = financeids;
	}
	


	

}
