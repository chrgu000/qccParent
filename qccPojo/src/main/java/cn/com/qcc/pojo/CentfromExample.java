package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class CentfromExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CentfromExample() {
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

        public Criteria andCentfromidIsNull() {
            addCriterion("centfromid is null");
            return (Criteria) this;
        }

        public Criteria andCentfromidIsNotNull() {
            addCriterion("centfromid is not null");
            return (Criteria) this;
        }

        public Criteria andCentfromidEqualTo(Long value) {
            addCriterion("centfromid =", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidNotEqualTo(Long value) {
            addCriterion("centfromid <>", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidGreaterThan(Long value) {
            addCriterion("centfromid >", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidGreaterThanOrEqualTo(Long value) {
            addCriterion("centfromid >=", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidLessThan(Long value) {
            addCriterion("centfromid <", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidLessThanOrEqualTo(Long value) {
            addCriterion("centfromid <=", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidIn(List<Long> values) {
            addCriterion("centfromid in", values, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidNotIn(List<Long> values) {
            addCriterion("centfromid not in", values, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidBetween(Long value1, Long value2) {
            addCriterion("centfromid between", value1, value2, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidNotBetween(Long value1, Long value2) {
            addCriterion("centfromid not between", value1, value2, "centfromid");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNull() {
            addCriterion("fatherid is null");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNotNull() {
            addCriterion("fatherid is not null");
            return (Criteria) this;
        }

        public Criteria andFatheridEqualTo(String value) {
            addCriterion("fatherid =", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotEqualTo(String value) {
            addCriterion("fatherid <>", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThan(String value) {
            addCriterion("fatherid >", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThanOrEqualTo(String value) {
            addCriterion("fatherid >=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThan(String value) {
            addCriterion("fatherid <", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThanOrEqualTo(String value) {
            addCriterion("fatherid <=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLike(String value) {
            addCriterion("fatherid like", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotLike(String value) {
            addCriterion("fatherid not like", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridIn(List<String> values) {
            addCriterion("fatherid in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotIn(List<String> values) {
            addCriterion("fatherid not in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridBetween(String value1, String value2) {
            addCriterion("fatherid between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotBetween(String value1, String value2) {
            addCriterion("fatherid not between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andCategorynameIsNull() {
            addCriterion("categoryname is null");
            return (Criteria) this;
        }

        public Criteria andCategorynameIsNotNull() {
            addCriterion("categoryname is not null");
            return (Criteria) this;
        }

        public Criteria andCategorynameEqualTo(String value) {
            addCriterion("categoryname =", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotEqualTo(String value) {
            addCriterion("categoryname <>", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameGreaterThan(String value) {
            addCriterion("categoryname >", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameGreaterThanOrEqualTo(String value) {
            addCriterion("categoryname >=", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLessThan(String value) {
            addCriterion("categoryname <", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLessThanOrEqualTo(String value) {
            addCriterion("categoryname <=", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameLike(String value) {
            addCriterion("categoryname like", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotLike(String value) {
            addCriterion("categoryname not like", value, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameIn(List<String> values) {
            addCriterion("categoryname in", values, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotIn(List<String> values) {
            addCriterion("categoryname not in", values, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameBetween(String value1, String value2) {
            addCriterion("categoryname between", value1, value2, "categoryname");
            return (Criteria) this;
        }

        public Criteria andCategorynameNotBetween(String value1, String value2) {
            addCriterion("categoryname not between", value1, value2, "categoryname");
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