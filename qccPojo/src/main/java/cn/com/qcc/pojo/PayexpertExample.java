package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayexpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayexpertExample() {
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

        public Criteria andPayexpertidIsNull() {
            addCriterion("payexpertid is null");
            return (Criteria) this;
        }

        public Criteria andPayexpertidIsNotNull() {
            addCriterion("payexpertid is not null");
            return (Criteria) this;
        }

        public Criteria andPayexpertidEqualTo(Long value) {
            addCriterion("payexpertid =", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotEqualTo(Long value) {
            addCriterion("payexpertid <>", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidGreaterThan(Long value) {
            addCriterion("payexpertid >", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidGreaterThanOrEqualTo(Long value) {
            addCriterion("payexpertid >=", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidLessThan(Long value) {
            addCriterion("payexpertid <", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidLessThanOrEqualTo(Long value) {
            addCriterion("payexpertid <=", value, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidIn(List<Long> values) {
            addCriterion("payexpertid in", values, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotIn(List<Long> values) {
            addCriterion("payexpertid not in", values, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidBetween(Long value1, Long value2) {
            addCriterion("payexpertid between", value1, value2, "payexpertid");
            return (Criteria) this;
        }

        public Criteria andPayexpertidNotBetween(Long value1, Long value2) {
            addCriterion("payexpertid not between", value1, value2, "payexpertid");
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

        public Criteria andPayexpertnameIsNull() {
            addCriterion("payexpertname is null");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameIsNotNull() {
            addCriterion("payexpertname is not null");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameEqualTo(String value) {
            addCriterion("payexpertname =", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotEqualTo(String value) {
            addCriterion("payexpertname <>", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameGreaterThan(String value) {
            addCriterion("payexpertname >", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameGreaterThanOrEqualTo(String value) {
            addCriterion("payexpertname >=", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameLessThan(String value) {
            addCriterion("payexpertname <", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameLessThanOrEqualTo(String value) {
            addCriterion("payexpertname <=", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameLike(String value) {
            addCriterion("payexpertname like", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotLike(String value) {
            addCriterion("payexpertname not like", value, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameIn(List<String> values) {
            addCriterion("payexpertname in", values, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotIn(List<String> values) {
            addCriterion("payexpertname not in", values, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameBetween(String value1, String value2) {
            addCriterion("payexpertname between", value1, value2, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andPayexpertnameNotBetween(String value1, String value2) {
            addCriterion("payexpertname not between", value1, value2, "payexpertname");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_timeEqualTo(Date value) {
            addCriterion("start_time =", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThan(Date value) {
            addCriterion("start_time >", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThan(Date value) {
            addCriterion("start_time <", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIn(List<Date> values) {
            addCriterion("start_time in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
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