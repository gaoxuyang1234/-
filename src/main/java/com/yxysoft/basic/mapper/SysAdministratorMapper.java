package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.SysAdministrator;
import com.yxysoft.basic.model.SysAdministratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdministratorMapper {
    long countByExample(SysAdministratorExample example);

    int deleteByExample(SysAdministratorExample example);//

    int deleteByPrimaryKey(Integer administratorId);//根据id删除管理员信息

    int insert(SysAdministrator record);//添加管理员信息，执行所有字段

    int insertSelective(SysAdministrator record);//添加管理员信息，只执行相关字段

    List<SysAdministrator> selectByExample(SysAdministratorExample example);

    SysAdministrator selectByPrimaryKey(Integer administratorId);  //根据id查找管理员信息

    int updateByExampleSelective(@Param("record") SysAdministrator record, @Param("example") SysAdministratorExample example);

    int updateByExample(@Param("record") SysAdministrator record, @Param("example") SysAdministratorExample example);

    int updateByPrimaryKeySelective(SysAdministrator record);//修改管理员信息，不为空才修改

    int updateByPrimaryKey(SysAdministrator record);///修改管理员信息 为空也修改

    List<SysAdministrator> selectalladminfo();//查询所有管理员信息
}