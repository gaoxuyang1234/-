package com.yxysoft.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yxysoft.basic.mapper.SysPunchInMapper;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysPunchIn;





@Service
public class punchServiceImpl implements punchService{

	//注入接口
	@Autowired
	private  SysPunchInMapper sysPunchInM;
	

	
	
/*//分页通过条件查询数据
	public PageBean<SysPunchIn> querypunchlist(QueryVo vo) {
		// 设置查询条件,从哪一条数据开始查
		vo.setStart((vo.getCurrentPage() - 1) * vo.getPagesize());
		 //list
		List<SysPunchIn> list=(List<SysPunchIn>) sysPunchInM.querypunchlist(vo);
		
		// 封装返回的page对象
		PageBean<SysPunchIn> page = new PageBean<>( vo.getCurrentPage(),vo.getPagesize(),list);
		
		return page;
	}
*/

	public List<SysPunchIn> querypunchlist(QueryVo vo) {
	
		 //list
		List<SysPunchIn> list= sysPunchInM.querypunchlist(vo);
		
		
		return list;
	}



//回显
	@Override
	public List<SysPunchIn> selectByPrimaryKey(Integer punchId) {
		
		List<SysPunchIn> s=sysPunchInM.selecthuixian(punchId);
		return s;
	}


	}

	

