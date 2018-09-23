package com.yxysoft.basic.service;


import com.yxysoft.basic.mapper.SysUserMapper;
import com.yxysoft.basic.model.SysUser;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by 朱翰林 on 2018/7/12.
 */


@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    /**根据id查找用户信息，查找用户当前部门
     * @param userId
     * @return
     */
   public SysUser selectByPrimaryKey(Integer userId){

       return this.sysUserMapper.selectByPrimaryKey(userId);
   }

    /**根据openid查询是否存在用户信息
     * @param openid
     * @return
     */
   public   SysUser selectByOpenId(String openid){

       return this.sysUserMapper.selectByOpenId(openid);
   }


    public   SysUser userlogining(SysUser bean){

        return this.sysUserMapper.userlogining(bean);
    }

    //根据id获得 user  gxy
	public SysUser list2(Integer uid) {
		SysUser user= this.sysUserMapper.selectByPrimaryKey(uid);
		return user;
	}



}
