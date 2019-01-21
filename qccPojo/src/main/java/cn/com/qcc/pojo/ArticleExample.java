package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOtheridIsNull() {
            addCriterion("otherid is null");
            return (Criteria) this;
        }

        public Criteria andOtheridIsNotNull() {
            addCriterion("otherid is not null");
            return (Criteria) this;
        }

        public Criteria andOtheridEqualTo(Long value) {
            addCriterion("otherid =", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotEqualTo(Long value) {
            addCriterion("otherid <>", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThan(Long value) {
            addCriterion("otherid >", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThanOrEqualTo(Long value) {
            addCriterion("otherid >=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThan(Long value) {
            addCriterion("otherid <", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThanOrEqualTo(Long value) {
            addCriterion("otherid <=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridIn(List<Long> values) {
            addCriterion("otherid in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotIn(List<Long> values) {
            addCriterion("otherid not in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridBetween(Long value1, Long value2) {
            addCriterion("otherid between", value1, value2, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotBetween(Long value1, Long value2) {
            addCriterion("otherid not between", value1, value2, "otherid");
            return (Criteria) this;
        }

        public Criteria andTribeidIsNull() {
            addCriterion("tribeid is null");
            return (Criteria) this;
        }

        public Criteria andTribeidIsNotNull() {
            addCriterion("tribeid is not null");
            return (Criteria) this;
        }

        public Criteria andTribeidEqualTo(Long value) {
            addCriterion("tribeid =", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidNotEqualTo(Long value) {
            addCriterion("tribeid <>", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidGreaterThan(Long value) {
            addCriterion("tribeid >", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidGreaterThanOrEqualTo(Long value) {
            addCriterion("tribeid >=", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidLessThan(Long value) {
            addCriterion("tribeid <", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidLessThanOrEqualTo(Long value) {
            addCriterion("tribeid <=", value, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidIn(List<Long> values) {
            addCriterion("tribeid in", values, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidNotIn(List<Long> values) {
            addCriterion("tribeid not in", values, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidBetween(Long value1, Long value2) {
            addCriterion("tribeid between", value1, value2, "tribeid");
            return (Criteria) this;
        }

        public Criteria andTribeidNotBetween(Long value1, Long value2) {
            addCriterion("tribeid not between", value1, value2, "tribeid");
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