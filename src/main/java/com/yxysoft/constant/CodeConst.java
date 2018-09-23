package com.yxysoft.constant;

import net.sf.jsqlparser.statement.delete.Delete;

/**
 * 返回代码
 * @author yangsy
 *
 */
public enum CodeConst {
    /**
     * success
     */
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUNT(404, "找不到"),
    FILE_SIZE_TOO_LAGER(989, "文件过大"),
    UPDATE_ERROR(889,"修改失败"),
    UPLOAD_ERROR(990, "上传失败"),
    DOLOAD_ERROR(888,"下载失败"),
    INSERT_ERROR(991, "新增失败"),
    REPEAT(992, "数据重复"),
    CodeOR(993, "系统错误"),
    ADMIN_USER_REPEAT(994, "后台用户名重复"),
    NULL_DATA(995, "没有数据"),
    TIME_PASSED(996, "时间己过期"),
    USER_NOT_FOUND(997, "找不到用户"),
    USER_REPEAT(998, "用户重复"),
    AUTH_FAILED(999, "登录信息有误"),
    REG_FILE_FRONT_FIRST(1001, " 请先上传身份证正面"),
    REG_FILE_BACK_FIRST(1002, " 请先上传身份证反面"),
    REG_VIDEO_FAIL(1101, "活体检测失败，请重新拍头像/录视频"),
    LOGIN_FACE_FAIL(1201, "人脸登录失败请重新登录"),
    FORMAL_ERROE(1202,"格式错误"),
    DELETE_ERROE(1203,"删除失败"),
    DELETE_REPEAT(1204,"删除重复"),
    USER_CODE_REPEAT(1205,"工号重复"),
    CARD_NO_REPEAT(1206,"身份证重复"),
    YZM_ERROR(1207,"验证码输入错误");



    private int resultCode;
    private String message;

    // 构造方法重载
    CodeConst(int resultCode) {
        this.resultCode = resultCode;
    }
    //构造方法重载
    CodeConst(String message) {
        this.message = message;
    }

    //构造方法
    CodeConst(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
