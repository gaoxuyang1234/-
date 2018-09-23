package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysOvertime;
import com.yxysoft.basic.model.SysOvertimeExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOvertimeMapper {
    long countByExample(SysOvertimeExample example);

    int deleteByExample(SysOvertimeExample example);

    int deleteByPrimaryKey(Integer overtimeId);

    int insert(SysOvertime record);

    int insertSelective(SysOvertime record);//用户加班信息写入

    SysOvertime judgeTime(Integer overtimeName, Date overtimeStartTime, Date overtimeEndTime);//根据姓名开始结束时间查找加班记录

    List<SysOvertime> selectByExample(SysOvertimeExample example);

    SysOvertime selectByPrimaryKey(Integer overtimeId);

    int updateByExampleSelective(@Param("record") SysOvertime record, @Param("example") SysOvertimeExample example);

    int updateByExample(@Param("record") SysOvertime record, @Param("example") SysOvertimeExample example);

    int updateByPrimaryKeySelective(SysOvertime record);

    int updateByPrimaryKey(SysOvertime record);

    
    //条件查询
	List<SysOvertime> queryOvertimelist(QueryVo vo);
     //根据id链表查找加班信息
      SysOvertime overtimeList(Integer overtimeId);

    //删除员工加班信息
    int deleteovertime(Integer overtimeId);
   
}