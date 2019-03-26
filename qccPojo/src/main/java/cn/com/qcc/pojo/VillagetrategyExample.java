package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VillagetrategyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VillagetrategyExample() {
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

        public Criteria andTrategyidIsNull() {
            addCriterion("trategyid is null");
            return (Criteria) this;
        }

        public Criteria andTrategyidIsNotNull() {
            addCriterion("trategyid is not null");
            return (Criteria) this;
        }

        public Criteria andTrategyidEqualTo(Long value) {
            addCriterion("trategyid =", value, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidNotEqualTo(Long value) {
            addCriterion("trategyid <>", value, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidGreaterThan(Long value) {
            addCriterion("trategyid >", value, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidGreaterThanOrEqualTo(Long value) {
            addCriterion("trategyid >=", value, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidLessThan(Long value) {
            addCriterion("trategyid <", value, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidLessThanOrEqualTo(Long value) {
            addCriterion("trategyid <=", value, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidIn(List<Long> values) {
            addCriterion("trategyid in", values, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidNotIn(List<Long> values) {
            addCriterion("trategyid not in", values, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidBetween(Long value1, Long value2) {
            addCriterion("trategyid between", value1, value2, "trategyid");
            return (Criteria) this;
        }

        public Criteria andTrategyidNotBetween(Long value1, Long value2) {
            addCriterion("trategyid not between", value1, value2, "trategyid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andVillageidIsNull() {
            addCriterion("villageid is null");
            return (Criteria) this;
        }

        public Criteria andVillageidIsNotNull() {
            addCriterion("villageid is not null");
            return (Criteria) this;
        }

        public Criteria andVillageidEqualTo(Long value) {
            addCriterion("villageid =", value, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidNotEqualTo(Long value) {
            addCriterion("villageid <>", value, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidGreaterThan(Long value) {
            addCriterion("villageid >", value, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidGreaterThanOrEqualTo(Long value) {
            addCriterion("villageid >=", value, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidLessThan(Long value) {
            addCriterion("villageid <", value, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidLessThanOrEqualTo(Long value) {
            addCriterion("villageid <=", value, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidIn(List<Long> values) {
            addCriterion("villageid in", values, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidNotIn(List<Long> values) {
            addCriterion("villageid not in", values, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidBetween(Long value1, Long value2) {
            addCriterion("villageid between", value1, value2, "villageid");
            return (Criteria) this;
        }

        public Criteria andVillageidNotBetween(Long value1, Long value2) {
            addCriterion("villageid not between", value1, value2, "villageid");
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

        public Criteria andStrategyimgIsNull() {
            addCriterion("strategyimg is null");
            return (Criteria) this;
        }

        public Criteria andStrategyimgIsNotNull() {
            addCriterion("strategyimg is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyimgEqualTo(String value) {
            addCriterion("strategyimg =", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgNotEqualTo(String value) {
            addCriterion("strategyimg <>", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgGreaterThan(String value) {
            addCriterion("strategyimg >", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgGreaterThanOrEqualTo(String value) {
            addCriterion("strategyimg >=", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgLessThan(String value) {
            addCriterion("strategyimg <", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgLessThanOrEqualTo(String value) {
            addCriterion("strategyimg <=", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgLike(String value) {
            addCriterion("strategyimg like", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgNotLike(String value) {
            addCriterion("strategyimg not like", value, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgIn(List<String> values) {
            addCriterion("strategyimg in", values, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgNotIn(List<String> values) {
            addCriterion("strategyimg not in", values, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgBetween(String value1, String value2) {
            addCriterion("strategyimg between", value1, value2, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andStrategyimgNotBetween(String value1, String value2) {
            addCriterion("strategyimg not between", value1, value2, "strategyimg");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioIsNull() {
            addCriterion("strategyvedio is null");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioIsNotNull() {
            addCriterion("strategyvedio is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioEqualTo(String value) {
            addCriterion("strategyvedio =", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioNotEqualTo(String value) {
            addCriterion("strategyvedio <>", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioGreaterThan(String value) {
            addCriterion("strategyvedio >", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioGreaterThanOrEqualTo(String value) {
            addCriterion("strategyvedio >=", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioLessThan(String value) {
            addCriterion("strategyvedio <", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioLessThanOrEqualTo(String value) {
            addCriterion("strategyvedio <=", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioLike(String value) {
            addCriterion("strategyvedio like", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioNotLike(String value) {
            addCriterion("strategyvedio not like", value, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioIn(List<String> values) {
            addCriterion("strategyvedio in", values, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioNotIn(List<String> values) {
            addCriterion("strategyvedio not in", values, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioBetween(String value1, String value2) {
            addCriterion("strategyvedio between", value1, value2, "strategyvedio");
            return (Criteria) this;
        }

        public Criteria andStrategyvedioNotBetween(String value1, String value2) {
            addCriterion("strategyvedio not between", value1, value2, "strategyvedio");
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