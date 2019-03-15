package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HousepaydetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HousepaydetailExample() {
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

        public Criteria andOrdernumIsNull() {
            addCriterion("ordernum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("ordernum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("ordernum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("ordernum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("ordernum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("ordernum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("ordernum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("ordernum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("ordernum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("ordernum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("ordernum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("ordernum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("ordernum not between", value1, value2, "ordernum");
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

        public Criteria andTotalpricesIsNull() {
            addCriterion("totalprices is null");
            return (Criteria) this;
        }

        public Criteria andTotalpricesIsNotNull() {
            addCriterion("totalprices is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpricesEqualTo(Double value) {
            addCriterion("totalprices =", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesNotEqualTo(Double value) {
            addCriterion("totalprices <>", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesGreaterThan(Double value) {
            addCriterion("totalprices >", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesGreaterThanOrEqualTo(Double value) {
            addCriterion("totalprices >=", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesLessThan(Double value) {
            addCriterion("totalprices <", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesLessThanOrEqualTo(Double value) {
            addCriterion("totalprices <=", value, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesIn(List<Double> values) {
            addCriterion("totalprices in", values, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesNotIn(List<Double> values) {
            addCriterion("totalprices not in", values, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesBetween(Double value1, Double value2) {
            addCriterion("totalprices between", value1, value2, "totalprices");
            return (Criteria) this;
        }

        public Criteria andTotalpricesNotBetween(Double value1, Double value2) {
            addCriterion("totalprices not between", value1, value2, "totalprices");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("paytime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("paytime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("paytime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("paytime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("paytime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paytime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("paytime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("paytime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("paytime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("paytime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("paytime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("paytime not between", value1, value2, "paytime");
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

        public Criteria andManageruseridIsNull() {
            addCriterion("manageruserid is null");
            return (Criteria) this;
        }

        public Criteria andManageruseridIsNotNull() {
            addCriterion("manageruserid is not null");
            return (Criteria) this;
        }

        public Criteria andManageruseridEqualTo(Long value) {
            addCriterion("manageruserid =", value, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridNotEqualTo(Long value) {
            addCriterion("manageruserid <>", value, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridGreaterThan(Long value) {
            addCriterion("manageruserid >", value, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridGreaterThanOrEqualTo(Long value) {
            addCriterion("manageruserid >=", value, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridLessThan(Long value) {
            addCriterion("manageruserid <", value, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridLessThanOrEqualTo(Long value) {
            addCriterion("manageruserid <=", value, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridIn(List<Long> values) {
            addCriterion("manageruserid in", values, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridNotIn(List<Long> values) {
            addCriterion("manageruserid not in", values, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridBetween(Long value1, Long value2) {
            addCriterion("manageruserid between", value1, value2, "manageruserid");
            return (Criteria) this;
        }

        public Criteria andManageruseridNotBetween(Long value1, Long value2) {
            addCriterion("manageruserid not between", value1, value2, "manageruserid");
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

        public Criteria andPayuserphoneIsNull() {
            addCriterion("payuserphone is null");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneIsNotNull() {
            addCriterion("payuserphone is not null");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneEqualTo(String value) {
            addCriterion("payuserphone =", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneNotEqualTo(String value) {
            addCriterion("payuserphone <>", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneGreaterThan(String value) {
            addCriterion("payuserphone >", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("payuserphone >=", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneLessThan(String value) {
            addCriterion("payuserphone <", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneLessThanOrEqualTo(String value) {
            addCriterion("payuserphone <=", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneLike(String value) {
            addCriterion("payuserphone like", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneNotLike(String value) {
            addCriterion("payuserphone not like", value, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneIn(List<String> values) {
            addCriterion("payuserphone in", values, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneNotIn(List<String> values) {
            addCriterion("payuserphone not in", values, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneBetween(String value1, String value2) {
            addCriterion("payuserphone between", value1, value2, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andPayuserphoneNotBetween(String value1, String value2) {
            addCriterion("payuserphone not between", value1, value2, "payuserphone");
            return (Criteria) this;
        }

        public Criteria andDetailcontentIsNull() {
            addCriterion("detailcontent is null");
            return (Criteria) this;
        }

        public Criteria andDetailcontentIsNotNull() {
            addCriterion("detailcontent is not null");
            return (Criteria) this;
        }

        public Criteria andDetailcontentEqualTo(String value) {
            addCriterion("detailcontent =", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentNotEqualTo(String value) {
            addCriterion("detailcontent <>", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentGreaterThan(String value) {
            addCriterion("detailcontent >", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentGreaterThanOrEqualTo(String value) {
            addCriterion("detailcontent >=", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentLessThan(String value) {
            addCriterion("detailcontent <", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentLessThanOrEqualTo(String value) {
            addCriterion("detailcontent <=", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentLike(String value) {
            addCriterion("detailcontent like", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentNotLike(String value) {
            addCriterion("detailcontent not like", value, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentIn(List<String> values) {
            addCriterion("detailcontent in", values, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentNotIn(List<String> values) {
            addCriterion("detailcontent not in", values, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentBetween(String value1, String value2) {
            addCriterion("detailcontent between", value1, value2, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andDetailcontentNotBetween(String value1, String value2) {
            addCriterion("detailcontent not between", value1, value2, "detailcontent");
            return (Criteria) this;
        }

        public Criteria andHousenumIsNull() {
            addCriterion("housenum is null");
            return (Criteria) this;
        }

        public Criteria andHousenumIsNotNull() {
            addCriterion("housenum is not null");
            return (Criteria) this;
        }

        public Criteria andHousenumEqualTo(String value) {
            addCriterion("housenum =", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotEqualTo(String value) {
            addCriterion("housenum <>", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumGreaterThan(String value) {
            addCriterion("housenum >", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumGreaterThanOrEqualTo(String value) {
            addCriterion("housenum >=", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumLessThan(String value) {
            addCriterion("housenum <", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumLessThanOrEqualTo(String value) {
            addCriterion("housenum <=", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumLike(String value) {
            addCriterion("housenum like", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotLike(String value) {
            addCriterion("housenum not like", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumIn(List<String> values) {
            addCriterion("housenum in", values, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotIn(List<String> values) {
            addCriterion("housenum not in", values, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumBetween(String value1, String value2) {
            addCriterion("housenum between", value1, value2, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotBetween(String value1, String value2) {
            addCriterion("housenum not between", value1, value2, "housenum");
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