package com.yxysoft.basic.controller;


import com.yxysoft.base.Result;
import com.yxysoft.basic.model.SysCard;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.service.SysCardService;
import com.yxysoft.basic.service.SysPunchINService;
import com.yxysoft.constant.CodeConst;
import com.yxysoft.constant.GlobalConst;
import com.yxysoft.utils.DateUtil;
import com.yxysoft.utils.QiniuUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.http.HttpRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by 朱翰林 on 2018/7/14.
 */

@Api(tags = {"用户补卡管理"})
@RequestMapping("/syscardcotroller")
@RestController
public class SysCardController {

    @Autowired
    private SysCardService sysCardService;

    @Autowired
    private SysPunchINService sysPunchINService;

    private SysPunchIn sysPunchIn;
    //七牛云工具类
    private QiniuUtil qiniuUtil;

    //private Logger logger = LoggerFactory.getLogger(SysCardController.class);
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(SysCardController.class);


    /**
     * 补卡日期信息获取
     *
     * @param uid 用户id
     * @return
     */
    @RequestMapping(value = "/addcardinfo")
    @ApiOperation(value = "补卡日期获取", notes = "补卡日期集合", code = 200, produces = "application/json")
    public Result<?> cardinfo(Integer uid) {

        List<SysPunchIn> sysPunchIns = this.sysPunchINService.pinfo(uid);
        if (sysPunchIns.size() != 0) {
            return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), sysPunchIns);

        } else {
            //没有记录情况
            return new Result<>(CodeConst.NULL_DATA.getResultCode(), CodeConst.NULL_DATA.getMessage(), "该用户没有签过或签退或找不到数据");

        }
    }


    /**上传图片
     *
     * @param uploadf  图片
     * @return
     */
    @RequestMapping(value = "/pictureupload")
    @ApiOperation(value = "上传图片", notes = "上传图片，成功返回图片保存的路径", code = 200, produces = "application/json")
    @ApiImplicitParam(paramType = "upload", name = "file", dataType = "MultipartFile", required = false)
    public Result<?> pictureupload(@RequestParam("file") MultipartFile uploadf,String fileType) {
        System.out.println(fileType);
        try {
            byte[] by = uploadf.getBytes();
            System.out.println(by);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* 图片上传 */
        PicUitl pu = new PicUitl();
        Result<?> result = pu.pirtload(uploadf,fileType);
        if (result.getResultCode() == 990) {
            return result;
        } else if (result.getResultCode() == 400) {
            return result;
        } else {
           //200
            return result;

        }

    }


    /**
     * 用户信息补卡添加到数据库
     *
     * @param uid        用户id
     * @param cardTime   补卡时间
     * @param cardPlace  补卡地点
     * @param cardReason 补卡理由
     * @param shiftName  班次
     * @param createTime 创建时间
     * @param state      状态
     * @return
     */
    @RequestMapping(value = "/addcard")
    @ApiOperation(value = "添加用户补卡信息", notes = "添加用户补卡信息", code = 200, produces = "application/json")
    public Result<?> addbkinfo(Integer pid, Integer uid, String cardPlace, String cardReason,
                               Integer state, String shiftName, String cardTime, String createTime,String picturePath) {

            SysCard sc = new SysCard();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                Date carddate = formatter.parse(cardTime);
                Date createdate = formatters.parse(createTime);
                sc.setCardTime(carddate);//补卡时间
                sc.setCreateTime(createdate);//创建时间
            } catch (ParseException e) {
                e.printStackTrace();
            }

            sc.setCardUserId(uid);//补卡用户id
            sc.setCardPlace(cardPlace);//补卡地点
            sc.setCardReason(cardReason);//不卡理由
            sc.setShiftName(shiftName);//班次
            sc.setSatte(state);//状态
            sc.setPicturePath(picturePath);//图片保存路径
            int reason = this.sysCardService.insertSelective(sc);
            if (reason != 0) {

                //添加成功
                this.sysPunchIn = new SysPunchIn();
                this.sysPunchIn.setPunchState("2");
                this.sysPunchIn.setPunchId(pid);//打卡表id
                int reasonupdate = this.sysPunchINService.updateByPrimaryKeySelective(sysPunchIn);
                //打卡表状态修改成功
                if (reasonupdate != 0) {
                    return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "补卡成功!");
                } else {
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "补卡表添加成功！" +
                            "但是打卡表修改状态失败！");
                }


            } else {
                //添加失败
                return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "补卡表添加失败！");
            }




    }


}
