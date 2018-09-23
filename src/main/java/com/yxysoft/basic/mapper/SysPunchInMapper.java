package com.yxysoft.basic.mapper;


import com.yxysoft.basic.model.QueryVo;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.model.SysPunchInExample;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysPunchInMapper {
    long countByExample(SysPunchInExample example);

    int deleteByExample(SysPunchInExample example);

    int deleteByPrimaryKey(Integer punchId);

    int insert(SysPunchIn record);

    int insertSelective(SysPunchIn record);

    List<SysPunchIn> selectByExample(SysPunchInExample example);

    SysPunchIn selectByPrimaryKey(Integer punchId);

    int updateByExampleSelective(@Param("record") SysPunchIn record, @Param("example") SysPunchInExample example);

    int updateByExample(@Param("record") SysPunchIn record, @Param("example") SysPunchInExample example);

    int updateByPrimaryKeySelective(SysPunchIn record);

    int updateByPrimaryKey(SysPunchIn record);

    //分页查询
    //PageBean<SysPunchIn> querypunchlist(QueryVo vo);

    //list
    List<SysPunchIn> querypunchlist(QueryVo vo);

    //回显
    List<SysPunchIn> selecthuixian(Integer punchId);


    SysPunchIn user_cardon(@Param("pid") Integer pid);


    SysPunchIn user_cardin(@Param("pid") Integer pid);


    List<SysPunchIn> pinfo(Integer userId);

    List<SysPunchIn> syscount(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);

    List<SysPunchIn> sysnorcount(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);

    List<SysPunchIn> sysleavecount(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);

    List<SysPunchIn> sysztcount(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);

    List<SysPunchIn> syscdcount(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);

    List<SysPunchIn> sysqkcount(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);

    List<SysPunchIn> kg(@Param("uid") Integer uid, @Param("sysmonth") Integer sysmonth, @Param("sysyear") Integer sysyear);


    ////页面签到判断  gxy
    SysPunchIn list(@Param("datetime") String dateTime, @Param("pid") Integer uid);

    
  
    //请假
	void insertAskLeave(@Param("uid2")Integer leaveName, @Param("createTime")String leaveStartTime);
	
	//（update）  有签到的添加签退
	void updateByPrimaryKeySelective1(@Param("signBackPath")String signBackPath, @Param("punchEndTime")String punchEndTime,@Param("punchId") Integer punchId, @Param("signBackPlace")String signBackPlace,
			@Param("signBackReason")String signBackReason, @Param("signBackState")Integer signBackState, @Param("userId")Integer userId);

	

}