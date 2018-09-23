package com.yxysoft.basic.controller;

import com.yxysoft.base.Result;
import com.yxysoft.basic.model.SysAskLeave;
import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.service.SysAskLeaveService;
import com.yxysoft.basic.service.SysPunchINService;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;


/**
 * Created by 朱翰林 on 2018/7/13.
 */

@Api(tags = {"用户请假管理"})
@RequestMapping("/sysleave")
@RestController
public class SysAskLeaveController {

    // private SysAskLeave sysAskLeave;
    private SysPunchIn sysPunchIn;
    @Autowired
    private SysAskLeaveService sysAskLeaveService;
    @Autowired
    private SysPunchINService sysPunchINService;


    /**
     * 上传图片
     *
     * @param uploadf 图片
     * @return
     */
    @RequestMapping(value = "/pictureupload")
    @ApiOperation(value = "上传图片", notes = "上传图片，成功返回图片保存的路径", code = 200, produces = "application/json")
    @ApiImplicitParam(paramType = "upload", name = "file", dataType = "MultipartFile", required = false)
    public Result<?> pictureupload(@RequestParam("file") MultipartFile uploadf,String fileType) {
      System.out.println(fileType);
//        try {
//            byte[] by = uploadf.getBytes();
//            System.out.println(by);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /* 图片上传 */
        PicUitl pu = new PicUitl();
        Result<?> result = pu.pirtload(uploadf,fileType);
        if (result.getResultCode() == 990) {
            return result;
        } else if (result.getResultCode() == 400) {
            return result;
        } else {
            System.out.println(result);
            //200
            return result;

        }

    }


