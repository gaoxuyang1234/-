package com.yxysoft.basic.controller;


import com.yxysoft.base.Result;
import com.yxysoft.base.weixin.CreateQrCode;
import com.yxysoft.basic.model.HttpsUtil;
import com.yxysoft.basic.model.IndustrySMS;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.model.SysUser;
import com.yxysoft.basic.service.SysAskLeaveService;
import com.yxysoft.basic.service.SysPunchINService;
import com.yxysoft.basic.service.SysUserService;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by 朱翰林 on 2018/7/12.
 */

@Api(tags = {"用户登陆管理"})
@RequestMapping("/sysuser")
@RestController
public class SysUserController {
    private SysUser sysUser;

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysPunchINService sysPunchINService;
    @Resource
    private SysAskLeaveService sysAskLeaveService ;

    private String ccfsshijian;

    /**
     * 查找openid
     *
     * @param openid
     * @return
     */
    //若存在openid进入打卡界面
    @RequestMapping(value = "/daka")
    @ApiOperation(value = "验证用户微信openID", notes = "验证用户微信openID", code = 200, produces = "application/json")
    public Result<?> SopenID(String openid) {
        // Result<SysUser> result = new Result<SysUser>();
        sysUser = this.sysUserService.selectByOpenId(openid);
        //存在且有效:录入OPID进入打卡页面
        if (sysUser != null && sysUser.getState() == 1) {
            return new Result<>(sysUser);
        }
        //不存在:表明该员工主管未录入,提示未检索到员工信息
        return new Result<>(CodeConst.NULL_DATA.getResultCode(), CodeConst.NULL_DATA.getMessage());

    }

