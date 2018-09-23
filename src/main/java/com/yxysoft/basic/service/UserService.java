package com.yxysoft.basic.service;

import java.util.List;


import com.yxysoft.basic.model.QueryVo2;
import com.yxysoft.basic.model.SysUser;


public interface UserService {

	List<SysUser> queryUserList(QueryVo2 vo, Integer currentPage,Integer pagesize);

	List<SysUser> queryUserList(QueryVo2 vo);

	SysUser selectByPrimaryKey(Integer userId) ;

	Integer addUser(SysUser su);

	Integer updateUser(SysUser su);

	Integer deleteUser(Integer userId);

	int  deleteserinfo(Integer userId);

	SysUser selectuserinfo(String cardNo);

	 SysUser selectuserinfocode(String userCode);



}
