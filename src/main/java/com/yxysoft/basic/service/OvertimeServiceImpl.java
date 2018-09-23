package com.yxysoft.basic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.SysOvertimeMapper;
import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysOvertime;

@Service
public class OvertimeServiceImpl implements OvertimeService {

	@Autowired
	private SysOvertimeMapper sysOvertimeM;
	
	public List<SysOvertime> queryOvertimelist(QueryVo vo, Integer currentPage, Integer pagesize) {
		PageHelper.startPage(currentPage, pagesize);
		List<SysOvertime> list = sysOvertimeM.queryOvertimelist(vo);
		return list;
	}

	public List<SysOvertime> queryOvertimelist(QueryVo vo) {

		return  sysOvertimeM.queryOvertimelist(vo);
	}



	//修改
	public int OvertimeUpdate(SysOvertime overtime) {
		 return sysOvertimeM.updateByPrimaryKeySelective(overtime);
		
		
	}

     //根据id查找加班信息
	public 	SysOvertime overtimeinfo(Integer oid){
		return this.sysOvertimeM.overtimeList(oid);


	}


	public int deleteovertime(Integer oid){

		return this.sysOvertimeM.deleteovertime(oid);
	}

}
