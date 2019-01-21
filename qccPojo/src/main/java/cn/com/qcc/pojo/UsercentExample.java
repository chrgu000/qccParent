package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsercentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsercentExample() {
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

        public Criteria andUsercentidIsNull() {
            addCriterion("usercentid is null");
            return (Criteria) this;
        }

        public Criteria andUsercentidIsNotNull() {
            addCriterion("usercentid is not null");
            return (Criteria) this;
        }

        public Criteria andUsercentidEqualTo(Long value) {
            addCriterion("usercentid =", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidNotEqualTo(Long value) {
            addCriterion("usercentid <>", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidGreaterThan(Long value) {
            addCriterion("usercentid >", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidGreaterThanOrEqualTo(Long value) {
            addCriterion("usercentid >=", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidLessThan(Long value) {
            addCriterion("usercentid <", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidLessThanOrEqualTo(Long value) {
            addCriterion("usercentid <=", value, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidIn(List<Long> values) {
            addCriterion("usercentid in", values, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidNotIn(List<Long> values) {
            addCriterion("usercentid not in", values, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidBetween(Long value1, Long value2) {
            addCriterion("usercentid between", value1, value2, "usercentid");
            return (Criteria) this;
        }

        public Criteria andUsercentidNotBetween(Long value1, Long value2) {
            addCriterion("usercentid not between", value1, value2, "usercentid");
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

        public Criteria andCenttimesIsNull() {
            addCriterion("centtimes is null");
            return (Criteria) this;
        }

        public Criteria andCenttimesIsNotNull() {
            addCriterion("centtimes is not null");
            return (Criteria) this;
        }

        public Criteria andCenttimesEqualTo(Integer value) {
            addCriterion("centtimes =", value, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesNotEqualTo(Integer value) {
            addCriterion("centtimes <>", value, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesGreaterThan(Integer value) {
            addCriterion("centtimes >", value, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("centtimes >=", value, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesLessThan(Integer value) {
            addCriterion("centtimes <", value, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesLessThanOrEqualTo(Integer value) {
            addCriterion("centtimes <=", value, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesIn(List<Integer> values) {
            addCriterion("centtimes in", values, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesNotIn(List<Integer> values) {
            addCriterion("centtimes not in", values, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesBetween(Integer value1, Integer value2) {
            addCriterion("centtimes between", value1, value2, "centtimes");
            return (Criteria) this;
        }

        public Criteria andCenttimesNotBetween(Integer value1, Integer value2) {
            addCriterion("centtimes not between", value1, value2, "centtimes");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNull() {
            addCriterion("houseid is null");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNotNull() {
            addCriterion("houseid is not null");
            return (Criteria) this;
        }

        public Criteria andHouseidEqualTo(Long value) {
            addCriterion("houseid =", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotEqualTo(Long value) {
            addCriterion("houseid <>", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThan(Long value) {
            addCriterion("houseid >", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThanOrEqualTo(Long value) {
            addCriterion("houseid >=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThan(Long value) {
            addCriterion("houseid <", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThanOrEqualTo(Long value) {
            addCriterion("houseid <=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidIn(List<Long> values) {
            addCriterion("houseid in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotIn(List<Long> values) {
            addCriterion("houseid not in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidBetween(Long value1, Long value2) {
            addCriterion("houseid between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotBetween(Long value1, Long value2) {
            addCriterion("houseid not between", value1, value2, "houseid");
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

        public Criteria andLanduseridIsNull() {
            addCriterion("landuserid is null");
            return (Criteria) this;
        }

        public Criteria andLanduseridIsNotNull() {
            addCriterion("landuserid is not null");
            return (Criteria) this;
        }

        public Criteria andLanduseridEqualTo(Long value) {
            addCriterion("landuserid =", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridNotEqualTo(Long value) {
            addCriterion("landuserid <>", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridGreaterThan(Long value) {
            addCriterion("landuserid >", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("landuserid >=", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridLessThan(Long value) {
            addCriterion("landuserid <", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridLessThanOrEqualTo(Long value) {
            addCriterion("landuserid <=", value, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridIn(List<Long> values) {
            addCriterion("landuserid in", values, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridNotIn(List<Long> values) {
            addCriterion("landuserid not in", values, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridBetween(Long value1, Long value2) {
            addCriterion("landuserid between", value1, value2, "landuserid");
            return (Criteria) this;
        }

        public Criteria andLanduseridNotBetween(Long value1, Long value2) {
            addCriterion("landuserid not between", value1, value2, "landuserid");
            return (Criteria) this;
        }

        public Criteria andYapricesIsNull() {
            addCriterion("yaprices is null");
            return (Criteria) this;
        }

        public Criteria andYapricesIsNotNull() {
            addCriterion("yaprices is not null");
            return (Criteria) this;
        }

        public Criteria andYapricesEqualTo(Double value) {
            addCriterion("yaprices =", value, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesNotEqualTo(Double value) {
            addCriterion("yaprices <>", value, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesGreaterThan(Double value) {
            addCriterion("yaprices >", value, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesGreaterThanOrEqualTo(Double value) {
            addCriterion("yaprices >=", value, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesLessThan(Double value) {
            addCriterion("yaprices <", value, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesLessThanOrEqualTo(Double value) {
            addCriterion("yaprices <=", value, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesIn(List<Double> values) {
            addCriterion("yaprices in", values, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesNotIn(List<Double> values) {
            addCriterion("yaprices not in", values, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesBetween(Double value1, Double value2) {
            addCriterion("yaprices between", value1, value2, "yaprices");
            return (Criteria) this;
        }

        public Criteria andYapricesNotBetween(Double value1, Double value2) {
            addCriterion("yaprices not between", value1, value2, "yaprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesIsNull() {
            addCriterion("centprices is null");
            return (Criteria) this;
        }

        public Criteria andCentpricesIsNotNull() {
            addCriterion("centprices is not null");
            return (Criteria) this;
        }

        public Criteria andCentpricesEqualTo(Double value) {
            addCriterion("centprices =", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesNotEqualTo(Double value) {
            addCriterion("centprices <>", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesGreaterThan(Double value) {
            addCriterion("centprices >", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesGreaterThanOrEqualTo(Double value) {
            addCriterion("centprices >=", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesLessThan(Double value) {
            addCriterion("centprices <", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesLessThanOrEqualTo(Double value) {
            addCriterion("centprices <=", value, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesIn(List<Double> values) {
            addCriterion("centprices in", values, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesNotIn(List<Double> values) {
            addCriterion("centprices not in", values, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesBetween(Double value1, Double value2) {
            addCriterion("centprices between", value1, value2, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentpricesNotBetween(Double value1, Double value2) {
            addCriterion("centprices not between", value1, value2, "centprices");
            return (Criteria) this;
        }

        public Criteria andCentfromidIsNull() {
            addCriterion("centfromid is null");
            return (Criteria) this;
        }

        public Criteria andCentfromidIsNotNull() {
            addCriterion("centfromid is not null");
            return (Criteria) this;
        }

        public Criteria andCentfromidEqualTo(Long value) {
            addCriterion("centfromid =", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidNotEqualTo(Long value) {
            addCriterion("centfromid <>", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidGreaterThan(Long value) {
            addCriterion("centfromid >", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidGreaterThanOrEqualTo(Long value) {
            addCriterion("centfromid >=", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidLessThan(Long value) {
            addCriterion("centfromid <", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidLessThanOrEqualTo(Long value) {
            addCriterion("centfromid <=", value, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidIn(List<Long> values) {
            addCriterion("centfromid in", values, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidNotIn(List<Long> values) {
            addCriterion("centfromid not in", values, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidBetween(Long value1, Long value2) {
            addCriterion("centfromid between", value1, value2, "centfromid");
            return (Criteria) this;
        }

        public Criteria andCentfromidNotBetween(Long value1, Long value2) {
            addCriterion("centfromid not between", value1, value2, "centfromid");
            return (Criteria) this;
        }

        public Criteria andUsersteteIsNull() {
            addCriterion("userstete is null");
            return (Criteria) this;
        }

        public Criteria andUsersteteIsNotNull() {
            addCriterion("userstete is not null");
            return (Criteria) this;
        }

        public Criteria andUsersteteEqualTo(Integer value) {
            addCriterion("userstete =", value, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteNotEqualTo(Integer value) {
            addCriterion("userstete <>", value, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteGreaterThan(Integer value) {
            addCriterion("userstete >", value, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteGreaterThanOrEqualTo(Integer value) {
            addCriterion("userstete >=", value, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteLessThan(Integer value) {
            addCriterion("userstete <", value, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteLessThanOrEqualTo(Integer value) {
            addCriterion("userstete <=", value, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteIn(List<Integer> values) {
            addCriterion("userstete in", values, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteNotIn(List<Integer> values) {
            addCriterion("userstete not in", values, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteBetween(Integer value1, Integer value2) {
            addCriterion("userstete between", value1, value2, "userstete");
            return (Criteria) this;
        }

        public Criteria andUsersteteNotBetween(Integer value1, Integer value2) {
            addCriterion("userstete not between", value1, value2, "userstete");
            return (Criteria) this;
        }

        public Criteria andOthermoreIsNull() {
            addCriterion("othermore is null");
            return (Criteria) this;
        }

        public Criteria andOthermoreIsNotNull() {
            addCriterion("othermore is not null");
            return (Criteria) this;
        }

        public Criteria andOthermoreEqualTo(String value) {
            addCriterion("othermore =", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreNotEqualTo(String value) {
            addCriterion("othermore <>", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreGreaterThan(String value) {
            addCriterion("othermore >", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreGreaterThanOrEqualTo(String value) {
            addCriterion("othermore >=", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreLessThan(String value) {
            addCriterion("othermore <", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreLessThanOrEqualTo(String value) {
            addCriterion("othermore <=", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreLike(String value) {
            addCriterion("othermore like", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreNotLike(String value) {
            addCriterion("othermore not like", value, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreIn(List<String> values) {
            addCriterion("othermore in", values, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreNotIn(List<String> values) {
            addCriterion("othermore not in", values, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreBetween(String value1, String value2) {
            addCriterion("othermore between", value1, value2, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreNotBetween(String value1, String value2) {
            addCriterion("othermore not between", value1, value2, "othermore");
            return (Criteria) this;
        }

        public Criteria andOthermoreidIsNull() {
            addCriterion("othermoreid is null");
            return (Criteria) this;
        }

        public Criteria andOthermoreidIsNotNull() {
            addCriterion("othermoreid is not null");
            return (Criteria) this;
        }

        public Criteria andOthermoreidEqualTo(String value) {
            addCriterion("othermoreid =", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidNotEqualTo(String value) {
            addCriterion("othermoreid <>", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidGreaterThan(String value) {
            addCriterion("othermoreid >", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidGreaterThanOrEqualTo(String value) {
            addCriterion("othermoreid >=", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidLessThan(String value) {
            addCriterion("othermoreid <", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidLessThanOrEqualTo(String value) {
            addCriterion("othermoreid <=", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidLike(String value) {
            addCriterion("othermoreid like", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidNotLike(String value) {
            addCriterion("othermoreid not like", value, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidIn(List<String> values) {
            addCriterion("othermoreid in", values, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidNotIn(List<String> values) {
            addCriterion("othermoreid not in", values, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidBetween(String value1, String value2) {
            addCriterion("othermoreid between", value1, value2, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andOthermoreidNotBetween(String value1, String value2) {
            addCriterion("othermoreid not between", value1, value2, "othermoreid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidIsNull() {
            addCriterion("paystyleid is null");
            return (Criteria) this;
        }

        public Criteria andPaystyleidIsNotNull() {
            addCriterion("paystyleid is not null");
            return (Criteria) this;
        }

        public Criteria andPaystyleidEqualTo(String value) {
            addCriterion("paystyleid =", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidNotEqualTo(String value) {
            addCriterion("paystyleid <>", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidGreaterThan(String value) {
            addCriterion("paystyleid >", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidGreaterThanOrEqualTo(String value) {
            addCriterion("paystyleid >=", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidLessThan(String value) {
            addCriterion("paystyleid <", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidLessThanOrEqualTo(String value) {
            addCriterion("paystyleid <=", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidLike(String value) {
            addCriterion("paystyleid like", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidNotLike(String value) {
            addCriterion("paystyleid not like", value, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidIn(List<String> values) {
            addCriterion("paystyleid in", values, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidNotIn(List<String> values) {
            addCriterion("paystyleid not in", values, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidBetween(String value1, String value2) {
            addCriterion("paystyleid between", value1, value2, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andPaystyleidNotBetween(String value1, String value2) {
            addCriterion("paystyleid not between", value1, value2, "paystyleid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidIsNull() {
            addCriterion("rentmodalid is null");
            return (Criteria) this;
        }

        public Criteria andRentmodalidIsNotNull() {
            addCriterion("rentmodalid is not null");
            return (Criteria) this;
        }

        public Criteria andRentmodalidEqualTo(Long value) {
            addCriterion("rentmodalid =", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidNotEqualTo(Long value) {
            addCriterion("rentmodalid <>", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidGreaterThan(Long value) {
            addCriterion("rentmodalid >", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidGreaterThanOrEqualTo(Long value) {
            addCriterion("rentmodalid >=", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidLessThan(Long value) {
            addCriterion("rentmodalid <", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidLessThanOrEqualTo(Long value) {
            addCriterion("rentmodalid <=", value, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidIn(List<Long> values) {
            addCriterion("rentmodalid in", values, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidNotIn(List<Long> values) {
            addCriterion("rentmodalid not in", values, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidBetween(Long value1, Long value2) {
            addCriterion("rentmodalid between", value1, value2, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andRentmodalidNotBetween(Long value1, Long value2) {
            addCriterion("rentmodalid not between", value1, value2, "rentmodalid");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_timeEqualTo(Date value) {
            addCriterion("start_time =", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThan(Date value) {
            addCriterion("start_time >", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThan(Date value) {
            addCriterion("start_time <", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIn(List<Date> values) {
            addCriterion("start_time in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "start_time");
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