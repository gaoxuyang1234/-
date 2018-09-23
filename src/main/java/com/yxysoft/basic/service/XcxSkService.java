package com.yxysoft.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.QxzwUserCardDetailMapper;
import com.yxysoft.basic.mapper.XcxSkMapper;
import com.yxysoft.basic.model.QxzwUserCardDetail;
import com.yxysoft.basic.model.QxzwUserCardDetailExample;
import com.yxysoft.basic.model.XcxSk;
import com.yxysoft.basic.model.XcxSkExample;

/**
 * @author Jesse
 * @date 2018/1/23
 */
@Service
public class XcxSkService {
    @Autowired
    private XcxSkMapper xcxSkMapper;
    @Autowired
    private QxzwUserCardDetailMapper userCardDetailMapper;

    /**
     *  
     */
    public List<XcxSk> queryXcxSk(String sk) {
    	XcxSkExample example = new XcxSkExample();
    	XcxSkExample.Criteria criteria = example.createCriteria();
    	criteria.andUuidEqualTo(sk);
        return xcxSkMapper.selectByExample(example);
    }
    
    public QxzwUserCardDetail queryQxzwUserCardDetail(int uId){
    	QxzwUserCardDetailExample example = new QxzwUserCardDetailExample();
    	QxzwUserCardDetailExample.Criteria criteria = example.createCriteria();
    	criteria.andUIdEqualTo(uId);
    	
    	List<QxzwUserCardDetail> list = userCardDetailMapper.selectByExample(example);
    	if(list!=null&&list.size()>0){
    		return list.get(0);
    	}else{
    		return new QxzwUserCardDetail();
    	}
    	
    }
    

    public int insetXcxSk(XcxSk info) {
        return xcxSkMapper.insertSelective(info);
    }
    
    

}
