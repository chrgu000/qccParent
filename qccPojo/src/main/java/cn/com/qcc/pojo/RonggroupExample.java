package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RonggroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RonggroupExample() {
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

        public Criteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(Long value) {
            addCriterion("groupid =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(Long value) {
            addCriterion("groupid <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(Long value) {
            addCriterion("groupid >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(Long value) {
            addCriterion("groupid >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(Long value) {
            addCriterion("groupid <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(Long value) {
            addCriterion("groupid <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<Long> values) {
            addCriterion("groupid in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<Long> values) {
            addCriterion("groupid not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(Long value1, Long value2) {
            addCriterion("groupid between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(Long value1, Long value2) {
            addCriterion("groupid not between", value1, value2, "groupid");
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

        public Criteria andGrouptypeidIsNull() {
            addCriterion("grouptypeid is null");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidIsNotNull() {
            addCriterion("grouptypeid is not null");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidEqualTo(Long value) {
            addCriterion("grouptypeid =", value, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidNotEqualTo(Long value) {
            addCriterion("grouptypeid <>", value, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidGreaterThan(Long value) {
            addCriterion("grouptypeid >", value, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("grouptypeid >=", value, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidLessThan(Long value) {
            addCriterion("grouptypeid <", value, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidLessThanOrEqualTo(Long value) {
            addCriterion("grouptypeid <=", value, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidIn(List<Long> values) {
            addCriterion("grouptypeid in", values, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidNotIn(List<Long> values) {
            addCriterion("grouptypeid not in", values, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidBetween(Long value1, Long value2) {
            addCriterion("grouptypeid between", value1, value2, "grouptypeid");
            return (Criteria) this;
        }

        public Criteria andGrouptypeidNotBetween(Long value1, Long value2) {
            addCriterion("grouptypeid not between", value1, value2, "grouptypeid");
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

        public Criteria andAddressnameIsNull() {
            addCriterion("addressname is null");
            return (Criteria) this;
        }

        public Criteria andAddressnameIsNotNull() {
            addCriterion("addressname is not null");
            return (Criteria) this;
        }

        public Criteria andAddressnameEqualTo(String value) {
            addCriterion("addressname =", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameNotEqualTo(String value) {
            addCriterion("addressname <>", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameGreaterThan(String value) {
            addCriterion("addressname >", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameGreaterThanOrEqualTo(String value) {
            addCriterion("addressname >=", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameLessThan(String value) {
            addCriterion("addressname <", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameLessThanOrEqualTo(String value) {
            addCriterion("addressname <=", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameLike(String value) {
            addCriterion("addressname like", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameNotLike(String value) {
            addCriterion("addressname not like", value, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameIn(List<String> values) {
            addCriterion("addressname in", values, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameNotIn(List<String> values) {
            addCriterion("addressname not in", values, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameBetween(String value1, String value2) {
            addCriterion("addressname between", value1, value2, "addressname");
            return (Criteria) this;
        }

        public Criteria andAddressnameNotBetween(String value1, String value2) {
            addCriterion("addressname not between", value1, value2, "addressname");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andJointypeIsNull() {
            addCriterion("jointype is null");
            return (Criteria) this;
        }

        public Criteria andJointypeIsNotNull() {
            addCriterion("jointype is not null");
            return (Criteria) this;
        }

        public Criteria andJointypeEqualTo(Integer value) {
            addCriterion("jointype =", value, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeNotEqualTo(Integer value) {
            addCriterion("jointype <>", value, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeGreaterThan(Integer value) {
            addCriterion("jointype >", value, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("jointype >=", value, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeLessThan(Integer value) {
            addCriterion("jointype <", value, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeLessThanOrEqualTo(Integer value) {
            addCriterion("jointype <=", value, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeIn(List<Integer> values) {
            addCriterion("jointype in", values, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeNotIn(List<Integer> values) {
            addCriterion("jointype not in", values, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeBetween(Integer value1, Integer value2) {
            addCriterion("jointype between", value1, value2, "jointype");
            return (Criteria) this;
        }

        public Criteria andJointypeNotBetween(Integer value1, Integer value2) {
            addCriterion("jointype not between", value1, value2, "jointype");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeIsNull() {
            addCriterion("beinvitemode is null");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeIsNotNull() {
            addCriterion("beinvitemode is not null");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeEqualTo(Integer value) {
            addCriterion("beinvitemode =", value, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeNotEqualTo(Integer value) {
            addCriterion("beinvitemode <>", value, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeGreaterThan(Integer value) {
            addCriterion("beinvitemode >", value, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("beinvitemode >=", value, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeLessThan(Integer value) {
            addCriterion("beinvitemode <", value, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeLessThanOrEqualTo(Integer value) {
            addCriterion("beinvitemode <=", value, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeIn(List<Integer> values) {
            addCriterion("beinvitemode in", values, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeNotIn(List<Integer> values) {
            addCriterion("beinvitemode not in", values, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeBetween(Integer value1, Integer value2) {
            addCriterion("beinvitemode between", value1, value2, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andBeinvitemodeNotBetween(Integer value1, Integer value2) {
            addCriterion("beinvitemode not between", value1, value2, "beinvitemode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeIsNull() {
            addCriterion("uptinfomode is null");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeIsNotNull() {
            addCriterion("uptinfomode is not null");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeEqualTo(Integer value) {
            addCriterion("uptinfomode =", value, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeNotEqualTo(Integer value) {
            addCriterion("uptinfomode <>", value, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeGreaterThan(Integer value) {
            addCriterion("uptinfomode >", value, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("uptinfomode >=", value, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeLessThan(Integer value) {
            addCriterion("uptinfomode <", value, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeLessThanOrEqualTo(Integer value) {
            addCriterion("uptinfomode <=", value, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeIn(List<Integer> values) {
            addCriterion("uptinfomode in", values, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeNotIn(List<Integer> values) {
            addCriterion("uptinfomode not in", values, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeBetween(Integer value1, Integer value2) {
            addCriterion("uptinfomode between", value1, value2, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andUptinfomodeNotBetween(Integer value1, Integer value2) {
            addCriterion("uptinfomode not between", value1, value2, "uptinfomode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeIsNull() {
            addCriterion("invitemode is null");
            return (Criteria) this;
        }

        public Criteria andInvitemodeIsNotNull() {
            addCriterion("invitemode is not null");
            return (Criteria) this;
        }

        public Criteria andInvitemodeEqualTo(Integer value) {
            addCriterion("invitemode =", value, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeNotEqualTo(Integer value) {
            addCriterion("invitemode <>", value, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeGreaterThan(Integer value) {
            addCriterion("invitemode >", value, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitemode >=", value, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeLessThan(Integer value) {
            addCriterion("invitemode <", value, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeLessThanOrEqualTo(Integer value) {
            addCriterion("invitemode <=", value, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeIn(List<Integer> values) {
            addCriterion("invitemode in", values, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeNotIn(List<Integer> values) {
            addCriterion("invitemode not in", values, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeBetween(Integer value1, Integer value2) {
            addCriterion("invitemode between", value1, value2, "invitemode");
            return (Criteria) this;
        }

        public Criteria andInvitemodeNotBetween(Integer value1, Integer value2) {
            addCriterion("invitemode not between", value1, value2, "invitemode");
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