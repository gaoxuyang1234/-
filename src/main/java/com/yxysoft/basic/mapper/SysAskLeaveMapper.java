package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysAskLeave;
import com.yxysoft.basic.model.SysAskLeaveExample;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.service.AskLeaveService;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAskLeaveMapper {
    long countByExample(SysAskLeaveExample example);

    int deleteByExample(SysAskLeaveExample example);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(SysAskLeave record);

    int insertSelective(SysAskLeave record);

    List<SysAskLeave> selectByExample(SysAskLeaveExample example);

    SysAskLeave selectByPrimaryKey(Integer leaveId);

    int updateByExampleSelective(@Param("record") SysAskLeave record, @Param("example") SysAskLeaveExample example);

    int updateByExample(@Param("record") SysAskLeave record, @Param("example") SysAskLeaveExample example);

    int updateByPrimaryKeySelective(SysAskLeave record);

    int updateByPrimaryKey(SysAskLeave record);

    
    
    
    //条件查询
	List<SysAskLeave> queryAskLeavelist(QueryVo vo);

	SysAskLeave leaveList(Integer lid);

	int deleteaskleave(Integer leaveId);

	

	

	SysAskLeave judgeTime(@Param("leaveName")Integer leaveName, @Param("leaveStartTime")Date leaveStartTime, @Param("leaveEndTime")Date leaveEndTime);

	





	
}