package cn.com.qcc.pojo;

public class Typedetail {
    /** */
    private Long typedetailid;

    /** 一级分类名称*/
    private Integer articletypeid;

    /** 二级分类的详情名称*/
    private String detailname;

    /** utf8*/
    private String typeid;
    
    private String typenames;
    

    public String getTypenames() {
		return typenames;
	}

	public void setTypenames(String typenames) {
		this.typenames = typenames;
	}

	public Long getTypedetailid() {
        return typedetailid;
    }

    public void setTypedetailid(Long typedetailid) {
        this.typedetailid = typedetailid;
    }

    public Integer getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(Integer articletypeid) {
        this.articletypeid = articletypeid;
    }

    public String getDetailname() {
        return detailname;
    }

    public void setDetailname(String detailname) {
        this.detailname = detailname == null ? null : detailname.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }
}