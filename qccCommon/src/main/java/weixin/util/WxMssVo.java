package weixin.util;

import java.util.Map;

public class WxMssVo {

	private String touser;// 用户openid
	private String template_id;// 模版id
	private String page = "pages/IssuedBan/IssuedBan";// 默认跳到小程序首页
	private String form_id;// 收集到的用户formid
	//private String emphasis_keyword = "keyword0.DATA";// 放大那个推送字段
	private Map<String, TemplateData> data;// 推送文字
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public Map<String, TemplateData> getData() {
		return data;
	}
	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}
	
	

}
