package com.yxysoft.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yxysoft.base.Result;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysCard;
import com.yxysoft.basic.service.CardService;


@Api(tags = {"补卡管理"})
@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService card;
	@ResponseBody
	@ApiOperation(value = "用户补卡信息列表", notes = "用户补卡信息列表", code = 200, produces = "application/json")
	@RequestMapping("/list")
	public Map<String, List<SysCard>> queryCardList(QueryVo Vo){
		System.out.println(Vo);
//		PageBean pb=new PageBean();
//		pb.setCurrentPage(currentPage);
		int currentPage=Vo.getCurrentPage();
		int pagesize=Vo.getPagesize();
		System.out.println(Vo.getUsername());
//		pb.setPageSize(pagesize);
		List<SysCard> list = this.card.queryCardList(Vo, currentPage, pagesize);

		list.size();
		System.out.println(list.size());
		List<SysCard> list2 = this.card.queryCardList(Vo);

//		System.out.println(vo.getUserName());
//		System.out.println(vo.getBeginDate());
//		System.out.println(vo.getCardNo());
//		System.out.println(vo.getEndDate());
		Map<String, List<SysCard>> map =  new HashMap<>();
		map.put("1", list);
		map.put("2", list2);
		return map;
		
		
	}

	//删除
	@RequestMapping("/delete")
	@ApiOperation(value = "删除员工加班信息", notes = "修改状态为无效", code = 200, produces = "application/json")
	@ResponseBody
	public Result<?> deleteUser(Integer cardId) {

		SysCard sysCard = this.card.cardinfo(cardId);

		if(sysCard.getSatte()==null){

			return new Result<>(CodeConst.NULL_DATA.getResultCode(),"找不到数据");
		}else {
			if (sysCard.getSatte() == 2) {

				return new Result<>(CodeConst.DELETE_REPEAT.getResultCode(), "删除重复！");
			} else {
				int reason = this.card.deletecard(cardId);

				if (reason != 0) {
					return new Result<>(CodeConst.SUCCESS.getResultCode(), "删除成功");
				} else {
					return new Result<>(CodeConst.DELETE_ERROE.getResultCode(), "删除失败!");
				}

			}

		}
	}




	@RequestMapping("/update")
	@ApiOperation(value = "修改用户补卡信息", notes = "修改用户补卡信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<? >   Cardupdate(SysCard Card){
		int reason=card.Cardupdate(Card);
		if (reason!=0){
			return new Result<>(CodeConst.SUCCESS.getResultCode(),"修改成功");

		}else {
			return new Result<>(CodeConst.UPDATE_ERROR.getResultCode(),"修改失败!");
		}


	}


	@RequestMapping("/cardinfo")
	@ApiOperation(value = "修改界面加载补卡信息", notes = "动态加载补卡信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<SysCard> cardinfo(Integer cardId) {
		System.out.println(cardId);
		SysCard sysCard;
		sysCard = this.card.cardinfo(cardId);
		//System.out.println(sysCard.getShiftName());
		return new Result<>(sysCard);
	}


}
