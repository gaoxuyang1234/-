package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysDepartmentMapper;
import com.yxysoft.basic.model.SysDepartment;
import com.yxysoft.basic.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 朱翰林 on 2018/7/12.
 */


@Service
public class SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**查找部门最大补卡数
     *
     * @param department
     * @return
     */

    public SysDepartment selectByName(SysUser department){

        return this.sysDepartmentMapper.selectByName(department);

    }

    /**查找当前用户的所属部门
     *
     * @param depId
     * @return
     */
    public SysDepartment selectByPrimaryKey(Integer depId){

        return this.sysDepartmentMapper.selectByPrimaryKey(depId);

    }




}
