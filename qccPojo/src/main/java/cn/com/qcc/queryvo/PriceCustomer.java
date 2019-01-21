package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Price;

public class PriceCustomer extends Price {

	private String smallprices;
	private String bigprices;

	public String getSmallprices() {
		if (smallprices == null || smallprices == "") {
			return "1";
		}
		return smallprices;
	}

	public void setSmallprices(String smallprices) {
		if (smallprices == null || smallprices == "") {
			this.smallprices = "1";
		}
		this.smallprices = smallprices;
	}

	public String getBigprices() {
		if (bigprices == null || bigprices == "") {
			return "10000";
		}
		return bigprices;
	}

	public void setBigprices(String bigprices) {
		if (bigprices == null || bigprices == "") {
			this.bigprices = "10000";
		}
		this.bigprices = bigprices;
	}

}
