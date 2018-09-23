package com.yxysoft.basic.service;

import java.util.List;

import com.github.pagehelper.PageHelper;

import com.yxysoft.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxysoft.basic.mapper.SysUserMapper;
import com.yxysoft.basic.model.QueryVo2;
import com.yxysoft.basic.model.SysUser;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> queryUserList(QueryVo2 vo, Integer currentPage, Integer pagesize) {


        PageHelper.startPage(currentPage, pagesize);
        List<SysUser> list = sysUserMapper.queryUserList(vo);

        return list;
    }

    public List<SysUser> queryUserList(QueryVo2 vo) {

        return sysUserMapper.queryUserList(vo);
    }

    //添加(已有方法)
    public Integer addUser(SysUser su) {
        return sysUserMapper.insertSelective(su);

    }

    //修改(已有方法)
    public Integer updateUser(SysUser su) {
        return sysUserMapper.updateByPrimaryKeySelective(su);

    }

    //通过id删除
    public Integer deleteUser(Integer userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);

    }

    //通过id查找用户信息
    public SysUser selectByPrimaryKey(Integer userId) {
        return this.sysUserMapper.selectByPrimaryKey(userId);
    }

    //通过id删除，修改状态为无效
    public int deleteserinfo(Integer userId) {

        return this.sysUserMapper.deleteserinfo(userId);
    }

    //添加时根据身份证判断是否已经有用户信息
    public SysUser selectuserinfo(String cardNo) {

        return this.sysUserMapper.selectuserinfo(cardNo);

    }

    //添加时根据身份证判断是否已经有用户信息
    public  SysUser selectuserinfocode(String userCode){
            return  this.sysUserMapper.selectuserinfocode(userCode);
    }

}
