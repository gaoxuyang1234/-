package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysOvertimeMapper;
import com.yxysoft.basic.model.SysOvertime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 朱翰林 on 2018/7/12.
 */

@Service
public class SysOvertimeService {

    @Autowired
    private SysOvertimeMapper sysOvertimeMapper;

    /**添加用户加班信息
     *
     * @param record
     * @return
     */
    public  int insertSelective(SysOvertime record){

        return this.sysOvertimeMapper.insertSelective(record);

    }

    /**根据姓名开始结束时间查找加班记录
     *
     * @param overtimeName
     * @param overtimeStartTime
     * @param overtimeEndTime
     * @return
     */
    public   SysOvertime judgeTime(Integer overtimeName, Date overtimeStartTime, Date overtimeEndTime){

        return this.sysOvertimeMapper.judgeTime(overtimeName,overtimeStartTime,overtimeEndTime);


    }


}
