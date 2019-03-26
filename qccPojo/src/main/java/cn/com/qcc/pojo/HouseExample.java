package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
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

        public Criteria andTribeidsIsNull() {
            addCriterion("tribeids is null");
            return (Criteria) this;
        }

        public Criteria andTribeidsIsNotNull() {
            addCriterion("tribeids is not null");
            return (Criteria) this;
        }

        public Criteria andTribeidsEqualTo(String value) {
            addCriterion("tribeids =", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsNotEqualTo(String value) {
            addCriterion("tribeids <>", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsGreaterThan(String value) {
            addCriterion("tribeids >", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsGreaterThanOrEqualTo(String value) {
            addCriterion("tribeids >=", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsLessThan(String value) {
            addCriterion("tribeids <", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsLessThanOrEqualTo(String value) {
            addCriterion("tribeids <=", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsLike(String value) {
            addCriterion("tribeids like", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsNotLike(String value) {
            addCriterion("tribeids not like", value, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsIn(List<String> values) {
            addCriterion("tribeids in", values, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsNotIn(List<String> values) {
            addCriterion("tribeids not in", values, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsBetween(String value1, String value2) {
            addCriterion("tribeids between", value1, value2, "tribeids");
            return (Criteria) this;
        }

        public Criteria andTribeidsNotBetween(String value1, String value2) {
            addCriterion("tribeids not between", value1, value2, "tribeids");
            return (Criteria) this;
        }

        public Criteria andHousetitleIsNull() {
            addCriterion("housetitle is null");
            return (Criteria) this;
        }

        public Criteria andHousetitleIsNotNull() {
            addCriterion("housetitle is not null");
            return (Criteria) this;
        }

        public Criteria andHousetitleEqualTo(String value) {
            addCriterion("housetitle =", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleNotEqualTo(String value) {
            addCriterion("housetitle <>", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleGreaterThan(String value) {
            addCriterion("housetitle >", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleGreaterThanOrEqualTo(String value) {
            addCriterion("housetitle >=", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleLessThan(String value) {
            addCriterion("housetitle <", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleLessThanOrEqualTo(String value) {
            addCriterion("housetitle <=", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleLike(String value) {
            addCriterion("housetitle like", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleNotLike(String value) {
            addCriterion("housetitle not like", value, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleIn(List<String> values) {
            addCriterion("housetitle in", values, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleNotIn(List<String> values) {
            addCriterion("housetitle not in", values, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleBetween(String value1, String value2) {
            addCriterion("housetitle between", value1, value2, "housetitle");
            return (Criteria) this;
        }

        public Criteria andHousetitleNotBetween(String value1, String value2) {
            addCriterion("housetitle not between", value1, value2, "housetitle");
            return (Criteria) this;
        }

        public Criteria andBuildingidIsNull() {
            addCriterion("buildingid is null");
            return (Criteria) this;
        }

        public Criteria andBuildingidIsNotNull() {
            addCriterion("buildingid is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingidEqualTo(Long value) {
            addCriterion("buildingid =", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotEqualTo(Long value) {
            addCriterion("buildingid <>", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidGreaterThan(Long value) {
            addCriterion("buildingid >", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidGreaterThanOrEqualTo(Long value) {
            addCriterion("buildingid >=", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLessThan(Long value) {
            addCriterion("buildingid <", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLessThanOrEqualTo(Long value) {
            addCriterion("buildingid <=", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidIn(List<Long> values) {
            addCriterion("buildingid in", values, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotIn(List<Long> values) {
            addCriterion("buildingid not in", values, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidBetween(Long value1, Long value2) {
            addCriterion("buildingid between", value1, value2, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotBetween(Long value1, Long value2) {
            addCriterion("buildingid not between", value1, value2, "buildingid");
            return (Criteria) this;
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

        public Criteria andUser_identityIsNull() {
            addCriterion("user_identity is null");
            return (Criteria) this;
        }

        public Criteria andUser_identityIsNotNull() {
            addCriterion("user_identity is not null");
            return (Criteria) this;
        }

        public Criteria andUser_identityEqualTo(String value) {
            addCriterion("user_identity =", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityNotEqualTo(String value) {
            addCriterion("user_identity <>", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityGreaterThan(String value) {
            addCriterion("user_identity >", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityGreaterThanOrEqualTo(String value) {
            addCriterion("user_identity >=", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityLessThan(String value) {
            addCriterion("user_identity <", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityLessThanOrEqualTo(String value) {
            addCriterion("user_identity <=", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityLike(String value) {
            addCriterion("user_identity like", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityNotLike(String value) {
            addCriterion("user_identity not like", value, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityIn(List<String> values) {
            addCriterion("user_identity in", values, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityNotIn(List<String> values) {
            addCriterion("user_identity not in", values, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityBetween(String value1, String value2) {
            addCriterion("user_identity between", value1, value2, "user_identity");
            return (Criteria) this;
        }

        public Criteria andUser_identityNotBetween(String value1, String value2) {
            addCriterion("user_identity not between", value1, value2, "user_identity");
            return (Criteria) this;
        }

        public Criteria andApartment_idIsNull() {
            addCriterion("apartment_id is null");
            return (Criteria) this;
        }

        public Criteria andApartment_idIsNotNull() {
            addCriterion("apartment_id is not null");
            return (Criteria) this;
        }

        public Criteria andApartment_idEqualTo(Integer value) {
            addCriterion("apartment_id =", value, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idNotEqualTo(Integer value) {
            addCriterion("apartment_id <>", value, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idGreaterThan(Integer value) {
            addCriterion("apartment_id >", value, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("apartment_id >=", value, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idLessThan(Integer value) {
            addCriterion("apartment_id <", value, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idLessThanOrEqualTo(Integer value) {
            addCriterion("apartment_id <=", value, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idIn(List<Integer> values) {
            addCriterion("apartment_id in", values, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idNotIn(List<Integer> values) {
            addCriterion("apartment_id not in", values, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idBetween(Integer value1, Integer value2) {
            addCriterion("apartment_id between", value1, value2, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andApartment_idNotBetween(Integer value1, Integer value2) {
            addCriterion("apartment_id not between", value1, value2, "apartment_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idIsNull() {
            addCriterion("housetag_id is null");
            return (Criteria) this;
        }

        public Criteria andHousetag_idIsNotNull() {
            addCriterion("housetag_id is not null");
            return (Criteria) this;
        }

        public Criteria andHousetag_idEqualTo(String value) {
            addCriterion("housetag_id =", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idNotEqualTo(String value) {
            addCriterion("housetag_id <>", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idGreaterThan(String value) {
            addCriterion("housetag_id >", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idGreaterThanOrEqualTo(String value) {
            addCriterion("housetag_id >=", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idLessThan(String value) {
            addCriterion("housetag_id <", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idLessThanOrEqualTo(String value) {
            addCriterion("housetag_id <=", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idLike(String value) {
            addCriterion("housetag_id like", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idNotLike(String value) {
            addCriterion("housetag_id not like", value, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idIn(List<String> values) {
            addCriterion("housetag_id in", values, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idNotIn(List<String> values) {
            addCriterion("housetag_id not in", values, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idBetween(String value1, String value2) {
            addCriterion("housetag_id between", value1, value2, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andHousetag_idNotBetween(String value1, String value2) {
            addCriterion("housetag_id not between", value1, value2, "housetag_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idIsNull() {
            addCriterion("property_id is null");
            return (Criteria) this;
        }

        public Criteria andProperty_idIsNotNull() {
            addCriterion("property_id is not null");
            return (Criteria) this;
        }

        public Criteria andProperty_idEqualTo(Integer value) {
            addCriterion("property_id =", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idNotEqualTo(Integer value) {
            addCriterion("property_id <>", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idGreaterThan(Integer value) {
            addCriterion("property_id >", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_id >=", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idLessThan(Integer value) {
            addCriterion("property_id <", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idLessThanOrEqualTo(Integer value) {
            addCriterion("property_id <=", value, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idIn(List<Integer> values) {
            addCriterion("property_id in", values, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idNotIn(List<Integer> values) {
            addCriterion("property_id not in", values, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idBetween(Integer value1, Integer value2) {
            addCriterion("property_id between", value1, value2, "property_id");
            return (Criteria) this;
        }

        public Criteria andProperty_idNotBetween(Integer value1, Integer value2) {
            addCriterion("property_id not between", value1, value2, "property_id");
            return (Criteria) this;
        }

        public Criteria andBrandidIsNull() {
            addCriterion("brandid is null");
            return (Criteria) this;
        }

        public Criteria andBrandidIsNotNull() {
            addCriterion("brandid is not null");
            return (Criteria) this;
        }

        public Criteria andBrandidEqualTo(Long value) {
            addCriterion("brandid =", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotEqualTo(Long value) {
            addCriterion("brandid <>", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidGreaterThan(Long value) {
            addCriterion("brandid >", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidGreaterThanOrEqualTo(Long value) {
            addCriterion("brandid >=", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidLessThan(Long value) {
            addCriterion("brandid <", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidLessThanOrEqualTo(Long value) {
            addCriterion("brandid <=", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidIn(List<Long> values) {
            addCriterion("brandid in", values, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotIn(List<Long> values) {
            addCriterion("brandid not in", values, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidBetween(Long value1, Long value2) {
            addCriterion("brandid between", value1, value2, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotBetween(Long value1, Long value2) {
            addCriterion("brandid not between", value1, value2, "brandid");
            return (Criteria) this;
        }

        public Criteria andLandlordIsNull() {
            addCriterion("landlord is null");
            return (Criteria) this;
        }

        public Criteria andLandlordIsNotNull() {
            addCriterion("landlord is not null");
            return (Criteria) this;
        }

        public Criteria andLandlordEqualTo(String value) {
            addCriterion("landlord =", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordNotEqualTo(String value) {
            addCriterion("landlord <>", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordGreaterThan(String value) {
            addCriterion("landlord >", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordGreaterThanOrEqualTo(String value) {
            addCriterion("landlord >=", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordLessThan(String value) {
            addCriterion("landlord <", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordLessThanOrEqualTo(String value) {
            addCriterion("landlord <=", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordLike(String value) {
            addCriterion("landlord like", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordNotLike(String value) {
            addCriterion("landlord not like", value, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordIn(List<String> values) {
            addCriterion("landlord in", values, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordNotIn(List<String> values) {
            addCriterion("landlord not in", values, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordBetween(String value1, String value2) {
            addCriterion("landlord between", value1, value2, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordNotBetween(String value1, String value2) {
            addCriterion("landlord not between", value1, value2, "landlord");
            return (Criteria) this;
        }

        public Criteria andLandlordtelIsNull() {
            addCriterion("landlordtel is null");
            return (Criteria) this;
        }

        public Criteria andLandlordtelIsNotNull() {
            addCriterion("landlordtel is not null");
            return (Criteria) this;
        }

        public Criteria andLandlordtelEqualTo(String value) {
            addCriterion("landlordtel =", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelNotEqualTo(String value) {
            addCriterion("landlordtel <>", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelGreaterThan(String value) {
            addCriterion("landlordtel >", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelGreaterThanOrEqualTo(String value) {
            addCriterion("landlordtel >=", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelLessThan(String value) {
            addCriterion("landlordtel <", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelLessThanOrEqualTo(String value) {
            addCriterion("landlordtel <=", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelLike(String value) {
            addCriterion("landlordtel like", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelNotLike(String value) {
            addCriterion("landlordtel not like", value, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelIn(List<String> values) {
            addCriterion("landlordtel in", values, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelNotIn(List<String> values) {
            addCriterion("landlordtel not in", values, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelBetween(String value1, String value2) {
            addCriterion("landlordtel between", value1, value2, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andLandlordtelNotBetween(String value1, String value2) {
            addCriterion("landlordtel not between", value1, value2, "landlordtel");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactstelIsNull() {
            addCriterion("contactstel is null");
            return (Criteria) this;
        }

        public Criteria andContactstelIsNotNull() {
            addCriterion("contactstel is not null");
            return (Criteria) this;
        }

        public Criteria andContactstelEqualTo(String value) {
            addCriterion("contactstel =", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelNotEqualTo(String value) {
            addCriterion("contactstel <>", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelGreaterThan(String value) {
            addCriterion("contactstel >", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelGreaterThanOrEqualTo(String value) {
            addCriterion("contactstel >=", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelLessThan(String value) {
            addCriterion("contactstel <", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelLessThanOrEqualTo(String value) {
            addCriterion("contactstel <=", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelLike(String value) {
            addCriterion("contactstel like", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelNotLike(String value) {
            addCriterion("contactstel not like", value, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelIn(List<String> values) {
            addCriterion("contactstel in", values, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelNotIn(List<String> values) {
            addCriterion("contactstel not in", values, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelBetween(String value1, String value2) {
            addCriterion("contactstel between", value1, value2, "contactstel");
            return (Criteria) this;
        }

        public Criteria andContactstelNotBetween(String value1, String value2) {
            addCriterion("contactstel not between", value1, value2, "contactstel");
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

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Integer value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Integer value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Integer value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Integer value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Integer value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Integer> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Integer> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Integer value1, Integer value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andPrice_idIsNull() {
            addCriterion("price_id is null");
            return (Criteria) this;
        }

        public Criteria andPrice_idIsNotNull() {
            addCriterion("price_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrice_idEqualTo(Long value) {
            addCriterion("price_id =", value, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idNotEqualTo(Long value) {
            addCriterion("price_id <>", value, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idGreaterThan(Long value) {
            addCriterion("price_id >", value, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idGreaterThanOrEqualTo(Long value) {
            addCriterion("price_id >=", value, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idLessThan(Long value) {
            addCriterion("price_id <", value, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idLessThanOrEqualTo(Long value) {
            addCriterion("price_id <=", value, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idIn(List<Long> values) {
            addCriterion("price_id in", values, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idNotIn(List<Long> values) {
            addCriterion("price_id not in", values, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idBetween(Long value1, Long value2) {
            addCriterion("price_id between", value1, value2, "price_id");
            return (Criteria) this;
        }

        public Criteria andPrice_idNotBetween(Long value1, Long value2) {
            addCriterion("price_id not between", value1, value2, "price_id");
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

        public Criteria andAgesIsNull() {
            addCriterion("ages is null");
            return (Criteria) this;
        }

        public Criteria andAgesIsNotNull() {
            addCriterion("ages is not null");
            return (Criteria) this;
        }

        public Criteria andAgesEqualTo(String value) {
            addCriterion("ages =", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesNotEqualTo(String value) {
            addCriterion("ages <>", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesGreaterThan(String value) {
            addCriterion("ages >", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesGreaterThanOrEqualTo(String value) {
            addCriterion("ages >=", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesLessThan(String value) {
            addCriterion("ages <", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesLessThanOrEqualTo(String value) {
            addCriterion("ages <=", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesLike(String value) {
            addCriterion("ages like", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesNotLike(String value) {
            addCriterion("ages not like", value, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesIn(List<String> values) {
            addCriterion("ages in", values, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesNotIn(List<String> values) {
            addCriterion("ages not in", values, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesBetween(String value1, String value2) {
            addCriterion("ages between", value1, value2, "ages");
            return (Criteria) this;
        }

        public Criteria andAgesNotBetween(String value1, String value2) {
            addCriterion("ages not between", value1, value2, "ages");
            return (Criteria) this;
        }

        public Criteria andTurnIsNull() {
            addCriterion("turn is null");
            return (Criteria) this;
        }

        public Criteria andTurnIsNotNull() {
            addCriterion("turn is not null");
            return (Criteria) this;
        }

        public Criteria andTurnEqualTo(String value) {
            addCriterion("turn =", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotEqualTo(String value) {
            addCriterion("turn <>", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnGreaterThan(String value) {
            addCriterion("turn >", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnGreaterThanOrEqualTo(String value) {
            addCriterion("turn >=", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnLessThan(String value) {
            addCriterion("turn <", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnLessThanOrEqualTo(String value) {
            addCriterion("turn <=", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnLike(String value) {
            addCriterion("turn like", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotLike(String value) {
            addCriterion("turn not like", value, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnIn(List<String> values) {
            addCriterion("turn in", values, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotIn(List<String> values) {
            addCriterion("turn not in", values, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnBetween(String value1, String value2) {
            addCriterion("turn between", value1, value2, "turn");
            return (Criteria) this;
        }

        public Criteria andTurnNotBetween(String value1, String value2) {
            addCriterion("turn not between", value1, value2, "turn");
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

        public Criteria andUndergroundIsNull() {
            addCriterion("underground is null");
            return (Criteria) this;
        }

        public Criteria andUndergroundIsNotNull() {
            addCriterion("underground is not null");
            return (Criteria) this;
        }

        public Criteria andUndergroundEqualTo(String value) {
            addCriterion("underground =", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundNotEqualTo(String value) {
            addCriterion("underground <>", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundGreaterThan(String value) {
            addCriterion("underground >", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundGreaterThanOrEqualTo(String value) {
            addCriterion("underground >=", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundLessThan(String value) {
            addCriterion("underground <", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundLessThanOrEqualTo(String value) {
            addCriterion("underground <=", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundLike(String value) {
            addCriterion("underground like", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundNotLike(String value) {
            addCriterion("underground not like", value, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundIn(List<String> values) {
            addCriterion("underground in", values, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundNotIn(List<String> values) {
            addCriterion("underground not in", values, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundBetween(String value1, String value2) {
            addCriterion("underground between", value1, value2, "underground");
            return (Criteria) this;
        }

        public Criteria andUndergroundNotBetween(String value1, String value2) {
            addCriterion("underground not between", value1, value2, "underground");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHousestatusIsNull() {
            addCriterion("housestatus is null");
            return (Criteria) this;
        }

        public Criteria andHousestatusIsNotNull() {
            addCriterion("housestatus is not null");
            return (Criteria) this;
        }

        public Criteria andHousestatusEqualTo(String value) {
            addCriterion("housestatus =", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusNotEqualTo(String value) {
            addCriterion("housestatus <>", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusGreaterThan(String value) {
            addCriterion("housestatus >", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusGreaterThanOrEqualTo(String value) {
            addCriterion("housestatus >=", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusLessThan(String value) {
            addCriterion("housestatus <", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusLessThanOrEqualTo(String value) {
            addCriterion("housestatus <=", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusLike(String value) {
            addCriterion("housestatus like", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusNotLike(String value) {
            addCriterion("housestatus not like", value, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusIn(List<String> values) {
            addCriterion("housestatus in", values, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusNotIn(List<String> values) {
            addCriterion("housestatus not in", values, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusBetween(String value1, String value2) {
            addCriterion("housestatus between", value1, value2, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHousestatusNotBetween(String value1, String value2) {
            addCriterion("housestatus not between", value1, value2, "housestatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusIsNull() {
            addCriterion("houstatus is null");
            return (Criteria) this;
        }

        public Criteria andHoustatusIsNotNull() {
            addCriterion("houstatus is not null");
            return (Criteria) this;
        }

        public Criteria andHoustatusEqualTo(String value) {
            addCriterion("houstatus =", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusNotEqualTo(String value) {
            addCriterion("houstatus <>", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusGreaterThan(String value) {
            addCriterion("houstatus >", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusGreaterThanOrEqualTo(String value) {
            addCriterion("houstatus >=", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusLessThan(String value) {
            addCriterion("houstatus <", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusLessThanOrEqualTo(String value) {
            addCriterion("houstatus <=", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusLike(String value) {
            addCriterion("houstatus like", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusNotLike(String value) {
            addCriterion("houstatus not like", value, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusIn(List<String> values) {
            addCriterion("houstatus in", values, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusNotIn(List<String> values) {
            addCriterion("houstatus not in", values, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusBetween(String value1, String value2) {
            addCriterion("houstatus between", value1, value2, "houstatus");
            return (Criteria) this;
        }

        public Criteria andHoustatusNotBetween(String value1, String value2) {
            addCriterion("houstatus not between", value1, value2, "houstatus");
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

        public Criteria andHouse_numberIsNull() {
            addCriterion("house_number is null");
            return (Criteria) this;
        }

        public Criteria andHouse_numberIsNotNull() {
            addCriterion("house_number is not null");
            return (Criteria) this;
        }

        public Criteria andHouse_numberEqualTo(String value) {
            addCriterion("house_number =", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberNotEqualTo(String value) {
            addCriterion("house_number <>", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberGreaterThan(String value) {
            addCriterion("house_number >", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberGreaterThanOrEqualTo(String value) {
            addCriterion("house_number >=", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberLessThan(String value) {
            addCriterion("house_number <", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberLessThanOrEqualTo(String value) {
            addCriterion("house_number <=", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberLike(String value) {
            addCriterion("house_number like", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberNotLike(String value) {
            addCriterion("house_number not like", value, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberIn(List<String> values) {
            addCriterion("house_number in", values, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberNotIn(List<String> values) {
            addCriterion("house_number not in", values, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberBetween(String value1, String value2) {
            addCriterion("house_number between", value1, value2, "house_number");
            return (Criteria) this;
        }

        public Criteria andHouse_numberNotBetween(String value1, String value2) {
            addCriterion("house_number not between", value1, value2, "house_number");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNull() {
            addCriterion("videourl is null");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNotNull() {
            addCriterion("videourl is not null");
            return (Criteria) this;
        }

        public Criteria andVideourlEqualTo(String value) {
            addCriterion("videourl =", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotEqualTo(String value) {
            addCriterion("videourl <>", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThan(String value) {
            addCriterion("videourl >", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThanOrEqualTo(String value) {
            addCriterion("videourl >=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThan(String value) {
            addCriterion("videourl <", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThanOrEqualTo(String value) {
            addCriterion("videourl <=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLike(String value) {
            addCriterion("videourl like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotLike(String value) {
            addCriterion("videourl not like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlIn(List<String> values) {
            addCriterion("videourl in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotIn(List<String> values) {
            addCriterion("videourl not in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlBetween(String value1, String value2) {
            addCriterion("videourl between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotBetween(String value1, String value2) {
            addCriterion("videourl not between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNull() {
            addCriterion("schedule is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNotNull() {
            addCriterion("schedule is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleEqualTo(Integer value) {
            addCriterion("schedule =", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotEqualTo(Integer value) {
            addCriterion("schedule <>", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThan(Integer value) {
            addCriterion("schedule >", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule >=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThan(Integer value) {
            addCriterion("schedule <", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThanOrEqualTo(Integer value) {
            addCriterion("schedule <=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleIn(List<Integer> values) {
            addCriterion("schedule in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotIn(List<Integer> values) {
            addCriterion("schedule not in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleBetween(Integer value1, Integer value2) {
            addCriterion("schedule between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule not between", value1, value2, "schedule");
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

        public Criteria andHousecodeIsNull() {
            addCriterion("housecode is null");
            return (Criteria) this;
        }

        public Criteria andHousecodeIsNotNull() {
            addCriterion("housecode is not null");
            return (Criteria) this;
        }

        public Criteria andHousecodeEqualTo(String value) {
            addCriterion("housecode =", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeNotEqualTo(String value) {
            addCriterion("housecode <>", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeGreaterThan(String value) {
            addCriterion("housecode >", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeGreaterThanOrEqualTo(String value) {
            addCriterion("housecode >=", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeLessThan(String value) {
            addCriterion("housecode <", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeLessThanOrEqualTo(String value) {
            addCriterion("housecode <=", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeLike(String value) {
            addCriterion("housecode like", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeNotLike(String value) {
            addCriterion("housecode not like", value, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeIn(List<String> values) {
            addCriterion("housecode in", values, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeNotIn(List<String> values) {
            addCriterion("housecode not in", values, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeBetween(String value1, String value2) {
            addCriterion("housecode between", value1, value2, "housecode");
            return (Criteria) this;
        }

        public Criteria andHousecodeNotBetween(String value1, String value2) {
            addCriterion("housecode not between", value1, value2, "housecode");
            return (Criteria) this;
        }

        public Criteria andXcxpictureIsNull() {
            addCriterion("xcxpicture is null");
            return (Criteria) this;
        }

        public Criteria andXcxpictureIsNotNull() {
            addCriterion("xcxpicture is not null");
            return (Criteria) this;
        }

        public Criteria andXcxpictureEqualTo(String value) {
            addCriterion("xcxpicture =", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureNotEqualTo(String value) {
            addCriterion("xcxpicture <>", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureGreaterThan(String value) {
            addCriterion("xcxpicture >", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureGreaterThanOrEqualTo(String value) {
            addCriterion("xcxpicture >=", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureLessThan(String value) {
            addCriterion("xcxpicture <", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureLessThanOrEqualTo(String value) {
            addCriterion("xcxpicture <=", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureLike(String value) {
            addCriterion("xcxpicture like", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureNotLike(String value) {
            addCriterion("xcxpicture not like", value, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureIn(List<String> values) {
            addCriterion("xcxpicture in", values, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureNotIn(List<String> values) {
            addCriterion("xcxpicture not in", values, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureBetween(String value1, String value2) {
            addCriterion("xcxpicture between", value1, value2, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andXcxpictureNotBetween(String value1, String value2) {
            addCriterion("xcxpicture not between", value1, value2, "xcxpicture");
            return (Criteria) this;
        }

        public Criteria andRenderingsIsNull() {
            addCriterion("renderings is null");
            return (Criteria) this;
        }

        public Criteria andRenderingsIsNotNull() {
            addCriterion("renderings is not null");
            return (Criteria) this;
        }

        public Criteria andRenderingsEqualTo(String value) {
            addCriterion("renderings =", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsNotEqualTo(String value) {
            addCriterion("renderings <>", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsGreaterThan(String value) {
            addCriterion("renderings >", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsGreaterThanOrEqualTo(String value) {
            addCriterion("renderings >=", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsLessThan(String value) {
            addCriterion("renderings <", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsLessThanOrEqualTo(String value) {
            addCriterion("renderings <=", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsLike(String value) {
            addCriterion("renderings like", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsNotLike(String value) {
            addCriterion("renderings not like", value, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsIn(List<String> values) {
            addCriterion("renderings in", values, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsNotIn(List<String> values) {
            addCriterion("renderings not in", values, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsBetween(String value1, String value2) {
            addCriterion("renderings between", value1, value2, "renderings");
            return (Criteria) this;
        }

        public Criteria andRenderingsNotBetween(String value1, String value2) {
            addCriterion("renderings not between", value1, value2, "renderings");
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