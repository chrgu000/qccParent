package cn.com.qcc.pojo;

import java.util.Date;

public class Consume {
    /** 充值或者消费ID*/
    private Long consume_id;

    /** 记录充值时间*/
    private Date create_time;

    /** 记录的用户ID即是VIP的ID */
    private String user_id;

    /** 记录消费*/
    private Date update_time;

    /** 1消费，2 充值 */
    private Integer type;

    /** 充值或者消费金额*/
    private Double monetary;

    /** 描述*/
    private String descname;
    
    private String order;
    

    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Long getConsume_id() {
        return consume_id;
    }

    public void setConsume_id(Long consume_id) {
        this.consume_id = consume_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getMonetary() {
        return monetary;
    }

    public void setMonetary(Double monetary) {
        this.monetary = monetary;
    }

    public String getDescname() {
        return descname;
    }

    public void setDescname(String descname) {
        this.descname = descname == null ? null : descname.trim();
    }
}