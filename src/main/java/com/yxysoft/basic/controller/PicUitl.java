package com.yxysoft.basic.controller;

import com.yxysoft.base.Result;

import com.yxysoft.basic.service.BjmUtils;
import com.yxysoft.constant.CodeConst;
import com.yxysoft.constant.GlobalConst;
import com.yxysoft.utils.DateUtil;
import com.yxysoft.utils.QiniuUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class PicUitl {


    //七牛云工具类
    private QiniuUtil qiniuUtil =new QiniuUtil();

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(SysCardController.class);


    private List<String> saveUploadedFiles(List<MultipartFile> files,String fileType) {

        String filePath ="D:\\upload\\";
        File fil = new File(filePath);
        if (!fil.exists()) {
            fil.mkdirs();//不存在的话就创建一个路径
        }
        List<String> paths = new ArrayList<String>();
        //开始保存到本地
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                //跳过空数据
                continue;//跳过当前循环
            }
            try {
                byte[] bytes = file.getBytes();//字节流
                //保存
                String fileNname = file.getOriginalFilename();//获取文件名
               // String fileType= file.getOriginalFilename().split(".")[1];//获取文件类型
                Path path = Paths.get(filePath+fileNname+"."+fileType);//要保存在服务器的路径+文件名+文件格式
                Files.write(path, bytes);//把图片写入到本地路径中
                paths.add(filePath + file.getOriginalFilename()+"."+fileType);//放入路径集合，可能不知保存到一个服务器
            } catch (Exception e) {
                //异常
                e.printStackTrace();
            }

        }
        return paths;
    }


    public Result<?> pirtload(MultipartFile uploadf,String fileType) {
        //图片上传
        logger.debug("Single file upload!");//错误

        Map<String, Object> map = new HashMap<String, Object>();
        if (uploadf.isEmpty()) {
            //判断是否为空
            return new Result<>(CodeConst.UPLOAD_ERROR.getResultCode(), "请选择一个文件!");
        } else {

            try {
                List<String> paths = saveUploadedFiles(Arrays.asList(uploadf),fileType);
                //保存文件到七牛云
                //参数：保存在服务器的路径，保存在空间中的名字，如果为空会使用文件的hash值为文件名
                String path = qiniuUtil.uploadImg(new FileInputStream(new File(paths.get(0))), "addcard/" + DateUtil.getCurrentTimeSSSAsNumber() + ".jpg");
                //放入路径到map
                map.put("path", path);

            } catch (Exception e) {
                e.printStackTrace();
                //异常400
                return new Result<>(CodeConst.BAD_REQUEST.getResultCode(), CodeConst.BAD_REQUEST.getMessage(), "异常！！");
            }
            //返回map
            return new Result<>(map);


        }


    }


//    /**
//     * 迭代文件路径
//     * @param sId    主键sId
//     * @param index  索引:个人(01),公司(02)
//     * @return
//     */
//    public String getFilePath(Integer sId,String index){
//        StringBuilder sb=new StringBuilder();
//        QxzwBusList qxzwBusList=qxzwFile2Service.getQxzwBusListId(sId);
//        while(qxzwBusList!=null){
//            sb.insert(0, qxzwBusList.getsId()+"/");
//            qxzwBusList=qxzwFile2Service.getQxzwBusListId(qxzwBusList.getpSId());
//        }
//        if(index.equals("01")){
//            sb.append("p");
//        }else{
//            sb.append("c");
//        }
//        return sb.toString();
//    }


}
