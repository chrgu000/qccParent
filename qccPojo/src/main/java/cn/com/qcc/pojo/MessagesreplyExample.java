package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessagesreplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessagesreplyExample() {
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

        public Criteria andMessagesreplyidIsNull() {
            addCriterion("messagesreplyid is null");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidIsNotNull() {
            addCriterion("messagesreplyid is not null");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidEqualTo(Long value) {
            addCriterion("messagesreplyid =", value, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidNotEqualTo(Long value) {
            addCriterion("messagesreplyid <>", value, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidGreaterThan(Long value) {
            addCriterion("messagesreplyid >", value, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidGreaterThanOrEqualTo(Long value) {
            addCriterion("messagesreplyid >=", value, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidLessThan(Long value) {
            addCriterion("messagesreplyid <", value, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidLessThanOrEqualTo(Long value) {
            addCriterion("messagesreplyid <=", value, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidIn(List<Long> values) {
            addCriterion("messagesreplyid in", values, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidNotIn(List<Long> values) {
            addCriterion("messagesreplyid not in", values, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidBetween(Long value1, Long value2) {
            addCriterion("messagesreplyid between", value1, value2, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesreplyidNotBetween(Long value1, Long value2) {
            addCriterion("messagesreplyid not between", value1, value2, "messagesreplyid");
            return (Criteria) this;
        }

        public Criteria andMessagesidIsNull() {
            addCriterion("messagesid is null");
            return (Criteria) this;
        }

        public Criteria andMessagesidIsNotNull() {
            addCriterion("messagesid is not null");
            return (Criteria) this;
        }

        public Criteria andMessagesidEqualTo(Long value) {
            addCriterion("messagesid =", value, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidNotEqualTo(Long value) {
            addCriterion("messagesid <>", value, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidGreaterThan(Long value) {
            addCriterion("messagesid >", value, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidGreaterThanOrEqualTo(Long value) {
            addCriterion("messagesid >=", value, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidLessThan(Long value) {
            addCriterion("messagesid <", value, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidLessThanOrEqualTo(Long value) {
            addCriterion("messagesid <=", value, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidIn(List<Long> values) {
            addCriterion("messagesid in", values, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidNotIn(List<Long> values) {
            addCriterion("messagesid not in", values, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidBetween(Long value1, Long value2) {
            addCriterion("messagesid between", value1, value2, "messagesid");
            return (Criteria) this;
        }

        public Criteria andMessagesidNotBetween(Long value1, Long value2) {
            addCriterion("messagesid not between", value1, value2, "messagesid");
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

        public Criteria andFollowUseridIsNull() {
            addCriterion("followUserid is null");
            return (Criteria) this;
        }

        public Criteria andFollowUseridIsNotNull() {
            addCriterion("followUserid is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUseridEqualTo(Long value) {
            addCriterion("followUserid =", value, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridNotEqualTo(Long value) {
            addCriterion("followUserid <>", value, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridGreaterThan(Long value) {
            addCriterion("followUserid >", value, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("followUserid >=", value, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridLessThan(Long value) {
            addCriterion("followUserid <", value, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridLessThanOrEqualTo(Long value) {
            addCriterion("followUserid <=", value, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridIn(List<Long> values) {
            addCriterion("followUserid in", values, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridNotIn(List<Long> values) {
            addCriterion("followUserid not in", values, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridBetween(Long value1, Long value2) {
            addCriterion("followUserid between", value1, value2, "followUserid");
            return (Criteria) this;
        }

        public Criteria andFollowUseridNotBetween(Long value1, Long value2) {
            addCriterion("followUserid not between", value1, value2, "followUserid");
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

        public Criteria andReplyIsNull() {
            addCriterion("reply is null");
            return (Criteria) this;
        }

        public Criteria andReplyIsNotNull() {
            addCriterion("reply is not null");
            return (Criteria) this;
        }

        public Criteria andReplyEqualTo(String value) {
            addCriterion("reply =", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotEqualTo(String value) {
            addCriterion("reply <>", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThan(String value) {
            addCriterion("reply >", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThanOrEqualTo(String value) {
            addCriterion("reply >=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThan(String value) {
            addCriterion("reply <", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThanOrEqualTo(String value) {
            addCriterion("reply <=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLike(String value) {
            addCriterion("reply like", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotLike(String value) {
            addCriterion("reply not like", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyIn(List<String> values) {
            addCriterion("reply in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotIn(List<String> values) {
            addCriterion("reply not in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyBetween(String value1, String value2) {
            addCriterion("reply between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotBetween(String value1, String value2) {
            addCriterion("reply not between", value1, value2, "reply");
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