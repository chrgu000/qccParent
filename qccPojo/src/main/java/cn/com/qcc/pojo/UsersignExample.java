package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersignExample() {
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

        public Criteria andSignidIsNull() {
            addCriterion("signid is null");
            return (Criteria) this;
        }

        public Criteria andSignidIsNotNull() {
            addCriterion("signid is not null");
            return (Criteria) this;
        }

        public Criteria andSignidEqualTo(Long value) {
            addCriterion("signid =", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotEqualTo(Long value) {
            addCriterion("signid <>", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidGreaterThan(Long value) {
            addCriterion("signid >", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidGreaterThanOrEqualTo(Long value) {
            addCriterion("signid >=", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidLessThan(Long value) {
            addCriterion("signid <", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidLessThanOrEqualTo(Long value) {
            addCriterion("signid <=", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidIn(List<Long> values) {
            addCriterion("signid in", values, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotIn(List<Long> values) {
            addCriterion("signid not in", values, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidBetween(Long value1, Long value2) {
            addCriterion("signid between", value1, value2, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotBetween(Long value1, Long value2) {
            addCriterion("signid not between", value1, value2, "signid");
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

        public Criteria andSingcountIsNull() {
            addCriterion("singcount is null");
            return (Criteria) this;
        }

        public Criteria andSingcountIsNotNull() {
            addCriterion("singcount is not null");
            return (Criteria) this;
        }

        public Criteria andSingcountEqualTo(Integer value) {
            addCriterion("singcount =", value, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountNotEqualTo(Integer value) {
            addCriterion("singcount <>", value, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountGreaterThan(Integer value) {
            addCriterion("singcount >", value, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("singcount >=", value, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountLessThan(Integer value) {
            addCriterion("singcount <", value, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountLessThanOrEqualTo(Integer value) {
            addCriterion("singcount <=", value, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountIn(List<Integer> values) {
            addCriterion("singcount in", values, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountNotIn(List<Integer> values) {
            addCriterion("singcount not in", values, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountBetween(Integer value1, Integer value2) {
            addCriterion("singcount between", value1, value2, "singcount");
            return (Criteria) this;
        }

        public Criteria andSingcountNotBetween(Integer value1, Integer value2) {
            addCriterion("singcount not between", value1, value2, "singcount");
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