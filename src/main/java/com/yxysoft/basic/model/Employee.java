package com.yxysoft.basic.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="user对象",description="用户对象user")
public class Employee {
    @ApiModelProperty(value="ID",name="id",required=false,hidden=true)
    private Long id;
    
    @ApiModelProperty(value="用户名",name="name",required=true,example="xingguo")
    private String name;
    

    @ApiModelProperty(value="密码",name="pwd",required=true)
    private String pwd;

	private Integer sex;

    private Date createdTime;

    public Employee(Long id, String name, String pwd, Integer sex, Date createdTime) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.createdTime = createdTime;
    }

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}