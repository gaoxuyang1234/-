package com.yxysoft.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Jesse
 * @date 2018/1/22
 */
@Api(tags={"调整测试页面接口"})
@Controller
public class IndexController {

    @ApiOperation("跳转到Index页面")
    @RequestMapping(value ="/indexPage",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @ApiOperation("跳转到文件上传页面")
    @RequestMapping(value ="/file",method = RequestMethod.GET)
    public String file(){
        return "file";
    }
}
