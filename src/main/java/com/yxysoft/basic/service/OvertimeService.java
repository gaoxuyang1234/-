package com.yxysoft.basic.service;

import java.util.List;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysOvertime;

public interface  OvertimeService {

	List<SysOvertime> queryOvertimelist(QueryVo vo,Integer currentPage,Integer pagesize);

	List<SysOvertime> queryOvertimelist(QueryVo vo);

	//修改
	int OvertimeUpdate(SysOvertime overtime);

	//获取点击的加班信息
	SysOvertime overtimeinfo(Integer oid);

	int deleteovertime(Integer oid);

}
