package cn.com.qcc.pojo;

public class Storeconn {
    /** 控制主键*/
    private Long storeconnid;

    /** 店铺ID*/
    private Long storeid;

    /** 物品详情ID*/
    private Long articledetailid;

    /** 1---正常上架，2---下架*/
    private Integer state;

    public Long getStoreconnid() {
        return storeconnid;
    }

    public void setStoreconnid(Long storeconnid) {
        this.storeconnid = storeconnid;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public Long getArticledetailid() {
        return articledetailid;
    }

    public void setArticledetailid(Long articledetailid) {
        this.articledetailid = articledetailid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}