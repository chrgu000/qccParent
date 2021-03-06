package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LandlordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LandlordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLanduseridIsNull() {
            addCriterion("landuserid is null");
            return (Criteria) this;
        }

        public Criteria andLanduseridIsNotNull() {
            addCriterion("landuserid is not null");
            return (Criteria) this;
        }

        public Criteria andLanduseridEqualTo(Long value) {
            addCriterion("landuserid =", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridNotEqualTo(Long value) {
            addCriterion("landuserid <>", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridGreaterThan(Long value) {
            addCriterion("landuserid >", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("landuserid >=", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridLessThan(Long value) {
            addCriterion("landuserid <", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridLessThanOrEqualTo(Long value) {
            addCriterion("landuserid <=", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridIn(List<Long> values) {
            addCriterion("landuserid in", values, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridNotIn(List<Long> values) {
            addCriterion("landuserid not in", values, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridBetween(Long value1, Long value2) {
            addCriterion("landuserid between", value1, value2, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridNotBetween(Long value1, Long value2) {
            addCriterion("landuserid not between", value1, value2, "landuserid");
            return (Criteria) this;
        }

        public Criteria andBdidIsNull() {
            addCriterion("bdid is null");
            return (Criteria) this;
        }

        public Criteria andBdidIsNotNull() {
            addCriterion("bdid is not null");
            return (Criteria) this;
        }

        public Criteria andBdidEqualTo(String value) {
            addCriterion("bdid =", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotEqualTo(String value) {
            addCriterion("bdid <>", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidGreaterThan(String value) {
            addCriterion("bdid >", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidGreaterThanOrEqualTo(String value) {
            addCriterion("bdid >=", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidLessThan(String value) {
            addCriterion("bdid <", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidLessThanOrEqualTo(String value) {
            addCriterion("bdid <=", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidLike(String value) {
            addCriterion("bdid like", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotLike(String value) {
            addCriterion("bdid not like", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidIn(List<String> values) {
            addCriterion("bdid in", values, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotIn(List<String> values) {
            addCriterion("bdid not in", values, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidBetween(String value1, String value2) {
            addCriterion("bdid between", value1, value2, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotBetween(String value1, String value2) {
            addCriterion("bdid not between", value1, value2, "bdid");
            return (Criteria) this;
        }

        public Criteria andLandstateIsNull() {
            addCriterion("landstate is null");
            return (Criteria) this;
        }

        public Criteria andLandstateIsNotNull() {
            addCriterion("landstate is not null");
            return (Criteria) this;
        }

        public Criteria andLandstateEqualTo(Integer value) {
            addCriterion("landstate =", value, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateNotEqualTo(Integer value) {
            addCriterion("landstate <>", value, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateGreaterThan(Integer value) {
            addCriterion("landstate >", value, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("landstate >=", value, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateLessThan(Integer value) {
            addCriterion("landstate <", value, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateLessThanOrEqualTo(Integer value) {
            addCriterion("landstate <=", value, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateIn(List<Integer> values) {
            addCriterion("landstate in", values, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateNotIn(List<Integer> values) {
            addCriterion("landstate not in", values, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateBetween(Integer value1, Integer value2) {
            addCriterion("landstate between", value1, value2, "landstate");
            return (Criteria) this;
        }

        public Criteria andLandstateNotBetween(Integer value1, Integer value2) {
            addCriterion("landstate not between", value1, value2, "landstate");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Long value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Long value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Long value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Long value1, Long value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Long value1, Long value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNull() {
            addCriterion("brandname is null");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNotNull() {
            addCriterion("brandname is not null");
            return (Criteria) this;
        }

        public Criteria andBrandnameEqualTo(String value) {
            addCriterion("brandname =", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotEqualTo(String value) {
            addCriterion("brandname <>", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThan(String value) {
            addCriterion("brandname >", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThanOrEqualTo(String value) {
            addCriterion("brandname >=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThan(String value) {
            addCriterion("brandname <", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThanOrEqualTo(String value) {
            addCriterion("brandname <=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLike(String value) {
            addCriterion("brandname like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotLike(String value) {
            addCriterion("brandname not like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameIn(List<String> values) {
            addCriterion("brandname in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotIn(List<String> values) {
            addCriterion("brandname not in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameBetween(String value1, String value2) {
            addCriterion("brandname between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotBetween(String value1, String value2) {
            addCriterion("brandname not between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andCorporateIsNull() {
            addCriterion("corporate is null");
            return (Criteria) this;
        }

        public Criteria andCorporateIsNotNull() {
            addCriterion("corporate is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateEqualTo(String value) {
            addCriterion("corporate =", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotEqualTo(String value) {
            addCriterion("corporate <>", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateGreaterThan(String value) {
            addCriterion("corporate >", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateGreaterThanOrEqualTo(String value) {
            addCriterion("corporate >=", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateLessThan(String value) {
            addCriterion("corporate <", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateLessThanOrEqualTo(String value) {
            addCriterion("corporate <=", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateLike(String value) {
            addCriterion("corporate like", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotLike(String value) {
            addCriterion("corporate not like", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateIn(List<String> values) {
            addCriterion("corporate in", values, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotIn(List<String> values) {
            addCriterion("corporate not in", values, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateBetween(String value1, String value2) {
            addCriterion("corporate between", value1, value2, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotBetween(String value1, String value2) {
            addCriterion("corporate not between", value1, value2, "corporate");
            return (Criteria) this;
        }

        public Criteria andBusinessnumIsNull() {
            addCriterion("businessnum is null");
            return (Criteria) this;
        }

        public Criteria andBusinessnumIsNotNull() {
            addCriterion("businessnum is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessnumEqualTo(String value) {
            addCriterion("businessnum =", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotEqualTo(String value) {
            addCriterion("businessnum <>", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumGreaterThan(String value) {
            addCriterion("businessnum >", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumGreaterThanOrEqualTo(String value) {
            addCriterion("businessnum >=", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumLessThan(String value) {
            addCriterion("businessnum <", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumLessThanOrEqualTo(String value) {
            addCriterion("businessnum <=", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumLike(String value) {
            addCriterion("businessnum like", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotLike(String value) {
            addCriterion("businessnum not like", value, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumIn(List<String> values) {
            addCriterion("businessnum in", values, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotIn(List<String> values) {
            addCriterion("businessnum not in", values, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumBetween(String value1, String value2) {
            addCriterion("businessnum between", value1, value2, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinessnumNotBetween(String value1, String value2) {
            addCriterion("businessnum not between", value1, value2, "businessnum");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureIsNull() {
            addCriterion("businesspicture is null");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureIsNotNull() {
            addCriterion("businesspicture is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureEqualTo(String value) {
            addCriterion("businesspicture =", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureNotEqualTo(String value) {
            addCriterion("businesspicture <>", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureGreaterThan(String value) {
            addCriterion("businesspicture >", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureGreaterThanOrEqualTo(String value) {
            addCriterion("businesspicture >=", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureLessThan(String value) {
            addCriterion("businesspicture <", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureLessThanOrEqualTo(String value) {
            addCriterion("businesspicture <=", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureLike(String value) {
            addCriterion("businesspicture like", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureNotLike(String value) {
            addCriterion("businesspicture not like", value, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureIn(List<String> values) {
            addCriterion("businesspicture in", values, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureNotIn(List<String> values) {
            addCriterion("businesspicture not in", values, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureBetween(String value1, String value2) {
            addCriterion("businesspicture between", value1, value2, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andBusinesspictureNotBetween(String value1, String value2) {
            addCriterion("businesspicture not between", value1, value2, "businesspicture");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIsNull() {
            addCriterion("linkphone is null");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIsNotNull() {
            addCriterion("linkphone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkphoneEqualTo(String value) {
            addCriterion("linkphone =", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotEqualTo(String value) {
            addCriterion("linkphone <>", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneGreaterThan(String value) {
            addCriterion("linkphone >", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneGreaterThanOrEqualTo(String value) {
            addCriterion("linkphone >=", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLessThan(String value) {
            addCriterion("linkphone <", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLessThanOrEqualTo(String value) {
            addCriterion("linkphone <=", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLike(String value) {
            addCriterion("linkphone like", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotLike(String value) {
            addCriterion("linkphone not like", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIn(List<String> values) {
            addCriterion("linkphone in", values, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotIn(List<String> values) {
            addCriterion("linkphone not in", values, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneBetween(String value1, String value2) {
            addCriterion("linkphone between", value1, value2, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotBetween(String value1, String value2) {
            addCriterion("linkphone not between", value1, value2, "linkphone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}