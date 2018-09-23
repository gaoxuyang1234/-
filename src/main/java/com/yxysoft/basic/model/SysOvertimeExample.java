package com.yxysoft.basic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysOvertimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysOvertimeExample() {
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

        public Criteria andOvertimeIdIsNull() {
            addCriterion("overtime_id is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdIsNotNull() {
            addCriterion("overtime_id is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdEqualTo(Integer value) {
            addCriterion("overtime_id =", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdNotEqualTo(Integer value) {
            addCriterion("overtime_id <>", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdGreaterThan(Integer value) {
            addCriterion("overtime_id >", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("overtime_id >=", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdLessThan(Integer value) {
            addCriterion("overtime_id <", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdLessThanOrEqualTo(Integer value) {
            addCriterion("overtime_id <=", value, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdIn(List<Integer> values) {
            addCriterion("overtime_id in", values, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdNotIn(List<Integer> values) {
            addCriterion("overtime_id not in", values, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdBetween(Integer value1, Integer value2) {
            addCriterion("overtime_id between", value1, value2, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("overtime_id not between", value1, value2, "overtimeId");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameIsNull() {
            addCriterion("overtime_name is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameIsNotNull() {
            addCriterion("overtime_name is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameEqualTo(Integer value) {
            addCriterion("overtime_name =", value, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameNotEqualTo(Integer value) {
            addCriterion("overtime_name <>", value, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameGreaterThan(Integer value) {
            addCriterion("overtime_name >", value, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("overtime_name >=", value, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameLessThan(Integer value) {
            addCriterion("overtime_name <", value, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameLessThanOrEqualTo(Integer value) {
            addCriterion("overtime_name <=", value, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameIn(List<Integer> values) {
            addCriterion("overtime_name in", values, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameNotIn(List<Integer> values) {
            addCriterion("overtime_name not in", values, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameBetween(Integer value1, Integer value2) {
            addCriterion("overtime_name between", value1, value2, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeNameNotBetween(Integer value1, Integer value2) {
            addCriterion("overtime_name not between", value1, value2, "overtimeName");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeIsNull() {
            addCriterion("overtime_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeIsNotNull() {
            addCriterion("overtime_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeEqualTo(Date value) {
            addCriterion("overtime_start_time =", value, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeNotEqualTo(Date value) {
            addCriterion("overtime_start_time <>", value, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeGreaterThan(Date value) {
            addCriterion("overtime_start_time >", value, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overtime_start_time >=", value, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeLessThan(Date value) {
            addCriterion("overtime_start_time <", value, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("overtime_start_time <=", value, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeIn(List<Date> values) {
            addCriterion("overtime_start_time in", values, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeNotIn(List<Date> values) {
            addCriterion("overtime_start_time not in", values, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeBetween(Date value1, Date value2) {
            addCriterion("overtime_start_time between", value1, value2, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("overtime_start_time not between", value1, value2, "overtimeStartTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeIsNull() {
            addCriterion("overtime_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeIsNotNull() {
            addCriterion("overtime_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeEqualTo(Date value) {
            addCriterion("overtime_end_time =", value, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeNotEqualTo(Date value) {
            addCriterion("overtime_end_time <>", value, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeGreaterThan(Date value) {
            addCriterion("overtime_end_time >", value, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overtime_end_time >=", value, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeLessThan(Date value) {
            addCriterion("overtime_end_time <", value, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("overtime_end_time <=", value, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeIn(List<Date> values) {
            addCriterion("overtime_end_time in", values, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeNotIn(List<Date> values) {
            addCriterion("overtime_end_time not in", values, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeBetween(Date value1, Date value2) {
            addCriterion("overtime_end_time between", value1, value2, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("overtime_end_time not between", value1, value2, "overtimeEndTime");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursIsNull() {
            addCriterion("overtime_hours is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursIsNotNull() {
            addCriterion("overtime_hours is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursEqualTo(BigDecimal value) {
            addCriterion("overtime_hours =", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursNotEqualTo(BigDecimal value) {
            addCriterion("overtime_hours <>", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursGreaterThan(BigDecimal value) {
            addCriterion("overtime_hours >", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_hours >=", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursLessThan(BigDecimal value) {
            addCriterion("overtime_hours <", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_hours <=", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursIn(List<BigDecimal> values) {
            addCriterion("overtime_hours in", values, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursNotIn(List<BigDecimal> values) {
            addCriterion("overtime_hours not in", values, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_hours between", value1, value2, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_hours not between", value1, value2, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonIsNull() {
            addCriterion("overtime_reason is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonIsNotNull() {
            addCriterion("overtime_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonEqualTo(String value) {
            addCriterion("overtime_reason =", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonNotEqualTo(String value) {
            addCriterion("overtime_reason <>", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonGreaterThan(String value) {
            addCriterion("overtime_reason >", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonGreaterThanOrEqualTo(String value) {
            addCriterion("overtime_reason >=", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonLessThan(String value) {
            addCriterion("overtime_reason <", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonLessThanOrEqualTo(String value) {
            addCriterion("overtime_reason <=", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonLike(String value) {
            addCriterion("overtime_reason like", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonNotLike(String value) {
            addCriterion("overtime_reason not like", value, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonIn(List<String> values) {
            addCriterion("overtime_reason in", values, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonNotIn(List<String> values) {
            addCriterion("overtime_reason not in", values, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonBetween(String value1, String value2) {
            addCriterion("overtime_reason between", value1, value2, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andOvertimeReasonNotBetween(String value1, String value2) {
            addCriterion("overtime_reason not between", value1, value2, "overtimeReason");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNull() {
            addCriterion("reviewer is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNotNull() {
            addCriterion("reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerEqualTo(Integer value) {
            addCriterion("reviewer =", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotEqualTo(Integer value) {
            addCriterion("reviewer <>", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThan(Integer value) {
            addCriterion("reviewer >", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThanOrEqualTo(Integer value) {
            addCriterion("reviewer >=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThan(Integer value) {
            addCriterion("reviewer <", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThanOrEqualTo(Integer value) {
            addCriterion("reviewer <=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerIn(List<Integer> values) {
            addCriterion("reviewer in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotIn(List<Integer> values) {
            addCriterion("reviewer not in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerBetween(Integer value1, Integer value2) {
            addCriterion("reviewer between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotBetween(Integer value1, Integer value2) {
            addCriterion("reviewer not between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerStateIsNull() {
            addCriterion("reviewer_state is null");
            return (Criteria) this;
        }

        public Criteria andReviewerStateIsNotNull() {
            addCriterion("reviewer_state is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerStateEqualTo(Integer value) {
            addCriterion("reviewer_state =", value, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateNotEqualTo(Integer value) {
            addCriterion("reviewer_state <>", value, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateGreaterThan(Integer value) {
            addCriterion("reviewer_state >", value, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("reviewer_state >=", value, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateLessThan(Integer value) {
            addCriterion("reviewer_state <", value, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateLessThanOrEqualTo(Integer value) {
            addCriterion("reviewer_state <=", value, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateIn(List<Integer> values) {
            addCriterion("reviewer_state in", values, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateNotIn(List<Integer> values) {
            addCriterion("reviewer_state not in", values, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateBetween(Integer value1, Integer value2) {
            addCriterion("reviewer_state between", value1, value2, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerStateNotBetween(Integer value1, Integer value2) {
            addCriterion("reviewer_state not between", value1, value2, "reviewerState");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonIsNull() {
            addCriterion("reviewer_reason is null");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonIsNotNull() {
            addCriterion("reviewer_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonEqualTo(String value) {
            addCriterion("reviewer_reason =", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonNotEqualTo(String value) {
            addCriterion("reviewer_reason <>", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonGreaterThan(String value) {
            addCriterion("reviewer_reason >", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reviewer_reason >=", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonLessThan(String value) {
            addCriterion("reviewer_reason <", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonLessThanOrEqualTo(String value) {
            addCriterion("reviewer_reason <=", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonLike(String value) {
            addCriterion("reviewer_reason like", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonNotLike(String value) {
            addCriterion("reviewer_reason not like", value, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonIn(List<String> values) {
            addCriterion("reviewer_reason in", values, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonNotIn(List<String> values) {
            addCriterion("reviewer_reason not in", values, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonBetween(String value1, String value2) {
            addCriterion("reviewer_reason between", value1, value2, "reviewerReason");
            return (Criteria) this;
        }

        public Criteria andReviewerReasonNotBetween(String value1, String value2) {
            addCriterion("reviewer_reason not between", value1, value2, "reviewerReason");
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