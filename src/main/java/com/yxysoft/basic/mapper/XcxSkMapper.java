package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.XcxSk;
import com.yxysoft.basic.model.XcxSkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XcxSkMapper {
    long countByExample(XcxSkExample example);

    int deleteByExample(XcxSkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XcxSk record);

    int insertSelective(XcxSk record);

    List<XcxSk> selectByExample(XcxSkExample example);

    XcxSk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XcxSk record, @Param("example") XcxSkExample example);

    int updateByExample(@Param("record") XcxSk record, @Param("example") XcxSkExample example);

    int updateByPrimaryKeySelective(XcxSk record);

    int updateByPrimaryKey(XcxSk record);
}