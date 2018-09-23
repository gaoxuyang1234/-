package com.yxysoft.basic.service;

import java.util.List;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysAskLeave;
import com.yxysoft.basic.model.SysOvertime;

public interface AskLeaveService {
     
    List<SysAskLeave> queryAskLeavelist(QueryVo vo, Integer currentPage,Integer pagesize);

    List<SysAskLeave> queryAskLeavelist(QueryVo vo);


    int AskLeaveUpdate(SysAskLeave AskLeave);

    //获取点击的请假信息
    SysAskLeave leaveinfo(Integer lid);
    //请假信息删除
    int deleteaskleave(Integer leaveId);

}
