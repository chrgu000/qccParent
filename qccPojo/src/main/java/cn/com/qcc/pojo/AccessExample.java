package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessExample() {
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

        public Criteria andAccessidIsNull() {
            addCriterion("accessid is null");
            return (Criteria) this;
        }

        public Criteria andAccessidIsNotNull() {
            addCriterion("accessid is not null");
            return (Criteria) this;
        }

        public Criteria andAccessidEqualTo(Long value) {
            addCriterion("accessid =", value, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidNotEqualTo(Long value) {
            addCriterion("accessid <>", value, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidGreaterThan(Long value) {
            addCriterion("accessid >", value, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidGreaterThanOrEqualTo(Long value) {
            addCriterion("accessid >=", value, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidLessThan(Long value) {
            addCriterion("accessid <", value, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidLessThanOrEqualTo(Long value) {
            addCriterion("accessid <=", value, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidIn(List<Long> values) {
            addCriterion("accessid in", values, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidNotIn(List<Long> values) {
            addCriterion("accessid not in", values, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidBetween(Long value1, Long value2) {
            addCriterion("accessid between", value1, value2, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessidNotBetween(Long value1, Long value2) {
            addCriterion("accessid not between", value1, value2, "accessid");
            return (Criteria) this;
        }

        public Criteria andAccessnameIsNull() {
            addCriterion("accessname is null");
            return (Criteria) this;
        }

        public Criteria andAccessnameIsNotNull() {
            addCriterion("accessname is not null");
            return (Criteria) this;
        }

        public Criteria andAccessnameEqualTo(String value) {
            addCriterion("accessname =", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameNotEqualTo(String value) {
            addCriterion("accessname <>", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameGreaterThan(String value) {
            addCriterion("accessname >", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameGreaterThanOrEqualTo(String value) {
            addCriterion("accessname >=", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameLessThan(String value) {
            addCriterion("accessname <", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameLessThanOrEqualTo(String value) {
            addCriterion("accessname <=", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameLike(String value) {
            addCriterion("accessname like", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameNotLike(String value) {
            addCriterion("accessname not like", value, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameIn(List<String> values) {
            addCriterion("accessname in", values, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameNotIn(List<String> values) {
            addCriterion("accessname not in", values, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameBetween(String value1, String value2) {
            addCriterion("accessname between", value1, value2, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessnameNotBetween(String value1, String value2) {
            addCriterion("accessname not between", value1, value2, "accessname");
            return (Criteria) this;
        }

        public Criteria andAccessurlIsNull() {
            addCriterion("accessurl is null");
            return (Criteria) this;
        }

        public Criteria andAccessurlIsNotNull() {
            addCriterion("accessurl is not null");
            return (Criteria) this;
        }

        public Criteria andAccessurlEqualTo(String value) {
            addCriterion("accessurl =", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlNotEqualTo(String value) {
            addCriterion("accessurl <>", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlGreaterThan(String value) {
            addCriterion("accessurl >", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlGreaterThanOrEqualTo(String value) {
            addCriterion("accessurl >=", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlLessThan(String value) {
            addCriterion("accessurl <", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlLessThanOrEqualTo(String value) {
            addCriterion("accessurl <=", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlLike(String value) {
            addCriterion("accessurl like", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlNotLike(String value) {
            addCriterion("accessurl not like", value, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlIn(List<String> values) {
            addCriterion("accessurl in", values, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlNotIn(List<String> values) {
            addCriterion("accessurl not in", values, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlBetween(String value1, String value2) {
            addCriterion("accessurl between", value1, value2, "accessurl");
            return (Criteria) this;
        }

        public Criteria andAccessurlNotBetween(String value1, String value2) {
            addCriterion("accessurl not between", value1, value2, "accessurl");
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