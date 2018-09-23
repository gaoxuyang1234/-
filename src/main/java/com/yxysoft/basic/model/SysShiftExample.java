package com.yxysoft.basic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysShiftExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysShiftExample() {
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

        public Criteria andShiftIdIsNull() {
            addCriterion("shift_id is null");
            return (Criteria) this;
        }

        public Criteria andShiftIdIsNotNull() {
            addCriterion("shift_id is not null");
            return (Criteria) this;
        }

        public Criteria andShiftIdEqualTo(Integer value) {
            addCriterion("shift_id =", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotEqualTo(Integer value) {
            addCriterion("shift_id <>", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdGreaterThan(Integer value) {
            addCriterion("shift_id >", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shift_id >=", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdLessThan(Integer value) {
            addCriterion("shift_id <", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdLessThanOrEqualTo(Integer value) {
            addCriterion("shift_id <=", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdIn(List<Integer> values) {
            addCriterion("shift_id in", values, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotIn(List<Integer> values) {
            addCriterion("shift_id not in", values, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdBetween(Integer value1, Integer value2) {
            addCriterion("shift_id between", value1, value2, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shift_id not between", value1, value2, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftNameIsNull() {
            addCriterion("shift_name is null");
            return (Criteria) this;
        }

        public Criteria andShiftNameIsNotNull() {
            addCriterion("shift_name is not null");
            return (Criteria) this;
        }

        public Criteria andShiftNameEqualTo(String value) {
            addCriterion("shift_name =", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotEqualTo(String value) {
            addCriterion("shift_name <>", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameGreaterThan(String value) {
            addCriterion("shift_name >", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameGreaterThanOrEqualTo(String value) {
            addCriterion("shift_name >=", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameLessThan(String value) {
            addCriterion("shift_name <", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameLessThanOrEqualTo(String value) {
            addCriterion("shift_name <=", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameLike(String value) {
            addCriterion("shift_name like", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotLike(String value) {
            addCriterion("shift_name not like", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameIn(List<String> values) {
            addCriterion("shift_name in", values, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotIn(List<String> values) {
            addCriterion("shift_name not in", values, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameBetween(String value1, String value2) {
            addCriterion("shift_name between", value1, value2, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotBetween(String value1, String value2) {
            addCriterion("shift_name not between", value1, value2, "shiftName");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeIsNull() {
            addCriterion("start_hour_time is null");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeIsNotNull() {
            addCriterion("start_hour_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeEqualTo(Integer value) {
            addCriterion("start_hour_time =", value, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeNotEqualTo(Integer value) {
            addCriterion("start_hour_time <>", value, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeGreaterThan(Integer value) {
            addCriterion("start_hour_time >", value, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_hour_time >=", value, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeLessThan(Integer value) {
            addCriterion("start_hour_time <", value, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeLessThanOrEqualTo(Integer value) {
            addCriterion("start_hour_time <=", value, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeIn(List<Integer> values) {
            addCriterion("start_hour_time in", values, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeNotIn(List<Integer> values) {
            addCriterion("start_hour_time not in", values, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeBetween(Integer value1, Integer value2) {
            addCriterion("start_hour_time between", value1, value2, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartHourTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("start_hour_time not between", value1, value2, "startHourTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeIsNull() {
            addCriterion("start_minute_time is null");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeIsNotNull() {
            addCriterion("start_minute_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeEqualTo(Integer value) {
            addCriterion("start_minute_time =", value, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeNotEqualTo(Integer value) {
            addCriterion("start_minute_time <>", value, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeGreaterThan(Integer value) {
            addCriterion("start_minute_time >", value, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_minute_time >=", value, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeLessThan(Integer value) {
            addCriterion("start_minute_time <", value, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeLessThanOrEqualTo(Integer value) {
            addCriterion("start_minute_time <=", value, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeIn(List<Integer> values) {
            addCriterion("start_minute_time in", values, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeNotIn(List<Integer> values) {
            addCriterion("start_minute_time not in", values, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeBetween(Integer value1, Integer value2) {
            addCriterion("start_minute_time between", value1, value2, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andStartMinuteTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("start_minute_time not between", value1, value2, "startMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeIsNull() {
            addCriterion("end_hour_time is null");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeIsNotNull() {
            addCriterion("end_hour_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeEqualTo(Integer value) {
            addCriterion("end_hour_time =", value, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeNotEqualTo(Integer value) {
            addCriterion("end_hour_time <>", value, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeGreaterThan(Integer value) {
            addCriterion("end_hour_time >", value, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_hour_time >=", value, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeLessThan(Integer value) {
            addCriterion("end_hour_time <", value, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeLessThanOrEqualTo(Integer value) {
            addCriterion("end_hour_time <=", value, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeIn(List<Integer> values) {
            addCriterion("end_hour_time in", values, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeNotIn(List<Integer> values) {
            addCriterion("end_hour_time not in", values, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeBetween(Integer value1, Integer value2) {
            addCriterion("end_hour_time between", value1, value2, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndHourTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("end_hour_time not between", value1, value2, "endHourTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeIsNull() {
            addCriterion("end_minute_time is null");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeIsNotNull() {
            addCriterion("end_minute_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeEqualTo(Integer value) {
            addCriterion("end_minute_time =", value, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeNotEqualTo(Integer value) {
            addCriterion("end_minute_time <>", value, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeGreaterThan(Integer value) {
            addCriterion("end_minute_time >", value, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_minute_time >=", value, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeLessThan(Integer value) {
            addCriterion("end_minute_time <", value, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeLessThanOrEqualTo(Integer value) {
            addCriterion("end_minute_time <=", value, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeIn(List<Integer> values) {
            addCriterion("end_minute_time in", values, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeNotIn(List<Integer> values) {
            addCriterion("end_minute_time not in", values, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeBetween(Integer value1, Integer value2) {
            addCriterion("end_minute_time between", value1, value2, "endMinuteTime");
            return (Criteria) this;
        }

        public Criteria andEndMinuteTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("end_minute_time not between", value1, value2, "endMinuteTime");
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