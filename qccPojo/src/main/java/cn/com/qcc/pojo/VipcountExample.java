package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VipcountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VipcountExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
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

        public Criteria andIs_vipIsNull() {
            addCriterion("is_vip is null");
            return (Criteria) this;
        }

        public Criteria andIs_vipIsNotNull() {
            addCriterion("is_vip is not null");
            return (Criteria) this;
        }

        public Criteria andIs_vipEqualTo(Integer value) {
            addCriterion("is_vip =", value, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipNotEqualTo(Integer value) {
            addCriterion("is_vip <>", value, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipGreaterThan(Integer value) {
            addCriterion("is_vip >", value, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_vip >=", value, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipLessThan(Integer value) {
            addCriterion("is_vip <", value, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipLessThanOrEqualTo(Integer value) {
            addCriterion("is_vip <=", value, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipIn(List<Integer> values) {
            addCriterion("is_vip in", values, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipNotIn(List<Integer> values) {
            addCriterion("is_vip not in", values, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipBetween(Integer value1, Integer value2) {
            addCriterion("is_vip between", value1, value2, "is_vip");
            return (Criteria) this;
        }

        public Criteria andIs_vipNotBetween(Integer value1, Integer value2) {
            addCriterion("is_vip not between", value1, value2, "is_vip");
            return (Criteria) this;
        }

        public Criteria andCretime_timeIsNull() {
            addCriterion("cretime_time is null");
            return (Criteria) this;
        }

        public Criteria andCretime_timeIsNotNull() {
            addCriterion("cretime_time is not null");
            return (Criteria) this;
        }

        public Criteria andCretime_timeEqualTo(Date value) {
            addCriterion("cretime_time =", value, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeNotEqualTo(Date value) {
            addCriterion("cretime_time <>", value, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeGreaterThan(Date value) {
            addCriterion("cretime_time >", value, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("cretime_time >=", value, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeLessThan(Date value) {
            addCriterion("cretime_time <", value, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeLessThanOrEqualTo(Date value) {
            addCriterion("cretime_time <=", value, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeIn(List<Date> values) {
            addCriterion("cretime_time in", values, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeNotIn(List<Date> values) {
            addCriterion("cretime_time not in", values, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeBetween(Date value1, Date value2) {
            addCriterion("cretime_time between", value1, value2, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andCretime_timeNotBetween(Date value1, Date value2) {
            addCriterion("cretime_time not between", value1, value2, "cretime_time");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Double value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Double value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Double value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Double value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Double value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Double> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Double> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Double value1, Double value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Double value1, Double value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(Double value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(Double value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(Double value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(Double value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(Double value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(Double value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<Double> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<Double> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(Double value1, Double value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(Double value1, Double value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountIsNull() {
            addCriterion("weixinaccount is null");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountIsNotNull() {
            addCriterion("weixinaccount is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountEqualTo(String value) {
            addCriterion("weixinaccount =", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountNotEqualTo(String value) {
            addCriterion("weixinaccount <>", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountGreaterThan(String value) {
            addCriterion("weixinaccount >", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountGreaterThanOrEqualTo(String value) {
            addCriterion("weixinaccount >=", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountLessThan(String value) {
            addCriterion("weixinaccount <", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountLessThanOrEqualTo(String value) {
            addCriterion("weixinaccount <=", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountLike(String value) {
            addCriterion("weixinaccount like", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountNotLike(String value) {
            addCriterion("weixinaccount not like", value, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountIn(List<String> values) {
            addCriterion("weixinaccount in", values, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountNotIn(List<String> values) {
            addCriterion("weixinaccount not in", values, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountBetween(String value1, String value2) {
            addCriterion("weixinaccount between", value1, value2, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinaccountNotBetween(String value1, String value2) {
            addCriterion("weixinaccount not between", value1, value2, "weixinaccount");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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