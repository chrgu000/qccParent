package cn.com.qcc.pojo;

public class Housetag {
    /** 小类别id(设施表id)*/
    private Long housetagid;

    /** 大的类别*/
    private Integer category;

    /** 大类别的名字*/
    private String category_name;

    /** 小类别名字*/
    private String type;

    /** 设备图片*/
    private String picture;

    public Long getHousetagid() {
        return housetagid;
    }

    public void setHousetagid(Long housetagid) {
        this.housetagid = housetagid;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name == null ? null : category_name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}