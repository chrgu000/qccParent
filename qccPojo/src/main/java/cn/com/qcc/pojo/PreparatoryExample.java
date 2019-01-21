package cn.com.qcc.pojo;

import java.util.ArrayList;
import java.util.List;

public class PreparatoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PreparatoryExample() {
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

        public Criteria andPreparatoryidIsNull() {
            addCriterion("preparatoryid is null");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidIsNotNull() {
            addCriterion("preparatoryid is not null");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidEqualTo(Long value) {
            addCriterion("preparatoryid =", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidNotEqualTo(Long value) {
            addCriterion("preparatoryid <>", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidGreaterThan(Long value) {
            addCriterion("preparatoryid >", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidGreaterThanOrEqualTo(Long value) {
            addCriterion("preparatoryid >=", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidLessThan(Long value) {
            addCriterion("preparatoryid <", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidLessThanOrEqualTo(Long value) {
            addCriterion("preparatoryid <=", value, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidIn(List<Long> values) {
            addCriterion("preparatoryid in", values, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidNotIn(List<Long> values) {
            addCriterion("preparatoryid not in", values, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidBetween(Long value1, Long value2) {
            addCriterion("preparatoryid between", value1, value2, "preparatoryid");
            return (Criteria) this;
        }

        public Criteria andPreparatoryidNotBetween(Long value1, Long value2) {
            addCriterion("preparatoryid not between", value1, value2, "preparatoryid");
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

        public Criteria andHousetagidIsNull() {
            addCriterion("housetagid is null");
            return (Criteria) this;
        }

        public Criteria andHousetagidIsNotNull() {
            addCriterion("housetagid is not null");
            return (Criteria) this;
        }

        public Criteria andHousetagidEqualTo(Long value) {
            addCriterion("housetagid =", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotEqualTo(Long value) {
            addCriterion("housetagid <>", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidGreaterThan(Long value) {
            addCriterion("housetagid >", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidGreaterThanOrEqualTo(Long value) {
            addCriterion("housetagid >=", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidLessThan(Long value) {
            addCriterion("housetagid <", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidLessThanOrEqualTo(Long value) {
            addCriterion("housetagid <=", value, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidIn(List<Long> values) {
            addCriterion("housetagid in", values, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotIn(List<Long> values) {
            addCriterion("housetagid not in", values, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidBetween(Long value1, Long value2) {
            addCriterion("housetagid between", value1, value2, "housetagid");
            return (Criteria) this;
        }

        public Criteria andHousetagidNotBetween(Long value1, Long value2) {
            addCriterion("housetagid not between", value1, value2, "housetagid");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumIsNull() {
            addCriterion("centpercentnum is null");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumIsNotNull() {
            addCriterion("centpercentnum is not null");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumEqualTo(Double value) {
            addCriterion("centpercentnum =", value, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumNotEqualTo(Double value) {
            addCriterion("centpercentnum <>", value, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumGreaterThan(Double value) {
            addCriterion("centpercentnum >", value, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumGreaterThanOrEqualTo(Double value) {
            addCriterion("centpercentnum >=", value, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumLessThan(Double value) {
            addCriterion("centpercentnum <", value, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumLessThanOrEqualTo(Double value) {
            addCriterion("centpercentnum <=", value, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumIn(List<Double> values) {
            addCriterion("centpercentnum in", values, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumNotIn(List<Double> values) {
            addCriterion("centpercentnum not in", values, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumBetween(Double value1, Double value2) {
            addCriterion("centpercentnum between", value1, value2, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andCentpercentnumNotBetween(Double value1, Double value2) {
            addCriterion("centpercentnum not between", value1, value2, "centpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumIsNull() {
            addCriterion("landpercentnum is null");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumIsNotNull() {
            addCriterion("landpercentnum is not null");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumEqualTo(Double value) {
            addCriterion("landpercentnum =", value, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumNotEqualTo(Double value) {
            addCriterion("landpercentnum <>", value, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumGreaterThan(Double value) {
            addCriterion("landpercentnum >", value, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumGreaterThanOrEqualTo(Double value) {
            addCriterion("landpercentnum >=", value, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumLessThan(Double value) {
            addCriterion("landpercentnum <", value, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumLessThanOrEqualTo(Double value) {
            addCriterion("landpercentnum <=", value, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumIn(List<Double> values) {
            addCriterion("landpercentnum in", values, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumNotIn(List<Double> values) {
            addCriterion("landpercentnum not in", values, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumBetween(Double value1, Double value2) {
            addCriterion("landpercentnum between", value1, value2, "landpercentnum");
            return (Criteria) this;
        }

        public Criteria andLandpercentnumNotBetween(Double value1, Double value2) {
            addCriterion("landpercentnum not between", value1, value2, "landpercentnum");
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