package com.yxysoft.basic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

public class QueryVo {

    //通过5个条件查询  1 姓名 2 工号  3 状态
    //姓名
    private String username;
    //工号
    private Integer usercode;
    //状态
    private Integer state;


    //时间（段）


    private String beginDate;


    private String endDate;

    //shijian
    private String shijian;

	   /*//今天
		private String today;
		//昨天
		private String tomorrow;
		//本周
		private String week;
		//上周
		private String lastweek;
		//本月
		private String month;
		//上月
		private String lastmonth;*/


	    
	    


    private Integer currentPage;

    private Integer pagesize;

    private Integer start;


    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }


    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


   // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setBeginDate(String beginDate) {
        System.out.println("11111111111");
        System.out.println(beginDate);
        this.beginDate = beginDate;
    }


    public String getBeginDate() {
        System.out.println("2222222");
        return beginDate;
    }


   // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")


    public String getEndDate() {
        return endDate;
    }

   // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
