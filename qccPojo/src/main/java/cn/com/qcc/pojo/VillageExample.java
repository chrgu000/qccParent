package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VillageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VillageExample() {
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

        public Criteria andVillagetypeidIsNull() {
            addCriterion("villagetypeid is null");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidIsNotNull() {
            addCriterion("villagetypeid is not null");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidEqualTo(Integer value) {
            addCriterion("villagetypeid =", value, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidNotEqualTo(Integer value) {
            addCriterion("villagetypeid <>", value, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidGreaterThan(Integer value) {
            addCriterion("villagetypeid >", value, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("villagetypeid >=", value, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidLessThan(Integer value) {
            addCriterion("villagetypeid <", value, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("villagetypeid <=", value, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidIn(List<Integer> values) {
            addCriterion("villagetypeid in", values, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidNotIn(List<Integer> values) {
            addCriterion("villagetypeid not in", values, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidBetween(Integer value1, Integer value2) {
            addCriterion("villagetypeid between", value1, value2, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("villagetypeid not between", value1, value2, "villagetypeid");
            return (Criteria) this;
        }

        public Criteria andVillagenameIsNull() {
            addCriterion("villagename is null");
            return (Criteria) this;
        }

        public Criteria andVillagenameIsNotNull() {
            addCriterion("villagename is not null");
            return (Criteria) this;
        }

        public Criteria andVillagenameEqualTo(String value) {
            addCriterion("villagename =", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameNotEqualTo(String value) {
            addCriterion("villagename <>", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameGreaterThan(String value) {
            addCriterion("villagename >", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameGreaterThanOrEqualTo(String value) {
            addCriterion("villagename >=", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameLessThan(String value) {
            addCriterion("villagename <", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameLessThanOrEqualTo(String value) {
            addCriterion("villagename <=", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameLike(String value) {
            addCriterion("villagename like", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameNotLike(String value) {
            addCriterion("villagename not like", value, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameIn(List<String> values) {
            addCriterion("villagename in", values, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameNotIn(List<String> values) {
            addCriterion("villagename not in", values, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameBetween(String value1, String value2) {
            addCriterion("villagename between", value1, value2, "villagename");
            return (Criteria) this;
        }

        public Criteria andVillagenameNotBetween(String value1, String value2) {
            addCriterion("villagename not between", value1, value2, "villagename");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Long value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Long value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Long value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Long value1, Long value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Long value1, Long value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andHousecountIsNull() {
            addCriterion("housecount is null");
            return (Criteria) this;
        }

        public Criteria andHousecountIsNotNull() {
            addCriterion("housecount is not null");
            return (Criteria) this;
        }

        public Criteria andHousecountEqualTo(String value) {
            addCriterion("housecount =", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountNotEqualTo(String value) {
            addCriterion("housecount <>", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountGreaterThan(String value) {
            addCriterion("housecount >", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountGreaterThanOrEqualTo(String value) {
            addCriterion("housecount >=", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountLessThan(String value) {
            addCriterion("housecount <", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountLessThanOrEqualTo(String value) {
            addCriterion("housecount <=", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountLike(String value) {
            addCriterion("housecount like", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountNotLike(String value) {
            addCriterion("housecount not like", value, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountIn(List<String> values) {
            addCriterion("housecount in", values, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountNotIn(List<String> values) {
            addCriterion("housecount not in", values, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountBetween(String value1, String value2) {
            addCriterion("housecount between", value1, value2, "housecount");
            return (Criteria) this;
        }

        public Criteria andHousecountNotBetween(String value1, String value2) {
            addCriterion("housecount not between", value1, value2, "housecount");
            return (Criteria) this;
        }

        public Criteria andComyearIsNull() {
            addCriterion("comyear is null");
            return (Criteria) this;
        }

        public Criteria andComyearIsNotNull() {
            addCriterion("comyear is not null");
            return (Criteria) this;
        }

        public Criteria andComyearEqualTo(String value) {
            addCriterion("comyear =", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearNotEqualTo(String value) {
            addCriterion("comyear <>", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearGreaterThan(String value) {
            addCriterion("comyear >", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearGreaterThanOrEqualTo(String value) {
            addCriterion("comyear >=", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearLessThan(String value) {
            addCriterion("comyear <", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearLessThanOrEqualTo(String value) {
            addCriterion("comyear <=", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearLike(String value) {
            addCriterion("comyear like", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearNotLike(String value) {
            addCriterion("comyear not like", value, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearIn(List<String> values) {
            addCriterion("comyear in", values, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearNotIn(List<String> values) {
            addCriterion("comyear not in", values, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearBetween(String value1, String value2) {
            addCriterion("comyear between", value1, value2, "comyear");
            return (Criteria) this;
        }

        public Criteria andComyearNotBetween(String value1, String value2) {
            addCriterion("comyear not between", value1, value2, "comyear");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCarfreeIsNull() {
            addCriterion("carfree is null");
            return (Criteria) this;
        }

        public Criteria andCarfreeIsNotNull() {
            addCriterion("carfree is not null");
            return (Criteria) this;
        }

        public Criteria andCarfreeEqualTo(String value) {
            addCriterion("carfree =", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeNotEqualTo(String value) {
            addCriterion("carfree <>", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeGreaterThan(String value) {
            addCriterion("carfree >", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeGreaterThanOrEqualTo(String value) {
            addCriterion("carfree >=", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeLessThan(String value) {
            addCriterion("carfree <", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeLessThanOrEqualTo(String value) {
            addCriterion("carfree <=", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeLike(String value) {
            addCriterion("carfree like", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeNotLike(String value) {
            addCriterion("carfree not like", value, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeIn(List<String> values) {
            addCriterion("carfree in", values, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeNotIn(List<String> values) {
            addCriterion("carfree not in", values, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeBetween(String value1, String value2) {
            addCriterion("carfree between", value1, value2, "carfree");
            return (Criteria) this;
        }

        public Criteria andCarfreeNotBetween(String value1, String value2) {
            addCriterion("carfree not between", value1, value2, "carfree");
            return (Criteria) this;
        }

        public Criteria andComfreeIsNull() {
            addCriterion("comfree is null");
            return (Criteria) this;
        }

        public Criteria andComfreeIsNotNull() {
            addCriterion("comfree is not null");
            return (Criteria) this;
        }

        public Criteria andComfreeEqualTo(String value) {
            addCriterion("comfree =", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeNotEqualTo(String value) {
            addCriterion("comfree <>", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeGreaterThan(String value) {
            addCriterion("comfree >", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeGreaterThanOrEqualTo(String value) {
            addCriterion("comfree >=", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeLessThan(String value) {
            addCriterion("comfree <", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeLessThanOrEqualTo(String value) {
            addCriterion("comfree <=", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeLike(String value) {
            addCriterion("comfree like", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeNotLike(String value) {
            addCriterion("comfree not like", value, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeIn(List<String> values) {
            addCriterion("comfree in", values, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeNotIn(List<String> values) {
            addCriterion("comfree not in", values, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeBetween(String value1, String value2) {
            addCriterion("comfree between", value1, value2, "comfree");
            return (Criteria) this;
        }

        public Criteria andComfreeNotBetween(String value1, String value2) {
            addCriterion("comfree not between", value1, value2, "comfree");
            return (Criteria) this;
        }

        public Criteria andComphoneIsNull() {
            addCriterion("comphone is null");
            return (Criteria) this;
        }

        public Criteria andComphoneIsNotNull() {
            addCriterion("comphone is not null");
            return (Criteria) this;
        }

        public Criteria andComphoneEqualTo(String value) {
            addCriterion("comphone =", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneNotEqualTo(String value) {
            addCriterion("comphone <>", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneGreaterThan(String value) {
            addCriterion("comphone >", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneGreaterThanOrEqualTo(String value) {
            addCriterion("comphone >=", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneLessThan(String value) {
            addCriterion("comphone <", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneLessThanOrEqualTo(String value) {
            addCriterion("comphone <=", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneLike(String value) {
            addCriterion("comphone like", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneNotLike(String value) {
            addCriterion("comphone not like", value, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneIn(List<String> values) {
            addCriterion("comphone in", values, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneNotIn(List<String> values) {
            addCriterion("comphone not in", values, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneBetween(String value1, String value2) {
            addCriterion("comphone between", value1, value2, "comphone");
            return (Criteria) this;
        }

        public Criteria andComphoneNotBetween(String value1, String value2) {
            addCriterion("comphone not between", value1, value2, "comphone");
            return (Criteria) this;
        }

        public Criteria andCarcountIsNull() {
            addCriterion("carcount is null");
            return (Criteria) this;
        }

        public Criteria andCarcountIsNotNull() {
            addCriterion("carcount is not null");
            return (Criteria) this;
        }

        public Criteria andCarcountEqualTo(String value) {
            addCriterion("carcount =", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountNotEqualTo(String value) {
            addCriterion("carcount <>", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountGreaterThan(String value) {
            addCriterion("carcount >", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountGreaterThanOrEqualTo(String value) {
            addCriterion("carcount >=", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountLessThan(String value) {
            addCriterion("carcount <", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountLessThanOrEqualTo(String value) {
            addCriterion("carcount <=", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountLike(String value) {
            addCriterion("carcount like", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountNotLike(String value) {
            addCriterion("carcount not like", value, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountIn(List<String> values) {
            addCriterion("carcount in", values, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountNotIn(List<String> values) {
            addCriterion("carcount not in", values, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountBetween(String value1, String value2) {
            addCriterion("carcount between", value1, value2, "carcount");
            return (Criteria) this;
        }

        public Criteria andCarcountNotBetween(String value1, String value2) {
            addCriterion("carcount not between", value1, value2, "carcount");
            return (Criteria) this;
        }

        public Criteria andComcountIsNull() {
            addCriterion("comcount is null");
            return (Criteria) this;
        }

        public Criteria andComcountIsNotNull() {
            addCriterion("comcount is not null");
            return (Criteria) this;
        }

        public Criteria andComcountEqualTo(String value) {
            addCriterion("comcount =", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountNotEqualTo(String value) {
            addCriterion("comcount <>", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountGreaterThan(String value) {
            addCriterion("comcount >", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountGreaterThanOrEqualTo(String value) {
            addCriterion("comcount >=", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountLessThan(String value) {
            addCriterion("comcount <", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountLessThanOrEqualTo(String value) {
            addCriterion("comcount <=", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountLike(String value) {
            addCriterion("comcount like", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountNotLike(String value) {
            addCriterion("comcount not like", value, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountIn(List<String> values) {
            addCriterion("comcount in", values, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountNotIn(List<String> values) {
            addCriterion("comcount not in", values, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountBetween(String value1, String value2) {
            addCriterion("comcount between", value1, value2, "comcount");
            return (Criteria) this;
        }

        public Criteria andComcountNotBetween(String value1, String value2) {
            addCriterion("comcount not between", value1, value2, "comcount");
            return (Criteria) this;
        }

        public Criteria andDevephoneIsNull() {
            addCriterion("devephone is null");
            return (Criteria) this;
        }

        public Criteria andDevephoneIsNotNull() {
            addCriterion("devephone is not null");
            return (Criteria) this;
        }

        public Criteria andDevephoneEqualTo(String value) {
            addCriterion("devephone =", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneNotEqualTo(String value) {
            addCriterion("devephone <>", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneGreaterThan(String value) {
            addCriterion("devephone >", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneGreaterThanOrEqualTo(String value) {
            addCriterion("devephone >=", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneLessThan(String value) {
            addCriterion("devephone <", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneLessThanOrEqualTo(String value) {
            addCriterion("devephone <=", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneLike(String value) {
            addCriterion("devephone like", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneNotLike(String value) {
            addCriterion("devephone not like", value, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneIn(List<String> values) {
            addCriterion("devephone in", values, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneNotIn(List<String> values) {
            addCriterion("devephone not in", values, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneBetween(String value1, String value2) {
            addCriterion("devephone between", value1, value2, "devephone");
            return (Criteria) this;
        }

        public Criteria andDevephoneNotBetween(String value1, String value2) {
            addCriterion("devephone not between", value1, value2, "devephone");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNull() {
            addCriterion("developer is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNotNull() {
            addCriterion("developer is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperEqualTo(String value) {
            addCriterion("developer =", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotEqualTo(String value) {
            addCriterion("developer <>", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThan(String value) {
            addCriterion("developer >", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThanOrEqualTo(String value) {
            addCriterion("developer >=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThan(String value) {
            addCriterion("developer <", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThanOrEqualTo(String value) {
            addCriterion("developer <=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLike(String value) {
            addCriterion("developer like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotLike(String value) {
            addCriterion("developer not like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperIn(List<String> values) {
            addCriterion("developer in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotIn(List<String> values) {
            addCriterion("developer not in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperBetween(String value1, String value2) {
            addCriterion("developer between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotBetween(String value1, String value2) {
            addCriterion("developer not between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andVillagephoneIsNull() {
            addCriterion("villagephone is null");
            return (Criteria) this;
        }

        public Criteria andVillagephoneIsNotNull() {
            addCriterion("villagephone is not null");
            return (Criteria) this;
        }

        public Criteria andVillagephoneEqualTo(String value) {
            addCriterion("villagephone =", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneNotEqualTo(String value) {
            addCriterion("villagephone <>", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneGreaterThan(String value) {
            addCriterion("villagephone >", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneGreaterThanOrEqualTo(String value) {
            addCriterion("villagephone >=", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneLessThan(String value) {
            addCriterion("villagephone <", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneLessThanOrEqualTo(String value) {
            addCriterion("villagephone <=", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneLike(String value) {
            addCriterion("villagephone like", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneNotLike(String value) {
            addCriterion("villagephone not like", value, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneIn(List<String> values) {
            addCriterion("villagephone in", values, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneNotIn(List<String> values) {
            addCriterion("villagephone not in", values, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneBetween(String value1, String value2) {
            addCriterion("villagephone between", value1, value2, "villagephone");
            return (Criteria) this;
        }

        public Criteria andVillagephoneNotBetween(String value1, String value2) {
            addCriterion("villagephone not between", value1, value2, "villagephone");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
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

        public Criteria andBdidIsNull() {
            addCriterion("bdid is null");
            return (Criteria) this;
        }

        public Criteria andBdidIsNotNull() {
            addCriterion("bdid is not null");
            return (Criteria) this;
        }

        public Criteria andBdidEqualTo(String value) {
            addCriterion("bdid =", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotEqualTo(String value) {
            addCriterion("bdid <>", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidGreaterThan(String value) {
            addCriterion("bdid >", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidGreaterThanOrEqualTo(String value) {
            addCriterion("bdid >=", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidLessThan(String value) {
            addCriterion("bdid <", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidLessThanOrEqualTo(String value) {
            addCriterion("bdid <=", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidLike(String value) {
            addCriterion("bdid like", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotLike(String value) {
            addCriterion("bdid not like", value, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidIn(List<String> values) {
            addCriterion("bdid in", values, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotIn(List<String> values) {
            addCriterion("bdid not in", values, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidBetween(String value1, String value2) {
            addCriterion("bdid between", value1, value2, "bdid");
            return (Criteria) this;
        }

        public Criteria andBdidNotBetween(String value1, String value2) {
            addCriterion("bdid not between", value1, value2, "bdid");
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