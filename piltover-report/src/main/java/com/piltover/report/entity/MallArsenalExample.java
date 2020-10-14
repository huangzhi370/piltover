package com.piltover.report.entity;

import java.util.ArrayList;
import java.util.List;

public class MallArsenalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallArsenalExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArsenalNameIsNull() {
            addCriterion("arsenal_name is null");
            return (Criteria) this;
        }

        public Criteria andArsenalNameIsNotNull() {
            addCriterion("arsenal_name is not null");
            return (Criteria) this;
        }

        public Criteria andArsenalNameEqualTo(String value) {
            addCriterion("arsenal_name =", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameNotEqualTo(String value) {
            addCriterion("arsenal_name <>", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameGreaterThan(String value) {
            addCriterion("arsenal_name >", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameGreaterThanOrEqualTo(String value) {
            addCriterion("arsenal_name >=", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameLessThan(String value) {
            addCriterion("arsenal_name <", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameLessThanOrEqualTo(String value) {
            addCriterion("arsenal_name <=", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameLike(String value) {
            addCriterion("arsenal_name like", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameNotLike(String value) {
            addCriterion("arsenal_name not like", value, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameIn(List<String> values) {
            addCriterion("arsenal_name in", values, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameNotIn(List<String> values) {
            addCriterion("arsenal_name not in", values, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameBetween(String value1, String value2) {
            addCriterion("arsenal_name between", value1, value2, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalNameNotBetween(String value1, String value2) {
            addCriterion("arsenal_name not between", value1, value2, "arsenalName");
            return (Criteria) this;
        }

        public Criteria andArsenalDescIsNull() {
            addCriterion("arsenal_desc is null");
            return (Criteria) this;
        }

        public Criteria andArsenalDescIsNotNull() {
            addCriterion("arsenal_desc is not null");
            return (Criteria) this;
        }

        public Criteria andArsenalDescEqualTo(String value) {
            addCriterion("arsenal_desc =", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescNotEqualTo(String value) {
            addCriterion("arsenal_desc <>", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescGreaterThan(String value) {
            addCriterion("arsenal_desc >", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescGreaterThanOrEqualTo(String value) {
            addCriterion("arsenal_desc >=", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescLessThan(String value) {
            addCriterion("arsenal_desc <", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescLessThanOrEqualTo(String value) {
            addCriterion("arsenal_desc <=", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescLike(String value) {
            addCriterion("arsenal_desc like", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescNotLike(String value) {
            addCriterion("arsenal_desc not like", value, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescIn(List<String> values) {
            addCriterion("arsenal_desc in", values, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescNotIn(List<String> values) {
            addCriterion("arsenal_desc not in", values, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescBetween(String value1, String value2) {
            addCriterion("arsenal_desc between", value1, value2, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andArsenalDescNotBetween(String value1, String value2) {
            addCriterion("arsenal_desc not between", value1, value2, "arsenalDesc");
            return (Criteria) this;
        }

        public Criteria andHolderIsNull() {
            addCriterion("holder is null");
            return (Criteria) this;
        }

        public Criteria andHolderIsNotNull() {
            addCriterion("holder is not null");
            return (Criteria) this;
        }

        public Criteria andHolderEqualTo(String value) {
            addCriterion("holder =", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotEqualTo(String value) {
            addCriterion("holder <>", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderGreaterThan(String value) {
            addCriterion("holder >", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderGreaterThanOrEqualTo(String value) {
            addCriterion("holder >=", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderLessThan(String value) {
            addCriterion("holder <", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderLessThanOrEqualTo(String value) {
            addCriterion("holder <=", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderLike(String value) {
            addCriterion("holder like", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotLike(String value) {
            addCriterion("holder not like", value, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderIn(List<String> values) {
            addCriterion("holder in", values, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotIn(List<String> values) {
            addCriterion("holder not in", values, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderBetween(String value1, String value2) {
            addCriterion("holder between", value1, value2, "holder");
            return (Criteria) this;
        }

        public Criteria andHolderNotBetween(String value1, String value2) {
            addCriterion("holder not between", value1, value2, "holder");
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