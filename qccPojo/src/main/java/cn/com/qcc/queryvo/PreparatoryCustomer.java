package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Preparatory;

public class PreparatoryCustomer extends Preparatory{
	
	private String type;
	
	/**预定金**/
	private double orderPirce ;
	/**租客付佣金**/
	private double centPrice;
	/**房东付佣金**/
	private double landPrice;
	/**押金**/
	private double yanPrice ;
	/**首次租金**/
	private double firstCentPrice;
	
	public double getFirstCentPrice() {
		return firstCentPrice;
	}

	public void setFirstCentPrice(double firstCentPrice) {
		this.firstCentPrice = firstCentPrice;
	}

	public double getOrderPirce() {
		return orderPirce;
	}

	public void setOrderPirce(double orderPirce) {
		this.orderPirce = orderPirce;
	}

	public double getCentPrice() {
		return centPrice;
	}

	public void setCentPrice(double centPrice) {
		this.centPrice = centPrice;
	}

	public double getLandPrice() {
		return landPrice;
	}

	public void setLandPrice(double landPrice) {
		this.landPrice = landPrice;
	}

	public double getYanPrice() {
		return yanPrice;
	}

	public void setYanPrice(double yanPrice) {
		this.yanPrice = yanPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
