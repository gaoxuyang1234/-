package com.yxysoft.basic.model;

/**
 * Created by 朱翰林 on 2018/8/1.
 */

//import com.sun.deploy.net.URLEncoder;
import com.yxysoft.base.Result;
import com.yxysoft.basic.model.Config;
import com.yxysoft.utils.baidu.HttpUtil;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String to = "18851682468";

    public static void setTo(String to) {
        IndustrySMS.to = to;
    }

    private static String code = smsCode();


    public static String getCode() {
        return code;
    }

    //  登录验证码：{1}，如非本人操作，请忽略此短信。
    private static String smsContent = "【探羊科技】登录验证码："+code+"，如非本人操作，请忽略此短信。";

    /**
     * 验证码通知短信
     */
    public static String execute()
    {
        String tmpSmsContent = null;
        try{
   //         tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
                + HttpsUtil.createCommonParam();

        // 提交请求
        String result = HttpsUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        return result;
    }

    //创建验证码
    public static String smsCode(){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.println("验证码："+random);
        return random;
    }
}
