package com.yxysoft.basic.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.SysCardMapper;
import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysCard;
@Service
public class CardServiceImpl implements CardService{

	
	@Autowired
	private SysCardMapper sysCard;


	public List<SysCard> queryCardList(QueryVo Vo,Integer currentPage,Integer pagesize){
		PageHelper.startPage(currentPage, pagesize);
		List<SysCard> list = sysCard.queryCardList(Vo);
		return list;

	}


	public List<SysCard> queryCardList(QueryVo Vo) {
		List<SysCard> list=sysCard.queryCardList(Vo);
		return list;
	}

	@Override
	public int Cardupdate(SysCard card) {
		
	   return 	sysCard.updateByPrimaryKeySelective(card);
	}

	 //查找用户打卡信息
     public SysCard cardinfo(Integer cid){

		  return sysCard.cardList(cid);
	 }

     //删除用户补卡信息

	public   int deletecard(Integer cardId){
		return this.sysCard.deletecard(cardId);
	}

}
