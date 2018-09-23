package com.yxysoft.basic.service;


import java.util.List;


import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysPunchIn;


public interface punchService {



	//list没分页
	List<SysPunchIn> querypunchlist(QueryVo vo);
   //回显
	List<SysPunchIn> selectByPrimaryKey(Integer punchId);

	//list 分页
	//PageBean<SysPunchIn> querypunchlist(QueryVo vo);



	


}
