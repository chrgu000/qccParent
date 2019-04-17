package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BargainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BargainExample() {
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

        public Criteria andBarginidIsNull() {
            addCriterion("barginid is null");
            return (Criteria) this;
        }

        public Criteria andBarginidIsNotNull() {
            addCriterion("barginid is not null");
            return (Criteria) this;
        }

        public Criteria andBarginidEqualTo(Long value) {
            addCriterion("barginid =", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidNotEqualTo(Long value) {
            addCriterion("barginid <>", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidGreaterThan(Long value) {
            addCriterion("barginid >", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidGreaterThanOrEqualTo(Long value) {
            addCriterion("barginid >=", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidLessThan(Long value) {
            addCriterion("barginid <", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidLessThanOrEqualTo(Long value) {
            addCriterion("barginid <=", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidIn(List<Long> values) {
            addCriterion("barginid in", values, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidNotIn(List<Long> values) {
            addCriterion("barginid not in", values, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidBetween(Long value1, Long value2) {
            addCriterion("barginid between", value1, value2, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidNotBetween(Long value1, Long value2) {
            addCriterion("barginid not between", value1, value2, "barginid");
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

        public Criteria andOtheridIsNull() {
            addCriterion("otherid is null");
            return (Criteria) this;
        }

        public Criteria andOtheridIsNotNull() {
            addCriterion("otherid is not null");
            return (Criteria) this;
        }

        public Criteria andOtheridEqualTo(Long value) {
            addCriterion("otherid =", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotEqualTo(Long value) {
            addCriterion("otherid <>", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThan(Long value) {
            addCriterion("otherid >", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThanOrEqualTo(Long value) {
            addCriterion("otherid >=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThan(Long value) {
            addCriterion("otherid <", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThanOrEqualTo(Long value) {
            addCriterion("otherid <=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridIn(List<Long> values) {
            addCriterion("otherid in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotIn(List<Long> values) {
            addCriterion("otherid not in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridBetween(Long value1, Long value2) {
            addCriterion("otherid between", value1, value2, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotBetween(Long value1, Long value2) {
            addCriterion("otherid not between", value1, value2, "otherid");
            return (Criteria) this;
        }

        public Criteria andLessbalanceIsNull() {
            addCriterion("lessbalance is null");
            return (Criteria) this;
        }

        public Criteria andLessbalanceIsNotNull() {
            addCriterion("lessbalance is not null");
            return (Criteria) this;
        }

        public Criteria andLessbalanceEqualTo(Double value) {
            addCriterion("lessbalance =", value, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceNotEqualTo(Double value) {
            addCriterion("lessbalance <>", value, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceGreaterThan(Double value) {
            addCriterion("lessbalance >", value, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("lessbalance >=", value, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceLessThan(Double value) {
            addCriterion("lessbalance <", value, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceLessThanOrEqualTo(Double value) {
            addCriterion("lessbalance <=", value, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceIn(List<Double> values) {
            addCriterion("lessbalance in", values, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceNotIn(List<Double> values) {
            addCriterion("lessbalance not in", values, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceBetween(Double value1, Double value2) {
            addCriterion("lessbalance between", value1, value2, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andLessbalanceNotBetween(Double value1, Double value2) {
            addCriterion("lessbalance not between", value1, value2, "lessbalance");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidIsNull() {
            addCriterion("preparatoryid is null");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidIsNotNull() {
            addCriterion("preparatoryid is not null");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidEqualTo(Long value) {
            addCriterion("preparatoryid =", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidNotEqualTo(Long value) {
            addCriterion("preparatoryid <>", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidGreaterThan(Long value) {
            addCriterion("preparatoryid >", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidGreaterThanOrEqualTo(Long value) {
            addCriterion("preparatoryid >=", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidLessThan(Long value) {
            addCriterion("preparatoryid <", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidLessThanOrEqualTo(Long value) {
            addCriterion("preparatoryid <=", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidIn(List<Long> values) {
            addCriterion("preparatoryid in", values, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidNotIn(List<Long> values) {
            addCriterion("preparatoryid not in", values, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidBetween(Long value1, Long value2) {
            addCriterion("preparatoryid between", value1, value2, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidNotBetween(Long value1, Long value2) {
            addCriterion("preparatoryid not between", value1, value2, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceIsNull() {
            addCriterion("totalbanalce is null");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceIsNotNull() {
            addCriterion("totalbanalce is not null");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceEqualTo(Double value) {
            addCriterion("totalbanalce =", value, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceNotEqualTo(Double value) {
            addCriterion("totalbanalce <>", value, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceGreaterThan(Double value) {
            addCriterion("totalbanalce >", value, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceGreaterThanOrEqualTo(Double value) {
            addCriterion("totalbanalce >=", value, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceLessThan(Double value) {
            addCriterion("totalbanalce <", value, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceLessThanOrEqualTo(Double value) {
            addCriterion("totalbanalce <=", value, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceIn(List<Double> values) {
            addCriterion("totalbanalce in", values, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceNotIn(List<Double> values) {
            addCriterion("totalbanalce not in", values, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceBetween(Double value1, Double value2) {
            addCriterion("totalbanalce between", value1, value2, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTotalbanalceNotBetween(Double value1, Double value2) {
            addCriterion("totalbanalce not between", value1, value2, "totalbanalce");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andDaycountIsNull() {
            addCriterion("daycount is null");
            return (Criteria) this;
        }

        public Criteria andDaycountIsNotNull() {
            addCriterion("daycount is not null");
            return (Criteria) this;
        }

        public Criteria andDaycountEqualTo(Integer value) {
            addCriterion("daycount =", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountNotEqualTo(Integer value) {
            addCriterion("daycount <>", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountGreaterThan(Integer value) {
            addCriterion("daycount >", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("daycount >=", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountLessThan(Integer value) {
            addCriterion("daycount <", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountLessThanOrEqualTo(Integer value) {
            addCriterion("daycount <=", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountIn(List<Integer> values) {
            addCriterion("daycount in", values, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountNotIn(List<Integer> values) {
            addCriterion("daycount not in", values, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountBetween(Integer value1, Integer value2) {
            addCriterion("daycount between", value1, value2, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountNotBetween(Integer value1, Integer value2) {
            addCriterion("daycount not between", value1, value2, "daycount");
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