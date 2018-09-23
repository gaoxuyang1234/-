package com.yxysoft.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yxysoft.basic.model.SysShift;


public interface ShiftService {



	List<SysShift> queryShiftList(String shiftName);

	List<SysShift> queryShiftList(String shiftName,Integer currentPage,Integer pagesize);


	int addShift(SysShift ss);


	int updateShift(SysShift ss);


//	int deleteShift(Integer shiftId);

	int  deleteshiftinfo(Integer userId);



	SysShift shfitinfo(Integer shiftId);

	SysShift selectshiftinfo(SysShift sysShift);
	
}
