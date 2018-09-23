package com.yxysoft.basic.mapper;

import com.yxysoft.basic.model.ViewQxzwBusApplyObj;
import com.yxysoft.basic.model.ViewQxzwBusApplyObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewQxzwBusApplyObjMapper {
    long countByExample(ViewQxzwBusApplyObjExample example);

	int deleteByExample(ViewQxzwBusApplyObjExample example);

	int insert(ViewQxzwBusApplyObj record);

	int insertSelective(ViewQxzwBusApplyObj record);

	List<ViewQxzwBusApplyObj> selectByExample(ViewQxzwBusApplyObjExample example);

	int updateByExampleSelective(@Param("record") ViewQxzwBusApplyObj record,
	@Param("example") ViewQxzwBusApplyObjExample example);

	int updateByExample(@Param("record") ViewQxzwBusApplyObj record,
	@Param("example") ViewQxzwBusApplyObjExample example);
	
	ViewQxzwBusApplyObj  selectViewObj(Integer aId);

}