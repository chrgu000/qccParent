package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class SystemstateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemstateExample() {
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

        public Criteria andSystemidIsNull() {
            addCriterion("systemid is null");
            return (Criteria) this;
        }

        public Criteria andSystemidIsNotNull() {
            addCriterion("systemid is not null");
            return (Criteria) this;
        }

        public Criteria andSystemidEqualTo(Integer value) {
            addCriterion("systemid =", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotEqualTo(Integer value) {
            addCriterion("systemid <>", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidGreaterThan(Integer value) {
            addCriterion("systemid >", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("systemid >=", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLessThan(Integer value) {
            addCriterion("systemid <", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLessThanOrEqualTo(Integer value) {
            addCriterion("systemid <=", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidIn(List<Integer> values) {
            addCriterion("systemid in", values, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotIn(List<Integer> values) {
            addCriterion("systemid not in", values, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidBetween(Integer value1, Integer value2) {
            addCriterion("systemid between", value1, value2, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotBetween(Integer value1, Integer value2) {
            addCriterion("systemid not between", value1, value2, "systemid");
            return (Criteria) this;
        }

        public Criteria andDescnameIsNull() {
            addCriterion("descname is null");
            return (Criteria) this;
        }

        public Criteria andDescnameIsNotNull() {
            addCriterion("descname is not null");
            return (Criteria) this;
        }

        public Criteria andDescnameEqualTo(String value) {
            addCriterion("descname =", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotEqualTo(String value) {
            addCriterion("descname <>", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameGreaterThan(String value) {
            addCriterion("descname >", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameGreaterThanOrEqualTo(String value) {
            addCriterion("descname >=", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLessThan(String value) {
            addCriterion("descname <", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLessThanOrEqualTo(String value) {
            addCriterion("descname <=", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameLike(String value) {
            addCriterion("descname like", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotLike(String value) {
            addCriterion("descname not like", value, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameIn(List<String> values) {
            addCriterion("descname in", values, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotIn(List<String> values) {
            addCriterion("descname not in", values, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameBetween(String value1, String value2) {
            addCriterion("descname between", value1, value2, "descname");
            return (Criteria) this;
        }

        public Criteria andDescnameNotBetween(String value1, String value2) {
            addCriterion("descname not between", value1, value2, "descname");
            return (Criteria) this;
        }

        public Criteria andStateaboutIsNull() {
            addCriterion("stateabout is null");
            return (Criteria) this;
        }

        public Criteria andStateaboutIsNotNull() {
            addCriterion("stateabout is not null");
            return (Criteria) this;
        }

        public Criteria andStateaboutEqualTo(String value) {
            addCriterion("stateabout =", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutNotEqualTo(String value) {
            addCriterion("stateabout <>", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutGreaterThan(String value) {
            addCriterion("stateabout >", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutGreaterThanOrEqualTo(String value) {
            addCriterion("stateabout >=", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutLessThan(String value) {
            addCriterion("stateabout <", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutLessThanOrEqualTo(String value) {
            addCriterion("stateabout <=", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutLike(String value) {
            addCriterion("stateabout like", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutNotLike(String value) {
            addCriterion("stateabout not like", value, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutIn(List<String> values) {
            addCriterion("stateabout in", values, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutNotIn(List<String> values) {
            addCriterion("stateabout not in", values, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutBetween(String value1, String value2) {
            addCriterion("stateabout between", value1, value2, "stateabout");
            return (Criteria) this;
        }

        public Criteria andStateaboutNotBetween(String value1, String value2) {
            addCriterion("stateabout not between", value1, value2, "stateabout");
            return (Criteria) this;
        }

        public Criteria andDefaultstateIsNull() {
            addCriterion("defaultstate is null");
            return (Criteria) this;
        }

        public Criteria andDefaultstateIsNotNull() {
            addCriterion("defaultstate is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultstateEqualTo(Integer value) {
            addCriterion("defaultstate =", value, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateNotEqualTo(Integer value) {
            addCriterion("defaultstate <>", value, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateGreaterThan(Integer value) {
            addCriterion("defaultstate >", value, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("defaultstate >=", value, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateLessThan(Integer value) {
            addCriterion("defaultstate <", value, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateLessThanOrEqualTo(Integer value) {
            addCriterion("defaultstate <=", value, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateIn(List<Integer> values) {
            addCriterion("defaultstate in", values, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateNotIn(List<Integer> values) {
            addCriterion("defaultstate not in", values, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateBetween(Integer value1, Integer value2) {
            addCriterion("defaultstate between", value1, value2, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andDefaultstateNotBetween(Integer value1, Integer value2) {
            addCriterion("defaultstate not between", value1, value2, "defaultstate");
            return (Criteria) this;
        }

        public Criteria andTypewordIsNull() {
            addCriterion("typeword is null");
            return (Criteria) this;
        }

        public Criteria andTypewordIsNotNull() {
            addCriterion("typeword is not null");
            return (Criteria) this;
        }

        public Criteria andTypewordEqualTo(String value) {
            addCriterion("typeword =", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordNotEqualTo(String value) {
            addCriterion("typeword <>", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordGreaterThan(String value) {
            addCriterion("typeword >", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordGreaterThanOrEqualTo(String value) {
            addCriterion("typeword >=", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordLessThan(String value) {
            addCriterion("typeword <", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordLessThanOrEqualTo(String value) {
            addCriterion("typeword <=", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordLike(String value) {
            addCriterion("typeword like", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordNotLike(String value) {
            addCriterion("typeword not like", value, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordIn(List<String> values) {
            addCriterion("typeword in", values, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordNotIn(List<String> values) {
            addCriterion("typeword not in", values, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordBetween(String value1, String value2) {
            addCriterion("typeword between", value1, value2, "typeword");
            return (Criteria) this;
        }

        public Criteria andTypewordNotBetween(String value1, String value2) {
            addCriterion("typeword not between", value1, value2, "typeword");
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