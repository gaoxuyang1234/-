package com.yxysoft.basic.service;

import java.util.List;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysCard;

public interface CardService {

	List<SysCard> queryCardList(QueryVo Vo,Integer currentPage,Integer pagesize);

	List<SysCard> queryCardList(QueryVo Vo);

	int Cardupdate(SysCard card);

	SysCard cardinfo(Integer cid);

	//删除用户补卡信息
	int deletecard(Integer cardId);

}
