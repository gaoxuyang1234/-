package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.WxAccessToken;
import com.yxysoft.basic.model.WxAccessTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxAccessTokenMapper {
    long countByExample(WxAccessTokenExample example);

    int deleteByExample(WxAccessTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxAccessToken record);

    int insertSelective(WxAccessToken record);

    List<WxAccessToken> selectByExample(WxAccessTokenExample example);

    WxAccessToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxAccessToken record, @Param("example") WxAccessTokenExample example);

    int updateByExample(@Param("record") WxAccessToken record, @Param("example") WxAccessTokenExample example);

    int updateByPrimaryKeySelective(WxAccessToken record);

    int updateByPrimaryKey(WxAccessToken record);
}