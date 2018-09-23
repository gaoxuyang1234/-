package com.yxysoft.basic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.base.AcceptToolBean;
import com.yxysoft.basic.mapper.ViewQxzwBusApplyObjMapper;
import com.yxysoft.basic.mapper.ViewQxzwBusApplysMapper;
import com.yxysoft.basic.model.ViewQxzwBusApplyObj;
import com.yxysoft.basic.model.ViewQxzwBusApplys;

@Service
public class UsFileUploadService {

	@Autowired
	ViewQxzwBusApplysMapper viewQxzwBusApplysMapper;
	@Autowired
	QxzwAcceptService qxzwAcceptService;
	
	public List<ViewQxzwBusApplys> selectUsByState(AcceptToolBean bean){
//		ViewQxzwBusApplys view=new ViewQxzwBusApplys();
//		view.setState(state);
//		view.setuId(usId);
		return viewQxzwBusApplysMapper.selectUsByState(bean);
	}
	
	
	
	
	
	
}
