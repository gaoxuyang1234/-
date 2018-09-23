package com.yxysoft.basic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCardExample() {
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

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(Integer value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(Integer value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(Integer value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(Integer value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<Integer> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<Integer> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(Integer value1, Integer value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdIsNull() {
            addCriterion("card_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCardUserIdIsNotNull() {
            addCriterion("card_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardUserIdEqualTo(Integer value) {
            addCriterion("card_user_id =", value, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdNotEqualTo(Integer value) {
            addCriterion("card_user_id <>", value, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdGreaterThan(Integer value) {
            addCriterion("card_user_id >", value, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_user_id >=", value, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdLessThan(Integer value) {
            addCriterion("card_user_id <", value, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("card_user_id <=", value, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdIn(List<Integer> values) {
            addCriterion("card_user_id in", values, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdNotIn(List<Integer> values) {
            addCriterion("card_user_id not in", values, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdBetween(Integer value1, Integer value2) {
            addCriterion("card_user_id between", value1, value2, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("card_user_id not between", value1, value2, "cardUserId");
            return (Criteria) this;
        }

        public Criteria andCardTimeIsNull() {
            addCriterion("card_time is null");
            return (Criteria) this;
        }

        public Criteria andCardTimeIsNotNull() {
            addCriterion("card_time is not null");
            return (Criteria) this;
        }

        public Criteria andCardTimeEqualTo(Date value) {
            addCriterion("card_time =", value, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeNotEqualTo(Date value) {
            addCriterion("card_time <>", value, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeGreaterThan(Date value) {
            addCriterion("card_time >", value, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("card_time >=", value, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeLessThan(Date value) {
            addCriterion("card_time <", value, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeLessThanOrEqualTo(Date value) {
            addCriterion("card_time <=", value, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeIn(List<Date> values) {
            addCriterion("card_time in", values, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeNotIn(List<Date> values) {
            addCriterion("card_time not in", values, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeBetween(Date value1, Date value2) {
            addCriterion("card_time between", value1, value2, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardTimeNotBetween(Date value1, Date value2) {
            addCriterion("card_time not between", value1, value2, "cardTime");
            return (Criteria) this;
        }

        public Criteria andCardPlaceIsNull() {
            addCriterion("card_place is null");
            return (Criteria) this;
        }

        public Criteria andCardPlaceIsNotNull() {
            addCriterion("card_place is not null");
            return (Criteria) this;
        }

        public Criteria andCardPlaceEqualTo(String value) {
            addCriterion("card_place =", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceNotEqualTo(String value) {
            addCriterion("card_place <>", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceGreaterThan(String value) {
            addCriterion("card_place >", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("card_place >=", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceLessThan(String value) {
            addCriterion("card_place <", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceLessThanOrEqualTo(String value) {
            addCriterion("card_place <=", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceLike(String value) {
            addCriterion("card_place like", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceNotLike(String value) {
            addCriterion("card_place not like", value, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceIn(List<String> values) {
            addCriterion("card_place in", values, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceNotIn(List<String> values) {
            addCriterion("card_place not in", values, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceBetween(String value1, String value2) {
            addCriterion("card_place between", value1, value2, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardPlaceNotBetween(String value1, String value2) {
            addCriterion("card_place not between", value1, value2, "cardPlace");
            return (Criteria) this;
        }

        public Criteria andCardReasonIsNull() {
            addCriterion("card_reason is null");
            return (Criteria) this;
        }

        public Criteria andCardReasonIsNotNull() {
            addCriterion("card_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCardReasonEqualTo(String value) {
            addCriterion("card_reason =", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonNotEqualTo(String value) {
            addCriterion("card_reason <>", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonGreaterThan(String value) {
            addCriterion("card_reason >", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonGreaterThanOrEqualTo(String value) {
            addCriterion("card_reason >=", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonLessThan(String value) {
            addCriterion("card_reason <", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonLessThanOrEqualTo(String value) {
            addCriterion("card_reason <=", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonLike(String value) {
            addCriterion("card_reason like", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonNotLike(String value) {
            addCriterion("card_reason not like", value, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonIn(List<String> values) {
            addCriterion("card_reason in", values, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonNotIn(List<String> values) {
            addCriterion("card_reason not in", values, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonBetween(String value1, String value2) {
            addCriterion("card_reason between", value1, value2, "cardReason");
            return (Criteria) this;
        }

        public Criteria andCardReasonNotBetween(String value1, String value2) {
            addCriterion("card_reason not between", value1, value2, "cardReason");
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

        public Criteria andSatteIsNull() {
            addCriterion("satte is null");
            return (Criteria) this;
        }

        public Criteria andSatteIsNotNull() {
            addCriterion("satte is not null");
            return (Criteria) this;
        }

        public Criteria andSatteEqualTo(Integer value) {
            addCriterion("satte =", value, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteNotEqualTo(Integer value) {
            addCriterion("satte <>", value, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteGreaterThan(Integer value) {
            addCriterion("satte >", value, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteGreaterThanOrEqualTo(Integer value) {
            addCriterion("satte >=", value, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteLessThan(Integer value) {
            addCriterion("satte <", value, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteLessThanOrEqualTo(Integer value) {
            addCriterion("satte <=", value, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteIn(List<Integer> values) {
            addCriterion("satte in", values, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteNotIn(List<Integer> values) {
            addCriterion("satte not in", values, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteBetween(Integer value1, Integer value2) {
            addCriterion("satte between", value1, value2, "satte");
            return (Criteria) this;
        }

        public Criteria andSatteNotBetween(Integer value1, Integer value2) {
            addCriterion("satte not between", value1, value2, "satte");
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