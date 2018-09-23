package com.yxysoft.roomservice.roomlist.common;

public class Config {

    /**
     * webrtc互通需要开通 实时音视频 服务 ，web exe互通 需要开通云通信服务
     * 有介绍appid 和 accType的获取方法。以及私钥文件的下载方法。
     */
    public class iLive {
        public final static long sdkAppID = 1400080804;


        public final static String accountType = "25508";

        /**
         * 派发userSig 和 privateMapKey 采用非对称加密算法RSA，用私钥生成签名。privateKey就是用于生成签名的私钥，私钥文件可以在实时音视频控制台获取
         * 配置privateKey
         * 将private_key文件的内容按下面的方式填写到 privateKey字段。
         */
        public final static String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
				"MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQg9XJ51X2BtMsaDqP+\n" +
				"0qijVVKDAtuJ4S7JWo9d8OQ+W+ShRANCAASwh8NnVgFiVYJnsAUyetDdRkl658Yy\n" +
				"TknrfGBmraolZNencCtH9vorj+Dg0beVVWS/z9Rn01mjbZ6ETdijydq5\n" +
				"-----END PRIVATE KEY-----";
    }


    /**
     * 房间相关参数
     */
    public class Room {
        // 房间容量上限
        public final static int maxMembers = 4;

        // 心跳超时 单位秒
        public final static int heartBeatTimeout = 20;
    }

}
