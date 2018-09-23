package com.yxysoft.basic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPunchInExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SysPunchInExample() {
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

		public Criteria andPunchIdIsNull() {
			addCriterion("punch_id is null");
			return (Criteria) this;
		}

		public Criteria andPunchIdIsNotNull() {
			addCriterion("punch_id is not null");
			return (Criteria) this;
		}

		public Criteria andPunchIdEqualTo(Integer value) {
			addCriterion("punch_id =", value, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdNotEqualTo(Integer value) {
			addCriterion("punch_id <>", value, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdGreaterThan(Integer value) {
			addCriterion("punch_id >", value, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("punch_id >=", value, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdLessThan(Integer value) {
			addCriterion("punch_id <", value, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdLessThanOrEqualTo(Integer value) {
			addCriterion("punch_id <=", value, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdIn(List<Integer> values) {
			addCriterion("punch_id in", values, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdNotIn(List<Integer> values) {
			addCriterion("punch_id not in", values, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdBetween(Integer value1, Integer value2) {
			addCriterion("punch_id between", value1, value2, "punchId");
			return (Criteria) this;
		}

		public Criteria andPunchIdNotBetween(Integer value1, Integer value2) {
			addCriterion("punch_id not between", value1, value2, "punchId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeIsNull() {
			addCriterion("punch_start_time is null");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeIsNotNull() {
			addCriterion("punch_start_time is not null");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeEqualTo(Date value) {
			addCriterion("punch_start_time =", value, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeNotEqualTo(Date value) {
			addCriterion("punch_start_time <>", value, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeGreaterThan(Date value) {
			addCriterion("punch_start_time >", value, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("punch_start_time >=", value, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeLessThan(Date value) {
			addCriterion("punch_start_time <", value, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("punch_start_time <=", value, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeIn(List<Date> values) {
			addCriterion("punch_start_time in", values, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeNotIn(List<Date> values) {
			addCriterion("punch_start_time not in", values, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeBetween(Date value1, Date value2) {
			addCriterion("punch_start_time between", value1, value2, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("punch_start_time not between", value1, value2, "punchStartTime");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceIsNull() {
			addCriterion("punch_place is null");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceIsNotNull() {
			addCriterion("punch_place is not null");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceEqualTo(String value) {
			addCriterion("punch_place =", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceNotEqualTo(String value) {
			addCriterion("punch_place <>", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceGreaterThan(String value) {
			addCriterion("punch_place >", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceGreaterThanOrEqualTo(String value) {
			addCriterion("punch_place >=", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceLessThan(String value) {
			addCriterion("punch_place <", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceLessThanOrEqualTo(String value) {
			addCriterion("punch_place <=", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceLike(String value) {
			addCriterion("punch_place like", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceNotLike(String value) {
			addCriterion("punch_place not like", value, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceIn(List<String> values) {
			addCriterion("punch_place in", values, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceNotIn(List<String> values) {
			addCriterion("punch_place not in", values, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceBetween(String value1, String value2) {
			addCriterion("punch_place between", value1, value2, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPunchPlaceNotBetween(String value1, String value2) {
			addCriterion("punch_place not between", value1, value2, "punchPlace");
			return (Criteria) this;
		}

		public Criteria andPicturePathIsNull() {
			addCriterion("picture_path is null");
			return (Criteria) this;
		}

		public Criteria andPicturePathIsNotNull() {
			addCriterion("picture_path is not null");
			return (Criteria) this;
		}

		public Criteria andPicturePathEqualTo(String value) {
			addCriterion("picture_path =", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotEqualTo(String value) {
			addCriterion("picture_path <>", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathGreaterThan(String value) {
			addCriterion("picture_path >", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathGreaterThanOrEqualTo(String value) {
			addCriterion("picture_path >=", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathLessThan(String value) {
			addCriterion("picture_path <", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathLessThanOrEqualTo(String value) {
			addCriterion("picture_path <=", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathLike(String value) {
			addCriterion("picture_path like", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotLike(String value) {
			addCriterion("picture_path not like", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathIn(List<String> values) {
			addCriterion("picture_path in", values, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotIn(List<String> values) {
			addCriterion("picture_path not in", values, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathBetween(String value1, String value2) {
			addCriterion("picture_path between", value1, value2, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotBetween(String value1, String value2) {
			addCriterion("picture_path not between", value1, value2, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPunchReasonIsNull() {
			addCriterion("punch_reason is null");
			return (Criteria) this;
		}

		public Criteria andPunchReasonIsNotNull() {
			addCriterion("punch_reason is not null");
			return (Criteria) this;
		}

		public Criteria andPunchReasonEqualTo(String value) {
			addCriterion("punch_reason =", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonNotEqualTo(String value) {
			addCriterion("punch_reason <>", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonGreaterThan(String value) {
			addCriterion("punch_reason >", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonGreaterThanOrEqualTo(String value) {
			addCriterion("punch_reason >=", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonLessThan(String value) {
			addCriterion("punch_reason <", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonLessThanOrEqualTo(String value) {
			addCriterion("punch_reason <=", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonLike(String value) {
			addCriterion("punch_reason like", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonNotLike(String value) {
			addCriterion("punch_reason not like", value, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonIn(List<String> values) {
			addCriterion("punch_reason in", values, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonNotIn(List<String> values) {
			addCriterion("punch_reason not in", values, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonBetween(String value1, String value2) {
			addCriterion("punch_reason between", value1, value2, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchReasonNotBetween(String value1, String value2) {
			addCriterion("punch_reason not between", value1, value2, "punchReason");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeIsNull() {
			addCriterion("punch_end_time is null");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeIsNotNull() {
			addCriterion("punch_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeEqualTo(Date value) {
			addCriterion("punch_end_time =", value, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeNotEqualTo(Date value) {
			addCriterion("punch_end_time <>", value, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeGreaterThan(Date value) {
			addCriterion("punch_end_time >", value, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("punch_end_time >=", value, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeLessThan(Date value) {
			addCriterion("punch_end_time <", value, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("punch_end_time <=", value, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeIn(List<Date> values) {
			addCriterion("punch_end_time in", values, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeNotIn(List<Date> values) {
			addCriterion("punch_end_time not in", values, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeBetween(Date value1, Date value2) {
			addCriterion("punch_end_time between", value1, value2, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andPunchEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("punch_end_time not between", value1, value2, "punchEndTime");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceIsNull() {
			addCriterion("sign_back_place is null");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceIsNotNull() {
			addCriterion("sign_back_place is not null");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceEqualTo(String value) {
			addCriterion("sign_back_place =", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceNotEqualTo(String value) {
			addCriterion("sign_back_place <>", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceGreaterThan(String value) {
			addCriterion("sign_back_place >", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceGreaterThanOrEqualTo(String value) {
			addCriterion("sign_back_place >=", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceLessThan(String value) {
			addCriterion("sign_back_place <", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceLessThanOrEqualTo(String value) {
			addCriterion("sign_back_place <=", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceLike(String value) {
			addCriterion("sign_back_place like", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceNotLike(String value) {
			addCriterion("sign_back_place not like", value, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceIn(List<String> values) {
			addCriterion("sign_back_place in", values, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceNotIn(List<String> values) {
			addCriterion("sign_back_place not in", values, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceBetween(String value1, String value2) {
			addCriterion("sign_back_place between", value1, value2, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPlaceNotBetween(String value1, String value2) {
			addCriterion("sign_back_place not between", value1, value2, "signBackPlace");
			return (Criteria) this;
		}

		public Criteria andSignBackPathIsNull() {
			addCriterion("sign_back_path is null");
			return (Criteria) this;
		}

		public Criteria andSignBackPathIsNotNull() {
			addCriterion("sign_back_path is not null");
			return (Criteria) this;
		}

		public Criteria andSignBackPathEqualTo(String value) {
			addCriterion("sign_back_path =", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathNotEqualTo(String value) {
			addCriterion("sign_back_path <>", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathGreaterThan(String value) {
			addCriterion("sign_back_path >", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathGreaterThanOrEqualTo(String value) {
			addCriterion("sign_back_path >=", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathLessThan(String value) {
			addCriterion("sign_back_path <", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathLessThanOrEqualTo(String value) {
			addCriterion("sign_back_path <=", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathLike(String value) {
			addCriterion("sign_back_path like", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathNotLike(String value) {
			addCriterion("sign_back_path not like", value, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathIn(List<String> values) {
			addCriterion("sign_back_path in", values, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathNotIn(List<String> values) {
			addCriterion("sign_back_path not in", values, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathBetween(String value1, String value2) {
			addCriterion("sign_back_path between", value1, value2, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackPathNotBetween(String value1, String value2) {
			addCriterion("sign_back_path not between", value1, value2, "signBackPath");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonIsNull() {
			addCriterion("sign_back_reason is null");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonIsNotNull() {
			addCriterion("sign_back_reason is not null");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonEqualTo(String value) {
			addCriterion("sign_back_reason =", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonNotEqualTo(String value) {
			addCriterion("sign_back_reason <>", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonGreaterThan(String value) {
			addCriterion("sign_back_reason >", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonGreaterThanOrEqualTo(String value) {
			addCriterion("sign_back_reason >=", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonLessThan(String value) {
			addCriterion("sign_back_reason <", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonLessThanOrEqualTo(String value) {
			addCriterion("sign_back_reason <=", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonLike(String value) {
			addCriterion("sign_back_reason like", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonNotLike(String value) {
			addCriterion("sign_back_reason not like", value, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonIn(List<String> values) {
			addCriterion("sign_back_reason in", values, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonNotIn(List<String> values) {
			addCriterion("sign_back_reason not in", values, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonBetween(String value1, String value2) {
			addCriterion("sign_back_reason between", value1, value2, "signBackReason");
			return (Criteria) this;
		}

		public Criteria andSignBackReasonNotBetween(String value1, String value2) {
			addCriterion("sign_back_reason not between", value1, value2, "signBackReason");
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

		public Criteria andPunchStateIsNull() {
			addCriterion("punch_state is null");
			return (Criteria) this;
		}

		public Criteria andPunchStateIsNotNull() {
			addCriterion("punch_state is not null");
			return (Criteria) this;
		}

		public Criteria andPunchStateEqualTo(String value) {
			addCriterion("punch_state =", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateNotEqualTo(String value) {
			addCriterion("punch_state <>", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateGreaterThan(String value) {
			addCriterion("punch_state >", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateGreaterThanOrEqualTo(String value) {
			addCriterion("punch_state >=", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateLessThan(String value) {
			addCriterion("punch_state <", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateLessThanOrEqualTo(String value) {
			addCriterion("punch_state <=", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateLike(String value) {
			addCriterion("punch_state like", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateNotLike(String value) {
			addCriterion("punch_state not like", value, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateIn(List<String> values) {
			addCriterion("punch_state in", values, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateNotIn(List<String> values) {
			addCriterion("punch_state not in", values, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateBetween(String value1, String value2) {
			addCriterion("punch_state between", value1, value2, "punchState");
			return (Criteria) this;
		}

		public Criteria andPunchStateNotBetween(String value1, String value2) {
			addCriterion("punch_state not between", value1, value2, "punchState");
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

		public Criteria andSignBackStateIsNull() {
			addCriterion("sign_back_state is null");
			return (Criteria) this;
		}

		public Criteria andSignBackStateIsNotNull() {
			addCriterion("sign_back_state is not null");
			return (Criteria) this;
		}

		public Criteria andSignBackStateEqualTo(Integer value) {
			addCriterion("sign_back_state =", value, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateNotEqualTo(Integer value) {
			addCriterion("sign_back_state <>", value, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateGreaterThan(Integer value) {
			addCriterion("sign_back_state >", value, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("sign_back_state >=", value, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateLessThan(Integer value) {
			addCriterion("sign_back_state <", value, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateLessThanOrEqualTo(Integer value) {
			addCriterion("sign_back_state <=", value, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateIn(List<Integer> values) {
			addCriterion("sign_back_state in", values, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateNotIn(List<Integer> values) {
			addCriterion("sign_back_state not in", values, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateBetween(Integer value1, Integer value2) {
			addCriterion("sign_back_state between", value1, value2, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignBackStateNotBetween(Integer value1, Integer value2) {
			addCriterion("sign_back_state not between", value1, value2, "signBackState");
			return (Criteria) this;
		}

		public Criteria andSignInStateIsNull() {
			addCriterion("sign_in_state is null");
			return (Criteria) this;
		}

		public Criteria andSignInStateIsNotNull() {
			addCriterion("sign_in_state is not null");
			return (Criteria) this;
		}

		public Criteria andSignInStateEqualTo(Integer value) {
			addCriterion("sign_in_state =", value, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateNotEqualTo(Integer value) {
			addCriterion("sign_in_state <>", value, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateGreaterThan(Integer value) {
			addCriterion("sign_in_state >", value, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("sign_in_state >=", value, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateLessThan(Integer value) {
			addCriterion("sign_in_state <", value, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateLessThanOrEqualTo(Integer value) {
			addCriterion("sign_in_state <=", value, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateIn(List<Integer> values) {
			addCriterion("sign_in_state in", values, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateNotIn(List<Integer> values) {
			addCriterion("sign_in_state not in", values, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateBetween(Integer value1, Integer value2) {
			addCriterion("sign_in_state between", value1, value2, "signInState");
			return (Criteria) this;
		}

		public Criteria andSignInStateNotBetween(Integer value1, Integer value2) {
			addCriterion("sign_in_state not between", value1, value2, "signInState");
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