package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorycentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistorycentExample() {
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

        public Criteria andHistorycentidIsNull() {
            addCriterion("historycentid is null");
            return (Criteria) this;
        }

        public Criteria andHistorycentidIsNotNull() {
            addCriterion("historycentid is not null");
            return (Criteria) this;
        }

        public Criteria andHistorycentidEqualTo(Long value) {
            addCriterion("historycentid =", value, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidNotEqualTo(Long value) {
            addCriterion("historycentid <>", value, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidGreaterThan(Long value) {
            addCriterion("historycentid >", value, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidGreaterThanOrEqualTo(Long value) {
            addCriterion("historycentid >=", value, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidLessThan(Long value) {
            addCriterion("historycentid <", value, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidLessThanOrEqualTo(Long value) {
            addCriterion("historycentid <=", value, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidIn(List<Long> values) {
            addCriterion("historycentid in", values, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidNotIn(List<Long> values) {
            addCriterion("historycentid not in", values, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidBetween(Long value1, Long value2) {
            addCriterion("historycentid between", value1, value2, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycentidNotBetween(Long value1, Long value2) {
            addCriterion("historycentid not between", value1, value2, "historycentid");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlIsNull() {
            addCriterion("historycenturl is null");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlIsNotNull() {
            addCriterion("historycenturl is not null");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlEqualTo(String value) {
            addCriterion("historycenturl =", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlNotEqualTo(String value) {
            addCriterion("historycenturl <>", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlGreaterThan(String value) {
            addCriterion("historycenturl >", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlGreaterThanOrEqualTo(String value) {
            addCriterion("historycenturl >=", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlLessThan(String value) {
            addCriterion("historycenturl <", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlLessThanOrEqualTo(String value) {
            addCriterion("historycenturl <=", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlLike(String value) {
            addCriterion("historycenturl like", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlNotLike(String value) {
            addCriterion("historycenturl not like", value, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlIn(List<String> values) {
            addCriterion("historycenturl in", values, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlNotIn(List<String> values) {
            addCriterion("historycenturl not in", values, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlBetween(String value1, String value2) {
            addCriterion("historycenturl between", value1, value2, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andHistorycenturlNotBetween(String value1, String value2) {
            addCriterion("historycenturl not between", value1, value2, "historycenturl");
            return (Criteria) this;
        }

        public Criteria andUsercentidIsNull() {
            addCriterion("usercentid is null");
            return (Criteria) this;
        }

        public Criteria andUsercentidIsNotNull() {
            addCriterion("usercentid is not null");
            return (Criteria) this;
        }

        public Criteria andUsercentidEqualTo(Long value) {
            addCriterion("usercentid =", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidNotEqualTo(Long value) {
            addCriterion("usercentid <>", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidGreaterThan(Long value) {
            addCriterion("usercentid >", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidGreaterThanOrEqualTo(Long value) {
            addCriterion("usercentid >=", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidLessThan(Long value) {
            addCriterion("usercentid <", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidLessThanOrEqualTo(Long value) {
            addCriterion("usercentid <=", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidIn(List<Long> values) {
            addCriterion("usercentid in", values, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidNotIn(List<Long> values) {
            addCriterion("usercentid not in", values, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidBetween(Long value1, Long value2) {
            addCriterion("usercentid between", value1, value2, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidNotBetween(Long value1, Long value2) {
            addCriterion("usercentid not between", value1, value2, "usercentid");
            return (Criteria) this;
        }

        public Criteria andDescnameIsNull() {
            addCriterion("descname is null");
            return (Criteria) this;
        }

        public Criteria andDescnameIsNotNull() {
            addCriterion("descname is not null");
            return (Criteria) this;
        }

        public Criteria andDescnameEqualTo(String value) {
            addCriterion("descname =", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotEqualTo(String value) {
            addCriterion("descname <>", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameGreaterThan(String value) {
            addCriterion("descname >", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameGreaterThanOrEqualTo(String value) {
            addCriterion("descname >=", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLessThan(String value) {
            addCriterion("descname <", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLessThanOrEqualTo(String value) {
            addCriterion("descname <=", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLike(String value) {
            addCriterion("descname like", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotLike(String value) {
            addCriterion("descname not like", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameIn(List<String> values) {
            addCriterion("descname in", values, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotIn(List<String> values) {
            addCriterion("descname not in", values, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameBetween(String value1, String value2) {
            addCriterion("descname between", value1, value2, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotBetween(String value1, String value2) {
            addCriterion("descname not between", value1, value2, "descname");
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