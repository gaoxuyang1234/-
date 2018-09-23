package com.yxysoft.base.weixin;

/**
 * Created by 朱翰林 on 2018/8/7.
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.yxysoft.base.Result;
import com.yxysoft.constant.CodeConst;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 生成二维码
 */
public class CreateQrCode {

    public void createerweima() {
        int width = 300;//二维码图片宽度
        int height = 300;//二维码图片高度
        String format = "png";//二维码图片格式
        String content = "http://192.168.101.74:8080/accept/wxlogin";//二维码内容
        //定义二维码的参数
        HashMap map = new HashMap();
        //设置编码
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置纠错等级
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        map.put(EncodeHintType.MARGIN, 2);

        try {
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.AZTEC.QR_CODE, width, height);
            Path file = new File("D:/rescode/微信打卡/attendance/src/main/resources/static/weixindaka/img/erweima.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
           // return new Result<>(CodeConst.SUCCESS.getResultCode());

        } catch (WriterException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
           // return new Result<>(CodeConst.BAD_REQUEST.getResultCode());
        }
    }
}

