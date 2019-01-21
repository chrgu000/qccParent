package cn.com.qcc.pojo;

public class Rental {
    /** 城市code*/
    private Long code;

    /** 公租房申请条件*/
    private String rentcontent;

    /** 图片申请流程*/
    private String rentpicture;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getRentcontent() {
        return rentcontent;
    }

    public void setRentcontent(String rentcontent) {
        this.rentcontent = rentcontent == null ? null : rentcontent.trim();
    }

    public String getRentpicture() {
        return rentpicture;
    }

    public void setRentpicture(String rentpicture) {
        this.rentpicture = rentpicture == null ? null : rentpicture.trim();
    }
}