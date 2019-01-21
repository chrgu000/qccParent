package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReleasetableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReleasetableExample() {
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

        public Criteria andReleaseidIsNull() {
            addCriterion("releaseid is null");
            return (Criteria) this;
        }

        public Criteria andReleaseidIsNotNull() {
            addCriterion("releaseid is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseidEqualTo(Long value) {
            addCriterion("releaseid =", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotEqualTo(Long value) {
            addCriterion("releaseid <>", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThan(Long value) {
            addCriterion("releaseid >", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThanOrEqualTo(Long value) {
            addCriterion("releaseid >=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThan(Long value) {
            addCriterion("releaseid <", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThanOrEqualTo(Long value) {
            addCriterion("releaseid <=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidIn(List<Long> values) {
            addCriterion("releaseid in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotIn(List<Long> values) {
            addCriterion("releaseid not in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidBetween(Long value1, Long value2) {
            addCriterion("releaseid between", value1, value2, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotBetween(Long value1, Long value2) {
            addCriterion("releaseid not between", value1, value2, "releaseid");
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

        public Criteria andPricesIsNull() {
            addCriterion("prices is null");
            return (Criteria) this;
        }

        public Criteria andPricesIsNotNull() {
            addCriterion("prices is not null");
            return (Criteria) this;
        }

        public Criteria andPricesEqualTo(Double value) {
            addCriterion("prices =", value, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesNotEqualTo(Double value) {
            addCriterion("prices <>", value, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesGreaterThan(Double value) {
            addCriterion("prices >", value, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesGreaterThanOrEqualTo(Double value) {
            addCriterion("prices >=", value, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesLessThan(Double value) {
            addCriterion("prices <", value, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesLessThanOrEqualTo(Double value) {
            addCriterion("prices <=", value, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesIn(List<Double> values) {
            addCriterion("prices in", values, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesNotIn(List<Double> values) {
            addCriterion("prices not in", values, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesBetween(Double value1, Double value2) {
            addCriterion("prices between", value1, value2, "prices");
            return (Criteria) this;
        }

        public Criteria andPricesNotBetween(Double value1, Double value2) {
            addCriterion("prices not between", value1, value2, "prices");
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

        public Criteria andCodeidsIsNull() {
            addCriterion("codeids is null");
            return (Criteria) this;
        }

        public Criteria andCodeidsIsNotNull() {
            addCriterion("codeids is not null");
            return (Criteria) this;
        }

        public Criteria andCodeidsEqualTo(String value) {
            addCriterion("codeids =", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsNotEqualTo(String value) {
            addCriterion("codeids <>", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsGreaterThan(String value) {
            addCriterion("codeids >", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsGreaterThanOrEqualTo(String value) {
            addCriterion("codeids >=", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsLessThan(String value) {
            addCriterion("codeids <", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsLessThanOrEqualTo(String value) {
            addCriterion("codeids <=", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsLike(String value) {
            addCriterion("codeids like", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsNotLike(String value) {
            addCriterion("codeids not like", value, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsIn(List<String> values) {
            addCriterion("codeids in", values, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsNotIn(List<String> values) {
            addCriterion("codeids not in", values, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsBetween(String value1, String value2) {
            addCriterion("codeids between", value1, value2, "codeids");
            return (Criteria) this;
        }

        public Criteria andCodeidsNotBetween(String value1, String value2) {
            addCriterion("codeids not between", value1, value2, "codeids");
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