package cn.com.qcc.pojo;

import java.math.BigDecimal;

public class Groupaddress {
    /** */
    private Long detailid;

    /** */
    private BigDecimal latitude;

    /** */
    private BigDecimal longitude;

    /** utf8*/
    private String detailes;

    public Long getDetailid() {
        return detailid;
    }

    public void setDetailid(Long detailid) {
        this.detailid = detailid;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getDetailes() {
        return detailes;
    }

    public void setDetailes(String detailes) {
        this.detailes = detailes == null ? null : detailes.trim();
    }
}