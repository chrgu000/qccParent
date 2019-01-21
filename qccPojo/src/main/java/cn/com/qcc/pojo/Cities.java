package cn.com.qcc.pojo;

import java.util.Date;

public class Cities {
	/**  */
	private Long cityid;

	/** 首字母 */
	private String initial;

	/** 城市名 */
	private String cityname;

	/**  */
	private Date create_time;

	/**  */
	private Date update_time;

	public Long getCityid() {
		return cityid;
	}

	public void setCityid(Long cityid) {
		this.cityid = cityid;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial == null ? null : initial.trim();
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname == null ? null : cityname.trim();
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}