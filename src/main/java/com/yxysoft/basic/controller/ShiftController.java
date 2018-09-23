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

import com.yxysoft.basic.model.SysShift;
import com.yxysoft.basic.service.ShiftService;



@Api(tags = {"班次管理"})
@Controller
@RequestMapping(value="/shift")
public class ShiftController {
	
	@Autowired
	private ShiftService ShiftS;

	
	@ResponseBody
	@ApiOperation(value = "班次信息列表", notes = "班次信息列表", code = 200, produces = "application/json")
	@RequestMapping("/list")
	public Map<String, List<SysShift>> queryShiftList(String shiftName,Integer currentPage,Integer pagesize ){
		System.out.println(shiftName);
//		PageBean pb=new PageBean();
//		pb.setCurrentPage(currentPage);
		System.out.println(currentPage);
		System.out.println(pagesize);
		//System.out.println(Vo.getUsername());
//		pb.setPageSize(pagesize);
		List<SysShift> list = this.ShiftS.queryShiftList(shiftName,currentPage,pagesize);

		list.size();
		System.out.println(list.size());
		List<SysShift> list2 = this.ShiftS.queryShiftList(shiftName);

//		System.out.println(vo.getUserName());
//		System.out.println(vo.getBeginDate());
//		System.out.println(vo.getCardNo());
//		System.out.println(vo.getEndDate());
		Map<String, List<SysShift>> map =  new HashMap<>();
		map.put("1", list);
		map.put("2", list2);
		return map;
	}

	
	
	//添加
	@RequestMapping("/add")
	@ApiOperation(value = "添加班次信息", notes = "添加班次信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<?>  addShift(SysShift  ss){
		System.out.println("进入方法");
		SysShift sysShift=this.ShiftS.selectshiftinfo(ss);
		if (sysShift==null) {

			int reason = this.ShiftS.addShift(ss);

			if (reason != 0) {
				return new Result<>(CodeConst.SUCCESS.getResultCode(), "添加成功");

			} else {
				return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), "添加失败!");
			}
		}else {

			return new Result<>(CodeConst.REPEAT.getResultCode(),"用户信息已有");
		}
	}
	
	
	//修改
	@RequestMapping("/update")
	@ApiOperation(value = "修改班次信息", notes = "修改班次信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<? > updateShift(SysShift  ss){
		int reason =this.ShiftS.updateShift(ss);
		if (reason != 0) {
			return new Result<>(CodeConst.SUCCESS.getResultCode(), "修改成功");

		} else {
			return new Result<>(CodeConst.UPDATE_ERROR.getResultCode(), "修改失败!");
		}
		
	}
	
	//删除
	@RequestMapping("/delete")
	@ApiOperation(value = "删除班次信息", notes = "删除班次信息", code = 200, produces = "application/json")
	@ResponseBody
	public Result<?> deleteShift(Integer shiftId){
//		ShiftS.deleteShift(shiftId);
		SysShift sysShift = this.ShiftS.shfitinfo(shiftId);

		if(sysShift.getState()==null){

			return new Result<>(CodeConst.NULL_DATA.getResultCode(),"找不到数据");
		}else {

			if (sysShift.getState() == 2) {

				return new Result<>(CodeConst.DELETE_REPEAT.getResultCode(), "删除重复！");
			} else {
				int reason = this.ShiftS.deleteshiftinfo(shiftId);

				if (reason != 0) {
					return new Result<>(CodeConst.SUCCESS.getResultCode(), "删除成功");
				} else {
					return new Result<>(CodeConst.DELETE_ERROE.getResultCode(), "删除失败!");
				}

			}
		}

	}

	@RequestMapping("/shiftinfo")
	@ApiOperation(value = "修改界面加载班次信息", notes = "动态加载班次信息", code = 200, produces = "application/json")
	@ResponseBody

	public Result<SysShift> userinfo(Integer shiftId) {
		System.out.println(shiftId);
		SysShift sysShift;
		sysShift = this.ShiftS.shfitinfo(shiftId);
		//System.out.println(sysUser.getUserName());
		return new Result<>(CodeConst.SUCCESS.getResultCode(),CodeConst.SUCCESS.getMessage(),sysShift);
	}



}
