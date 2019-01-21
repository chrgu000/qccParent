package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class TypedetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypedetailExample() {
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

        public Criteria andTypedetailidIsNull() {
            addCriterion("typedetailid is null");
            return (Criteria) this;
        }

        public Criteria andTypedetailidIsNotNull() {
            addCriterion("typedetailid is not null");
            return (Criteria) this;
        }

        public Criteria andTypedetailidEqualTo(Long value) {
            addCriterion("typedetailid =", value, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidNotEqualTo(Long value) {
            addCriterion("typedetailid <>", value, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidGreaterThan(Long value) {
            addCriterion("typedetailid >", value, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidGreaterThanOrEqualTo(Long value) {
            addCriterion("typedetailid >=", value, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidLessThan(Long value) {
            addCriterion("typedetailid <", value, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidLessThanOrEqualTo(Long value) {
            addCriterion("typedetailid <=", value, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidIn(List<Long> values) {
            addCriterion("typedetailid in", values, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidNotIn(List<Long> values) {
            addCriterion("typedetailid not in", values, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidBetween(Long value1, Long value2) {
            addCriterion("typedetailid between", value1, value2, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andTypedetailidNotBetween(Long value1, Long value2) {
            addCriterion("typedetailid not between", value1, value2, "typedetailid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidIsNull() {
            addCriterion("articletypeid is null");
            return (Criteria) this;
        }

        public Criteria andArticletypeidIsNotNull() {
            addCriterion("articletypeid is not null");
            return (Criteria) this;
        }

        public Criteria andArticletypeidEqualTo(Integer value) {
            addCriterion("articletypeid =", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidNotEqualTo(Integer value) {
            addCriterion("articletypeid <>", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidGreaterThan(Integer value) {
            addCriterion("articletypeid >", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("articletypeid >=", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidLessThan(Integer value) {
            addCriterion("articletypeid <", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidLessThanOrEqualTo(Integer value) {
            addCriterion("articletypeid <=", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidIn(List<Integer> values) {
            addCriterion("articletypeid in", values, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidNotIn(List<Integer> values) {
            addCriterion("articletypeid not in", values, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidBetween(Integer value1, Integer value2) {
            addCriterion("articletypeid between", value1, value2, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("articletypeid not between", value1, value2, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andDetailnameIsNull() {
            addCriterion("detailname is null");
            return (Criteria) this;
        }

        public Criteria andDetailnameIsNotNull() {
            addCriterion("detailname is not null");
            return (Criteria) this;
        }

        public Criteria andDetailnameEqualTo(String value) {
            addCriterion("detailname =", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotEqualTo(String value) {
            addCriterion("detailname <>", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameGreaterThan(String value) {
            addCriterion("detailname >", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameGreaterThanOrEqualTo(String value) {
            addCriterion("detailname >=", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameLessThan(String value) {
            addCriterion("detailname <", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameLessThanOrEqualTo(String value) {
            addCriterion("detailname <=", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameLike(String value) {
            addCriterion("detailname like", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotLike(String value) {
            addCriterion("detailname not like", value, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameIn(List<String> values) {
            addCriterion("detailname in", values, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotIn(List<String> values) {
            addCriterion("detailname not in", values, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameBetween(String value1, String value2) {
            addCriterion("detailname between", value1, value2, "detailname");
            return (Criteria) this;
        }

        public Criteria andDetailnameNotBetween(String value1, String value2) {
            addCriterion("detailname not between", value1, value2, "detailname");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(String value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(String value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(String value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(String value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(String value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(String value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLike(String value) {
            addCriterion("typeid like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotLike(String value) {
            addCriterion("typeid not like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<String> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<String> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(String value1, String value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(String value1, String value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
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