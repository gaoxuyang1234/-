package com.yxysoft.basic.service;

import com.yxysoft.basic.mapper.SysPunchInMapper;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.model.SysUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱翰林 on 2018/7/12.
 */

@Service
public class SysPunchINService {

    @Autowired
    private SysPunchInMapper sysPunchInMapper;

    /**
     * 判断是否已经签到
     *
     *
     * @return
     */
    public SysPunchIn user_cardin(Integer uid) {
        return this.sysPunchInMapper.user_cardin( uid);

    }

    /**
     * 判断是否已经签退
     *
     *
     * @param uid
     * @return
     */
    public SysPunchIn user_cardon( Integer uid) {
        return this.sysPunchInMapper.user_cardon( uid);

    }


    /**
     * 用户打卡数据写入数据库
     *
     * @param record
     * @return
     */

    public int insertSelective(SysPunchIn record) {
        return this.sysPunchInMapper.insertSelective(record);
    }

    /**
     * 更新用户打卡状态
     *
     * @param record
     * @return
     */

    public int updateByPrimaryKeySelective(SysPunchIn record) {
        return this.sysPunchInMapper.updateByPrimaryKeySelective(record);
    }


    /**查询该用户所有打卡信息
     *
     * @param userId
     * @return
     */
    public List<SysPunchIn> pinfo(Integer userId) {

        return this.sysPunchInMapper.pinfo(userId);

    }
    /**查询用户某年某月记录数
     *
     * @param sysmonth
     * @param sysyear
     * @param uid
     * @return
     */
    public  List<SysPunchIn> syscount(Integer uid,Integer sysmonth,Integer sysyear){
        return this.sysPunchInMapper.syscount(uid,sysmonth,sysyear);
    }

    /**正常打卡数
     *
     * @param uid
     * @param sysmonth
     * @param sysyear
     * @return
     */
   public List<SysPunchIn>  sysnorcount(Integer uid,Integer sysmonth,Integer sysyear){
       return this.sysPunchInMapper.sysnorcount(uid, sysmonth, sysyear);

   }

    /**请假总数
     *
     * @param uid
     * @param sysmonth
     * @param sysyear
     * @return
     */
    public List<SysPunchIn>  sysleavecount(Integer uid,Integer sysmonth,Integer sysyear){
        return this.sysPunchInMapper.sysleavecount(uid, sysmonth, sysyear);
    }

    /**迟到总数
     *
     * @param uid
     * @param sysmonth
     * @param sysyear
     * @return
     */
      public List<SysPunchIn>   syscdcount(Integer uid,Integer sysmonth,Integer sysyear){

          return this.sysPunchInMapper.syscdcount(uid, sysmonth, sysyear);
      }

    /**早退总数
     *
     * @param uid
     * @param sysmonth
     * @param sysyear
     * @return
     */
       public List<SysPunchIn>   sysztcount(Integer uid,Integer sysmonth,Integer sysyear){

          return this.sysPunchInMapper.sysztcount(uid, sysmonth, sysyear);
       }

    /**缺卡总数
     *
     * @param uid
     * @param sysmonth
     * @param sysyear
     * @return
     */
    public List<SysPunchIn>   sysqkcount(Integer uid,Integer sysmonth,Integer sysyear){

        return this.sysPunchInMapper.sysqkcount(uid, sysmonth, sysyear);
    }

    /**旷工集合
     *
     * @return
     */
      public List<SysPunchIn> kg(Integer uid,Integer sysmonth,Integer sysyear){

          return this.sysPunchInMapper.kg(uid, sysmonth, sysyear);
      }
//主页面  gxy
	public SysPunchIn list(String dateTime, Integer uid) {
		
		return this.sysPunchInMapper.list(dateTime, uid);
	}
//add
	public void add(SysPunchIn punch) {
		this.sysPunchInMapper.insertSelective(punch);
		
		
	}

//请假
	public void insertAskLeave(Integer leaveName, String leaveStartTime, String leaveEndTime) {
		
		if(leaveStartTime!=leaveEndTime){
		    this.sysPunchInMapper.insertAskLeave(leaveName,leaveStartTime);	
		    this.sysPunchInMapper.insertAskLeave(leaveName,leaveEndTime);	
		}else{
			this.sysPunchInMapper.insertAskLeave(leaveName,leaveStartTime);	
			
		}
		
	}
	//add根据punchid
	public void addByPunchid(String signBackPath, String punchEndTime, Integer punchId, String signBackPlace,
			String signBackReason, Integer signBackState, Integer userId) {
		this.sysPunchInMapper.updateByPrimaryKeySelective1(signBackPath, punchEndTime, punchId,  signBackPlace,
				 signBackReason,signBackState,userId);
		
	}

	

	


}