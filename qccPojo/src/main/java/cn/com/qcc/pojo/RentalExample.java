package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class RentalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentalExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Long value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Long value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Long value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Long value1, Long value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Long value1, Long value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andRentcontentIsNull() {
            addCriterion("rentcontent is null");
            return (Criteria) this;
        }

        public Criteria andRentcontentIsNotNull() {
            addCriterion("rentcontent is not null");
            return (Criteria) this;
        }

        public Criteria andRentcontentEqualTo(String value) {
            addCriterion("rentcontent =", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentNotEqualTo(String value) {
            addCriterion("rentcontent <>", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentGreaterThan(String value) {
            addCriterion("rentcontent >", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentGreaterThanOrEqualTo(String value) {
            addCriterion("rentcontent >=", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentLessThan(String value) {
            addCriterion("rentcontent <", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentLessThanOrEqualTo(String value) {
            addCriterion("rentcontent <=", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentLike(String value) {
            addCriterion("rentcontent like", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentNotLike(String value) {
            addCriterion("rentcontent not like", value, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentIn(List<String> values) {
            addCriterion("rentcontent in", values, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentNotIn(List<String> values) {
            addCriterion("rentcontent not in", values, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentBetween(String value1, String value2) {
            addCriterion("rentcontent between", value1, value2, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentcontentNotBetween(String value1, String value2) {
            addCriterion("rentcontent not between", value1, value2, "rentcontent");
            return (Criteria) this;
        }

        public Criteria andRentpictureIsNull() {
            addCriterion("rentpicture is null");
            return (Criteria) this;
        }

        public Criteria andRentpictureIsNotNull() {
            addCriterion("rentpicture is not null");
            return (Criteria) this;
        }

        public Criteria andRentpictureEqualTo(String value) {
            addCriterion("rentpicture =", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureNotEqualTo(String value) {
            addCriterion("rentpicture <>", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureGreaterThan(String value) {
            addCriterion("rentpicture >", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureGreaterThanOrEqualTo(String value) {
            addCriterion("rentpicture >=", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureLessThan(String value) {
            addCriterion("rentpicture <", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureLessThanOrEqualTo(String value) {
            addCriterion("rentpicture <=", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureLike(String value) {
            addCriterion("rentpicture like", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureNotLike(String value) {
            addCriterion("rentpicture not like", value, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureIn(List<String> values) {
            addCriterion("rentpicture in", values, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureNotIn(List<String> values) {
            addCriterion("rentpicture not in", values, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureBetween(String value1, String value2) {
            addCriterion("rentpicture between", value1, value2, "rentpicture");
            return (Criteria) this;
        }

        public Criteria andRentpictureNotBetween(String value1, String value2) {
            addCriterion("rentpicture not between", value1, value2, "rentpicture");
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