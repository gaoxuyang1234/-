package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysCardMapper;
import com.yxysoft.basic.model.SysCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 朱翰林 on 2018/7/12.
 */


@Service
public class SysCardService {

    @Autowired
    private SysCardMapper sysCardMapper;

    /**写入补卡信息
     *
     * @param record
     * @return
     */
    public int insertSelective(SysCard record){

        return this.sysCardMapper.insertSelective(record);
    }
}
