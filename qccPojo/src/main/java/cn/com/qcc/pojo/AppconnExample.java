package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppconnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppconnExample() {
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

        public Criteria andPhoneAddressIsNull() {
            addCriterion("phoneAddress is null");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressIsNotNull() {
            addCriterion("phoneAddress is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressEqualTo(String value) {
            addCriterion("phoneAddress =", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressNotEqualTo(String value) {
            addCriterion("phoneAddress <>", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressGreaterThan(String value) {
            addCriterion("phoneAddress >", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressGreaterThanOrEqualTo(String value) {
            addCriterion("phoneAddress >=", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressLessThan(String value) {
            addCriterion("phoneAddress <", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressLessThanOrEqualTo(String value) {
            addCriterion("phoneAddress <=", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressLike(String value) {
            addCriterion("phoneAddress like", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressNotLike(String value) {
            addCriterion("phoneAddress not like", value, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressIn(List<String> values) {
            addCriterion("phoneAddress in", values, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressNotIn(List<String> values) {
            addCriterion("phoneAddress not in", values, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressBetween(String value1, String value2) {
            addCriterion("phoneAddress between", value1, value2, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andPhoneAddressNotBetween(String value1, String value2) {
            addCriterion("phoneAddress not between", value1, value2, "phoneAddress");
            return (Criteria) this;
        }

        public Criteria andVersionidIsNull() {
            addCriterion("versionid is null");
            return (Criteria) this;
        }

        public Criteria andVersionidIsNotNull() {
            addCriterion("versionid is not null");
            return (Criteria) this;
        }

        public Criteria andVersionidEqualTo(String value) {
            addCriterion("versionid =", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotEqualTo(String value) {
            addCriterion("versionid <>", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidGreaterThan(String value) {
            addCriterion("versionid >", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidGreaterThanOrEqualTo(String value) {
            addCriterion("versionid >=", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidLessThan(String value) {
            addCriterion("versionid <", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidLessThanOrEqualTo(String value) {
            addCriterion("versionid <=", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidLike(String value) {
            addCriterion("versionid like", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotLike(String value) {
            addCriterion("versionid not like", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidIn(List<String> values) {
            addCriterion("versionid in", values, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotIn(List<String> values) {
            addCriterion("versionid not in", values, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidBetween(String value1, String value2) {
            addCriterion("versionid between", value1, value2, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotBetween(String value1, String value2) {
            addCriterion("versionid not between", value1, value2, "versionid");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
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