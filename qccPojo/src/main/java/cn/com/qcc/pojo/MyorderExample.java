package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyorderExample() {
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

        public Criteria andOrdernumIsNull() {
            addCriterion("ordernum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(Long value) {
            addCriterion("ordernum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(Long value) {
            addCriterion("ordernum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(Long value) {
            addCriterion("ordernum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(Long value) {
            addCriterion("ordernum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(Long value) {
            addCriterion("ordernum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(Long value) {
            addCriterion("ordernum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<Long> values) {
            addCriterion("ordernum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<Long> values) {
            addCriterion("ordernum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(Long value1, Long value2) {
            addCriterion("ordernum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(Long value1, Long value2) {
            addCriterion("ordernum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andConsumeidIsNull() {
            addCriterion("consumeid is null");
            return (Criteria) this;
        }

        public Criteria andConsumeidIsNotNull() {
            addCriterion("consumeid is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeidEqualTo(Long value) {
            addCriterion("consumeid =", value, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidNotEqualTo(Long value) {
            addCriterion("consumeid <>", value, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidGreaterThan(Long value) {
            addCriterion("consumeid >", value, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidGreaterThanOrEqualTo(Long value) {
            addCriterion("consumeid >=", value, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidLessThan(Long value) {
            addCriterion("consumeid <", value, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidLessThanOrEqualTo(Long value) {
            addCriterion("consumeid <=", value, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidIn(List<Long> values) {
            addCriterion("consumeid in", values, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidNotIn(List<Long> values) {
            addCriterion("consumeid not in", values, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidBetween(Long value1, Long value2) {
            addCriterion("consumeid between", value1, value2, "consumeid");
            return (Criteria) this;
        }

        public Criteria andConsumeidNotBetween(Long value1, Long value2) {
            addCriterion("consumeid not between", value1, value2, "consumeid");
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

        public Criteria andReleaseidIsNull() {
            addCriterion("releaseid is null");
            return (Criteria) this;
        }

        public Criteria andReleaseidIsNotNull() {
            addCriterion("releaseid is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseidEqualTo(Long value) {
            addCriterion("releaseid =", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotEqualTo(Long value) {
            addCriterion("releaseid <>", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThan(Long value) {
            addCriterion("releaseid >", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThanOrEqualTo(Long value) {
            addCriterion("releaseid >=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThan(Long value) {
            addCriterion("releaseid <", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThanOrEqualTo(Long value) {
            addCriterion("releaseid <=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidIn(List<Long> values) {
            addCriterion("releaseid in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotIn(List<Long> values) {
            addCriterion("releaseid not in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidBetween(Long value1, Long value2) {
            addCriterion("releaseid between", value1, value2, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotBetween(Long value1, Long value2) {
            addCriterion("releaseid not between", value1, value2, "releaseid");
            return (Criteria) this;
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

        public Criteria andTotalpricesIsNull() {
            addCriterion("totalprices is null");
            return (Criteria) this;
        }

        public Criteria andTotalpricesIsNotNull() {
            addCriterion("totalprices is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpricesEqualTo(Double value) {
            addCriterion("totalprices =", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesNotEqualTo(Double value) {
            addCriterion("totalprices <>", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesGreaterThan(Double value) {
            addCriterion("totalprices >", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesGreaterThanOrEqualTo(Double value) {
            addCriterion("totalprices >=", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesLessThan(Double value) {
            addCriterion("totalprices <", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesLessThanOrEqualTo(Double value) {
            addCriterion("totalprices <=", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesIn(List<Double> values) {
            addCriterion("totalprices in", values, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesNotIn(List<Double> values) {
            addCriterion("totalprices not in", values, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesBetween(Double value1, Double value2) {
            addCriterion("totalprices between", value1, value2, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesNotBetween(Double value1, Double value2) {
            addCriterion("totalprices not between", value1, value2, "totalprices");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
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