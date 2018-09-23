package com.yxysoft.basic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAdministratorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAdministratorExample() {
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

        public Criteria andAdministratorIdIsNull() {
            addCriterion("administrator_id is null");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdIsNotNull() {
            addCriterion("administrator_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdEqualTo(Integer value) {
            addCriterion("administrator_id =", value, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdNotEqualTo(Integer value) {
            addCriterion("administrator_id <>", value, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdGreaterThan(Integer value) {
            addCriterion("administrator_id >", value, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("administrator_id >=", value, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdLessThan(Integer value) {
            addCriterion("administrator_id <", value, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdLessThanOrEqualTo(Integer value) {
            addCriterion("administrator_id <=", value, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdIn(List<Integer> values) {
            addCriterion("administrator_id in", values, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdNotIn(List<Integer> values) {
            addCriterion("administrator_id not in", values, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdBetween(Integer value1, Integer value2) {
            addCriterion("administrator_id between", value1, value2, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("administrator_id not between", value1, value2, "administratorId");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameIsNull() {
            addCriterion("administrator_name is null");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameIsNotNull() {
            addCriterion("administrator_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameEqualTo(String value) {
            addCriterion("administrator_name =", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameNotEqualTo(String value) {
            addCriterion("administrator_name <>", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameGreaterThan(String value) {
            addCriterion("administrator_name >", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameGreaterThanOrEqualTo(String value) {
            addCriterion("administrator_name >=", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameLessThan(String value) {
            addCriterion("administrator_name <", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameLessThanOrEqualTo(String value) {
            addCriterion("administrator_name <=", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameLike(String value) {
            addCriterion("administrator_name like", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameNotLike(String value) {
            addCriterion("administrator_name not like", value, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameIn(List<String> values) {
            addCriterion("administrator_name in", values, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameNotIn(List<String> values) {
            addCriterion("administrator_name not in", values, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameBetween(String value1, String value2) {
            addCriterion("administrator_name between", value1, value2, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorNameNotBetween(String value1, String value2) {
            addCriterion("administrator_name not between", value1, value2, "administratorName");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeIsNull() {
            addCriterion("administrator_code is null");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeIsNotNull() {
            addCriterion("administrator_code is not null");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeEqualTo(String value) {
            addCriterion("administrator_code =", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeNotEqualTo(String value) {
            addCriterion("administrator_code <>", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeGreaterThan(String value) {
            addCriterion("administrator_code >", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("administrator_code >=", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeLessThan(String value) {
            addCriterion("administrator_code <", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeLessThanOrEqualTo(String value) {
            addCriterion("administrator_code <=", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeLike(String value) {
            addCriterion("administrator_code like", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeNotLike(String value) {
            addCriterion("administrator_code not like", value, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeIn(List<String> values) {
            addCriterion("administrator_code in", values, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeNotIn(List<String> values) {
            addCriterion("administrator_code not in", values, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeBetween(String value1, String value2) {
            addCriterion("administrator_code between", value1, value2, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andAdministratorCodeNotBetween(String value1, String value2) {
            addCriterion("administrator_code not between", value1, value2, "administratorCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andDepIdIsNull() {
            addCriterion("dep_id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(Integer value) {
            addCriterion("dep_id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(Integer value) {
            addCriterion("dep_id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(Integer value) {
            addCriterion("dep_id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dep_id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(Integer value) {
            addCriterion("dep_id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(Integer value) {
            addCriterion("dep_id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<Integer> values) {
            addCriterion("dep_id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<Integer> values) {
            addCriterion("dep_id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(Integer value1, Integer value2) {
            addCriterion("dep_id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dep_id not between", value1, value2, "depId");
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