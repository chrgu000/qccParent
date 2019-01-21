package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class StoreconnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreconnExample() {
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

        public Criteria andStoreconnidIsNull() {
            addCriterion("storeconnid is null");
            return (Criteria) this;
        }

        public Criteria andStoreconnidIsNotNull() {
            addCriterion("storeconnid is not null");
            return (Criteria) this;
        }

        public Criteria andStoreconnidEqualTo(Long value) {
            addCriterion("storeconnid =", value, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidNotEqualTo(Long value) {
            addCriterion("storeconnid <>", value, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidGreaterThan(Long value) {
            addCriterion("storeconnid >", value, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidGreaterThanOrEqualTo(Long value) {
            addCriterion("storeconnid >=", value, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidLessThan(Long value) {
            addCriterion("storeconnid <", value, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidLessThanOrEqualTo(Long value) {
            addCriterion("storeconnid <=", value, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidIn(List<Long> values) {
            addCriterion("storeconnid in", values, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidNotIn(List<Long> values) {
            addCriterion("storeconnid not in", values, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidBetween(Long value1, Long value2) {
            addCriterion("storeconnid between", value1, value2, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreconnidNotBetween(Long value1, Long value2) {
            addCriterion("storeconnid not between", value1, value2, "storeconnid");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNull() {
            addCriterion("storeid is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeid is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(Long value) {
            addCriterion("storeid =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(Long value) {
            addCriterion("storeid <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(Long value) {
            addCriterion("storeid >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(Long value) {
            addCriterion("storeid >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(Long value) {
            addCriterion("storeid <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(Long value) {
            addCriterion("storeid <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<Long> values) {
            addCriterion("storeid in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<Long> values) {
            addCriterion("storeid not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(Long value1, Long value2) {
            addCriterion("storeid between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(Long value1, Long value2) {
            addCriterion("storeid not between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidIsNull() {
            addCriterion("articledetailid is null");
            return (Criteria) this;
        }

        public Criteria andArticledetailidIsNotNull() {
            addCriterion("articledetailid is not null");
            return (Criteria) this;
        }

        public Criteria andArticledetailidEqualTo(Long value) {
            addCriterion("articledetailid =", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidNotEqualTo(Long value) {
            addCriterion("articledetailid <>", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidGreaterThan(Long value) {
            addCriterion("articledetailid >", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidGreaterThanOrEqualTo(Long value) {
            addCriterion("articledetailid >=", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidLessThan(Long value) {
            addCriterion("articledetailid <", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidLessThanOrEqualTo(Long value) {
            addCriterion("articledetailid <=", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidIn(List<Long> values) {
            addCriterion("articledetailid in", values, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidNotIn(List<Long> values) {
            addCriterion("articledetailid not in", values, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidBetween(Long value1, Long value2) {
            addCriterion("articledetailid between", value1, value2, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidNotBetween(Long value1, Long value2) {
            addCriterion("articledetailid not between", value1, value2, "articledetailid");
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