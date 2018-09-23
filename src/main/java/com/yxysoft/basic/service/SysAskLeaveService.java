package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysAskLeaveMapper;
import com.yxysoft.basic.model.SysAskLeave;
import com.yxysoft.basic.model.SysPunchIn;

import org.apache.commons.collections.map.AbstractHashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 朱翰林 on 2018/7/12.
 */


@Service
public class SysAskLeaveService {


    @Autowired
    private SysAskLeaveMapper sysAskLeaveMapper;


    /**写入请假信息
     *
     * @param record
     * @return
     */
    public  int insertSelective(SysAskLeave record){

        return this.sysAskLeaveMapper.insertSelective(record);
        
    }

    /**根据姓名开始结束时间查找请假记录
     *
     * @param leaveName
     * @param leaveStartTime
     * @param leaveEndTime
     * @return
     */
    public  SysAskLeave judgeTime(Integer leaveName, Date leaveStartTime, Date leaveEndTime){
             return this.sysAskLeaveMapper.judgeTime(leaveName, leaveStartTime, leaveEndTime);

        }
  
}