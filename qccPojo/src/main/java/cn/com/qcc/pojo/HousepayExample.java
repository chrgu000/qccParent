package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HousepayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HousepayExample() {
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

        public Criteria andHousepayidIsNull() {
            addCriterion("housepayid is null");
            return (Criteria) this;
        }

        public Criteria andHousepayidIsNotNull() {
            addCriterion("housepayid is not null");
            return (Criteria) this;
        }

        public Criteria andHousepayidEqualTo(Long value) {
            addCriterion("housepayid =", value, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidNotEqualTo(Long value) {
            addCriterion("housepayid <>", value, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidGreaterThan(Long value) {
            addCriterion("housepayid >", value, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidGreaterThanOrEqualTo(Long value) {
            addCriterion("housepayid >=", value, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidLessThan(Long value) {
            addCriterion("housepayid <", value, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidLessThanOrEqualTo(Long value) {
            addCriterion("housepayid <=", value, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidIn(List<Long> values) {
            addCriterion("housepayid in", values, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidNotIn(List<Long> values) {
            addCriterion("housepayid not in", values, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidBetween(Long value1, Long value2) {
            addCriterion("housepayid between", value1, value2, "housepayid");
            return (Criteria) this;
        }

        public Criteria andHousepayidNotBetween(Long value1, Long value2) {
            addCriterion("housepayid not between", value1, value2, "housepayid");
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

        public Criteria andFinanceidEqualTo(Long value) {
            addCriterion("financeid =", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidNotEqualTo(Long value) {
            addCriterion("financeid <>", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidGreaterThan(Long value) {
            addCriterion("financeid >", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidGreaterThanOrEqualTo(Long value) {
            addCriterion("financeid >=", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidLessThan(Long value) {
            addCriterion("financeid <", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidLessThanOrEqualTo(Long value) {
            addCriterion("financeid <=", value, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidIn(List<Long> values) {
            addCriterion("financeid in", values, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidNotIn(List<Long> values) {
            addCriterion("financeid not in", values, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidBetween(Long value1, Long value2) {
            addCriterion("financeid between", value1, value2, "financeid");
            return (Criteria) this;
        }

        public Criteria andFinanceidNotBetween(Long value1, Long value2) {
            addCriterion("financeid not between", value1, value2, "financeid");
            return (Criteria) this;
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

        public Criteria andPaystateIsNull() {
            addCriterion("paystate is null");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNotNull() {
            addCriterion("paystate is not null");
            return (Criteria) this;
        }

        public Criteria andPaystateEqualTo(Integer value) {
            addCriterion("paystate =", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotEqualTo(Integer value) {
            addCriterion("paystate <>", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThan(Integer value) {
            addCriterion("paystate >", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("paystate >=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThan(Integer value) {
            addCriterion("paystate <", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThanOrEqualTo(Integer value) {
            addCriterion("paystate <=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateIn(List<Integer> values) {
            addCriterion("paystate in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotIn(List<Integer> values) {
            addCriterion("paystate not in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateBetween(Integer value1, Integer value2) {
            addCriterion("paystate between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotBetween(Integer value1, Integer value2) {
            addCriterion("paystate not between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateIsNull() {
            addCriterion("currentstate is null");
            return (Criteria) this;
        }

        public Criteria andCurrentstateIsNotNull() {
            addCriterion("currentstate is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentstateEqualTo(Integer value) {
            addCriterion("currentstate =", value, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateNotEqualTo(Integer value) {
            addCriterion("currentstate <>", value, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateGreaterThan(Integer value) {
            addCriterion("currentstate >", value, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("currentstate >=", value, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateLessThan(Integer value) {
            addCriterion("currentstate <", value, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateLessThanOrEqualTo(Integer value) {
            addCriterion("currentstate <=", value, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateIn(List<Integer> values) {
            addCriterion("currentstate in", values, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateNotIn(List<Integer> values) {
            addCriterion("currentstate not in", values, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateBetween(Integer value1, Integer value2) {
            addCriterion("currentstate between", value1, value2, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCurrentstateNotBetween(Integer value1, Integer value2) {
            addCriterion("currentstate not between", value1, value2, "currentstate");
            return (Criteria) this;
        }

        public Criteria andCentpricesIsNull() {
            addCriterion("centprices is null");
            return (Criteria) this;
        }

        public Criteria andCentpricesIsNotNull() {
            addCriterion("centprices is not null");
            return (Criteria) this;
        }

        public Criteria andCentpricesEqualTo(Double value) {
            addCriterion("centprices =", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesNotEqualTo(Double value) {
            addCriterion("centprices <>", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesGreaterThan(Double value) {
            addCriterion("centprices >", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesGreaterThanOrEqualTo(Double value) {
            addCriterion("centprices >=", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesLessThan(Double value) {
            addCriterion("centprices <", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesLessThanOrEqualTo(Double value) {
            addCriterion("centprices <=", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesIn(List<Double> values) {
            addCriterion("centprices in", values, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesNotIn(List<Double> values) {
            addCriterion("centprices not in", values, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesBetween(Double value1, Double value2) {
            addCriterion("centprices between", value1, value2, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesNotBetween(Double value1, Double value2) {
            addCriterion("centprices not between", value1, value2, "centprices");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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