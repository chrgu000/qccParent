package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorymeterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistorymeterExample() {
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

        public Criteria andHistorymeteridIsNull() {
            addCriterion("historymeterid is null");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridIsNotNull() {
            addCriterion("historymeterid is not null");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridEqualTo(Long value) {
            addCriterion("historymeterid =", value, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridNotEqualTo(Long value) {
            addCriterion("historymeterid <>", value, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridGreaterThan(Long value) {
            addCriterion("historymeterid >", value, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridGreaterThanOrEqualTo(Long value) {
            addCriterion("historymeterid >=", value, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridLessThan(Long value) {
            addCriterion("historymeterid <", value, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridLessThanOrEqualTo(Long value) {
            addCriterion("historymeterid <=", value, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridIn(List<Long> values) {
            addCriterion("historymeterid in", values, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridNotIn(List<Long> values) {
            addCriterion("historymeterid not in", values, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridBetween(Long value1, Long value2) {
            addCriterion("historymeterid between", value1, value2, "historymeterid");
            return (Criteria) this;
        }

        public Criteria andHistorymeteridNotBetween(Long value1, Long value2) {
            addCriterion("historymeterid not between", value1, value2, "historymeterid");
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

        public Criteria andHouseidIsNull() {
            addCriterion("houseid is null");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNotNull() {
            addCriterion("houseid is not null");
            return (Criteria) this;
        }

        public Criteria andHouseidEqualTo(Long value) {
            addCriterion("houseid =", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotEqualTo(Long value) {
            addCriterion("houseid <>", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThan(Long value) {
            addCriterion("houseid >", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThanOrEqualTo(Long value) {
            addCriterion("houseid >=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThan(Long value) {
            addCriterion("houseid <", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThanOrEqualTo(Long value) {
            addCriterion("houseid <=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidIn(List<Long> values) {
            addCriterion("houseid in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotIn(List<Long> values) {
            addCriterion("houseid not in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidBetween(Long value1, Long value2) {
            addCriterion("houseid between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotBetween(Long value1, Long value2) {
            addCriterion("houseid not between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andFinanceidIsNull() {
            addCriterion("financeid is null");
            return (Criteria) this;
        }

        public Criteria andFinanceidIsNotNull() {
            addCriterion("financeid is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceidEqualTo(Integer value) {
            addCriterion("financeid =", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidNotEqualTo(Integer value) {
            addCriterion("financeid <>", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidGreaterThan(Integer value) {
            addCriterion("financeid >", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("financeid >=", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidLessThan(Integer value) {
            addCriterion("financeid <", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidLessThanOrEqualTo(Integer value) {
            addCriterion("financeid <=", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidIn(List<Integer> values) {
            addCriterion("financeid in", values, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidNotIn(List<Integer> values) {
            addCriterion("financeid not in", values, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidBetween(Integer value1, Integer value2) {
            addCriterion("financeid between", value1, value2, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidNotBetween(Integer value1, Integer value2) {
            addCriterion("financeid not between", value1, value2, "financeid");
            return (Criteria) this;
        }

        public Criteria andBeforecountIsNull() {
            addCriterion("beforecount is null");
            return (Criteria) this;
        }

        public Criteria andBeforecountIsNotNull() {
            addCriterion("beforecount is not null");
            return (Criteria) this;
        }

        public Criteria andBeforecountEqualTo(Double value) {
            addCriterion("beforecount =", value, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountNotEqualTo(Double value) {
            addCriterion("beforecount <>", value, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountGreaterThan(Double value) {
            addCriterion("beforecount >", value, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountGreaterThanOrEqualTo(Double value) {
            addCriterion("beforecount >=", value, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountLessThan(Double value) {
            addCriterion("beforecount <", value, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountLessThanOrEqualTo(Double value) {
            addCriterion("beforecount <=", value, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountIn(List<Double> values) {
            addCriterion("beforecount in", values, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountNotIn(List<Double> values) {
            addCriterion("beforecount not in", values, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountBetween(Double value1, Double value2) {
            addCriterion("beforecount between", value1, value2, "beforecount");
            return (Criteria) this;
        }

        public Criteria andBeforecountNotBetween(Double value1, Double value2) {
            addCriterion("beforecount not between", value1, value2, "beforecount");
            return (Criteria) this;
        }

        public Criteria andAftercountIsNull() {
            addCriterion("aftercount is null");
            return (Criteria) this;
        }

        public Criteria andAftercountIsNotNull() {
            addCriterion("aftercount is not null");
            return (Criteria) this;
        }

        public Criteria andAftercountEqualTo(Double value) {
            addCriterion("aftercount =", value, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountNotEqualTo(Double value) {
            addCriterion("aftercount <>", value, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountGreaterThan(Double value) {
            addCriterion("aftercount >", value, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountGreaterThanOrEqualTo(Double value) {
            addCriterion("aftercount >=", value, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountLessThan(Double value) {
            addCriterion("aftercount <", value, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountLessThanOrEqualTo(Double value) {
            addCriterion("aftercount <=", value, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountIn(List<Double> values) {
            addCriterion("aftercount in", values, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountNotIn(List<Double> values) {
            addCriterion("aftercount not in", values, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountBetween(Double value1, Double value2) {
            addCriterion("aftercount between", value1, value2, "aftercount");
            return (Criteria) this;
        }

        public Criteria andAftercountNotBetween(Double value1, Double value2) {
            addCriterion("aftercount not between", value1, value2, "aftercount");
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