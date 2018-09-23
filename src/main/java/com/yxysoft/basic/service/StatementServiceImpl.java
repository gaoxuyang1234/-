package com.yxysoft.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.SysUserMapper;
import com.yxysoft.basic.model.QueryVo2;
import com.yxysoft.basic.model.QueryVo3;
import com.yxysoft.basic.model.SysUser;
@Service
public class StatementServiceImpl implements StatementService{

	@Autowired
	private SysUserMapper sysUserM;
	
	public List<QueryVo3> queryStatementList(QueryVo2 vo) {
		List<QueryVo3> list=sysUserM.queryStatementList(vo);
		return list;
	}
	

}
