package com.yxysoft.basic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAskLeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAskLeaveExample() {
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

        public Criteria andLeaveIdIsNull() {
            addCriterion("leave_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaveIdIsNotNull() {
            addCriterion("leave_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveIdEqualTo(Integer value) {
            addCriterion("leave_id =", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotEqualTo(Integer value) {
            addCriterion("leave_id <>", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdGreaterThan(Integer value) {
            addCriterion("leave_id >", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_id >=", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLessThan(Integer value) {
            addCriterion("leave_id <", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLessThanOrEqualTo(Integer value) {
            addCriterion("leave_id <=", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdIn(List<Integer> values) {
            addCriterion("leave_id in", values, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotIn(List<Integer> values) {
            addCriterion("leave_id not in", values, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdBetween(Integer value1, Integer value2) {
            addCriterion("leave_id between", value1, value2, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_id not between", value1, value2, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveNameIsNull() {
            addCriterion("leave_name is null");
            return (Criteria) this;
        }

        public Criteria andLeaveNameIsNotNull() {
            addCriterion("leave_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveNameEqualTo(Integer value) {
            addCriterion("leave_name =", value, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameNotEqualTo(Integer value) {
            addCriterion("leave_name <>", value, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameGreaterThan(Integer value) {
            addCriterion("leave_name >", value, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_name >=", value, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameLessThan(Integer value) {
            addCriterion("leave_name <", value, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameLessThanOrEqualTo(Integer value) {
            addCriterion("leave_name <=", value, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameIn(List<Integer> values) {
            addCriterion("leave_name in", values, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameNotIn(List<Integer> values) {
            addCriterion("leave_name not in", values, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameBetween(Integer value1, Integer value2) {
            addCriterion("leave_name between", value1, value2, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveNameNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_name not between", value1, value2, "leaveName");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeIsNull() {
            addCriterion("leave_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeIsNotNull() {
            addCriterion("leave_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeEqualTo(Date value) {
            addCriterion("leave_start_time =", value, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeNotEqualTo(Date value) {
            addCriterion("leave_start_time <>", value, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeGreaterThan(Date value) {
            addCriterion("leave_start_time >", value, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("leave_start_time >=", value, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeLessThan(Date value) {
            addCriterion("leave_start_time <", value, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("leave_start_time <=", value, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeIn(List<Date> values) {
            addCriterion("leave_start_time in", values, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeNotIn(List<Date> values) {
            addCriterion("leave_start_time not in", values, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeBetween(Date value1, Date value2) {
            addCriterion("leave_start_time between", value1, value2, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("leave_start_time not between", value1, value2, "leaveStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeIsNull() {
            addCriterion("leave_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeIsNotNull() {
            addCriterion("leave_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeEqualTo(Date value) {
            addCriterion("leave_end_time =", value, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeNotEqualTo(Date value) {
            addCriterion("leave_end_time <>", value, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeGreaterThan(Date value) {
            addCriterion("leave_end_time >", value, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("leave_end_time >=", value, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeLessThan(Date value) {
            addCriterion("leave_end_time <", value, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("leave_end_time <=", value, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeIn(List<Date> values) {
            addCriterion("leave_end_time in", values, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeNotIn(List<Date> values) {
            addCriterion("leave_end_time not in", values, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeBetween(Date value1, Date value2) {
            addCriterion("leave_end_time between", value1, value2, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("leave_end_time not between", value1, value2, "leaveEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysIsNull() {
            addCriterion("leave_days is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysIsNotNull() {
            addCriterion("leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysEqualTo(BigDecimal value) {
            addCriterion("leave_days =", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysNotEqualTo(BigDecimal value) {
            addCriterion("leave_days <>", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysGreaterThan(BigDecimal value) {
            addCriterion("leave_days >", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("leave_days >=", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysLessThan(BigDecimal value) {
            addCriterion("leave_days <", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("leave_days <=", value, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysIn(List<BigDecimal> values) {
            addCriterion("leave_days in", values, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysNotIn(List<BigDecimal> values) {
            addCriterion("leave_days not in", values, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leave_days between", value1, value2, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leave_days not between", value1, value2, "leaveDays");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNull() {
            addCriterion("leave_reason is null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNotNull() {
            addCriterion("leave_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonEqualTo(String value) {
            addCriterion("leave_reason =", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotEqualTo(String value) {
            addCriterion("leave_reason <>", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThan(String value) {
            addCriterion("leave_reason >", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThanOrEqualTo(String value) {
            addCriterion("leave_reason >=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThan(String value) {
            addCriterion("leave_reason <", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThanOrEqualTo(String value) {
            addCriterion("leave_reason <=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLike(String value) {
            addCriterion("leave_reason like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotLike(String value) {
            addCriterion("leave_reason not like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIn(List<String> values) {
            addCriterion("leave_reason in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotIn(List<String> values) {
            addCriterion("leave_reason not in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonBetween(String value1, String value2) {
            addCriterion("leave_reason between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotBetween(String value1, String value2) {
            addCriterion("leave_reason not between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andApproverIsNull() {
            addCriterion("approver is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("approver is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(Integer value) {
            addCriterion("approver =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(Integer value) {
            addCriterion("approver <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(Integer value) {
            addCriterion("approver >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(Integer value) {
            addCriterion("approver >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(Integer value) {
            addCriterion("approver <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(Integer value) {
            addCriterion("approver <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<Integer> values) {
            addCriterion("approver in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<Integer> values) {
            addCriterion("approver not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(Integer value1, Integer value2) {
            addCriterion("approver between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(Integer value1, Integer value2) {
            addCriterion("approver not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverStateIsNull() {
            addCriterion("approver_state is null");
            return (Criteria) this;
        }

        public Criteria andApproverStateIsNotNull() {
            addCriterion("approver_state is not null");
            return (Criteria) this;
        }

        public Criteria andApproverStateEqualTo(Integer value) {
            addCriterion("approver_state =", value, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateNotEqualTo(Integer value) {
            addCriterion("approver_state <>", value, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateGreaterThan(Integer value) {
            addCriterion("approver_state >", value, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("approver_state >=", value, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateLessThan(Integer value) {
            addCriterion("approver_state <", value, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateLessThanOrEqualTo(Integer value) {
            addCriterion("approver_state <=", value, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateIn(List<Integer> values) {
            addCriterion("approver_state in", values, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateNotIn(List<Integer> values) {
            addCriterion("approver_state not in", values, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateBetween(Integer value1, Integer value2) {
            addCriterion("approver_state between", value1, value2, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverStateNotBetween(Integer value1, Integer value2) {
            addCriterion("approver_state not between", value1, value2, "approverState");
            return (Criteria) this;
        }

        public Criteria andApproverReasonIsNull() {
            addCriterion("approver_reason is null");
            return (Criteria) this;
        }

        public Criteria andApproverReasonIsNotNull() {
            addCriterion("approver_reason is not null");
            return (Criteria) this;
        }

        public Criteria andApproverReasonEqualTo(String value) {
            addCriterion("approver_reason =", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonNotEqualTo(String value) {
            addCriterion("approver_reason <>", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonGreaterThan(String value) {
            addCriterion("approver_reason >", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonGreaterThanOrEqualTo(String value) {
            addCriterion("approver_reason >=", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonLessThan(String value) {
            addCriterion("approver_reason <", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonLessThanOrEqualTo(String value) {
            addCriterion("approver_reason <=", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonLike(String value) {
            addCriterion("approver_reason like", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonNotLike(String value) {
            addCriterion("approver_reason not like", value, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonIn(List<String> values) {
            addCriterion("approver_reason in", values, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonNotIn(List<String> values) {
            addCriterion("approver_reason not in", values, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonBetween(String value1, String value2) {
            addCriterion("approver_reason between", value1, value2, "approverReason");
            return (Criteria) this;
        }

        public Criteria andApproverReasonNotBetween(String value1, String value2) {
            addCriterion("approver_reason not between", value1, value2, "approverReason");
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