    /**
     * 添加请假信息到数据库
     *
     * @param leaveName      用户id
     * @param leaveStartTime 请假开始时间
     * @param leaveEndTime   请假结束时间
     * @param leaveDay       请假天数
     * @param leaveReason    请假理由
     * @param createTime     创建时间
     * @param state          状态
     * @return
     */
    @RequestMapping(value = "/addleaveinfo")
    @ApiOperation(value = "添加用户请假信息", notes = "添加用户请假信息", code = 200, produces = "application/json")
    public Result<?> insertSelective(Integer leaveName, String leaveStartTime, String leaveEndTime, BigDecimal leaveDay, String leaveReason
            , String createTime, Integer state, String picturePath) {


        SysAskLeave sysAskLeave = new SysAskLeave();
        SysAskLeave sal;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
        try {
            Date leaveStarTimed = formatter.parse(leaveStartTime);
            Date leaveEndtTimed = formatter.parse(leaveEndTime);
            Date createTimed = formatters.parse(createTime);
            sysAskLeave.setLeaveStartTime(leaveStarTimed);//请假开始时间
            sysAskLeave.setLeaveEndTime(leaveEndtTimed);//请教结束时间
            sysAskLeave.setCreateTime(createTimed);//创建时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        sysAskLeave.setLeaveName(leaveName);//请假姓名
        sysAskLeave.setLeaveDays(leaveDay);//请假天数
        sysAskLeave.setLeaveReason(leaveReason);//请假理由
        sysAskLeave.setState(state);//状态
        sysAskLeave.setPicturePath(picturePath);//图片上传路径
        //判断当前时间是否在请假区间内
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dtime = createTime.substring(0, 10);


        sal = this.sysAskLeaveService.judgeTime(sysAskLeave.getLeaveName(), sysAskLeave.getLeaveStartTime(),
                sysAskLeave.getLeaveEndTime());

        //判断是否可以请假
        //状态有效
         if (sal != null && sysAskLeave.getState() == 1) {
            return new Result<>(CodeConst.REPEAT.getResultCode(), CodeConst.REPEAT.getMessage(), "不能重复请假");

        //状态无效，可以请假
         /*} else if (sal != null && sysAskLeave.getState() == 0) {
            int reason = this.sysAskLeaveService.insertSelective(sysAskLeave);*/
	       //gxy修改！ 👇 
         } else if (sal == null) {
        	    //添加打卡表punch-start 传 uid 开始  结束 只能请两天 请三天就要和管理员联系
        	    this.sysPunchINService.insertAskLeave(leaveName,leaveStartTime,leaveEndTime);
        	    //添加请假记录
                int reason = this.sysAskLeaveService.insertSelective(sysAskLeave);
	            return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "请假成功");
	    }else {
            //添加失败
            return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加失败");
        }
            
         //===========================================
            /*SysPunchIn sin;
            SysPunchIn son;
            sin = this.sysPunchINService.user_cardin(leaveName);//判断当天有没有签到记录
            son = this.sysPunchINService.user_cardon(leaveName);//判断当天有没有签退记录
            //当天有记录，在原有基础上修改
            if (sin != null || son != null) {
                if (reason != 0) {
                    //添加成功
                    //修改打卡人状态信息为请假
                    //查找请假记录id
                    this.sysPunchIn = new SysPunchIn();
                    this.sysPunchIn.setPunchState("1");
                    if (sin.getPunchId() != null) {
                        this.sysPunchIn.setPunchId(sin.getPunchId());
                    }
                    if (son.getPunchId() != null) {
                        this.sysPunchIn.setPunchId(sin.getPunchId());
                    }

                    int reaon = this.sysPunchINService.updateByPrimaryKeySelective(sysPunchIn);
                    //System.out.println(r);
                    if (reaon != 0) {
                        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "请假成功");
                    } else {
                        return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加成功！" +
                                "但是打卡表更新失败");
                    }

                } else {
                    // result.setMessage("2");
                    //添加失败
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加失败");
                }


            }//当天没有记录，需要新建一个记录
            else {
                if (reason != 0) {
                    try {
                        Date createTimed = formatter.parse(createTime);
                        this.sysPunchIn.setCreateTime(createTimed);//创建时间
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    this.sysPunchIn = new SysPunchIn();
                    this.sysPunchIn.setUserId(leaveName);//打卡人id
                    this.sysPunchIn.setPunchState("1");//请假状态

                    this.sysPunchIn.setState(state);//状态
                    int reaon = this.sysPunchINService.insertSelective(sysPunchIn);
                    //  System.out.println(r);
                    if (reaon != 0) {
                        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "请假成功");
                    } else {
                        return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加成功！" +
                                "但是打卡表添加新信息失败");
                    }
                } else {
                    // result.setMessage("2");
                    //添加失败
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "添加失败");

                }

            }
        }//没有数据可以请假
        else {
            int reason = this.sysAskLeaveService.insertSelective(sysAskLeave);
            SysPunchIn sin;
            SysPunchIn son;
            sin = this.sysPunchINService.user_cardin(leaveName);//判断当天有没有签到记录
            son = this.sysPunchINService.user_cardon(leaveName);//判断当天有没有签退记录
            //当天有记录，在原有基础上修改
            if (sin != null || son != null) {
                if (reason != 0) {
                    // result.setMessage("1");
                    //添加成功
                    //修改打卡人状态信息为请假
                    //查找请假记录id
                    this.sysPunchIn = new SysPunchIn();
                    this.sysPunchIn.setPunchState("1");
                    if (sin != null) {
                        this.sysPunchIn.setPunchId(sin.getPunchId());
                    }
                    if (son != null) {
                        this.sysPunchIn.setPunchId(sin.getPunchId());
                    }
                    int reaon = this.sysPunchINService.updateByPrimaryKeySelective(sysPunchIn);
                    // System.out.println(r);
                    System.out.println();
                    if (reaon != 0) {
                        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "请假成功");
                    } else {
                        return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加成功！" +
                                "但是打卡表更新失败");
                    }
                } else {
                    // result.setMessage("2");
                    //添加失败
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加失败");
                }

            }//当天没有记录，需要新建一个记录
            else {
                if (reason != 0) {
                    this.sysPunchIn = new SysPunchIn();
                    try {
                        Date createTimed = formatter.parse(createTime);

                        this.sysPunchIn.setCreateTime(createTimed);//创建时间
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    this.sysPunchIn.setUserId(leaveName);//打卡人id
                    this.sysPunchIn.setPunchState("1");//请假状态

                    this.sysPunchIn.setState(state);//状态
                    int reson = this.sysPunchINService.insertSelective(sysPunchIn);
                    // System.out.println(r);
                    System.out.println();
                    if (reson != 0) {
                        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "请假成功");
                    } else {
                        return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加成功！" +
                                "但是打卡表添加新信息失败");
                    }
                } else {
                    // result.setMessage("2");
                    //添加失败
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "请假表添加失败");

                }

            }  
            
         }
            */

      

    }
}
