package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryexcleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryexcleExample() {
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

        public Criteria andHistoryexclidIsNull() {
            addCriterion("historyexclid is null");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidIsNotNull() {
            addCriterion("historyexclid is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidEqualTo(Long value) {
            addCriterion("historyexclid =", value, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidNotEqualTo(Long value) {
            addCriterion("historyexclid <>", value, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidGreaterThan(Long value) {
            addCriterion("historyexclid >", value, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidGreaterThanOrEqualTo(Long value) {
            addCriterion("historyexclid >=", value, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidLessThan(Long value) {
            addCriterion("historyexclid <", value, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidLessThanOrEqualTo(Long value) {
            addCriterion("historyexclid <=", value, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidIn(List<Long> values) {
            addCriterion("historyexclid in", values, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidNotIn(List<Long> values) {
            addCriterion("historyexclid not in", values, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidBetween(Long value1, Long value2) {
            addCriterion("historyexclid between", value1, value2, "historyexclid");
            return (Criteria) this;
        }

        public Criteria andHistoryexclidNotBetween(Long value1, Long value2) {
            addCriterion("historyexclid not between", value1, value2, "historyexclid");
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

        public Criteria andHistoryexcleurlIsNull() {
            addCriterion("historyexcleurl is null");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlIsNotNull() {
            addCriterion("historyexcleurl is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlEqualTo(String value) {
            addCriterion("historyexcleurl =", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlNotEqualTo(String value) {
            addCriterion("historyexcleurl <>", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlGreaterThan(String value) {
            addCriterion("historyexcleurl >", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlGreaterThanOrEqualTo(String value) {
            addCriterion("historyexcleurl >=", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlLessThan(String value) {
            addCriterion("historyexcleurl <", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlLessThanOrEqualTo(String value) {
            addCriterion("historyexcleurl <=", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlLike(String value) {
            addCriterion("historyexcleurl like", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlNotLike(String value) {
            addCriterion("historyexcleurl not like", value, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlIn(List<String> values) {
            addCriterion("historyexcleurl in", values, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlNotIn(List<String> values) {
            addCriterion("historyexcleurl not in", values, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlBetween(String value1, String value2) {
            addCriterion("historyexcleurl between", value1, value2, "historyexcleurl");
            return (Criteria) this;
        }

        public Criteria andHistoryexcleurlNotBetween(String value1, String value2) {
            addCriterion("historyexcleurl not between", value1, value2, "historyexcleurl");
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