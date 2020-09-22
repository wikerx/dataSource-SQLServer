package com.scott.ds.common.exception;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :BaseException
 * @description : 自定义一错误编码
 * @data :2020/7/9 0009 下午 8:09
 * @status : 编写
 **/
public enum BaseErrorCode {

    REQ_PARAM_EMPT(10001,"请求数据为空"),
    REQ_PARAM_ERR(10002,"请求参数异常"),
    SYS_UNKNOWN_ERR(10003,"系统异常"),
    NOTFOUND_RESULT_ERR(10004,"未找到结果");


    private int code;



    BaseErrorCode(int code, String msg){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
