package com.yxysoft.basic.controller;

import com.yxysoft.base.Result;
import com.yxysoft.basic.model.SysDepartment;
import com.yxysoft.basic.service.SysDepartmentService;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 朱翰林 on 2018/7/16.
 */


@Api(tags = {"部门信息管理"})
@RequestMapping("/sysdepartment")
@RestController
public class SysDepartmentController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    private SysDepartment sysDepartment;

    /**查询当前用户的所属部门
     *
     * @param did
     * @return
     */

    @RequestMapping("Dname")
    @ApiOperation(value = "查询当前用户所属部门名称", notes = "查询当前用户所属部门名称", code = 200, produces = "application/json"
          )
    public Result<?> selectByPrimaryKey(Integer did){
        sysDepartment=this.sysDepartmentService.selectByPrimaryKey(did);

     if (sysDepartment!=null){
         //状态有效
         if (sysDepartment.getState()==1){
             //状态有效
             return new Result<>(CodeConst.SUCCESS.getResultCode(),CodeConst.SUCCESS.getMessage(),sysDepartment);
         }else {
             //状态无效
             return  new Result<>(CodeConst.TIME_PASSED.getResultCode(),CodeConst.TIME_PASSED.getMessage(),"状态无效");

         }
     } else {
         //没有数据
         return new Result<>(CodeConst.NULL_DATA.getResultCode(),CodeConst.NULL_DATA.getMessage(),"没有该部门信息");

     }

    }


}
