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

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdpicturesIsNull() {
            addCriterion("idpictures is null");
            return (Criteria) this;
        }

        public Criteria andIdpicturesIsNotNull() {
            addCriterion("idpictures is not null");
            return (Criteria) this;
        }

        public Criteria andIdpicturesEqualTo(String value) {
            addCriterion("idpictures =", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesNotEqualTo(String value) {
            addCriterion("idpictures <>", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesGreaterThan(String value) {
            addCriterion("idpictures >", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesGreaterThanOrEqualTo(String value) {
            addCriterion("idpictures >=", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesLessThan(String value) {
            addCriterion("idpictures <", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesLessThanOrEqualTo(String value) {
            addCriterion("idpictures <=", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesLike(String value) {
            addCriterion("idpictures like", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesNotLike(String value) {
            addCriterion("idpictures not like", value, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesIn(List<String> values) {
            addCriterion("idpictures in", values, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesNotIn(List<String> values) {
            addCriterion("idpictures not in", values, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesBetween(String value1, String value2) {
            addCriterion("idpictures between", value1, value2, "idpictures");
            return (Criteria) this;
        }

        public Criteria andIdpicturesNotBetween(String value1, String value2) {
            addCriterion("idpictures not between", value1, value2, "idpictures");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
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

        public Criteria andLandaddressIsNull() {
            addCriterion("landaddress is null");
            return (Criteria) this;
        }

        public Criteria andLandaddressIsNotNull() {
            addCriterion("landaddress is not null");
            return (Criteria) this;
        }

        public Criteria andLandaddressEqualTo(String value) {
            addCriterion("landaddress =", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressNotEqualTo(String value) {
            addCriterion("landaddress <>", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressGreaterThan(String value) {
            addCriterion("landaddress >", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressGreaterThanOrEqualTo(String value) {
            addCriterion("landaddress >=", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressLessThan(String value) {
            addCriterion("landaddress <", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressLessThanOrEqualTo(String value) {
            addCriterion("landaddress <=", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressLike(String value) {
            addCriterion("landaddress like", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressNotLike(String value) {
            addCriterion("landaddress not like", value, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressIn(List<String> values) {
            addCriterion("landaddress in", values, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressNotIn(List<String> values) {
            addCriterion("landaddress not in", values, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressBetween(String value1, String value2) {
            addCriterion("landaddress between", value1, value2, "landaddress");
            return (Criteria) this;
        }

        public Criteria andLandaddressNotBetween(String value1, String value2) {
            addCriterion("landaddress not between", value1, value2, "landaddress");
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