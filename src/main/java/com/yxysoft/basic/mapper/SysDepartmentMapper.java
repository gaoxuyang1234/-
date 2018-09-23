package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.SysDepartment;
import com.yxysoft.basic.model.SysDepartmentExample;
import java.util.List;

import com.yxysoft.basic.model.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysDepartmentMapper {
    long countByExample(SysDepartmentExample example);

    int deleteByExample(SysDepartmentExample example);

    int deleteByPrimaryKey(Integer depId);

    int insert(SysDepartment record);

    int insertSelective(SysDepartment record);

    List<SysDepartment> selectByExample(SysDepartmentExample example);

    SysDepartment selectByPrimaryKey(Integer depId);//查找当前用户的所属部门

    SysDepartment selectByName(SysUser department);//查找部门最大补卡次数



    int updateByExampleSelective(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByExample(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByPrimaryKeySelective(SysDepartment record);

    int updateByPrimaryKey(SysDepartment record);
}