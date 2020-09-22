package com.scott.ds.common.exception;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :BaseException
 * @description : 自定义异常
 * @data :2020/7/9 0009 下午 8:11
 * @status : 编写
 **/
public class BaseException extends RuntimeException{
    private int code;

//    构造器的第二个参数是上面创建的那个枚举，之后把枚举里面定义的code给了这个code
    public BaseException(String message, BaseErrorCode errorCode) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
