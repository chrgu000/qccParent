package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LandloadBrokerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LandloadBrokerExample() {
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

        public Criteria andBrokeruseridIsNull() {
            addCriterion("brokeruserid is null");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridIsNotNull() {
            addCriterion("brokeruserid is not null");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridEqualTo(Long value) {
            addCriterion("brokeruserid =", value, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridNotEqualTo(Long value) {
            addCriterion("brokeruserid <>", value, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridGreaterThan(Long value) {
            addCriterion("brokeruserid >", value, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridGreaterThanOrEqualTo(Long value) {
            addCriterion("brokeruserid >=", value, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridLessThan(Long value) {
            addCriterion("brokeruserid <", value, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridLessThanOrEqualTo(Long value) {
            addCriterion("brokeruserid <=", value, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridIn(List<Long> values) {
            addCriterion("brokeruserid in", values, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridNotIn(List<Long> values) {
            addCriterion("brokeruserid not in", values, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridBetween(Long value1, Long value2) {
            addCriterion("brokeruserid between", value1, value2, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andBrokeruseridNotBetween(Long value1, Long value2) {
            addCriterion("brokeruserid not between", value1, value2, "brokeruserid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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