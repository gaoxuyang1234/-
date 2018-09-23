package com.yxysoft.basic.controller;

import com.yxysoft.base.Result;
import com.yxysoft.basic.model.SysShift;
import com.yxysoft.basic.service.SysShiftService;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 朱翰林 on 2018/7/14.
 */



@RequestMapping("/sysshift")
@RestController
public class SysShiftController {

    @Autowired
    private SysShiftService sysShiftService;

    /**查找所有班次信息
     *
     * @return
     */
     @RequestMapping(value = "/selallshinfo")
    @ApiOperation(value = "所有班次信息", notes = "所有班次信息", code = 200, produces = "application/json")
    public Result<?> user_card(){
      //  Result<SysShift> result=new Result<SysShift>();
       // SysShift ss=new SysShift();
        List<SysShift> list=this.sysShiftService.selectallshiftinfo();
        if (list.size()!=0){
            //找到数据并且状态有效
            return new Result<>(CodeConst.SUCCESS.getResultCode(),CodeConst.SUCCESS.getMessage(),list);
        }else {
            //查询不到
            return new Result<>(CodeConst.NULL_DATA.getResultCode(),CodeConst.NULL_DATA.getMessage(),"查询不到数据");
        }


    }

}
