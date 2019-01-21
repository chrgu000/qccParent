package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingExample() {
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

        public Criteria andDetailidIsNull() {
            addCriterion("detailid is null");
            return (Criteria) this;
        }

        public Criteria andDetailidIsNotNull() {
            addCriterion("detailid is not null");
            return (Criteria) this;
        }

        public Criteria andDetailidEqualTo(Long value) {
            addCriterion("detailid =", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotEqualTo(Long value) {
            addCriterion("detailid <>", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThan(Long value) {
            addCriterion("detailid >", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThanOrEqualTo(Long value) {
            addCriterion("detailid >=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThan(Long value) {
            addCriterion("detailid <", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThanOrEqualTo(Long value) {
            addCriterion("detailid <=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidIn(List<Long> values) {
            addCriterion("detailid in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotIn(List<Long> values) {
            addCriterion("detailid not in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidBetween(Long value1, Long value2) {
            addCriterion("detailid between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotBetween(Long value1, Long value2) {
            addCriterion("detailid not between", value1, value2, "detailid");
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

        public Criteria andDescribesIsNull() {
            addCriterion("describes is null");
            return (Criteria) this;
        }

        public Criteria andDescribesIsNotNull() {
            addCriterion("describes is not null");
            return (Criteria) this;
        }

        public Criteria andDescribesEqualTo(String value) {
            addCriterion("describes =", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotEqualTo(String value) {
            addCriterion("describes <>", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesGreaterThan(String value) {
            addCriterion("describes >", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesGreaterThanOrEqualTo(String value) {
            addCriterion("describes >=", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesLessThan(String value) {
            addCriterion("describes <", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesLessThanOrEqualTo(String value) {
            addCriterion("describes <=", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesLike(String value) {
            addCriterion("describes like", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotLike(String value) {
            addCriterion("describes not like", value, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesIn(List<String> values) {
            addCriterion("describes in", values, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotIn(List<String> values) {
            addCriterion("describes not in", values, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesBetween(String value1, String value2) {
            addCriterion("describes between", value1, value2, "describes");
            return (Criteria) this;
        }

        public Criteria andDescribesNotBetween(String value1, String value2) {
            addCriterion("describes not between", value1, value2, "describes");
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

        public Criteria andBuildingcodeIsNull() {
            addCriterion("buildingcode is null");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeIsNotNull() {
            addCriterion("buildingcode is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeEqualTo(String value) {
            addCriterion("buildingcode =", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeNotEqualTo(String value) {
            addCriterion("buildingcode <>", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeGreaterThan(String value) {
            addCriterion("buildingcode >", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeGreaterThanOrEqualTo(String value) {
            addCriterion("buildingcode >=", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeLessThan(String value) {
            addCriterion("buildingcode <", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeLessThanOrEqualTo(String value) {
            addCriterion("buildingcode <=", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeLike(String value) {
            addCriterion("buildingcode like", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeNotLike(String value) {
            addCriterion("buildingcode not like", value, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeIn(List<String> values) {
            addCriterion("buildingcode in", values, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeNotIn(List<String> values) {
            addCriterion("buildingcode not in", values, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeBetween(String value1, String value2) {
            addCriterion("buildingcode between", value1, value2, "buildingcode");
            return (Criteria) this;
        }

        public Criteria andBuildingcodeNotBetween(String value1, String value2) {
            addCriterion("buildingcode not between", value1, value2, "buildingcode");
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

        public Criteria andLinkphoneIsNull() {
            addCriterion("linkphone is null");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIsNotNull() {
            addCriterion("linkphone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkphoneEqualTo(String value) {
            addCriterion("linkphone =", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotEqualTo(String value) {
            addCriterion("linkphone <>", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneGreaterThan(String value) {
            addCriterion("linkphone >", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneGreaterThanOrEqualTo(String value) {
            addCriterion("linkphone >=", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLessThan(String value) {
            addCriterion("linkphone <", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLessThanOrEqualTo(String value) {
            addCriterion("linkphone <=", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLike(String value) {
            addCriterion("linkphone like", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotLike(String value) {
            addCriterion("linkphone not like", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIn(List<String> values) {
            addCriterion("linkphone in", values, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotIn(List<String> values) {
            addCriterion("linkphone not in", values, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneBetween(String value1, String value2) {
            addCriterion("linkphone between", value1, value2, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotBetween(String value1, String value2) {
            addCriterion("linkphone not between", value1, value2, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLandphoneIsNull() {
            addCriterion("landphone is null");
            return (Criteria) this;
        }

        public Criteria andLandphoneIsNotNull() {
            addCriterion("landphone is not null");
            return (Criteria) this;
        }

        public Criteria andLandphoneEqualTo(String value) {
            addCriterion("landphone =", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneNotEqualTo(String value) {
            addCriterion("landphone <>", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneGreaterThan(String value) {
            addCriterion("landphone >", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneGreaterThanOrEqualTo(String value) {
            addCriterion("landphone >=", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneLessThan(String value) {
            addCriterion("landphone <", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneLessThanOrEqualTo(String value) {
            addCriterion("landphone <=", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneLike(String value) {
            addCriterion("landphone like", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneNotLike(String value) {
            addCriterion("landphone not like", value, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneIn(List<String> values) {
            addCriterion("landphone in", values, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneNotIn(List<String> values) {
            addCriterion("landphone not in", values, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneBetween(String value1, String value2) {
            addCriterion("landphone between", value1, value2, "landphone");
            return (Criteria) this;
        }

        public Criteria andLandphoneNotBetween(String value1, String value2) {
            addCriterion("landphone not between", value1, value2, "landphone");
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

        public Criteria andBnumberIsNull() {
            addCriterion("bnumber is null");
            return (Criteria) this;
        }

        public Criteria andBnumberIsNotNull() {
            addCriterion("bnumber is not null");
            return (Criteria) this;
        }

        public Criteria andBnumberEqualTo(String value) {
            addCriterion("bnumber =", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberNotEqualTo(String value) {
            addCriterion("bnumber <>", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberGreaterThan(String value) {
            addCriterion("bnumber >", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberGreaterThanOrEqualTo(String value) {
            addCriterion("bnumber >=", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberLessThan(String value) {
            addCriterion("bnumber <", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberLessThanOrEqualTo(String value) {
            addCriterion("bnumber <=", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberLike(String value) {
            addCriterion("bnumber like", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberNotLike(String value) {
            addCriterion("bnumber not like", value, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberIn(List<String> values) {
            addCriterion("bnumber in", values, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberNotIn(List<String> values) {
            addCriterion("bnumber not in", values, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberBetween(String value1, String value2) {
            addCriterion("bnumber between", value1, value2, "bnumber");
            return (Criteria) this;
        }

        public Criteria andBnumberNotBetween(String value1, String value2) {
            addCriterion("bnumber not between", value1, value2, "bnumber");
            return (Criteria) this;
        }

        public Criteria andMetroidIsNull() {
            addCriterion("metroid is null");
            return (Criteria) this;
        }

        public Criteria andMetroidIsNotNull() {
            addCriterion("metroid is not null");
            return (Criteria) this;
        }

        public Criteria andMetroidEqualTo(Long value) {
            addCriterion("metroid =", value, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidNotEqualTo(Long value) {
            addCriterion("metroid <>", value, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidGreaterThan(Long value) {
            addCriterion("metroid >", value, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidGreaterThanOrEqualTo(Long value) {
            addCriterion("metroid >=", value, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidLessThan(Long value) {
            addCriterion("metroid <", value, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidLessThanOrEqualTo(Long value) {
            addCriterion("metroid <=", value, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidIn(List<Long> values) {
            addCriterion("metroid in", values, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidNotIn(List<Long> values) {
            addCriterion("metroid not in", values, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidBetween(Long value1, Long value2) {
            addCriterion("metroid between", value1, value2, "metroid");
            return (Criteria) this;
        }

        public Criteria andMetroidNotBetween(Long value1, Long value2) {
            addCriterion("metroid not between", value1, value2, "metroid");
            return (Criteria) this;
        }

        public Criteria andLandIsNull() {
            addCriterion("land is null");
            return (Criteria) this;
        }

        public Criteria andLandIsNotNull() {
            addCriterion("land is not null");
            return (Criteria) this;
        }

        public Criteria andLandEqualTo(String value) {
            addCriterion("land =", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandNotEqualTo(String value) {
            addCriterion("land <>", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandGreaterThan(String value) {
            addCriterion("land >", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandGreaterThanOrEqualTo(String value) {
            addCriterion("land >=", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandLessThan(String value) {
            addCriterion("land <", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandLessThanOrEqualTo(String value) {
            addCriterion("land <=", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandLike(String value) {
            addCriterion("land like", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandNotLike(String value) {
            addCriterion("land not like", value, "land");
            return (Criteria) this;
        }

        public Criteria andLandIn(List<String> values) {
            addCriterion("land in", values, "land");
            return (Criteria) this;
        }

        public Criteria andLandNotIn(List<String> values) {
            addCriterion("land not in", values, "land");
            return (Criteria) this;
        }

        public Criteria andLandBetween(String value1, String value2) {
            addCriterion("land between", value1, value2, "land");
            return (Criteria) this;
        }

        public Criteria andLandNotBetween(String value1, String value2) {
            addCriterion("land not between", value1, value2, "land");
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