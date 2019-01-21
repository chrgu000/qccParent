package cn.com.qcc.pojo;

public class Furniture {
    /** */
    private Long furnitureid;

    /** */
    private Long fatherid;

    /** */
    private String categoryname;

    public Long getFurnitureid() {
        return furnitureid;
    }

    public void setFurnitureid(Long furnitureid) {
        this.furnitureid = furnitureid;
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }
}