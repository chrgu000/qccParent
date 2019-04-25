package weixin.util;

public class TemplateData {

	// keyword1：订单类型，keyword2：下单金额，keyword3：配送地址，keyword4：取件地址，keyword5备注
	private String value;// ,,依次排下去
	private String color;// 字段颜色（微信官方已废弃，设置没有效果）

	public TemplateData() {
		super();
	}

	public TemplateData(String value) {
		super();
		this.value = value;
	}

	public TemplateData( String value, String color) {
		super();
		
		this.value = value;
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
