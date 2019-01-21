package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HousepersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HousepersionExample() {
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

        public Criteria andHousepersionidIsNull() {
            addCriterion("housepersionid is null");
            return (Criteria) this;
        }

        public Criteria andHousepersionidIsNotNull() {
            addCriterion("housepersionid is not null");
            return (Criteria) this;
        }

        public Criteria andHousepersionidEqualTo(Long value) {
            addCriterion("housepersionid =", value, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidNotEqualTo(Long value) {
            addCriterion("housepersionid <>", value, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidGreaterThan(Long value) {
            addCriterion("housepersionid >", value, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidGreaterThanOrEqualTo(Long value) {
            addCriterion("housepersionid >=", value, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidLessThan(Long value) {
            addCriterion("housepersionid <", value, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidLessThanOrEqualTo(Long value) {
            addCriterion("housepersionid <=", value, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidIn(List<Long> values) {
            addCriterion("housepersionid in", values, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidNotIn(List<Long> values) {
            addCriterion("housepersionid not in", values, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidBetween(Long value1, Long value2) {
            addCriterion("housepersionid between", value1, value2, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andHousepersionidNotBetween(Long value1, Long value2) {
            addCriterion("housepersionid not between", value1, value2, "housepersionid");
            return (Criteria) this;
        }

        public Criteria andUsercentnumIsNull() {
            addCriterion("usercentnum is null");
            return (Criteria) this;
        }

        public Criteria andUsercentnumIsNotNull() {
            addCriterion("usercentnum is not null");
            return (Criteria) this;
        }

        public Criteria andUsercentnumEqualTo(String value) {
            addCriterion("usercentnum =", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumNotEqualTo(String value) {
            addCriterion("usercentnum <>", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumGreaterThan(String value) {
            addCriterion("usercentnum >", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumGreaterThanOrEqualTo(String value) {
            addCriterion("usercentnum >=", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumLessThan(String value) {
            addCriterion("usercentnum <", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumLessThanOrEqualTo(String value) {
            addCriterion("usercentnum <=", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumLike(String value) {
            addCriterion("usercentnum like", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumNotLike(String value) {
            addCriterion("usercentnum not like", value, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumIn(List<String> values) {
            addCriterion("usercentnum in", values, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumNotIn(List<String> values) {
            addCriterion("usercentnum not in", values, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumBetween(String value1, String value2) {
            addCriterion("usercentnum between", value1, value2, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andUsercentnumNotBetween(String value1, String value2) {
            addCriterion("usercentnum not between", value1, value2, "usercentnum");
            return (Criteria) this;
        }

        public Criteria andCentstateIsNull() {
            addCriterion("centstate is null");
            return (Criteria) this;
        }

        public Criteria andCentstateIsNotNull() {
            addCriterion("centstate is not null");
            return (Criteria) this;
        }

        public Criteria andCentstateEqualTo(Integer value) {
            addCriterion("centstate =", value, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateNotEqualTo(Integer value) {
            addCriterion("centstate <>", value, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateGreaterThan(Integer value) {
            addCriterion("centstate >", value, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("centstate >=", value, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateLessThan(Integer value) {
            addCriterion("centstate <", value, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateLessThanOrEqualTo(Integer value) {
            addCriterion("centstate <=", value, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateIn(List<Integer> values) {
            addCriterion("centstate in", values, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateNotIn(List<Integer> values) {
            addCriterion("centstate not in", values, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateBetween(Integer value1, Integer value2) {
            addCriterion("centstate between", value1, value2, "centstate");
            return (Criteria) this;
        }

        public Criteria andCentstateNotBetween(Integer value1, Integer value2) {
            addCriterion("centstate not between", value1, value2, "centstate");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andPicturesIsNull() {
            addCriterion("pictures is null");
            return (Criteria) this;
        }

        public Criteria andPicturesIsNotNull() {
            addCriterion("pictures is not null");
            return (Criteria) this;
        }

        public Criteria andPicturesEqualTo(String value) {
            addCriterion("pictures =", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotEqualTo(String value) {
            addCriterion("pictures <>", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesGreaterThan(String value) {
            addCriterion("pictures >", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesGreaterThanOrEqualTo(String value) {
            addCriterion("pictures >=", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesLessThan(String value) {
            addCriterion("pictures <", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesLessThanOrEqualTo(String value) {
            addCriterion("pictures <=", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesLike(String value) {
            addCriterion("pictures like", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotLike(String value) {
            addCriterion("pictures not like", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesIn(List<String> values) {
            addCriterion("pictures in", values, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotIn(List<String> values) {
            addCriterion("pictures not in", values, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesBetween(String value1, String value2) {
            addCriterion("pictures between", value1, value2, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotBetween(String value1, String value2) {
            addCriterion("pictures not between", value1, value2, "pictures");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNull() {
            addCriterion("cardtype is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("cardtype is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(String value) {
            addCriterion("cardtype =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(String value) {
            addCriterion("cardtype <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(String value) {
            addCriterion("cardtype >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("cardtype >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(String value) {
            addCriterion("cardtype <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(String value) {
            addCriterion("cardtype <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLike(String value) {
            addCriterion("cardtype like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotLike(String value) {
            addCriterion("cardtype not like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<String> values) {
            addCriterion("cardtype in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<String> values) {
            addCriterion("cardtype not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(String value1, String value2) {
            addCriterion("cardtype between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(String value1, String value2) {
            addCriterion("cardtype not between", value1, value2, "cardtype");
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

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeIsNull() {
            addCriterion("idcardstart_time is null");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeIsNotNull() {
            addCriterion("idcardstart_time is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeEqualTo(Date value) {
            addCriterion("idcardstart_time =", value, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeNotEqualTo(Date value) {
            addCriterion("idcardstart_time <>", value, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeGreaterThan(Date value) {
            addCriterion("idcardstart_time >", value, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("idcardstart_time >=", value, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeLessThan(Date value) {
            addCriterion("idcardstart_time <", value, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeLessThanOrEqualTo(Date value) {
            addCriterion("idcardstart_time <=", value, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeIn(List<Date> values) {
            addCriterion("idcardstart_time in", values, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeNotIn(List<Date> values) {
            addCriterion("idcardstart_time not in", values, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeBetween(Date value1, Date value2) {
            addCriterion("idcardstart_time between", value1, value2, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardstart_timeNotBetween(Date value1, Date value2) {
            addCriterion("idcardstart_time not between", value1, value2, "idcardstart_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeIsNull() {
            addCriterion("idcardend_time is null");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeIsNotNull() {
            addCriterion("idcardend_time is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeEqualTo(Date value) {
            addCriterion("idcardend_time =", value, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeNotEqualTo(Date value) {
            addCriterion("idcardend_time <>", value, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeGreaterThan(Date value) {
            addCriterion("idcardend_time >", value, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("idcardend_time >=", value, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeLessThan(Date value) {
            addCriterion("idcardend_time <", value, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeLessThanOrEqualTo(Date value) {
            addCriterion("idcardend_time <=", value, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeIn(List<Date> values) {
            addCriterion("idcardend_time in", values, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeNotIn(List<Date> values) {
            addCriterion("idcardend_time not in", values, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeBetween(Date value1, Date value2) {
            addCriterion("idcardend_time between", value1, value2, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andIdcardend_timeNotBetween(Date value1, Date value2) {
            addCriterion("idcardend_time not between", value1, value2, "idcardend_time");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andLoveIsNull() {
            addCriterion("love is null");
            return (Criteria) this;
        }

        public Criteria andLoveIsNotNull() {
            addCriterion("love is not null");
            return (Criteria) this;
        }

        public Criteria andLoveEqualTo(String value) {
            addCriterion("love =", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveNotEqualTo(String value) {
            addCriterion("love <>", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveGreaterThan(String value) {
            addCriterion("love >", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveGreaterThanOrEqualTo(String value) {
            addCriterion("love >=", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveLessThan(String value) {
            addCriterion("love <", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveLessThanOrEqualTo(String value) {
            addCriterion("love <=", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveLike(String value) {
            addCriterion("love like", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveNotLike(String value) {
            addCriterion("love not like", value, "love");
            return (Criteria) this;
        }

        public Criteria andLoveIn(List<String> values) {
            addCriterion("love in", values, "love");
            return (Criteria) this;
        }

        public Criteria andLoveNotIn(List<String> values) {
            addCriterion("love not in", values, "love");
            return (Criteria) this;
        }

        public Criteria andLoveBetween(String value1, String value2) {
            addCriterion("love between", value1, value2, "love");
            return (Criteria) this;
        }

        public Criteria andLoveNotBetween(String value1, String value2) {
            addCriterion("love not between", value1, value2, "love");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andXingzuoIsNull() {
            addCriterion("xingzuo is null");
            return (Criteria) this;
        }

        public Criteria andXingzuoIsNotNull() {
            addCriterion("xingzuo is not null");
            return (Criteria) this;
        }

        public Criteria andXingzuoEqualTo(String value) {
            addCriterion("xingzuo =", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotEqualTo(String value) {
            addCriterion("xingzuo <>", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoGreaterThan(String value) {
            addCriterion("xingzuo >", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoGreaterThanOrEqualTo(String value) {
            addCriterion("xingzuo >=", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoLessThan(String value) {
            addCriterion("xingzuo <", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoLessThanOrEqualTo(String value) {
            addCriterion("xingzuo <=", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoLike(String value) {
            addCriterion("xingzuo like", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotLike(String value) {
            addCriterion("xingzuo not like", value, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoIn(List<String> values) {
            addCriterion("xingzuo in", values, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotIn(List<String> values) {
            addCriterion("xingzuo not in", values, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoBetween(String value1, String value2) {
            addCriterion("xingzuo between", value1, value2, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andXingzuoNotBetween(String value1, String value2) {
            addCriterion("xingzuo not between", value1, value2, "xingzuo");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andHujiIsNull() {
            addCriterion("huji is null");
            return (Criteria) this;
        }

        public Criteria andHujiIsNotNull() {
            addCriterion("huji is not null");
            return (Criteria) this;
        }

        public Criteria andHujiEqualTo(String value) {
            addCriterion("huji =", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotEqualTo(String value) {
            addCriterion("huji <>", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiGreaterThan(String value) {
            addCriterion("huji >", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiGreaterThanOrEqualTo(String value) {
            addCriterion("huji >=", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiLessThan(String value) {
            addCriterion("huji <", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiLessThanOrEqualTo(String value) {
            addCriterion("huji <=", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiLike(String value) {
            addCriterion("huji like", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotLike(String value) {
            addCriterion("huji not like", value, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiIn(List<String> values) {
            addCriterion("huji in", values, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotIn(List<String> values) {
            addCriterion("huji not in", values, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiBetween(String value1, String value2) {
            addCriterion("huji between", value1, value2, "huji");
            return (Criteria) this;
        }

        public Criteria andHujiNotBetween(String value1, String value2) {
            addCriterion("huji not between", value1, value2, "huji");
            return (Criteria) this;
        }

        public Criteria andXueliIsNull() {
            addCriterion("xueli is null");
            return (Criteria) this;
        }

        public Criteria andXueliIsNotNull() {
            addCriterion("xueli is not null");
            return (Criteria) this;
        }

        public Criteria andXueliEqualTo(String value) {
            addCriterion("xueli =", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotEqualTo(String value) {
            addCriterion("xueli <>", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliGreaterThan(String value) {
            addCriterion("xueli >", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliGreaterThanOrEqualTo(String value) {
            addCriterion("xueli >=", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLessThan(String value) {
            addCriterion("xueli <", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLessThanOrEqualTo(String value) {
            addCriterion("xueli <=", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLike(String value) {
            addCriterion("xueli like", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotLike(String value) {
            addCriterion("xueli not like", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliIn(List<String> values) {
            addCriterion("xueli in", values, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotIn(List<String> values) {
            addCriterion("xueli not in", values, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliBetween(String value1, String value2) {
            addCriterion("xueli between", value1, value2, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotBetween(String value1, String value2) {
            addCriterion("xueli not between", value1, value2, "xueli");
            return (Criteria) this;
        }

        public Criteria andJinjilannameIsNull() {
            addCriterion("jinjilanname is null");
            return (Criteria) this;
        }

        public Criteria andJinjilannameIsNotNull() {
            addCriterion("jinjilanname is not null");
            return (Criteria) this;
        }

        public Criteria andJinjilannameEqualTo(String value) {
            addCriterion("jinjilanname =", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameNotEqualTo(String value) {
            addCriterion("jinjilanname <>", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameGreaterThan(String value) {
            addCriterion("jinjilanname >", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameGreaterThanOrEqualTo(String value) {
            addCriterion("jinjilanname >=", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameLessThan(String value) {
            addCriterion("jinjilanname <", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameLessThanOrEqualTo(String value) {
            addCriterion("jinjilanname <=", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameLike(String value) {
            addCriterion("jinjilanname like", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameNotLike(String value) {
            addCriterion("jinjilanname not like", value, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameIn(List<String> values) {
            addCriterion("jinjilanname in", values, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameNotIn(List<String> values) {
            addCriterion("jinjilanname not in", values, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameBetween(String value1, String value2) {
            addCriterion("jinjilanname between", value1, value2, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andJinjilannameNotBetween(String value1, String value2) {
            addCriterion("jinjilanname not between", value1, value2, "jinjilanname");
            return (Criteria) this;
        }

        public Criteria andGuanxiIsNull() {
            addCriterion("guanxi is null");
            return (Criteria) this;
        }

        public Criteria andGuanxiIsNotNull() {
            addCriterion("guanxi is not null");
            return (Criteria) this;
        }

        public Criteria andGuanxiEqualTo(String value) {
            addCriterion("guanxi =", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiNotEqualTo(String value) {
            addCriterion("guanxi <>", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiGreaterThan(String value) {
            addCriterion("guanxi >", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiGreaterThanOrEqualTo(String value) {
            addCriterion("guanxi >=", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiLessThan(String value) {
            addCriterion("guanxi <", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiLessThanOrEqualTo(String value) {
            addCriterion("guanxi <=", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiLike(String value) {
            addCriterion("guanxi like", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiNotLike(String value) {
            addCriterion("guanxi not like", value, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiIn(List<String> values) {
            addCriterion("guanxi in", values, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiNotIn(List<String> values) {
            addCriterion("guanxi not in", values, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiBetween(String value1, String value2) {
            addCriterion("guanxi between", value1, value2, "guanxi");
            return (Criteria) this;
        }

        public Criteria andGuanxiNotBetween(String value1, String value2) {
            addCriterion("guanxi not between", value1, value2, "guanxi");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneIsNull() {
            addCriterion("jinjitelephone is null");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneIsNotNull() {
            addCriterion("jinjitelephone is not null");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneEqualTo(String value) {
            addCriterion("jinjitelephone =", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneNotEqualTo(String value) {
            addCriterion("jinjitelephone <>", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneGreaterThan(String value) {
            addCriterion("jinjitelephone >", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("jinjitelephone >=", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneLessThan(String value) {
            addCriterion("jinjitelephone <", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneLessThanOrEqualTo(String value) {
            addCriterion("jinjitelephone <=", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneLike(String value) {
            addCriterion("jinjitelephone like", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneNotLike(String value) {
            addCriterion("jinjitelephone not like", value, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneIn(List<String> values) {
            addCriterion("jinjitelephone in", values, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneNotIn(List<String> values) {
            addCriterion("jinjitelephone not in", values, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneBetween(String value1, String value2) {
            addCriterion("jinjitelephone between", value1, value2, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andJinjitelephoneNotBetween(String value1, String value2) {
            addCriterion("jinjitelephone not between", value1, value2, "jinjitelephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
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