package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class PararuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PararuleExample() {
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

        public Criteria andPararuleidIsNull() {
            addCriterion("pararuleid is null");
            return (Criteria) this;
        }

        public Criteria andPararuleidIsNotNull() {
            addCriterion("pararuleid is not null");
            return (Criteria) this;
        }

        public Criteria andPararuleidEqualTo(Integer value) {
            addCriterion("pararuleid =", value, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidNotEqualTo(Integer value) {
            addCriterion("pararuleid <>", value, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidGreaterThan(Integer value) {
            addCriterion("pararuleid >", value, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pararuleid >=", value, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidLessThan(Integer value) {
            addCriterion("pararuleid <", value, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidLessThanOrEqualTo(Integer value) {
            addCriterion("pararuleid <=", value, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidIn(List<Integer> values) {
            addCriterion("pararuleid in", values, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidNotIn(List<Integer> values) {
            addCriterion("pararuleid not in", values, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidBetween(Integer value1, Integer value2) {
            addCriterion("pararuleid between", value1, value2, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararuleidNotBetween(Integer value1, Integer value2) {
            addCriterion("pararuleid not between", value1, value2, "pararuleid");
            return (Criteria) this;
        }

        public Criteria andPararulenameIsNull() {
            addCriterion("pararulename is null");
            return (Criteria) this;
        }

        public Criteria andPararulenameIsNotNull() {
            addCriterion("pararulename is not null");
            return (Criteria) this;
        }

        public Criteria andPararulenameEqualTo(String value) {
            addCriterion("pararulename =", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameNotEqualTo(String value) {
            addCriterion("pararulename <>", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameGreaterThan(String value) {
            addCriterion("pararulename >", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameGreaterThanOrEqualTo(String value) {
            addCriterion("pararulename >=", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameLessThan(String value) {
            addCriterion("pararulename <", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameLessThanOrEqualTo(String value) {
            addCriterion("pararulename <=", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameLike(String value) {
            addCriterion("pararulename like", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameNotLike(String value) {
            addCriterion("pararulename not like", value, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameIn(List<String> values) {
            addCriterion("pararulename in", values, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameNotIn(List<String> values) {
            addCriterion("pararulename not in", values, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameBetween(String value1, String value2) {
            addCriterion("pararulename between", value1, value2, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararulenameNotBetween(String value1, String value2) {
            addCriterion("pararulename not between", value1, value2, "pararulename");
            return (Criteria) this;
        }

        public Criteria andPararuledetailIsNull() {
            addCriterion("pararuledetail is null");
            return (Criteria) this;
        }

        public Criteria andPararuledetailIsNotNull() {
            addCriterion("pararuledetail is not null");
            return (Criteria) this;
        }

        public Criteria andPararuledetailEqualTo(String value) {
            addCriterion("pararuledetail =", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailNotEqualTo(String value) {
            addCriterion("pararuledetail <>", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailGreaterThan(String value) {
            addCriterion("pararuledetail >", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailGreaterThanOrEqualTo(String value) {
            addCriterion("pararuledetail >=", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailLessThan(String value) {
            addCriterion("pararuledetail <", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailLessThanOrEqualTo(String value) {
            addCriterion("pararuledetail <=", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailLike(String value) {
            addCriterion("pararuledetail like", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailNotLike(String value) {
            addCriterion("pararuledetail not like", value, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailIn(List<String> values) {
            addCriterion("pararuledetail in", values, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailNotIn(List<String> values) {
            addCriterion("pararuledetail not in", values, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailBetween(String value1, String value2) {
            addCriterion("pararuledetail between", value1, value2, "pararuledetail");
            return (Criteria) this;
        }

        public Criteria andPararuledetailNotBetween(String value1, String value2) {
            addCriterion("pararuledetail not between", value1, value2, "pararuledetail");
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