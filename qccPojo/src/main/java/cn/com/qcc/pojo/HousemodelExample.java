package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HousemodelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HousemodelExample() {
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

        public Criteria andHouseModelIdIsNull() {
            addCriterion("houseModelId is null");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdIsNotNull() {
            addCriterion("houseModelId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdEqualTo(Long value) {
            addCriterion("houseModelId =", value, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdNotEqualTo(Long value) {
            addCriterion("houseModelId <>", value, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdGreaterThan(Long value) {
            addCriterion("houseModelId >", value, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("houseModelId >=", value, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdLessThan(Long value) {
            addCriterion("houseModelId <", value, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdLessThanOrEqualTo(Long value) {
            addCriterion("houseModelId <=", value, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdIn(List<Long> values) {
            addCriterion("houseModelId in", values, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdNotIn(List<Long> values) {
            addCriterion("houseModelId not in", values, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdBetween(Long value1, Long value2) {
            addCriterion("houseModelId between", value1, value2, "houseModelId");
            return (Criteria) this;
        }

        public Criteria andHouseModelIdNotBetween(Long value1, Long value2) {
            addCriterion("houseModelId not between", value1, value2, "houseModelId");
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

        public Criteria andHouseTitleIsNull() {
            addCriterion("houseTitle is null");
            return (Criteria) this;
        }

        public Criteria andHouseTitleIsNotNull() {
            addCriterion("houseTitle is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTitleEqualTo(String value) {
            addCriterion("houseTitle =", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleNotEqualTo(String value) {
            addCriterion("houseTitle <>", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleGreaterThan(String value) {
            addCriterion("houseTitle >", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleGreaterThanOrEqualTo(String value) {
            addCriterion("houseTitle >=", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleLessThan(String value) {
            addCriterion("houseTitle <", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleLessThanOrEqualTo(String value) {
            addCriterion("houseTitle <=", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleLike(String value) {
            addCriterion("houseTitle like", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleNotLike(String value) {
            addCriterion("houseTitle not like", value, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleIn(List<String> values) {
            addCriterion("houseTitle in", values, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleNotIn(List<String> values) {
            addCriterion("houseTitle not in", values, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleBetween(String value1, String value2) {
            addCriterion("houseTitle between", value1, value2, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andHouseTitleNotBetween(String value1, String value2) {
            addCriterion("houseTitle not between", value1, value2, "houseTitle");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
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

        public Criteria andApartmentNameIsNull() {
            addCriterion("apartmentName is null");
            return (Criteria) this;
        }

        public Criteria andApartmentNameIsNotNull() {
            addCriterion("apartmentName is not null");
            return (Criteria) this;
        }

        public Criteria andApartmentNameEqualTo(String value) {
            addCriterion("apartmentName =", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameNotEqualTo(String value) {
            addCriterion("apartmentName <>", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameGreaterThan(String value) {
            addCriterion("apartmentName >", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("apartmentName >=", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameLessThan(String value) {
            addCriterion("apartmentName <", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameLessThanOrEqualTo(String value) {
            addCriterion("apartmentName <=", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameLike(String value) {
            addCriterion("apartmentName like", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameNotLike(String value) {
            addCriterion("apartmentName not like", value, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameIn(List<String> values) {
            addCriterion("apartmentName in", values, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameNotIn(List<String> values) {
            addCriterion("apartmentName not in", values, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameBetween(String value1, String value2) {
            addCriterion("apartmentName between", value1, value2, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andApartmentNameNotBetween(String value1, String value2) {
            addCriterion("apartmentName not between", value1, value2, "apartmentName");
            return (Criteria) this;
        }

        public Criteria andRedecoratIsNull() {
            addCriterion("redecorat is null");
            return (Criteria) this;
        }

        public Criteria andRedecoratIsNotNull() {
            addCriterion("redecorat is not null");
            return (Criteria) this;
        }

        public Criteria andRedecoratEqualTo(String value) {
            addCriterion("redecorat =", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratNotEqualTo(String value) {
            addCriterion("redecorat <>", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratGreaterThan(String value) {
            addCriterion("redecorat >", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratGreaterThanOrEqualTo(String value) {
            addCriterion("redecorat >=", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratLessThan(String value) {
            addCriterion("redecorat <", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratLessThanOrEqualTo(String value) {
            addCriterion("redecorat <=", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratLike(String value) {
            addCriterion("redecorat like", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratNotLike(String value) {
            addCriterion("redecorat not like", value, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratIn(List<String> values) {
            addCriterion("redecorat in", values, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratNotIn(List<String> values) {
            addCriterion("redecorat not in", values, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratBetween(String value1, String value2) {
            addCriterion("redecorat between", value1, value2, "redecorat");
            return (Criteria) this;
        }

        public Criteria andRedecoratNotBetween(String value1, String value2) {
            addCriterion("redecorat not between", value1, value2, "redecorat");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNull() {
            addCriterion("citycode is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("citycode is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(String value) {
            addCriterion("citycode =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(String value) {
            addCriterion("citycode <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(String value) {
            addCriterion("citycode >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("citycode >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(String value) {
            addCriterion("citycode <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(String value) {
            addCriterion("citycode <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLike(String value) {
            addCriterion("citycode like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotLike(String value) {
            addCriterion("citycode not like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<String> values) {
            addCriterion("citycode in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<String> values) {
            addCriterion("citycode not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(String value1, String value2) {
            addCriterion("citycode between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(String value1, String value2) {
            addCriterion("citycode not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andHousetagidIsNull() {
            addCriterion("housetagid is null");
            return (Criteria) this;
        }

        public Criteria andHousetagidIsNotNull() {
            addCriterion("housetagid is not null");
            return (Criteria) this;
        }

        public Criteria andHousetagidEqualTo(String value) {
            addCriterion("housetagid =", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotEqualTo(String value) {
            addCriterion("housetagid <>", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidGreaterThan(String value) {
            addCriterion("housetagid >", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidGreaterThanOrEqualTo(String value) {
            addCriterion("housetagid >=", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidLessThan(String value) {
            addCriterion("housetagid <", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidLessThanOrEqualTo(String value) {
            addCriterion("housetagid <=", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidLike(String value) {
            addCriterion("housetagid like", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotLike(String value) {
            addCriterion("housetagid not like", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidIn(List<String> values) {
            addCriterion("housetagid in", values, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotIn(List<String> values) {
            addCriterion("housetagid not in", values, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidBetween(String value1, String value2) {
            addCriterion("housetagid between", value1, value2, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotBetween(String value1, String value2) {
            addCriterion("housetagid not between", value1, value2, "housetagid");
            return (Criteria) this;
        }

        public Criteria andVillageNameIsNull() {
            addCriterion("villageName is null");
            return (Criteria) this;
        }

        public Criteria andVillageNameIsNotNull() {
            addCriterion("villageName is not null");
            return (Criteria) this;
        }

        public Criteria andVillageNameEqualTo(String value) {
            addCriterion("villageName =", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotEqualTo(String value) {
            addCriterion("villageName <>", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameGreaterThan(String value) {
            addCriterion("villageName >", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameGreaterThanOrEqualTo(String value) {
            addCriterion("villageName >=", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameLessThan(String value) {
            addCriterion("villageName <", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameLessThanOrEqualTo(String value) {
            addCriterion("villageName <=", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameLike(String value) {
            addCriterion("villageName like", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotLike(String value) {
            addCriterion("villageName not like", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameIn(List<String> values) {
            addCriterion("villageName in", values, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotIn(List<String> values) {
            addCriterion("villageName not in", values, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameBetween(String value1, String value2) {
            addCriterion("villageName between", value1, value2, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotBetween(String value1, String value2) {
            addCriterion("villageName not between", value1, value2, "villageName");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNull() {
            addCriterion("building is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNotNull() {
            addCriterion("building is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingEqualTo(String value) {
            addCriterion("building =", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotEqualTo(String value) {
            addCriterion("building <>", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThan(String value) {
            addCriterion("building >", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThanOrEqualTo(String value) {
            addCriterion("building >=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThan(String value) {
            addCriterion("building <", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThanOrEqualTo(String value) {
            addCriterion("building <=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLike(String value) {
            addCriterion("building like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotLike(String value) {
            addCriterion("building not like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingIn(List<String> values) {
            addCriterion("building in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotIn(List<String> values) {
            addCriterion("building not in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingBetween(String value1, String value2) {
            addCriterion("building between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotBetween(String value1, String value2) {
            addCriterion("building not between", value1, value2, "building");
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

        public Criteria andHouseNumberIsNull() {
            addCriterion("houseNumber is null");
            return (Criteria) this;
        }

        public Criteria andHouseNumberIsNotNull() {
            addCriterion("houseNumber is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNumberEqualTo(String value) {
            addCriterion("houseNumber =", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotEqualTo(String value) {
            addCriterion("houseNumber <>", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberGreaterThan(String value) {
            addCriterion("houseNumber >", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("houseNumber >=", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLessThan(String value) {
            addCriterion("houseNumber <", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLessThanOrEqualTo(String value) {
            addCriterion("houseNumber <=", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLike(String value) {
            addCriterion("houseNumber like", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotLike(String value) {
            addCriterion("houseNumber not like", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberIn(List<String> values) {
            addCriterion("houseNumber in", values, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotIn(List<String> values) {
            addCriterion("houseNumber not in", values, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberBetween(String value1, String value2) {
            addCriterion("houseNumber between", value1, value2, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotBetween(String value1, String value2) {
            addCriterion("houseNumber not between", value1, value2, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andPaystyleIsNull() {
            addCriterion("paystyle is null");
            return (Criteria) this;
        }

        public Criteria andPaystyleIsNotNull() {
            addCriterion("paystyle is not null");
            return (Criteria) this;
        }

        public Criteria andPaystyleEqualTo(String value) {
            addCriterion("paystyle =", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleNotEqualTo(String value) {
            addCriterion("paystyle <>", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleGreaterThan(String value) {
            addCriterion("paystyle >", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleGreaterThanOrEqualTo(String value) {
            addCriterion("paystyle >=", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleLessThan(String value) {
            addCriterion("paystyle <", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleLessThanOrEqualTo(String value) {
            addCriterion("paystyle <=", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleLike(String value) {
            addCriterion("paystyle like", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleNotLike(String value) {
            addCriterion("paystyle not like", value, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleIn(List<String> values) {
            addCriterion("paystyle in", values, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleNotIn(List<String> values) {
            addCriterion("paystyle not in", values, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleBetween(String value1, String value2) {
            addCriterion("paystyle between", value1, value2, "paystyle");
            return (Criteria) this;
        }

        public Criteria andPaystyleNotBetween(String value1, String value2) {
            addCriterion("paystyle not between", value1, value2, "paystyle");
            return (Criteria) this;
        }

        public Criteria andLandPhoneIsNull() {
            addCriterion("landPhone is null");
            return (Criteria) this;
        }

        public Criteria andLandPhoneIsNotNull() {
            addCriterion("landPhone is not null");
            return (Criteria) this;
        }

        public Criteria andLandPhoneEqualTo(String value) {
            addCriterion("landPhone =", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotEqualTo(String value) {
            addCriterion("landPhone <>", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneGreaterThan(String value) {
            addCriterion("landPhone >", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("landPhone >=", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneLessThan(String value) {
            addCriterion("landPhone <", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneLessThanOrEqualTo(String value) {
            addCriterion("landPhone <=", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneLike(String value) {
            addCriterion("landPhone like", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotLike(String value) {
            addCriterion("landPhone not like", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneIn(List<String> values) {
            addCriterion("landPhone in", values, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotIn(List<String> values) {
            addCriterion("landPhone not in", values, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneBetween(String value1, String value2) {
            addCriterion("landPhone between", value1, value2, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotBetween(String value1, String value2) {
            addCriterion("landPhone not between", value1, value2, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandNameIsNull() {
            addCriterion("landName is null");
            return (Criteria) this;
        }

        public Criteria andLandNameIsNotNull() {
            addCriterion("landName is not null");
            return (Criteria) this;
        }

        public Criteria andLandNameEqualTo(String value) {
            addCriterion("landName =", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameNotEqualTo(String value) {
            addCriterion("landName <>", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameGreaterThan(String value) {
            addCriterion("landName >", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameGreaterThanOrEqualTo(String value) {
            addCriterion("landName >=", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameLessThan(String value) {
            addCriterion("landName <", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameLessThanOrEqualTo(String value) {
            addCriterion("landName <=", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameLike(String value) {
            addCriterion("landName like", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameNotLike(String value) {
            addCriterion("landName not like", value, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameIn(List<String> values) {
            addCriterion("landName in", values, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameNotIn(List<String> values) {
            addCriterion("landName not in", values, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameBetween(String value1, String value2) {
            addCriterion("landName between", value1, value2, "landName");
            return (Criteria) this;
        }

        public Criteria andLandNameNotBetween(String value1, String value2) {
            addCriterion("landName not between", value1, value2, "landName");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andTradingIsNull() {
            addCriterion("trading is null");
            return (Criteria) this;
        }

        public Criteria andTradingIsNotNull() {
            addCriterion("trading is not null");
            return (Criteria) this;
        }

        public Criteria andTradingEqualTo(String value) {
            addCriterion("trading =", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingNotEqualTo(String value) {
            addCriterion("trading <>", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingGreaterThan(String value) {
            addCriterion("trading >", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingGreaterThanOrEqualTo(String value) {
            addCriterion("trading >=", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingLessThan(String value) {
            addCriterion("trading <", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingLessThanOrEqualTo(String value) {
            addCriterion("trading <=", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingLike(String value) {
            addCriterion("trading like", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingNotLike(String value) {
            addCriterion("trading not like", value, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingIn(List<String> values) {
            addCriterion("trading in", values, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingNotIn(List<String> values) {
            addCriterion("trading not in", values, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingBetween(String value1, String value2) {
            addCriterion("trading between", value1, value2, "trading");
            return (Criteria) this;
        }

        public Criteria andTradingNotBetween(String value1, String value2) {
            addCriterion("trading not between", value1, value2, "trading");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Double value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Double value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Double value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Double value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Double value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Double> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Double> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Double value1, Double value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Double value1, Double value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andDetailesIsNull() {
            addCriterion("detailes is null");
            return (Criteria) this;
        }

        public Criteria andDetailesIsNotNull() {
            addCriterion("detailes is not null");
            return (Criteria) this;
        }

        public Criteria andDetailesEqualTo(String value) {
            addCriterion("detailes =", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesNotEqualTo(String value) {
            addCriterion("detailes <>", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesGreaterThan(String value) {
            addCriterion("detailes >", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesGreaterThanOrEqualTo(String value) {
            addCriterion("detailes >=", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesLessThan(String value) {
            addCriterion("detailes <", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesLessThanOrEqualTo(String value) {
            addCriterion("detailes <=", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesLike(String value) {
            addCriterion("detailes like", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesNotLike(String value) {
            addCriterion("detailes not like", value, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesIn(List<String> values) {
            addCriterion("detailes in", values, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesNotIn(List<String> values) {
            addCriterion("detailes not in", values, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesBetween(String value1, String value2) {
            addCriterion("detailes between", value1, value2, "detailes");
            return (Criteria) this;
        }

        public Criteria andDetailesNotBetween(String value1, String value2) {
            addCriterion("detailes not between", value1, value2, "detailes");
            return (Criteria) this;
        }

        public Criteria andLatlngIsNull() {
            addCriterion("latlng is null");
            return (Criteria) this;
        }

        public Criteria andLatlngIsNotNull() {
            addCriterion("latlng is not null");
            return (Criteria) this;
        }

        public Criteria andLatlngEqualTo(String value) {
            addCriterion("latlng =", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngNotEqualTo(String value) {
            addCriterion("latlng <>", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngGreaterThan(String value) {
            addCriterion("latlng >", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngGreaterThanOrEqualTo(String value) {
            addCriterion("latlng >=", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngLessThan(String value) {
            addCriterion("latlng <", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngLessThanOrEqualTo(String value) {
            addCriterion("latlng <=", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngLike(String value) {
            addCriterion("latlng like", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngNotLike(String value) {
            addCriterion("latlng not like", value, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngIn(List<String> values) {
            addCriterion("latlng in", values, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngNotIn(List<String> values) {
            addCriterion("latlng not in", values, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngBetween(String value1, String value2) {
            addCriterion("latlng between", value1, value2, "latlng");
            return (Criteria) this;
        }

        public Criteria andLatlngNotBetween(String value1, String value2) {
            addCriterion("latlng not between", value1, value2, "latlng");
            return (Criteria) this;
        }

        public Criteria andCentTypeIsNull() {
            addCriterion("centType is null");
            return (Criteria) this;
        }

        public Criteria andCentTypeIsNotNull() {
            addCriterion("centType is not null");
            return (Criteria) this;
        }

        public Criteria andCentTypeEqualTo(String value) {
            addCriterion("centType =", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeNotEqualTo(String value) {
            addCriterion("centType <>", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeGreaterThan(String value) {
            addCriterion("centType >", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("centType >=", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeLessThan(String value) {
            addCriterion("centType <", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeLessThanOrEqualTo(String value) {
            addCriterion("centType <=", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeLike(String value) {
            addCriterion("centType like", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeNotLike(String value) {
            addCriterion("centType not like", value, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeIn(List<String> values) {
            addCriterion("centType in", values, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeNotIn(List<String> values) {
            addCriterion("centType not in", values, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeBetween(String value1, String value2) {
            addCriterion("centType between", value1, value2, "centType");
            return (Criteria) this;
        }

        public Criteria andCentTypeNotBetween(String value1, String value2) {
            addCriterion("centType not between", value1, value2, "centType");
            return (Criteria) this;
        }

        public Criteria andCentStateIsNull() {
            addCriterion("centState is null");
            return (Criteria) this;
        }

        public Criteria andCentStateIsNotNull() {
            addCriterion("centState is not null");
            return (Criteria) this;
        }

        public Criteria andCentStateEqualTo(String value) {
            addCriterion("centState =", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateNotEqualTo(String value) {
            addCriterion("centState <>", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateGreaterThan(String value) {
            addCriterion("centState >", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateGreaterThanOrEqualTo(String value) {
            addCriterion("centState >=", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateLessThan(String value) {
            addCriterion("centState <", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateLessThanOrEqualTo(String value) {
            addCriterion("centState <=", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateLike(String value) {
            addCriterion("centState like", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateNotLike(String value) {
            addCriterion("centState not like", value, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateIn(List<String> values) {
            addCriterion("centState in", values, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateNotIn(List<String> values) {
            addCriterion("centState not in", values, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateBetween(String value1, String value2) {
            addCriterion("centState between", value1, value2, "centState");
            return (Criteria) this;
        }

        public Criteria andCentStateNotBetween(String value1, String value2) {
            addCriterion("centState not between", value1, value2, "centState");
            return (Criteria) this;
        }

        public Criteria andCentTimeIsNull() {
            addCriterion("centTime is null");
            return (Criteria) this;
        }

        public Criteria andCentTimeIsNotNull() {
            addCriterion("centTime is not null");
            return (Criteria) this;
        }

        public Criteria andCentTimeEqualTo(Date value) {
            addCriterion("centTime =", value, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeNotEqualTo(Date value) {
            addCriterion("centTime <>", value, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeGreaterThan(Date value) {
            addCriterion("centTime >", value, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("centTime >=", value, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeLessThan(Date value) {
            addCriterion("centTime <", value, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeLessThanOrEqualTo(Date value) {
            addCriterion("centTime <=", value, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeIn(List<Date> values) {
            addCriterion("centTime in", values, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeNotIn(List<Date> values) {
            addCriterion("centTime not in", values, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeBetween(Date value1, Date value2) {
            addCriterion("centTime between", value1, value2, "centTime");
            return (Criteria) this;
        }

        public Criteria andCentTimeNotBetween(Date value1, Date value2) {
            addCriterion("centTime not between", value1, value2, "centTime");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(String value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(String value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(String value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLike(String value) {
            addCriterion("floor like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotLike(String value) {
            addCriterion("floor not like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<String> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberIsNull() {
            addCriterion("agencyNumber is null");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberIsNotNull() {
            addCriterion("agencyNumber is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberEqualTo(Double value) {
            addCriterion("agencyNumber =", value, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberNotEqualTo(Double value) {
            addCriterion("agencyNumber <>", value, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberGreaterThan(Double value) {
            addCriterion("agencyNumber >", value, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberGreaterThanOrEqualTo(Double value) {
            addCriterion("agencyNumber >=", value, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberLessThan(Double value) {
            addCriterion("agencyNumber <", value, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberLessThanOrEqualTo(Double value) {
            addCriterion("agencyNumber <=", value, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberIn(List<Double> values) {
            addCriterion("agencyNumber in", values, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberNotIn(List<Double> values) {
            addCriterion("agencyNumber not in", values, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberBetween(Double value1, Double value2) {
            addCriterion("agencyNumber between", value1, value2, "agencyNumber");
            return (Criteria) this;
        }

        public Criteria andAgencyNumberNotBetween(Double value1, Double value2) {
            addCriterion("agencyNumber not between", value1, value2, "agencyNumber");
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