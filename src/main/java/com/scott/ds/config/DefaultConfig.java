package com.scott.ds.config;

import java.math.BigDecimal;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :DefaultConfig
 * @description : 默认全局配置
 * @data :2020/7/9 0009 下午 8:24
 * @status : 编写
 **/
public class DefaultConfig {
//    系统支持的请求类型
    public final static String SUPPORT_REQUEST_TYPE = "PUT,POST,DELETE,GET";
    public final static String PUT = "PUT";
    public final static String POST = "POST";
    public final static String DELETE = "DELETE";
    public final static String GET = "GET";
    public final static String HTTPS = "https";


    public final static String IDENTIFIRT_COLON = ":";
//    交易成功的返回码
    public final static String RESPONSE_CODE_SUCCEED = "F0000";
//    交易成功的说明
    public final static String RESPONSE_EXPLAIN_SUCCEED = "Approved";
//    交易失败
    public final static String RESPONSE_EXPLAIN_ERROR = "ERROR";
    public final static String RESPONSE_INVALID_REQUEST = "INVALID_REQUEST";
    public final static String RESPONSE_EXPLAIN_FAILURE = "FAILURE";
    public final static String RESPONSE_EXPLAIN_SUCCESS = "SUCCESS";
    public final static String RESPONSE_EXPLAIN_PROCEED = "PROCEED";
    public final static String FLAG_SUCCEED = "succeed";

//    0
    public final static int IDENTIFIRT_ZERO = 0;
    public final static String IDENTIFIRT_ZERO_STRING = "0";
//    1
    public final static int IDENTIFIRT_ONE = 1;
    public final static int IDENTIFIRT_ONE_ = -1;
    public final static int IDENTIFIRT_TWO = 2;
    public final static int IDENTIFIRT_THREE = 3;
    public final static int IDENTIFIRT_FOURTH = 4;
    public final static String IDENTIFIRT_ONE_STRING = "1";
    public final static String IDENTIFIRT_SECOND_STRING = "2";
    public final static String IDENTIFIRT_YES = "Y";
    public final static String IDENTIFIRT_NO = "N";
    public final static String IDENTIFIRT_F = "F";
//    USD
    public final static String PAY_CURRENCY_USD = "USD";
    public final static String PAY_CURRENCY_CNY = "CNY";
    public final static BigDecimal BASE_AMOUNT_ZERO = new BigDecimal("0.0");
    public final static BigDecimal BASE_AMOUNT = new BigDecimal("1.0");

    /**
     * 连接池配置
     * */
    public final static int CORE_POOL_SIZE = 2;
    public final static int MAXIMUM_POOL_SIZE = 6;
    public final static int MAXKEEP_ALIVE_SIZE = 5;
    public final static int CAPACITY = 6;
    public final static int KEEP_ALIVE_TIME = 200;
    public final static Long KEEP_ALIVE_TIMEL = 60L;

    /**
     * 编码格式
     * */
    public final static String ENCODING_UTF8 = "UTF-8";
    public final static String CONTENY_TYPE_JSON = "application/json";

    public final static String INTERCEPTIPADDRESS = "interceptIpAddress";

    /**
     * 全局系统配置
     * */
    /**
     * 笔数路由
     * */
    public final static String STORKE_ROUTING = "STORKE_ROUTING";
    /**
     * 2/3方固定通道规则
     * */
    public final static String FIXED_CHANNEL = "FIXED_CHANNEL";
    /**
     * 金额路由
     * */
    public final static String AMOUNT_ROUTING = "AMOUNT_ROUTING";
    /**
     * 历史账单
     * */
    public final static String BILL_ADDRESS = "BILL_ADDRESS";

    /**
     * 卡种
     * */
    public final static String CARD_TUPE_MASTER = "master";
    public final static String CARD_TUPE_VISA = "visa";
    public final static String CARD_TUPE_AE = "ae";
    public final static String CARD_TUPE_JCB = "jcb";
    public final static String CARD_TUPE_DC = "dc";
    public final static String ACCEPT = "ACCEPT";
    public final static String REVIEW = "REVIEW";
    public final static String REJECT = "REJECT";
    public final static String TRUE = "true";
    public final static String SPLITE_ONE = "#";

    /**
     * ActiveMQ
     * 0:事物提交确认
     * 1:自动确认
     * 2:客户端手动确认
     * 3:批量自动确认
     * MANUAL_OK_ACKNOWLEDGE:消息处理异常重新尝试次数
     */
    public final static int SESSION_TRANSACTED = 0;
    public final static int AUTO_ACKNOWLEDGE = 1;
    public final static int CLIENT_ACKNOWLEDGE = 2;
    public final static int DUPS_OK_ACKNOWLEDGE = 3;
    public final static int MANUAL_OK_ACKNOWLEDGE = 4;
    public final static int ERROR_SEND_TIMES = 5;
    public final static String JMS_LISTENER_FACTORY = "jmsListenerFactory";
    public final static String JMS_NOTIFY_RESULT = "orderNotifyMsg";
//    异常订单队列
    public final static String JMS_EXCEPT_QUEUE = "ActiveMQ.DLQ";

    public final static int CONNECTION_TIME_OUT = 30000;
    public final static int READ_TIME_OUT = 30000;

    /**
     * 允许请求的交易地址
     * check/source:3D回调页面
     * */
    public final static String[] REQUEST_ALLOW_URL = {"/online/pay","/page/pay","/domain/pay",
            "/check/index","/checkinfo/index","/verify/source","/index","/domain"};
    public final static String STATIC_STRING = "static";


}
