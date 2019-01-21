package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class RentmodalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentmodalExample() {
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

        public Criteria andRentmodalidIsNull() {
            addCriterion("rentmodalid is null");
            return (Criteria) this;
        }

        public Criteria andRentmodalidIsNotNull() {
            addCriterion("rentmodalid is not null");
            return (Criteria) this;
        }

        public Criteria andRentmodalidEqualTo(Long value) {
            addCriterion("rentmodalid =", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidNotEqualTo(Long value) {
            addCriterion("rentmodalid <>", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidGreaterThan(Long value) {
            addCriterion("rentmodalid >", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidGreaterThanOrEqualTo(Long value) {
            addCriterion("rentmodalid >=", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidLessThan(Long value) {
            addCriterion("rentmodalid <", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidLessThanOrEqualTo(Long value) {
            addCriterion("rentmodalid <=", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidIn(List<Long> values) {
            addCriterion("rentmodalid in", values, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidNotIn(List<Long> values) {
            addCriterion("rentmodalid not in", values, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidBetween(Long value1, Long value2) {
            addCriterion("rentmodalid between", value1, value2, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidNotBetween(Long value1, Long value2) {
            addCriterion("rentmodalid not between", value1, value2, "rentmodalid");
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

        public Criteria andFatheridEqualTo(Integer value) {
            addCriterion("fatherid =", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotEqualTo(Integer value) {
            addCriterion("fatherid <>", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThan(Integer value) {
            addCriterion("fatherid >", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fatherid >=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThan(Integer value) {
            addCriterion("fatherid <", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThanOrEqualTo(Integer value) {
            addCriterion("fatherid <=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridIn(List<Integer> values) {
            addCriterion("fatherid in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotIn(List<Integer> values) {
            addCriterion("fatherid not in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridBetween(Integer value1, Integer value2) {
            addCriterion("fatherid between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("fatherid not between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andRentnameIsNull() {
            addCriterion("rentname is null");
            return (Criteria) this;
        }

        public Criteria andRentnameIsNotNull() {
            addCriterion("rentname is not null");
            return (Criteria) this;
        }

        public Criteria andRentnameEqualTo(String value) {
            addCriterion("rentname =", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameNotEqualTo(String value) {
            addCriterion("rentname <>", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameGreaterThan(String value) {
            addCriterion("rentname >", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameGreaterThanOrEqualTo(String value) {
            addCriterion("rentname >=", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameLessThan(String value) {
            addCriterion("rentname <", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameLessThanOrEqualTo(String value) {
            addCriterion("rentname <=", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameLike(String value) {
            addCriterion("rentname like", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameNotLike(String value) {
            addCriterion("rentname not like", value, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameIn(List<String> values) {
            addCriterion("rentname in", values, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameNotIn(List<String> values) {
            addCriterion("rentname not in", values, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameBetween(String value1, String value2) {
            addCriterion("rentname between", value1, value2, "rentname");
            return (Criteria) this;
        }

        public Criteria andRentnameNotBetween(String value1, String value2) {
            addCriterion("rentname not between", value1, value2, "rentname");
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