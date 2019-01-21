package cn.com.qcc.pojo;

import java.util.Date;
import java.util.List;

public class Releasetable {
    /** 规格参数唯一约束*/
    private Long releaseid;

    /** 物品详情ID*/
    private Long articledetailid;

    /** 单价*/
    private Double prices;

    /** 库存*/
    private Integer count;

    /** 规格参数ID*/
    private String codeids;

    /** */
    private Date update_time;
    
    

    public Long getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(Long releaseid) {
        this.releaseid = releaseid;
    }

    public Long getArticledetailid() {
        return articledetailid;
    }

    public void setArticledetailid(Long articledetailid) {
        this.articledetailid = articledetailid;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCodeids() {
        return codeids;
    }

    public void setCodeids(String codeids) {
        this.codeids = codeids == null ? null : codeids.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


    

}