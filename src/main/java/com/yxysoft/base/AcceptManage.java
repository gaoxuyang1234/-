package com.yxysoft.base;

import java.util.Date;

public  class  AcceptManage {
    
		/**
		 * 街道等名称
		 */
		private String dName;
		/**
		 * 用于计算数量(非数据库字段)
		 */
		private Integer countNum;
		/**
		 *  业务对象Id
		 */
		private Integer aId;
		/**
		 * 业务Id
		 */
		private Integer sId;
		
		/**
		 * 部门Id
		 */
		private Integer dId;
		/**
		 * 用户Id
		 */
		private Integer uId;
		
		/**
		 * 用户名称
		 */
		private String uName;
		/**
		 * 业务事项名称
		 */
		private String sName;
		
		/**
		 * 提交时间
		 */
		private Date aTime;
		/**
		 * 状态
		 */
		private Integer state;
		/**
		 * 身份证
		 */
		private String cardNo;
		/**
		 * 手机号
		 */
		private String mobile;
		
		private String accCode;
		
		private Integer yuanFlag;
		
		private Integer zhengFlag;
		
		private Integer mail;
		//评价等级
		private Integer lev;
		
		
		
		public Integer getLev() {
			return lev;
		}

		public void setLev(Integer lev) {
			this.lev = lev;
		}

		public String getdName() {
			return dName;
		}

		public void setdName(String dName) {
			this.dName = dName;
		}

		public Integer getCountNum() {
			return countNum;
		}

		public void setCountNum(Integer countNum) {
			this.countNum = countNum;
		}

		public Integer getaId() {
			return aId;
		}

		public void setaId(Integer aId) {
			this.aId = aId;
		}

		public Integer getsId() {
			return sId;
		}

		public void setsId(Integer sId) {
			this.sId = sId;
		}

		public Integer getdId() {
			return dId;
		}

		public void setdId(Integer dId) {
			this.dId = dId;
		}

		public Integer getuId() {
			return uId;
		}

		public void setuId(Integer uId) {
			this.uId = uId;
		}

		public String getuName() {
			return uName;
		}

		public void setuName(String uName) {
			this.uName = uName;
		}

		public String getsName() {
			return sName;
		}

		public void setsName(String sName) {
			this.sName = sName;
		}

		public Date getaTime() {
			return aTime;
		}

		public void setaTime(Date aTime) {
			this.aTime = aTime;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}


		public String getAccCode() {
			return accCode;
		}

		public void setAccCode(String accCode) {
			this.accCode = accCode;
		}

		public Integer getYuanFlag() {
			return yuanFlag;
		}

		public void setYuanFlag(Integer yuanFlag) {
			this.yuanFlag = yuanFlag;
		}

		public Integer getZhengFlag() {
			return zhengFlag;
		}

		public void setZhengFlag(Integer zhengFlag) {
			this.zhengFlag = zhengFlag;
		}

		public Integer getMail() {
			return mail;
		}

		public void setMail(Integer mail) {
			this.mail = mail;
		}
		
		
		
		
}
