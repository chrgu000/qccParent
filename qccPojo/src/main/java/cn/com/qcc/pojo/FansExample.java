package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FansExample() {
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

        public Criteria andFansIdIsNull() {
            addCriterion("fansId is null");
            return (Criteria) this;
        }

        public Criteria andFansIdIsNotNull() {
            addCriterion("fansId is not null");
            return (Criteria) this;
        }

        public Criteria andFansIdEqualTo(Long value) {
            addCriterion("fansId =", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotEqualTo(Long value) {
            addCriterion("fansId <>", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdGreaterThan(Long value) {
            addCriterion("fansId >", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fansId >=", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLessThan(Long value) {
            addCriterion("fansId <", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLessThanOrEqualTo(Long value) {
            addCriterion("fansId <=", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdIn(List<Long> values) {
            addCriterion("fansId in", values, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotIn(List<Long> values) {
            addCriterion("fansId not in", values, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdBetween(Long value1, Long value2) {
            addCriterion("fansId between", value1, value2, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotBetween(Long value1, Long value2) {
            addCriterion("fansId not between", value1, value2, "fansId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIsNull() {
            addCriterion("followUserId is null");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIsNotNull() {
            addCriterion("followUserId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdEqualTo(Long value) {
            addCriterion("followUserId =", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotEqualTo(Long value) {
            addCriterion("followUserId <>", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdGreaterThan(Long value) {
            addCriterion("followUserId >", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("followUserId >=", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLessThan(Long value) {
            addCriterion("followUserId <", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLessThanOrEqualTo(Long value) {
            addCriterion("followUserId <=", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIn(List<Long> values) {
            addCriterion("followUserId in", values, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotIn(List<Long> values) {
            addCriterion("followUserId not in", values, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdBetween(Long value1, Long value2) {
            addCriterion("followUserId between", value1, value2, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotBetween(Long value1, Long value2) {
            addCriterion("followUserId not between", value1, value2, "followUserId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFanStatusIsNull() {
            addCriterion("fanStatus is null");
            return (Criteria) this;
        }

        public Criteria andFanStatusIsNotNull() {
            addCriterion("fanStatus is not null");
            return (Criteria) this;
        }

        public Criteria andFanStatusEqualTo(String value) {
            addCriterion("fanStatus =", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusNotEqualTo(String value) {
            addCriterion("fanStatus <>", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusGreaterThan(String value) {
            addCriterion("fanStatus >", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusGreaterThanOrEqualTo(String value) {
            addCriterion("fanStatus >=", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusLessThan(String value) {
            addCriterion("fanStatus <", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusLessThanOrEqualTo(String value) {
            addCriterion("fanStatus <=", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusLike(String value) {
            addCriterion("fanStatus like", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusNotLike(String value) {
            addCriterion("fanStatus not like", value, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusIn(List<String> values) {
            addCriterion("fanStatus in", values, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusNotIn(List<String> values) {
            addCriterion("fanStatus not in", values, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusBetween(String value1, String value2) {
            addCriterion("fanStatus between", value1, value2, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andFanStatusNotBetween(String value1, String value2) {
            addCriterion("fanStatus not between", value1, value2, "fanStatus");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
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