package com.yxysoft.basic.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yxysoft.base.Result;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysOvertime;
import com.yxysoft.basic.service.OvertimeService;


@Api(tags = {"加班管理"})
@Controller
@RequestMapping(value="/overtime")
public class OvertimeController {
	
	@Autowired
	private OvertimeService overtimeS;
	
	//条件查询
	@ResponseBody
	@ApiOperation(value = "用户加班信息列表", notes = "用户加班信息列表", code = 200, produces = "application/json")
	@RequestMapping("/list")
	public Map<String, List<SysOvertime>> queryOvertimelist(QueryVo vo){

	    System.out.println(vo);
//		PageBean pb=new PageBean();
//		pb.setCurrentPage(currentPage);
		//System.out.println(currentPage);
		//System.out.println(pagesize);
		int currentPage=vo.getCurrentPage();
		int pagesize=vo.getPagesize();
		System.out.println(vo.getBeginDate());
//
//		String starttime=vo.getBeginDate();
//		String endtime= vo.getEndDate();
//
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String stime = df.format(starttime);
//		String etime = df.format(endtime);
//		System.out.println(stime);
//		pb.setPageSize(pagesize);
		List<SysOvertime> list = this.overtimeS.queryOvertimelist(vo, currentPage, pagesize);

		list.size();
		System.out.println(list.size());
		List<SysOvertime> list2 = this.overtimeS.queryOvertimelist(vo);

//		System.out.println(vo.getUserName());
//		System.out.println(vo.getBeginDate());
//		System.out.println(vo.getCardNo());
//		System.out.println(vo.getEndDate());
		Map<String, List<SysOvertime>> map = new HashMap<>();
		map.put("1", list);
		map.put("2", list2);
		return map;
	}
	//修改
	@RequestMapping("/update")
	@ApiOperation(value = "用户加班信息修改", notes = "用户加班信息修改", code = 200, produces = "application/json")
	@ResponseBody
	public  Result<?> OvertimeUpdate(SysOvertime Overtime){
		System.out.println(Overtime);
		int reason = overtimeS.OvertimeUpdate(Overtime);
		if (reason != 0) {
			return new Result<>(CodeConst.SUCCESS.getResultCode(), "修改成功");

		} else {
			return new Result<>(CodeConst.UPDATE_ERROR.getResultCode(), "修改失败!");
		}


	}


	//删除
	@RequestMapping("/delete")
	@ApiOperation(value = "删除员工加班信息", notes = "修改状态为无效", code = 200, produces = "application/json")
	@ResponseBody
	public Result<?> deleteUser(Integer overtimeId) {

	SysOvertime sysOvertime = this.overtimeS.overtimeinfo(overtimeId);

		if(sysOvertime.getState()==null){

			return new Result<>(CodeConst.NULL_DATA.getResultCode(),"找不到数据");
		}else {
			if (sysOvertime.getState() == 2) {

				return new Result<>(CodeConst.DELETE_REPEAT.getResultCode(), "删除重复！");
			} else {
				int reason = this.overtimeS.deleteovertime(overtimeId);

				if (reason != 0) {
					return new Result<>(CodeConst.SUCCESS.getResultCode(), "删除成功");
				} else {
					return new Result<>(CodeConst.DELETE_ERROE.getResultCode(), "删除失败!");
				}

			}

		}
	}

	@ApiOperation(value = "修改界面加载加班信息", notes = "动态加载加班信息", code = 200, produces = "application/json")
	@RequestMapping("/overtimeinfo")
	@ResponseBody
	public Result<SysOvertime> userinfo(Integer overtimeId) {
		System.out.println(overtimeId);
		SysOvertime sysOvertime;
		sysOvertime = this.overtimeS.overtimeinfo(overtimeId);
		System.out.println(sysOvertime.getOvertimeName());
		return new Result<>(sysOvertime);
	}

}
