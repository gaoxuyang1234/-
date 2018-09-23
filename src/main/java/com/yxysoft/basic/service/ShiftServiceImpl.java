package com.yxysoft.basic.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.SysShiftMapper;
import com.yxysoft.basic.model.SysShift;
@Service
public class ShiftServiceImpl implements ShiftService{

	@Autowired
	private SysShiftMapper SysShiftM;


	public List<SysShift> queryShiftList(String shiftName, Integer currentPage, Integer pagesize) {


		PageHelper.startPage(currentPage, pagesize);
		List<SysShift> list = SysShiftM.queryShiftList(shiftName);

		return list;
	}


	public List<SysShift> queryShiftList(String shiftName) {
		
		List<SysShift> list=SysShiftM.queryShiftList(shiftName);
		return list;
	}


	
	public int addShift(SysShift ss) {
		return SysShiftM.insert(ss);
	}



	
	public int updateShift(SysShift ss) {
		return SysShiftM.updateByPrimaryKeySelective(ss);
	}



	
//	public int deleteShift(Integer shiftId) {
//		return SysShiftM.deleteByPrimaryKey(shiftId);
//
//	}

	public SysShift shfitinfo(Integer shiftId){
		return SysShiftM.shiftList(shiftId);
	}


	public int  deleteshiftinfo(Integer shiftId){

          return SysShiftM.deleteshiftinfo(shiftId);
	}


	public 	SysShift selectshiftinfo(SysShift sysShift){

		  return  SysShiftM.selectshiftinfo(sysShift);
	}
}
