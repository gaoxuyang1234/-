package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysLoginInformationMapper;
import com.yxysoft.basic.model.SysLoginInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 朱翰林 on 2018/7/12.
 */


@Service
public class SysLoginInformationService {

    @Autowired
    private SysLoginInformationMapper sysLoginInformationMapper;

    /**管理员信息存入登陆表
     *
     * @param record
     * @return
     */
    public int insertSelective(SysLoginInformation record){


        return this.sysLoginInformationMapper.insertSelective(record);

    }
}
