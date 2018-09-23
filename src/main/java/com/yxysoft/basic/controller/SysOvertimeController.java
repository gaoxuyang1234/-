package com.yxysoft.basic.controller;

import com.yxysoft.base.Result;
import com.yxysoft.basic.model.SysOvertime;
import com.yxysoft.basic.service.SysOvertimeService;
import com.yxysoft.constant.CodeConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 朱翰林 on 2018/7/13.
 */


@Api(tags = {"用户加班管理"})
@RequestMapping("/sysovertime")
@RestController
public class SysOvertimeController {

    @Autowired
    private SysOvertimeService sysOvertimeService;

    /**
     * 加班写入数据库
     *
     * @param ovId
     * @param ovName
     * @param ovS
     * @param ovE
     * @param ovH
     * @param ovR
     * @return
     */

    @RequestMapping(value = "/addsysovertime")
    @ApiOperation(value = "添加用户加班信息", notes = "添加用户加班信息", code = 200, produces = "application/json")
    @ApiImplicitParam(paramType = "upload", name = "file", dataType = "MultipartFile", required = true)
    public Result<?> insertSelective(Integer ovId, Integer ovName, Date ovS, Date ovE, BigDecimal ovH, String ovR,
                                          Date ct, Date nt, Integer st, @RequestParam("file") MultipartFile uploadf) {
        //上传图片
        PicUitl pu = new PicUitl();
        Result<?> resultt = new Result<>();
//        resultt = pu.pirtload(uploadf);
        if (resultt.getResultCode() == 990) {
            return resultt;
        } else if (resultt.getResultCode() == 400) {
            return resultt;
        } else if (resultt.getResultCode() == 1202) {
            return resultt;
        } else {
            Result<String> result = new Result<String>();
            SysOvertime so = new SysOvertime();
            SysOvertime sot = new SysOvertime();
            boolean flag;
            so.setOvertimeId(ovId);//加班id
            so.setOvertimeName(ovName);//加班姓名
            so.setOvertimeStartTime(ovS);//加班开始时间
            so.setOvertimeEndTime(ovE);//加班结束时间
            so.setOvertimeHours(ovH);//加班时间
            so.setOvertimeReason(ovR);//加班理由
            so.setCreateTime(ct);//创建时间
            so.setState(st);//状态
            //判断当前时间是否在请假区间内
            if (nt.getTime() == ovS.getTime() || nt.getTime() == ovE.getTime()) {
                //在当前时间内
                flag = true;
            }

            Calendar date = Calendar.getInstance();
            date.setTime(nt);

            Calendar strat = Calendar.getInstance();
            strat.setTime(ovS);

            Calendar end = Calendar.getInstance();
            end.setTime(ovE);

            if (date.after(strat) && date.before(end)) {
                //在当前时间内
                flag = true;
            } else {
                //不在当前时间内
                flag = false;
            }
            sot = this.sysOvertimeService.judgeTime(so.getOvertimeName(), so.getOvertimeStartTime(), so.getOvertimeEndTime());

            //判断是否可以加班
            if (sot.getOvertimeId() != null && so.getState() == 1) {
                //有数据
                if (flag == true) {
                    //不能重复加班
                    return new Result<>(CodeConst.REPEAT.getResultCode(), CodeConst.REPEAT.getMessage(), "不能重复加班");

                } else {
                    //可以加班
                    int reason = this.sysOvertimeService.insertSelective(so);
                    if (reason != 0) {
                        // result.setMessage("1");
                        //添加成功
                        return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "添加成功");
                    } else {
                        // result.setMessage("2");
                        //添加失败
                        return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "添加失败");

                    }
                }
            }//加班信息无效
            else if (sot.getOvertimeId() != null && so.getState() == 0) {
                int reason = this.sysOvertimeService.insertSelective(so);
                if (reason != 0) {
                    // result.setMessage("1");
                    //添加成功
                    return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "添加成功");
                } else {
                    // result.setMessage("2");
                    //添加失败
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "添加失败");

                }


//            return new Result<>(CodeConst.TIME_PASSED.getResultCode(), CodeConst.TIME_PASSED.getMessage(),
//                    "用户加班信息状态无效");

            } else {
                //没有数据可以加班
                int reason = this.sysOvertimeService.insertSelective(so);
                if (reason != 0) {
                    // result.setMessage("1");
                    //添加成功
                    return new Result<>(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage(), "添加成功");
                } else {
                    // result.setMessage("2");
                    //添加失败
                    return new Result<>(CodeConst.INSERT_ERROR.getResultCode(), CodeConst.INSERT_ERROR.getMessage(), "添加失败");

                }

            }
        }
    }


}
