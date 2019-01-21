package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TribenoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TribenoticeExample() {
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

        public Criteria andTribenoticeidIsNull() {
            addCriterion("tribenoticeid is null");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidIsNotNull() {
            addCriterion("tribenoticeid is not null");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidEqualTo(Long value) {
            addCriterion("tribenoticeid =", value, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidNotEqualTo(Long value) {
            addCriterion("tribenoticeid <>", value, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidGreaterThan(Long value) {
            addCriterion("tribenoticeid >", value, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidGreaterThanOrEqualTo(Long value) {
            addCriterion("tribenoticeid >=", value, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidLessThan(Long value) {
            addCriterion("tribenoticeid <", value, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidLessThanOrEqualTo(Long value) {
            addCriterion("tribenoticeid <=", value, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidIn(List<Long> values) {
            addCriterion("tribenoticeid in", values, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidNotIn(List<Long> values) {
            addCriterion("tribenoticeid not in", values, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidBetween(Long value1, Long value2) {
            addCriterion("tribenoticeid between", value1, value2, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeidNotBetween(Long value1, Long value2) {
            addCriterion("tribenoticeid not between", value1, value2, "tribenoticeid");
            return (Criteria) this;
        }

        public Criteria andTribenoticeIsNull() {
            addCriterion("tribenotice is null");
            return (Criteria) this;
        }

        public Criteria andTribenoticeIsNotNull() {
            addCriterion("tribenotice is not null");
            return (Criteria) this;
        }

        public Criteria andTribenoticeEqualTo(String value) {
            addCriterion("tribenotice =", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeNotEqualTo(String value) {
            addCriterion("tribenotice <>", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeGreaterThan(String value) {
            addCriterion("tribenotice >", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeGreaterThanOrEqualTo(String value) {
            addCriterion("tribenotice >=", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeLessThan(String value) {
            addCriterion("tribenotice <", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeLessThanOrEqualTo(String value) {
            addCriterion("tribenotice <=", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeLike(String value) {
            addCriterion("tribenotice like", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeNotLike(String value) {
            addCriterion("tribenotice not like", value, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeIn(List<String> values) {
            addCriterion("tribenotice in", values, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeNotIn(List<String> values) {
            addCriterion("tribenotice not in", values, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeBetween(String value1, String value2) {
            addCriterion("tribenotice between", value1, value2, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribenoticeNotBetween(String value1, String value2) {
            addCriterion("tribenotice not between", value1, value2, "tribenotice");
            return (Criteria) this;
        }

        public Criteria andTribeidIsNull() {
            addCriterion("tribeid is null");
            return (Criteria) this;
        }

        public Criteria andTribeidIsNotNull() {
            addCriterion("tribeid is not null");
            return (Criteria) this;
        }

        public Criteria andTribeidEqualTo(Long value) {
            addCriterion("tribeid =", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidNotEqualTo(Long value) {
            addCriterion("tribeid <>", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidGreaterThan(Long value) {
            addCriterion("tribeid >", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidGreaterThanOrEqualTo(Long value) {
            addCriterion("tribeid >=", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidLessThan(Long value) {
            addCriterion("tribeid <", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidLessThanOrEqualTo(Long value) {
            addCriterion("tribeid <=", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidIn(List<Long> values) {
            addCriterion("tribeid in", values, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidNotIn(List<Long> values) {
            addCriterion("tribeid not in", values, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidBetween(Long value1, Long value2) {
            addCriterion("tribeid between", value1, value2, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidNotBetween(Long value1, Long value2) {
            addCriterion("tribeid not between", value1, value2, "tribeid");
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