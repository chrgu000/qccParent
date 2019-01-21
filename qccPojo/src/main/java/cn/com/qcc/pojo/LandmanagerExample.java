package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LandmanagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LandmanagerExample() {
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

        public Criteria andLandmanageridIsNull() {
            addCriterion("landmanagerid is null");
            return (Criteria) this;
        }

        public Criteria andLandmanageridIsNotNull() {
            addCriterion("landmanagerid is not null");
            return (Criteria) this;
        }

        public Criteria andLandmanageridEqualTo(Long value) {
            addCriterion("landmanagerid =", value, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridNotEqualTo(Long value) {
            addCriterion("landmanagerid <>", value, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridGreaterThan(Long value) {
            addCriterion("landmanagerid >", value, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridGreaterThanOrEqualTo(Long value) {
            addCriterion("landmanagerid >=", value, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridLessThan(Long value) {
            addCriterion("landmanagerid <", value, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridLessThanOrEqualTo(Long value) {
            addCriterion("landmanagerid <=", value, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridIn(List<Long> values) {
            addCriterion("landmanagerid in", values, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridNotIn(List<Long> values) {
            addCriterion("landmanagerid not in", values, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridBetween(Long value1, Long value2) {
            addCriterion("landmanagerid between", value1, value2, "landmanagerid");
            return (Criteria) this;
        }

        public Criteria andLandmanageridNotBetween(Long value1, Long value2) {
            addCriterion("landmanagerid not between", value1, value2, "landmanagerid");
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

        public Criteria andFollowuseridIsNull() {
            addCriterion("followuserid is null");
            return (Criteria) this;
        }

        public Criteria andFollowuseridIsNotNull() {
            addCriterion("followuserid is not null");
            return (Criteria) this;
        }

        public Criteria andFollowuseridEqualTo(Long value) {
            addCriterion("followuserid =", value, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridNotEqualTo(Long value) {
            addCriterion("followuserid <>", value, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridGreaterThan(Long value) {
            addCriterion("followuserid >", value, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridGreaterThanOrEqualTo(Long value) {
            addCriterion("followuserid >=", value, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridLessThan(Long value) {
            addCriterion("followuserid <", value, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridLessThanOrEqualTo(Long value) {
            addCriterion("followuserid <=", value, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridIn(List<Long> values) {
            addCriterion("followuserid in", values, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridNotIn(List<Long> values) {
            addCriterion("followuserid not in", values, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridBetween(Long value1, Long value2) {
            addCriterion("followuserid between", value1, value2, "followuserid");
            return (Criteria) this;
        }

        public Criteria andFollowuseridNotBetween(Long value1, Long value2) {
            addCriterion("followuserid not between", value1, value2, "followuserid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidIsNull() {
            addCriterion("accessurlid is null");
            return (Criteria) this;
        }

        public Criteria andAccessurlidIsNotNull() {
            addCriterion("accessurlid is not null");
            return (Criteria) this;
        }

        public Criteria andAccessurlidEqualTo(String value) {
            addCriterion("accessurlid =", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidNotEqualTo(String value) {
            addCriterion("accessurlid <>", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidGreaterThan(String value) {
            addCriterion("accessurlid >", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidGreaterThanOrEqualTo(String value) {
            addCriterion("accessurlid >=", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidLessThan(String value) {
            addCriterion("accessurlid <", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidLessThanOrEqualTo(String value) {
            addCriterion("accessurlid <=", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidLike(String value) {
            addCriterion("accessurlid like", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidNotLike(String value) {
            addCriterion("accessurlid not like", value, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidIn(List<String> values) {
            addCriterion("accessurlid in", values, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidNotIn(List<String> values) {
            addCriterion("accessurlid not in", values, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidBetween(String value1, String value2) {
            addCriterion("accessurlid between", value1, value2, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andAccessurlidNotBetween(String value1, String value2) {
            addCriterion("accessurlid not between", value1, value2, "accessurlid");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateIsNull() {
            addCriterion("landmanagerstate is null");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateIsNotNull() {
            addCriterion("landmanagerstate is not null");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateEqualTo(Integer value) {
            addCriterion("landmanagerstate =", value, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateNotEqualTo(Integer value) {
            addCriterion("landmanagerstate <>", value, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateGreaterThan(Integer value) {
            addCriterion("landmanagerstate >", value, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("landmanagerstate >=", value, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateLessThan(Integer value) {
            addCriterion("landmanagerstate <", value, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateLessThanOrEqualTo(Integer value) {
            addCriterion("landmanagerstate <=", value, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateIn(List<Integer> values) {
            addCriterion("landmanagerstate in", values, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateNotIn(List<Integer> values) {
            addCriterion("landmanagerstate not in", values, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateBetween(Integer value1, Integer value2) {
            addCriterion("landmanagerstate between", value1, value2, "landmanagerstate");
            return (Criteria) this;
        }

        public Criteria andLandmanagerstateNotBetween(Integer value1, Integer value2) {
            addCriterion("landmanagerstate not between", value1, value2, "landmanagerstate");
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