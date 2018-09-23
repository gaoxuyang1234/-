package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.SysShift;
import com.yxysoft.basic.model.SysShiftExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysShiftMapper {
    long countByExample(SysShiftExample example);

    int deleteByExample(SysShiftExample example);

    int deleteByPrimaryKey(Integer shiftId);

    int insert(SysShift record);

    int insertSelective(SysShift record);

    List<SysShift> selectByExample(SysShiftExample example);

    SysShift selectByPrimaryKey(Integer shiftId);

    SysShift select();

    int updateByExampleSelective(@Param("record") SysShift record, @Param("example") SysShiftExample example);

    int updateByExample(@Param("record") SysShift record, @Param("example") SysShiftExample example);

    int updateByPrimaryKeySelective(SysShift record);

    int updateByPrimaryKey(SysShift record);

    //根据状态查
	List<SysShift> queryShiftList(String shiftName);

    //删除用户信息
    int deleteshiftinfo(Integer shiftId);
    //添加班次时判断是否重复
    SysShift selectshiftinfo(SysShift sysShift);


    //根据id链表查询班次信息
    SysShift shiftList(Integer shiftId);


    //查询班次所有信息
    List<SysShift> selectallshiftinfo();

}