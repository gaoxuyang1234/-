package com.yxysoft.basic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QueryVo3 {

	private String  user_name;
	private String user_code;
	private String department;
	private Date  create_time;
	private Integer p1;
	private Integer p2;
	private Integer p4;
	private Integer p5;
	

	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getP1() {
		return p1;
	}
	public void setP1(Integer p1) {
		this.p1 = p1;
	}
	public Integer getP2() {
		return p2;
	}
	public void setP2(Integer p2) {
		this.p2 = p2;
	}
	public Integer getP4() {
		return p4;
	}
	public void setP4(Integer p4) {
		this.p4 = p4;
	}
	public Integer getP5() {
		return p5;
	}
	public void setP5(Integer p5) {
		this.p5 = p5;
	}
	
}
