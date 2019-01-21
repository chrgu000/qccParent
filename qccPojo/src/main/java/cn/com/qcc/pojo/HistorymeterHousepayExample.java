package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class HistorymeterHousepayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistorymeterHousepayExample() {
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