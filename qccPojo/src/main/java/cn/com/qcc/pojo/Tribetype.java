package cn.com.qcc.pojo;

import java.util.Date;

public class Tribetype {
    /** */
    private Long tribetypeid;

    /** 1-城市，2表示部落*/
    private Integer typecode;

    /** 首字母*/
    private String initial;

    /** 城市名*/
    private String typename;

    /** */
    private Date create_time;

    /** */
    private Date update_time;
    
    private String cityname;
    
    public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Long getTribetypeid() {
        return tribetypeid;
    }

    public void setTribetypeid(Long tribetypeid) {
        this.tribetypeid = tribetypeid;
    }

    public Integer getTypecode() {
        return typecode;
    }

    public void setTypecode(Integer typecode) {
        this.typecode = typecode;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
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