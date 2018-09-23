package com.yxysoft.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.ViewQxzwBusApplyObjMapper;
import com.yxysoft.basic.model.ViewQxzwBusApplyObj;
import com.yxysoft.basic.model.ViewQxzwBusApplyObjExample;
import com.yxysoft.basic.model.ViewQxzwBusApplyObjExample.Criteria;

@Service
public class WService {

	@Autowired
	ViewQxzwBusApplyObjMapper viewQxzwBusApplyObjMapper;
	
	public List<ViewQxzwBusApplyObj> selectView(Integer aId){
		ViewQxzwBusApplyObjExample example=new ViewQxzwBusApplyObjExample();
		Criteria cera=example.createCriteria();
		cera.andAIdEqualTo(aId);
		return viewQxzwBusApplyObjMapper.selectByExample(example);
	}

	
	
	
}
