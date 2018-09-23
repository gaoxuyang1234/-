package com.yxysoft.basic.mapper;

import java.util.List;
import java.util.Map;

import com.yxysoft.base.AcceptManage;
import com.yxysoft.base.AcceptToolBean;

public interface StatisMapper {


	/**
	 * 查询各个街道和办事处的办理数量(dId,dName,pdId,countNum)
	 * @param toolbean
	 * @return
	 */
	List<Map<String,Object>> selectDepList(AcceptToolBean toolbean);
	
	
	List<AcceptManage> selectBusList(AcceptToolBean toolbean);
	
	int selectBusListCount(AcceptToolBean toolbean);
	/**
	 * 根据用户信息,业务信息,时间段查询具体数据
	 * @param toolbean
	 * @return
	 */
	List<AcceptManage> selectUsList(AcceptToolBean toolbean);
	
	int selectUsListCount(AcceptToolBean toolbean);
	
	/**
	 * 统计:总办理量(couobj),今日待办事项(counow),不见面事项总数(coubus),已经办理过的业务事项(cousid)
	 * @return
	 */
	Map<String,Object> statisCount(AcceptToolBean toolbean);
	
	/**
	 * 统计:总办理量(couobj),用户总人数(couuser),不见面事项总数(coubus),已经办理过的业务事项(cousid)
	 * @return
	 */
	Map<String,Object> statisCountG();
	
	/**
	 * 统计:指定时间段的办理数据
	 * @return
	 */
	List<Map<String,Object>> statisMonthCount(AcceptToolBean toolbean);
	/**
	 * 统计:针对用户的办理数据
	 * @param toolbean
	 * @return
	 */
	List<AcceptManage> statisUsCount(AcceptToolBean toolbean);
	
	/**
	 * 统计工作人员数据
	 * @param toolbean
	 * @return
	 */
	List<Map<String,Object>> statisPersCount(AcceptToolBean toolbean);
	/**
	 * 统计:查询指定时间段业务信息数据
	 * @param toolbean
	 * @return
	 */
	List<AcceptManage> statisBusList(AcceptToolBean toolbean);
	
	/**
	 * 统计所有街道和部门的代办信息(state=2)
	 * @return
	 */
	List<Map<String,Object>> statisDepCount();
	
	List<Map<String,Object>> statisStreetRates(AcceptToolBean bean);
	
	List<Map<String,Object>> statisDepRates(AcceptToolBean bean);
	
	List<Map<String,Object>> statisLineList(AcceptToolBean bean);
}
