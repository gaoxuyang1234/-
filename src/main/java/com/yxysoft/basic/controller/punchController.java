package com.yxysoft.basic.controller;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.service.punchService;




@Controller
@RequestMapping("/punch")
public class punchController {

	@Autowired
	private punchService punchS;

	
	
	@ResponseBody
	@RequestMapping(value="/list")
    public List<SysPunchIn> querypunchlist(QueryVo vo){
		
		//通过条件查询
		List<SysPunchIn>list= punchS.querypunchlist(vo);
		
	
		return list;
	}
	
	//回显 方法
	@ResponseBody
	@RequestMapping(value="/list1")
    public List<SysPunchIn> querypunchlist1(Integer punchId){
		
		//通过条件查询
		List<SysPunchIn>  list= punchS.selectByPrimaryKey(punchId);
		
	
		return list;
	}
	
/*	分页
 * public PageBean<SysPunchIn> querypunchlist(QueryVo vo){
		
		//通过条件查询
		PageBean<SysPunchIn> page= punchS.querypunchlist(vo);
		
	
		return page;
	}
	*/
	
		
		

	
	
}
