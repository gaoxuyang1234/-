package com.yxysoft.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yxysoft.base.Result;

import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bouncycastle.voms.VOMSAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysAskLeave;
import com.yxysoft.basic.service.AskLeaveService;


@Api(tags = {"请假管理"})
@Controller
@RequestMapping(value="/askLeave")
public class AskLeaveController {

	@Autowired
	private AskLeaveService askLeave;
	
	@ResponseBody
	@ApiOperation(value = "用户请假信息", notes = "用户请假信息列表", code = 200, produces = "application/json")
	@RequestMapping("/list")
	public  Map<String, List<SysAskLeave>> queryAskLeavelist(QueryVo vo){

		System.out.println(vo);
//		PageBean pb=new PageBean();
//		pb.setCurrentPage(currentPage);
//		System.out.println(currentPage);
//		System.out.println(pagesize);
		int currentPage=vo.getCurrentPage();
		int pagesize=vo.getPagesize();
		System.out.println(vo.getUsername());
//		pb.setPageSize(pagesize);
		List<SysAskLeave> list = this.askLeave.queryAskLeavelist(vo, currentPage, pagesize);

		list.size();
		System.out.println(list.size());
		List<SysAskLeave> list2 = this.askLeave.queryAskLeavelist(vo);

//		System.out.println(vo.getUserName());
//		System.out.println(vo.getBeginDate());
//		System.out.println(vo.getCardNo());
//		System.out.println(vo.getEndDate());
		Map<String, List<SysAskLeave>> map =  new HashMap<>();
		map.put("1", list);
		map.put("2", list2);
		return map;
		
	}
		
	@RequestMapping("/update")
	@ApiOperation(value = "修改请假信息", notes = "修改用户请假信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<?> AskLeaveUpdate(SysAskLeave AskLeave){
		int reason=askLeave.AskLeaveUpdate(AskLeave);
		if (reason!=0){
			return new Result<>(CodeConst.SUCCESS.getResultCode(),"修改成功");

		}else {
			return new Result<>(CodeConst.UPDATE_ERROR.getResultCode(),"修改失败!");
		}

		
		
	}

	//删除
	@RequestMapping("/delete")
	@ApiOperation(value = "删除请假信息", notes = "修改请假状态为无效", code = 200, produces = "application/json")
	@ResponseBody
	public Result<?> deleteUser(Integer leaveId) {

		SysAskLeave sysAskLeave =this.askLeave.leaveinfo(leaveId);

		if(sysAskLeave.getState()==null){

			return new Result<>(CodeConst.NULL_DATA.getResultCode(),"找不到数据");
		}else {
			if (sysAskLeave.getState() == 2) {

				return new Result<>(CodeConst.DELETE_REPEAT.getResultCode(), "删除重复！");
			} else {
				int reason = this.askLeave.deleteaskleave(leaveId);

				if (reason != 0) {
					return new Result<>(CodeConst.SUCCESS.getResultCode(), "删除成功");
				} else {
					return new Result<>(CodeConst.DELETE_ERROE.getResultCode(), "删除失败!");
				}

			}

		}
	}




	@RequestMapping("/leaveinfo")
	@ApiOperation(value = "修改界面加载请假信息", notes = "动态加载请假信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<SysAskLeave> userinfo(Integer leaveId) {
		System.out.println(leaveId);
		SysAskLeave sysAskLeave;
		sysAskLeave = this.askLeave.leaveinfo(leaveId);
		System.out.println(sysAskLeave.getLeaveName());
		return new Result<>(sysAskLeave);
	}



}
