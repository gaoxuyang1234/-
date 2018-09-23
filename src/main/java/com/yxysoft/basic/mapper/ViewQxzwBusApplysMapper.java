package com.yxysoft.basic.mapper;

import com.yxysoft.base.AcceptToolBean;
import com.yxysoft.basic.model.ViewQxzwBusApplys;
import com.yxysoft.basic.model.ViewQxzwBusApplysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewQxzwBusApplysMapper {
    long countByExample(ViewQxzwBusApplysExample example);

    int deleteByExample(ViewQxzwBusApplysExample example);

    int insert(ViewQxzwBusApplys record);

    int insertSelective(ViewQxzwBusApplys record);

    List<ViewQxzwBusApplys> selectByExample(ViewQxzwBusApplysExample example);

    int updateByExampleSelective(@Param("record") ViewQxzwBusApplys record, @Param("example") ViewQxzwBusApplysExample example);

    int updateByExample(@Param("record") ViewQxzwBusApplys record, @Param("example") ViewQxzwBusApplysExample example);
    
    /**
     * 根据aId查询部门下不同状态的数据(当前日期)
     * aId,state
     * @param view
     * @return
     */
    List<ViewQxzwBusApplys>  selectStateAid(ViewQxzwBusApplys view);
    
    ViewQxzwBusApplys selectAid(Integer aId);
    //查询已办理或未办理的业务 
    List<ViewQxzwBusApplys> selectViewList(AcceptToolBean bean);
    //查询已办理或未办理的数量
    int selectViewListCount(AcceptToolBean bean);
    List<ViewQxzwBusApplys>  selectUsByState(AcceptToolBean bean);
}