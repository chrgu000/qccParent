package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HouseorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseorderExample() {
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

        public Criteria andHouseorderidIsNull() {
            addCriterion("houseorderid is null");
            return (Criteria) this;
        }

        public Criteria andHouseorderidIsNotNull() {
            addCriterion("houseorderid is not null");
            return (Criteria) this;
        }

        public Criteria andHouseorderidEqualTo(Long value) {
            addCriterion("houseorderid =", value, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidNotEqualTo(Long value) {
            addCriterion("houseorderid <>", value, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidGreaterThan(Long value) {
            addCriterion("houseorderid >", value, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidGreaterThanOrEqualTo(Long value) {
            addCriterion("houseorderid >=", value, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidLessThan(Long value) {
            addCriterion("houseorderid <", value, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidLessThanOrEqualTo(Long value) {
            addCriterion("houseorderid <=", value, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidIn(List<Long> values) {
            addCriterion("houseorderid in", values, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidNotIn(List<Long> values) {
            addCriterion("houseorderid not in", values, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidBetween(Long value1, Long value2) {
            addCriterion("houseorderid between", value1, value2, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andHouseorderidNotBetween(Long value1, Long value2) {
            addCriterion("houseorderid not between", value1, value2, "houseorderid");
            return (Criteria) this;
        }

        public Criteria andBarginidIsNull() {
            addCriterion("barginid is null");
            return (Criteria) this;
        }

        public Criteria andBarginidIsNotNull() {
            addCriterion("barginid is not null");
            return (Criteria) this;
        }

        public Criteria andBarginidEqualTo(Long value) {
            addCriterion("barginid =", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidNotEqualTo(Long value) {
            addCriterion("barginid <>", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidGreaterThan(Long value) {
            addCriterion("barginid >", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidGreaterThanOrEqualTo(Long value) {
            addCriterion("barginid >=", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidLessThan(Long value) {
            addCriterion("barginid <", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidLessThanOrEqualTo(Long value) {
            addCriterion("barginid <=", value, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidIn(List<Long> values) {
            addCriterion("barginid in", values, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidNotIn(List<Long> values) {
            addCriterion("barginid not in", values, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidBetween(Long value1, Long value2) {
            addCriterion("barginid between", value1, value2, "barginid");
            return (Criteria) this;
        }

        public Criteria andBarginidNotBetween(Long value1, Long value2) {
            addCriterion("barginid not between", value1, value2, "barginid");
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

        public Criteria andReservationsIsNull() {
            addCriterion("reservations is null");
            return (Criteria) this;
        }

        public Criteria andReservationsIsNotNull() {
            addCriterion("reservations is not null");
            return (Criteria) this;
        }

        public Criteria andReservationsEqualTo(String value) {
            addCriterion("reservations =", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsNotEqualTo(String value) {
            addCriterion("reservations <>", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsGreaterThan(String value) {
            addCriterion("reservations >", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsGreaterThanOrEqualTo(String value) {
            addCriterion("reservations >=", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsLessThan(String value) {
            addCriterion("reservations <", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsLessThanOrEqualTo(String value) {
            addCriterion("reservations <=", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsLike(String value) {
            addCriterion("reservations like", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsNotLike(String value) {
            addCriterion("reservations not like", value, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsIn(List<String> values) {
            addCriterion("reservations in", values, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsNotIn(List<String> values) {
            addCriterion("reservations not in", values, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsBetween(String value1, String value2) {
            addCriterion("reservations between", value1, value2, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationsNotBetween(String value1, String value2) {
            addCriterion("reservations not between", value1, value2, "reservations");
            return (Criteria) this;
        }

        public Criteria andReservationstelIsNull() {
            addCriterion("reservationstel is null");
            return (Criteria) this;
        }

        public Criteria andReservationstelIsNotNull() {
            addCriterion("reservationstel is not null");
            return (Criteria) this;
        }

        public Criteria andReservationstelEqualTo(String value) {
            addCriterion("reservationstel =", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelNotEqualTo(String value) {
            addCriterion("reservationstel <>", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelGreaterThan(String value) {
            addCriterion("reservationstel >", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelGreaterThanOrEqualTo(String value) {
            addCriterion("reservationstel >=", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelLessThan(String value) {
            addCriterion("reservationstel <", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelLessThanOrEqualTo(String value) {
            addCriterion("reservationstel <=", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelLike(String value) {
            addCriterion("reservationstel like", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelNotLike(String value) {
            addCriterion("reservationstel not like", value, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelIn(List<String> values) {
            addCriterion("reservationstel in", values, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelNotIn(List<String> values) {
            addCriterion("reservationstel not in", values, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelBetween(String value1, String value2) {
            addCriterion("reservationstel between", value1, value2, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andReservationstelNotBetween(String value1, String value2) {
            addCriterion("reservationstel not between", value1, value2, "reservationstel");
            return (Criteria) this;
        }

        public Criteria andMesageIsNull() {
            addCriterion("mesage is null");
            return (Criteria) this;
        }

        public Criteria andMesageIsNotNull() {
            addCriterion("mesage is not null");
            return (Criteria) this;
        }

        public Criteria andMesageEqualTo(String value) {
            addCriterion("mesage =", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageNotEqualTo(String value) {
            addCriterion("mesage <>", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageGreaterThan(String value) {
            addCriterion("mesage >", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageGreaterThanOrEqualTo(String value) {
            addCriterion("mesage >=", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageLessThan(String value) {
            addCriterion("mesage <", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageLessThanOrEqualTo(String value) {
            addCriterion("mesage <=", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageLike(String value) {
            addCriterion("mesage like", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageNotLike(String value) {
            addCriterion("mesage not like", value, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageIn(List<String> values) {
            addCriterion("mesage in", values, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageNotIn(List<String> values) {
            addCriterion("mesage not in", values, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageBetween(String value1, String value2) {
            addCriterion("mesage between", value1, value2, "mesage");
            return (Criteria) this;
        }

        public Criteria andMesageNotBetween(String value1, String value2) {
            addCriterion("mesage not between", value1, value2, "mesage");
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

        public Criteria andPaystateIsNull() {
            addCriterion("paystate is null");
            return (Criteria) this;
        }

        public Criteria andPaystateIsNotNull() {
            addCriterion("paystate is not null");
            return (Criteria) this;
        }

        public Criteria andPaystateEqualTo(Integer value) {
            addCriterion("paystate =", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotEqualTo(Integer value) {
            addCriterion("paystate <>", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThan(Integer value) {
            addCriterion("paystate >", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("paystate >=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThan(Integer value) {
            addCriterion("paystate <", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateLessThanOrEqualTo(Integer value) {
            addCriterion("paystate <=", value, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateIn(List<Integer> values) {
            addCriterion("paystate in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotIn(List<Integer> values) {
            addCriterion("paystate not in", values, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateBetween(Integer value1, Integer value2) {
            addCriterion("paystate between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andPaystateNotBetween(Integer value1, Integer value2) {
            addCriterion("paystate not between", value1, value2, "paystate");
            return (Criteria) this;
        }

        public Criteria andRefundmessIsNull() {
            addCriterion("refundmess is null");
            return (Criteria) this;
        }

        public Criteria andRefundmessIsNotNull() {
            addCriterion("refundmess is not null");
            return (Criteria) this;
        }

        public Criteria andRefundmessEqualTo(String value) {
            addCriterion("refundmess =", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessNotEqualTo(String value) {
            addCriterion("refundmess <>", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessGreaterThan(String value) {
            addCriterion("refundmess >", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessGreaterThanOrEqualTo(String value) {
            addCriterion("refundmess >=", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessLessThan(String value) {
            addCriterion("refundmess <", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessLessThanOrEqualTo(String value) {
            addCriterion("refundmess <=", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessLike(String value) {
            addCriterion("refundmess like", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessNotLike(String value) {
            addCriterion("refundmess not like", value, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessIn(List<String> values) {
            addCriterion("refundmess in", values, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessNotIn(List<String> values) {
            addCriterion("refundmess not in", values, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessBetween(String value1, String value2) {
            addCriterion("refundmess between", value1, value2, "refundmess");
            return (Criteria) this;
        }

        public Criteria andRefundmessNotBetween(String value1, String value2) {
            addCriterion("refundmess not between", value1, value2, "refundmess");
            return (Criteria) this;
        }

        public Criteria andWeixinorderIsNull() {
            addCriterion("weixinorder is null");
            return (Criteria) this;
        }

        public Criteria andWeixinorderIsNotNull() {
            addCriterion("weixinorder is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinorderEqualTo(String value) {
            addCriterion("weixinorder =", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderNotEqualTo(String value) {
            addCriterion("weixinorder <>", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderGreaterThan(String value) {
            addCriterion("weixinorder >", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderGreaterThanOrEqualTo(String value) {
            addCriterion("weixinorder >=", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderLessThan(String value) {
            addCriterion("weixinorder <", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderLessThanOrEqualTo(String value) {
            addCriterion("weixinorder <=", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderLike(String value) {
            addCriterion("weixinorder like", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderNotLike(String value) {
            addCriterion("weixinorder not like", value, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderIn(List<String> values) {
            addCriterion("weixinorder in", values, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderNotIn(List<String> values) {
            addCriterion("weixinorder not in", values, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderBetween(String value1, String value2) {
            addCriterion("weixinorder between", value1, value2, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andWeixinorderNotBetween(String value1, String value2) {
            addCriterion("weixinorder not between", value1, value2, "weixinorder");
            return (Criteria) this;
        }

        public Criteria andBuystateIsNull() {
            addCriterion("buystate is null");
            return (Criteria) this;
        }

        public Criteria andBuystateIsNotNull() {
            addCriterion("buystate is not null");
            return (Criteria) this;
        }

        public Criteria andBuystateEqualTo(Integer value) {
            addCriterion("buystate =", value, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateNotEqualTo(Integer value) {
            addCriterion("buystate <>", value, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateGreaterThan(Integer value) {
            addCriterion("buystate >", value, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("buystate >=", value, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateLessThan(Integer value) {
            addCriterion("buystate <", value, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateLessThanOrEqualTo(Integer value) {
            addCriterion("buystate <=", value, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateIn(List<Integer> values) {
            addCriterion("buystate in", values, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateNotIn(List<Integer> values) {
            addCriterion("buystate not in", values, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateBetween(Integer value1, Integer value2) {
            addCriterion("buystate between", value1, value2, "buystate");
            return (Criteria) this;
        }

        public Criteria andBuystateNotBetween(Integer value1, Integer value2) {
            addCriterion("buystate not between", value1, value2, "buystate");
            return (Criteria) this;
        }

        public Criteria andSallstateIsNull() {
            addCriterion("sallstate is null");
            return (Criteria) this;
        }

        public Criteria andSallstateIsNotNull() {
            addCriterion("sallstate is not null");
            return (Criteria) this;
        }

        public Criteria andSallstateEqualTo(Integer value) {
            addCriterion("sallstate =", value, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateNotEqualTo(Integer value) {
            addCriterion("sallstate <>", value, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateGreaterThan(Integer value) {
            addCriterion("sallstate >", value, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("sallstate >=", value, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateLessThan(Integer value) {
            addCriterion("sallstate <", value, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateLessThanOrEqualTo(Integer value) {
            addCriterion("sallstate <=", value, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateIn(List<Integer> values) {
            addCriterion("sallstate in", values, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateNotIn(List<Integer> values) {
            addCriterion("sallstate not in", values, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateBetween(Integer value1, Integer value2) {
            addCriterion("sallstate between", value1, value2, "sallstate");
            return (Criteria) this;
        }

        public Criteria andSallstateNotBetween(Integer value1, Integer value2) {
            addCriterion("sallstate not between", value1, value2, "sallstate");
            return (Criteria) this;
        }

        public Criteria andDaycountIsNull() {
            addCriterion("daycount is null");
            return (Criteria) this;
        }

        public Criteria andDaycountIsNotNull() {
            addCriterion("daycount is not null");
            return (Criteria) this;
        }

        public Criteria andDaycountEqualTo(Integer value) {
            addCriterion("daycount =", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountNotEqualTo(Integer value) {
            addCriterion("daycount <>", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountGreaterThan(Integer value) {
            addCriterion("daycount >", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("daycount >=", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountLessThan(Integer value) {
            addCriterion("daycount <", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountLessThanOrEqualTo(Integer value) {
            addCriterion("daycount <=", value, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountIn(List<Integer> values) {
            addCriterion("daycount in", values, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountNotIn(List<Integer> values) {
            addCriterion("daycount not in", values, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountBetween(Integer value1, Integer value2) {
            addCriterion("daycount between", value1, value2, "daycount");
            return (Criteria) this;
        }

        public Criteria andDaycountNotBetween(Integer value1, Integer value2) {
            addCriterion("daycount not between", value1, value2, "daycount");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNull() {
            addCriterion("ordertime is null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNotNull() {
            addCriterion("ordertime is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeEqualTo(Date value) {
            addCriterion("ordertime =", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotEqualTo(Date value) {
            addCriterion("ordertime <>", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThan(Date value) {
            addCriterion("ordertime >", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ordertime >=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThan(Date value) {
            addCriterion("ordertime <", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThanOrEqualTo(Date value) {
            addCriterion("ordertime <=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIn(List<Date> values) {
            addCriterion("ordertime in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotIn(List<Date> values) {
            addCriterion("ordertime not in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeBetween(Date value1, Date value2) {
            addCriterion("ordertime between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotBetween(Date value1, Date value2) {
            addCriterion("ordertime not between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
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