package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysCard;
import com.yxysoft.basic.model.SysCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCardMapper {
    long countByExample(SysCardExample example);

    int deleteByExample(SysCardExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(SysCard record);

    int insertSelective(SysCard record);//写入补卡信息

    List<SysCard> selectByExample(SysCardExample example);

    SysCard selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") SysCard record, @Param("example") SysCardExample example);

    int updateByExample(@Param("record") SysCard record, @Param("example") SysCardExample example);

    int updateByPrimaryKeySelective(SysCard record);

    int updateByPrimaryKey(SysCard record);

    
    
    //条件查询
	List<SysCard> queryCardList(QueryVo vo);


    //根据id链表查询用户id
	 SysCard cardList(Integer cardId);


    //删除用户补卡信息

    int deletecard(Integer cardId);
}