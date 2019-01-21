package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryExample() {
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

        public Criteria andDeliveryidIsNull() {
            addCriterion("deliveryid is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIsNotNull() {
            addCriterion("deliveryid is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryidEqualTo(Long value) {
            addCriterion("deliveryid =", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotEqualTo(Long value) {
            addCriterion("deliveryid <>", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidGreaterThan(Long value) {
            addCriterion("deliveryid >", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidGreaterThanOrEqualTo(Long value) {
            addCriterion("deliveryid >=", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLessThan(Long value) {
            addCriterion("deliveryid <", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLessThanOrEqualTo(Long value) {
            addCriterion("deliveryid <=", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIn(List<Long> values) {
            addCriterion("deliveryid in", values, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotIn(List<Long> values) {
            addCriterion("deliveryid not in", values, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidBetween(Long value1, Long value2) {
            addCriterion("deliveryid between", value1, value2, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotBetween(Long value1, Long value2) {
            addCriterion("deliveryid not between", value1, value2, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneIsNull() {
            addCriterion("deliveryphone is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneIsNotNull() {
            addCriterion("deliveryphone is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneEqualTo(String value) {
            addCriterion("deliveryphone =", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneNotEqualTo(String value) {
            addCriterion("deliveryphone <>", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneGreaterThan(String value) {
            addCriterion("deliveryphone >", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryphone >=", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneLessThan(String value) {
            addCriterion("deliveryphone <", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneLessThanOrEqualTo(String value) {
            addCriterion("deliveryphone <=", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneLike(String value) {
            addCriterion("deliveryphone like", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneNotLike(String value) {
            addCriterion("deliveryphone not like", value, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneIn(List<String> values) {
            addCriterion("deliveryphone in", values, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneNotIn(List<String> values) {
            addCriterion("deliveryphone not in", values, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneBetween(String value1, String value2) {
            addCriterion("deliveryphone between", value1, value2, "deliveryphone");
            return (Criteria) this;
        }

        public Criteria andDeliveryphoneNotBetween(String value1, String value2) {
            addCriterion("deliveryphone not between", value1, value2, "deliveryphone");
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

        public Criteria andDeliverynameIsNull() {
            addCriterion("deliveryname is null");
            return (Criteria) this;
        }

        public Criteria andDeliverynameIsNotNull() {
            addCriterion("deliveryname is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverynameEqualTo(String value) {
            addCriterion("deliveryname =", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameNotEqualTo(String value) {
            addCriterion("deliveryname <>", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameGreaterThan(String value) {
            addCriterion("deliveryname >", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryname >=", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameLessThan(String value) {
            addCriterion("deliveryname <", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameLessThanOrEqualTo(String value) {
            addCriterion("deliveryname <=", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameLike(String value) {
            addCriterion("deliveryname like", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameNotLike(String value) {
            addCriterion("deliveryname not like", value, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameIn(List<String> values) {
            addCriterion("deliveryname in", values, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameNotIn(List<String> values) {
            addCriterion("deliveryname not in", values, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameBetween(String value1, String value2) {
            addCriterion("deliveryname between", value1, value2, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliverynameNotBetween(String value1, String value2) {
            addCriterion("deliveryname not between", value1, value2, "deliveryname");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressIsNull() {
            addCriterion("deliveryaddress is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressIsNotNull() {
            addCriterion("deliveryaddress is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressEqualTo(String value) {
            addCriterion("deliveryaddress =", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressNotEqualTo(String value) {
            addCriterion("deliveryaddress <>", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressGreaterThan(String value) {
            addCriterion("deliveryaddress >", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryaddress >=", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressLessThan(String value) {
            addCriterion("deliveryaddress <", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressLessThanOrEqualTo(String value) {
            addCriterion("deliveryaddress <=", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressLike(String value) {
            addCriterion("deliveryaddress like", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressNotLike(String value) {
            addCriterion("deliveryaddress not like", value, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressIn(List<String> values) {
            addCriterion("deliveryaddress in", values, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressNotIn(List<String> values) {
            addCriterion("deliveryaddress not in", values, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressBetween(String value1, String value2) {
            addCriterion("deliveryaddress between", value1, value2, "deliveryaddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddressNotBetween(String value1, String value2) {
            addCriterion("deliveryaddress not between", value1, value2, "deliveryaddress");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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