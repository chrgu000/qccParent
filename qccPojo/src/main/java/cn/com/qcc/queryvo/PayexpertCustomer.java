package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.pojo.Payexpert;

public class PayexpertCustomer extends Payexpert{
	
	/**当期没有交费的金额**/
	private double centprices;
	
	//签约次数
	private int centtimes;
	
	private List<HousepayCustomer> payList;
	

	public int getCenttimes() {
		return centtimes;
	}

	public void setCenttimes(int centtimes) {
		this.centtimes = centtimes;
	}

	public double getCentprices() {
		return centprices;
	}

	public void setCentprices(double centprices) {
		this.centprices = centprices;
	}

	public List<HousepayCustomer> getPayList() {
		return payList;
	}

	public void setPayList(List<HousepayCustomer> payList) {
		this.payList = payList;
	}
	
	

}