    // 二维码
    @RequestMapping(value = "/erweima")
    public Result<?> erweima() {
        CreateQrCode createQrCode = new CreateQrCode();
        createQrCode.createerweima();
        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "二维码生成成功！");
    }


    //发送验证码

    /**
     * @param fsshijian 用户获取验证码的时间
     * @param phone     获取用户输入的手机号码
     */
    @RequestMapping(value = "/fsyzm")
    @ApiOperation(value = "发送验证码", notes = "随机生成验证码发送到指定手机", code = 200, produces = "application/json")
    public String huoquyzm(String phone, String fsshijian) {
        //  Result<?> result;
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        //  String fsshijian=df.format(new Date());
        // System.out.println(fsshijian);
        this.ccfsshijian = fsshijian;
        IndustrySMS.setTo(phone);
        String result = IndustrySMS.execute();
        System.out.println("第一次随机数" + IndustrySMS.getCode());
        return result;

    }

    //验证用户验证码

    /**
     * @param yzm       用户填写的验证码
     * @param yzshijian 验证用户填写验证码的时间
     * @return
     */
    @RequestMapping(value = "/yzyzm")
    @ApiOperation(value = "验证验证码", notes = "验证用户填写的验证码", code = 200, produces = "application/json")
    public Result<?> yanzyzm(String yzm, String yzshijian) {
        int minutes;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        // simpleFormat.parse("")
        // String fromDate = simpleFormat.f
        System.out.println(this.ccfsshijian);
        System.out.println(yzshijian);
        // String toDate = simpleFormat.format(yzshijian);

        simpleFormat.format(new Date());

        try {
            try {
                long from = simpleFormat.parse(this.ccfsshijian).getTime();
                long to = simpleFormat.parse(yzshijian).getTime();
                minutes = (int) ((to - from) / (1000 * 60));

                if (minutes > 2) {
                    return new Result<>(CodeConst.BAD_REQUEST.getResultCode(), CodeConst.BAD_REQUEST.getMessage(), "验证码失效");

                }
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(CodeConst.CodeOR.getResultCode(), CodeConst.CodeOR.getMessage(), "异常");
        }
//        Date date= simpleFormat.parse("2017-11-11");
//        simpleFormat.parse("");
//        long to = simpleFormat.parse(toDate).getTime();


        System.out.println(yzm);
        System.out.println("随机数为" + IndustrySMS.getCode());


        if (yzm.equals(IndustrySMS.getCode())) {
            System.out.println("11111111111");
            return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "验证成功");

        } else {

            return new Result<>(CodeConst.YZM_ERROR.getResultCode(), CodeConst.YZM_ERROR.getMessage(), "验证错误");
        }


    }


    //进去登陆界面

    /**
     * @param uName
     * @param mod   手机号
     * @param code  判断员工姓名或者工号的参数
     * @return
     */
    @RequestMapping(value = "/login")
    @ApiOperation(value = "用户姓名或者工号和手机号登陆", notes = "用户姓名或者工号和手机号登陆", code = 200, produces = "application/json")
    public Result<?> Login(String uName, String mod, String code) {
//        System.out.println(uName);
//        System.out.println(code);
//        System.out.println(mod);
        SysUser uss = new SysUser();
        //判断是用户名还是工号
        if (code.equals("useName")) {
            uss.setUserName(uName);
        } else if (code.equals("useCode")) {
            uss.setUserCode(uName);
        }
        //手机号
        uss.setMobile(mod);
        // Result<SysUser> result = new Result<SysUser>();
        sysUser = this.sysUserService.userlogining(uss);
        if (sysUser != null && sysUser.getState() == 1) {
            //登陆成功，进入考勤页面200
            return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), sysUser);
        } else if (sysUser != null && sysUser.getState() != 1) {
            //无效:提示员工信息无效,请联系主管997
            return new Result<>(CodeConst.USER_NOT_FOUND.getResultCode(), CodeConst.SUCCESS.getMessage(), "员工信息无效请联系主管");
        } else {
            //找不到用户，登陆信息有误999
            return new Result<>(CodeConst.AUTH_FAILED.getResultCode(), CodeConst.AUTH_FAILED.getMessage(), "找不到用户");

        }


    }


    @RequestMapping(value = "/userInfo")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", code = 200, produces = "application/json")
    public Result<?> userInfo(Integer uid) {
        SysUser sysUser = this.sysUserService.selectByPrimaryKey(uid);
        if (sysUser != null) {
            return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), sysUser);

        } else {
            return new Result<>(CodeConst.NULL_DATA.getResultCode(), CodeConst.NULL_DATA.getMessage(), "获取失败！");
        }


    }

    /**
     * 根据年月 ,获取对应的月份天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }


    /**
     * 闰年判断
     *
     * @param year
     * @return
     */
    public static Boolean yearandmonth(Integer year) {
        //判断是不是闰年
        boolean flag;
        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    /**
     * 用户某年某月各项信息总数
     *
     * @param uid   用户id
     * @param year
     * @param month
     * @return
     */
    @RequestMapping(value = "/count")
    @ApiOperation(value = "用户某年某月总数", notes = "用户某年某月各项信息总数", code = 200, produces = "application/josn")
    public Result<?> userinfowork(Integer uid, Integer year, Integer month) {
        //获取当前年月的总天数
        //  int yeat = Integer.parseInt(year);
        int day = SysUserController.getDaysByYearMonth(year, month);
        //当前用户某年某月的总记录数
        int cqcount = this.sysPunchINService.syscount(uid, month, year).size();//出勤总数
        Integer zccount = this.sysPunchINService.sysnorcount(uid, month, year).size();//正常签到总数
        //gxy改
        Integer qjcount = this.sysPunchINService.sysleavecount(uid, month, year).size();//请假总数
       
        Integer cdcount = this.sysPunchINService.syscdcount(uid, month, year).size();//迟到总数
        Integer ztcount = this.sysPunchINService.sysztcount(uid, month, year).size();//早退总数
        Integer qkcount = this.sysPunchINService.sysqkcount(uid, month, year).size();//缺卡总数
        List<SysPunchIn> kg = this.sysPunchINService.kg(uid, month, year);//获取矿工集合
        Integer kgcount;//矿工总数
        Integer restcount;//总休息数
        List<Integer> list = new ArrayList<>();

        kgcount = kg.size();//矿工总数
        restcount = day - cqcount - kgcount;//总休息数

        list.add(cqcount);//出勤
        list.add(zccount);//正常签到
        list.add(qjcount);//请假
        list.add(cdcount);//迟到
        list.add(ztcount);//早退
        list.add(qkcount);//缺卡
        list.add(kgcount);//矿工
        list.add(restcount);//休息

   
        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), list);


    }

    @RequestMapping(value = "/kgtime")
    @ApiOperation(value = "当前用户某年某月矿工信息集合", notes = "获取当前用户某年某月各项矿工日期", code = 200, produces = "application/josn")
    public Result<?> kgtime(Integer uid, Integer year, Integer month) {

        List<SysPunchIn> kg = this.sysPunchINService.kg(uid, month, year);//获取矿工集合


        return new Result<>(kg);

    }

    @RequestMapping(value = "/qjtime")
    @ApiOperation(value = "当前用户某年某月请假信息集合", notes = "获取当前用户某年某月各项请假日期", code = 200, produces = "application/josn")
    public Result<?> qjtime(Integer uid, Integer year, Integer month) {

        List<SysPunchIn> kg = this.sysPunchINService.sysleavecount(uid, month, year);//获取矿工集合
//
        return new Result<>(kg);

    }


    @RequestMapping(value = "/cdtime")
    @ApiOperation(value = "当前用户某年某月缺卡信息集合", notes = "获取当前用户某年某月各项缺卡日期", code = 200, produces = "application/josn")
    public Result<?> cdtime(Integer uid, Integer year, Integer month) {

        List<SysPunchIn> kg = this.sysPunchINService.syscdcount(uid, month, year);//获取矿工集合
//
        return new Result<>(kg);

    }


    @RequestMapping(value = "/qktime")
    @ApiOperation(value = "当前用户某年某月缺卡信息集合", notes = "获取当前用户某年某月各项缺卡日期", code = 200, produces = "application/josn")
    public Result<?> qktime(Integer uid, Integer year, Integer month) {

        List<SysPunchIn> kg = this.sysPunchINService.sysqkcount(uid, month, year);//获取矿工集合
//
        return new Result<>(kg);

    }

    @RequestMapping(value = "/zttime")
    @ApiOperation(value = "当前用户某年某月早退信息集合", notes = "获取当前用户某年某月各项早退日期", code = 200, produces = "application/josn")
    public Result<?> zttime(Integer uid, Integer year, Integer month) {

        List<SysPunchIn> kg = this.sysPunchINService.sysztcount(uid, month, year);//获取矿工集合
//
        return new Result<>(kg);

    }




}