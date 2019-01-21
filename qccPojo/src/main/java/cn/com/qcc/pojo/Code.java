package cn.com.qcc.pojo;

import java.util.Date;

public class Code {
    /** 验证码id*/
    private Long codeid;

    /** 手机号码*/
    private Long telephone;

    /** 验证码类型 [此字段作废]*/
    private String type;

    /** 验证码 */
    private String code;

    /** 开始时间*/
    private Date create_time;

    /** 结束时间*/
    private Date update_time;

    public Long getCodeid() {
        return codeid;
    }

    public void setCodeid(Long codeid) {
        this.codeid = codeid;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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