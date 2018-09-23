package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.SysLoginInformation;
import com.yxysoft.basic.model.SysLoginInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginInformationMapper {
    long countByExample(SysLoginInformationExample example);

    int deleteByExample(SysLoginInformationExample example);

    int deleteByPrimaryKey(Integer loginId);

    int insert(SysLoginInformation record);

    int insertSelective(SysLoginInformation record);//管理员存入登陆表

    List<SysLoginInformation> selectByExample(SysLoginInformationExample example);

    SysLoginInformation selectByPrimaryKey(Integer loginId);

    int updateByExampleSelective(@Param("record") SysLoginInformation record, @Param("example") SysLoginInformationExample example);

    int updateByExample(@Param("record") SysLoginInformation record, @Param("example") SysLoginInformationExample example);

    int updateByPrimaryKeySelective(SysLoginInformation record);

    int updateByPrimaryKey(SysLoginInformation record);
}