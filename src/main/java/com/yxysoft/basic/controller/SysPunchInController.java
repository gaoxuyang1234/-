package com.yxysoft.basic.controller;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yxysoft.basic.model.SysPunchIn;
import com.yxysoft.basic.model.SysUser;
import com.yxysoft.basic.service.SysPunchINService;
import com.yxysoft.basic.service.SysUserService;
import com.yxysoft.utils.FileUtil;
import com.yxysoft.utils.WaterMarkUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by 朱翰林 on 2018/7/13.
 */


@Api(tags = {"用户签到签退管理"})
@RequestMapping(value = "/syspunchin")
@Controller
public class SysPunchInController {

    @Autowired
    private SysPunchINService sysPunchINService;

    @Autowired
    private SysUserService sysUserService;
    
    /**
     * 判断是否签到 gxy
     */
    @ResponseBody
    @RequestMapping(value ="checkpunch")
    @ApiOperation(value = "检查用户是否已经签到或者签退", notes = "检查用户是否已经签到或者签退", code = 200, produces = "application/json")
    public SysPunchIn user_card(String dateTime, Integer uid)  {
    	 SysPunchIn punchIn = this.sysPunchINService.list(dateTime, uid);
    	 return  punchIn;
    }
    	

    //根据uid  获得user
     @ResponseBody
     @RequestMapping(value ="checkpunch2")	
     public SysUser user(Integer uid){
		
    	 SysUser user = this.sysUserService.list2(uid);
    	 return user;
    	 
     }
     
     //签到 图片上传
     @RequestMapping(value= "add" ,method = RequestMethod.POST)
    public String upload(@RequestParam("PicturePath") MultipartFile PicturePath,String punchPlace,String punchReason,String shiftName,Integer signInState,Integer userId,HttpServletRequest request){

    	
    	// 要上传的目标文件存放路径
         String localPath ="C:/image1/";   
        //上传
         FileUtil.upload(PicturePath, localPath, PicturePath.getOriginalFilename());
         //获得文件名
         String fileName = PicturePath.getOriginalFilename();
       //添加水印！
         Font font = new Font("微软雅黑", Font.PLAIN, 35);                     //水印字体
         String srcImgPath="C:/image1/"+fileName; //源图片地址
         String tarImgPath="C:/image/"+fileName;  //待存储的地址
         //格式化时间
         SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String format = f.format(new Date());
         String waterMarkContent=format;  //水印内容
         Color color=new Color(220,20,60);
         new WaterMarkUtils().addWaterMark(srcImgPath, tarImgPath, waterMarkContent, color, font);

    	 //上传到数据库
    	 SysPunchIn punch=new SysPunchIn();
    	 punch.setPunchPlace(punchPlace);
    	 punch.setPunchReason(punchReason);
    	 punch.setShiftName(shiftName);
    	 punch.setSignInState(signInState);
    	 punch.setUserId(userId);
    	 //图片
    	 punch.setPicturePath(fileName);	 
    	 punch.setPunchStartTime(new Date());
    	 punch.setCreateTime(new Date());
    	 sysPunchINService.add(punch); 
    	 return "redirect:/adm/zhuye";
     }
     
    /**
     * 显示单张图片
     * @return
     */
     private ResourceLoader resourceLoader;
     @Autowired
     public SysPunchInController(ResourceLoader resourceLoader) {
         this.resourceLoader = resourceLoader;
     }
     
     @Value("${web.upload-path}")
     private String path;

    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
     
     
     //=============
 	//有签到的签退//根据punchIn 签退
     @RequestMapping(value= "addEnd")
     public String update(@RequestParam("signBackPath1") MultipartFile signBackPath1,Integer punchId,String signBackPlace,String signBackReason,Integer signBackState,Integer userId ){

     	// 要上传的目标文件存放路径
          String localPath ="C:/image1/";   
         //上传
          FileUtil.upload(signBackPath1, localPath, signBackPath1.getOriginalFilename());
          //获得文件名
          String signBackPath = signBackPath1.getOriginalFilename();
        //添加水印！
          Font font = new Font("微软雅黑", Font.PLAIN, 35);                     //水印字体
          String srcImgPath="C:/image1/"+signBackPath; //源图片地址
          String tarImgPath="C:/image/"+signBackPath;  //待存储的地址
          //格式化时间
          SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String format = f.format(new Date());
          String waterMarkContent=format;  //水印内容
          Color color=new Color(220,20,60);
          new WaterMarkUtils().addWaterMark(srcImgPath, tarImgPath, waterMarkContent, color, font);
    	 
         //签退时间
     	SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 String punchEndTime = Format.format(new Date());
     	 sysPunchINService.addByPunchid(signBackPath,punchEndTime,punchId,signBackPlace,signBackReason,signBackState,userId); 
     	 return "redirect:/adm/zhuye";
      }
     //直接签退
     @RequestMapping(value= "End")
     public String insert1(@RequestParam("signBackPath") MultipartFile signBackPath1,String signBackPlace,String signBackReason,Integer signBackState,Integer userId,String shiftName){
    	// 要上传的目标文件存放路径
         String localPath ="C:/image1/";   
        //上传
         FileUtil.upload(signBackPath1, localPath, signBackPath1.getOriginalFilename());
         //获得文件名
         String fileName = signBackPath1.getOriginalFilename();
       //添加水印！
         Font font = new Font("微软雅黑", Font.PLAIN, 35);                     //水印字体
         String srcImgPath="C:/image1/"+fileName; //源图片地址
         String tarImgPath="C:/image/"+fileName;  //待存储的地址
         //格式化时间
         SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String format = f.format(new Date());
         String waterMarkContent=format;  //水印内容
         Color color=new Color(220,20,60);
         new WaterMarkUtils().addWaterMark(srcImgPath, tarImgPath, waterMarkContent, color, font);
         
         //上传到数据库
     	 SysPunchIn punch=new SysPunchIn();
     	 punch.setUserId(userId);
     	 //图片
     	 punch.setPicturePath(fileName);	 
     	 punch.setPunchEndTime(new Date());
     	 punch.setCreateTime(new Date());
     	 punch.setSignBackPlace(signBackPlace);
     	 punch.setSignBackReason(signBackReason);
     	 punch.setSignBackState(signBackState);
     	 punch.setShiftName(shiftName);
     	 sysPunchINService.add(punch); 
     	 return "redirect:/adm/zhuye";
      }
    
     
     	
}