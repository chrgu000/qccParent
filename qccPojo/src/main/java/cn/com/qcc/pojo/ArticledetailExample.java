package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticledetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticledetailExample() {
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

        public Criteria andArticledetailidIsNull() {
            addCriterion("articledetailid is null");
            return (Criteria) this;
        }

        public Criteria andArticledetailidIsNotNull() {
            addCriterion("articledetailid is not null");
            return (Criteria) this;
        }

        public Criteria andArticledetailidEqualTo(Long value) {
            addCriterion("articledetailid =", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidNotEqualTo(Long value) {
            addCriterion("articledetailid <>", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidGreaterThan(Long value) {
            addCriterion("articledetailid >", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidGreaterThanOrEqualTo(Long value) {
            addCriterion("articledetailid >=", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidLessThan(Long value) {
            addCriterion("articledetailid <", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidLessThanOrEqualTo(Long value) {
            addCriterion("articledetailid <=", value, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidIn(List<Long> values) {
            addCriterion("articledetailid in", values, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidNotIn(List<Long> values) {
            addCriterion("articledetailid not in", values, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidBetween(Long value1, Long value2) {
            addCriterion("articledetailid between", value1, value2, "articledetailid");
            return (Criteria) this;
        }

        public Criteria andArticledetailidNotBetween(Long value1, Long value2) {
            addCriterion("articledetailid not between", value1, value2, "articledetailid");
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

        public Criteria andOnetypeidIsNull() {
            addCriterion("onetypeid is null");
            return (Criteria) this;
        }

        public Criteria andOnetypeidIsNotNull() {
            addCriterion("onetypeid is not null");
            return (Criteria) this;
        }

        public Criteria andOnetypeidEqualTo(Long value) {
            addCriterion("onetypeid =", value, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidNotEqualTo(Long value) {
            addCriterion("onetypeid <>", value, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidGreaterThan(Long value) {
            addCriterion("onetypeid >", value, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("onetypeid >=", value, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidLessThan(Long value) {
            addCriterion("onetypeid <", value, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidLessThanOrEqualTo(Long value) {
            addCriterion("onetypeid <=", value, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidIn(List<Long> values) {
            addCriterion("onetypeid in", values, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidNotIn(List<Long> values) {
            addCriterion("onetypeid not in", values, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidBetween(Long value1, Long value2) {
            addCriterion("onetypeid between", value1, value2, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andOnetypeidNotBetween(Long value1, Long value2) {
            addCriterion("onetypeid not between", value1, value2, "onetypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidIsNull() {
            addCriterion("articletypeid is null");
            return (Criteria) this;
        }

        public Criteria andArticletypeidIsNotNull() {
            addCriterion("articletypeid is not null");
            return (Criteria) this;
        }

        public Criteria andArticletypeidEqualTo(Integer value) {
            addCriterion("articletypeid =", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidNotEqualTo(Integer value) {
            addCriterion("articletypeid <>", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidGreaterThan(Integer value) {
            addCriterion("articletypeid >", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("articletypeid >=", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidLessThan(Integer value) {
            addCriterion("articletypeid <", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidLessThanOrEqualTo(Integer value) {
            addCriterion("articletypeid <=", value, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidIn(List<Integer> values) {
            addCriterion("articletypeid in", values, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidNotIn(List<Integer> values) {
            addCriterion("articletypeid not in", values, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidBetween(Integer value1, Integer value2) {
            addCriterion("articletypeid between", value1, value2, "articletypeid");
            return (Criteria) this;
        }

        public Criteria andArticletypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("articletypeid not between", value1, value2, "articletypeid");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andTopdayIsNull() {
            addCriterion("topday is null");
            return (Criteria) this;
        }

        public Criteria andTopdayIsNotNull() {
            addCriterion("topday is not null");
            return (Criteria) this;
        }

        public Criteria andTopdayEqualTo(Integer value) {
            addCriterion("topday =", value, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayNotEqualTo(Integer value) {
            addCriterion("topday <>", value, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayGreaterThan(Integer value) {
            addCriterion("topday >", value, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("topday >=", value, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayLessThan(Integer value) {
            addCriterion("topday <", value, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayLessThanOrEqualTo(Integer value) {
            addCriterion("topday <=", value, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayIn(List<Integer> values) {
            addCriterion("topday in", values, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayNotIn(List<Integer> values) {
            addCriterion("topday not in", values, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayBetween(Integer value1, Integer value2) {
            addCriterion("topday between", value1, value2, "topday");
            return (Criteria) this;
        }

        public Criteria andTopdayNotBetween(Integer value1, Integer value2) {
            addCriterion("topday not between", value1, value2, "topday");
            return (Criteria) this;
        }

        public Criteria andToppricesIsNull() {
            addCriterion("topprices is null");
            return (Criteria) this;
        }

        public Criteria andToppricesIsNotNull() {
            addCriterion("topprices is not null");
            return (Criteria) this;
        }

        public Criteria andToppricesEqualTo(Integer value) {
            addCriterion("topprices =", value, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesNotEqualTo(Integer value) {
            addCriterion("topprices <>", value, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesGreaterThan(Integer value) {
            addCriterion("topprices >", value, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesGreaterThanOrEqualTo(Integer value) {
            addCriterion("topprices >=", value, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesLessThan(Integer value) {
            addCriterion("topprices <", value, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesLessThanOrEqualTo(Integer value) {
            addCriterion("topprices <=", value, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesIn(List<Integer> values) {
            addCriterion("topprices in", values, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesNotIn(List<Integer> values) {
            addCriterion("topprices not in", values, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesBetween(Integer value1, Integer value2) {
            addCriterion("topprices between", value1, value2, "topprices");
            return (Criteria) this;
        }

        public Criteria andToppricesNotBetween(Integer value1, Integer value2) {
            addCriterion("topprices not between", value1, value2, "topprices");
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