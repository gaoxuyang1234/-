package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysShiftMapper;
import com.yxysoft.basic.model.SysShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 朱翰林 on 2018/7/13.
 */


@Service
public class SysShiftService {


    @Autowired
    private SysShiftMapper sysShiftMapper;

    /**
     * 查询班次所有信息
     *
     * @return
     */
    public List<SysShift> selectallshiftinfo() {
        return this.sysShiftMapper.selectallshiftinfo();


    }
}