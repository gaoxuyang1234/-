package com.yxysoft.basic.service;

import java.util.List;

import com.yxysoft.basic.model.QueryVo2;
import com.yxysoft.basic.model.QueryVo3;
import com.yxysoft.basic.model.SysUser;

public interface StatementService {

	List<QueryVo3> queryStatementList(QueryVo2 vo);

}
