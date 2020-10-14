package com.piltover.user.entity;

import java.util.ArrayList;
import java.util.List;

public class MallUserDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallUserDetailExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNull() {
            addCriterion("user_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNotNull() {
            addCriterion("user_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameEqualTo(String value) {
            addCriterion("user_nick_name =", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotEqualTo(String value) {
            addCriterion("user_nick_name <>", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThan(String value) {
            addCriterion("user_nick_name >", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nick_name >=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThan(String value) {
            addCriterion("user_nick_name <", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("user_nick_name <=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLike(String value) {
            addCriterion("user_nick_name like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotLike(String value) {
            addCriterion("user_nick_name not like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIn(List<String> values) {
            addCriterion("user_nick_name in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotIn(List<String> values) {
            addCriterion("user_nick_name not in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameBetween(String value1, String value2) {
            addCriterion("user_nick_name between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotBetween(String value1, String value2) {
            addCriterion("user_nick_name not between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserHeightIsNull() {
            addCriterion("user_height is null");
            return (Criteria) this;
        }

        public Criteria andUserHeightIsNotNull() {
            addCriterion("user_height is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeightEqualTo(String value) {
            addCriterion("user_height =", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotEqualTo(String value) {
            addCriterion("user_height <>", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightGreaterThan(String value) {
            addCriterion("user_height >", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightGreaterThanOrEqualTo(String value) {
            addCriterion("user_height >=", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightLessThan(String value) {
            addCriterion("user_height <", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightLessThanOrEqualTo(String value) {
            addCriterion("user_height <=", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightLike(String value) {
            addCriterion("user_height like", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotLike(String value) {
            addCriterion("user_height not like", value, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightIn(List<String> values) {
            addCriterion("user_height in", values, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotIn(List<String> values) {
            addCriterion("user_height not in", values, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightBetween(String value1, String value2) {
            addCriterion("user_height between", value1, value2, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserHeightNotBetween(String value1, String value2) {
            addCriterion("user_height not between", value1, value2, "userHeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightIsNull() {
            addCriterion("user_weight is null");
            return (Criteria) this;
        }

        public Criteria andUserWeightIsNotNull() {
            addCriterion("user_weight is not null");
            return (Criteria) this;
        }

        public Criteria andUserWeightEqualTo(String value) {
            addCriterion("user_weight =", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotEqualTo(String value) {
            addCriterion("user_weight <>", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightGreaterThan(String value) {
            addCriterion("user_weight >", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightGreaterThanOrEqualTo(String value) {
            addCriterion("user_weight >=", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightLessThan(String value) {
            addCriterion("user_weight <", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightLessThanOrEqualTo(String value) {
            addCriterion("user_weight <=", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightLike(String value) {
            addCriterion("user_weight like", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotLike(String value) {
            addCriterion("user_weight not like", value, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightIn(List<String> values) {
            addCriterion("user_weight in", values, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotIn(List<String> values) {
            addCriterion("user_weight not in", values, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightBetween(String value1, String value2) {
            addCriterion("user_weight between", value1, value2, "userWeight");
            return (Criteria) this;
        }

        public Criteria andUserWeightNotBetween(String value1, String value2) {
            addCriterion("user_weight not between", value1, value2, "userWeight");
            return (Criteria) this;
        }

        public Criteria andAllNameIsNull() {
            addCriterion("all_name is null");
            return (Criteria) this;
        }

        public Criteria andAllNameIsNotNull() {
            addCriterion("all_name is not null");
            return (Criteria) this;
        }

        public Criteria andAllNameEqualTo(String value) {
            addCriterion("all_name =", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameNotEqualTo(String value) {
            addCriterion("all_name <>", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameGreaterThan(String value) {
            addCriterion("all_name >", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameGreaterThanOrEqualTo(String value) {
            addCriterion("all_name >=", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameLessThan(String value) {
            addCriterion("all_name <", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameLessThanOrEqualTo(String value) {
            addCriterion("all_name <=", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameLike(String value) {
            addCriterion("all_name like", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameNotLike(String value) {
            addCriterion("all_name not like", value, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameIn(List<String> values) {
            addCriterion("all_name in", values, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameNotIn(List<String> values) {
            addCriterion("all_name not in", values, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameBetween(String value1, String value2) {
            addCriterion("all_name between", value1, value2, "allName");
            return (Criteria) this;
        }

        public Criteria andAllNameNotBetween(String value1, String value2) {
            addCriterion("all_name not between", value1, value2, "allName");
            return (Criteria) this;
        }

        public Criteria andWeaponIsNull() {
            addCriterion("weapon is null");
            return (Criteria) this;
        }

        public Criteria andWeaponIsNotNull() {
            addCriterion("weapon is not null");
            return (Criteria) this;
        }

        public Criteria andWeaponEqualTo(String value) {
            addCriterion("weapon =", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotEqualTo(String value) {
            addCriterion("weapon <>", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponGreaterThan(String value) {
            addCriterion("weapon >", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponGreaterThanOrEqualTo(String value) {
            addCriterion("weapon >=", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponLessThan(String value) {
            addCriterion("weapon <", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponLessThanOrEqualTo(String value) {
            addCriterion("weapon <=", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponLike(String value) {
            addCriterion("weapon like", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotLike(String value) {
            addCriterion("weapon not like", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponIn(List<String> values) {
            addCriterion("weapon in", values, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotIn(List<String> values) {
            addCriterion("weapon not in", values, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponBetween(String value1, String value2) {
            addCriterion("weapon between", value1, value2, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotBetween(String value1, String value2) {
            addCriterion("weapon not between", value1, value2, "weapon");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andSkillIsNull() {
            addCriterion("skill is null");
            return (Criteria) this;
        }

        public Criteria andSkillIsNotNull() {
            addCriterion("skill is not null");
            return (Criteria) this;
        }

        public Criteria andSkillEqualTo(String value) {
            addCriterion("skill =", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotEqualTo(String value) {
            addCriterion("skill <>", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThan(String value) {
            addCriterion("skill >", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThanOrEqualTo(String value) {
            addCriterion("skill >=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThan(String value) {
            addCriterion("skill <", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThanOrEqualTo(String value) {
            addCriterion("skill <=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLike(String value) {
            addCriterion("skill like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotLike(String value) {
            addCriterion("skill not like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillIn(List<String> values) {
            addCriterion("skill in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotIn(List<String> values) {
            addCriterion("skill not in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillBetween(String value1, String value2) {
            addCriterion("skill between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotBetween(String value1, String value2) {
            addCriterion("skill not between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIsNull() {
            addCriterion("head_portrait is null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIsNotNull() {
            addCriterion("head_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitEqualTo(String value) {
            addCriterion("head_portrait =", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotEqualTo(String value) {
            addCriterion("head_portrait <>", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitGreaterThan(String value) {
            addCriterion("head_portrait >", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("head_portrait >=", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLessThan(String value) {
            addCriterion("head_portrait <", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLessThanOrEqualTo(String value) {
            addCriterion("head_portrait <=", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLike(String value) {
            addCriterion("head_portrait like", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotLike(String value) {
            addCriterion("head_portrait not like", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIn(List<String> values) {
            addCriterion("head_portrait in", values, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotIn(List<String> values) {
            addCriterion("head_portrait not in", values, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitBetween(String value1, String value2) {
            addCriterion("head_portrait between", value1, value2, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotBetween(String value1, String value2) {
            addCriterion("head_portrait not between", value1, value2, "headPortrait");
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